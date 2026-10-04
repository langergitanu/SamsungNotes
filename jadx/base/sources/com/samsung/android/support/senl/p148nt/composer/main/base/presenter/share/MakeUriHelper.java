package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfExport;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareErrorCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentTimeUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MakeUriHelper {
    public static final int JPG_HEIGHT = 4000;
    public static final int JPG_WIDTH = 1000;
    public static final int MIN_JPG_HEIGHT = 300;
    private static final String TAG = Logger.createTag("MakeUriHelper");
    private boolean mIsCanceled = false;
    private final ShareCacheHelper mShareCacheHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MakePdfResult {
        String mResultPath = "";
        ISpenNotePdfManager.ResultType mResultType;

        public String getResultPath() {
            return this.mResultPath;
        }

        public ISpenNotePdfManager.ResultType getResultType() {
            return this.mResultType;
        }

        public void setResultPath(String str) {
            this.mResultPath = str;
        }

        public void setResultType(ISpenNotePdfManager.ResultType resultType) {
            this.mResultType = resultType;
        }
    }

    public MakeUriHelper(ShareCacheHelper shareCacheHelper) {
        this.mShareCacheHelper = shareCacheHelper;
    }

    private CharSequence getExtractTextFromObjects(ArrayList<SpenObjectBase> arrayList, StringBuilder sb, CharSequence charSequence) {
        HandleTextBox handleTextBox = new HandleTextBox();
        Iterator<SpenObjectBase> it = arrayList.iterator();
        while (it.hasNext()) {
            SpenObjectShape spenObjectShape = (SpenObjectShape) it.next();
            if (spenObjectShape != null && spenObjectShape.getText() != null) {
                charSequence = handleTextBox.handleText(new HandleTextBox.InputBuilder(spenObjectShape).setTextSb(sb).setCharSequence(charSequence).done());
            }
        }
        return charSequence;
    }

    private void updateDisplayTimes(@NonNull ShareData shareData, String str) {
        try {
            DocumentTimeUtils.setDisplayTimes(str, shareData.getCreatedTime(), shareData.getLastModifiedTime());
        } catch (RuntimeException e) {
            Logger.m11000e(TAG, "updateDisplayTimes# failed to update DisplayTimes, e : " + e.getMessage());
        }
    }

    public void cancel() {
        this.mIsCanceled = true;
    }

    @NonNull
    public Pair<StringBuilder, CharSequence> exportText(SpenWNote spenWNote) {
        HandleWebCard handleWebCard = new HandleWebCard();
        HandleLinkCard handleLinkCard = new HandleLinkCard();
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceHandleText = new HandleTextBox().handleText(new HandleTextBox.InputBuilder(spenWNote.getBodyText()).setTextSb(sb).setClearSpace(true).setConverter(new HandleTextBox.ObjectSpanClearConverterImpl()).done());
        for (SpenWPage spenWPage : spenWNote.getPageList()) {
            if (spenWPage != null) {
                charSequenceHandleText = getExtractTextFromObjects(spenWPage.getObjectList(64), sb, getExtractTextFromObjects(spenWPage.getObjectList(2), sb, charSequenceHandleText));
                Iterator<SpenObjectBase> it = spenWPage.getObjectList(4096).iterator();
                while (it.hasNext()) {
                    SpenObjectWeb spenObjectWeb = (SpenObjectWeb) it.next();
                    if (spenObjectWeb != null && spenObjectWeb.getUri() != null) {
                        charSequenceHandleText = handleWebCard.handleWeb(spenObjectWeb, sb, charSequenceHandleText);
                    }
                }
                Iterator<SpenObjectBase> it2 = spenWPage.getObjectList(65536).iterator();
                while (it2.hasNext()) {
                    SpenObjectLink spenObjectLink = (SpenObjectLink) it2.next();
                    if (spenObjectLink != null && spenObjectLink.getTitle() != null) {
                        charSequenceHandleText = handleLinkCard.handleLink(spenObjectLink, sb, charSequenceHandleText);
                    }
                }
            }
        }
        return new Pair<>(sb, charSequenceHandleText);
    }

    public ArrayList<String> makeImage(Context context, SpenWNote spenWNote, String str) {
        return makeImage(context, spenWNote, str, true);
    }

    public void makeJpg(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return;
        }
        int width = bitmap.getWidth() > 0 ? bitmap.getWidth() : 1000;
        int height = bitmap.getHeight() > 0 ? bitmap.getHeight() : 4000;
        if (height <= 300) {
            height = 300;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
        bitmap.recycle();
        if (this.mIsCanceled) {
            return;
        }
        ImageUtils.makeJpg(bitmapCreateBitmap, new File(str), 100);
    }

    public String makeMsPPT(Context context, SpenWNote spenWNote, String str, String str2) {
        if (!CommonUtil.initSpenSdk(context) || this.mIsCanceled) {
            return null;
        }
        File file = new File(str2);
        return DocConverterHelper.getInstance().wdocToPPT(context, spenWNote, str, FileUtils.extractFileName(file.getName()), file.getParent());
    }

    public String makeMsWord(Context context, SpenWNote spenWNote, String str, String str2) {
        if (!CommonUtil.initSpenSdk(context) || this.mIsCanceled) {
            return null;
        }
        File file = new File(str2);
        return DocConverterHelper.getInstance().wdocToWord(context, spenWNote, str, FileUtils.extractFileName(file.getName()), file.getParent());
    }

    public String makePdf(Context context, SpenNotePdfExport spenNotePdfExport, int i, String str) {
        return makePdf(context, spenNotePdfExport, i, str, true).getResultPath();
    }

    public String makeSDoc(Context context, ShareData shareData, String str) throws ShareException {
        try {
            if (this.mIsCanceled) {
                return null;
            }
            boolean zEquals = FileUtils.getFileExt(shareData.getPath()).equals("sdocx");
            if (zEquals) {
                SpenSdkInitializer.initialize(context);
                if (LockUtils.isLocked(shareData.getPath())) {
                    this.mShareCacheHelper.unlockSpenWNote(context, shareData.getPath(), str, UUIDUtils.isCoeditUuid(shareData.getUuid()));
                } else {
                    DocumentCopyUtils.copy(context, shareData.getPath(), str, UUIDUtils.isCoeditUuid(shareData.getUuid()));
                }
                if (SpenWNoteFile.isValid(str)) {
                    SpenWNoteFile.setServerCheckPoint(str, -1L);
                }
            } else {
                BaseUtils.copyFile(shareData.getPath(), str);
            }
            if (!new File(str).exists()) {
                return null;
            }
            if (zEquals) {
                updateDisplayTimes(shareData, str);
            }
            UriHelper.requestScanFile(context, str, Constants.MIME_SDOC);
            return str;
        } catch (Exception e) {
            throw new ShareException(ShareErrorCode.CreateFileFailed, e.getMessage() != null ? e.getMessage() : "");
        }
    }

    public String makeText(Context context, SpenWNote spenWNote, String str) {
        String strTrim = ((StringBuilder) exportText(spenWNote).first).toString().trim();
        if (TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(str)) {
            Logger.m10999d(TAG, "makeText# failed to exportFile");
            return "";
        }
        String strMakeTextFile = makeTextFile(strTrim, str);
        if (!AbstractC2322a.m1607A(strMakeTextFile)) {
            return "";
        }
        UriHelper.requestScanFile(context, strMakeTextFile, "text/plain");
        return strMakeTextFile;
    }

    public String makeTextFile(String str, String str2) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str2), StandardCharsets.UTF_8));
            try {
                bufferedWriter.append((CharSequence) str);
                bufferedWriter.flush();
                bufferedWriter.close();
                return str2;
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e) {
            Logger.m11000e(TAG, "makeTextFile#FileNotFoundException " + e.getMessage());
            return "";
        } catch (IOException e2) {
            AbstractC8014b.m7204f(e2, new StringBuilder("makeTextFile#IOException "), TAG);
            return "";
        }
    }

    public ArrayList<String> makeImage(Context context, SpenWNote spenWNote, String str, boolean z) {
        int pageCount;
        Bitmap bitmapCapturePage;
        String string;
        String strGenerateUniqueFilePath;
        SpenWNote spenWNote2 = spenWNote;
        Logger.m11003i(TAG, "makeImage# page capture Start");
        NoteCaptureControl noteCaptureControl = new NoteCaptureControl(context);
        noteCaptureControl.setWNote(spenWNote2);
        SpenWNote.PageMode pageMode = spenWNote2.getPageMode();
        ArrayList<RectF> arrayList = new ArrayList<>();
        int i = 1;
        if (pageMode == SpenWNote.PageMode.SINGLE) {
            SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(context);
            spenBodyTextContext.setDocument(spenWNote2);
            spenBodyTextContext.measureText();
            RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(0);
            spenBodyTextContext.close();
            arrayList = ShareUtils.getPageThumbnailRect(spenWNote2, measuredFitRect);
            if (arrayList == null || arrayList.isEmpty()) {
                pageCount = 0;
            } else {
                pageCount = arrayList.size();
                noteCaptureControl.setContents(spenWNote2.getPage(0), spenWNote2.getBodyText(), 0);
            }
        } else {
            pageCount = spenWNote2.getPageCount() - 1;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<SpenWPage> pageList = spenWNote2.getPageList();
        File file = new File(str);
        String strExtractFileName = FileUtils.extractFileName(file.getName());
        int i2 = 0;
        while (i2 < pageCount && !this.mIsCanceled) {
            if (pageMode == SpenWNote.PageMode.SINGLE) {
                bitmapCapturePage = noteCaptureControl.captureRect(arrayList.get(i2));
            } else {
                noteCaptureControl.setContents(pageList.get(i2), spenWNote2.getBodyText(), i2);
                bitmapCapturePage = noteCaptureControl.capturePage(1.0f);
            }
            if (pageCount == i) {
                string = strExtractFileName;
            } else {
                StringBuilder sbM781w = AbstractC0541b.m781w(strExtractFileName, "_");
                sbM781w.append(i2 + 1);
                string = sbM781w.toString();
            }
            if (file.getParent() != null) {
                strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(file.getParent(), string, "jpg");
                makeJpg(bitmapCapturePage, strGenerateUniqueFilePath);
            } else {
                strGenerateUniqueFilePath = null;
            }
            if (strGenerateUniqueFilePath != null && AbstractC2322a.m1607A(strGenerateUniqueFilePath)) {
                arrayList2.add(strGenerateUniqueFilePath);
                arrayList3.add("image/jpeg");
            }
            i2++;
            spenWNote2 = spenWNote;
            i = 1;
        }
        noteCaptureControl.close();
        if (z && !arrayList2.isEmpty()) {
            UriHelper.requestScanFile(context, (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]));
        }
        Logger.m11003i(TAG, "makeImage# page capture done " + arrayList2.size());
        return arrayList2;
    }

    public MakePdfResult makePdf(Context context, SpenNotePdfExport spenNotePdfExport, int i, String str, boolean z) {
        MakePdfResult makePdfResult = new MakePdfResult();
        if (!this.mIsCanceled) {
            Logger.startTime(String.valueOf(hashCode()));
            if (spenNotePdfExport != null) {
                makePdfResult.setResultType(spenNotePdfExport.exportFile(i, str));
                String strValueOf = String.valueOf(hashCode());
                String str2 = TAG;
                Logger.endTime(strValueOf, str2, "makePdf# end");
                if (makePdfResult.getResultType() == ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS) {
                    Logger.m10999d(str2, "makePdf# success to exportFile");
                    if (new File(str).exists()) {
                        makePdfResult.setResultPath(str);
                        if (z) {
                            UriHelper.requestScanFile(context, str, Constants.MIME_PDF);
                            return makePdfResult;
                        }
                    }
                } else {
                    makePdfResult.setResultPath("");
                    Logger.m11000e(str2, "makePdf# failed to exportFile. resultType:" + makePdfResult.getResultType());
                }
            }
        }
        return makePdfResult;
    }
}
