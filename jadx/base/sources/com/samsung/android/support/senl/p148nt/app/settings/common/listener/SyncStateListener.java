package com.samsung.android.support.senl.p148nt.app.settings.common.listener;

import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.TwoStatePreference;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.dialog.GDPRDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.listener.SyncStateListener;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p011C0.InterfaceC0044a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/listener/SyncStateListener;", "LC0/a;", "Landroidx/fragment/app/FragmentActivity;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroidx/preference/PreferenceScreen;", "preferenceScreen", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/preference/PreferenceScreen;)V", "", "isEnable", "byUser", "", "onUpdate", "(ZZ)V", "release", "()V", "", SearchConstants.TargetContents.TAG, "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "mActivityWeakReference", "Ljava/lang/ref/WeakReference;", "mPreferenceScreenWeakReference", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SyncStateListener implements InterfaceC0044a {

    @NotNull
    private final String TAG;

    @Nullable
    private WeakReference<FragmentActivity> mActivityWeakReference;

    @Nullable
    private WeakReference<PreferenceScreen> mPreferenceScreenWeakReference;

    public SyncStateListener(@NotNull FragmentActivity activity, @NotNull PreferenceScreen preferenceScreen) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(preferenceScreen, "preferenceScreen");
        this.TAG = "SyncStateListener";
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.mPreferenceScreenWeakReference = new WeakReference<>(preferenceScreen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$0(SyncStateListener syncStateListener, boolean z, PreferenceScreen preferenceScreen, boolean z2, FragmentActivity fragmentActivity) {
        MainLogger.m7258i(syncStateListener.TAG, "onUpdate# " + z);
        Intrinsics.checkNotNull(preferenceScreen);
        Preference preferenceFindPreference = preferenceScreen.findPreference(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (preferenceFindPreference instanceof TwoStatePreference) {
            ((TwoStatePreference) preferenceFindPreference).setChecked(z);
        }
        if (z2) {
            GDPRDialogFragment.INSTANCE.newInstance().showAllowingStateLoss(fragmentActivity.getSupportFragmentManager(), GDPRDialogFragment.TAG);
        }
    }

    @Override // p011C0.InterfaceC0044a
    public void onUpdate(final boolean isEnable, final boolean byUser) {
        WeakReference<FragmentActivity> weakReference = this.mActivityWeakReference;
        Intrinsics.checkNotNull(weakReference);
        final FragmentActivity fragmentActivity = weakReference.get();
        WeakReference<PreferenceScreen> weakReference2 = this.mPreferenceScreenWeakReference;
        Intrinsics.checkNotNull(weakReference2);
        final PreferenceScreen preferenceScreen = weakReference2.get();
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        fragmentActivity.runOnUiThread(new Runnable() { // from class: V2.a
            @Override // java.lang.Runnable
            public final void run() {
                SyncStateListener.onUpdate$lambda$0(this.f840a, isEnable, preferenceScreen, byUser, fragmentActivity);
            }
        });
    }

    public final void release() {
        WeakReference<FragmentActivity> weakReference = this.mActivityWeakReference;
        Intrinsics.checkNotNull(weakReference);
        weakReference.clear();
        WeakReference<PreferenceScreen> weakReference2 = this.mPreferenceScreenWeakReference;
        Intrinsics.checkNotNull(weakReference2);
        weakReference2.clear();
        this.mActivityWeakReference = null;
        this.mPreferenceScreenWeakReference = null;
    }
}
