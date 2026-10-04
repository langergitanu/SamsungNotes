package com.samsung.android.sdk.bixby2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.bixby2.data.AppMetaInfo;
import com.samsung.android.sdk.bixby2.provider.CapsuleProvider;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Sbixby {
    private static final String BIXBY_VERSION_1_0 = "1";
    private static final String TAG = "Sbixby_1.1.0";
    private static Map<String, AppMetaInfo> appMetaInfoMap;
    private static Context mContext;
    private static Sbixby mInstance;
    private static String mPackageName;

    private Sbixby(Context context) {
        mContext = context;
    }

    public static synchronized Sbixby getInstance() {
        if (mInstance == null) {
            throw new IllegalStateException("The Sbixby instance is NULL. do initialize Sbixby before accessing instance.");
        }
        LogUtil.m5745d(TAG, " getInstance()");
        return mInstance;
    }

    public static StateHandler getStateHandler() {
        LogUtil.m5745d(TAG, " getStateHandler()");
        return StateHandler.getInstance();
    }

    public static void initialize(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("App Context is NULL. pass valid context.");
        }
        if (mInstance == null) {
            mInstance = new Sbixby(context);
        }
        mInstance.setPackageName(context.getPackageName());
        CapsuleProvider.setAppInitialized(true);
        LogUtil.m5747i(TAG, "initialized");
    }

    public static boolean isPathRuleBased(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(Constants.BIXBY_AGENT_PKG_NAME, 0);
            if (packageInfo != null && !TextUtils.isEmpty(packageInfo.versionName)) {
                String[] strArrSplit = packageInfo.versionName.split(RemoteConstant.VERSION_DIVIDE);
                if (!TextUtils.isEmpty(strArrSplit[0])) {
                    if ("1".equals(strArrSplit[0])) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.m5745d(TAG, "NameNotFoundException" + e);
        }
        return false;
    }

    private void setPackageName(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("package name is null or empty.");
        }
        mPackageName = str;
    }

    public void addActionHandler(String str, @NonNull ActionHandler actionHandler, boolean z) {
        if (TextUtils.isEmpty(str) || actionHandler == null) {
            throw new IllegalArgumentException("Action handler is NULL. pass valid app action handler implementation.");
        }
        LogUtil.m5745d(TAG, " addActionHandler: action Id --> " + str);
        CapsuleProvider.addActionHandler(str, actionHandler, Boolean.valueOf(z));
    }

    public void addAppMetaInfo(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.m5745d(TAG, "capsuleId cannot be null or empty");
            throw new IllegalArgumentException("capsuleId cannot be null or empty");
        }
        if (appMetaInfoMap == null) {
            appMetaInfoMap = new HashMap();
        }
        appMetaInfoMap.put(str, new AppMetaInfo(str, i));
    }

    public Map<String, AppMetaInfo> getAppMetaInfoMap() {
        return appMetaInfoMap;
    }

    public void removeActionHandler(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Action id is NULL. pass valid app action id");
        }
        LogUtil.m5745d(TAG, "removing actionHandler with actionId --> " + str);
        CapsuleProvider.removeActionHandler(str);
    }

    public void removeAllActionHandlers() {
        LogUtil.m5745d(TAG, "Removing all action handlers");
        CapsuleProvider.removeAllActionHandlers();
    }

    public void removeAppMetaInfo(String str) {
        if (str == null || !appMetaInfoMap.containsKey(str)) {
            return;
        }
        appMetaInfoMap.remove(str);
    }

    public void addActionHandler(String str, @NonNull ActionHandler actionHandler) {
        addActionHandler(str, actionHandler, false);
    }
}
