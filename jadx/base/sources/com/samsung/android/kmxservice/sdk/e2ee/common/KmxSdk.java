package com.samsung.android.kmxservice.sdk.e2ee.common;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.samsung.android.kmxservice.sdk.e2ee.FabricIdSupplier;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxSdk {
    private static final String TAG = LogTag.getTag("KmxSdk");
    private final Context context;
    private final FabricIdSupplier fabricIdSupplier;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KmxSdkHolder {
        private static KmxSdk INSTANCE;

        private KmxSdkHolder() {
        }
    }

    private KmxSdk(Context context, @NonNull FabricIdSupplier fabricIdSupplier) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            this.context = context;
        } else {
            this.context = applicationContext;
        }
        this.fabricIdSupplier = fabricIdSupplier;
    }

    public static void checkIfInitialized() {
        if (KmxSdkHolder.INSTANCE == null || KmxSdkHolder.INSTANCE.context == null || KmxSdkHolder.INSTANCE.fabricIdSupplier == null) {
            throw new KmxException("KmxSdk is not initialized. should call KmxSdk.initialize() first.", 1);
        }
    }

    public static Context getContext() {
        return KmxSdkHolder.INSTANCE.context;
    }

    public static String getGuid() {
        return KmxSdkHolder.INSTANCE.fabricIdSupplier.getGUID();
    }

    public static void initialize(Context context, @NonNull FabricIdSupplier fabricIdSupplier) {
        if (context == null) {
            Log.e(TAG, "[Initialize] your context is null");
        } else {
            KmxSdkHolder.INSTANCE = new KmxSdk(context, fabricIdSupplier);
        }
    }
}
