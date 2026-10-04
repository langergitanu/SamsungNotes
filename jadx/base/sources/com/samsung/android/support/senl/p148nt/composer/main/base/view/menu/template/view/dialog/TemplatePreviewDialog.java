package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.dialog.TemplatePreviewDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplatePreviewDialog {
    private static final int MAX_PAGE_COUNT_FOR_ADDED_PDF_TEMPLATE = 10;
    private static final String TAG = CTLogger.createTag("TemplatePreviewDialog");

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.dialog.TemplatePreviewDialog$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C104531 implements Task.Callback<ResultValues> {
        final /* synthetic */ Context val$context;

        public C104531(Context context) {
            this.val$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$1(Context context) {
            ToastHandler.show(context, C9086R.string.change_template_preview_load_failed, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(Context context, ResultValues resultValues) {
            if ((context instanceof Activity) && CommonUtil.isNotAvailableActivity((Activity) context)) {
                Logger.m11000e(TemplatePreviewDialog.TAG, "onShowTemplatePreviewDialog# isNotAvailableActivity true");
            } else {
                TemplatePreviewDialog.this.loadAllPagesThumbnail(context, resultValues.getThumbnails());
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onError(ResultValues resultValues) {
            Logger.m11000e(TemplatePreviewDialog.TAG, "getLoadPdfThumbnailCallback# onError#");
            Handler handler = new Handler(Looper.getMainLooper());
            final Context context = this.val$context;
            handler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.dialog.b
                @Override // java.lang.Runnable
                public final void run() {
                    TemplatePreviewDialog.C104531.lambda$onError$1(context);
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onSuccess(@NonNull final ResultValues resultValues) {
            Logger.m11003i(TemplatePreviewDialog.TAG, "getLoadPdfThumbnailCallback# onSuccess#");
            Handler handler = new Handler(Looper.getMainLooper());
            final Context context = this.val$context;
            handler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.dialog.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7189a.lambda$onSuccess$0(context, resultValues);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private final boolean mIsLongPage;
        private final int mPageCount;
        private final String mPdfFilePath;

        public InputValues(Context context, String str, int i) {
            this.mContext = context;
            this.mPdfFilePath = str;
            this.mPageCount = i;
            this.mIsLongPage = str.contains("_long") || str.contains("_Long");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final List<Bitmap> mThumbnails = new ArrayList();

        @NonNull
        public List<Bitmap> getThumbnails() {
            return this.mThumbnails;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TaskLoadPdfThumbnails extends SingleThreadTask<InputValues, ResultValues> {
        private static final String TAG = CTLogger.createTag("TaskLoadPdfThumbnails");

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$executeTask$0(InputValues inputValues) throws Throwable {
            int dimensionPixelSize = inputValues.mIsLongPage ? inputValues.mContext.getResources().getDimensionPixelSize(C9086R.dimen.change_template_preview_dialog_thumbnail_width_long) : inputValues.mContext.getResources().getDimensionPixelSize(C9086R.dimen.change_template_preview_dialog_thumbnail_width);
            ResultValues resultValues = new ResultValues();
            SpenNotePdfImport spenNotePdfImport = null;
            try {
                try {
                    SpenNotePdfImport spenNotePdfImport2 = new SpenNotePdfImport(inputValues.mContext);
                    for (int i = 0; i < inputValues.mPageCount; i++) {
                        try {
                            Bitmap pageBitmap = spenNotePdfImport2.getPageBitmap(inputValues.mPdfFilePath, "", i, dimensionPixelSize);
                            if (pageBitmap != null) {
                                resultValues.mThumbnails.add(pageBitmap);
                            }
                        } catch (Exception e) {
                            e = e;
                            spenNotePdfImport = spenNotePdfImport2;
                            Logger.m11000e(TAG, "executeTask, e: " + e.getMessage());
                            if (spenNotePdfImport != null) {
                                spenNotePdfImport.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            spenNotePdfImport = spenNotePdfImport2;
                            if (spenNotePdfImport != null) {
                                spenNotePdfImport.close();
                            }
                            throw th;
                        }
                    }
                    spenNotePdfImport2.close();
                } catch (Exception e2) {
                    e = e2;
                }
                notifyCallback(!resultValues.mThumbnails.isEmpty(), resultValues);
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
        public void executeTask(@NonNull final InputValues inputValues) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
            this.mExecutorService = executorServiceNewSingleThreadExecutor;
            executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.dialog.c
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f7193a.lambda$executeTask$0(inputValues);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAllPagesThumbnail(Context context, @NonNull List<Bitmap> list) {
        Logger.m11000e(TAG, "loadAllPagesThumbnail# Bitmap size : " + list.size());
        View viewInflate = LayoutInflater.from(context).inflate(C9086R.layout.comp_template_preview_dialog, (ViewGroup) null);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(C9086R.id.comp_template_preview_container);
        viewGroup.setContentDescription(context.getResources().getQuantityString(C9086R.plurals.plural_composer_pages_in_template, 2, 2) + " " + context.getString(C9086R.string.composer_swipe_2_finger_scroll));
        for (Bitmap bitmap : list) {
            View viewInflate2 = LayoutInflater.from(context).inflate(C9086R.layout.comp_template_preview_dialog_item, (ViewGroup) null);
            ((ImageView) viewInflate2.findViewById(C9086R.id.comp_template_preview_item_image)).setImageBitmap(bitmap);
            viewGroup.addView(viewInflate2);
        }
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setView(viewInflate);
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.dialog_ok, new DialogInterfaceOnClickListenerC0140a(23));
        alertDialogBuilderForAppCompat.show();
    }

    public void onShowTemplatePreviewDialog(Context context, TemplateItem templateItem) {
        int pageCount = templateItem.getPageCount();
        if (templateItem.getType() == 5 && pageCount > 10) {
            pageCount = 10;
        }
        InputValues inputValues = new InputValues(context, templateItem.getPath(), pageCount);
        TaskLoadPdfThumbnails taskLoadPdfThumbnails = new TaskLoadPdfThumbnails();
        taskLoadPdfThumbnails.setInputValue(inputValues);
        taskLoadPdfThumbnails.setTaskCallback(new C104531(context));
        taskLoadPdfThumbnails.run();
    }
}
