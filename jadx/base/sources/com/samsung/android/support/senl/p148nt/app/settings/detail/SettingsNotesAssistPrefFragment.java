package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreferenceCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.settings.SettingsActivity;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SwitchPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.app.settings.detail.noteassist.NotesAssistNoticesPreference;
import com.samsung.android.support.senl.p148nt.base.common.cms.ExternalLinkUtil;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AIFeatureInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0202d;
import p079T.C0287e;
import p079T.RunnableC0284b;
import p091W2.C0331a;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\b\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J\b\u0010*\u001a\u00020\u000eH\u0002J\b\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\b\u0010-\u001a\u00020\u000eH\u0002J\b\u0010.\u001a\u00020\u000eH\u0016J\b\u0010/\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsNotesAssistPrefFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "mAddBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "mRemoveBroadcastReceiver", "mPrivacyNoticeLinkActions", "", "Ljava/lang/Runnable;", "[Ljava/lang/Runnable;", "mPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "updateLanguageList", "", "onCreatePreferences", "bundle", "Landroid/os/Bundle;", "s", "", "initPreference", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initNotesAssistSwitch", "onNoteAssistSwitchCheckChanged", "checked", "", "onNoteAssistPreferenceChanged", "state", "updateNotesAssistSwitch", "updateNotesAssistNoticesConfigurationChanged", "initNotesAssistSensitiveDataNotice", "initNotesAssistPrivacyNotice", "initNotesAssistAutoDetectLanguage", "updateAutoDetectLanguage", "initNotesAssistAutoTranscribe", "updateAutoTranscribe", "initNotesAssistOnDevice", "updateNotesAssistOnDevice", "initNotesAssistLanguagePackForDownload", "updateNotesAssistLanguagePackForDownloadSummary", "updateNotesAssistLanguagePackForDownloadEnabledState", "updateNotesAssistLanguagePackForDownloadSummaryColor", "initNotesAssistMoreAdvancedIntelligenceFeature", "onDestroy", "setBroadcastReceiver", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsNotesAssistPrefFragment extends SettingsBaseFragment {

    @NotNull
    private static final String SETTINGS_NOTES_ASSIST_NOTICES = "settings_notes_assist_notices";

    @NotNull
    private static final String SETTINGS_NOTES_ASSIST_PRIVACY_NOTICE = "settings_notes_assist_privacy_notice";

    @NotNull
    private static final String SETTINGS_NOTES_ASSIST_SENSITIVE_DATA_NOTICE = "settings_notes_assist_sensitive_data_notice";

    @NotNull
    public static final String TAG = "SettingsNotesAssistPrefFragment";

    @Nullable
    private BroadcastReceiver mAddBroadcastReceiver;

    @Nullable
    private BroadcastReceiver mRemoveBroadcastReceiver;

    @NotNull
    private final Runnable[] mPrivacyNoticeLinkActions = {new RunnableC0284b(16), new RunnableC0284b(17)};

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 2);

    public SettingsNotesAssistPrefFragment() {
        setBroadcastReceiver();
    }

    private final void initNotesAssistAutoDetectLanguage() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE);
        if (preferenceFindPreference == null) {
            return;
        }
        SettingsMenuUtils settingsMenuUtils = SettingsMenuUtils.INSTANCE;
        if (!settingsMenuUtils.isAutoDetectLanguageSupported() || !settingsMenuUtils.isAutoDetectLanguageVisible() || !settingsMenuUtils.isSupportSTTAutoDetectLanguage()) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE_CATEGORY);
            if (preferenceCategory == null) {
                return;
            } else {
                preferenceCategory.removePreference(preferenceFindPreference);
            }
        }
        updateAutoDetectLanguage();
    }

    private final void initNotesAssistAutoTranscribe() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE);
        if (preferenceFindPreference == null) {
            return;
        }
        if (!SettingsMenuUtils.INSTANCE.isAutoTranscribeSupported() || !SettingsMenuUtils.isAutoTranscribeVisible()) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE_CATEGORY);
            if (preferenceCategory == null) {
                return;
            } else {
                preferenceCategory.removePreference(preferenceFindPreference);
            }
        }
        updateAutoTranscribe();
    }

    private final void initNotesAssistLanguagePackForDownload() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD);
        if (preferenceFindPreference == null) {
            return;
        }
        preferenceFindPreference.setOnPreferenceClickListener(new C8782f(this, 3));
        updateNotesAssistLanguagePackForDownloadSummary();
        updateNotesAssistLanguagePackForDownloadEnabledState();
        updateNotesAssistLanguagePackForDownloadSummaryColor();
        AiLanguageHelper.initTranslateConfig(new RunnableC8783g(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initNotesAssistLanguagePackForDownload$lambda$14(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AiLanguageHelper.setSelectTranslationLanguageActivity(settingsNotesAssistPrefFragment.getActivity(), C8003R.string.settings_notes_assist_language_pack_for_download, C8003R.string.settings_notes_assist_language_pack_for_download_description);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.EVENT_SETTINGS_NOTES_ASSIST_LANGUAGE_PACKS);
        return false;
    }

    private final void initNotesAssistMoreAdvancedIntelligenceFeature() {
        Intent intent;
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_MORE_GALAXY_AI_FEATURE);
        if (preferenceFindPreference == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || !Intrinsics.areEqual(SettingsConstants.KEY_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS, intent.getAction()) || !AiViewUtils.isAtLeastOneUI85()) {
            preferenceFindPreference.setOnPreferenceClickListener(new C8782f(this, 0));
            return;
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_MORE_GALAXY_AI_FEATURE_CATEGORY);
        if (preferenceCategory != null) {
            preferenceCategory.removePreference(preferenceFindPreference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initNotesAssistMoreAdvancedIntelligenceFeature$lambda$17(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intent intent = new Intent();
        intent.setAction("com.samsung.android.settings.action.INTELLIGENCE_SERVICE_GLOBAL_SETTINGS");
        settingsNotesAssistPrefFragment.startActivity(intent);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.EVENT_SETTINGS_NOTES_ASSIST_MORE_ADVANCED_INTELLIGENCE_FEATURES);
        return false;
    }

    private final void initNotesAssistOnDevice() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY);
        if (preferenceFindPreference == null) {
            return;
        }
        if (SettingsMenuUtils.INSTANCE.isNotesAssistOnDeviceSummaryVisible()) {
            try {
                preferenceFindPreference.setOnPreferenceClickListener(new C8782f(this, 2));
            } catch (IllegalStateException e) {
                AbstractC6670b.m4738C("initNotesAssistOnDevice# ", e.getMessage(), TAG);
            }
            updateNotesAssistOnDevice();
            return;
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        getPreferenceScreen().removePreference(preferenceCategory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initNotesAssistOnDevice$lambda$13(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        settingsNotesAssistPrefFragment.swapOtherFragment(10);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.EVENT_SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY);
        return false;
    }

    private final void initNotesAssistPrivacyNotice() {
        Preference preferenceFindPreference = findPreference(SETTINGS_NOTES_ASSIST_PRIVACY_NOTICE);
        if (preferenceFindPreference == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String string = getString(C8003R.string.settings_notes_assist_privacy_notice, ContentUtils.HASH_SYMBOL, ContentUtils.HASH_SYMBOL, ContentUtils.HASH_SYMBOL, ContentUtils.HASH_SYMBOL);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int length = this.mPrivacyNoticeLinkActions.length;
        for (int i = 0; i < length; i++) {
            int iM14129C = StringsKt.m14129C(ContentUtils.HASH_SYMBOL, 0, 6, string);
            if (iM14129C >= 0) {
                string = new Regex(ContentUtils.HASH_SYMBOL).replaceFirst(string, "");
            }
            int iM14129C2 = StringsKt.m14129C(ContentUtils.HASH_SYMBOL, 0, 6, string);
            if (iM14129C2 >= 0) {
                string = new Regex(ContentUtils.HASH_SYMBOL).replaceFirst(string, "");
            }
            if (iM14129C != -1 && iM14129C2 != -1) {
                Pair pairCreate = Pair.create(Integer.valueOf(iM14129C), Integer.valueOf(iM14129C2));
                Intrinsics.checkNotNullExpressionValue(pairCreate, "create(...)");
                arrayList.add(pairCreate);
            }
            MainLogger.m7258i(TAG, "initNotesAssistPrivacyNotice# startOfLink : " + iM14129C + ", endOfLink : " + iM14129C2);
        }
        SpannableString spannableString = new SpannableString(string);
        int length2 = this.mPrivacyNoticeLinkActions.length;
        for (final int i2 = 0; i2 < length2; i2++) {
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsNotesAssistPrefFragment.initNotesAssistPrivacyNotice.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    SettingsNotesAssistPrefFragment.this.mPrivacyNoticeLinkActions[i2].run();
                }
            };
            Object first = ((Pair) arrayList.get(i2)).first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            int iIntValue = ((Number) first).intValue();
            Object second = ((Pair) arrayList.get(i2)).second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            spannableString.setSpan(clickableSpan, iIntValue, ((Number) second).intValue(), 0);
            Context applicationContext = BaseUtils.getApplicationContext();
            ForegroundColorSpan foregroundColorSpan = applicationContext != null ? new ForegroundColorSpan(applicationContext.getColor(C8003R.color.settings_notes_assist_link_color)) : null;
            Object first2 = ((Pair) arrayList.get(i2)).first;
            Intrinsics.checkNotNullExpressionValue(first2, "first");
            int iIntValue2 = ((Number) first2).intValue();
            Object second2 = ((Pair) arrayList.get(i2)).second;
            Intrinsics.checkNotNullExpressionValue(second2, "second");
            spannableString.setSpan(foregroundColorSpan, iIntValue2, ((Number) second2).intValue(), 33);
            MetricAffectingSpan linkTypefaceSpan = ExternalLinkUtil.getLinkTypefaceSpan();
            Object first3 = ((Pair) arrayList.get(i2)).first;
            Intrinsics.checkNotNullExpressionValue(first3, "first");
            int iIntValue3 = ((Number) first3).intValue();
            Object second3 = ((Pair) arrayList.get(i2)).second;
            Intrinsics.checkNotNullExpressionValue(second3, "second");
            spannableString.setSpan(linkTypefaceSpan, iIntValue3, ((Number) second3).intValue(), 33);
        }
        preferenceFindPreference.setTitle(spannableString);
    }

    private final void initNotesAssistSensitiveDataNotice() {
        Preference preferenceFindPreference = findPreference(SETTINGS_NOTES_ASSIST_SENSITIVE_DATA_NOTICE);
        if (preferenceFindPreference == null) {
            return;
        }
        if (SystemPropertiesCompat.INSTANCE.getInstance().isKoreaModel()) {
            if (DeviceInfo.isVSTModel()) {
                preferenceFindPreference.setTitle(C8003R.string.settings_notes_assist_sensitive_data_notice_kor_vst);
                return;
            } else if (DeviceUtils.isTabletModel()) {
                preferenceFindPreference.setTitle(C8003R.string.settings_notes_assist_sensitive_data_notice_kor_tablet);
                return;
            } else {
                preferenceFindPreference.setTitle(C8003R.string.settings_notes_assist_sensitive_data_notice_kor);
                return;
            }
        }
        if (DeviceInfo.isVSTModel()) {
            preferenceFindPreference.setTitle(C8003R.string.settings_notes_assist_sensitive_data_notice_vst);
        } else if (DeviceUtils.isTabletModel()) {
            preferenceFindPreference.setTitle(C8003R.string.settings_notes_assist_sensitive_data_notice_tablet);
        } else {
            preferenceFindPreference.setTitle(C8003R.string.settings_notes_assist_sensitive_data_notice);
        }
    }

    private final void initNotesAssistSwitch() {
        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST);
        if (switchPreference == null) {
            return;
        }
        switchPreference.setTagRes(C8003R.string.settings_notes_assist);
        switchPreference.setChecked(AiActionStatus.isAiFeatureEnable());
        MainLogger.m7258i(TAG, "initNotesAssistSwitch#init status: " + switchPreference.isChecked());
        switchPreference.setOnPreferenceClickListener(new C8776a(switchPreference, 1));
        switchPreference.setOnCheckedChangeListener(new C0331a(this, 6));
        switchPreference.setOnPreferenceChangeListener(new C0287e(switchPreference, this, 13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initNotesAssistSwitch$lambda$10(SwitchPreference switchPreference, SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        if (Intrinsics.areEqual(Boolean.valueOf(switchPreference.isChecked()), obj)) {
            return true;
        }
        MainLogger.m7258i(TAG, "onPreferenceChange# key : " + preference.getKey() + ", state : " + obj);
        settingsNotesAssistPrefFragment.onNoteAssistPreferenceChanged(((Boolean) obj).booleanValue());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initNotesAssistSwitch$lambda$6(SwitchPreference switchPreference, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        MainLogger.m7258i(TAG, "initNotesAssistSwitch#onPreferenceClickListener");
        switchPreference.setChecked(!switchPreference.isChecked());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNotesAssistSwitch$lambda$9(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        MainLogger.m7258i(TAG, "initNotesAssistSwitch#setOnCheckedChangeListener - isChecked: " + z);
        if (!z) {
            settingsNotesAssistPrefFragment.onNoteAssistSwitchCheckChanged(false);
            return;
        }
        boolean zIsNoticedServerAiFeature = AiCommonUtil.isNoticedServerAiFeature();
        boolean z2 = !zIsNoticedServerAiFeature;
        if (!zIsNoticedServerAiFeature) {
            buttonView.setChecked(false);
        }
        AiCommonUtil.executeActionWithSettings(settingsNotesAssistPrefFragment.getActivity(), new RunnableC0202d(z2, buttonView, settingsNotesAssistPrefFragment, 4), new RunnableC8515c(buttonView, settingsNotesAssistPrefFragment, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNotesAssistSwitch$lambda$9$lambda$7(boolean z, CompoundButton compoundButton, SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment) {
        MainLogger.m7258i(TAG, "initNotesAssistSwitch#executeActionWithSettings-action");
        if (z) {
            compoundButton.setChecked(true);
        }
        settingsNotesAssistPrefFragment.onNoteAssistSwitchCheckChanged(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNotesAssistSwitch$lambda$9$lambda$8(CompoundButton compoundButton, SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment) {
        MainLogger.m7258i(TAG, "initNotesAssistSwitch#executeActionWithSettings-cancel");
        if (SettingsMenuUtils.isNotesAssistVisible()) {
            compoundButton.setChecked(false);
        } else {
            settingsNotesAssistPrefFragment.requireActivity().finish();
        }
    }

    private final void initPreference() {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        companion.getInstance("Settings");
        getPreferenceManager().setSharedPreferencesName("Settings");
        addPreferencesFromResource(C8003R.xml.settings_notes_assist_preference);
        initNotesAssistSwitch();
        initNotesAssistSensitiveDataNotice();
        initNotesAssistPrivacyNotice();
        initNotesAssistAutoTranscribe();
        initNotesAssistAutoDetectLanguage();
        initNotesAssistOnDevice();
        initNotesAssistLanguagePackForDownload();
        initNotesAssistMoreAdvancedIntelligenceFeature();
        companion.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPreferenceChangeListener$lambda$2(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, SharedPreferences sharedPreferences, String str) {
        if (!Intrinsics.areEqual(SettingsConstants.SETTINGS_NOTES_ASSIST, str)) {
            if (Intrinsics.areEqual(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE, str)) {
                settingsNotesAssistPrefFragment.updateAutoDetectLanguage();
            }
        } else {
            settingsNotesAssistPrefFragment.updateNotesAssistSwitch();
            settingsNotesAssistPrefFragment.updateAutoTranscribe();
            settingsNotesAssistPrefFragment.updateAutoDetectLanguage();
            settingsNotesAssistPrefFragment.updateNotesAssistOnDevice();
            settingsNotesAssistPrefFragment.updateNotesAssistLanguagePackForDownloadEnabledState();
            settingsNotesAssistPrefFragment.updateNotesAssistLanguagePackForDownloadSummaryColor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPrivacyNoticeLinkActions$lambda$0() {
        ExternalLinkUtil.linkPrivacyNotice(BaseUtils.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPrivacyNoticeLinkActions$lambda$1() {
        ExternalLinkUtil.linkTermsAndCondition(BaseUtils.getApplicationContext());
    }

    private final void onNoteAssistPreferenceChanged(boolean state) {
        MainLogger.m7258i(TAG, "onNoteAssistPreferenceChanged#state: " + state);
        AiActionStatus.setAiFeatureEnable(state, false);
        updateNotesAssistLanguagePackForDownloadEnabledState();
        updateNotesAssistLanguagePackForDownloadSummaryColor();
    }

    private final void onNoteAssistSwitchCheckChanged(boolean checked) {
        MainLogger.m7258i(TAG, "onNoteAssistSwitchCheckChanged#checked: " + checked);
        if (checked == AiActionStatus.isAiFeatureEnable()) {
            return;
        }
        AiActionStatus.setAiFeatureEnable(checked, false);
        updateNotesAssistLanguagePackForDownloadEnabledState();
        updateNotesAssistLanguagePackForDownloadSummaryColor();
    }

    private final void setBroadcastReceiver() {
        updateLanguageList();
        this.mAddBroadcastReceiver = AiLanguageHelper.registerLanguagePackAddedReceiver(BaseUtils.getApplicationContext(), new AiLanguageHelper.LanguagePackAddedReceiver() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsNotesAssistPrefFragment.setBroadcastReceiver.1
            @Override // com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.LanguagePackAddedReceiver, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (context == null || intent == null) {
                    Logger.m8697d(SettingsNotesAssistPrefFragment.TAG, "LanguagePackAddedReceiver received but null");
                } else {
                    AbstractC4539a.m3188B("LanguagePackAddedReceiver received", intent.getStringExtra("locale"), SettingsNotesAssistPrefFragment.TAG);
                    SettingsNotesAssistPrefFragment.this.updateLanguageList();
                }
            }
        });
        this.mRemoveBroadcastReceiver = AiLanguageHelper.registerLanguagePackRemovedReceiver(BaseUtils.getApplicationContext(), new AiLanguageHelper.LanguagePackRemovedReceiver() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsNotesAssistPrefFragment.setBroadcastReceiver.2
            @Override // com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.LanguagePackRemovedReceiver, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (context == null || intent == null) {
                    Logger.m8697d(SettingsNotesAssistPrefFragment.TAG, "LanguagePackRemovedReceiver received but null");
                } else {
                    AbstractC4539a.m3188B("LanguagePackRemovedReceiver received", intent.getStringExtra("locale"), SettingsNotesAssistPrefFragment.TAG);
                    SettingsNotesAssistPrefFragment.this.updateLanguageList();
                }
            }
        });
    }

    private final void updateAutoDetectLanguage() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE);
        if (switchPreferenceCompat == null) {
            return;
        }
        try {
            switchPreferenceCompat.setChecked(SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE, true));
            switchPreferenceCompat.setEnabled(AiActionStatus.isAiFeatureEnable());
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("updateNotesAssistSwitch# ", e.getMessage(), TAG);
        }
    }

    private final void updateAutoTranscribe() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_AUTO_TRANSCRIBE);
        if (preferenceFindPreference == null) {
            return;
        }
        try {
            preferenceFindPreference.setEnabled(AiActionStatus.isAiFeatureEnable());
            preferenceFindPreference.setOnPreferenceClickListener(new C8782f(this, 1));
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("updateAutoTranscribe# ", e.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateAutoTranscribe$lambda$12(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intent intent = new Intent();
        FragmentActivity activity = settingsNotesAssistPrefFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        intent.setClass(activity, SettingsActivity.class);
        intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 14);
        settingsNotesAssistPrefFragment.startActivity(intent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLanguageList() {
        CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        AiLanguageHelper.updateLanguageList(new RunnableC8783g(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLanguageList$lambda$5$lambda$4(SettingsNotesAssistPrefFragment settingsNotesAssistPrefFragment) {
        CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        settingsNotesAssistPrefFragment.updateNotesAssistLanguagePackForDownloadSummary();
    }

    private final void updateNotesAssistLanguagePackForDownloadEnabledState() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD);
        if (preferenceFindPreference == null) {
            return;
        }
        try {
            preferenceFindPreference.setEnabled(AiActionStatus.isAiFeatureEnable());
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("updateNotesAssistLanguagePackForDownloadEnabledState# ", e.getMessage(), TAG);
        }
    }

    private final void updateNotesAssistLanguagePackForDownloadSummary() {
        MainLogger.m7254d(TAG, "updateNotesAssistLanguagePackForDownloadSummary# ");
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD);
        if (preferenceFindPreference == null) {
            return;
        }
        String settingsOnDeviceLanguageListString = AiLanguageHelper.INSTANCE.getSettingsOnDeviceLanguageListString();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD, settingsOnDeviceLanguageListString);
        try {
            preferenceFindPreference.setSummary(settingsOnDeviceLanguageListString);
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("updateNotesAssistLanguagePackForDownloadSummary# ", e.getMessage(), TAG);
        }
    }

    private final void updateNotesAssistLanguagePackForDownloadSummaryColor() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD);
        if (preferenceFindPreference == null) {
            return;
        }
        try {
            preferenceFindPreference.seslSetSummaryColor(SettingsMenuUtils.INSTANCE.getSummaryColor(getContext(), true, preferenceFindPreference.isEnabled()));
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("updateNotesAssistLanguagePackForDownloadSummaryColor# ", e.getMessage(), TAG);
        }
    }

    private final void updateNotesAssistNoticesConfigurationChanged() {
        NotesAssistNoticesPreference notesAssistNoticesPreference = (NotesAssistNoticesPreference) findPreference(SETTINGS_NOTES_ASSIST_NOTICES);
        if (notesAssistNoticesPreference == null) {
            return;
        }
        notesAssistNoticesPreference.onConfigurationChanged();
    }

    private final void updateNotesAssistOnDevice() {
        Preference preferenceFindPreference = findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY);
        if (preferenceFindPreference == null) {
            return;
        }
        try {
            preferenceFindPreference.setEnabled(AiActionStatus.isAiFeatureEnable());
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("updateNotesAssistSwitch# ", e.getMessage(), TAG);
        }
    }

    private final void updateNotesAssistSwitch() {
        SwitchPreference switchPreference = (SwitchPreference) findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST);
        if (switchPreference == null) {
            return;
        }
        boolean zIsAiActionStatusEnabledWithSettings = AiCommonUtil.isAiActionStatusEnabledWithSettings();
        boolean zIsAiFeatureEnable = AiActionStatus.isAiFeatureEnable();
        MainLogger.m7258i(TAG, "updateNotesAssistSwitch, statusEnabled: " + zIsAiActionStatusEnabledWithSettings + ", featureEnabled: " + zIsAiFeatureEnable);
        switchPreference.setChecked(zIsAiActionStatusEnabledWithSettings && zIsAiFeatureEnable);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateNotesAssistNoticesConfigurationChanged();
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
        RequestToSCloudManager.Companion companion = RequestToSCloudManager.INSTANCE;
        if ((companion.getInstance().isWiFiAvailable() || companion.getInstance().isDataNetworkAvailable()) && RequestToSamsungAccountManager.INSTANCE.isLogined() && !DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext()) && SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_LOCAL_CHANGED, false)) {
            AIFeatureInfoManager.requestAIFeatureInfo();
        }
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateNotesAssistSwitch();
        updateLanguageList();
    }
}
