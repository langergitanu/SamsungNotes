package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SwitchPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.detail.autotranscrible.AutoTranscribeNoticesPreference;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer;
import com.samsung.android.support.senl.p148nt.stt.view.language.STTLanguageManager;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p079T.C0287e;
import p091W2.C0331a;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsAutoTranscribePrefFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "mCurrentLanguage", "", "mAddBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "mRemoveBroadcastReceiver", "mLanguagePackSelectedReceiver", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$STTLanguagePackSelectedReceiver;", "mPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "updateLanguageList", "", "onCreatePreferences", "bundle", "Landroid/os/Bundle;", "s", "initPreference", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initAutoTranscribeSwitch", "updateAutoTranscribeNoticesConfigurationChanged", "onAutoTranscribeSwitchCheckChanged", "checked", "", "onAutoTranscribePreferenceChanged", "state", "updateAutoTranscribeSwitch", "initAutoTranscribeLanguagePackForDownload", "updateAutoTranscriptionLanguageSummary", "updateAutoTranscriptionLanguageEnabledState", "updateAutoTranscriptionLanguageSummaryColor", "onDestroy", "setBroadcastReceiver", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsAutoTranscribePrefFragment extends SettingsBaseFragment {

    @NotNull
    private static final String SETTINGS_AUTO_TRANSCRIBE_NOTICES = "settings_auto_transcribe_notices";

    @NotNull
    public static final String TAG = "SettingsNotesAssistPrefFragment#AutoTranscribe";

    @Nullable
    private BroadcastReceiver mAddBroadcastReceiver;

    @NotNull
    private String mCurrentLanguage = "";

    @NotNull
    private AiLanguageHelper.STTLanguagePackSelectedReceiver mLanguagePackSelectedReceiver = new AiLanguageHelper.STTLanguagePackSelectedReceiver();

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 1);

    @Nullable
    private BroadcastReceiver mRemoveBroadcastReceiver;

    public SettingsAutoTranscribePrefFragment() {
        setBroadcastReceiver();
    }

    private final void initAutoTranscribeLanguagePackForDownload() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(new C7737b(this, 19));
        updateAutoTranscriptionLanguageSummary();
        updateAutoTranscriptionLanguageEnabledState();
        updateAutoTranscriptionLanguageSummaryColor();
        AiLanguageHelper.initTranslateConfig(new RunnableC8777b(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initAutoTranscribeLanguagePackForDownload$lambda$5(SettingsAutoTranscribePrefFragment settingsAutoTranscribePrefFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AiLanguageHelper.setSelectModeTranslationLanguageActivity(settingsAutoTranscribePrefFragment.getActivity(), C8003R.string.settings_notes_assist_language_pack_for_download, C8003R.string.f6020x3a912c57);
        return false;
    }

    private final void initAutoTranscribeSwitch() {
        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE);
        if (switchPreference == null) {
            return;
        }
        switchPreference.setTagRes(C8003R.string.settings_auto_transcribe);
        switchPreference.setChecked(AiActionStatus.isAutoTranscribeEnable());
        switchPreference.setOnPreferenceClickListener(new C8776a(switchPreference, 0));
        switchPreference.setOnCheckedChangeListener(new C0331a(this, 5));
        switchPreference.setOnPreferenceChangeListener(new C0287e(switchPreference, this, 11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initAutoTranscribeSwitch$lambda$2(SwitchPreference switchPreference, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        switchPreference.setChecked(!switchPreference.isChecked());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAutoTranscribeSwitch$lambda$3(SettingsAutoTranscribePrefFragment settingsAutoTranscribePrefFragment, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        if (z) {
            STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
            companion.initLanguageData();
            List<String> downloadedLocaleList = companion.getDownloadedLocaleList();
            if (downloadedLocaleList == null || downloadedLocaleList.isEmpty()) {
                MainLogger.m7258i(TAG, "updateAutoTranscribeSwitch# no language pack available");
                AiLanguageHelper.setSelectModeTranslationLanguageActivity(settingsAutoTranscribePrefFragment.getActivity(), C8003R.string.settings_notes_assist_language_pack_for_download, C8003R.string.f6020x3a912c57);
            }
            settingsAutoTranscribePrefFragment.onAutoTranscribeSwitchCheckChanged(true);
        } else {
            settingsAutoTranscribePrefFragment.onAutoTranscribeSwitchCheckChanged(false);
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS_AUTO_TRANSCRIBE, SettingsSAConstants.EVENT_SETTINGS_AUTO_TRANSCRIBE_SWITCH, z ? "1" : "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initAutoTranscribeSwitch$lambda$4(SwitchPreference switchPreference, SettingsAutoTranscribePrefFragment settingsAutoTranscribePrefFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        if (Intrinsics.areEqual(Boolean.valueOf(switchPreference.isChecked()), obj)) {
            return true;
        }
        MainLogger.m7258i(TAG, "onPreferenceChange# key : " + preference.getKey() + ", state : " + obj);
        settingsAutoTranscribePrefFragment.onAutoTranscribePreferenceChanged(((Boolean) obj).booleanValue());
        return false;
    }

    private final void initPreference() {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        companion.getInstance("Settings");
        getPreferenceManager().setSharedPreferencesName("Settings");
        addPreferencesFromResource(C8003R.xml.settings_auto_transcribe_preference);
        initAutoTranscribeSwitch();
        initAutoTranscribeLanguagePackForDownload();
        companion.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPreferenceChangeListener$lambda$0(SettingsAutoTranscribePrefFragment settingsAutoTranscribePrefFragment, SharedPreferences sharedPreferences, String str) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE, str)) {
            settingsAutoTranscribePrefFragment.updateAutoTranscribeSwitch();
            settingsAutoTranscribePrefFragment.updateAutoTranscriptionLanguageEnabledState();
            settingsAutoTranscribePrefFragment.updateAutoTranscriptionLanguageSummaryColor();
        }
    }

    private final void onAutoTranscribePreferenceChanged(boolean state) {
        AiActionStatus.setAutoTranscribeEnable(state);
        updateAutoTranscriptionLanguageEnabledState();
        updateAutoTranscriptionLanguageSummaryColor();
    }

    private final void onAutoTranscribeSwitchCheckChanged(boolean checked) {
        AiActionStatus.setAutoTranscribeEnable(checked);
        updateAutoTranscriptionLanguageEnabledState();
        updateAutoTranscriptionLanguageSummaryColor();
    }

    private final void setBroadcastReceiver() {
        updateLanguageList();
        this.mAddBroadcastReceiver = AiLanguageHelper.registerLanguagePackAddedReceiver(BaseUtils.getApplicationContext(), new AiLanguageHelper.LanguagePackAddedReceiver() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsAutoTranscribePrefFragment.setBroadcastReceiver.1
            @Override // com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.LanguagePackAddedReceiver, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (context == null || intent == null) {
                    MainLogger.m7254d(SettingsAutoTranscribePrefFragment.TAG, "LanguagePackAddedReceiver received but null");
                } else {
                    AbstractC0000a.m25v("LanguagePackAddedReceiver received", intent.getStringExtra("locale"), SettingsAutoTranscribePrefFragment.TAG);
                    SettingsAutoTranscribePrefFragment.this.updateLanguageList();
                }
            }
        });
        this.mRemoveBroadcastReceiver = AiLanguageHelper.registerLanguagePackRemovedReceiver(BaseUtils.getApplicationContext(), new AiLanguageHelper.LanguagePackRemovedReceiver() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsAutoTranscribePrefFragment.setBroadcastReceiver.2
            @Override // com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.LanguagePackRemovedReceiver, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (context == null || intent == null) {
                    MainLogger.m7254d(SettingsAutoTranscribePrefFragment.TAG, "LanguagePackRemovedReceiver received but null");
                } else {
                    AbstractC0000a.m25v("LanguagePackRemovedReceiver received", intent.getStringExtra("locale"), SettingsAutoTranscribePrefFragment.TAG);
                    SettingsAutoTranscribePrefFragment.this.updateLanguageList();
                }
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AiLanguageHelper.registerLanguagePackSelectedReceiver(activity, this.mLanguagePackSelectedReceiver);
        }
    }

    private final void updateAutoTranscribeNoticesConfigurationChanged() {
        AutoTranscribeNoticesPreference autoTranscribeNoticesPreference = (AutoTranscribeNoticesPreference) findPreference(SETTINGS_AUTO_TRANSCRIBE_NOTICES);
        if (autoTranscribeNoticesPreference == null) {
            return;
        }
        autoTranscribeNoticesPreference.onConfigurationChanged();
    }

    private final void updateAutoTranscribeSwitch() {
        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE);
        if (switchPreference == null) {
            return;
        }
        boolean zIsAiActionStatusEnabledWithSettings = AiCommonUtil.isAiActionStatusEnabledWithSettings();
        boolean zIsAutoTranscribeEnable = AiActionStatus.isAutoTranscribeEnable();
        MainLogger.m7258i(TAG, "updateAutoTranscribeSwitch, statusEnabled: " + zIsAiActionStatusEnabledWithSettings + ", featureEnabled: " + zIsAutoTranscribeEnable);
        switchPreference.setChecked(zIsAiActionStatusEnabledWithSettings && zIsAutoTranscribeEnable);
    }

    private final void updateAutoTranscriptionLanguageEnabledState() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE);
        if (preferenceFindPreference == null) {
            return;
        }
        try {
            preferenceFindPreference.setEnabled(AiActionStatus.isAutoTranscribeEnable());
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("updateAutoTranscriptionLanguageEnabledState# ", e.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAutoTranscriptionLanguageSummary() {
        String languageTag;
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE);
        if (preferenceFindPreference == null) {
            return;
        }
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        String str = "";
        String string = companion.getInstance("Settings").getString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, "");
        this.mCurrentLanguage = String.valueOf(string);
        STTLanguageManager companion2 = STTLanguageManager.INSTANCE.getInstance();
        companion2.initLanguageData();
        if (companion2.isLanguageTagInstalled(string)) {
            str = string;
        } else {
            MainLogger.m7258i(TAG, "updateAutoTranscriptionLanguageSummary# language not downloaded, update back to null");
            companion.getInstance("Settings").putString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, "");
        }
        Locale locale = AiLanguageHelper.getLocale(str);
        Locale defaultDeviceLocale = ScsRecognizer.INSTANCE.getDefaultDeviceLocale();
        if (locale != null) {
            try {
                languageTag = locale.toLanguageTag();
            } catch (IllegalStateException e) {
                AbstractC6670b.m4738C("updateAutoTranscriptionLanguageSummary# ", e.getMessage(), TAG);
                return;
            }
        } else {
            languageTag = null;
        }
        if (languageTag != null && languageTag.length() != 0) {
            preferenceFindPreference.setSummary(AiLanguageHelper.getDisplayName(locale));
            return;
        }
        if (companion2.isLanguageTagInstalled(defaultDeviceLocale.toLanguageTag())) {
            preferenceFindPreference.setSummary(AiLanguageHelper.getDisplayName(defaultDeviceLocale));
            companion.getInstance("Settings").putString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, defaultDeviceLocale.toLanguageTag());
            return;
        }
        List<String> downloadedLocaleList = companion2.getDownloadedLocaleList();
        if (downloadedLocaleList != null && !downloadedLocaleList.isEmpty()) {
            List<String> downloadedLocaleList2 = companion2.getDownloadedLocaleList();
            Intrinsics.checkNotNull(downloadedLocaleList2);
            String str2 = downloadedLocaleList2.get(0);
            preferenceFindPreference.setSummary(AiLanguageHelper.getDisplayName(AiLanguageHelper.getLocale(str2)));
            companion.getInstance("Settings").putString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, str2);
            return;
        }
        onAutoTranscribeSwitchCheckChanged(false);
    }

    private final void updateAutoTranscriptionLanguageSummaryColor() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE);
        if (preferenceFindPreference == null) {
            return;
        }
        try {
            preferenceFindPreference.seslSetSummaryColor(SettingsMenuUtils.INSTANCE.getSummaryColor(getContext(), true, preferenceFindPreference.isEnabled()));
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("updateAutoTranscriptionLanguageSummaryColor# ", e.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLanguageList() {
        AiLanguageHelper.updateLanguageList(new RunnableC8777b(this, 1));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateAutoTranscribeNoticesConfigurationChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String s) {
        initPreference();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AiCommonUtil.releaseActionStatus(getActivity());
        if (this.mAddBroadcastReceiver != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(BaseUtils.getApplicationContext(), this.mAddBroadcastReceiver);
            this.mAddBroadcastReceiver = null;
        }
        if (this.mRemoveBroadcastReceiver != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(BaseUtils.getApplicationContext(), this.mRemoveBroadcastReceiver);
            this.mRemoveBroadcastReceiver = null;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            AiLanguageHelper.registerLanguagePackSelectedReceiver(applicationContext, this.mLanguagePackSelectedReceiver);
        }
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateAutoTranscribeSwitch();
        String string = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, "");
        if (!Intrinsics.areEqual(this.mCurrentLanguage, string)) {
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_SETTINGS_AUTO_TRANSCRIBE, SettingsSAConstants.EVENT_SETTINGS_AUTO_TRANSCRIBE_LANGUAGE, String.valueOf(string));
        }
        updateLanguageList();
    }
}
