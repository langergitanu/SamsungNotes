package com.samsung.android.support.senl.p148nt.app.settings.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\"\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J+\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150$2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsMainFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseFragment;", "<init>", "()V", "mSettingsSyncHelper", "Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsSyncHelper;", "mSettingsGeneralHelper", "Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsGeneralHelper;", "mSettingsIntelligenceHelper", "Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsIntelligenceHelper;", "mSettingsPrivacyHelper", "Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsPrivacyHelper;", "mSettingsMiscHelper", "Lcom/samsung/android/support/senl/nt/app/settings/main/SettingsMiscHelper;", "mIsTabletLayout", "", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onCreate", "onResume", "onStart", "onDestroy", "onStop", "updatePreference", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsMainFragment extends SettingsBaseFragment {

    @NotNull
    public static final String TAG = "ST$SettingsMainFragment";
    private boolean mIsTabletLayout;

    @NotNull
    private SettingsSyncHelper mSettingsSyncHelper = new SettingsSyncHelper(this);

    @NotNull
    private SettingsGeneralHelper mSettingsGeneralHelper = new SettingsGeneralHelper(this);

    @NotNull
    private SettingsIntelligenceHelper mSettingsIntelligenceHelper = new SettingsIntelligenceHelper(this);

    @NotNull
    private SettingsPrivacyHelper mSettingsPrivacyHelper = new SettingsPrivacyHelper(this);

    @NotNull
    private SettingsMiscHelper mSettingsMiscHelper = new SettingsMiscHelper(this);

    private final void updatePreference() {
        MainLogger.m7258i(TAG, "updatePreference()");
        this.mSettingsSyncHelper.updatePreference();
        this.mSettingsGeneralHelper.updatePreference();
        this.mSettingsIntelligenceHelper.updatePreference();
        this.mSettingsPrivacyHelper.updatePreference();
        this.mSettingsMiscHelper.updatePreference();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (this.mSettingsIntelligenceHelper.handleActivityResults(requestCode, resultCode, data) || this.mSettingsSyncHelper.handleActivityResults(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mIsTabletLayout = ResourceUtils.isTabletLayout(getContext());
        this.mSettingsSyncHelper.onCreate();
        this.mSettingsIntelligenceHelper.onCreate();
        this.mSettingsMiscHelper.onCreate();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, com.samsung.android.support.senl.p145cm.base.framework.sem.preference.PreferenceFragmentCompatCustom, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        getPreferenceManager().setSharedPreferencesName("Settings");
        getPreferenceManager().setSharedPreferencesMode(0);
        addPreferencesFromResource(C8003R.xml.settings_main_preference);
        this.mSettingsSyncHelper.initialize();
        this.mSettingsGeneralHelper.initialize();
        this.mSettingsIntelligenceHelper.initialize();
        this.mSettingsPrivacyHelper.initialize();
        this.mSettingsMiscHelper.initialize();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mSettingsSyncHelper.release();
        this.mSettingsGeneralHelper.release();
        this.mSettingsIntelligenceHelper.release();
        this.mSettingsPrivacyHelper.release();
        this.mSettingsMiscHelper.release();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (this.mSettingsSyncHelper.handleRequestPermissionsResult(requestCode, permissions, grantResults)) {
            return;
        }
        MainLogger.m7255e(TAG, "onRequestPermissionsResult# unexpected requestCode: " + requestCode);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MainLogger.m7258i(TAG, "onResume()");
        UserInputSkipper.releaseHoldingEventTimeByTag(UserInputSkipper.Tag.SettingsMain);
        updatePreference();
        this.mSettingsSyncHelper.onResume();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainLogger.m7258i(TAG, "onStart()");
        if (this.mSettingsPrivacyHelper.getMIsFromSamsungInternet()) {
            this.mSettingsPrivacyHelper.setFromSamsungInternet(false);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.semOverridePendingTransition(C8003R.anim.samsung_activity_close_enter, C8003R.anim.samsung_activity_close_exit);
            }
        }
        this.mSettingsSyncHelper.onStart();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MainLogger.m7258i(TAG, "onStop()");
        this.mSettingsSyncHelper.onStop();
    }
}
