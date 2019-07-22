package com.mgosu.walpaperprojects.ultil;

public class APIUltil {
    public static final String baseUrl = "http://192.168.200.216/";

    public static DataClient getData(){
        return RetrofitClient.getRetrofit(baseUrl).create(DataClient.class);
    }
}
