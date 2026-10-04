package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class RemoteVersionCheck {
    public static final int IDX_APP_VERSION = 1;
    public static final int IDX_REMOTE_VERSION = 0;
    private static final String METHOD_ON_VALID_VERSION = "onValidVersion";
    private static final String METHOD_RECEIVE_VERSION = "receiveVersion";
    private static final String METHOD_SHOW_APP_UPDATE_TOAST = "showAppUpdateToast";
    private static final String METHOD_VERSION_INFO_LOG = "versionInfoLog";
    private static final String TAG = Logger.createTag("RemoteVersionCheck");
    private final Activity mActivity;
    private final RemoteDataHelper mRemoteDataHelper = new RemoteDataHelper();
    private final RemoteFunctionContract.InnerContract mRemoteFunctionPresenter;

    public RemoteVersionCheck(Activity activity, RemoteFunctionContract.InnerContract innerContract) {
        this.mActivity = activity;
        this.mRemoteFunctionPresenter = innerContract;
    }

    private void checkAIAssistSupport(String str) {
        int i = Integer.parseInt(RemoteConstant.getMajorVersion(str));
        int i2 = Integer.parseInt(RemoteConstant.getMinorVersion(str));
        if (i < 3 || (i == 3 && i2 < 1)) {
            this.mRemoteFunctionPresenter.disableAIAssist();
        }
    }

    private void checkDynamicWeightAndFixedOpacityFeatureSupport(String str) {
        int i = Integer.parseInt(RemoteConstant.getMajorVersion(str));
        int i2 = Integer.parseInt(RemoteConstant.getMinorVersion(str));
        if (i != 3 || i2 >= 3) {
            return;
        }
        this.mRemoteFunctionPresenter.disableDynamicWeightAndFixedOpacityFeature();
    }

    private Method findMethodBy(String str) throws NoSuchMethodException {
        for (Method method : getClass().getMethods()) {
            RemoteConstant.RemoteFunctionName remoteFunctionName = (RemoteConstant.RemoteFunctionName) method.getAnnotation(RemoteConstant.RemoteFunctionName.class);
            if (remoteFunctionName != null && str.equals(remoteFunctionName.value())) {
                return method;
            }
        }
        throw new NoSuchMethodException(AbstractC0541b.m756B(str, " is not exist"));
    }

    private String getCurrentVersion() {
        return AbstractC0541b.m772n("0.3.3:", PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(this.mActivity));
    }

    @RemoteConstant.RemoteFunctionName(METHOD_ON_VALID_VERSION)
    public void onValidVersion() {
        Logger.m11003i(TAG, METHOD_ON_VALID_VERSION);
        this.mRemoteFunctionPresenter.onValidVersion();
    }

    public void receiveMessage(@NonNull String str) {
        AbstractC8014b.m7197C("receiveMessage ", str, TAG);
        try {
            String jSONObject = this.mRemoteDataHelper.getJSONObject(str, "key_action");
            String jSONObject2 = this.mRemoteDataHelper.getJSONObject(str, "key_type");
            String jSONObject3 = this.mRemoteDataHelper.getJSONObject(str, RemoteConstant.KEY_MESSAGE);
            Method methodFindMethodBy = findMethodBy(jSONObject);
            if (jSONObject2.isEmpty()) {
                methodFindMethodBy.invoke(this, null);
            } else {
                methodFindMethodBy.invoke(this, this.mRemoteDataHelper.getParseValue(jSONObject2, jSONObject3));
            }
        } catch (IllegalAccessException e) {
            e = e;
            AbstractC8014b.m7207i("executeFunction error : ", e, TAG);
        } catch (IllegalArgumentException e2) {
            e = e2;
            AbstractC8014b.m7207i("executeFunction error : ", e, TAG);
        } catch (NoSuchMethodException e3) {
            e = e3;
            AbstractC8014b.m7207i("executeFunction error : ", e, TAG);
        } catch (InvocationTargetException e5) {
            Logger.m11001e(TAG, "executeFunction InvocationTargetException : " + e5.getMessage(), e5.getTargetException());
        } catch (JSONException e6) {
            e = e6;
            AbstractC8014b.m7207i("executeFunction error : ", e, TAG);
        }
    }

    @RemoteConstant.RemoteFunctionName(METHOD_RECEIVE_VERSION)
    public void receiveVersion(String str) {
        String str2 = TAG;
        Logger.m11003i(str2, "receiveVersion " + str);
        String[] strArrSplit = str.split(":");
        versionInfoLog(str);
        sendMessage(METHOD_VERSION_INFO_LOG, getCurrentVersion());
        checkAIAssistSupport(strArrSplit[0]);
        checkDynamicWeightAndFixedOpacityFeatureSupport(strArrSplit[0]);
        if (!RemoteConstant.REMOTE_VERSION.equals(strArrSplit[0])) {
            if (!RemoteConstant.getMajorVersion().equals(RemoteConstant.getMajorVersion(strArrSplit[0]))) {
                Logger.m11000e(str2, "Major version mismatched");
                sendMessage(METHOD_SHOW_APP_UPDATE_TOAST, null);
                this.mRemoteFunctionPresenter.onInvalidVersion();
                return;
            } else if (!RemoteConstant.getMinorVersion().equals(RemoteConstant.getMinorVersion(strArrSplit[0]))) {
                Logger.m11000e(str2, "Minor version mismatched");
                if (this.mRemoteFunctionPresenter.isAIAssistDisabled()) {
                    Logger.m11000e(str2, "Do not show toast message when AI Assist is disabled.");
                } else {
                    sendMessage(METHOD_SHOW_APP_UPDATE_TOAST, null);
                }
            }
        }
        sendMessage(METHOD_ON_VALID_VERSION, null);
        this.mRemoteFunctionPresenter.onValidVersion();
    }

    public void sendMessage(String str, Object obj) {
        try {
            String strCreateJsonBySingleParam = this.mRemoteDataHelper.createJsonBySingleParam(str, obj);
            Logger.m11003i(TAG, "sendMessage " + strCreateJsonBySingleParam);
            this.mRemoteFunctionPresenter.sendMessage(strCreateJsonBySingleParam);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @RemoteConstant.RemoteFunctionName(METHOD_SHOW_APP_UPDATE_TOAST)
    public void showAppUpdateToast() {
        Logger.m11003i(TAG, METHOD_SHOW_APP_UPDATE_TOAST);
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteVersionCheck.1
            @Override // java.lang.Runnable
            public void run() {
                ToastHandler.show(RemoteVersionCheck.this.mActivity, CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.in_app_update_phone_and_tablet_toast_jp : C9086R.string.in_app_update_phone_and_tablet_toast, 1);
            }
        });
    }

    public void versionCheck() {
        sendMessage(METHOD_RECEIVE_VERSION, getCurrentVersion());
    }

    @RemoteConstant.RemoteFunctionName(METHOD_VERSION_INFO_LOG)
    public void versionInfoLog(String str) {
        String[] strArrSplit = str.split(":");
        StringBuilder sb = new StringBuilder("Remote Function Version Info \n");
        sb.append("Remote Type : ".concat(this.mRemoteFunctionPresenter.getRemoteType() == 4 ? "Tablet(Server)" : "Phone(Client)"));
        sb.append("\n");
        sb.append("Remote version | current : 0.3.3 | other device : " + strArrSplit[0]);
        sb.append("\n");
        if (strArrSplit.length > 1) {
            sb.append("App version | current " + PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(this.mActivity) + " | other device : " + strArrSplit[1]);
        }
        Logger.m11003i(TAG, sb.toString());
    }
}
