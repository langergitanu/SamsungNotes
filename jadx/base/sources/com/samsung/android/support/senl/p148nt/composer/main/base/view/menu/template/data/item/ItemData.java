package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ItemData {
    protected List<TemplateItem> mItemDataList = new ArrayList();

    public boolean addAll(List<TemplateItem> list) {
        return this.mItemDataList.addAll(list);
    }

    public boolean addItem(TemplateItem templateItem) {
        return this.mItemDataList.add(templateItem);
    }

    public void clearItemDataList() {
        this.mItemDataList.clear();
    }

    public TemplateItem getFirstItem() {
        return this.mItemDataList.get(0);
    }

    public List<TemplateItem> getItemDataList() {
        return this.mItemDataList;
    }

    public int getItemMode() {
        if (this.mItemDataList.isEmpty()) {
            return 0;
        }
        return getFirstItem().getMode();
    }

    public void initItems(Context context) {
    }

    public abstract boolean isSelectedTemplateItem(String str, TemplateItem templateItem);

    public boolean remove(TemplateItem templateItem) {
        return this.mItemDataList.remove(templateItem);
    }
}
