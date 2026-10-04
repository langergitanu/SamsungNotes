package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item;

import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemPin;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItem;", "view", "Landroid/view/View;", "menuItemContract", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;)V", "onClick", "", "setVisibility", "visibility", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuItemPin extends MenuItem {

    @NotNull
    private static final String TAG = SOLogger.createTag("MenuItemPin");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuItemPin(@NotNull View view, @NotNull MenuItemContract menuItemContract) {
        super(view, menuItemContract, null, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(menuItemContract, "menuItemContract");
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mView);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItem
    public void onClick() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onClick#");
        SAManager.INSTANCE.getINSTANCE().onPinClicked();
        this.mMenuItemContract.onPin();
    }

    public final void setVisibility(int visibility) {
        AbstractC8014b.m7206h("setVisibility#, visibility : ", visibility, SOLogger.INSTANCE, TAG);
        this.mView.setVisibility(visibility);
    }
}
