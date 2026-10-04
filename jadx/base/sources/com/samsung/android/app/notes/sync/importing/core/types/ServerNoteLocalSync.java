package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import android.os.SystemClock;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;
import p042J1.AbstractC0155m;
import p195k1.C12969a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ServerNoteLocalSync extends ImportBaseTask {
    private static final String TAG = "ServerNoteLocalSync";

    public ServerNoteLocalSync(Context context, ImportBaseTask.Listener listener, int i) {
        super(context, listener, DocTypeConstants.SDOCX_SCLOUD, i);
    }

    public void convertingImportItem(ImportItem importItem) {
        importItem.getLocalFullPath();
        new C12969a(this.mContext, importItem.getServerKey()).m13878g(null);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public List<ImportItem> getDownloadList() {
        return super.getDownloadList();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public List<ImportItem> getFailedList() {
        return super.getFailedList();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() {
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public List<ImportItem> getResultData() {
        return super.getResultData();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public List<ImportItem> getSuccessfulList() {
        return super.getSuccessfulList();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void setDownloadList(List<ImportItem> list) {
        super.setDownloadList(list);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() throws SyncException {
        Debugger.m8607d(TAG, "startImport()");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this) {
            try {
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onDownloaded(DocTypeConstants.SDOCX_SCLOUD, null, 1);
                }
            } finally {
            }
        }
        this.mSuccessfulList = new ArrayList();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        int size = this.mImportList.size();
        for (int i = 0; i < size && !isCancelled(); i++) {
            if (!AbstractC0155m.m401p()) {
                throw new SyncException(323, "device storage is full!");
            }
            ImportItem importItem = this.mImportList.get(i);
            synchronized (this) {
                try {
                    ImportBaseTask.Listener listener2 = this.mListener;
                    if (listener2 != null) {
                        listener2.onDownloaded(DocTypeConstants.SDOCX_SCLOUD, importItem, 1);
                    }
                } finally {
                }
            }
            try {
                convertingImportItem(importItem);
                this.mSuccessfulList.add(importItem);
                Debugger.m8607d(TAG, "succeed to convert a Server Note [" + this.mSuccessfulList.size() + " / " + size + "] - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
            } catch (Exception e) {
                AbstractC0000a.m22s("Failed to convert a Server Note file : ", e, TAG);
            }
        }
        Debugger.m8607d(TAG, "startImport finished : time = " + (System.currentTimeMillis() - jElapsedRealtime));
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void stop() {
        super.stop();
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() {
        return 0;
    }

    public ServerNoteLocalSync(Context context, ImportBaseTask.Listener listener, int i, List<ImportItem> list) {
        super(context, listener, DocTypeConstants.SDOCX_SCLOUD, i);
        this.mImportList = list;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public List<ImportItem> doInBackground(Void... voidArr) {
        return super.doInBackground(voidArr);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask, android.os.AsyncTask
    public void onPostExecute(List<ImportItem> list) {
        super.onPostExecute(list);
    }
}
