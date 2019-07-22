package com.mgosu.walpaperprojects.ultil;



import com.mgosu.walpaperprojects.model.wallpaper.Wallpaper;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DataClient {


   // type:list_item
    //cat_type:video↵↵1
    //page:1
    //limit:20
@FormUrlEncoded
@POST("dev/wallpaper.php")
Call<Wallpaper> getWallpaper(@Field("type") String type,
                             @Field("cat_type") String cat_type,
                             @Field("page") String page,
                             @Field("limit") String limit);

}
