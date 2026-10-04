package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view.AiMenuPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.AnchorPosition;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuView {
    private static final String TAG = Logger.createTag("AiView");
    private AiMenuPopup mAiContextMenuPopup;
    private AiSelectionView mAiSelectionView;
    private ComposerViewPresenter mComposerViewPresenter;

    public AiMenuView(ComposerViewPresenter composerViewPresenter, AiContextMenuPresenter aiContextMenuPresenter, AiMenuPopup.ViewContract viewContract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mAiSelectionView = new AiSelectionView(composerViewPresenter, aiContextMenuPresenter);
        this.mAiContextMenuPopup = new AiMenuPopup(composerViewPresenter, aiContextMenuPresenter, viewContract);
    }

    public boolean canShowAiContextMenu() {
        return this.mAiContextMenuPopup.canShowAiContextMenu();
    }

    public AiMenuPopup getAiContextMenuPopup() {
        return this.mAiContextMenuPopup;
    }

    public void onAttachView() {
        this.mAiSelectionView.onAttachView();
    }

    public void release() {
        AiMenuPopup aiMenuPopup = this.mAiContextMenuPopup;
        if (aiMenuPopup != null) {
            aiMenuPopup.hide();
        }
    }

    public void showAiPopupMenu(final View view, final AnchorPosition anchorPosition) {
        AiCommonUtil.executeActionByOndevice(this.mComposerViewPresenter.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiMenuView.1
            @Override // java.lang.Runnable
            public void run() {
                AiMenuView.this.mAiContextMenuPopup.show(view, anchorPosition);
            }
        }, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiMenuView.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.m11000e(AiMenuView.TAG, "show# canceled");
                AiMenuView.this.mAiContextMenuPopup.hide();
            }
        });
    }
}
