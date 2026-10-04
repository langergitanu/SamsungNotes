package com.samsung.android.support.senl.p148nt.app.common.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import p044K.C0158a;
import p192j1.C12936a;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardUtil {
    private static final long CONVERT_CHECK_RANGE = 2592000000L;
    private static final long DAY_TIME_IN_MILLIS = 3600000;
    public static final String ENABLED_ACCOUNT_IMPORT_TIP_CARD = "enabled_account_import_tip_card";
    private static final String ENABLED_EXTERNAL_STORAGE_TIP_CARD = "enabled_external_storage_tip_card";
    private static final String KEY_CONVERT_ALL = "task_convert_all";
    public static final String KEY_CONVERT_TRY_COUNT = "key_upgrade_try_count";
    private static final String KEY_FAILED_CONVERT_PROGRESS = "key_failed_convert_progress";
    private static final String KEY_FAILED_IMPORT_PDF_PROGRESS = "key_failed_import_pdf_progress";
    private static final String KEY_FAILED_IMPORT_SAMSUNG_NOTE_PROGRESS = "key_failed_import_samsung_note_progress";
    private static final String KEY_FINISHED_CONVERT_PROGRESS = "key_finished_convert_progress";
    private static final String KEY_FINISHED_IMPORT_PDF_PROGRESS = "key_finished_import_pdf_progress";
    private static final String KEY_FINISHED_IMPORT_SAMSUNG_NOTE_PROGRESS = "key_finished_import_samsung_note_progress";
    public static final String KEY_LAST_CONVERT_CHECKED_TIME = "key_convert_checked_time";
    public static final String KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED = "key_microsoft_feed_login_tipcard_canceled";
    private static final String KEY_TOTAL_CONVERT_PROGRESS = "key_total_convert_progress";
    private static final String KEY_TOTAL_IMPORT_PDF_PROGRESS = "key_total_import_pdf_progress";
    private static final String KEY_TOTAL_IMPORT_SAMSUNG_NOTE_PROGRESS = "key_total_import_samsung_note_progress";
    private static final String TAG = "TipCardUtil";
    private static final String TASK_PREFERENCE = "task_preference";

    public static void clearConvertTaskProgress() {
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_TOTAL_CONVERT_PROGRESS);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_FINISHED_CONVERT_PROGRESS);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_FAILED_CONVERT_PROGRESS);
    }

    public static void clearImportPDFTaskProgress() {
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_TOTAL_IMPORT_PDF_PROGRESS);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_FINISHED_IMPORT_PDF_PROGRESS);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_FAILED_IMPORT_PDF_PROGRESS);
    }

    public static void clearImportSamsungNoteTaskProgress() {
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_TOTAL_IMPORT_SAMSUNG_NOTE_PROGRESS);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_FINISHED_IMPORT_SAMSUNG_NOTE_PROGRESS);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).remove(KEY_FAILED_IMPORT_SAMSUNG_NOTE_PROGRESS);
    }

    public static void countUpConvertTryCount(String str) {
        int i = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(KEY_CONVERT_TRY_COUNT, 0);
        if (i <= 3) {
            int i2 = i + 1;
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(KEY_CONVERT_TRY_COUNT, i2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("# tryCount : ");
            AbstractC8014b.m7212n(sb, TAG, i2);
        }
    }

    public static int getFailedConvertTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_FAILED_CONVERT_PROGRESS, 0);
    }

    public static int getFailedImportPDFTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_FAILED_IMPORT_PDF_PROGRESS, 0);
    }

    public static int getFailedImportSamsungNoteTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_FAILED_IMPORT_SAMSUNG_NOTE_PROGRESS, 0);
    }

    public static int getFinishedConvertTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_FINISHED_CONVERT_PROGRESS, 0);
    }

    public static int getFinishedImportPDFTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_FINISHED_IMPORT_PDF_PROGRESS, 0);
    }

    public static int getFinishedImportSamsungNoteTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_FINISHED_IMPORT_SAMSUNG_NOTE_PROGRESS, 0);
    }

    public static int getTotalConvertTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_TOTAL_CONVERT_PROGRESS, 0);
    }

    public static int getTotalImportPDFTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_TOTAL_IMPORT_PDF_PROGRESS, 0);
    }

    public static int getTotalImportSamsungNoteTaskProgress() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getInt(KEY_TOTAL_IMPORT_SAMSUNG_NOTE_PROGRESS, 0);
    }

    public static boolean isAccountImportTipCardEnabled() {
        boolean zIsSystemTestBuild = SystemPropertiesCompat.INSTANCE.getInstance().isSystemTestBuild();
        boolean z = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getBoolean(ENABLED_ACCOUNT_IMPORT_TIP_CARD, true);
        MainLogger.m7258i(TAG, "isAccountImportTipCardEnabled:" + z + " isSystemTestBuild: " + zIsSystemTestBuild);
        return z && !zIsSystemTestBuild;
    }

    public static boolean isAccountImportTipCardNeeds(int i, int i2, String str) {
        if (!isAccountImportTipCardEnabled()) {
            MainLogger.m7254d(TAG, "isAccountImportTipCardNeeds# accountImportTipCard disabled");
            return false;
        }
        if (i > 0) {
            MainLogger.m7254d(TAG, "isAccountImportTipCardNeeds# note data exist");
            return false;
        }
        if (!isAvailableTipCard(i2, str)) {
            AbstractC6670b.m4736A(i2, "isAccountImportTipCardNeeds# not available TipCard on modeIndex: ", TAG);
            return false;
        }
        if (DeviceUtils.isDemoDevice(BaseUtils.getApplicationContext())) {
            MainLogger.m7254d(TAG, "isAccountImportTipCardNeeds# demo device");
            return false;
        }
        if (DeviceInfo.isOtherCorpDevice()) {
            MainLogger.m7254d(TAG, "isAccountImportTipCardNeeds# other corp device");
            return false;
        }
        if (!DeviceUtils.isSupportedSync(C0158a.m407a().f492a)) {
            MainLogger.m7254d(TAG, "isAccountImportTipCardNeeds# not support sync feature");
            return false;
        }
        C0158a.m407a().getClass();
        if (!C0158a.m411g()) {
            MainLogger.m7254d(TAG, "isAccountImportTipCardNeeds# not support import feature");
            return false;
        }
        if (!C0158a.m407a().m417k() || !((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            return true;
        }
        MainLogger.m7254d(TAG, "isAccountImportTipCardNeeds# sync is enabled and account is login");
        return false;
    }

    public static boolean isAvailableMdeTipCard(int i) {
        return i == 10 || i == 11;
    }

    public static boolean isAvailableTipCard(int i, String str) {
        return i == 1 || (i == 2 && !FeatureUtils.isFilterFolderType(str));
    }

    public static boolean isConvertAll() {
        return SharedPreferencesCompat.getInstance(TASK_PREFERENCE).getBoolean(KEY_CONVERT_ALL, false);
    }

    public static boolean isExternalStorageTipCardEnabled() {
        return SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getBoolean(ENABLED_EXTERNAL_STORAGE_TIP_CARD, true);
    }

    public static boolean isMicrosoftLoginTipcardCanceled() {
        return SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getBoolean(KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED, false);
    }

    public static boolean isNeedCheckConvertedNotes() {
        if (BaseUtils.getApplicationContext() == null || DataManager.getInstance().getAll_ConvertedCount() <= 0) {
            return false;
        }
        long j = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getLong(KEY_LAST_CONVERT_CHECKED_TIME, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - j;
        if (j <= 0) {
            MainLogger.m7258i(TAG, "isNeedConvertSuggestion# init lastConvertCheckedTime");
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putLong(KEY_LAST_CONVERT_CHECKED_TIME, jCurrentTimeMillis);
            return false;
        }
        if (j2 < CONVERT_CHECK_RANGE) {
            MainLogger.m7258i(TAG, "isNeedConvertSuggestion# passedDay: " + (j2 / 3600000));
            return false;
        }
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putLong(KEY_LAST_CONVERT_CHECKED_TIME, jCurrentTimeMillis);
        int i = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(KEY_CONVERT_TRY_COUNT, 0);
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "isNeedConvertSuggestion# convertTryCount : ", ", passedDay: ");
        sbM778t.append(j2 / 3600000);
        MainLogger.m7258i(TAG, sbM778t.toString());
        return i <= 3;
    }

    private static boolean isPermissionGrantedForSyncTipCard(int i) {
        if (i != 11) {
            return false;
        }
        C12936a.m13839c().getClass();
        return C12936a.m13842g();
    }

    public static boolean isSyncTipCardCanShow(int i, int i2, String str) {
        if (isValidTipCardOnMode(i, i2, str)) {
            if (!isPermissionGrantedForSyncTipCard(i)) {
                return true;
            }
            MainLogger.m7254d(TAG, "isSyncTipCardCanShow# permission is granted");
            return false;
        }
        MainLogger.m7254d(TAG, "isSyncTipCardCanShow# invalid " + i + " on " + i2);
        return false;
    }

    public static boolean isValidTipCardOnMode(int i, int i2, String str) {
        if (i == 13) {
            return isAvailableMdeTipCard(i2);
        }
        if (i != 28) {
            if (i != 21 && i != 22) {
                return isAvailableTipCard(i2, str);
            }
            if (!isAvailableTipCard(i2, str) && i2 != 21 && i2 != 22) {
                return false;
            }
        }
        return true;
    }

    public static void setAccountImportTipCardDisabled() {
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(ENABLED_ACCOUNT_IMPORT_TIP_CARD, false);
    }

    public static void setConvertAll(boolean z) {
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putBoolean(KEY_CONVERT_ALL, z);
    }

    public static void setConvertTaskProgress(int i, int i2, int i4) {
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_TOTAL_CONVERT_PROGRESS, i);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_FINISHED_CONVERT_PROGRESS, i2);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_FAILED_CONVERT_PROGRESS, i4);
    }

    public static void setExternalStorageTipCardEnabled(boolean z) {
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(ENABLED_EXTERNAL_STORAGE_TIP_CARD, z);
    }

    public static void setImportPDFTaskProgress(int i, int i2, int i4) {
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_TOTAL_IMPORT_PDF_PROGRESS, i);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_FINISHED_IMPORT_PDF_PROGRESS, i2);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_FAILED_IMPORT_PDF_PROGRESS, i4);
    }

    public static void setImportSamsungNoteTaskProgress(int i, int i2, int i4) {
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_TOTAL_IMPORT_SAMSUNG_NOTE_PROGRESS, i);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_FINISHED_IMPORT_SAMSUNG_NOTE_PROGRESS, i2);
        SharedPreferencesCompat.getInstance(TASK_PREFERENCE).putInt(KEY_FAILED_IMPORT_SAMSUNG_NOTE_PROGRESS, i4);
    }

    public static void setMicrosoftFeedLoginTipcardDisabled() {
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED, true);
    }
}
