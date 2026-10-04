package com.samsung.android.support.senl.p148nt.app.settings.common.utils;

import android.content.SharedPreferences;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0007J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/utils/SettingToolbarPreferenceUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "saveToolbarList", "", "visibleToolbarList", "", "hiddenToolbarList", "getJsonString", XmlErrorCodes.LIST, "setDefaultQuickColorCountValue", "setDefaultQuickSizeCountValue", "registerOnSharedPreferenceChangeListener", "prefListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterOnSharedPreferenceChangeListener", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingToolbarPreferenceUtils {

    @NotNull
    public static final SettingToolbarPreferenceUtils INSTANCE = new SettingToolbarPreferenceUtils();

    @NotNull
    private static final String TAG = "SettingToolbarPreferenceUtils";

    private SettingToolbarPreferenceUtils() {
    }

    private final String getJsonString(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        String string = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    public static final void saveToolbarList(@NotNull List<String> visibleToolbarList, @NotNull List<String> hiddenToolbarList) {
        Intrinsics.checkNotNullParameter(visibleToolbarList, "visibleToolbarList");
        Intrinsics.checkNotNullParameter(hiddenToolbarList, "hiddenToolbarList");
        SettingToolbarPreferenceUtils settingToolbarPreferenceUtils = INSTANCE;
        String jsonString = settingToolbarPreferenceUtils.getJsonString(visibleToolbarList);
        String jsonString2 = settingToolbarPreferenceUtils.getJsonString(hiddenToolbarList);
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").edit().putString(SettingsConstants.SETTINGS_TOOLBAR_ITEM_ORDER, jsonString).putString(SettingsConstants.SETTINGS_CANDIDATE_TOOLBAR_ITEM_ORDER, jsonString2).commit();
        MainLogger.m7258i(TAG, "saveToolbarList# visible=" + jsonString + " hidden=" + jsonString2);
    }

    @JvmStatic
    public static final void setDefaultQuickColorCountValue() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR_QUICK_COLOR_USE_COUNT, 3);
    }

    @JvmStatic
    public static final void setDefaultQuickSizeCountValue() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR_QUICK_SIZE_USE_COUNT, 1);
    }

    public final void registerOnSharedPreferenceChangeListener(@NotNull SharedPreferences.OnSharedPreferenceChangeListener prefListener) {
        Intrinsics.checkNotNullParameter(prefListener, "prefListener");
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").registerOnSharedPreferenceChangeListener(prefListener);
    }

    public final void unregisterOnSharedPreferenceChangeListener(@NotNull SharedPreferences.OnSharedPreferenceChangeListener prefListener) {
        Intrinsics.checkNotNullParameter(prefListener, "prefListener");
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(prefListener);
    }
}
