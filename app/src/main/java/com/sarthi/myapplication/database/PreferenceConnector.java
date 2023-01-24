package com.sarthi.myapplication.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.sarthi.myapplication.abstracts.BaseApplication;


/**
 * Created by sarthi on 24/01/19.
 */

public class PreferenceConnector {

    public static final String PREF_NAME = "Cricket_PREFERENCES";

    public static final int MODE = Context.MODE_PRIVATE;


    //App User
    public final static String PREF_USER_ID = "user_id";









    public static void writeBoolean(String key, boolean value, Context context) {
        getEditor(context).putBoolean(key, value).commit();
    }

    public static boolean readBoolean(String key, boolean defValue, Context context) {
        return getPreferences(context).getBoolean(key, defValue);
    }

    public static void writeInteger(String key, int value, Context context) {
        getEditor(context).putInt(key, value).commit();

    }

    public static int readInteger(String key, int defValue, Context context) {
        return getPreferences(context).getInt(key, defValue);
    }

    public static void writeString(String key, String value, Context context) {
        getEditor(context).putString(key, value).commit();

    }

    public static String readString(String key, String defValue, Context context) {
        return getPreferences(context).getString(key, defValue);
    }


    public static void writeFloat(String key, float value, Context context) {
        getEditor(context).putFloat(key, value).commit();
    }

    public static float readFloat(String key, float defValue, Context context) {
        return getPreferences(context).getFloat(key, defValue);
    }

    public static void writeLong(String key, long value, Context context) {
        getEditor(context).putLong(key, value).commit();
    }

    public static boolean keyExists(String key, Context context)
    {
        return getPreferences(context).contains(key);
    }

    public static long readLong(String key, long defValue, Context context) {
        return getPreferences(context).getLong(key, defValue);
    }

    public static SharedPreferences getPreferences(Context context) {
        if (null == context) {

           context= BaseApplication.getInstance();
        }
        return context.getSharedPreferences(PREF_NAME, MODE);
    }

    public static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

    public static void clearAll(Context context) {
        getEditor(context).clear();
        getEditor(context).commit();
    }


}
