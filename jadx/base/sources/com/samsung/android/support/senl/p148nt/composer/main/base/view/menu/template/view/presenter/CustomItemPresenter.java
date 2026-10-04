package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.CustomItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.ItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.RecyclerViewItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.PdfTemplateThumbnail;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import java.io.File;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomItemPresenter extends AddedItemPresenter {
    private static final String KEY_CUSTOM_DELETED_ITEM = "key_custom_deleted_item";
    private static final String KEY_CUSTOM_ITEM_MODE = "key_custom_item_mode";
    private static final String TAG = CTLogger.createTag("PdfItemPresenter");
    private Contract mContract;
    private float mPageRatio;
    private final float mPageWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onSelectedTemplateChanged();

        void resetPageThumbnail();
    }

    public CustomItemPresenter(ChangeTemplatesContract.ItemPresenter itemPresenter, Context context, float f, Contract contract) {
        super(itemPresenter);
        this.mItemData = new CustomItemData();
        this.mPageWidth = PdfTemplateThumbnail.getTemplateViewWidth(context);
        this.mPageRatio = f;
        this.mContract = contract;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void attachView(ChangeTemplatesContract.View view) {
        super.attachView(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public TemplateItem createItem(@NonNull SpenNotePdfImport spenNotePdfImport, NotesTemplateEntity notesTemplateEntity) {
        if (notesTemplateEntity.getType() == 3) {
            return new TemplateItem(getTemplateType(false), 0, notesTemplateEntity.getTitle(), notesTemplateEntity.getUuid(), notesTemplateEntity.getData(), notesTemplateEntity.getData(), -1, false, notesTemplateEntity.getWidth(), notesTemplateEntity.getHeight());
        }
        TemplateItem templateItem = new TemplateItem(getTemplateType(true), 0, notesTemplateEntity.getTitle(), notesTemplateEntity.getUuid(), notesTemplateEntity.getData(), PdfTemplateThumbnail.getPdfDrawablePath(spenNotePdfImport, new PdfTemplateThumbnail.PdfTemplateInfo(this.mTemplatesPresenter.getAddedTemplatesFolder().getPath() + File.separator, notesTemplateEntity.getData()), this.mPageWidth), false);
        templateItem.setPageCount(spenNotePdfImport.getPageCount(templateItem.getPath(), ""));
        return templateItem;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public void deleteFile(NotesTemplateEntity notesTemplateEntity) {
        if (notesTemplateEntity.getType() == 3) {
            FileUtils.deleteFile(notesTemplateEntity.getData());
            return;
        }
        FileUtils.deleteFile(notesTemplateEntity.getData());
        FileUtils.deleteFile(notesTemplateEntity.getData().substring(0, notesTemplateEntity.getData().lastIndexOf(46)) + ".jpg");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ ItemData getItemData() {
        return super.getItemData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ TemplateItem getRenameItem() {
        return super.getRenameItem();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ int getSelectedItemCount() {
        return super.getSelectedItemCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ int getTemplateCount() {
        return super.getTemplateCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public int getTemplateType() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void handleChangedTemplateData(List list, float f) {
        super.handleChangedTemplateData(list, f);
    }

    public void initItems(Context context) {
        initTemplateRepository(this.mPageRatio);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void initTemplateRepository(float f) {
        super.initTemplateRepository(f);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void insertTemplateRepository(Context context, @Nullable String str, @NonNull String str2, @NonNull String str3, int i) {
        super.insertTemplateRepository(context, str, str2, str3, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public /* bridge */ /* synthetic */ void onAddTemplate(boolean z) {
        super.onAddTemplate(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void onChangeMode() {
        super.onChangeMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void onClickDelete(boolean z) {
        super.onClickDelete(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public /* bridge */ /* synthetic */ void onDeleteDone(boolean z, boolean z2) {
        super.onDeleteDone(z, z2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public /* bridge */ /* synthetic */ void onDeleteTemplate(List list) {
        super.onDeleteTemplate(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public /* bridge */ /* synthetic */ boolean onDownloadTemplate(Context context, TemplateItem templateItem) {
        return super.onDownloadTemplate(context, templateItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void onEditDialogResult(String str) {
        super.onEditDialogResult(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public /* bridge */ /* synthetic */ void onItemClicked(int i) {
        super.onItemClicked(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public /* bridge */ /* synthetic */ boolean onItemLongPressed(int i) {
        return super.onItemLongPressed(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt(KEY_CUSTOM_ITEM_MODE, this.mItemData.getItemMode());
        bundle.putSerializable(KEY_CUSTOM_DELETED_ITEM, (Serializable) this.mDeletedItemList);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public /* bridge */ /* synthetic */ void onSelectTemplate(int i, TemplateItem templateItem) {
        super.onSelectTemplate(i, templateItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public void onSelectedTemplateChanged() {
        this.mContract.onSelectedTemplateChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ int requestSelectAllItems(boolean z) {
        return super.requestSelectAllItems(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public void resetPageThumbnail() {
        this.mContract.resetPageThumbnail();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void restoreDeletedItemList() {
        super.restoreDeletedItemList();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void restoreSetMode() {
        super.restoreSetMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public void restoreState(@NonNull Bundle bundle) {
        int i = bundle.getInt(KEY_CUSTOM_ITEM_MODE, 0);
        this.mRestoreItemMode = i;
        if (i == 1) {
            this.mDeletedItemList = (List) bundle.getSerializable(KEY_CUSTOM_DELETED_ITEM);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void setRecyclerViewItemData(RecyclerViewItemData recyclerViewItemData) {
        super.setRecyclerViewItemData(recyclerViewItemData);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void setSelectedTemplateData(SelectedTemplateData selectedTemplateData) {
        super.setSelectedTemplateData(selectedTemplateData);
    }

    public void updateItemsDrawable(Context context, float f) {
        this.mPageRatio = f;
        this.mItemData.clearItemDataList();
        initItems(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public int getTemplateType(boolean z) {
        return z ? 5 : 3;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public /* bridge */ /* synthetic */ void onChangeMode(int i) {
        super.onChangeMode(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.AddedItemPresenter
    public void deleteFile(TemplateItem templateItem) {
        if (templateItem.getType() == 3) {
            FileUtils.deleteFile(templateItem.getPath());
            return;
        }
        FileUtils.deleteFile(templateItem.getPath());
        FileUtils.deleteFile(templateItem.getPath().substring(0, templateItem.getPath().lastIndexOf(46)) + ".jpg");
    }
}
