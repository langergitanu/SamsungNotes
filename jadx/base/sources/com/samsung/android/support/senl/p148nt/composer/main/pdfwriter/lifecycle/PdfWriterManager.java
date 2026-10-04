package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PdfFileInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PdfWriterManager {
    private static final String TAG = Logger.createTag("PdfWriterManager");
    private static PdfWriterManager sInstance;
    private static Map<IPwInfo, String> sPwInfoMap;

    private PdfWriterManager() {
        initPwInfoMap();
    }

    public static synchronized PdfWriterManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new PdfWriterManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private String getPathFrom(PdfFileInfo pdfFileInfo) {
        return pdfFileInfo.isSaveAs() ? pdfFileInfo.getName() : pdfFileInfo.getPath();
    }

    private static synchronized void initPwInfoMap() {
        sPwInfoMap = new HashMap();
    }

    public synchronized boolean moveExistPwToFront(Context context, PdfFileInfo pdfFileInfo) {
        Set<Map.Entry<IPwInfo, String>> setEntrySet = sPwInfoMap.entrySet();
        if (setEntrySet == null) {
            return false;
        }
        String pathFrom = getPathFrom(pdfFileInfo);
        if (pathFrom.isEmpty()) {
            return false;
        }
        for (Map.Entry<IPwInfo, String> entry : setEntrySet) {
            if (entry.getValue().equals(pathFrom)) {
                Logger.m10999d(TAG, "moveExistPwToFront#");
                return AppTaskCompat.getInstance().moveToFront(context, entry.getKey().getTaskId());
            }
        }
        return false;
    }

    public void register(@NonNull IPwInfo iPwInfo, @NonNull PdfFileInfo pdfFileInfo) {
        register(iPwInfo, pdfFileInfo.isSaveAs() ? pdfFileInfo.getName() : pdfFileInfo.getPath());
    }

    public synchronized void unregister(@NonNull IPwInfo iPwInfo) {
        Logger.m10999d(TAG, "unregister# " + iPwInfo);
        sPwInfoMap.remove(iPwInfo);
    }

    public synchronized void register(@NonNull IPwInfo iPwInfo, @NonNull String str) {
        Logger.m10999d(TAG, "register# " + iPwInfo.hashCode() + " " + Logger.getEncode(str));
        if (str.isEmpty()) {
            return;
        }
        sPwInfoMap.put(iPwInfo, str);
    }
}
