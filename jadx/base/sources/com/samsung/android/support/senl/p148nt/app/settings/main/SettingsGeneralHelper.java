package com.samsung.android.support.senl.p148nt.app.settings.main;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.DropDownPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreferenceCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.externalsearch.SettingsSearchIndexingManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0006\u0010%\u001a\u00020\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsGeneralHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "mSPenSettingStateChangeListener", "Lcom/samsung/android/support/senl/nt/app/settings/externalsearch/SettingsSearchIndexingManager$SPenSettingStateChangeListener;", "initialize", "", "initDefaultNoteStyle", "initLockNotes", "initScreenOffMemoStyle", "initDefaultEditingMode", "initAutoSaveNotes", "release", "updatePreference", "updateScreenOffMemoStyleSummary", "updateDefaultEditingMode", "updateAutoSaveNotes", "onPreferenceChange", "", "preference", "Landroidx/preference/Preference;", "newValue", "", "handleSwitchPreferenceChange", "Landroidx/preference/SwitchPreferenceCompat;", "o", "onPreferenceClick", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "handleDropDownPreferenceChange", "Landroidx/preference/DropDownPreference;", "updateScreenOffMemoStyleVisibility", "tag", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsGeneralHelper extends AbsSettingsHelper {

    @NotNull
    private static final String TAG = "SettingsGeneralHelper";

    @Nullable
    private SettingsSearchIndexingManager.SPenSettingStateChangeListener mSPenSettingStateChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGeneralHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mSPenSettingStateChangeListener = new SettingsSearchIndexingManager.SPenSettingStateChangeListener() { // from class: com.samsung.android.support.senl.nt.app.settings.main.a
            @Override // com.samsung.android.support.senl.nt.app.settings.externalsearch.SettingsSearchIndexingManager.SPenSettingStateChangeListener
            public final void onChanged() {
                SettingsGeneralHelper.mSPenSettingStateChangeListener$lambda$0(this.f6329a);
            }
        };
    }

    private final boolean handleDropDownPreferenceChange(DropDownPreference preference, Object o) {
        if (!(o instanceof String)) {
            return false;
        }
        if (Intrinsics.areEqual(preference.getValue(), o)) {
            return true;
        }
        String value = preference.getValue();
        MainLogger.m7258i(TAG, "onPreferenceChange# key : " + value + ", state : " + o);
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, value)) {
            SettingsMenuUtils.INSTANCE.setDefaultEditingMode(getFragment().getContext(), (String) o);
        } else {
            AbstractC8014b.m7209k("unexpected key: ", value, TAG);
        }
        return true;
    }

    private final boolean handleSwitchPreferenceChange(SwitchPreferenceCompat preference, Object o) {
        String key;
        if (!(o instanceof Boolean)) {
            return false;
        }
        if (!Intrinsics.areEqual(Boolean.valueOf(preference.isChecked()), o) && (key = preference.getKey()) != null) {
            MainLogger.m7258i(TAG, "handleSwitchPreferenceChange# key : " + key + ", state : " + o);
            SettingsMainSALoggingHelper.mainSettingChangedSALogging(key, ((Boolean) o).booleanValue());
            if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_AUTO_SAVE_NOTES)) {
                updateAutoSaveNotes();
            } else {
                MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
            }
        }
        return true;
    }

    private final void initAutoSaveNotes() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
        preferenceFindPreference.setOnPreferenceChangeListener(this);
    }

    private final void initDefaultEditingMode() {
        DropDownPreference dropDownPreference;
        Context context = getFragment().getContext();
        if (context == null || (dropDownPreference = (DropDownPreference) getFragment().findPreference(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE)) == null) {
            return;
        }
        SettingsMenuUtils settingsMenuUtils = SettingsMenuUtils.INSTANCE;
        if (settingsMenuUtils.isDefaultEditingModeSupported()) {
            dropDownPreference.setValue(settingsMenuUtils.getDefaultEditingMode(context));
            dropDownPreference.seslSetSummaryColor(SettingsMenuUtils.getSummaryColor(context, true));
            dropDownPreference.setOnPreferenceClickListener(this);
        } else {
            PreferenceCategory preferenceCategory = (PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_GENERAL_CATEGORY);
            if (preferenceCategory == null) {
                return;
            }
            preferenceCategory.removePreference(dropDownPreference);
        }
    }

    private final void initDefaultNoteStyle() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_DEFAULT_NOTE_STYLE);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
    }

    private final void initLockNotes() {
        Preference preferenceFindPreference;
        Context context = getFragment().getContext();
        if (context == null || (preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_PASSWORD_AND_BIOMETRICS)) == null) {
            return;
        }
        preferenceFindPreference.setTitle(SettingsMenuUtils.getLockNotesTitleRes(context));
        if (SettingsMenuUtils.isLockNotesSupported(context)) {
            preferenceFindPreference.setOnPreferenceClickListener(this);
            return;
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_GENERAL_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        preferenceCategory.removePreference(preferenceFindPreference);
    }

    private final void initScreenOffMemoStyle() {
        Preference preferenceFindPreference;
        Context context = getFragment().getContext();
        if (context == null || (preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE)) == null) {
            return;
        }
        if (SettingsMenuUtils.isScreenOffMemoStyleSupported(context)) {
            preferenceFindPreference.seslSetSummaryColor(SettingsMenuUtils.getSummaryColor(context, true));
            preferenceFindPreference.setOnPreferenceClickListener(this);
        } else {
            PreferenceCategory preferenceCategory = (PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_GENERAL_CATEGORY);
            if (preferenceCategory == null) {
                return;
            }
            preferenceCategory.removePreference(preferenceFindPreference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSPenSettingStateChangeListener$lambda$0(SettingsGeneralHelper settingsGeneralHelper) {
        settingsGeneralHelper.updateScreenOffMemoStyleVisibility();
        SettingsSearchIndexingManager.requestIndexing();
    }

    private final void updateAutoSaveNotes() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) getFragment().findPreference(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES);
        if (switchPreferenceCompat == null) {
            return;
        }
        if (!switchPreferenceCompat.isVisible()) {
            MainLogger.m7258i(TAG, "updateAutoSaveNotes# preference is not visible");
            return;
        }
        boolean zIsAutoSaveNoteChecked = SettingsMenuUtils.isAutoSaveNoteChecked();
        MainLogger.m7258i(TAG, "updateAutoSaveNotes# isChecked: " + zIsAutoSaveNoteChecked);
        switchPreferenceCompat.setChecked(zIsAutoSaveNoteChecked);
    }

    private final void updateDefaultEditingMode() {
        DropDownPreference dropDownPreference = (DropDownPreference) getFragment().findPreference(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE);
        if (dropDownPreference == null) {
            return;
        }
        if (dropDownPreference.isVisible()) {
            dropDownPreference.setValue(SettingsMenuUtils.INSTANCE.getDefaultEditingMode(getFragment().getContext()));
        } else {
            MainLogger.m7258i(TAG, "updateDefaultEditingMode# preference is not visible");
        }
    }

    private final void updateScreenOffMemoStyleSummary() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE);
        if (preferenceFindPreference == null) {
            return;
        }
        int i = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, 0);
        MainLogger.m7258i(TAG, "updateScreenOffMemoStyleSummary : " + i);
        preferenceFindPreference.seslSetSummaryColor(SettingsMenuUtils.getSummaryColor(getFragment().getContext(), true));
        if (i == 0) {
            preferenceFindPreference.setSummary(C8003R.string.settings_screen_off_memo_style_original_pen_on_black_background);
        } else if (i != 1) {
            preferenceFindPreference.setSummary(C8003R.string.settings_screen_off_memo_style_black_pen_on_white_background);
        } else {
            preferenceFindPreference.setSummary(C8003R.string.settings_screen_off_memo_style_original_pen_on_white_background);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initialize() {
        super.initialize();
        MainLogger.m7254d(TAG, "initialize");
        initDefaultNoteStyle();
        initLockNotes();
        initScreenOffMemoStyle();
        initDefaultEditingMode();
        initAutoSaveNotes();
        SettingsSearchIndexingManager.SPenSettingStateChangeListener sPenSettingStateChangeListener = this.mSPenSettingStateChangeListener;
        if (sPenSettingStateChangeListener != null) {
            SettingsSearchIndexingManager.registerSPenSettingStateChangeListener(sPenSettingStateChangeListener);
        }
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
            return handleSwitchPreferenceChange((SwitchPreferenceCompat) preference, newValue);
        }
        if (!(preference instanceof DropDownPreference)) {
            return super.onPreferenceChange(preference, newValue);
        }
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance("Settings");
        Intrinsics.checkNotNull(newValue, "null cannot be cast to non-null type kotlin.String");
        companion.putString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, (String) newValue);
        return handleDropDownPreferenceChange((DropDownPreference) preference, newValue);
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
        if (key == null) {
            return true;
        }
        MainLogger.m7258i(TAG, "onPreferenceClick# key : ".concat(key));
        if (!preference.isEnabled()) {
            MainLogger.m7258i(TAG, "onPreferenceClick# preference is disabled ");
            return false;
        }
        SettingsMainSALoggingHelper.mainSettingClickedSALogging(key);
        int iHashCode = key.hashCode();
        if (iHashCode == -2012132363 ? !key.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE) : iHashCode == -974570453 ? !key.equals(SettingsConstants.SETTINGS_PASSWORD_AND_BIOMETRICS) : !(iHashCode == 940181886 && key.equals(SettingsConstants.SETTINGS_DEFAULT_NOTE_STYLE))) {
            MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
            return true;
        }
        getFragment().startSettingsActivity(key);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES, key)) {
            updateAutoSaveNotes();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, key)) {
            updateDefaultEditingMode();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, key)) {
            updateScreenOffMemoStyleSummary();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void release() {
        super.release();
        SettingsSearchIndexingManager.SPenSettingStateChangeListener sPenSettingStateChangeListener = this.mSPenSettingStateChangeListener;
        if (sPenSettingStateChangeListener != null) {
            SettingsSearchIndexingManager.unregisterSPenSettingStateChangeListener(sPenSettingStateChangeListener);
        }
        this.mSPenSettingStateChangeListener = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateScreenOffMemoStyleSummary();
        updateScreenOffMemoStyleVisibility();
        updateDefaultEditingMode();
        updateAutoSaveNotes();
    }

    public final void updateScreenOffMemoStyleVisibility() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setVisible(SettingsMenuUtils.isScreenOffMemoStyleVisible());
    }
}
