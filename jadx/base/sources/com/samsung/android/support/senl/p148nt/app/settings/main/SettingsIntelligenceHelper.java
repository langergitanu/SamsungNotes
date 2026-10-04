package com.samsung.android.support.senl.p148nt.app.settings.main;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsSwitchPreferenceScreen;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.external.GlobalSetting;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.PolicyManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\tJ\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsIntelligenceHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "mSTTlanguagePackSelectedReceiver", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$STTLanguagePackSelectedReceiver;", "isNoteAssistStartRequestedByExternalAction", "", "()Z", "initialize", "", "initNotesAssist", "initDrawingAssist", "onCreate", "release", "updatePreference", "updateNoteAssist", "updateDrawingAssist", "onPreferenceClick", "preference", "Landroidx/preference/Preference;", "startNoteAssistSettingActivity", "fromOtherApps", "handleActivityResults", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "tag", "", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsIntelligenceHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsIntelligenceHelper.kt\ncom/samsung/android/support/senl/nt/app/settings/main/SettingsIntelligenceHelper\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,181:1\n108#2:182\n80#2,22:183\n*S KotlinDebug\n*F\n+ 1 SettingsIntelligenceHelper.kt\ncom/samsung/android/support/senl/nt/app/settings/main/SettingsIntelligenceHelper\n*L\n40#1:182\n40#1:183,22\n*E\n"})
public final class SettingsIntelligenceHelper extends AbsSettingsHelper {

    @NotNull
    private static final String EXTRA_FROM_INTELLIGENCE_SETTING = "samsung_note_assist";

    @NotNull
    private static final String KEY_NOTES_ASSIST_FOR_ADVANCED_INTELLIGENCE = "key";

    @NotNull
    private static final String KEY_NOTES_ASSIST_FOR_TIPS = "com.android.settings.keyhint";

    @NotNull
    private static final String TAG = "SettingsIntelligenceHelper";

    @NotNull
    private final AiLanguageHelper.STTLanguagePackSelectedReceiver mSTTlanguagePackSelectedReceiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsIntelligenceHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mSTTlanguagePackSelectedReceiver = new AiLanguageHelper.STTLanguagePackSelectedReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleActivityResults$lambda$4(SettingsIntelligenceHelper settingsIntelligenceHelper) {
        if (settingsIntelligenceHelper.isNoteAssistStartRequestedByExternalAction()) {
            settingsIntelligenceHelper.startNoteAssistSettingActivity(true);
        }
    }

    private final void initDrawingAssist() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_DRAWING_ASSIST);
        if (preferenceFindPreference == null) {
            return;
        }
        SettingsMenuUtils settingsMenuUtils = SettingsMenuUtils.INSTANCE;
        if (!settingsMenuUtils.isDrawingAssistSupported()) {
            removePreference(preferenceFindPreference);
            return;
        }
        updatePreferenceVisibility(preferenceFindPreference, settingsMenuUtils.isDrawingAssistVisible());
        preferenceFindPreference.setTitle(SettingsMenuUtils.getDrawingAssistTitleRes());
        preferenceFindPreference.setEnabled(!PolicyManager.isEdmPolicyAiDrawingGrayout());
        preferenceFindPreference.setOnPreferenceClickListener(this);
    }

    private final void initNotesAssist() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST);
        if (preferenceFindPreference == null) {
            return;
        }
        if (!SettingsMenuUtils.INSTANCE.isNotesAssistSupported()) {
            removePreference(preferenceFindPreference);
            return;
        }
        updatePreferenceVisibility(preferenceFindPreference, SettingsMenuUtils.isNotesAssistVisible());
        preferenceFindPreference.setEnabled(!PolicyManager.isEdmPolicyAiGrayout());
        preferenceFindPreference.setOnPreferenceClickListener(this);
    }

    private final void updateDrawingAssist() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_DRAWING_ASSIST);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setVisible(SettingsMenuUtils.INSTANCE.isDrawingAssistVisible());
    }

    private final void updateNoteAssist() {
        Preference preferenceFindPreference = getFragment().findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setVisible(SettingsMenuUtils.isNotesAssistVisible());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public boolean handleActivityResults(int requestCode, int resultCode, @Nullable Intent data) {
        if (!PermissionHelper.onActivityResult(requestCode, resultCode, new RunnableC8669a(this, 14))) {
            return false;
        }
        finishActivity();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initialize() {
        super.initialize();
        MainLogger.m7254d(TAG, "initialize");
        initNotesAssist();
        initDrawingAssist();
        if (PermissionHelper.noticeAppPermissionIfNeededs(getFragment().getActivity()) || !isNoteAssistStartRequestedByExternalAction()) {
            return;
        }
        startNoteAssistSettingActivity(true);
    }

    public final boolean isNoteAssistStartRequestedByExternalAction() {
        Intent intent;
        FragmentActivity activity = getFragment().getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        boolean booleanExtra = intent.getBooleanExtra(SettingsConstants.KEY_FROM_TIPS, false);
        String str = booleanExtra ? "com.android.settings.keyhint" : "key";
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra == null) {
            return false;
        }
        MainLogger.m7254d(TAG, "isNoteAssistStartRequestedByExternalAction, fromTips: " + booleanExtra + ", checkKey: " + str + ", value: [" + stringExtra + "]");
        int length = stringExtra.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) stringExtra.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return Intrinsics.areEqual(EXTRA_FROM_INTELLIGENCE_SETTING, stringExtra.subSequence(i, length + 1).toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void onCreate() {
        AiLanguageHelper.registerLanguagePackSelectedReceiver(getFragment().getContext(), this.mSTTlanguagePackSelectedReceiver);
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
        if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_NOTES_ASSIST)) {
            startNoteAssistSettingActivity(false);
            return true;
        }
        if (Intrinsics.areEqual(key, SettingsConstants.SETTINGS_DRAWING_ASSIST)) {
            GlobalSetting.INSTANCE.launchAiDrawingSetting(new WeakReference<>(getFragment()));
            return true;
        }
        MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void release() {
        super.release();
        SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (settingsSwitchPreferenceScreen != null) {
            settingsSwitchPreferenceScreen.release();
        }
        AiCommonUtil.releaseActionStatus(getFragment().getActivity());
        AiLanguageHelper.unregisterLanguagePackReceiver(getFragment().getContext(), this.mSTTlanguagePackSelectedReceiver);
    }

    public final void startNoteAssistSettingActivity(boolean fromOtherApps) {
        MainLogger.m7258i(TAG, "startNoteAssistSettingActivity, fromOtherApps: " + fromOtherApps);
        getFragment().startSettingsActivity(SettingsConstants.SETTINGS_NOTES_ASSIST);
        if (fromOtherApps) {
            finishActivity();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateNoteAssist();
        updateDrawingAssist();
    }
}
