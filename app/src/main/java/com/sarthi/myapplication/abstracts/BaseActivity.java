package com.sarthi.myapplication.abstracts;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.sarthi.myapplication.R;
import com.sarthi.myapplication.network.ApiClient;
import com.sarthi.myapplication.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.RequestBody;


public class BaseActivity extends AppCompatActivity {
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    public boolean checkNetwork() {
        boolean b = BaseApplication.getInstance().checkInternetConnection();
        return b || showNoNetworkMsg();
    }

    public boolean showNoNetworkMsg() {
        Utility.showMessage(this, getString(R.string.msg_no_internet));
        return false;
    }

    public void hitApi(WebCallInterface webCallInterface) {
        if (checkNetwork()) {
            webCallInterface.callApi();
        }
    }

    public ApiInterface getWebInterface() {
        return ApiClient.getInstance().getApiService();
    }


    public ApiInterface getWebAquaInterfacetemp() {
        return ApiClient.getInstance().getApiServicetemp();
    }


    public void displayError(String message) {
        Utility.showMessage(this, message);
    }

    /***
     * Preform actions on touching
     * @param ev MotionEvent
     * @return dispatchTouchEvent
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //hide keyboard
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE)
                && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int[] sourceCoordinates = new int[2];
            view.getLocationOnScreen(sourceCoordinates);
            float x = ev.getRawX() + view.getLeft() - sourceCoordinates[0];
            float y = ev.getRawY() + view.getTop() - sourceCoordinates[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) Objects.requireNonNull(this.getSystemService(Context.INPUT_METHOD_SERVICE))).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //Init FragmentManager
        FragmentHandler.getInstance().setFragmentManager(getSupportFragmentManager());
        super.onCreate(savedInstanceState);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean checkAndRequestPermissions() {
        int permissionSendMessage = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);

        int receiveSMS = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECEIVE_SMS);

        int readSMS = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_SMS);
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (receiveSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
        }
        if (readSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_SMS);
        }
        if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.SEND_SMS);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                        REQUEST_ID_MULTIPLE_PERMISSIONS);
            }
            return false;
        }
        return true;
    }

    // This method  converts String to RequestBody
    public RequestBody toRequestBody(String value) {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), value);
        return body;
    }

    protected Context getRootContext() {
        return this;
    }

    public void replaceFragment(@IdRes int containerViewId,
                                @NonNull Fragment fragment,
                                @NonNull String fragmentTag,
                                @Nullable String backStackStateName,
                                boolean shouldSave) {
        if (shouldSave) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(containerViewId, fragment, fragmentTag)
                    .addToBackStack(backStackStateName)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(containerViewId, fragment, fragmentTag)
                    .disallowAddToBackStack()
                    .commit();
        }
    }

    protected Fragment getCurrentFragment(@IdRes int framId) {
        return getSupportFragmentManager().findFragmentById(framId);
    }



}
