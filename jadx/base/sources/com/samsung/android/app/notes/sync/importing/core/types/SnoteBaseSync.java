package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils;
import java.io.File;
import p086V.C0315a;
import p086V.C0322h;
import p086V.InterfaceC0316b;
import p089W.C0327a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SnoteBaseSync extends ImportBaseTask {
    protected boolean mConvertingCompleted;
    private String mTag;
    private Object mWaitForCompleted;

    public SnoteBaseSync(Context context, ImportBaseTask.Listener listener, DocTypeConstants docTypeConstants, int i, String str) {
        super(context, listener, docTypeConstants, i);
        this.mConvertingCompleted = false;
        this.mWaitForCompleted = new Object();
        this.mTag = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConvertingFinished() {
        Debugger.m8615i(this.mTag, "notifyConvertingFinished!");
        this.mConvertingCompleted = true;
        synchronized (this.mWaitForCompleted) {
            this.mWaitForCompleted.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void progressUpdate(ImportItem importItem) {
        if (importItem.getRemoveOnConverted()) {
            File file = new File(importItem.getLocalFullPath());
            if (!file.exists() || file.delete()) {
                return;
            }
            Debugger.m8609e(this.mTag, "progressUpdate : Deleting failed = " + importItem.getLocalFullPath());
        }
    }

    private void waitConvertingFinished() {
        Debugger.m8615i(this.mTag, "waitConvertingFinished : start");
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 3) {
                break;
            }
            try {
                if (this.mConvertingCompleted) {
                    break;
                }
                int i4 = 1800000 * i2;
                synchronized (this.mWaitForCompleted) {
                    this.mWaitForCompleted.wait(i4);
                }
                i = i2;
            } catch (InterruptedException e) {
                Debugger.m8609e(this.mTag, "waitConvertingFinished " + e.getMessage());
            }
        }
        Debugger.m8615i(this.mTag, "waitConvertingFinished : finish");
    }

    public void convertingImportItem(String str, final ImportItem importItem, C0327a c0327a) {
        int i = importItem.isReplaced() ? 1 : 2;
        C0315a c0315a = new C0315a();
        c0315a.f812a = str;
        c0315a.f813b = i;
        this.mConvertingCompleted = false;
        try {
            InterfaceC0316b interfaceC0316b = new InterfaceC0316b() { // from class: com.samsung.android.app.notes.sync.importing.core.types.SnoteBaseSync.1
                @Override // p086V.InterfaceC0316b
                public void onEnd(int i2, final int i4, final int i5) {
                    Debugger.m8615i(SnoteBaseSync.this.mTag, "onEnd : success = " + i4 + " , failed = " + i5);
                    try {
                        if (i5 != 0) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.SnoteBaseSync.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    C0322h.m670a().f818d.showImportedFileCorruptedMessage(i4, 1, i5);
                                }
                            });
                        } else if (FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING && i4 > 0) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.app.notes.sync.importing.core.types.SnoteBaseSync.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    C0322h.m670a().f818d.showImportedFileSuccessMessage();
                                }
                            });
                        }
                        SnoteBaseSync snoteBaseSync = SnoteBaseSync.this;
                        snoteBaseSync.mConvertingCompleted = true;
                        snoteBaseSync.notifyConvertingFinished();
                    } catch (Throwable th) {
                        SnoteBaseSync snoteBaseSync2 = SnoteBaseSync.this;
                        snoteBaseSync2.mConvertingCompleted = true;
                        snoteBaseSync2.notifyConvertingFinished();
                        throw th;
                    }
                }

                @Override // p086V.InterfaceC0316b
                public void onProgressed(int i2, String str2) {
                    Debugger.m8615i(SnoteBaseSync.this.mTag, "onProgress : item = " + str2 + " @" + i2);
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    SnoteBaseSync.this.progressUpdate(importItem);
                }

                public void onStart() {
                }
            };
            c0327a.getClass();
            C0322h.m670a().f824j.convert(ApplicationManager.getInstance().getAppContext(), c0315a, interfaceC0316b);
        } catch (Exception e) {
            AbstractC4539a.m3213w(e, new StringBuilder("fail to convert : "), this.mTag);
            this.mConvertingCompleted = true;
            notifyConvertingFinished();
        }
        waitConvertingFinished();
    }

    public void finalizeConverter(C0327a c0327a) {
        c0327a.getClass();
        C0322h.m670a().f824j.release();
    }

    public void initializeConverter(C0327a c0327a) {
        c0327a.getClass();
        C0322h.m670a().f824j.init();
    }
}
