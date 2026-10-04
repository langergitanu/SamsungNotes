package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.patternpalette.ViewOnClickListenerC7602a;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.IVerifyPasswordContract;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.VerifyPasswordPresenter;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyPasswordView extends AbsPasswordView implements IVerifyPasswordContract.IView {
    private static final String TAG = LockLogger.createTag("VerifyPasswordView");
    private int mAdditionalInfo;
    private View mProgressView;
    private boolean mShowBiometricRecommendation;
    protected IVerifyPasswordContract.IPresenter mVerifyPresenter;

    public VerifyPasswordView() {
    }

    private ViewGroup getDecorView() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return (ViewGroup) window.getDecorView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideProgress$3() {
        if (this.mProgressView == null || getDecorView() == null) {
            return;
        }
        this.mProgressView.setVisibility(8);
        this.mProgressView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_VERIFY_PASSWORD_SCREEN, LockConstants.SA_LOG_VERIFY_PASSWORD_EVENT_RESET_PASSWORD);
        changeScenario(1);
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showProgress$2() {
        if (this.mProgressView == null) {
            ViewGroup decorView = getDecorView();
            if (decorView == null) {
                return;
            }
            View viewFindViewById = decorView.findViewById(C8003R.id.progress_bar);
            this.mProgressView = viewFindViewById;
            if (viewFindViewById == null) {
                LayoutInflater.from(decorView.getContext()).inflate(C8003R.layout.notes_progress_circle, decorView, true);
                this.mProgressView = decorView.findViewById(C8003R.id.progress_bar);
            }
        }
        View view = this.mProgressView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseView, com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void finishSuccess() {
        resetPasswordBlockingEndTime();
        super.finishSuccess();
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyPasswordContract.IView
    public int getSavedFailCount() {
        return LockPrefUtils.getUnlockTryCount(getContext());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public void hideProgress() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new RunnableC8143h(this, 1));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initBiometricCheckBox() {
        if (!this.mShowBiometricRecommendation || LockPrefUtils.getPrefUseFingerprint(getContext()) || LockPrefUtils.getPrefUseIris(getContext())) {
            this.mUseBiometricsCheckBox.setVisibility(8);
            return;
        }
        if (hasEnrolledFingerprint() && hasEnrolledIris()) {
            this.mUseBiometricsCheckBox.setText(C8003R.string.lock_verify_use_biometrics_next_time);
        } else if (hasEnrolledFingerprint()) {
            this.mUseBiometricsCheckBox.setText(C8003R.string.lock_verify_use_fingerprints_next_time);
        } else if (hasEnrolledIris()) {
            this.mUseBiometricsCheckBox.setText(C8003R.string.lock_verify_use_irises_next_time);
        } else {
            this.mUseBiometricsCheckBox.setVisibility(8);
        }
        this.mUseBiometricsCheckBox.setOnClickListener(new ViewOnClickListenerC7602a(1));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initBottomNavigationMenu(View view) {
        super.initBottomNavigationMenu(view);
        this.mDoneItem.setTitle(C8003R.string.action_done);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initGuideText() {
        if (this.mGuideTextView == null || this.mGuideFingerPrintsChangedTextView == null) {
            return;
        }
        if (this.mGuideInitValue.isEmpty()) {
            this.mGuideTextView.setText(C8003R.string.lock_verify_guide_default);
        } else {
            this.mGuideTextView.setText(this.mGuideInitValue);
            this.mGuideInitValue = "";
        }
        if ((this.mAdditionalInfo & 2) == 2) {
            this.mGuideFingerPrintsChangedTextView.setVisibility(0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initTitle() {
        ActionBar supportActionBar;
        if (getActivity() == null || (supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setTitle(C8003R.string.lock_verify_title);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.mVerifyPresenter == null) {
            VerifyPasswordPresenter verifyPasswordPresenter = new VerifyPasswordPresenter(this);
            this.mVerifyPresenter = verifyPasswordPresenter;
            this.mPresenter = verifyPasswordPresenter;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyPasswordContract.IView
    public void onBlockingTimeChanged(int i) {
        if (getContext() != null) {
            this.mGuideTextView.setText(getContext().getResources().getQuantityString(C8003R.plurals.lock_out_dialog_message, i, Integer.valueOf(i)));
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyPasswordContract.IView
    public void onBlockingTimerEnded() {
        LockLogger.m7356d(TAG, "onBlockingTimerEnded");
        if (getContext() == null) {
            return;
        }
        if (this.mPasswordInputView != null) {
            setPasswordInputViewAccessibility(true);
        }
        initGuideText();
        showSoftInput();
        resetPasswordBlockingEndTime();
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyPasswordContract.IView
    public void onBlockingTimerStarted(long j) {
        LockLogger.m7356d(TAG, "onBlockingTimerStarted");
        if (getContext() == null) {
            return;
        }
        EditText editText = this.mPasswordInputView;
        if (editText != null) {
            editText.setText("");
            setPasswordInputViewAccessibility(false);
        }
        MenuItem menuItem = this.mDoneItem;
        if (menuItem != null) {
            setMenuItemEnabled(menuItem, false);
        }
        LockPrefUtils.setBlockEndTime(getContext(), SystemClock.elapsedRealtime() + j);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void onCancelButtonClicked() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.mDoneItem.setTitle(C8003R.string.action_done);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (viewOnCreateView == null) {
            return getView();
        }
        TextView textView = (TextView) viewOnCreateView.findViewById(C8003R.id.reset_password);
        textView.setVisibility(0);
        textView.setPaintFlags(8);
        textView.setOnClickListener(new ViewOnClickListenerC7538b(this, 27));
        return viewOnCreateView;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LockPrefUtils.setUnlockTryCount(getContext(), this.mVerifyPresenter.getFailCount());
        hideProgress();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public boolean onDoneButtonClicked() {
        LockLogger.m7356d(TAG, "onDoneButtonClicked");
        String passwordText = getPasswordText();
        if (isValidPassword(passwordText)) {
            return this.mVerifyPresenter.verifyPassword(getContext(), passwordText);
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyPasswordContract.IView
    public void setGuideWrongPasswordText() {
        this.mGuideTextView.setText(C8003R.string.lock_verify_incorrect_password);
        resetPasswordInput();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public void showProgress() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new RunnableC8143h(this, 0));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void updateDefaultGuideText() {
        TextView textView = this.mGuideTextView;
        if (textView == null) {
            return;
        }
        textView.setText(getResources().getString(C8003R.string.lock_password_confirm_guide_text));
    }

    public VerifyPasswordView(boolean z, int i) {
        this.mShowBiometricRecommendation = z;
        this.mAdditionalInfo = i;
    }
}
