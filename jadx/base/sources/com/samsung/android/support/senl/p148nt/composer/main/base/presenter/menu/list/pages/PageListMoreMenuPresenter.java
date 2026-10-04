package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipDataBackupPath;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.HistoryEventListenerAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share.ExportPagesMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCopyPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCutPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDeletePages;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.DynamicTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ImageTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.PdfTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListMoreMenuPresenter implements MoreMenuListPopup.OnMoreMenuEventListener {
    private static final String TAG = Logger.createTag("PageListMoreMenuPresenter");
    private int mAddPageIndex;
    private SpenBodyTextContext mBodyTextContext;
    private final ClipboardController mClipboardController;
    private final ComposerViewPresenter mCompViewPresenter;
    private final PageListComposerModeHelper mComposerModeHelper;
    private final ComposerModel mComposerModel;
    private final Contract mContract;
    private HistoryEventListenerImpl mHistoryEventListenerImpl;
    private float mImageRatio;
    private final OptionMenuPresenter mOptionMenuPresenter;
    private final PageListDataManager mPageListDataManager;
    private boolean mSkipToShowSipForSearch;
    private final SoftInputManager mSoftInputManager;
    private final TaskController mTaskController;
    private final BOOLEAN mIsMeasuredBodyText = new BOOLEAN(false);
    private final SharePagesMenu mSharePagesMenu = new SharePagesMenu(null);
    private final ExportPagesMenu mExportPagesMenu = new ExportPagesMenu(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void clearPageFocus();

        View getPageSearchEditView();

        void hideStickyMemo();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HistoryEventListenerImpl extends HistoryEventListenerAdapter {
        private final BOOLEAN mIsMeasuredBodyText;

        public HistoryEventListenerImpl(BOOLEAN r12) {
            this.mIsMeasuredBodyText = r12;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.HistoryEventListenerAdapter, com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
        public void onPreSubmit(SpenWNote spenWNote, SpenObjectBase spenObjectBase, int i, int i2, int i4) {
            this.mIsMeasuredBodyText.setValue(false);
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.HistoryEventListenerAdapter, com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
        public void onRedo(SpenWNote spenWNote) {
            this.mIsMeasuredBodyText.setValue(false);
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.HistoryEventListenerAdapter, com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
        public void onUndo(SpenWNote spenWNote) {
            this.mIsMeasuredBodyText.setValue(false);
        }
    }

    public PageListMoreMenuPresenter(Contract contract, PageListDataManager pageListDataManager, ComposerModel composerModel, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, PageListComposerModeHelper pageListComposerModeHelper, OptionMenuPresenter optionMenuPresenter) {
        this.mContract = contract;
        this.mPageListDataManager = pageListDataManager;
        this.mComposerModel = composerModel;
        this.mCompViewPresenter = composerViewPresenter;
        this.mTaskController = controllerManager.getTaskController();
        this.mClipboardController = controllerManager.getClipboardController();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mComposerModeHelper = pageListComposerModeHelper;
        this.mOptionMenuPresenter = optionMenuPresenter;
    }

    private void addClearMenu(ArrayList<Integer> arrayList, String str) {
        int pageIndex = this.mPageListDataManager.getPageIndex(str);
        if (pageIndex < 0) {
            Logger.m11000e(TAG, "addClearMenu#, invalid index : " + pageIndex);
            return;
        }
        String str2 = TAG;
        Logger.m10999d(str2, "addClearMenu#, pageId / index : " + str + " / " + pageIndex);
        RectF measuredFitRect = getMeasuredFitRect(pageIndex);
        if (measuredFitRect == null) {
            Logger.m10999d(str2, "addClearMenu# rect is null");
        } else {
            if (this.mCompViewPresenter.getNoteManager().isObjectEmpty(pageIndex) && measuredFitRect.isEmpty()) {
                return;
            }
            arrayList.add(5);
        }
    }

    private boolean beginHistoryGroup() {
        if (this.mCompViewPresenter.getNoteManager().getNote().isGroupingHistory()) {
            return false;
        }
        this.mCompViewPresenter.getNoteManager().getNote().beginHistoryGroup();
        return true;
    }

    private void deregisterHistoryEventListener() {
        if (this.mHistoryEventListenerImpl == null || this.mCompViewPresenter.getDoc() == null) {
            return;
        }
        this.mCompViewPresenter.getDoc().deregisterHistoryEventListener(this.mHistoryEventListenerImpl);
        this.mHistoryEventListenerImpl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDeletePostAction(TaskDeletePages.ResultValues resultValues) {
        if (this.mCompViewPresenter.getNoteManager().getNote().getPageCount() == 1) {
            this.mComposerModel.getComposerSaveModel().setAllPageDeleted(true);
            this.mCompViewPresenter.getNoteManager().insertPage(0);
        }
        if (resultValues.isNeededToCallEndHistory()) {
            this.mCompViewPresenter.getNoteManager().getNote().endHistoryGroup();
        }
    }

    private RectF getMeasuredFitRect(int i) {
        if (this.mBodyTextContext == null) {
            return null;
        }
        if (this.mIsMeasuredBodyText.isFalse()) {
            this.mBodyTextContext.measureText();
            this.mIsMeasuredBodyText.setValue(true);
        }
        return this.mBodyTextContext.getMeasuredFitRect(i);
    }

    private ArrayList<PageCopyData> getSelectedPageDataList(String str) {
        ArrayList<PageCopyData> arrayList = new ArrayList<>();
        int pageIndex = this.mPageListDataManager.getPageIndex(str);
        AbstractC8014b.m7217s(pageIndex, "getSelectedPageDataList# ", TAG);
        if (pageIndex < 0) {
            return arrayList;
        }
        arrayList.add(new PageCopyData(pageIndex, this.mPageListDataManager.isBookmarked(str)));
        return arrayList;
    }

    private void hideSearchSoftInput() {
        View pageSearchEditView = this.mContract.getPageSearchEditView();
        if (pageSearchEditView == null || !pageSearchEditView.hasFocus()) {
            return;
        }
        this.mSoftInputManager.hide(pageSearchEditView);
    }

    private void insertTemplatePage() {
        int height;
        Logger.addFileLog(TAG, "insertTemplatePage", 0);
        int iPreExecute = preExecute("insertTemplatePage");
        SpenWPage page = this.mComposerModel.getDoc().getPage(this.mAddPageIndex);
        if (page.getTemplateType() == 17) {
            int i = this.mAddPageIndex;
            updatePageIndex(iPreExecute, i, i);
            return;
        }
        if (page.hasPDF()) {
            int i2 = this.mAddPageIndex;
            updatePageIndex(iPreExecute, i2, i2);
            return;
        }
        int i4 = this.mAddPageIndex + 1;
        int pageDefaultWidth = this.mComposerModel.getDoc().getPageDefaultWidth();
        if (this.mComposerModel.getDoc().getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
            height = DocumentPageRatio.PageRatioType.A4_LANDSCAPE.getHeight(pageDefaultWidth);
        } else {
            float f = this.mImageRatio;
            height = f == 0.0f ? DocumentPageRatio.PageRatioType.A4_PORTRAIT.getHeight(pageDefaultWidth) : (int) (pageDefaultWidth * f);
        }
        this.mCompViewPresenter.getNoteManager().insertPage(i4, this.mAddPageIndex, pageDefaultWidth, height, null, null, 0, true);
        updatePageIndex(iPreExecute, this.mAddPageIndex, i4);
    }

    private boolean isAvailable() {
        if (isNotIdleWorkingState()) {
            return false;
        }
        return !this.mComposerModeHelper.checkNoServerPermission();
    }

    private boolean isAvailableShare() {
        return !this.mComposerModel.getNotesDocEntityManager().isLocked() || DeviceUtils.isSupportedFileProvider();
    }

    private boolean isNotIdleWorkingState() {
        ComposerModel composerModel = this.mComposerModel;
        boolean zIsIdleWorkingState = composerModel != null ? composerModel.getComposerSaveModel().isIdleWorkingState() : false;
        if (!zIsIdleWorkingState) {
            Logger.m10999d(TAG, "isIdleWorkingState# false");
        }
        return !zIsIdleWorkingState;
    }

    private boolean isTranslationOverlayActivated() {
        return this.mOptionMenuPresenter.isTranslationOverlayActivated();
    }

    private void loadTemplateResult(Intent intent) {
        int templateViewType = DocumentBackgroundUtils.getTemplateViewType();
        if (TemplateViewType.isCustomImageType(templateViewType)) {
            this.mImageRatio = intent.getFloatExtra(ChangeTemplateConstants.ARG_TEMPLATE_IMAGE_RATIO, DocumentPageRatio.PAGE_RATIO.getPageRatio());
        } else {
            this.mImageRatio = intent.getFloatExtra(ChangeTemplateConstants.ARG_TEMPLATE_NOTE_PAGE_RATIO, DocumentPageRatio.PageRatioType.A4_PORTRAIT.getPageRatio());
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(templateViewType, "loadTemplateResult# templateViewType:", ", mImageRatio:");
        sbM778t.append(this.mImageRatio);
        Logger.m11003i(str, sbM778t.toString());
    }

    private Intent setupIntentTemplateInfo(Intent intent) {
        DocumentPageRatio.PageRatioType pageRatioType;
        String strValueOf;
        Intent intent2 = new Intent();
        intent2.putExtra(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 2);
        SpenWPage page = this.mComposerModel.getDoc().getPage(this.mAddPageIndex);
        int pageDefaultWidth = this.mComposerModel.getDoc().getPageDefaultWidth();
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_WIDTH, pageDefaultWidth);
        if (this.mComposerModel.getDoc().getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
            pageRatioType = DocumentPageRatio.PageRatioType.A4_LANDSCAPE;
        } else {
            pageRatioType = DocumentPageRatio.PageRatioType.A4_PORTRAIT;
            SpenWPage page2 = this.mComposerModel.getDoc().getPage(this.mAddPageIndex);
            float height = page2.getHeight() / page2.getWidth();
            DocumentPageRatio.PageRatioType pageRatioType2 = DocumentPageRatio.PageRatioType.LONG;
            if (height >= pageRatioType2.getPageRatio()) {
                pageRatioType = pageRatioType2;
            }
        }
        int height2 = pageRatioType.getHeight(pageDefaultWidth);
        int templateType = page.getTemplateType();
        if (templateType == 12) {
            strValueOf = page.getTemplateURI();
            intent2.putExtra("template_type", 3);
            intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME, strValueOf);
        } else if (templateType == 16) {
            strValueOf = PdfTemplatePresenterUtil.getPdfTemplateNameFromPage(page);
            intent2.putExtra("template_type", PdfTemplatePresenterUtil.getTemplateTypeFromTemplateName(strValueOf, pageRatioType.getPageRatio()));
            intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME, strValueOf);
        } else if (templateType == 17) {
            strValueOf = "";
            intent2.putExtra("template_type", DynamicTemplatePresenterUtil.getTemplateTypeFromTemplateXml(""));
            intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME, "");
        } else {
            strValueOf = String.valueOf(templateType);
            intent2.putExtra("template_type", ImageTemplatePresenterUtil.getTemplateTypeFromTemplateName(strValueOf));
            intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME, strValueOf);
        }
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_IS_TWO_PAGE, false);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NOTE_PAGE_RATIO, pageRatioType.getPageRatio());
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_HEIGHT, height2);
        String str = TAG;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("setupIntentTemplateInfo# templateType:", templateType, ", templateName:", strValueOf, ", width:");
        sbM1629s.append(pageDefaultWidth);
        sbM1629s.append(", height:");
        sbM1629s.append(height2);
        Logger.m10999d(str, sbM1629s.toString());
        return intent2;
    }

    private void showShareTypePopupMenu(String str, View view) {
        ArrayList<PageCopyData> selectedPageDataList = getSelectedPageDataList(str);
        if (selectedPageDataList.isEmpty()) {
            return;
        }
        hideSearchSoftInput();
        this.mOptionMenuPresenter.getOptionMenuSharePresenter().setPageDataList(selectedPageDataList);
        this.mSharePagesMenu.showPopupMenu(this.mCompViewPresenter.getActivity(), this.mOptionMenuPresenter.getOptionMenuSharePresenter(), view);
    }

    public void clearBodyTextContext() {
        SpenBodyTextContext spenBodyTextContext = this.mBodyTextContext;
        if (spenBodyTextContext == null) {
            return;
        }
        spenBodyTextContext.close();
        this.mBodyTextContext = null;
        this.mIsMeasuredBodyText.setValue(false);
        deregisterHistoryEventListener();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void clearSelection() {
        this.mCompViewPresenter.getWritingToolManager().clearControl();
        this.mCompViewPresenter.getObjectManager().clearSelection();
    }

    public List<Integer> getMenuList(String str) {
        boolean z = this.mPageListDataManager.getPageManager().getPageCount() > 2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!this.mCompViewPresenter.getComponentFactory().getConfig().isOnlyDeletableInPageList()) {
            if (this.mPageListDataManager.isMode(2) || this.mPageListDataManager.isMode(3)) {
                arrayList.add(1);
                if (z) {
                    arrayList.add(4);
                }
            } else {
                arrayList.add(0);
                arrayList.add(1);
                if (ClipboardCacheManager.isPageData(ClipDataBackupPath.getBackupPathFromHtml(this.mClipboardController.getPrimaryClip()))) {
                    arrayList.add(3);
                }
                arrayList.add(2, 2);
                arrayList.add(4);
                addClearMenu(arrayList, str);
            }
            if (isAvailableShare()) {
                arrayList.add(6);
                arrayList.add(7);
            }
            if (this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
                arrayList.remove((Object) 1);
                arrayList.remove((Object) 2);
                arrayList.remove((Object) 3);
                if (this.mComposerModel.getModeManager().isDeleteOnlyMode()) {
                    arrayList.remove((Object) 0);
                }
                arrayList.remove((Object) 5);
            }
            int pageIndex = this.mPageListDataManager.getPageIndex(str);
            if (pageIndex < 0) {
                Logger.m11000e(TAG, "getMenuList#, invalid pageIndex : " + pageIndex);
            } else if (ObjectTypeUtil.hasMathType(this.mCompViewPresenter.getDoc().getPage(pageIndex).getObjectList())) {
                arrayList.remove((Object) 1);
                arrayList.remove((Object) 2);
            }
            if (this.mComposerModel.getComposerSpenDocModel().hasUnknownObject()) {
                Logger.m11004w(TAG, "getMenuList#, hasUnknownObject true");
                boolean zContains = arrayList.contains(0);
                boolean zContains2 = arrayList.contains(3);
                arrayList.clear();
                if (zContains) {
                    arrayList.add(0);
                }
                if (zContains2) {
                    arrayList.add(3);
                }
            }
            if (DynamicTemplateUtil.hasDynamicTemplatePage(Collections.singletonList(this.mComposerModel.getDoc().getPage(pageIndex)))) {
                arrayList.remove((Object) 1);
                arrayList.remove((Object) 2);
            }
        } else if (z) {
            arrayList.add(4);
            return arrayList;
        }
        return arrayList;
    }

    public void initBodyTextContext(Activity activity) {
        this.mIsMeasuredBodyText.setValue(false);
        this.mBodyTextContext = new SpenBodyTextContext(activity);
        SpenWNote doc = this.mCompViewPresenter.getDoc();
        this.mBodyTextContext.setDocument(doc);
        if (this.mHistoryEventListenerImpl == null) {
            this.mHistoryEventListenerImpl = new HistoryEventListenerImpl(this.mIsMeasuredBodyText);
        } else {
            Logger.m11000e(TAG, "initBodyTextContext# unexpected call");
        }
        doc.registerHistoryEventListener(this.mHistoryEventListenerImpl);
    }

    public void onActivityResult(int i, Intent intent) {
        Intent intent2;
        if (i == -1 && intent.hasExtra(ChangeTemplateConstants.ARG_NOTE_STYLE_RESULT) && (intent2 = (Intent) intent.getParcelableExtra(ChangeTemplateConstants.ARG_NOTE_STYLE_RESULT)) != null) {
            loadTemplateResult(intent2);
            this.mComposerModel.getDoc().beginHistoryGroup();
            insertTemplatePage();
            intent2.putExtra(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 2);
            this.mOptionMenuPresenter.updateTemplateResult(intent2);
            this.mComposerModel.getDoc().endHistoryGroup();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onAdd(String str) {
        if (isAvailable()) {
            int pageIndex = this.mPageListDataManager.getPageIndex(str);
            AbstractC0000a.m3D(pageIndex, "onAdd# ", TAG);
            if (pageIndex < 0) {
                return;
            }
            this.mAddPageIndex = pageIndex;
            startChangeTemplateActivity(this.mCompViewPresenter.getActivity());
            if (this.mComposerModel.isTabletLayout()) {
                ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_ADD_PAGE);
            } else {
                this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_MORE_OPTION_ADD);
            }
            this.mSkipToShowSipForSearch = true;
        }
    }

    public void onConfigurationChanged() {
        this.mSharePagesMenu.hidePopupMenu();
        this.mExportPagesMenu.hidePopupMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onCopy(Context context, String str) {
        if (isNotIdleWorkingState()) {
            return;
        }
        int pageIndex = this.mPageListDataManager.getPageIndex(str);
        AbstractC0000a.m3D(pageIndex, "onCopy# ", TAG);
        if (pageIndex < 0) {
            return;
        }
        if (this.mComposerModel.isTranslatedPDFNote()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return;
        }
        if (isTranslationOverlayActivated()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(5);
            return;
        }
        this.mTaskController.execute(new TaskCopyPage(), new TaskCopyPage.InputValues(context, this.mCompViewPresenter.getNoteManager(), this.mCompViewPresenter.getObjectManager(), new PageCopyData(pageIndex, this.mPageListDataManager.isBookmarked(str))), null, false);
        if (this.mPageListDataManager.isMode(2)) {
            this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_SEARCH_MODE_PAGE_MORE_OPTION_COPY);
        } else if (this.mComposerModel.isTabletLayout()) {
            ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_COPY);
        } else {
            this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_MORE_OPTION_COPY);
        }
        this.mSkipToShowSipForSearch = true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onCut(Context context, String str) {
        if (isAvailable()) {
            int pageIndex = this.mPageListDataManager.getPageIndex(str);
            String str2 = TAG;
            AbstractC0000a.m3D(pageIndex, "onCut# ", str2);
            if (pageIndex < 0) {
                return;
            }
            if (this.mComposerModel.isTranslatedPDFNote()) {
                this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
                return;
            }
            if (isTranslationOverlayActivated()) {
                this.mCompViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(4);
                return;
            }
            Logger.addFileLog(str2, "PageCut", 0);
            preExecute("onCut");
            this.mTaskController.execute(new TaskCutPage(), new TaskCutPage.InputValues(context, this.mCompViewPresenter.getNoteManager(), this.mCompViewPresenter.getObjectManager(), new PageCopyData(pageIndex, this.mPageListDataManager.isBookmarked(str)), beginHistoryGroup()), new Task.Callback<TaskDeletePages.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListMoreMenuPresenter.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskDeletePages.ResultValues resultValues) {
                    Logger.m10999d(PageListMoreMenuPresenter.TAG, "onCutClicked#onError");
                    PageListMoreMenuPresenter.this.doDeletePostAction(resultValues);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskDeletePages.ResultValues resultValues) {
                    Logger.m10999d(PageListMoreMenuPresenter.TAG, "onCutClicked#onSuccess");
                    PageListMoreMenuPresenter.this.doDeletePostAction(resultValues);
                }
            }, false);
            if (this.mComposerModel.isTabletLayout()) {
                ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_CUT);
            } else {
                this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_MORE_OPTION_CUT);
            }
            this.mSkipToShowSipForSearch = true;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onDelete(Context context, String str) {
        if (isAvailable()) {
            int pageIndex = this.mPageListDataManager.getPageIndex(str);
            String str2 = TAG;
            AbstractC0000a.m3D(pageIndex, "onDelete# ", str2);
            if (pageIndex < 0) {
                return;
            }
            Logger.addFileLog(str2, "PageDelete", 0);
            preExecute("onDelete");
            this.mCompViewPresenter.getNoteManager().getNote().beginHistoryGroup();
            this.mCompViewPresenter.getNoteManager().deletePage(pageIndex);
            if (this.mCompViewPresenter.getNoteManager().getNote().getPageCount() == 1) {
                this.mComposerModel.getComposerSaveModel().setAllPageDeleted(true);
                this.mCompViewPresenter.getNoteManager().insertPage(0);
            }
            this.mCompViewPresenter.getNoteManager().getNote().endHistoryGroup();
            if (this.mPageListDataManager.isMode(2)) {
                this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_SEARCH_MODE_PAGE_MORE_OPTION_DELETE);
            } else if (this.mComposerModel.isTabletLayout()) {
                ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_DELETE);
            } else {
                this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_MORE_OPTION_DELETE);
            }
            this.mSkipToShowSipForSearch = true;
        }
    }

    public void onDestroy() {
        deregisterHistoryEventListener();
    }

    public void onDetachView() {
        this.mSharePagesMenu.hidePopupMenu();
        this.mExportPagesMenu.hidePopupMenu();
        clearBodyTextContext();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onDismiss() {
        if (this.mSkipToShowSipForSearch) {
            this.mSkipToShowSipForSearch = false;
            return;
        }
        View pageSearchEditView = this.mContract.getPageSearchEditView();
        if (pageSearchEditView == null || !pageSearchEditView.hasFocus()) {
            return;
        }
        this.mSoftInputManager.show(pageSearchEditView);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onErasePage(Context context, String str) {
        if (isAvailable()) {
            int pageIndex = this.mPageListDataManager.getPageIndex(str);
            String str2 = TAG;
            AbstractC0000a.m3D(pageIndex, "onErasePage# ", str2);
            if (pageIndex < 0) {
                return;
            }
            Logger.addFileLog(str2, "PageErase", 0);
            preExecute("onErasePage");
            this.mCompViewPresenter.getNoteManager().clearPage(pageIndex, this.mCompViewPresenter.getObjectManager().getSelectedObjectPageList());
            if (this.mComposerModel.isTabletLayout()) {
                ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_CLEAR_PAGE);
            } else {
                this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_MORE_OPTION_ERASE);
            }
            this.mSkipToShowSipForSearch = true;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onExport(Context context, String str, View view) {
        if (isNotIdleWorkingState()) {
            return;
        }
        ArrayList<PageCopyData> selectedPageDataList = getSelectedPageDataList(str);
        if (selectedPageDataList.isEmpty()) {
            return;
        }
        if (this.mComposerModel.isTranslatedPDFNote()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return;
        }
        if (isTranslationOverlayActivated()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(0);
            return;
        }
        hideSearchSoftInput();
        this.mOptionMenuPresenter.getOptionMenuSharePresenter().setPageDataList(selectedPageDataList);
        this.mExportPagesMenu.showPopupMenu(this.mCompViewPresenter.getActivity(), this.mOptionMenuPresenter.getOptionMenuSharePresenter(), view);
        this.mSkipToShowSipForSearch = true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onPaste(Context context, String str) {
        if (isAvailable()) {
            final int pageIndex = this.mPageListDataManager.getPageIndex(str);
            String str2 = TAG;
            AbstractC0000a.m3D(pageIndex, "onPaste# ", str2);
            if (pageIndex < 0) {
                return;
            }
            Logger.addFileLog(str2, "PagePaste", 0);
            this.mContract.clearPageFocus();
            final int iPreExecute = preExecute("onPaste");
            this.mCompViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(false);
            ClipData primaryClip = this.mClipboardController.getPrimaryClip();
            if (!ClipboardCacheManager.isPageData(ClipDataBackupPath.getBackupPathFromHtml(primaryClip))) {
                Logger.m11004w(str2, "onPaste# clipData is not pageData");
                return;
            }
            if (this.mComposerModel.isTabletLayout()) {
                ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_PASTE);
            } else {
                this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_MORE_OPTION_PASTE);
            }
            this.mSkipToShowSipForSearch = true;
            TaskPaste.InputValues inputValues = new TaskPaste.InputValues(context, primaryClip, this.mComposerModel, this.mCompViewPresenter.getObjectManager(), this.mCompViewPresenter.getNoteManager(), this.mPageListDataManager.getPageManager(), this.mCompViewPresenter.getTextManager(), pageIndex);
            this.mTaskController.execute(new TaskPaste(), inputValues, new Task.Callback<TaskPaste.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListMoreMenuPresenter.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskPaste.ResultValues resultValues) {
                    resultValues.showErrorToast();
                    PageListMoreMenuPresenter.this.mCompViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(true);
                    int currentPageIndex = PageListMoreMenuPresenter.this.mPageListDataManager.getPageManager().getDocPageInfo().getCurrentPageIndex();
                    PageListMoreMenuPresenter.this.mPageListDataManager.getPageManager().getDocPageInfo().forceSetCurrentPageIndex(0);
                    PageListMoreMenuPresenter.this.mPageListDataManager.getPageManager().getDocPageInfo().setCurrentPageIndex(currentPageIndex, true);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskPaste.ResultValues resultValues) {
                    PageListMoreMenuPresenter.this.mPageListDataManager.getPageManager().getDocPageInfo().forceSetCurrentPageIndex(pageIndex);
                    PageListMoreMenuPresenter.this.mCompViewPresenter.getComposerControllerManager().getScrollController().goToPage(pageIndex + 1);
                    PageListMoreMenuPresenter.this.mComposerModeHelper.setCursorAfterEditModeChange(iPreExecute, pageIndex + 1);
                    if (resultValues.isUpdateInvertBG()) {
                        PageListMoreMenuPresenter.this.mCompViewPresenter.getNoteManager().updateInvertBackgroundColor();
                    }
                    PageListMoreMenuPresenter.this.mCompViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(true);
                }
            }, false);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.MoreMenuListPopup.OnMoreMenuEventListener
    public void onShare(Context context, String str, View view) {
        if (isNotIdleWorkingState()) {
            return;
        }
        if (this.mComposerModel.isTranslatedPDFNote()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return;
        }
        if (isTranslationOverlayActivated()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(1);
            return;
        }
        showShareTypePopupMenu(str, view);
        if (this.mComposerModel.isTabletLayout()) {
            ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_SHARE);
        } else {
            this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_SHARE);
        }
        this.mSkipToShowSipForSearch = true;
    }

    public int preExecute(String str) {
        this.mContract.hideStickyMemo();
        this.mCompViewPresenter.getObjectManager().clearSelectObject();
        this.mCompViewPresenter.getWritingToolManager().clearControl();
        return this.mComposerModeHelper.releaseReadMode(str);
    }

    public void startChangeTemplateActivity(Activity activity) {
        int i = this.mAddPageIndex;
        if (i < 0 || i >= this.mPageListDataManager.getPageManager().getPageCount()) {
            Logger.m11000e(TAG, "startChangeTemplateActivity# error addPageIndex =" + this.mAddPageIndex + ", page count : " + this.mPageListDataManager.getPageManager().getPageCount());
            return;
        }
        Intent intent = setupIntentTemplateInfo(activity.getIntent());
        intent.setClassName(activity.getPackageName(), NoteStyleActivity.class.getName());
        intent.putExtra("key_type", Constant.Type.TEMPLATE_PICKER.ordinal());
        intent.putExtra(Constant.KEY_GRAVITY, 8388659);
        ComposerRequestCode composerRequestCode = ComposerRequestCode.AddPageTemplate;
        activity.startActivityForResult(intent, composerRequestCode.getId());
        this.mComposerModel.getComposerState().setLastRequestCode(composerRequestCode.getId());
    }

    public void updatePageIndex(int i, int i2, int i4) {
        this.mPageListDataManager.getPageManager().getDocPageInfo().forceSetCurrentPageIndex(i2);
        this.mCompViewPresenter.getComposerControllerManager().getScrollController().goToPage(i4);
        this.mComposerModeHelper.setCursorAfterEditModeChange(i, i4);
    }
}
