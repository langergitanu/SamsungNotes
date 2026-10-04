package com.samsung.android.app.notes.sync.importing.core;

import android.content.Context;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteLocalSync;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SnoteLocalImportHelper extends ImportHelper implements IAuthInfoReqListener {
    public SnoteLocalImportHelper(Context context) {
        super(context, DocTypeConstants.SNOTE_LOCAL, false);
        setAccountListener(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public void onError(String str, String str2) {
        synchronized (this) {
            onImportError(this.mType, 201, "errCode = " + str + " errMsg = " + str2, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public void onReceived(String str, String str2) {
        synchronized (this) {
            try {
                int i = this.mRequestType;
                if (i == 1) {
                    this.mSync = new SnoteLocalSync(this.mContext, this, 2);
                } else {
                    if (i != 2) {
                        this.mSync = null;
                        throw new UnsupportedOperationException();
                    }
                    this.mSync = new SnoteLocalSync(this.mContext, this, 3, this.mDownloadList);
                }
                ImportBaseTask importBaseTask = this.mSync;
                if (importBaseTask != null) {
                    this.mState = 3;
                    importBaseTask.executeOnExecutor(this.mExecutor, new Void[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
