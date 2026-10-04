package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.SwitchPreferenceCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsSearchFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "mPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "", "initLayout", "initRecentTags", "onDestroyView", "registerPreferenceChangeListener", "unregisterPreferenceChangeListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsSearchFragment extends SettingsBaseFragment {

    @NotNull
    public static final String TAG = "SettingsSearchFragment";

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 3);

    private final void initLayout() {
        initRecentTags();
    }

    private final void initRecentTags() {
        SwitchPreferenceCompat switchPreferenceCompat;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.getIntent().getBooleanExtra(NotesConstants.KEY_TAG_VISIBLE, true) || (switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(NotesConstants.KEY_RECENT_TAGS)) == null) {
            return;
        }
        getPreferenceScreen().removePreference(switchPreferenceCompat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPreferenceChangeListener$lambda$0(SettingsSearchFragment settingsSearchFragment, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNull(str);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) settingsSearchFragment.findPreference(str);
        if (switchPreferenceCompat == null) {
            return;
        }
        switchPreferenceCompat.setChecked(sharedPreferences.getBoolean(str, true));
    }

    private final void registerPreferenceChangeListener() {
        SharedPreferencesCompat.INSTANCE.getInstance("SearchSettings").registerOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
    }

    private final void unregisterPreferenceChangeListener() {
        SharedPreferencesCompat.INSTANCE.getInstance("SearchSettings").unregisterOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        getPreferenceManager().setSharedPreferencesName("SearchSettings");
        getPreferenceManager().setSharedPreferencesMode(0);
        addPreferencesFromResource(C8003R.xml.settings_search_preference);
        initLayout();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        unregisterPreferenceChangeListener();
        super.onDestroyView();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.settings_list_background_color), null));
        registerPreferenceChangeListener();
    }
}
