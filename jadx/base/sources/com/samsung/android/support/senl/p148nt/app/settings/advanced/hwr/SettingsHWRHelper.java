package com.samsung.android.support.senl.p148nt.app.settings.advanced.hwr;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.advanced.hwr.dialog.HWDBDownloadDialog;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsSwitchPreferenceScreen;
import com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsMainSALoggingHelper;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayLanguageUtils;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/hwr/SettingsHWRHelper;", "Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "initialize", "", "release", "updatePreference", "onPreferenceClick", "", "preference", "Landroidx/preference/Preference;", "onPreferenceChange", "newValue", "", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "initHWR", "updateHWR", "isHWRDBDownloaded", "showHWRDBDownloadDialog", "startHWRecognitionSetting", "mLanguageDownloadHelper", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/extractor/TextRecognitionLanguageDownloadHelper;", "getMLanguageDownloadHelper", "()Lcom/samsung/android/support/senl/nt/model/collector/recognition/extractor/TextRecognitionLanguageDownloadHelper;", "mLanguageDownloadHelper$delegate", "Lkotlin/Lazy;", "tag", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsHWRHelper extends AbsSettingsHelper {

    @NotNull
    private static final String TAG = "SettingsHWRHelper";

    /* JADX INFO: renamed from: mLanguageDownloadHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLanguageDownloadHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsHWRHelper(@NotNull SettingsBaseFragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mLanguageDownloadHelper = LazyKt.lazy(new C8753a(0));
    }

    private final TextRecognitionLanguageDownloadHelper getMLanguageDownloadHelper() {
        return (TextRecognitionLanguageDownloadHelper) this.mLanguageDownloadHelper.getValue();
    }

    private final void initHWR() {
        SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION);
        Context context = getFragment().getContext();
        if (settingsSwitchPreferenceScreen == null || context == null) {
            return;
        }
        settingsSwitchPreferenceScreen.setVisible(SettingsMenuUtils.isHWRLanguageSupported(context));
        if (!settingsSwitchPreferenceScreen.isVisible()) {
            MainLogger.m7258i(TAG, "initHWR# preference is not visible");
            return;
        }
        if (isHWRDBDownloaded() || RecognitionUtil.isHWREnabledChanged()) {
            settingsSwitchPreferenceScreen.setWidgetState(2);
            settingsSwitchPreferenceScreen.setChecked(RecognitionUtil.isHWREnabled());
            String hWRLanguage = RecognitionUtil.getHWRLanguage(context);
            Intrinsics.checkNotNullExpressionValue(hWRLanguage, "getHWRLanguage(...)");
            settingsSwitchPreferenceScreen.setSummary(DisplayLanguageUtils.getDisplayName(hWRLanguage));
        } else {
            settingsSwitchPreferenceScreen.setWidgetState(0);
        }
        settingsSwitchPreferenceScreen.seslSetSummaryColor(SettingsMenuUtils.getSummaryColor(context, true));
        settingsSwitchPreferenceScreen.setOnPreferenceClickListener(this);
        settingsSwitchPreferenceScreen.setOnPreferenceChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isHWRDBDownloaded() {
        return getMLanguageDownloadHelper().isExistedOnDeviceByDefaultLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRecognitionLanguageDownloadHelper mLanguageDownloadHelper_delegate$lambda$3() {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = new TextRecognitionLanguageDownloadHelper(BaseUtils.getApplicationContext());
        textRecognitionLanguageDownloadHelper.init(C0158a.m407a().m414e());
        return textRecognitionLanguageDownloadHelper;
    }

    private final void showHWRDBDownloadDialog() {
        HWDBDownloadDialog hWDBDownloadDialog = new HWDBDownloadDialog();
        hWDBDownloadDialog.init(getMLanguageDownloadHelper());
        hWDBDownloadDialog.setContract(new HWDBDownloadDialog.Contract() { // from class: com.samsung.android.support.senl.nt.app.settings.advanced.hwr.SettingsHWRHelper.showHWRDBDownloadDialog.1
            @Override // com.samsung.android.support.senl.nt.app.settings.advanced.hwr.dialog.HWDBDownloadDialog.Contract
            public void onDownloadCompleted() {
                if (SettingsHWRHelper.this.isHWRDBDownloaded()) {
                    RecognitionUtil.setHWREnabledChanged(true);
                    SettingsHWRHelper.this.startHWRecognitionSetting();
                }
            }
        });
        hWDBDownloadDialog.show(getFragment().getChildFragmentManager(), HWDBDownloadDialog.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startHWRecognitionSetting() {
        getFragment().startSettingsActivity(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION);
    }

    private final void updateHWR() {
        SettingsSwitchPreferenceScreen settingsSwitchPreferenceScreen = (SettingsSwitchPreferenceScreen) getFragment().findPreference(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION);
        if (settingsSwitchPreferenceScreen == null) {
            return;
        }
        if (!settingsSwitchPreferenceScreen.isVisible()) {
            MainLogger.m7258i(TAG, "updateHWR# preference is not visible");
            return;
        }
        if (!isHWRDBDownloaded() && !RecognitionUtil.isHWREnabledChanged()) {
            settingsSwitchPreferenceScreen.setWidgetState(0);
            settingsSwitchPreferenceScreen.setSummary("");
            return;
        }
        settingsSwitchPreferenceScreen.setWidgetState(2);
        settingsSwitchPreferenceScreen.setChecked(RecognitionUtil.isHWREnabled());
        String hWRLanguage = RecognitionUtil.getHWRLanguage(BaseUtils.getContext());
        Intrinsics.checkNotNullExpressionValue(hWRLanguage, "getHWRLanguage(...)");
        settingsSwitchPreferenceScreen.setSummary(DisplayLanguageUtils.getDisplayName(hWRLanguage));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void initialize() {
        super.initialize();
        initHWR();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(@NotNull Preference preference, @Nullable Object newValue) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        UserInputSkipper.setHoldingEventTime(100L, UserInputSkipper.Tag.SettingsMain);
        if (preference instanceof SwitchPreferenceCompat) {
            Intrinsics.checkNotNull(newValue, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) newValue).booleanValue();
            String key = ((SwitchPreferenceCompat) preference).getKey();
            if (key != null) {
                MainLogger.m7258i(TAG, "handleSwitchPreferenceChange# key : " + key + ", state : " + zBooleanValue);
                SettingsMainSALoggingHelper.advancedSettingChangedSALogging(key, zBooleanValue);
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
            if (!Intrinsics.areEqual(key, SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION)) {
                MainLogger.m7258i(TAG, "unexpected key: ".concat(key));
            } else if (isHWRDBDownloaded()) {
                startHWRecognitionSetting();
            } else {
                showHWRDBDownloadDialog();
            }
        }
        return super.onPreferenceClick(preference);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper, android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, key) || Intrinsics.areEqual(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, key)) {
            updateHWR();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void release() {
        super.release();
        MainLogger.m7254d(TAG, "release");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.helper.AbsSettingsHelper
    public void updatePreference() {
        super.updatePreference();
        updateHWR();
    }
}
