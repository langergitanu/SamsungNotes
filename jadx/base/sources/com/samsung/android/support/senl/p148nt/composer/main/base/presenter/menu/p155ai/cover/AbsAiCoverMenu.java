package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover;

import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsAiCoverMenu implements AiCoverContract.IView {
    protected ImageView mIconView;
    protected AiCoverMenuViewPresenter mPresenter;
    protected View mView;

    public abstract void applyCurrentState();

    public abstract String getTag();

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverContract.IView
    public void hide() {
        Logger.m10999d(getTag(), "hide");
        setVisibility(8);
    }

    public void initChildren(View view) {
        this.mIconView = (ImageView) view.findViewById(C9086R.id.ai_menu_cover_image_view);
    }

    public void initView(View view) {
        this.mView = view;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AbsAiCoverMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Logger.m10999d(AbsAiCoverMenu.this.getTag(), "onClick# create cover");
                AbsAiCoverMenu.this.onClickButton();
            }
        });
    }

    public void onClickButton() {
        AiCommonUtil.executeActionByServer(this.mPresenter.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AbsAiCoverMenu.2
            @Override // java.lang.Runnable
            public void run() {
                AbsAiCoverMenu.this.mPresenter.onClickButton();
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverContract.IView
    public void onFailed(String str) {
        if (AiCoverDataCreator.USER_CANCEL.equals(str)) {
            show();
        } else {
            hide();
        }
    }

    public void setPresenter(AiCoverMenuViewPresenter aiCoverMenuViewPresenter) {
        this.mPresenter = aiCoverMenuViewPresenter;
    }

    public void setVisibility(int i) {
        if (!this.mPresenter.isCoverMenuEnabled(false)) {
            this.mView.setVisibility(8);
            return;
        }
        if (i == this.mView.getVisibility()) {
            return;
        }
        if (i == 0 && this.mPresenter.isCoverEnabled() && this.mPresenter.hasCover()) {
            return;
        }
        AbstractC0000a.m3D(i, "setVisibility# visibility : ", getTag());
        this.mView.setVisibility(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverContract.IView
    public void show() {
        Logger.m10999d(getTag(), "show#");
        applyCurrentState();
        setVisibility(0);
    }
}
