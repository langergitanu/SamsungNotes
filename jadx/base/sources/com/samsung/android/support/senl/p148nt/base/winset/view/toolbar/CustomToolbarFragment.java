package com.samsung.android.support.senl.p148nt.base.winset.view.toolbar;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rJ\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\"H$J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H$J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH$R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/CustomToolbarFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mToolbar", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/CustomToolbar;", "mIsToolbarEnabled", "", "mHandler", "Landroid/os/Handler;", "mCreateOptionMenuRunnable", "Ljava/lang/Runnable;", "initialize", "", "view", "Landroid/view/View;", "initToolbar", "onDestroyView", "enableToolbar", "enableAdjustableMenu", "onCreateOptionsMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onPrepareOptionsMenu", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "supportedToolbar", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar;", "getSupportedToolbar", "()Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar;", "onCreateFragmentOptionMenu", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/IMenuInflater;", "onPrepareFragmentOptionMenu", "initAppbarContents", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCustomToolbarFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomToolbarFragment.kt\ncom/samsung/android/support/senl/nt/base/winset/view/toolbar/CustomToolbarFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,107:1\n1#2:108\n*E\n"})
public abstract class CustomToolbarFragment extends Fragment {

    @NotNull
    private static final String TAG = "CustomToolbarFragment";

    @Nullable
    private Runnable mCreateOptionMenuRunnable;

    @Nullable
    private Handler mHandler;
    private boolean mIsToolbarEnabled;

    @JvmField
    @Nullable
    protected CustomToolbar mToolbar;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableToolbar$lambda$1(CustomToolbarFragment customToolbarFragment) {
        FragmentActivity activity = customToolbarFragment.getActivity();
        if (activity != null) {
            activity.invalidateOptionsMenu();
        }
    }

    public final void enableAdjustableMenu() {
        Logger.m8697d(TAG, "enableAdjustableMenu# ");
        CustomToolbar customToolbar = this.mToolbar;
        if (customToolbar != null) {
            customToolbar.enableAdjustableMenu();
        }
    }

    public final void enableToolbar() {
        Handler handler;
        if (this.mToolbar == null || this.mIsToolbarEnabled) {
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        if (this.mCreateOptionMenuRunnable == null) {
            this.mCreateOptionMenuRunnable = new RunnableC8669a(this, 23);
        }
        Runnable runnable = this.mCreateOptionMenuRunnable;
        if (runnable != null && (handler = this.mHandler) != null) {
            handler.post(runnable);
        }
        this.mIsToolbarEnabled = true;
    }

    @Nullable
    public final ICustomToolbar getSupportedToolbar() {
        return this.mToolbar;
    }

    public abstract void initAppbarContents(@NotNull View view);

    public void initToolbar(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        CustomToolbar customToolbar = (CustomToolbar) view.findViewById(C8875R.id.toolbar);
        this.mToolbar = customToolbar;
        if (customToolbar != null) {
            customToolbar.initToolbar();
        }
        CustomToolbar customToolbar2 = this.mToolbar;
        if (customToolbar2 != null) {
            customToolbar2.seslSetEatingTouch(false);
        }
    }

    public final void initialize(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initToolbar(view);
        initAppbarContents(view);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        AbstractC4539a.m3203m(hashCode(), "onConfigurationChanged# ", TAG);
        CustomToolbar customToolbar = this.mToolbar;
        if (customToolbar != null) {
            customToolbar.postUpdateToolbarLayout();
        }
    }

    public abstract void onCreateFragmentOptionMenu(@NotNull Menu menu, @NotNull IMenuInflater inflater);

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (this.mToolbar == null) {
            super.onCreateOptionsMenu(menu, inflater);
            return;
        }
        Logger.m8697d(TAG, "onCreateOptionsMenu# ");
        CustomToolbar customToolbar = this.mToolbar;
        Menu menu2 = customToolbar != null ? customToolbar.getMenu() : null;
        Intrinsics.checkNotNull(menu2);
        CustomToolbar customToolbar2 = this.mToolbar;
        Intrinsics.checkNotNull(customToolbar2);
        onCreateFragmentOptionMenu(menu2, customToolbar2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Handler handler;
        Logger.m8697d(TAG, "onDestroyView# ");
        CustomToolbar customToolbar = this.mToolbar;
        if (customToolbar == null) {
            super.onDestroyView();
            return;
        }
        if (customToolbar != null) {
            customToolbar.setOnMenuItemClickListener(null);
        }
        CustomToolbar customToolbar2 = this.mToolbar;
        if (customToolbar2 != null) {
            customToolbar2.release();
        }
        this.mToolbar = null;
        this.mIsToolbarEnabled = false;
        Runnable runnable = this.mCreateOptionMenuRunnable;
        if (runnable != null && (handler = this.mHandler) != null) {
            handler.removeCallbacks(runnable);
        }
        this.mHandler = null;
        this.mCreateOptionMenuRunnable = null;
        super.onDestroyView();
    }

    public abstract void onPrepareFragmentOptionMenu(@NotNull Menu menu);

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onPrepareOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (this.mToolbar == null) {
            super.onPrepareOptionsMenu(menu);
            return;
        }
        Logger.m8697d(TAG, "onPrepareOptionsMenu# ");
        CustomToolbar customToolbar = this.mToolbar;
        Menu menu2 = customToolbar != null ? customToolbar.getMenu() : null;
        Intrinsics.checkNotNull(menu2);
        onPrepareFragmentOptionMenu(menu2);
        CustomToolbar customToolbar2 = this.mToolbar;
        if (customToolbar2 != null) {
            customToolbar2.updateOverflowBtnBadge();
        }
    }
}
