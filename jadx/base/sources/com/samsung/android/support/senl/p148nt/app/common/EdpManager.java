package com.samsung.android.support.senl.p148nt.app.common;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.updater.BaseUpdater;
import com.samsung.android.support.senl.p148nt.app.common.updater.EdpUpdater;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.EdpNotificationHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import p211o0.C13569c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class EdpManager {
    private static final long CHECK_PERIOD_MONTH_A_DAY = 2592000000L;
    private static final boolean EDP_ENABLE_DEVICE = false;
    private static final String EDP_FTU_NOTIFY = "EDP_NOTIFY";
    private static final String EDP_NOTIFY_APP_UPDATE = "EDP_UPDATE";
    private static final String EDP_NOTIFY_UNSUPPORTED = "EDP_UNSUPPORTED";
    public static final String TAG = "EdpManager";
    private static EdpManager mInstance;
    private boolean mIsUnsupportedEdpDevice = false;
    private boolean mHasLatestSupportedEdpVersion = false;
    private boolean mHasKeyErrorEdpDevice = false;
    private boolean mNotifyEdpNotSupportedRemmendedAppUpdate = false;
    private boolean mNotifyEdpKeyError = false;
    private boolean mNotifyTipcardEdpKeyError = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EdpNotiType {
        public static final int HAS_KEY_ERROR = 3;
        public static final int NEED_SHOW_FTU = 4;
        public static final int NOT_SUPPORTED = 1;
        public static final int NOT_SUPPORTED_AND_HAS_UPDATE = 2;
        public static final int SUPPORTED = 0;
    }

    private boolean getEdpFtuNotify() {
        return true;
    }

    private int getEdpNotiType() {
        if (this.mHasKeyErrorEdpDevice) {
            return 3;
        }
        return this.mIsUnsupportedEdpDevice ? this.mHasLatestSupportedEdpVersion ? 2 : 1 : !getEdpFtuNotify() ? 4 : 0;
    }

    public static synchronized EdpManager getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new EdpManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private boolean getUnsupportNotify() {
        long j = SharedPreferencesCompat.getInstance("Settings").getLong(EDP_NOTIFY_UNSUPPORTED, 0L);
        return j != 0 && System.currentTimeMillis() - j < CHECK_PERIOD_MONTH_A_DAY;
    }

    private boolean getUpdateNotify() {
        long j = SharedPreferencesCompat.getInstance("Settings").getLong(EDP_NOTIFY_APP_UPDATE, 0L);
        return j != 0 && System.currentTimeMillis() - j < CHECK_PERIOD_MONTH_A_DAY;
    }

    public void checkLatestSupportedVersion() {
        boolean z = false;
        if (!this.mIsUnsupportedEdpDevice || !C13569c.m14375c().m14381g()) {
            this.mHasLatestSupportedEdpVersion = false;
            return;
        }
        if (EdpUpdater.getInstance().hasLatestSupportedVersion(new BaseUpdater.AppStoreResultListener() { // from class: com.samsung.android.support.senl.nt.app.common.EdpManager.1
            @Override // com.samsung.android.support.senl.nt.app.common.updater.BaseUpdater.AppStoreResultListener
            public void onResult(BaseUpdater.AppStoreResult appStoreResult) {
                EdpManager.this.mHasLatestSupportedEdpVersion = appStoreResult == BaseUpdater.AppStoreResult.NEED_UPDATE && EdpUpdater.getInstance().isEdpEnableMinimumVersion();
                if (EdpManager.this.hasUpdateNotification()) {
                    EdpManager.this.notifyEdpNotSupportedRemmendedAppUpdate();
                }
            }
        }) && EdpUpdater.getInstance().isEdpEnableMinimumVersion()) {
            z = true;
        }
        this.mHasLatestSupportedEdpVersion = z;
        if (hasUpdateNotification()) {
            notifyEdpNotSupportedRemmendedAppUpdate();
        }
    }

    public boolean hasFtuNotification() {
        return PermissionHelper.isPermissionGrantedWithoutNotice(BaseUtils.getApplicationContext(), PermissionCompat.getPermissionsForPostNotification()) && getEdpNotiType() == 4;
    }

    public boolean hasKeyErrorNotification() {
        return PermissionHelper.isPermissionGrantedWithoutNotice(BaseUtils.getApplicationContext(), PermissionCompat.getPermissionsForPostNotification()) && getEdpNotiType() == 3 && !this.mNotifyEdpKeyError;
    }

    public boolean hasKeyErrorTipcard() {
        return getEdpNotiType() == 3 && !this.mNotifyTipcardEdpKeyError;
    }

    public boolean hasTipcard() {
        return hasUnsupportTipcard() || hasUpdateTipcard() || hasKeyErrorTipcard();
    }

    public boolean hasUnsupportTipcard() {
        return getEdpNotiType() == 1 && !getUnsupportNotify();
    }

    public boolean hasUpdateNotification() {
        return PermissionHelper.isPermissionGrantedWithoutNotice(BaseUtils.getApplicationContext(), PermissionCompat.getPermissionsForPostNotification()) && getEdpNotiType() == 2 && !this.mNotifyEdpNotSupportedRemmendedAppUpdate && !getUpdateNotify();
    }

    public boolean hasUpdateTipcard() {
        return getEdpNotiType() == 2 && !getUpdateNotify();
    }

    public boolean isUnsupportedEdpDevice() {
        return this.mIsUnsupportedEdpDevice;
    }

    public void notifyEdpFtu() {
        new EdpNotificationHelper().notifyEdpFtu();
        setEdpFtuNotify(true);
    }

    public void notifyEdpKeyError() {
        new EdpNotificationHelper().notifyEdpKeyError();
        this.mNotifyEdpKeyError = true;
    }

    public void notifyEdpNotSupportedRemmendedAppUpdate() {
        new EdpNotificationHelper().notifyEdpNotSupportedRemmendedAppUpdate();
        this.mNotifyEdpNotSupportedRemmendedAppUpdate = true;
    }

    public void setEdpFtuNotify(boolean z) {
        SharedPreferencesCompat.getInstance("Settings").putInt(EDP_FTU_NOTIFY, z ? 1 : 0);
    }

    public void setKeyErrorEdpDevice(boolean z) {
        this.mHasKeyErrorEdpDevice = z;
        if (hasKeyErrorNotification()) {
            notifyEdpKeyError();
        }
    }

    public void setNotifyTipcardEdpKeyError(boolean z) {
        this.mNotifyTipcardEdpKeyError = z;
    }

    public void setUnsupportNotify(boolean z) {
        SharedPreferencesCompat.getInstance("Settings").putLong(EDP_NOTIFY_UNSUPPORTED, z ? System.currentTimeMillis() : 0L);
    }

    public void setUnsupportedEdpDevice(boolean z) {
        this.mIsUnsupportedEdpDevice = z;
        checkLatestSupportedVersion();
    }

    public void setUpdateNotify(boolean z) {
        SharedPreferencesCompat.getInstance("Settings").putLong(EDP_NOTIFY_APP_UPDATE, z ? System.currentTimeMillis() : 0L);
    }
}
