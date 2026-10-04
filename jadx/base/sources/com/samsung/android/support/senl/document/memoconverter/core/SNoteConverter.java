package com.samsung.android.support.senl.document.memoconverter.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.ArrayMap;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentVoice;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenExceedImageLimitException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenExceedTextLimitException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.document.SpenInvalidPasswordException;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenNoteFile;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.delegator.DocumentSaveSDoc;
import com.samsung.android.support.senl.document.memoconverter.FinishListener;
import com.samsung.android.support.senl.document.memoconverter.ProgressListener;
import com.samsung.android.support.senl.document.memoconverter.core.SpdExtractor;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SNoteConverter {
    private static final String CROP_EXTRA_DATA_KEY = "SAMSUNGNOTES_SNB_CONVERTER_FG_IMAGE_CROP_DATA_";
    private static final String SDOC_FOR_CATEGORY = "SDocData";
    private static final String SMEMO2_FOR_CATEGORY = "SMemo2";
    private static final String SMEMO_FOR_CATEGORY = "SMemo";
    private static final String SNOTE3_FOR_CATEGORY = "SNote3";
    private static final String SNOTEPATH_FOR_CATEGORY = "SnoteData";
    private static final String SNOTE_FOR_CATEGORY = "SNote";
    private static final String TAG = "SNoteConverter";
    private Context mContext;
    private FinishListener mFinishListener = null;
    private ProgressListener mKmemoProgressListener = null;
    private int mNoteHeight;
    private int mNoteWidth;
    private SNBToSPDConverter mSnbConverter;
    private SpdExtractor mSpdExtractor;

    public SNoteConverter(Context context) {
        this.mSnbConverter = null;
        this.mSpdExtractor = null;
        this.mNoteWidth = 0;
        this.mNoteHeight = 0;
        this.mContext = context;
        SpdExtractor spdExtractor = new SpdExtractor(context);
        this.mSpdExtractor = spdExtractor;
        spdExtractor.setProgressListener(new ProgressListener() { // from class: com.samsung.android.support.senl.document.memoconverter.core.SNoteConverter.1
            @Override // com.samsung.android.support.senl.document.memoconverter.ProgressListener
            public void onProgress(int i, int i2, ArrayList<String> arrayList) {
                if (SNoteConverter.this.mKmemoProgressListener != null) {
                    SNoteConverter.this.mKmemoProgressListener.onProgress((int) Math.ceil(i / 2.0f), i2, null);
                }
            }
        });
        this.mSnbConverter = new SNBToSPDConverter();
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.mNoteWidth = Math.min(point.x, point.y);
        int iMax = Math.max(point.x, point.y);
        this.mNoteHeight = iMax;
        float f = (this.mNoteWidth * 16.0f) / 9.0f;
        if (f < iMax) {
            this.mNoteHeight = (int) f;
        }
        initSpenSdk(context);
        this.mSnbConverter.initSdk(this.mContext.getFilesDir().getAbsolutePath(), point.x, point.y, 10);
        DocumentLogger.m7181i(TAG, "SNoteConverter()");
    }

    private ArrayList<String> createSdoc(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, boolean z, boolean z2, boolean z3) throws Throwable {
        ArrayList<SpenContentHandWriting> arrayList;
        ArrayList<String> arrayList2;
        int i;
        SpdExtractor.ResultInfo resultInfo;
        String str7;
        String strM2218i;
        String strM2223n;
        SpenSDoc spenSDoc;
        ArrayList<SpenContentHandWriting> arrayList3;
        ArrayList<String> arrayList4;
        ArrayList<SpenContentHandWriting> arrayList5;
        int i2;
        String str8;
        String str9;
        int i4;
        ArrayList<String> arrayList6;
        int i5;
        ProgressListener progressListener;
        String str10 = str3;
        String str11 = MarkdownConverter.PREFIX_NAME;
        String str12 = TAG;
        SpdExtractor.ResultInfo resultInfoRequestExtract = this.mSpdExtractor.requestExtract(str, str5);
        if (resultInfoRequestExtract == null) {
            return null;
        }
        ArrayList<SpenContentHandWriting> arrayList7 = resultInfoRequestExtract.hwList;
        ArrayList<SpenContentVoice> arrayList8 = resultInfoRequestExtract.voiceList;
        boolean zIsFavorite = SpenNoteFile.isFavorite(str);
        String title = str6 != null ? str6 : ConverterUtils.getTitle(str);
        String str13 = new String(title);
        ArrayList<String> arrayList9 = new ArrayList<>();
        int size = arrayList7.size();
        int i6 = (size - 1) / 100;
        SpenSDoc spenSDoc2 = null;
        String str14 = null;
        int i7 = 0;
        while (i7 <= i6) {
            ArrayList<SpenContentVoice> arrayList10 = arrayList8;
            if (i7 > 0) {
                arrayList2 = arrayList9;
                if (str10 == null) {
                    i = i6;
                    StringBuilder sb = new StringBuilder();
                    resultInfo = resultInfoRequestExtract;
                    arrayList = arrayList7;
                    sb.append(AppDelegator.getInstance().getNoteFilePath(this.mContext));
                    sb.append("[");
                    sb.append(str13);
                    sb.append("]_");
                    sb.append(i7);
                    sb.append("_");
                    sb.append(new Date().getTime());
                    sb.append(".sdoc");
                    strM2223n = sb.toString();
                    strM2218i = AbstractC2821a.m2218i(i7, title, "_");
                    str7 = str14;
                } else {
                    arrayList = arrayList7;
                    i = i6;
                    resultInfo = resultInfoRequestExtract;
                    int iLastIndexOf = str10.lastIndexOf(".sdoc");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((Object) str10.subSequence(0, iLastIndexOf));
                    sb2.append("_");
                    strM2223n = AbstractC2821a.m2223n(sb2, ".sdoc", i7);
                    strM2218i = AbstractC2821a.m2218i(i7, title, "_");
                    str7 = null;
                }
            } else {
                arrayList = arrayList7;
                arrayList2 = arrayList9;
                i = i6;
                resultInfo = resultInfoRequestExtract;
                if (str10 == null) {
                    strM2218i = str13;
                    strM2223n = AppDelegator.getInstance().getNoteFilePath(this.mContext) + "[" + str13 + "]_" + new Date().getTime() + ".sdoc";
                    str7 = str14;
                } else {
                    str7 = str4;
                    strM2218i = str13;
                    strM2223n = str10;
                }
            }
            try {
                try {
                    spenSDoc = new SpenSDoc(this.mContext, strM2223n, (String) null, (String[]) null);
                } catch (SpenSDocInvalidPasswordException e) {
                    e = e;
                    DocumentLogger.m7180e(str12, str11, e);
                    spenSDoc = spenSDoc2;
                } catch (SpenSDocUnsupportedFileException e2) {
                    e = e2;
                    DocumentLogger.m7180e(str12, str11, e);
                    spenSDoc = spenSDoc2;
                } catch (SpenSDocUnsupportedVersionException e3) {
                    e = e3;
                    DocumentLogger.m7180e(str12, str11, e);
                    spenSDoc = spenSDoc2;
                } catch (IOException e5) {
                    e = e5;
                    DocumentLogger.m7180e(str12, str11, e);
                    spenSDoc = spenSDoc2;
                }
            } catch (SpenSDocInvalidPasswordException | SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException e6) {
                e = e6;
            }
            spenSDoc.getTitle().setText(strM2218i);
            spenSDoc.setFavorite(zIsFavorite);
            if (z3) {
                spenSDoc.setDocumentType(1);
            } else {
                spenSDoc.setDocumentType(0);
            }
            int i8 = i7 * 100;
            while (true) {
                if (i8 >= size) {
                    arrayList3 = arrayList;
                    break;
                }
                arrayList3 = arrayList;
                try {
                    spenSDoc.appendContent(arrayList3.get(i8));
                } catch (SpenExceedImageLimitException | SpenExceedTextLimitException e7) {
                    DocumentLogger.m7180e(str12, str11, e7);
                }
                i8++;
                if (i8 % 100 == 0) {
                    break;
                }
                arrayList = arrayList3;
            }
            for (SpenContentVoice spenContentVoice : arrayList10) {
                String str15 = title;
                try {
                    SpenContentVoice spenContentVoice2 = new SpenContentVoice();
                    spenContentVoice2.copy(spenContentVoice);
                    spenSDoc.appendContent(spenContentVoice2);
                } catch (SpenExceedImageLimitException | SpenExceedTextLimitException e8) {
                    DocumentLogger.m7180e(str12, str11, e8);
                }
                title = str15;
            }
            String str16 = title;
            if (z) {
                arrayList4 = arrayList2;
                arrayList5 = arrayList3;
                i2 = i7;
                str8 = str11;
                str9 = str12;
                i4 = i;
                arrayList6 = null;
                i5 = size;
                updateToDB(this.mContext, spenSDoc, strM2223n, getCategoryByPath(str2), zIsFavorite, str7, j, j2);
            } else {
                arrayList4 = arrayList2;
                arrayList5 = arrayList3;
                i2 = i7;
                str8 = str11;
                str9 = str12;
                i4 = i;
                arrayList6 = null;
                i5 = size;
                spenSDoc.save(strM2223n, null, j, j2);
                spenSDoc.close(true);
            }
            if (z2 && (progressListener = this.mKmemoProgressListener) != null) {
                progressListener.onProgress(((int) Math.floor(((double) i4) / 2.0d)) + ((int) Math.ceil(((double) (i2 + 1)) / 2.0d)), i4, arrayList6);
            }
            arrayList4.add(strM2223n);
            i7 = i2 + 1;
            spenSDoc2 = spenSDoc;
            i6 = i4;
            str13 = strM2218i;
            title = str16;
            arrayList8 = arrayList10;
            size = i5;
            resultInfoRequestExtract = resultInfo;
            arrayList7 = arrayList5;
            str11 = str8;
            str12 = str9;
            str14 = str7;
            arrayList9 = arrayList4;
            str10 = str3;
        }
        ArrayList<String> arrayList11 = arrayList9;
        Iterator<String> it = resultInfoRequestExtract.delFiles.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            if (file.exists()) {
                file.delete();
            }
        }
        return arrayList11;
    }

    private boolean deleteMemo(String str) {
        String title;
        ArrayList<String> noteFilePathList;
        String strSubstring;
        if (str == null || (title = ConverterUtils.getTitle(str)) == null || (noteFilePathList = AppDelegator.getInstance().getNoteFilePathList(this.mContext, false)) == null) {
            return false;
        }
        for (String str2 : noteFilePathList) {
            if (str2 != null) {
                int iIndexOf = str2.indexOf("[");
                int iLastIndexOf = str2.lastIndexOf("]");
                if (iIndexOf >= 0 && iLastIndexOf >= 0 && iLastIndexOf > iIndexOf) {
                    int i = iIndexOf + 1;
                    if (iLastIndexOf - i > 0 && (strSubstring = str2.substring(i, iLastIndexOf)) != null && strSubstring.length() > 0 && strSubstring.compareTo(title) == 0) {
                        AppDelegator.getInstance().deleteSDoc(this.mContext, AppDelegator.getInstance().getSDocUUID(this.mContext, str2), true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static String getCategoryByPath(String str) {
        char c = str.contains("SnoteData/") ? (char) 1 : str.contains("SMemo2/") ? (char) 3 : str.contains("SMemo/") ? (char) 2 : str.contains("SNote3/") ? (char) 5 : str.contains("SNote/") ? (char) 4 : str.contains("SDocData/") ? (char) 6 : (char) 0;
        if (c <= 0) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf("/");
        int iLastIndexOf2 = str.lastIndexOf("/", iLastIndexOf - 1) + 1;
        String strSubstring = str.substring(iLastIndexOf2, iLastIndexOf);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iLastIndexOf2, iLastIndexOf, "getCategoryByPath() : subCatPosStart[", "] subCatPosEnd[", "], folderName : ");
        sbM1173s.append(strSubstring);
        DocumentLogger.m7178d(TAG, sbM1173s.toString());
        if ((c != 1 || strSubstring.equals(SNOTEPATH_FOR_CATEGORY)) && ((c != 2 || strSubstring.equals(SMEMO_FOR_CATEGORY)) && ((c != 3 || strSubstring.equals(SMEMO2_FOR_CATEGORY)) && ((c != 4 || strSubstring.equals(SNOTE_FOR_CATEGORY)) && ((c != 5 || strSubstring.equals(SNOTE3_FOR_CATEGORY)) && (c != 6 || strSubstring.equals("SDocData"))))))) {
            if ((c != 1 || !strSubstring.equals(SNOTEPATH_FOR_CATEGORY)) && ((c != 2 || !strSubstring.equals(SMEMO_FOR_CATEGORY)) && ((c != 3 || !strSubstring.equals(SMEMO2_FOR_CATEGORY)) && ((c != 4 || !strSubstring.equals(SNOTE_FOR_CATEGORY)) && ((c != 5 || !strSubstring.equals(SNOTE3_FOR_CATEGORY)) && (c != 6 || !strSubstring.equals("SDocData"))))))) {
                return null;
            }
            while (iLastIndexOf2 > 0 && iLastIndexOf > 0) {
                iLastIndexOf = iLastIndexOf2 - 1;
                iLastIndexOf2 = str.lastIndexOf("/", iLastIndexOf2 - 2) + 1;
                String strSubstring2 = (iLastIndexOf2 < 0 || iLastIndexOf <= iLastIndexOf2) ? "" : str.substring(iLastIndexOf2, iLastIndexOf);
                StringBuilder sbM1173s2 = AbstractC0622a.m1173s(iLastIndexOf2, iLastIndexOf, "getCategoryByPath() : subCatPosStart[", "] subCatPosEnd[", "], parentFolder : ");
                sbM1173s2.append(strSubstring2);
                DocumentLogger.m7178d(TAG, sbM1173s2.toString());
                if (strSubstring.equals(strSubstring2)) {
                }
            }
            return null;
        }
        return strSubstring;
    }

    private static String getCategoryUuid(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String categoryUUID = AppDelegator.getInstance().getCategoryUUID(context, str, false);
        return categoryUUID.equals("1") ? AppDelegator.getInstance().addCategory(context, str) : categoryUUID;
    }

    private long getCreatedTime(String str) {
        long createdTime = SpenNoteFile.getCreatedTime(str);
        return createdTime <= 0 ? getLastModifiedTime(str) : createdTime / 1000;
    }

    private static void initSpenSdk(Context context) {
        Spen spen = new Spen();
        try {
            DocumentLogger.m7178d(TAG, "initSpenSdk() start");
            spen.initialize(context, 200);
            DocumentLogger.m7178d(TAG, "initSpenSdk() end");
        } catch (SsdkUnsupportedException e) {
            if (e.getType() == 0) {
                DocumentLogger.m7178d(TAG, "Vendor is not SAMSUNG" + e);
            } else {
                DocumentLogger.m7178d(TAG, "Device is not supported" + e);
            }
        }
    }

    private String makeEmptySodc(Context context, String str) {
        try {
            long jLastModified = new File(str).lastModified();
            String title = ConverterUtils.getTitle(str);
            String str2 = AppDelegator.getInstance().getNoteFilePath(this.mContext) + "[" + title + "]_" + new Date().getTime() + ".sdoc";
            SpenSDoc spenSDoc = new SpenSDoc(this.mContext, str2, (String) null, (String[]) null);
            spenSDoc.getTitle().setText(title);
            SpenContentText spenContentText = new SpenContentText();
            spenContentText.setText("");
            spenSDoc.appendContent(spenContentText);
            String strNewUUID = AppDelegator.getInstance().newUUID(this.mContext);
            DocumentSaveSDoc.saveSDoc(context, DocumentSaveSDoc.createBuilderInstance().setSPenSDoc(spenSDoc).setNew(true).setDocFilePath(str2).setLastModifiedAtTime(Long.valueOf(jLastModified)).setCreatedAtTime(Long.valueOf(jLastModified)).setUuid(strNewUUID));
            return strNewUUID;
        } catch (Exception e) {
            DocumentLogger.m7179e(TAG, "fail to make empty sdoc " + e);
            return null;
        }
    }

    public static String saveLockFile(Context context, String str, long j, long j2, boolean z, int i, String str2) {
        if (str == null) {
            return null;
        }
        AppDelegator appDelegator = AppDelegator.getInstance();
        DocumentLogger.m7181i(TAG, "saveLockFile : " + SDocUtil.logPath(str));
        String categoryByPath = getCategoryByPath(str);
        String title = ConverterUtils.getTitle(str);
        String strNewUUID = appDelegator.newUUID(context);
        try {
            String str3 = AppDelegator.getInstance().getNoteFilePath(context) + "[" + (str2 == null ? title : str2) + "]_" + new Date().getTime() + ".sdoc";
            SpenSDoc spenSDoc = new SpenSDoc(context, str3, (String) null, (String[]) null);
            if (i == appDelegator.getLockTypeSPD()) {
                spenSDoc.setDocumentType(2);
            } else if (i == appDelegator.getLockTypeSNB()) {
                spenSDoc.setDocumentType(3);
            } else if (i == appDelegator.getLockTypeTMEMO()) {
                title = "";
                spenSDoc.setDocumentType(4);
            }
            DocumentLogger.m7181i(TAG, "saveLockMemo - lockType :  " + i + " / title : " + title);
            spenSDoc.getTitle().setText(title);
            spenSDoc.bindFile(str);
            DocumentSaveSDoc.saveSDoc(context, DocumentSaveSDoc.createBuilderInstance().setSPenSDoc(spenSDoc).setDocFilePath(str3).setUuid(strNewUUID).setNew(true).setCloseDocAfterSave(true).setFavorite(Boolean.valueOf(z)).setLockType(Integer.valueOf(i)).setCategoryUuid(getCategoryUuid(context, categoryByPath)).setCreatedAtTime(Long.valueOf(j)).setLastModifiedAtTime(Long.valueOf(j2)));
            return strNewUUID;
        } catch (SpenSDocInvalidPasswordException e) {
            e = e;
            DocumentLogger.m7179e(TAG, "Fail to make new SDOC" + e);
            return null;
        } catch (SpenSDocUnsupportedFileException e2) {
            e = e2;
            DocumentLogger.m7179e(TAG, "Fail to make new SDOC" + e);
            return null;
        } catch (SpenSDocUnsupportedVersionException e3) {
            e = e3;
            DocumentLogger.m7179e(TAG, "Fail to make new SDOC" + e);
            return null;
        } catch (IOException e5) {
            e = e5;
            DocumentLogger.m7179e(TAG, "Fail to make new SDOC" + e);
            return null;
        }
    }

    private void setRemainderData(SpenSDoc spenSDoc, SpdExtractor.ResultInfo resultInfo, ArrayMap<String, Long> arrayMap) {
        String str;
        ArrayList<String> arrayList = resultInfo.pageIdList;
        if (arrayList == null || (str = arrayList.get(0)) == null || !arrayMap.containsKey(str)) {
            return;
        }
        long jLongValue = arrayMap.get(str).longValue();
        ArrayList<SpenSDoc.ReminderData> arrayList2 = new ArrayList<>();
        SpenSDoc.ReminderData reminderData = new SpenSDoc.ReminderData();
        reminderData.time = jLongValue;
        reminderData.reminderUUID = AppDelegator.getInstance().newUUID(this.mContext);
        arrayList2.add(reminderData);
        spenSDoc.setReminderData(arrayList2);
    }

    private String updateToDB(Context context, SpenSDoc spenSDoc, String str, String str2, boolean z, String str3, long j, long j2) {
        if (str3 == null) {
            str3 = AppDelegator.getInstance().newUUID(this.mContext);
        }
        DocumentSaveSDoc.saveSDoc(context, DocumentSaveSDoc.createBuilderInstance().setUuid(str3).setSPenSDoc(spenSDoc).setCloseDocAfterSave(true).setDocFilePath(str).setCreatedAtTime(Long.valueOf(j)).setLastModifiedAtTime(Long.valueOf(j2)).setFavorite(Boolean.valueOf(z)).setUpdateStrokeInWorkerThread(true).setCategoryUuid(getCategoryUuid(context, str2)).setNew(!AppDelegator.getInstance().isExistingNote(this.mContext, str3)));
        DocumentLogger.m7181i(TAG, "updateToDB() - " + str + " is saved");
        return str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean convertSNBToSDoc(String str, int i) throws Throwable {
        String title;
        if (str == null) {
            DocumentLogger.m7179e(TAG, "converterToSDoc - snb path is null");
            return false;
        }
        if (i != 1) {
            if (i == 2 && isAlreadyConverted(str)) {
                title = ConverterUtils.getTitle(str);
            }
            long jLastModified = new File(str).lastModified();
            if (!isSNBLocked(str)) {
                return saveLockFile(this.mContext, str, jLastModified, jLastModified, false, AppDelegator.getInstance().getLockTypeSNB(), title) != null;
            }
            String strSnbTospd = snbTospd(str, null);
            if (strSnbTospd == null) {
                DocumentLogger.m7179e(TAG, "Fail SNB To SPD : " + SDocUtil.logPath(str));
                String strMakeEmptySodc = makeEmptySodc(this.mContext, str);
                FinishListener finishListener = this.mFinishListener;
                if (finishListener != null) {
                    finishListener.onFinish(str, strMakeEmptySodc, true);
                }
                return true;
            }
            if (!AbstractC2322a.m1607A(strSnbTospd) || !SpenNoteFile.isValid(strSnbTospd)) {
                DocumentLogger.m7179e(TAG, "No SPD file");
                return false;
            }
            ArrayList<String> arrayListCreateSdoc = createSdoc(strSnbTospd, str, null, null, null, jLastModified, jLastModified, title, true, false, false);
            String sDocUUID = (arrayListCreateSdoc == null || arrayListCreateSdoc.size() <= 0) ? null : AppDelegator.getInstance().getSDocUUID(this.mContext, arrayListCreateSdoc.get(0));
            FileUtil.deleteFile(new File(strSnbTospd));
            FinishListener finishListener2 = this.mFinishListener;
            if (finishListener2 != null) {
                finishListener2.onFinish(str, sDocUUID, true);
            }
            return true;
        }
        deleteMemo(str);
        title = null;
        long jLastModified2 = new File(str).lastModified();
        if (!isSNBLocked(str)) {
        }
    }

    public ArrayList<String> convertSNBToSDocFile(String str, String str2) throws Throwable {
        SpenSDoc spenSDoc;
        if (str == null) {
            DocumentLogger.m7179e(TAG, "converterToSDoc - snb path is null");
            return null;
        }
        DocumentLogger.m7181i(TAG, "snbTospd start");
        String strSnbTospd = snbTospd(str, str2);
        DocumentLogger.m7181i(TAG, "snbTospd done");
        if (strSnbTospd != null) {
            ArrayList<String> arrayListConvertSPDToSDocFile = convertSPDToSDocFile(strSnbTospd, str2);
            FileUtil.deleteFile(new File(strSnbTospd));
            return arrayListConvertSPDToSDocFile;
        }
        long jLastModified = new File(str).lastModified();
        String title = ConverterUtils.getTitle(str);
        String str3 = AppDelegator.getInstance().getNoteFilePath(this.mContext) + "[" + title + "]_" + new Date().getTime() + ".sdoc";
        try {
            spenSDoc = new SpenSDoc(this.mContext, str3, (String) null, (String[]) null);
        } catch (SpenSDocInvalidPasswordException | SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException e) {
            DocumentLogger.m7180e(TAG, "convertToSDocFile", e);
            spenSDoc = null;
        }
        SpenContentText spenContentText = new SpenContentText();
        spenContentText.setText("");
        spenSDoc.getTitle().setText(title);
        try {
            spenSDoc.appendContent(spenContentText);
        } catch (SpenExceedImageLimitException | SpenExceedTextLimitException e2) {
            DocumentLogger.m7180e(TAG, "convertToSDocFile", e2);
        }
        spenSDoc.save(str3, null, jLastModified, jLastModified);
        spenSDoc.close(true);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str3);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String convertSPDToSDoc(String str, int i, String str2, ArrayMap<String, Long> arrayMap) throws Throwable {
        String title;
        long time = new Date().getTime();
        DocumentLogger.m7181i(TAG, "convertSPDToSDoc - " + SDocUtil.logPath(str));
        String sDocUUID = null;
        if (str == null || !SpenNoteFile.isValid(str)) {
            DocumentLogger.m7179e(TAG, SDocUtil.logPath(str) + " is not a spd file");
            return null;
        }
        if (i != 1) {
            if (i == 2 && isAlreadyConverted(str)) {
                title = ConverterUtils.getTitle(str);
            }
            long createdTime = getCreatedTime(str);
            long lastModifiedTime = getLastModifiedTime(str);
            if (!SpenNoteFile.isLocked(str)) {
                return saveLockFile(this.mContext, str, createdTime, lastModifiedTime, SpenNoteFile.isFavorite(str), AppDelegator.getInstance().getLockTypeSPD(), title);
            }
            ArrayList<String> arrayListCreateSdoc = createSdoc(str, str, null, null, null, createdTime, lastModifiedTime, title, true, true, false);
            if (arrayListCreateSdoc != null && arrayListCreateSdoc.size() > 0) {
                sDocUUID = AppDelegator.getInstance().getSDocUUID(this.mContext, arrayListCreateSdoc.get(0));
            }
            String str3 = sDocUUID;
            FinishListener finishListener = this.mFinishListener;
            if (finishListener != null) {
                finishListener.onFinish(str, str3, true);
            }
            DocumentLogger.m7181i(TAG, "_convertTOSDoc - end : " + SDocUtil.logPath(str) + " / " + (new Date().getTime() - time));
            return str3;
        }
        deleteMemo(str);
        title = null;
        long createdTime2 = getCreatedTime(str);
        long lastModifiedTime2 = getLastModifiedTime(str);
        if (!SpenNoteFile.isLocked(str)) {
        }
    }

    public ArrayList<String> convertSPDToSDocFile(String str, String str2) throws Throwable {
        DocumentLogger.m7181i(TAG, "convertToSDocFile - start");
        if (SpenNoteFile.isValid(str)) {
            ArrayList<String> arrayListCreateSdoc = createSdoc(str, str, null, null, str2, getCreatedTime(str), getLastModifiedTime(str), null, false, false, false);
            DocumentLogger.m7181i(TAG, "convertToSDocFile - end");
            return arrayListCreateSdoc;
        }
        DocumentLogger.m7179e(TAG, SDocUtil.logPath(str) + " is not a spd file");
        return null;
    }

    public long getLastModifiedTime(String str) {
        long lastModifiedTime = SpenNoteFile.getLastModifiedTime(str);
        return lastModifiedTime <= 0 ? new Date().getTime() : lastModifiedTime / 1000;
    }

    public boolean isAlreadyConverted(String str) {
        String title;
        ArrayList<String> noteFilePathList;
        String strSubstring;
        if (str != null && (title = ConverterUtils.getTitle(str)) != null && (noteFilePathList = AppDelegator.getInstance().getNoteFilePathList(this.mContext, false)) != null && noteFilePathList.size() != 0) {
            for (int i = 0; i < noteFilePathList.size(); i++) {
                String str2 = noteFilePathList.get(i);
                if (str2 != null) {
                    int iIndexOf = str2.indexOf("[");
                    int iLastIndexOf = str2.lastIndexOf("]");
                    if (iIndexOf >= 0 && iLastIndexOf >= 0 && iLastIndexOf > iIndexOf) {
                        int i2 = iIndexOf + 1;
                        if (iLastIndexOf - i2 > 0 && (strSubstring = str2.substring(i2, iLastIndexOf)) != null && strSubstring.length() > 0 && strSubstring.compareTo(title) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isRightSPDPassword(String str, String str2) {
        DocumentLogger.m7178d(TAG, "isRightPassword() : spd path : " + SDocUtil.logPath(str));
        if (str2 == null || str2.isEmpty()) {
            DocumentLogger.m7178d(TAG, "isRightPassword() : spd password is null or empty");
            return false;
        }
        if (str == null) {
            DocumentLogger.m7178d(TAG, "isRightPassword() : spd path is null ");
            return false;
        }
        if (AbstractC2322a.m1607A(str)) {
            return SpenNoteFile.isrightPassword(this.mContext, str, str2);
        }
        DocumentLogger.m7178d(TAG, "isRightPassword() : spd is not existed ");
        return false;
    }

    public boolean isRightSnbPassword(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        String title = ConverterUtils.getTitle(str);
        File cacheDir = this.mContext.getCacheDir();
        String strM757C = AbstractC0541b.m757C(cacheDir != null ? cacheDir.toString() : "", "/", title);
        File file = new File(strM757C);
        if (file.mkdir() || file.exists()) {
            boolean zIsRightSnbPassword = this.mSnbConverter.isRightSnbPassword(str, str2, strM757C);
            try {
                FileUtil.deleteFile(file);
                return zIsRightSnbPassword;
            } catch (Exception unused) {
                DocumentLogger.m7179e(TAG, "Fail To Delete Cache File");
                return zIsRightSnbPassword;
            }
        }
        DocumentLogger.m7179e(TAG, "isRightSnbPassword() : Can't make directory( " + file + " )");
        return false;
    }

    public boolean isSNBLocked(String str) {
        return this.mSnbConverter.isLockedSnbFile(str);
    }

    public boolean isSPDLocked(String str) {
        return SpenNoteFile.isLocked(str);
    }

    public void setFinishListener(FinishListener finishListener) {
        this.mFinishListener = finishListener;
    }

    public void setKMemoProgressListener(ProgressListener progressListener) {
        this.mKmemoProgressListener = progressListener;
    }

    public boolean setMaxPageCountForSDoc(int i) {
        if (i <= 0) {
            return false;
        }
        return this.mSpdExtractor.setMaxPageCountForSdoc(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0228 A[Catch: Exception -> 0x0231, TryCatch #3 {Exception -> 0x0231, blocks: (B:70:0x0223, B:72:0x0228, B:74:0x022d), top: B:86:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022d A[Catch: Exception -> 0x0231, TRY_LEAVE, TryCatch #3 {Exception -> 0x0231, blocks: (B:70:0x0223, B:72:0x0228, B:74:0x022d), top: B:86:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0223 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String snbTospd(String str, String str2) {
        String str3;
        Bitmap bitmap;
        Bitmap bitmap2;
        String str4;
        String str5;
        String str6;
        String str7;
        Bitmap bitmap3;
        String str8 = "SAMSUNGNOTES_SNB_CONVERTER_FG_IMAGE_CROP_DATA_B";
        String str9 = "SAMSUNGNOTES_SNB_CONVERTER_FG_IMAGE_CROP_DATA_T";
        SpenNoteDoc spenNoteDoc = null;
        Bitmap image = null;
        if (str == null) {
            DocumentLogger.m7179e(TAG, "path is invalid");
            return null;
        }
        if (!AbstractC2322a.m1607A(str)) {
            DocumentLogger.m7179e(TAG, "file is invalid");
            return null;
        }
        String title = ConverterUtils.getTitle(str);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null || !cacheDir.exists()) {
            DocumentLogger.m7179e(TAG, "Can't Write To Cache folder");
            return null;
        }
        String strM2221l = AbstractC2821a.m2221l(cacheDir.getAbsolutePath(), "/", title, ".spd");
        DocumentLogger.m7181i(TAG, "convert snb start");
        String noteDoc = this.mSnbConverter.getNoteDoc(str, strM2221l, this.mContext.getFilesDir().getAbsolutePath(), str2, this.mContext, this.mNoteWidth, this.mNoteHeight);
        DocumentLogger.m7181i(TAG, "convert snb done");
        if (noteDoc == null) {
            DocumentLogger.m7181i(TAG, "fail to convert snb. make a empty spd");
        }
        try {
            DocumentLogger.m7181i(TAG, "new SpenNoteDoc");
            Context context = this.mContext;
            SpenNoteDoc spenNoteDoc2 = new SpenNoteDoc(context, noteDoc, str2, context.getResources().getDisplayMetrics().widthPixels, 1);
            str3 = noteDoc;
            boolean z = false;
            Bitmap bitmap4 = null;
            int i = 0;
            while (i < spenNoteDoc2.getPageCount()) {
                try {
                    SpenPageDoc page = spenNoteDoc2.getPage(i);
                    if (page != null) {
                        int i2 = z;
                        while (i2 < page.getObjectCount(z)) {
                            SpenObjectBase object = page.getObject(i2);
                            if (object == null) {
                                str6 = str8;
                                str7 = str9;
                                bitmap3 = bitmap4;
                            } else if (object.getType() == 3 && object.hasExtraDataInt("SAMSUNGNOTES_SNB_CONVERTER_FG_IMAGE_CROP_DATA_R")) {
                                image = ((SpenObjectImage) object).getImage();
                                if (image == null) {
                                    str4 = str8;
                                    str5 = str9;
                                    bitmap2 = bitmap4;
                                    z = false;
                                } else {
                                    int width = image.getWidth();
                                    int height = image.getHeight();
                                    RectF rect = object.getRect();
                                    Rect rect2 = new Rect();
                                    bitmap2 = bitmap4;
                                    rect2.right = object.getExtraDataInt("SAMSUNGNOTES_SNB_CONVERTER_FG_IMAGE_CROP_DATA_R");
                                    rect2.left = object.getExtraDataInt("SAMSUNGNOTES_SNB_CONVERTER_FG_IMAGE_CROP_DATA_L");
                                    rect2.top = object.getExtraDataInt(str9);
                                    rect2.bottom = object.getExtraDataInt(str8);
                                    object.removeExtraDataInt("SAMSUNGNOTES_SNB_CONVERTER_FG_IMAGE_CROP_DATA_L");
                                    object.removeExtraDataInt(str9);
                                    object.removeExtraDataInt("SAMSUNGNOTES_SNB_CONVERTER_FG_IMAGE_CROP_DATA_R");
                                    object.removeExtraDataInt(str8);
                                    str4 = str8;
                                    if (rect2.left >= rect2.right || rect2.top >= rect2.bottom) {
                                        str5 = str9;
                                        z = false;
                                        image.recycle();
                                        page.removeObject(object);
                                    } else {
                                        DocumentLogger.m7181i(TAG, "Start Corp Foreground Bitmap " + rect2);
                                        str5 = str9;
                                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(image, rect2.left, rect2.top, rect2.width(), rect2.height());
                                        try {
                                            DocumentLogger.m7181i(TAG, "createBitmap " + bitmapCreateBitmap);
                                            if (bitmapCreateBitmap != null) {
                                                RectF rectF = new RectF();
                                                float f = width;
                                                rectF.left = ((rect.width() / f) * rect2.left) + rect.left;
                                                rectF.right = ((rect.width() / f) * rect2.right) + rect.left;
                                                float f4 = height;
                                                rectF.top = ((rect.height() / f4) * rect2.top) + rect.top;
                                                rectF.bottom = ((rect.height() / f4) * rect2.bottom) + rect.top;
                                                ((SpenObjectImage) object).setImage(bitmapCreateBitmap);
                                                z = false;
                                                object.setRect(rectF, false);
                                                DocumentLogger.m7181i(TAG, "End Corp Foreground Bitmap " + rect2);
                                                bitmapCreateBitmap.recycle();
                                            } else {
                                                z = false;
                                            }
                                            image.recycle();
                                            bitmap4 = bitmapCreateBitmap;
                                        } catch (Exception e) {
                                            e = e;
                                            bitmap2 = bitmapCreateBitmap;
                                            bitmap = image;
                                            spenNoteDoc = spenNoteDoc2;
                                            DocumentLogger.m7179e(TAG, "Fail to resize stroke image " + e);
                                            if (spenNoteDoc != null) {
                                                try {
                                                    spenNoteDoc.close();
                                                } catch (Exception unused) {
                                                    DocumentLogger.m7179e(TAG, "Fail to resize stroke image " + e);
                                                    return str3;
                                                }
                                            }
                                            if (bitmap != null) {
                                                bitmap.recycle();
                                            }
                                            if (bitmap2 != null) {
                                                bitmap2.recycle();
                                            }
                                            return str3;
                                        }
                                    }
                                }
                                bitmap4 = bitmap2;
                            } else {
                                str6 = str8;
                                str7 = str9;
                                bitmap3 = bitmap4;
                                z = false;
                            }
                            i2++;
                            bitmap4 = bitmap3;
                            str8 = str6;
                            str9 = str7;
                        }
                        str4 = str8;
                        str5 = str9;
                        bitmap2 = bitmap4;
                        bitmap4 = bitmap2;
                    } else {
                        str4 = str8;
                        str5 = str9;
                        bitmap2 = bitmap4;
                        bitmap4 = bitmap2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bitmap2 = bitmap4;
                }
                try {
                    i++;
                    str8 = str4;
                    str9 = str5;
                } catch (Exception e3) {
                    e = e3;
                    bitmap = image;
                    spenNoteDoc = spenNoteDoc2;
                    DocumentLogger.m7179e(TAG, "Fail to resize stroke image " + e);
                    if (spenNoteDoc != null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bitmap2 != null) {
                    }
                    return str3;
                }
            }
            bitmap2 = bitmap4;
            spenNoteDoc2.save(str3, true);
            DocumentLogger.m7181i(TAG, "new note save");
            spenNoteDoc2.close();
            return str3;
        } catch (Exception e5) {
            e = e5;
            str3 = noteDoc;
            bitmap = null;
            bitmap2 = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void unlockSNB(String str, String str2, boolean z) throws Throwable {
        boolean z2;
        if (str == null) {
            DocumentLogger.m7179e(TAG, "unlockSNB : doc is null");
            FinishListener finishListener = this.mFinishListener;
            if (finishListener != null) {
                finishListener.onFinish(null, null, false);
            }
        } else {
            try {
                SpenSDoc spenSDoc = new SpenSDoc(this.mContext, str, (String) null, (String[]) null);
                String text = spenSDoc.getTitle() != null ? spenSDoc.getTitle().getText() : null;
                String boundFilePath = spenSDoc.getBoundFilePath(0);
                long modifiedTime = spenSDoc.getModifiedTime();
                long createdTime = spenSDoc.getCreatedTime();
                spenSDoc.close(false);
                if (boundFilePath == null) {
                    DocumentLogger.m7179e(TAG, "unlockSNB : snbPath is null");
                    FinishListener finishListener2 = this.mFinishListener;
                    if (finishListener2 != null) {
                        finishListener2.onFinish(null, null, false);
                    }
                } else {
                    if (this.mSnbConverter.isLockedSnbFile(boundFilePath)) {
                        String sDocUUID = AppDelegator.getInstance().getSDocUUID(this.mContext, str);
                        String strSnbTospd = snbTospd(boundFilePath, str2);
                        ArrayList<String> arrayListCreateSdoc = createSdoc(strSnbTospd, boundFilePath, str, sDocUUID, str2, createdTime, modifiedTime, text, true, false, z);
                        if (arrayListCreateSdoc != null) {
                            try {
                                z2 = arrayListCreateSdoc.size() > 0;
                            } catch (Exception e) {
                                e = e;
                                if (e instanceof SpenInvalidPasswordException) {
                                    throw new SpenInvalidPasswordException("invalid password");
                                }
                                DocumentLogger.m7179e(TAG, "unlockSNB fail " + e);
                                return;
                            }
                        }
                        FinishListener finishListener3 = this.mFinishListener;
                        if (finishListener3 != null) {
                            finishListener3.onFinish(strSnbTospd, sDocUUID, z2);
                        }
                        if (z2) {
                            SpenSDoc spenSDoc2 = new SpenSDoc(this.mContext, str, (String) null, (String[]) null);
                            spenSDoc2.releaseFile(0);
                            spenSDoc2.save(str, null, spenSDoc2.getCreatedTime(), spenSDoc2.getModifiedTime());
                            spenSDoc2.close(true);
                            return;
                        }
                        return;
                    }
                    DocumentLogger.m7179e(TAG, "unlockSNB : spdPath is unlocked");
                    FinishListener finishListener4 = this.mFinishListener;
                    if (finishListener4 != null) {
                        finishListener4.onFinish(null, null, false);
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void unlockSPD(String str, String str2, boolean z) throws Throwable {
        boolean z2;
        DocumentLogger.m7181i(TAG, "unlockSPD start : " + SDocUtil.logPath(str));
        if (str == null) {
            DocumentLogger.m7179e(TAG, "unlockSPD : docUuid is null");
            FinishListener finishListener = this.mFinishListener;
            if (finishListener != null) {
                finishListener.onFinish(null, null, false);
            }
        } else {
            try {
                SpenSDoc spenSDoc = new SpenSDoc(this.mContext, str, (String) null, (String[]) null);
                if (spenSDoc.getDocumentType() != 2) {
                    DocumentLogger.m7181i(TAG, "unlockSPD - " + SDocUtil.logPath(str) + " is not lock file");
                    spenSDoc.close(true);
                    FinishListener finishListener2 = this.mFinishListener;
                    if (finishListener2 != null) {
                        finishListener2.onFinish(null, null, false);
                    }
                } else {
                    String text = spenSDoc.getTitle() != null ? spenSDoc.getTitle().getText() : null;
                    String boundFilePath = spenSDoc.getBoundFilePath(0);
                    spenSDoc.close(false);
                    if (boundFilePath == null) {
                        DocumentLogger.m7179e(TAG, "unlockSPD : spdPath is null");
                        FinishListener finishListener3 = this.mFinishListener;
                        if (finishListener3 != null) {
                            finishListener3.onFinish(boundFilePath, null, false);
                        }
                    } else {
                        if (SpenNoteFile.isLocked(boundFilePath)) {
                            long createdTime = getCreatedTime(boundFilePath);
                            long lastModifiedTime = getLastModifiedTime(boundFilePath);
                            String sDocUUID = AppDelegator.getInstance().getSDocUUID(this.mContext, str);
                            ArrayList<String> arrayListCreateSdoc = createSdoc(boundFilePath, boundFilePath, str, sDocUUID, str2, createdTime, lastModifiedTime, text, true, false, z);
                            if (arrayListCreateSdoc != null) {
                                try {
                                    z2 = arrayListCreateSdoc.size() > 0;
                                } catch (Exception e) {
                                    e = e;
                                    if (e instanceof SpenInvalidPasswordException) {
                                        throw new SpenInvalidPasswordException("invalid password");
                                    }
                                    DocumentLogger.m7179e(TAG, "unlockSPD fail " + e);
                                    return;
                                }
                            }
                            FinishListener finishListener4 = this.mFinishListener;
                            if (finishListener4 != null) {
                                finishListener4.onFinish(boundFilePath, sDocUUID, z2);
                            }
                            if (z2) {
                                SpenSDoc spenSDoc2 = new SpenSDoc(this.mContext, str, (String) null, (String[]) null);
                                spenSDoc2.releaseFile(0);
                                spenSDoc2.save(str, null, createdTime, lastModifiedTime);
                                spenSDoc2.close(true);
                                return;
                            }
                            return;
                        }
                        DocumentLogger.m7179e(TAG, "unlockSPD : spdPath is unlocked");
                        FinishListener finishListener5 = this.mFinishListener;
                        if (finishListener5 != null) {
                            finishListener5.onFinish(boundFilePath, null, false);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }
}
