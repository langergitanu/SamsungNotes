package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.ButtonPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.TextViewPreference;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.TextureViewPreference;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsConvertOldNotesFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "onCreatePreferences", "", "bundle", "Landroid/os/Bundle;", "s", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initLayout", "initTextureLayout", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsConvertOldNotesFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsConvertOldNotesFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/SettingsConvertOldNotesFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
public final class SettingsConvertOldNotesFragment extends SettingsBaseFragment {

    @NotNull
    private static final String SETTINGS_BOTTOM_CATEGORY = "settings_bottom_category";

    @NotNull
    private static final String SETTINGS_CONVERT_OLD_NOTES = "settings_convert_your_notes";

    @NotNull
    private static final String SETTINGS_CONVERT_OLD_NOTES_BUTTON = "settings_convert_your_notes_button";

    @NotNull
    private static final String SETTINGS_CONVERT_OLD_NOTES_BUTTON_CATEGORY = "settings_convert_your_notes_button_category";

    @NotNull
    private static final String SETTINGS_CONVERT_OLD_NOTES_DESCRIPTION = "settings_convert_your_notes_description";

    @NotNull
    public static final String TAG = "SettingsConvertOldNotesFragment";

    private final void initLayout() {
        MainLogger.m7258i(TAG, "initConvertYourNotesLayout# ");
        int all_OldNotesCount = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createNotesOldDocumentRepository().getAll_OldNotesCount(0);
        TextViewPreference textViewPreference = (TextViewPreference) findPreference(SETTINGS_CONVERT_OLD_NOTES_DESCRIPTION);
        if (textViewPreference != null) {
            textViewPreference.setTitle(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.convert_notes_jp_desctiption : C8003R.string.convert_notes_desctiption);
        }
        initTextureLayout();
        Preference preferenceFindPreference = findPreference(SETTINGS_CONVERT_OLD_NOTES_BUTTON_CATEGORY);
        if (preferenceFindPreference != null) {
            preferenceFindPreference.seslSetSubheaderRoundedBackground(12);
        }
        ButtonPreference buttonPreference = (ButtonPreference) findPreference(SETTINGS_CONVERT_OLD_NOTES_BUTTON);
        if (buttonPreference != null) {
            buttonPreference.setText(getResources().getQuantityString(C8003R.plurals.plurals_convert_n_notes, all_OldNotesCount, Integer.valueOf(all_OldNotesCount)));
            buttonPreference.setOnClickListener(new ViewOnClickListenerC8556a(this, 4));
        }
        Preference preferenceFindPreference2 = findPreference(SETTINGS_BOTTOM_CATEGORY);
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.seslSetRoundedBg(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$1(SettingsConvertOldNotesFragment settingsConvertOldNotesFragment, View view) {
        MainLogger.m7258i(TAG, "onClick# ");
        Intent intent = new Intent();
        intent.setAction(NotesConstants.ACTION_CONVERT_SDOC_FROM_SETTINGS);
        FragmentActivity activity = settingsConvertOldNotesFragment.getActivity();
        if (activity != null) {
            NotesUtils.INSTANCE.backToNoteList(activity, intent);
        }
    }

    private final void initTextureLayout() {
        MainLogger.m7258i(TAG, "initTextureLayout# ");
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("settings_convert_your_notes");
        Context context = getContext();
        if (preferenceCategory == null || context == null) {
            return;
        }
        preferenceCategory.removeAll();
        Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + (DeviceUtils.isTabletModel() ? C8003R.raw.convert_old_note_video_tablet : C8003R.raw.convert_old_note_video_phone));
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        preferenceCategory.addPreference(new TextureViewPreference(context, uri));
        preferenceCategory.seslSetSubheaderRoundedBackground(3);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        initTextureLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String s) {
        addPreferencesFromResource(C8003R.xml.settings_convert_old_notes_preference);
        initLayout();
    }
}
