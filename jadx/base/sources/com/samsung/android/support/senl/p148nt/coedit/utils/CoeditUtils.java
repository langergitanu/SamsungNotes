package com.samsung.android.support.senl.p148nt.coedit.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.lang.ref.WeakReference;
import p042J1.C0145c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditUtils {
    private static final int LOW_MEMORY_PERCENTAGE_THRESHHOLD = 10;
    private static final String TAG = "CoeditUtils";
    private static boolean mIsTrimMemoryLow;

    private static boolean checkUsedMemorySize() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) BaseUtils.getApplicationContext().getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)).getMemoryInfo(memoryInfo);
        double d = (memoryInfo.availMem / memoryInfo.totalMem) * 100.0d;
        CoeditLogger.m8919d(TAG, "checkUsedMemorySize, availMem : " + memoryInfo.availMem + ", totalMem: " + memoryInfo.totalMem + ", availPercent: " + d);
        return d < 10.0d;
    }

    public static String generateRandomNumber(int i) {
        int iNextInt;
        if (i < 1) {
            iNextInt = 0;
        } else {
            double d = i - 1;
            iNextInt = JavaInstanceConstructor.getSecureRandom().nextInt((((int) Math.pow(10.0d, d)) * 9) - 1) + ((int) Math.pow(10.0d, d));
        }
        return String.valueOf(iNextInt);
    }

    private static String getFileExt(String str) {
        if (str == null || !str.contains(Extension.DOT)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46) + 1;
        return iLastIndexOf == str.length() ? "" : str.substring(iLastIndexOf, str.length());
    }

    public static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            fileExtensionFromUrl = getFileExt(str);
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
        return TextUtils.isEmpty(mimeTypeFromExtension) ? fileExtensionFromUrl.equalsIgnoreCase("spi") ? CoeditServiceConstants.MimeType.OBJECT_SPI : "*/*" : mimeTypeFromExtension;
    }

    public static String getRequestNumber(String str) {
        StringBuilder sbM781w = AbstractC0541b.m781w(str, "_");
        sbM781w.append(generateRandomNumber(10));
        return sbM781w.toString();
    }

    public static String getSdkVersion() {
        try {
            try {
                String strValueOf = String.valueOf(SpenWNoteFile.getSdkFormatVersion());
                AbstractC8014b.m7219u("getSdkVersion# sdkVersion: ", strValueOf, TAG);
                return strValueOf;
            } catch (Throwable th) {
                CoeditLogger.m8919d(TAG, "getSdkVersion# sdkVersion: 2034");
                throw th;
            }
        } catch (Exception | UnsatisfiedLinkError e) {
            CoeditLogger.m8920e(TAG, "getSdkVersion# Failed to get version info. " + e.getMessage());
            CoeditLogger.m8919d(TAG, "getSdkVersion# sdkVersion: 2034");
            return NotesSAConstants.EVENT_NOTESLIST_MOVE;
        }
    }

    public static boolean hasLocalChanged(String str) {
        return CoeditCacheUtils.isLocalDataChanged(str) || CoeditCacheUtils.getAbnormalReleased(str) == 4 || CoeditCacheUtils.getAbnormalReleased(str) == 1 || CoeditCacheUtils.getAbnormalReleased(str) == 3;
    }

    public static boolean isActivityRefValid(WeakReference<Activity> weakReference) {
        return weakReference != null && isActivityValid(weakReference.get());
    }

    public static boolean isActivityValid(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean isCoeditDataNetworkAvailable() {
        if (isWiFiSyncOnlyAndNotWiFiConnected()) {
            return false;
        }
        return RequestToSCloudManager.INSTANCE.getInstance().isDataNetworkAvailable();
    }

    public static boolean isMemoryUnavailable() {
        if (!mIsTrimMemoryLow) {
            return false;
        }
        boolean zCheckUsedMemorySize = checkUsedMemorySize();
        CoeditLogger.m8919d(TAG, "isMemoryUnavailable, isLowMemory : " + zCheckUsedMemorySize);
        return zCheckUsedMemorySize;
    }

    public static boolean isNetworkReconnectDisabled() {
        return !(isWiFiSyncOnlyAndNotWiFiConnected() || RequestToSCloudManager.INSTANCE.getInstance().isDataNetworkAvailable()) || isWiFiSyncOnlyAndNotWiFiConnected();
    }

    public static boolean isWiFiSyncOnlyAndNotWiFiConnected() {
        boolean zEquals;
        Context applicationContext = BaseUtils.getApplicationContext();
        if (C0145c.m339x(applicationContext)) {
            return false;
        }
        if (applicationContext == null) {
            Debugger.m8609e("SyncSettingsUtil", "isCoeditNoteSyncWiFiOnly() : context is null!");
            zEquals = true;
        } else {
            zEquals = "settings_wifi_sync_only".equals(C0145c.m324i(applicationContext));
        }
        return zEquals && !C0145c.m298F(applicationContext);
    }

    public static void makeBodyTextNotEmpty(@NonNull SpenWNote spenWNote) {
    }

    public static void refreshUpdateCorrupted(SpenWNote spenWNote, String str) {
        if (spenWNote == null || !CoeditCacheUtils.isRequestUpdateCorrupted(str) || hasLocalChanged(str) || CoeditCacheUtils.getAbnormalReleased(str) > 0) {
            return;
        }
        CoeditLogger.m8919d(TAG, "refreshUpdateCorrupted " + str);
        CoeditCacheUtils.removeComposeCoeditCache(BaseUtils.getApplicationContext(), str);
        spenWNote.setServerCheckPoint(-1L);
    }

    public static void removeCoeditCacheIfCheckPointIsChanged(String str, long j, long j2, String str2) {
        if (j == j2) {
            return;
        }
        CoeditLogger.m8919d(TAG, str2 + ", removeCoeditCacheIfCheckPointIsChanged, remove all CoeditCache, coeditStartServerCheckPoint: " + j + ", currentServerCheckPoint: " + j2);
        CoeditCacheUtils.removeComposeCoeditCache(BaseUtils.getApplicationContext(), str, false);
    }

    public static void trimMemory(int i) {
        mIsTrimMemoryLow = i >= 15;
    }

    public static boolean verify(String str, String str2) {
        try {
            verifyUuid(str);
            verifyLoginState(str2);
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            CoeditLogger.m8920e(TAG, "verify failed: " + e.getMessage());
            return false;
        }
    }

    public static void verifyLoginState(String str) {
        if (!RequestToSamsungAccountManager.INSTANCE.isLogined()) {
            throw new IllegalStateException(AbstractC0541b.m773o("Samsung Account is not logined. UNAVAILABLE ", str, Extension.DOT));
        }
    }

    public static void verifyUuid(String str) {
        if (UUIDUtils.isCoeditUuid(str)) {
            return;
        }
        throw new IllegalArgumentException("Illegal uuid of note for coedit, @CoeditHandler." + Thread.currentThread().getStackTrace()[3].getMethodName() + "() - " + str);
    }
}
