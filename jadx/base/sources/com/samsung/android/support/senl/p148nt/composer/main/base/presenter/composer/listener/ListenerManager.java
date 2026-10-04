package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.listener.SpenDialogActionListener;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener;
import com.samsung.android.sdk.pen.control.SpenControlObjectListener;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener;
import com.samsung.android.sdk.pen.text.SpenCursorChangedListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.C7868a;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.DragAndDropController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.CursorChangedListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenTextManagerActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ListenerManager {
    private static final String TAG = Logger.createTag("ListenerManager");
    private ActionListenerImpl mActionListener;
    private final ComponentFactory mComponentFactory;
    private ControlObjectListenerImpl mControlObjectListener;
    private ControlObjectSpanListenerImpl mControlObjectSpanListener;
    private CursorChangedListenerImpl mCursorChangedListener;
    private DefaultPreTouchListenerImpl mDefaultPreTouchListenerImpl;
    private SpenDialogActionListener mDialogActionListener;
    private HistoryEventListenerImpl mHistoryEventListener;
    private SpenObjectSelectListenerImpl mObjectSelectListener;
    private OnDragListenerImpl mOnDragListener;
    private PageActionListenerImpl mPageActionListener;
    private final ListenerImplContract.IPresenter mPresenter;
    private SoftInputListenerImpl mSoftInputListener;
    private SpenAlignmentListenerImpl mSpenAlignmentListener;
    private SpenConvertToTextListenerImpl mSpenConvertToTextListener;
    private SpenCustomObjectEventListener mSpenCustomObjectEventListener;
    private SpenNotePdfActionListenerImpl mSpenNotePdfActionListener;
    private SpenObjectEventListenerImpl mSpenObjectEventListener;
    private SpenPageEventListener mSpenPageEventListener;
    private SpenPageLayoutListenerImpl mSpenPageLayoutListener;
    private SpenPreTouchListenerImpl mSpenPreTouchListener;
    private SpenTextManagerActionListenerImpl mSpenTextManagerActionListener;
    private SpenVoiceDataEventListenerImpl mSpenVoiceDataEventListenerImpl;
    private TextEventListenerImpl mTextEventListener;
    private ThumbnailChangeListenerImpl mThumbnailChangeListener;
    private final ViewGetter mViewGetter;
    private VoiceRecordingListenerManager mVoiceRecordingListenerManager;
    private final ContextMenuListenerImpl mContextMenuListener = new ContextMenuListenerImpl();
    private final SpenSTTListenerImpl mSpenSTTListenerImpl = new SpenSTTListenerImpl();
    private final SpenZoomListenerImpl mSpenZoomListener = new SpenZoomListenerImpl();
    private final SpenToastActionListenerImpl mSpenToastActionListener = new SpenToastActionListenerImpl();
    private final SpenAnalyticsListenerImpl mSpenAnalyticsListener = new SpenAnalyticsListenerImpl();
    private final OnFocusChangeListenerImpl mOnFocusChangeListener = new OnFocusChangeListenerImpl();
    private final OnKeyListenerImpl mOnKeyListener = new OnKeyListenerImpl();
    private final SpenNoteDeltaZoomAdapterImpl mNoteZoomScrollerListenerManager = new SpenNoteDeltaZoomAdapterImpl();
    private final SpenStrokeShapeListenerImpl mSpenStrokeShapeListener = new SpenStrokeShapeListenerImpl();
    private final SpenSelectionChangeListenerImpl mSpenSelectionChangeListener = new SpenSelectionChangeListenerImpl();
    private boolean mInitialized = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory {
        @NonNull
        ActionListenerImpl createActionListener(@NonNull ListenerImplContract.IView iView, @NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull ContextMenuListenerImpl contextMenuListenerImpl);

        @NonNull
        ControlObjectListenerImpl createControlObjectListenerImpl(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull DragAndDropController dragAndDropController);

        @NonNull
        SpenObjectSelectListenerImpl createObjectSelectListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull SoftInputManager softInputManager, @NonNull TextStateHandler textStateHandler);

        @NonNull
        OnDragListenerImpl createOnDragListenerImpl(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager);

        @NonNull
        PageActionListenerImpl createPageActionListenerImpl(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ProgressController progressController);

        @NonNull
        SpenConvertToTextListenerImpl createSpenConvertToTextListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull TaskController taskController, @NonNull ProgressController progressController, @NonNull SoftInputManager softInputManager);

        @NonNull
        SpenNotePdfActionListenerImpl createSpenNotePdfActionListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull DragAndDropController dragAndDropController);

        @NonNull
        SpenTextManagerActionListenerImpl createSpenTextManagerActionListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull DragAndDropController dragAndDropController);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ViewGetter {
        @Nullable
        ListenerImplContract.IView getView();
    }

    public ListenerManager(@NonNull ComponentFactory componentFactory, ListenerImplContract.IPresenter iPresenter, ViewGetter viewGetter) {
        this.mComponentFactory = componentFactory;
        this.mPresenter = iPresenter;
        this.mViewGetter = viewGetter;
    }

    private void initPreCommitTextFunc(ControllerManager controllerManager) {
        this.mPresenter.getTextManager().getSpenNoteTextManager().setPreCommitRegex(new Regex("^[\\s\\S]{25,}$"));
        this.mPresenter.getTextManager().getSpenNoteTextManager().setPreCommitCheckFunction(new C7868a(controllerManager, 2));
    }

    private boolean isInvalidWithView() {
        return !this.mInitialized || this.mViewGetter.getView() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$initPreCommitTextFunc$0(ControllerManager controllerManager, CharSequence charSequence, Integer num, Integer num2) {
        ClipData.Item item;
        String[] strArr;
        Logger.m10999d(TAG, "PreCommitCheckFunction# ");
        if (num.intValue() != -1 && num2.intValue() != -1) {
            return Boolean.TRUE;
        }
        String strTrim = charSequence.toString().trim();
        if (strTrim.startsWith("<html>") && strTrim.endsWith("</html>")) {
            item = new ClipData.Item("", charSequence.toString());
            strArr = new String[]{Constants.MIME_HTML};
        } else {
            item = new ClipData.Item(charSequence);
            strArr = new String[]{"text/plain"};
        }
        controllerManager.getClipboardController().paste(null, new ClipData(null, strArr, item));
        return Boolean.FALSE;
    }

    private void releasePreCommitTextFunc() {
        if (this.mPresenter.getTextManager().getSpenNoteTextManager() != null) {
            this.mPresenter.getTextManager().getSpenNoteTextManager().setPreCommitCheckFunction(null);
        }
    }

    public void addCustomObjectEventListener(SpenWNote.CustomObjectEventListener customObjectEventListener) {
        if (this.mInitialized) {
            this.mSpenCustomObjectEventListener.addListener(customObjectEventListener);
        }
    }

    public void addFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.mInitialized) {
            this.mOnFocusChangeListener.addListener(onFocusChangeListener);
        }
    }

    public void addHistoryEventBridgeListener(HistoryEventListenerImpl.HistoryEventBridgeListener historyEventBridgeListener) {
        if (this.mInitialized) {
            this.mHistoryEventListener.addBridgeListener(historyEventBridgeListener);
        }
    }

    public void addKeyListener(View.OnKeyListener onKeyListener) {
        if (this.mInitialized) {
            this.mOnKeyListener.addListener(onKeyListener);
        }
    }

    public void addNoteZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener) {
        if (isInvalidWithView()) {
            return;
        }
        this.mNoteZoomScrollerListenerManager.addZoomScrollerListener(spenNoteZoomScrollerListener);
        if (!this.mNoteZoomScrollerListenerManager.isEnable() || this.mViewGetter.getView() == null) {
            return;
        }
        this.mViewGetter.getView().getListenerManager().setNoteZoomScrollerListener(this.mNoteZoomScrollerListenerManager);
    }

    public void addPreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        if (isInvalidWithView()) {
            return;
        }
        this.mSpenPreTouchListener.addPreTouchListener(preTouchListener);
        if (!this.mSpenPreTouchListener.isEnable() || this.mViewGetter.getView() == null) {
            return;
        }
        this.mViewGetter.getView().getListenerManager().setPreTouchListener(this.mSpenPreTouchListener);
    }

    public void addSpenControlObjectListener(SpenControlObjectListener spenControlObjectListener) {
        if (this.mInitialized) {
            this.mControlObjectListener.addListener(spenControlObjectListener);
        }
    }

    public void addSpenObjectEventListener(SpenWNote.ObjectEventListener objectEventListener) {
        if (this.mInitialized) {
            this.mSpenObjectEventListener.addSpenObjectEventListener(objectEventListener);
            if (this.mSpenObjectEventListener.isEnable()) {
                this.mPresenter.getDoc().registerObjectEventListener(this.mSpenObjectEventListener);
            }
        }
    }

    public void addSpenObjectSelectListener(SpenObjectSelectListener spenObjectSelectListener) {
        if (this.mInitialized) {
            this.mObjectSelectListener.addBridgeListener(spenObjectSelectListener);
        }
    }

    public void addSpenSTTListener(SPenSTTListener sPenSTTListener) {
        if (this.mInitialized) {
            this.mSpenSTTListenerImpl.addBridgeListener(sPenSTTListener);
        }
    }

    public void addSpenSelectionChangeListener(SpenSelectionChangeListener spenSelectionChangeListener) {
        if (this.mInitialized) {
            this.mSpenSelectionChangeListener.addBridgeListener(spenSelectionChangeListener);
        }
    }

    public void addVoiceDataEventListener(SpenWNote.VoiceDataEventListener voiceDataEventListener) {
        if (this.mInitialized) {
            this.mSpenVoiceDataEventListenerImpl.addVoiceDataListener(voiceDataEventListener);
        }
    }

    public void addZoomListener(SpenZoomListenerImpl.ZoomListener zoomListener) {
        if (isInvalidWithView()) {
            return;
        }
        this.mSpenZoomListener.addZoomListener(zoomListener);
        if (!this.mSpenZoomListener.isEnable() || this.mViewGetter.getView() == null) {
            return;
        }
        this.mViewGetter.getView().getListenerManager().setZoomListener(this.mSpenZoomListener);
    }

    public void consumeDelayedCursorChangeEvent() {
        this.mCursorChangedListener.consumeAllMessages();
    }

    public ActionListenerImpl getActionListener() {
        return this.mActionListener;
    }

    @NonNull
    public ContextMenuListenerImpl getContextMenuListener() {
        return this.mContextMenuListener;
    }

    public ControlObjectListenerImpl getControlObjectListener() {
        return this.mControlObjectListener;
    }

    public MotionEvent getLastTouchedMotionEvent() {
        DefaultPreTouchListenerImpl defaultPreTouchListenerImpl = this.mDefaultPreTouchListenerImpl;
        if (defaultPreTouchListenerImpl != null) {
            return defaultPreTouchListenerImpl.getLastTouchedMotionEvent();
        }
        return null;
    }

    public OnDragListenerImpl getOnDragListener() {
        return this.mOnDragListener;
    }

    public PageActionListenerImpl getPageActionListenerImpl() {
        return this.mPageActionListener;
    }

    public SpenNotePdfActionListenerImpl getSpenNotePdfListener() {
        return this.mSpenNotePdfActionListener;
    }

    public SpenPageEventListener getSpenPageEventListener() {
        return this.mSpenPageEventListener;
    }

    public void init(ControllerManager controllerManager) {
        ListenerImplContract.IView view = this.mViewGetter.getView();
        if (view == null) {
            return;
        }
        DragAndDropController dragAndDropController = new DragAndDropController(this.mPresenter.getActivity(), this.mPresenter.getView(), this.mPresenter.getObjectManager(), this.mPresenter.getPageManager(), this.mPresenter.getComposerModel().getModeManager(), this.mPresenter.getComposerControllerManager().getScrollController(), controllerManager, this.mPresenter.getPdfManager(), this.mPresenter.hashCode());
        TextStateHandler textStateHandler = new TextStateHandler(this.mPresenter.getTextManager(), controllerManager.getQuickSaveTimer(), this.mPresenter.getHandoffManager().getHandler());
        this.mCursorChangedListener = new CursorChangedListenerImpl(this.mPresenter, controllerManager.getQuickSaveTimer(), textStateHandler);
        this.mPageActionListener = this.mComponentFactory.createPageActionListenerImpl(this.mPresenter, controllerManager.getProgressController());
        this.mSoftInputListener = new SoftInputListenerImpl(this.mPresenter, controllerManager.getSoftInputManager(), controllerManager.getClipboardController());
        this.mThumbnailChangeListener = new ThumbnailChangeListenerImpl(this.mPresenter);
        this.mActionListener = this.mComponentFactory.createActionListener(view, this.mPresenter, controllerManager, this.mContextMenuListener);
        this.mDialogActionListener = new SpenDialogActionListenerImpl(this.mPresenter, controllerManager);
        this.mObjectSelectListener = this.mComponentFactory.createObjectSelectListener(this.mPresenter, controllerManager.getSoftInputManager(), textStateHandler);
        this.mSpenTextManagerActionListener = this.mComponentFactory.createSpenTextManagerActionListener(this.mPresenter, controllerManager, dragAndDropController);
        this.mSpenNotePdfActionListener = this.mComponentFactory.createSpenNotePdfActionListener(this.mPresenter, controllerManager, dragAndDropController);
        this.mControlObjectListener = this.mComponentFactory.createControlObjectListenerImpl(this.mPresenter, controllerManager, dragAndDropController);
        this.mControlObjectSpanListener = new ControlObjectSpanListenerImpl(this.mPresenter, controllerManager, dragAndDropController);
        this.mSpenConvertToTextListener = this.mComponentFactory.createSpenConvertToTextListener(this.mPresenter, controllerManager.getTaskController(), controllerManager.getProgressController(), controllerManager.getSoftInputManager());
        this.mSpenAlignmentListener = new SpenAlignmentListenerImpl(this.mPresenter, controllerManager.getProgressController());
        this.mOnDragListener = this.mComponentFactory.createOnDragListenerImpl(this.mPresenter, controllerManager);
        this.mSpenPreTouchListener = new SpenPreTouchListenerImpl(this.mPresenter.getComposerModel().getCoeditAdapter());
        ListenerImplContract.IPresenter iPresenter = this.mPresenter;
        this.mVoiceRecordingListenerManager = new VoiceRecordingListenerManager(iPresenter, iPresenter.getDialogPresenterManager(), controllerManager);
        this.mSpenPageLayoutListener = new SpenPageLayoutListenerImpl(this.mPresenter.getComposerControllerManager().getCvPageSettingController());
        this.mDefaultPreTouchListenerImpl = new DefaultPreTouchListenerImpl(this.mPresenter.getComposerModel(), this.mPresenter.getHandoffManager().getHandler(), controllerManager.getQuickSaveTimer());
        this.mTextEventListener = new TextEventListenerImpl(this.mPresenter.getActivity());
        ListenerImplContract.IViewListenerManager listenerManager = view.getListenerManager();
        listenerManager.setCursorChangedListener(this.mCursorChangedListener);
        listenerManager.setPageActionListener(this.mPageActionListener);
        listenerManager.setSoftInputListener(this.mSoftInputListener);
        listenerManager.setThumbnailChangedListener(this.mThumbnailChangeListener);
        listenerManager.setContextMenuListener(this.mContextMenuListener);
        listenerManager.setActionListener(this.mActionListener);
        listenerManager.setDialogActionListener(this.mDialogActionListener);
        listenerManager.setObjectSelectListener(this.mObjectSelectListener);
        listenerManager.setSpenTextManagerActionListener(this.mSpenTextManagerActionListener);
        listenerManager.setControlObjectListener(this.mControlObjectListener);
        listenerManager.setObjectSpanControlObjectListener(this.mControlObjectSpanListener);
        listenerManager.setSpenConvertToTextListener(this.mSpenConvertToTextListener);
        listenerManager.setSpenAlignmentListener(this.mSpenAlignmentListener);
        listenerManager.setSpenSTTListener(this.mSpenSTTListenerImpl);
        listenerManager.setOnDragListener(this.mOnDragListener);
        listenerManager.setSpenAnalyticsListener(this.mSpenAnalyticsListener);
        listenerManager.setOnFocusChangeListener(this.mOnFocusChangeListener);
        listenerManager.setOnKeyListener(this.mOnKeyListener);
        listenerManager.setNoteZoomScrollerListener(this.mNoteZoomScrollerListenerManager);
        listenerManager.setPageLayoutListener(this.mSpenPageLayoutListener);
        listenerManager.setStrokeShapeListener(this.mSpenStrokeShapeListener);
        listenerManager.setTextEventListener(this.mTextEventListener);
        listenerManager.setNoteWritingToastListener(this.mSpenToastActionListener);
        listenerManager.setSpenSelectionChangeListener(this.mSpenSelectionChangeListener);
        this.mOnFocusChangeListener.addListener(controllerManager.getClipboardController());
        initPreCommitTextFunc(controllerManager);
        this.mContextMenuListener.setDragAndDropInfo(this.mOnDragListener.getDragAndDropInfo());
        this.mSoftInputListener.setDragAndDropInfo(this.mOnDragListener.getDragAndDropInfo());
        this.mSpenTextManagerActionListener.setDragAndDropInfo(this.mOnDragListener.getDragAndDropInfo());
        this.mSpenNotePdfActionListener.setDragAndDropInfo(this.mOnDragListener.getDragAndDropInfo());
        this.mControlObjectListener.setDragAndDropInfo(this.mOnDragListener.getDragAndDropInfo());
        this.mControlObjectSpanListener.setDragAndDropInfo(this.mOnDragListener.getDragAndDropInfo());
        this.mInitialized = true;
        addPreTouchListener(this.mDefaultPreTouchListenerImpl);
    }

    public void initListenerForDoc() {
        this.mHistoryEventListener = new HistoryEventListenerImpl(this.mPresenter.getDoc());
        this.mSpenObjectEventListener = new SpenObjectEventListenerImpl(this.mPresenter.getHandoffManager().getHandler());
        this.mSpenPageEventListener = new SpenPageEventListener(this.mPresenter);
        this.mSpenVoiceDataEventListenerImpl = new SpenVoiceDataEventListenerImpl();
        this.mSpenCustomObjectEventListener = new SpenCustomObjectEventListener(this.mPresenter.getDoc());
        this.mPresenter.getDoc().registerPageEventListener(this.mSpenPageEventListener);
        this.mPresenter.getDoc().registerVoiceDataEventListener(this.mSpenVoiceDataEventListenerImpl);
        this.mPresenter.getDoc().registerTextEventListener(this.mTextEventListener);
    }

    public boolean isCtrlPressedLast() {
        if (this.mInitialized) {
            return this.mOnKeyListener.isCtrlPressedLast();
        }
        return false;
    }

    public void notifyClearedHistory() {
        if (this.mInitialized) {
            this.mHistoryEventListener.notifyClearedHistory();
        }
    }

    public void onDestroy() {
        releaseDocListener();
        if (this.mInitialized) {
            this.mInitialized = false;
            this.mSpenPreTouchListener.release();
            this.mSpenPreTouchListener = null;
            this.mCursorChangedListener.release();
            this.mVoiceRecordingListenerManager.release();
            this.mOnDragListener.release();
            this.mSpenConvertToTextListener.release();
            this.mSpenAlignmentListener.release();
            this.mSpenSTTListenerImpl.release();
            this.mControlObjectListener.release();
            this.mControlObjectSpanListener.release();
            this.mSpenTextManagerActionListener.release();
            this.mActionListener.release();
        }
    }

    public void registerHistoryEventListener(HistoryEventListenerImpl.UndoRedoListener undoRedoListener) {
        if (this.mInitialized) {
            this.mHistoryEventListener.registerHistoryEventListener(undoRedoListener);
        }
    }

    public void releaseDocListener() {
        HistoryEventListenerImpl historyEventListenerImpl = this.mHistoryEventListener;
        if (historyEventListenerImpl != null) {
            historyEventListenerImpl.release();
            this.mHistoryEventListener = null;
        }
        boolean z = (this.mPresenter.getDoc() == null || this.mPresenter.getDoc().isClosed()) ? false : true;
        if (this.mSpenPageEventListener != null) {
            if (z) {
                this.mPresenter.getDoc().deregisterPageEventListener(this.mSpenPageEventListener);
            }
            this.mSpenPageEventListener.release();
            this.mSpenPageEventListener = null;
        }
        if (this.mSpenVoiceDataEventListenerImpl != null) {
            if (z) {
                this.mPresenter.getDoc().deregisterVoiceDataEventListener(this.mSpenVoiceDataEventListenerImpl);
            }
            this.mSpenVoiceDataEventListenerImpl.release();
            this.mSpenVoiceDataEventListenerImpl = null;
        }
        if (this.mTextEventListener != null) {
            if (z) {
                this.mPresenter.getDoc().deregisterTextEventListener(this.mTextEventListener);
            }
            this.mTextEventListener.release();
            this.mTextEventListener = null;
        }
        if (this.mSpenObjectEventListener != null) {
            if (z) {
                this.mPresenter.getDoc().deregisterObjectEventListener(this.mSpenObjectEventListener);
            }
            this.mSpenObjectEventListener.release();
            this.mSpenObjectEventListener = null;
        }
        SpenCustomObjectEventListener spenCustomObjectEventListener = this.mSpenCustomObjectEventListener;
        if (spenCustomObjectEventListener != null) {
            spenCustomObjectEventListener.release();
            this.mSpenCustomObjectEventListener = null;
        }
    }

    public void releaseHistoryEventListener(HistoryEventListenerImpl.UndoRedoListener undoRedoListener) {
        if (this.mInitialized) {
            this.mHistoryEventListener.releaseHistoryEventListener(undoRedoListener);
        }
    }

    public void releaseSpenComposerViewListener(ListenerImplContract.IView iView) {
        ListenerImplContract.IViewListenerManager listenerManager = iView.getListenerManager();
        listenerManager.setCursorChangedListener(null);
        listenerManager.setPageActionListener(null);
        listenerManager.setSoftInputListener(null);
        listenerManager.setThumbnailChangedListener(null);
        listenerManager.setContextMenuListener(null);
        listenerManager.setActionListener(null);
        listenerManager.setDialogActionListener(null);
        listenerManager.setObjectSelectListener(null);
        listenerManager.setSpenTextManagerActionListener(null);
        listenerManager.setControlObjectListener(null);
        listenerManager.setObjectSpanControlObjectListener(null);
        listenerManager.setSpenConvertToTextListener(null);
        listenerManager.setSpenAlignmentListener(null);
        listenerManager.setSpenSTTListener(null);
        listenerManager.setOnDragListener(null);
        listenerManager.setSpenAnalyticsListener(null);
        listenerManager.setOnFocusChangeListener(null);
        listenerManager.setOnKeyListener(null);
        listenerManager.setNoteZoomScrollerListener(null);
        listenerManager.setPageLayoutListener(null);
        listenerManager.setStrokeShapeListener(null);
        listenerManager.setTextEventListener(null);
        listenerManager.setNoteWritingToastListener(null);
        removePreTouchListener(this.mDefaultPreTouchListenerImpl);
        listenerManager.setPreTouchListener(null);
        listenerManager.setContextMenuDelegateListener(null);
        listenerManager.setSpenSelectionChangeListener(null);
        releasePreCommitTextFunc();
    }

    public void removeCustomObjectEventListener(SpenWNote.CustomObjectEventListener customObjectEventListener) {
        if (this.mInitialized) {
            this.mSpenCustomObjectEventListener.removeListener(customObjectEventListener);
        }
    }

    public void removeFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.mInitialized) {
            this.mOnFocusChangeListener.removeListener(onFocusChangeListener);
        }
    }

    public void removeHistoryEventBridgeListener(HistoryEventListenerImpl.HistoryEventBridgeListener historyEventBridgeListener) {
        if (this.mInitialized) {
            this.mHistoryEventListener.removeBridgeListener(historyEventBridgeListener);
        }
    }

    public void removeKeyListener(View.OnKeyListener onKeyListener) {
        if (this.mInitialized) {
            this.mOnKeyListener.removeListener(onKeyListener);
        }
    }

    public void removeNoteZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener) {
        if (isInvalidWithView()) {
            return;
        }
        this.mNoteZoomScrollerListenerManager.removeZoomScrollerListener(spenNoteZoomScrollerListener);
        if (this.mNoteZoomScrollerListenerManager.isEnable() || this.mViewGetter.getView() == null) {
            return;
        }
        this.mViewGetter.getView().getListenerManager().setNoteZoomScrollerListener(null);
    }

    public void removePreTouchListener(SpenPreTouchListenerImpl.PreTouchListener preTouchListener) {
        if (isInvalidWithView()) {
            return;
        }
        this.mSpenPreTouchListener.removePreTouchListener(preTouchListener);
        if (this.mSpenPreTouchListener.isEnable() || this.mViewGetter.getView() == null) {
            return;
        }
        this.mViewGetter.getView().getListenerManager().setPreTouchListener(null);
    }

    public void removeSpenControlObjectListener(SpenControlObjectListener spenControlObjectListener) {
        if (this.mInitialized) {
            this.mControlObjectListener.removeListener(spenControlObjectListener);
        }
    }

    public void removeSpenObjectEventListener(SpenWNote.ObjectEventListener objectEventListener) {
        if (this.mInitialized) {
            this.mSpenObjectEventListener.removeSpenObjectEventListener(objectEventListener);
            if (this.mSpenObjectEventListener.isEnable()) {
                return;
            }
            this.mPresenter.getDoc().deregisterObjectEventListener(this.mSpenObjectEventListener);
        }
    }

    public void removeSpenObjectSelectListener(SpenObjectSelectListener spenObjectSelectListener) {
        if (this.mInitialized) {
            this.mObjectSelectListener.removeBridgeListener(spenObjectSelectListener);
        }
    }

    public void removeSpenSTTListener(SPenSTTListener sPenSTTListener) {
        if (this.mInitialized) {
            this.mSpenSTTListenerImpl.removeBridgeListener(sPenSTTListener);
        }
    }

    public void removeSpenSelectionChangeListener(SpenSelectionChangeListener spenSelectionChangeListener) {
        if (this.mInitialized) {
            this.mSpenSelectionChangeListener.removeBridgeListener(spenSelectionChangeListener);
        }
    }

    public void removeVoiceDataEventListener(SpenWNote.VoiceDataEventListener voiceDataEventListener) {
        if (this.mInitialized) {
            this.mSpenVoiceDataEventListenerImpl.removeVoiceDataListener(voiceDataEventListener);
        }
    }

    public void removeZoomListener(SpenZoomListenerImpl.ZoomListener zoomListener) {
        if (isInvalidWithView()) {
            return;
        }
        this.mSpenZoomListener.removeZoomListener(zoomListener);
        if (this.mSpenZoomListener.isEnable() || this.mViewGetter.getView() == null) {
            return;
        }
        this.mViewGetter.getView().getListenerManager().setZoomListener(null);
    }

    public void setBlockDefaultPreTouch(boolean z) {
        DefaultPreTouchListenerImpl defaultPreTouchListenerImpl = this.mDefaultPreTouchListenerImpl;
        if (defaultPreTouchListenerImpl != null) {
            defaultPreTouchListenerImpl.setBlockDefaultPreTouch(z);
        }
    }

    public void setContextMenuManager(ContextMenuContract contextMenuContract) {
        if (this.mInitialized) {
            this.mContextMenuListener.setContextMenuManager(contextMenuContract);
        }
    }

    public void setCursorChangedListener(SpenCursorChangedListener spenCursorChangedListener) {
        CursorChangedListenerImpl cursorChangedListenerImpl = this.mCursorChangedListener;
        if (cursorChangedListenerImpl != null) {
            cursorChangedListenerImpl.setCursorChangedListener(spenCursorChangedListener);
        }
    }

    public void setOnBeforeTextChangedByKeyboardListener(SpenTextManagerActionListenerImpl.OnBeforeTextChangedByKeyboardListener onBeforeTextChangedByKeyboardListener) {
        if (this.mInitialized) {
            this.mSpenTextManagerActionListener.setOnBeforeTextChangedByKeyboardListener(onBeforeTextChangedByKeyboardListener);
        }
    }

    public void setOnCommitListener(HistoryEventListenerImpl.OnCommitListener onCommitListener) {
        if (this.mInitialized) {
            this.mHistoryEventListener.setOnCommitListener(onCommitListener);
        }
    }

    public void setShortcutManager(ListenerImplContract.IShortCutManager iShortCutManager) {
        if (this.mInitialized) {
            removePreTouchListener(iShortCutManager);
            addPreTouchListener(iShortCutManager);
            removeKeyListener(iShortCutManager);
            addKeyListener(iShortCutManager);
            this.mSoftInputListener.setOnKeyListener(iShortCutManager);
        }
    }

    public void setSpenContextMenuDelegateListener(SpenContextMenuDelegateListener spenContextMenuDelegateListener) {
        if (isInvalidWithView() || this.mViewGetter.getView() == null) {
            return;
        }
        this.mViewGetter.getView().getListenerManager().setContextMenuDelegateListener(spenContextMenuDelegateListener);
    }

    public void setSpenGestureControllerListener(SpenGestureControllerImpl spenGestureControllerImpl) {
        if (isInvalidWithView() || this.mViewGetter.getView() == null) {
            return;
        }
        this.mViewGetter.getView().getListenerManager().setSpenGestureControllerListener(spenGestureControllerImpl);
    }

    public void setTextSelectionChangedListener(CursorChangedListenerImpl.TextSelectionChangedListener textSelectionChangedListener) {
        CursorChangedListenerImpl cursorChangedListenerImpl = this.mCursorChangedListener;
        if (cursorChangedListenerImpl != null) {
            cursorChangedListenerImpl.setTextSelectionChangedListener(textSelectionChangedListener);
        }
    }
}
