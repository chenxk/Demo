
package com.demo.test.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import com.demo.test.R;
import com.demo.test.util.MyActivityManager;
import com.demo.test.utildata.ApplicationData;

import java.util.ArrayList;


/**
 * Description of LoadingDialog
 *
 * @author bob.bop
 * @version $Id:$
 * @created on 2015-8-12
 */
public class LoadingDialog {
    private static ArrayList<Dialog> dialogLits = new ArrayList<>();

    private LoadingDialog() {

    }

    public static void show(Context mContext) {
        if (dialogLits.size() > 0) {
            return;
        }
        OnKeyListener keyListener = (dialog, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_HOME || keyCode == KeyEvent.KEYCODE_SEARCH) {
                return true;
            } else if (keyCode == KeyEvent.KEYCODE_BACK) {
                Intent intent = new Intent();
                intent.setAction("CancelLoad");
                mContext.sendBroadcast(intent);
                if (ApplicationData.subscriptionMap.get(mContext) != null &&
                        !ApplicationData.subscriptionMap.get(mContext).isUnsubscribed()) {
                    ApplicationData.subscriptionMap.get(mContext).unsubscribe();
                }
                dialogLits.remove(dialog);
                if (MyActivityManager.getInstance().getActivityList().size() > 1) {
                    MyActivityManager.getInstance().getActivityList()
                            .get(MyActivityManager.getInstance().getActivityList().size() - 1).finish();
                }
            }
            return false;
        };
        Dialog mDialog = new AlertDialog.Builder(mContext).create();
        View view = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_loading_layout, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.dialog_img);
//        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
//        animationDrawable.start();
        mDialog.setOnKeyListener(keyListener);
        // mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        mDialog.show();
        mDialog.setContentView(view);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Window dialogWindow = mDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        dialogLits.add(mDialog);
    }

    public static void dismiss() {
        for (int i = 0; i < dialogLits.size(); i++) {
            if (dialogLits.get(i).isShowing()) {
                try {
                    dialogLits.get(i).dismiss();
                } catch (Exception e) {
                    Log.e("exception", "exception: " + Log.getStackTraceString(e));
                }
            }
        }
        dialogLits.clear();
    }
}
