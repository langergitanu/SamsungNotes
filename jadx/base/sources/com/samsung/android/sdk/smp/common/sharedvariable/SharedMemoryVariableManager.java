package com.samsung.android.sdk.smp.common.sharedvariable;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.interfaces.SharedDataManager;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SharedMemoryVariableManager extends SharedDataManager {
    private static final String IS_DATA_CLEARED = "is_data_cleared";
    private static final String POPUP_CURRENT_DISPLAY_ID = "popup_current_display_id";
    private static final String RUNNING_REALTIME_MID_IN_FCMSERVICE = "running_realtime_mid_in_fcmservice";
    private static SharedMemoryVariableManager sSharedManager;

    private SharedMemoryVariableManager(Context context) {
        super(context);
    }

    public static synchronized SharedMemoryVariableManager getInstance(Context context) {
        try {
            if (sSharedManager == null) {
                sSharedManager = new SharedMemoryVariableManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sSharedManager;
    }

    public synchronized void addRunningRealtimeMidInFcmService(String str) {
        putStringSet(RUNNING_REALTIME_MID_IN_FCMSERVICE, str);
    }

    public synchronized int countRunningRealtimeMidsInFcmService() {
        return getStringSet(RUNNING_REALTIME_MID_IN_FCMSERVICE).size();
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public boolean getBooleanForSingleProcess(Context context, String str, boolean z) {
        return SharedMemoryVariable.getInstance().getBoolean(str, z);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getBooleanUri() {
        return getSmpPrefProviderBaseUri() + "variable_boolean/";
    }

    public synchronized int getCurrentDisplayId() {
        return getInteger(POPUP_CURRENT_DISPLAY_ID, -1);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public int getIntegerForSingleProcess(Context context, String str, int i) {
        return SharedMemoryVariable.getInstance().getInteger(str, i);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getIntegerUri() {
        return getSmpPrefProviderBaseUri() + "variable_integer/";
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public long getLongForSingleProcess(Context context, String str, long j) {
        return 0L;
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getLongUri() {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getRemoveStringSetUri() {
        return getSmpPrefProviderBaseUri() + "variable_delete_string_set/";
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getRemoveUri() {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getStringForSingleProcess(Context context, String str, String str2) {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public Set<String> getStringSetForSingleProcess(Context context, String str) {
        return SharedMemoryVariable.getInstance().getStringSet(str);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getStringSetUri() {
        return getSmpPrefProviderBaseUri() + "variable_string_set/";
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public String getStringUri() {
        return null;
    }

    public synchronized boolean isDataCleared() {
        return getBoolean(IS_DATA_CLEARED, false);
    }

    public synchronized boolean isRunningRealtimeMidInFcmService(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return getStringSet(RUNNING_REALTIME_MID_IN_FCMSERVICE).contains(str);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putBooleanForSingleProcess(Context context, String str, boolean z) {
        SharedMemoryVariable.getInstance().putBoolean(str, z);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putIntegerForSingleProcess(Context context, String str, int i) {
        SharedMemoryVariable.getInstance().putInteger(str, i);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putLongForSingleProcess(Context context, String str, long j) {
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putStringForSingleProcess(Context context, String str, String str2) {
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void putStringSetForSingleProcess(Context context, String str, String str2) {
        SharedMemoryVariable.getInstance().putStringSet(str, str2);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void removeForSingleProcess(Context context, String str) {
    }

    public synchronized void removeRunningRealtimeMidInFcmService(String str) {
        removeStringSet(RUNNING_REALTIME_MID_IN_FCMSERVICE, str);
    }

    @Override // com.samsung.android.sdk.smp.common.interfaces.SharedDataManager
    public void removeStringSetForSingleProcess(Context context, String str, String str2) {
        SharedMemoryVariable.getInstance().removeStringSet(str, str2);
    }

    public synchronized void setCurrentDisplayId(int i) {
        putInteger(POPUP_CURRENT_DISPLAY_ID, i);
    }

    public synchronized void setDataCleared(boolean z) {
        putBoolean(IS_DATA_CLEARED, z);
    }
}
