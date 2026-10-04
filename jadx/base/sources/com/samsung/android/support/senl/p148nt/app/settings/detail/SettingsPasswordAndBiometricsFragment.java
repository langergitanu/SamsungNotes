package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.lock.LockActivity;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockToastUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.RunnableC8501g;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\"\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002J\b\u0010,\u001a\u00020\u0010H\u0002J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u0010H\u0002J\b\u0010/\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsPasswordAndBiometricsFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "mPreferencePassword", "Landroidx/preference/Preference;", "mPreferenceIris", "Landroidx/preference/SwitchPreferenceCompat;", "mPreferenceFingerprint", "mFingerprintApi", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi;", "mIrisApi", "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi;", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "onCreatePreferences", "", "bundle", "Landroid/os/Bundle;", "s", "", "onCreate", "savedInstanceState", "onStart", "onResume", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "initPreference", "updatePasswordLayout", "updateBiometricsLayout", "updateBiometricsViews", "setBiometricsVisible", "fingerprint", "", "iris", "mOnPreferenceClickListener", "Landroidx/preference/Preference$OnPreferenceClickListener;", "mOnPreferenceChangeListener", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "startCreatePassword", "startChangePassword", "startVerifyPasswordForBiometric", "startRegisterFingerprint", "startRegisterIris", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsPasswordAndBiometricsFragment extends SettingsBaseFragment {

    @NotNull
    private static final String INTENT_ACTION_REGISTER_IRIS = "com.samsung.settings.REGISTER_IRIS";
    private static final int REQUEST_CODE_CHANGE_PASSWORD = 2;
    private static final int REQUEST_CODE_CREATE_PASSWORD = 1;
    private static final int REQUEST_CODE_VERIFY_PASSWORD_FOR_FINGERPRINT = 3;
    private static final int REQUEST_CODE_VERIFY_PASSWORD_FOR_IRIS = 4;

    @NotNull
    private static final String SETTINGS_LOCK_BIOMETRICS_CATEGORY = "settings_lock_biometrics_category";

    @NotNull
    private static final String SETTINGS_LOCK_BIOMETRICS_FINGERPRINT = "settings_lock_biometrics_fingerprints";

    @NotNull
    private static final String SETTINGS_LOCK_BIOMETRICS_HELP_TEXT = "settings_lock_biometrics_help_text";

    @NotNull
    private static final String SETTINGS_LOCK_BIOMETRICS_IRIS = "settings_lock_biometrics_iris";

    @NotNull
    private static final String SETTINGS_LOCK_CREATE_CHANGE_PASSWORD = "settings_lock_create_change_password";

    @NotNull
    public static final String TAG = "SettingsPasswordAndBiometricsFragment";

    @Nullable
    private ExecutorService mExecutorService;

    @Nullable
    private FingerprintApi mFingerprintApi;

    @Nullable
    private IrisApi mIrisApi;

    @Nullable
    private SwitchPreferenceCompat mPreferenceFingerprint;

    @Nullable
    private SwitchPreferenceCompat mPreferenceIris;

    @Nullable
    private Preference mPreferencePassword;

    @NotNull
    private final Preference.OnPreferenceClickListener mOnPreferenceClickListener = new C8784h(this);

    @NotNull
    private final Preference.OnPreferenceChangeListener mOnPreferenceChangeListener = new C8784h(this);

    private final void initPreference() {
        getPreferenceManager().setSharedPreferencesName("Settings");
        getPreferenceManager().setSharedPreferencesMode(0);
        addPreferencesFromResource(C8003R.xml.settings_password_and_biometrics_preference);
        Preference preferenceFindPreference = findPreference("settings_lock_create_change_password");
        this.mPreferencePassword = preferenceFindPreference;
        if (preferenceFindPreference != null) {
            Intrinsics.checkNotNull(preferenceFindPreference);
            preferenceFindPreference.setOnPreferenceClickListener(this.mOnPreferenceClickListener);
        }
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference("settings_lock_biometrics_iris");
        this.mPreferenceIris = switchPreferenceCompat;
        if (switchPreferenceCompat != null) {
            Intrinsics.checkNotNull(switchPreferenceCompat);
            switchPreferenceCompat.setOnPreferenceChangeListener(this.mOnPreferenceChangeListener);
        }
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) findPreference("settings_lock_biometrics_fingerprints");
        this.mPreferenceFingerprint = switchPreferenceCompat2;
        if (switchPreferenceCompat2 != null) {
            Intrinsics.checkNotNull(switchPreferenceCompat2);
            switchPreferenceCompat2.setOnPreferenceChangeListener(this.mOnPreferenceChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnPreferenceChangeListener$lambda$3(SettingsPasswordAndBiometricsFragment settingsPasswordAndBiometricsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        MainLogger.m7258i(TAG, "onPreferenceChange : " + preference.getKey() + "(" + obj + ")");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (Intrinsics.areEqual(preference, settingsPasswordAndBiometricsFragment.mPreferenceFingerprint)) {
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_PASSWORD_AND_BIOMETRICS, SettingsSAConstants.EVENT_PASSWORD_AND_BIOMETRICS_FINGERPRINTS, zBooleanValue ? "1" : "0");
            if (!zBooleanValue) {
                LockPrefUtils.setPrefUseFingerprint(settingsPasswordAndBiometricsFragment.getContext(), false);
                return true;
            }
            FingerprintApi fingerprintApi = settingsPasswordAndBiometricsFragment.mFingerprintApi;
            Intrinsics.checkNotNull(fingerprintApi);
            if (fingerprintApi.hasEnrolledFingerprint(settingsPasswordAndBiometricsFragment.getContext())) {
                settingsPasswordAndBiometricsFragment.startVerifyPasswordForBiometric(3);
            } else {
                settingsPasswordAndBiometricsFragment.startRegisterFingerprint();
            }
            return false;
        }
        if (!Intrinsics.areEqual(preference, settingsPasswordAndBiometricsFragment.mPreferenceIris)) {
            return false;
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_PASSWORD_AND_BIOMETRICS, SettingsSAConstants.EVENT_PASSWORD_AND_BIOMETRICS_IRISES, zBooleanValue ? "1" : "0");
        if (!zBooleanValue) {
            LockPrefUtils.setPrefUseIris(settingsPasswordAndBiometricsFragment.getContext(), false);
            return true;
        }
        IrisApi irisApi = settingsPasswordAndBiometricsFragment.mIrisApi;
        Intrinsics.checkNotNull(irisApi);
        if (irisApi.hasEnrolledIris(settingsPasswordAndBiometricsFragment.getContext())) {
            settingsPasswordAndBiometricsFragment.startVerifyPasswordForBiometric(4);
        } else {
            settingsPasswordAndBiometricsFragment.startRegisterIris();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnPreferenceClickListener$lambda$2(SettingsPasswordAndBiometricsFragment settingsPasswordAndBiometricsFragment, Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        if (!Intrinsics.areEqual(preference, settingsPasswordAndBiometricsFragment.mPreferencePassword)) {
            return false;
        }
        if (LockUtils.isSetPassword(settingsPasswordAndBiometricsFragment.getContext())) {
            settingsPasswordAndBiometricsFragment.startChangePassword();
            return false;
        }
        settingsPasswordAndBiometricsFragment.startCreatePassword();
        return false;
    }

    private final void setBiometricsVisible(boolean fingerprint, boolean iris) {
        Preference preferenceFindPreference = findPreference(SETTINGS_LOCK_BIOMETRICS_CATEGORY);
        Preference preferenceFindPreference2 = findPreference(SETTINGS_LOCK_BIOMETRICS_HELP_TEXT);
        boolean z = true;
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setVisible(fingerprint || iris);
        }
        if (preferenceFindPreference2 != null) {
            if (!fingerprint && !iris) {
                z = false;
            }
            preferenceFindPreference2.setVisible(z);
        }
        SwitchPreferenceCompat switchPreferenceCompat = this.mPreferenceIris;
        Intrinsics.checkNotNull(switchPreferenceCompat);
        switchPreferenceCompat.setVisible(iris);
        SwitchPreferenceCompat switchPreferenceCompat2 = this.mPreferenceFingerprint;
        Intrinsics.checkNotNull(switchPreferenceCompat2);
        switchPreferenceCompat2.setVisible(fingerprint);
    }

    private final void startChangePassword() {
        MainLogger.m7258i(TAG, "startChangePassword");
        Intent intent = new Intent(getActivity(), (Class<?>) LockActivity.class);
        intent.putExtra("key_lock_scenario_type", 2);
        startActivityForResult(intent, 2);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_PASSWORD_AND_BIOMETRICS, SettingsSAConstants.EVENT_PASSWORD_AND_BIOMETRICS_CHANGE_PASSWORD);
    }

    private final void startCreatePassword() {
        Intent intent = new Intent(getActivity(), (Class<?>) LockActivity.class);
        intent.putExtra("key_lock_scenario_type", 1);
        startActivityForResult(intent, 1);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_PASSWORD_AND_BIOMETRICS, SettingsSAConstants.EVENT_PASSWORD_AND_BIOMETRICS_CREATE_PASSWORD);
    }

    private final void startRegisterFingerprint() {
        FingerprintApi fingerprintApi = this.mFingerprintApi;
        Intrinsics.checkNotNull(fingerprintApi);
        fingerprintApi.registerFingerprint(getContext());
    }

    private final void startRegisterIris() {
        MainLogger.m7258i(TAG, "startRegisterIris");
        Intent intent = new Intent();
        intent.setAction(INTENT_ACTION_REGISTER_IRIS);
        startActivity(intent);
    }

    private final void startVerifyPasswordForBiometric(int requestCode) {
        MainLogger.m7258i(TAG, "startVerifyPasswordForBiometric(requestCode:" + requestCode + ")");
        Intent intent = new Intent(getActivity(), (Class<?>) LockActivity.class);
        intent.putExtra("key_lock_scenario_type", 4);
        startActivityForResult(intent, requestCode);
    }

    private final void updateBiometricsLayout() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        boolean zIsLockNotesUsingFingerprintSupported = SettingsMenuUtils.isLockNotesUsingFingerprintSupported(context, this.mFingerprintApi);
        boolean zIsLockNotesUsingIrisSupported = SettingsMenuUtils.isLockNotesUsingIrisSupported(context, this.mIrisApi);
        setBiometricsVisible(zIsLockNotesUsingFingerprintSupported, zIsLockNotesUsingIrisSupported);
        if (zIsLockNotesUsingFingerprintSupported || zIsLockNotesUsingIrisSupported) {
            ExecutorService executorService = this.mExecutorService;
            Intrinsics.checkNotNull(executorService);
            executorService.execute(new RunnableC8669a(this, 5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateBiometricsViews() {
        boolean z;
        Context context = getContext();
        if (context == null) {
            return;
        }
        boolean z2 = true;
        if (LockPrefUtils.getPrefUseFingerprint(context)) {
            FingerprintApi fingerprintApi = this.mFingerprintApi;
            Intrinsics.checkNotNull(fingerprintApi);
            if (fingerprintApi.hasChangedFingerprint(context)) {
                MainLogger.m7258i(TAG, "updateBiometricsViews, Fingerprint has changed");
                LockPrefUtils.setPrefUseFingerprint(context, false);
                z = true;
            } else {
                z = false;
            }
        }
        if (LockPrefUtils.getPrefUseIris(context)) {
            IrisApi irisApi = this.mIrisApi;
            Intrinsics.checkNotNull(irisApi);
            if (irisApi.hasChangedIris(context)) {
                MainLogger.m7258i(TAG, "updateBiometricsViews, Iris has changed");
                LockPrefUtils.setPrefUseIris(context, false);
            } else {
                z2 = false;
            }
        }
        FragmentActivity activity = getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        Intrinsics.checkNotNull(activity);
        activity.runOnUiThread(new RunnableC8501g(this, context, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateBiometricsViews$lambda$1(SettingsPasswordAndBiometricsFragment settingsPasswordAndBiometricsFragment, Context context, boolean z, boolean z2) {
        SwitchPreferenceCompat switchPreferenceCompat = settingsPasswordAndBiometricsFragment.mPreferenceFingerprint;
        Intrinsics.checkNotNull(switchPreferenceCompat);
        switchPreferenceCompat.setChecked(LockPrefUtils.getPrefUseFingerprint(context));
        SwitchPreferenceCompat switchPreferenceCompat2 = settingsPasswordAndBiometricsFragment.mPreferenceIris;
        Intrinsics.checkNotNull(switchPreferenceCompat2);
        switchPreferenceCompat2.setChecked(LockPrefUtils.getPrefUseIris(context));
        if (z || z2) {
            LockToastUtils.showBiometricChangeToast(context, z, z2);
        }
    }

    private final void updatePasswordLayout() {
        Preference preference = this.mPreferencePassword;
        if (preference == null) {
            return;
        }
        Intrinsics.checkNotNull(preference);
        preference.setEnabled(SettingsMenuUtils.isLockNoteSetPasswordEnabled(getContext()));
        Preference preference2 = this.mPreferencePassword;
        Intrinsics.checkNotNull(preference2);
        preference2.setTitle(SettingsMenuUtils.getLockNotesSetPasswordTitleRes(getContext()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(requestCode, resultCode, "onActivityResult requestCode:", " resultCode:", " data:");
        sbM1173s.append(data);
        MainLogger.m7258i(TAG, sbM1173s.toString());
        if (requestCode == 1) {
            if (resultCode != -1) {
                requireActivity().finish();
                return;
            }
            return;
        }
        if (requestCode != 2) {
            if (requestCode == 3) {
                if (resultCode == -1) {
                    FingerprintApi fingerprintApi = this.mFingerprintApi;
                    Intrinsics.checkNotNull(fingerprintApi);
                    if (fingerprintApi.hasEnrolledFingerprint(getContext())) {
                        SwitchPreferenceCompat switchPreferenceCompat = this.mPreferenceFingerprint;
                        Intrinsics.checkNotNull(switchPreferenceCompat);
                        switchPreferenceCompat.setChecked(true);
                        FingerprintApi fingerprintApi2 = this.mFingerprintApi;
                        Intrinsics.checkNotNull(fingerprintApi2);
                        fingerprintApi2.enableFingerprint(getContext());
                        return;
                    }
                    return;
                }
                return;
            }
            if (requestCode != 4) {
                MainLogger.m7258i(TAG, "unresolved requestCode");
                return;
            }
            if (resultCode == -1) {
                IrisApi irisApi = this.mIrisApi;
                Intrinsics.checkNotNull(irisApi);
                if (irisApi.hasEnrolledIris(getContext())) {
                    SwitchPreferenceCompat switchPreferenceCompat2 = this.mPreferenceIris;
                    Intrinsics.checkNotNull(switchPreferenceCompat2);
                    switchPreferenceCompat2.setChecked(true);
                    IrisApi irisApi2 = this.mIrisApi;
                    Intrinsics.checkNotNull(irisApi2);
                    irisApi2.enableIris(getContext());
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (PostLaunchManager.INSTANCE.getInstance().hasBaseLogic(301)) {
            ToastHandler.show(getContext(), C8003R.string.base_something_wrong_try_again, 0);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (!LockUtils.isSetPassword(getContext())) {
            startCreatePassword();
        }
        this.mFingerprintApi = new FingerprintApi();
        this.mIrisApi = new IrisApi();
        this.mExecutorService = AbstractC4539a.m3201k(TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String s) {
        initPreference();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updatePasswordLayout();
        updateBiometricsLayout();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        UserInputSkipper.releaseHoldingEventTimeByTag(UserInputSkipper.Tag.SettingsDetail);
    }
}
