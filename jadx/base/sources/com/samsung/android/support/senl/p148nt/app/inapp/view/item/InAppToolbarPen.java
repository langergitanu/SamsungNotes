package com.samsung.android.support.senl.p148nt.app.inapp.view.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarPen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarPen;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarPen;", "view", "Landroid/view/View;", "mInAppToolbarItemManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;)V", "mInAppSettingViewManager", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingViewManager;", "onClick", "", "setSelected", "", "selected", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppToolbarPen extends HwToolbarPen {

    @Nullable
    private final InAppSettingViewManager mInAppSettingViewManager;

    @NotNull
    private HwToolbarItemContract mInAppToolbarItemManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppToolbarPen(@Nullable View view, @NotNull HwToolbarItemContract mInAppToolbarItemManager) {
        super(view, mInAppToolbarItemManager);
        Intrinsics.checkNotNullParameter(mInAppToolbarItemManager, "mInAppToolbarItemManager");
        this.mInAppToolbarItemManager = mInAppToolbarItemManager;
        this.mInAppSettingViewManager = (InAppSettingViewManager) mInAppToolbarItemManager.getMInAppSettingViewManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarPen, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        InAppSettingViewManager inAppSettingViewManager = this.mInAppSettingViewManager;
        if (inAppSettingViewManager != null && !inAppSettingViewManager.isShownSettingViews(4)) {
            this.mInAppSettingViewManager.show(getViewId(), 4);
        }
        this.mInAppToolbarItemManager.onSelected(getViewId());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarPen, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean selected) {
        InAppSettingViewManager inAppSettingViewManager;
        if (!super.setSelected(selected)) {
            return false;
        }
        if (selected && (inAppSettingViewManager = this.mInAppSettingViewManager) != null && !inAppSettingViewManager.isShownSettingViews(4) && !this.mInAppSettingViewManager.isShownSettingViews(1)) {
            this.mInAppSettingViewManager.show(getViewId(), 4);
        }
        return true;
    }
}
