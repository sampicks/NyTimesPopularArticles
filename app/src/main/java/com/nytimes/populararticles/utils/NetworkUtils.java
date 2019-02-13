package com.nytimes.populararticles.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/**
 * The type Network utils.
 */
public class NetworkUtils {
    /**
     * private constructor
     */
    private NetworkUtils() {
    }

    /**
     * Is internet available boolean.
     *
     * @param context the context
     * @return the boolean
     */
    public static boolean isInternetAvailable(Context context) {
        final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm != null) {
            if (Build.VERSION.SDK_INT < 23) {
                final NetworkInfo networkInfo = cm.getActiveNetworkInfo();

                if (networkInfo != null) {
                    return (networkInfo.isConnected() && (networkInfo.getType() == ConnectivityManager.TYPE_WIFI || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE));
                }
            } else {
                final Network activeNetwork = cm.getActiveNetwork();

                if (activeNetwork != null) {
                    final NetworkCapabilities networkCapabilities = cm.getNetworkCapabilities(activeNetwork);

                    return (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI));
                }
            }
        }

        return false;
    }
}
