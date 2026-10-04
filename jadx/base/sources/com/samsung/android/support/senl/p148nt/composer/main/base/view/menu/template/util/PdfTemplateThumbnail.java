package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PdfTemplateThumbnail {
    private static final String TAG = CTLogger.createTag("PdfDataHelper");

    public static String getPdfDrawablePath(Context context, @NonNull SpenNotePdfImport spenNotePdfImport, PdfTemplateInfo pdfTemplateInfo) {
        return getPdfDrawablePath(spenNotePdfImport, pdfTemplateInfo, getTemplateViewWidth(context));
    }

    public static float getTemplateViewWidth(Context context) {
        return context.getResources().getDimensionPixelSize(C9086R.dimen.change_template_item_width);
    }

    public static String makeThumbnail(Context context, SpenNotePdfImport spenNotePdfImport, PdfTemplateInfo pdfTemplateInfo) {
        return makeThumbnail(spenNotePdfImport, pdfTemplateInfo, getTemplateViewWidth(context));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PdfTemplateInfo {
        private final String mCachePath;
        private String mPdfFilePath;

        public PdfTemplateInfo(String str) {
            this.mCachePath = str;
        }

        public String getCachePath() {
            return this.mCachePath;
        }

        public String getPdfFilePath() {
            return this.mPdfFilePath;
        }

        public void setPdfFilePath(String str) {
            this.mPdfFilePath = str;
        }

        public PdfTemplateInfo(String str, String str2) {
            this(str);
            this.mPdfFilePath = str2;
        }
    }

    public static String getPdfDrawablePath(@NonNull SpenNotePdfImport spenNotePdfImport, PdfTemplateInfo pdfTemplateInfo, float f) {
        if (!FileUtils.exists(pdfTemplateInfo.mPdfFilePath)) {
            Logger.m11000e(TAG, "getPdfDrawablePath# pdf file is not exist. " + Logger.getEncode(pdfTemplateInfo.mPdfFilePath));
            return null;
        }
        String str = pdfTemplateInfo.mPdfFilePath.substring(0, pdfTemplateInfo.mPdfFilePath.lastIndexOf(46)) + ".jpg";
        return !FileUtils.exists(str) ? makeThumbnail(spenNotePdfImport, pdfTemplateInfo, f) : str;
    }

    private static String makeThumbnail(SpenNotePdfImport spenNotePdfImport, PdfTemplateInfo pdfTemplateInfo, float f) {
        if (TextUtils.isEmpty(pdfTemplateInfo.mPdfFilePath) || !new File(pdfTemplateInfo.mPdfFilePath).exists()) {
            Logger.m11003i(TAG, "makeThumbnail# PdfFilePath is null or not exists. " + Logger.getEncode(pdfTemplateInfo.mPdfFilePath));
            return null;
        }
        Bitmap pageBitmap = spenNotePdfImport.getPageBitmap(pdfTemplateInfo.mPdfFilePath, "", 0, f);
        if (pageBitmap == null) {
            Logger.m11000e(TAG, "makeThumbnail# getPageBitmap is null. " + Logger.getEncode(pdfTemplateInfo.mPdfFilePath));
            return null;
        }
        String str = pdfTemplateInfo.mCachePath + FileUtils.extractFileName(pdfTemplateInfo.mPdfFilePath) + ".jpg";
        ImageUtil.saveBitmapToFileCache(pageBitmap, str, Bitmap.CompressFormat.JPEG, 95);
        Logger.m11003i(TAG, "makeThumbnail# thumbnail Path : " + Logger.getEncode(str));
        return str;
    }
}
