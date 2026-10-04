package com.samsung.android.support.senl.p148nt.coedit.control.controller;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.support.senl.ntnl.coedit.CoeditDeviceInfo;
import com.samsung.android.support.senl.ntnl.coedit.ICoeditController;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.SCloudDownloadFile;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.SCloudUploadFile;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.List;
import p001A.AbstractC0000a;
import p234q1.C14433b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditController implements ICoeditController {
    private static final String TAG = "NT/CoeditController";
    private static final long UPDATE_CHECK_PERIOD_EVERY_WEEK = 604800000;
    private ComposerContract mComposerContract;
    private ManagerContract mManagerContract;
    private RestoreContract mRestoreContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComposerContract {
        boolean canShowProgress();

        void handleError(long j, String str);

        void handleExceedMaxConnectDevice(long j);

        void hideProgress(String str);

        boolean isEditMode();

        void onDeviceListUpdated(List<CoeditDeviceInfo> list);

        void setDisableOfflineEditMode(boolean z);

        void setRequestUpdate(boolean z);

        void showProgress(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ManagerContract {
        int getDownloadXmlDataSize();

        boolean isReconnectAvailable();

        void releaseForReconnect(String str);

        void releaseJwt();

        void requestReconnect(String str);

        void runOnUiThread(long j);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RestoreContract {
        void restoreDownloadStroke(String str, byte[] bArr);

        void restoreUndownloadStroke(String str, String str2);
    }

    public CoeditController(RestoreContract restoreContract, ManagerContract managerContract, ComposerContract composerContract) {
        this.mRestoreContract = restoreContract;
        this.mManagerContract = managerContract;
        this.mComposerContract = composerContract;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public boolean canShowProgress() {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return false;
        }
        return composerContract.canShowProgress();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public int getAbnormalReleased(String str) {
        return CoeditCacheUtils.getAbnormalReleased(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public String getCacheFilePath(String str) {
        return CoeditCacheUtils.createCoeditCachePath(BaseUtils.getApplicationContext(), str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public int getCurrentDocumentSize(String str) {
        return CoeditCacheUtils.getCurrentDocumentSize(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public long getLastDownloadedCheckPoint(String str) {
        return CoeditCacheUtils.getLastDownloadedCheckPoint(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public String getMimeType(String str) {
        return CoeditUtils.getMimeType(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void handleExceedMaxConnectDevice(long j) {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return;
        }
        composerContract.handleExceedMaxConnectDevice(j);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void hideProgress(String str) {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return;
        }
        composerContract.hideProgress(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public boolean isEditMode() {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return false;
        }
        return composerContract.isEditMode();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public boolean isLocalDataChanged(String str) {
        return CoeditCacheUtils.isLocalDataChanged(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public boolean isNetworkReconnectDisabled() {
        return CoeditUtils.isNetworkReconnectDisabled();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public boolean isReconnectAvailable() {
        ManagerContract managerContract = this.mManagerContract;
        if (managerContract == null) {
            return false;
        }
        return managerContract.isReconnectAvailable();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public boolean isSnapDuration(String str, String str2) {
        NotesDocumentEntity notesDocumentEntityM9f;
        SesCoeditShareReadResolver sesCoeditShareReadResolver = SesCoeditShareReadResolver.getInstance();
        Context applicationContext = BaseUtils.getApplicationContext();
        String spaceIdByGroupId = SesCoeditShareReadResolver.getInstance().getSpaceIdByGroupId(str2);
        Context applicationContext2 = BaseUtils.getApplicationContext();
        if (str != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(applicationContext2, str);
            AbstractC0000a.m18o(applicationContext2, applicationContext2, applicationContext2);
        } else {
            notesDocumentEntityM9f = null;
        }
        return System.currentTimeMillis() - sesCoeditShareReadResolver.getCoeditNoteModifiedTime(applicationContext, spaceIdByGroupId, notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getMdeItemId() : "") > 604800000;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public boolean isSnapUploadCompleted(String str) {
        return CoeditCacheUtils.isSnapUploadCompleted(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void onDeviceListUpdated(List<CoeditDeviceInfo> list) {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return;
        }
        composerContract.onDeviceListUpdated(list);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void onError(long j, String str) {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return;
        }
        composerContract.handleError(j, str);
    }

    public void release() {
        this.mRestoreContract = null;
        this.mManagerContract = null;
        this.mComposerContract = null;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void releaseForReconnect(String str) {
        ManagerContract managerContract = this.mManagerContract;
        if (managerContract == null) {
            return;
        }
        managerContract.releaseForReconnect(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void releaseJwt() {
        ManagerContract managerContract = this.mManagerContract;
        if (managerContract == null) {
            return;
        }
        managerContract.releaseJwt();
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public String requestDownloadFile(String str, String str2, String str3) {
        CoeditLogger.m8919d(TAG, "[CS7] requestDownloadFile()");
        if (TextUtils.isEmpty(str)) {
            CoeditLogger.m8920e(TAG, "[CS7-2] requestDownloadFile() : Empty uuid!");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            CoeditLogger.m8920e(TAG, "[CS7-2] requestDownloadFile() : No groupId!");
            return null;
        }
        if (!StorageUtils.isAvailableMinimumMemory()) {
            CoeditLogger.m8920e(TAG, "[CS7-2] requestDownloadFile() : No isAvailableMinimumMemory!");
            return null;
        }
        if (CoeditUtils.isMemoryUnavailable()) {
            CoeditLogger.m8920e(TAG, "[CS7-2] requestDownloadFile() : isMemoryUnavailable");
            return null;
        }
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            CoeditLogger.m8920e(TAG, "[CS7-2] requestDownloadFile() : DataNetwork is not available!");
            return null;
        }
        RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
        String accessToken = companion.getAccessToken();
        String userId = companion.getUserId();
        if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(userId)) {
            CoeditLogger.m8920e(TAG, "[CS7-2] requestDownloadFile() : invalid accessToken or userId!");
            return null;
        }
        if (!TextUtils.isEmpty(RequestToSCloudManager.INSTANCE.getInstance().getAuthorizationSync(accessToken, userId))) {
            return new SCloudDownloadFile(str3, str2).perform();
        }
        CoeditLogger.m8920e(TAG, "[CS3-2] requestDownloadFile() : Authorization is not available!");
        return null;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void requestReconnect(String str) {
        ManagerContract managerContract = this.mManagerContract;
        if (managerContract == null) {
            return;
        }
        managerContract.requestReconnect(str);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public int requestUploadFile(String str, String str2, String str3, long j, String str4, String str5) {
        CoeditLogger.m8919d(TAG, "[CS5] requestUploadFile()");
        if (TextUtils.isEmpty(str)) {
            CoeditLogger.m8920e(TAG, "[CS5-2] requestUploadFile() : Empty uuid!");
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            CoeditLogger.m8920e(TAG, "[CS5-2] requestUploadFile() : No groupId!");
            return -1;
        }
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            CoeditLogger.m8920e(TAG, "[CS5-2] requestUploadFile() : DataNetwork is not available!");
            return -1;
        }
        RequestToSamsungAccountManager.Companion companion = RequestToSamsungAccountManager.INSTANCE;
        String accessToken = companion.getAccessToken();
        String userId = companion.getUserId();
        if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(userId)) {
            CoeditLogger.m8920e(TAG, "[CS5-2] requestUploadFile() : invalid accessToken or userId!");
            return -1;
        }
        String strM15039o = C14433b.m15033p(BaseUtils.getApplicationContext()).m15039o(accessToken, userId);
        if (!TextUtils.isEmpty(strM15039o)) {
            return new SCloudUploadFile(strM15039o, str3, str4, j, str5, str2).perform();
        }
        CoeditLogger.m8920e(TAG, "[CS5-2] requestUploadFile() : Authorization is not available!");
        return -1;
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void restoreUndrawnData(String str) {
        final int[] iArr = {0};
        final int[] iArr2 = {0};
        CoeditCacheUtils.restorePrefInfo(str, new CoeditCacheUtils.RestoreDownloadListener() { // from class: com.samsung.android.support.senl.nt.coedit.control.controller.CoeditController.1
            @Override // com.samsung.android.support.senl.nt.base.common.util.CoeditCacheUtils.RestoreDownloadListener
            public void restoreDownloadStroke(String str2, byte[] bArr) {
                CoeditController.this.mRestoreContract.restoreDownloadStroke(str2, bArr);
                int[] iArr3 = iArr2;
                iArr3[0] = iArr3[0] + 1;
            }

            @Override // com.samsung.android.support.senl.nt.base.common.util.CoeditCacheUtils.RestoreDownloadListener
            public void restoreUndownloadStroke(String str2, String str3) {
                CoeditController.this.mRestoreContract.restoreUndownloadStroke(str2, str3);
                int[] iArr3 = iArr;
                iArr3[0] = iArr3[0] + 1;
            }
        });
        if (iArr[0] > 0 || iArr2[0] > 0) {
            CoeditLogger.m8923i(TAG, "restoreUndrawnData Undownload#" + iArr[0] + " Download# " + iArr2[0]);
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void runOnUiThread(long j) {
        ManagerContract managerContract = this.mManagerContract;
        if (managerContract == null) {
            return;
        }
        managerContract.runOnUiThread(j);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void setAbnormalReleased(String str, int i) {
        CoeditCacheUtils.setAbnormalReleased(str, i);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void setCurrentDocumentSize(String str, int i) {
        CoeditCacheUtils.setCurrentDocumentSize(str, i);
        CoeditLogger.m8923i(TAG, "setCurrentDocumentSize : " + i);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    @WorkerThread
    public void setDisableOfflineEditMode(boolean z) {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return;
        }
        composerContract.setDisableOfflineEditMode(z);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void setLastDownloadedCheckPoint(String str, long j) {
        CoeditCacheUtils.setLastDownloadedCheckPoint(str, j);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void setLocalDataChanged(String str, boolean z) {
        CoeditCacheUtils.setLocalDataChanged(str, z);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void setRequestUpdate(String str, int i) {
        if (i == 0) {
            CoeditCacheUtils.setRequestUpdate(str, i);
            setRequestUpdate(true);
            return;
        }
        if (i == 1) {
            CoeditCacheUtils.setRequestUpdate(str, i);
            setRequestUpdate(false);
        } else if (i == 3) {
            setRequestUpdate(true);
        } else if (i != 6) {
            setRequestUpdate(false);
        } else {
            CoeditCacheUtils.setRequestUpdate(str, i);
        }
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void setXmlDocumentSize(String str) {
        if (this.mComposerContract == null) {
            return;
        }
        int downloadXmlDataSize = this.mManagerContract.getDownloadXmlDataSize();
        CoeditCacheUtils.setCurrentDocumentSize(str, downloadXmlDataSize);
        CoeditLogger.m8923i(TAG, "setXmlDocumentSize : " + downloadXmlDataSize);
    }

    @Override // com.samsung.android.support.senl.ntnl.coedit.ICoeditController
    public void showProgress(String str) {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return;
        }
        composerContract.showProgress(str);
    }

    private void setRequestUpdate(boolean z) {
        ComposerContract composerContract = this.mComposerContract;
        if (composerContract == null) {
            return;
        }
        composerContract.setRequestUpdate(z);
    }
}
