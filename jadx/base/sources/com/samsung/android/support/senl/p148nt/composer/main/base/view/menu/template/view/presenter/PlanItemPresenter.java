package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.PlanItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.PdfTemplateThumbnail;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateIndexConverter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PlanItemPresenter extends ItemPresenter {
    private static final String TAG = "PlanItemPresenter";
    private final String mCachePath;
    private final TaskDownloadPdfTemplate mDownloadPdfTask;
    private float mPageRatio;
    private SelectedTemplateData mSelectedTemplateData;

    public PlanItemPresenter(ChangeTemplatesContract.ItemPresenter itemPresenter, TaskDownloadPdfTemplate taskDownloadPdfTemplate, float f) {
        super(itemPresenter);
        this.mTemplatesPresenter = itemPresenter;
        this.mDownloadPdfTask = taskDownloadPdfTemplate;
        this.mCachePath = itemPresenter.getDefaultPdfTemplatesFolder().getPath() + File.separator;
        this.mPageRatio = f;
    }

    private int convertType(int i) {
        return i == 0 ? 16 : 17;
    }

    private void loadTemplateItems(Context context) {
        TemplateItem templateItem;
        int i = 0;
        String[][] pdfUriStringArray = ItemPresenter.DEBUG ? PdfTemplatePresenterUtil.getPdfUriStringArray(context, true) : PdfTemplatePresenterUtil.getPdfUriStringArray(context, false);
        TypedArray itemResourceArray = PdfTemplatePresenterUtil.getItemResourceArray(this.mPageRatio);
        TypedArray itemNameArray = PdfTemplatePresenterUtil.getItemNameArray();
        int[] itemPageCountArray = PdfTemplatePresenterUtil.getItemPageCountArray(context, this.mPageRatio);
        int loadItemIndex = PdfTemplatePresenterUtil.getLoadItemIndex(this.mPageRatio);
        TypedArray itemResourceArray2 = ImageTemplatePresenterUtil.getItemResourceArray(this.mPageRatio);
        TypedArray itemNameArray2 = ImageTemplatePresenterUtil.getItemNameArray();
        int i2 = 16;
        TypedArray itemIndexArray = ImageTemplatePresenterUtil.getItemIndexArray(16);
        TypedArray itemTypeArray = ImageTemplatePresenterUtil.getItemTypeArray(16);
        SpenNotePdfImport spenNotePdfImport = new SpenNotePdfImport(context);
        while (itemIndexArray.length() > 0) {
            try {
                try {
                    int iConvertType = convertType(itemTypeArray.getInt(i, -1));
                    int[] iArr = itemPageCountArray;
                    int i4 = itemIndexArray.getInt(i, -1);
                    if (iConvertType == i2) {
                        this.mItemData.addItem(new TemplateItem(iConvertType, 0, itemNameArray2.getString(i4), "", itemResourceArray2.getResourceId(i4, -1)));
                    } else if (iConvertType == 17) {
                        PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo = new PdfTemplateThumbnail.PdfTemplateInfo(this.mCachePath);
                        String str = this.mCachePath + FileUtils.getFileNameFromFilePath(pdfUriStringArray[loadItemIndex][i4]);
                        if (FileUtils.exists(str)) {
                            pdfTemplateInfo.setPdfFilePath(str);
                            templateItem = new TemplateItem(17, 0, itemNameArray.getString(i4), str, PdfTemplateThumbnail.getPdfDrawablePath(context, spenNotePdfImport, pdfTemplateInfo), true);
                        } else {
                            templateItem = new TemplateItem(17, 2, itemNameArray.getString(i4), str, itemResourceArray.getResourceId(i4, -1));
                            templateItem.setPdfUris(makePdfUriList(pdfUriStringArray, i4), loadItemIndex);
                        }
                        templateItem.setPageCount(iArr[i4]);
                        this.mItemData.addItem(templateItem);
                    }
                    i++;
                    itemPageCountArray = iArr;
                    i2 = 16;
                } catch (Exception unused) {
                    Logger.m11000e(TAG, "updateBasicItems# exception");
                }
            } catch (Throwable th) {
                itemIndexArray.recycle();
                itemTypeArray.recycle();
                itemResourceArray.recycle();
                itemResourceArray2.recycle();
                spenNotePdfImport.close();
                throw th;
            }
        }
        itemIndexArray.recycle();
        itemTypeArray.recycle();
        itemResourceArray.recycle();
        itemResourceArray2.recycle();
        spenNotePdfImport.close();
    }

    private List<Uri> makePdfUriList(String[][] strArr, int i) {
        return PdfTemplatePresenterUtil.makePdfUriList(strArr, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public void initItemData() {
        this.mItemData = new PlanItemData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public void initItems(Context context) {
        super.initItems(context);
        loadTemplateItems(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public boolean onDownloadTemplate(Context context, TemplateItem templateItem) {
        return PdfTemplatePresenterUtil.onDownloadTemplate(context, this.mView, templateItem, this.mCachePath, this.mDownloadPdfTask, this.mRecyclerViewItemData);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener
    public void onSelectTemplate(int i, TemplateItem templateItem) {
        if (templateItem.getType() == 17 && templateItem.getMode() == 2) {
            return;
        }
        this.mView.onSelectItem(i, templateItem);
    }

    public void setSelectedTemplateData(SelectedTemplateData selectedTemplateData) {
        this.mSelectedTemplateData = selectedTemplateData;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public void updateItemsDrawable(Context context, float f) {
        this.mPageRatio = f;
        this.mItemData.clearItemDataList();
        initItems(context);
        if (this.mSelectedTemplateData.getSelectedTemplateType() == 16) {
            this.mSelectedTemplateData.setSelectedTemplateData(16, String.valueOf(TemplateIndexConverter.convertTemplateNameToWPageIndex(this.mItemData.getItemDataList().get(this.mRecyclerViewItemData.getSelectedItemIndex()).getName())));
        } else if (this.mSelectedTemplateData.getSelectedTemplateType() == 17) {
            this.mSelectedTemplateData.setSelectedTemplateData(17, this.mItemData.getItemDataList().get(this.mRecyclerViewItemData.getSelectedItemIndex()).getPath());
        }
    }
}
