package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuAi extends RtMenuItem {
    public RtMenuAi(View view) {
        super(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void hideAiMenu() {
        this.mPresenter.hideAiMenu((this.mPresenter.isAiMenuForTranslationAndTranslated() && this.mPresenter.canShowAiContextMenu()) ? false : true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        if (this.mPresenter.isShowingAiResultWorking()) {
            return;
        }
        if (this.mRtToolbarMenu.isDirectWriteUsing()) {
            this.mRtToolbarMenu.updateDirectWrite(false);
        }
        super.onClicked();
        this.mPresenter.showAiMenu(this.mView);
    }

    public void playAnimation() {
        int i = SharedPreferencesCompat.getInstance("Composer").getInt(SharedPreferencesConstants.COMPOSER_KEY_AI_RT_TOOLBAR_BUTTON_ANIMATION, 0);
        if (i >= 3) {
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
            SharedPreferencesCompat.getInstance("Composer").putInt(SharedPreferencesConstants.COMPOSER_KEY_AI_RT_TOOLBAR_BUTTON_ANIMATION, i + 1);
        }
    }
}
