package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageListState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeEdit;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share.ExportPagesMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCopyPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCutPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDeletePages;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListEditModeMenuPresenter {
    private static final String TAG = Logger.createTag("PageListEditModeLayout");
    private final ComposerViewPresenter mCompViewPresenter;
    private final PageListComposerModeHelper mComposerModeHelper;
    private final ComposerModel mComposerModel;
    private final Contract mContract;
    private final OptionMenuPresenter mOptionMenuPresenter;
    private List<PageId> mPageIdList;
    private final PageListDataManager mPageListDataManager;
    private PageListModeEdit mPageListModeEdit;
    private final TaskController mTaskController;
    private boolean mIsDeletingPages = false;
    private final SharePagesMenu mSharePagesMenu = new SharePagesMenu(new SharePagesMenu.OptionMenuListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu.OptionMenuListener
        public void onDismiss(boolean z) {
            if (z) {
                PageListEditModeMenuPresenter.this.mContract.getView().setBottomNavigationButtonEnabled(true);
            }
        }
    });
    private final ExportPagesMenu mExportPagesMenu = new ExportPagesMenu(new SharePagesMenu.OptionMenuListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.2
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.share.SharePagesMenu.OptionMenuListener
        public void onDismiss(boolean z) {
            if (z) {
                PageListEditModeMenuPresenter.this.mContract.getView().setBottomNavigationButtonEnabled(true);
                PageListEditModeMenuPresenter.this.mContract.setMode(0);
            }
        }
    });

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        PageListContract.IView getView();

        void hideStickyMemo();

        boolean isMode(int i);

        void setBlockThumbnailUpdate(boolean z);

        void setMode(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void updateSelectedPageCount(boolean z, int i, int i2, boolean z2, int i4);
    }

    public PageListEditModeMenuPresenter(Contract contract, PageListDataManager pageListDataManager, ComposerModel composerModel, ComposerViewPresenter composerViewPresenter, TaskController taskController, PageListComposerModeHelper pageListComposerModeHelper, OptionMenuPresenter optionMenuPresenter) {
        this.mContract = contract;
        this.mPageListDataManager = pageListDataManager;
        this.mComposerModel = composerModel;
        this.mCompViewPresenter = composerViewPresenter;
        this.mTaskController = taskController;
        this.mComposerModeHelper = pageListComposerModeHelper;
        this.mOptionMenuPresenter = optionMenuPresenter;
    }

    private boolean beginHistoryGroup() {
        if (this.mCompViewPresenter.getNoteManager().getNote().isGroupingHistory()) {
            return false;
        }
        this.mCompViewPresenter.getNoteManager().getNote().beginHistoryGroup();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDeletePostAction(TaskDeletePages.ResultValues resultValues) {
        this.mPageListModeEdit.setBlockOnPageDeleted(false);
        boolean zIsEmpty = resultValues.getDeletedPageIdList().isEmpty();
        if (!zIsEmpty) {
            resultValues.getPageManager().notifyDataRemoved(resultValues.getDeletedPageIndexList(), new PageManager.PageUpdateState(false, resultValues.getDeletedPageIdList()));
        }
        if (this.mCompViewPresenter.getNoteManager().getNote().getPageCount() == 1) {
            this.mComposerModel.getComposerSaveModel().setAllPageDeleted(true);
            this.mCompViewPresenter.getNoteManager().insertPage(0);
            this.mCompViewPresenter.getComposerControllerManager().getScrollController().alignmentContent(0);
        }
        if (resultValues.isNeededToCallEndHistory()) {
            this.mCompViewPresenter.getNoteManager().getNote().endHistoryGroup();
        }
        if (!zIsEmpty) {
            this.mPageListDataManager.onPageIndexChanged(resultValues.getPageManager().getDocPageInfo().getCurrentPageIndex());
        }
        this.mContract.setBlockThumbnailUpdate(false);
        this.mIsDeletingPages = false;
        this.mContract.setMode(0);
    }

    private void doDeletePreAction(String str, List<Integer> list) {
        this.mComposerModeHelper.releaseReadMode(str);
        handleUnusualCase();
        this.mIsDeletingPages = true;
        this.mContract.setBlockThumbnailUpdate(true);
        this.mPageListModeEdit.setBlockOnPageDeleted(true);
        this.mContract.hideStickyMemo();
    }

    private ArrayList<Integer> getSelectedIndexList() {
        HashSet<String> selectedItems = this.mPageListModeEdit.getSelectedItems();
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = selectedItems.iterator();
        while (it.hasNext()) {
            int pageIndex = this.mPageListDataManager.getPageIndex(it.next());
            if (pageIndex >= 0) {
                arrayList.add(Integer.valueOf(pageIndex));
                sb.append(pageIndex);
                sb.append(SQLKeyword.COMMA);
            }
        }
        Collections.sort(arrayList);
        Logger.m11003i(TAG, "getSelectedIndexList, index : " + ((Object) sb));
        return arrayList;
    }

    private ArrayList<PageCopyData> getSelectedPageDataList() {
        HashSet<String> selectedItems = this.mPageListModeEdit.getSelectedItems();
        ArrayList<PageCopyData> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String str : selectedItems) {
            int pageIndex = this.mPageListDataManager.getPageIndex(str);
            if (pageIndex >= 0) {
                arrayList.add(new PageCopyData(pageIndex, this.mPageListDataManager.isBookmarked(str)));
                sb.append(pageIndex);
                sb.append(SQLKeyword.COMMA);
            }
        }
        Collections.sort(arrayList);
        Logger.m11003i(TAG, "getSelectedPageDataList, index : " + ((Object) sb));
        return arrayList;
    }

    private void handleUnusualCase() {
        if (this.mCompViewPresenter.getPageManager().getDocPageInfo().isReadyToRestore()) {
            this.mCompViewPresenter.getComposerControllerManager().getScrollController().restoreLastPosition(this.mCompViewPresenter.getNoteManager().getNote());
        }
    }

    private boolean isTranslationOverlayActivated() {
        return this.mOptionMenuPresenter.isTranslationOverlayActivated();
    }

    private void showShareTypePopupMenu(Activity activity) {
        View viewFindViewById = activity.findViewById(C9086R.id.bottom_overflow);
        if (viewFindViewById == null) {
            Logger.m11000e(TAG, "onShareClicked# anchorView is null");
            return;
        }
        this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_EDIT_MODE_SHARE);
        this.mOptionMenuPresenter.getOptionMenuSharePresenter().setPageDataList(getSelectedPageDataList());
        this.mSharePagesMenu.showPopupMenu(activity, this.mOptionMenuPresenter.getOptionMenuSharePresenter(), viewFindViewById);
    }

    public void clearSelection() {
        this.mCompViewPresenter.getWritingToolManager().clearControl();
        this.mCompViewPresenter.getObjectManager().clearSelection();
    }

    public boolean isAutoSaveOptionEnabled() {
        return this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled();
    }

    public boolean isCoeditNote() {
        return this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote();
    }

    public boolean isCopyEnabled() {
        return (this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() || isDynamicTemplatePageSelected()) ? false : true;
    }

    public boolean isDynamicTemplatePageSelected() {
        if (this.mPageListModeEdit == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.mPageListModeEdit.getSelectedItems().iterator();
        while (it.hasNext()) {
            arrayList.add(this.mComposerModel.getDoc().getPage(this.mComposerModel.getDoc().getPageIndexById(it.next())));
        }
        return DynamicTemplateUtil.hasDynamicTemplatePage(arrayList);
    }

    public boolean isEditModeWithReadOnly() {
        return this.mComposerModel.getModeManager().isEditModeWithReadOnly();
    }

    public boolean isLockNote() {
        return this.mComposerModel.getNotesDocEntityManager().isLocked();
    }

    public void onConfigurationChanged() {
        this.mSharePagesMenu.hidePopupMenu();
        this.mExportPagesMenu.hidePopupMenu();
    }

    public boolean onCopyClicked(Context context) {
        if (this.mComposerModel.isTranslatedPDFNote()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return false;
        }
        if (isTranslationOverlayActivated()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(5);
            return false;
        }
        this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_EDIT_MODE_COPY);
        this.mTaskController.execute(new TaskCopyPage(), new TaskCopyPage.InputValues(context, this.mCompViewPresenter.getNoteManager(), this.mCompViewPresenter.getObjectManager(), getSelectedPageDataList()), null, false);
        this.mContract.setMode(0);
        return true;
    }

    public boolean onCutClicked(Context context) {
        String str = TAG;
        Logger.m10999d(str, "onCutClicked#");
        if (this.mComposerModel.isTranslatedPDFNote()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return false;
        }
        if (isTranslationOverlayActivated()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(4);
            return false;
        }
        Logger.addFileLog(str, "PagesCut", 0);
        this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_EDIT_MODE_CUT);
        doDeletePreAction("onCutClicked", getSelectedIndexList());
        ArrayList<PageCopyData> selectedPageDataList = getSelectedPageDataList();
        this.mPageListModeEdit.getSelectedItems().clear();
        this.mTaskController.execute(new TaskCutPage(), new TaskCutPage.InputValues(context, this.mCompViewPresenter.getPageManager(), this.mCompViewPresenter.getNoteManager(), this.mCompViewPresenter.getObjectManager(), selectedPageDataList, beginHistoryGroup()), new Task.Callback<TaskDeletePages.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDeletePages.ResultValues resultValues) {
                Logger.m10999d(PageListEditModeMenuPresenter.TAG, "onCutClicked#onError");
                PageListEditModeMenuPresenter.this.doDeletePostAction(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDeletePages.ResultValues resultValues) {
                Logger.m10999d(PageListEditModeMenuPresenter.TAG, "onCutClicked#onSuccess");
                PageListEditModeMenuPresenter.this.doDeletePostAction(resultValues);
            }
        }, false);
        return true;
    }

    public void onDeleteClicked() {
        String str = TAG;
        Logger.m10999d(str, "onDeleteClicked()");
        Logger.addFileLog(str, "PageEDel", 0);
        this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_EDIT_MODE_DELETE);
        ArrayList<Integer> selectedIndexList = getSelectedIndexList();
        doDeletePreAction("onDeleteClicked", selectedIndexList);
        this.mPageListModeEdit.getSelectedItems().clear();
        this.mTaskController.execute(new TaskDeletePages(), new TaskDeletePages.InputValues(this.mPageListDataManager.getPageManager(), this.mCompViewPresenter.getNoteManager(), selectedIndexList, beginHistoryGroup()), new Task.Callback<TaskDeletePages.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDeletePages.ResultValues resultValues) {
                Logger.m10999d(PageListEditModeMenuPresenter.TAG, "onDeleteClicked#onError");
                PageListEditModeMenuPresenter.this.doDeletePostAction(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDeletePages.ResultValues resultValues) {
                Logger.m10999d(PageListEditModeMenuPresenter.TAG, "onDeleteClicked#onSuccess");
                PageListEditModeMenuPresenter.this.doDeletePostAction(resultValues);
            }
        }, false);
    }

    public void onDetachView() {
        this.mSharePagesMenu.hidePopupMenu();
        this.mExportPagesMenu.hidePopupMenu();
    }

    public void onDoneClicked() {
        Logger.m10999d(TAG, "onDoneClicked()");
        this.mContract.setMode(0);
        if (DeviceInfo.isVSTModel()) {
            ComposerSA.insertLog(ComposerSA.getScreenID(this.mComposerModel.getModeManager().isEditMode(), this.mComposerModel.getModeManager().isMode(Mode.Writing), this.mComposerModel.isTabletLayout()), ComposerSAConstants.EVENT_VST_EDITING_PAGE_DONE);
        }
    }

    public boolean onExportClicked(Activity activity) {
        if (this.mComposerModel.isTranslatedPDFNote()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return false;
        }
        if (isTranslationOverlayActivated()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(0);
            return false;
        }
        View viewFindViewById = activity.findViewById(C9086R.id.bottom_overflow);
        if (viewFindViewById == null) {
            Logger.m11000e(TAG, "onExportClicked# anchorView is null");
            return true;
        }
        if (!ContentPickerUtils.canExportFileMenu(activity)) {
            return true;
        }
        this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_EDIT_MODE_SAVE_AS);
        this.mOptionMenuPresenter.getOptionMenuSharePresenter().setPageDataList(getSelectedPageDataList());
        this.mExportPagesMenu.showPopupMenu(activity, this.mOptionMenuPresenter.getOptionMenuSharePresenter(), viewFindViewById);
        return true;
    }

    public void onSelectAllClicked(boolean z, boolean z2) {
        if (this.mContract.isMode(1)) {
            this.mPageListModeEdit.selectAll(this.mPageIdList, this.mContract.getView(), z, z2);
        } else {
            Logger.m11000e(TAG, "onSelectAllClicked# not edit mode");
        }
    }

    public boolean onShareClicked(Activity activity) {
        if (this.mComposerModel.isTranslatedPDFNote()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return false;
        }
        if (isTranslationOverlayActivated()) {
            this.mCompViewPresenter.getDialogPresenterManager().showTurnOffTranslationDialog(1);
            return false;
        }
        showShareTypePopupMenu(activity);
        this.mContract.setMode(0);
        return true;
    }

    public void saveState(PageListState pageListState) {
        pageListState.setDeletingPages(this.mIsDeletingPages);
    }

    public void setMode(PageListModeEdit pageListModeEdit) {
        this.mPageListModeEdit = pageListModeEdit;
    }

    public void setPageIdList(List<PageId> list) {
        this.mPageIdList = list;
    }
}
