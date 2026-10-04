package com.samsung.android.support.senl.p148nt.app.settings.main;

import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.cms.ExternalLinkUtil;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsPrivacyHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "mIsFromSamsungInternet", "", "value", "isFromSamsungInternet", "()Z", "setFromSamsungInternet", "(Z)V", "initialize", "", "initPrivacyNotice", "initPermissions", "onPreferenceClick", "preference", "Landroidx/preference/Preference;", "tag", "", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsPrivacyHelper extends AbsSettingsHelper {

    @NotNull
    private static final String TAG = "SettingsPrivacyHelper";
    private boolean mIsFromSamsungInternet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsPrivacyHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    private final void initPermissions() {
        Preference preferenceFindPreference;
        PreferenceCategory preferenceCategory = (PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_PRIVACY_CATEGORY);
        if (preferenceCategory == null || (preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_PERMISSIONS)) == null) {
            return;
        }
        if (SettingsMenuUtils.INSTANCE.isPermissionsSupported()) {
            preferenceFindPreference.setOnPreferenceClickListener(this);
        } else {
            preferenceCategory.removePreference(preferenceFindPreference);
        }
    }

    private final void initPrivacyNotice() {
        Preference preferenceFindPreference;
        if (((PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_PRIVACY_CATEGORY)) == null || (preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_PRIVACY_NOTICE)) == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
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
        initPrivacyNotice();
        initPermissions();
    }

    /* JADX INFO: renamed from: isFromSamsungInternet, reason: from getter */
    public final boolean getMIsFromSamsungInternet() {
        return this.mIsFromSamsungInternet;
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
            SettingsMainSALoggingHelper.mainSettingClickedSALogging(key);
            if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_PERMISSIONS)) {
                getFragment().startSettingsActivity(key);
            } else if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_PRIVACY_NOTICE)) {
                this.mIsFromSamsungInternet = true;
                ExternalLinkUtil.INSTANCE.linkPersonalInfoPolicy(getFragment().getContext());
            } else {
                MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
            }
        }
        return true;
    }

    public final void setFromSamsungInternet(boolean z) {
        this.mIsFromSamsungInternet = z;
    }
}
