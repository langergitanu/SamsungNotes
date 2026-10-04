package com.samsung.android.support.senl.p148nt.app.lock.view.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;
import com.samsung.android.support.senl.addons.base.view.inputblockcontainers.InputIntercepterRelativeLayout;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.AccountHelper;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.password.IBasePasswordContract;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.view.progress.BottomMenuProgressView;
import com.samsung.android.support.senl.p148nt.app.lock.view.progress.OptionMenuProgressView;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import p035H2.RunnableC0116a;
import p122b2.RunnableC4199v;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsPasswordView extends AbsBaseView implements IBasePasswordContract.IView {
    private static final int MENU_INDEX_CONTINUE = 1;
    private static final int PASSWORD_MAX_LENGTH = 16;
    protected static final int PASSWORD_MIN_LENGTH = 4;
    private static final String STATE_BUNDLE_KEY_CONFIRM_PASSWORD = "state_bundle_key_confirm_password";
    private static final String STATE_BUNDLE_KEY_DONE = "state_bundle_key_done";
    private static final String STATE_BUNDLE_KEY_INPUT_STATE = "state_bundle_key_input_state";
    private static final String STATE_BUNDLE_KEY_PASSWORD = "state_bundle_key_password";
    private static final String STATE_BUNDLE_KEY_PROGRESS = "state_bundle_key_progress";
    private static final String STATE_BUNDLE_KEY_USE_BIOMETRIC = "state_bundle_key_use_biometric";
    private static final String TAG = LockLogger.createTag("AbsPasswordView");
    private BottomMenuProgressView mBottomMenuProgressView;
    protected MenuItem mCancelItem;
    private ViewGroup mContainer;
    protected MenuItem mDoneItem;
    private FingerprintApi mFingerprintApi;
    protected TextView mGuideFingerPrintsChangedTextView;
    protected TextView mGuideTextView;
    private IrisApi mIrisApi;
    private OptionMenuProgressView mOptionMenuProgressView;
    private ScrollView mPasswordContainer;
    private View.OnLayoutChangeListener mPasswordContainerChangeListener;
    protected EditText mPasswordInputView;
    protected InputIntercepterRelativeLayout mPasswordViewLayout;
    protected IBasePasswordContract.IPresenter mPresenter;
    protected Toolbar mToolbar;
    protected CheckBox mUseBiometricsCheckBox;
    private boolean mIsPasswordEditedByCode = false;
    private boolean mIsPasswordWatcherRunning = false;
    private boolean mProgressInitValue = false;
    private boolean mDoneButtonInitValue = false;
    private String mPasswordInputInitValue = "";
    protected String mGuideInitValue = "";
    private boolean mPasswordInputInitState = true;
    private boolean mIsCheckedUseBiometric = false;
    protected boolean mIsConfirmPassword = false;
    private final NavigationBarView.OnItemSelectedListener mBottomNavigationItemListener = new NavigationBarView.OnItemSelectedListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.base.AbsPasswordView.3
        @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.equals(AbsPasswordView.this.mDoneItem)) {
                AbsPasswordView.this.onDoneButtonClicked();
                return true;
            }
            if (!menuItem.equals(AbsPasswordView.this.mCancelItem)) {
                return false;
            }
            AbsPasswordView.this.onCancelButtonClicked();
            AbsPasswordView.this.finishCancel();
            return true;
        }
    };
    private final View.OnKeyListener mPasswordKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.base.AbsPasswordView.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            LockLogger.m7356d(AbsPasswordView.TAG, "onKey : " + i + "/" + keyEvent);
            if (keyEvent == null || keyEvent.getAction() != 1 || (i != 23 && i != 66 && i != 160)) {
                return false;
            }
            AbsPasswordView.this.onDoneButtonClicked();
            return true;
        }
    };
    private final TextView.OnEditorActionListener mEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.base.AbsPasswordView.5
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            boolean zOnDoneButtonClicked = AbsPasswordView.this.onDoneButtonClicked();
            LockLogger.m7356d(AbsPasswordView.TAG, "onEditorAction ret : " + zOnDoneButtonClicked);
            return !zOnDoneButtonClicked;
        }
    };
    private final TextWatcher mPasswordWatcher = new TextWatcher() { // from class: com.samsung.android.support.senl.nt.app.lock.view.base.AbsPasswordView.6
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (AbsPasswordView.this.mIsPasswordEditedByCode) {
                AbsPasswordView.this.mIsPasswordEditedByCode = false;
                return;
            }
            if (AbsPasswordView.this.isValidPassword(editable.toString())) {
                AbsPasswordView.this.updateDefaultGuideText();
                AbsPasswordView absPasswordView = AbsPasswordView.this;
                absPasswordView.setMenuItemEnabled(absPasswordView.mDoneItem, true);
            } else if (editable.length() > 16) {
                AbsPasswordView.this.mIsPasswordEditedByCode = true;
                AbsPasswordView.this.mPasswordInputView.getText().delete(AbsPasswordView.this.mPasswordInputView.length() - 1, AbsPasswordView.this.mPasswordInputView.length());
            } else {
                AbsPasswordView absPasswordView2 = AbsPasswordView.this;
                absPasswordView2.setMenuItemEnabled(absPasswordView2.mDoneItem, false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
        }
    };

    private void addPasswordWatcher() {
        if (this.mIsPasswordWatcherRunning) {
            return;
        }
        this.mPasswordInputView.addTextChangedListener(this.mPasswordWatcher);
        this.mIsPasswordWatcherRunning = true;
    }

    private boolean hasInvalidCharacter(String str) {
        for (char c : str.toCharArray()) {
            if (c <= ' ' || c > 127) {
                return true;
            }
        }
        return false;
    }

    private void initLayout(View view) {
        if (getActivity() != null) {
            this.mToolbar = (Toolbar) getActivity().findViewById(C8003R.id.lock_toolbar);
            ((AppCompatActivity) getActivity()).setSupportActionBar(this.mToolbar);
            initTitle();
        }
        if (getContext().getResources().getConfiguration().orientation == 1) {
            initBottomNavigationMenu(view);
        } else {
            initOptionMenu();
        }
        this.mGuideTextView = (TextView) view.findViewById(C8003R.id.guide_text_view);
        this.mGuideFingerPrintsChangedTextView = (TextView) view.findViewById(C8003R.id.guide_text_view_fingerprints_changed);
        if (TextUtils.isEmpty(this.mPasswordInputInitValue)) {
            initGuideText();
        } else if (isValidPassword(this.mPasswordInputInitValue)) {
            updateDefaultGuideText();
        }
        EditText editText = (EditText) view.findViewById(C8003R.id.edit_pwd);
        this.mPasswordInputView = editText;
        editText.setOnKeyListener(this.mPasswordKeyListener);
        this.mPasswordInputView.setOnEditorActionListener(this.mEditorActionListener);
        setPasswordText(this.mPasswordInputInitValue);
        this.mPasswordInputView.setEnabled(this.mPasswordInputInitState);
        this.mUseBiometricsCheckBox = (CheckBox) view.findViewById(C8003R.id.use_biometrics_checkbox);
        initBiometricCheckBox();
        if (this.mUseBiometricsCheckBox.getVisibility() == 0) {
            this.mUseBiometricsCheckBox.setChecked(this.mIsCheckedUseBiometric);
        }
        this.mUseBiometricsCheckBox.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.base.AbsPasswordView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AbsPasswordView.this.mUseBiometricsCheckBox.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AbsPasswordView.this.setUseBiometricsTouchDelegate();
            }
        });
        ScrollView scrollView = (ScrollView) view.findViewById(C8003R.id.password_container);
        this.mPasswordContainer = scrollView;
        if (scrollView != null) {
            View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.base.AbsPasswordView.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    View childAt = AbsPasswordView.this.mPasswordContainer.getChildAt(0);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    if (AbsPasswordView.this.mPasswordContainer.getHeight() < childAt.getHeight()) {
                        layoutParams.gravity = 48;
                    } else {
                        layoutParams.gravity = 16;
                    }
                    childAt.setLayoutParams(layoutParams);
                }
            };
            this.mPasswordContainerChangeListener = onLayoutChangeListener;
            this.mPasswordContainer.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    private void initOptionMenu() {
        setHasOptionsMenu(true);
        this.mOptionMenuProgressView = new OptionMenuProgressView(this.mToolbar, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideProgress$2() {
        BottomMenuProgressView bottomMenuProgressView = this.mBottomMenuProgressView;
        if (bottomMenuProgressView != null && bottomMenuProgressView.isShowing()) {
            this.mBottomMenuProgressView.hide();
        }
        OptionMenuProgressView optionMenuProgressView = this.mOptionMenuProgressView;
        if (optionMenuProgressView != null && optionMenuProgressView.isShowing()) {
            this.mOptionMenuProgressView.hide();
        }
        EditText editText = this.mPasswordInputView;
        if (editText != null) {
            editText.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ignoreInputEvent$3(boolean z) {
        this.mPasswordViewLayout.ignoreInputEvent(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFocusToPasswordInput$4() {
        this.mPasswordInputView.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showProgress$1() {
        BottomMenuProgressView bottomMenuProgressView = this.mBottomMenuProgressView;
        if (bottomMenuProgressView != null && !bottomMenuProgressView.isShowing()) {
            this.mBottomMenuProgressView.show(getContext());
        }
        OptionMenuProgressView optionMenuProgressView = this.mOptionMenuProgressView;
        if (optionMenuProgressView == null || optionMenuProgressView.isShowing()) {
            return;
        }
        this.mOptionMenuProgressView.show(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSoftInput$0(InputMethodManager inputMethodManager) {
        if (InputMethodCompat.getInstance().isInputMethodShown(getContext(), this.mPasswordInputView, false)) {
            return;
        }
        inputMethodManager.showSoftInput(this.mPasswordInputView, 1);
        LockLogger.m7356d(TAG, "show SIP delayed");
    }

    private void refreshViewByOrientation() {
        Bundle bundle = new Bundle();
        onSaveInstanceState(bundle);
        View viewOnCreateView = onCreateView((LayoutInflater) getActivity().getSystemService("layout_inflater"), this.mContainer, bundle);
        this.mContainer.removeAllViews();
        this.mContainer.addView(viewOnCreateView);
        if (isPasswordInputAccessible()) {
            showSoftInput();
            EditText editText = this.mPasswordInputView;
            editText.setSelection(editText.getText().length());
            addPasswordWatcher();
        }
    }

    private void removePasswordWatcher() {
        if (this.mIsPasswordWatcherRunning) {
            this.mPasswordInputView.removeTextChangedListener(this.mPasswordWatcher);
            this.mIsPasswordWatcherRunning = false;
        }
    }

    private void restoreSavedInstance(@Nullable Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString(STATE_BUNDLE_KEY_PASSWORD);
            if (string != null) {
                this.mPasswordInputInitValue = string;
            }
            this.mDoneButtonInitValue = bundle.getBoolean(STATE_BUNDLE_KEY_DONE);
            this.mProgressInitValue = bundle.getBoolean(STATE_BUNDLE_KEY_PROGRESS);
            this.mPasswordInputInitState = bundle.getBoolean(STATE_BUNDLE_KEY_INPUT_STATE);
            this.mIsCheckedUseBiometric = bundle.getBoolean(STATE_BUNDLE_KEY_USE_BIOMETRIC);
            this.mIsConfirmPassword = bundle.getBoolean(STATE_BUNDLE_KEY_CONFIRM_PASSWORD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUseBiometricsTouchDelegate() {
        LockLogger.m7356d(TAG, "setUseBiometricsTouchDelegate");
        Rect rect = new Rect();
        this.mUseBiometricsCheckBox.getHitRect(rect);
        int iHeight = rect.height() / 2;
        ((View) this.mUseBiometricsCheckBox.getParent()).setTouchDelegate(new TouchDelegate(new Rect(rect.left - iHeight, rect.top - iHeight, rect.right + iHeight, rect.bottom + iHeight), this.mUseBiometricsCheckBox));
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public String getEncryptedPasswordHash() {
        return LockUtils.getEncryptedPasswordHash(getContext());
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public String getEncryptedPasswordSalt() {
        return LockUtils.getEncryptedPasswordSalt(getContext());
    }

    public String getPasswordText() {
        return this.mPasswordInputView.getText().toString();
    }

    public boolean hasEnrolledFingerprint() {
        return this.mFingerprintApi.hasEnrolledFingerprint(getContext());
    }

    public boolean hasEnrolledIris() {
        return this.mIrisApi.hasEnrolledIris(getContext());
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public void hideProgress() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new RunnableC8122a(this, 0));
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public void ignoreInputEvent(boolean z) {
        LockLogger.m7356d(TAG, "ignoreInputEvent " + z);
        if (getActivity() == null || this.mPasswordViewLayout == null) {
            return;
        }
        getActivity().runOnUiThread(new RunnableC0116a(9, this, z));
    }

    public abstract void initBiometricCheckBox();

    public void initBottomNavigationMenu(View view) {
        setHasOptionsMenu(false);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) view.findViewById(C8003R.id.bottom_navi_view);
        bottomNavigationView.inflateMenu(C8003R.menu.lock_password_bottom_menu);
        bottomNavigationView.setOnItemSelectedListener(this.mBottomNavigationItemListener);
        MenuItem menuItemFindItem = bottomNavigationView.getMenu().findItem(C8003R.id.action_done);
        this.mDoneItem = menuItemFindItem;
        setMenuItemEnabled(menuItemFindItem, this.mDoneButtonInitValue);
        MenuItem menuItemFindItem2 = bottomNavigationView.getMenu().findItem(C8003R.id.action_cancel);
        this.mCancelItem = menuItemFindItem2;
        setMenuItemEnabled(menuItemFindItem2, true);
        BottomMenuProgressView bottomMenuProgressView = new BottomMenuProgressView((NavigationBarItemView) view.findViewById(C8003R.id.action_done));
        this.mBottomMenuProgressView = bottomMenuProgressView;
        if (this.mProgressInitValue) {
            bottomMenuProgressView.show(getContext());
        }
        updateBottomNavigationMenuColor();
        if (SettingsCompat.getInstance().isShowButtonBackground(getContext())) {
            LockLogger.m7356d(TAG, "initBottomNavigationMenu isShowButtonBackground, hide BottomNaviView");
            bottomNavigationView.setVisibility(8);
        }
    }

    public abstract void initGuideText();

    public abstract void initTitle();

    public boolean isPasswordInputAccessible() {
        EditText editText = this.mPasswordInputView;
        return editText != null && editText.isEnabled() && this.mPasswordInputView.isFocusable() && this.mPasswordInputView.isFocusableInTouchMode();
    }

    public boolean isProgressbarShowing() {
        if (getContext().getResources().getConfiguration().orientation == 1) {
            BottomMenuProgressView bottomMenuProgressView = this.mBottomMenuProgressView;
            return bottomMenuProgressView != null && bottomMenuProgressView.isShowing();
        }
        OptionMenuProgressView optionMenuProgressView = this.mOptionMenuProgressView;
        return optionMenuProgressView != null && optionMenuProgressView.isShowing();
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public boolean isUseBiometricChecked() {
        if (this.mUseBiometricsCheckBox.getVisibility() != 0) {
            return false;
        }
        return this.mUseBiometricsCheckBox.isChecked();
    }

    public boolean isValidPassword(String str) {
        if (!isAdded()) {
            LockLogger.m7356d(TAG, "isValidPassword not added yet");
            return false;
        }
        if (hasInvalidCharacter(str)) {
            LockLogger.m7356d(TAG, "has invalid character");
            this.mGuideTextView.setText(C8003R.string.lock_create_invalid_character);
            return false;
        }
        if (str.length() < 4) {
            LockLogger.m7356d(TAG, "password min length");
            this.mGuideTextView.setText(getResources().getQuantityString(C8003R.plurals.lock_create_guide_default, 4, 4));
            return false;
        }
        if (str.length() <= 16) {
            return true;
        }
        LockLogger.m7356d(TAG, "password max length");
        this.mGuideTextView.setText(getString(C8003R.string.lock_create_over_max, 16));
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public void loginSamsungAccount(int i) {
        LockLogger.m7356d(TAG, "loginSamsungAccount requestCode : " + i);
        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            AccountHelper.confirmSamsungAccountByFragment(this, i);
        } else {
            AccountHelper.loginSamsungAccountByFragment(this, i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        setRetainInstance(true);
    }

    public abstract void onCancelButtonClicked();

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        refreshViewByOrientation();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        LockLogger.m7356d(TAG, "onCreateOptionsMenu");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C8003R.menu.lock_password_bottom_menu, menu);
        MenuItem menuItemFindItem = menu.findItem(C8003R.id.action_done);
        this.mDoneItem = menuItemFindItem;
        setMenuItemEnabled(menuItemFindItem, this.mDoneButtonInitValue);
        MenuItem menuItemFindItem2 = menu.findItem(C8003R.id.action_cancel);
        this.mCancelItem = menuItemFindItem2;
        setMenuItemEnabled(menuItemFindItem2, true);
        if (this.mProgressInitValue) {
            this.mOptionMenuProgressView.show(getContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mContainer = viewGroup;
        this.mPasswordViewLayout = (InputIntercepterRelativeLayout) layoutInflater.inflate(C8003R.layout.lock_password, viewGroup, false);
        this.mFingerprintApi = new FingerprintApi();
        this.mIrisApi = new IrisApi();
        this.mIsPasswordEditedByCode = false;
        this.mIsPasswordWatcherRunning = false;
        this.mProgressInitValue = false;
        this.mDoneButtonInitValue = false;
        this.mPasswordInputInitValue = "";
        this.mPasswordInputInitState = true;
        this.mGuideInitValue = "";
        this.mIsConfirmPassword = false;
        restoreSavedInstance(bundle);
        initLayout(this.mPasswordViewLayout);
        return this.mPasswordViewLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mContainer = null;
        ScrollView scrollView = this.mPasswordContainer;
        if (scrollView != null) {
            scrollView.removeOnLayoutChangeListener(this.mPasswordContainerChangeListener);
            this.mPasswordContainer = null;
            this.mPasswordContainerChangeListener = null;
        }
    }

    public abstract boolean onDoneButtonClicked();

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.equals(this.mDoneItem)) {
            onDoneButtonClicked();
            return true;
        }
        if (!menuItem.equals(this.mCancelItem)) {
            return false;
        }
        finishCancel();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        removePasswordWatcher();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isPasswordInputAccessible()) {
            showSoftInput();
            addPasswordWatcher();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(STATE_BUNDLE_KEY_PASSWORD, getPasswordText());
        MenuItem menuItem = this.mDoneItem;
        if (menuItem != null) {
            bundle.putBoolean(STATE_BUNDLE_KEY_DONE, menuItem.isEnabled());
            if (this.mDoneItem.getTitle() != null) {
                bundle.putBoolean(STATE_BUNDLE_KEY_CONFIRM_PASSWORD, this.mDoneItem.getTitle().equals(getString(C8003R.string.f6004OK)));
            }
        }
        bundle.putBoolean(STATE_BUNDLE_KEY_PROGRESS, isProgressbarShowing());
        bundle.putBoolean(STATE_BUNDLE_KEY_INPUT_STATE, this.mPasswordInputView.isEnabled());
        bundle.putBoolean(STATE_BUNDLE_KEY_USE_BIOMETRIC, this.mUseBiometricsCheckBox.isChecked());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseView, com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && isPasswordInputAccessible()) {
            showSoftInput();
        }
    }

    public void requestFocusToPasswordInput() {
        this.mPasswordInputView.post(new RunnableC8122a(this, 2));
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public void resetOldBiometricBlockingEndTime() {
        if (getContext() != null) {
            LockLogger.m7356d(TAG, "resetOldBiometricBlockingEndTime");
            LockPrefUtils.setOldBiometricMethodBlockEndTime(getContext(), 0L);
        }
    }

    public void resetPasswordInput() {
        setPasswordText("");
        setMenuItemEnabled(this.mDoneItem, false);
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public void setBiometricsEnabled() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.mFingerprintApi.isDeviceAvailable(context) && this.mFingerprintApi.hasEnrolledFingerprint(context)) {
            this.mFingerprintApi.enableFingerprint(context);
        }
        if (this.mIrisApi.isDeviceAvailable(context) && this.mIrisApi.hasEnrolledIris(context)) {
            this.mIrisApi.enableIris(context);
        }
    }

    public void setMenuItemEnabled(MenuItem menuItem, boolean z) {
        if (menuItem == null) {
            return;
        }
        menuItem.setEnabled(z);
    }

    public void setPasswordInputViewAccessibility(boolean z) {
        this.mPasswordInputView.setEnabled(z);
        this.mPasswordInputView.setFocusableInTouchMode(z);
        this.mPasswordInputView.setFocusable(z);
    }

    public void setPasswordText(CharSequence charSequence) {
        if (this.mIsPasswordWatcherRunning) {
            this.mIsPasswordEditedByCode = true;
        }
        this.mPasswordInputView.setText(charSequence);
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IView
    public void showProgress() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new RunnableC8122a(this, 1));
    }

    public void showSoftInput() {
        if (this.mPasswordInputView == null || (InputMethodCompat.getInstance().isInputMethodShown(getContext(), this.mPasswordInputView, false) && this.mPasswordInputView.hasFocus())) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("shown SIP ? ");
            sb.append(this.mPasswordInputView != null);
            LockLogger.m7358i(str, sb.toString());
            return;
        }
        this.mPasswordInputView.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        inputMethodManager.showSoftInput(this.mPasswordInputView, 1);
        LockLogger.m7356d(TAG, "show SIP");
        new Handler().postDelayed(new RunnableC4199v(this, inputMethodManager, 21), 500L);
    }

    public void updateBottomNavigationMenuColor() {
        if (ButtonBackgroundUtils.isShowButtonShapeEnabled(getContext())) {
            int i = ContextUtils.isNightMode(getContext()) ? -16777216 : -1;
            ButtonBackgroundUtils.updateMenuItemTextColor(this.mDoneItem, i);
            ButtonBackgroundUtils.updateMenuItemTextColor(this.mCancelItem, i);
        }
    }

    public abstract void updateDefaultGuideText();
}
