package com.reivai.mealrecipes.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.reivai.sweetalertdialog.SweetAlertDialog;

public class GlobalFunction {

    Context context;

    public GlobalFunction(Context context) {
        this.context = context;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void noInternetConnection(Context context, SweetAlertDialog alertDialog) {
        alertDialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        alertDialog.setTitleText("Tidak Ada Koneksi Internet")
                .setContentText("Silahkan periksa koneksi anda dan coba kembali")
                .setConfirmText("OK")
                .show();
    }
}
