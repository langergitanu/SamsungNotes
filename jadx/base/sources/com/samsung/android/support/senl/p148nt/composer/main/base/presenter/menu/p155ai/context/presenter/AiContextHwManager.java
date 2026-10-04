package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextTextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.SelectionHw;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiContextHwManager {
    private static final String SAVE_KEY_LINE_RECT = "hw_line_rect";
    private static final String SAVE_KEY_TEXT_AI_ASSIST_HW = "assist_hw";
    private static final String TAG = Logger.createTag("AiContextHwManager", AiConstants.PREFIX_TAG);
    private final AiMenuResultManager mAiMenuResultManager;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final Contract mContract;
    private final ControllerManager mControllerManager;
    private String mErrorMsg;
    private ArrayList<SpenObjectBase> mLastSelectedObjectList;
    private RectF mLastSelectedViewRect;
    private SelectionHw mSelectionHW;
    private SpenObjectSelectListener mSpenObjectSelectListener;
    private final AiContextMenuState mState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract extends AiContextTextManager.Contract {
        void handleFailOfStartHwContext();

        void onHide();

        void show(boolean z, int i, View view, boolean z2);

        boolean startTextSelection(int i);
    }

    public AiContextHwManager(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, AiContextMenuState aiContextMenuState, AiMenuResultManager aiMenuResultManager, Contract contract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mState = aiContextMenuState;
        this.mAiMenuResultManager = aiMenuResultManager;
        this.mContract = contract;
    }

    private boolean startSelectionWithSelectedObjects() {
        this.mLastSelectedObjectList = this.mComposerViewPresenter.getObjectManager().getSelectedSafeObjectList();
        if (this.mSpenObjectSelectListener == null) {
            this.mSpenObjectSelectListener = new SpenObjectSelectListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextHwManager.3
                @Override // com.samsung.android.sdk.composer.listener.SpenObjectSelectListener
                public void onObjectSelected(ArrayList<SpenWPage> arrayList, ArrayList<SpenObjectBase> arrayList2, boolean z) {
                    if (z || AiContextHwManager.this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected()) {
                        return;
                    }
                    if (AiContextHwManager.this.mLastSelectedObjectList != null && !AiContextHwManager.this.mAiMenuResultManager.isShowingResultView()) {
                        AiContextHwManager.this.mContract.onHide();
                    }
                    AiContextHwManager.this.mLastSelectedObjectList = null;
                }
            };
        }
        this.mComposerViewPresenter.getListenerManager().addSpenObjectSelectListener(this.mSpenObjectSelectListener);
        return this.mSelectionHW.startSelectionWithSelectedObjects();
    }

    public void clearSelectionHw(boolean z) {
        SelectionHw selectionHw = this.mSelectionHW;
        if (selectionHw != null) {
            selectionHw.clear(z);
            this.mSelectionHW = null;
        }
        this.mLastSelectedViewRect = null;
    }

    public void createSelectionHw(final Integer num) {
        this.mSelectionHW = new SelectionHw(this.mComposerViewPresenter, this.mControllerManager, new SelectionHw.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextHwManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionHw.Contract
            public void hide() {
                AiContextHwManager.this.mContract.getAiContextMenu().hide();
                AiContextHwManager.this.mLastSelectedViewRect = null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionHw.Contract
            public void onRecognitionFailed() {
                if (AiContextHwManager.this.mState.isHwContext()) {
                    AiContextHwManager aiContextHwManager = AiContextHwManager.this;
                    aiContextHwManager.mErrorMsg = aiContextHwManager.mComposerViewPresenter.getActivity().getString(C9086R.string.composer_unable_to_extract_text);
                } else if (!AiContextHwManager.this.isWritingMode() || num == null) {
                    AiContextHwManager aiContextHwManager2 = AiContextHwManager.this;
                    aiContextHwManager2.mErrorMsg = aiContextHwManager2.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_can_not_find_any_text);
                } else {
                    AiContextHwManager.this.clearSelectionHw(true);
                    if (AiContextHwManager.this.mContract.startTextSelection(num.intValue())) {
                        return;
                    }
                    AiContextHwManager aiContextHwManager3 = AiContextHwManager.this;
                    aiContextHwManager3.mErrorMsg = aiContextHwManager3.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_error_can_not_find_any_text);
                }
                if (AiContextHwManager.this.mContract.getAiContextMenu().isShowing()) {
                    hide();
                } else {
                    AiContextHwManager.this.mContract.onHide();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionHw.Contract
            public void updateMenu(boolean z, RectF rectF, RectF rectF2) {
                boolean zIsShowing = AiContextHwManager.this.mContract.getAiContextMenu().isShowing();
                if (AiContextHwManager.this.mState.isHwContext() && z && !zIsShowing) {
                    AiContextHwManager.this.mContract.getAiContextMenu().show(AiContextHwManager.this.mComposerViewPresenter.getActivity(), true);
                    AiContextHwManager.this.mContract.postDirectAction();
                } else if (AiContextHwManager.this.mState.isInitializing() || AiContextHwManager.this.mState.isWaitingMaxSelection()) {
                    AiContextHwManager.this.mContract.postDirectAction();
                    AiContextHwManager.this.mState.setInitializing(false);
                }
                if (z && zIsShowing && AiContextHwManager.this.mLastSelectedViewRect != null && AiContextHwManager.this.mLastSelectedViewRect.height() != rectF2.height()) {
                    AiContextHwManager.this.mContract.setCanSwitchContents(false);
                }
                AiContextHwManager.this.mContract.getAiContextMenu().setVisible(z);
                if (z && rectF != null) {
                    AiContextHwManager.this.mContract.getAiContextMenu().updatePosition(rectF);
                }
                AiContextHwManager.this.mLastSelectedViewRect = rectF2;
            }
        });
    }

    public SelectionHw getSelectionHW() {
        return this.mSelectionHW;
    }

    public SpenObjectSelectListener getSpenObjectSelectListener() {
        return this.mSpenObjectSelectListener;
    }

    public boolean hasLineRectList() {
        SelectionHw selectionHw = this.mSelectionHW;
        return (selectionHw == null || selectionHw.getLineRectFList() == null || this.mSelectionHW.getLineRectFList().isEmpty()) ? false : true;
    }

    public boolean isAiAssistHw() {
        return (this.mState.isHwContext() || this.mSelectionHW == null) ? false : true;
    }

    public boolean isWritingMode() {
        return this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Writing);
    }

    public void readyToSwitchHw(int i) {
        createSelectionHw(Integer.valueOf(i));
        this.mContract.getAiContextMenu().show(this.mComposerViewPresenter.getActivity(), false);
        int i2 = this.mComposerViewPresenter.getComposerModel().getDoc().getPage(i).getOffset().y;
        int i4 = this.mComposerViewPresenter.getComposerModel().getDoc().getPage(i).getOffset().x;
        ArrayList<RectF> arrayList = new ArrayList<>();
        arrayList.add(new RectF(i4, i2, this.mComposerViewPresenter.getDoc().getPage(i).getWidth() + i4, this.mComposerViewPresenter.getDoc().getPage(i).getHeight() + i2));
        this.mSelectionHW.setLineRectFList(arrayList);
        if (this.mSelectionHW.restoreSelection()) {
            this.mContract.initMenuExecutor(true);
        }
    }

    @RequiresApi(api = 33)
    public boolean restoreHw(Bundle bundle) {
        ArrayList<SpenObjectBase> arrayList = this.mLastSelectedObjectList;
        if (arrayList == null || arrayList.isEmpty()) {
            this.mLastSelectedObjectList = null;
            ArrayList<RectF> parcelableArrayList = bundle.getParcelableArrayList("hw_line_rect", RectF.class);
            if (parcelableArrayList == null) {
                return false;
            }
            createSelectionHw(null);
            this.mSelectionHW.setLineRectFList(parcelableArrayList);
            this.mContract.show(!bundle.getBoolean(SAVE_KEY_TEXT_AI_ASSIST_HW, false), 0, null, true);
            return true;
        }
        List<SpenObjectBase> selectedObjectList = this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.size() != this.mLastSelectedObjectList.size()) {
            this.mComposerViewPresenter.getDoc().selectObject(this.mLastSelectedObjectList);
        }
        if (this.mSelectionHW == null) {
            createSelectionHw(null);
            this.mSelectionHW.setLineRectFList(null);
        }
        this.mContract.show(!bundle.getBoolean(SAVE_KEY_TEXT_AI_ASSIST_HW, false), 0, null, true);
        return false;
    }

    public void restoreResultSelection() {
        ArrayList<SpenObjectBase> arrayList = this.mLastSelectedObjectList;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        List<SpenObjectBase> selectedObjectList = this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.size() != this.mLastSelectedObjectList.size()) {
            this.mComposerViewPresenter.getDoc().selectObject(this.mLastSelectedObjectList);
        }
    }

    public boolean saveState(@NonNull Bundle bundle) {
        SelectionHw selectionHw = this.mSelectionHW;
        if (selectionHw == null) {
            return false;
        }
        bundle.putParcelableArrayList(SAVE_KEY_LINE_RECT, selectionHw.getLineRectFList());
        bundle.putBoolean(SAVE_KEY_TEXT_AI_ASSIST_HW, isAiAssistHw());
        return true;
    }

    public void showErrorToast() {
        if (TextUtils.isEmpty(this.mErrorMsg)) {
            return;
        }
        AiCommonUtil.showCustomToast(this.mComposerViewPresenter.getActivity(), this.mErrorMsg);
        this.mErrorMsg = null;
    }

    public boolean startHwContext(boolean z) {
        if (this.mSelectionHW == null) {
            createSelectionHw(null);
        }
        this.mLastSelectedObjectList = null;
        if (this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected()) {
            this.mAiMenuResultManager.cancelRecognizing();
            this.mComposerViewPresenter.setContextMenuDelegate(true, null);
            return startSelectionWithSelectedObjects();
        }
        if (z) {
            return this.mSelectionHW.restoreSelection();
        }
        this.mAiMenuResultManager.cancelRecognizing();
        return this.mSelectionHW.startHwSelection();
    }

    public void startHwSelection(final int i, boolean z) {
        final boolean z2 = this.mSelectionHW != null;
        this.mContract.postSmoothScrollAndScaleToFitPage(z, i, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextHwManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (!AiContextHwManager.this.mState.isShowing()) {
                    Logger.m11000e(AiContextHwManager.TAG, "startAiAssist# not showing state");
                    return;
                }
                if (!z2) {
                    AiContextHwManager.this.createSelectionHw(Integer.valueOf(i));
                }
                AiContextHwManager.this.mContract.getAiContextMenu().show(AiContextHwManager.this.mComposerViewPresenter.getActivity(), false);
                if (AiContextHwManager.this.startHwContext(z2)) {
                    AiContextHwManager.this.mContract.initMenuExecutor(true);
                } else {
                    AiContextHwManager.this.mContract.handleFailOfStartHwContext();
                }
            }
        });
    }
}
