package com.samsung.android.support.senl.addons.base.binding.binder;

import com.samsung.android.support.senl.addons.base.binding.binder.IBinding;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IVMCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingFactory;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IVMCommand;", "<init>", "()V", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BindingFactory implements IVMCommand {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingFactory$Companion;", "", "<init>", "()V", "createBinding", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "holder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IBinding createBinding(@NotNull IViewBind bind, @Nullable IViewModelHolder holder) {
            Intrinsics.checkNotNullParameter(bind, "bind");
            String mPropertyId = bind.getMPropertyId();
            boolean mIsPendingExecutable = bind.getMIsPendingExecutable();
            IBinding iBindingCreateBinding = (mPropertyId == null || !StringsKt.m14145S(mPropertyId, "action_")) ? (mPropertyId == null || !StringsKt.m14145S(mPropertyId, "ad_")) ? (mPropertyId == null || !StringsKt.m14145S(mPropertyId, "pr_")) ? (mPropertyId == null || !StringsKt.m14145S(mPropertyId, "md_")) ? null : BindingMethodsFactory.INSTANCE.createBinding(bind, holder) : BindingPropertyFactory.INSTANCE.createBinding(bind, holder) : BindingAdapterFactory.INSTANCE.createBinding(bind, holder) : BindingActionFactory.INSTANCE.createBinding(bind, holder);
            if (iBindingCreateBinding == null) {
                return new IBinding.EmptyBinding();
            }
            if (mIsPendingExecutable) {
                iBindingCreateBinding.setExecuteType(1);
            }
            return iBindingCreateBinding;
        }

        private Companion() {
        }
    }
}
