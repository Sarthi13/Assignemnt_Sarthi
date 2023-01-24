package com.sarthi.myapplication.abstracts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import com.sarthi.myapplication.database.PreferenceConnector;
import com.sarthi.myapplication.dialog.CustomProgressDialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utility {


    public static CustomProgressDialog mCustomProgressDialog = null;
    private static android.app.Fragment fragment;

    public static final String APP_STORE_LINK = "https://play.google.com/store/apps/details?id=com.eagledev.gamerhost";


    public static void showMessage(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public static void showDialog(Activity activity) {
        closeDialog();
        mCustomProgressDialog = new CustomProgressDialog();
        mCustomProgressDialog.createDialog(activity == null ? fragment.getActivity() : activity);
        mCustomProgressDialog.showDialog();
    }

    public static void closeDialog() {
        if (null != mCustomProgressDialog)
            mCustomProgressDialog.dismissDialog();
    }

    public static void clearConstant() {

        Constant.TRANSACTIONID = "";


    }


    public static void logoutUser(Context context) {


        PreferenceConnector.writeString(PreferenceConnector.PREF_USER_ID, "", context);



    }

    public static Bitmap rotateImage(String path, Uri uri, int degrees, Context context) {

        Bitmap b = null;
        InputStream inputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inTempStorage = new byte[16 * 1024];
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(new FileInputStream(path), null, options);
        } catch (FileNotFoundException ignored) {
        }
        int IMAGE_MAX_SIZE = 1000;
        int scale = 1;
        if (options.outHeight > IMAGE_MAX_SIZE || options.outWidth > IMAGE_MAX_SIZE) {
            scale = (int) Math.pow(2, (int) Math.round(Math.log(IMAGE_MAX_SIZE /
                    (double) Math.max(options.outHeight, options.outWidth)) / Math.log(0.5)));
        }
        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        o2.inPurgeable = true;
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        o2.outHeight = display.getHeight();
        o2.outWidth = display.getWidth();
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            b = BitmapFactory.decodeStream(inputStream, null, o2);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (degrees != 0 && b != null) {
            Matrix m = new Matrix();
            m.setRotate(degrees, (float) b.getWidth() / 2, (float) b.getHeight() / 2);
            try {
                Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, true);
                if (b != b2) {
                    b.recycle();
                    b = b2;
                }
            } catch (OutOfMemoryError ex) {
                //throw ex;
            }
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileOutputStream stream = new FileOutputStream(file.getPath());
                if (b != null) {
                    b.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    //b.recycle();
                }
                stream.flush();
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return b;
    }





    public static String parseDateToddMMyyyy(String time) {
        String inputPattern;

        inputPattern = "yyyy-MM-dd HH:mm:ss";

        String outputPattern = "dd-MMMM-yyyy hh:mm a";

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.ENGLISH);

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }



    public static String parseTime(String time) {
        String inputPattern;

        inputPattern = "HH:mm";

        String outputPattern = "hh:mm a";

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.ENGLISH);

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


    public static String parseOnlydate(String time) {
        String inputPattern;

        inputPattern = "yyyy-MM-dd";

        String outputPattern = "dd/MM/yyyy";

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.ENGLISH);

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static String parsedate(String time) {
        String inputPattern;

        inputPattern = "yyyy-MM-dd";

        String outputPattern = "dd MMMM yyyy";

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.ENGLISH);

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

