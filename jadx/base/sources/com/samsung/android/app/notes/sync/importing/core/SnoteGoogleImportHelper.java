package com.samsung.android.app.notes.sync.importing.core;

import android.content.Context;
import com.google.api.services.drive.Drive;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteGoogleDriveSync;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SnoteGoogleImportHelper extends ImportHelper implements IAuthInfoReqListener {
    private String currentAccountName;
    private Drive mDrive;

    public SnoteGoogleImportHelper(Context context) {
        super(context, DocTypeConstants.SNOTE_GOOGLEDRIVE, false);
        this.mDrive = null;
        this.currentAccountName = null;
        setAccountListener(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public void onError(String str, String str2) {
        synchronized (this) {
            onImportError(this.mType, 201, "errCode = " + str + " errMsg = " + str2, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public void onReceived(String str, String str2) throws Throwable {
        SnoteGoogleImportHelper snoteGoogleImportHelper;
        synchronized (this) {
            try {
                try {
                    if (this.mDrive == null) {
                        throw new UnsupportedOperationException();
                    }
                    int i = this.mRequestType;
                    if (i == 1) {
                        snoteGoogleImportHelper = this;
                        snoteGoogleImportHelper.mSync = new SnoteGoogleDriveSync(snoteGoogleImportHelper.mContext, snoteGoogleImportHelper.mDrive, this, 2);
                    } else {
                        if (i != 2) {
                            this.mSync = null;
                            throw new UnsupportedOperationException();
                        }
                        snoteGoogleImportHelper = this;
                        snoteGoogleImportHelper.mSync = new SnoteGoogleDriveSync(this.mContext, this.mDrive, snoteGoogleImportHelper, 3, this.mDownloadList);
                    }
                    ImportBaseTask importBaseTask = snoteGoogleImportHelper.mSync;
                    if (importBaseTask != null) {
                        snoteGoogleImportHelper.mState = 3;
                        importBaseTask.executeOnExecutor(snoteGoogleImportHelper.mExecutor, new Void[0]);
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void setCurrentAccountName(String str) {
        this.currentAccountName = str;
    }

    public void setDrive(Drive drive) {
        this.mDrive = drive;
    }
}
