package com.samsung.android.support.senl.addons.base.binding.binder;

import android.view.View;
import com.samsung.android.support.senl.addons.base.binding.binder.IBinding;
import com.samsung.android.support.senl.addons.base.binding.methods.BMCanvasContainer;
import com.samsung.android.support.senl.addons.base.binding.methods.BMCommonSettingView;
import com.samsung.android.support.senl.addons.base.binding.methods.BMTransparency;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ICommonSettingView;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IVMCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingMethodsFactory;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IVMCommand;", "<init>", "()V", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BindingMethodsFactory implements IVMCommand {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingMethodsFactory$Companion;", "", "<init>", "()V", "createBinding", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "holder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "InflatedBinding", "TransparencyBinding", "SettingPopupListenerBinding", "SettingPopupDataStoreBinding", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingMethodsFactory$Companion$InflatedBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer$OnInflateCallback;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class InflatedBinding extends AbsExecuteBinding<ICanvasContainer.OnInflateCallback> {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable ICanvasContainer.OnInflateCallback data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (view instanceof BMCanvasContainer) {
                    ((BMCanvasContainer) view).setOnInflateCallback(data);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingMethodsFactory$Companion$SettingPopupDataStoreBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class SettingPopupDataStoreBinding extends AbsBooleanExecuteBinding {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (!(view instanceof BMCommonSettingView) || data == null) {
                    return;
                }
                ((BMCommonSettingView) view).storeData(data.booleanValue());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingMethodsFactory$Companion$SettingPopupListenerBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ICommonSettingView$ISettingPopupListener;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class SettingPopupListenerBinding extends AbsExecuteBinding<ICommonSettingView.ISettingPopupListener> {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable ICommonSettingView.ISettingPopupListener data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (view instanceof BMCommonSettingView) {
                    ((BMCommonSettingView) view).setSettingPopupListener(data);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingMethodsFactory$Companion$TransparencyBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsBooleanExecuteBinding;", "<init>", "()V", "execute", "", "view", "Landroid/view/View;", "data", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class TransparencyBinding extends AbsBooleanExecuteBinding {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
            public void execute(@NotNull View view, @Nullable Boolean data) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (!(view instanceof BMTransparency) || data == null) {
                    return;
                }
                ((BMTransparency) view).setTransparency(data.booleanValue());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
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
                    case -1977764608:
                        emptyBinding = !mPropertyId.equals("md_transparency") ? new IBinding.EmptyBinding() : new TransparencyBinding();
                        break;
                    case -504599323:
                        if (mPropertyId.equals("md_inflated")) {
                            emptyBinding = new InflatedBinding();
                            break;
                        }
                        break;
                    case 1277479609:
                        if (mPropertyId.equals("md_pupupDataStore")) {
                            emptyBinding = new SettingPopupDataStoreBinding();
                            break;
                        }
                        break;
                    case 2098483896:
                        if (mPropertyId.equals("md_settingPopupListener")) {
                            emptyBinding = new SettingPopupListenerBinding();
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
