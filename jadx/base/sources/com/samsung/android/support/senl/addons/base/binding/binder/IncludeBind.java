package com.samsung.android.support.senl.addons.base.binding.binder;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/IncludeBind;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/ViewStubBind;", "includeId", "", "mSubBinds", "", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "mInfos", "<init>", "(ILjava/util/List;Ljava/util/List;)V", "getMSubBinds", "()Ljava/util/List;", "setMSubBinds", "(Ljava/util/List;)V", "getMInfos", "setMInfos", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class IncludeBind extends ViewStubBind {

    @NotNull
    private List<IViewBind> mInfos;

    @NotNull
    private List<IViewBind> mSubBinds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncludeBind(int i, @NotNull List<IViewBind> mSubBinds, @NotNull List<IViewBind> mInfos) {
        super(i, mSubBinds.size());
        Intrinsics.checkNotNullParameter(mSubBinds, "mSubBinds");
        Intrinsics.checkNotNullParameter(mInfos, "mInfos");
        this.mSubBinds = mSubBinds;
        this.mInfos = mInfos;
    }

    @NotNull
    public final List<IViewBind> getMInfos() {
        return this.mInfos;
    }

    @NotNull
    public final List<IViewBind> getMSubBinds() {
        return this.mSubBinds;
    }

    public final void setMInfos(@NotNull List<IViewBind> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mInfos = list;
    }

    public final void setMSubBinds(@NotNull List<IViewBind> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mSubBinds = list;
    }
}
