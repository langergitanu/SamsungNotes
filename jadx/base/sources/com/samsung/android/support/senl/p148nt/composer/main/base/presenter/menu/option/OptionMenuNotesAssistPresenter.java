package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.os.Handler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuNotesAssistPresenter {
    private final AiMenuManager mAiMenuManager;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final MenuPresenterContract.IMenuManager mMenuManager;

    public OptionMenuNotesAssistPresenter(ComposerViewPresenter composerViewPresenter, MenuPresenterContract.IMenuManager iMenuManager, AiMenuManager aiMenuManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mMenuManager = iMenuManager;
        this.mAiMenuManager = aiMenuManager;
    }

    private String getScreenId() {
        return this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode() ? ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT : ComposerSAConstants.SCREEN_PDF_VIEWER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$translate$0() {
        this.mMenuManager.onShowMenu(MenuPresenterContract.CMenu.AI_MENU_FOR_PDF_VIEWER_OVERLAY);
    }

    public Handler getHandler() {
        return this.mComposerViewPresenter.getHandler();
    }

    public void hideAiResultView() {
        this.mAiMenuManager.hideResultView(true);
    }

    public void setAiSALogForPdfReader() {
        this.mAiMenuManager.setAiSALogForPdfReader();
    }

    public void summarize() {
        String screenId = getScreenId();
        ComposerSA.insertLog(screenId, ComposerSAConstants.EVENT_PDF_VIEWER_AI_SUMMARIZE);
        ComposerSA.insertLog(screenId, ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "i");
        this.mMenuManager.hideBottomMenu();
        this.mMenuManager.onShowMenu(MenuPresenterContract.CMenu.AI_MENU_FOR_PDF_VIEWER);
    }

    public void translate() {
        String screenId = getScreenId();
        ComposerSA.insertLog(screenId, ComposerSAConstants.EVENT_PDF_VIEWER_AI_TRANSLATE);
        ComposerSA.insertLog(screenId, ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "j");
        this.mMenuManager.hideBottomMenu();
        AiCommonUtil.executeActionByOndevice(this.mComposerViewPresenter.getActivity(), new RunnableC9845d(this, 2));
    }
}
