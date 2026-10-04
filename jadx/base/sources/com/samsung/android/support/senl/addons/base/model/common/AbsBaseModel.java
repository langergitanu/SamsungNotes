package com.samsung.android.support.senl.addons.base.model.common;

import com.samsung.android.support.senl.addons.base.common.AbsObservable;
import com.samsung.android.support.senl.addons.base.common.IObservable;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.sec.spp.push.Config;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\rB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00060\bR\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014J\u001b\u0010\u0007\u001a\u00060\bR\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\fJ\f\u0010\u0007\u001a\u00060\bR\u00020\u0000H\u0014¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/base/common/AbsObservable;", "", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "<init>", "()V", "createInfo", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel$Info;", "data", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;", "type", "(Ljava/lang/Integer;)Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel$Info;", "Info", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBaseModel extends AbsObservable<Integer, IBaseModel.Observer> implements IBaseModel {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0084\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u00020\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\b\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel$Info;", "Lcom/samsung/android/support/senl/addons/base/common/AbsObservable$Info;", "", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "Lcom/samsung/android/support/senl/addons/base/common/AbsObservable;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Info;", Config.NOTIFICATION_INTENT_SENDER, "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;)V", "type", "(Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;Ljava/lang/Integer;)V", "data", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;", "(Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class Info extends AbsObservable<Integer, IBaseModel.Observer>.Info<Integer, IBaseModel.Observer> implements IBaseModel.Info {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Info(@NotNull AbsBaseModel absBaseModel, AbsBaseModel sender) {
            super(sender);
            Intrinsics.checkNotNullParameter(sender, "sender");
            AbsBaseModel.this = absBaseModel;
        }

        public Info(@Nullable AbsBaseModel absBaseModel, @Nullable Integer num) {
            super(absBaseModel, num, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Info(@NotNull AbsBaseModel absBaseModel, @NotNull AbsBaseModel sender, IObservable.InfoData<Integer> data) {
            super(sender, null, data);
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(data, "data");
            AbsBaseModel.this = absBaseModel;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.common.AbsObservable
    @NotNull
    public Info createInfo(@NotNull IObservable.InfoData<Integer> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new Info(this, this, data);
    }

    @Override // com.samsung.android.support.senl.addons.base.common.AbsObservable
    @NotNull
    public Info createInfo(@Nullable Integer type) {
        return new Info(this, type);
    }

    @Override // com.samsung.android.support.senl.addons.base.common.AbsObservable
    @NotNull
    public Info createInfo() {
        return new Info(this, this);
    }
}
