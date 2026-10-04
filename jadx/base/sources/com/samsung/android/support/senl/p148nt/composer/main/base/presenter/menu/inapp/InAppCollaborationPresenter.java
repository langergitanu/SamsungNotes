package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServerManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityState;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.ContinuityConstant;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.inapp.model.NearbyMyDevices;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InAppCollaborationPresenter extends BaseInAppPresenter {
    public static final int DELAY_SHOW_TOOLBAR = 600;
    private static final String KEY_NIGHT_MODE = "key_night_mode";
    private static final int MSG_DISCONNECT = 1;
    private static final int SCREEN_OFF_TIMEOUT = 5000;
    private static final String TAG = "InAppCollaborationPresenter";
    private static final int WINDOW_MODE_INVALID = -1;
    private Activity mActivity;
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private ControllerManager mControllerManager;
    private HwToolbarPresenter mHwToolbarPresenter;
    private OptionMenuPresenter mOptionMenuPresenter;
    private QuickToolPresenter mQuickToolPresenter;
    private RemoteFunctionPresenter mRemoteFunctionPresenter;
    private RemoteInAppPresenter mRemoteInAppPresenter;
    private RtToolbarPresenter mRtToolbarPresenter;
    private BroadcastReceiver mScreenOffReceiver;
    private ToolbarPresenter mToolbarPresenter;
    private final Handler mInAppUIHandler = new Handler(Looper.getMainLooper());
    private final Handler mConnectionTimeOutHandler = new ConnectionTimeOutHandler(this, 0);
    private Object mTargetComposer = new NullObject();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C97701 implements ContinuityServiceManager.ContinuityActionContract {
        public C97701() {
        }

        private void showToast(final String str) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter.1.3
                @Override // java.lang.Runnable
                public void run() {
                    ToastHandler.show(InAppCollaborationPresenter.this.mActivity, str, 0);
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityActionContract
        public void closedInAppCollaboration() {
            InAppLogger.m8595d(InAppCollaborationPresenter.TAG, "closedInAppCollaboration");
            ContinuityServerManager.getInstance().initTargetComposer();
            InAppCollaborationPresenter.this.setIsInAppCollaborationMode(false);
            if (InAppCollaborationPresenter.this.mOptionMenuPresenter.replaceInAppMenuToProgress(false)) {
                showToast(InAppCollaborationPresenter.this.mActivity.getResources().getString(C9086R.string.in_app_connect_fail));
            }
            InAppCollaborationPresenter.this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter.1.2
                @Override // java.lang.Runnable
                public void run() {
                    InAppCollaborationPresenter.this.mHwToolbarPresenter.restoreFromRemoteTypePresenter();
                    InAppCollaborationPresenter.this.mRtToolbarPresenter.restoreFromRemoteTypePresenter();
                }
            });
            InAppCollaborationPresenter.this.mRemoteFunctionPresenter = null;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityActionContract
        public void messageReceived(@NonNull byte[] bArr) {
            if (InAppCollaborationPresenter.this.mRemoteFunctionPresenter == null) {
                InAppLogger.m8595d(InAppCollaborationPresenter.TAG, "RemoteFunctionPresenter is null");
                return;
            }
            String str = new String(bArr, StandardCharsets.UTF_8);
            InAppLogger.m8598i(InAppCollaborationPresenter.TAG, "messageReceived : ".concat(str));
            InAppCollaborationPresenter.this.mRemoteFunctionPresenter.receiveMessage(str);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityServiceContract
        public void onServiceConnected() {
            ContinuityServerManager.getInstance().startDiscovery(new NearbyMyDevices.ContinuityMenuContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter.1.1
                @Override // com.samsung.android.support.senl.nt.base.common.inapp.model.NearbyMyDevices.ContinuityMenuContract
                public void onReleaseDim() {
                    if (InAppCollaborationPresenter.this.mControllerManager.getViewState().isResumed()) {
                        ContinuityServerManager.getInstance().sendMessage(ContinuityConstant.DIM_RELEASE.getBytes(StandardCharsets.UTF_8));
                    }
                }

                @Override // com.samsung.android.support.senl.nt.base.common.inapp.model.NearbyMyDevices.ContinuityMenuContract
                public void onUpdateDeviceListDialog() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter.1.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InAppCollaborationPresenter.this.mOptionMenuPresenter != null) {
                                InAppCollaborationPresenter.this.mOptionMenuPresenter.hideInAppDeviceListDialog();
                            }
                        }
                    });
                }

                @Override // com.samsung.android.support.senl.nt.base.common.inapp.model.NearbyMyDevices.ContinuityMenuContract
                public void onUpdateMenuVisibility() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InAppCollaborationPresenter.this.mOptionMenuPresenter != null) {
                                InAppCollaborationPresenter.this.mOptionMenuPresenter.invalidateOptionsMenu();
                            }
                        }
                    });
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityServiceContract
        public void onServiceDisconnected() {
            InAppCollaborationPresenter.this.setIsInAppCollaborationMode(false);
            ContinuityServerManager.getInstance().initTargetComposer();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.inapp.ContinuityServiceManager.ContinuityActionContract
        public void readyToInAppCollaboration() {
            ContinuityServerManager.getInstance().setTargetComposer(InAppCollaborationPresenter.this.mTargetComposer.hashCode());
            InAppCollaborationPresenter.this.mOptionMenuPresenter.replaceInAppMenuToProgress(false);
            InAppCollaborationPresenter.this.setIsInAppCollaborationMode(true);
            if (InAppCollaborationPresenter.this.mRemoteFunctionPresenter == null) {
                InAppCollaborationPresenter.this.mRemoteFunctionPresenter = new RemoteFunctionPresenter(InAppCollaborationPresenter.this.mActivity, ContinuityServerManager.getInstance(), 4);
            }
            InAppCollaborationPresenter.this.mRemoteFunctionPresenter.addRemoteTargetClass(InAppCollaborationPresenter.this.mHwToolbarPresenter.convertToRemoteTypePresenter(InAppCollaborationPresenter.this.mRemoteFunctionPresenter));
            InAppCollaborationPresenter.this.mRemoteFunctionPresenter.addRemoteTargetClass(InAppCollaborationPresenter.this.mRtToolbarPresenter.convertToRemoteTypePresenter(InAppCollaborationPresenter.this.mRemoteFunctionPresenter));
            InAppCollaborationPresenter inAppCollaborationPresenter = InAppCollaborationPresenter.this;
            inAppCollaborationPresenter.mRemoteInAppPresenter = new RemoteInAppPresenter(inAppCollaborationPresenter.mRemoteFunctionPresenter);
            InAppCollaborationPresenter.this.mRemoteFunctionPresenter.addRemoteTargetClass(InAppCollaborationPresenter.this.mRemoteInAppPresenter);
            InAppCollaborationPresenter.this.mRemoteFunctionPresenter.versionCheck();
            InAppCollaborationPresenter.this.enableCustomToolbarSettingMenu(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ConnectionTimeOutHandler extends Handler {
        public /* synthetic */ ConnectionTimeOutHandler(InAppCollaborationPresenter inAppCollaborationPresenter, int i) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            InAppLogger.m8595d(InAppCollaborationPresenter.TAG, "handleMessage# " + message.what);
            if (message.what == 1) {
                InAppLogger.m8595d(InAppCollaborationPresenter.TAG, "MSG_DISCONNECT");
                InAppCollaborationPresenter.this.closeInAppCollaboration();
            }
        }

        private ConnectionTimeOutHandler() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NullObject {
        public int hashCode() {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean closeInAppCollaboration() {
        ComposerModel composerModel;
        InAppLogger.m8595d(TAG, "closeInAppCollaboration");
        if (isEnabledInAppCollaboration() && ((composerModel = this.mComposerModel) == null || composerModel.getComposerState().isInAppCollaborationMode())) {
            ContinuityServerManager.getInstance().closeInAppCollaboration();
            return true;
        }
        OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
        if (optionMenuPresenter != null && optionMenuPresenter.replaceInAppMenuToProgress(false)) {
            InAppLogger.m8595d(TAG, "closeInAppCollaboration# canceled, need to close session");
            ContinuityServerManager.getInstance().closeSession();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableCustomToolbarSettingMenu(boolean z) {
        this.mHwToolbarPresenter.enableMenus(z, Collections.singletonList(8388608));
    }

    private boolean isTopActivity() {
        boolean z = this.mActivity != null && AppTaskCompat.getInstance().isEqualTopActivity(this.mActivity.getApplicationContext(), this.mActivity.getTaskId(), this.mActivity.getClass().getName());
        StringBuilder sbM3200j = AbstractC4539a.m3200j("isTopActivity# ", ", hashCode : ", z);
        sbM3200j.append(this.mTargetComposer.hashCode());
        InAppLogger.m8595d(TAG, sbM3200j.toString());
        return z;
    }

    private boolean needToChangeTarget(int i) {
        if (i == -1) {
            i = WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity);
        }
        boolean z = i == 0;
        boolean zIsTopActivity = isTopActivity();
        boolean zHasTargetComposer = ContinuityServerManager.getInstance().hasTargetComposer();
        boolean zIsTargetComposer = ContinuityServerManager.getInstance().isTargetComposer(this.mTargetComposer.hashCode());
        StringBuilder sbM2230u = AbstractC2821a.m2230u("needToChangeTarget# isFullScreen : ", ", isTopActivity : ", ", hasTargetActivity : ", z, zIsTopActivity);
        AbstractC2821a.m2208C(sbM2230u, zHasTargetComposer, ", isTargetActivity : ", zIsTargetComposer, ", this hashCode : ");
        sbM2230u.append(this.mTargetComposer.hashCode());
        InAppLogger.m8595d(TAG, sbM2230u.toString());
        if (!z || !zIsTopActivity || !zHasTargetComposer || zIsTargetComposer) {
            return false;
        }
        if (ContinuityServerManager.getInstance().getContinuityState() == ContinuityState.PEER_CONNECTED) {
            InAppLogger.m8595d(TAG, "needToChangeTarget# disconnect > connect");
            ContinuityServerManager.getInstance().closeInAppCollaboration();
        }
        return true;
    }

    private void registerScreenOffReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                    InAppLogger.m8596e(InAppCollaborationPresenter.TAG, "ScreenOffReceiver# onReceive error");
                    return;
                }
                InAppLogger.m8595d(InAppCollaborationPresenter.TAG, "ScreenOffReceiver# onReceive");
                InAppCollaborationPresenter.this.mConnectionTimeOutHandler.removeMessages(1);
                InAppLogger.m8595d(InAppCollaborationPresenter.TAG, "ScreenOffReceiver# send message successfully : " + InAppCollaborationPresenter.this.mConnectionTimeOutHandler.sendEmptyMessageDelayed(1, 5000L));
            }
        };
        this.mScreenOffReceiver = broadcastReceiver;
        this.mActivity.registerReceiver(broadcastReceiver, intentFilter);
    }

    private void releaseServiceContract() {
        InAppLogger.m8595d(TAG, "releaseServiceContract");
        ContinuityServerManager.getInstance().setActionContract(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisableHandoff(boolean z) {
        InAppLogger.m8595d(TAG, "setDisableHandoff# disabled : " + z);
        if (z) {
            this.mComposerViewPresenter.getHandoffManager().disableHandoffTemporary();
            this.mComposerViewPresenter.getHandoffManager().setDisabled(true);
        } else {
            this.mComposerViewPresenter.getHandoffManager().setDisabled(false);
            this.mComposerViewPresenter.getHandoffManager().sendHandoffData();
        }
    }

    private void setServiceContract() {
        InAppLogger.m8595d(TAG, "setServiceContract");
        ContinuityServerManager.getInstance().setActionContract(new C97701());
    }

    private void unregisterScreenOffReceiver() {
        try {
            this.mActivity.unregisterReceiver(this.mScreenOffReceiver);
        } catch (Exception e) {
            InAppLogger.m8596e(TAG, "unregisterScreenOffReceiver# " + e.getMessage());
        } finally {
            this.mScreenOffReceiver = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void connect() {
        if (ContinuityServerManager.getInstance().getContinuityState() == ContinuityState.CONNECTED || ContinuityServerManager.getInstance().getTargetComposerSize() != 1) {
            return;
        }
        setServiceContract();
        ContinuityServerManager.getInstance().connect(this.mActivity.getApplicationContext());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void disconnect() {
        if (this.mActivity != null && ContinuityServerManager.getInstance().getContinuityState() != ContinuityState.DISCONNECTED && ContinuityServerManager.getInstance().getTargetComposerSize() == 0) {
            ContinuityServerManager.getInstance().disconnect(this.mActivity.getApplicationContext());
            ContinuityServerManager.getInstance().release(this.mActivity.getApplicationContext());
        }
        releaseServiceContract();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void init(ComposerViewPresenter composerViewPresenter, OptionMenuPresenter optionMenuPresenter, HwToolbarPresenter hwToolbarPresenter, RtToolbarPresenter rtToolbarPresenter, ToolbarPresenter toolbarPresenter, ControllerManager controllerManager, QuickToolPresenter quickToolPresenter) {
        InAppLogger.m8595d(TAG, "init");
        this.mComposerViewPresenter = composerViewPresenter;
        this.mOptionMenuPresenter = optionMenuPresenter;
        this.mToolbarPresenter = toolbarPresenter;
        this.mHwToolbarPresenter = hwToolbarPresenter;
        this.mQuickToolPresenter = quickToolPresenter;
        this.mRtToolbarPresenter = rtToolbarPresenter;
        this.mControllerManager = controllerManager;
        this.mComposerModel = composerViewPresenter.getComposerModel();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public boolean isEnabledInAppCollaboration() {
        if (!ContinuityServerManager.getInstance().hasNearbyMyDevices().booleanValue()) {
            InAppLogger.m8595d(TAG, "isEnabledInAppCollaboration# hasNearbyDevice empty");
            return false;
        }
        if (!FeatureInfo.isShowOptionToMovePenToolsEnabled()) {
            InAppLogger.m8595d(TAG, "isEnabledInAppCollaboration# settingOption disabled");
            return false;
        }
        InAppLogger.m8595d(TAG, "isEnabledInAppCollaboration# true, this hashCode : " + this.mTargetComposer.hashCode());
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public boolean isRestrictedInAppCollaboration() {
        boolean zIsTabletLayout = ResourceUtils.isTabletLayout(this.mActivity);
        boolean z = !zIsTabletLayout;
        boolean z2 = WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity) != 0;
        boolean zIsNightMode = ContextUtils.isNightMode(this.mActivity);
        boolean zIsPDFReader = this.mOptionMenuPresenter.isPDFReader();
        boolean zIsShowOptionToMovePenToolsEnabled = FeatureInfo.isShowOptionToMovePenToolsEnabled();
        boolean zIsPeerConnected = ContinuityServerManager.getInstance().isPeerConnected();
        boolean zIsReadOnlyMode = this.mOptionMenuPresenter.isReadOnlyMode();
        boolean zIsCoeditNote = this.mComposerModel.getCoeditAdapter().isCoeditNote();
        StringBuilder sbM2230u = AbstractC2821a.m2230u("isRestrictedInAppCollaboration# / notTabletLayout : ", " / multiWindow : ", " / nightMode : ", z, z2);
        AbstractC2821a.m2208C(sbM2230u, zIsNightMode, " / pdfReader : ", zIsPDFReader, " / readMode : ");
        AbstractC2821a.m2208C(sbM2230u, zIsReadOnlyMode, " / settingDisabled : ", !zIsShowOptionToMovePenToolsEnabled, "/ connecting : ");
        AbstractC2821a.m2208C(sbM2230u, zIsPeerConnected, " / isCoeditNote : ", zIsCoeditNote, ", this hashCode : ");
        sbM2230u.append(this.mTargetComposer.hashCode());
        InAppLogger.m8595d(TAG, sbM2230u.toString());
        return !zIsTabletLayout || z2 || zIsNightMode || zIsPDFReader || zIsReadOnlyMode || !zIsShowOptionToMovePenToolsEnabled || zIsPeerConnected || zIsCoeditNote;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void onActivityCreated(@NonNull Activity activity, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        InAppLogger.m8595d(TAG, "onActivityCreated, this hashCode : " + fragment.hashCode());
        this.mActivity = activity;
        this.mTargetComposer = activity;
        if (bundle == null) {
            ContinuityServerManager.getInstance().addTargetComposer(this.mTargetComposer.hashCode());
            connect();
            registerScreenOffReceiver();
            return;
        }
        String string = bundle.getString(KEY_NIGHT_MODE, "");
        if (ContinuityConstant.NIGHT_MODE_OFF.equals(string) && ContextUtils.isNightMode(this.mActivity)) {
            ContinuityServerManager.getInstance().sendMessage(ContinuityConstant.NIGHT_MODE_ON.getBytes(StandardCharsets.UTF_8));
        } else {
            if (!ContinuityConstant.NIGHT_MODE_ON.equals(string) || ContextUtils.isNightMode(this.mActivity)) {
                return;
            }
            ContinuityServerManager.getInstance().sendMessage(ContinuityConstant.NIGHT_MODE_OFF.getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void onAttachView(Activity activity) {
        this.mActivity = activity;
        InAppLogger.m8595d(TAG, "onAttachView, this hashCode : " + this.mTargetComposer.hashCode());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public boolean onBackPressed() {
        InAppLogger.m8595d(TAG, "onBackPressed#");
        return closeInAppCollaboration();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void onDestroy() {
        if (this.mActivity == null) {
            return;
        }
        InAppLogger.m8595d(TAG, "onDestroy, this hashCode : " + this.mTargetComposer.hashCode());
        ContinuityServerManager.getInstance().removeTargetComposer(this.mTargetComposer.hashCode());
        disconnect();
        unregisterScreenOffReceiver();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void onDetachView() {
        InAppLogger.m8595d(TAG, "onDetachView, this hashCode : " + this.mTargetComposer.hashCode());
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.InAppContract
    public void onInAppCollaborationCloseButtonClicked() {
        closeInAppCollaboration();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void onPause() {
        InAppLogger.m8595d(TAG, "onPause#, this hashCode : " + this.mTargetComposer.hashCode());
        if (isEnabledInAppCollaboration() && ContinuityServerManager.getInstance().isTargetComposer(this.mTargetComposer.hashCode())) {
            InAppLogger.m8595d(TAG, "onPause# dim set");
            ContinuityServerManager.getInstance().sendMessage(ContinuityConstant.DIM_SET.getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void onResume() {
        InAppLogger.m8595d(TAG, "onResume#, this hashCode : " + this.mTargetComposer.hashCode());
        this.mConnectionTimeOutHandler.removeMessages(1);
        if (!needToChangeTarget(-1) && isEnabledInAppCollaboration() && ContinuityServerManager.getInstance().isTargetComposer(this.mTargetComposer.hashCode())) {
            InAppLogger.m8595d(TAG, "onResume# dim release");
            ContinuityServerManager.getInstance().sendMessage(ContinuityConstant.DIM_RELEASE.getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putString(KEY_NIGHT_MODE, ContextUtils.isNightMode(this.mActivity) ? ContinuityConstant.NIGHT_MODE_ON : ContinuityConstant.NIGHT_MODE_OFF);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void onWindowModeChanged(int i) {
        InAppLogger.m8595d(TAG, "onWindowModeChanged# windowMode : " + i);
        if (needToChangeTarget(i)) {
            return;
        }
        OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
        if (optionMenuPresenter != null) {
            optionMenuPresenter.hideInAppDeviceListDialog();
        }
        if (isEnabledInAppCollaboration() && i != 0 && ContinuityServerManager.getInstance().closeInAppCollaboration()) {
            InAppLogger.m8595d(TAG, "onWindowModeChanged# multi window is not supported");
            ToastHandler.show(this.mActivity.getApplicationContext(), this.mActivity.getResources().getString(C9086R.string.in_app_cannot_use_multi_window_toast), 0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void setIsInAppCollaborationMode(final boolean z) {
        if (this.mComposerModel.getComposerState().isInAppCollaborationMode() == z) {
            return;
        }
        this.mComposerModel.getComposerState().setIsInAppCollaborationMode(z);
        this.mInAppUIHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zIsEditMode = InAppCollaborationPresenter.this.mComposerModel.getModeManager().isEditMode();
                InAppLogger.m8595d(InAppCollaborationPresenter.TAG, "enableInAppCollaborationMode# isInAppCollaborationMode: " + z + " isEditMode: " + zIsEditMode);
                InAppCollaborationPresenter.this.mComposerViewPresenter.onInAppCollaborationModeChanged(z);
                InAppCollaborationPresenter.this.setDisableHandoff(z);
                if (zIsEditMode) {
                    if (!z) {
                        new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                InAppCollaborationPresenter.this.mQuickToolPresenter.setVisibility(0);
                                if (!InAppCollaborationPresenter.this.mToolbarPresenter.isToolbarShowing()) {
                                    InAppCollaborationPresenter.this.mToolbarPresenter.show(true);
                                }
                                InAppCollaborationPresenter.this.enableCustomToolbarSettingMenu(true);
                            }
                        }, 600L);
                        return;
                    }
                    InAppCollaborationPresenter.this.mQuickToolPresenter.setVisibility(8);
                    InAppCollaborationPresenter.this.mToolbarPresenter.hide(true);
                    ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER);
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter
    public void startInAppCollaboration(String str) {
        if (isEnabledInAppCollaboration()) {
            setServiceContract();
            this.mOptionMenuPresenter.replaceInAppMenuToProgress(true);
            if (ContinuityServerManager.getInstance().startInAppCollaboration(str)) {
                return;
            }
            this.mOptionMenuPresenter.replaceInAppMenuToProgress(false);
            Activity activity = this.mActivity;
            ToastHandler.show(activity, activity.getResources().getString(C9086R.string.in_app_connect_fail), 1);
        }
    }
}
