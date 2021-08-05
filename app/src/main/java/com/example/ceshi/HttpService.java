package com.example.ceshi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface HttpService {

    @POST("网页前端.json")
    @FormUrlEncoded
    //Call<ResponseBody> post(@Field("neirong")String s);
    //ResponseBody java的ben对象
    Call<Test[]> post(@Field("neirong")String s);
}
