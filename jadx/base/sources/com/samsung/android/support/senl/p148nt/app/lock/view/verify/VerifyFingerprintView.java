package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.IVerifyFingerprintContract;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.VerifyFingerprintPresenter;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockStateUtils;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.view.SprImageView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyFingerprintView extends AbsBaseBiometricView implements IVerifyFingerprintContract.IView {
    private static final int DELAY_MS_GET_FOREGROUND = 200;
    private static final String TAG = LockLogger.createTag("VerifyFingerprintView");
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private TextView mGuideTextView;
    private final IVerifyFingerprintContract.IPresenter mPresenter;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyFingerprintView$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C81281 implements Application.ActivityLifecycleCallbacks {
        public C81281() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityPostResumed$0(Activity activity) {
            VerifyFingerprintView.this.mPresenter.onResume(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            LockLogger.m7356d(VerifyFingerprintView.TAG, "onActivityPaused");
            VerifyFingerprintView.this.cancelAuthenticate();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(@NonNull Activity activity) {
            LockLogger.m7356d(VerifyFingerprintView.TAG, "onActivityPostResumed");
            if (LockStateUtils.isForeground(VerifyFingerprintView.this.getContext(), Process.myUid(), Process.myPid())) {
                VerifyFingerprintView.this.mPresenter.onResume(activity);
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC8136a(activity, 0, this), 200L);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public VerifyFingerprintView() {
        this.mActivityLifecycleCallbacks = new C81281();
        this.mPresenter = new VerifyFingerprintPresenter(this);
    }

    private View createDexView(@NonNull LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(C8003R.layout.lock_dex_dialog_view, (ViewGroup) null);
        ((SprImageView) viewInflate.findViewById(C8003R.id.fingerprint_icon)).setVisibility(0);
        TextView textView = (TextView) viewInflate.findViewById(C8003R.id.dex_guide_text);
        this.mGuideTextView = textView;
        textView.setText(C8003R.string.lock_dex_use_fingerprint);
        ((Button) viewInflate.findViewById(C8003R.id.use_password)).setOnClickListener(new ViewOnClickListenerC7538b(this, 23));
        return viewInflate;
    }

    private boolean isSupportLifecycleCallback() {
        return Build.VERSION.SDK_INT >= 29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createDexView$0(View view) {
        this.mPresenter.cancelAuthenticate();
        CommonSamsungAnalytics.insertLog("322", "3211");
        changeToPasswordVerification(1);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView
    public void authenticate() {
        this.mPresenter.authenticate(getContext());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView
    public void cancelAuthenticate() {
        this.mPresenter.cancelAuthenticate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (isSupportLifecycleCallback()) {
            getActivity().registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(getContext())) {
            LockLogger.m7356d(TAG, "createDexView");
            return createDexView(layoutInflater);
        }
        LockLogger.m7356d(TAG, "emptyView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (isSupportLifecycleCallback()) {
            getActivity().unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isSupportLifecycleCallback()) {
            return;
        }
        cancelAuthenticate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LockLogger.m7356d(TAG, "onResume");
        super.onResume();
        if (isSupportLifecycleCallback()) {
            return;
        }
        this.mPresenter.onResume(getContext());
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyFingerprintContract.IView
    public void setGuideText(CharSequence charSequence) {
        TextView textView = this.mGuideTextView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyFingerprintContract.IView
    public void setGuideText(@StringRes int i) {
        TextView textView = this.mGuideTextView;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public VerifyFingerprintView(AbsBaseBiometricView.PASSWORDTYPE passwordtype) {
        super(passwordtype);
        this.mActivityLifecycleCallbacks = new C81281();
        this.mPresenter = new VerifyFingerprintPresenter(this);
    }
}
