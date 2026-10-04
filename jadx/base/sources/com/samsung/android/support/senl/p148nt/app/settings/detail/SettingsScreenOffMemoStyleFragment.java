package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.preference.Preference;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.ImageViewPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.RadioButtonPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0002J\u0006\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0003J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsScreenOffMemoStyleFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "Landroidx/preference/Preference$OnPreferenceClickListener;", "<init>", "()V", "mRadioButtonKeys", "", "", "[Ljava/lang/String;", "onCreatePreferences", "", "bundle", "Landroid/os/Bundle;", "s", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "initLayout", "updateLayout", "getPreviewImageResource", "", "saveType", "onPreferenceClick", "", "preference", "Landroidx/preference/Preference;", "getSaveTypeFromPreferenceKey", "key", "getKeyFromSaveType", "getDescriptionFromSaveType", "insertSALog", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsScreenOffMemoStyleFragment extends SettingsBaseFragment implements Preference.OnPreferenceClickListener {

    @NotNull
    private static final String SETTINGS_SCREEN_OFF_MEMO_STYLE_PREVIEW = "settings_screen_off_memo_style_preview";

    @NotNull
    public static final String TAG = "SettingsScreenOffMemoStyleFragment";

    @NotNull
    private final String[] mRadioButtonKeys = {SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_BLACK_BACKGROUND, SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_WHITE_BACKGROUND, SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_BLACK_PEN_ON_WHITE_BACKGROUND};

    @StringRes
    private final int getDescriptionFromSaveType(int saveType) {
        if (saveType == 0) {
            return C8003R.string.settings_screen_off_memo_style_original_pen_on_black_background;
        }
        if (saveType == 1) {
            return C8003R.string.settings_screen_off_memo_style_original_pen_on_white_background;
        }
        if (saveType == 2) {
            return C8003R.string.settings_screen_off_memo_style_black_pen_on_white_background;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(saveType, "unexpected saveType: "));
    }

    private final String getKeyFromSaveType(int saveType) {
        if (saveType == 0) {
            return SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_BLACK_BACKGROUND;
        }
        if (saveType == 1) {
            return SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_WHITE_BACKGROUND;
        }
        if (saveType == 2) {
            return SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_BLACK_PEN_ON_WHITE_BACKGROUND;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(saveType, "unexpected saveType: "));
    }

    @DrawableRes
    private final int getPreviewImageResource(int saveType) {
        if (saveType == 0) {
            return DeviceUtils.isTabletModel() ? C8003R.drawable.settings_img_help_tablet_02 : C8003R.drawable.settings_img_help_02;
        }
        if (saveType == 1) {
            return DeviceUtils.isTabletModel() ? C8003R.drawable.settings_img_help_tablet_01 : C8003R.drawable.settings_img_help_01;
        }
        if (saveType == 2) {
            return DeviceUtils.isTabletModel() ? C8003R.drawable.settings_img_help_tablet_03 : C8003R.drawable.settings_img_help_03;
        }
        AbstractC8014b.m7201c(saveType, "unexpected saveType: ", TAG);
        return 0;
    }

    private final int getSaveTypeFromPreferenceKey(String key) {
        int iHashCode = key.hashCode();
        if (iHashCode != 555354271) {
            if (iHashCode != 834322709) {
                if (iHashCode == 1466795311 && key.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_WHITE_BACKGROUND)) {
                    return 1;
                }
            } else if (key.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_BLACK_PEN_ON_WHITE_BACKGROUND)) {
                return 2;
            }
        } else if (key.equals(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE_ORIGINAL_PEN_ON_BLACK_BACKGROUND)) {
            return 0;
        }
        throw new IllegalArgumentException("unexpected key: ".concat(key));
    }

    private final void initLayout() {
        for (String str : this.mRadioButtonKeys) {
            Preference preferenceFindPreference = findPreference(str);
            if (preferenceFindPreference != null) {
                preferenceFindPreference.setOnPreferenceClickListener(this);
            }
        }
    }

    private final void insertSALog(int saveType) {
        AbstractC8014b.m7201c(saveType, "insertSALog# saveType : ", TAG);
        if (saveType == 0) {
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SCREEN_OFF_MEMO_STYLE, SettingsSAConstants.EVENT_LOOK_WHEN_SAVED_SAME_AS_SCREEN_OFF_MEMO);
            return;
        }
        if (saveType == 1) {
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SCREEN_OFF_MEMO_STYLE, SettingsSAConstants.EVENT_LOOK_WHEN_SAVED_PEN_COLOR_ON_WHITE_BG);
        } else if (saveType != 2) {
            AbstractC8014b.m7201c(saveType, "unexpected saveType: ", TAG);
        } else {
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SCREEN_OFF_MEMO_STYLE, SettingsSAConstants.EVENT_LOOK_WHEN_SAVED_BLACK_COLOR_ON_WHITE_BG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String s) {
        addPreferencesFromResource(C8003R.xml.settings_screen_off_memo_style_preference);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(@NotNull Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        AbstractC0000a.m25v("onPreferenceClick# key : ", key, TAG);
        try {
            Intrinsics.checkNotNull(key);
            int saveTypeFromPreferenceKey = getSaveTypeFromPreferenceKey(key);
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, saveTypeFromPreferenceKey);
            insertSALog(saveTypeFromPreferenceKey);
            updateLayout();
            return true;
        } catch (IllegalArgumentException e) {
            AbstractC6670b.m4738C("onPreferenceClick# error: ", e.getMessage(), TAG);
            return false;
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initLayout();
        updateLayout();
    }

    public final void updateLayout() {
        int i = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, 0);
        MainLogger.m7254d(TAG, "initLayout# saveType : " + i);
        ImageViewPreference imageViewPreference = (ImageViewPreference) findPreference(SETTINGS_SCREEN_OFF_MEMO_STYLE_PREVIEW);
        if (imageViewPreference != null) {
            imageViewPreference.setImageResource(getPreviewImageResource(i));
            imageViewPreference.setContentDescription(getDescriptionFromSaveType(i));
            int dimension = (int) getResources().getDimension(C8003R.dimen.look_of_saved_som_help_img_padding_top_bottom);
            imageViewPreference.setPaddingRelative(0, dimension, 0, dimension);
        }
        String keyFromSaveType = getKeyFromSaveType(i);
        for (String str : this.mRadioButtonKeys) {
            try {
                RadioButtonPreference radioButtonPreference = (RadioButtonPreference) findPreference(str);
                if (radioButtonPreference != null) {
                    radioButtonPreference.setChecked(Intrinsics.areEqual(str, keyFromSaveType));
                }
            } catch (ClassCastException e) {
                AbstractC6670b.m4738C("updateLayout# error# ", e.getMessage(), TAG);
            }
        }
    }
}
