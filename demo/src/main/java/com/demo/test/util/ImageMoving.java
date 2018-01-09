package com.demo.test.util;

import android.util.Log;

import com.demo.test.beans.ImagePiece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by DELL on 2017/12/25.
 */
public class ImageMoving {

    // 行
    private int row;
    // 列
    private int column;

    // 打乱后的集合
    private List<ImagePiece> pieces;

    // 打乱后的二位数组
    private ImagePiece[][] dim2Pieces;

    // 挑选出的一个图片
    private ImagePiece choosedPiece;

    // 步数
    private int steps;

    // 耗时 -毫秒
    private long costTime;

    public List<ImagePiece> getPieces() {
        return pieces;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public ImagePiece[][] getDim2Pieces() {
        return dim2Pieces;
    }

    public ImagePiece getChoosedPiece() {
        return choosedPiece;
    }

    public int getSteps() {
        return steps;
    }

    public long getCostTime() {
        return System.currentTimeMillis() - costTime;
    }


    public ImageMoving(){

    }

    /**
     * 处理切分好的图片
     * @param pieces 图片
     * @param column 一行有多少列
     */
    public void initData(List<ImagePiece> pieces,int column){
        this.column = column;
        this.row = pieces.size() / column;
        chooseLastPiece(pieces);
        shuffle(pieces);
        list2Array();
    }


    /**
     * 将切分好的图片中最后一块移除掉
     *
     * @param pieces
     */
    public void chooseLastPiece(List<ImagePiece> pieces){
        int lastIndex = pieces.size() - 1;
        chooseOnePiece(pieces,lastIndex);
    }

    /**
     * 将切分好的图片中的一块标记为空白块
     *
     * @param pieces
     */
    public void chooseOnePiece(List<ImagePiece> pieces, int index){
        choosedPiece = pieces.get(index);
        //choosedPiece = pieces.remove(index);
        choosedPiece.setRow(row - 1);
        choosedPiece.setColumn(column - 1);
        choosedPiece.setIndex(row * column - 1);
        choosedPiece.setChoosed(true);
        //Log.i("chooseOnePiece", choosedPiece.toString());
    }


    /**
     * 集合打乱
     * <a>https://baike.baidu.com/item/%E4%B8%8D%E5%8F%AF%E8%BF%98%E5%8E%9F%E7%9A%84%E6%8B%BC%E5%9B%BE/1446453</a>
     *
     * @param pieces
     */
    public void shuffle(List<ImagePiece> pieces){
        Collections.shuffle(pieces);
        this.pieces = pieces;
    }


    /**
     * 计算逆序数对
     */
    public boolean inverseNums(){
        int coverPairCount = 0;
        //int maxnumber = row*column - 1;
        for (int i = 0; i < pieces.size() - 1; i++) {
            int j = i + 1;
            if (pieces.get(i).getIndex() > pieces.get(j).getIndex())
            {
                coverPairCount++;
            }
        }

        System.out.println("coverPairCount:" + coverPairCount);

        return (coverPairCount&1) == 0;
    }

    /**
     * 打乱后的集合转为二维数组
     */
    public void list2Array(){
        // 二位数组重置
        this.dim2Pieces = new ImagePiece[row][column];
        this.steps = 0;
        this.costTime = 0;

        for (int i = 0; i < pieces.size(); i++) {
            int j = i / row;
            int k = i % column;
            ImagePiece piece = pieces.get(i);
            piece.setRow(j);
            piece.setColumn(k);
            this.dim2Pieces[j][k] = piece;
        }

        //pieces.add(choosedPiece);
        //dim2Pieces[row - 1][column - 1] = choosedPiece;

        boolean isOk = inverseNums();
        if(!isOk){
            //list2Array();
            int size = pieces.size();
            // 交换最后两个
            ImagePiece piece1 = pieces.get(size - 1);
            ImagePiece piece2 = pieces.get(size - 2);

            swapPiece(piece1,piece2);

        }
    }


    /**
     * 移动一个图片
     * @param piece
     * @return
     */
    public boolean moveImagePiece(ImagePiece piece){

        int row = piece.getRow();
        int column = piece.getColumn();

        int r = choosedPiece.getRow();
        int c = choosedPiece.getColumn();

        steps++;

        if(costTime == 0){
            costTime = System.currentTimeMillis();
        }

        // TODO 同行或者同列且相接
        if((row == r && Math.abs(column - c) == 1) || (column == c && Math.abs(row - r) == 1)){

            swapPiece(piece,choosedPiece);

            return checkSuccess();
        }


        return false;
    }


    /**
     * 交换两个图片位置
     * @param piece1
     * @param piece2
     */
    public void swapPiece(ImagePiece piece1, ImagePiece piece2){

        int row = piece1.getRow();
        int column = piece1.getColumn();

        int r = piece2.getRow();
        int c = piece2.getColumn();

        ImagePiece temp = new ImagePiece();
        //temp.copy(piece1);
        swapRowColunm(piece1,temp);

        //piece1.copy(piece2);
        swapRowColunm(piece2,piece1);

        this.dim2Pieces[r][c] = piece1;
        //piece2.copy(temp);

        swapRowColunm(temp,piece2);

        this.dim2Pieces[row][column] = piece2;

        int index1 = pieces.indexOf(piece1);
        int index2 = pieces.indexOf(piece2);

        pieces.remove(index1);
        pieces.add(index1,piece2);

        pieces.remove(index2);
        pieces.add(index2,piece1);

    }

    /**
     * 交换行和列
     * @param source
     * @param target
     */
    public void swapRowColunm(ImagePiece source, ImagePiece target){
        target.setRow(source.getRow());
        target.setColumn(source.getColumn());
    }


    public boolean checkSuccess(){
        for (int i = 0; i < pieces.size(); i++) {
            ImagePiece piece = pieces.get(i);
            if(piece.getIndex() != i){
                return false;
            }
        }
        return true;
    }

    public float checkProcess(){
        int complete = 0;
        for (int i = 0; i < pieces.size(); i++) {
            ImagePiece piece = pieces.get(i);
            if(piece.getIndex() == i){
                complete++;
            }
        }

        float process = (float) complete / (float) pieces.size();

        return process;
    }

    public void print(){
        for (ImagePiece piece : getPieces()) {
            Log.i("piece", piece.toString());
        }
    }


    public static void main(String[] args) {

        List<ImagePiece> pieces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ImagePiece piece = new ImagePiece();
            piece.setIndex(i);
            pieces.add(piece);
        }

        int column = 3;
        ImageMoving moving = new ImageMoving();

        moving.initData(pieces,column);


        if(true){
            return;
        }

        for (ImagePiece piece : moving.getPieces()) {
            System.out.println(piece.toString());
        }

        ImagePiece choosedPiece = moving.getChoosedPiece();
        int row = choosedPiece.getRow();
        int col = choosedPiece.getColumn();

        int ncol = col - 1;
        if(col == 0 || col == 2){
            ncol = 1;
        }

        ImagePiece[][] dim2Pieces = moving.getDim2Pieces();
        ImagePiece movPiece = dim2Pieces[row][ncol];

        System.out.println("----------");
        System.out.println(movPiece.toString());
        System.out.println("----------");

        moving.moveImagePiece(movPiece);

        for (ImagePiece piece : moving.getPieces()) {
            System.out.println(piece.toString());
        }


        System.out.println("----------");
        dim2Pieces = moving.getDim2Pieces();
        for (ImagePiece[] dim2Piece : dim2Pieces) {
            for (ImagePiece piece : dim2Piece) {
                System.out.println(piece.toString());
            }
        }

    }


    /**
     *
     */
    public interface ImageMovingListener {
        void movePiece(ImagePiece piece);
    }


}
