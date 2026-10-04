package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.ItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.RecyclerViewItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentStyleRepository;
import com.samsung.android.support.senl.p148nt.model.domain.template.CreatePageTemplateUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
abstract class AddedItemPresenter implements OnItemActionListener {
    private static final String TAG = CTLogger.createTag("CustomItemPresenter");
    protected ItemData mItemData;
    protected RecyclerViewItemData mRecyclerViewItemData;
    protected SelectedTemplateData mSelectedTemplateData;
    protected ChangeTemplatesContract.ItemPresenter mTemplatesPresenter;
    private ChangeTemplatesContract.View mView;
    protected List<TemplateItem> mDeletedItemList = new ArrayList();
    protected int mRestoreItemMode = 0;
    private boolean mScrollToSelectedItem = false;

    public AddedItemPresenter(ChangeTemplatesContract.ItemPresenter itemPresenter) {
        this.mTemplatesPresenter = itemPresenter;
    }

    private List<String> convertEntitiyToPath(List<NotesTemplateEntity> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<NotesTemplateEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getData());
        }
        return arrayList;
    }

    private void deleteTemplateRepository(List<String> list) {
        Logger.m10999d(TAG, "deleteItems# path : " + list.size());
        DataRepositoryScheduler.runnable(new RunnableC10464a(list, 0)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteTemplateRepository$1(List list) {
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createTemplateRepository().deleteByPath(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTemplateRepository$2(float f, List list) {
        List<NotesTemplateEntity> listVerifyItems = verifyItems(list);
        if (listVerifyItems.isEmpty()) {
            handleChangedTemplateData(list, f);
            restoreSetMode();
            scrollToPosition(5);
            onSelectedTemplateChanged();
            return;
        }
        Logger.m11002f(TAG, "initTemplateRepository# delete failed PDF template : " + listVerifyItems.size());
        deleteTemplateRepository(convertEntitiyToPath(listVerifyItems));
        Iterator<NotesTemplateEntity> it = listVerifyItems.iterator();
        while (it.hasNext()) {
            deleteFile(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$insertTemplateRepository$0(Context context, String str, String str2, String str3, int i) {
        CreatePageTemplateUseCase createPageTemplateUseCase = new CreatePageTemplateUseCase(NotesDataRepositoryFactory.newInstance(context).createTemplateRepository());
        if (str == null) {
            str = "";
        }
        createPageTemplateUseCase.invoke(new CreatePageTemplateUseCase.Param(str, str2, str3, i));
    }

    private void scrollToPosition(int i) {
        if (this.mRecyclerViewItemData.getItemList().isEmpty()) {
            Logger.m10999d(TAG, "scrollToPosition# itemList is empty.# ");
            return;
        }
        if (this.mScrollToSelectedItem) {
            this.mScrollToSelectedItem = false;
            TemplateItem selectedItem = this.mRecyclerViewItemData.getSelectedItem();
            if (selectedItem == null || selectedItem.getType() != i) {
                return;
            }
            Logger.m10999d(TAG, "scrollToPosition# isNeedToScrollToSelectedItem# ");
            scrollToPosition(selectedItem);
        }
    }

    private boolean updateItemDataList(List<NotesTemplateEntity> list, float f) {
        ArrayList arrayList = new ArrayList();
        SpenNotePdfImport spenNotePdfImport = new SpenNotePdfImport(BaseUtils.getContext());
        try {
            try {
                Iterator<NotesTemplateEntity> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(createItem(spenNotePdfImport, it.next()));
                }
            } catch (Exception e) {
                Logger.m10999d(TAG, "addItem, e: " + e.getMessage());
            }
            List<TemplateItem> itemDataList = this.mItemData.getItemDataList();
            boolean z = true;
            if (!itemDataList.isEmpty() && !arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        break;
                    }
                    if (!itemDataList.get(i).equals(arrayList.get(i))) {
                        break;
                    }
                    i++;
                }
            }
            if (z) {
                this.mItemData.clearItemDataList();
                this.mItemData.addItem(new TemplateItem(25, 0, "", "", ImageTemplatePresenterUtil.getItemResourceArray(f).getResourceId(0, -1)));
                this.mItemData.addAll(arrayList);
            }
            return z;
        } finally {
            spenNotePdfImport.close();
        }
    }

    private List<NotesTemplateEntity> verifyItems(List<NotesTemplateEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (NotesTemplateEntity notesTemplateEntity : list) {
                if (!FileUtils.exists(notesTemplateEntity.getData())) {
                    Logger.m11000e(TAG, "verifyItems# pdf file is not exist. " + Logger.getEncode(notesTemplateEntity.getData()));
                    arrayList.add(notesTemplateEntity);
                }
            }
        }
        return arrayList;
    }

    public void attachView(ChangeTemplatesContract.View view) {
        this.mView = view;
    }

    public abstract TemplateItem createItem(@NonNull SpenNotePdfImport spenNotePdfImport, NotesTemplateEntity notesTemplateEntity);

    public abstract void deleteFile(TemplateItem templateItem);

    public abstract void deleteFile(NotesTemplateEntity notesTemplateEntity);

    public ItemData getItemData() {
        return this.mItemData;
    }

    public TemplateItem getRenameItem() {
        return this.mRecyclerViewItemData.getRenameItem();
    }

    public int getSelectedItemCount() {
        return this.mRecyclerViewItemData.getSelectedTemplates().size();
    }

    public int getTemplateCount() {
        return this.mRecyclerViewItemData.getItemCount();
    }

    public abstract int getTemplateType();

    public abstract int getTemplateType(boolean z);

    public void handleChangedTemplateData(List<NotesTemplateEntity> list, float f) {
        boolean zUpdateItemDataList = updateItemDataList(list, f);
        if (zUpdateItemDataList) {
            this.mTemplatesPresenter.updateAllItems();
        }
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("handleChangedTemplateData, isUpdated: ", ", itemDataListSize:", zUpdateItemDataList);
        sbM3200j.append(this.mRecyclerViewItemData.getItemList().size());
        Logger.m11003i(str, sbM3200j.toString());
    }

    public void initTemplateRepository(final float f) {
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createTemplateRepository().getAll_LiveData(true).observe(this.mView.getFragment(), new Observer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f7202a.lambda$initTemplateRepository$2(f, (List) obj);
            }
        });
    }

    public void insertTemplateRepository(final Context context, @Nullable final String str, @NonNull final String str2, @NonNull final String str3, final int i) {
        DataRepositoryScheduler.runnable(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.b
            @Override // java.lang.Runnable
            public final void run() {
                AddedItemPresenter.lambda$insertTemplateRepository$0(context, str, str2, str3, i);
            }
        }).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onAddTemplate(boolean z) {
        Logger.m10999d(TAG, "onAddTemplate#");
        this.mView.onOpenChooser(getTemplateType(z), this.mView.getPageRatioType());
    }

    public void onChangeMode() {
        onChangeMode(0);
    }

    public void onClickDelete(boolean z) {
        onDeleteTemplate(this.mRecyclerViewItemData.getSelectedTemplates());
        onDeleteDone(false, z);
        this.mRecyclerViewItemData.clearSelectedTemplates();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onDeleteDone(boolean z, boolean z2) {
        Logger.m10999d(TAG, "onDeleteDone#");
        if (this.mDeletedItemList.isEmpty()) {
            onChangeMode(0);
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        for (TemplateItem templateItem : this.mDeletedItemList) {
            if (templateItem != null) {
                String path = templateItem.getPath();
                deleteFile(templateItem);
                arrayList.add(path);
                if (new DocumentStyleRepository().deleteTemplateData(path) && z) {
                    this.mSelectedTemplateData.setDefaultTemplateData();
                }
                if (z2 && templateItem.getType() == this.mSelectedTemplateData.getSelectedTemplateType() && templateItem.getPath().equals(this.mSelectedTemplateData.getSelectedTemplate())) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            resetPageThumbnail();
            this.mSelectedTemplateData.setNoTemplateData();
        }
        this.mDeletedItemList.clear();
        this.mRecyclerViewItemData.setItemMode(0);
        deleteTemplateRepository(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onDeleteTemplate(List<TemplateItem> list) {
        Logger.m10999d(TAG, "onDeleteTemplate#");
        for (TemplateItem templateItem : list) {
            if (this.mRecyclerViewItemData.getItemIndex(templateItem) < 0) {
                Logger.m10999d(TAG, "onDeleteTemplate# invalid item !!" + this.mRecyclerViewItemData.getItemIndex(templateItem));
                return;
            }
            if (!this.mDeletedItemList.contains(templateItem)) {
                this.mDeletedItemList.add(templateItem);
                this.mRecyclerViewItemData.deleteItem(templateItem);
                this.mItemData.remove(templateItem);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public boolean onDownloadTemplate(Context context, TemplateItem templateItem) {
        return false;
    }

    public void onEditDialogResult(String str) {
        TemplateItem renameItem = this.mRecyclerViewItemData.getRenameItem();
        if (renameItem == null) {
            return;
        }
        renameItem.setName(str);
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createTemplateRepository().updateTitle(renameItem.getUuid(), str);
        this.mRecyclerViewItemData.notifyItemChanged(renameItem);
        this.mRecyclerViewItemData.clearSelectedTemplates();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onItemClicked(int i) {
        this.mView.onItemClicked(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public boolean onItemLongPressed(int i) {
        this.mView.onItemLongPressed(i);
        return false;
    }

    public abstract void onSaveInstanceState(@NonNull Bundle bundle);

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onSelectTemplate(int i, TemplateItem templateItem) {
        Logger.m10999d(TAG, "onSelectTemplate# mode:" + this.mItemData.getItemMode());
        if (this.mItemData.getItemMode() == 1) {
            return;
        }
        this.mView.onSelectItem(i, templateItem);
    }

    public abstract void onSelectedTemplateChanged();

    public int requestSelectAllItems(boolean z) {
        return this.mRecyclerViewItemData.requestSelectAllItems(z);
    }

    public abstract void resetPageThumbnail();

    public void restoreDeletedItemList() {
        Logger.m10999d(TAG, "restoreDeletedItemList#");
        this.mDeletedItemList.clear();
        this.mTemplatesPresenter.loadItemData();
    }

    public void restoreSetMode() {
        if (this.mRestoreItemMode == 1) {
            this.mRecyclerViewItemData.setItemMode(1);
            Logger.m10999d(TAG, "restoreSetMode# templateType: " + getTemplateType() + ", deletedItemSize: " + this.mDeletedItemList.size());
            if (this.mDeletedItemList.isEmpty()) {
                return;
            }
            this.mRecyclerViewItemData.deleteItems(this.mDeletedItemList);
        }
    }

    public abstract void restoreState(@NonNull Bundle bundle);

    public void setRecyclerViewItemData(RecyclerViewItemData recyclerViewItemData) {
        this.mRecyclerViewItemData = recyclerViewItemData;
    }

    public void setSelectedTemplateData(SelectedTemplateData selectedTemplateData) {
        this.mSelectedTemplateData = selectedTemplateData;
    }

    public void onChangeMode(int i) {
        AbstractC0000a.m3D(i, "onChangeMode# ", TAG);
        if (i == 0) {
            restoreDeletedItemList();
        }
        this.mRecyclerViewItemData.setItemMode(i);
    }

    private void scrollToPosition(TemplateItem templateItem) {
        this.mView.scrollToPosition(templateItem.getType(), Math.max(this.mRecyclerViewItemData.getItemIndex(templateItem), 0));
    }
}
