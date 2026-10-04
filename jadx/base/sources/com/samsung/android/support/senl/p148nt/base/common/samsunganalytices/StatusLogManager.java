package com.samsung.android.support.senl.p148nt.base.common.samsunganalytices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.ArraySet;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import com.samsung.context.sdk.samsunganalytics.SamsungAnalytics;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0007J\u001a\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007H\u0007J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0001H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/StatusLogManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "STATUS_KEY_TYPE_STRING", "", "STATUS_KEY_TYPE_INTEGER", "STATUS_PREFERENCE_NAME", "STATUS_KEY_NAME_VERSION", "STATUS_KEY_NAME_STRING", "STATUS_KEY_NAME_INTEGER", "mSharedPref", "Landroid/content/SharedPreferences;", "mStringStatusList", "", "mIntegerStatusList", "mSettingPrefBuilder", "Lcom/samsung/context/sdk/samsunganalytics/LogBuilders$SettingPrefBuilder;", "setUpStatus", "", "context", "Landroid/content/Context;", "version", "insertStatusLog", "statusID", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "value", "updateStatusKeys", "type", "updateStatusValues", "key", "registerStatusLogs", "updateVersion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StatusLogManager {

    @NotNull
    private static final String STATUS_KEY_NAME_INTEGER = "IntegerKeys";

    @NotNull
    private static final String STATUS_KEY_NAME_STRING = "StringKeys";

    @NotNull
    private static final String STATUS_KEY_NAME_VERSION = "VersionKey";
    private static final int STATUS_KEY_TYPE_INTEGER = 2;
    private static final int STATUS_KEY_TYPE_STRING = 1;

    @NotNull
    private static final String STATUS_PREFERENCE_NAME = "APP_LAUNCH";

    @NotNull
    private static final String TAG = "NotesSA$StatusM";

    @Nullable
    private static SharedPreferences mSharedPref;

    @NotNull
    public static final StatusLogManager INSTANCE = new StatusLogManager();

    @NotNull
    private static final Map<String, String> mStringStatusList = new HashMap();

    @NotNull
    private static final Map<String, Integer> mIntegerStatusList = new HashMap();

    @NotNull
    private static final LogBuilders.SettingPrefBuilder mSettingPrefBuilder = new LogBuilders.SettingPrefBuilder();

    private StatusLogManager() {
    }

    @JvmStatic
    public static final void insertStatusLog(@NotNull String statusID, @Nullable String detail) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(statusID, "statusID");
        if (detail == null) {
            Logger.m8698e(TAG, "invalid status(" + statusID + "). detail is null.");
            return;
        }
        Map<String, String> map = mStringStatusList;
        if (map.containsKey(statusID)) {
            z = false;
            if (Intrinsics.areEqual(map.get(statusID), detail)) {
                z2 = false;
            } else {
                z2 = false;
                z = true;
            }
        } else {
            z2 = true;
            z = true;
        }
        if (z) {
            map.put(statusID, detail);
            INSTANCE.updateStatusValues(statusID, detail);
        }
        if (z2) {
            StatusLogManager statusLogManager = INSTANCE;
            statusLogManager.updateStatusKeys(1);
            mSettingPrefBuilder.addKey("APP_LAUNCH", statusID);
            statusLogManager.registerStatusLogs();
        }
    }

    private final void registerStatusLogs() {
        Logger.m8697d(TAG, "setUpStatus: register Setting Pref");
        SamsungAnalytics.getInstance().registerSettingPref(mSettingPrefBuilder.build());
    }

    @JvmStatic
    @SuppressLint({"MutatingSharedPrefs"})
    public static final void setUpStatus(@NotNull Context context, @NotNull String version) {
        int i;
        int iIntValue;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(version, "version");
        Logger.m8697d(TAG, "setUpStatus: " + version);
        SharedPreferences sharedPreferences = context.getSharedPreferences("APP_LAUNCH", 0);
        mSharedPref = sharedPreferences;
        String string2 = sharedPreferences != null ? sharedPreferences.getString(STATUS_KEY_NAME_VERSION, "") : null;
        if (TextUtils.isEmpty(string2)) {
            INSTANCE.updateVersion(version);
        } else if (!Intrinsics.areEqual(string2, version)) {
            Logger.m8697d(TAG, "setUpStatus: changed version : fr " + string2 + " to " + version);
            INSTANCE.updateVersion(version);
        }
        ArraySet arraySet = new ArraySet();
        SharedPreferences sharedPreferences2 = mSharedPref;
        Set<String> stringSet = sharedPreferences2 != null ? sharedPreferences2.getStringSet(STATUS_KEY_NAME_STRING, arraySet) : null;
        if (stringSet != null) {
            i = 0;
            for (String str : stringSet) {
                try {
                    SharedPreferences sharedPreferences3 = mSharedPref;
                    string = sharedPreferences3 != null ? sharedPreferences3.getString(str, "") : null;
                } catch (ClassCastException unused) {
                    string = "";
                }
                if (!TextUtils.isEmpty(string)) {
                    mStringStatusList.put(str, string);
                    mSettingPrefBuilder.addKey("APP_LAUNCH", str);
                    i++;
                }
            }
            stringSet.clear();
        } else {
            i = 0;
        }
        SharedPreferences sharedPreferences4 = mSharedPref;
        Set<String> stringSet2 = sharedPreferences4 != null ? sharedPreferences4.getStringSet(STATUS_KEY_NAME_INTEGER, stringSet) : null;
        if (stringSet2 != null) {
            for (String str2 : stringSet2) {
                try {
                    SharedPreferences sharedPreferences5 = mSharedPref;
                    Integer numValueOf = sharedPreferences5 != null ? Integer.valueOf(sharedPreferences5.getInt(str2, 0)) : null;
                    Intrinsics.checkNotNull(numValueOf);
                    iIntValue = numValueOf.intValue();
                } catch (ClassCastException unused2) {
                    iIntValue = 0;
                }
                mIntegerStatusList.put(str2, Integer.valueOf(iIntValue));
                mSettingPrefBuilder.addKey("APP_LAUNCH", str2);
                i++;
            }
        }
        Logger.m8697d(TAG, "setUpStatus : " + mSettingPrefBuilder.build());
        if (i > 0) {
            INSTANCE.registerStatusLogs();
        }
    }

    private final void updateStatusKeys(int type) {
        Set<String> setKeySet;
        String str;
        if (mSharedPref == null) {
            return;
        }
        if (type == 1) {
            setKeySet = mStringStatusList.keySet();
            str = STATUS_KEY_NAME_STRING;
        } else if (type != 2) {
            setKeySet = null;
            str = null;
        } else {
            setKeySet = mIntegerStatusList.keySet();
            str = STATUS_KEY_NAME_INTEGER;
        }
        if (str != null) {
            SharedPreferences sharedPreferences = mSharedPref;
            SharedPreferences.Editor editorEdit = sharedPreferences != null ? sharedPreferences.edit() : null;
            if (editorEdit != null) {
                editorEdit.putStringSet(str, setKeySet);
                editorEdit.apply();
            }
        }
    }

    private final void updateStatusValues(String key, Object value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = mSharedPref;
        if (sharedPreferences == null) {
            return;
        }
        if (value instanceof String) {
            editorEdit = sharedPreferences != null ? sharedPreferences.edit() : null;
            Intrinsics.checkNotNull(editorEdit);
            editorEdit.putString(key, (String) value);
            editorEdit.apply();
            return;
        }
        if (value instanceof Integer) {
            editorEdit = sharedPreferences != null ? sharedPreferences.edit() : null;
            Intrinsics.checkNotNull(editorEdit);
            editorEdit.putInt(key, ((Number) value).intValue());
            editorEdit.apply();
        }
    }

    private final void updateVersion(String version) {
        SharedPreferences sharedPreferences = mSharedPref;
        SharedPreferences.Editor editorEdit = sharedPreferences != null ? sharedPreferences.edit() : null;
        if (editorEdit != null) {
            editorEdit.putString(STATUS_KEY_NAME_VERSION, version);
            editorEdit.apply();
        }
    }

    @JvmStatic
    public static final void insertStatusLog(@NotNull String statusID, int value) {
        boolean z;
        Intrinsics.checkNotNullParameter(statusID, "statusID");
        Map<String, Integer> map = mIntegerStatusList;
        boolean z2 = true;
        if (map.containsKey(statusID)) {
            Integer num = map.get(statusID);
            z = false;
            if (num != null && num.intValue() == value) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (z2) {
            map.put(statusID, Integer.valueOf(value));
            INSTANCE.updateStatusValues(statusID, Integer.valueOf(value));
        }
        if (z) {
            StatusLogManager statusLogManager = INSTANCE;
            statusLogManager.updateStatusKeys(2);
            mSettingPrefBuilder.addKey("APP_LAUNCH", statusID);
            statusLogManager.registerStatusLogs();
        }
    }
}
