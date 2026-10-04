package com.samsung.android.support.senl.p148nt.model.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentServiceWrapperManager {
    private static final String TAG = ModelLogger.createTag("DocumentServiceWrapperManager");
    private final List<IDocumentServiceWrapper> mWrappers = new ArrayList();

    public boolean exist(@Nullable DocumentSubscriptionId documentSubscriptionId) {
        String str = TAG;
        DataLogger.m12307i(str, "exist, subscriptionId : " + documentSubscriptionId);
        if (documentSubscriptionId == null) {
            DataLogger.m12309w(str, "exist, false");
            return false;
        }
        for (IDocumentServiceWrapper iDocumentServiceWrapper : getWrappers()) {
            if (iDocumentServiceWrapper != null && documentSubscriptionId.equals(iDocumentServiceWrapper.getUser())) {
                DataLogger.m12309w(TAG, "exist, true - wrapper : " + iDocumentServiceWrapper);
                return true;
            }
        }
        DataLogger.m12309w(TAG, "exist, false");
        return false;
    }

    @NonNull
    public List<IDocumentServiceWrapper> getWrappers() {
        return this.mWrappers;
    }

    public boolean isEmpty() {
        return getWrappers().isEmpty();
    }

    public void subscribe(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper) {
        DataLogger.m12307i(TAG, "subscribe, wrapper : " + iDocumentServiceWrapper);
        if (getWrappers().contains(iDocumentServiceWrapper)) {
            return;
        }
        getWrappers().add(iDocumentServiceWrapper);
    }

    @NonNull
    public String toString() {
        return AbstractC0541b.m777s(new StringBuilder("{mWrappers : "), this.mWrappers, "}");
    }

    public void unsubscribe(@NonNull IDocumentServiceWrapper iDocumentServiceWrapper) {
        DataLogger.m12307i(TAG, "unsubscribe, wrapper : " + iDocumentServiceWrapper);
        getWrappers().remove(iDocumentServiceWrapper);
    }
}
