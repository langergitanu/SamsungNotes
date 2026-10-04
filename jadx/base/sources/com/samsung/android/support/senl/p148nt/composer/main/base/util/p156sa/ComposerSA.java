package com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa;

import android.app.Activity;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AiResultLayout;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolSA;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerSA implements ComposerSAConstants, HWToolbarSAConstants, CommonSAConstants {
    private static final int DETAIL_TYPE_MAX_COUNT = 15;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SpenSettingLoggingListener implements SpenSettingPenLayout.LoggingListener {
        @Override // com.samsung.android.sdk.pen.setting.SpenSettingPenLayout.LoggingListener
        public void onClosed() {
        }

        @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onColorCirclePressed() {
        }

        @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onColorPickerCancel() {
        }

        @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onColorPickerDone() {
        }

        @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
        public void onColorPickerSelected() {
        }

        @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
        public void onColorSelected(int i) {
        }

        @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
        public void onColorSettingCancel() {
        }

        @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
        public void onColorSettingDone(int i) {
        }

        @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
        public void onColorSettingSelected() {
        }

        @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
        public void onEyedropperClosed() {
        }

        @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
        public void onEyedropperHandlerTapped() {
        }

        @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
        public void onEyedropperSelected() {
        }

        @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
        public void onPaletteSwiped(int i) {
        }

        @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onRecentColorSelected() {
        }

        @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onSeekbarChanged() {
        }
    }

    public static String getAiResultViewMode(int i) {
        AiResultLayout.Companion companion = AiResultLayout.INSTANCE;
        return i == companion.MODE_BOTTOM() ? "a" : i == companion.MODE_SIDE() ? "b" : i == companion.MODE_FLOATING() ? "c" : "";
    }

    public static String getDetailAiSelectedTextLength(int i, int i2) {
        int[] iArr = {100, 200, 400, 600, 800, 1000, 1500, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        int i4 = 0;
        while (i4 < 16) {
            int i5 = iArr[i4];
            if (i <= i5 || i5 >= i2) {
                break;
            }
            i4++;
        }
        return String.valueOf((char) (i4 + 97));
    }

    public static String getDetailAiSelectedTextMaxLength(int i, int i2, int i4, int i5) {
        if (i < i2) {
            return "a";
        }
        int i6 = 0;
        while (true) {
            if (i6 >= 15 || i <= (i2 = i2 + i4)) {
                break;
            }
            i6++;
            if (i6 > i5) {
                i6 = i5 - 1;
                break;
            }
        }
        return String.valueOf((char) (i6 + 97));
    }

    public static String getDetailBodyTextLength(int i) {
        int[] iArr = {100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000};
        int i2 = 0;
        while (i2 < 10 && i > iArr[i2]) {
            i2++;
        }
        return String.valueOf((char) (i2 + 97));
    }

    public static String getDetailDeviceRatio(Activity activity, float f) {
        if (activity == null) {
            return "";
        }
        boolean z = activity.getResources().getConfiguration().orientation != 1;
        int i = (int) (f * 100.0f);
        return i <= 60 ? z ? "1" : "14" : (i <= 60 || i > 80) ? (i <= 80 || i > 100) ? (i <= 100 || i > 120) ? (i <= 120 || i > 140) ? (i <= 140 || i > 160) ? (i <= 160 || i > 180) ? (i <= 180 || i > 200) ? (i <= 200 || i > 250) ? (i <= 250 || i > 300) ? (i <= 300 || i > 400) ? i > 400 ? z ? "12" : PublicApiId.SINGLE_ACCOUNT_PCA_ACQUIRE_TOKEN_SILENT_ASYNC_WITH_PARAMETERS : "" : z ? QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_PEN_BUTTON : PublicApiId.SINGLE_ACCOUNT_PCA_ACQUIRE_TOKEN_SILENT_WITH_PARAMETERS : z ? QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING : PublicApiId.PCA_ACQUIRE_TOKEN_SILENT_ASYNC_WITH_PARAMETERS : z ? "9" : PublicApiId.PCA_ACQUIRE_TOKEN_SILENT_WITH_PARAMETERS : z ? "8" : "20" : z ? "7" : "19" : z ? "6" : "18" : z ? "5" : "17" : z ? "4" : "16" : z ? "3" : "15" : z ? "2" : "14";
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized String getScreenID(boolean z, boolean z2, boolean z3) {
        return !z ? "301" : z3 ? "403" : z2 ? "411" : "401";
    }

    public static void insert(String str, String str2, String str3) {
        NotesSamsungAnalytics.insertLog(str, str2, str3);
    }

    public static void insertLog(String str, String str2, String str3) {
        BaseComposerSA.insertLog(str, str2, str3);
    }

    public static void insertStatusLog(String str, String str2) {
        NotesSamsungAnalytics.insertStatusLog(str, str2);
    }

    public static void insertLog(String str) {
        NotesSamsungAnalytics.insertLog(str);
    }

    public static void insertStatusLog(String str, int i) {
        NotesSamsungAnalytics.insertStatusLog(str, i);
    }

    public static void insertLog(String str, String str2) {
        NotesSamsungAnalytics.insertLog(str, str2);
    }

    public static void insertLog(String str, String str2, long j) {
        NotesSamsungAnalytics.insertLog(str, str2, j);
    }

    public static synchronized String getScreenID(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z) {
            return z2 ? ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT : ComposerSAConstants.SCREEN_PDF_VIEWER;
        }
        try {
            return getScreenID(z2, z3, z4);
        } finally {
        }
    }

    public static void insertLog(String str, String str2, String str3, long j) {
        NotesSamsungAnalytics.insertLog(str, str2, str3, j);
    }

    public static void insertLog(String str, String str2, Map<String, String> map) {
        NotesSamsungAnalytics.insertLog(str, str2, map);
    }
}
