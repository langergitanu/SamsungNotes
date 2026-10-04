package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.item.RecyclerViewItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.PdfTemplateThumbnail;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.TaskDownloadPdfTemplate;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.util.ArrayList;
import java.util.List;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PdfTemplatePresenterUtil {
    private static final String TAG = CTLogger.createTag("PdfTemplatePresenterUtil");

    public static void downloadUrlTemplatePdf(Context context, ChangeTemplatesContract.View view, TemplateItem templateItem, String str, TaskDownloadPdfTemplate taskDownloadPdfTemplate, RecyclerViewItemData recyclerViewItemData) {
        if (!RequestToSyncManager.INSTANCE.isDataNetworkAvailable(context)) {
            showNetworkErrorToast(context);
            return;
        }
        Logger.m11003i(TAG, "downloadUrlTemplatePdf#");
        taskDownloadPdfTemplate.setInputValue(new TaskDownloadPdfTemplate.InputValues(view.getFragment().getParentFragmentManager(), context, templateItem.getPdfUris(), str, true));
        taskDownloadPdfTemplate.setTaskCallback(getDownloadUrlPdfCallback(context, templateItem, str, recyclerViewItemData));
        taskDownloadPdfTemplate.run();
    }

    public static Task.Callback<TaskDownloadPdfTemplate.ResultValues> getDownloadUrlPdfCallback(final Context context, final TemplateItem templateItem, final String str, final RecyclerViewItemData recyclerViewItemData) {
        return new Task.Callback<TaskDownloadPdfTemplate.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.PdfTemplatePresenterUtil.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDownloadPdfTemplate.ResultValues resultValues) {
                Logger.m11000e(PdfTemplatePresenterUtil.TAG, "downloadUrlTemplatePdf#onError# " + resultValues.getErrorCode());
                resultValues.showErrorToast(true);
                recyclerViewItemData.notifyItemChanged(templateItem);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDownloadPdfTemplate.ResultValues resultValues) {
                Logger.m11003i(PdfTemplatePresenterUtil.TAG, "downloadUrlTemplatePdf#onSuccess# ");
                PdfTemplatePresenterUtil.updateDefaultPdfUrlItem(context, templateItem, resultValues.getPathList(), str, recyclerViewItemData);
            }
        };
    }

    public static TypedArray getItemIndexArray(int i) {
        return i != 11 ? i != 14 ? i != 17 ? i != 20 ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_creative_template_item_index) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_journals_template_item_index) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_planners_template_item_index) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_academic_template_item_index) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_basic_template_item_index);
    }

    public static TypedArray getItemNameArray() {
        return TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_pdf_url_template_name_res);
    }

    public static int[] getItemPageCountArray(Context context, float f) {
        return DocumentPageRatio.PageRatioType.LONG.equal(f) ? context.getResources().getIntArray(C9086R.array.comp_change_template_pdf_long_page_count) : DocumentPageRatio.PageRatioType.A4_LANDSCAPE.equal(f) ? context.getResources().getIntArray(C9086R.array.comp_change_template_pdf_land_page_count) : context.getResources().getIntArray(C9086R.array.comp_change_template_pdf_page_count);
    }

    public static TypedArray getItemResourceArray(float f) {
        return DocumentPageRatio.PageRatioType.LONG.equal(f) ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_pdf_url_template_long_drawable_res) : DocumentPageRatio.PageRatioType.A4_LANDSCAPE.equal(f) ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_pdf_url_template_land_drawable_res) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_pdf_url_template_drawable_res);
    }

    public static TypedArray getItemTypeArray(int i) {
        return i != 11 ? i != 14 ? i != 17 ? i != 20 ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_creative_template_item_type) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_journals_template_item_type) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_planners_template_item_type) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_academic_template_item_type) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_basic_template_item_type);
    }

    public static int getLoadItemIndex(float f) {
        if (DocumentPageRatio.PageRatioType.LONG.equal(f)) {
            return 1;
        }
        return DocumentPageRatio.PageRatioType.A4_LANDSCAPE.equal(f) ? 2 : 0;
    }

    public static String getPdfTemplateNameFromPage(SpenWPage spenWPage) {
        String filePath;
        int iLastIndexOf;
        ArrayList<SpenWPage.PDFData> pDFData = spenWPage.getPDFData();
        return (pDFData == null || pDFData.isEmpty() || (filePath = pDFData.get(0).getFilePath()) == null || (iLastIndexOf = filePath.lastIndexOf(64)) < 0) ? "" : FileUtils.findFile(BaseUtils.getContext().getDir(TemplateConstants.TEMPLATE_FOLDER_ROOT, 0), filePath.substring(iLastIndexOf + 1));
    }

    public static String[][] getPdfUriStringArray(Context context, boolean z) {
        return z ? new String[][]{context.getResources().getStringArray(C9086R.array.comp_change_template_pdf_url_template_stg_v2), context.getResources().getStringArray(C9086R.array.comp_change_template_pdf_url_long_template_stg_v2), context.getResources().getStringArray(C9086R.array.comp_change_template_pdf_file_land_template_stg_v2)} : new String[][]{context.getResources().getStringArray(C9086R.array.comp_change_template_pdf_url_template_v2), context.getResources().getStringArray(C9086R.array.comp_change_template_pdf_url_long_template_v2), context.getResources().getStringArray(C9086R.array.comp_change_template_pdf_file_land_template_v2)};
    }

    public static int getTemplateTypeFromTemplateName(String str, float f) {
        int i;
        String[] strArr = getPdfUriStringArray(BaseUtils.getContext(), false)[getLoadItemIndex(f)];
        Integer numValueOf = null;
        for (int i2 : TemplateViewType.TYPE_PDF_TEMPLATES) {
            if (numValueOf != null) {
                break;
            }
            TypedArray itemIndexArray = getItemIndexArray(i2);
            TypedArray itemTypeArray = getItemTypeArray(i2);
            int length = itemIndexArray.length();
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (itemTypeArray.getInt(i4, -1) == 1 && (i = itemIndexArray.getInt(i4, -1)) >= 0) {
                    if (FileUtils.extractFileName(str).equals(FileUtils.extractFileName(strArr[i]))) {
                        numValueOf = Integer.valueOf(i2);
                        break;
                    }
                }
                i4++;
            }
            itemIndexArray.recycle();
        }
        if (numValueOf == null) {
            numValueOf = 5;
        }
        return numValueOf.intValue();
    }

    public static boolean isSelectedTemplateItem(String str, TemplateItem templateItem) {
        String path = templateItem.getPath();
        return !TextUtils.isEmpty(path) && path.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showDownloadConfirmDialog$0(Context context, ChangeTemplatesContract.View view, TemplateItem templateItem, String str, TaskDownloadPdfTemplate taskDownloadPdfTemplate, RecyclerViewItemData recyclerViewItemData, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        downloadUrlTemplatePdf(context, view, templateItem, str, taskDownloadPdfTemplate, recyclerViewItemData);
    }

    public static List<Uri> makePdfUriList(String[][] strArr, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uri.parse(strArr[0][i]));
        arrayList.add(Uri.parse(strArr[1][i]));
        arrayList.add(Uri.parse(strArr[2][i]));
        return arrayList;
    }

    public static boolean onDownloadTemplate(Context context, ChangeTemplatesContract.View view, TemplateItem templateItem, String str, TaskDownloadPdfTemplate taskDownloadPdfTemplate, RecyclerViewItemData recyclerViewItemData) {
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (!companion.isDataNetworkAvailable(context)) {
            showNetworkErrorToast(context);
            return false;
        }
        if (companion.isWiFiAvailable(context)) {
            downloadUrlTemplatePdf(context, view, templateItem, str, taskDownloadPdfTemplate, recyclerViewItemData);
            return true;
        }
        Logger.m11003i(TAG, "onDownloadTemplate# wifi is not available");
        showDownloadConfirmDialog(context, view, templateItem, str, taskDownloadPdfTemplate, recyclerViewItemData);
        return false;
    }

    public static void showDownloadConfirmDialog(final Context context, final ChangeTemplatesContract.View view, final TemplateItem templateItem, final String str, final TaskDownloadPdfTemplate taskDownloadPdfTemplate, final RecyclerViewItemData recyclerViewItemData) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setMessage(C9086R.string.change_template_download_pdf_using_mobile_data);
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PdfTemplatePresenterUtil.lambda$showDownloadConfirmDialog$0(context, view, templateItem, str, taskDownloadPdfTemplate, recyclerViewItemData, dialogInterface, i);
            }
        });
        alertDialogBuilderForAppCompat.setNegativeButton(C9086R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0140a(24));
        alertDialogBuilderForAppCompat.show();
    }

    public static void showNetworkErrorToast(Context context) {
        Logger.m11003i(TAG, "showNetworkErrorToast# network is not available");
        ToastHandler.show(context, C9086R.string.change_template_network_error_message, 0);
    }

    public static void updateDefaultPdfUrlItem(Context context, TemplateItem templateItem, List<String> list, String str, RecyclerViewItemData recyclerViewItemData) {
        if (list == null || list.isEmpty()) {
            Logger.m11000e(TAG, "updateDefaultPdfUrlItem# pdfPathList is null");
            return;
        }
        SpenNotePdfImport spenNotePdfImport = new SpenNotePdfImport(context);
        try {
            String str2 = list.get(templateItem.getLoadItemIndex());
            if (!FileUtils.exists(str2)) {
                Logger.m11000e(TAG, "updateDefaultPdfUrlItem# the pdf file not exists. " + LoggerBase.getEncode(str2));
                return;
            }
            String pdfDrawablePath = PdfTemplateThumbnail.getPdfDrawablePath(context, spenNotePdfImport, new PdfTemplateThumbnail.PdfTemplateInfo(str, str2));
            if (pdfDrawablePath != null) {
                templateItem.setDrawablePath(pdfDrawablePath);
                templateItem.setPath(str2);
                templateItem.setMode(0);
            }
            recyclerViewItemData.notifyItemChanged(templateItem);
        } catch (Exception e) {
            Logger.m11001e(TAG, "updateDefaultPdfUrlItem# exception", e);
        } finally {
            spenNotePdfImport.close();
        }
    }
}
