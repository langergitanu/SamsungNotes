package com.samsung.android.support.senl.p148nt.composer.main.base.model.mde;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfoResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditAdapter {
    private static final String TAG = Logger.createTag("CoeditAdapter");
    private ConnectionCallback mConnectionCallback;
    private boolean mIsCoeditNote;
    private boolean mIsSharedNote;
    private MdeInfoResolver mMdeInfoResolver;
    private List<String> mNoTimeoutPauseCallers;
    private ActionCallbackWrapper mOpenChannelCallback;
    private List<String> mPauseCallers;
    private ActionCallbackWrapper mSnapCallback;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private ICoeditController mCoeditController = new EmptyCoeditController();
    private boolean mIsCoeditEnabled = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActionCallback {
        void onCompleted();

        void onError(String str);

        void onStartOfflineMode(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ActionCallbackWrapper implements ActionCallback {
        private ActionCallback mCallback;
        private Handler mHandler;

        public ActionCallbackWrapper(ActionCallback actionCallback, Handler handler) {
            this.mCallback = actionCallback;
            this.mHandler = handler;
        }

        private void runOnUiThread(final Runnable runnable) {
            if (CommonUtils.isOnMainUIThread()) {
                runnable.run();
            } else {
                this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallbackWrapper.4
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                });
            }
        }

        public void clear() {
            this.mCallback = null;
            this.mHandler = null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
        public void onCompleted() {
            if (this.mCallback == null) {
                return;
            }
            runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallbackWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ActionCallbackWrapper.this.mCallback != null) {
                        ActionCallbackWrapper.this.mCallback.onCompleted();
                        ActionCallbackWrapper.this.clear();
                    }
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
        public void onError(final String str) {
            if (this.mCallback == null) {
                return;
            }
            runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallbackWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ActionCallbackWrapper.this.mCallback != null) {
                        ActionCallbackWrapper.this.mCallback.onError(str);
                        ActionCallbackWrapper.this.clear();
                    }
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallback
        public void onStartOfflineMode(final String str) {
            if (this.mCallback == null) {
                return;
            }
            runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ActionCallbackWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ActionCallbackWrapper.this.mCallback != null) {
                        ActionCallbackWrapper.this.mCallback.onStartOfflineMode(str);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ConnectionCallback {
        void onConnected();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICoeditController {
        void checkDeleteOnlyMode();

        void clearCoeditCallback();

        String getWorkspaceId();

        void internalChannelOpen(SpenWNote spenWNote, ActionCallback actionCallback);

        void internalSnapRefresh();

        void internalSnapRestart(String str, ActionCallback actionCallback, ActionCallback actionCallback2);

        void internalSnapStart(SpenWNote spenWNote, String str, String str2, String str3, ActionCallback actionCallback, CoeditHandlerManager.Contract contract);

        boolean isCoeditMode();

        boolean isWritePermissionGranted();

        int pauseConcurrency(String str, PauseTimeoutCallback pauseTimeoutCallback);

        void readyCoedit(Activity activity, String str);

        void requestReadPermission();

        int resumeConcurrency(String str);

        void saveCoeditCache();

        void trimMemory(int i);

        boolean waitConnection(ConnectionCallback connectionCallback);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PauseTimeoutCallback implements Runnable {
        String mCaller;
        Runnable mCancelAction;

        public PauseTimeoutCallback(String str, Runnable runnable) {
            this.mCaller = str;
            this.mCancelAction = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.m10999d(CoeditAdapter.TAG, "pause caller: " + this.mCaller + " timeout");
            Runnable runnable = this.mCancelAction;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private void clearCallback(String str) {
        if (this.mSnapCallback != null) {
            Logger.m10999d(TAG, str + "# clear snap callback");
            this.mSnapCallback.clear();
            this.mSnapCallback = null;
        }
        if (this.mOpenChannelCallback != null) {
            Logger.m10999d(TAG, str + "# clear channel callback");
            this.mOpenChannelCallback.clear();
            this.mOpenChannelCallback = null;
        }
    }

    private List<String> getNoTimeoutPauseCallers() {
        if (this.mNoTimeoutPauseCallers == null) {
            this.mNoTimeoutPauseCallers = new ArrayList();
        }
        return this.mNoTimeoutPauseCallers;
    }

    private List<String> getPauseCallers() {
        if (this.mPauseCallers == null) {
            this.mPauseCallers = new ArrayList();
        }
        return this.mPauseCallers;
    }

    public void checkDeleteOnlyMode() {
        this.mCoeditController.checkDeleteOnlyMode();
    }

    public void clearCoeditCallback() {
        this.mCoeditController.clearCoeditCallback();
        if (this.mConnectionCallback != null) {
            Logger.m10999d(TAG, "clearCoeditCallback# clear connection callback");
            this.mConnectionCallback = null;
        }
        clearCallback("clearCoeditCallback");
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public String getWorkspaceId() {
        return this.mCoeditController.getWorkspaceId();
    }

    public void internalSnapRefresh() {
        this.mCoeditController.internalSnapRefresh();
    }

    public boolean isCoeditMode() {
        return this.mCoeditController.isCoeditMode();
    }

    public boolean isCoeditNote(String str) {
        return str.startsWith(PredefinedCategory.COEDIT_NOTES.getUuid());
    }

    public boolean isEnabled() {
        return this.mIsCoeditEnabled;
    }

    public boolean isSharedNote(String str) {
        return str.startsWith(PredefinedCategory.SHARED_NOTE_BOOK.getUuid());
    }

    public void openCoeditChannel(SpenWNote spenWNote, ActionCallback actionCallback) {
        ActionCallbackWrapper actionCallbackWrapper = new ActionCallbackWrapper(actionCallback, this.mHandler);
        this.mOpenChannelCallback = actionCallbackWrapper;
        this.mCoeditController.internalChannelOpen(spenWNote, actionCallbackWrapper);
    }

    public int pauseCoedit(String str, Runnable runnable) {
        int iPauseConcurrency = this.mCoeditController.pauseConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.AUTO_RELEASE.COMPOSER_REQUEST, new PauseTimeoutCallback(str, runnable));
        if (iPauseConcurrency == 2 || iPauseConcurrency == 6) {
            getPauseCallers().add(str);
        }
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("pauseCoedit# caller: ", str, " cancelAction: ");
        sbM15l.append(runnable == null ? "null" : "exist");
        sbM15l.append(" ret: ");
        sbM15l.append(iPauseConcurrency);
        Logger.m10999d(str2, sbM15l.toString());
        return iPauseConcurrency;
    }

    public int pauseCoeditNoTimeout(String str) {
        int iPauseConcurrency = this.mCoeditController.pauseConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.COMPOSER_REQUEST, new PauseTimeoutCallback(str, null));
        if (iPauseConcurrency == 2 || iPauseConcurrency == 6) {
            getNoTimeoutPauseCallers().add(str);
        }
        Logger.m10999d(TAG, "pauseCoeditNoTimeout# caller: " + str + " ret: " + iPauseConcurrency);
        return iPauseConcurrency;
    }

    public void readyCoedit(Activity activity, String str) {
        this.mCoeditController.readyCoedit(activity, str);
    }

    public void reopenCoedit(String str, ActionCallback actionCallback, ActionCallback actionCallback2) {
        clearCallback("reopenCoedit");
        this.mSnapCallback = new ActionCallbackWrapper(actionCallback, this.mHandler);
        ActionCallbackWrapper actionCallbackWrapper = new ActionCallbackWrapper(actionCallback2, this.mHandler);
        this.mOpenChannelCallback = actionCallbackWrapper;
        this.mCoeditController.internalSnapRestart(str, this.mSnapCallback, actionCallbackWrapper);
    }

    public void requestServerReadPermission() {
        this.mCoeditController.requestReadPermission();
    }

    public int resumeCoedit(String str) {
        int iResumeConcurrency;
        if (!getPauseCallers().remove(str)) {
            AbstractC8014b.m7196B("resumeCoedit# no exist ", str, TAG);
            return 0;
        }
        if (getPauseCallers().isEmpty()) {
            iResumeConcurrency = this.mCoeditController.resumeConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.AUTO_RELEASE.COMPOSER_REQUEST);
        } else {
            Logger.m10999d(TAG, "resumeCoedit# remain: " + getPauseCallers());
            iResumeConcurrency = 3;
        }
        Logger.m10999d(TAG, "resumeCoedit# " + str + " ret: " + iResumeConcurrency);
        return iResumeConcurrency;
    }

    public int resumeCoeditNoTimeout(String str) {
        if (!getNoTimeoutPauseCallers().remove(str)) {
            AbstractC8014b.m7196B("resumeCoeditNoTimeout# no exist ", str, TAG);
            return 0;
        }
        int iResumeConcurrency = this.mCoeditController.resumeConcurrency(CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.COMPOSER_REQUEST);
        Logger.m10999d(TAG, "resumeCoeditNoTimeout# " + str + " ret: " + iResumeConcurrency);
        return iResumeConcurrency;
    }

    public void saveCoeditCache() {
        this.mCoeditController.saveCoeditCache();
    }

    public void setCoeditController(@NonNull ICoeditController iCoeditController) {
        this.mCoeditController = iCoeditController;
    }

    public void setCoeditEnabled(boolean z) {
        this.mIsCoeditEnabled = z;
    }

    public void setCoeditNote(boolean z) {
        this.mIsCoeditNote = z;
    }

    public void setMdeInfoResolver(MdeInfoResolver mdeInfoResolver) {
        this.mMdeInfoResolver = mdeInfoResolver;
    }

    public void setSharedNote(boolean z) {
        this.mIsSharedNote = z;
    }

    public void snapCoedit(final SpenWNote spenWNote, final String str, final String str2, final String str3, ActionCallback actionCallback, final CoeditHandlerManager.Contract contract) {
        this.mSnapCallback = new ActionCallbackWrapper(actionCallback, this.mHandler);
        if (this.mMdeInfoResolver.isSessionConnected()) {
            this.mCoeditController.internalSnapStart(spenWNote, str, str2, str3, this.mSnapCallback, contract);
        } else {
            this.mMdeInfoResolver.requestConnectSessionAsync(new MdeInfoResolver.ConnectionCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfoResolver.ConnectionCallback
                public void onConnected() {
                    Logger.m10999d(CoeditAdapter.TAG, "snapCoedit# connected session");
                    CoeditAdapter.this.mCoeditController.internalSnapStart(spenWNote, str, str2, str3, CoeditAdapter.this.mSnapCallback, contract);
                }
            });
        }
    }

    public boolean takeServerWritePermission() {
        return this.mCoeditController.isWritePermissionGranted();
    }

    public void trimMemory(int i) {
        this.mCoeditController.trimMemory(i);
    }

    public boolean waitConnection(ConnectionCallback connectionCallback) {
        this.mConnectionCallback = connectionCallback;
        boolean zWaitConnection = this.mCoeditController.waitConnection(new ConnectionCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.CoeditAdapter.ConnectionCallback
            public void onConnected() {
                if (CoeditAdapter.this.mConnectionCallback != null) {
                    CoeditAdapter.this.mConnectionCallback.onConnected();
                    CoeditAdapter.this.mConnectionCallback = null;
                }
            }
        });
        if (!zWaitConnection) {
            this.mConnectionCallback = null;
        }
        return zWaitConnection;
    }

    public boolean isCoeditNote() {
        return this.mIsCoeditNote;
    }

    public boolean isSharedNote() {
        return this.mIsSharedNote;
    }
}
