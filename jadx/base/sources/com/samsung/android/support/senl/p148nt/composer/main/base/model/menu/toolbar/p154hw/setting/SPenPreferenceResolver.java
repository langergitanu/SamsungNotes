package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting;

import android.content.SharedPreferences;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenVersion;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SPenPreferenceResolver {
    public static boolean getBoolean(String str, boolean z) {
        return getSettingPreferences().getBoolean(str, z);
    }

    public static int getInt(SPenVersion.Version version, String str, int i) {
        return getSettingPreferences(version).getInt(str, i);
    }

    public static String getLatestString(String str) {
        return getLatestString(SPenVersion.Version.DEFAULT, str);
    }

    private static SharedPreferencesCompat getSettingPreferences(SPenVersion.Version version) {
        return SharedPreferencesCompat.getInstance(version.getPreference());
    }

    public static String getString(String str, String str2) {
        return getSettingPreferences().getString(str, str2);
    }

    private static SPenVersion.Version previousVersion(SPenVersion.Version version) {
        if (version.ordinal() > 0) {
            return SPenVersion.Version.values()[version.ordinal() - 1];
        }
        return null;
    }

    public static void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        getSettingPreferences().registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static void setBoolean(String str, boolean z) {
        getSettingPreferences().putBoolean(str, z);
    }

    public static void setInt(String str, int i) {
        getSettingPreferences().putInt(str, i);
    }

    public static void setString(String str, String str2) {
        getSettingPreferences().putString(str, str2);
    }

    public static void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        getSettingPreferences().unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static int getInt(String str, int i) {
        return getSettingPreferences().getInt(str, i);
    }

    public static String getLatestString(SPenVersion.Version version, String str) throws NoSuchFieldException, LegacyVersionException {
        do {
            String string = getSettingPreferences(version).getString(str, "");
            if (!string.isEmpty()) {
                if (version.equals(SPenVersion.Version.DEFAULT)) {
                    return string;
                }
                throw new LegacyVersionException(version, string);
            }
            version = previousVersion(version);
        } while (version != null);
        throw new NoSuchFieldException("has no preference value");
    }

    private static SharedPreferencesCompat getSettingPreferences() {
        return getSettingPreferences(SPenVersion.Version.DEFAULT);
    }
}
