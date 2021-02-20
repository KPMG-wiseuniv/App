package com.KPMG_wiseuniv.fitting_room;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitAPI {
    //API for getting furniture data from server
    @GET("send_imgdata/")
    Call<ArrayList<Imgdata>> get_imgdata();

    //API for sending image to server
    @Multipart
    @POST("train_img/")
    Call<Void> send_img(@Part MultipartBody.Part image,
                        @Part("imgname") String imgname,
                        @Part("Furniture") String Furniture,
                        @Part("FD") String FD);

    //API for getting AI training result from server
    @GET("send_train_result/")
    Call<result> get_result();
}
