package com.samsung.android.sdk.ocr;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.sdk.ocr.OCRResult;
import com.samsung.android.sdk.pen.ocr.SpenOcrBlockData;
import com.samsung.android.sdk.pen.ocr.SpenOcrCharData;
import com.samsung.android.sdk.pen.ocr.SpenOcrLineData;
import com.samsung.android.sdk.pen.ocr.SpenOcrPageData;
import com.samsung.android.sdk.pen.ocr.SpenOcrWordData;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SOCRConverter {
    private static final String TAG = "SOCRConverter";

    private static void CreateCharDataForLegacyLibrary(SpenOcrWordData spenOcrWordData) {
        if (!isLegacyWordData(spenOcrWordData)) {
            Log.i(TAG, "Word data is not legacy so it doesn't need to generate characters");
            return;
        }
        String legacyText = spenOcrWordData.getLegacyText();
        int length = legacyText.length();
        ArrayList<Point[]> charRects = spenOcrWordData.getCharRects();
        int i = 0;
        if (charRects.size() == length) {
            while (i < length) {
                SpenOcrCharData spenOcrCharData = new SpenOcrCharData();
                int i2 = i + 1;
                spenOcrCharData.setText(legacyText.substring(i, i2));
                spenOcrCharData.setRect(charRects.get(i));
                spenOcrWordData.add(spenOcrCharData);
                i = i2;
            }
            return;
        }
        Point[] rect = spenOcrWordData.getRect();
        Point point = rect[0];
        Point point2 = rect[1];
        Point point3 = rect[2];
        Point point4 = rect[3];
        Log.i(TAG, String.format("Converting a word into %d character list", Integer.valueOf(length)));
        while (i < length) {
            SpenOcrCharData spenOcrCharData2 = new SpenOcrCharData();
            int i4 = i + 1;
            spenOcrCharData2.setText(legacyText.substring(i, i4));
            spenOcrCharData2.setRect(new Point[]{getSplitPoint(point, point2, i, length), getSplitPoint(point, point2, i4, length), getSplitPoint(point4, point3, i4, length), getSplitPoint(point4, point3, i, length)});
            spenOcrWordData.add(spenOcrCharData2);
            i = i4;
        }
    }

    public static OCRResult.BlockData convertBlock(SpenOcrBlockData spenOcrBlockData, OCRResult.BlockData blockData) {
        if (blockData == null) {
            blockData = new OCRResult.BlockData();
        } else {
            blockData.clear();
        }
        Iterator<SpenOcrLineData> it = spenOcrBlockData.getLineDataList().iterator();
        while (it.hasNext()) {
            blockData.add(convertLine(it.next(), (OCRResult.LineData) null));
        }
        blockData.setRect(spenOcrBlockData.getRect());
        return blockData;
    }

    public static OCRResult.CharData convertChar(SpenOcrCharData spenOcrCharData, OCRResult.CharData charData) {
        if (charData == null) {
            charData = new OCRResult.CharData();
        } else {
            charData.clear();
        }
        charData.setText(spenOcrCharData.getText());
        charData.setRect(spenOcrCharData.getRect());
        return charData;
    }

    public static OCRResult.LineData convertLine(SpenOcrLineData spenOcrLineData, OCRResult.LineData lineData) {
        if (lineData == null) {
            lineData = new OCRResult.LineData();
        } else {
            lineData.clear();
        }
        Iterator<SpenOcrWordData> it = spenOcrLineData.getWordDataList().iterator();
        while (it.hasNext()) {
            lineData.add(convertWord(it.next(), (OCRResult.WordData) null));
        }
        lineData.setRect(spenOcrLineData.getRect());
        lineData.setAngle(spenOcrLineData.getAngle());
        return lineData;
    }

    public static OCRResult convertPage(SpenOcrPageData spenOcrPageData, OCRResult oCRResult) {
        if (oCRResult == null) {
            oCRResult = new OCRResult();
        } else {
            oCRResult.clearResult();
        }
        Iterator<SpenOcrBlockData> it = spenOcrPageData.getTextBlockList().iterator();
        while (it.hasNext()) {
            oCRResult.add(convertBlock(it.next(), null));
        }
        oCRResult.logInfo();
        return oCRResult;
    }

    public static OCRResult.WordData convertWord(SpenOcrWordData spenOcrWordData, OCRResult.WordData wordData) {
        if (wordData == null) {
            wordData = new OCRResult.WordData();
        } else {
            wordData.clear();
        }
        CreateCharDataForLegacyLibrary(spenOcrWordData);
        Iterator<SpenOcrCharData> it = spenOcrWordData.getCharDataList().iterator();
        while (it.hasNext()) {
            wordData.add(convertChar(it.next(), (OCRResult.CharData) null));
        }
        wordData.setRect(spenOcrWordData.getRect());
        wordData.setPoly(spenOcrWordData.getPoly());
        return wordData;
    }

    private static Point getSplitPoint(Point point, Point point2, int i, int i2) {
        int i4 = i2 - i;
        float f = i2;
        return new Point((int) (((point2.x * i) + (point.x * i4)) / f), (int) (((point2.y * i) + (point.y * i4)) / f));
    }

    private static boolean isLegacyWordData(SpenOcrWordData spenOcrWordData) {
        if (TextUtils.isEmpty(spenOcrWordData.getLegacyText())) {
            Log.i(TAG, "No legacy conversion: legacy word text has not been assigned");
            return false;
        }
        ArrayList<SpenOcrCharData> charDataList = spenOcrWordData.getCharDataList();
        if (charDataList != null && charDataList.size() > 0) {
            Log.i(TAG, "No legacy conversion: charDataList is not empty");
            return false;
        }
        Point[] rect = spenOcrWordData.getRect();
        if (rect != null && rect.length == 4) {
            return true;
        }
        Log.i(TAG, "No legacy conversion: word Rect is not defined");
        return false;
    }

    public static SpenOcrCharData convertChar(OCRResult.CharData charData, SpenOcrCharData spenOcrCharData) {
        if (spenOcrCharData == null) {
            spenOcrCharData = new SpenOcrCharData();
        } else {
            spenOcrCharData.clear();
        }
        spenOcrCharData.setText(charData.getText());
        spenOcrCharData.setRect(charData.getRect());
        return spenOcrCharData;
    }

    public static SpenOcrLineData convertLine(OCRResult.LineData lineData, SpenOcrLineData spenOcrLineData) {
        if (spenOcrLineData == null) {
            spenOcrLineData = new SpenOcrLineData();
        } else {
            spenOcrLineData.clear();
        }
        Iterator<OCRResult.WordData> it = lineData.getWordDataList().iterator();
        while (it.hasNext()) {
            spenOcrLineData.add(convertWord(it.next(), (SpenOcrWordData) null));
        }
        spenOcrLineData.setRect(lineData.getRect());
        spenOcrLineData.setAngle(lineData.getAngle());
        return spenOcrLineData;
    }

    public static SpenOcrWordData convertWord(OCRResult.WordData wordData, SpenOcrWordData spenOcrWordData) {
        if (spenOcrWordData == null) {
            spenOcrWordData = new SpenOcrWordData();
        } else {
            spenOcrWordData.clear();
        }
        Iterator<OCRResult.CharData> it = wordData.getCharDataList().iterator();
        while (it.hasNext()) {
            spenOcrWordData.add(convertChar(it.next(), (SpenOcrCharData) null));
        }
        spenOcrWordData.setText(wordData.getText());
        spenOcrWordData.setRect(wordData.getRect());
        return spenOcrWordData;
    }
}
