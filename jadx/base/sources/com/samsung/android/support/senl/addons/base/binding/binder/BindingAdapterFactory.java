package com.samsung.android.support.senl.addons.base.binding.binder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAContentTransparentControl;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAFont;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAImageViewSource;
import com.samsung.android.support.senl.addons.base.binding.adapters.BARTLFlip;
import com.samsung.android.support.senl.addons.base.binding.adapters.BARotationView;
import com.samsung.android.support.senl.addons.base.binding.adapters.BASettingPopupControl;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAViewBackground;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAViewHideAnimation;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAViewHover;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAViewLayout;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAViewRipple;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAViewState;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAVisibility;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAZoomRatioText;
import com.samsung.android.support.senl.addons.base.binding.binder.IBinding;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopup;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationExtraEvent;
import com.samsung.android.support.senl.addons.base.viewmodel.animation.HideAnimationData;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IVMCommand;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IVMCommand;", "<init>", "()V", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BindingAdapterFactory implements IVMCommand {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0003\u0018\u00002\u00020\u0001:\u001e\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion;", "", "<init>", "()V", "createBinding", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "holder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "createViewPropertyBinding", "id", "", "createOthersBinding", "BGColorBinding", "BGBiding", "BGColorAlphaBinding", "VisibleHideBinding", "VisibleGoneBinding", "VisibleGoneWithAnimationBinding", "TransparentBinding", "SettingPopupBinding", "HoverPopupBiding", "SelectedBinding", "EnabledBinding", "RtlFlippingBinding", "ViewWeightBinding", "HideAnimationByTouchBinding", "BitmapSrcBinding", "FocusableBinding", "ConsumeHoverBinding", "ViewWidthBinding", "ViewHeightBinding", "ViewMarginBottomBinding", "ViewMarginBottomResIdBinding", "ViewMarginEndBinding", "ViewMarginStartBinding", "ViewMarginTopBinding", "ViewPaddingEndBinding", "ViewGravityByDirection", "ZoomRatioTextBinding", "BackgroundRippleBinding", "RotationExtraBinding", "FontBinding", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$BGBiding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class BGBiding extends AbsExecuteBinding<Drawable> {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Drawable data) {
                Intrinsics.checkNotNullParameter(view, "view");
                BAViewBackground.INSTANCE.setViewBackground(view, data);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$BGColorAlphaBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsColorExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class BGColorAlphaBinding extends AbsColorExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                BAViewBackground.INSTANCE.setViewBackgroundColorAlpha(view, data);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$BGColorBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsColorExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class BGColorBinding extends AbsColorExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                BAViewBackground.INSTANCE.setViewBackgroundColor(view, data);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$BackgroundRippleBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class BackgroundRippleBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewRipple.INSTANCE.setBackgroundRipple(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$BitmapSrcBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Landroid/graphics/Bitmap;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class BitmapSrcBinding extends AbsExecuteBinding<Bitmap> {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Bitmap data) {
                Intrinsics.checkNotNullParameter(view, "view");
                BAImageViewSource.INSTANCE.setImageViewImage((ImageView) view, data);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ConsumeHoverBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ConsumeHoverBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewHover.INSTANCE.setHoverListenerForConsuming(view);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$EnabledBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class EnabledBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewState.INSTANCE.setBtnEnabled(view, data.booleanValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$FocusableBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class FocusableBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewState.INSTANCE.setBtnFocusable(view, data.booleanValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$FontBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsStringExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class FontBinding extends AbsStringExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable String data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (view instanceof TextView) {
                    BAFont.INSTANCE.setFont((TextView) view, data);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$HideAnimationByTouchBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Landroid/util/SparseArray;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/HideAnimationData;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class HideAnimationByTouchBinding extends AbsExecuteBinding<SparseArray<HideAnimationData>> {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable SparseArray<HideAnimationData> data) {
                Intrinsics.checkNotNullParameter(view, "view");
                BAViewHideAnimation.INSTANCE.runHideAnimation(view, data);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$HoverPopupBiding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class HoverPopupBiding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    ViewCompat.INSTANCE.getInstance().setTooltipText(view, view.getContentDescription());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$RotationExtraBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationExtraEvent;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class RotationExtraBinding extends AbsExecuteBinding<IRotationExtraEvent> {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable IRotationExtraEvent data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null && data.getMDataType() == 2) {
                    BARotationView.setRotation(view, data, data.getMExtraData());
                } else {
                    if (data == null || data.getMDataType() != 1) {
                        return;
                    }
                    BARotationView.INSTANCE.setRotation(view, data, view.getResources().getString(data.getMExtraData()));
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$RtlFlippingBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class RtlFlippingBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BARTLFlip.INSTANCE.setRtlXFlipping(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$SelectedBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class SelectedBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewState.INSTANCE.setViewSelected(view, data.booleanValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$SettingPopupBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopup;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class SettingPopupBinding extends AbsExecuteBinding<ISettingPopup> {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable ISettingPopup data) {
                Intrinsics.checkNotNullParameter(view, "view");
                BASettingPopupControl.INSTANCE.setSettingPopup(view, data);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$TransparentBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class TransparentBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAContentTransparentControl.INSTANCE.setTransparency(view, data.booleanValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewGravityByDirection;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewGravityByDirection extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewGravityByDirection(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewHeightBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewHeightBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewHeight(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewMarginBottomBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewMarginBottomBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewMarginBottom(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewMarginBottomResIdBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewMarginBottomResIdBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewMarginBottomResId(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewMarginEndBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewMarginEndBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewMarginEnd(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewMarginStartBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewMarginStartBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewMarginStart(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewMarginTopBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewMarginTopBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewMarginTop(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewPaddingEndBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewPaddingEndBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewPaddingEnd(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewWeightBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsFloatExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Float;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewWeightBinding extends AbsFloatExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Float data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewWeight(view, data.floatValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ViewWidthBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ViewWidthBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAViewLayout.INSTANCE.setViewWidth(view, data.intValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$VisibleGoneBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class VisibleGoneBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAVisibility.INSTANCE.setVisibleAndGone(view, data.booleanValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$VisibleGoneWithAnimationBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class VisibleGoneWithAnimationBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAVisibility.INSTANCE.setVisibleAndGoneWithAnimation(view, data.booleanValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$VisibleHideBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class VisibleHideBinding extends AbsBooleanExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (data != null) {
                    BAVisibility.INSTANCE.setVisibleAndInvisible(view, data.booleanValue());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingAdapterFactory$Companion$ZoomRatioTextBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsIntegerExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ZoomRatioTextBinding extends AbsIntegerExecuteBinding {
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Integer data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (!(view instanceof TextView) || data == null) {
                    return;
                }
                BAZoomRatioText.INSTANCE.setZoomRatioText((TextView) view, data.intValue());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private final IBinding createOthersBinding(String id) {
            if (id != null) {
                switch (id.hashCode()) {
                    case -2131167794:
                        if (id.equals("ad_base_settingPopup")) {
                            return new SettingPopupBinding();
                        }
                        break;
                    case -1846927234:
                        if (id.equals("ad_base_drawableBackground")) {
                            return new BGBiding();
                        }
                        break;
                    case -1723728392:
                        if (id.equals("ad_base_hideAnimationByTouch")) {
                            return new HideAnimationByTouchBinding();
                        }
                        break;
                    case -872039965:
                        if (id.equals("ad_base_bitmapSrc")) {
                            return new BitmapSrcBinding();
                        }
                        break;
                    case -560959969:
                        if (id.equals("ad_base_colorBackground")) {
                            return new BGColorBinding();
                        }
                        break;
                    case 180466656:
                        if (id.equals("ad_base_rotationExtra")) {
                            return new RotationExtraBinding();
                        }
                        break;
                    case 267047296:
                        if (id.equals("ad_base_transparent")) {
                            return new TransparentBinding();
                        }
                        break;
                    case 468305395:
                        if (id.equals("ad_base_zoomRatioText")) {
                            return new ZoomRatioTextBinding();
                        }
                        break;
                    case 736193250:
                        if (id.equals("ad_base_hoverPopup")) {
                            return new HoverPopupBiding();
                        }
                        break;
                    case 782109746:
                        if (id.equals("ad_base_consumeHover")) {
                            return new ConsumeHoverBinding();
                        }
                        break;
                    case 1042666896:
                        if (id.equals("ad_base_backgroundRipple")) {
                            return new BackgroundRippleBinding();
                        }
                        break;
                    case 1318834145:
                        if (id.equals("ad_base_font")) {
                            return new FontBinding();
                        }
                        break;
                    case 1451703103:
                        if (id.equals("ad_base_visibleGoneWithAnimation")) {
                            return new VisibleGoneWithAnimationBinding();
                        }
                        break;
                    case 1501254201:
                        if (id.equals("ad_base_setBackgroundColorAlpha")) {
                            return new BGColorAlphaBinding();
                        }
                        break;
                    case 1963658263:
                        if (id.equals("ad_base_rtlFlipping")) {
                            return new RtlFlippingBinding();
                        }
                        break;
                    case 2123419743:
                        if (id.equals("ad_base_visibleGone")) {
                            return new VisibleGoneBinding();
                        }
                        break;
                    case 2123443458:
                        if (id.equals("ad_base_visibleHide")) {
                            return new VisibleHideBinding();
                        }
                        break;
                }
            }
            return new IBinding.EmptyBinding();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private final IBinding createViewPropertyBinding(String id) {
            if (id != null) {
                switch (id.hashCode()) {
                    case -2096024981:
                        if (id.equals("ad_base_viewMarginBottomResId")) {
                            return new ViewMarginBottomResIdBinding();
                        }
                        break;
                    case -1738985998:
                        if (id.equals("ad_base_viewSelected")) {
                            return new SelectedBinding();
                        }
                        break;
                    case -1711229378:
                        if (id.equals("ad_base_viewHeight")) {
                            return new ViewHeightBinding();
                        }
                        break;
                    case -1697795114:
                        if (id.equals("ad_base_viewMarginEnd")) {
                            return new ViewMarginEndBinding();
                        }
                        break;
                    case -1697780656:
                        if (id.equals("ad_base_viewMarginTop")) {
                            return new ViewMarginTopBinding();
                        }
                        break;
                    case -1563735728:
                        if (id.equals("ad_base_viewMarginBottom")) {
                            return new ViewMarginBottomBinding();
                        }
                        break;
                    case -1404460975:
                        if (id.equals("ad_base_viewGravityByDirection")) {
                            return new ViewGravityByDirection();
                        }
                        break;
                    case -1281792113:
                        if (id.equals("ad_base_viewWeight")) {
                            return new ViewWeightBinding();
                        }
                        break;
                    case 374081802:
                        if (id.equals("ad_base_viewEnabled")) {
                            return new EnabledBinding();
                        }
                        break;
                    case 519576733:
                        if (id.equals("ad_base_viewMarginStart")) {
                            return new ViewMarginStartBinding();
                        }
                        break;
                    case 976022971:
                        if (id.equals("ad_base_viewFocusable")) {
                            return new FocusableBinding();
                        }
                        break;
                    case 1322307745:
                        if (id.equals("ad_base_viewPaddingEnd")) {
                            return new ViewPaddingEndBinding();
                        }
                        break;
                    case 1482787279:
                        if (id.equals("ad_base_viewWidth")) {
                            return new ViewWidthBinding();
                        }
                        break;
                }
            }
            return new IBinding.EmptyBinding();
        }

        @NotNull
        public final IBinding createBinding(@NotNull IViewBind bind, @Nullable IViewModelHolder holder) {
            Intrinsics.checkNotNullParameter(bind, "bind");
            String mPropertyId = bind.getMPropertyId();
            IBinding iBindingCreateOthersBinding = (mPropertyId == null || !StringsKt.m14145S(mPropertyId, "ad_base_view")) ? createOthersBinding(mPropertyId) : createViewPropertyBinding(mPropertyId);
            iBindingCreateOthersBinding.setValues(bind, holder);
            return iBindingCreateOthersBinding;
        }

        private Companion() {
        }
    }
}
