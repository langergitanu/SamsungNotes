package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.MenuBarContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItemState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/MenuBar;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarContract$IView;", "container", "Landroid/view/ViewGroup;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter;", "<init>", "(Landroid/view/ViewGroup;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter;)V", "mContainer", "Landroid/view/View;", "mMenuBarLayout", "mPresenter", "mMenuItemManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemManager;", "mMenuItemState", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemState;", "mSettingViewState", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewState;", "init", "", "visibility", "", "halfWheelRotation", "", "onWindowFocusChanged", "hasFocus", "onConfigurationChanged", "updateVisibility", "type", "invalidate", "onDestroy", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMenuBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MenuBar.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/MenuBar\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,158:1\n1#2:159\n35#3:160\n*S KotlinDebug\n*F\n+ 1 MenuBar.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/MenuBar\n*L\n65#1:160\n*E\n"})
public final class MenuBar implements MenuBarContract.IView {

    @NotNull
    private static final String TAG = SOLogger.createTag("MenuBar");

    @NotNull
    private final View mContainer;

    @Nullable
    private View mMenuBarLayout;

    @Nullable
    private MenuItemManager mMenuItemManager;

    @NotNull
    private final MenuItemState mMenuItemState;

    @NotNull
    private final MenuBarPresenter mPresenter;

    @NotNull
    private final SettingViewState mSettingViewState;

    public MenuBar(@NotNull ViewGroup container, @NotNull MenuBarPresenter presenter) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "MenuBar#");
        this.mContainer = container;
        container.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.view.menubar.MenuBar.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(child, "child");
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(child, "child");
                SOLogger.INSTANCE.SOLoggerD(MenuBar.TAG, "onChildViewRemoved#");
                MenuBar.this.mContainer.postInvalidate();
            }
        });
        this.mPresenter = presenter;
        presenter.setView(this);
        this.mMenuItemState = new MenuItemState();
        this.mSettingViewState = new SettingViewState();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarContract.IView
    public void init(int visibility, boolean halfWheelRotation) {
        int rotation;
        ViewGroup.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        Resources resources;
        Configuration configuration;
        Context context = this.mContainer.getContext();
        Resources resources2 = context != null ? context.getResources() : null;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContainer.getContext());
        Context context2 = this.mContainer.getContext();
        Integer numValueOf = (context2 == null || (resources = context2.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
        SOLogger.INSTANCE.SOLoggerD(TAG, "init orientation# " + numValueOf);
        try {
            View view = this.mMenuBarLayout;
            if (view != null) {
                View view2 = this.mContainer;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) view2).indexOfChild(view);
            }
            View view3 = this.mContainer;
            Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view3).removeView(this.mMenuBarLayout);
        } catch (Exception e) {
            AbstractC0000a.m24u("init# getMessage ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
        if ((numValueOf != null && numValueOf.intValue() == 1) || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
            View viewInflate = layoutInflaterFrom.inflate(C9086R.layout.screenoff_menu_bar_layout_portrait, (ViewGroup) this.mContainer, false);
            this.mMenuBarLayout = viewInflate;
            layoutParams = viewInflate != null ? viewInflate.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = resources2 != null ? (int) resources2.getDimension(C9086R.dimen.screenoff_menu_bar_layout_width_height) : 0;
            layoutParams2.gravity = 48;
        } else {
            if (halfWheelRotation) {
                rotation = this.mPresenter.getRotation();
            } else {
                Context context3 = this.mContainer.getContext();
                Object systemService = context3 != null ? context3.getSystemService("window") : null;
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
            }
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            sOLogger.SOLoggerD(str, "init halfWheelRotation/rotation/isRTLMode # " + halfWheelRotation + "/" + rotation + "/" + zIsRTLMode);
            View viewInflate2 = layoutInflaterFrom.inflate(C9086R.layout.screenoff_menu_bar_layout_landscape, (ViewGroup) this.mContainer, false);
            this.mMenuBarLayout = viewInflate2;
            layoutParams = viewInflate2 != null ? viewInflate2.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (zIsRTLMode) {
                layoutParams2.gravity = 8388613;
            } else {
                layoutParams2.gravity = 8388611;
            }
            layoutParams2.width = resources2 != null ? (int) resources2.getDimension(C9086R.dimen.screenoff_menu_bar_layout_width_height) : 0;
            if (rotation == 3) {
                int navigationBarHeightIgnoreHasSoftKey = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeightIgnoreHasSoftKey(((ViewGroup) this.mContainer).getContext());
                AbstractC8014b.m7206h("init navigationHeight# ", navigationBarHeightIgnoreHasSoftKey, sOLogger, str);
                if (zIsRTLMode) {
                    layoutParams2.setMarginEnd(navigationBarHeightIgnoreHasSoftKey);
                } else {
                    layoutParams2.setMarginStart(navigationBarHeightIgnoreHasSoftKey);
                }
            }
        }
        View view4 = this.mMenuBarLayout;
        if (view4 != null) {
            view4.setVisibility(visibility);
        }
        ((ViewGroup) this.mContainer).addView(this.mMenuBarLayout, layoutParams2);
        this.mMenuItemManager = new MenuItemManager(this.mContainer, this.mPresenter, this.mMenuItemState, this.mSettingViewState);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarContract.IView
    public void invalidate() {
        View view = this.mMenuBarLayout;
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarContract.IView
    public void onConfigurationChanged(int visibility, boolean halfWheelRotation) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onConfigurationChanged#");
        onDestroy();
        init(visibility, halfWheelRotation);
        if (halfWheelRotation) {
            updateVisibility(16, this.mPresenter.getPinVisibility());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarContract.IView
    public void onDestroy() {
        ViewGroup viewGroup = (ViewGroup) this.mContainer;
        if (viewGroup != null) {
            viewGroup.removeView(this.mMenuBarLayout);
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        boolean zIsInLayout = ((ViewGroup) this.mContainer).isInLayout();
        ViewGroup viewGroup2 = (ViewGroup) this.mContainer;
        sOLogger.SOLoggerD(str, "onDestroy# isInLayout/indexOfChild " + zIsInLayout + "/" + (viewGroup2 != null ? Integer.valueOf(viewGroup2.indexOfChild(this.mMenuBarLayout)) : null));
        this.mMenuBarLayout = null;
        MenuItemManager menuItemManager = this.mMenuItemManager;
        if (menuItemManager != null) {
            menuItemManager.onDestroy();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarContract.IView
    public void onWindowFocusChanged(boolean hasFocus) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowFocusChanged#");
        MenuItemManager menuItemManager = this.mMenuItemManager;
        if (menuItemManager != null) {
            menuItemManager.onWindowFocusChanged(hasFocus);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarContract.IView
    public void updateVisibility(int type, int visibility) {
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC1038a.m1214o(type, visibility, "updateVisibility#, type/visibility = ", "/"));
        if (type == 1) {
            View view = this.mMenuBarLayout;
            if (view != null) {
                view.setVisibility(visibility);
                return;
            }
            return;
        }
        MenuItemManager menuItemManager = this.mMenuItemManager;
        if (menuItemManager != null) {
            menuItemManager.update(type, visibility);
        }
    }
}
