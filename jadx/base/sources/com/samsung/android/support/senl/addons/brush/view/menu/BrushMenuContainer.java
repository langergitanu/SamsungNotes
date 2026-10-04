package com.samsung.android.support.senl.addons.brush.view.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.SpenBrushLayoutInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.ScreenUtils;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.binding.method.BMBrushEraserView;
import com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView;
import com.samsung.android.support.senl.addons.brush.view.injector.MenuLayoutInjector;
import com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl;
import com.samsung.android.support.senl.addons.brush.view.menu.control.BrushPhoneMenuControl;
import com.samsung.android.support.senl.addons.brush.view.menu.control.BrushTabletMenuControl;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMainViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMenuHideViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorGradationViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorMenuViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorRecentViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.MenuLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModelList;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.BrushSettingsViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.ColorPickerViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.submenu.SubMenuViewModel;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001,\b\u0016\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003MNOB\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bB%\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eJ\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020&H\u0014J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0014J\u0012\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u000104H\u0002J\u0012\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00108\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010:\u001a\u00020&2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u00020&2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020&H\u0002J\u0006\u0010A\u001a\u00020&J\u0012\u0010B\u001a\u00020&2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020&H\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0014R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020F8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006P"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/support/senl/addons/brush/binding/method/BMBrushMenuView;", "Lcom/samsung/android/support/senl/addons/brush/binding/method/BMBrushEraserView;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode$OnRotationChangeListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSpenSettingBrushLayout", "Lcom/samsung/android/sdk/pen/setting/SpenSettingBrushLayout;", "mBrushMenuControl", "Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl;", "mSettingLayoutChangeListener", "Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer$SettingLayoutChangeListener;", "mSettingLayoutChildChangeListener", "Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer$SettingLayoutChildChangeListener;", "mPenViewModelList", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList;", "mColorMenuViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorMenuViewModel;", "mColorRecentViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorRecentViewModel;", "mColorGradationViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorGradationViewModel;", "mColorPickerViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/ColorPickerViewModel;", "mBrushMainViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMainViewModel;", "mSubMenuViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/submenu/SubMenuViewModel;", "init", "", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "mPenViewModeChangeListener", "com/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer$mPenViewModeChangeListener$1", "Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer$mPenViewModeChangeListener$1;", "mPenListCallback", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Observer;", "mColorMenuCallback", "mMainCallback", "applyRecentColor", "hsvColor", "", "setLayoutViewModel", "layoutViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushLayoutViewModel;", "setMainViewModel", "mainViewModel", "setSettingsViewModel", "settingsViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/BrushSettingsViewModel;", "setMenuHideViewModel", "menuHideViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMenuHideViewModel;", "release", "close", "onRotationChanged", "action", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "menuInfo", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "getMenuInfo", "()Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "setEraserSelection", "selection", "", "updateMenuTopPosition", "Companion", "SettingLayoutChangeListener", "SettingLayoutChildChangeListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushMenuContainer extends RelativeLayout implements BMBrushMenuView, BMBrushEraserView, IRotationMode.OnRotationChangeListener {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushMenuContainer");

    @Nullable
    private BrushMainViewModel mBrushMainViewModel;

    @Nullable
    private BrushMenuControl mBrushMenuControl;

    @Nullable
    private ColorGradationViewModel mColorGradationViewModel;

    @NotNull
    private final IBaseViewModel.Observer mColorMenuCallback;

    @Nullable
    private ColorMenuViewModel mColorMenuViewModel;

    @Nullable
    private ColorPickerViewModel mColorPickerViewModel;

    @Nullable
    private ColorRecentViewModel mColorRecentViewModel;

    @NotNull
    private final IBaseViewModel.Observer mMainCallback;

    @NotNull
    private final IBaseViewModel.Observer mPenListCallback;

    @NotNull
    private final BrushMenuContainer$mPenViewModeChangeListener$1 mPenViewModeChangeListener;

    @Nullable
    private PenViewModelList mPenViewModelList;

    @Nullable
    private SettingLayoutChangeListener mSettingLayoutChangeListener;

    @Nullable
    private SettingLayoutChildChangeListener mSettingLayoutChildChangeListener;

    @Nullable
    private SpenSettingBrushLayout mSpenSettingBrushLayout;

    @Nullable
    private SubMenuViewModel mSubMenuViewModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer$SettingLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer;)V", "onLayoutChange", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class SettingLayoutChangeListener implements View.OnLayoutChangeListener {
        public SettingLayoutChangeListener() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (TabletUtil.isTabletUi()) {
                return;
            }
            int i = right - left;
            int i2 = bottom - top;
            int i4 = oldBottom - oldTop;
            if (oldRight - oldLeft == i && i4 == i2) {
                return;
            }
            if (i < i2) {
                SpenSettingBrushLayout spenSettingBrushLayout = BrushMenuContainer.this.mSpenSettingBrushLayout;
                if (spenSettingBrushLayout != null) {
                    spenSettingBrushLayout.setColorAlign(3);
                }
                SpenSettingBrushLayout spenSettingBrushLayout2 = BrushMenuContainer.this.mSpenSettingBrushLayout;
                if (spenSettingBrushLayout2 != null) {
                    spenSettingBrushLayout2.setPenAlign(3);
                }
            } else {
                SpenSettingBrushLayout spenSettingBrushLayout3 = BrushMenuContainer.this.mSpenSettingBrushLayout;
                if (spenSettingBrushLayout3 != null) {
                    spenSettingBrushLayout3.setColorAlign(2);
                }
                SpenSettingBrushLayout spenSettingBrushLayout4 = BrushMenuContainer.this.mSpenSettingBrushLayout;
                if (spenSettingBrushLayout4 != null) {
                    spenSettingBrushLayout4.setPenAlign(2);
                }
            }
            BrushMenuControl brushMenuControl = BrushMenuContainer.this.mBrushMenuControl;
            Intrinsics.checkNotNull(brushMenuControl);
            IBrushMenuInfo menuInfo = BrushMenuContainer.this.getMenuInfo();
            View rootView = BrushMenuContainer.this.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
            brushMenuControl.updateMenuInfo(menuInfo, rootView);
            Logger.m7100d(BrushMenuContainer.TAG, "onLayout. " + i + "x" + i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer$SettingLayoutChildChangeListener;", "Lcom/samsung/android/sdk/pen/setting/SpenSettingBrushLayout$ChildLayoutChangedListener;", "Lcom/samsung/android/sdk/pen/setting/SpenSettingBrushLayout$ChildActionListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuContainer;)V", "onPenRectChanged", "", "rect", "Landroid/graphics/Rect;", "onColorRectSizeChanged", "onPenAlignChanged", "align", "", "onColorAlignChanged", "onPenLongClicked", "onColorLongClicked", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class SettingLayoutChildChangeListener implements SpenSettingBrushLayout.ChildLayoutChangedListener, SpenSettingBrushLayout.ChildActionListener {
        public SettingLayoutChildChangeListener() {
        }

        @Override // com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout.ChildLayoutChangedListener
        public void onColorAlignChanged(int align) {
            AbstractC6670b.m4761v(align, "onColorAlignChanged. ", BrushMenuContainer.TAG);
            BrushMenuControl brushMenuControl = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl != null) {
                IBrushMenuInfo menuInfo = BrushMenuContainer.this.getMenuInfo();
                View rootView = BrushMenuContainer.this.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                brushMenuControl.updateMenuInfo(menuInfo, rootView);
            }
            BrushMenuControl brushMenuControl2 = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl2 != null) {
                brushMenuControl2.disableSmartTipPopup();
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.SpenChildActionListener
        public void onColorLongClicked() {
            BrushMenuControl brushMenuControl = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl != null) {
                brushMenuControl.disableSmartTipPopup();
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout.ChildLayoutChangedListener
        public void onColorRectSizeChanged(@NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Logger.m7100d(BrushMenuContainer.TAG, "onColorRectSizeChanged. " + rect);
            BrushMenuControl brushMenuControl = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl != null) {
                IBrushMenuInfo menuInfo = BrushMenuContainer.this.getMenuInfo();
                View rootView = BrushMenuContainer.this.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                brushMenuControl.updateMenuInfo(menuInfo, rootView);
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout.ChildLayoutChangedListener
        public void onPenAlignChanged(int align) {
            AbstractC6670b.m4761v(align, "onPenAlignChanged. ", BrushMenuContainer.TAG);
            BrushMenuControl brushMenuControl = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl != null) {
                IBrushMenuInfo menuInfo = BrushMenuContainer.this.getMenuInfo();
                View rootView = BrushMenuContainer.this.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                brushMenuControl.updateMenuInfo(menuInfo, rootView);
            }
            BrushMenuControl brushMenuControl2 = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl2 != null) {
                brushMenuControl2.disableSmartTipPopup();
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.SpenChildActionListener
        public void onPenLongClicked() {
            BrushMenuControl brushMenuControl = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl != null) {
                brushMenuControl.disableSmartTipPopup();
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout.ChildLayoutChangedListener
        public void onPenRectChanged(@NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Logger.m7100d(BrushMenuContainer.TAG, "onPenRectChanged. " + rect);
            BrushMenuControl brushMenuControl = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl != null) {
                IBrushMenuInfo menuInfo = BrushMenuContainer.this.getMenuInfo();
                View rootView = BrushMenuContainer.this.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                brushMenuControl.updateMenuInfo(menuInfo, rootView);
            }
            BrushMenuControl brushMenuControl2 = BrushMenuContainer.this.mBrushMenuControl;
            if (brushMenuControl2 != null) {
                brushMenuControl2.setSmartTipPopup();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenViewModeChangeListener$1] */
    public BrushMenuContainer(@Nullable Context context) {
        super(context);
        this.mPenViewModeChangeListener = new SpenBrushPenTypeLayout.OnModeChangeListener() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenViewModeChangeListener$1
            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout.OnModeChangeListener
            public void onModeChanged(int mode) {
                AbstractC6670b.m4761v(mode, "onModeChanged. ", BrushMenuContainer.TAG);
                boolean z = mode == 2;
                BrushMenuControl brushMenuControl = this.this$0.mBrushMenuControl;
                if (brushMenuControl != null) {
                    brushMenuControl.setColorViewVisibility(z);
                }
                BrushMenuControl brushMenuControl2 = this.this$0.mBrushMenuControl;
                if (brushMenuControl2 != null) {
                    IBrushMenuInfo menuInfo = this.this$0.getMenuInfo();
                    View rootView = this.this$0.getRootView();
                    Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                    brushMenuControl2.updateMenuInfo(menuInfo, rootView);
                }
            }
        };
        this.mPenListCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenListCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                BrushMenuControl brushMenuControl;
                String id = info != null ? info.getId() : null;
                IPenViewModelList.Companion companion = IPenViewModelList.INSTANCE;
                if (Intrinsics.areEqual(id, companion.getOBSV_VIEW_PEN_SELECTED_CHANGE())) {
                    BrushMenuControl brushMenuControl2 = this.this$0.mBrushMenuControl;
                    if (brushMenuControl2 != null) {
                        brushMenuControl2.updateCurrentPenView();
                    }
                    BrushMenuControl brushMenuControl3 = this.this$0.mBrushMenuControl;
                    if (brushMenuControl3 != null) {
                        brushMenuControl3.updateCurrentColorView(true);
                        return;
                    }
                    return;
                }
                if (!Intrinsics.areEqual(id, "erase_button_click")) {
                    if (!Intrinsics.areEqual(id, companion.getOBSV_VIEW_PEN_CHANGE_OPACITY()) || (brushMenuControl = this.this$0.mBrushMenuControl) == null) {
                        return;
                    }
                    brushMenuControl.updateCurrentPenView();
                    return;
                }
                BrushMenuControl brushMenuControl4 = this.this$0.mBrushMenuControl;
                if (brushMenuControl4 != null) {
                    PenViewModelList penViewModelList = this.this$0.mPenViewModelList;
                    PenViewModel mEraserViewModel = penViewModelList != null ? penViewModelList.getMEraserViewModel() : null;
                    Intrinsics.checkNotNull(mEraserViewModel);
                    brushMenuControl4.updateCurrentPenView(mEraserViewModel);
                }
            }
        };
        this.mColorMenuCallback = new BrushMenuContainer$mColorMenuCallback$1(this);
        this.mMainCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mMainCallback$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                String id = info != null ? info.getId() : null;
                if (id != null) {
                    switch (id.hashCode()) {
                        case -902089316:
                            if (id.equals("ble_single_press_type_2")) {
                                BrushMenuContainer brushMenuContainer = this.this$0;
                                ColorRecentViewModel colorRecentViewModel = brushMenuContainer.mColorRecentViewModel;
                                brushMenuContainer.applyRecentColor(colorRecentViewModel != null ? colorRecentViewModel.getPrevRecentColor() : null);
                                return;
                            }
                            return;
                        case -864243566:
                            if (!id.equals("erase_all_button_click")) {
                                return;
                            }
                            break;
                        case 875125433:
                            if (!id.equals("ble_double_press")) {
                                return;
                            }
                            break;
                        case 1636429296:
                            if (id.equals("ble_single_press")) {
                                BrushMenuContainer brushMenuContainer2 = this.this$0;
                                ColorRecentViewModel colorRecentViewModel2 = brushMenuContainer2.mColorRecentViewModel;
                                brushMenuContainer2.applyRecentColor(colorRecentViewModel2 != null ? colorRecentViewModel2.getNextRecentColor() : null);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    BrushMenuControl brushMenuControl = this.this$0.mBrushMenuControl;
                    if (brushMenuControl != null) {
                        brushMenuControl.updateCurrentPenView();
                    }
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyRecentColor(float[] hsvColor) {
        ColorMenuViewModel colorMenuViewModel = this.mColorMenuViewModel;
        if (colorMenuViewModel != null) {
            colorMenuViewModel.setMainColorAndPosition(hsvColor, 1048576);
        }
        BrushMenuControl brushMenuControl = this.mBrushMenuControl;
        if (brushMenuControl != null) {
            brushMenuControl.selectNextRecentColor(hsvColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IBrushMenuInfo getMenuInfo() {
        boolean z;
        SpenSettingBrushLayout spenSettingBrushLayout = this.mSpenSettingBrushLayout;
        BrushMenuControl brushMenuControl = this.mBrushMenuControl;
        if (brushMenuControl != null) {
            Intrinsics.checkNotNull(brushMenuControl);
            z = brushMenuControl.isPenMenuOpen();
        }
        return new BrushMenuInfo(spenSettingBrushLayout, z);
    }

    private final void release() {
        SpenSettingBrushLayout spenSettingBrushLayout = this.mSpenSettingBrushLayout;
        if (spenSettingBrushLayout != null) {
            Intrinsics.checkNotNull(spenSettingBrushLayout);
            spenSettingBrushLayout.removeOnLayoutChangeListener(this.mSettingLayoutChangeListener);
            SpenSettingBrushLayout spenSettingBrushLayout2 = this.mSpenSettingBrushLayout;
            Intrinsics.checkNotNull(spenSettingBrushLayout2);
            spenSettingBrushLayout2.setChildLayoutChangedListener(null);
            SpenSettingBrushLayout spenSettingBrushLayout3 = this.mSpenSettingBrushLayout;
            Intrinsics.checkNotNull(spenSettingBrushLayout3);
            spenSettingBrushLayout3.setChildActionListener(null);
            removeView(this.mSpenSettingBrushLayout);
            SpenSettingBrushLayout spenSettingBrushLayout4 = this.mSpenSettingBrushLayout;
            Intrinsics.checkNotNull(spenSettingBrushLayout4);
            spenSettingBrushLayout4.close();
            this.mSpenSettingBrushLayout = null;
        }
        BrushMenuControl brushMenuControl = this.mBrushMenuControl;
        if (brushMenuControl != null) {
            Intrinsics.checkNotNull(brushMenuControl);
            brushMenuControl.close();
            this.mBrushMenuControl = null;
        }
        this.mSettingLayoutChangeListener = null;
        this.mSettingLayoutChildChangeListener = null;
    }

    private final void updateMenuTopPosition() {
        Context context = getContext();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((context instanceof Activity) && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (ScreenUtils.getWindowType((Activity) context) != 2) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = getResources().getDimensionPixelOffset(C7944R.dimen.brush_menu_top_margin_on_split_window);
            }
        }
    }

    public final void close() {
        Logger.m7100d(TAG, "close");
        release();
        ColorMenuViewModel colorMenuViewModel = this.mColorMenuViewModel;
        if (colorMenuViewModel != null) {
            Intrinsics.checkNotNull(colorMenuViewModel);
            IScreenModel screenModel = colorMenuViewModel.getMScreenModel();
            Intrinsics.checkNotNull(screenModel);
            screenModel.removeRotationChangeListener(this);
            this.mColorMenuViewModel = null;
        }
        PenViewModelList penViewModelList = this.mPenViewModelList;
        if (penViewModelList != null) {
            Intrinsics.checkNotNull(penViewModelList);
            penViewModelList.removeObserver(this.mPenListCallback);
            this.mPenViewModelList = null;
        }
        ColorRecentViewModel colorRecentViewModel = this.mColorRecentViewModel;
        if (colorRecentViewModel != null) {
            Intrinsics.checkNotNull(colorRecentViewModel);
            colorRecentViewModel.removeObserver(this.mColorMenuCallback);
            this.mColorRecentViewModel = null;
        }
        ColorGradationViewModel colorGradationViewModel = this.mColorGradationViewModel;
        if (colorGradationViewModel != null) {
            Intrinsics.checkNotNull(colorGradationViewModel);
            colorGradationViewModel.removeObserver(this.mColorMenuCallback);
            this.mColorGradationViewModel = null;
        }
        ColorPickerViewModel colorPickerViewModel = this.mColorPickerViewModel;
        if (colorPickerViewModel != null) {
            Intrinsics.checkNotNull(colorPickerViewModel);
            colorPickerViewModel.removeObserver(this.mColorMenuCallback);
            this.mColorPickerViewModel = null;
        }
        BrushMainViewModel brushMainViewModel = this.mBrushMainViewModel;
        if (brushMainViewModel != null) {
            Intrinsics.checkNotNull(brushMainViewModel);
            brushMainViewModel.removeObserver(this.mMainCallback);
            this.mBrushMainViewModel = null;
        }
        SubMenuViewModel subMenuViewModel = this.mSubMenuViewModel;
        if (subMenuViewModel != null) {
            Intrinsics.checkNotNull(subMenuViewModel);
            subMenuViewModel.removeObserver(this.mPenListCallback);
            this.mSubMenuViewModel = null;
        }
    }

    public final void init() {
        BrushMenuControl brushMenuControl = this.mBrushMenuControl;
        release();
        Logger.m7104i(TAG, "initialized");
        this.mBrushMenuControl = TabletUtil.isTabletUi() ? new BrushTabletMenuControl(brushMenuControl) : new BrushPhoneMenuControl(brushMenuControl);
        this.mSettingLayoutChangeListener = new SettingLayoutChangeListener();
        this.mSettingLayoutChildChangeListener = new SettingLayoutChildChangeListener();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BrushMenuControl brushMenuControl2 = this.mBrushMenuControl;
        SpenBrushLayoutInfo brushLayoutInfo = brushMenuControl2 != null ? brushMenuControl2.getBrushLayoutInfo() : null;
        Intrinsics.checkNotNull(brushLayoutInfo);
        this.mSpenSettingBrushLayout = new SpenSettingBrushLayout(context, brushLayoutInfo, new ArrayList(), new ArrayList());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        MenuLayoutInjector menuLayoutInjector = new MenuLayoutInjector(context2);
        SpenSettingBrushLayout spenSettingBrushLayout = this.mSpenSettingBrushLayout;
        Intrinsics.checkNotNull(spenSettingBrushLayout);
        spenSettingBrushLayout.setChildRoundedBackground(menuLayoutInjector.getRadius(), menuLayoutInjector.getBackgroundColor(), menuLayoutInjector.getStrokeSize(), menuLayoutInjector.getStrokeColor());
        SpenSettingBrushLayout spenSettingBrushLayout2 = this.mSpenSettingBrushLayout;
        Intrinsics.checkNotNull(spenSettingBrushLayout2);
        spenSettingBrushLayout2.addOnLayoutChangeListener(this.mSettingLayoutChangeListener);
        SpenSettingBrushLayout spenSettingBrushLayout3 = this.mSpenSettingBrushLayout;
        Intrinsics.checkNotNull(spenSettingBrushLayout3);
        spenSettingBrushLayout3.setChildLayoutChangedListener(this.mSettingLayoutChildChangeListener);
        SpenSettingBrushLayout spenSettingBrushLayout4 = this.mSpenSettingBrushLayout;
        Intrinsics.checkNotNull(spenSettingBrushLayout4);
        spenSettingBrushLayout4.setChildActionListener(this.mSettingLayoutChildChangeListener);
        BrushMenuControl brushMenuControl3 = this.mBrushMenuControl;
        if (brushMenuControl3 != null) {
            SpenSettingBrushLayout spenSettingBrushLayout5 = this.mSpenSettingBrushLayout;
            Intrinsics.checkNotNull(spenSettingBrushLayout5);
            brushMenuControl3.setBrushLayout(spenSettingBrushLayout5, this.mPenViewModeChangeListener);
        }
        addView(this.mSpenSettingBrushLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateMenuTopPosition();
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateMenuTopPosition();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode.OnRotationChangeListener
    public void onRotationChanged(@Nullable IRotationEvent action) {
        SpenSettingBrushLayout spenSettingBrushLayout = this.mSpenSettingBrushLayout;
        if (spenSettingBrushLayout != null) {
            Intrinsics.checkNotNull(spenSettingBrushLayout);
            Integer numValueOf = action != null ? Integer.valueOf(action.getMTarget()) : null;
            Intrinsics.checkNotNull(numValueOf);
            spenSettingBrushLayout.setChildRotation(numValueOf.intValue());
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushEraserView
    public void setEraserSelection(boolean selection) {
        if (!selection) {
            BrushMenuControl brushMenuControl = this.mBrushMenuControl;
            if (brushMenuControl != null) {
                brushMenuControl.updateCurrentPenView();
                return;
            }
            return;
        }
        BrushMenuControl brushMenuControl2 = this.mBrushMenuControl;
        if (brushMenuControl2 != null) {
            PenViewModelList penViewModelList = this.mPenViewModelList;
            PenViewModel eraserViewModel = penViewModelList != null ? penViewModelList.getMEraserViewModel() : null;
            Intrinsics.checkNotNull(eraserViewModel);
            brushMenuControl2.updateCurrentPenView(eraserViewModel);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView
    public void setLayoutViewModel(@Nullable BrushLayoutViewModel layoutViewModel) {
        MenuLayoutViewModel menuViewModel;
        ColorRecentViewModel recentVM;
        IScreenModel screenModel;
        MenuLayoutViewModel menuViewModel2;
        if (this.mBrushMenuControl == null) {
            Logger.m7101e(TAG, "setLayoutViewModel fail");
            return;
        }
        Logger.m7100d(TAG, "setLayoutViewModel");
        BrushMenuControl brushMenuControl = this.mBrushMenuControl;
        if (brushMenuControl != null) {
            brushMenuControl.setBrushLayoutViewModel(layoutViewModel);
        }
        ColorGradationViewModel colorGradationViewModel = null;
        PenViewModelList penViewModelList = layoutViewModel != null ? layoutViewModel.getPenViewModelList() : null;
        PenViewModelList penViewModelList2 = this.mPenViewModelList;
        if (penViewModelList2 != null && !Intrinsics.areEqual(penViewModelList2, penViewModelList)) {
            PenViewModelList penViewModelList3 = this.mPenViewModelList;
            Intrinsics.checkNotNull(penViewModelList3);
            penViewModelList3.removeObserver(this.mPenListCallback);
        }
        this.mPenViewModelList = penViewModelList;
        if (penViewModelList != null) {
            penViewModelList.addObserver(this.mPenListCallback);
        }
        BrushMenuControl brushMenuControl2 = this.mBrushMenuControl;
        if (brushMenuControl2 != null) {
            brushMenuControl2.setPenInfo(this.mPenViewModelList);
        }
        BrushMenuControl brushMenuControl3 = this.mBrushMenuControl;
        if (brushMenuControl3 != null) {
            brushMenuControl3.updateCurrentPenView();
        }
        SubMenuViewModel subMenuViewModel = this.mSubMenuViewModel;
        if (subMenuViewModel != null && subMenuViewModel.getEraserSelection() && this.mPenViewModelList != null) {
            BrushMenuControl brushMenuControl4 = this.mBrushMenuControl;
            Intrinsics.checkNotNull(brushMenuControl4);
            PenViewModelList penViewModelList4 = this.mPenViewModelList;
            Intrinsics.checkNotNull(penViewModelList4);
            PenViewModel eraserViewModel = penViewModelList4.getMEraserViewModel();
            Intrinsics.checkNotNull(eraserViewModel);
            brushMenuControl4.updateCurrentPenView(eraserViewModel);
        }
        ColorMenuViewModel colorMenuViewModel = (layoutViewModel == null || (menuViewModel2 = layoutViewModel.getMenuViewModel()) == null) ? null : menuViewModel2.getMColorMenuViewModel();
        ColorMenuViewModel colorMenuViewModel2 = this.mColorMenuViewModel;
        if (colorMenuViewModel2 != null && !Intrinsics.areEqual(colorMenuViewModel2, colorMenuViewModel)) {
            ColorMenuViewModel colorMenuViewModel3 = this.mColorMenuViewModel;
            Intrinsics.checkNotNull(colorMenuViewModel3);
            colorMenuViewModel3.removeObserver(this.mColorMenuCallback);
        }
        this.mColorMenuViewModel = colorMenuViewModel;
        if (colorMenuViewModel != null) {
            colorMenuViewModel.addObserver(this.mColorMenuCallback);
        }
        ColorMenuViewModel colorMenuViewModel4 = this.mColorMenuViewModel;
        if (colorMenuViewModel4 != null && (screenModel = colorMenuViewModel4.getMScreenModel()) != null) {
            screenModel.addRotationChangeListener(this);
        }
        BrushMenuControl brushMenuControl5 = this.mBrushMenuControl;
        if (brushMenuControl5 != null) {
            ColorMenuViewModel colorMenuViewModel5 = this.mColorMenuViewModel;
            brushMenuControl5.updatePaletteList(colorMenuViewModel5 != null ? colorMenuViewModel5.getSelectedIndices() : null);
        }
        BrushMenuControl brushMenuControl6 = this.mBrushMenuControl;
        if (brushMenuControl6 != null) {
            brushMenuControl6.updateCurrentColorView(false);
        }
        ColorMenuViewModel colorMenuViewModel6 = this.mColorMenuViewModel;
        ColorRecentViewModel recentVM2 = colorMenuViewModel6 != null ? colorMenuViewModel6.getMRecent() : null;
        ColorRecentViewModel colorRecentViewModel = this.mColorRecentViewModel;
        if (colorRecentViewModel != null && !Intrinsics.areEqual(colorRecentViewModel, recentVM2)) {
            ColorRecentViewModel colorRecentViewModel2 = this.mColorRecentViewModel;
            Intrinsics.checkNotNull(colorRecentViewModel2);
            colorRecentViewModel2.removeObserver(this.mColorMenuCallback);
        }
        this.mColorRecentViewModel = recentVM2;
        if (recentVM2 != null) {
            recentVM2.addObserver(this.mColorMenuCallback);
        }
        BrushMenuControl brushMenuControl7 = this.mBrushMenuControl;
        if (brushMenuControl7 != null) {
            ColorMenuViewModel colorMenuViewModel7 = this.mColorMenuViewModel;
            brushMenuControl7.setRecentPalette((colorMenuViewModel7 == null || (recentVM = colorMenuViewModel7.getMRecent()) == null) ? null : recentVM.getRecentPaletteList());
        }
        if (layoutViewModel != null && (menuViewModel = layoutViewModel.getMenuViewModel()) != null) {
            colorGradationViewModel = menuViewModel.getMColorGradationViewModel();
        }
        ColorGradationViewModel colorGradationViewModel2 = this.mColorGradationViewModel;
        if (colorGradationViewModel2 != null && !Intrinsics.areEqual(colorGradationViewModel2, colorGradationViewModel)) {
            ColorGradationViewModel colorGradationViewModel3 = this.mColorGradationViewModel;
            Intrinsics.checkNotNull(colorGradationViewModel3);
            colorGradationViewModel3.removeObserver(this.mColorMenuCallback);
        }
        this.mColorGradationViewModel = colorGradationViewModel;
        if (colorGradationViewModel != null) {
            colorGradationViewModel.addObserver(this.mColorMenuCallback);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView
    public void setMainViewModel(@Nullable BrushMainViewModel mainViewModel) {
        Logger.m7100d(TAG, "setMainViewModel");
        BrushMainViewModel brushMainViewModel = this.mBrushMainViewModel;
        if (brushMainViewModel != null && !Intrinsics.areEqual(brushMainViewModel, mainViewModel)) {
            BrushMainViewModel brushMainViewModel2 = this.mBrushMainViewModel;
            Intrinsics.checkNotNull(brushMainViewModel2);
            brushMainViewModel2.removeObserver(this.mMainCallback);
        }
        this.mBrushMainViewModel = mainViewModel;
        Intrinsics.checkNotNull(mainViewModel);
        mainViewModel.addObserver(this.mMainCallback);
        BrushMainViewModel brushMainViewModel3 = this.mBrushMainViewModel;
        Intrinsics.checkNotNull(brushMainViewModel3);
        SubMenuViewModel subMenuViewModel = brushMainViewModel3.getSubMenuViewModel();
        SubMenuViewModel subMenuViewModel2 = this.mSubMenuViewModel;
        if (subMenuViewModel2 != null && !Intrinsics.areEqual(subMenuViewModel2, subMenuViewModel)) {
            SubMenuViewModel subMenuViewModel3 = this.mSubMenuViewModel;
            Intrinsics.checkNotNull(subMenuViewModel3);
            subMenuViewModel3.removeObserver(this.mPenListCallback);
        }
        this.mSubMenuViewModel = subMenuViewModel;
        Intrinsics.checkNotNull(subMenuViewModel);
        subMenuViewModel.addObserver(this.mPenListCallback);
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView
    public void setMenuHideViewModel(@Nullable BrushMenuHideViewModel menuHideViewModel) {
        Logger.m7100d(TAG, "setMenuHideViewModel");
        BrushMenuControl brushMenuControl = this.mBrushMenuControl;
        if (brushMenuControl != null) {
            brushMenuControl.setMenuHideViewModel(menuHideViewModel);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView
    public void setSettingsViewModel(@Nullable BrushSettingsViewModel settingsViewModel) {
        Logger.m7100d(TAG, "setSettingsViewModel");
        BrushMenuControl brushMenuControl = this.mBrushMenuControl;
        if (brushMenuControl != null) {
            brushMenuControl.setSettingsViewModel(settingsViewModel);
        }
        ColorPickerViewModel colorPickerViewModel = settingsViewModel != null ? settingsViewModel.getColorPickerViewModel() : null;
        ColorPickerViewModel colorPickerViewModel2 = this.mColorPickerViewModel;
        if (colorPickerViewModel2 != null && !Intrinsics.areEqual(colorPickerViewModel2, colorPickerViewModel)) {
            ColorPickerViewModel colorPickerViewModel3 = this.mColorPickerViewModel;
            Intrinsics.checkNotNull(colorPickerViewModel3);
            colorPickerViewModel3.removeObserver(this.mColorMenuCallback);
        }
        this.mColorPickerViewModel = colorPickerViewModel;
        Intrinsics.checkNotNull(colorPickerViewModel);
        colorPickerViewModel.addObserver(this.mColorMenuCallback);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenViewModeChangeListener$1] */
    public BrushMenuContainer(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPenViewModeChangeListener = new SpenBrushPenTypeLayout.OnModeChangeListener() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenViewModeChangeListener$1
            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout.OnModeChangeListener
            public void onModeChanged(int mode) {
                AbstractC6670b.m4761v(mode, "onModeChanged. ", BrushMenuContainer.TAG);
                boolean z = mode == 2;
                BrushMenuControl brushMenuControl = this.this$0.mBrushMenuControl;
                if (brushMenuControl != null) {
                    brushMenuControl.setColorViewVisibility(z);
                }
                BrushMenuControl brushMenuControl2 = this.this$0.mBrushMenuControl;
                if (brushMenuControl2 != null) {
                    IBrushMenuInfo menuInfo = this.this$0.getMenuInfo();
                    View rootView = this.this$0.getRootView();
                    Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                    brushMenuControl2.updateMenuInfo(menuInfo, rootView);
                }
            }
        };
        this.mPenListCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenListCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                BrushMenuControl brushMenuControl;
                String id = info != null ? info.getId() : null;
                IPenViewModelList.Companion companion = IPenViewModelList.INSTANCE;
                if (Intrinsics.areEqual(id, companion.getOBSV_VIEW_PEN_SELECTED_CHANGE())) {
                    BrushMenuControl brushMenuControl2 = this.this$0.mBrushMenuControl;
                    if (brushMenuControl2 != null) {
                        brushMenuControl2.updateCurrentPenView();
                    }
                    BrushMenuControl brushMenuControl3 = this.this$0.mBrushMenuControl;
                    if (brushMenuControl3 != null) {
                        brushMenuControl3.updateCurrentColorView(true);
                        return;
                    }
                    return;
                }
                if (!Intrinsics.areEqual(id, "erase_button_click")) {
                    if (!Intrinsics.areEqual(id, companion.getOBSV_VIEW_PEN_CHANGE_OPACITY()) || (brushMenuControl = this.this$0.mBrushMenuControl) == null) {
                        return;
                    }
                    brushMenuControl.updateCurrentPenView();
                    return;
                }
                BrushMenuControl brushMenuControl4 = this.this$0.mBrushMenuControl;
                if (brushMenuControl4 != null) {
                    PenViewModelList penViewModelList = this.this$0.mPenViewModelList;
                    PenViewModel mEraserViewModel = penViewModelList != null ? penViewModelList.getMEraserViewModel() : null;
                    Intrinsics.checkNotNull(mEraserViewModel);
                    brushMenuControl4.updateCurrentPenView(mEraserViewModel);
                }
            }
        };
        this.mColorMenuCallback = new BrushMenuContainer$mColorMenuCallback$1(this);
        this.mMainCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mMainCallback$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                String id = info != null ? info.getId() : null;
                if (id != null) {
                    switch (id.hashCode()) {
                        case -902089316:
                            if (id.equals("ble_single_press_type_2")) {
                                BrushMenuContainer brushMenuContainer = this.this$0;
                                ColorRecentViewModel colorRecentViewModel = brushMenuContainer.mColorRecentViewModel;
                                brushMenuContainer.applyRecentColor(colorRecentViewModel != null ? colorRecentViewModel.getPrevRecentColor() : null);
                                return;
                            }
                            return;
                        case -864243566:
                            if (!id.equals("erase_all_button_click")) {
                                return;
                            }
                            break;
                        case 875125433:
                            if (!id.equals("ble_double_press")) {
                                return;
                            }
                            break;
                        case 1636429296:
                            if (id.equals("ble_single_press")) {
                                BrushMenuContainer brushMenuContainer2 = this.this$0;
                                ColorRecentViewModel colorRecentViewModel2 = brushMenuContainer2.mColorRecentViewModel;
                                brushMenuContainer2.applyRecentColor(colorRecentViewModel2 != null ? colorRecentViewModel2.getNextRecentColor() : null);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    BrushMenuControl brushMenuControl = this.this$0.mBrushMenuControl;
                    if (brushMenuControl != null) {
                        brushMenuControl.updateCurrentPenView();
                    }
                }
            }
        };
        init();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenViewModeChangeListener$1] */
    public BrushMenuContainer(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPenViewModeChangeListener = new SpenBrushPenTypeLayout.OnModeChangeListener() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenViewModeChangeListener$1
            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout.OnModeChangeListener
            public void onModeChanged(int mode) {
                AbstractC6670b.m4761v(mode, "onModeChanged. ", BrushMenuContainer.TAG);
                boolean z = mode == 2;
                BrushMenuControl brushMenuControl = this.this$0.mBrushMenuControl;
                if (brushMenuControl != null) {
                    brushMenuControl.setColorViewVisibility(z);
                }
                BrushMenuControl brushMenuControl2 = this.this$0.mBrushMenuControl;
                if (brushMenuControl2 != null) {
                    IBrushMenuInfo menuInfo = this.this$0.getMenuInfo();
                    View rootView = this.this$0.getRootView();
                    Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                    brushMenuControl2.updateMenuInfo(menuInfo, rootView);
                }
            }
        };
        this.mPenListCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mPenListCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                BrushMenuControl brushMenuControl;
                String id = info != null ? info.getId() : null;
                IPenViewModelList.Companion companion = IPenViewModelList.INSTANCE;
                if (Intrinsics.areEqual(id, companion.getOBSV_VIEW_PEN_SELECTED_CHANGE())) {
                    BrushMenuControl brushMenuControl2 = this.this$0.mBrushMenuControl;
                    if (brushMenuControl2 != null) {
                        brushMenuControl2.updateCurrentPenView();
                    }
                    BrushMenuControl brushMenuControl3 = this.this$0.mBrushMenuControl;
                    if (brushMenuControl3 != null) {
                        brushMenuControl3.updateCurrentColorView(true);
                        return;
                    }
                    return;
                }
                if (!Intrinsics.areEqual(id, "erase_button_click")) {
                    if (!Intrinsics.areEqual(id, companion.getOBSV_VIEW_PEN_CHANGE_OPACITY()) || (brushMenuControl = this.this$0.mBrushMenuControl) == null) {
                        return;
                    }
                    brushMenuControl.updateCurrentPenView();
                    return;
                }
                BrushMenuControl brushMenuControl4 = this.this$0.mBrushMenuControl;
                if (brushMenuControl4 != null) {
                    PenViewModelList penViewModelList = this.this$0.mPenViewModelList;
                    PenViewModel mEraserViewModel = penViewModelList != null ? penViewModelList.getMEraserViewModel() : null;
                    Intrinsics.checkNotNull(mEraserViewModel);
                    brushMenuControl4.updateCurrentPenView(mEraserViewModel);
                }
            }
        };
        this.mColorMenuCallback = new BrushMenuContainer$mColorMenuCallback$1(this);
        this.mMainCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer$mMainCallback$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                String id = info != null ? info.getId() : null;
                if (id != null) {
                    switch (id.hashCode()) {
                        case -902089316:
                            if (id.equals("ble_single_press_type_2")) {
                                BrushMenuContainer brushMenuContainer = this.this$0;
                                ColorRecentViewModel colorRecentViewModel = brushMenuContainer.mColorRecentViewModel;
                                brushMenuContainer.applyRecentColor(colorRecentViewModel != null ? colorRecentViewModel.getPrevRecentColor() : null);
                                return;
                            }
                            return;
                        case -864243566:
                            if (!id.equals("erase_all_button_click")) {
                                return;
                            }
                            break;
                        case 875125433:
                            if (!id.equals("ble_double_press")) {
                                return;
                            }
                            break;
                        case 1636429296:
                            if (id.equals("ble_single_press")) {
                                BrushMenuContainer brushMenuContainer2 = this.this$0;
                                ColorRecentViewModel colorRecentViewModel2 = brushMenuContainer2.mColorRecentViewModel;
                                brushMenuContainer2.applyRecentColor(colorRecentViewModel2 != null ? colorRecentViewModel2.getNextRecentColor() : null);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    BrushMenuControl brushMenuControl = this.this$0.mBrushMenuControl;
                    if (brushMenuControl != null) {
                        brushMenuControl.updateCurrentPenView();
                    }
                }
            }
        };
        init();
    }
}
