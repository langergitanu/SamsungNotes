package com.samsung.android.imagetranslation.task;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Size;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.imagetranslation.common.Dump;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttEngineException;
import com.samsung.android.imagetranslation.jni.KeyFrameParam;
import com.samsung.android.imagetranslation.jni.SceneText;
import com.samsung.android.imagetranslation.util.SceneTextUtil;
import com.samsung.android.imagetranslation.util.TextAlignment;
import com.samsung.android.imagetranslation.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ProcessTRL {
    private static int ALIGN_MODE = 0;
    private static final float BASE_RATIO_Y = 0.2f;
    private static final int FONT_SIZE = 35;
    private static final float MARGIN_RATIO_X = 0.02f;
    private static final float MARGIN_RATIO_Y = 0.02f;
    private static double MAX_EXTENSION_RATIO = 0.2d;
    private static final int MAX_LINE_HEIGHT = 65536;
    private static final int MAX_MASK_SIZE = 16384;
    private static final int MIN_FONT_THRESHOLD = 3;
    private static final int MIPMAP_NUM = 16;
    private static final boolean SCALE_TEXT_ON = false;
    private static boolean SCALE_X_ON = false;
    private static final String TAG = "ProcessTRL";
    private static String destinationLangCode;
    private KeyFrameParam keyFrameParam;
    private int mMaskHeight;
    private int mMaskWidth;
    private final int[] MIPMAP_SIZE = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};
    private boolean[] mIsTextValid = null;
    private int[] mMarginX = null;
    private int[] mLineWidth = null;
    private int[] mLineWidth_m = null;
    private int[] mLineHeight = null;
    private int[] mLineHeight_m = null;
    private int mMinLineHeight = 65536;
    private long totalTimeTakenForUniformFont = 0;

    public ProcessTRL(KeyFrameParam keyFrameParam) {
        this.keyFrameParam = keyFrameParam;
    }

    private void decideFontSizeAndWidthForLine(String[] strArr, int i, SceneText sceneText, int i2, CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        SceneText sceneText2;
        boolean z;
        boolean z2;
        CopyOnWriteArrayList<SceneText> copyOnWriteArrayList2;
        double dMin;
        boolean z3 = true;
        int i4 = 0;
        if (sceneText.getComponents().isEmpty() || !Util.isRTLLanguage(sceneText.getComponents().get(0).getPoly())) {
            sceneText2 = sceneText;
            z = false;
        } else {
            sceneText2 = sceneText;
            sceneText2.setTextAlignment(2);
            z = true;
        }
        int textAlignment = sceneText2.getComponents().size() == 1 ? 1 : sceneText2.getTextAlignment();
        int orientation = Util.getOrientation(sceneText2.getPoly());
        CopyOnWriteArrayList<SceneText> components = sceneText2.getComponents();
        int i5 = 0;
        while (i5 < i) {
            Paint paint = new Paint();
            if (this.mIsTextValid[i5]) {
                String str = strArr[i5];
                Rect rect = new Rect();
                int i6 = this.mLineHeight[i5];
                String str2 = TAG;
                LTTLogger.m5458d(str2, "originalFontSize : " + i6 + " Text : " + str);
                float f = (float) i6;
                paint.setTextSize(f);
                components.get(i5).setFontSize(f);
                components.get(i5).setPaddedBoxPoly(components.get(i5).getPoly());
                paint.getTextBounds(str, i4, str.length(), rect);
                int iWidth = rect.width();
                LTTLogger.m5458d(str2, "mLineWidth[l] : " + this.mLineWidth[i5] + " requiredWidth : " + iWidth);
                if (iWidth > this.mLineWidth[i5]) {
                    double maxExtendedWidth = getMaxExtendedWidth(sceneText2, components.get(i5), copyOnWriteArrayList, 0, iWidth - this.mLineWidth[i5], textAlignment, orientation, z);
                    double dCeil = ((double) ((int) Math.ceil(maxExtendedWidth / ((double) this.mLineWidth[i5])))) * 0.5d;
                    MAX_EXTENSION_RATIO = dCeil;
                    z2 = true;
                    if (textAlignment == 1) {
                        copyOnWriteArrayList2 = components;
                        dMin = Math.min(maxExtendedWidth, dCeil * 2.0d * ((double) this.mLineWidth[i5]));
                    } else {
                        copyOnWriteArrayList2 = components;
                        dMin = Math.min(maxExtendedWidth, dCeil * ((double) this.mLineWidth[i5]));
                    }
                    int i7 = (int) dMin;
                    StringBuilder sb = new StringBuilder("Text : ");
                    sb.append(strArr[i5]);
                    sb.append(" Extension Ratio : ");
                    sb.append(MAX_EXTENSION_RATIO);
                    sb.append(" ExtendedLength : ");
                    sb.append(i7);
                    AbstractC0622a.m1180z(sb, textAlignment, orientation, " alignment : ", " orientation : ");
                    sb.append(" isRTLLanguage : ");
                    sb.append(z);
                    LTTLogger.m5458d(str2, sb.toString());
                    Point[] extendedPolyValues = Util.getExtendedPolyValues(copyOnWriteArrayList2.get(i5).getPoly(), i7, textAlignment, orientation, z);
                    int i8 = this.mLineWidth[i5] + i7;
                    copyOnWriteArrayList2.get(i5).setPaddedBoxPoly(extendedPolyValues);
                    this.mLineWidth[i5] = i8;
                } else {
                    copyOnWriteArrayList2 = components;
                    z2 = true;
                }
            } else {
                z2 = z3;
                copyOnWriteArrayList2 = components;
            }
            i5++;
            sceneText2 = sceneText;
            z3 = z2;
            components = copyOnWriteArrayList2;
            i4 = 0;
        }
    }

    private Bitmap drawTrsTextMask(String[] strArr, int i, SceneText sceneText) {
        float f;
        float f4;
        float f5;
        int i2;
        ProcessTRL processTRL = this;
        int i4 = i;
        Paint textAlignedPaint = SceneTextUtil.getTextAlignedPaint(ALIGN_MODE);
        int[] iArr = new int[i4];
        float[] fArr = new float[i4];
        int[] iArr2 = new int[i4];
        float[] fArr2 = new float[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = processTRL.mMinLineHeight;
            if (i6 < 35) {
                fArr2[i5] = (35.0f / i6) * processTRL.mLineHeight[i5];
            } else {
                fArr2[i5] = processTRL.mLineHeight[i5];
            }
        }
        int iMin = 1024;
        float f6 = 1.0f;
        int i7 = 1024;
        float f7 = 1.0f;
        int i8 = 0;
        int i9 = 0;
        int i10 = 3;
        while (true) {
            f = 0.5f;
            f4 = 2.0f;
            int i11 = 1;
            if (i8 != 0) {
                break;
            }
            int i12 = 0;
            int iMax = 0;
            int i13 = 0;
            while (i12 < i4) {
                if (processTRL.mIsTextValid[i12]) {
                    textAlignedPaint.setTextScaleX(f6);
                    int i14 = ALIGN_MODE;
                    if (i14 == 0) {
                        i9 = processTRL.mMarginX[i12];
                    } else if (i14 == i11) {
                        i9 = (int) ((processTRL.mLineWidth_m[i12] / 2.0f) + 0.5f);
                    } else if (i14 == 2) {
                        i9 = (processTRL.mLineWidth_m[i12] - i11) - processTRL.mMarginX[i12];
                    }
                    textAlignedPaint.setTextSize(Math.max((int) (fArr2[i12] * f7), 3));
                    if (((int) (fArr2[i12] * f7)) <= 3) {
                        i8 = i11;
                    }
                    int iMax2 = Math.max(2, i9);
                    int iMax3 = Math.max(SceneTextUtil.getTextWidth(strArr[i12], textAlignedPaint), (int) textAlignedPaint.measureText(strArr[i12]));
                    iArr2[i12] = iMax3;
                    int iMax4 = Math.max(i13, iMax3);
                    int textHeight = SceneTextUtil.getTextHeight(strArr[i12], textAlignedPaint);
                    iArr[i12] = textHeight;
                    processTRL.mMaskHeight += textHeight;
                    fArr[i12] = textAlignedPaint.getTextSize();
                    int iMax5 = Math.max(3, SceneTextUtil.getTextHeight(strArr[i12], textAlignedPaint) / 15);
                    i10 = iMax5;
                    iMax = ((Math.max(5, (int) sceneText.getMarginY()) + iMax5) * 2) + iArr[i12] + iMax;
                    i2 = iMax4;
                    i9 = iMax2;
                } else {
                    i2 = i13;
                }
                i12++;
                i13 = i2;
                i11 = 1;
                f6 = 1.0f;
            }
            int iMax6 = ((Math.max(5, (int) sceneText.getMarginY()) + i10) * 2) + iMax;
            int[] iArr3 = iArr;
            float[] fArr3 = fArr;
            int iPow = (int) Math.pow(2.0d, Math.ceil(Math.log((i9 * 2) + i13) / Math.log(2.0d)));
            int iPow2 = (int) Math.pow(2.0d, Math.ceil(Math.log(iMax6) / Math.log(2.0d)));
            if (i8 != 0) {
                iMin = Math.min(iPow, 16384);
                iPow2 = Math.min(iPow2, 16384);
            } else {
                iMin = iPow;
            }
            i7 = iPow2;
            if (iMin > 16384 || i7 > 16384) {
                f7 *= 0.9f;
                iArr = iArr3;
                fArr = fArr3;
                f6 = 1.0f;
            } else {
                iArr = iArr3;
                fArr = fArr3;
                f6 = 1.0f;
                i8 = 1;
            }
        }
        int[] iArr4 = iArr;
        float[] fArr4 = fArr;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, i7, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        int i15 = i9;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i4) {
            if (processTRL.mIsTextValid[i16]) {
                Rect rect = new Rect();
                textAlignedPaint.setTextSize(fArr4[i16]);
                int iMax7 = Math.max(3, SceneTextUtil.getTextHeight(strArr[i16], textAlignedPaint) / 15);
                int iMax8 = ((int) Math.max(5.0d, sceneText.getMarginY())) + iMax7;
                if (Util.isRTLLanguage(destinationLangCode)) {
                    textAlignedPaint.setTextAlign(Paint.Align.RIGHT);
                    i15 = i9 + iArr2[i16];
                }
                String str = strArr[i16];
                textAlignedPaint.getTextBounds(str, 0, str.length(), rect);
                if (iMax7 > 0) {
                    textAlignedPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                    f5 = f;
                    textAlignedPaint.setColor(Color.argb(f5, 0.0f, 0.0f, 0.0f));
                    textAlignedPaint.setStrokeWidth(iMax7);
                    textAlignedPaint.setStrokeMiter(f4);
                    textAlignedPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
                    float f8 = i15;
                    int i18 = i17 + iMax8;
                    canvas.drawText(strArr[i16], f8, i18 - rect.top, textAlignedPaint);
                    textAlignedPaint.setStyle(Paint.Style.FILL);
                    textAlignedPaint.setColor(Color.argb(1.0f, 0.0f, 0.0f, 0.0f));
                    textAlignedPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                    canvas.drawText(strArr[i16], f8, i18 - rect.top, textAlignedPaint);
                } else {
                    f5 = f;
                    textAlignedPaint.setStyle(Paint.Style.FILL);
                    textAlignedPaint.setColor(Color.argb(1.0f, 0.0f, 0.0f, 0.0f));
                    canvas.drawText(strArr[i16], i15, (i17 + iMax8) - rect.top, textAlignedPaint);
                }
                int i19 = iMax8 * 2;
                sceneText.getComponents().get(i16).setTrsTextMaskPoly(SceneTextUtil.getTrsTextMaskPoly(0, i17, (i9 * 2) + iArr2[i16], iArr4[i16] + i19));
                i17 = iArr4[i16] + i19 + i17;
            } else {
                f5 = f;
            }
            i16++;
            processTRL = this;
            i4 = i;
            f = f5;
            f4 = 2.0f;
        }
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_MASK_DUMP_ENABLE) {
            Dump.dumpBitmap(bitmapCreateBitmap.copy(Bitmap.Config.ARGB_8888, true), AbstractC1974b.m1317j(System.currentTimeMillis(), "mask_java_dump_", ".png"), "Mask");
        }
        return bitmapCreateBitmap;
    }

    private Bitmap drawTrsTextOnParagraphMask(SceneText sceneText) {
        String str;
        int[] iArr;
        float f;
        int i;
        String str2;
        int i2;
        float f4;
        ArrayList<String> splitTRSLines = sceneText.getSplitTRSLines();
        int size = splitTRSLines.size();
        LTTLogger.m5458d(TAG, "drawTrsTextOnParagraphMask: orientation - " + sceneText.getOrient());
        Point[] poly = sceneText.getPoly();
        int length = poly.length;
        int i4 = 0;
        while (true) {
            str = " ";
            if (i4 >= length) {
                break;
            }
            Point point = poly[i4];
            LTTLogger.m5458d(TAG, "drawTrsTextOnParagraphMask: Original - " + point.x + " " + point.y);
            i4++;
        }
        Paint textAlignedPaint = SceneTextUtil.getTextAlignedPaint(ALIGN_MODE);
        float fontSize = sceneText.getFontSize();
        String str3 = TAG;
        LTTLogger.m5458d(str3, "Optimal size for current para is: " + fontSize);
        textAlignedPaint.setTextSize(fontSize);
        int iMin = Math.min((int) (((double) sceneText.getWidth()) * 0.075d), 15);
        float fMax = (float) Math.max(5.0d, sceneText.getMarginY());
        LTTLogger.m5458d(str3, "alignPtY : " + fMax);
        int[] iArr2 = new int[size];
        float[] fArr = new float[size];
        int iMax = Math.max((int) fontSize, 35);
        float f5 = iMax;
        textAlignedPaint.setTextSize(f5);
        int longestLine = SceneTextUtil.getLongestLine(splitTRSLines, textAlignedPaint);
        if (longestLine < splitTRSLines.size()) {
            int textWidth = SceneTextUtil.getTextWidth(splitTRSLines.get(longestLine), textAlignedPaint) + iMin;
            iArr = iArr2;
            double d = ((double) fMax) * 1.01d;
            double textHeight = ((double) SceneTextUtil.getTextHeight(splitTRSLines.get(longestLine), textAlignedPaint)) + d;
            double d2 = size;
            float f6 = 16384.0f / (textWidth / f5);
            f = fMax;
            int iMin2 = Math.min(iMax, (int) Math.min(Math.ceil(f6), Math.ceil(16384.0f / (((int) ((textHeight * d2) + d)) / f5))));
            textAlignedPaint.setTextSize(iMin2);
            if (iMin2 < iMax) {
                iMax = iMin2;
                while (true) {
                    if (SceneTextUtil.getTextWidth(splitTRSLines.get(longestLine), textAlignedPaint) + iMin <= 16384 && ((int) (((((double) SceneTextUtil.getTextHeight(splitTRSLines.get(longestLine), textAlignedPaint)) + d) * d2) + d)) <= 16384) {
                        break;
                    }
                    iMax--;
                    textAlignedPaint.setTextSize(iMax);
                }
            } else {
                iMax = iMin2;
            }
        } else {
            iArr = iArr2;
            f = fMax;
        }
        textAlignedPaint.setTextSize(Math.max(iMax, 3));
        float fMin = f;
        int i5 = 0;
        float f7 = 0.0f;
        int i6 = 0;
        while (i5 < size) {
            String str4 = splitTRSLines.get(i5);
            if (TextUtils.isEmpty(str4) || str4.equals(str)) {
                i = i5;
                str2 = str;
                i2 = iMin;
                f4 = f7;
                LTTLogger.m5464w(TAG, "No String present in current trans line");
            } else {
                int textHeight2 = SceneTextUtil.getTextHeight(str4, textAlignedPaint);
                i = i5;
                int textWidth2 = SceneTextUtil.getTextWidth(str4, textAlignedPaint);
                str2 = str;
                String str5 = TAG;
                i2 = iMin;
                f4 = f7;
                LTTLogger.m5458d(str5, "Text width: " + textWidth2 + " Height: " + textHeight2);
                if (textWidth2 == 0 || textHeight2 == 0) {
                    LTTLogger.m5464w(str5, "Can't paint current line: ".concat(str4));
                } else {
                    int iMax2 = Math.max(i6, SceneTextUtil.getTextWidth(str4, textAlignedPaint) + i2);
                    if (textAlignedPaint.getTextSize() < f5) {
                        fMin = Math.min((fMin * f5) / textAlignedPaint.getTextSize(), 15.0f);
                        textAlignedPaint.setTextSize(f5);
                        iMax2 = Math.max(iMax2, SceneTextUtil.getTextWidth(str4, textAlignedPaint) + i2);
                    }
                    int textHeight3 = SceneTextUtil.getTextHeight(str4, textAlignedPaint);
                    iArr[i] = textHeight3;
                    f7 = f4 + textHeight3;
                    this.mMaskHeight += textHeight3;
                    fArr[i] = textAlignedPaint.getTextSize();
                    LTTLogger.m5458d(str5, "Drawing " + str4 + " at current height of " + f7 + " with width of " + SceneTextUtil.getTextWidth(str4, textAlignedPaint));
                    i6 = iMax2;
                    i5 = i + 1;
                    str = str2;
                    iMin = i2;
                }
            }
            f7 = f4;
            i5 = i + 1;
            str = str2;
            iMin = i2;
        }
        int i7 = iMin;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) Math.min(16384.0d, Math.pow(2.0d, Math.ceil(Math.log(i6) / Math.log(2.0d)))), (int) Math.min(16384.0d, Math.pow(2.0d, Math.ceil(Math.log(((size + 1) * fMin) + f7) / Math.log(2.0d)))), Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        int textAlignment = sceneText.getTextAlignment();
        int iMax3 = Math.max(3, SceneTextUtil.getTextHeight(splitTRSLines.get(longestLine), textAlignedPaint) / 15);
        float f8 = fMin;
        int i8 = 0;
        int iMax4 = 0;
        while (i8 < size) {
            String str6 = splitTRSLines.get(i8);
            textAlignedPaint.setTextSize(fArr[i8]);
            Rect rect = new Rect();
            ArrayList<String> arrayList = splitTRSLines;
            float f9 = f8 + iArr[i8];
            int textWidth3 = textAlignment == 1 ? (i6 - SceneTextUtil.getTextWidth(str6, textAlignedPaint)) / 2 : textAlignment == 2 ? (i6 - SceneTextUtil.getTextWidth(str6, textAlignedPaint)) - i7 : i7;
            if (Util.isRTLLanguage(destinationLangCode)) {
                textAlignedPaint.setTextAlign(Paint.Align.RIGHT);
                textWidth3 = SceneTextUtil.getTextWidth(str6, textAlignedPaint) + textWidth3;
            }
            int i9 = size;
            int i10 = textAlignment;
            textAlignedPaint.getTextBounds(str6, 0, str6.length(), rect);
            if (iMax3 > 0) {
                textAlignedPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                textAlignedPaint.setColor(Color.argb(0.5f, 0.0f, 0.0f, 0.0f));
                textAlignedPaint.setStrokeWidth(iMax3);
                textAlignedPaint.setStrokeMiter(2.0f);
                textAlignedPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
                float f10 = textWidth3;
                canvas.drawText(str6, f10, f9 - rect.bottom, textAlignedPaint);
                textAlignedPaint.setStyle(Paint.Style.FILL);
                textAlignedPaint.setColor(Color.argb(1.0f, 0.0f, 0.0f, 0.0f));
                textAlignedPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                canvas.drawText(str6, f10, f9 - rect.bottom, textAlignedPaint);
            } else {
                textAlignedPaint.setStyle(Paint.Style.FILL);
                textAlignedPaint.setColor(Color.argb(1.0f, 0.0f, 0.0f, 0.0f));
                canvas.drawText(str6, textWidth3, f9 - rect.bottom, textAlignedPaint);
            }
            iMax4 = Math.max(iMax4, SceneTextUtil.getTextWidth(str6, textAlignedPaint));
            f8 = f9 + fMin;
            i8++;
            splitTRSLines = arrayList;
            size = i9;
            textAlignment = i10;
        }
        sceneText.setTrsTextHeight((int) f8);
        sceneText.setTrsTextwidth((i7 * 2) + iMax4);
        LTTLogger.m5458d(TAG, "drawTrsTextMask:  maskHeight - " + bitmapCreateBitmap.getHeight() + " maskWidth - " + bitmapCreateBitmap.getWidth());
        if (Dump.IS_MASK_DUMP_ENABLE) {
            Dump.dumpBitmap(bitmapCreateBitmap.copy(Bitmap.Config.ARGB_8888, true), AbstractC1974b.m1317j(System.currentTimeMillis(), "mask_java_dump_", ".png"), "Mask");
        }
        return bitmapCreateBitmap;
    }

    private int getMaxExtendedWidth(SceneText sceneText, SceneText sceneText2, CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, int i, int i2, int i4, int i5, boolean z) {
        int i6 = i2;
        int i7 = 0;
        int i8 = i;
        while (i8 <= i6) {
            int iM7d = AbstractC0000a.m7d(i6, i8, 2, i8);
            if (isPossibleToExtend(sceneText, sceneText2, copyOnWriteArrayList, iM7d, i4, i5, z)) {
                i8 = iM7d + 1;
                i7 = iM7d;
            } else {
                i6 = iM7d - 1;
            }
        }
        return i7;
    }

    private int getTextWidth(String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    private boolean isPossibleToExtend(SceneText sceneText, SceneText sceneText2, CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, int i, int i2, int i4, boolean z) {
        int inputImageWidth = this.keyFrameParam.getInputImageWidth();
        int inputImageHeight = this.keyFrameParam.getInputImageHeight();
        Point[] poly = sceneText2.getPoly();
        Point[] extendedPolyValues = Util.getExtendedPolyValues(poly, i, i2, i4, z);
        if (Util.isPolyOutOfImageBound(poly, extendedPolyValues, inputImageWidth, inputImageHeight, 10)) {
            return false;
        }
        for (SceneText sceneText3 : copyOnWriteArrayList) {
            if (!sceneText3.isParagraphRendering() || sceneText3.getValue().equals(sceneText.getValue())) {
                for (SceneText sceneText4 : sceneText3.getComponents()) {
                    if (!sceneText4.getValue().equals(sceneText2.getValue())) {
                        boolean zIsLineOnTopOrBottom = Util.isLineOnTopOrBottom(sceneText2.getPoly(), sceneText4.getPoly(), sceneText.getPaddedBoxPoly(), sceneText3.getPaddedBoxPoly());
                        boolean zIsPolyValueIntersecting = Util.isPolyValueIntersecting(extendedPolyValues, sceneText4.getPaddedBoxPoly() == null ? sceneText4.getPoly() : sceneText4.getPaddedBoxPoly());
                        if (!zIsLineOnTopOrBottom && zIsPolyValueIntersecting) {
                            return false;
                        }
                    }
                }
            } else if (Util.isPolyValueIntersecting(extendedPolyValues, sceneText3.getPaddedBoxPoly())) {
                return false;
            }
        }
        return true;
    }

    private void makeParagraphTrsTextMask(SceneText sceneText, String[] strArr, int i) {
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
            updateTrsTextMask(sceneText, strArr, i);
            return;
        }
        sceneText.setTrsTextMask(null);
        for (int i2 = 0; i2 < i; i2++) {
            sceneText.getComponents().get(i2).setTrsTextMaskPoly(null);
        }
    }

    private static void setDestinationLanguage(KeyFrameParam keyFrameParam) {
        destinationLangCode = keyFrameParam.getDestLanguage();
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

    private void updateTrsTextMask(SceneText sceneText, String[] strArr, int i) {
        int i2;
        int i4;
        SceneText sceneText2;
        String[] strArr2;
        int i5;
        Bitmap bitmapDrawTrsTextMask;
        if (sceneText.isParagraphRendering()) {
            int width = sceneText.getWidth();
            int height = sceneText.getHeight();
            LTTLogger.m5461i(TAG, "Block W: " + width + " H: " + height);
            int i6 = 0;
            while (true) {
                if (i6 >= 16) {
                    i2 = 0;
                    break;
                }
                i2 = this.MIPMAP_SIZE[i6];
                if (width <= i2) {
                    break;
                } else {
                    i6++;
                }
            }
            for (int i7 = 0; i7 < 16; i7++) {
                i4 = this.MIPMAP_SIZE[i7];
                if (height <= i4) {
                    break;
                }
            }
            i4 = 0;
        } else {
            int i8 = 0;
            while (true) {
                if (i8 >= 16) {
                    i2 = 0;
                    break;
                }
                int i9 = this.mMaskWidth;
                int i10 = this.MIPMAP_SIZE[i8];
                if (i9 <= i10) {
                    i2 = i10;
                    break;
                }
                i8++;
            }
            for (int i11 = 0; i11 < 16; i11++) {
                int i12 = this.mMaskHeight;
                i4 = this.MIPMAP_SIZE[i11];
                if (i12 <= i4) {
                    break;
                }
            }
            i4 = 0;
        }
        int i13 = i2;
        LTTLogger.m5461i(TAG, "maskWidth_mipmap : " + i13 + ", maskHeight_mipmap : " + i4);
        if (i13 == 0 || i4 == 0) {
            sceneText.setTrsTextMask(null);
            for (int i14 = 0; i14 < i; i14++) {
                sceneText.getComponents().get(i14).setTrsTextMaskPoly(null);
            }
            return;
        }
        sceneText.setTextAlignment(TextAlignment.getAlignmentOfBlock(sceneText));
        if (sceneText.isParagraphRendering()) {
            bitmapDrawTrsTextMask = sceneText.getFontSize() != 0.0f ? drawTrsTextOnParagraphMask(sceneText) : null;
            sceneText2 = sceneText;
        } else {
            if (Dump.IS_UNIFORM_FONT_ENABLED) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                sceneText2 = sceneText;
                strArr2 = strArr;
                i5 = i;
                decideFontSizeAndWidthForLine(strArr2, i5, sceneText2, i13, this.keyFrameParam.getSceneTexts());
                this.totalTimeTakenForUniformFont = (System.currentTimeMillis() - jCurrentTimeMillis) + this.totalTimeTakenForUniformFont;
            } else {
                sceneText2 = sceneText;
                strArr2 = strArr;
                i5 = i;
            }
            bitmapDrawTrsTextMask = drawTrsTextMask(strArr2, i5, sceneText2);
        }
        sceneText2.setTrsTextMask(bitmapDrawTrsTextMask);
    }

    private void updateTrsTextMaskPoly(SceneText sceneText, String[] strArr, int i) {
        int height;
        int width;
        if (sceneText.getDeviceOrientation() != 90) {
        }
        CopyOnWriteArrayList<SceneText> components = sceneText.getComponents();
        this.mMaskWidth = -1;
        this.mMaskHeight = 0;
        this.mMinLineHeight = 65536;
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
                this.mMinLineHeight = Math.min(this.mMinLineHeight, height);
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
                LTTLogger.m5458d(str2, sbM778t.toString());
            } else {
                sceneText.getComponents().get(i2).setTrsTextMaskPoly(null);
            }
        }
        if (z) {
            LTTLogger.m5459e(TAG, "Device orientation is not correct");
        }
        if (z2) {
            LTTLogger.m5459e(TAG, "Size of poly is not four!!");
        }
    }

    public void detectAndClearSameTranslatedResult() {
        for (SceneText sceneText : this.keyFrameParam.getSceneTexts()) {
            String str = TAG;
            LTTLogger.m5458d(str, "Paragraph type =" + sceneText.getTrlUnit());
            if (!sceneText.isParagraphRendering()) {
                for (SceneText sceneText2 : sceneText.getComponents()) {
                    String str2 = TAG;
                    LTTLogger.m5458d(str2, "Line Original =" + sceneText2.getValue());
                    LTTLogger.m5458d(str2, "Line Translated =" + sceneText2.getTrsValue());
                    if (!sceneText2.hasOnlyNumber()) {
                        String trsValue = sceneText2.getTrsValue();
                        int length = trsValue.length();
                        int iCharCount = 0;
                        while (true) {
                            if (iCharCount >= length) {
                                LTTLogger.m5458d(TAG, "Empty mask rendering");
                                sceneText2.setTrsValue(" ");
                                break;
                            }
                            int iCodePointAt = trsValue.codePointAt(iCharCount);
                            if (Character.isWhitespace(iCodePointAt)) {
                                iCharCount += Character.charCount(iCodePointAt);
                            } else if (Util.removeMoreThanOneSpaceBetweenWords(sceneText2.getValue()).trim().equalsIgnoreCase(Util.removeMoreThanOneSpaceBetweenWords(sceneText2.getTrsValue()).trim())) {
                                LTTLogger.m5458d(TAG, "Rendering skipped");
                                sceneText2.setTrsValue("");
                            }
                        }
                    } else {
                        LTTLogger.m5458d(str2, "Rendering skipped");
                        sceneText2.setTrsValue("");
                    }
                }
            } else {
                LTTLogger.m5458d(str, "Para Original =" + sceneText.getValue());
                LTTLogger.m5458d(str, "Para Translated =" + sceneText.getTrsValue());
                LTTLogger.m5458d(str, "Para Distributed =" + sceneText.getSplitTRSLines());
                if (Util.removeMoreThanOneSpaceBetweenWords(sceneText.getValue()).trim().equalsIgnoreCase(Util.removeMoreThanOneSpaceBetweenWords(sceneText.getTrsValue()).trim())) {
                    sceneText.getSplitTRSLines().clear();
                }
            }
        }
    }

    public void generateTranslationMask() throws LttEngineException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = TAG;
        LTTLogger.m5458d(str, "--> doSceneTextFormatting");
        int size = this.keyFrameParam.getSceneTexts().size();
        setDestinationLanguage(this.keyFrameParam);
        if (size == 0) {
            LTTLogger.m5458d(str, "Number of paragraph is zero");
            throw new LttEngineException(-16, "Number of paragraph is zero");
        }
        for (int i = 0; i < size; i++) {
            SceneText sceneText = this.keyFrameParam.getSceneTexts().get(i);
            int size2 = sceneText.getComponents().size();
            if ((!sceneText.isParagraphRendering() || !sceneText.getSplitTRSLines().isEmpty()) && (sceneText.isParagraphRendering() || size2 != 0)) {
                CopyOnWriteArrayList<SceneText> components = sceneText.getComponents();
                String[] strArr = new String[size2];
                for (int i2 = 0; i2 < size2; i2++) {
                    strArr[i2] = components.get(i2).getTrsValue();
                }
                makeParagraphTrsTextMask(sceneText, strArr, size2);
                String str2 = TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "Block : ", " Alignment : ");
                sbM778t.append(sceneText.getTextAlignment());
                LTTLogger.m5458d(str2, sbM778t.toString());
                this.keyFrameParam.getSceneTexts().set(i, sceneText);
            }
        }
        String str3 = TAG;
        LTTLogger.m5462p(str3, "Uniform Font : " + this.totalTimeTakenForUniformFont + " ms");
        LTTLogger.m5462p(str3, "generateTranslationMask: Total time taken : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        LTTLogger.m5458d(str3, "<-- doSceneTextFormatting");
    }

    public void getLinesToRestore(List<Path> list) {
        int i = 0;
        for (SceneText sceneText : this.keyFrameParam.getSceneTexts()) {
            String str = TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "getLinesToRestore: Distribution --> Block - ", " type =");
            sbM778t.append(sceneText.getTrlUnit());
            LTTLogger.m5458d(str, sbM778t.toString());
            if (sceneText.isParagraphRendering()) {
                LTTLogger.m5458d(str, "getLinesToRestore: Para Original - " + sceneText.getValue());
                LTTLogger.m5458d(str, "getLinesToRestore: Para Translated - " + sceneText.getTrsValue());
                LTTLogger.m5458d(str, "getLinesToRestore: Para Distributed - " + sceneText.getSplitTRSLines());
                if (Util.removeMoreThanOneSpaceBetweenWords(sceneText.getValue()).trim().equalsIgnoreCase(Util.removeMoreThanOneSpaceBetweenWords(sceneText.getTrsValue()).trim())) {
                    LTTLogger.m5458d(str, "getLinesToRestore: Para Restored");
                    list.add(getPath(sceneText.getPoly()));
                    sceneText.getSplitTRSLines().clear();
                }
            } else {
                for (SceneText sceneText2 : sceneText.getComponents()) {
                    String str2 = TAG;
                    LTTLogger.m5458d(str2, "getLinesToRestore: Line Original - " + sceneText2.getValue() + " hasOnlyNumber - " + sceneText2.hasOnlyNumber());
                    StringBuilder sb = new StringBuilder("getLinesToRestore: Line Translated - ");
                    sb.append(sceneText2.getTrsValue());
                    LTTLogger.m5458d(str2, sb.toString());
                    if (sceneText2.hasOnlyNumber()) {
                        LTTLogger.m5458d(str2, "getLinesToRestore: Rendering skipped");
                        sceneText2.setTrsValue("");
                    } else if (Util.removeMoreThanOneSpaceBetweenWords(sceneText2.getValue()).trim().equalsIgnoreCase(Util.removeMoreThanOneSpaceBetweenWords(sceneText2.getTrsValue()).trim())) {
                        LTTLogger.m5458d(str2, "getLinesToRestore: Line Restored");
                        list.add(getPath(sceneText2.getPoly()));
                        sceneText2.setTrsValue("");
                    }
                }
            }
            i++;
        }
    }

    public Path getPath(Point[] pointArr) {
        Path path = new Path();
        Point point = pointArr[0];
        path.moveTo(point.x, point.y);
        Point point2 = pointArr[1];
        path.lineTo(point2.x, point2.y);
        Point point3 = pointArr[2];
        path.lineTo(point3.x, point3.y);
        Point point4 = pointArr[3];
        path.lineTo(point4.x, point4.y);
        path.close();
        return path;
    }
}
