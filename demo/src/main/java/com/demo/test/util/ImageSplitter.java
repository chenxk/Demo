package com.demo.test.util;

import android.graphics.Bitmap;
import android.util.Log;

import com.demo.test.beans.ImagePiece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/12/24.
 */

public class ImageSplitter {

    /**
     *
     * 对图片进行比例裁剪
     *
     * @param bitmap 源文件
     * @param viewWidth
     * @param viewHeight
     * @return
     */
    public static Bitmap cutBitmap(Bitmap bitmap, int viewWidth, int viewHeight){
        float scale = (float) viewWidth / (float) viewHeight;
        return cutBitmap(bitmap, scale);
    }


    /**
     *
     * 对图片进行比例裁剪
     *
     * @param bitmap 源文件
     * @param scale 宽高比
     * @return
     */
    public static Bitmap cutBitmap(Bitmap bitmap, float scale){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Log.i("ora Width",width + "");
        Log.i("ora Height",height + "");

        Log.i("view scale",scale + "");

        float imgScale = (float)width / (float)height;
        Log.i("img scale",imgScale + "");


        int newWidth = width;
        int newHeight = height;

        // 宽高比小于期望值,高度太长
        if(imgScale <= scale){
            newHeight = (int) (width / scale);
        }else{
            // 宽度太长
            newWidth = (int) (height * scale);
        }
        Log.i("newWidth",newWidth + "");
        Log.i("newHeight",newHeight + "");
        // 切割点
        int x = (width - newWidth) / 2;
        int y = (height - newHeight) / 2;

        Log.i("cut x",x + "");
        Log.i("cut y", y + "");

        Bitmap remp = Bitmap.createBitmap(bitmap, x, y, newWidth, newHeight);

        return remp;
    }


    /**
     * 图片分隔
     * @param bitmap 原图片
     * @param xPiece 宽度分隔几份
     * @param yPiece 高度分隔几份
     * @return
     */
    public static List<ImagePiece> split(Bitmap bitmap, int xPiece, int yPiece) {

        List<ImagePiece> pieces = new ArrayList<ImagePiece>(xPiece * yPiece);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int pieceWidth = width / xPiece;
        int pieceHeight = height / yPiece;
        /*for (int i = 0; i < yPiece; i++) {
            for (int j = 0; j < xPiece; j++) {
                ImagePiece piece = new ImagePiece();
                piece.setIndex(j + i * xPiece);
                int xValue = j * pieceWidth;
                int yValue = i * pieceHeight;
                piece.setBitmap(Bitmap.createBitmap(bitmap, xValue, yValue,
                        pieceWidth, pieceHeight));
                pieces.add(piece);
            }
        }*/

        int index = 0;
        for (int i = 0; i < yPiece; i++) {
            for (int j = 0; j < xPiece; j++) {
                int x = j * pieceWidth;
                int y = i * pieceHeight;

                Bitmap temp = Bitmap.createBitmap(bitmap, x, y, pieceWidth, pieceHeight);
                ImagePiece piece = new ImagePiece();
                piece.setBitmap(temp);
                piece.setIndex(index);

                pieces.add(piece);
                index++;
            }
        }

        return pieces;
    }

    public ImageSplitter() {
    }

    public static void main(String[] args) {

        System.out.println("");




        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");


        ImagePiece piece = new ImagePiece();
        Bitmap bitmap = piece.getBitmap();
        for (String s : list) {

        }

        for (String s : list) {

        }

        int index = piece.getIndex();



        for (String s : list) {
            System.out.println(s);
        }



    }


}
