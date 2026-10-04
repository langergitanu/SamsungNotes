package com.samsung.android.support.senl.p148nt.app.inapp.view.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingViewManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarQuickSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarQuickSize;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarQuickSize;", "view", "Landroid/view/View;", "mInAppToolbarItemManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;)V", SearchConstants.TargetContents.TAG, "", "mInAppSettingViewManager", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingViewManager;", "onClick", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppToolbarQuickSize extends HwToolbarQuickSize {

    @NotNull
    private final String TAG;

    @NotNull
    private final InAppSettingViewManager mInAppSettingViewManager;

    @NotNull
    private final HwToolbarItemContract mInAppToolbarItemManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppToolbarQuickSize(@Nullable View view, @NotNull HwToolbarItemContract mInAppToolbarItemManager) {
        super(view, mInAppToolbarItemManager);
        Intrinsics.checkNotNullParameter(mInAppToolbarItemManager, "mInAppToolbarItemManager");
        this.mInAppToolbarItemManager = mInAppToolbarItemManager;
        this.TAG = "InAppToolbarQuickSize";
        HwSettingViewManager mInAppSettingViewManager = mInAppToolbarItemManager.getMInAppSettingViewManager();
        Intrinsics.checkNotNull(mInAppSettingViewManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingViewManager");
        this.mInAppSettingViewManager = (InAppSettingViewManager) mInAppSettingViewManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarQuickSize, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        String strValueOf;
        Logger.m10999d(this.TAG, "onClick# ");
        if (this.mView.isSelected()) {
            if (this.mInAppSettingViewManager.isShownSettingViews(1024)) {
                this.mInAppSettingViewManager.hide();
            } else {
                this.mInAppSettingViewManager.show(getViewId(), 1024, this.mView);
            }
            strValueOf = String.valueOf(this.mInAppSettingViewManager.getSettingInfoManager().getQuickSizeData().getSize(HwToolbarConstants.QUICK_SIZE.getOrdinal(getViewId())));
        } else {
            if (!this.mInAppToolbarItemManager.isSelected(2) && !this.mInAppToolbarItemManager.isSelected(2048)) {
                this.mInAppToolbarItemManager.onSelected(2);
            }
            this.mInAppSettingViewManager.hide();
            this.mInAppToolbarItemManager.onSelected(getViewId());
            this.mInAppSettingViewManager.updateToolbarSelectionState();
            strValueOf = "1";
        }
        if (ResourceUtils.isTabletLayout(this.mView.getContext())) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_QUICK_SIZE, strValueOf);
        } else {
            ComposerSA.insertLog("401", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_QUICK_SIZE, strValueOf);
        }
    }
}
