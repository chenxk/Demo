package com.demo.test.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.test.R;
import com.demo.test.beans.ImagePiece;
import com.demo.test.util.ImageMoving;

import java.util.List;

/**
 * @author Administrator
 * @date 2017/12/20
 */

public class SwitchColumnAdapter extends RecyclerView.Adapter<SwitchColumnAdapter.GridViewHolder> {
    private Context mContext;
    private List<ImagePiece> bitmaps;
    private LayoutInflater inflater;
    private int height, width, row , column;
    private ImageMoving.ImageMovingListener listener;

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ImageMoving.ImageMovingListener getListener() {
        return listener;
    }

    public void setListener(ImageMoving.ImageMovingListener listener) {
        this.listener = listener;
    }

    public List<ImagePiece> getBitmaps() {
        return bitmaps;
    }

    public void setBitmaps(List<ImagePiece> bitmaps) {
        this.bitmaps = bitmaps;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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


    public SwitchColumnAdapter(Context contexts, List<ImagePiece> bitmaps,int height,int width,int row ,int column) {
        inflater = LayoutInflater.from(contexts);
        this.mContext = contexts;
        this.bitmaps = bitmaps;
        this.height = height;
        this.width = width;
        this.row = row;
        this.column = column;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_count_switch, parent, false);

        return new GridViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        /*Glide.with(mContext).load(urls.get(position))
                .asBitmap().placeholder(R.drawable.ico_null)
                .error(R.drawable.ico_null)
                .into(holder.ivPic);*/

        holder.ivPic.setImageBitmap(null);
        ImagePiece piece = bitmaps.get(position);

        if(!piece.isChoosed() || isSuccess()){
            holder.ivPic.setImageBitmap(piece.getBitmap());
        }

        holder.tvText.setText("我是图片" + (position + 1));

        setMeasureSize(holder.cardView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/12/26 已成功或者空白区域不能点击
                if(isSuccess() || piece.isChoosed()){
                    return;
                }
                listener.movePiece(piece);
            }
        });
    }



    private void setMeasureSize(View view){
        if(this.height == 0){
            view.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            view.requestLayout();
            view.invalidate();
            return;
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = this.height / row;
        view.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return bitmaps.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPic;
        private TextView tvText;
        private CardView cardView;

        private GridViewHolder(View itemView) {
            super(itemView);
            ivPic = (ImageView) itemView.findViewById(R.id.ivPic);
            tvText = (TextView) itemView.findViewById(R.id.tvText);
            cardView = (CardView)itemView.findViewById(R.id.imageItemView);
        }

    }
}
