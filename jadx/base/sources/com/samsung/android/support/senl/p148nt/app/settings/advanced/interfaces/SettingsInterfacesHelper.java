package com.samsung.android.support.senl.p148nt.app.settings.advanced.interfaces;

import android.content.SharedPreferences;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreferenceCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMainSALoggingHelper;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\tJ\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/interfaces/SettingsInterfacesHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "mIsHideNavigationMenu", "", "initialize", "", "updatePreference", "onPreferenceClick", "preference", "Landroidx/preference/Preference;", "onPreferenceChange", "newValue", "", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "initDefaultPreference", "initHideScrollBarWhileEditing", "updateHideScrollbarWhileEditing", "initHideNavigationBarWhileWriting", "updateHideNavigationBarWhileEditing", "initBlockBackKeyWhileEditing", "updateBlockBackKeyWhileEditing", "tag", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsInterfacesHelper extends AbsSettingsHelper {

    @NotNull
    private static final String TAG = "SettingsInterfacesHelper";
    private boolean mIsHideNavigationMenu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsInterfacesHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    private final void initBlockBackKeyWhileEditing() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING);
        if (switchPreferenceCompat == null) {
            return;
        }
        switchPreferenceCompat.setOnPreferenceClickListener(this);
        switchPreferenceCompat.setOnPreferenceChangeListener(this);
    }

    private final void initHideNavigationBarWhileWriting() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (SettingsMenuUtils.isHideNavigationBarWhileWritingSupported()) {
            switchPreferenceCompat.setChecked(this.mIsHideNavigationMenu);
            switchPreferenceCompat.setOnPreferenceClickListener(this);
            switchPreferenceCompat.setOnPreferenceChangeListener(this);
        } else {
            PreferenceGroup parent = switchPreferenceCompat.getParent();
            if (parent != null) {
                parent.removePreference(switchPreferenceCompat);
            }
        }
    }

    private final void initHideScrollBarWhileEditing() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING);
        if (preferenceFindPreference == null) {
            return;
        }
        if (SettingsMenuUtils.INSTANCE.isHideScrollBarWhileEditingSupported()) {
            preferenceFindPreference.setOnPreferenceClickListener(this);
            preferenceFindPreference.setOnPreferenceChangeListener(this);
        } else {
            PreferenceGroup parent = preferenceFindPreference.getParent();
            if (parent != null) {
                parent.removePreference(preferenceFindPreference);
            }
        }
    }

    private final void updateBlockBackKeyWhileEditing() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "updateBlockBackKeyWhileEditing# preference is not visible");
            return;
        }
        boolean zIsBlockBackKeyWhileEditing = SettingsMenuUtils.isBlockBackKeyWhileEditing();
        MainLogger.m7258i(TAG, "updateBlockBackKeyWhileEditing# isChecked: " + zIsBlockBackKeyWhileEditing);
        switchPreferenceCompat.setChecked(zIsBlockBackKeyWhileEditing);
    }

    private final void updateHideNavigationBarWhileEditing() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "updateHideNavigationBarWhileEditing# preference is not visible");
            return;
        }
        boolean zIsHideNavigationBarWhileEditingChecked = SettingsMenuUtils.isHideNavigationBarWhileEditingChecked();
        MainLogger.m7258i(TAG, "updateHideNavigationBarWhileEditing# isChecked: " + zIsHideNavigationBarWhileEditingChecked);
        switchPreferenceCompat.setChecked(zIsHideNavigationBarWhileEditingChecked);
    }

    private final void updateHideScrollbarWhileEditing() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "updateHideScrollbarWhileEditing# preference is not visible");
            return;
        }
        boolean zIsHideScrollBarWhileEditingChecked = SettingsMenuUtils.isHideScrollBarWhileEditingChecked();
        MainLogger.m7258i(TAG, "updateHideScrollbarWhileEditing# isChecked: " + zIsHideScrollBarWhileEditingChecked);
        switchPreferenceCompat.setChecked(zIsHideScrollBarWhileEditingChecked);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    public final void initDefaultPreference() {
        this.mIsHideNavigationMenu = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, CommonUtils.isDefaultHideNavigationOptionEnabled());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initialize() {
        super.initialize();
        MainLogger.m7254d(TAG, "initialize");
        initHideScrollBarWhileEditing();
        initHideNavigationBarWhileWriting();
        initBlockBackKeyWhileEditing();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(@NotNull Preference preference, @Nullable Object newValue) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            Intrinsics.checkNotNull(newValue, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) newValue).booleanValue();
            MainLogger.m7258i(TAG, "handleSwitchPreferenceChange# key : " + key + ", state : " + zBooleanValue);
            SettingsMainSALoggingHelper.advancedSettingChangedSALogging(key, zBooleanValue);
        }
        return super.onPreferenceChange(preference, newValue);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(@NotNull Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        if (!UserInputSkipper.isValidEvent(UserInputSkipper.Tag.SettingsMain)) {
            return false;
        }
        String key = preference.getKey();
        if (key != null) {
            MainLogger.m7258i(TAG, "onPreferenceClick# key : ".concat(key));
            if (!preference.isEnabled()) {
                MainLogger.m7258i(TAG, "onPreferenceClick# preference is disabled ");
                return false;
            }
            SettingsMainSALoggingHelper.advancedSettingClickedSALogging(key);
        }
        return super.onPreferenceClick(preference);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, key)) {
            updateHideScrollbarWhileEditing();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, key)) {
            updateHideNavigationBarWhileEditing();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, key)) {
            updateBlockBackKeyWhileEditing();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateHideScrollbarWhileEditing();
        updateHideNavigationBarWhileEditing();
        updateBlockBackKeyWhileEditing();
    }
}
