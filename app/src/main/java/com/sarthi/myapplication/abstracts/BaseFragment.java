package com.sarthi.myapplication.abstracts;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.sarthi.myapplication.network.ApiClient;
import com.sarthi.myapplication.network.ApiInterface;


public class BaseFragment extends Fragment {
    private BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BaseActivity) getActivity();
    }

    public boolean checkNetwork() {
        return activity.checkNetwork();
    }

    private boolean showNoNetworkMsg() {
        return activity.showNoNetworkMsg();
    }

    public void hitApi(WebCallInterface webCallInterface) {
        activity.hitApi(webCallInterface);


    }

    public ApiInterface getWebInterface() {
        return activity.getWebInterface();
    }

    public ApiInterface getWebAquaInterfacetemp() {
        return ApiClient.getInstance().getApiServicetemp();
    }


    public void displayError(String message) {
        activity.displayError(message);
    }
}
