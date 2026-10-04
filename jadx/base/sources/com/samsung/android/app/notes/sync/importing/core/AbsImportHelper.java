package com.samsung.android.app.notes.sync.importing.core;

import android.content.Context;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import java.util.List;
import java.util.concurrent.Executor;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AbsImportHelper implements ImportBaseTask.Listener {
    public static final int REQUEST_DOWNLOAD_LISTS = 2;
    public static final int REQUEST_GET_LISTS = 1;
    public static final int REQUEST_NONE = 0;
    public static final int REQUEST_TOKEN = 2;
    public static final int START = 3;
    public static final int STOP = 1;
    private static final String TAG = "AbsSyncHelper";
    protected final Context mContext;
    public final DocTypeConstants mType;
    protected ImportBaseTask mSync = null;
    protected Executor mExecutor = null;
    protected List<ImportItem> mDownloadList = null;
    protected List<ImportItem> mSuccessfulList = null;
    protected int mPrevDownloadCount = 0;
    protected List<ImportItem> mDownloadAppendList = null;
    protected boolean mHasError = false;
    protected ImportBaseTask.Listener mListener = null;
    protected IAuthInfoReqListener mAccountListener = null;
    protected int mState = 1;
    protected int mRequestType = 0;

    public AbsImportHelper(Context context, DocTypeConstants docTypeConstants) {
        this.mContext = context;
        this.mType = docTypeConstants;
    }

    public int getDownloadListSize() {
        List<ImportItem> list = this.mDownloadList;
        int size = list != null ? list.size() : 0;
        List<ImportItem> list2 = this.mDownloadAppendList;
        if (list2 != null) {
            size += list2.size();
        }
        return size + this.mPrevDownloadCount;
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public int getState() {
        return this.mState;
    }

    public int getSuccessfulListSize() {
        List<ImportItem> list = this.mSuccessfulList;
        return list == null ? this.mPrevDownloadCount : list.size() + this.mPrevDownloadCount;
    }

    public DocTypeConstants getTaskType() {
        ImportBaseTask importBaseTask = this.mSync;
        return importBaseTask == null ? DocTypeConstants.NONE : importBaseTask.mTaskType;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onDownloaded(DocTypeConstants docTypeConstants, ImportItem importItem, int i) {
        synchronized (this) {
            try {
                if (this.mListener != null) {
                    ImportBaseTask importBaseTask = this.mSync;
                    this.mSuccessfulList = importBaseTask == null ? null : importBaseTask.getSuccessfulList();
                    this.mListener.onDownloaded(docTypeConstants, importItem, i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onGetListEnded(DocTypeConstants docTypeConstants) {
        Debugger.m8607d(TAG, "onGetListEnded()");
        synchronized (this) {
            try {
                this.mState = 1;
                this.mRequestType = 0;
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onGetListEnded(docTypeConstants);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportEnded(DocTypeConstants docTypeConstants) {
        Debugger.m8607d(TAG, "onSyncEnded()");
        synchronized (this) {
            try {
                this.mState = 1;
                this.mRequestType = 0;
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onImportEnded(docTypeConstants);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportError(DocTypeConstants docTypeConstants, int i, String str, Exception exc) {
        synchronized (this) {
            try {
                this.mState = 1;
                this.mRequestType = 0;
                this.mHasError = true;
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onImportError(docTypeConstants, i, str, exc);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportStart(DocTypeConstants docTypeConstants) {
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onItemImportFinished(DocTypeConstants docTypeConstants, int i, int i2, int i4) {
        synchronized (this) {
            try {
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onItemImportFinished(docTypeConstants, i, i2, i4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onUpdated(DocTypeConstants docTypeConstants, int i, int i2, ImportItem importItem) {
        synchronized (this) {
            try {
                ImportBaseTask.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onUpdated(docTypeConstants, i, i2, importItem);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean requestDownloadLists(Executor executor, List<ImportItem> list, boolean z) {
        return false;
    }

    public boolean requestGetLists(Executor executor) {
        return false;
    }

    public boolean requestRetry(Executor executor) {
        return false;
    }

    public boolean requestSync(Executor executor) {
        return false;
    }

    public void setAccountListener(IAuthInfoReqListener iAuthInfoReqListener) {
        this.mAccountListener = iAuthInfoReqListener;
    }

    public void setImportListener(ImportBaseTask.Listener listener) {
        synchronized (this) {
            this.mListener = listener;
        }
    }

    public boolean stop() {
        synchronized (this) {
            try {
                ImportBaseTask importBaseTask = this.mSync;
                if (importBaseTask != null) {
                    DocTypeConstants docTypeConstants = importBaseTask.mTaskType;
                    Debugger.m8615i(TAG, "stop() - type : " + docTypeConstants + " , requestType : " + importBaseTask.mRequestType);
                    this.mSync.stop();
                    this.mSync = null;
                    this.mPrevDownloadCount = 0;
                    this.mDownloadList = null;
                    this.mSuccessfulList = null;
                    this.mDownloadAppendList = null;
                    this.mState = 1;
                    this.mRequestType = 0;
                    if (this.mListener != null) {
                        Debugger.m8615i(TAG, "call onImportEnded()");
                        this.mListener.onImportEnded(docTypeConstants);
                    }
                } else {
                    Debugger.m8615i(TAG, "stop() - mSync is null!");
                    C13541h.m14287e().m14289b(this.mAccountListener);
                    this.mState = 1;
                    this.mRequestType = 0;
                    if (this.mListener != null) {
                        Debugger.m8615i(TAG, "call onImportEnded()");
                        this.mListener.onImportEnded(DocTypeConstants.NONE);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return false;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportEnded(DocTypeConstants docTypeConstants, List<ImportItem> list) {
        Debugger.m8607d(TAG, "onImportEnded()");
        synchronized (this) {
            try {
                if (this.mHasError) {
                    Debugger.m8607d(TAG, "onImportEnded() : mHasError is true!");
                    this.mState = 1;
                    this.mRequestType = 0;
                    List<ImportItem> list2 = this.mSuccessfulList;
                    if (list2 != null) {
                        this.mPrevDownloadCount += list2.size();
                        this.mDownloadList.removeAll(this.mSuccessfulList);
                    }
                    this.mHasError = false;
                } else {
                    List<ImportItem> list3 = this.mDownloadAppendList;
                    if (list3 != null && !list3.isEmpty()) {
                        this.mState = 1;
                        this.mRequestType = 0;
                        this.mPrevDownloadCount += this.mDownloadList.size();
                        List<ImportItem> list4 = this.mDownloadAppendList;
                        this.mDownloadAppendList = null;
                        Debugger.m8607d(TAG, "call requestDownloadLists()");
                        requestDownloadLists(this.mExecutor, list4, true);
                    } else {
                        this.mState = 1;
                        this.mRequestType = 0;
                        this.mPrevDownloadCount = 0;
                        this.mDownloadList = null;
                        this.mSuccessfulList = null;
                        ImportBaseTask.Listener listener = this.mListener;
                        if (listener != null) {
                            listener.onImportEnded(docTypeConstants, list);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
