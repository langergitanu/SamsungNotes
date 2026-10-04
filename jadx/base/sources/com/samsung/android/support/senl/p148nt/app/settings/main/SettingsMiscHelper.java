package com.samsung.android.support.senl.p148nt.app.settings.main;

import android.content.Context;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.patternpalette.ViewOnClickListenerC7602a;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.UpdateTipCardPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.external.ContactUs;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsMiscHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "initialize", "", "initTipCard", "initAdvanced", "initContactUs", "initAboutNotes", "onCreate", "updatePreference", "updateTipCard", "updateAppUpdateBadge", "onPreferenceClick", "", "preference", "Landroidx/preference/Preference;", "tag", "", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsMiscHelper extends AbsSettingsHelper {

    @NotNull
    private static final String TAG = "SettingsMiscHelper";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsMiscHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    private final void initAboutNotes() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_ABOUT_NOTES);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
        preferenceFindPreference.setTitle(SettingsMenuUtils.getAboutSamsungNotesTitleRes());
    }

    private final void initAdvanced() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_ADVANCED);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(this);
    }

    private final void initContactUs() {
        Context context;
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_CONTACT_US);
        if (preferenceFindPreference == null || (context = getFragment().getContext()) == null) {
            return;
        }
        if (SettingsMenuUtils.isContactUsSupported(context)) {
            preferenceFindPreference.setOnPreferenceClickListener(this);
            return;
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) getFragment().findPreference(SettingsConstants.SETTINGS_ABOUT_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        preferenceCategory.removePreference(preferenceFindPreference);
    }

    private final void initTipCard() {
        UpdateTipCardPreference updateTipCardPreference = (UpdateTipCardPreference) getFragment().findPreference(SettingsConstants.SETTINGS_UPDATE_TIPCARD);
        if (updateTipCardPreference == null) {
            return;
        }
        updateTipCardPreference.setPositiveButtonClickListener(new ViewOnClickListenerC7602a(3)).setNeutralButtonClickListener(new ViewOnClickListenerC0219a(this, updateTipCardPreference, 9));
        updateTipCardPreference.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTipCard$lambda$0(View view) {
        MainLogger.m7258i(TAG, "TipCardButtonPositiveClickListener# onClick().");
        UpdateManager.getInstance().setHasTipCard(UpdateManager.getInstance().getPrefUserCheckedVersion());
        UpdateManager.getInstance().goToGalaxyAppStore();
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS, SettingsSAConstants.EVENT_APP_UPDATE_TIPCARD_UPDATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTipCard$lambda$1(SettingsMiscHelper settingsMiscHelper, UpdateTipCardPreference updateTipCardPreference, View view) {
        MainLogger.m7258i(TAG, "TipCardButtonCloseClickListener# onClick().");
        UpdateManager.getInstance().setHasTipCard(UpdateManager.getInstance().getPrefUserCheckedVersion());
        settingsMiscHelper.getFragment().getPreferenceScreen().removePreference(updateTipCardPreference);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS, SettingsSAConstants.EVENT_APP_UPDATE_TIPCARD_CLOSE);
    }

    private final void updateAppUpdateBadge() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_ABOUT_NOTES);
        if (preferenceFindPreference != null) {
            if (!preferenceFindPreference.isVisible()) {
                MainLogger.m7258i(TAG, "updateAppUpdateBadge# preference is not visible, ignore");
                return;
            }
            boolean zHasBadge = UpdateManager.getInstance().hasBadge();
            MainLogger.m7258i(TAG, "updateAppUpdateBadge# hasBadge: " + zHasBadge);
            preferenceFindPreference.setDotContentDescription(getFragment().getString(C8003R.string.badge_new_notification));
            preferenceFindPreference.setDotVisibility(zHasBadge);
        }
    }

    private final void updateTipCard() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_UPDATE_TIPCARD_DUMMY_CATEGORY);
        UpdateTipCardPreference updateTipCardPreference = (UpdateTipCardPreference) getFragment().findPreference(SettingsConstants.SETTINGS_UPDATE_TIPCARD);
        boolean zHasTipCard = UpdateManager.getInstance().hasTipCard();
        AbstractC6670b.m4739D("updateTipCard# hasTipCard: ", TAG, zHasTipCard);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setVisible(zHasTipCard);
        }
        if (updateTipCardPreference != null) {
            updateTipCardPreference.setVisible(zHasTipCard);
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
        initTipCard();
        initAdvanced();
        initAboutNotes();
        initContactUs();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void onCreate() {
        PermissionHelper.noticeAppPermissionIfNeededs(getFragment().getActivity());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        if (r0.equals(com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants.SETTINGS_ABOUT_NOTES) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        if (r0.equals(com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants.SETTINGS_ADVANCED) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        getFragment().startSettingsActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return true;
     */
    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        if (iHashCode != -328739650) {
            if (iHashCode != 623588723) {
                if (iHashCode == 1361973433 && key.equals(SettingsConstants.SETTINGS_CONTACT_US)) {
                    ContactUs.INSTANCE.launchContactUs(getFragment().getContext());
                    return true;
                }
            }
            MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
            return true;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateTipCard();
        updateAppUpdateBadge();
    }
}
