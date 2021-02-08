package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class Picture_choose_Fragment extends Fragment {
    PictureActivity pictureActivity;

    private static final int GALLERY_CODE=1001;//for gallery
    private static final int CAMERA_CODE=1002;//for camera
    ImageView background, explain_img;
    TextView picture_ment, explain_text;
    Button gallery, camera;
    Uri selected_img;
    Bitmap selected_bitmap;
    int want_height=256, want_width=256;//for room picture resizing size

    int which=0;
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
        View v=inflater.inflate(R.layout.picture_choose, container, false);

        setting_view(v);
        setting_change();
        setting_gallery_btn();
        setting_camera_btn();

        return v;
    }

    public void setting_view(View v){//for inflation and basic setting
        background=v.findViewById(R.id.background);
        picture_ment=v.findViewById(R.id.picture_ment);
        gallery=v.findViewById(R.id.gallery_btn);
        camera=v.findViewById(R.id.camera_btn);
        explain_img=v.findViewById(R.id.explain_img);
        explain_text=v.findViewById(R.id.explain_text);
    }

    public void setting_change(){//if which==0, activate upload function
        if(which==0){            //else if which==1, finish upload picture
            gallery.setText("Gallery");
            camera.setText("Camera");
            picture_ment.setText("Alright!\n\nPlease upload the photo of room\nplanning to decorate");
            picture_ment.setShadowLayer(0, 0, 0, 0);
            explain_text.setText("Photo must include the space the\nfurniture will be placed and props\nsurrounding.\nRefer to the example below for\ndistance and composition");
            Glide.with(pictureActivity).load((Bitmap) null).into(background);
            Glide.with(pictureActivity).load(R.drawable.main_background).into(background);
            Glide.with(pictureActivity).load(R.drawable.explain_picture).into(explain_img);
        }
        else if(which==1){
            gallery.setText("OK!");
            camera.setText("Upload again!");
            picture_ment.setText("Your photo is uploaded.\nShall we move on to the next step?");
            picture_ment.setShadowLayer(10, 10, 10, Color.parseColor("#000000"));
            explain_text.setText("");
            Glide.with(pictureActivity).load((Bitmap)null).into(background);
            Glide.with(pictureActivity).load(selected_img).into(background);
            Glide.with(pictureActivity).load((Bitmap)null).into(explain_img);
        }
    }

    public void setting_gallery_btn(){//for getting picture from gallery
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(which==0){
                    Intent galleryintent=new Intent(Intent.ACTION_PICK);
                    galleryintent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(galleryintent, GALLERY_CODE);
                }
                else if(which==1){
                    pictureActivity.training_image();
                }
            }
        });
    }

    public void setting_camera_btn(){//for activate camera function
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(which==0){
                    if(pictureActivity.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
                        Intent cameraintent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraintent, CAMERA_CODE);
                    }
                    else{
                        Toast.makeText(pictureActivity, "No camera on this device", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else if(which==1){
                    which=0;
                    setting_change();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==pictureActivity.RESULT_OK){
            if(requestCode==GALLERY_CODE){//for gallery
                if(data.getData()!=null){
                    selected_img=data.getData();
                    try {
                        selected_bitmap= MediaStore.Images.Media.getBitmap(pictureActivity.getContentResolver(), selected_img);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    which=1;
                    setting_change();
                }
            }
            else if(requestCode==CAMERA_CODE){//for camera
                if(data.getData()!=null){
                    selected_img=data.getData();
                    try {
                        selected_bitmap= MediaStore.Images.Media.getBitmap(pictureActivity.getContentResolver(), selected_img);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    which=1;
                    setting_change();
                }
            }
        }
    }

    public void resize(){//for resizing uploaded picture
        selected_bitmap=Bitmap.createScaledBitmap(selected_bitmap, want_width, want_height, true);

    }
}
