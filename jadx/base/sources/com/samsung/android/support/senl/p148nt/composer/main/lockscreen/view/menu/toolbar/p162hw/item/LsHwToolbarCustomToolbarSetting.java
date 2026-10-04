package com.samsung.android.support.senl.p148nt.composer.main.lockscreen.view.menu.toolbar.p162hw.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarCustomToolbarSetting;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/view/menu/toolbar/hw/item/LsHwToolbarCustomToolbarSetting;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarCustomToolbarSetting;", "view", "Landroid/view/View;", "hwToolbarItemManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;)V", "onClick", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LsHwToolbarCustomToolbarSetting extends HwToolbarCustomToolbarSetting {
    public LsHwToolbarCustomToolbarSetting(@Nullable View view, @Nullable HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarCustomToolbarSetting, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        this.mHwToolbarItemManager.doActionAfterDismissKeyguard(new RunnableC0015b(this, 9));
    }
}
