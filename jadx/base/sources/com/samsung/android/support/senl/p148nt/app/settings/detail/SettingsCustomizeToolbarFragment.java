package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.presenter.CustomToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarView;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u000eH\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010*\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsCustomizeToolbarFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseNonPreferenceFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter$Contract;", "<init>", "()V", "customToolbarView", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;", "customToolbarPresenter", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter;", "memoListActivity", "Landroid/app/Activity;", "isTabletLayout", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "updateLayout", "onDestroy", "onCreateOptionsMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "Landroid/view/MenuInflater;", "onPrepareOptionsMenu", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "getSettingContents", "onPause", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsCustomizeToolbarFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsCustomizeToolbarFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/SettingsCustomizeToolbarFragment\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,148:1\n1321#2,2:149\n*S KotlinDebug\n*F\n+ 1 SettingsCustomizeToolbarFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/SettingsCustomizeToolbarFragment\n*L\n91#1:149,2\n*E\n"})
public final class SettingsCustomizeToolbarFragment extends SettingsBaseNonPreferenceFragment implements CustomToolbarPresenter.Contract {

    @NotNull
    public static final String TAG = "SettingsCustomizeToolbarFragment";
    private CustomToolbarPresenter customToolbarPresenter;
    private CustomToolbarView customToolbarView;
    private boolean isTabletLayout;

    @Nullable
    private Activity memoListActivity;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConfigurationChanged$lambda$0(SettingsCustomizeToolbarFragment settingsCustomizeToolbarFragment) {
        boolean zIsTabletLayout = settingsCustomizeToolbarFragment.isTabletLayout();
        if (settingsCustomizeToolbarFragment.isTabletLayout != zIsTabletLayout) {
            settingsCustomizeToolbarFragment.isTabletLayout = zIsTabletLayout;
            CustomToolbarView customToolbarView = settingsCustomizeToolbarFragment.customToolbarView;
            if (customToolbarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customToolbarView");
                customToolbarView = null;
            }
            customToolbarView.onLayoutTypeChanged(zIsTabletLayout);
        }
    }

    private final void updateLayout() {
        Sequence<View> children;
        View view = getView();
        ViewGroup viewGroup = view != null ? (ViewGroup) view.findViewById(C8003R.id.customize_toolbar_fragment_layout) : null;
        if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null) {
            return;
        }
        for (View view2 : children) {
            if (view2.getId() != C8003R.id.toolbar_preview_container) {
                DisplayUtils.updateViewMarginByFlexibleSpacing(getActivity(), view2);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.CustomToolbarPresenter.Contract
    @NotNull
    public FragmentActivity getFragmentActivity() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        return fragmentActivityRequireActivity;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment
    @Nullable
    public ViewGroup getSettingContents() {
        View view = getView();
        if (view != null) {
            return (ViewGroup) view.findViewById(C8003R.id.customize_toolbar_fragment_layout);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.CustomToolbarPresenter.Contract
    public boolean isTabletLayout() {
        if (this.memoListActivity == null) {
            MainLogger.m7254d(TAG, "isTabletLayout# memoListActivity is null");
            return ResourceUtils.isTabletLayout(getContext());
        }
        if (!Intrinsics.areEqual(getCallee(), SettingsConstants.CALLEE_MAINLIST)) {
            return ResourceUtils.isTabletLayout(getContext());
        }
        MainLogger.m7254d(TAG, "isTabletLayout# Called from MemoListActivity");
        return ResourceUtils.isTabletLayout(this.memoListActivity);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateLayout();
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC8669a(this, 4), 50L);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HwToolbarItemHelper.reflectNewItem();
        this.memoListActivity = ApplicationManager.INSTANCE.getInstance().getActivityTracker().findActivityWithActivityNamePrefixAndTaskId("MemoListActivity", getFragmentActivity().getTaskId());
        this.isTabletLayout = isTabletLayout();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(C8003R.menu.customize_toolbar_menu, menu);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setHasOptionsMenu(true);
        return inflater.inflate(C8003R.layout.settings_customize_toolbar_fragment, container, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (isRemoving() || requireActivity().isFinishing()) {
            CustomToolbarPresenter customToolbarPresenter = this.customToolbarPresenter;
            if (customToolbarPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customToolbarPresenter");
                customToolbarPresenter = null;
            }
            customToolbarPresenter.insertSAStatusLogging();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != C8003R.id.reset) {
            return super.onOptionsItemSelected(item);
        }
        CustomToolbarPresenter customToolbarPresenter = this.customToolbarPresenter;
        if (customToolbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbarPresenter");
            customToolbarPresenter = null;
        }
        customToolbarPresenter.reset();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CustomToolbarPresenter customToolbarPresenter = this.customToolbarPresenter;
        if (customToolbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbarPresenter");
            customToolbarPresenter = null;
        }
        customToolbarPresenter.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(@NotNull Menu menu) {
        MenuItem menuItemFindItem;
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onPrepareOptionsMenu(menu);
        if (this.customToolbarView == null || (menuItemFindItem = menu.findItem(C8003R.id.reset)) == null) {
            return;
        }
        CustomToolbarView customToolbarView = this.customToolbarView;
        if (customToolbarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbarView");
            customToolbarView = null;
        }
        menuItemFindItem.setEnabled(!customToolbarView.isDefaultState());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CustomToolbarPresenter customToolbarPresenter = this.customToolbarPresenter;
        if (customToolbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbarPresenter");
            customToolbarPresenter = null;
        }
        customToolbarPresenter.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.customToolbarPresenter = new CustomToolbarPresenter(this);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        CustomToolbarPresenter customToolbarPresenter = this.customToolbarPresenter;
        CustomToolbarView customToolbarView = null;
        if (customToolbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbarPresenter");
            customToolbarPresenter = null;
        }
        this.customToolbarView = new CustomToolbarView(fragmentActivityRequireActivity, view, customToolbarPresenter);
        CustomToolbarPresenter customToolbarPresenter2 = this.customToolbarPresenter;
        if (customToolbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbarPresenter");
            customToolbarPresenter2 = null;
        }
        CustomToolbarView customToolbarView2 = this.customToolbarView;
        if (customToolbarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbarView");
        } else {
            customToolbarView = customToolbarView2;
        }
        customToolbarPresenter2.setView(customToolbarView);
        updateLayout();
    }
}
