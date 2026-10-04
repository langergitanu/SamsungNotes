package com.samsung.android.support.senl.p148nt.app.settings.advanced.tools;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreferenceCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.dialog.SettingsConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.external.GlobalSetting;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMainSALoggingHelper;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServerManager;
import com.samsung.android.support.senl.p148nt.base.common.mcf.utils.MCFUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\"\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/tools/SettingsToolsHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "mContinuitySettingObserver", "Landroid/database/ContentObserver;", "initialize", "", "release", "updatePreference", "onPreferenceClick", "", "preference", "Landroidx/preference/Preference;", "onPreferenceChange", "newValue", "", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "initQuickTools", "updateQuickTools", "initCustomizeToolbar", "initUsePhoneAsToolbar", "updateUsePhoneAsToolbarSummary", "showOptionMovePenToolsDialog", "handleActivityResults", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "tag", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsToolsHelper extends AbsSettingsHelper {
    private static final int REQUEST_CONTINUITY_SETTING = 2;

    @NotNull
    private static final String TAG = "SettingsToolsHelper";

    @NotNull
    private final ContentObserver mContinuitySettingObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsToolsHelper(@NotNull final SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        final Handler handler = new Handler();
        this.mContinuitySettingObserver = new ContentObserver(handler) { // from class: com.samsung.android.support.senl.nt.app.settings.advanced.tools.SettingsToolsHelper$mContinuitySettingObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange, uri);
                Context context = fragment.getContext();
                if (context != null && Intrinsics.areEqual(MCFUtil.INSTANCE.getURI_SETTINGS_MCF_CONTINUITY(), uri) && SettingsMenuUtils.isUsePhoneAsToolbarVisible()) {
                    boolean zIsContinuitySettingEnabled = MCFUtil.isContinuitySettingEnabled(context);
                    AbstractC8014b.m7210l("onContinuitySettingChanged: ", "SettingsToolsHelper", zIsContinuitySettingEnabled);
                    if (zIsContinuitySettingEnabled) {
                        ContinuityServerManager.INSTANCE.getInstance().initContinuityService(context);
                    } else {
                        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
                        if (companion.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, true)) {
                            companion.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, false);
                        }
                    }
                    this.updateUsePhoneAsToolbarSummary();
                }
            }
        };
    }

    private final void initCustomizeToolbar() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR);
        Context context = getFragment().getContext();
        if (preferenceFindPreference == null || context == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
        preferenceFindPreference.setVisible(!DeviceInfo.isVSTModel());
    }

    private final void initQuickTools() {
        Preference preference = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_QUICK_TOOLS);
        if (preference == null) {
            return;
        }
        if (SettingsMenuUtils.INSTANCE.isQuickToolsSupported()) {
            preference.setOnPreferenceClickListener(this);
            preference.setOnPreferenceChangeListener(this);
        } else {
            PreferenceGroup parent = preference.getParent();
            if (parent != null) {
                parent.removePreference(preference);
            }
        }
    }

    private final void initUsePhoneAsToolbar() {
        PreferenceGroup parent;
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR);
        Context context = getFragment().getContext();
        if (preferenceFindPreference == null || context == null) {
            return;
        }
        if (!SettingsMenuUtils.isUsePhoneAsToolbarSupported() && (parent = preferenceFindPreference.getParent()) != null) {
            parent.removePreference(preferenceFindPreference);
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
        preferenceFindPreference.setOnPreferenceChangeListener(this);
        preferenceFindPreference.setSummary(SettingsMenuUtils.INSTANCE.getUsePhoneAsToolbarSummaryRes(context));
    }

    private final void showOptionMovePenToolsDialog() {
        getFragment().showSettingsConfirmDialog(4, new SettingsConfirmDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.settings.advanced.tools.SettingsToolsHelper.showOptionMovePenToolsDialog.1
            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
            public void onConfirm() {
                GlobalSetting.INSTANCE.launchContinuitySetting(new WeakReference<>(SettingsToolsHelper.this.getFragment()), 2);
            }
        });
    }

    private final void updateQuickTools() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_QUICK_TOOLS);
        if (switchPreferenceCompat == null) {
            return;
        }
        switchPreferenceCompat.setVisible(SettingsMenuUtils.INSTANCE.isQuickToolsSupported());
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "quicktools# preference is not visible");
            return;
        }
        boolean zIsQuickToolEnabled = SettingsMenuUtils.isQuickToolEnabled();
        MainLogger.m7258i(TAG, "quicktools# isChecked: " + zIsQuickToolEnabled);
        switchPreferenceCompat.setChecked(zIsQuickToolEnabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUsePhoneAsToolbarSummary() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR);
        if (switchPreferenceCompat == null) {
            return;
        }
        boolean zIsUsePhoneAsToolbarVisible = SettingsMenuUtils.isUsePhoneAsToolbarVisible();
        switchPreferenceCompat.setVisible(zIsUsePhoneAsToolbarVisible);
        if (zIsUsePhoneAsToolbarVisible) {
            switchPreferenceCompat.setEnabled(SettingsMenuUtils.isUsePhoneAsToolbarEnabled(getFragment().getContext()));
            switchPreferenceCompat.setChecked(SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, true));
            switchPreferenceCompat.setSummary(SettingsMenuUtils.INSTANCE.getUsePhoneAsToolbarSummaryRes(getFragment().getContext()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public boolean handleActivityResults(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != 2) {
            return super.handleActivityResults(requestCode, resultCode, data);
        }
        if (MCFUtil.isContinuitySettingEnabled(getFragment().getContext())) {
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, true);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initialize() {
        super.initialize();
        MainLogger.m7254d(TAG, "initialize");
        MCFUtil.INSTANCE.registerContentObserver(getFragment().getContext(), this.mContinuitySettingObserver);
        initQuickTools();
        initUsePhoneAsToolbar();
        initCustomizeToolbar();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(@NotNull Preference preference, @Nullable Object newValue) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.SettingsMain;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(100L, tag);
        if (preference instanceof SwitchPreferenceCompat) {
            Intrinsics.checkNotNull(newValue, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) newValue).booleanValue();
            SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) preference;
            if (switchPreferenceCompat.isChecked() == zBooleanValue) {
                return true;
            }
            String key = switchPreferenceCompat.getKey();
            if (key != null) {
                MainLogger.m7258i(TAG, "handleSwitchPreferenceChange# key : " + key + ", state : " + zBooleanValue);
                SettingsMainSALoggingHelper.mainSettingChangedSALogging(key, zBooleanValue);
                if (!Intrinsics.areEqual(key, SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR)) {
                    MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
                } else if (zBooleanValue && !MCFUtil.isContinuitySettingEnabled(getFragment().getContext())) {
                    showOptionMovePenToolsDialog();
                    return false;
                }
            }
        }
        return super.onPreferenceChange(preference, newValue);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(@NotNull Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.SettingsMain;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(1000L, tag);
        String key = preference.getKey();
        if (key != null) {
            MainLogger.m7258i(TAG, "onPreferenceClick# key : ".concat(key));
            if (!preference.isEnabled()) {
                MainLogger.m7258i(TAG, "onPreferenceClick# preference is disabled ");
                return false;
            }
            SettingsMainSALoggingHelper.advancedSettingClickedSALogging(key);
            if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR)) {
                getFragment().startSettingsActivity(key);
            } else {
                MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
            }
        }
        return super.onPreferenceClick(preference);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_QUICK_TOOLS, key)) {
            updateQuickTools();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, key)) {
            updateUsePhoneAsToolbarSummary();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void release() {
        super.release();
        MainLogger.m7254d(TAG, "release");
        MCFUtil.INSTANCE.unregisterContentObserver(getFragment().getContext(), this.mContinuitySettingObserver);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateQuickTools();
        updateUsePhoneAsToolbarSummary();
    }
}
