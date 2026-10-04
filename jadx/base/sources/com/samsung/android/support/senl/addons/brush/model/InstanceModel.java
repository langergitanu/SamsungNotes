package com.samsung.android.support.senl.addons.brush.model;

import com.samsung.android.support.senl.addons.base.model.IDataHandler;
import com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasScreenModel;
import com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0014J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/InstanceModel;", "Lcom/samsung/android/support/senl/addons/base/model/instance/AbsInstanceModel;", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasScreenModel;", "handler", "Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;)V", "mStatusHeight", "", "mMenuSize", "Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;", "setMenuSizeInjector", "", "injector", "getMenuSizeInjector", "setStatusHeight", "y", "getStatusBarHeight", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class InstanceModel extends AbsInstanceModel implements IBrushCanvasScreenModel {

    @Nullable
    private IMenuSizeInjector mMenuSize;
    private int mStatusHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstanceModel(@Nullable IDataHandler iDataHandler) {
        super(iDataHandler);
        Intrinsics.checkNotNull(iDataHandler);
    }

    @Nullable
    /* JADX INFO: renamed from: getMenuSizeInjector, reason: from getter */
    public IMenuSizeInjector getMMenuSize() {
        return this.mMenuSize;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasScreenModel
    /* JADX INFO: renamed from: getStatusBarHeight, reason: from getter */
    public int getMStatusHeight() {
        return this.mStatusHeight;
    }

    public void setMenuSizeInjector(@NotNull IMenuSizeInjector injector) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        this.mMenuSize = injector;
    }

    public final void setStatusHeight(int y2) {
        this.mStatusHeight = y2;
    }
}
