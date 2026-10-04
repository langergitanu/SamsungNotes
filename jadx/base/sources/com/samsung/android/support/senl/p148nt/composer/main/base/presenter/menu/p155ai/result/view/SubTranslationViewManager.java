package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SubTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewTranslation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SubTranslationViewManager {
    View mAiRootView;
    AiMenuResultCommonViews mCommonViews;
    Contract mContract;
    AiMenuContract.SubTransition.IParentAction mParentAction;
    ViewGroup mParentView;
    View mResultView;
    AiMenuResultViewSubTranslation mSubTranslationView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        Activity getActivity();
    }

    public SubTranslationViewManager(View view, ViewGroup viewGroup, View view2, AiMenuContract.SubTransition.IParentAction iParentAction, AiMenuResultCommonViews aiMenuResultCommonViews, Contract contract) {
        this.mAiRootView = view;
        this.mParentView = viewGroup;
        this.mResultView = view2;
        this.mParentAction = iParentAction;
        this.mCommonViews = aiMenuResultCommonViews;
        this.mContract = contract;
    }

    private void initSubTranslation(SubTranslation subTranslation) {
        AiMenuResultViewSubTranslation aiMenuResultViewSubTranslation = new AiMenuResultViewSubTranslation(subTranslation, this.mCommonViews, new AiMenuResultViewTranslation.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SubTranslationViewManager.1
            private void updateBottomMenu() {
                SubTranslationViewManager subTranslationViewManager = SubTranslationViewManager.this;
                subTranslationViewManager.mCommonViews.setBottomButtonsState(subTranslationViewManager.mSubTranslationView.isAvailableBottomMenu());
                SubTranslationViewManager.this.mCommonViews.getBottomView().show(true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public Activity getActivity() {
                return SubTranslationViewManager.this.mContract.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.Contract
            public void hide() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.Contract
            public boolean isSummaryTranslations() {
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.Contract
            public boolean updateEditedRecognizedHw() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateResultState(boolean z, boolean z2) {
                if (z2) {
                    updateBottomMenu();
                }
            }
        });
        this.mSubTranslationView = aiMenuResultViewSubTranslation;
        View viewInflateView = aiMenuResultViewSubTranslation.inflateView(this.mParentView);
        this.mParentView.addView(viewInflateView);
        this.mSubTranslationView.initView(this.mAiRootView, viewInflateView);
    }

    private void requestTranslate(boolean z) {
        this.mCommonViews.showProgress(1);
        this.mCommonViews.setBottomButtonsState(false);
        if (z) {
            this.mParentAction.getSrcContentInfo().setSubResultText(this.mParentAction.getResultToCopy().getText());
        } else {
            this.mParentAction.getSubTranslation().changeOriginalText(this.mParentAction.getResultToCopy().getText());
        }
        this.mParentAction.getSubTranslation().execute();
    }

    private void setVisibleState(boolean z) {
        if (z) {
            this.mResultView.setVisibility(8);
            this.mSubTranslationView.getView().setVisibility(0);
        } else {
            this.mSubTranslationView.getView().setVisibility(8);
            this.mResultView.setVisibility(0);
        }
        AiMenuContract.IAiAction action = getAction();
        if (action instanceof SubTranslation) {
            ((SubTranslation) action).setShowing(z);
        }
    }

    public void clearTranslation() {
        if (this.mSubTranslationView == null) {
            return;
        }
        this.mCommonViews.getBottomView().updateTranslateButtonText(true);
        this.mParentAction.getSrcContentInfo().setSubResultText(null);
        setVisibleState(false);
    }

    public AiMenuContract.IAiAction getAction() {
        return this.mSubTranslationView.getAction();
    }

    public boolean isShowing() {
        AiMenuResultViewSubTranslation aiMenuResultViewSubTranslation = this.mSubTranslationView;
        return aiMenuResultViewSubTranslation != null && aiMenuResultViewSubTranslation.getView().getVisibility() == 0;
    }

    public void onLanguageDownload() {
        requestTranslate(true);
    }

    public void toggleTranslate() {
        AiMenuResultViewSubTranslation aiMenuResultViewSubTranslation = this.mSubTranslationView;
        if (aiMenuResultViewSubTranslation == null) {
            requestTranslate(true);
            initSubTranslation(this.mParentAction.getSubTranslation());
        } else if (aiMenuResultViewSubTranslation.getView().getVisibility() == 0) {
            setVisibleState(false);
            this.mCommonViews.getBottomView().updateTranslateButtonText(true);
            return;
        }
        if (TextUtils.isEmpty(this.mParentAction.getSrcContentInfo().getSubResultText())) {
            requestTranslate(false);
        }
        setVisibleState(true);
        this.mCommonViews.getBottomView().updateTranslateButtonText(false);
    }
}
