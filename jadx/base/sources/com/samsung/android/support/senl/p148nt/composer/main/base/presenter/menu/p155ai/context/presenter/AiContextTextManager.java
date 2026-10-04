package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.SelectionText;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationOverlayManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SrcContentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiContextTextManager {
    private static final String TAG = Logger.createTag("AiContextTextManager", AiConstants.PREFIX_TAG);
    private final ComposerViewPresenter mComposerViewPresenter;
    private final Contract mContract;
    private final ControllerManager mControllerManager;
    private SelectionText mSelectionText;
    private final AiContextMenuState mState;
    private final TranslationOverlayManager mTranslationOverlayManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AiContextMenu getAiContextMenu();

        void initMenuExecutor(boolean z);

        boolean isBixbyAction();

        boolean isResultActionDirect();

        void postDirectAction();

        void postSmoothScrollAndScaleToFitPage(boolean z, int i, Runnable runnable);

        void setCanSwitchContents(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SpenContextMenuDelegateListenerImpl extends SpenContextMenuDelegateListener {
        public SpenContextMenuDelegateListenerImpl() {
        }

        @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
        public void onHideContextMenu() {
            Logger.m10999d(AiContextTextManager.TAG, "onHideContextMenu#");
            AiContextTextManager.this.mContract.getAiContextMenu().setVisible(false);
        }

        @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
        public boolean onShowContextMenu(RectF rectF, boolean z) {
            AiContextTextManager.this.mContract.getAiContextMenu().setVisible(true);
            RectF endCursorHandleRect = AiContextTextManager.this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getEndCursorHandleRect(true);
            if (endCursorHandleRect != null) {
                Logger.m10999d(AiContextTextManager.TAG, "onShowContextMenu# getEndCursorHandleRect " + endCursorHandleRect);
                AiContextTextManager.this.mContract.getAiContextMenu().updatePosition(endCursorHandleRect);
            } else {
                Logger.m10999d(AiContextTextManager.TAG, "onShowContextMenu# " + rectF);
                AiContextTextManager.this.mContract.getAiContextMenu().updatePosition(rectF);
            }
            return true;
        }

        @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
        public void onUpdateContentRect(RectF rectF) {
            RectF endCursorHandleRect = AiContextTextManager.this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getEndCursorHandleRect(true);
            if (endCursorHandleRect != null) {
                Logger.m10999d(AiContextTextManager.TAG, "onUpdateContentRect# getEndCursorHandleRect " + endCursorHandleRect);
                AiContextTextManager.this.mContract.getAiContextMenu().updatePosition(endCursorHandleRect);
                return;
            }
            Logger.m10999d(AiContextTextManager.TAG, "onUpdateContentRect# " + rectF);
            AiContextTextManager.this.mContract.getAiContextMenu().updatePosition(rectF);
        }
    }

    public AiContextTextManager(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, TranslationOverlayManager translationOverlayManager, AiContextMenuState aiContextMenuState, Contract contract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mTranslationOverlayManager = translationOverlayManager;
        this.mState = aiContextMenuState;
        this.mContract = contract;
    }

    public void clearSelectionText(boolean z) {
        SelectionText selectionText = this.mSelectionText;
        if (selectionText == null) {
            return;
        }
        selectionText.clear(z);
        this.mSelectionText = null;
        if (this.mState.isClearTextSelectionFlag()) {
            clearSelectionText();
        }
    }

    public void createSelectionText(final int i) {
        this.mSelectionText = new SelectionText(this.mComposerViewPresenter, this.mControllerManager, this.mTranslationOverlayManager, this.mContract.isBixbyAction(), new SelectionText.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionText.Contract
            public int getPageIndex() {
                return i;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionText.Contract
            public void onChanged(int i2, int i4) {
                AiContextTextManager.this.mContract.setCanSwitchContents(false);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionText.Contract
            public void onReleasedSelection() {
                if (AiContextTextManager.this.mState.isBlockToReleaseSelection()) {
                    Logger.m11003i(AiContextTextManager.TAG, "onReleasedSelection# ");
                } else {
                    AiContextTextManager.this.mContract.getAiContextMenu().hide();
                    AiContextTextManager.this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().clearAiTextFormat();
                }
            }
        });
    }

    public SelectionText getSelectionText() {
        return this.mSelectionText;
    }

    public boolean hasBodyTextWithSelectionText(int i) {
        if (this.mSelectionText == null) {
            createSelectionText(i);
        }
        Pair<Integer, Integer> pairStartSelectBodyText = this.mSelectionText.startSelectBodyText(this.mComposerViewPresenter.getDoc().getBodyText(), false);
        return ((pairStartSelectBodyText == null || pairStartSelectBodyText.first.intValue() == -1) ? 0 : (pairStartSelectBodyText.second.intValue() + 1) - pairStartSelectBodyText.first.intValue()) > 0;
    }

    public void readyToSwitchBodyText(int i) {
        if (this.mSelectionText == null) {
            createSelectionText(i);
        }
        setPreStateTextSelection();
        this.mSelectionText.startSelectBodyText(this.mComposerViewPresenter.getDoc().getBodyText(), true);
        setPostStateTextSelection();
    }

    public void readyToSwitchPdf(int i) {
        if (this.mSelectionText == null) {
            createSelectionText(i);
        }
        if (this.mSelectionText.selectPdfTextMin(this.mComposerViewPresenter.getDoc(), i, false)) {
            setPreStateTextSelection();
            this.mSelectionText.selectPdfTextMin(this.mComposerViewPresenter.getDoc(), i, true);
            setPostStateTextSelection();
        }
    }

    @RequiresApi(api = 33)
    public boolean restoreTextSelection(SrcContentInfo srcContentInfo) {
        String str = TAG;
        Logger.m10999d(str, "restoreTextSelection");
        if (!srcContentInfo.isSelected()) {
            return false;
        }
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        doc.selectObject(doc.getBodyText());
        boolean z = true;
        this.mControllerManager.getSoftInputManager().blockToShow(true, "restore ai context");
        if (srcContentInfo.getSrcType() == 1) {
            doc.getBodyText().setSelection(srcContentInfo.mStartPos, srcContentInfo.mEndPos);
        } else if (srcContentInfo.getSrcType() != 0) {
            z = false;
        } else {
            if (this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
                Logger.m10999d(str, "restoreTextSelection# ignore if translated");
                srcContentInfo.setSelected(false);
                return false;
            }
            PdfManager pdfManager = this.mComposerViewPresenter.getPdfManager();
            Logger.m10999d(str, srcContentInfo.mPdfStartPos.toString() + " " + srcContentInfo.mPdfEndPos.toString());
            pdfManager.setTextSelection(srcContentInfo.mPdfStartPos.getSpenPdfSelectionPos(), srcContentInfo.mPdfEndPos.getSpenPdfSelectionPos());
        }
        this.mControllerManager.getSoftInputManager().blockToShow(false, "restore ai context");
        return z;
    }

    public boolean selectMaximum() {
        if (this.mSelectionText == null) {
            return false;
        }
        this.mSelectionText.selectMaximumForText(this.mState.isWaitingMaxSelection() ? new SelectionText.MaxSelectionCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionText.MaxSelectionCallback
            public void onCompleted(boolean z) {
                AiContextTextManager.this.mContract.postDirectAction();
            }
        } : null);
        return true;
    }

    public void setPostStateTextSelection() {
        this.mContract.getAiContextMenu().show(this.mComposerViewPresenter.getActivity(), false);
        this.mContract.postDirectAction();
        this.mContract.initMenuExecutor(false);
        this.mState.setInitializing(false);
    }

    public void setPreStateTextSelection() {
        this.mComposerViewPresenter.getTextManager().setAiTextFormat(true);
        this.mComposerViewPresenter.getPdfManager().setSelectedPdfStateListener(new PdfManager.SelectedPdfStateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.PdfManager.SelectedPdfStateListener
            public void onMaxSelectionTextLengthReached() {
                AiCommonUtil.showCustomToast(AiContextTextManager.this.mComposerViewPresenter.getActivity(), AiContextTextManager.this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_cannot_select_more_maximum_characters));
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_TO_SELECT_TEXT, "a");
            }
        });
        this.mComposerViewPresenter.getPdfManager().setAiTextFormat(true);
        this.mComposerViewPresenter.setContextMenuDelegate(false, null);
        this.mComposerViewPresenter.setContextMenuDelegate(true, new SpenContextMenuDelegateListenerImpl());
    }

    public void startTextSelection(int i, boolean z, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (!AiContextTextManager.this.mState.isShowing()) {
                    Logger.m11000e(AiContextTextManager.TAG, "startAiAssist# not showing state");
                    return;
                }
                AiContextTextManager.this.setPreStateTextSelection();
                runnable.run();
                AiContextTextManager.this.setPostStateTextSelection();
            }
        };
        if (this.mContract.isResultActionDirect()) {
            runnable2.run();
        } else {
            this.mContract.postSmoothScrollAndScaleToFitPage(z, i, runnable2);
        }
    }

    public boolean startTextSelection(int i) {
        createSelectionText(i);
        if (!this.mSelectionText.startTextSelection(false)) {
            return false;
        }
        setPreStateTextSelection();
        this.mSelectionText.startTextSelection(true);
        setPostStateTextSelection();
        return true;
    }

    public void clearSelectionText() {
        this.mComposerViewPresenter.setAutoScrollEnabled(false);
        this.mComposerViewPresenter.getTextManager().clearSelection();
        this.mComposerViewPresenter.getPdfManager().clearSelection();
        this.mComposerViewPresenter.setAutoScrollEnabled(true);
    }
}
