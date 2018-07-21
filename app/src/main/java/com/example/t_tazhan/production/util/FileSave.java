package com.example.t_tazhan.production.util;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

public class FileSave {

    private static final String ROOM_POSITION = "/ROOM_POSITION";
    public static void saveFile(String str,String X,String Y) {
        String filePath;
        boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (hasSDCard) {
            filePath = Environment.getExternalStorageDirectory().toString()
                    + ROOM_POSITION
                    + File.separator
                    + "信标位置"
                    + X
                    + ","
                    + Y
                    + "_test.txt";
        } else  // 系统下载缓存根目录的hello.text
            filePath = Environment.getDownloadCacheDirectory().toString()
                    + ROOM_POSITION
                    + File.separator
                    + "信标位置"
                    + X
                    + ","
                    + Y
                    + "_test.txt";

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(file);
            outStream.write(str.getBytes());
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}