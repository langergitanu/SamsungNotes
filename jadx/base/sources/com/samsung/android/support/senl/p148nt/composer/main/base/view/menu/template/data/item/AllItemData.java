package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item;

import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AllItemData {
    private static final String TAG = CTLogger.createTag("AllItemData");
    public ItemData mAcademicItemData;
    private final List<TemplateItem> mAllItems = new ArrayList();
    public ItemData mBasicItemData;
    public ItemData mCreativeItemData;
    public ItemData mCustomItemData;
    public ItemData mPlanItemData;
    public ItemData mRecordItemData;

    public AllItemData(ItemData itemData, ItemData itemData2, ItemData itemData3, ItemData itemData4, ItemData itemData5, ItemData itemData6) {
        this.mBasicItemData = itemData;
        this.mAcademicItemData = itemData2;
        this.mPlanItemData = itemData3;
        this.mRecordItemData = itemData4;
        this.mCreativeItemData = itemData5;
        this.mCustomItemData = itemData6;
    }

    private boolean isSelectedTemplateItem(SelectedTemplateData selectedTemplateData, TemplateItem templateItem) {
        if (selectedTemplateData.getSelectedTemplateType() != templateItem.getType()) {
            return false;
        }
        if (selectedTemplateData.getSelectedTemplateType() == 10 || selectedTemplateData.getSelectedTemplateType() == 11) {
            return this.mBasicItemData.isSelectedTemplateItem(selectedTemplateData.getSelectedTemplate(), templateItem);
        }
        if (selectedTemplateData.getSelectedTemplateType() == 13 || selectedTemplateData.getSelectedTemplateType() == 14) {
            return this.mAcademicItemData.isSelectedTemplateItem(selectedTemplateData.getSelectedTemplate(), templateItem);
        }
        if (selectedTemplateData.getSelectedTemplateType() == 16 || selectedTemplateData.getSelectedTemplateType() == 17) {
            return this.mPlanItemData.isSelectedTemplateItem(selectedTemplateData.getSelectedTemplate(), templateItem);
        }
        if (selectedTemplateData.getSelectedTemplateType() == 19 || selectedTemplateData.getSelectedTemplateType() == 20) {
            return this.mRecordItemData.isSelectedTemplateItem(selectedTemplateData.getSelectedTemplate(), templateItem);
        }
        if (selectedTemplateData.getSelectedTemplateType() == 22 || selectedTemplateData.getSelectedTemplateType() == 23) {
            return this.mCreativeItemData.isSelectedTemplateItem(selectedTemplateData.getSelectedTemplate(), templateItem);
        }
        if (selectedTemplateData.getSelectedTemplateType() == 3 || selectedTemplateData.getSelectedTemplateType() == 5) {
            return this.mCustomItemData.isSelectedTemplateItem(selectedTemplateData.getSelectedTemplate(), templateItem);
        }
        return false;
    }

    public void addAllItems() {
        this.mAllItems.clear();
        this.mAllItems.addAll(this.mBasicItemData.getItemDataList());
        this.mAllItems.addAll(this.mAcademicItemData.getItemDataList());
        this.mAllItems.addAll(this.mPlanItemData.getItemDataList());
        this.mAllItems.addAll(this.mRecordItemData.getItemDataList());
        this.mAllItems.addAll(this.mCreativeItemData.getItemDataList());
        this.mAllItems.addAll(this.mCustomItemData.getItemDataList());
        Logger.m11003i(TAG, "addAllItems# " + this.mAllItems.size());
    }

    public TemplateItem getSelectedItem(SelectedTemplateData selectedTemplateData) {
        for (TemplateItem templateItem : this.mAllItems) {
            if (isSelectedTemplateItem(selectedTemplateData, templateItem)) {
                return templateItem;
            }
        }
        return this.mBasicItemData.getFirstItem();
    }

    public TemplateItem updateSelectedItem(SelectedTemplateData selectedTemplateData) {
        TemplateItem templateItem = null;
        for (TemplateItem templateItem2 : this.mAllItems) {
            if (templateItem != null) {
                templateItem2.setSelected(false);
            } else if (isSelectedTemplateItem(selectedTemplateData, templateItem2)) {
                templateItem2.setSelected(true);
                templateItem = templateItem2;
            } else {
                templateItem2.setSelected(false);
            }
        }
        if (templateItem != null) {
            return templateItem;
        }
        TemplateItem firstItem = this.mBasicItemData.getFirstItem();
        firstItem.setSelected(true);
        return firstItem;
    }
}
