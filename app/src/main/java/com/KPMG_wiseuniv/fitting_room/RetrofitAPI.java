package com.KPMG_wiseuniv.fitting_room;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RetrofitAPI {
    @GET("send_imgdata/")
    Call<ArrayList<Imgdata>> get_imgdata();

    @Multipart
    @POST("train_img/")
    Call<Void> send_img(@Part MultipartBody.Part image);
}
