package com.samsung.android.support.senl.addons.base.binding.binder;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/ViewStubBind;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "viewStubId", "", "size", "<init>", "(II)V", "mViewId", "mSize", "getViewId", "getPropertyId", "", "getSize", "getViewKey", "getViewModelId", "getBindingId", "isPendingExecutable", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ViewStubBind implements IViewBind {
    private final int mSize;
    private final int mViewId;

    public ViewStubBind(int i, int i2) {
        this.mViewId = i;
        this.mSize = i2;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    @Nullable
    public String getBindingId() {
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBind
    @Nullable
    public String getPropertyId() {
        return null;
    }

    /* JADX INFO: renamed from: getSize, reason: from getter */
    public int getMSize() {
        return this.mSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    /* JADX INFO: renamed from: getViewId, reason: from getter */
    public int getMViewId() {
        return this.mViewId;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    public int getViewKey() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    @Nullable
    public String getViewModelId() {
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewBindInfo
    public boolean isPendingExecutable() {
        return false;
    }
}
