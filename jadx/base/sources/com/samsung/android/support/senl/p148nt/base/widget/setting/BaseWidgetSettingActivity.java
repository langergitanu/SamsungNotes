package com.samsung.android.support.senl.p148nt.base.widget.setting;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.emoji2.text.flatbuffer.C2747a;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.NestedScrollViewCustom;
import com.samsung.android.support.senl.p145cm.base.framework.view.DisplayCutoutCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u001c\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0018\u001a\u00020\u000bH\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/setting/BaseWidgetSettingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mPresenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "getMPresenter", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "setMPresenter", "(Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "disableSystemBarInsets", "view", "Landroid/view/View;", "maskSupplier", "Ljava/util/function/Supplier;", "", "setToolbarView", "createPresenter", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onDestroy", "onCreateOptionsMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBaseWidgetSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseWidgetSettingActivity.kt\ncom/samsung/android/support/senl/nt/base/widget/setting/BaseWidgetSettingActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,196:1\n311#2:197\n327#2,4:198\n312#2:202\n311#2:203\n327#2,4:204\n312#2:208\n*S KotlinDebug\n*F\n+ 1 BaseWidgetSettingActivity.kt\ncom/samsung/android/support/senl/nt/base/widget/setting/BaseWidgetSettingActivity\n*L\n144#1:197\n144#1:198,4\n144#1:202\n146#1:203\n146#1:204,4\n146#1:208\n*E\n"})
public abstract class BaseWidgetSettingActivity extends AppCompatActivity {

    @Nullable
    private BaseWidgetSettingPresenter mPresenter;

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat disableSystemBarInsets$lambda$2(Supplier supplier, BaseWidgetSettingActivity baseWidgetSettingActivity, View view, View view2, View view3, int i, View view4, View view5, View v, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Object obj = supplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Insets insets = windowInsets.getInsets(((Number) obj).intValue());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        if (baseWidgetSettingActivity.getResources().getConfiguration().orientation == 1) {
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                view2.getLayoutParams().height = insets.top;
                marginLayoutParams.bottomMargin = insets.bottom;
                view.setLayoutParams(marginLayoutParams);
                view3.getLayoutParams().height = insets.bottom + i;
            }
        } else if (DeviceUtils.isTabletModel() || DesktopModeCompat.INSTANCE.getInstance().isDexMode(baseWidgetSettingActivity) || (DeviceUtils.isFoldableModel() && BaseWidgetUtils.INSTANCE.getWidgetAddDisplayType(v.getContext()) == DisplayDeviceTypeCompat.INSTANCE.getDISPLAY_DEVICE_TYPE_MAIN())) {
            view2.getLayoutParams().height = insets.top;
            view4.getLayoutParams().height = insets.bottom;
        } else {
            if (DeviceUtils.isFoldableModel() && BaseWidgetUtils.INSTANCE.getWidgetAddDisplayType(v.getContext()) == DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_SUB) {
                Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type android.widget.LinearLayout");
                ((LinearLayout) view5).setOrientation(0);
                view2.getLayoutParams().height = -1;
                view4.getLayoutParams().height = -1;
            }
            view2.getLayoutParams().width = insets.left;
            view4.getLayoutParams().width = insets.right;
        }
        view2.requestLayout();
        view4.requestLayout();
        if (view3 != null) {
            view3.requestLayout();
        }
        return WindowInsetsCompat.CONSUMED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer onCreate$lambda$0() {
        return Integer.valueOf(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToolbarView$lambda$5(TextView textView, BaseWidgetSettingActivity baseWidgetSettingActivity, int i, AppBarLayout appBarLayout, int i2) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        if ((-i2) / appBarLayout.getHeight() > 0.0f) {
            if (textView != null) {
                textView.setText("");
            }
        } else if (textView != null) {
            textView.setText(baseWidgetSettingActivity.getResources().getString(C8875R.string.base_widget_setting_title));
        }
        int height = appBarLayout.getHeight() + i2;
        if ((textView == null || height != textView.getHeight()) && height >= i) {
            if (textView != null) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = height;
                textView.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if ((textView == null || height != textView.getHeight()) && height < i && textView != null) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams2.height = i;
            textView.setLayoutParams(layoutParams2);
        }
    }

    @NotNull
    public abstract BaseWidgetSettingPresenter createPresenter(@Nullable Bundle savedInstanceState);

    public final void disableSystemBarInsets(@NotNull final View view, @NotNull final Supplier<Integer> maskSupplier) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(maskSupplier, "maskSupplier");
        if (Build.VERSION.SDK_INT > 34) {
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            getWindow().setNavigationBarColor(0);
            getWindow().setNavigationBarContrastEnforced(false);
            WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView()).setAppearanceLightNavigationBars(!ContextUtils.isNightMode(this));
            final View viewFindViewById = findViewById(C8875R.id.status_bar_background_view);
            final View viewFindViewById2 = findViewById(C8875R.id.navigation_bar_background_view);
            final View viewFindViewById3 = findViewById(C8875R.id.widget_setting_floating_bottom_layout);
            final View viewFindViewById4 = findViewById(C8875R.id.widget_setting_scroll_bottom_space);
            final int dimensionPixelSize = getResources().getDimensionPixelSize(C8875R.dimen.widget_setting_scroll_bottom_height);
            ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.b
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    return BaseWidgetSettingActivity.disableSystemBarInsets$lambda$2(maskSupplier, this, viewFindViewById3, viewFindViewById, viewFindViewById4, dimensionPixelSize, viewFindViewById2, view, view2, windowInsetsCompat);
                }
            });
        }
    }

    @Nullable
    public final BaseWidgetSettingPresenter getMPresenter() {
        return this.mPresenter;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        BaseWidgetSettingPresenter baseWidgetSettingPresenter = this.mPresenter;
        if (baseWidgetSettingPresenter != null) {
            baseWidgetSettingPresenter.showCancelDialog();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) throws Exception {
        super.onCreate(savedInstanceState);
        if (BaseWidgetUtils.INSTANCE.isFoldSettingLayout()) {
            setContentView(C8875R.layout.widget_setting_layout_top);
        } else {
            setContentView(C8875R.layout.widget_setting_layout);
        }
        int color = getResources().getColor(C8875R.color.widget_setting_background, getTheme());
        boolean z = !ContextUtils.isNightMode(this);
        DisplayCutoutCompat.INSTANCE.getInstance().setDisplayCutoutBGColor(this, color);
        SystemUi.setStatusBarTheme(this, color, z);
        SystemUi.setNavigationBarTheme(this, color, z);
        WindowManagerCompat.INSTANCE.getInstance().controlIndicatorBar(this);
        View viewFindViewById = findViewById(C8875R.id.widget_setting_layout_root);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        disableSystemBarInsets(viewFindViewById, new C2747a(3));
        View viewFindViewById2 = findViewById(C8875R.id.toolbar);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) viewFindViewById2;
        toolbar.setTitle(C8875R.string.base_widget_setting_title);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        setToolbarView();
        this.mPresenter = createPresenter(savedInstanceState);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.BaseWidgetSettingActivity.onCreate.2
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                BaseWidgetSettingActivity.this.onBackPressed();
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (getResources().getConfiguration().orientation == 2) {
            getMenuInflater().inflate(C8875R.menu.widget_setting_menu, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BaseWidgetSettingPresenter baseWidgetSettingPresenter = this.mPresenter;
        if (baseWidgetSettingPresenter != null) {
            baseWidgetSettingPresenter.onDestroy();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (getResources().getConfiguration().orientation != 2) {
            return super.onOptionsItemSelected(item);
        }
        if (item.getItemId() == C8875R.id.save) {
            BaseWidgetSettingPresenter baseWidgetSettingPresenter = this.mPresenter;
            if (baseWidgetSettingPresenter != null) {
                baseWidgetSettingPresenter.saveAndFinish();
            }
            return true;
        }
        BaseWidgetSettingPresenter baseWidgetSettingPresenter2 = this.mPresenter;
        if (baseWidgetSettingPresenter2 != null) {
            baseWidgetSettingPresenter2.cancelAndFinish();
        }
        return true;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        BaseWidgetSettingPresenter baseWidgetSettingPresenter = this.mPresenter;
        if (baseWidgetSettingPresenter != null) {
            baseWidgetSettingPresenter.onSaveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    public final void setMPresenter(@Nullable BaseWidgetSettingPresenter baseWidgetSettingPresenter) {
        this.mPresenter = baseWidgetSettingPresenter;
    }

    public final void setToolbarView() throws Exception {
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (!companion.isSupportedNewWidget() || getResources().getConfiguration().orientation != 2 || companion.isQ7mModel() || DeviceUtils.isTabletModel() || DesktopModeCompat.INSTANCE.getInstance().isDexMode(this)) {
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        FloatingToolbarLayout floatingToolbarLayout = (FloatingToolbarLayout) findViewById(C8875R.id.sesl_floating_toolbar_layout);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(C8875R.id.appbar);
        NestedScrollViewCustom nestedScrollViewCustom = (NestedScrollViewCustom) findViewById(C8875R.id.widget_setting_scroll_view);
        final TextView textView = (TextView) findViewById(C8875R.id.widget_setting_toolbar_title);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(C8875R.dimen.widget_setting_toolbar_top_margin);
        if (floatingToolbarLayout != null) {
            FloatingTopLayout.enableToolbarItemBackgroundTransition$default(floatingToolbarLayout, false, false, 2, null);
        }
        if (floatingToolbarLayout != null) {
            floatingToolbarLayout.applyBlurInfo(this);
        }
        if (floatingToolbarLayout != null) {
            Intrinsics.checkNotNull(nestedScrollViewCustom);
            floatingToolbarLayout.setNestedScrollView(nestedScrollViewCustom);
        }
        if (nestedScrollViewCustom != null) {
            nestedScrollViewCustom.seslSetFadingEdgeEnabled(true);
        }
        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.a
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    BaseWidgetSettingActivity.setToolbarView$lambda$5(textView, this, dimensionPixelSize, appBarLayout2, i);
                }
            });
        }
    }
}
