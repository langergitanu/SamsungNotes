package com.samsung.android.livetranslation.task;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Size;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.livetranslation.common.Dump;
import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.text.SceneText;
import com.samsung.android.livetranslation.util.LTTLogger;
import com.samsung.android.livetranslation.util.SceneTextUtil;
import com.samsung.android.livetranslation.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SceneTextFormatter {
    private static int ALIGN_MODE = 0;
    private static final float BASE_RATIO_Y = 0.2f;
    private static final float MARGIN_RATIO_X = 0.02f;
    private static final float MARGIN_RATIO_Y = 0.02f;
    private static final int MIPMAP_NUM = 16;
    private static final boolean SCALE_TEXT_ON = true;
    private static boolean SCALE_X_ON = false;
    static final String TAG = "SceneTextFormatter";
    private static String destinationLangCode;
    private int mMaskHeight;
    private int mMaskWidth;
    private final int[] MIPMAP_SIZE = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};
    private boolean[] mIsTextValid = null;
    private int[] mMarginX = null;
    private int[] mLineWidth = null;
    private int[] mLineWidth_m = null;
    private int[] mLineHeight = null;
    private int[] mLineHeight_m = null;

    private void drawTrsTextMask(Bitmap bitmap, String[] strArr, int i, SceneText sceneText) throws Throwable {
        int i2;
        float f;
        int i4;
        Canvas canvas = new Canvas(bitmap);
        int i5 = 0;
        canvas.drawColor(0);
        Paint textAlignedPaint = SceneTextUtil.getTextAlignedPaint(ALIGN_MODE);
        CopyOnWriteArrayList<SceneText> components = sceneText.getComponents();
        int i6 = 0;
        int i7 = 0;
        while (i6 < i) {
            if (this.mIsTextValid[i6]) {
                String str = strArr[i6];
                int i8 = this.mLineHeight[i6];
                float f4 = 0.5f;
                int i9 = (int) ((i8 * 0.2f) + 0.5f);
                textAlignedPaint.setTextSize(i8);
                float fMax = this.mLineWidth[i6] / Math.max(getTextWidth(str, textAlignedPaint), 1);
                if (!SCALE_X_ON && fMax > 1.0f) {
                    fMax = 1.0f;
                }
                textAlignedPaint.setTextScaleX(fMax);
                while (true) {
                    f = f4;
                    if (SceneTextUtil.getTextHeight(str, textAlignedPaint) <= this.mLineHeight[i6] - i9) {
                        break;
                    }
                    i8--;
                    textAlignedPaint.setTextSize(i8);
                    f4 = f;
                }
                if (SceneTextUtil.getTextWidth(str, textAlignedPaint) != this.mLineWidth[i6]) {
                    int i10 = i5;
                    boolean z = true;
                    while (z) {
                        i10++;
                        Paint paint = new Paint(textAlignedPaint);
                        float fMax2 = (this.mLineWidth[i6] / Math.max(getTextWidth(str, paint), 1)) * fMax;
                        fMax = (SCALE_X_ON || fMax2 <= 1.0f) ? fMax2 : 1.0f;
                        paint.setTextScaleX(fMax);
                        int textWidth = SceneTextUtil.getTextWidth(str, paint);
                        int i11 = this.mLineWidth[i6];
                        if ((textWidth > i11 || (i11 - SceneTextUtil.getTextWidth(str, paint) >= 10 && 10 > i10)) && 100 > i10) {
                            textAlignedPaint = paint;
                        } else {
                            textAlignedPaint = paint;
                            z = false;
                        }
                    }
                }
                int i12 = ALIGN_MODE;
                int i13 = i12 != 0 ? i12 != 1 ? i12 != 2 ? 0 : (this.mLineWidth_m[i6] - 1) - this.mMarginX[i6] : (int) ((this.mLineWidth_m[i6] / 2.0f) + f) : this.mMarginX[i6];
                if (Util.isRTLLanguage(destinationLangCode)) {
                    textAlignedPaint.setTextAlign(Paint.Align.RIGHT);
                    i4 = this.mLineWidth[i6] - i13;
                } else {
                    i4 = 0;
                }
                canvas.drawText(strArr[i6], i4, ((this.mLineHeight[i6] - 1) + i7) - i9, textAlignedPaint);
                Rect rect = new Rect();
                String str2 = strArr[i6];
                i2 = 0;
                textAlignedPaint.getTextBounds(str2, 0, str2.length(), rect);
                setUpdatedPolyforTranslatedLines(components.get(i6), components.get(i6).getPoly(), rect.width());
                i7 += this.mLineHeight_m[i6];
            } else {
                i2 = i5;
            }
            i6++;
            i5 = i2;
        }
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_MASK_DUMP_ENABLE) {
            Dump.dumpBitmap(bitmap.copy(Bitmap.Config.ARGB_8888, true), AbstractC1974b.m1317j(Util.getTimeInMilliSecond(), "mask_java_dump_", ".png"), "Mask");
        }
    }

    private void drawTrsTextOnParagraphMask(Bitmap bitmap, SceneText sceneText) throws Throwable {
        ArrayList<String> arrayList;
        int i;
        boolean z;
        ArrayList<String> splitTRSLines = sceneText.getSplitTRSLines();
        int size = splitTRSLines.size();
        Canvas canvas = new Canvas(bitmap);
        boolean z2 = false;
        canvas.drawColor(0);
        LTTLogger.m5581d(TAG, "drawTrsTextOnParagraphMask: orientation - " + sceneText.getOrient());
        for (Point point : sceneText.getPoly()) {
            LTTLogger.m5581d(TAG, "drawTrsTextOnParagraphMask: Original - " + point.x + " " + point.y);
        }
        Paint textAlignedPaint = SceneTextUtil.getTextAlignedPaint(ALIGN_MODE);
        float fontSize = sceneText.getFontSize();
        String str = TAG;
        LTTLogger.m5581d(str, "Opti size for current para is: " + fontSize);
        textAlignedPaint.setTextSize(fontSize);
        int width = sceneText.getWidth();
        int iMin = Math.min((int) (((double) width) * 0.075d), 15);
        double marginY = sceneText.getMarginY();
        LTTLogger.m5581d(str, "alignPtY : " + marginY);
        if (Util.isRTLLanguage(destinationLangCode)) {
            textAlignedPaint.setTextAlign(Paint.Align.RIGHT);
            iMin = width - iMin;
        }
        int i2 = 0;
        double d = marginY;
        while (i2 < size) {
            String str2 = splitTRSLines.get(i2);
            if (TextUtils.isEmpty(str2) || str2.equals(" ")) {
                arrayList = splitTRSLines;
                i = size;
                z = z2;
                LTTLogger.m5586w(TAG, "No String present in current trans line");
            } else {
                int textHeight = SceneTextUtil.getTextHeight(str2, textAlignedPaint);
                int textWidth = SceneTextUtil.getTextWidth(str2, textAlignedPaint);
                String str3 = TAG;
                arrayList = splitTRSLines;
                i = size;
                LTTLogger.m5581d(str3, "Text width: " + textWidth + " Height: " + textHeight);
                if (textWidth == 0 || textHeight == 0) {
                    z = false;
                    LTTLogger.m5586w(str3, "Can't paint current line: ".concat(str2));
                } else {
                    double d2 = d + ((double) textHeight);
                    canvas.drawText(str2, iMin, ((float) d2) - SceneTextUtil.getTextBottom(str2, textAlignedPaint), textAlignedPaint);
                    LTTLogger.m5581d(str3, "Drawing " + str2 + " at current height of " + d2 + " with width of " + SceneTextUtil.getTextWidth(str2, textAlignedPaint));
                    z = false;
                    textAlignedPaint.getTextBounds(str2, 0, str2.length(), new Rect());
                    d = d2 + marginY;
                }
            }
            i2++;
            z2 = z;
            splitTRSLines = arrayList;
            size = i;
        }
        LTTLogger.m5581d(TAG, "drawTrsTextMask:  maskHeight - " + bitmap.getHeight() + " maskWidth - " + bitmap.getWidth());
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_MASK_DUMP_ENABLE) {
            Dump.dumpBitmap(bitmap.copy(Bitmap.Config.ARGB_8888, true), AbstractC1974b.m1317j(Util.getTimeInMilliSecond(), "mask_java_dump_", ".png"), "Mask");
        }
    }

    private int getTextWidth(String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    private void makeParagraphTrsTextMask(SceneText sceneText, String[] strArr, int i, KeyFrame.TRL_UNIT trl_unit) throws Throwable {
        this.mIsTextValid = new boolean[i];
        this.mMarginX = new int[i];
        this.mLineWidth = new int[i];
        this.mLineWidth_m = new int[i];
        this.mLineHeight = new int[i];
        this.mLineHeight_m = new int[i];
        this.mMaskWidth = 0;
        this.mMaskHeight = 0;
        updateTrsTextMaskPoly(sceneText, strArr, i);
        if (sceneText.isParagraphRendering() || !(this.mMaskWidth == 0 || this.mMaskHeight == 0)) {
            updateTrsTextMask(sceneText, strArr, i, trl_unit);
            return;
        }
        sceneText.setTrsTextMask(null);
        for (int i2 = 0; i2 < i; i2++) {
            sceneText.getComponents().get(i2).setTrsTextMaskPoly(null);
        }
    }

    public static void setTextScaleX(boolean z) {
        if (z) {
            SCALE_X_ON = true;
            ALIGN_MODE = 1;
        } else {
            SCALE_X_ON = false;
            ALIGN_MODE = 0;
        }
    }

    private void setUpdatedPolyforTranslatedLines(SceneText sceneText, Point[] pointArr, int i) {
        Point point = new Point();
        Point point2 = pointArr[0];
        point.x = point2.x;
        point.y = point2.y;
        Point point3 = new Point();
        point3.x = pointArr[0].x + i;
        point3.y = pointArr[1].y;
        Point point4 = new Point();
        point4.x = pointArr[0].x + i;
        point4.y = pointArr[2].y;
        Point point5 = new Point();
        Point point6 = pointArr[3];
        point5.x = point6.x;
        point5.y = point6.y;
        sceneText.setUpdatedTrsPoly(new Point[]{point, point3, point4, point5});
    }

    private void updateTrsTextMask(SceneText sceneText, String[] strArr, int i, KeyFrame.TRL_UNIT trl_unit) throws Throwable {
        int i2;
        int i4;
        if (sceneText.isParagraphRendering()) {
            int width = sceneText.getWidth();
            int height = sceneText.getHeight();
            LTTLogger.m5583i(TAG, "Block W: " + width + " H: " + height);
            int i5 = 0;
            while (true) {
                if (i5 >= 16) {
                    i2 = 0;
                    break;
                }
                i2 = this.MIPMAP_SIZE[i5];
                if (width <= i2) {
                    break;
                } else {
                    i5++;
                }
            }
            for (int i6 = 0; i6 < 16; i6++) {
                i4 = this.MIPMAP_SIZE[i6];
                if (height <= i4) {
                    break;
                }
            }
            i4 = 0;
        } else {
            int i7 = 0;
            while (true) {
                if (i7 >= 16) {
                    i2 = 0;
                    break;
                }
                int i8 = this.mMaskWidth;
                int i9 = this.MIPMAP_SIZE[i7];
                if (i8 <= i9) {
                    i2 = i9;
                    break;
                }
                i7++;
            }
            for (int i10 = 0; i10 < 16; i10++) {
                int i11 = this.mMaskHeight;
                i4 = this.MIPMAP_SIZE[i10];
                if (i11 <= i4) {
                    break;
                }
            }
            i4 = 0;
        }
        LTTLogger.m5583i(TAG, "maskWidth_mipmap : " + i2 + ", maskHeight_mipmap : " + i4);
        if (i2 == 0 || i4 == 0) {
            sceneText.setTrsTextMask(null);
            for (int i12 = 0; i12 < i; i12++) {
                sceneText.getComponents().get(i12).setTrsTextMaskPoly(null);
            }
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i4, Bitmap.Config.ALPHA_8);
        if (!sceneText.isParagraphRendering()) {
            drawTrsTextMask(bitmapCreateBitmap, strArr, i, sceneText);
        } else if (sceneText.getFontSize() != 0.0f) {
            drawTrsTextOnParagraphMask(bitmapCreateBitmap, sceneText);
        }
        sceneText.setTrsTextMask(bitmapCreateBitmap);
    }

    private void updateTrsTextMaskPoly(SceneText sceneText, String[] strArr, int i) {
        int height;
        int width;
        if (sceneText.getDeviceOrientation() != 90) {
        }
        CopyOnWriteArrayList<SceneText> components = sceneText.getComponents();
        this.mMaskWidth = -1;
        this.mMaskHeight = 0;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            components.get(i2).getVerticalType();
            String str = strArr[i2];
            Point[] poly = components.get(i2).getPoly();
            if (poly.length == 4) {
                Size optimalLineMaskSize = SceneTextUtil.getOptimalLineMaskSize(poly, str, 0);
                width = optimalLineMaskSize.getWidth();
                height = optimalLineMaskSize.getHeight();
                if (width == -1 || height == -1) {
                    height = 0;
                    width = 0;
                    z = true;
                }
            } else {
                height = 0;
                width = 0;
                z2 = true;
            }
            this.mIsTextValid[i2] = !TextUtils.isEmpty(str) && width > 0 && height > 0;
            if (this.mIsTextValid[i2]) {
                int i4 = (int) ((width * 0.02f) + 0.5f);
                int i5 = (i4 * 2) + width;
                int i6 = (((int) ((height * 0.02f) + 0.5f)) * 2) + height;
                this.mLineWidth[i2] = width;
                this.mMarginX[i2] = i4;
                this.mLineWidth_m[i2] = i5;
                this.mLineHeight[i2] = height;
                this.mLineHeight_m[i2] = i6;
                Point[] pointArr = new Point[4];
                for (int i7 = 0; i7 < 4; i7++) {
                    pointArr[i7] = new Point();
                }
                Point[] trsTextMaskPoly = SceneTextUtil.getTrsTextMaskPoly(0, this.mMaskHeight, i5, i6);
                sceneText.getComponents().get(i2).setTrsTextMaskPoly(trsTextMaskPoly);
                if (i5 > this.mMaskWidth) {
                    this.mMaskWidth = i5;
                }
                this.mMaskHeight += i6;
                String str2 = TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i2, "Mask ", " => TrsTextMaskPoly: ");
                sbM778t.append(Arrays.toString(trsTextMaskPoly));
                LTTLogger.m5581d(str2, sbM778t.toString());
            } else {
                sceneText.getComponents().get(i2).setTrsTextMaskPoly(null);
            }
        }
        if (z) {
            LTTLogger.m5582e(TAG, "Device orientation is not correct");
        }
        if (z2) {
            LTTLogger.m5582e(TAG, "Size of poly is not four!!");
        }
    }

    public void doSceneTextFormatting(KeyFrame keyFrame) {
        String str = TAG;
        LTTLogger.m5581d(str, "--> doSceneTextFormatting");
        KeyFrame.TRL_UNIT tRLUnit = keyFrame.getTRLUnit();
        int size = keyFrame.getSceneTexts().size();
        destinationLangCode = keyFrame.getTarLang();
        if (size == 0) {
            LTTLogger.m5581d(str, "Number of paragraph is zero");
            return;
        }
        for (int i = 0; i < size; i++) {
            SceneText sceneText = keyFrame.getSceneTexts().get(i);
            int size2 = sceneText.getComponents().size();
            if ((!sceneText.isParagraphRendering() || !sceneText.getSplitTRSLines().isEmpty()) && (sceneText.isParagraphRendering() || size2 != 0)) {
                CopyOnWriteArrayList<SceneText> components = sceneText.getComponents();
                String[] strArr = new String[size2];
                for (int i2 = 0; i2 < size2; i2++) {
                    strArr[i2] = components.get(i2).getTrsValue();
                }
                makeParagraphTrsTextMask(sceneText, strArr, size2, tRLUnit);
                keyFrame.getSceneTexts().set(i, sceneText);
            }
        }
        LTTLogger.m5581d(TAG, "<-- doSceneTextFormatting");
    }
}
