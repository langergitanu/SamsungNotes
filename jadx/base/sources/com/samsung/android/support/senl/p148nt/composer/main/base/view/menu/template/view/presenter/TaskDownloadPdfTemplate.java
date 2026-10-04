package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.AddPdfUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.PdfTemplateThumbnail;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentStyleRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p066P2.RunnableC0202d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskDownloadPdfTemplate extends SingleThreadTask<InputValues, ResultValues> {
    public static final int MAXIMUM_PDF_TEMPLATE_SIZE_MB = 5;
    private static final String PROGRESS_DIALOG = "pdf_template_dialog";
    private static final String TAG = CTLogger.createTag("TaskDownloadPdfTemplate");
    public static final String VERSION_PRE_FIX = "_v";
    private FragmentManager mFragmentManager;
    private Runnable rNotification;
    private int mErrorCode = 0;
    private final Handler mHandler = new Handler();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final Context mContext;
        private final int mErrorCode;
        private final List<String> mPathList;

        public ResultValues(Context context, List<String> list, int i) {
            this.mContext = context;
            this.mPathList = list;
            this.mErrorCode = i;
        }

        public Context getContext() {
            return this.mContext;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public List<String> getPathList() {
            return this.mPathList;
        }

        public void showErrorToast(boolean z) {
            AbstractC8014b.m7221w(new StringBuilder("showErrorToast#"), TaskDownloadPdfTemplate.TAG, this.mErrorCode);
            AddPdfUtil.showErrorToast(this.mContext, this.mErrorCode, z);
        }
    }

    public static void clearCachePath(String str, String str2) {
        File[] fileArrListFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            String preFixPath = getPreFixPath(str2);
            for (File file2 : fileArrListFiles) {
                if (file2.getAbsolutePath().contains(preFixPath) || file2.length() <= 0) {
                    FileUtils.deleteFile(file2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void defaultTemplatePdfDownload(Context context, SpenNotePdfImport spenNotePdfImport, PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo) {
        TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(C9086R.array.comp_change_template_pdf_template_raw_res);
        try {
            try {
            } catch (Exception e) {
                Logger.m11000e(TAG, "defaultTemplatePdfDownload# Exception : " + e.getMessage());
            }
            if (!needToDownloadDefaultTemplate(typedArrayObtainTypedArray, pdfTemplateInfo.getCachePath())) {
                Logger.m11003i(TAG, "defaultTemplatePdfDownload# skip.");
                return;
            }
            showProgressDialog();
            for (int i = 0; i < typedArrayObtainTypedArray.length(); i++) {
                String string = typedArrayObtainTypedArray.getString(i);
                if (string != null) {
                    String str = pdfTemplateInfo.getCachePath() + FileUtils.getFileNameFromFilePath(string);
                    if (downloadTemplatePdf(context, str, typedArrayObtainTypedArray.getResourceId(i, 0))) {
                        pdfTemplateInfo.setPdfFilePath(str);
                        String strMakeThumbnail = PdfTemplateThumbnail.makeThumbnail(context, spenNotePdfImport, pdfTemplateInfo);
                        if (TextUtils.isEmpty(strMakeThumbnail) || !new File(strMakeThumbnail).exists()) {
                            FileUtils.deleteFile(str);
                        }
                    }
                }
            }
            new DocumentStyleRepository().checkDefaultTemplateData();
            Logger.m11003i(TAG, "defaultTemplatePdfDownload# done");
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private String downloadTemplatePdf(Context context, PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo, Uri uri) {
        ContentPickerUtils.DownloadFileResult downloadFileResultDownloadPdf = ContentPickerUtils.downloadPdf(context, pdfTemplateInfo.getCachePath(), uri, AddPdfUtil.getMaximumPdfSize());
        int i = downloadFileResultDownloadPdf.mSaveResult;
        if (i != 0) {
            if (i == 1) {
                setErrorCode(ISpenNotePdfManager.ResultType.RESULT_TYPE_CANCEL.ordinal());
                return "";
            }
            if (i == 2) {
                setErrorCode(67108864);
                return "";
            }
            if (i == 3) {
                setErrorCode(65536);
                return "";
            }
        } else {
            if (TextUtils.isEmpty(downloadFileResultDownloadPdf.mFilePath)) {
                setErrorCode(16777216);
                return "";
            }
            pdfTemplateInfo.setPdfFilePath(downloadFileResultDownloadPdf.mFilePath);
        }
        if (handlePdfError(context, pdfTemplateInfo)) {
            FileUtils.deleteFile(pdfTemplateInfo.getPdfFilePath());
            return "";
        }
        if (!new File(pdfTemplateInfo.getPdfFilePath()).exists()) {
            setErrorCode(1048576);
            return "";
        }
        Logger.m11003i(TAG, "downloadTemplatePdf#, path : " + Logger.getEncode(pdfTemplateInfo.getPdfFilePath()));
        return pdfTemplateInfo.getPdfFilePath();
    }

    private static String getPreFixPath(String str) {
        int iLastIndexOf = str.lastIndexOf(VERSION_PRE_FIX);
        if (iLastIndexOf > 0) {
            return str.substring(0, iLastIndexOf);
        }
        int iLastIndexOf2 = str.lastIndexOf(Constants.PDF_EXTENSION_WITH_DOT);
        return iLastIndexOf2 > 0 ? str.substring(0, iLastIndexOf2) : str;
    }

    private boolean handlePdfError(Context context, PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo) {
        ISpenNotePdfManager.ResultType resultTypeHasOwnerPermission;
        SpenNotePdfImport spenNotePdfImport = new SpenNotePdfImport(context);
        try {
            try {
                resultTypeHasOwnerPermission = spenNotePdfImport.hasOwnerPermission(pdfTemplateInfo.getPdfFilePath(), "");
            } catch (Exception e) {
                Logger.m11000e(TAG, "handlePdfError, e: " + e.getMessage());
            }
            if (ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PASSWORD.equals(resultTypeHasOwnerPermission)) {
                setErrorCode(ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PROTECTED.ordinal());
                return true;
            }
            if (AddPdfUtil.getConvertErrorCode(resultTypeHasOwnerPermission.ordinal()) != 0) {
                setErrorCode(resultTypeHasOwnerPermission.ordinal());
                return true;
            }
            return false;
        } finally {
            spenNotePdfImport.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runNotifyCallback$0(boolean z, ResultValues resultValues) {
        notifyCallback(z, resultValues);
        this.rNotification = null;
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showProgressDialog$1() {
        if (this.mFragmentManager == null) {
            Logger.m11003i(TAG, "showProgressDialog# manager is null");
            return;
        }
        Logger.m11003i(TAG, "showProgressDialog#");
        Fragment fragmentFindFragmentByTag = this.mFragmentManager.findFragmentByTag(PROGRESS_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            this.mFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
        DialogFragment dialogFragmentCreateCircleProgressDialogFragment = DialogUtils.createCircleProgressDialogFragment();
        dialogFragmentCreateCircleProgressDialogFragment.setCancelable(false);
        dialogFragmentCreateCircleProgressDialogFragment.show(this.mFragmentManager, PROGRESS_DIALOG);
        this.rNotification = null;
    }

    private boolean needToDownloadDefaultTemplate(TypedArray typedArray, String str) {
        for (int i = 0; i < typedArray.length(); i++) {
            String string = typedArray.getString(i);
            if (string != null) {
                String strM756B = AbstractC0541b.m756B(str, FileUtils.getFileNameFromFilePath(string));
                if (!FileUtils.exists(strM756B)) {
                    clearCachePath(str, strM756B);
                    return true;
                }
            }
        }
        return false;
    }

    private void removeAppData(Context context, PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo) {
        String str = pdfTemplateInfo.getPdfFilePath() + ".temp";
        FileUtils.moveFile(pdfTemplateInfo.getPdfFilePath(), str);
        SpenNotePdfImport spenNotePdfImport = new SpenNotePdfImport(context);
        try {
            try {
                spenNotePdfImport.removeAppData(str, "", pdfTemplateInfo.getPdfFilePath());
            } catch (Exception e) {
                Logger.m11000e(TAG, "removeAppData, e: " + e.getMessage());
            }
            FileUtils.deleteFile(str);
        } finally {
            spenNotePdfImport.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runNotifyCallback(boolean z, ResultValues resultValues) {
        Runnable runnable = this.rNotification;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        RunnableC0202d runnableC0202d = new RunnableC0202d(this, z, resultValues, 11);
        this.rNotification = runnableC0202d;
        this.mHandler.post(runnableC0202d);
    }

    private void setErrorCode(int i) {
        this.mErrorCode = AddPdfUtil.getConvertErrorCode(i) | this.mErrorCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> uriDownloadPdf(Context context, SpenNotePdfImport spenNotePdfImport, PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo, List<Uri> list, boolean z) {
        showProgressDialog();
        ArrayList arrayList = new ArrayList();
        Iterator<Uri> it = list.iterator();
        while (it.hasNext()) {
            Context context2 = context;
            SpenNotePdfImport spenNotePdfImport2 = spenNotePdfImport;
            PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo2 = pdfTemplateInfo;
            boolean z2 = z;
            String strUriDownloadPdf = uriDownloadPdf(context2, spenNotePdfImport2, pdfTemplateInfo2, it.next(), z2);
            if (!TextUtils.isEmpty(strUriDownloadPdf)) {
                arrayList.add(strUriDownloadPdf);
            }
            context = context2;
            spenNotePdfImport = spenNotePdfImport2;
            pdfTemplateInfo = pdfTemplateInfo2;
            z = z2;
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear ");
        Runnable runnable = this.rNotification;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.rNotification = null;
        }
        dismissProgressDialog();
        this.mErrorCode = 0;
        super.clear();
    }

    public void dismissProgressDialog() {
        if (this.mFragmentManager == null) {
            Logger.m11003i(TAG, "dismissProgressDialog# manager is null");
            return;
        }
        Logger.m11003i(TAG, "dismissProgressDialog()");
        DialogFragment dialogFragment = (DialogFragment) this.mFragmentManager.findFragmentByTag(PROGRESS_DIALOG);
        if (dialogFragment == null || dialogFragment.getDialog() == null || !dialogFragment.getDialog().isShowing()) {
            return;
        }
        dialogFragment.dismissAllowingStateLoss();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isNeedToCheckNoteSize() {
        return true;
    }

    public void showProgressDialog() {
        if (this.rNotification != null) {
            return;
        }
        RunnableC10464a runnableC10464a = new RunnableC10464a(this, 1);
        this.rNotification = runnableC10464a;
        this.mHandler.post(runnableC10464a);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        this.mFragmentManager = inputValues.mFragmentManager;
        final Context context = inputValues.mContext;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.TaskDownloadPdfTemplate.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                String str = "executeTask, e: ";
                Logger.startTime(String.valueOf(hashCode()), TaskDownloadPdfTemplate.TAG, "download pdf template start.");
                AddPdfUtil.setMaximumPdfSizeMB(5);
                PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo = new PdfTemplateThumbnail.PdfTemplateInfo(inputValues.mCachePath);
                List arrayList = new ArrayList();
                SpenNotePdfImport spenNotePdfImport = new SpenNotePdfImport(context);
                boolean z = true;
                try {
                    try {
                        if (inputValues.mUriList == null || inputValues.mUriList.isEmpty()) {
                            TaskDownloadPdfTemplate.this.defaultTemplatePdfDownload(context, spenNotePdfImport, pdfTemplateInfo);
                            str = str;
                        } else {
                            arrayList = TaskDownloadPdfTemplate.this.uriDownloadPdf(context, spenNotePdfImport, pdfTemplateInfo, (List<Uri>) inputValues.mUriList, inputValues.mIsDefault);
                            int size = inputValues.mUriList.size();
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str = size2;
                            } else {
                                z = false;
                                str = size2;
                            }
                        }
                    } catch (Exception e) {
                        Logger.m11000e(TaskDownloadPdfTemplate.TAG, str + e.getMessage());
                    }
                    spenNotePdfImport.close();
                    Logger.endTime(String.valueOf(hashCode()), TaskDownloadPdfTemplate.TAG, "download pdf template end.");
                    TaskDownloadPdfTemplate taskDownloadPdfTemplate = TaskDownloadPdfTemplate.this;
                    taskDownloadPdfTemplate.runNotifyCallback(z, new ResultValues(context, arrayList, taskDownloadPdfTemplate.mErrorCode));
                } catch (Throwable th) {
                    spenNotePdfImport.close();
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final String mCachePath;
        private final Context mContext;
        private final FragmentManager mFragmentManager;
        private boolean mIsDefault;
        private List<Uri> mUriList;

        public InputValues(FragmentManager fragmentManager, Context context, List<Uri> list, String str, boolean z) {
            this(fragmentManager, context, str);
            this.mUriList = list;
            this.mIsDefault = z;
        }

        public InputValues(FragmentManager fragmentManager, Context context, String str) {
            this.mIsDefault = true;
            this.mFragmentManager = fragmentManager;
            this.mContext = context;
            this.mCachePath = str;
        }
    }

    private String uriDownloadPdf(Context context, SpenNotePdfImport spenNotePdfImport, PdfTemplateThumbnail.PdfTemplateInfo pdfTemplateInfo, Uri uri, boolean z) {
        String mimeType = UriFileUtils.getMimeType(context, uri);
        if (mimeType != null && mimeType.contains(Constants.PDF_EXTENSION)) {
            String fileNameFromUri = FileUtils.getFileNameFromUri(context, uri);
            String strGenerateUniqueFilePath = "";
            if (!TextUtils.isEmpty(fileNameFromUri)) {
                try {
                    if (z) {
                        strGenerateUniqueFilePath = new File(pdfTemplateInfo.getCachePath(), fileNameFromUri).getAbsolutePath();
                        clearCachePath(pdfTemplateInfo.getCachePath(), strGenerateUniqueFilePath);
                    } else {
                        strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(pdfTemplateInfo.getCachePath(), fileNameFromUri);
                    }
                } catch (Exception e) {
                    AbstractC8014b.m7205g(e, new StringBuilder("uriDownloadPdf# clearCachePath Exception : "), TAG);
                }
            }
            String strDownloadTemplatePdf = downloadTemplatePdf(context, pdfTemplateInfo, uri);
            if (TextUtils.isEmpty(strDownloadTemplatePdf)) {
                Logger.m11000e(TAG, "uriDownloadPdf# pdfFilePath has some problem. uri:" + Logger.getEncode(uri.toString()));
                return null;
            }
            if (TextUtils.isEmpty(strGenerateUniqueFilePath)) {
                Logger.m11003i(TAG, "uriDownloadPdf# pdfFileName is empty. uri:" + Logger.getEncode(uri.toString()));
                strGenerateUniqueFilePath = strDownloadTemplatePdf;
            } else {
                FileUtils.moveFile(strDownloadTemplatePdf, strGenerateUniqueFilePath);
            }
            pdfTemplateInfo.setPdfFilePath(strGenerateUniqueFilePath);
            removeAppData(context, pdfTemplateInfo);
            String strMakeThumbnail = PdfTemplateThumbnail.makeThumbnail(context, spenNotePdfImport, pdfTemplateInfo);
            if (!TextUtils.isEmpty(strMakeThumbnail) && AbstractC2322a.m1607A(strMakeThumbnail)) {
                return strGenerateUniqueFilePath;
            }
            FileUtils.deleteFile(strGenerateUniqueFilePath);
            setErrorCode(1048576);
            return null;
        }
        AbstractC8014b.m7198D("UriDownloadPdf# mimeType is wrong. ", mimeType, TAG);
        setErrorCode(ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_FORMAT.ordinal());
        return null;
    }

    private boolean downloadTemplatePdf(Context context, String str, int i) {
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i2 = inputStreamOpenRawResource.read(bArr);
                        if (i2 > 0) {
                            fileOutputStream.write(bArr, 0, i2);
                        } else {
                            fileOutputStream.close();
                            inputStreamOpenRawResource.close();
                            return true;
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("downloadTemplatePdf# IOException : "), TAG);
            return false;
        }
    }
}
