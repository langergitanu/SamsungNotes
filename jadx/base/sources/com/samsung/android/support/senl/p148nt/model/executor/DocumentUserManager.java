package com.samsung.android.support.senl.p148nt.model.executor;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentUserManager {
    private static final String TAG = ModelLogger.createTag("DocumentUserManager");
    private final Map<String, ArrayList<DocumentSubscriptionId>> mUserMap = new ConcurrentHashMap();

    public void disuse(@NonNull String str, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12309w(TAG, "disuse, uuid : " + str + ", user : " + documentSubscriptionId);
        synchronized (this.mUserMap) {
            try {
                ArrayList<DocumentSubscriptionId> arrayList = this.mUserMap.get(str);
                if (arrayList != null) {
                    arrayList.remove(documentSubscriptionId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getUsingCount(@NonNull String str) {
        ArrayList<DocumentSubscriptionId> arrayList = this.mUserMap.get(str);
        int size = arrayList != null ? arrayList.size() : 0;
        String str2 = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("getUsingCount, uuid : ", size, str, ", count: ", ", users: ");
        sbM780v.append(arrayList);
        DataLogger.m12302d(str2, sbM780v.toString());
        return size;
    }

    public boolean isSkipped(@NonNull DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12309w(TAG, "isSkipped, user : " + documentSubscriptionId);
        for (DocumentSubscriptionId documentSubscriptionId2 : DocumentSubscriptionId.SKIPPED_USERS) {
            if (documentSubscriptionId2.getUser().equals(documentSubscriptionId.getUser())) {
                DataLogger.m12309w(TAG, "isSkipped, user : " + documentSubscriptionId + ", skip user : " + documentSubscriptionId2.getUser());
                return true;
            }
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "DocumentUserManager{userMap=" + this.mUserMap + '}';
    }

    public void use(@NonNull String str, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        String str2 = TAG;
        DataLogger.m12309w(str2, "use, uuid : " + str + ", user : " + documentSubscriptionId);
        synchronized (this.mUserMap) {
            try {
                if (!this.mUserMap.containsKey(str)) {
                    this.mUserMap.put(str, new ArrayList<>());
                }
                ArrayList<DocumentSubscriptionId> arrayList = this.mUserMap.get(str);
                if (arrayList == null) {
                    return;
                }
                if (!arrayList.contains(documentSubscriptionId)) {
                    arrayList.add(documentSubscriptionId);
                    return;
                }
                DataLogger.m12309w(str2, "use, already contained - uuid : " + str + ", user : " + documentSubscriptionId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
