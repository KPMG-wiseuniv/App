package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Picture_train_Fragment extends Fragment {
    PictureActivity pictureActivity;
    ManageFurniture alltrain;
    Furniture nowdata;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        pictureActivity=(PictureActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        pictureActivity=null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.picture_train, container, false);

        alltrain=ManageFurniture.getInstance();
        nowdata=alltrain.getFurniture();

        uploadImage();

        return v;
    }
    public void uploadImage(){
        RetrofitAPI myAPI=RetrofitClient.getApiService();
        String imagepath=getPath(pictureActivity.selected);
        File file=new File(imagepath);
        RequestBody requestFile=RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body=MultipartBody.Part.createFormData("image", "train.jpg", requestFile);
        ArrayList<Furniture> now_total=ManageFurniture.getInstance().getTotal_furniture();
        Furniture now_furniture=now_total.get(now_total.size()-1);
        Train_param param=new Train_param(now_furniture.getTh_cat(), now_furniture.getFunction());
        Call<Void> send=myAPI.send_img(body, param.getFurniture(), param.getFD());
        send.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    System.out.println("image send success");
                    Call<result> result=myAPI.get_result();
                    result.enqueue(new Callback<com.KPMG_wiseuniv.fitting_room.result>() {
                        @Override
                        public void onResponse(Call<com.KPMG_wiseuniv.fitting_room.result> call, Response<com.KPMG_wiseuniv.fitting_room.result> response) {
                            if(response.isSuccessful()){
                                result res=response.body();
                                Intent intent=new Intent(pictureActivity, ResultActivity.class);
                                intent.putExtra("AIinterior", res.getInterior());
                                intent.putExtra("AIcolor", res.getColor());
                                intent.putExtra("AIFD", res.getFD());
                                intent.putExtra("nowchoice", now_total.size()-1);
                                pictureActivity.finish();
                                startActivity(intent);
                            }
                            else{
                                System.out.println("get result fail");
                            }
                        }

                        @Override
                        public void onFailure(Call<com.KPMG_wiseuniv.fitting_room.result> call, Throwable t) {
                            System.out.println("server communication fail");
                        }
                    });
                }
                else{
                    Toast.makeText(pictureActivity, "send and get image fail", Toast.LENGTH_SHORT).show();
                    System.out.println("image send error");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pictureActivity, "server communication fail", Toast.LENGTH_SHORT).show();
                System.out.println("server communication error");
            }
        });
    }
    // uri 절대경로 가져오기
    public String getPath(Uri uri){

        String filePath;
        Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            filePath = uri.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            filePath = cursor.getString(idx); cursor.close();
        }
        return filePath;
    }
}
