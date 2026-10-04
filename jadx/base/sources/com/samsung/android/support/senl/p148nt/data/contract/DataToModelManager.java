package com.samsung.android.support.senl.p148nt.data.contract;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DataToModelManager {
    private static DataToModelManager sInstance;
    private RequestCollectContract mRequestCollectContract = null;

    public static void cancelCollect() {
        if (getInstance().getRequestCollectContract() == null) {
            return;
        }
        getInstance().getRequestCollectContract().cancelCollect();
    }

    public static synchronized DataToModelManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new DataToModelManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static int getSourceType(@SearchConstants.Source int i) {
        if (getInstance().getRequestCollectContract() == null) {
            return 1;
        }
        return getInstance().getRequestCollectContract().getSourceType(i);
    }

    public static void pausePdfCollect(@NonNull Class<?> cls, @NonNull String str) {
        if (getInstance().getRequestCollectContract() == null) {
            return;
        }
        getInstance().getRequestCollectContract().pausePdfCollect(cls, str);
    }

    public static void resumePdfCollect(@NonNull Class<?> cls, @NonNull String str) {
        if (getInstance().getRequestCollectContract() == null) {
            return;
        }
        getInstance().getRequestCollectContract().resumePdfCollect(cls, str);
    }

    public static void startCollect(String str, String str2, long j, List<String> list, int i, boolean z) {
        if (getInstance().getRequestCollectContract() == null) {
            return;
        }
        getInstance().getRequestCollectContract().startCollect(str, str2, j, list, i, z);
    }

    public RequestCollectContract getRequestCollectContract() {
        return this.mRequestCollectContract;
    }

    public void setRequestCollectContract(RequestCollectContract requestCollectContract) {
        this.mRequestCollectContract = requestCollectContract;
    }
}
