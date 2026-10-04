package com.samsung.android.support.senl.p148nt.app.settings.common.helper;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J+\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0%2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0002\u0010(J\"\u0010)\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010-\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010.\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u00100\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/helper/AbsSettingsHelper;", "Landroidx/preference/Preference$OnPreferenceClickListener;", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "fragment", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;)V", "getFragment", "()Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "initialize", "", "initializeWithLifeCycleOwner", "releaseWithLifeCycleOwner", "onCreate", "onStart", "onResume", "onStop", "release", "updatePreference", "finishActivity", "onPreferenceClick", "", "preference", "Landroidx/preference/Preference;", "onPreferenceChange", "newValue", "", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "handleRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "handleActivityResults", "resultCode", "data", "Landroid/content/Intent;", "removePreference", "updatePreferenceVisibility", "isVisible", "tag", "getTag", "()Ljava/lang/String;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsSettingsHelper implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener, SharedPreferences.OnSharedPreferenceChangeListener {

    @NotNull
    private final SettingsBaseFragment fragment;

    public AbsSettingsHelper(@NotNull SettingsBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
    }

    public final void finishActivity() {
        FragmentActivity activity = this.fragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        Intrinsics.checkNotNull(activity);
        activity.finish();
    }

    @NotNull
    public final SettingsBaseFragment getFragment() {
        return this.fragment;
    }

    @NotNull
    public abstract String getTag();

    public boolean handleActivityResults(int requestCode, int resultCode, @Nullable Intent data) {
        return false;
    }

    public boolean handleRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        return false;
    }

    public void initialize() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").registerOnSharedPreferenceChangeListener(this);
    }

    public void initializeWithLifeCycleOwner() {
    }

    public void onCreate() {
    }

    public boolean onPreferenceChange(@NotNull Preference preference, @Nullable Object newValue) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        return true;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(@NotNull Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        return true;
    }

    public void onResume() {
    }

    public void onSharedPreferenceChanged(@Nullable SharedPreferences sharedPreferences, @Nullable String key) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void release() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this);
    }

    public void releaseWithLifeCycleOwner() {
    }

    public final void removePreference(@NotNull Preference preference) {
        PreferenceGroup parent;
        Intrinsics.checkNotNullParameter(preference, "preference");
        PreferenceGroup parent2 = preference.getParent();
        if (parent2 != null) {
            parent2.removePreference(preference);
            if (parent2.getPreferenceCount() != 0 || (parent = parent2.getParent()) == null) {
                return;
            }
            parent.removePreference(parent2);
        }
    }

    public void updatePreference() {
    }

    public final void updatePreferenceVisibility(@NotNull Preference preference, boolean isVisible) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        preference.setVisible(isVisible);
        if (isVisible) {
            PreferenceGroup parent = preference.getParent();
            if (parent != null) {
                parent.setVisible(true);
                return;
            }
            return;
        }
        PreferenceGroup parent2 = preference.getParent();
        if (parent2 != null) {
            int preferenceCount = parent2.getPreferenceCount();
            for (int i = 0; i < preferenceCount; i++) {
                if (parent2.getPreference(i).isVisible()) {
                    return;
                }
            }
            parent2.setVisible(false);
        }
    }
}
