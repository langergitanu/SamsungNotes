package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.content.res.TypedArray;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.BasicItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BasicItemPresenter extends ItemPresenter {
    private static final String TAG = "BasicItemPresenter";
    private float mPageRatio;

    public BasicItemPresenter(ChangeTemplatesContract.ItemPresenter itemPresenter, float f) {
        super(itemPresenter);
        this.mPageRatio = f;
        initItemData();
    }

    private int convertType(int i) {
        return i == 0 ? 10 : 11;
    }

    private void loadTemplateItems() {
        TypedArray itemNameArray = ImageTemplatePresenterUtil.getItemNameArray();
        TypedArray itemResourceArray = ImageTemplatePresenterUtil.getItemResourceArray(this.mPageRatio);
        TypedArray itemIndexArray = ImageTemplatePresenterUtil.getItemIndexArray(10);
        TypedArray itemTypeArray = ImageTemplatePresenterUtil.getItemTypeArray(10);
        for (int i = 0; i < itemNameArray.length(); i++) {
            try {
                try {
                    int i2 = itemIndexArray.getInt(i, -1);
                    this.mItemData.addItem(new TemplateItem(convertType(itemTypeArray.getInt(i, -1)), 0, itemNameArray.getString(i2), "", itemResourceArray.getResourceId(i2, -1)));
                } catch (Exception unused) {
                    Logger.m11000e(TAG, "initBasicItemData# exception");
                }
            } finally {
                itemNameArray.recycle();
                itemResourceArray.recycle();
                itemIndexArray.recycle();
                itemTypeArray.recycle();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public int getTemplateType() {
        return 10;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public void initItemData() {
        this.mItemData = new BasicItemData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public void initItems(Context context) {
        super.initItems(context);
        loadTemplateItems();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onSelectTemplate(int i, TemplateItem templateItem) {
        Logger.m10999d(TAG, "onSelectTemplate#");
        this.mView.onSelectItem(i, templateItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public void updateItemsDrawable(float f) {
        this.mPageRatio = f;
        TypedArray itemResourceArray = ImageTemplatePresenterUtil.getItemResourceArray(f);
        TypedArray itemIndexArray = ImageTemplatePresenterUtil.getItemIndexArray(10);
        TypedArray itemTypeArray = ImageTemplatePresenterUtil.getItemTypeArray(10);
        try {
            try {
                int i = 0;
                for (TemplateItem templateItem : this.mItemData.getItemDataList()) {
                    if (templateItem.getType() == convertType(itemTypeArray.getInt(i, -1))) {
                        int i2 = i + 1;
                        templateItem.setDrawableResId(itemResourceArray.getResourceId(itemIndexArray.getInt(i, -1), -1));
                        i = i2;
                    }
                }
            } catch (Exception unused) {
                Logger.m11000e(TAG, "updateBasicItems# exception");
            }
        } finally {
            itemResourceArray.recycle();
            itemIndexArray.recycle();
            itemTypeArray.recycle();
        }
    }
}
