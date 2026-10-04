package com.samsung.android.app.notes.sync.importing.core;

import android.content.Context;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ImportHelper extends AbsImportHelper {
    private static final String TAG = "ImportHelper";
    protected final boolean mNeedToken;

    public ImportHelper(Context context, DocTypeConstants docTypeConstants, boolean z) {
        super(context, docTypeConstants);
        this.mNeedToken = z;
    }

    private void requestToken() {
        Debugger.m8607d(TAG, "Start getting the token");
        synchronized (this) {
            this.mState = 2;
            C13541h.m14287e().m14295i(this.mAccountListener);
        }
    }

    public boolean request(Executor executor, int i) {
        synchronized (this) {
            try {
                this.mExecutor = executor;
                if (this.mRequestType == i) {
                    return true;
                }
                this.mRequestType = i;
                this.mHasError = false;
                if (this.mNeedToken) {
                    int i2 = this.mState;
                    if (i2 == 1) {
                        requestToken();
                    } else if (i2 == 3) {
                        ImportBaseTask importBaseTask = this.mSync;
                        if (importBaseTask != null) {
                            importBaseTask.stop();
                            this.mSync = null;
                        }
                        requestToken();
                    }
                } else {
                    IAuthInfoReqListener iAuthInfoReqListener = this.mAccountListener;
                    if (iAuthInfoReqListener != null) {
                        iAuthInfoReqListener.onReceived(null, null);
                    }
                }
                return true;
            } finally {
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.AbsImportHelper
    public boolean requestDownloadLists(Executor executor, List<ImportItem> list, boolean z) {
        super.requestDownloadLists(executor, list, z);
        Debugger.m8607d(TAG, "requestDownloadLists()");
        synchronized (this) {
            try {
                int i = this.mState;
                if (i == 1 || this.mRequestType != 2) {
                    if (!z) {
                        this.mPrevDownloadCount = 0;
                    }
                    this.mDownloadList = list;
                    Debugger.m8607d(TAG, "request REQUEST_DOWNLOAD_LISTS");
                    return request(executor, 2);
                }
                if (i == 3) {
                    if (this.mDownloadAppendList == null) {
                        this.mDownloadAppendList = new ArrayList();
                    }
                    this.mDownloadAppendList.addAll(list);
                    Debugger.m8607d(TAG, "Add the docs to mDownloadAppendList");
                } else {
                    this.mDownloadList.addAll(list);
                    Debugger.m8607d(TAG, "Add the docs to mDownloadList");
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.AbsImportHelper
    public boolean requestGetLists(Executor executor) {
        boolean zRequest;
        super.requestGetLists(executor);
        Debugger.m8607d(TAG, "Start getting the doc list");
        synchronized (this) {
            zRequest = request(executor, 1);
        }
        return zRequest;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.AbsImportHelper
    public boolean requestRetry(Executor executor) {
        super.requestRetry(executor);
        synchronized (this) {
            try {
                if (this.mState != 1) {
                    return false;
                }
                List<ImportItem> list = this.mDownloadList;
                if (list != null && this.mSuccessfulList != null) {
                    List<ImportItem> list2 = this.mDownloadAppendList;
                    if (list2 != null) {
                        list.addAll(list2);
                        this.mDownloadAppendList = null;
                    }
                    return request(executor, 2);
                }
                return false;
            } finally {
            }
        }
    }
}
