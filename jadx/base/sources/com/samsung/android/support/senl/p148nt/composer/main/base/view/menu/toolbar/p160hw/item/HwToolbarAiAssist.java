package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarAiAssist extends HwToolbarItem {
    public HwToolbarAiAssist(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void clearControl() {
        this.mHwToolbarItemManager.clearContextMenu();
        this.mHwSettingViewManager.hide();
        this.mWritingToolManager.clearControl();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean hasInputSkipper() {
        return true;
    }

    public void introAnimation() {
        int i;
        View view = this.mView;
        if (view == null || view.getVisibility() != 0 || !this.mIsActive || (i = SharedPreferencesCompat.getInstance("Composer").getInt(SharedPreferencesConstants.COMPOSER_KEY_AI_HW_TOOLBAR_BUTTON_ANIMATION, 0)) >= 3) {
            return;
        }
        View viewFindViewById = this.mView.findViewById(C9086R.id.toolbar_ai_menu_img);
        if (viewFindViewById instanceof LottieAnimationView) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) viewFindViewById;
            if (ContextUtils.isNightMode(this.mView.getContext())) {
                lottieAnimationView.setAnimation("note_assist_icon_dark.json");
            } else {
                lottieAnimationView.setAnimation("note_assist_icon_light.json");
            }
            lottieAnimationView.playAnimation();
            SharedPreferencesCompat.getInstance("Composer").putInt(SharedPreferencesConstants.COMPOSER_KEY_AI_HW_TOOLBAR_BUTTON_ANIMATION, i + 1);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        if (this.mHwToolbarItemManager.isSelected(262144)) {
            this.mHwToolbarItemManager.onSelected(2);
        }
        this.mHwSettingViewManager.hide();
        this.mHwToolbarItemManager.onSelected(getViewId(), false);
        this.mHwToolbarItemManager.getSettingInstance().showAiAssistMenu(this.mView);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        return true;
    }
}
