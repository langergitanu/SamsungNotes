package com.samsung.android.support.senl.p148nt.app.inapp.view.item;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.inapp.presenter.item.InAppToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingTextModeLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarTextMode;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarTextMode;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarTextMode;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "view", "Landroid/view/View;", "rootView", "mInAppToolbarItemManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;", "<init>", "(Landroid/app/Activity;Landroid/view/View;Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;)V", "mTextModeSettingView", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout;", "mFloaterContainer", "hidePopup", "", "onClick", "setSelected", "", "selected", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppToolbarTextMode extends HwToolbarTextMode {

    @NotNull
    private final View mFloaterContainer;

    @NotNull
    private final HwToolbarItemContract mInAppToolbarItemManager;

    @NotNull
    private final InAppSettingTextModeLayout mTextModeSettingView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppToolbarTextMode(@NotNull Activity activity, @NotNull View view, @NotNull View rootView, @NotNull HwToolbarItemContract mInAppToolbarItemManager) {
        super(view, mInAppToolbarItemManager);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(mInAppToolbarItemManager, "mInAppToolbarItemManager");
        this.mInAppToolbarItemManager = mInAppToolbarItemManager;
        HwToolbarPresenterImpl hwToolbarPresenter = mInAppToolbarItemManager.getHwToolbarPresenter();
        Intrinsics.checkNotNull(hwToolbarPresenter, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.presenter.item.InAppToolbarPresenter");
        this.mTextModeSettingView = new InAppSettingTextModeLayout(activity, rootView, (InAppToolbarPresenter) hwToolbarPresenter);
        View viewFindViewById = rootView.findViewById(C8003R.id.floating_layout_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mFloaterContainer = viewFindViewById;
    }

    public final void hidePopup() {
        this.mTextModeSettingView.hidePopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarTextMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        functionEnable(true);
        if (this.mView.isSelected()) {
            return;
        }
        this.mInAppToolbarItemManager.hide();
        this.mInAppToolbarItemManager.clearAllToolbarItem(4096);
        this.mInAppToolbarItemManager.onSelected(getViewId());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarTextMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean selected) {
        this.mTextModeSettingView.setVisibility(selected ? 0 : 8);
        this.mFloaterContainer.setVisibility(selected ? 4 : 0);
        if (selected == this.mView.isSelected()) {
            return false;
        }
        this.mView.setSelected(selected);
        this.mInAppToolbarItemManager.updateStateSelected(getViewId(), selected);
        return true;
    }
}
