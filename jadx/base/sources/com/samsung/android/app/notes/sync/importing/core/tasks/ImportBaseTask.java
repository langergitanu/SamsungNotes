package com.samsung.android.app.notes.sync.importing.core.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import java.util.ArrayList;
import java.util.List;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ImportBaseTask extends AsyncTask<Void, Void, List<ImportItem>> {
    protected static final String TAG = "ImportBaseTask";
    protected final Context mContext;
    protected int mErrorCode;
    protected List<ImportItem> mImportList;
    protected Listener mListener;
    public int mRequestType;
    protected List<ImportItem> mResultList;
    protected List<ImportItem> mSuccessfulList;
    public DocTypeConstants mTaskType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Listener {
        void onDownloaded(DocTypeConstants docTypeConstants, ImportItem importItem, int i);

        void onGetListEnded(DocTypeConstants docTypeConstants);

        void onImportEnded(DocTypeConstants docTypeConstants);

        void onImportEnded(DocTypeConstants docTypeConstants, List<ImportItem> list);

        void onImportError(DocTypeConstants docTypeConstants, int i, String str, Exception exc);

        void onImportStart(DocTypeConstants docTypeConstants);

        void onItemImportFinished(DocTypeConstants docTypeConstants, int i, int i2, int i4);

        void onUpdated(DocTypeConstants docTypeConstants, int i, int i2, ImportItem importItem);
    }

    public ImportBaseTask(Context context, Listener listener, DocTypeConstants docTypeConstants, int i) {
        DocTypeConstants docTypeConstants2 = DocTypeConstants.NONE;
        this.mResultList = null;
        this.mImportList = null;
        this.mSuccessfulList = null;
        this.mContext = context;
        this.mListener = listener;
        this.mTaskType = docTypeConstants;
        this.mRequestType = i;
    }

    public List<ImportItem> getDownloadList() {
        return this.mImportList;
    }

    public List<ImportItem> getFailedList() {
        return new ArrayList();
    }

    public abstract void getImportItems();

    public List<ImportItem> getResultData() {
        return this.mResultList;
    }

    public List<ImportItem> getSuccessfulList() {
        if (this.mSuccessfulList == null) {
            this.mSuccessfulList = new ArrayList();
        }
        return this.mSuccessfulList;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Debugger.m8615i(TAG, "onCancelled()");
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.mListener.onImportStart(this.mTaskType);
    }

    public void setDownloadList(List<ImportItem> list) {
        this.mImportList = list;
    }

    public abstract void startImport();

    public void stop() {
        synchronized (this) {
            this.mListener = null;
            Debugger.m8615i(TAG, "stop() : cancel(true) - TaskType : " + this.mTaskType + " , RequestType : " + this.mRequestType);
            cancel(true);
        }
    }

    public abstract int syncProgress();

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ImportItem> doInBackground(Void... voidArr) {
        Exception exc;
        int iM639l;
        Thread.currentThread().setName(TAG);
        this.mErrorCode = 0;
        try {
            SpenSdkInitializer.initialize(this.mContext);
            int i = this.mRequestType;
            if (i == 2) {
                Process.setThreadPriority(-2);
                getImportItems();
            } else if (i == 3) {
                Process.setThreadPriority(11);
                startImport();
            }
        } catch (Exception e) {
            Debugger.m8608e(e);
            this.mErrorCode = 1;
            if (e instanceof SyncException) {
                SyncException syncException = (SyncException) e;
                int exceptionCode = syncException.getExceptionCode();
                if (exceptionCode == 315 && exceptionCode != (iM639l = AbstractC0299q.m639l(syncException))) {
                    exceptionCode = iM639l;
                }
                int iM637k = AbstractC0299q.m637k(exceptionCode);
                this.mErrorCode = iM637k;
                if (iM637k == 901) {
                    exc = (Exception) syncException.getCause();
                }
                synchronized (this) {
                }
            } else {
                exc = null;
                synchronized (this) {
                    try {
                        Listener listener = this.mListener;
                        if (listener != null) {
                            listener.onImportError(this.mTaskType, this.mErrorCode, "ImportBaseTask.doInBackground", exc);
                        }
                    } finally {
                    }
                }
            }
        }
        List<ImportItem> list = this.mResultList;
        if (list != null) {
            return list;
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(List<ImportItem> list) {
        Debugger.m8615i(TAG, "onPostExecute() start " + this.mTaskType + " : v." + AbstractC0155m.m399n(this.mContext));
        synchronized (this) {
            try {
                if (this.mListener != null) {
                    int i = this.mRequestType;
                    if (i == 2) {
                        Debugger.m8607d(TAG, "finish getting doc list!");
                        if (this.mErrorCode != 901) {
                            this.mListener.onGetListEnded(this.mTaskType);
                        } else {
                            Debugger.m8607d(TAG, "do not call mListener.onGetListEnded()");
                        }
                    } else if (i == 3) {
                        Debugger.m8607d(TAG, "finish downloading doc files!");
                        this.mListener.onImportEnded(this.mTaskType, this.mImportList);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Debugger.m8615i(TAG, "onPostExecute() ends");
    }
}
