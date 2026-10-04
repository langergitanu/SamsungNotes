package com.samsung.android.support.senl.addons.base.binding.binder;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import com.samsung.android.support.senl.addons.base.binding.binder.BindingActionFactory;
import com.samsung.android.support.senl.addons.base.binding.binder.IBinding;
import com.samsung.android.support.senl.addons.base.model.event.LayoutChangeEvent;
import com.samsung.android.support.senl.addons.base.model.event.TouchEvent;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IVMCommand;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IVMCommand;", "<init>", "()V", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BindingActionFactory implements IVMCommand {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0005\n\u000b\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion;", "", "<init>", "()V", "createBinding", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "holder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "TouchBinding", "ClickBinding", "LongClickBinding", "ProgressBarBinding", "LayoutChangeBinding", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$ClickBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBinding;", "", "<init>", "()V", "mClickAction", "Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$ClickBinding$ClickAction;", "setValues", "", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBindInfo;", "vmHolder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "unbind", "ClickAction", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ClickBinding extends AbsBinding<Object> {

            @Nullable
            private ClickAction mClickAction;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$ClickBinding$ClickAction;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsAction;", "type", "", "subType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
            public static final class ClickAction extends AbsAction {
                public ClickAction(@Nullable String str, @Nullable String str2) {
                    super(str, str2);
                }

                @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
                @Nullable
                public Object getData() {
                    return getMBindId();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void bind$lambda$0(ClickBinding clickBinding, View view) {
                IBaseViewModel viewModel = clickBinding.getViewModel();
                if (viewModel != null) {
                    viewModel.perform(clickBinding.mClickAction);
                }
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void bind() {
                View view = getView();
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.addons.base.binding.binder.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            BindingActionFactory.Companion.ClickBinding.bind$lambda$0(this.f5702a, view2);
                        }
                    });
                }
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsBinding, com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void setValues(@NotNull IViewBindInfo bind, @Nullable IViewModelHolder vmHolder) {
                Intrinsics.checkNotNullParameter(bind, "bind");
                super.setValues(bind, vmHolder);
                this.mClickAction = new ClickAction("action_click", bind.getMBindingId());
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void unbind() {
                View view = getView();
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$LayoutChangeBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBinding;", "", "<init>", "()V", "mLayoutChangeAction", "Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$LayoutChangeBinding$LayoutChangeAction;", "mLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "setValues", "", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBindInfo;", "vmHolder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "unbind", "LayoutChangeAction", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class LayoutChangeBinding extends AbsBinding<Object> {

            @Nullable
            private LayoutChangeAction mLayoutChangeAction;

            @Nullable
            private View.OnLayoutChangeListener mLayoutChangeListener;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016JP\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$LayoutChangeBinding$LayoutChangeAction;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsAction;", "type", "", "subType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "mLayoutChangeEvent", "Lcom/samsung/android/support/senl/addons/base/model/event/LayoutChangeEvent;", "getData", "", "setLayoutChangeEvent", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
            public static final class LayoutChangeAction extends AbsAction {

                @NotNull
                private final LayoutChangeEvent mLayoutChangeEvent;

                public LayoutChangeAction(@Nullable String str, @Nullable String str2) {
                    super(str, str2);
                    this.mLayoutChangeEvent = new LayoutChangeEvent();
                }

                @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
                @NotNull
                public Object getData() {
                    return this.mLayoutChangeEvent;
                }

                public final void setLayoutChangeEvent(@Nullable View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    LayoutChangeEvent layoutChangeEvent = this.mLayoutChangeEvent;
                    layoutChangeEvent.mView = v;
                    layoutChangeEvent.mLeft = left;
                    layoutChangeEvent.mTop = top;
                    layoutChangeEvent.mRight = right;
                    layoutChangeEvent.mBottom = bottom;
                    layoutChangeEvent.mOldLeft = oldLeft;
                    layoutChangeEvent.mOldTop = oldTop;
                    layoutChangeEvent.mOldRight = oldRight;
                    layoutChangeEvent.mOldBottom = oldBottom;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001d  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static final void bind$lambda$0(LayoutChangeBinding layoutChangeBinding, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                int i10;
                int i11;
                int i12;
                LayoutChangeAction layoutChangeAction;
                IBaseViewModel viewModel;
                if (i == i6) {
                    i11 = i8;
                    i10 = i7;
                    if (i4 == i11) {
                        i12 = i9;
                        if (i2 == i10 && i5 == i12) {
                            return;
                        }
                    }
                    layoutChangeAction = layoutChangeBinding.mLayoutChangeAction;
                    if (layoutChangeAction != null) {
                        layoutChangeAction.setLayoutChangeEvent(view, i, i2, i4, i5, i6, i10, i11, i12);
                    }
                    viewModel = layoutChangeBinding.getViewModel();
                    if (viewModel == null) {
                        viewModel.perform(layoutChangeBinding.mLayoutChangeAction);
                        return;
                    }
                    return;
                }
                i10 = i7;
                i11 = i8;
                i12 = i9;
                layoutChangeAction = layoutChangeBinding.mLayoutChangeAction;
                if (layoutChangeAction != null) {
                }
                viewModel = layoutChangeBinding.getViewModel();
                if (viewModel == null) {
                }
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void bind() {
                this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.addons.base.binding.binder.b
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                        BindingActionFactory.Companion.LayoutChangeBinding.bind$lambda$0(this.f5703a, view, i, i2, i4, i5, i6, i7, i8, i9);
                    }
                };
                View view = getView();
                if (view != null) {
                    view.addOnLayoutChangeListener(this.mLayoutChangeListener);
                }
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsBinding, com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void setValues(@NotNull IViewBindInfo bind, @Nullable IViewModelHolder vmHolder) {
                Intrinsics.checkNotNullParameter(bind, "bind");
                super.setValues(bind, vmHolder);
                this.mLayoutChangeAction = new LayoutChangeAction("action_layoutChange", bind.getMBindingId());
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void unbind() {
                View view = getView();
                if (view != null) {
                    view.removeOnLayoutChangeListener(this.mLayoutChangeListener);
                }
                this.mLayoutChangeListener = null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$LongClickBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBinding;", "", "<init>", "()V", "TOOLTIP_TIME_SHOW", "", "mClickAction", "Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$LongClickBinding$ClickAction;", "setValues", "", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBindInfo;", "vmHolder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "setUndoRedoTooltipText", "view", "Landroid/view/View;", "unbind", "ClickAction", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class LongClickBinding extends AbsBinding<Object> {
            private final int TOOLTIP_TIME_SHOW = 200;

            @Nullable
            private ClickAction mClickAction;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$LongClickBinding$ClickAction;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsAction;", "type", "", "subType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
            public static final class ClickAction extends AbsAction {
                public ClickAction(@Nullable String str, @Nullable String str2) {
                    super(str, str2);
                }

                @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
                @Nullable
                public Object getData() {
                    return getMBindId();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean bind$lambda$0(LongClickBinding longClickBinding, View view) {
                IBaseViewModel viewModel = longClickBinding.getViewModel();
                if (viewModel != null) {
                    viewModel.perform(longClickBinding.mClickAction);
                }
                View view2 = longClickBinding.getView();
                Intrinsics.checkNotNull(view2);
                longClickBinding.setUndoRedoTooltipText(view2);
                ClickAction clickAction = longClickBinding.mClickAction;
                Object mResult = clickAction != null ? clickAction.getMResult() : null;
                Boolean bool = mResult instanceof Boolean ? (Boolean) mResult : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void setUndoRedoTooltipText$lambda$1(View view) {
                view.setTooltipText(null);
                view.setTooltipText(view.getContentDescription());
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void bind() {
                View view = getView();
                if (view != null) {
                    view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.addons.base.binding.binder.d
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view2) {
                            return BindingActionFactory.Companion.LongClickBinding.bind$lambda$0(this.f5705a, view2);
                        }
                    });
                }
            }

            public final void setUndoRedoTooltipText(@NotNull final View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (view.getVisibility() != 0) {
                    return;
                }
                view.setEnabled(true);
                new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.addons.base.binding.binder.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        BindingActionFactory.Companion.LongClickBinding.setUndoRedoTooltipText$lambda$1(view);
                    }
                }, this.TOOLTIP_TIME_SHOW);
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsBinding, com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void setValues(@NotNull IViewBindInfo bind, @Nullable IViewModelHolder vmHolder) {
                Intrinsics.checkNotNullParameter(bind, "bind");
                super.setValues(bind, vmHolder);
                this.mClickAction = new ClickAction("action_long_click", bind.getMBindingId());
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void unbind() {
                View view = getView();
                if (view != null) {
                    view.setOnLongClickListener(null);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$ProgressBarBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBinding;", "", "<init>", "()V", "mProgressAction", "Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$ProgressBarBinding$ProgressAction;", "setValues", "", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBindInfo;", "vmHolder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "unbind", "ProgressAction", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ProgressBarBinding extends AbsBinding<Object> {

            @Nullable
            private ProgressAction mProgressAction;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$ProgressBarBinding$ProgressAction;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsAction;", "type", "", "subType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "mProgressData", "", "getMProgressData", "()I", "setMProgressData", "(I)V", "getData", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
            public static final class ProgressAction extends AbsAction {
                private int mProgressData;

                public ProgressAction(@Nullable String str, @Nullable String str2) {
                    super(str, str2);
                }

                @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
                @NotNull
                public Object getData() {
                    return Integer.valueOf(this.mProgressData);
                }

                public final int getMProgressData() {
                    return this.mProgressData;
                }

                public final void setMProgressData(int i) {
                    this.mProgressData = i;
                }
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void bind() {
                View view = getView();
                if (view instanceof SeekBar) {
                    ((SeekBar) view).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.support.senl.addons.base.binding.binder.BindingActionFactory$Companion$ProgressBarBinding$bind$1
                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                            BindingActionFactory.Companion.ProgressBarBinding.ProgressAction progressAction = this.this$0.mProgressAction;
                            Intrinsics.checkNotNull(progressAction);
                            progressAction.setMProgressData(progress);
                            IBaseViewModel viewModel = this.this$0.getViewModel();
                            if (viewModel != null) {
                                viewModel.perform(this.this$0.mProgressAction);
                            }
                        }

                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onStartTrackingTouch(SeekBar seekBar) {
                            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                        }

                        @Override // android.widget.SeekBar.OnSeekBarChangeListener
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                        }
                    });
                }
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsBinding, com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void setValues(@NotNull IViewBindInfo bind, @Nullable IViewModelHolder vmHolder) {
                Intrinsics.checkNotNullParameter(bind, "bind");
                super.setValues(bind, vmHolder);
                this.mProgressAction = new ProgressAction("action_onProgress", bind.getMBindingId());
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void unbind() {
                View view = getView();
                if (view instanceof SeekBar) {
                    ((SeekBar) view).setOnSeekBarChangeListener(null);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\t\u001a\u00020\bH\u0017J\b\u0010\r\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$TouchBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBinding;", "", "<init>", "()V", "mAction", "Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$TouchBinding$TouchAction;", "setValues", "", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBindInfo;", "vmHolder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "unbind", "TouchAction", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class TouchBinding extends AbsBinding<Object> {

            @Nullable
            private TouchAction mAction;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingActionFactory$Companion$TouchBinding$TouchAction;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsAction;", "type", "", "bindId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "mTouchEvent", "Lcom/samsung/android/support/senl/addons/base/model/event/TouchEvent;", "getData", "", "setTouchEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "release", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
            public static final class TouchAction extends AbsAction {

                @NotNull
                private final TouchEvent mTouchEvent;

                public TouchAction(@Nullable String str, @Nullable String str2) {
                    super(str, str2);
                    this.mTouchEvent = new TouchEvent();
                }

                @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel.Action
                @NotNull
                public Object getData() {
                    return this.mTouchEvent;
                }

                public final void release() {
                    this.mTouchEvent.release();
                }

                public final void setTouchEvent(@Nullable View view, @Nullable MotionEvent event) {
                    if (view == null || event == null) {
                        return;
                    }
                    this.mTouchEvent.setView(view);
                    this.mTouchEvent.setEvent(event);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean bind$lambda$0(TouchBinding touchBinding, View view, MotionEvent motionEvent) {
                TouchAction touchAction = touchBinding.mAction;
                if (touchAction != null) {
                    touchAction.setTouchEvent(view, motionEvent);
                }
                IBaseViewModel viewModel = touchBinding.getViewModel();
                if (viewModel != null) {
                    viewModel.perform(touchBinding.mAction);
                }
                TouchAction touchAction2 = touchBinding.mAction;
                Object mResult = touchAction2 != null ? touchAction2.getMResult() : null;
                TouchAction touchAction3 = touchBinding.mAction;
                if (touchAction3 != null) {
                    touchAction3.release();
                }
                Boolean bool = mResult instanceof Boolean ? (Boolean) mResult : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            @SuppressLint({"ClickableViewAccessibility"})
            public void bind() {
                View view = getView();
                if (view != null) {
                    view.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.addons.base.binding.binder.e
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view2, MotionEvent motionEvent) {
                            return BindingActionFactory.Companion.TouchBinding.bind$lambda$0(this.f5706a, view2, motionEvent);
                        }
                    });
                }
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsBinding, com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void setValues(@NotNull IViewBindInfo bind, @Nullable IViewModelHolder vmHolder) {
                Intrinsics.checkNotNullParameter(bind, "bind");
                super.setValues(bind, vmHolder);
                this.mAction = new TouchAction("action_touch", bind.getMBindingId());
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.binder.IBinding
            public void unbind() {
                View view = getView();
                if (view != null) {
                    view.setOnTouchListener(null);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final IBinding createBinding(@NotNull IViewBind bind, @Nullable IViewModelHolder holder) {
            IBinding emptyBinding;
            Intrinsics.checkNotNullParameter(bind, "bind");
            String mPropertyId = bind.getMPropertyId();
            if (mPropertyId != null) {
                switch (mPropertyId.hashCode()) {
                    case -1969496363:
                        emptyBinding = !mPropertyId.equals("action_onProgress") ? new IBinding.EmptyBinding() : new ProgressBarBinding();
                        break;
                    case -565598493:
                        if (mPropertyId.equals("action_layoutChange")) {
                            emptyBinding = new LayoutChangeBinding();
                            break;
                        }
                        break;
                    case 217717678:
                        if (mPropertyId.equals("action_long_click")) {
                            emptyBinding = new LongClickBinding();
                            break;
                        }
                        break;
                    case 1835771455:
                        if (mPropertyId.equals("action_click")) {
                            emptyBinding = new ClickBinding();
                            break;
                        }
                        break;
                    case 1851572214:
                        if (mPropertyId.equals("action_touch")) {
                            emptyBinding = new TouchBinding();
                            break;
                        }
                        break;
                }
            }
            emptyBinding.setValues(bind, holder);
            return emptyBinding;
        }

        private Companion() {
        }
    }
}
