package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.ItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.RecyclerViewItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.dialog.TemplatePreviewDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ItemPresenter implements OnItemActionListener {
    protected static boolean DEBUG = false;
    private static final String TAG = "ItemPresenter";
    protected ItemData mItemData;
    protected RecyclerViewItemData mRecyclerViewItemData;
    private TemplatePreviewDialog mTemplatePreviewDialog;
    protected ChangeTemplatesContract.ItemPresenter mTemplatesPresenter;
    protected ChangeTemplatesContract.View mView;

    public ItemPresenter(ChangeTemplatesContract.ItemPresenter itemPresenter) {
        this.mTemplatesPresenter = itemPresenter;
        initItemData();
    }

    public void attachView(ChangeTemplatesContract.View view) {
        this.mView = view;
    }

    public ItemData getItemData() {
        return this.mItemData;
    }

    public int getTemplateType() {
        return -1;
    }

    public abstract void initItemData();

    public void initItems(Context context) {
        this.mItemData.initItems(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onDeleteDone(boolean z, boolean z2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public boolean onDownloadTemplate(Context context, TemplateItem templateItem) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onSelectTemplate(int i, TemplateItem templateItem) {
        Logger.m10999d(TAG, "onSelectTemplate#");
        this.mView.onSelectItem(i, templateItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onShowTemplatePreviewDialog(Context context, TemplateItem templateItem) {
        Logger.m10999d(TAG, "onShowTemplatePreviewDialog#");
        if (this.mTemplatePreviewDialog == null) {
            this.mTemplatePreviewDialog = new TemplatePreviewDialog();
        }
        this.mTemplatePreviewDialog.onShowTemplatePreviewDialog(context, templateItem);
    }

    public void setRecyclerViewItemData(RecyclerViewItemData recyclerViewItemData) {
        this.mRecyclerViewItemData = recyclerViewItemData;
    }

    public void updateItemsDrawable(float f) {
    }

    public void updateItemsDrawable(Context context, float f) {
    }
}
