package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item;

import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.BaseItemAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecyclerViewItemData {
    private static final String TAG = CTLogger.createTag("RecyclerViewItemData");
    private BaseItemAdapter mItemAdapter;
    private List<TemplateItem> mItemList = new ArrayList();

    public RecyclerViewItemData(BaseItemAdapter baseItemAdapter) {
        this.mItemAdapter = baseItemAdapter;
    }

    public void addItemToList(ItemData itemData) {
        Logger.m11004w(TAG, "addItemToList, " + itemData.getItemDataList().size());
        if (itemData.getItemDataList().isEmpty()) {
            return;
        }
        this.mItemList.clear();
        this.mItemList.addAll(itemData.getItemDataList());
        this.mItemAdapter.setItemList(this.mItemList);
        this.mItemAdapter.notifyAdapter();
    }

    public void clearItemList() {
        this.mItemList.clear();
    }

    public void clearSelectedTemplates() {
        this.mItemAdapter.clearSelectedTemplates();
    }

    public void deleteItem(TemplateItem templateItem) {
        this.mItemList.remove(templateItem);
        this.mItemAdapter.notifyAdapter();
    }

    public void deleteItems(List<TemplateItem> list) {
        this.mItemList.removeAll(list);
        this.mItemAdapter.notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.mItemList.size() - 1;
    }

    public int getItemIndex(TemplateItem templateItem) {
        return this.mItemList.indexOf(templateItem);
    }

    public List<TemplateItem> getItemList() {
        return this.mItemList;
    }

    public TemplateItem getRenameItem() {
        return this.mItemAdapter.getRenameItem();
    }

    public TemplateItem getSelectedItem() {
        for (TemplateItem templateItem : this.mItemList) {
            if (templateItem.getSelected()) {
                Logger.m10999d(TAG, "getSelectedItem# name : " + templateItem.getName());
                return templateItem;
            }
        }
        Logger.m10999d(TAG, "getSelectedItem# name : " + this.mItemList.get(0).getName());
        return this.mItemList.get(0);
    }

    public int getSelectedItemIndex() {
        return this.mItemList.indexOf(getSelectedItem());
    }

    public List<TemplateItem> getSelectedTemplates() {
        return this.mItemAdapter.getSelectedTemplates();
    }

    public void notifyItemChanged(TemplateItem templateItem) {
        this.mItemAdapter.notifyItemChanged(templateItem);
    }

    public int requestSelectAllItems(boolean z) {
        return this.mItemAdapter.requestSelectAllItems(z);
    }

    public int restoreDeleteItems(List<TemplateItem> list) {
        this.mItemList.removeAll(list);
        this.mItemAdapter.notifyAdapter();
        return this.mItemList.size();
    }

    public void setItemMode(int i) {
        Iterator<TemplateItem> it = this.mItemList.iterator();
        while (it.hasNext()) {
            it.next().setMode(i);
        }
        this.mItemAdapter.notifyAdapter();
    }
}
