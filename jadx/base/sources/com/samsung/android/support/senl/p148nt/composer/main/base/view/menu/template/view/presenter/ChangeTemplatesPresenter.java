package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.TemplateNameDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.BaseItemAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.AllItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.RecyclerViewItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.state.ViewStateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.CustomItemPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.TaskDownloadPdfTemplate;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import java.io.File;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ChangeTemplatesPresenter implements ChangeTemplatesContract.ItemPresenter {
    private static final String TAG = CTLogger.createTag("ChangeTemplatesPresenter2");
    private static final String TEMPLATE_FOLDER_ADDED = "added";
    private static final String TEMPLATE_FOLDER_DEFAULT_TEMPLATE = "default_template";
    private final AcademicItemPresenter mAcademicItemPresenter;
    private RecyclerViewItemData mAcademicRecyclerViewItemData;
    private final AllItemData mAllItemData;
    private final BasicItemPresenter mBasicItemPresenter;
    private RecyclerViewItemData mBasicRecyclerViewItemData;
    private Contract mContract;
    private final CreativeItemPresenter mCreativeItemPresenter;
    private RecyclerViewItemData mCreativeRecyclerViewItemData;
    private final CustomItemPresenter mCustomItemPresenter;
    private RecyclerViewItemData mCustomRecyclerViewItemData;
    private final TaskDownloadPdfTemplate mDownloadPdfTask;
    private final JournalItemPresenter mJournalItemPresenter;
    private float mPageRatio;
    private final PlanItemPresenter mPlanItemPresenter;
    private RecyclerViewItemData mPlanRecyclerViewItemData;
    private RecyclerViewItemData mRecordRecyclerViewItemData;
    private SelectedTemplateData mSelectedTemplateData;
    private File mTemplateRootFolder;
    private ChangeTemplatesContract.View mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onSelectedTemplateChanged();

        void resetPageThumbnail();
    }

    public ChangeTemplatesPresenter(Context context, ViewStateData viewStateData, Contract contract) {
        TaskDownloadPdfTemplate taskDownloadPdfTemplate = new TaskDownloadPdfTemplate();
        this.mDownloadPdfTask = taskDownloadPdfTemplate;
        SpenSdkInitializer.initialize(context);
        setTemplateRootFolder(context.getDir(TemplateConstants.TEMPLATE_FOLDER_ROOT, 0));
        float pageRatio = viewStateData.getPageRatio();
        this.mPageRatio = pageRatio;
        BasicItemPresenter basicItemPresenter = new BasicItemPresenter(this, pageRatio);
        this.mBasicItemPresenter = basicItemPresenter;
        AcademicItemPresenter academicItemPresenter = new AcademicItemPresenter(this, taskDownloadPdfTemplate, this.mPageRatio);
        this.mAcademicItemPresenter = academicItemPresenter;
        PlanItemPresenter planItemPresenter = new PlanItemPresenter(this, taskDownloadPdfTemplate, this.mPageRatio);
        this.mPlanItemPresenter = planItemPresenter;
        JournalItemPresenter journalItemPresenter = new JournalItemPresenter(this, taskDownloadPdfTemplate, this.mPageRatio);
        this.mJournalItemPresenter = journalItemPresenter;
        CreativeItemPresenter creativeItemPresenter = new CreativeItemPresenter(this, taskDownloadPdfTemplate, this.mPageRatio);
        this.mCreativeItemPresenter = creativeItemPresenter;
        CustomItemPresenter customItemPresenter = new CustomItemPresenter(this, context, this.mPageRatio, new CustomItemPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.CustomItemPresenter.Contract
            public void onSelectedTemplateChanged() {
                ChangeTemplatesPresenter.this.onSelectedTemplateChanged();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.CustomItemPresenter.Contract
            public void resetPageThumbnail() {
                ChangeTemplatesPresenter.this.resetPageThumbnail();
            }
        });
        this.mCustomItemPresenter = customItemPresenter;
        this.mAllItemData = new AllItemData(basicItemPresenter.getItemData(), academicItemPresenter.getItemData(), planItemPresenter.getItemData(), journalItemPresenter.getItemData(), creativeItemPresenter.getItemData(), customItemPresenter.getItemData());
        this.mContract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteCanceledFile(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (!new File(str).delete()) {
            Logger.m11003i(TAG, "deleteCanceledFile#, delete error deletePath");
        }
        if (new File(str.substring(0, str.lastIndexOf(Extension.DOT)) + ".jpg").delete()) {
            return;
        }
        Logger.m11003i(TAG, "deleteCanceledFile#, delete error thumbnailPath");
    }

    private Task.Callback<TaskDownloadPdfTemplate.ResultValues> getDownloadPdfCallback(final boolean z) {
        return new Task.Callback<TaskDownloadPdfTemplate.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesPresenter.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDownloadPdfTemplate.ResultValues resultValues) {
                Logger.m11000e(ChangeTemplatesPresenter.TAG, "downloadTemplatePdf#onError# " + resultValues.getErrorCode());
                resultValues.showErrorToast(true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDownloadPdfTemplate.ResultValues resultValues) {
                Logger.m11003i(ChangeTemplatesPresenter.TAG, "downloadTemplatePdf#onSuccess# ");
                if (resultValues.getPathList() != null && !resultValues.getPathList().isEmpty()) {
                    ChangeTemplatesPresenter.this.requestRenameDialog(resultValues.getContext(), resultValues.getPathList().get(0), Constants.MIME_PDF, 5, z);
                }
                resultValues.showErrorToast(true);
            }
        };
    }

    private void setItemData(Context context) {
        this.mBasicItemPresenter.initItems(context);
        this.mAcademicItemPresenter.initItems(context);
        this.mPlanItemPresenter.initItems(context);
        this.mJournalItemPresenter.initItems(context);
        this.mCreativeItemPresenter.initItems(context);
        this.mCustomItemPresenter.initItems(context);
        updateAllItems();
    }

    private void setTemplateRootFolder(File file) {
        this.mTemplateRootFolder = file;
    }

    public void attachView(ChangeTemplatesContract.View view) {
        this.mView = view;
        this.mBasicItemPresenter.attachView(view);
        this.mAcademicItemPresenter.attachView(this.mView);
        this.mPlanItemPresenter.attachView(this.mView);
        this.mJournalItemPresenter.attachView(this.mView);
        this.mCreativeItemPresenter.attachView(this.mView);
        this.mCustomItemPresenter.attachView(this.mView);
    }

    public int calculateSpanCount(Context context, int i) {
        Resources resources = context.getResources();
        return Math.min(Math.max((i - (resources.getDimensionPixelSize(C9086R.dimen.change_template_recyclerview_horizontal_padding) * 2)) / resources.getDimensionPixelSize(C9086R.dimen.change_template_item_width), 1), 5);
    }

    public void detachView() {
        this.mDownloadPdfTask.clear();
        this.mView = null;
    }

    public void downloadTemplateImage(Uri uri, Context context, int i, int i2) {
        String mimeType = UriFileUtils.getMimeType(context, uri);
        if (mimeType != null && mimeType.contains(Constants.THUMBNAIL_GIF_EXTENSION)) {
            mimeType = "image/jpeg";
        }
        String str = mimeType;
        String strSaveImageFromUri = DownloadBitmap.saveImageFromUri(context, uri, str, getAddedTemplatesFolder().getPath() + File.separator, null);
        if (TextUtils.isEmpty(strSaveImageFromUri) || !AbstractC2322a.m1607A(strSaveImageFromUri)) {
            Logger.m11004w(TAG, "downloadTemplateImage#, Failed to template image content - not exists");
            ToastHandler.show(context, C9086R.string.composer_failed_to_load_image, 0);
            return;
        }
        Logger.m11003i(TAG, "downloadTemplateImage#, path : " + Logger.getEncode(strSaveImageFromUri));
        this.mView.onOpenTemplateEditor(strSaveImageFromUri, str, i, i2, "");
    }

    public void downloadTemplatePdf(Context context, Uri uri, boolean z) {
        this.mDownloadPdfTask.setInputValue(new TaskDownloadPdfTemplate.InputValues(this.mView.getFragment().getParentFragmentManager(), context, Collections.singletonList(uri), getAddedTemplatesFolder().getPath() + File.separator, false));
        this.mDownloadPdfTask.setTaskCallback(getDownloadPdfCallback(z));
        this.mDownloadPdfTask.run();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.ItemPresenter
    public File getAddedTemplatesFolder() {
        File file = new File(this.mTemplateRootFolder, TEMPLATE_FOLDER_ADDED);
        if (!file.exists() && !file.mkdir()) {
            Logger.m11000e(TAG, "getAddedTemplatesFolder fail");
        }
        return file;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.ItemPresenter
    public File getDefaultPdfTemplatesFolder() {
        File file = new File(this.mTemplateRootFolder, TEMPLATE_FOLDER_DEFAULT_TEMPLATE);
        if (!file.exists() && !file.mkdir()) {
            Logger.m11000e(TAG, "getDefaultPdfTemplatesFolder fail");
        }
        return file;
    }

    public int getItemCount() {
        return this.mCustomItemPresenter.getTemplateCount();
    }

    public TemplateItem getRenameItem() {
        return this.mCustomItemPresenter.getRenameItem();
    }

    public TemplateItem getSelectedItem(SelectedTemplateData selectedTemplateData) {
        return this.mAllItemData.getSelectedItem(selectedTemplateData);
    }

    public int getSelectedItemCount() {
        return this.mCustomItemPresenter.getSelectedItemCount();
    }

    public void init(Context context) {
        setItemData(context);
    }

    public void insertTemplateImage(Context context, @Nullable String str, @NonNull String str2, @NonNull String str3, int i) {
        Logger.m11003i(TAG, "insertTemplateImage#, path : " + Logger.getEncode(str2));
        if (context instanceof NoteStyleActivity) {
            SAManager.INSTANCE.onAddTemplate("401");
        } else {
            SAManager.INSTANCE.onAddTemplate("510");
        }
        this.mCustomItemPresenter.insertTemplateRepository(context, str, str2, str3, i);
    }

    public void insertTemplatePdf(Context context, @Nullable String str, @NonNull String str2, @NonNull String str3, int i, boolean z) {
        Logger.m11003i(TAG, "insertTemplatePdf#, path : " + Logger.getEncode(str2));
        if (z) {
            if (context != null && ContextUtils.isNightMode(context)) {
                ToastHandler.show(context, context.getString(C9086R.string.dark_mode_not_applied_has_pdf_toast_msg), 0, false);
            }
            setSelectedTemplateData(i, str2);
        }
        this.mCustomItemPresenter.insertTemplateRepository(context, str, str2, str3, i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.ItemPresenter
    public void loadItemData() {
        Logger.m11004w(TAG, "loadItemData");
        if (this.mSelectedTemplateData.getSelectedTemplateType() != -1) {
            this.mAllItemData.updateSelectedItem(this.mSelectedTemplateData);
        }
        this.mBasicRecyclerViewItemData.clearItemList();
        this.mBasicRecyclerViewItemData.addItemToList(this.mBasicItemPresenter.getItemData());
        this.mAcademicRecyclerViewItemData.clearItemList();
        this.mAcademicRecyclerViewItemData.addItemToList(this.mAcademicItemPresenter.getItemData());
        this.mPlanRecyclerViewItemData.clearItemList();
        this.mPlanRecyclerViewItemData.addItemToList(this.mPlanItemPresenter.getItemData());
        this.mRecordRecyclerViewItemData.clearItemList();
        this.mRecordRecyclerViewItemData.addItemToList(this.mJournalItemPresenter.getItemData());
        this.mCreativeRecyclerViewItemData.clearItemList();
        this.mCreativeRecyclerViewItemData.addItemToList(this.mCreativeItemPresenter.getItemData());
        this.mCustomRecyclerViewItemData.clearItemList();
        this.mCustomRecyclerViewItemData.addItemToList(this.mCustomItemPresenter.getItemData());
        restoreSetMode();
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onChangeMode() {
        this.mCustomItemPresenter.onChangeMode();
    }

    public void onClickDelete(boolean z) {
        this.mCustomItemPresenter.onClickDelete(z);
    }

    public void onEditDialogResult(String str) {
        this.mCustomItemPresenter.onEditDialogResult(str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.ItemPresenter
    public void onOpenTemplateEditor(String str, int i, int i2) {
        this.mView.onOpenTemplateEditor(str, "", i, i2, getAddedTemplatesFolder().getPath() + File.separator + FileExtensions.getFileNameByTime("files", Constants.THUMBNAIL_PNG_EXTENSION));
    }

    public void onSaveInstanceState(Bundle bundle) {
        int selectedTemplateType = this.mSelectedTemplateData.getSelectedTemplateType();
        bundle.putInt(TemplateConstants.KEY_CURRENT_PAGE, (selectedTemplateType == 10 || selectedTemplateType == 11) ? 0 : (selectedTemplateType == 13 || selectedTemplateType == 14) ? 1 : (selectedTemplateType == 16 || selectedTemplateType == 17) ? 2 : (selectedTemplateType == 19 || selectedTemplateType == 20) ? 3 : (selectedTemplateType == 22 || selectedTemplateType == 23) ? 4 : 5);
        this.mCustomItemPresenter.onSaveInstanceState(bundle);
    }

    public void onSelectedTemplateChanged() {
        this.mContract.onSelectedTemplateChanged();
    }

    public void requestRenameDialog(final Context context, @NonNull final String str, @NonNull final String str2, final int i, final boolean z) {
        TemplateNameDialog templateNameDialog = new TemplateNameDialog(context, FileUtils.getFileNameFromFilePath(str), str, false);
        templateNameDialog.setEditDialogResultListener(new ITemplateEditDialogResult() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesPresenter.3
            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult
            public void onEditDialogDismiss(String str3) {
                ChangeTemplatesPresenter.this.deleteCanceledFile(str3);
                ChangeTemplatesPresenter.this.onChangeMode();
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult
            public void onEditDialogResult(@Nullable String str3) {
                int i2 = i;
                if (i2 != 3) {
                    ChangeTemplatesPresenter.this.insertTemplatePdf(context, str3, str, str2, i2, z);
                } else {
                    ChangeTemplatesPresenter.this.insertTemplateImage(context, str3, str, str2, i2);
                    ChangeTemplatesPresenter.this.selectTemplateImage(str);
                }
            }
        });
        if (context instanceof AppCompatActivity) {
            templateNameDialog.show();
        }
    }

    public int requestSelectAllItems(boolean z) {
        return this.mCustomItemPresenter.requestSelectAllItems(z);
    }

    public void resetPageThumbnail() {
        this.mContract.resetPageThumbnail();
    }

    public void restoreSetMode() {
        this.mCustomItemPresenter.restoreSetMode();
    }

    public void restoreState(Bundle bundle) {
        this.mCustomItemPresenter.restoreState(bundle);
    }

    public void scrollToSelectedTemplateItem() {
        int selectedTemplateType = this.mSelectedTemplateData.getSelectedTemplateType();
        if (selectedTemplateType == 10 || selectedTemplateType == 11) {
            this.mView.scrollToPosition(selectedTemplateType, this.mBasicRecyclerViewItemData.getSelectedItemIndex());
            return;
        }
        if (selectedTemplateType == 13 || selectedTemplateType == 14) {
            this.mView.scrollToPosition(selectedTemplateType, this.mAcademicRecyclerViewItemData.getSelectedItemIndex());
            return;
        }
        if (selectedTemplateType == 16 || selectedTemplateType == 17) {
            this.mView.scrollToPosition(selectedTemplateType, this.mPlanRecyclerViewItemData.getSelectedItemIndex());
            return;
        }
        if (selectedTemplateType == 19 || selectedTemplateType == 20) {
            this.mView.scrollToPosition(selectedTemplateType, this.mRecordRecyclerViewItemData.getSelectedItemIndex());
        } else if (selectedTemplateType == 22 || selectedTemplateType == 23) {
            this.mView.scrollToPosition(selectedTemplateType, this.mCreativeRecyclerViewItemData.getSelectedItemIndex());
        } else {
            this.mView.scrollToPosition(selectedTemplateType, this.mCustomRecyclerViewItemData.getSelectedItemIndex());
        }
    }

    public void selectTemplateImage(String str) {
        Logger.m11003i(TAG, "selectTemplateImage# ");
        this.mView.onSelectItem(2, new TemplateItem(3, 0, "", "", str, "", -1, false, 0, 0));
    }

    public void setAcademicItemAdapter(BaseItemAdapter baseItemAdapter) {
        baseItemAdapter.setOnClickListener(this.mAcademicItemPresenter);
        RecyclerViewItemData recyclerViewItemData = new RecyclerViewItemData(baseItemAdapter);
        this.mAcademicRecyclerViewItemData = recyclerViewItemData;
        this.mAcademicItemPresenter.setRecyclerViewItemData(recyclerViewItemData);
    }

    public void setBasicItemAdapter(BaseItemAdapter baseItemAdapter) {
        baseItemAdapter.setOnClickListener(this.mBasicItemPresenter);
        RecyclerViewItemData recyclerViewItemData = new RecyclerViewItemData(baseItemAdapter);
        this.mBasicRecyclerViewItemData = recyclerViewItemData;
        this.mBasicItemPresenter.setRecyclerViewItemData(recyclerViewItemData);
    }

    public void setCreativeItemAdapter(BaseItemAdapter baseItemAdapter) {
        baseItemAdapter.setOnClickListener(this.mCreativeItemPresenter);
        RecyclerViewItemData recyclerViewItemData = new RecyclerViewItemData(baseItemAdapter);
        this.mCreativeRecyclerViewItemData = recyclerViewItemData;
        this.mCreativeItemPresenter.setRecyclerViewItemData(recyclerViewItemData);
    }

    public void setCustomItemAdapter(BaseItemAdapter baseItemAdapter) {
        baseItemAdapter.setOnClickListener(this.mCustomItemPresenter);
        RecyclerViewItemData recyclerViewItemData = new RecyclerViewItemData(baseItemAdapter);
        this.mCustomRecyclerViewItemData = recyclerViewItemData;
        this.mCustomItemPresenter.setRecyclerViewItemData(recyclerViewItemData);
    }

    public void setPlanItemAdapter(BaseItemAdapter baseItemAdapter) {
        baseItemAdapter.setOnClickListener(this.mPlanItemPresenter);
        RecyclerViewItemData recyclerViewItemData = new RecyclerViewItemData(baseItemAdapter);
        this.mPlanRecyclerViewItemData = recyclerViewItemData;
        this.mPlanItemPresenter.setRecyclerViewItemData(recyclerViewItemData);
    }

    public void setRecordItemAdapter(BaseItemAdapter baseItemAdapter) {
        baseItemAdapter.setOnClickListener(this.mJournalItemPresenter);
        RecyclerViewItemData recyclerViewItemData = new RecyclerViewItemData(baseItemAdapter);
        this.mRecordRecyclerViewItemData = recyclerViewItemData;
        this.mJournalItemPresenter.setRecyclerViewItemData(recyclerViewItemData);
    }

    public void setSelectedTemplateData(SelectedTemplateData selectedTemplateData) {
        this.mSelectedTemplateData = selectedTemplateData;
        this.mAcademicItemPresenter.setSelectedTemplateData(selectedTemplateData);
        this.mPlanItemPresenter.setSelectedTemplateData(this.mSelectedTemplateData);
        this.mJournalItemPresenter.setSelectedTemplateData(this.mSelectedTemplateData);
        this.mCreativeItemPresenter.setSelectedTemplateData(this.mSelectedTemplateData);
        this.mCustomItemPresenter.setSelectedTemplateData(this.mSelectedTemplateData);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.ItemPresenter
    public void updateAllItems() {
        this.mAllItemData.addAllItems();
        loadItemData();
        this.mView.onAllItemUpdated();
    }

    public void updateItemsPageRatio(Context context, float f) {
        if (context == null) {
            Logger.m10999d(TAG, "updateItemsPageRatio# context is null");
            return;
        }
        Logger.m10999d(TAG, "updateItemsPageRatio# pageRatio " + f);
        this.mBasicItemPresenter.updateItemsDrawable(f);
        this.mAcademicItemPresenter.updateItemsDrawable(context, f);
        this.mPlanItemPresenter.updateItemsDrawable(context, f);
        this.mJournalItemPresenter.updateItemsDrawable(context, f);
        this.mCreativeItemPresenter.updateItemsDrawable(context, f);
        this.mCustomItemPresenter.updateItemsDrawable(context, f);
        updateAllItems();
    }

    public void setSelectedTemplateData(int i, String str) {
        this.mSelectedTemplateData.setSelectedTemplateData(i, str);
    }
}
