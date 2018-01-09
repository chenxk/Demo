package com.demo.test.beans;

import android.graphics.Bitmap;

import com.google.gson.Gson;

/**
 * Created by DELL on 2017/12/24.
 */

public class ImagePiece {
    private int index;
    private int row;
    private int column;
    private boolean choosed;

    private transient Bitmap bitmap;

    public boolean isChoosed() {
        return choosed;
    }

    public void setChoosed(boolean choosed) {
        this.choosed = choosed;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    @Override
    public int hashCode() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof ImagePiece)){
            return false;
        }

        ImagePiece piece = (ImagePiece) o;

        return index == piece.getIndex();
    }

    /**
     * 复制
     * @param source

    public void copy(ImagePiece source){
        //this.index = source.getIndex();
        this.row = source.getRow();
        this.column = source.getColumn();
        //this.bitmap = source.getBitmap();
        //this.choosed = source.isChoosed();
    }*/

    /**
     * 复制
     * @param source
     * @return
     */
    public static ImagePiece clone(ImagePiece source){
        ImagePiece piece = new ImagePiece();
        piece.setColumn(source.getColumn());
        piece.setRow(source.getRow());
        piece.setIndex(source.getIndex());
        piece.setChoosed(source.isChoosed());
        piece.setBitmap(source.getBitmap());
        return piece;
    }

    @Override
    public String toString() {
        Gson json = new Gson();
        //json.
        return json.toJson(this).toString();
    }
}
