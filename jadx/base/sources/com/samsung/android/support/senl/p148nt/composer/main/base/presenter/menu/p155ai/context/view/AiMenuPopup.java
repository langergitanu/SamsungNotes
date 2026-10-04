package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerSpenDocModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.PageSizeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiMenuResultManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatTypePopupWindow;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.DrawingAssistTypePopupWindow;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.AnchorPosition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuPopup {
    private static final String TAG = Logger.createTag("AiMenuPopup", AiConstants.PREFIX_TAG);
    private final AiContextMenuPresenter mAiContextMenuPresenter;
    private final AnchorOnLayoutChangeListener mAnchorOnLayoutChangeListener = new AnchorOnLayoutChangeListener(this, 0);
    private AutoFormatTypePopupWindow mAutoFormatTypePopupWindow;
    private final ComposerViewPresenter mComposerViewPresenter;
    private DrawingAssistTypePopupWindow mDrawingAssistTypePopupWindow;
    private PopupWindow mPopupWindow;
    private View mSummarizeButton;
    private final ViewContract mViewContract;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiMenuPopup$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C93534 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$widget$view$AnchorPosition */
        static final /* synthetic */ int[] f6827xd4bf1828;

        static {
            int[] iArr = new int[AnchorPosition.values().length];
            f6827xd4bf1828 = iArr;
            try {
                iArr[AnchorPosition.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6827xd4bf1828[AnchorPosition.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6827xd4bf1828[AnchorPosition.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6827xd4bf1828[AnchorPosition.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6827xd4bf1828[AnchorPosition.FLOATING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6827xd4bf1828[AnchorPosition.FLOATING_ROTATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AnchorOnLayoutChangeListener implements View.OnLayoutChangeListener {
        WeakReference<View> mLayoutAnchorView;
        WeakReference<View> mMenuAnchorView;

        public /* synthetic */ AnchorOnLayoutChangeListener(AiMenuPopup aiMenuPopup, int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLayoutChange$0(View view) {
            if (view.isAttachedToWindow()) {
                if (!AiMenuPopup.this.mPopupWindow.isShowing()) {
                    view = AiMenuPopup.this.mAnchorOnLayoutChangeListener.mMenuAnchorView.get();
                }
                AiMenuPopup.this.showAutoFormatTypeListWindow(view);
                AiMenuPopup.this.mPopupWindow.dismiss();
            }
        }

        public void clear() {
            WeakReference<View> weakReference = this.mLayoutAnchorView;
            if (weakReference != null) {
                View view = weakReference.get();
                if (view != null) {
                    view.removeOnLayoutChangeListener(this);
                }
                this.mLayoutAnchorView.clear();
                this.mLayoutAnchorView = null;
            }
            WeakReference<View> weakReference2 = this.mMenuAnchorView;
            if (weakReference2 != null) {
                weakReference2.clear();
                this.mMenuAnchorView = null;
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(final View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (i8 - i6 == i4 - i || AiMenuPopup.this.mAutoFormatTypePopupWindow == null || !AiMenuPopup.this.mAutoFormatTypePopupWindow.isShowing()) {
                return;
            }
            AiMenuPopup.this.mAutoFormatTypePopupWindow.hide();
            AiMenuPopup.this.mAiContextMenuPresenter.getHandler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6832a.lambda$onLayoutChange$0(view);
                }
            }, 500L);
        }

        public void setupListener(View view) {
            this.mMenuAnchorView = new WeakReference<>(view);
            View rootView = view.getRootView();
            rootView.addOnLayoutChangeListener(this);
            this.mLayoutAnchorView = new WeakReference<>(rootView);
        }

        private AnchorOnLayoutChangeListener() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ViewContract {
        View getCallerView();
    }

    public AiMenuPopup(ComposerViewPresenter composerViewPresenter, AiContextMenuPresenter aiContextMenuPresenter, ViewContract viewContract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mAiContextMenuPresenter = aiContextMenuPresenter;
        this.mViewContract = viewContract;
    }

    private boolean canStartForPdf(int i) {
        ComposerModel composerModel = this.mComposerViewPresenter.getComposerModel();
        ComposerSpenDocModel composerSpenDocModel = composerModel.getComposerSpenDocModel();
        if (!composerSpenDocModel.hasPdf(i)) {
            return false;
        }
        PdfManager pdfManager = this.mComposerViewPresenter.getPdfManager();
        if (pdfManager.hasSelectedText()) {
            return true;
        }
        if ((this.mComposerViewPresenter.getTextManager().isSelected() && this.mComposerViewPresenter.getObjectManager().isSelectedBodyText()) || composerSpenDocModel.hasStrokeInSelected()) {
            return false;
        }
        if (composerModel.isSingleMode()) {
            return pdfManager.hasPdfOnScreen();
        }
        return true;
    }

    private AnchorPosition getAnchor(View view) {
        Rect rect = new Rect();
        this.mComposerViewPresenter.getView().getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        if (rect2.top < rect.top) {
            return AnchorPosition.TOP;
        }
        if (rect2.bottom > rect.bottom) {
            return AnchorPosition.BOTTOM;
        }
        if (rect2.left < rect.left) {
            return AnchorPosition.LEFT;
        }
        if (rect2.right > rect.right) {
            return AnchorPosition.RIGHT;
        }
        return null;
    }

    private int getHorizontalOffsetFromAnchor(View view) {
        Rect rect = new Rect();
        view.getRootView().getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_popup_margin);
        return (rect.width() / 2) + rect.left < rect2.left ? (this.mPopupWindow.getContentView().getMeasuredWidth() + dimensionPixelSize) * (-1) : view.getWidth() + dimensionPixelSize;
    }

    private int getOffsetBaseOnHeight(View view) {
        return (view.getHeight() - this.mPopupWindow.getContentView().getMeasuredHeight()) / 2;
    }

    private int getOffsetBaseOnWidth(View view) {
        return (view.getWidth() - this.mPopupWindow.getContentView().getMeasuredWidth()) / 2;
    }

    private int getPageIndex() {
        int currentPageIndex = this.mComposerViewPresenter.getCurrentPageIndex();
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        if (doc == null) {
            return currentPageIndex;
        }
        RectF contentRectInView = this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller().getContentRectInView();
        ArrayList<Integer> pageIndexListByRect = this.mComposerViewPresenter.getObjectManager().getPageIndexListByRect(contentRectInView);
        int i = doc.getPageCount() <= 2 ? 1 : 2;
        if (pageIndexListByRect == null || pageIndexListByRect.size() <= i) {
            return currentPageIndex;
        }
        int iIntValue = pageIndexListByRect.get(0).intValue();
        RectF pageBound = PageSizeUtil.getPageBound(doc, iIntValue);
        float f = (pageBound.top + pageBound.bottom) / 2.0f;
        pageBound.top = f;
        return contentRectInView.top > f ? pageIndexListByRect.get(1).intValue() : iIntValue;
    }

    private int getVerticalOffsetFromAnchor(View view) {
        Rect rect = new Rect();
        view.getRootView().getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_popup_margin);
        return (rect.height() / 2) + rect.top < rect2.top ? (this.mPopupWindow.getContentView().getMeasuredHeight() + dimensionPixelSize) * (-1) : view.getHeight() + dimensionPixelSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAutoFormat$0(View view) {
        if (!canShowAutoFormat(true)) {
            showFailToast(view.getContext());
        } else {
            showAutoFormatTypeListWindow(this.mAnchorOnLayoutChangeListener.mMenuAnchorView.get());
            this.mPopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAutoFormatTypeListWindow$1(AutoFormat.FormatType formatType) {
        if (formatType.equals(AutoFormat.FormatType.Meeting)) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "b");
            showSelectionContextMenu(4);
        } else {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "a");
            showSelectionContextMenu(3);
        }
        hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDrawingAssistTypeListWindow$2(View view, DrawingAssistTypePopupWindow.StudioType studioType) {
        if (studioType.equals(DrawingAssistTypePopupWindow.StudioType.Image)) {
            onCreateImageClick(view);
        } else {
            this.mAiContextMenuPresenter.startCreativeStudio(studioType);
        }
        hide();
    }

    @SuppressLint({"InflateParams"})
    private void setup(Context context) {
        final View viewInflate = LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_context_style_layout, (ViewGroup) null, false);
        if (AiViewUtils.isAtLeastOneUI85()) {
            viewInflate.findViewById(C9086R.id.ai_context_layout).setBackgroundResource(C9086R.drawable.ai_menu_toolbar_bg_oneui_85);
        }
        setupAutoFormat(viewInflate);
        setupSummarize(viewInflate);
        setupSpellingCorrection(viewInflate);
        setupTranslate(viewInflate);
        setupCreateImage(viewInflate);
        setupTranscribe(viewInflate);
        if (Build.VERSION.SDK_INT < 33 || !AiViewUtils.isAtLeastOneUI7()) {
            PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
            this.mPopupWindow = popupWindow;
            OptionMenuPopupWindowHelper.setDefaultState(popupWindow, context);
        } else {
            this.mPopupWindow = OptionMenuPopupWindowHelper.getPopupWindowNewStyleLayout(context, (ViewGroup) viewInflate, this.mComposerViewPresenter.getHandler());
        }
        viewInflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiMenuPopup.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                viewInflate.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                viewInflate.requestFocus();
            }
        });
    }

    private void setupAutoFormat(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_btn_autoformat);
        if (!canShowAutoFormat(true)) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC9368a(this, 3));
        }
    }

    private void setupCreateImage(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_btn_create_image);
        if (!canShowCreateImage()) {
            viewFindViewById.setVisibility(8);
            return;
        }
        ((TextView) viewFindViewById.findViewById(C9086R.id.ai_menu_btn_create_image_name)).setText(getCreateImageStringRes());
        viewFindViewById.setVisibility(0);
        if (Features.isCreativeStudioSupported()) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiMenuPopup.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AiMenuPopup aiMenuPopup = AiMenuPopup.this;
                    aiMenuPopup.showDrawingAssistTypeListWindow(aiMenuPopup.mAnchorOnLayoutChangeListener.mMenuAnchorView.get());
                    AiMenuPopup.this.mPopupWindow.dismiss();
                }
            });
        } else {
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC9368a(this, 5));
        }
    }

    private void setupSpellingCorrection(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_btn_spelling_correction);
        if (!canShowSpellingCorrection(true)) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC9368a(this, 2));
        }
    }

    private void setupSummarize(View view) {
        this.mSummarizeButton = view.findViewById(C9086R.id.ai_menu_btn_summarize);
        if (!canShowSummarize()) {
            this.mSummarizeButton.setVisibility(8);
        } else {
            this.mSummarizeButton.setVisibility(0);
            this.mSummarizeButton.setOnClickListener(new ViewOnClickListenerC9368a(this, 1));
        }
    }

    private void setupTranscribe(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.ai_stt_transcribe_menu_btn);
        if (!canShowTranscribe()) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC9368a(this, 4));
        }
    }

    private void setupTranslate(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_btn_translate);
        if (!canShowTranslate()) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC9368a(this, 0));
        }
    }

    private void showPopup(View view, AnchorPosition anchorPosition) {
        switch (C93534.f6827xd4bf1828[anchorPosition.ordinal()]) {
            case 1:
                this.mPopupWindow.setAnimationStyle(C9086R.style.RtPopupBottomEnterExitAnimation);
                this.mPopupWindow.showAsDropDown(view, getOffsetBaseOnWidth(view), getVerticalOffsetFromAnchor(view));
                break;
            case 2:
                this.mPopupWindow.setAnimationStyle(C9086R.style.RtPopupTopEnterExitAnimation);
                this.mPopupWindow.showAsDropDown(view, getOffsetBaseOnWidth(view), getVerticalOffsetFromAnchor(view));
                break;
            case 3:
                this.mPopupWindow.setAnimationStyle(C9086R.style.AIPopupLeftEnterExitAnimation);
                this.mPopupWindow.showAsDropDown(view, getHorizontalOffsetFromAnchor(view), getOffsetBaseOnHeight(view));
                break;
            case 4:
                this.mPopupWindow.setAnimationStyle(C9086R.style.AIPopupRightEnterExitAnimation);
                this.mPopupWindow.showAsDropDown(view, getHorizontalOffsetFromAnchor(view), getOffsetBaseOnHeight(view));
                break;
            case 5:
                if (getVerticalOffsetFromAnchor(view) >= 0) {
                    showPopup(view, AnchorPosition.TOP);
                } else {
                    showPopup(view, AnchorPosition.BOTTOM);
                }
                break;
            case 6:
                if (getHorizontalOffsetFromAnchor(view) >= 0) {
                    showPopup(view, AnchorPosition.LEFT);
                } else {
                    showPopup(view, AnchorPosition.RIGHT);
                }
                break;
        }
    }

    private void showSelectionContextMenu(int i) {
        Logger.addFileLog(TAG, "AiMenu:" + i, 0);
        showSelectionContextMenu(new AiBixbyParam(i, 5));
    }

    private void updateMenuWidth() {
        if (this.mSummarizeButton.isLaidOut()) {
            updateContainerWidth();
        } else {
            this.mSummarizeButton.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiMenuPopup.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (AiMenuPopup.this.mSummarizeButton.getMeasuredWidth() > 0) {
                        AiMenuPopup.this.mSummarizeButton.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AiMenuPopup.this.updateContainerWidth();
                    }
                }
            });
        }
    }

    private void wakeUpTranslationService() {
        new LanguageIdentifier().identifyLanguageAsync("To wake-up TranslationService", null);
    }

    public boolean canShowAiContextMenu() {
        return canShowAutoFormat(false) || canShowSummarize() || canShowSpellingCorrection(false) || canShowTranslate() || canShowCreateImage() || canShowTranscribe();
    }

    public boolean canShowAutoFormat(boolean z) {
        return (z && canStartForPdf(getPageIndex())) ? false : true;
    }

    public boolean canShowCreateImage() {
        if (!FeatureInfo.isCreateImageEnabled()) {
            return false;
        }
        ComposerModel composerModel = this.mComposerViewPresenter.getComposerModel();
        if (composerModel.isPDFReader() || composerModel.getCoeditAdapter().isCoeditNote() || composerModel.getMdeInfo().isMde()) {
            return false;
        }
        return AiDrawingUtil.hasSupportedObjectsInScreen(this.mComposerViewPresenter.getDoc(), this.mComposerViewPresenter.getObjectManager()) || Features.isCreativeStudioSupported();
    }

    public boolean canShowSpellingCorrection(boolean z) {
        if (!z) {
            return true;
        }
        int pageIndex = getPageIndex();
        return !canStartForPdf(pageIndex) && this.mAiContextMenuPresenter.canUseSpellingCollection(pageIndex);
    }

    public boolean canShowSummarize() {
        return true;
    }

    public boolean canShowTranscribe() {
        return this.mAiContextMenuPresenter.canShowSTTTranscribeMenu();
    }

    public boolean canShowTranslate() {
        return FeatureInfo.isSupportNeuralTranslationFunction();
    }

    @StringRes
    public int getCreateImageStringRes() {
        return AiDrawingUtil.isDrawingToolkitUsed() ? Features.isCreativeStudioSupported() ? C9086R.string.ai_creative_studio : C9086R.string.ai_drawing_assist : C9086R.string.ai_drawing_sketch_to_image_name;
    }

    public void hide() {
        AutoFormatTypePopupWindow autoFormatTypePopupWindow = this.mAutoFormatTypePopupWindow;
        if (autoFormatTypePopupWindow != null) {
            autoFormatTypePopupWindow.hide();
            this.mAutoFormatTypePopupWindow = null;
        }
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.mPopupWindow = null;
        }
        this.mAnchorOnLayoutChangeListener.clear();
    }

    public void onCreateImageClick(View view) {
        if (!canShowCreateImage()) {
            showFailToast(view.getContext());
            return;
        }
        ModeManager modeManager = this.mComposerViewPresenter.getComposerModel().getModeManager();
        String screenID = ComposerSA.getScreenID(modeManager.isEditMode(), modeManager.isMode(Mode.Writing), ResourceUtils.isTabletLayout(view.getContext()));
        ComposerSA.insertLog(screenID, ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "f");
        ComposerSA.insertLog(screenID, ComposerSAConstants.EVENT_AI_DRAWING);
        this.mAiContextMenuPresenter.startCreateImage();
        hide();
    }

    public void onSpellingCorrectionClick(View view) {
        if (!canShowSpellingCorrection(true)) {
            showFailToast(view.getContext());
            return;
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "d");
        showSelectionContextMenu(5);
        hide();
    }

    public void onSummarizeClick(View view) {
        if (!canShowSummarize()) {
            showFailToast(view.getContext());
            return;
        }
        if (this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
            ComposerSA.insertLog(this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode() ? ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT : ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_AI_SUMMARIZE);
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "c");
        showSelectionContextMenu(2);
        hide();
    }

    public void onTranscribeClick(View view) {
        if (!canShowTranscribe()) {
            showFailToast(view.getContext());
            return;
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "g");
        this.mAiContextMenuPresenter.executeTranscribe();
        hide();
    }

    public void onTranslateClick(View view) {
        if (!canShowTranslate()) {
            showFailToast(view.getContext());
            return;
        }
        if (!this.mAiContextMenuPresenter.canUseOverlayPdfWithCurrentPage()) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "e");
            if (this.mAiContextMenuPresenter.isTranslated()) {
                this.mAiContextMenuPresenter.releaseTranslateWithOverlay(false);
            }
            showSelectionContextMenu(1);
            hide();
            return;
        }
        hide();
        AiMenuResultManager aiMenuResultManager = this.mAiContextMenuPresenter.getAiMenuResultManager();
        if (aiMenuResultManager.isShowingResultView()) {
            aiMenuResultManager.hideResultView(false, new boolean[0]);
        }
        ComposerModel composerModel = this.mComposerViewPresenter.getComposerModel();
        if (composerModel.isPDFReader()) {
            ComposerSA.insertLog(composerModel.getModeManager().isEditMode() ? ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT : ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_AI_TRANSLATE);
        }
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "k");
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        Objects.requireNonNull(aiContextMenuPresenter);
        aiContextMenuPresenter.executeTranslateWithOverlay(false, null, new RunnableC8669a(aiContextMenuPresenter, 27));
    }

    public void show(View view, AnchorPosition anchorPosition) {
        hide();
        setup(view.getContext());
        updateMenuWidth();
        this.mPopupWindow.getContentView().measure(0, 0);
        if (anchorPosition == null) {
            anchorPosition = getAnchor(view);
        }
        if (anchorPosition == null) {
            Logger.m11000e(TAG, "not found anchor position");
            return;
        }
        showPopup(view, anchorPosition);
        this.mAnchorOnLayoutChangeListener.setupListener(view);
        wakeUpTranslationService();
    }

    public void showAutoFormatTypeListWindow(View view) {
        AutoFormatTypePopupWindow autoFormatTypePopupWindow = new AutoFormatTypePopupWindow(this.mComposerViewPresenter.getHandler());
        this.mAutoFormatTypePopupWindow = autoFormatTypePopupWindow;
        autoFormatTypePopupWindow.initAutoFormatTypePopupWindow(view.getContext(), new C8886c(this, 6));
        this.mAutoFormatTypePopupWindow.show(view);
    }

    public void showDrawingAssistTypeListWindow(final View view) {
        DrawingAssistTypePopupWindow drawingAssistTypePopupWindow = new DrawingAssistTypePopupWindow(this.mComposerViewPresenter.getHandler());
        this.mDrawingAssistTypePopupWindow = drawingAssistTypePopupWindow;
        drawingAssistTypePopupWindow.initDrawingAssistTypePopupWindow(view.getContext(), AiDrawingUtil.hasSupportedObjectsInScreen(this.mComposerViewPresenter.getDoc(), this.mComposerViewPresenter.getObjectManager()), new DrawingAssistTypePopupWindow.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.b
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.DrawingAssistTypePopupWindow.OnItemClickListener
            public final void onItemClick(DrawingAssistTypePopupWindow.StudioType studioType) {
                this.f6830a.lambda$showDrawingAssistTypeListWindow$2(view, studioType);
            }
        });
        this.mDrawingAssistTypePopupWindow.show(view);
    }

    public void showFailToast(Context context) {
        ToastHandler.show(context, context.getString(C9086R.string.cant_use_this_feature_on_this_page), 0);
    }

    public void updateContainerWidth() {
        ViewGroup viewGroup = (ViewGroup) this.mPopupWindow.getContentView().findViewById(C9086R.id.ai_context_inner_container);
        int childCount = viewGroup.getChildCount();
        int iMax = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = viewGroup.getChildAt(i2);
            if (childAt2.getVisibility() == 0 && childAt2.getMeasuredWidth() < iMax) {
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.width = iMax;
                childAt2.setLayoutParams(layoutParams);
            }
        }
    }

    private void showSelectionContextMenu(AiBixbyParam aiBixbyParam) {
        this.mAiContextMenuPresenter.show(false, aiBixbyParam, getPageIndex(), this.mViewContract.getCallerView(), false);
    }
}
