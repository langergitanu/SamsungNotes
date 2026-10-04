package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.samsung.android.sdk.pen.setting.SpenPenSizeView;
import com.samsung.android.sdk.pen.setting.handwriting.SpenLineSizeView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingPenSizeLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingLayout;", "container", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mContainer", "mResource", "Landroid/content/res/Resources;", "mOrientation", "", "mSettingLayout", "Landroid/view/ViewGroup;", "mPenSizeView", "Lcom/samsung/android/sdk/pen/setting/SpenPenSizeView;", "initPenSizeView", "", "initPosition", "init", Constants.IntentExtraValue.SHOW, "hide", "isVisible", "", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "initialize", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingPenSizeLayout extends SettingLayout {

    @NotNull
    private static final String TAG = SOLogger.createTag("SettingPenSizeLayout");

    @NotNull
    private final View mContainer;
    private final int mOrientation;
    private SpenPenSizeView mPenSizeView;

    @NotNull
    private final Resources mResource;
    private ViewGroup mSettingLayout;

    public SettingPenSizeLayout(@NotNull View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        SOLogger.INSTANCE.SOLoggerD(TAG, "SettingPenSizeLayout#");
        this.mContainer = container;
        Resources resources = container.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        this.mResource = resources;
        this.mOrientation = resources.getConfiguration().orientation;
        if (container instanceof ViewGroup) {
            View viewInflate = LayoutInflater.from(((ViewGroup) container).getContext()).inflate(C9086R.layout.screenoff_pen_size_setting_layout, (ViewGroup) container, false);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            this.mSettingLayout = viewGroup;
            ViewGroup viewGroup2 = (ViewGroup) container;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
                viewGroup = null;
            }
            viewGroup2.addView(viewGroup);
        }
    }

    private final void initPenSizeView() {
        FrameLayout.LayoutParams layoutParams;
        AbstractC8014b.m7206h("initPenSizeView# orientation ", this.mOrientation, SOLogger.INSTANCE, TAG);
        int i = 1;
        if (this.mOrientation == 1 || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
            layoutParams = new FrameLayout.LayoutParams(this.mResource.getDimensionPixelSize(C9086R.dimen.screenoff_pen_size_setting_view_background_width_portrait), this.mResource.getDimensionPixelSize(C9086R.dimen.screenoff_pen_size_setting_view_background_height_portrait));
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mResource.getDimensionPixelSize(C9086R.dimen.screenoff_pen_size_setting_view_background_width_landscape), this.mResource.getDimensionPixelSize(C9086R.dimen.screenoff_pen_size_setting_view_background_height_landscape));
            i = 0;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        ViewGroup viewGroup = this.mSettingLayout;
        SpenPenSizeView spenPenSizeView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        viewGroup.setLayoutParams(layoutParams);
        ViewGroup viewGroup2 = this.mSettingLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup2 = null;
        }
        viewGroup2.setBackgroundResource(C9086R.drawable.screenoff_pen_setting_size_view_background);
        ViewGroup viewGroup3 = this.mSettingLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup3 = null;
        }
        Context context = viewGroup3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenPenSizeView spenPenSizeView2 = new SpenPenSizeView(context, i);
        this.mPenSizeView = spenPenSizeView2;
        spenPenSizeView2.setPenInfo(PenInfoModel.INSTANCE.getSpenSettingPenInfo());
        SpenPenSizeView spenPenSizeView3 = this.mPenSizeView;
        if (spenPenSizeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenSizeView");
            spenPenSizeView3 = null;
        }
        spenPenSizeView3.setActionListener(new SpenLineSizeView.ActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.view.menubar.setting.SettingPenSizeLayout.initPenSizeView.1
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenLineSizeView.ActionListener
            public void onSizeChanged(float size, int sizeLevel) {
                SOLogger.INSTANCE.SOLoggerD(SettingPenSizeLayout.TAG, "SpenPenSizeView# onSizeChanged size/sizeLevel " + size + "/" + sizeLevel);
                ISettingViewManager mSettingViewManager = SettingPenSizeLayout.this.getMSettingViewManager();
                if (mSettingViewManager != null) {
                    mSettingViewManager.onUpdatedPenSize(size, sizeLevel);
                }
            }
        });
        ViewGroup viewGroup4 = this.mSettingLayout;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup4 = null;
        }
        SpenPenSizeView spenPenSizeView4 = this.mPenSizeView;
        if (spenPenSizeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenSizeView");
        } else {
            spenPenSizeView = spenPenSizeView4;
        }
        viewGroup4.addView(spenPenSizeView, layoutParams2);
    }

    private final void initPosition() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPosition#");
        ViewGroup viewGroup = this.mSettingLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.mOrientation == 1 || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
            layoutParams2.gravity = 8388659;
            layoutParams2.setMarginStart((int) this.mResource.getDimension(C9086R.dimen.screenoff_pen_size_setting_view_margin_start_portrait));
            layoutParams2.topMargin = (int) this.mResource.getDimension(C9086R.dimen.screenoff_pen_size_setting_view_margin_top_portrait);
        } else {
            Object systemService = this.mContainer.getContext().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            int rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            layoutParams2.gravity = 80;
            int dimension = (int) this.mResource.getDimension(C9086R.dimen.screenoff_pen_size_setting_view_margin_top_landscape);
            int navigationBarHeightIgnoreHasSoftKey = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeightIgnoreHasSoftKey(this.mContainer.getContext());
            if (zIsRTLMode) {
                if (rotation == 3) {
                    layoutParams2.setMarginEnd(dimension + navigationBarHeightIgnoreHasSoftKey);
                } else {
                    layoutParams2.setMarginEnd(dimension);
                }
            } else if (rotation == 3) {
                layoutParams2.setMarginStart(dimension + navigationBarHeightIgnoreHasSoftKey);
            } else {
                layoutParams2.setMarginStart(dimension);
            }
            layoutParams2.bottomMargin = (int) this.mResource.getDimension(C9086R.dimen.screenoff_pen_size_setting_view_margin_bottom_landscape);
        }
        ViewGroup viewGroup3 = this.mSettingLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.setLayoutParams(layoutParams2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void hide() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "hide#");
        ViewGroup viewGroup = this.mSettingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void init() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        initPenSizeView();
        initPosition();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public boolean isVisible() {
        ViewGroup viewGroup = this.mSettingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        return viewGroup.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void show() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "show#");
        ViewGroup viewGroup = this.mSettingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingLayout");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void update(boolean initialize) {
        SpenPenSizeView spenPenSizeView = this.mPenSizeView;
        if (spenPenSizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenSizeView");
            spenPenSizeView = null;
        }
        spenPenSizeView.setPenInfo(PenInfoModel.INSTANCE.getSpenSettingPenInfo());
    }
}
