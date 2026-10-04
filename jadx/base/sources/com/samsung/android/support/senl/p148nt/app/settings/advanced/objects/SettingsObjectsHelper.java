package com.samsung.android.support.senl.p148nt.app.settings.advanced.objects;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreferenceCompat;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMainFragment;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMainSALoggingHelper;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.permission.DeepSkyPermissionHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\"\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010$\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/objects/SettingsObjectsHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "initialize", "", "updatePreference", "onPreferenceClick", "", "preference", "Landroidx/preference/Preference;", "onPreferenceChange", "newValue", "", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "initActionIcons", "updateActionIcons", "initShowLinksInNotes", "updateShowLinksInNotes", "initShowWebPreviews", "updateShowWebPreviews", "initClippingOptions", "updateClippingOptions", "showSmartSuggestionDataUsagePermissionSettingDialog", "handleActivityResults", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "tag", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsObjectsHelper extends AbsSettingsHelper {
    private static final int REQUEST_SMART_SUGGESTION_DATA_USAGE_PERMISSION = 3;

    @NotNull
    private static final String TAG = "SettingsObjectsHelper";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsObjectsHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    private final void initActionIcons() {
        Preference preference = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_ACTION_ICONS);
        Context context = getFragment().getContext();
        if (preference == null || context == null) {
            return;
        }
        if (SettingsMenuUtils.isActionIconsSupported(context)) {
            preference.setSummary(SettingsMenuUtils.getActionIconsSummaryRes(context));
            preference.setEnabled(SettingsMenuUtils.isActionIconsEnabled(context));
            preference.setOnPreferenceClickListener(this);
            preference.setOnPreferenceChangeListener(this);
            return;
        }
        PreferenceGroup parent = preference.getParent();
        if (parent != null) {
            parent.removePreference(preference);
        }
    }

    private final void initClippingOptions() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_CLIPPING_OPTIONS);
        Context context = getFragment().getContext();
        if (switchPreferenceCompat == null || context == null) {
            return;
        }
        if (!SettingsMenuUtils.isClippingOptionsSupported()) {
            PreferenceGroup parent = switchPreferenceCompat.getParent();
            if (parent != null) {
                parent.removePreference(switchPreferenceCompat);
                return;
            }
            return;
        }
        switchPreferenceCompat.setEnabled(SettingsMenuUtils.isClippingOptionsEnabled());
        switchPreferenceCompat.setChecked(SettingsMenuUtils.isClippingOptionsChecked());
        int[] clippingOptionsSummary = SettingsMenuUtils.getClippingOptionsSummary(context);
        int i = clippingOptionsSummary[1];
        if (i == -1) {
            switchPreferenceCompat.setSummary(clippingOptionsSummary[0]);
        } else {
            switchPreferenceCompat.setSummary(context.getString(clippingOptionsSummary[0], context.getString(i)));
        }
        switchPreferenceCompat.setOnPreferenceClickListener(this);
        switchPreferenceCompat.setOnPreferenceChangeListener(this);
    }

    private final void initShowLinksInNotes() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
        preferenceFindPreference.setOnPreferenceChangeListener(this);
    }

    private final void initShowWebPreviews() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
        preferenceFindPreference.setOnPreferenceChangeListener(this);
    }

    private final void showSmartSuggestionDataUsagePermissionSettingDialog() {
        MainLogger.m7254d(SettingsMainFragment.TAG, "showSmartSuggestionDataUsagePermissionSettingDialog#");
        try {
            getFragment().startActivityForResult(DeepSkyPermissionHelper.getIntentForAllowDataUsagePermissionSettingDialog(), 3);
        } catch (ActivityNotFoundException e) {
            AbstractC6670b.m4738C("showGotoPermissionSettingDialog# ", e.getMessage(), SettingsMainFragment.TAG);
        }
    }

    private final void updateActionIcons() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_ACTION_ICONS);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "updateActionIcons# preference is not visible");
            return;
        }
        boolean zIsActionIconsChecked = SettingsMenuUtils.isActionIconsChecked();
        MainLogger.m7258i(TAG, "updateActionIcons# isChecked: " + zIsActionIconsChecked);
        switchPreferenceCompat.setChecked(zIsActionIconsChecked);
    }

    private final void updateClippingOptions() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_CLIPPING_OPTIONS);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "updateClippingOptions# preference is not visible");
            return;
        }
        boolean zIsClippingOptionsChecked = SettingsMenuUtils.isClippingOptionsChecked();
        MainLogger.m7258i(TAG, "updateClippingOptions# isChecked: " + zIsClippingOptionsChecked);
        switchPreferenceCompat.setChecked(zIsClippingOptionsChecked);
    }

    private final void updateShowLinksInNotes() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "updateShowLinksInNotes# preference is not visible");
            return;
        }
        boolean zIsShowLinksInNoteChecked = SettingsMenuUtils.isShowLinksInNoteChecked();
        MainLogger.m7258i(TAG, "updateShowLinksInNotes# isChecked: " + zIsShowLinksInNoteChecked);
        switchPreferenceCompat.setChecked(zIsShowLinksInNoteChecked);
    }

    private final void updateShowWebPreviews() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "updateShowWebPreviews# preference is not visible");
            return;
        }
        boolean zIsShowWebPreviewsChecked = SettingsMenuUtils.isShowWebPreviewsChecked();
        MainLogger.m7258i(TAG, "updateShowWebPreviews# isChecked: " + zIsShowWebPreviewsChecked);
        switchPreferenceCompat.setChecked(zIsShowWebPreviewsChecked);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public boolean handleActivityResults(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != 3) {
            return super.handleActivityResults(requestCode, resultCode, data);
        }
        if (resultCode != -1) {
            return false;
        }
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, true);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initialize() {
        super.initialize();
        initActionIcons();
        initShowLinksInNotes();
        initShowWebPreviews();
        initClippingOptions();
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
                SettingsMainSALoggingHelper.advancedSettingChangedSALogging(key, zBooleanValue);
                if (!Intrinsics.areEqual(key, SettingsConstants.SETTINGS_CLIPPING_OPTIONS)) {
                    MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
                } else if (zBooleanValue && !DeepSkyPermissionHelper.isAllGrantedPermission()) {
                    showSmartSuggestionDataUsagePermissionSettingDialog();
                    return false;
                }
            }
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
        super.onSharedPreferenceChanged(sharedPreferences, key);
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_ACTION_ICONS, key)) {
            updateActionIcons();
            return;
        }
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, key)) {
            updateShowLinksInNotes();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, key)) {
            updateShowWebPreviews();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, key)) {
            updateClippingOptions();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateActionIcons();
        updateShowLinksInNotes();
        updateShowWebPreviews();
        updateClippingOptions();
    }
}
