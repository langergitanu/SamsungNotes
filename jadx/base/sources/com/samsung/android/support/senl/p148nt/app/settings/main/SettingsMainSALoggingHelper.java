package com.samsung.android.support.senl.p148nt.app.settings.main;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsMainSALoggingHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mainSettingClickedSALogging", "", "key", "mainSettingChangedSALogging", "enabled", "", "advancedSettingClickedSALogging", "advancedSettingChangedSALogging", "mainSettingLoginSamsungAccount", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsMainSALoggingHelper {

    @NotNull
    public static final SettingsMainSALoggingHelper INSTANCE = new SettingsMainSALoggingHelper();

    @NotNull
    private static final String TAG = "SettingsMainSALoggingHelper";

    private SettingsMainSALoggingHelper() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void advancedSettingChangedSALogging(@NotNull String key, boolean enabled) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        String str2 = enabled ? "1" : "0";
        switch (key.hashCode()) {
            case -2118166339:
                if (key.equals(SettingsConstants.SETTINGS_CLIPPING_OPTIONS)) {
                    MainLogger.m7258i(TAG, "switchChangedSALogging# do not logging key: ".concat(key));
                } else {
                    MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                }
                str = null;
                break;
            case -1883074265:
                if (!key.equals(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR)) {
                }
                str = null;
                break;
            case -1380260848:
                if (!key.equals(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING)) {
                }
                str = null;
                break;
            case -1004673047:
                if (key.equals(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_HANDWRITING_RECOGNITION_SWITCH;
                }
                MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case -826246688:
                if (!key.equals(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING)) {
                }
                str = null;
                break;
            case -821391588:
                if (key.equals(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_SHOW_WEB_PREVIEW_SWITCH;
                }
                MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case -545459603:
                if (key.equals(SettingsConstants.SETTINGS_ACTION_ICONS)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_SHOW_ACTION_ICON_SWITCH;
                }
                MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case -239703315:
                if (!key.equals(SettingsConstants.SETTINGS_QUICK_TOOLS)) {
                }
                str = null;
                break;
            case 1454998611:
                if (key.equals(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_SHOW_LINKS_IN_NOTES_SWITCH;
                }
                MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case 1696494445:
                if (key.equals(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_HIDE_NAVIGATION_BAR_SWITCH;
                }
                MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS_ADVANCED, String.valueOf(str), str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void advancedSettingClickedSALogging(@NotNull String key) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        switch (key.hashCode()) {
            case -1004673047:
                if (!key.equals(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION)) {
                    MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                    str = null;
                } else {
                    str = SettingsSAConstants.EVENT_SETTINGS_HANDWRITING_LANGUAGE;
                }
                break;
            case -821391588:
                if (key.equals(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_SHOW_WEB_PREVIEW;
                    break;
                }
                break;
            case -561983901:
                if (key.equals(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_CUSTOMIZE_TOOLBAR;
                    break;
                }
                break;
            case -545459603:
                if (key.equals(SettingsConstants.SETTINGS_ACTION_ICONS)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_SHOW_ACTION_ICON;
                    break;
                }
                break;
            case 197317699:
                if (key.equals(SettingsConstants.SETTINGS_IMPORT_NOTES)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_IMPORT_DATA;
                    break;
                }
                break;
            case 357581661:
                if (key.equals(SettingsConstants.SETTINGS_CONVERT_YOUR_NOTES)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_CONVERT_YOUR_NOTES;
                    break;
                }
                break;
            case 1454998611:
                if (key.equals(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_SHOW_LINKS_IN_NOTES;
                    break;
                }
                break;
            case 1696494445:
                if (key.equals(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_HIDE_NAVIGATION_BAR;
                    break;
                }
                break;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS_ADVANCED, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void mainSettingChangedSALogging(@NotNull String key, boolean enabled) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        String str2 = enabled ? "1" : "0";
        switch (key.hashCode()) {
            case -2118166339:
                if (key.equals(SettingsConstants.SETTINGS_CLIPPING_OPTIONS)) {
                    MainLogger.m7258i(TAG, "switchChangedSALogging# do not logging key: ".concat(key));
                } else {
                    MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                }
                str = null;
                break;
            case -2117034650:
                if (key.equals(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_SAMSUNG_CLOUD_SYNC_SWITCH;
                }
                MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case -1413988111:
                if (!key.equals(SettingsConstants.SETTINGS_REDUCE_IMAGE_SIZES)) {
                }
                str = null;
                break;
            case -1380260848:
                if (!key.equals(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING)) {
                }
                str = null;
                break;
            case -826246688:
                if (!key.equals(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING)) {
                }
                str = null;
                break;
            case -778800653:
                if (!key.equals(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES)) {
                }
                str = null;
                break;
            case -395165134:
                if (key.equals(SettingsConstants.SETTINGS_MICROSOFT_SYNC)) {
                    str = "5002";
                }
                MainLogger.m7258i(TAG, "switchChangedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS, String.valueOf(str), str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d1  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void mainSettingClickedSALogging(@NotNull String key) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        switch (key.hashCode()) {
            case -2118166339:
                if (key.equals(SettingsConstants.SETTINGS_CLIPPING_OPTIONS)) {
                    MainLogger.m7258i(TAG, "preferenceClickedSALogging# do not logging key: ".concat(key));
                } else {
                    MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                }
                str = null;
                break;
            case -2117034650:
                if (key.equals(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_SAMSUNG_CLOUD_SYNC;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case -2012132363:
                if (key.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_LOOK_WHEN_SAVED;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case -1413988111:
                if (!key.equals(SettingsConstants.SETTINGS_REDUCE_IMAGE_SIZES)) {
                }
                str = null;
                break;
            case -1380260848:
                if (!key.equals(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING)) {
                }
                str = null;
                break;
            case -974570453:
                if (key.equals(SettingsConstants.SETTINGS_PASSWORD_AND_BIOMETRICS)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_PASSWORD_AND_BIOMETRICS;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case -826246688:
                if (!key.equals(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING)) {
                }
                str = null;
                break;
            case -778800653:
                if (!key.equals(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES)) {
                }
                str = null;
                break;
            case -769285180:
                if (key.equals(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_DEFAULT_EDITING_MODE;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case -395165134:
                if (!key.equals(SettingsConstants.SETTINGS_MICROSOFT_SYNC)) {
                }
                str = null;
                break;
            case -328739650:
                if (key.equals(SettingsConstants.SETTINGS_ADVANCED)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_ADVANCED_SETTINGS;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case 623588723:
                if (key.equals(SettingsConstants.SETTINGS_ABOUT_NOTES)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_ABOUT_SAMSUNG_NOTES;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case 940181886:
                if (key.equals(SettingsConstants.SETTINGS_DEFAULT_NOTE_STYLE)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_DEFAULT_NOTE_STYLE;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case 946106123:
                if (!key.equals(SettingsConstants.SETTINGS_PRIVACY_NOTICE)) {
                }
                str = null;
                break;
            case 1361973433:
                if (key.equals(SettingsConstants.SETTINGS_CONTACT_US)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_CONTACT_US;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
            case 1999504451:
                if (key.equals(SettingsConstants.SETTINGS_NOTES_ASSIST)) {
                    str = SettingsSAConstants.EVENT_SETTINGS_NOTE_ASSIST;
                }
                MainLogger.m7258i(TAG, "preferenceClickedSALogging# unexpected key: ".concat(key));
                str = null;
                break;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS, str);
    }

    @JvmStatic
    public static final void mainSettingLoginSamsungAccount() {
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS, SettingsSAConstants.EVENT_SETTINGS_SAMSUNG_CLOUD_SYNC_SIGN_IN);
    }
}
