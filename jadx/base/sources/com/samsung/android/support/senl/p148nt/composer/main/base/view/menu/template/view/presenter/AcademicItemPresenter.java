package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.AcademicItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.PdfTemplateThumbnail;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AcademicItemPresenter extends ItemPresenter {
    private static final String TAG = "AcademicItemPresenter";
    private final String mCachePath;
    private final TaskDownloadPdfTemplate mDownloadPdfTask;
    private float mPageRatio;
    private SelectedTemplateData mSelectedTemplateData;

    public AcademicItemPresenter(ChangeTemplatesContract.ItemPresenter itemPresenter, TaskDownloadPdfTemplate taskDownloadPdfTemplate, float f) {
        super(itemPresenter);
        this.mTemplatesPresenter = itemPresenter;
        this.mDownloadPdfTask = taskDownloadPdfTemplate;
        this.mCachePath = itemPresenter.getDefaultPdfTemplatesFolder().getPath() + File.separator;
        this.mPageRatio = f;
    }

    private void loadTemplateItems(Context context) {
        TemplateItem templateItem;
        String[][] pdfUriStringArray = ItemPresenter.DEBUG ? PdfTemplatePresenterUtil.getPdfUriStringArray(context, true) : PdfTemplatePresenterUtil.getPdfUriStringArray(context, false);
        int[] itemPageCountArray = PdfTemplatePresenterUtil.getItemPageCountArray(context, this.mPageRatio);
        int loadItemIndex = PdfTemplatePresenterUtil.getLoadItemIndex(this.mPageRatio);
        TypedArray itemResourceArray = PdfTemplatePresenterUtil.getItemResourceArray(this.mPageRatio);
        TypedArray itemNameArray = PdfTemplatePresenterUtil.getItemNameArray();
        TypedArray itemIndexArray = PdfTemplatePresenterUtil.getItemIndexArray(14);
        SpenNotePdfImport spenNotePdfImport = new SpenNotePdfImport(context);
        try {
            try {
                PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo = new PdfTemplateThumbnail.PdfTemplateInfo(this.mCachePath);
                int length = itemIndexArray.length();
                for (int i = 0; i < length; i++) {
                    int i2 = itemIndexArray.getInt(i, -1);
                    String str = this.mCachePath + FileUtils.getFileNameFromFilePath(pdfUriStringArray[loadItemIndex][i2]);
                    if (FileUtils.exists(str)) {
                        pdfTemplateInfo.setPdfFilePath(str);
                        templateItem = new TemplateItem(14, 0, itemNameArray.getString(i2), str, PdfTemplateThumbnail.getPdfDrawablePath(context, spenNotePdfImport, pdfTemplateInfo), true);
                    } else {
                        templateItem = new TemplateItem(14, 2, itemNameArray.getString(i2), str, itemResourceArray.getResourceId(i2, -1));
                        templateItem.setPdfUris(makePdfUriList(pdfUriStringArray, i2), loadItemIndex);
                    }
                    templateItem.setPageCount(itemPageCountArray[i2]);
                    this.mItemData.addItem(templateItem);
                }
            } catch (Exception unused) {
                Logger.m11000e(TAG, "loadDefaultPdfUrlItem# exception");
            }
            itemResourceArray.recycle();
            itemNameArray.recycle();
            itemIndexArray.recycle();
            spenNotePdfImport.close();
        } catch (Throwable th) {
            itemResourceArray.recycle();
            itemNameArray.recycle();
            itemIndexArray.recycle();
            spenNotePdfImport.close();
            throw th;
        }
    }

    private List<Uri> makePdfUriList(String[][] strArr, int i) {
        return PdfTemplatePresenterUtil.makePdfUriList(strArr, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public int getTemplateType() {
        return 14;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ItemPresenter
    public void initItemData() {
        this.mItemData = new AcademicItemData();
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
        Logger.m10999d(TAG, "onSelectTemplate# mode:" + this.mItemData.getItemMode());
        if (templateItem.getMode() == 2) {
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
        if (this.mSelectedTemplateData.getSelectedTemplateType() == getTemplateType()) {
            this.mSelectedTemplateData.setSelectedTemplateData(getTemplateType(), this.mItemData.getItemDataList().get(this.mRecyclerViewItemData.getSelectedItemIndex()).getPath());
        }
    }
}
