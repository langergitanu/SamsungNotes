package com.samsung.android.support.senl.p148nt.app.importer;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.List;
import java.util.Map;
import p079T.RunnableC0284b;
import p084U0.C0312d;
import p084U0.InterfaceC0313e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ImportProcessor {
    private static final String TAG = "ImportProcessor";
    private static ImportTaskCallback sCallback;
    private static C0312d sDocumentManager;
    private static Integer sImportDocumentsSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImportTaskCallback implements InterfaceC0313e {
        private InterfaceC0313e mExternalListener;
        private final Runnable mOnFinishRunnable;

        public ImportTaskCallback(@NonNull Runnable runnable) {
            this.mOnFinishRunnable = runnable;
        }

        @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
        public void onFail(@NonNull String str, @NonNull String str2, int i, @Nullable String str3) {
            InterfaceC0313e interfaceC0313e = this.mExternalListener;
            if (interfaceC0313e != null) {
                interfaceC0313e.onFail(str, str2, i, str3);
            }
        }

        @Override // p084U0.InterfaceC0313e
        public void onFinish(int i, int i2, @NonNull Map<String, Integer> map, int i4) {
            InterfaceC0313e interfaceC0313e = this.mExternalListener;
            if (interfaceC0313e != null) {
                interfaceC0313e.onFinish(i, i2, map, i4);
            }
            this.mOnFinishRunnable.run();
        }

        @Override // p084U0.InterfaceC0313e
        public void onProgress(int i, int i2) {
            InterfaceC0313e interfaceC0313e = this.mExternalListener;
            if (interfaceC0313e != null) {
                interfaceC0313e.onProgress(i, i2);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
        public void onStart(@NonNull String str, @NonNull String str2) {
            InterfaceC0313e interfaceC0313e = this.mExternalListener;
            if (interfaceC0313e != null) {
                interfaceC0313e.onStart(str, str2);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
        public void onSuccess(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Pair<String, String> pair) {
            InterfaceC0313e interfaceC0313e = this.mExternalListener;
            if (interfaceC0313e != null) {
                interfaceC0313e.onSuccess(str, str2, str3, pair);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
        public void onUnsupportedVersionError(@NonNull String str, @NonNull String str2) {
            InterfaceC0313e interfaceC0313e = this.mExternalListener;
            if (interfaceC0313e != null) {
                interfaceC0313e.onUnsupportedVersionError(str, str2);
            }
        }

        public void setExternalListener(@Nullable InterfaceC0313e interfaceC0313e) {
            this.mExternalListener = interfaceC0313e;
        }
    }

    public static synchronized void cancel() {
        release(true);
    }

    public static synchronized void execute() {
        if (sDocumentManager != null && getImportDocumentsSize() > 0) {
            sDocumentManager.m664c(false);
            Logger.m8702i(TAG, "construct : " + sDocumentManager.hashCode());
        }
    }

    public static synchronized int getImportDocumentsSize() {
        Integer num;
        num = sImportDocumentsSize;
        return num == null ? 0 : num.intValue();
    }

    public static synchronized void initialize(@NonNull List<ImportDocument> list) {
        release(true);
        Integer numValueOf = Integer.valueOf(list.size());
        sImportDocumentsSize = numValueOf;
        if (numValueOf.intValue() <= 0) {
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        sCallback = new ImportTaskCallback(new RunnableC0284b(8));
        TaskState.INSTANCE.getInstance().setIsRunning("IMPORT_BY_SETTING", true);
        C0312d c0312d = new C0312d(applicationContext, list, TAG);
        c0312d.f808m = sCallback;
        c0312d.f806k = true;
        sDocumentManager = c0312d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initialize$0() {
        TaskState.INSTANCE.getInstance().setIsRunning("IMPORT_BY_SETTING", false);
        release(false);
    }

    public static synchronized boolean registerListener(InterfaceC0313e interfaceC0313e) {
        if (sCallback == null || getImportDocumentsSize() <= 0) {
            return false;
        }
        sCallback.setExternalListener(interfaceC0313e);
        return true;
    }

    private static synchronized void release(boolean z) {
        try {
            if (sDocumentManager != null) {
                Logger.m8702i(TAG, "release, manager : " + sDocumentManager.hashCode() + ", terminate : " + z);
                if (z) {
                    sDocumentManager.m669h();
                }
                sDocumentManager = null;
            }
            if (sCallback != null) {
                sCallback = null;
            }
            if (sImportDocumentsSize != null) {
                sImportDocumentsSize = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
