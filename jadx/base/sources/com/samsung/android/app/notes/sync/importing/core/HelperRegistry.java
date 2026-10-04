package com.samsung.android.app.notes.sync.importing.core;

import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.BasicImportHelperAdapter;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HelperRegistry {
    private static final String TAG = "HelperRegistry";
    HashMap<Class, BasicImportHelperAdapter> mImportHelperMap = new HashMap<>();

    public int getDownloadListSize() {
        Iterator<Map.Entry<Class, BasicImportHelperAdapter>> it = this.mImportHelperMap.entrySet().iterator();
        int downloadListSize = 0;
        while (it.hasNext()) {
            downloadListSize += it.next().getValue().getImportHelper().getDownloadListSize();
        }
        return downloadListSize;
    }

    public BasicImportHelperAdapter getImportHelperByClass(Class cls) {
        return this.mImportHelperMap.get(cls);
    }

    public ImportHelper getImportHelperByType(AbstractImportType abstractImportType) {
        return this.mImportHelperMap.get(abstractImportType.getClass()).getImportHelper();
    }

    public int getLocalDownloadListSize() {
        Iterator<Map.Entry<Class, BasicImportHelperAdapter>> it = this.mImportHelperMap.entrySet().iterator();
        int downloadListSize = 0;
        while (it.hasNext()) {
            ImportHelper importHelper = it.next().getValue().getImportHelper();
            DocTypeConstants docTypeConstants = importHelper.mType;
            if (docTypeConstants == DocTypeConstants.MEMO_LOCAL || docTypeConstants == DocTypeConstants.SNOTE_LOCAL) {
                downloadListSize = importHelper.getDownloadListSize() + downloadListSize;
            }
        }
        AbstractC0000a.m17n(downloadListSize, "getLocalDownloadListSize() ret : ", TAG);
        return downloadListSize;
    }

    public int getSuccessfulListSize() {
        Iterator<Map.Entry<Class, BasicImportHelperAdapter>> it = this.mImportHelperMap.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            ImportHelper importHelper = it.next().getValue().getImportHelper();
            if (importHelper.getState() != 1) {
                int successfulListSize = importHelper.getSuccessfulListSize() + i;
                Debugger.m8607d(TAG, importHelper.getClass().getSimpleName() + " " + importHelper.getSuccessfulListSize() + "/" + importHelper.getDownloadListSize());
                i = successfulListSize;
            }
        }
        return i;
    }

    public boolean isAllHelperStopped() {
        Iterator<Map.Entry<Class, BasicImportHelperAdapter>> it = this.mImportHelperMap.entrySet().iterator();
        boolean z = true;
        while (it.hasNext()) {
            ImportHelper importHelper = it.next().getValue().getImportHelper();
            if (importHelper.getState() != 1) {
                Debugger.m8607d(TAG, importHelper.getClass().getSimpleName() + " : " + importHelper.getState());
                z = false;
            }
        }
        return z;
    }

    public void putHelper(Class cls, BasicImportHelperAdapter basicImportHelperAdapter) {
        this.mImportHelperMap.put(cls, basicImportHelperAdapter);
    }

    public void requestRetry(Executor executor) {
        Iterator<Map.Entry<Class, BasicImportHelperAdapter>> it = this.mImportHelperMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().getImportHelper().requestRetry(executor);
        }
    }

    public void setSyncListener(ImportBaseTask.Listener listener) {
        Iterator<Map.Entry<Class, BasicImportHelperAdapter>> it = this.mImportHelperMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().getImportHelper().setImportListener(listener);
        }
    }

    public void stop() {
        Iterator<Map.Entry<Class, BasicImportHelperAdapter>> it = this.mImportHelperMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().getImportHelper().stop();
        }
    }
}
