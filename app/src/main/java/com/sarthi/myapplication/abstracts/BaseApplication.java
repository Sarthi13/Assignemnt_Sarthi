package com.sarthi.myapplication.abstracts;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;




public class BaseApplication extends Application {

    private static BaseApplication mInstance;



    //sarthi

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

      //AudienceNetworkAds.initialize(this);



    }

    public static BaseApplication getInstance() {
        return mInstance;
    }
    public  boolean checkInternetConnection() {
        ConnectivityManager con_manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        return con_manager.getActiveNetworkInfo() != null
                && con_manager.getActiveNetworkInfo().isAvailable()
                && con_manager.getActiveNetworkInfo().isConnected();
    }
}
