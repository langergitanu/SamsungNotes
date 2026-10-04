package com.samsung.android.support.senl.p148nt.app.common.updater;

import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.updater.BaseUpdater;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class EdpUpdater extends BaseUpdater {
    private static final String TAG = "EdpUpdater";
    private static EdpUpdater sInstance;

    public static synchronized EdpUpdater getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new EdpUpdater();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.updater.BaseUpdater
    public String getTag() {
        return TAG;
    }

    public boolean hasLatestSupportedVersion(BaseUpdater.AppStoreResultListener appStoreResultListener) {
        if (SyncState.getEdpUiTest2State()) {
            return true;
        }
        BaseUpdater.AppStoreResult appStoreResultCheckForceUpdateNotesVersion = getInstance().checkForceUpdateNotesVersion(appStoreResultListener);
        MainCoeditLogger.m7253i(TAG, "hasLatestSupportedVersion# appStoreResult : " + appStoreResultCheckForceUpdateNotesVersion);
        return appStoreResultCheckForceUpdateNotesVersion != BaseUpdater.AppStoreResult.ERROR && appStoreResultCheckForceUpdateNotesVersion == BaseUpdater.AppStoreResult.NEED_UPDATE;
    }

    public boolean isEdpEnableMinimumVersion() {
        return true;
    }
}
