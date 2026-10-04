package com.samsung.android.support.senl.p148nt.app.lock.view.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.create.CreatePasswordPresenter;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.create.ICreateContract;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CreatePasswordView extends AbsPasswordView implements ICreateContract.IView {
    private static final int ACTIVITY_REQUEST_CODE_SAMSUNG_ACCOUNT = 1;
    private static final int PERMISSION_REQUEST_CODE_ACCOUNT = 1;
    private static final String TAG = LockLogger.createTag("CreatePasswordView");
    private ICreateContract.IPresenter mCreatePresenter;
    private String mFirstInputPassword;
    private Mode mMode;
    private boolean mNeedSamsungAccountCheck;
    private View mRootView;
    private int mTitleStringId;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.create.CreatePasswordView$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C81262 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$app$lock$view$create$CreatePasswordView$Mode */
        static final /* synthetic */ int[] f6124xe070650d;

        static {
            int[] iArr = new int[Mode.values().length];
            f6124xe070650d = iArr;
            try {
                iArr[Mode.CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6124xe070650d[Mode.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Mode {
        CREATE,
        CHANGE
    }

    public CreatePasswordView() {
        this.mTitleStringId = 0;
    }

    private void checkSamsungAccount() {
        loginSamsungAccount(1);
        this.mNeedSamsungAccountCheck = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initBiometricCheckBox$0(CompoundButton compoundButton, boolean z) {
        CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_CREATE_PASSWORD_SCREEN, LockConstants.SA_LOG_CREATE_PASSWORD_EVENT_BIOMETRICS, z ? 1 : 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initBiometricCheckBox() {
        if (LockPrefUtils.getPrefUseFingerprint(getContext()) || LockPrefUtils.getPrefUseIris(getContext())) {
            this.mUseBiometricsCheckBox.setVisibility(8);
            return;
        }
        if (hasEnrolledFingerprint() && hasEnrolledIris()) {
            this.mUseBiometricsCheckBox.setText(C8003R.string.lock_create_use_finger_and_iris);
        } else if (hasEnrolledFingerprint()) {
            this.mUseBiometricsCheckBox.setText(C8003R.string.lock_create_use_fingerprint);
        } else if (hasEnrolledIris()) {
            this.mUseBiometricsCheckBox.setText(C8003R.string.lock_create_use_iris);
        } else {
            this.mUseBiometricsCheckBox.setVisibility(8);
        }
        this.mUseBiometricsCheckBox.setOnCheckedChangeListener(new C8127a(0));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initBottomNavigationMenu(View view) {
        super.initBottomNavigationMenu(view);
        if (this.mIsConfirmPassword) {
            this.mDoneItem.setTitle(C8003R.string.action_done);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initGuideText() {
        if (!this.mGuideInitValue.isEmpty()) {
            this.mGuideTextView.setText(this.mGuideInitValue);
            this.mGuideInitValue = "";
        } else if (LockUtils.isSetPassword(getContext())) {
            this.mGuideTextView.setText(getResources().getQuantityString(C8003R.plurals.lock_create_guide_default_new_password, 4, 4));
        } else {
            this.mGuideTextView.setText(getResources().getQuantityString(C8003R.plurals.lock_create_guide_default, 4, 4));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initTitle() {
        ActionBar supportActionBar;
        if (getActivity() == null || (supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setTitle(this.mTitleStringId);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        LockLogger.m7356d(TAG, "onActivityResult request/result : " + i + "/" + i2);
        if (i == 1) {
            if (i2 != -1) {
                finishCancel();
                return;
            }
            this.mPasswordInputView.setFocusable(true);
            this.mPasswordInputView.setFocusableInTouchMode(true);
            this.mNeedSamsungAccountCheck = false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.mCreatePresenter == null) {
            CreatePasswordPresenter createPasswordPresenter = new CreatePasswordPresenter(this);
            this.mCreatePresenter = createPasswordPresenter;
            this.mPresenter = createPasswordPresenter;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void onCancelButtonClicked() {
        if (this.mMode == Mode.CREATE) {
            CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_CREATE_PASSWORD_SCREEN, LockConstants.SA_LOG_CREATE_PASSWORD_EVENT_CANCEL);
        } else {
            CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_CHANGE_PASSWORD_SCREEN, LockConstants.SA_LOG_CHANGE_PASSWORD_EVENT_CANCEL);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mRootView = viewOnCreateView;
        if (viewOnCreateView == null) {
            return getView();
        }
        if (this.mNeedSamsungAccountCheck) {
            this.mPasswordInputView.setFocusable(false);
        }
        if (PermissionHelper.isPermissionGranted(getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.lock.view.create.CreatePasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbsPasswordView) CreatePasswordView.this).mPasswordInputView.setEnabled(false);
                CreatePasswordView.this.mRootView.setVisibility(4);
                PermissionHelper.requestPermissions((Fragment) CreatePasswordView.this, 1, true, "android.permission.GET_ACCOUNTS");
            }
        }, "android.permission.GET_ACCOUNTS") && this.mNeedSamsungAccountCheck) {
            checkSamsungAccount();
        }
        return this.mRootView;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public boolean onDoneButtonClicked() {
        if (this.mMode == Mode.CREATE) {
            CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_CREATE_PASSWORD_SCREEN, LockConstants.SA_LOG_CREATE_PASSWORD_EVENT_DONE);
        } else {
            CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_CHANGE_PASSWORD_SCREEN, LockConstants.SA_LOG_CHANGE_PASSWORD_EVENT_CONTINUE);
        }
        String passwordText = getPasswordText();
        if (!isValidPassword(passwordText)) {
            this.mFirstInputPassword = null;
            resetPasswordInput();
            return false;
        }
        if (!TextUtils.isEmpty(this.mFirstInputPassword)) {
            if (this.mFirstInputPassword.compareTo(passwordText) == 0) {
                this.mCreatePresenter.savePassword(getContext(), this.mFirstInputPassword);
                return true;
            }
            this.mGuideTextView.setText(C8003R.string.lock_create_do_not_match);
            resetPasswordInput();
            requestFocusToPasswordInput();
            return false;
        }
        this.mFirstInputPassword = passwordText;
        this.mGuideTextView.setText(C8003R.string.lock_create_confirm_again);
        this.mDoneItem.setTitle(C8003R.string.f6004OK);
        MenuItemCompat.setContentDescription(this.mDoneItem, getContext().getResources().getString(C8003R.string.f6004OK));
        updateBottomNavigationMenuColor();
        resetPasswordInput();
        requestFocusToPasswordInput();
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 1) {
            if (!PermissionHelper.verifyRequestResult(getActivity(), iArr, strArr)) {
                this.mNeedSamsungAccountCheck = true;
                finishCancel();
            } else {
                if (this.mNeedSamsungAccountCheck) {
                    checkSamsungAccount();
                }
                this.mPasswordInputView.setEnabled(true);
                this.mRootView.setVisibility(0);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void updateDefaultGuideText() {
        if (this.mGuideTextView == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mFirstInputPassword)) {
            this.mGuideTextView.setText(getResources().getString(C8003R.string.lock_setting_set_password_possible_help));
        } else {
            this.mGuideTextView.setText(getResources().getString(C8003R.string.lock_setting_change_password_confirm));
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.create.ICreateContract.IView
    public void updatePasswordOwnerGuid() {
        Context context = getContext();
        if (context != null) {
            LockPrefUtils.setLocalPasswordOwnerGuid(context, C13541h.m14287e().m14294h());
        }
    }

    public CreatePasswordView(boolean z) {
        this(z, Mode.CREATE);
    }

    public CreatePasswordView(boolean z, Mode mode) {
        this.mTitleStringId = 0;
        this.mNeedSamsungAccountCheck = z;
        this.mMode = mode;
        if (C81262.f6124xe070650d[mode.ordinal()] != 1) {
            this.mTitleStringId = C8003R.string.lock_create_title;
        } else {
            this.mTitleStringId = C8003R.string.settings_change_password;
        }
    }
}
