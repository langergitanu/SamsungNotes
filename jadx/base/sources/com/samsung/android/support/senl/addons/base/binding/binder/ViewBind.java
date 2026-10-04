package com.samsung.android.support.senl.addons.base.binding.binder;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/ViewBind;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "mPropertyId", "", "mViewId", "", "mViewKey", "mViewModelId", "mBindingId", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "mIsPendingExecutable", "", "getViewId", "getViewKey", "getPropertyId", "isPendingExecutable", "getViewModelId", "getBindingId", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ViewBind implements IViewBind {

    @Nullable
    private final String mBindingId;
    private boolean mIsPendingExecutable;

    @NotNull
    private String mPropertyId;
    private final int mViewId;
    private final int mViewKey;

    @Nullable
    private final String mViewModelId;

    public ViewBind(@NotNull String mPropertyId, int i, int i2, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(mPropertyId, "mPropertyId");
        this.mPropertyId = mPropertyId;
        this.mViewId = i;
        this.mViewKey = i2;
        this.mViewModelId = str;
        this.mBindingId = str2;
        if (StringsKt.m14167w(mPropertyId, "_pending")) {
            this.mIsPendingExecutable = true;
            this.mPropertyId = StringsKt.m14139M(this.mPropertyId, "_pending", "");
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    @Nullable
    /* JADX INFO: renamed from: getBindingId, reason: from getter */
    public String getMBindingId() {
        return this.mBindingId;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBind
    @NotNull
    /* JADX INFO: renamed from: getPropertyId, reason: from getter */
    public String getMPropertyId() {
        return this.mPropertyId;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    /* JADX INFO: renamed from: getViewId, reason: from getter */
    public int getMViewId() {
        return this.mViewId;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    /* JADX INFO: renamed from: getViewKey, reason: from getter */
    public int getMViewKey() {
        return this.mViewKey;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    @Nullable
    /* JADX INFO: renamed from: getViewModelId, reason: from getter */
    public String getMViewModelId() {
        return this.mViewModelId;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    /* JADX INFO: renamed from: isPendingExecutable, reason: from getter */
    public boolean getMIsPendingExecutable() {
        return this.mIsPendingExecutable;
    }
}
