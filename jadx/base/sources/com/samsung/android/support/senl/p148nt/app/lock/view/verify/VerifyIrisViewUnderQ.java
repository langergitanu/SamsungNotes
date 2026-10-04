package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockDialogUtils;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockToastUtils;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyIrisViewUnderQ extends AbsBaseOldBiometricView {
    private static final String TAG = LockLogger.createTag("VerifyIrisViewUnderQ");
    private TextView mGuideTextView;
    private View mPreview;
    private final IrisApi.OnAuthenticationListener mOnAuthenticationListener = new IrisApi.OnAuthenticationListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyIrisViewUnderQ.1
        @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
        public void onAuthenticationError(int i, CharSequence charSequence) {
            LockLogger.m7356d(VerifyIrisViewUnderQ.TAG, "onAuthenticationError : " + i + SQLKeyword.COMMA + ((Object) charSequence));
            VerifyIrisViewUnderQ.this.setGuideText(charSequence);
            if (VerifyIrisViewUnderQ.this.mIrisApi != null && VerifyIrisViewUnderQ.this.mIrisApi.isRetryCase(i)) {
                VerifyIrisViewUnderQ.this.showRetryDialog(charSequence);
                return;
            }
            if (i == IrisApi.OnAuthenticationListener.ERROR_TIMEOUT) {
                VerifyIrisViewUnderQ.this.finishCancel();
                return;
            }
            if (i == IrisApi.OnAuthenticationListener.ERROR_LOCKOUT) {
                VerifyIrisViewUnderQ.this.onBioAuthenticationLockedOut();
                return;
            }
            if (i == IrisApi.OnAuthenticationListener.ERROR_LOCKOUT_PERMANENT) {
                VerifyIrisViewUnderQ.this.onBioAuthenticationLockOutPermanent(charSequence);
            } else if (i != IrisApi.OnAuthenticationListener.ERROR_CANCELED) {
                VerifyIrisViewUnderQ.this.changeToPasswordVerification(1);
            } else {
                if (VerifyIrisViewUnderQ.this.getIsChangingToPasswordUI()) {
                    return;
                }
                VerifyIrisViewUnderQ.this.finishCancel();
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
        public void onAuthenticationFailed() {
            if (VerifyIrisViewUnderQ.this.mIrisApi != null) {
                VerifyIrisViewUnderQ.this.onBioAuthenticationFailed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyIrisViewUnderQ.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VerifyIrisViewUnderQ verifyIrisViewUnderQ = VerifyIrisViewUnderQ.this;
                        verifyIrisViewUnderQ.showRetryDialog(verifyIrisViewUnderQ.getString(C8003R.string.lock_iris_dialog_no_match));
                    }
                });
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
        public void onAuthenticationHelp(CharSequence charSequence) {
            VerifyIrisViewUnderQ.this.setGuideText(charSequence);
        }

        @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
        public void onAuthenticationSucceeded() {
            LockLogger.m7356d(VerifyIrisViewUnderQ.TAG, "onAuthenticationSuccess");
            if (VerifyIrisViewUnderQ.this.getContext() == null) {
                return;
            }
            LockPrefUtils.setOldBiometricMethodBlockEndTime(VerifyIrisViewUnderQ.this.getContext(), 0L);
            VerifyIrisViewUnderQ.this.finishSuccess();
        }

        @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
        public void onUsePasswordClicked() {
            VerifyIrisViewUnderQ.this.cancelAuthenticate();
            VerifyIrisViewUnderQ.this.changeToPasswordVerification(1);
        }
    };
    private final IrisApi mIrisApi = new IrisApi();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_VERIFY_IRIS_SCREEN, "3221");
        changeToPasswordVerification(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRetryDialog$1(Handler handler, DialogInterface dialogInterface, int i) {
        handler.post(new RunnableC8138c(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRetryDialog$2(Handler handler, DialogInterface dialogInterface, int i) {
        handler.post(new RunnableC8138c(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGuideText(CharSequence charSequence) {
        TextView textView = this.mGuideTextView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRetryDialog(CharSequence charSequence) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        AlertDialog alertDialog = this.mRetryDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            Handler handler = new Handler();
            this.mRetryDialog = LockDialogUtils.showRetryIrisDialogWithError(context, charSequence, new DialogInterfaceOnClickListenerC8139d(this, handler, 0), new DialogInterfaceOnClickListenerC8139d(this, handler, 1));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView
    public void authenticate() {
        if (isPasswordBlocked()) {
            showTimerDialog(((int) getSavedPasswordBlockingTime()) / 1000);
            return;
        }
        if (isOldBiometricBlockedPermanent()) {
            changeToPasswordVerification(1);
            return;
        }
        if (isOldBiometricBlocked()) {
            showTimerDialog(((int) getSavedOldBiometricBlockingTime()) / 1000);
            return;
        }
        if (!this.mIrisApi.hasChangedIris(getContext())) {
            this.mIrisApi.authenticate(getContext(), this.mPreview, this.mOnAuthenticationListener);
            return;
        }
        LockLogger.m7356d(TAG, "iris changed");
        LockToastUtils.showBiometricChangeToast(getContext(), false, true);
        LockPrefUtils.setPrefUseIris(getContext(), false);
        changeToPasswordVerification(1);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView
    public void cancelAuthenticate() {
        IrisApi irisApi = this.mIrisApi;
        if (irisApi != null) {
            irisApi.cancelAuthenticate();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(C8003R.layout.lock_iris, viewGroup, false);
        this.mPreview = viewInflate.findViewById(C8003R.id.iris_preview);
        this.mGuideTextView = (TextView) viewInflate.findViewById(C8003R.id.iris_guide_text);
        viewInflate.findViewById(C8003R.id.use_password).setOnClickListener(new ViewOnClickListenerC7538b(this, 26));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(-1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        cancelAuthenticate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!isBlockedByMultiwindow()) {
            authenticate();
        } else {
            LockToastUtils.showMultiWindowImpossibleToast(getContext());
            exitMultiWindow();
        }
    }
}
