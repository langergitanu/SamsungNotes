package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p042J1.AbstractC0155m;
import p089W.C0327a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SnoteLocalSync extends SnoteBaseSync {
    private static final String TAG = "SnoteLocalSync";

    public SnoteLocalSync(Context context, ImportBaseTask.Listener listener, int i) {
        super(context, listener, DocTypeConstants.SNOTE_LOCAL, i, TAG);
    }

    private void scanFiles(File file, List<String> list) {
        File[] fileArrListFiles;
        if (file != null) {
            try {
                if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.getName().charAt(0) != '.') {
                            if (file2.isDirectory()) {
                                scanFiles(file2, list);
                            } else {
                                String absolutePath = file2.getAbsolutePath();
                                if (absolutePath.length() > 4) {
                                    String strSubstring = absolutePath.substring(absolutePath.length() - 4);
                                    if (strSubstring.toLowerCase().endsWith(".spd") || strSubstring.toLowerCase().endsWith(".snb")) {
                                        list.add(absolutePath);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Debugger.m8609e(TAG, "scanFiles - " + th.getMessage());
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() throws Throwable {
        Debugger.m8615i(TAG, "getImportItems() start");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Debugger.m8615i(TAG, "Scan files in the device");
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            scanFiles(externalStorageDirectory, arrayList2);
        } else {
            Debugger.m8615i(TAG, "deviceStorageDirectory is null! ");
        }
        Debugger.m8615i(TAG, "Scan files in the SD card");
        File fileM391f = AbstractC0155m.m391f();
        if (fileM391f != null) {
            scanFiles(fileM391f, arrayList2);
        } else {
            Debugger.m8615i(TAG, "sdCardDirectory is null! ");
        }
        int size = arrayList2.size();
        if (size > 0) {
            arrayList = AbstractC0155m.m395j(arrayList2);
            synchronized (this) {
                try {
                    if (this.mListener != null) {
                        int size2 = arrayList.size();
                        int i = 0;
                        while (i < size2) {
                            ImportItem importItem = (ImportItem) arrayList.get(i);
                            i++;
                            this.mListener.onUpdated(this.mTaskType, i, size, importItem);
                        }
                    }
                } finally {
                }
            }
        }
        this.mResultList = arrayList;
        Debugger.m8615i(TAG, "getImportItems finish(" + this.mResultList.size() + ") - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " , size : " + this.mResultList.size());
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() {
        Debugger.m8607d(TAG, "startImport()");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this) {
            try {
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onDownloaded(DocTypeConstants.SNOTE_LOCAL, null, 1);
                }
            } finally {
            }
        }
        this.mSuccessfulList = new ArrayList();
        C0327a c0327a = new C0327a();
        initializeConverter(c0327a);
        int size = this.mImportList.size();
        try {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            int size2 = this.mImportList.size();
            for (int i = 0; i < size2 && !isCancelled(); i++) {
                if (!AbstractC0155m.m401p()) {
                    throw new SyncException(323, "device storage is full!");
                }
                ImportItem importItem = this.mImportList.get(i);
                Debugger.m8607d(TAG, "Starting to convert a Snote : " + FileUtils.logPath(importItem.getLocalFullPath()));
                synchronized (this) {
                    try {
                        ImportBaseTask.Listener listener2 = this.mListener;
                        if (listener2 != null) {
                            listener2.onDownloaded(DocTypeConstants.SNOTE_LOCAL, importItem, 1);
                        }
                    } finally {
                    }
                }
                try {
                    convertingImportItem(importItem.getLocalFullPath(), importItem, c0327a);
                    this.mSuccessfulList.add(importItem);
                    Debugger.m8607d(TAG, "succeed to convert a Snote [" + this.mSuccessfulList.size() + " / " + size + "] - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                } catch (Exception e) {
                    Debugger.m8609e(TAG, "Failed to convert a Snote file : " + e);
                }
            }
            finalizeConverter(c0327a);
            Debugger.m8607d(TAG, "startImport finished : time = " + (System.currentTimeMillis() - jElapsedRealtime));
        } catch (Throwable th) {
            finalizeConverter(c0327a);
            throw th;
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() throws Throwable {
        getImportItems();
        this.mImportList = this.mResultList;
        startImport();
        return 0;
    }

    public SnoteLocalSync(Context context, ImportBaseTask.Listener listener, int i, List<ImportItem> list) {
        super(context, listener, DocTypeConstants.SNOTE_LOCAL, i, TAG);
        this.mImportList = list;
    }
}
