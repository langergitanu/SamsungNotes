package com.samsung.android.support.senl.p148nt.app.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GUIDManager {
    private static final int ACTIVITY_REQUEST_CODE_ACCOUNT_LOG_IN = 117;
    private static final String TAG = "GUIDManager";
    private OnRequestGUIDListener mListener;
    private View mProgressView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.account.GUIDManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C80041 implements IAuthInfoReqListener {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ Runnable val$onError;
        final /* synthetic */ Runnable val$onReceived;
        final /* synthetic */ Runnable val$requestLogin;

        public C80041(Activity activity, Runnable runnable, Runnable runnable2, Runnable runnable3) {
            this.val$activity = activity;
            this.val$onReceived = runnable;
            this.val$requestLogin = runnable2;
            this.val$onError = runnable3;
        }

        private String getErrorMsg(Context context, String str) {
            if (!ErrorCodeConvertor.NETWORK_NOT_AVAILABLE.equals(str)) {
                return context.getString(C8003R.string.cannot_login_samsung_account);
            }
            String string = context.getString(C8003R.string.network_error);
            Activity activity = this.val$activity;
            activity.runOnUiThread(new RunnableC8007b(activity, string, 0));
            return string;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
        public void onError(String str, String str2) {
            AbstractC4539a.m3188B("requestAndWaitGuidReceived# error ", str, GUIDManager.TAG);
            Activity activity = this.val$activity;
            if (activity == null) {
                return;
            }
            GUIDManager.this.hideOverlayProgress(activity);
            if (ErrorCodeConvertor.AUTH_TOKEN_EXPIRED.equals(str)) {
                this.val$activity.runOnUiThread(this.val$requestLogin);
                return;
            }
            String errorMsg = getErrorMsg(this.val$activity, str);
            Activity activity2 = this.val$activity;
            activity2.runOnUiThread(new RunnableC8007b(activity2, errorMsg, 1));
            Runnable runnable = this.val$onError;
            if (runnable != null) {
                this.val$activity.runOnUiThread(runnable);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
        public void onReceived(String str, String str2) {
            Logger.m8697d(GUIDManager.TAG, "requestAndWaitGuidReceived# received");
            GUIDManager.this.hideOverlayProgress(this.val$activity);
            Runnable runnable = this.val$onReceived;
            if (runnable != null) {
                this.val$activity.runOnUiThread(runnable);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnRequestGUIDListener {
        void onFail();

        void onSuccess(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideOverlayProgress(Activity activity) {
        if (activity != null) {
            activity.runOnUiThread(new RunnableC8006a(this, 1));
        }
    }

    private void inflateProgressView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View viewFindViewById = viewGroup.findViewById(C8003R.id.progress_bar);
        this.mProgressView = viewFindViewById;
        if (viewFindViewById == null) {
            LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_progress_circle, viewGroup, true);
            this.mProgressView = viewGroup.findViewById(C8003R.id.progress_bar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideOverlayProgress$4() {
        View view = this.mProgressView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAndWaitGuidReceived$0() {
        this.mListener.onSuccess(C13541h.m14287e().m14294h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAndWaitGuidReceived$1() {
        this.mListener.onFail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showOverlayProgress$3() {
        View view = this.mProgressView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: requestAccountLogin, reason: merged with bridge method [inline-methods] */
    public void lambda$requestAndWaitGuidReceived$2(Activity activity) {
        Logger.m8697d(TAG, "requestAccountLogin");
        ToastHandler.show(activity, CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.need_login_first_jpn : C8003R.string.need_login_first, 1);
        AccountHelper.loginPopupSamsungAccount(activity, 117);
    }

    private void requestAndWaitGuidReceived(Activity activity) {
        Logger.m8697d(TAG, "requestAndWaitGuidReceived");
        requestAndWaitGuidReceived(activity, new RunnableC8006a(this, 2), new RunnableC8006a(this, 3), new RunnableC8007b(this, activity));
    }

    private void showOverlayProgress(Activity activity) {
        if (this.mProgressView == null) {
            inflateProgressView(activity);
        }
        if (activity != null) {
            activity.runOnUiThread(new RunnableC8006a(this, 0));
        }
    }

    public boolean isGuidReceived(Context context) {
        return !TextUtils.isEmpty(C13541h.m14287e().m14294h());
    }

    public void onActivityResult(Activity activity, int i, int i2, @Nullable Intent intent) {
        Logger.m8697d(TAG, "onActivityResult requestCode/resultCode " + i + "/" + i2);
        if (i == 117) {
            if (i2 == -1) {
                requestAndWaitGuidReceived(activity);
            } else {
                this.mListener.onFail();
            }
        }
    }

    public void requestGUID(Activity activity, OnRequestGUIDListener onRequestGUIDListener) {
        Logger.m8697d(TAG, "requestGUID");
        this.mListener = onRequestGUIDListener;
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            lambda$requestAndWaitGuidReceived$2(activity);
        } else if (isGuidReceived(activity)) {
            onRequestGUIDListener.onSuccess(C13541h.m14287e().m14294h());
        } else {
            requestAndWaitGuidReceived(activity);
        }
    }

    private void requestAndWaitGuidReceived(Activity activity, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        Logger.m8697d(TAG, "requestAndWaitGuidReceived");
        showOverlayProgress(activity);
        C13541h.m14287e().m14295i(new C80041(activity, runnable, runnable3, runnable2));
    }
}
