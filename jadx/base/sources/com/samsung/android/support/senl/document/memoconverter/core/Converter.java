package com.samsung.android.support.senl.document.memoconverter.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentDrawing;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentImage;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentVoice;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenExceedImageLimitException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenExceedTextLimitException;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.support.senl.document.C7991R;
import com.samsung.android.support.senl.document.data.ConverterFileDataAdapter;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.delegator.DocumentSaveSDoc;
import com.samsung.android.support.senl.document.memoconverter.core.Html.HtmlUtil;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Converter {
    private static final String CHECK_NO = "⬜";
    private static final String CHECK_YES = "⬛";
    private static final int COMPRESS_QUALITY = AppDelegator.getInstance().getThumbnailCompressQuality();
    private static final String IMAGE_CONTENT_STARTER = "<img src=";
    private static final String MEMO_DRAW = "MemoDraw";
    private static final String TAG = "Converter";
    private static final int TODO_ID_STARTER = 10000;
    private static final String TODO_LINE_ENDER = "\t</p>";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CategoryData {
        public String dpName;
        public String uuid;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SDocDBData {
        public String prevUUID = "";
        public String category = "";
        public String strippedContent = "";
        public String lastModifiedTime = "";
        public String favorite = "";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SDocData {
        public String categoryUUID;
        public String content;
        public String createdAt;
        public String data;
        public String favorite;

        /* JADX INFO: renamed from: id */
        public String f5901id;
        public String lastModifiedAt;
        public String strippedContent;
        public String title;
        public String uuid;
    }

    public static String addCategory(Context context, String str) {
        if (str != null) {
            return AppDelegator.getInstance().addCategory(context, str);
        }
        return null;
    }

    private static boolean containImage(String str) {
        return str != null && str.contains(IMAGE_CONTENT_STARTER);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x036b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0361  */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String createSDoc(Context context, SDocData sDocData, ArrayList<ConverterFileDataAdapter> arrayList, String str) throws Throwable {
        SpenSDoc spenSDoc;
        int i;
        SpenContentVoice spenContentVoice;
        String str2;
        SpenSDoc spenSDoc2;
        boolean z;
        Object obj;
        boolean z2;
        ?? file;
        Bitmap bitmapCreateBitmap;
        Object obj2;
        ArrayList<ConverterFileDataAdapter> arrayList2 = arrayList;
        String str3 = sDocData.uuid;
        String str4 = sDocData.title;
        String str5 = sDocData.content;
        if (str4 == null && str5 == null) {
            return str;
        }
        String str6 = str == null ? AppDelegator.getInstance().getNoteFilePath(context) + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + "[" + str3 + "].sdoc" : str;
        SpenContentVoice spenContentVoice2 = null;
        try {
            SpenSDoc spenSDoc3 = new SpenSDoc(context, str6, (String) null, (String[]) null);
            HashMap map = new HashMap();
            if (str4 != null) {
                spenSDoc3.getTitle().setText(str4);
            }
            String str7 = sDocData.favorite;
            if (str7 != null && str7.compareTo("1") == 0) {
                spenSDoc3.setFavorite(true);
            }
            ArrayList arrayList3 = new ArrayList();
            if (arrayList2 != null) {
                DocumentLogger.m7181i(TAG, "createSDoc() : image file cnt : " + arrayList2.size());
                SpenContentVoice spenContentVoice3 = null;
                int i2 = 0;
                while (i2 < arrayList2.size()) {
                    ConverterFileDataAdapter converterFileDataAdapter = arrayList2.get(i2);
                    String str8 = converterFileDataAdapter.curFullPath;
                    SpenContentVoice spenContentVoice4 = spenContentVoice2;
                    String str9 = converterFileDataAdapter.uuid;
                    String str10 = converterFileDataAdapter.mime_type;
                    String str11 = converterFileDataAdapter.orientation;
                    String str12 = str6;
                    StringBuilder sbM778t = AbstractC0541b.m778t(i2, "createSDoc - file info : ", " / ");
                    int i4 = i2;
                    sbM778t.append(SDocUtil.logPath(str8));
                    sbM778t.append(" / ");
                    sbM778t.append(str9);
                    sbM778t.append(" / ");
                    sbM778t.append(str10);
                    sbM778t.append(" / ");
                    sbM778t.append(str11);
                    DocumentLogger.m7181i(TAG, sbM778t.toString());
                    int i5 = str11.compareTo("90") == 0 ? 90 : str11.compareTo("180") == 0 ? 180 : str11.compareTo("270") == 0 ? 270 : 0;
                    String str13 = Extension.DOT + str10.substring(6, str10.length());
                    converterFileDataAdapter.fileType = str10.substring(0, 5);
                    File file2 = new File(str8);
                    if (file2.exists()) {
                        String str14 = context.getCacheDir() + "/file_OldMemo_" + str9 + str13;
                        spenContentVoice = spenContentVoice3;
                        if (converterFileDataAdapter.fileType.compareTo("image") == 0 && str13.compareTo(".png") != 0 && i5 != 0) {
                            int samplingRate = getSamplingRate(context, str8, i5);
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = samplingRate;
                            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str8, options);
                            if (bitmapDecodeFile != null) {
                                float resizeImageRect = getResizeImageRect(context, bitmapDecodeFile, i5);
                                Matrix matrix = new Matrix();
                                matrix.postScale(resizeImageRect, resizeImageRect);
                                matrix.postRotate(i5);
                                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                                File file3 = new File(str14);
                                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                bitmapCreateBitmap2.compress(Bitmap.CompressFormat.JPEG, COMPRESS_QUALITY, fileOutputStream);
                                fileOutputStream.close();
                                bitmapDecodeFile.recycle();
                                bitmapCreateBitmap2.recycle();
                                file = file3;
                            } else {
                                file = spenContentVoice4;
                            }
                        } else if (converterFileDataAdapter.fileType.compareTo("image") == 0 && str13.compareTo(".png") == 0) {
                            str14 = context.getCacheDir() + "/file_OldMemo" + str9 + ".jpeg";
                            Bitmap bitmapDecodeFile2 = BitmapFactory.decodeFile(str8);
                            if (bitmapDecodeFile2 == null) {
                                DocumentLogger.m7179e(TAG, "Fail to decode bitmap");
                            } else {
                                if (i5 != 0) {
                                    Matrix matrix2 = new Matrix();
                                    matrix2.postRotate(i5);
                                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile2, 0, 0, bitmapDecodeFile2.getWidth(), bitmapDecodeFile2.getHeight(), matrix2, true);
                                    bitmapDecodeFile2.recycle();
                                } else {
                                    bitmapCreateBitmap = bitmapDecodeFile2;
                                }
                                if (savePNGBitmapToJPEGFile(bitmapCreateBitmap, str14)) {
                                    obj2 = spenContentVoice4;
                                } else {
                                    DocumentLogger.m7179e(TAG, "createSDoc, fail to savePNGBitmapToJPEGFile!");
                                    File file4 = new File(str14);
                                    FileUtil.copyFile(file2, file4);
                                    obj2 = file4;
                                }
                                bitmapCreateBitmap.recycle();
                                file = obj2;
                            }
                        } else {
                            String str15 = converterFileDataAdapter.display_name;
                            if (str15 != null) {
                                z = true;
                                if (str15.contains(MEMO_DRAW)) {
                                    file = spenContentVoice4;
                                    str2 = str5;
                                    spenSDoc2 = spenSDoc3;
                                    z2 = false;
                                }
                                if (!z2) {
                                    file = new File(str14);
                                    FileUtil.copyFile(file2, file);
                                }
                                map.put(str9, str14);
                                if (converterFileDataAdapter.fileType.compareTo("audio") == 0) {
                                    spenContentVoice3 = new SpenContentVoice();
                                    spenContentVoice3.setState(4);
                                    spenContentVoice3.setText(converterFileDataAdapter.display_name);
                                    spenContentVoice3.attachFile(str14);
                                    spenContentVoice3.setPlayTime(getVoiceRuntime(str14));
                                } else {
                                    spenContentVoice3 = spenContentVoice;
                                }
                                if (file != 0) {
                                    arrayList3.add(str14);
                                }
                                i2 = i4 + 1;
                                arrayList2 = arrayList;
                                spenContentVoice2 = spenContentVoice4;
                                str6 = str12;
                                str5 = str2;
                                spenSDoc3 = spenSDoc2;
                            } else {
                                z = true;
                            }
                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                            options2.inJustDecodeBounds = z;
                            BitmapFactory.decodeFile(str8, options2);
                            int maxTextureSize = AppDelegator.getInstance().getMaxTextureSize();
                            int iWidth = AppDelegator.getInstance().getScreenDimension(context).width();
                            int i6 = options2.outHeight;
                            if (i6 > maxTextureSize) {
                                float f = maxTextureSize / i6;
                                Matrix matrix3 = new Matrix();
                                matrix3.postScale(f, f);
                                Bitmap bitmapDecodeFile3 = BitmapFactory.decodeFile(str8);
                                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapDecodeFile3, 0, 0, bitmapDecodeFile3.getWidth(), bitmapDecodeFile3.getHeight(), matrix3, true);
                                File file5 = new File(str14);
                                str2 = str5;
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file5);
                                spenSDoc2 = spenSDoc3;
                                bitmapCreateBitmap3.compress(Bitmap.CompressFormat.JPEG, COMPRESS_QUALITY, fileOutputStream2);
                                fileOutputStream2.close();
                                bitmapDecodeFile3.recycle();
                                bitmapCreateBitmap3.recycle();
                                obj = file5;
                                z2 = true;
                            } else {
                                str2 = str5;
                                spenSDoc2 = spenSDoc3;
                                obj = spenContentVoice4;
                                z2 = false;
                            }
                            if (options2.outWidth > iWidth) {
                                int samplingRate2 = getSamplingRate(context, str8, i5);
                                BitmapFactory.Options options3 = new BitmapFactory.Options();
                                options3.inSampleSize = samplingRate2;
                                Bitmap bitmapDecodeFile4 = BitmapFactory.decodeFile(str8, options3);
                                Object obj3 = obj;
                                if (bitmapDecodeFile4 != null) {
                                    float resizeImageRect2 = getResizeImageRect(context, bitmapDecodeFile4, i5);
                                    Matrix matrix4 = new Matrix();
                                    matrix4.postScale(resizeImageRect2, resizeImageRect2);
                                    matrix4.postRotate(i5);
                                    DocumentLogger.m7178d(TAG, "createSDoc, resize width : " + iWidth + " from " + options2.outWidth);
                                    Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap(bitmapDecodeFile4, 0, 0, bitmapDecodeFile4.getWidth(), bitmapDecodeFile4.getHeight(), matrix4, true);
                                    File file6 = new File(str14);
                                    FileOutputStream fileOutputStream3 = new FileOutputStream(file6);
                                    bitmapCreateBitmap4.compress(Bitmap.CompressFormat.JPEG, COMPRESS_QUALITY, fileOutputStream3);
                                    fileOutputStream3.close();
                                    bitmapDecodeFile4.recycle();
                                    bitmapCreateBitmap4.recycle();
                                    obj3 = file6;
                                }
                                file = obj3;
                                z2 = true;
                            } else {
                                file = obj;
                            }
                            if (!z2) {
                            }
                            map.put(str9, str14);
                            if (converterFileDataAdapter.fileType.compareTo("audio") == 0) {
                            }
                            if (file != 0) {
                            }
                            i2 = i4 + 1;
                            arrayList2 = arrayList;
                            spenContentVoice2 = spenContentVoice4;
                            str6 = str12;
                            str5 = str2;
                            spenSDoc3 = spenSDoc2;
                        }
                        str2 = str5;
                        spenSDoc2 = spenSDoc3;
                        map.put(str9, str14);
                        if (converterFileDataAdapter.fileType.compareTo("audio") == 0) {
                        }
                        if (file != 0) {
                        }
                        i2 = i4 + 1;
                        arrayList2 = arrayList;
                        spenContentVoice2 = spenContentVoice4;
                        str6 = str12;
                        str5 = str2;
                        spenSDoc3 = spenSDoc2;
                    } else {
                        spenContentVoice = spenContentVoice3;
                    }
                    str2 = str5;
                    spenSDoc2 = spenSDoc3;
                    spenContentVoice3 = spenContentVoice;
                    i2 = i4 + 1;
                    arrayList2 = arrayList;
                    spenContentVoice2 = spenContentVoice4;
                    str6 = str12;
                    str5 = str2;
                    spenSDoc3 = spenSDoc2;
                }
                spenContentVoice2 = spenContentVoice3;
            }
            String str16 = str5;
            SpenSDoc spenSDoc4 = spenSDoc3;
            String str17 = str6;
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            if (str16 != null) {
                i = 0;
                arrayList5.add(0);
                int iIsTodo = isTodo(str16);
                if (iIsTodo == 1 || iIsTodo == 2) {
                    spenSDoc = spenSDoc4;
                    ArrayList<SpenContentBase> arrayListDevideContentWithTodo = devideContentWithTodo(context, spenSDoc, str16, arrayList5, map);
                    if (arrayListDevideContentWithTodo != null && arrayListDevideContentWithTodo.size() > 0) {
                        arrayList4.addAll(arrayListDevideContentWithTodo);
                    }
                } else {
                    spenSDoc = spenSDoc4;
                    ArrayList<SpenContentBase> textImageContent = parseTextImageContent(context, spenSDoc, str16, arrayList5, map);
                    if (textImageContent != null && textImageContent.size() > 0) {
                        arrayList4.addAll(textImageContent);
                    }
                }
            } else {
                spenSDoc = spenSDoc4;
                i = 0;
            }
            if (spenContentVoice2 != null) {
                arrayList4.add(spenContentVoice2);
            }
            for (int i7 = i; i7 < arrayList4.size(); i7++) {
                try {
                    spenSDoc.appendContent((SpenContentBase) arrayList4.get(i7));
                } catch (SpenExceedImageLimitException | SpenExceedTextLimitException e) {
                    DocumentLogger.m7180e(TAG, "createSDoc", e);
                }
            }
            DocumentLogger.m7181i(TAG, "createSDoc() : " + SDocUtil.logPath(str17));
            spenSDoc.save(str17, null, Long.parseLong(sDocData.createdAt), Long.parseLong(sDocData.lastModifiedAt));
            spenSDoc.close(true);
            for (int i8 = i; i8 < arrayList3.size(); i8++) {
                File file7 = new File((String) arrayList3.get(i8));
                if (file7.exists()) {
                    file7.delete();
                }
            }
            return str17;
        } catch (Exception e2) {
            DocumentLogger.m7179e(TAG, "createSDoc() - " + e2.toString());
            return null;
        }
    }

    private static ArrayList<SpenContentBase> devideContentWithTodo(Context context, SpenSDoc spenSDoc, String str, ArrayList<Integer> arrayList, HashMap<String, String> map) {
        boolean z;
        if (str == null || str.length() <= 0) {
            return null;
        }
        ArrayList<SpenContentBase> arrayList2 = new ArrayList<>();
        String[] strArrSplit = str.split("</p>");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(10000);
        int i = 0;
        String string = "";
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            String strM1170p = AbstractC0622a.m1170p(strArrSplit[i2], "</p>", new StringBuilder());
            strArrSplit[i2] = strM1170p;
            int iIsTodo = isTodo(strM1170p);
            if (iIsTodo == 1 || iIsTodo == 2) {
                if (string.length() > 0) {
                    if (i == 0) {
                        arrayList2.addAll(parseTextImageContent(context, spenSDoc, string, arrayList, map));
                    } else {
                        ArrayList<SpenContentBase> textImageContent = parseTextImageContent(context, spenSDoc, string, arrayList, map);
                        fillToDoData(textImageContent, i, arrayList3);
                        arrayList2.addAll(textImageContent);
                    }
                }
                if (iIsTodo == 1) {
                    strArrSplit[i2] = strArrSplit[i2].replaceFirst(CHECK_NO, "");
                } else {
                    strArrSplit[i2] = strArrSplit[i2].replaceFirst(CHECK_YES, "");
                }
                string = "";
                i = iIsTodo;
            }
            if (strArrSplit[i2].contains(TODO_LINE_ENDER)) {
                strArrSplit[i2] = strArrSplit[i2].replaceFirst("\t", "");
                StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
                sbM1324q.append(strArrSplit[i2]);
                ArrayList<SpenContentBase> textImageContent2 = parseTextImageContent(context, spenSDoc, sbM1324q.toString(), arrayList, map);
                fillToDoData(textImageContent2, i, arrayList3);
                arrayList2.addAll(textImageContent2);
                i = 0;
                z = false;
                string = "";
            } else {
                z = true;
            }
            if (z) {
                StringBuilder sbM1324q2 = AbstractC1974b.m1324q(string);
                sbM1324q2.append(strArrSplit[i2]);
                string = sbM1324q2.toString();
            }
        }
        if (string.length() > 0) {
            arrayList2.addAll(parseTextImageContent(context, spenSDoc, string, arrayList, map));
        }
        return arrayList2;
    }

    private static void fillToDoData(ArrayList<SpenContentBase> arrayList, int i, ArrayList<Integer> arrayList2) {
        if (arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            SpenContentBase spenContentBase = arrayList.get(i2);
            spenContentBase.setTaskId(arrayList2.get(0).intValue());
            spenContentBase.setTaskStyle(i);
        }
        int iIntValue = arrayList2.get(0).intValue();
        arrayList2.remove(0);
        arrayList2.add(Integer.valueOf(iIntValue + 1));
    }

    private static SpenContentBase getDrawingContent(Context context, SpenSDoc spenSDoc, String str, ArrayList<Integer> arrayList, HashMap<String, String> map) {
        int iHeight;
        int i;
        try {
            Spanned spannedCharUtils_fromHtml = AppDelegator.getInstance().charUtils_fromHtml(str);
            int i2 = 0;
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannedCharUtils_fromHtml.getSpans(0, spannedCharUtils_fromHtml.length(), ImageSpan.class);
            if (imageSpanArr.length != 1) {
                DocumentLogger.m7179e(TAG, "getDrawingContent() - Error!! Img cnt is " + spannedCharUtils_fromHtml.length());
                return null;
            }
            String source = imageSpanArr[0].getSource();
            if (source == null) {
                DocumentLogger.m7179e(TAG, "getDrawingContent() - image path is null ");
                return null;
            }
            String strSubstring = source.substring(source.lastIndexOf("/") + 1);
            if (!map.containsKey(strSubstring)) {
                DocumentLogger.m7179e(TAG, "getDrawingContent() - No image id");
                return null;
            }
            String str2 = map.get(strSubstring);
            if (str2 == null) {
                DocumentLogger.m7179e(TAG, "getDrawingContent() ; image file is null");
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inMutable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str2, options);
            if (bitmapDecodeFile == null) {
                DocumentLogger.m7179e(TAG, "getDrawingContent() ; image file( " + str2 + " ) can not decode");
                return null;
            }
            Bitmap bitmapCopy = bitmapDecodeFile.copy(Bitmap.Config.ARGB_8888, true);
            int width = bitmapDecodeFile.getWidth();
            int height = bitmapDecodeFile.getHeight();
            int i4 = width * height;
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            bitmapDecodeFile.getPixels(iArr, 0, width, 0, 0, width, height);
            bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
            int color = context.getResources().getColor(C7991R.color.drawing_canvas_background_color);
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i2;
                if (iArr[i5] == -328966) {
                    iArr[i5] = color;
                    iArr2[i5] = i6;
                }
                i5++;
                i2 = i6;
            }
            int i7 = i2;
            bitmapDecodeFile.setPixels(iArr, 0, width, 0, 0, width, height);
            bitmapCopy.setPixels(iArr2, 0, width, 0, 0, width, height);
            int maxTextureSize = AppDelegator.getInstance().getMaxTextureSize();
            int iWidth = AppDelegator.getInstance().getScreenDimension(context).width();
            float f = height > maxTextureSize ? maxTextureSize / height : 1.0f;
            if (width > iWidth) {
                float f4 = iWidth / width;
                if (f > f4) {
                    f = f4;
                }
            }
            if (f < 1.0f) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                DocumentLogger.m7178d(TAG, "getDrawingContent, resize width : " + iWidth + " from " + width);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                if (bitmapDecodeFile != bitmapCreateBitmap) {
                    bitmapDecodeFile.recycle();
                    bitmapDecodeFile = bitmapCreateBitmap;
                }
                bitmapCopy = Bitmap.createBitmap(bitmapCopy, 0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight(), matrix, true);
                if (bitmapCopy != bitmapCopy) {
                    bitmapCopy.recycle();
                } else {
                    bitmapCopy = bitmapCopy;
                }
            }
            String str3 = str2.substring(i7, str2.lastIndexOf(Extension.DOT)) + "THUMBNAIL" + str2.substring(str2.lastIndexOf(Extension.DOT), str2.length());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str3));
            bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, COMPRESS_QUALITY, fileOutputStream);
            fileOutputStream.close();
            bitmapDecodeFile.recycle();
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Rect rect = new Rect();
            defaultDisplay.getRectSize(rect);
            if (rect.height() > rect.width()) {
                iHeight = rect.width();
                i = iHeight / 2;
            } else {
                iHeight = rect.height();
                i = iHeight / 2;
            }
            SpenPaintingDoc spenPaintingDoc = new SpenPaintingDoc(context, iHeight, i * 3, null);
            spenPaintingDoc.setBackgroundColor(color);
            spenPaintingDoc.setForegroundImage(bitmapCopy);
            spenPaintingDoc.setReplayable(false);
            bitmapCopy.recycle();
            RectF rectF = new RectF(0.0f, 0.0f, spenPaintingDoc.getWidth(), spenPaintingDoc.getHeight());
            int height2 = spenPaintingDoc.getHeight();
            String str4 = spenSDoc.getCachePath() + "/" + MEMO_DRAW + "_" + System.currentTimeMillis() + ".spp";
            SpenObjectStroke spenObjectStroke = (SpenObjectStroke) spenPaintingDoc.createObject(1);
            spenObjectStroke.setRect(new RectF(0.0f, 0.0f, 1.0f, 1.0f), false);
            spenObjectStroke.setSelectable(false);
            spenObjectStroke.setColor(0);
            spenObjectStroke.setExtraDataString("NMEMO_DRAWING_TO_PAINTING", "NMEMO_DRAWING_TO_PAINTING");
            spenPaintingDoc.appendObject(spenObjectStroke);
            spenPaintingDoc.save(str4);
            spenPaintingDoc.close();
            SpenContentDrawing spenContentDrawing = new SpenContentDrawing();
            spenContentDrawing.setThumbnailPath(str3);
            spenContentDrawing.setText(MEMO_DRAW);
            spenContentDrawing.setItemHeight(height2);
            spenContentDrawing.setObjectRect(rectF);
            spenContentDrawing.attachFile(str4);
            return spenContentDrawing;
        } catch (IOException e) {
            DocumentLogger.m7181i(TAG, "getDrawingContent - " + e);
            return null;
        }
    }

    private static ArrayList<SpenContentBase> getImageContent(Context context, SpenSDoc spenSDoc, String str, ArrayList<Integer> arrayList, HashMap<String, String> map) {
        if (str == null) {
            return null;
        }
        Spanned spannedCharUtils_fromHtml = AppDelegator.getInstance().charUtils_fromHtml(str);
        String string = spannedCharUtils_fromHtml.toString();
        DocumentLogger.m7181i(TAG, "getImageContent toString: " + SDocUtil.logPath(string));
        int spanEnd = 0;
        ImageSpan[] imageSpanArr = (ImageSpan[]) spannedCharUtils_fromHtml.getSpans(0, spannedCharUtils_fromHtml.length(), ImageSpan.class);
        if (imageSpanArr.length <= 0) {
            DocumentLogger.m7179e(TAG, "getImageContent() - Error!! Img cnt is " + spannedCharUtils_fromHtml.length());
            return null;
        }
        HashMap map2 = new HashMap();
        for (int i = 0; i < imageSpanArr.length; i++) {
            map2.put(Integer.valueOf(i), Integer.valueOf(spannedCharUtils_fromHtml.getSpanStart(imageSpanArr[i])));
        }
        Map<Integer, Integer> mapSortByValue = sortByValue(map2);
        ArrayList<SpenContentBase> arrayList2 = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> it = mapSortByValue.entrySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().getKey().intValue();
            int spanStart = spannedCharUtils_fromHtml.getSpanStart(imageSpanArr[iIntValue]);
            DocumentLogger.m7181i(TAG, AbstractC0622a.m1164j(spanStart, spanEnd, "getImageContent() span parse( ", " / ", " )"));
            if (spanStart - spanEnd > 0) {
                String strSubstring = string.substring(spanEnd, spanStart);
                DocumentLogger.m7181i(TAG, "getImageContent() temp( " + strSubstring + " )");
                arrayList2.addAll(getTextContent(context, strSubstring, arrayList));
            }
            SpenContentImage spenContentImage = new SpenContentImage();
            String source = imageSpanArr[iIntValue].getSource();
            String strSubstring2 = source.substring(source.lastIndexOf("/") + 1);
            if (map.containsKey(strSubstring2)) {
                spenContentImage.setThumbnailPath(map.get(strSubstring2));
                spenContentImage.setText(spenContentImage.getThumbnailPath());
                arrayList2.add(spenContentImage);
                spanEnd = spannedCharUtils_fromHtml.getSpanEnd(imageSpanArr[iIntValue]);
            } else {
                DocumentLogger.m7179e(TAG, "getImageContent() - Error!! no attached file!! SKIP" + strSubstring2);
                spanEnd = spannedCharUtils_fromHtml.getSpanEnd(imageSpanArr[iIntValue]);
            }
        }
        int length = string.length();
        if (length > 2 && string.charAt(length - 1) == '\n' && string.charAt(length - 2) == '\n') {
            length -= 2;
        }
        if (length - spanEnd > 0) {
            String html = HtmlUtil.toHtml(new SpannedString(string.substring(spanEnd, length)));
            StringBuilder sbM780v = AbstractC0541b.m780v("getImageContent() temp( ", spanEnd, html, " ) (", " ~ ");
            sbM780v.append(length);
            sbM780v.append(")");
            DocumentLogger.m7181i(TAG, sbM780v.toString());
            arrayList2.addAll(getTextContent(context, html, arrayList));
        }
        return arrayList2;
    }

    private static float getResizeImageRect(Context context, Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i != 180 && i != 0) {
            width = height;
        }
        Rect screenDimension = AppDelegator.getInstance().getScreenDimension(context);
        int iMin = Math.min(screenDimension.width(), screenDimension.height());
        if (width > iMin) {
            return iMin / width;
        }
        return 1.0f;
    }

    private static int getSamplingRate(Context context, String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        Rect screenDimension = AppDelegator.getInstance().getScreenDimension(context);
        int iMin = (i == 180 ? options.outWidth : options.outHeight) / Math.min(screenDimension.width(), screenDimension.height());
        while (iMin >= 2) {
            iMin /= 2;
            i2 *= 2;
        }
        return i2;
    }

    private static ArrayList<SpenContentBase> getTextContent(Context context, String str, ArrayList<Integer> arrayList) {
        if (str == null) {
            return null;
        }
        ArrayList<SpenContentBase> arrayList2 = new ArrayList<>();
        SpenContentText spenContentText = new SpenContentText();
        if (str.compareTo("<p></p>") == 0) {
            spenContentText.setText("");
            arrayList2.add(spenContentText);
        } else {
            Spanned spannedFromHtml = HtmlUtil.fromHtml(context, str);
            if (spannedFromHtml != null) {
                String[] strArrSplit = spannedFromHtml.toString().split("\\r?\\n");
                if (strArrSplit != null) {
                    for (String str2 : strArrSplit) {
                        SpenContentText spenContentText2 = new SpenContentText();
                        spenContentText2.setText(str2);
                        arrayList2.add(spenContentText2);
                    }
                } else {
                    spenContentText.setText(spannedFromHtml.toString());
                    arrayList2.add(spenContentText);
                }
            }
        }
        DocumentLogger.m7181i(TAG, "getTextContent : " + SDocUtil.logPath(spenContentText.getText()));
        return arrayList2;
    }

    public static String getVoiceRuntime(String str) {
        String strExtractMetadata;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
        } catch (RuntimeException e) {
            Log.e(TAG, e.toString());
            strExtractMetadata = null;
        }
        long j = strExtractMetadata != null ? Long.parseLong(strExtractMetadata) / 1000 : 0L;
        int i = (int) (j / 3600);
        long j2 = j % 3600;
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", Integer.valueOf(i), Integer.valueOf((int) (j2 / 60)), Integer.valueOf((int) (j2 % 60)));
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

    private static int isTodo(String str) {
        if (str.contains(CHECK_NO)) {
            return 1;
        }
        return str.contains(CHECK_YES) ? 2 : 0;
    }

    public static void loadSpenSDK(Context context) {
        initSpenSdk(context);
    }

    private static ArrayList<SpenContentBase> parseTextImageContent(Context context, SpenSDoc spenSDoc, String str, ArrayList<Integer> arrayList, HashMap<String, String> map) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        ArrayList<SpenContentBase> arrayList2 = new ArrayList<>();
        if (!containImage(str)) {
            arrayList2.addAll(getTextContent(context, str, arrayList));
            return arrayList2;
        }
        String[] strArrSplit = str.split("</p>");
        for (int i = 0; i < strArrSplit.length; i++) {
            String strM1170p = AbstractC0622a.m1170p(strArrSplit[i], "</p>", new StringBuilder());
            strArrSplit[i] = strM1170p;
            if (!containImage(strM1170p)) {
                arrayList2.addAll(getTextContent(context, strArrSplit[i], arrayList));
            } else if (strArrSplit[i].contains(MEMO_DRAW)) {
                SpenContentBase drawingContent = getDrawingContent(context, spenSDoc, strArrSplit[i], arrayList, map);
                if (drawingContent != null) {
                    arrayList2.add(drawingContent);
                }
            } else {
                ArrayList<SpenContentBase> imageContent = getImageContent(context, spenSDoc, strArrSplit[i], arrayList, map);
                if (imageContent != null) {
                    arrayList2.addAll(imageContent);
                }
            }
        }
        return arrayList2;
    }

    private static boolean savePNGBitmapToJPEGFile(Bitmap bitmap, String str) throws IOException {
        if (bitmap != null && !bitmap.isRecycled()) {
            File file = new File(str);
            file.createNewFile();
            if (!file.exists()) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                DocumentLogger.m7178d(TAG, "saveBitmapToFileCache, start path: " + SDocUtil.logPath(str));
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.drawColor(-1);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    bitmapCreateBitmap.recycle();
                    DocumentLogger.m7178d(TAG, "saveBitmapToFileCache, done path: " + SDocUtil.logPath(str));
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        DocumentLogger.m7180e(TAG, "saveBitmapToFileCache", th);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable unused3) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        LinkedList<Map.Entry> linkedList = new LinkedList(map.entrySet());
        Collections.sort(linkedList, new Comparator<Map.Entry<Integer, Integer>>() { // from class: com.samsung.android.support.senl.document.memoconverter.core.Converter.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<Integer, Integer> entry, Map.Entry<Integer, Integer> entry2) {
                return entry.getValue().compareTo(entry2.getValue());
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : linkedList) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static void updateSDocDB(Context context, String str, SDocDBData sDocDBData) {
        updateSDocDB(context, str, sDocDBData, null);
    }

    public static void updateSDocDBWithUuid(Context context, String str, SDocDBData sDocDBData, String str2) {
        updateSDocDB(context, str, sDocDBData, str2);
    }

    public static void updateSDocDB(Context context, String str, SDocDBData sDocDBData, String str2) {
        if (str2 == null) {
            str2 = AppDelegator.getInstance().newUUID(context);
        }
        boolean z = !AppDelegator.getInstance().isExistingNote(context, str2);
        String str3 = sDocDBData.category;
        DocumentSaveSDoc.saveSDoc(context, DocumentSaveSDoc.createBuilderInstance().setUuid(str2).setDocFilePath(str).setCategoryUuid((str3 == null || str3.length() <= 0) ? null : sDocDBData.category).setSaveDoc(false).setNew(z));
        if (sDocDBData.favorite != null) {
            AppDelegator.getInstance().setNoteFavorite(context, str2, sDocDBData.favorite.compareTo("1") == 0);
        }
    }
}
