package com.samsung.android.support.senl.addons.base.viewmodel.common;

import com.samsung.android.support.senl.addons.base.common.AbsObservable;
import com.samsung.android.support.senl.addons.base.common.IObservable;
import com.samsung.android.support.senl.addons.base.utils.InstanceCloseDebugger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.sec.spp.push.Config;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0019B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH$J\b\u0010\t\u001a\u00020\bH$J\b\u0010\n\u001a\u00020\bH$J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\f\u0010\u0013\u001a\u00060\u0014R\u00020\u0000H\u0016J\u0016\u0010\u0013\u001a\u00060\u0014R\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0013\u001a\u00060\u0014R\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "Lcom/samsung/android/support/senl/addons/base/common/AbsObservable;", "", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Observer;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "<init>", "()V", "closeSubViewModels", "", "closeCallbacks", "clearModels", "mDebugger", "Lcom/samsung/android/support/senl/addons/base/utils/InstanceCloseDebugger;", "perform", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "getData", "", "id", "createInfo", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel$Info;", "type", "data", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;", "close", "Info", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBaseViewModel extends AbsObservable<String, IBaseViewModel.Observer> implements IBaseViewModel {

    @Nullable
    private InstanceCloseDebugger mDebugger;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u00020\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\b\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel$Info;", "Lcom/samsung/android/support/senl/addons/base/common/AbsObservable$Info;", "", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Observer;", "Lcom/samsung/android/support/senl/addons/base/common/AbsObservable;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Info;", Config.NOTIFICATION_INTENT_SENDER, "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;)V", "type", "(Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;Ljava/lang/String;)V", "data", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;", "(Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class Info extends AbsObservable<String, IBaseViewModel.Observer>.Info<String, IBaseViewModel.Observer> implements IBaseViewModel.Info {
        final /* synthetic */ AbsBaseViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Info(@NotNull AbsBaseViewModel absBaseViewModel, AbsBaseViewModel sender) {
            super(sender);
            Intrinsics.checkNotNullParameter(sender, "sender");
            this.this$0 = absBaseViewModel;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Info(@NotNull AbsBaseViewModel absBaseViewModel, @Nullable AbsBaseViewModel sender, String str) {
            super(sender, str, null);
            Intrinsics.checkNotNullParameter(sender, "sender");
            this.this$0 = absBaseViewModel;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Info(@NotNull AbsBaseViewModel absBaseViewModel, @NotNull AbsBaseViewModel sender, IObservable.InfoData<String> data) {
            super(sender, null, data);
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(data, "data");
            this.this$0 = absBaseViewModel;
        }
    }

    public AbsBaseViewModel() {
        if (InstanceCloseDebugger.INSTANCE.canRun()) {
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            this.mDebugger = new InstanceCloseDebugger("AbsBaseViewModel", name);
        }
    }

    public abstract void clearModels();

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void close() {
        closeSubViewModels();
        clearModels();
        closeCallbacks();
        InstanceCloseDebugger instanceCloseDebugger = this.mDebugger;
        if (instanceCloseDebugger != null) {
            Intrinsics.checkNotNull(instanceCloseDebugger);
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            instanceCloseDebugger.close(name);
            this.mDebugger = null;
        }
    }

    public abstract void closeCallbacks();

    public abstract void closeSubViewModels();

    @Nullable
    public Object getData(@Nullable String id) {
        return null;
    }

    public void perform(@Nullable IBaseViewModel.Action action) {
    }

    @Override // com.samsung.android.support.senl.addons.base.common.AbsObservable
    @NotNull
    public Info createInfo() {
        return new Info(this, this);
    }

    @Override // com.samsung.android.support.senl.addons.base.common.AbsObservable
    @NotNull
    public Info createInfo(@Nullable String type) {
        return new Info(this, this, type);
    }

    @Override // com.samsung.android.support.senl.addons.base.common.AbsObservable
    @NotNull
    public Info createInfo(@NotNull IObservable.InfoData<String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new Info(this, this, data);
    }
}
