package com.samsung.android.support.senl.p148nt.app.inapp.view;

import android.app.Activity;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.app.inapp.view.item.InAppToolbarItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppHwToolbarMenu;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/HwToolbarMenu;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "decorView", "Landroid/view/ViewGroup;", "toolbarManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/common/IToolbarManager;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenterImpl;", "componentFactory", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarOrderManager$ComponentFactory;", "<init>", "(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/common/IToolbarManager;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenterImpl;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarOrderManager$ComponentFactory;)V", "hwToolbarItemManager", "Lcom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarItemManager;", "getHwToolbarItemManager", "()Lcom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarItemManager;", "createHwToolbarItemManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemManager;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppHwToolbarMenu extends HwToolbarMenu {

    @NotNull
    private final InAppToolbarItemManager hwToolbarItemManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppHwToolbarMenu(@Nullable Activity activity, @NotNull ViewGroup decorView, @NotNull IToolbarManager toolbarManager, @NotNull HwToolbarPresenterImpl presenter, @NotNull HwToolbarOrderManager.ComponentFactory componentFactory) {
        super(activity, decorView, toolbarManager, presenter, componentFactory);
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        Intrinsics.checkNotNullParameter(toolbarManager, "toolbarManager");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(componentFactory, "componentFactory");
        this.hwToolbarItemManager = new InAppToolbarItemManager(activity, decorView, presenter, this, componentFactory);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu
    @NotNull
    public HwToolbarItemManager createHwToolbarItemManager() {
        return this.hwToolbarItemManager;
    }

    @NotNull
    public final InAppToolbarItemManager getHwToolbarItemManager() {
        return this.hwToolbarItemManager;
    }
}
