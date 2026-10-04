package com.samsung.android.support.senl.p148nt.app.settings.common.component;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0004J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0004J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\b\u0010 \u001a\u0004\u0018\u00010!J\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseNonPreferenceFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mCallee", "", "mActivityContainer", "Landroid/view/View;", "mAnimationCallback", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$AnimationCallback;", "mApplyInsetListener", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$ApplyInsetListener;", "callee", "getCallee", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "isCallFromOtherApps", "", "includeTips", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onResume", "updateListView", "updateListForVst", "updateListForMobile", "getSettingContents", "Landroid/view/ViewGroup;", "getFloatingBottomLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingBottomLayout;", "getFloatingToolbarLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;", "registerWindowInsetManager", "unregisterWindowInsetManager", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class SettingsBaseNonPreferenceFragment extends Fragment {

    @Nullable
    private View mActivityContainer;

    @NotNull
    private final WindowInsetsManager.AnimationCallback mAnimationCallback = new WindowInsetsManager.AnimationCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.common.component.SettingsBaseNonPreferenceFragment$mAnimationCallback$1
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onEnd(WindowInsetsAnimationCompat animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.this$0.updateListView();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onProgress(WindowInsetsCompat windowInsets, List<WindowInsetsAnimationCompat> runningAnimations) {
            Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        }
    };

    @NotNull
    private final WindowInsetsManager.ApplyInsetListener mApplyInsetListener = new WindowInsetsManager.ApplyInsetListener() { // from class: com.samsung.android.support.senl.nt.app.settings.common.component.SettingsBaseNonPreferenceFragment$mApplyInsetListener$1
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.ApplyInsetListener
        public void onApplyInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsetsCompat");
            this.this$0.updateListView();
        }
    };

    @Nullable
    private String mCallee;

    public static /* synthetic */ boolean isCallFromOtherApps$default(SettingsBaseNonPreferenceFragment settingsBaseNonPreferenceFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isCallFromOtherApps");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return settingsBaseNonPreferenceFragment.isCallFromOtherApps(z);
    }

    private final void registerWindowInsetManager() {
        if (CommonUtil.isNotAvailableActivity(getActivity())) {
            return;
        }
        if (this.mActivityContainer == null) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            this.mActivityContainer = activity.findViewById(C8003R.id.activity_container);
        }
        if (this.mActivityContainer != null) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            companion.getInstance().registerAnimationCallback(this.mActivityContainer, this.mAnimationCallback);
            companion.getInstance().registerApplyListener(this.mActivityContainer, this.mApplyInsetListener);
        }
    }

    private final void unregisterWindowInsetManager() {
        if (this.mActivityContainer != null) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            companion.getInstance().unregisterAnimationCallback(this.mActivityContainer);
            companion.getInstance().unregisterApplyListener(this.mActivityContainer);
        }
    }

    private final void updateListForMobile() {
        ViewGroup settingContents;
        if (getView() == null || (settingContents = getSettingContents()) == null) {
            return;
        }
        settingContents.setPaddingRelative(settingContents.getPaddingStart(), 0, settingContents.getPaddingEnd(), 0);
    }

    private final void updateListForVst() {
        View view = getView();
        if (view != null) {
            view.post(new RunnableC8515c(this, view, 5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateListForVst$lambda$2$lambda$1(SettingsBaseNonPreferenceFragment settingsBaseNonPreferenceFragment, View view) {
        DisplayUtils.updateViewPaddingByFlexibleSpacingForVst(settingsBaseNonPreferenceFragment.getActivity(), view, isCallFromOtherApps$default(settingsBaseNonPreferenceFragment, false, 1, null));
    }

    @Nullable
    public final String getCallee() {
        if (this.mCallee == null) {
            if (getArguments() == null) {
                return SettingsConstants.CALLEE_COMPOSER;
            }
            this.mCallee = requireArguments().getString(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_SETTINGS);
        }
        return this.mCallee;
    }

    @Nullable
    public final FloatingBottomLayout getFloatingBottomLayout() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return (FloatingBottomLayout) activity.findViewById(C8003R.id.floating_bottom_layout);
        }
        return null;
    }

    @Nullable
    public final FloatingToolbarLayout getFloatingToolbarLayout() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return (FloatingToolbarLayout) activity.findViewById(C8003R.id.sesl_floating_toolbar_layout);
        }
        return null;
    }

    @Nullable
    public abstract ViewGroup getSettingContents();

    public final boolean isCallFromOtherApps(boolean includeTips) {
        return includeTips ? Intrinsics.areEqual(getCallee(), SettingsConstants.CALLEE_TIPS) : Intrinsics.areEqual(getCallee(), SettingsConstants.CALLEE_NONE);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateListView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerWindowInsetManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterWindowInsetManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateListView();
    }

    public final void updateListView() {
        if (getActivity() == null) {
            return;
        }
        if (this.mActivityContainer == null) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            this.mActivityContainer = activity.findViewById(C8003R.id.activity_container);
        }
        if (this.mActivityContainer != null) {
            if (DeviceInfo.isVSTModel()) {
                WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(this.mActivityContainer);
                updateListForVst();
                return;
            }
            updateListForMobile();
            if (!WidgetInsetUtils.getCanUseWindowInsets()) {
                WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(this.mActivityContainer);
                return;
            }
            FragmentActivity activity2 = getActivity();
            Window window = activity2 != null ? activity2.getWindow() : null;
            View view = this.mActivityContainer;
            ViewGroup settingContents = getSettingContents();
            FragmentActivity activity3 = getActivity();
            WidgetInsetUtils.applyWindowInsetsForSetting(window, view, settingContents, activity3 != null ? (AppBarLayout) activity3.findViewById(C8003R.id.appbar_layout) : null, getFloatingToolbarLayout(), getFloatingBottomLayout());
        }
    }
}
