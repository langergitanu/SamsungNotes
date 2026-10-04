package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Handler;
import android.view.View;
import com.samsung.android.sdk.composer.listener.SpenDialogActionListener;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.composer.listener.SpenPageLayoutListener;
import com.samsung.android.sdk.composer.listener.SpenStrokeShapeListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import com.samsung.android.sdk.pen.text.SpenTextLimitListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SoftInputListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.WebCardUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ListenerImplContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogPresenter extends HandoffManager.IDialogManager, WebCardUtil.IDialogManager {
        void dismissConfirmVoiceDialog();

        void dismissConvertSettingDialog();

        void dismissDirectWriteSettingDialog();

        void showCanNotAddToNoteDialog();

        void showConfirmCancelVoiceDialog();

        void showConfirmRemoveItemDialog(SpenWPage spenWPage, SpenObjectBase spenObjectBase);

        void showConfirmRemoveRecordingDialog();

        void showConvertSettingDialog(boolean z, boolean z2);

        void showLinkEditDialog(String str, SpenHyperTextSpan spenHyperTextSpan, boolean z, boolean z2);

        void showNotEnoughStorageDialog();

        void showOpenLinkPopup(Runnable runnable);

        void showTextBoxMoreDialog(SpenObjectShape spenObjectShape);

        void showTranslatedPDFBlockingDialog();

        void showTurnOffTranslationDialog(int i);

        void showUnavailableContentDialog();

        void showVersionUpdateDialog(Runnable runnable, Runnable runnable2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void clearWritingToolControl();

        void disableTableUnsupportedMenu();

        Activity getActivity();

        ComposerControllerManager getComposerControllerManager();

        ComposerModel getComposerModel();

        IDialogPresenter getDialogPresenterManager();

        SpenWNote getDoc();

        Handler getHandler();

        HandoffManager getHandoffManager();

        ListenerManager getListenerManager();

        NoteManager getNoteManager();

        ObjectManager getObjectManager();

        PageManager getPageManager();

        PdfManager getPdfManager();

        ComposerViewContract.TableAndCellContract getTableAndCellPresenter();

        TextManager getTextManager();

        ThumbnailUpdateHandler getThumbnailUpdateHandler();

        View getView();

        View getViewShowPopup();

        WritingToolManager getWritingToolManager();

        boolean isLockedScreen();

        void onAlignmentProgress(boolean z);

        void onAlignmentRunning(boolean z);

        void onAlignmentUpdateResult(ArrayList<RectF> arrayList);

        void onConvertToTextRunning(boolean z);

        void onInitLayoutFinished();

        void pauseCoEdit(String str, Runnable runnable);

        void requestReadyForSave();

        void resumeCoEdit(String str);

        void setContextMenu(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IShortCutManager extends View.OnKeyListener, SoftInputListenerImpl.ISipContextMenu, SpenPreTouchListenerImpl.PreTouchListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IStickyMemoManager {
        void openStickyMemo(SpenStickyNote spenStickyNote);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView extends ComposerControllerContract {
        IViewListenerManager getListenerManager();

        void hideCover();

        void onSmoothScrollEnd();

        void setDelayFlagToUpdateDecorView(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IViewListenerManager {
        void setActionListener(ActionListenerImpl actionListenerImpl);

        void setContextMenuDelegateListener(SpenContextMenuDelegateListener spenContextMenuDelegateListener);

        void setContextMenuListener(ContextMenuListenerImpl contextMenuListenerImpl);

        void setControlObjectListener(ControlObjectListenerImpl controlObjectListenerImpl);

        void setCursorChangedListener(CursorChangedListenerImpl cursorChangedListenerImpl);

        void setDialogActionListener(SpenDialogActionListener spenDialogActionListener);

        void setNoteWritingToastListener(SpenToastActionListenerImpl spenToastActionListenerImpl);

        void setNoteZoomScrollerListener(SpenNoteDeltaZoomAdapterImpl spenNoteDeltaZoomAdapterImpl);

        void setObjectSelectListener(SpenObjectSelectListener spenObjectSelectListener);

        void setObjectSpanControlObjectListener(ControlObjectSpanListenerImpl controlObjectSpanListenerImpl);

        void setOnDragListener(OnDragListenerImpl onDragListenerImpl);

        void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener);

        void setOnKeyListener(View.OnKeyListener onKeyListener);

        void setPageActionListener(PageActionListenerImpl pageActionListenerImpl);

        void setPageLayoutListener(SpenPageLayoutListener spenPageLayoutListener);

        void setPreTouchListener(SpenPreTouchListenerImpl spenPreTouchListenerImpl);

        void setSoftInputListener(SoftInputListenerImpl softInputListenerImpl);

        void setSpenAlignmentListener(SpenAlignmentListenerImpl spenAlignmentListenerImpl);

        void setSpenAnalyticsListener(SpenAnalyticsListenerImpl spenAnalyticsListenerImpl);

        void setSpenConvertToTextListener(SpenConvertToTextListenerImpl spenConvertToTextListenerImpl);

        void setSpenGestureControllerListener(SpenGestureControllerImpl spenGestureControllerImpl);

        void setSpenSTTListener(SpenSTTListenerImpl spenSTTListenerImpl);

        void setSpenSelectionChangeListener(SpenSelectionChangeListener spenSelectionChangeListener);

        void setSpenTextManagerActionListener(SpenTextManagerActionListenerImpl spenTextManagerActionListenerImpl);

        void setStrokeShapeListener(SpenStrokeShapeListener spenStrokeShapeListener);

        void setTextEventListener(SpenTextLimitListener spenTextLimitListener);

        void setThumbnailChangedListener(ThumbnailChangeListenerImpl thumbnailChangeListenerImpl);

        void setZoomListener(SpenZoomListenerImpl spenZoomListenerImpl);
    }
}
