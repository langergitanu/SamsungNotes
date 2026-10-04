package com.samsung.android.support.senl.addons.brush.binding.binder;

import android.util.SparseArray;
import android.view.View;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsBooleanExecuteBinding;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsIntegerExecuteBinding;
import com.samsung.android.support.senl.addons.base.binding.binder.IBinding;
import com.samsung.android.support.senl.addons.base.binding.binder.IBindingFactory;
import com.samsung.android.support.senl.addons.base.binding.binder.IViewBind;
import com.samsung.android.support.senl.addons.base.binding.binder.IViewModelHolder;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.animation.HideAnimationData;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.binding.adapter.BABrushMenuHide;
import com.samsung.android.support.senl.addons.brush.binding.adapter.BADoneTextSize;
import com.samsung.android.support.senl.addons.brush.binding.adapter.BAImageButtonEnable;
import com.samsung.android.support.senl.addons.brush.binding.adapter.BAMakePreviewImage;
import com.samsung.android.support.senl.addons.brush.binding.adapter.BAZoomMenuPosition;
import com.samsung.android.support.senl.addons.brush.binding.method.BMBrushCanvas;
import com.samsung.android.support.senl.addons.brush.binding.method.BMBrushEraserView;
import com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView;
import com.samsung.android.support.senl.addons.brush.binding.method.BMBrushSettingPopupView;
import com.samsung.android.support.senl.addons.brush.binding.method.BMPanningBar;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushPreviewBitmap;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMainViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMenuHideViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.canvas.PreviewImageViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.common.IBrushVMCommand;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.addons.brush.viewmodel.panningbar.IPanningBarListener;
import com.samsung.android.support.senl.addons.brush.viewmodel.penup.IPenupView;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.BrushSettingsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0013\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBindingFactory;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/common/IBrushVMCommand;", "<init>", "()V", "createBinding", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "holder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "property", "", "Companion", "BrushDoneButtonSizeBinding", "BrushMenuHideAnimationBinding", "ImageButtonEnableBinding", "ImageButtonEnableWithoutEnableTintBinding", "DesktopModeEnableBinding", "BrushPreviewBinding", "ZoomTextPositionBinding", "ZoomMenuPositionBinding", "LayoutViewModelBinding", "MainViewModelBinding", "SettingViewModelBinding", "MenuHideViewModelBinding", "EraserSelectionBinding", "MenuInfoBinding", "BrushSettingPopupListenerBinding", "PenupListenerBinding", "PreviewImageViewModelBinding", "PanningBarListenerBinding", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushBindingFactory implements IBindingFactory, IBrushVMCommand {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushBindingFactory");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$BrushDoneButtonSizeBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BrushDoneButtonSizeBinding extends AbsIntegerExecuteBinding {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable Integer data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (data != null) {
                BADoneTextSize.INSTANCE.setDoneTextSize(view, data.intValue());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$BrushMenuHideAnimationBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Landroid/util/SparseArray;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/HideAnimationData;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BrushMenuHideAnimationBinding extends AbsExecuteBinding<SparseArray<HideAnimationData>> {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable SparseArray<HideAnimationData> data) {
            Intrinsics.checkNotNullParameter(view, "view");
            BABrushMenuHide.INSTANCE.runMenuHideAnimation(view, data);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$BrushPreviewBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushPreviewBitmap;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BrushPreviewBinding extends AbsExecuteBinding<BrushPreviewBitmap> {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable BrushPreviewBitmap data) {
            Intrinsics.checkNotNullParameter(view, "view");
            BAMakePreviewImage.INSTANCE.setPreviewImage(view, data);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$BrushSettingPopupListenerBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView$IChangeListener;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BrushSettingPopupListenerBinding extends AbsExecuteBinding<ISettingView.IChangeListener> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable ISettingView.IChangeListener data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof BMBrushSettingPopupView) {
                ((BMBrushSettingPopupView) view).setChangeListener(data);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$DesktopModeEnableBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DesktopModeEnableBinding extends AbsBooleanExecuteBinding {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable Boolean data) {
            Intrinsics.checkNotNullParameter(view, "view");
            BAImageButtonEnable.INSTANCE.setDesktopModeEnable(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$EraserSelectionBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class EraserSelectionBinding extends AbsBooleanExecuteBinding {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable Boolean data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!(view instanceof BMBrushEraserView) || data == null) {
                return;
            }
            ((BMBrushEraserView) view).setEraserSelection(data.booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$ImageButtonEnableBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ImageButtonEnableBinding extends AbsBooleanExecuteBinding {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable Boolean data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (data != null) {
                BAImageButtonEnable.INSTANCE.setButtonEnable(view, data.booleanValue(), true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$ImageButtonEnableWithoutEnableTintBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ImageButtonEnableWithoutEnableTintBinding extends AbsBooleanExecuteBinding {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable Boolean data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (data != null) {
                BAImageButtonEnable.INSTANCE.setButtonEnable(view, data.booleanValue(), false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$LayoutViewModelBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushLayoutViewModel;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LayoutViewModelBinding extends AbsExecuteBinding<BrushLayoutViewModel> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable BrushLayoutViewModel data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof BMBrushMenuView) {
                ((BMBrushMenuView) view).setLayoutViewModel(data);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$MainViewModelBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMainViewModel;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MainViewModelBinding extends AbsExecuteBinding<BrushMainViewModel> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable BrushMainViewModel data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof BMBrushMenuView) {
                ((BMBrushMenuView) view).setMainViewModel(data);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$MenuHideViewModelBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMenuHideViewModel;", "<init>", "()V", "getData", "id", "", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MenuHideViewModelBinding extends AbsExecuteBinding<BrushMenuHideViewModel> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable BrushMenuHideViewModel data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof BMBrushMenuView) {
                ((BMBrushMenuView) view).setMenuHideViewModel(data);
            }
        }

        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsBinding
        @Nullable
        public BrushMenuHideViewModel getData(@NotNull String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            IBaseViewModel viewModel = getViewModel();
            if (viewModel instanceof BrushMenuHideViewModel) {
                return (BrushMenuHideViewModel) viewModel;
            }
            Logger.m7105w(BrushBindingFactory.TAG, "Menu hide viewModel binding : error not found vm");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$MenuInfoBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MenuInfoBinding extends AbsExecuteBinding<IBrushMenuInfo> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable IBrushMenuInfo data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof BMBrushSettingPopupView) {
                ((BMBrushSettingPopupView) view).updateMenuInfo(data);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$PanningBarListenerBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/panningbar/IPanningBarListener;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PanningBarListenerBinding extends AbsExecuteBinding<IPanningBarListener> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable IPanningBarListener data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof BMPanningBar) {
                ((BMPanningBar) view).setListener(data);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$PenupListenerBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penup/IPenupView$IPenupViewListener;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PenupListenerBinding extends AbsExecuteBinding<IPenupView.IPenupViewListener> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable IPenupView.IPenupViewListener data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof IPenupView) {
                ((IPenupView) view).setPenUpListener(data);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$PreviewImageViewModelBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/canvas/PreviewImageViewModel;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PreviewImageViewModelBinding extends AbsExecuteBinding<PreviewImageViewModel> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable PreviewImageViewModel data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof BMBrushCanvas) {
                ((BMBrushCanvas) view).setPreviewImageViewModel(data);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$SettingViewModelBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/BrushSettingsViewModel;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SettingViewModelBinding extends AbsExecuteBinding<BrushSettingsViewModel> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable BrushSettingsViewModel data) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof BMBrushMenuView) {
                ((BMBrushMenuView) view).setSettingsViewModel(data);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$ZoomMenuPositionBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ZoomMenuPositionBinding extends AbsExecuteBinding<IBrushMenuInfo> {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable IBrushMenuInfo data) {
            Intrinsics.checkNotNullParameter(view, "view");
            BAZoomMenuPosition.INSTANCE.setZoomMenuPosition(view, data);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/binder/BrushBindingFactory$ZoomTextPositionBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ZoomTextPositionBinding extends AbsExecuteBinding<IBrushMenuInfo> {
        @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
        public void execute(@NotNull View view, @Nullable IBrushMenuInfo data) {
            Intrinsics.checkNotNullParameter(view, "view");
            BAZoomMenuPosition.INSTANCE.setZoomTextPosition(view, data);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBindingFactory
    @NotNull
    public IBinding createBinding(@Nullable IViewBind bind, @Nullable IViewModelHolder holder) {
        String mPropertyId = bind != null ? bind.getMPropertyId() : null;
        if (bind == null || mPropertyId == null) {
            return createBinding("");
        }
        boolean mIsPendingExecutable = bind.getMIsPendingExecutable();
        IBinding iBindingCreateBinding = createBinding(mPropertyId);
        iBindingCreateBinding.setValues(bind, holder);
        if (mIsPendingExecutable) {
            iBindingCreateBinding.setExecuteType(1);
        }
        return iBindingCreateBinding;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final IBinding createBinding(String property) {
        Logger.m7100d(TAG, "createBinding. " + property);
        switch (property.hashCode()) {
            case -1653232473:
                if (property.equals("ad_brush_preview")) {
                    return new BrushPreviewBinding();
                }
                break;
            case -1569281609:
                if (property.equals("md_brush_previewImageVM")) {
                    return new PreviewImageViewModelBinding();
                }
                break;
            case -668230034:
                if (property.equals("md_brush_layoutVM")) {
                    return new LayoutViewModelBinding();
                }
                break;
            case -636916838:
                if (property.equals("md_brush_settingVM")) {
                    return new SettingViewModelBinding();
                }
                break;
            case -461707850:
                if (property.equals("ad_brush_doneButtonSize")) {
                    return new BrushDoneButtonSizeBinding();
                }
                break;
            case -26100639:
                if (property.equals("ad_brush_desktopModeEnable")) {
                    return new DesktopModeEnableBinding();
                }
                break;
            case 18932154:
                if (property.equals("md_brush_menuInfo")) {
                    return new MenuInfoBinding();
                }
                break;
            case 25141405:
                if (property.equals("md_brush_settingPopupListener")) {
                    return new BrushSettingPopupListenerBinding();
                }
                break;
            case 309873693:
                if (property.equals("ad_brush_imageEnable")) {
                    return new ImageButtonEnableBinding();
                }
                break;
            case 340303997:
                if (property.equals("md_brush_mainVM")) {
                    return new MainViewModelBinding();
                }
                break;
            case 569661724:
                if (property.equals("ad_brush_zoomMenuPosition")) {
                    return new ZoomMenuPositionBinding();
                }
                break;
            case 617576283:
                if (property.equals("md_brush_penupListener")) {
                    return new PenupListenerBinding();
                }
                break;
            case 631372830:
                if (property.equals("ad_brush_imageEnable_without_enable_tint")) {
                    return new ImageButtonEnableWithoutEnableTintBinding();
                }
                break;
            case 653439842:
                if (property.equals("ad_brush_menuHideAnimation")) {
                    return new BrushMenuHideAnimationBinding();
                }
                break;
            case 980617605:
                if (property.equals("md_brush_menuHideVM")) {
                    return new MenuHideViewModelBinding();
                }
                break;
            case 1315560170:
                if (property.equals("ad_brush_zoomTextPosition")) {
                    return new ZoomTextPositionBinding();
                }
                break;
            case 1739921587:
                if (property.equals("md_brush_eraserSelection")) {
                    return new EraserSelectionBinding();
                }
                break;
            case 2091254083:
                if (property.equals("md_brush_panningbarListener")) {
                    return new PanningBarListenerBinding();
                }
                break;
        }
        return new IBinding.EmptyBinding();
    }
}
