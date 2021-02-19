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
    @GET("send_imgdata/")
    Call<ArrayList<Imgdata>> get_imgdata();

    @Multipart
    @POST("train_img/")
    Call<Void> send_img(@Part MultipartBody.Part image,
                        @Part("Furniture") String Furniture,
                        @Part("FD") String FD);

    @GET("send_train_result/")
    Call<result> get_result();
}
