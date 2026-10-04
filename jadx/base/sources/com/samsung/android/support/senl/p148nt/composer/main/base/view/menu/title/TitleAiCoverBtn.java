package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AbsAiCoverMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleAiCoverBtn extends AbsAiCoverMenu {
    private static final String TAG = Logger.createTag("TitleAiCoverBtn");

    public TitleAiCoverBtn(View view, AiCoverMenuViewPresenter aiCoverMenuViewPresenter) {
        this.mView = view.findViewById(C9086R.id.ai_menu_cover_image_btn);
        ViewCompat.getInstance().setTooltipText(this.mView);
        this.mView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleAiCoverBtn.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(@NonNull View view2, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                if (Build.VERSION.SDK_INT >= 28) {
                    accessibilityNodeInfo.setTooltipText("");
                }
                accessibilityNodeInfo.setContentDescription(((Object) accessibilityNodeInfo.getContentDescription()) + SQLKeyword.COMMA + view2.getResources().getString(C9086R.string.button_string_button));
            }
        });
        setPresenter(aiCoverMenuViewPresenter);
    }

    private void setNoDataState() {
        Logger.m10999d(TAG, "setNoDataState#");
        this.mIconView.setImageResource(C9086R.drawable.ic_ai_menu_cover_manual);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AbsAiCoverMenu
    public void applyCurrentState() {
        Logger.m10999d(getTag(), "applyCurrentState# isEnabled : " + this.mPresenter.isCoverEnabled() + ", isApplied : " + this.mPresenter.isApplied());
        if (this.mPresenter.isApplied() && this.mPresenter.isCoverEnabled()) {
            setDisable();
        } else {
            setNoDataState();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AbsAiCoverMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AbsAiCoverMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverContract.IView
    public void hide() {
        Logger.m10999d(getTag(), "hide");
        applyCurrentState();
    }

    public void init() {
        initView(this.mView);
        initChildren(this.mView);
    }

    public void initShowStateOnTitle() {
        applyCurrentState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AbsAiCoverMenu
    public void onClickButton() {
        this.mPresenter.onClickButton();
    }

    public void setCoverAIIconColor(boolean z) {
        int color = z ? this.mView.getContext().getResources().getColor(C9086R.color.ai_menu_icon_color_dark, null) : this.mView.getContext().getResources().getColor(C9086R.color.ai_menu_icon_color, null);
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            imageView.setColorFilter(color);
        }
    }

    public void setDisable() {
        Logger.m11003i(TAG, "setDisable#");
        this.mView.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AbsAiCoverMenu
    public void setPresenter(AiCoverMenuViewPresenter aiCoverMenuViewPresenter) {
        super.setPresenter(aiCoverMenuViewPresenter);
        aiCoverMenuViewPresenter.setViewOnTitle(this);
    }
}
