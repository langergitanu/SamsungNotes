package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityService;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteFunctionPresenter implements RemoteFunctionContract.InnerContract {
    private static final String TAG = Logger.createTag("RemoteFunctionPresenter");
    private boolean isAIAssistDisabled;
    private boolean isDynamicWeightAndFixedOpacityFeatureDisabled;
    private final Activity mActivity;
    private final ContinuityService mContinuityService;
    private final RemoteDataHelper mRemoteDataHelper;
    private final RemoteExecutor mRemoteExecutor;
    private final Map<String, RemoteFunctionContract.TargetClassContract> mRemoteTargetClassMap;
    private final Map<String, Method> mRemoteTargetMethodMap;
    private final int mRemoteType;
    private RemoteVersionCheck mRemoteVersionCheck;

    public RemoteFunctionPresenter(Activity activity, ContinuityService continuityService, @RemoteConstant.RemoteSenderType int i) {
        this.mRemoteTargetClassMap = new HashMap();
        this.mRemoteTargetMethodMap = new HashMap();
        this.isAIAssistDisabled = false;
        this.isDynamicWeightAndFixedOpacityFeatureDisabled = false;
        this.mActivity = activity;
        this.mContinuityService = continuityService;
        this.mRemoteDataHelper = new RemoteDataHelper();
        this.mRemoteExecutor = new RemoteExecutor();
        this.mRemoteType = i;
        if (activity != null) {
            this.mRemoteVersionCheck = new RemoteVersionCheck(activity, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeFunction(String str, String str2, Object[] objArr) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            Logger.m11000e(TAG, "executeFunction - parameter error class " + str + " method " + str2);
            return;
        }
        this.mRemoteExecutor.executeFunction(this.mRemoteTargetClassMap.get(str), this.mRemoteTargetMethodMap.get(str + ":" + str2), objArr);
    }

    private String getFunctionName(Method method) {
        RemoteConstant.RemoteFunctionName remoteFunctionName = (RemoteConstant.RemoteFunctionName) method.getAnnotation(RemoteConstant.RemoteFunctionName.class);
        return (remoteFunctionName == null || remoteFunctionName.value().equals(RemoteConstant.NO_FUNCTION)) ? RemoteConstant.NO_FUNCTION : remoteFunctionName.value();
    }

    private String getReceiverFunctionName(Method method) {
        RemoteConstant.RemoteReceiverFunctionName remoteReceiverFunctionName = (RemoteConstant.RemoteReceiverFunctionName) method.getAnnotation(RemoteConstant.RemoteReceiverFunctionName.class);
        return (remoteReceiverFunctionName == null || remoteReceiverFunctionName.value().equals(RemoteConstant.NO_FUNCTION)) ? RemoteConstant.NO_FUNCTION : remoteReceiverFunctionName.value();
    }

    private boolean isValidSenderType(Method method) {
        RemoteConstant.RemoteSenderType remoteSenderType = (RemoteConstant.RemoteSenderType) method.getAnnotation(RemoteConstant.RemoteSenderType.class);
        if (remoteSenderType == null) {
            return false;
        }
        int iValue = remoteSenderType.value();
        int i = this.mRemoteType;
        if ((iValue & i) != i) {
            return false;
        }
        return ((iValue & 2) == 0 || (iValue & 4) == 0) ? (iValue & 1) == 0 : !isRemotedFunctionCall();
    }

    public void addRemoteTargetClass(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        this.mRemoteTargetClassMap.put(simpleName, (RemoteFunctionContract.TargetClassContract) obj);
        for (Method method : obj.getClass().getMethods()) {
            String functionName = getFunctionName(method);
            if (!functionName.equals(RemoteConstant.NO_FUNCTION)) {
                this.mRemoteTargetMethodMap.put(simpleName + ":" + functionName, method);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.PresenterContract
    public void disableAIAssist() {
        this.isAIAssistDisabled = true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.PresenterContract
    public void disableDynamicWeightAndFixedOpacityFeature() {
        this.isDynamicWeightAndFixedOpacityFeatureDisabled = true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.PresenterContract
    public int getRemoteType() {
        return this.mRemoteType;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.PresenterContract
    public boolean isAIAssistDisabled() {
        return this.isAIAssistDisabled;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.PresenterContract
    public boolean isDynamicWeightAndFixedOpacityFeatureDisabled() {
        return this.isDynamicWeightAndFixedOpacityFeatureDisabled;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.PresenterContract
    public boolean isRemotedFunctionCall() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            try {
                if (Class.forName(stackTraceElement.getClassName()).isAnnotationPresent(RemoteConstant.RemoteExecutor.class)) {
                    return true;
                }
            } catch (ClassNotFoundException e) {
                Logger.m11000e(TAG, "isRemotedFunctionCall error : " + e.toString());
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.InnerContract
    public void onInvalidVersion() {
        Logger.m11003i(TAG, "onInvalidVersion");
        this.mContinuityService.closeInAppCollaboration();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.InnerContract
    public void onValidVersion() {
        Logger.m11003i(TAG, "onValidVersion");
        this.mRemoteVersionCheck = null;
        Iterator<Map.Entry<String, RemoteFunctionContract.TargetClassContract>> it = this.mRemoteTargetClassMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().init();
        }
    }

    public void receiveMessage(@NonNull String str) {
        AbstractC8014b.m7197C("receiveMessage ", str, TAG);
        try {
            RemoteVersionCheck remoteVersionCheck = this.mRemoteVersionCheck;
            if (remoteVersionCheck != null) {
                remoteVersionCheck.receiveMessage(str);
                return;
            }
            final String keyClass = this.mRemoteDataHelper.getKeyClass(str);
            final String keyMethod = this.mRemoteDataHelper.getKeyMethod(str);
            final Object[] parameterValues = this.mRemoteDataHelper.getParameterValues(str);
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionPresenter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteFunctionPresenter.this.executeFunction(keyClass, keyMethod, parameterValues);
                    }
                });
            } else {
                executeFunction(keyClass, keyMethod, parameterValues);
            }
        } catch (JSONException e) {
            Logger.m11000e(TAG, "receiveMessage error : " + e.toString());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.PresenterContract
    public void remoteFunctionCall(String str, String str2, Object... objArr) {
        try {
            sendMessage(this.mRemoteDataHelper.createJsonByMultiParam(str, str2, objArr));
        } catch (ArrayStoreException | JSONException e) {
            Logger.m11000e(TAG, "sendMessage error : " + e.toString());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.PresenterContract
    public void remoteFunctionSync(String str, String str2, Object... objArr) {
        Method method = this.mRemoteTargetMethodMap.get(str + ":" + str2);
        if (method == null || !isValidSenderType(method)) {
            Logger.m11000e(TAG, "remoteFunctionSync is not available");
            return;
        }
        String receiverFunctionName = getReceiverFunctionName(method);
        if (RemoteConstant.NO_FUNCTION.equals(receiverFunctionName)) {
            receiverFunctionName = getFunctionName(method);
        }
        if (RemoteConstant.NO_FUNCTION.equals(receiverFunctionName)) {
            receiverFunctionName = method.getName();
        }
        AbstractC8014b.m7197C("remoteFunctionSync ", receiverFunctionName, TAG);
        remoteFunctionCall(str, receiverFunctionName, objArr);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.InnerContract
    public void sendMessage(String str) {
        this.mContinuityService.sendMessage(str.getBytes(StandardCharsets.UTF_8));
    }

    public void versionCheck() {
        RemoteVersionCheck remoteVersionCheck = this.mRemoteVersionCheck;
        if (remoteVersionCheck == null) {
            Logger.m11003i(TAG, "version checked already");
        } else {
            remoteVersionCheck.versionCheck();
        }
    }

    public RemoteFunctionPresenter(ContinuityService continuityService, @RemoteConstant.RemoteSenderType int i) {
        this(null, continuityService, i);
    }
}
