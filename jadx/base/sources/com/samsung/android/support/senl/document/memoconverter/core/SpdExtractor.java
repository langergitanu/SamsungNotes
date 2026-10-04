package com.samsung.android.support.senl.document.memoconverter.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.ArrayMap;
import android.util.TypedValue;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentVoice;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenCapturePage;
import com.samsung.android.support.senl.document.C7991R;
import com.samsung.android.support.senl.document.contract.DocumentTextRecognition;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.ProgressListener;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpdExtractor {
    private static final String BOOKMARK_VOICE_KEY = "NOTES_APP_BOOKMARK_VOICE_IDENTIFIER";
    private static final int DIRECT_VIEW_UNDERLINE_DP = 39;
    private static final String TAG = "SpdExtractor";
    private static final boolean USE_TEXT_RECOG = false;
    private static final String VOICE_MEMO_FILE_PREFIX = "/";
    private static final String VOICE_MEMO_KEY = "VoiceMemo";
    private static final int VOICE_MEMO_TYPE = 23;
    private int DEFAULT_MARGIN;
    private Context mContext;
    private ArrayList<String> mVoiceMemoTable = null;
    private int mMaxPageCnt = 100;
    private DocumentTextRecognition mTextRecognition = null;
    private ProgressListener mProgressListener = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultInfo {
        public ArrayList<SpenContentHandWriting> hwList = new ArrayList<>();
        public ArrayList<SpenContentVoice> voiceList = new ArrayList<>();
        public ArrayList<String> pageIdList = new ArrayList<>();
        public ArrayList<String> delFiles = new ArrayList<>();
    }

    public SpdExtractor(Context context) {
        this.mContext = context;
        this.DEFAULT_MARGIN = (context.getResources().getDisplayMetrics().densityDpi / 160) * 39;
    }

    private void CleanData(ResultInfo resultInfo) {
        if (resultInfo != null) {
            for (SpenContentHandWriting spenContentHandWriting : resultInfo.hwList) {
                File file = new File(spenContentHandWriting.getAttachedFile());
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(spenContentHandWriting.getThumbnailPath());
                if (file2.exists()) {
                    file2.delete();
                }
            }
            resultInfo.hwList = null;
            Iterator<SpenContentVoice> it = resultInfo.voiceList.iterator();
            while (it.hasNext()) {
                File file3 = new File(it.next().getAttachedFile());
                if (file3.exists()) {
                    file3.delete();
                }
            }
            resultInfo.voiceList = null;
        }
    }

    private ArrayMap<String, String> initVoiceMemo(SpenNoteDoc spenNoteDoc) throws Throwable {
        String[] extraDataStringArray;
        String str;
        if (spenNoteDoc == null || (extraDataStringArray = spenNoteDoc.getExtraDataStringArray(VOICE_MEMO_KEY)) == null || extraDataStringArray.length == 0 || (str = extraDataStringArray[0]) == null || str.length() == 0) {
            return null;
        }
        ArrayList<String> arrayList = this.mVoiceMemoTable;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.mVoiceMemoTable = new ArrayList<>();
        }
        String str2 = this.mContext.getCacheDir().toString() + "/";
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i = 0; i < extraDataStringArray.length; i++) {
            String attachedFile = spenNoteDoc.getAttachedFile(extraDataStringArray[i]);
            String strSubstring = attachedFile.substring(attachedFile.lastIndexOf(Extension.DOT), attachedFile.length());
            attachedFile.substring(0, attachedFile.lastIndexOf("/") + 1);
            String str3 = str2 + attachedFile.substring(attachedFile.lastIndexOf("/") + 1, attachedFile.length());
            DocumentLogger.m7178d(TAG, "initVoicecopy file :" + str3);
            try {
                FileUtil.copyFile(new File(attachedFile), new File(str3));
                this.mVoiceMemoTable.add(extraDataStringArray[i] + strSubstring);
                String strM1170p = AbstractC0622a.m1170p(extraDataStringArray[i], strSubstring, new StringBuilder());
                StringBuilder sbM1324q = AbstractC1974b.m1324q(str2);
                sbM1324q.append(extraDataStringArray[i]);
                sbM1324q.append(strSubstring);
                arrayMap.put(strM1170p, sbM1324q.toString());
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "[", "] fileName = ");
                sbM778t.append(AppDelegator.getInstance().fileUtils_logPath(extraDataStringArray[i] + strSubstring));
                DocumentLogger.m7178d(TAG, sbM778t.toString());
            } catch (IOException e) {
                DocumentLogger.m7180e(TAG, "initVoiceMemo fail copy voice file", e);
                return null;
            }
        }
        return arrayMap;
    }

    public SpenPageDoc.BackgroundEffect getBgEffect(Context context, float f) {
        SpenPageDoc.BackgroundEffect backgroundEffect = new SpenPageDoc.BackgroundEffect();
        backgroundEffect.margin = 0.0f;
        if (context == null) {
            backgroundEffect.color = 0;
            backgroundEffect.width = 1.0f;
            backgroundEffect.space = f / 48.0f;
            return backgroundEffect;
        }
        Resources resources = context.getResources();
        backgroundEffect.color = resources.getColor(C7991R.color.stroke_pagedoc_bg_effect_color, null);
        backgroundEffect.width = resources.getDimension(C7991R.dimen.stroke_bg_effect_divider_width);
        TypedValue typedValue = new TypedValue();
        resources.getValue(C7991R.dimen.stroke_direct_view_zoom_ratio, typedValue, true);
        backgroundEffect.space = (resources.getDimension(C7991R.dimen.stroke_thumbnail_default_margin) / resources.getDisplayMetrics().density) * Resources.getSystem().getDisplayMetrics().density * typedValue.getFloat();
        return backgroundEffect;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0291  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ResultInfo requestExtract(String str, String str2) throws Throwable {
        float fHeight;
        int iWidth;
        int i;
        SpenCapturePage spenCapturePage;
        ArrayMap<String, String> arrayMap;
        String str3 = str;
        DocumentLogger.m7178d(TAG, "requestExtract start : " + AppDelegator.getInstance().fileUtils_logPath(str3));
        Rect rect = new Rect(0, 0, Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);
        DocumentLogger.m7178d(TAG, "measurePageDoc screen rect = " + rect);
        if (rect.width() < rect.height()) {
            fHeight = rect.width();
            iWidth = rect.height();
        } else {
            fHeight = rect.height();
            iWidth = rect.width();
        }
        float f = iWidth;
        String str4 = this.mContext.getCacheDir().toString() + "/" + new Date().getTime() + Thread.currentThread().getId() + ".spd";
        DocumentLogger.m7178d(TAG, "File path : " + str4);
        File file = new File(str4);
        FileUtil.copyFile(new File(str3), file);
        new Date().getTime();
        SpenCapturePage spenCapturePage2 = new SpenCapturePage(this.mContext);
        SpenNoteDoc spenNoteDoc = (str2 == null || str2.length() <= 0) ? new SpenNoteDoc(this.mContext, str4, (int) fHeight, (int) f) : new SpenNoteDoc(this.mContext, str4, str2, (int) fHeight, (int) f);
        new Date().getTime();
        int orientation = spenNoteDoc.getOrientation();
        ArrayMap<String, String> arrayMapInitVoiceMemo = initVoiceMemo(spenNoteDoc);
        int pageCount = spenNoteDoc.getPageCount();
        ResultInfo resultInfo = new ResultInfo();
        int i2 = 0;
        while (true) {
            File file2 = file;
            if (i2 >= pageCount) {
                SpenNoteDoc spenNoteDoc2 = spenNoteDoc;
                ArrayMap<String, String> arrayMap2 = arrayMapInitVoiceMemo;
                SpenCapturePage spenCapturePage3 = spenCapturePage2;
                int i4 = 0;
                if (arrayMap2 != null && arrayMap2.size() > 0) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy H:m", Locale.getDefault());
                    while (i4 < arrayMap2.size()) {
                        ArrayMap<String, String> arrayMap3 = arrayMap2;
                        String strValueAt = arrayMap3.valueAt(i4);
                        SpenContentVoice spenContentVoice = new SpenContentVoice();
                        spenContentVoice.setText(ConverterUtils.getTitle(strValueAt));
                        if (str.contains("SMemo")) {
                            try {
                                long j = Long.parseLong(spenContentVoice.getText().substring(2, spenContentVoice.getText().length()));
                                Date date = new Date();
                                date.setTime(j);
                                spenContentVoice.setText(simpleDateFormat.format(date));
                            } catch (NumberFormatException unused) {
                                DocumentLogger.m7181i(TAG, "save voice file : " + SDocUtil.logPath(str) + " / " + spenContentVoice.getText() + " / fail to parse title");
                            }
                        }
                        spenContentVoice.attachFile(strValueAt);
                        DocumentLogger.m7181i(TAG, "attach voice file to ContentVoice: " + SDocUtil.logPath(strValueAt));
                        spenContentVoice.setPlayTime(Converter.getVoiceRuntime(strValueAt));
                        spenContentVoice.setBookmarkID(strValueAt.substring(strValueAt.lastIndexOf("/") + 1, strValueAt.length()));
                        resultInfo.voiceList.add(spenContentVoice);
                        resultInfo.delFiles.add(strValueAt);
                        i4++;
                        arrayMap2 = arrayMap3;
                    }
                }
                new Date().getTime();
                spenNoteDoc2.close(true);
                FileUtil.deleteFile(file2);
                new Date().getTime();
                new Date().getTime();
                spenCapturePage3.close();
                new Date().getTime();
                return resultInfo;
            }
            if (Thread.currentThread().isInterrupted()) {
                DocumentLogger.m7178d(TAG, "Thread Interrupted! : " + AppDelegator.getInstance().fileUtils_logPath(str3));
                spenNoteDoc.close(true);
                spenCapturePage2.close();
                CleanData(resultInfo);
                return null;
            }
            new Date().getTime();
            DocumentLogger.m7181i(TAG, "DrawText requestExtract : " + this.mContext.getResources().getDisplayMetrics().widthPixels + " / " + this.mContext.getResources().getDisplayMetrics().heightPixels);
            float f4 = fHeight;
            SpenNoteDoc spenNoteDoc3 = new SpenNoteDoc(this.mContext, orientation, (int) fHeight, (int) f);
            new Date().getTime();
            new Date().getTime();
            String id = spenNoteDoc.getPage(0).getId();
            spenNoteDoc.transferPage(spenNoteDoc3, 0);
            SpenPageDoc page = spenNoteDoc3.getPage(0);
            new Date().getTime();
            ArrayList<SpenObjectBase> objectList = page.getObjectList();
            float f5 = f;
            int size = objectList.size();
            int i5 = orientation;
            DocumentLogger.m7178d(TAG, "objectCount:" + size);
            if (size == 0 && page.getBackgroundImagePath() == null && (page.getBackgroundColor() & (-16777216)) == 0) {
                spenNoteDoc3.close();
                i2++;
                str3 = str;
                file = file2;
                fHeight = f4;
                f = f5;
                orientation = i5;
            } else {
                SpenNoteDoc spenNoteDoc4 = spenNoteDoc;
                RectF rectF = new RectF(0.0f, 0.0f, page.getWidth(), page.getHeight());
                DocumentLogger.m7178d(TAG, "Drawn Rect:" + rectF);
                if (arrayMapInitVoiceMemo != null && arrayMapInitVoiceMemo.size() > 0) {
                    Iterator<SpenObjectBase> it = objectList.iterator();
                    while (it.hasNext()) {
                        SpenObjectBase next = it.next();
                        Iterator<SpenObjectBase> it2 = it;
                        if (next.getType() == 4 && next.getExtraDataInt(PackageRelationship.TYPE_ATTRIBUTE_NAME) == 23) {
                            String extraDataString = next.getExtraDataString("filePath");
                            String strSubstring = extraDataString.substring(extraDataString.lastIndexOf("/") + 1);
                            if (strSubstring != null && this.mVoiceMemoTable.contains(strSubstring)) {
                                next.attachFile(arrayMapInitVoiceMemo.get(strSubstring));
                                next.setExtraDataString(BOOKMARK_VOICE_KEY, strSubstring);
                                StringBuilder sb = new StringBuilder("attach voice file : ");
                                arrayMap = arrayMapInitVoiceMemo;
                                sb.append(AppDelegator.getInstance().fileUtils_logPath(next.getAttachedFile()));
                                sb.append(" / name : ");
                                sb.append(AppDelegator.getInstance().fileUtils_logPath(strSubstring));
                                DocumentLogger.m7181i(TAG, sb.toString());
                            }
                        } else {
                            arrayMap = arrayMapInitVoiceMemo;
                        }
                        it = it2;
                        arrayMapInitVoiceMemo = arrayMap;
                    }
                }
                ArrayMap<String, String> arrayMap4 = arrayMapInitVoiceMemo;
                new Date().getTime();
                spenCapturePage2.setPageDoc(page);
                if (page.getBackgroundImagePath() == null && page.getBackgroundColor() == 0) {
                    page.setBackgroundEffect(getBgEffect(this.mContext, page.getHeight()));
                }
                int backgroundColor = page.getBackgroundColor();
                page.setBackgroundColor(0);
                String backgroundImagePath = page.getBackgroundImagePath();
                boolean z = (backgroundImagePath == null || backgroundImagePath.isEmpty()) ? false : true;
                new Date().getTime();
                new Date().getTime();
                Bitmap bitmapCapturePage = spenCapturePage2.capturePage(1.0f);
                File fileImageUtils_saveToCache = AppDelegator.getInstance().imageUtils_saveToCache(this.mContext, bitmapCapturePage, 0, 0, (int) rectF.width(), (int) rectF.height());
                bitmapCapturePage.recycle();
                new Date().getTime();
                page.getHeight();
                new Date().getTime();
                spenCapturePage2.setPageDoc(null);
                new Date().getTime();
                if (fileImageUtils_saveToCache == null || !fileImageUtils_saveToCache.exists()) {
                    i = i2;
                    spenCapturePage = spenCapturePage2;
                    DocumentLogger.m7178d(TAG, "thumbnailFile is null. skip.");
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.mContext.getCacheDir().toString());
                    sb2.append("/");
                    sb2.append(i2);
                    sb2.append("_");
                    i = i2;
                    spenCapturePage = spenCapturePage2;
                    sb2.append(new Date().getTime());
                    sb2.append(".spd");
                    String string = sb2.toString();
                    new Date().getTime();
                    spenNoteDoc3.save(string, false);
                    spenNoteDoc3.close();
                    new Date().getTime();
                    DocumentLogger.m7178d(TAG, "thumbnailFile :" + AppDelegator.getInstance().fileUtils_logPath(fileImageUtils_saveToCache.getAbsolutePath()));
                    new Date().getTime();
                    SpenContentHandWriting spenContentHandWriting = new SpenContentHandWriting();
                    spenContentHandWriting.setThumbnailPath(fileImageUtils_saveToCache.getAbsolutePath());
                    spenContentHandWriting.setText(fileImageUtils_saveToCache.getAbsolutePath());
                    spenContentHandWriting.setObjectRect(rectF);
                    spenContentHandWriting.attachFile(string);
                    spenContentHandWriting.setThumbnailCount(1);
                    if (!z && (backgroundColor & (-16777216)) != 0) {
                        spenContentHandWriting.setBackgroundColor(backgroundColor);
                        DocumentLogger.m7178d(TAG, "set HWC BG color :" + backgroundColor);
                    }
                    resultInfo.hwList.add(spenContentHandWriting);
                    new Date().getTime();
                    resultInfo.delFiles.add(fileImageUtils_saveToCache.getAbsolutePath());
                    resultInfo.delFiles.add(string);
                    resultInfo.pageIdList.add(id);
                    ProgressListener progressListener = this.mProgressListener;
                    if (progressListener != null) {
                        progressListener.onProgress(i + 1, pageCount, null);
                    }
                }
                i2 = i + 1;
                str3 = str;
                file = file2;
                fHeight = f4;
                f = f5;
                spenCapturePage2 = spenCapturePage;
                orientation = i5;
                spenNoteDoc = spenNoteDoc4;
                arrayMapInitVoiceMemo = arrayMap4;
            }
        }
    }

    public boolean setMaxPageCountForSdoc(int i) {
        if (i <= 0) {
            return false;
        }
        this.mMaxPageCnt = i;
        return true;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.mProgressListener = progressListener;
    }

    public void close() {
    }
}
