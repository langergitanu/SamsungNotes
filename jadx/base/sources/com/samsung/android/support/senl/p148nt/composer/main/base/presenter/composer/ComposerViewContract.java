package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.handwriting.LaserPenInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.HWToolbarPolicyManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ComposerViewContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AiMenuManagerContract {
        AiCoverMenuViewPresenter getAiCoverMenuViewPresenter();

        void hideAiSuggestionView();

        boolean isTranslating();

        void setStopImageOverlay(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HWToolbarContract extends ComposerModeController.HwToolbarContract {
        void changeWritingMode();

        HwSettingPresenter getSettingInstance();

        void hideToolbar();

        boolean isSelected(int i);

        void onAlignmentProgress(boolean z);

        void onAlignmentRunning(boolean z);

        void onAlignmentUpdateResult(ArrayList<RectF> arrayList);

        void onConvertToTextRunning(boolean z);

        void onPageCountChanged();

        void onPageIndexChanged();

        void onPageLayoutChanged();

        void restoreHwToolbarState(HwToolbarState hwToolbarState);

        void setBlockContextMenu(boolean z);

        void setSelectedEraserButton();

        void setSelectedLaserPenButton();

        void setUnselectedDirectWriteButton();

        void showToolbar();

        void updateMoveOnlyMode(boolean z);

        HwToolbarState updateSelectionMode();

        void updateToolbarItemList();

        void updatedLastPenInfo();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogManager extends ListenerImplContract.IDialogPresenter {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void clearWritingToolControl();

        Activity getActivity();

        ComposerModel getComposerModel();

        int getCurrentPageIndex();

        @NonNull
        HWToolbarPolicyManager getHWToolbarPolicyManager();

        HWToolbarContract getHWToolbarPresenter();

        ListenerManager getListenerManager();

        ObjectManager getObjectManager();

        RtTableAndCellStyleContract getRtTableAndCellStylePresenter();

        TextManager getTextManager();

        TlToolbarContract getTlToolbarPresenter();

        @NonNull
        WritingToolManager getWritingToolManager();

        void goToPage(int i);

        boolean hasBackgroundImage();

        void insertPage(int i);

        boolean isActionLinkEnabled();

        boolean isCtrlPressedLast();

        boolean isHyperTextEnabled();

        void onConfigurationChanged(Configuration configuration, boolean z);

        void onInAppCollaborationCloseButtonClicked();

        void onPageCountChanged(int i);

        void onPageIndexChanged(int i);

        void onPageLayoutChanged();

        void onScroll(PagePanInfo pagePanInfo, float f, int i);

        void setInputFormEnabled(boolean z);

        void setLaserPen(boolean z, LaserPenInfo laserPenInfo);

        void setView(IView iView);

        void setWritingGuideLineEnabled(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView extends ListenerImplContract.IView {
        Bitmap captureCurrentView();

        void clearSmoothScrollAndScaleToFitPage();

        void clearZoomRunnableAfterZoom();

        void endContinuousChange();

        void executeWorkThreadFromCoedit(boolean z);

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract
        void goToPage(int i);

        void init(SpenWNote spenWNote);

        void initBackgroundColor(boolean z);

        void initScrollManager();

        boolean isEasyWritingPadEnabled();

        boolean isEdgeState(boolean z);

        boolean isZoomLocked();

        void onChangedNoteType(boolean z);

        void onChangedPageCount(int i);

        void onInAppCollaborationModeChanged(boolean z);

        void release(boolean z);

        void requestCancelTouch();

        void requestReadyForSave();

        void restoreBeforeSmoothScrollAndScaleToFitPage(Runnable runnable);

        void setAllwaysFitPageToScreen(boolean z);

        void setAutoScrollEnabled(boolean z);

        void setContextMenuDelegate(boolean z);

        void setDocument(SpenWNote spenWNote);

        void setEasyWritingPadEnabled(boolean z);

        void setFullScreenModeOn();

        void setInputFormEnabled(boolean z);

        void setLaserPen(boolean z, LaserPenInfo laserPenInfo);

        void setLongPressEnabled(boolean z);

        void setPresenter(IPresenter iPresenter);

        void setScrollingEnabled(boolean z);

        void setSpenNotePdfActionListener(PdfManager pdfManager);

        void setTagList(List<String> list);

        void setToolbarPosition(Rect rect, boolean z);

        void setWritingGuideLineEnabled(boolean z);

        void setZoomLock(boolean z);

        void setZoomRunnableAfterZoom(Runnable runnable);

        void showLockCanvasToolTip();

        void smoothScrollAndScaleToFitPage(int i, Runnable runnable);

        void smoothScrollAndScaleToFitRect(RectF rectF, Runnable runnable);

        void smoothScrollToPage(int i);

        void startActionMode();

        void startContinuousChange();

        void startStickyMemoIconAnimation(SpenStickyNote spenStickyNote, boolean z);

        void stopActionMode();

        void updateNextFocusForward(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InAppContract {
        void onInAppCollaborationCloseButtonClicked();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RtTableAndCellStyleContract {
        void showTableCellSetting(SpenObjectBase spenObjectBase, RectF rectF, boolean z);

        void showTableSetting(SpenObjectBase spenObjectBase, RectF rectF, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TableAndCellContract {
        void showCalculateRemoveMenu(SpenObjectBase spenObjectBase);

        void showMoreMenu(SpenObjectBase spenObjectBase, RectF rectF, boolean z, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TlToolbarContract {
        void addPendingActionAfterInflate(Runnable runnable);

        View getContainer();

        boolean isInflated();

        boolean isTranslated();

        void show();
    }
}
