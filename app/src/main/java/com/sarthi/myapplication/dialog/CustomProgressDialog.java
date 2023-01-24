package com.sarthi.myapplication.dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;

import com.sarthi.myapplication.R;
import com.wang.avi.AVLoadingIndicatorView;


public class CustomProgressDialog {

    ProgressDialog mProgressDialog;
    Activity mActivity;

    public void createDialog(Activity activity) {
        try {
            mActivity = activity;
            mProgressDialog = new ProgressDialog(activity);
            mProgressDialog.setCancelable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog() {
        if (mProgressDialog == null)
            return;
        mProgressDialog.show();
        mProgressDialog.setContentView(R.layout.custom_dialog);
        AVLoadingIndicatorView image_loader = mProgressDialog.findViewById(R.id.avi);
        image_loader.show();
        mProgressDialog.getWindow().setLayout(mActivity.getWindow().getWindowManager().getDefaultDisplay().getWidth(), mActivity.getWindow().getWindowManager().getDefaultDisplay().getHeight());
        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void dismissDialog() {
        if (mProgressDialog == null)
            return;
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    public void setCancelable(boolean isCancelable) {
        mProgressDialog.setCancelable(isCancelable);
    }
}
