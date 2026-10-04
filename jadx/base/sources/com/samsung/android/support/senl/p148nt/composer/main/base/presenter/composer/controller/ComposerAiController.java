package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerAiController {
    private ComposerViewPresenterContract mContract;
    private boolean mNeedToReleaseAiSelectionOnFirstMove;
    private PdfManager mPdfManager;
    private TextManager mTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComposerViewPresenterContract {
        void clearContextMenuDelegate();

        void clearTextSelectionChangedListener();
    }

    public void clearAiTextFormat() {
        if (this.mContract == null) {
            return;
        }
        this.mTextManager.setAiTextFormat(false);
        this.mPdfManager.setAiTextFormat(false);
        this.mContract.clearTextSelectionChangedListener();
        this.mPdfManager.setPdfSelectionChangedListener(null);
        this.mContract.clearContextMenuDelegate();
    }

    public void init(TextManager textManager, PdfManager pdfManager) {
        this.mTextManager = textManager;
        this.mPdfManager = pdfManager;
    }

    public boolean isNeedToReleaseAiSelectionOnFirstMove() {
        return this.mNeedToReleaseAiSelectionOnFirstMove;
    }

    public void setContract(ComposerViewPresenterContract composerViewPresenterContract) {
        this.mContract = composerViewPresenterContract;
    }

    public void setNeedToReleaseAiSelectionOnFirstMove(boolean z) {
        this.mNeedToReleaseAiSelectionOnFirstMove = z;
    }
}
