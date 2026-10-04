package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.spr.drawable.Spr;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyFingerprintViewUnderP extends AbsBaseOldBiometricView {
    private static final String TAG = LockLogger.createTag("VerifyFingerprintViewUnderP");
    private ImageView mFingerGuideImage;
    private TextView mGuideTextView;
    private boolean mIsCanceledByManually;
    private final FingerprintApi.OnAuthenticationListener mApiListener = new FingerprintApi.OnAuthenticationListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyFingerprintViewUnderP.1
        @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
        public void onAuthenticationError(int i, CharSequence charSequence) {
            VerifyFingerprintViewUnderP.this.setGuideText(charSequence);
            if (i == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_LOCKOUT) {
                VerifyFingerprintViewUnderP.this.onBioAuthenticationLockedOut();
                return;
            }
            if (i == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_LOCKOUT_PERMANENT) {
                VerifyFingerprintViewUnderP.this.onBioAuthenticationLockOutPermanent(charSequence);
                return;
            }
            if (i != FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_CANCELED && i != FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_USER_CANCELED) {
                VerifyFingerprintViewUnderP.this.changeToPasswordVerification(1);
            } else {
                if (VerifyFingerprintViewUnderP.this.getIsChangingToPasswordUI() || VerifyFingerprintViewUnderP.this.mIsCanceledByManually) {
                    return;
                }
                VerifyFingerprintViewUnderP.this.finishCancel();
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
        public void onAuthenticationFailed() {
            VerifyFingerprintViewUnderP.this.onBioAuthenticationFailed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyFingerprintViewUnderP.1.1
                @Override // java.lang.Runnable
                public void run() {
                    VerifyFingerprintViewUnderP.this.setGuideText(C8003R.string.lock_fingerprint_no_match);
                    VerifyFingerprintViewUnderP.this.setGuideImage(C8003R.drawable.lock_fingerprint_no_match);
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
        public void onAuthenticationHelp(CharSequence charSequence) {
            VerifyFingerprintViewUnderP.this.setGuideText(charSequence);
        }

        @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
        public void onAuthenticationSucceeded() {
            LockLogger.m7356d(VerifyFingerprintViewUnderP.TAG, "onAuthenticationSuccess");
            if (VerifyFingerprintViewUnderP.this.getContext() == null) {
                return;
            }
            LockPrefUtils.setOldBiometricMethodBlockEndTime(VerifyFingerprintViewUnderP.this.getContext(), 0L);
            VerifyFingerprintViewUnderP.this.finishSuccess();
        }

        @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
        public void onUsePasswordClicked() {
        }
    };
    private final FingerprintApi mFingerprintApi = new FingerprintApi(FingerprintApi.ImplType.FINGERPRINT_MANAGER);

    private View createDefaultView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(C8003R.layout.lock_fingerprint, viewGroup, false);
        this.mGuideTextView = (TextView) viewInflate.findViewById(C8003R.id.finger_guide_text);
        this.mFingerGuideImage = (ImageView) viewInflate.findViewById(C8003R.id.finger_image);
        viewInflate.findViewById(C8003R.id.use_password).setOnClickListener(new ViewOnClickListenerC7538b(this, 24));
        setGuideImage(C8003R.drawable.lock_fingerprint_default);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createDefaultView$0(View view) {
        CommonSamsungAnalytics.insertLog("322", "3211");
        changeToPasswordVerification(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGuideImage(int i) {
        ImageView imageView;
        if (getContext() == null || (imageView = this.mFingerGuideImage) == null) {
            return;
        }
        imageView.setImageDrawable(Spr.getDrawable(getContext().getResources(), i, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGuideText(CharSequence charSequence) {
        TextView textView = this.mGuideTextView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView
    public void authenticate() {
        if (this.mFingerprintApi == null || getContext() == null) {
            return;
        }
        this.mIsCanceledByManually = false;
        this.mFingerprintApi.authenticate(getContext(), this.mApiListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseOldBiometricView
    public void cancelAuthenticate() {
        FingerprintApi fingerprintApi = this.mFingerprintApi;
        if (fingerprintApi != null) {
            this.mIsCanceledByManually = true;
            fingerprintApi.cancelAuthenticate();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return createDefaultView(layoutInflater, viewGroup);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getContext() == null) {
            return;
        }
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
        } else {
            if (!this.mFingerprintApi.hasChangedFingerprint(getContext())) {
                authenticate();
                return;
            }
            LockLogger.m7356d(TAG, "fingerprint changed");
            LockPrefUtils.setPrefUseFingerprint(getContext(), false);
            changeToPasswordVerification(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGuideText(@StringRes int i) {
        TextView textView = this.mGuideTextView;
        if (textView != null) {
            textView.setText(i);
        }
    }
}
