package com.bloczzgcold.core.base.data.response.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.bloczzgcold.core.base.utils.NetworkUtils;

import java.util.Objects;

public class NetworkStateReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (!NetworkUtils.isConnected()) {
                Toast.makeText(context, "网络不给力呀", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
