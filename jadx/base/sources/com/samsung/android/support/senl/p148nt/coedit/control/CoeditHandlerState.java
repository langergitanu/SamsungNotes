package com.samsung.android.support.senl.p148nt.coedit.control;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditHandlerState {
    private static String COEDITNOTE_CHECK_NOTES_EVERY_DAY = "COEDITNOTE_CHECK_NOTES_EVERY_DAY";
    private static final String TAG = "CoeditHandlerState";
    private static final long UPDATE_CHECK_PERIOD_EVERY_DAY = 86400000;
    private boolean mIsCancelDownloadRequested = false;
    private boolean mIsBackgroundDownloadEnable = false;
    private boolean mIsBackgroundDownloadResumed = false;

    private long getUpdateCheckedPeriod() {
        return SharedPreferencesCompat.getInstance("Settings").getLong(COEDITNOTE_CHECK_NOTES_EVERY_DAY, 0L);
    }

    private void setUpdateCheckedPeriod(long j) {
        SharedPreferencesCompat.getInstance("Settings").putLong(COEDITNOTE_CHECK_NOTES_EVERY_DAY, j);
    }

    public boolean isBackgroundDownloadEnable() {
        return this.mIsBackgroundDownloadEnable;
    }

    public boolean isCancelDownloadRequested() {
        return this.mIsCancelDownloadRequested;
    }

    public boolean isResumedBackgroundDownload() {
        return this.mIsBackgroundDownloadResumed;
    }

    public boolean requestBackgroundDownload() {
        long updateCheckedPeriod = getUpdateCheckedPeriod();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - updateCheckedPeriod <= 86400000 || !CoeditUtils.isCoeditDataNetworkAvailable()) {
            return false;
        }
        setUpdateCheckedPeriod(jCurrentTimeMillis);
        setBackgroundDownloadEnable(true);
        return true;
    }

    public void resumeBackgroundDownload() {
        CoeditLogger.m8923i(TAG, "resumeBackgroundDownload");
        this.mIsBackgroundDownloadResumed = true;
    }

    public void setBackgroundDownloadEnable(boolean z) {
        CoeditLogger.m8923i(TAG, "setBackgroundDownloadEnable# " + z);
        this.mIsBackgroundDownloadEnable = z;
        if (z) {
            this.mIsBackgroundDownloadResumed = true;
        }
    }

    public void setBackgroundDownloading(boolean z) {
        if (z) {
            this.mIsCancelDownloadRequested = false;
        }
    }

    public void setCancelDownloadRequested() {
        this.mIsCancelDownloadRequested = true;
    }

    public void stopBackgroundDownload() {
        CoeditLogger.m8923i(TAG, "stopBackgroundDownload");
        this.mIsBackgroundDownloadResumed = false;
    }
}
