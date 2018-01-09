package com.demo.test.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.test.R;
import com.demo.test.adapter.SwitchColumnAdapter;
import com.demo.test.beans.ImagePiece;
import com.demo.test.util.ImageMoving;
import com.demo.test.util.ImageSplitter;
import com.demo.test.util.SystemTool;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页
 *
 * @author Administrator
 */
public class HomeActivity extends BaseActivity implements ImageMoving.ImageMovingListener {
    @BindView(R.id.rvCountSwitch)
    RecyclerView rvCountSwitch;
    @BindView(R.id.edtRow)
    EditText edtRow;
    @BindView(R.id.edtColumn)
    EditText edtColumn;


    private long exitTime = 0;
    private int row = 3, column = 3;

    private int width,height;

    /**
     * 分切图片的缩略图
     */
    private Bitmap thumbnail;

    private SwitchColumnAdapter adapter;

    private ImageMoving moving = new ImageMoving();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setTopTitle(R.string.app_name);
        calHeight();
        initImageMoveView();
        someDirs();
    }

    /**
     *
     */
    private void someDirs( ){
        // 获得缓存文件路径，磁盘空间不足或清除缓存时数据会被删掉，一般存放一些临时文件
        // /data/data/<application package>/cache目录
        File cacheDir = getCacheDir();
        Log.d("TAG", "getCacheDir() : " + cacheDir.getAbsolutePath());

        // 获得文件存放路径，一般存放一些需要长期保留的文件
        // /data/data/<application package>/files目录
        File fileDir = getFilesDir();
        Log.d("TAG", "getFilesDir() : " + fileDir.getAbsolutePath());

        // 这是一个可以存放你自己应用程序自定义的文件，你可以通过该方法返回的File实例来创建或者访问这个目录
        // /data/data/<application package>/
        File dir = getDir("fileName", MODE_PRIVATE);
        Log.d("TAG", "getDir() : " + dir.getAbsolutePath());

        // 获取应用程序外部存储的缓存目录路径
        // SDCard/Android/data/<application package>/cache目录
        File externalCacheDir = getExternalCacheDir();
        Log.d("TAG", "getExternalCacheDir() : " + externalCacheDir.getAbsolutePath());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity:","onStart");;
    }


    /**
     *
     * 根据View大小和行列进行图片切分
     *
     * @param row
     * @param column
     * @return
     */
    private  List<ImagePiece> splitImages(int row, int column){
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.dog);

        float scale = (float) width / (float) height;

        thumbnail = ImageSplitter.cutBitmap(bitmap,scale);

        List<ImagePiece> pieces = ImageSplitter.split(thumbnail, column, row);

        moving.initData(pieces,column);

        return pieces;
    }

    /**
     * 计算图片移动区域大小
     */
    private void calHeight(){
        width =  SystemTool.getScreenWidth(this);
        height = SystemTool.getScreenHeight(this);

        int statusHeight = SystemTool.getStatusHeight(this);

        /*Log.i("rvCountSwitch width",width + "");
        Log.i("rvCountSwitch height",height+ "");
        Log.i("statusHeight height",statusHeight+ "");
*/

        int navigationHeightId = R.dimen.navigationHeight;
        float dimension = this.getResources().getDimension(navigationHeightId);
        //Log.i("navigationHeight",dimension+ "");

        int operationBarHeightId = R.dimen.operationBarHeight;
        float dimension2 = this.getResources().getDimension(operationBarHeightId);
        //Log.i("operationBarHeight",dimension2+ "");

        int pxVal = (int) (dimension + dimension2);// SystemTool.dp2px(this,100);
        //Log.i("pxVal ",pxVal+ "");

        height -= (statusHeight + pxVal);//rvCountSwitch.getMeasuredHeight();
        Log.i("view height ",height+ "");
        /*List<String> urls = new ArrayList<>();
        for (int i = 0; i < row * column; i++) {
            urls.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3671150995,1957149913&fm=27&gp=0.jpg");
        }*/

        //float scale = (float) width / (float) height;
    }


    /**
     * 游戏面板初始化
     */
    private void initImageMoveView() {

        List<ImagePiece> imagePieces = splitImages(row, column);

        GridLayoutManager manager = new GridLayoutManager(this, column);
        rvCountSwitch.setLayoutManager(manager);
        rvCountSwitch.setHasFixedSize(true);


        if(adapter == null){
            adapter = new SwitchColumnAdapter(this, imagePieces,height,width,row,column);
            adapter.setListener(this);
            rvCountSwitch.setAdapter(adapter);
        }else{
            adapter.setBitmaps(imagePieces);
            adapter.setRow(row);
            adapter.setColumn(column);
            //rvCountSwitch.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }


    }



    @OnClick({R.id.ivMore, R.id.btnOk})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivMore:
                Intent intent = new Intent(this, ExhibitionDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.btnOk:
                String rowStr = edtRow.getText().toString().trim();
                String columnStr = edtColumn.getText().toString().trim();
                if (rowStr.length() * columnStr.length() == 0)
                    return;
                row = Integer.parseInt(rowStr);
                column = Integer.parseInt(columnStr);
                if (row * column == 0)
                    return;
                initImageMoveView();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 3000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void movePiece(ImagePiece piece) {
        boolean result = moving.moveImagePiece(piece);
        adapter.setSuccess(result);
        if(result){
            Log.i("Success","");
            Log.i("steps",moving.getSteps() + " steps");
            Log.i("cost time",moving.getCostTime()/1000 + " seconds.");
        }
        adapter.notifyDataSetChanged();
    }
}
