package com.alan.selfadil.aplikasipemesanangaselpiji.server;

public class BaseURL {

    public static String baseUrl = "http://192.168.43.136:5000/";

    public static String login = baseUrl + "user/login";
    public static String register = baseUrl + "user/registrasi";

    // gas
    public static String datagas = baseUrl + "gas/datagas";
    public static String editdatagas = baseUrl + "gas/ubah/";
    public static String hapusdatagas = baseUrl + "gas/hapus/";
    public static String inputgas = baseUrl + "gas/input/";
}
