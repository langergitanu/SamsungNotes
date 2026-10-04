package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.util.Pair;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreferenceCompat;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.TextViewPreference;
import com.samsung.android.support.senl.p148nt.base.common.cms.ExternalLinkUtil;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.C0287e;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsNotesAssistOnDeviceFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "mPrivacyNoticeLinkActions", "", "Ljava/lang/Runnable;", "[Ljava/lang/Runnable;", "onCreatePreferences", "", "bundle", "Landroid/os/Bundle;", "s", "", "onSwitchPreventOnlineProcessing", "switchPreference", "Landroidx/preference/SwitchPreferenceCompat;", "onDestroy", "initToolbar", "onResume", "initNotesAssistSwitch", "initNotesAssistPrivacyNotice", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsNotesAssistOnDeviceFragment extends SettingsBaseFragment {

    @NotNull
    private static final String SETTINGS_NOTES_ASSIST_PRIVACY_NOTICE = "settings_notes_assist_privacy_notice";

    @NotNull
    public static final String TAG = "SettingsNotesAssistOnDeviceFragment";

    @NotNull
    private final Runnable[] mPrivacyNoticeLinkActions = {new RunnableC0284b(14), new RunnableC0284b(15)};

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
            MainLogger.m7254d(TAG, "initNotesAssistPrivacyNotice# startOfLink : " + iM14129C + ", endOfLink : " + iM14129C2);
        }
        SpannableString spannableString = new SpannableString(string);
        int length2 = this.mPrivacyNoticeLinkActions.length;
        for (final int i2 = 0; i2 < length2; i2++) {
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsNotesAssistOnDeviceFragment.initNotesAssistPrivacyNotice.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    SettingsNotesAssistOnDeviceFragment.this.mPrivacyNoticeLinkActions[i2].run();
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

    private final void initNotesAssistSwitch() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY);
        if (switchPreferenceCompat == null) {
            return;
        }
        onSwitchPreventOnlineProcessing((SwitchPreferenceCompat) findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY));
        switchPreferenceCompat.setOnPreferenceChangeListener(new C0287e(switchPreferenceCompat, this, 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initNotesAssistSwitch$lambda$5(final SwitchPreferenceCompat switchPreferenceCompat, SettingsNotesAssistOnDeviceFragment settingsNotesAssistOnDeviceFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        if (Intrinsics.areEqual(Boolean.valueOf(switchPreferenceCompat.isChecked()), obj)) {
            return true;
        }
        MainLogger.m7254d(TAG, "onPreferenceChange# key : " + preference.getKey() + ", state : " + obj);
        final Boolean bool = (Boolean) obj;
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.STATUS_SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY, bool.booleanValue() ? "1" : "2");
        final int i = 0;
        final int i2 = 1;
        AiCommonUtil.toggleSummaryFeature(settingsNotesAssistOnDeviceFragment.getActivity(), bool.booleanValue(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.e
            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        SettingsNotesAssistOnDeviceFragment.initNotesAssistSwitch$lambda$5$lambda$3(switchPreferenceCompat, bool);
                        break;
                    default:
                        SettingsNotesAssistOnDeviceFragment.initNotesAssistSwitch$lambda$5$lambda$4(switchPreferenceCompat, bool);
                        break;
                }
            }
        }, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.e
            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        SettingsNotesAssistOnDeviceFragment.initNotesAssistSwitch$lambda$5$lambda$3(switchPreferenceCompat, bool);
                        break;
                    default:
                        SettingsNotesAssistOnDeviceFragment.initNotesAssistSwitch$lambda$5$lambda$4(switchPreferenceCompat, bool);
                        break;
                }
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNotesAssistSwitch$lambda$5$lambda$3(SwitchPreferenceCompat switchPreferenceCompat, Object obj) {
        switchPreferenceCompat.setChecked(((Boolean) obj).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNotesAssistSwitch$lambda$5$lambda$4(SwitchPreferenceCompat switchPreferenceCompat, Object obj) {
        switchPreferenceCompat.setChecked(!((Boolean) obj).booleanValue());
    }

    private final void initToolbar() {
        ((Toolbar) requireActivity().findViewById(C8003R.id.toolbar)).setTitle(C8003R.string.settings_notes_assist_on_device_summarize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPrivacyNoticeLinkActions$lambda$0() {
        ExternalLinkUtil.linkPrivacyNotice(BaseUtils.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPrivacyNoticeLinkActions$lambda$1() {
        ExternalLinkUtil.linkTermsAndCondition(BaseUtils.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreatePreferences$lambda$2(SettingsNotesAssistOnDeviceFragment settingsNotesAssistOnDeviceFragment) {
        settingsNotesAssistOnDeviceFragment.onSwitchPreventOnlineProcessing((SwitchPreferenceCompat) settingsNotesAssistOnDeviceFragment.findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY));
    }

    private final void onSwitchPreventOnlineProcessing(SwitchPreferenceCompat switchPreference) {
        if (switchPreference == null) {
            return;
        }
        switchPreference.setChecked(SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY, false));
        switchPreference.setEnabled(!AiActionStatus.isPreventOnlineProcessing());
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY_PREVENT_ONLINE_CATEGORY);
        if (preferenceCategory == null) {
            return;
        }
        preferenceCategory.removeAll();
        if (switchPreference.isEnabled()) {
            return;
        }
        TextViewPreference textViewPreference = new TextViewPreference(getContext());
        textViewPreference.setTitle(getString(C8003R.string.settings_notes_assist_on_device_summarize_prevent_online));
        textViewPreference.setSelectable(false);
        preferenceCategory.addPreference(textViewPreference);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String s) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings");
        getPreferenceManager().setSharedPreferencesName("Settings");
        addPreferencesFromResource(C8003R.xml.settings_notes_assist_ondevice_preference);
        initToolbar();
        initNotesAssistSwitch();
        initNotesAssistPrivacyNotice();
        AiCommonUtil.registerSettingsListener(getActivity(), new C7737b(this, 21));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AiCommonUtil.unregisterSettingsListener(getActivity());
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onSwitchPreventOnlineProcessing((SwitchPreferenceCompat) findPreference(SettingsConstants.SETTINGS_NOTES_ASSIST_ON_DEVICE_SUMMARY));
    }
}
