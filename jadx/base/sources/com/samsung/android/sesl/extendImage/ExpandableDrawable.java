package com.samsung.android.sesl.extendImage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorSpace;
import android.graphics.ComposeShader;
import android.graphics.HardwareRenderer;
import android.graphics.Insets;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.pen.engine.drawLoop.AbstractC7448b;
import com.samsung.android.sesl.extendImage.ExpandableDrawable;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import opennlp.tools.parser.AbstractBottomUpParser;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ExpandableDrawable extends Drawable {
    private static final boolean DEBUG_DETAILED_PERFORMANCE = false;
    private static final boolean DEBUG_DRAW_TIME = true;
    private static final boolean DEBUG_EDGE_ANALYSIS = false;
    private static final boolean DEBUG_RECTS = false;
    public static final int DIRECTION_BOTTOM = 1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 3;
    public static final int DIRECTION_TOP = 0;
    private static final int DITHERING_LEVEL = 3;

    @SuppressLint({"ObsoleteSdkInt"})
    private static final boolean RENDER_NODE_BLUR_SUPPORTED;

    @SuppressLint({"ObsoleteSdkInt"})
    private static final boolean WIDE_GAMUT_SUPPORTED;
    private final String TAG;
    private final RectF[] mAreaAnalysisRectFs;
    private final RectF[] mBlendRectFs;
    private int mBlurredBitmapHeight;
    private BitmapShader mBlurredBitmapShader;
    private final Matrix mBlurredBitmapShaderMatrix;
    private int mBlurredBitmapWidth;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private final Paint mDebugPaint;
    private final RectF[] mGradientAnalysisRectFs;
    private final ExpandDrawInfo[] mGradientCaches;
    private final RectF mImageBoundsInView;
    private boolean mIsAnalyzing;
    private boolean mNeedsColorAnalysis;
    private boolean mNeedsUpdateShaders;
    private final RectF[] mOutpaintingRectFs;
    private final RectF[] mOverlapDepthMaxRectFs;
    private final ExpandableConstantState mState;
    private final RectF mTempBoundsRectF;
    private final RectF mTempOutpaintingRectF;
    private final RectF mTempOutpaintingShaderRectF;
    private final RectF mTempOverlapRectF;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EdgeColorGroup {
        private static final double EPSILON_S = 1.0E-4d;
        private int mStart;
        private int mEnd = 0;
        private int mLength = 0;
        private double mMaxL = 0.0d;
        private double mMaxA = 0.0d;
        private double mMaxB = 0.0d;
        private double mMinL = Double.MAX_VALUE;
        private double mMinA = Double.MAX_VALUE;
        private double mMinB = Double.MAX_VALUE;
        private double mSumL = 0.0d;
        private double mSumA = 0.0d;
        private double mSumB = 0.0d;
        private double mSumS = 0.0d;
        private double mMaxS = 0.0d;
        private double mMinS = Double.MAX_VALUE;
        private float mFirstH = -1.0f;
        private float mMaxShiftedH = 0.0f;
        private float mMinShiftedH = Float.MAX_VALUE;

        public EdgeColorGroup(int i, double d, double d2, double d3) {
            this.mStart = i;
            add(i, d, d2, d3);
        }

        private double getAvgA() {
            return this.mSumA / ((double) this.mLength);
        }

        private double getAvgB() {
            return this.mSumB / ((double) this.mLength);
        }

        private double getAvgL() {
            return this.mSumL / ((double) this.mLength);
        }

        private double getAvgS() {
            return this.mSumS / ((double) this.mLength);
        }

        private double getRangeA() {
            return this.mMaxA - this.mMinA;
        }

        private double getRangeB() {
            return this.mMaxB - this.mMinB;
        }

        private float getRangeH() {
            if (this.mFirstH < 0.0f) {
                return 0.0f;
            }
            return this.mMaxShiftedH - this.mMinShiftedH;
        }

        private double getRangeL() {
            return this.mMaxL - this.mMinL;
        }

        private double getRangeS() {
            return this.mMaxS - this.mMinS;
        }

        public void add(int i, double d, double d2, double d3) {
            this.mEnd = i;
            this.mLength = (i - this.mStart) + 1;
            this.mMaxL = Math.max(this.mMaxL, d);
            this.mMinL = Math.min(this.mMinL, d);
            this.mSumL += d;
            this.mMaxA = Math.max(this.mMaxA, d2);
            this.mMinA = Math.min(this.mMinA, d2);
            this.mSumA += d2;
            this.mMaxB = Math.max(this.mMaxB, d3);
            this.mMinB = Math.min(this.mMinB, d3);
            this.mSumB += d3;
            double lABSaturation = ColorConverter.getLABSaturation(d2, d3);
            this.mSumS += lABSaturation;
            this.mMaxS = Math.max(this.mMaxS, lABSaturation);
            this.mMinS = Math.min(this.mMinS, lABSaturation);
            if (this.mFirstH < 0.0f) {
                this.mFirstH = lABSaturation > 1.0E-4d ? ColorConverter.fastAngleDeg(d2, d3) : -1.0f;
            } else if (lABSaturation > 1.0E-4d) {
                float fAcuteAngle = ColorConverter.acuteAngle(ColorConverter.fastAngleDeg(d2, d3), this.mFirstH);
                this.mMaxShiftedH = Math.max(this.mMaxShiftedH, fAcuteAngle);
                this.mMinShiftedH = Math.min(this.mMinShiftedH, fAcuteAngle);
            }
        }

        public int getEnd() {
            return this.mEnd;
        }

        public int getStart() {
            return this.mStart;
        }

        public double getWeight() {
            return ((getRangeL() * ((double) getRangeH())) * getRangeS()) / ((double) this.mLength);
        }

        public boolean isSameGroup(int i, double d, double d2, double d3) {
            double d4 = i;
            if (Math.max(this.mMaxL, d) - Math.min(this.mMinL, d) > d4) {
                return false;
            }
            double lABSaturation = ColorConverter.getLABSaturation(d2, d3);
            if (Math.max(this.mMaxS, lABSaturation) - Math.min(this.mMinS, lABSaturation) > d4 / 100.0d) {
                return false;
            }
            double d5 = 2.0d - ((this.mSumS + lABSaturation) / ((double) (this.mLength + 1)));
            double dAcuteAngle = this.mFirstH < 0.0f ? 0.0d : ColorConverter.acuteAngle(ColorConverter.fastAngleDeg(d2, d3), this.mFirstH);
            return (this.mFirstH >= 0.0f ? Math.max((double) this.mMaxShiftedH, dAcuteAngle) - Math.min((double) this.mMinShiftedH, dAcuteAngle) : 0.0d) <= (d4 * 3.6d) * d5;
        }

        public int length() {
            return this.mLength;
        }

        @NonNull
        public String toString() {
            double avgL = getAvgL();
            double avgA = getAvgA();
            double avgB = getAvgB();
            Locale locale = Locale.US;
            String hexString = Integer.toHexString(ColorConverter.getRGBFromLAB(avgL, avgA, avgB));
            int i = this.mLength;
            int i2 = this.mStart;
            int i4 = this.mEnd;
            double weight = getWeight();
            double avgS = getAvgS();
            float rangeH = getRangeH();
            double rangeS = getRangeS();
            double rangeL = getRangeL();
            double rangeA = getRangeA();
            double rangeB = getRangeB();
            StringBuilder sbM780v = AbstractC0541b.m780v("EdgeColorGroup{, rgb=#", i, hexString, ", length=", ", start=");
            AbstractC2821a.m2235z(sbM780v, i2, i4, ", end=", ", weight=");
            sbM780v.append(weight);
            sbM780v.append(", avgL=");
            sbM780v.append(avgL);
            sbM780v.append(", avgA=");
            sbM780v.append(avgA);
            sbM780v.append(", avgB=");
            sbM780v.append(avgB);
            sbM780v.append(", avgS=");
            sbM780v.append(avgS);
            sbM780v.append(", rangeH=");
            sbM780v.append(rangeH);
            sbM780v.append(", rangeS=");
            sbM780v.append(rangeS);
            sbM780v.append(", rangeL=");
            sbM780v.append(rangeL);
            sbM780v.append(", rangeA=");
            sbM780v.append(rangeA);
            sbM780v.append(", rangeB=");
            sbM780v.append(rangeB);
            sbM780v.append("}");
            return sbM780v.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExpandDirection {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExpandDrawInfo {
        private ExpandEdgeColorInfo mCachedEdgeColorInfo;
        private final RectF mCachedImageBoundsRectF;
        private final RectF mCachedOutpaintingRectF;
        private final DitheringShaderFactory mDitheringShaderFactory = new DitheringShaderFactory();
        private boolean mIsValid;
        private int[] mOutpaintingColors;
        private float[] mOutpaintingPositions;
        private int[] mOverlapColors;
        private float[] mOverlapPositions;
        private final Paint mPaint;
        private int[] mReversedOverlapColors;
        private float[] mReversedOverlapPositions;
        private Shader mShader;

        public ExpandDrawInfo() {
            Paint paint = new Paint(7);
            this.mPaint = paint;
            this.mIsValid = false;
            this.mCachedOutpaintingRectF = new RectF();
            this.mCachedImageBoundsRectF = new RectF();
            if (Build.VERSION.SDK_INT >= 29) {
                BlendMode unused = BlendMode.SRC_OVER;
                paint.setBlendMode(BlendMode.SRC_OVER);
            }
        }

        private void cacheParameters(ExpandEdgeColorInfo expandEdgeColorInfo, RectF rectF, RectF rectF2) {
            this.mCachedOutpaintingRectF.set(rectF);
            this.mCachedImageBoundsRectF.set(rectF2);
            this.mCachedEdgeColorInfo = expandEdgeColorInfo;
        }

        private static Shader composeOutpaintingShader(int i, @NonNull int[] iArr, @NonNull float[] fArr, @NonNull RectF rectF, @NonNull RectF rectF2, @NonNull Shader shader) {
            LinearGradient linearGradient;
            LinearGradient linearGradientM5852A;
            if (!ExpandableDrawable.WIDE_GAMUT_SUPPORTED || Build.VERSION.SDK_INT < 29) {
                if (i == 0) {
                    linearGradient = new LinearGradient(0.0f, rectF2.top, 0.0f, rectF.top, iArr, fArr, Shader.TileMode.CLAMP);
                } else if (i == 1) {
                    linearGradient = new LinearGradient(0.0f, rectF2.bottom, 0.0f, rectF.bottom, iArr, fArr, Shader.TileMode.CLAMP);
                } else if (i == 2) {
                    linearGradient = new LinearGradient(rectF2.left, 0.0f, rectF.left, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException(AbstractC0000a.m11h(i, "Unexpected direction: "));
                    }
                    linearGradient = new LinearGradient(rectF2.right, 0.0f, rectF.right, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                }
                linearGradientM5852A = linearGradient;
            } else {
                ColorSpace colorSpace = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
                int length = iArr.length;
                long[] jArr = new long[length];
                for (int i2 = 0; i2 < length; i2++) {
                    jArr[i2] = Color.convert(iArr[i2], colorSpace);
                }
                if (i == 0) {
                    float f = rectF2.top;
                    float f4 = rectF.top;
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    linearGradientM5852A = AbstractC7448b.m5852A(f, f4, jArr, fArr);
                } else if (i == 1) {
                    float f5 = rectF2.bottom;
                    float f6 = rectF.bottom;
                    Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                    linearGradientM5852A = AbstractC7448b.m5852A(f5, f6, jArr, fArr);
                } else if (i == 2) {
                    float f7 = rectF2.left;
                    float f8 = rectF.left;
                    Shader.TileMode tileMode3 = Shader.TileMode.CLAMP;
                    linearGradientM5852A = AbstractC7448b.m5861f(f7, f8, jArr, fArr);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException(AbstractC0000a.m11h(i, "Unexpected direction: "));
                    }
                    float f9 = rectF2.right;
                    float f10 = rectF.right;
                    Shader.TileMode tileMode4 = Shader.TileMode.CLAMP;
                    linearGradientM5852A = AbstractC7448b.m5861f(f9, f10, jArr, fArr);
                }
            }
            return new ComposeShader(shader, linearGradientM5852A, PorterDuff.Mode.SRC_ATOP);
        }

        private static Shader composeOverlapShader(int i, @NonNull int[] iArr, @NonNull float[] fArr, @NonNull RectF rectF, @NonNull Shader shader) {
            LinearGradient linearGradient;
            LinearGradient linearGradientM5852A;
            if (!ExpandableDrawable.WIDE_GAMUT_SUPPORTED || Build.VERSION.SDK_INT < 29) {
                if (i == 0) {
                    linearGradient = new LinearGradient(0.0f, rectF.top, 0.0f, rectF.bottom, iArr, fArr, Shader.TileMode.CLAMP);
                } else if (i == 1) {
                    linearGradient = new LinearGradient(0.0f, rectF.bottom, 0.0f, rectF.top, iArr, fArr, Shader.TileMode.CLAMP);
                } else if (i == 2) {
                    linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException(AbstractC0000a.m11h(i, "Unexpected value: "));
                    }
                    linearGradient = new LinearGradient(rectF.right, 0.0f, rectF.left, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                }
                linearGradientM5852A = linearGradient;
            } else {
                ColorSpace colorSpace = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
                int length = iArr.length;
                long[] jArr = new long[length];
                for (int i2 = 0; i2 < length; i2++) {
                    jArr[i2] = Color.convert(iArr[i2], colorSpace);
                }
                if (i == 0) {
                    float f = rectF.top;
                    float f4 = rectF.bottom;
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    linearGradientM5852A = AbstractC7448b.m5852A(f, f4, jArr, fArr);
                } else if (i == 1) {
                    float f5 = rectF.bottom;
                    float f6 = rectF.top;
                    Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                    linearGradientM5852A = AbstractC7448b.m5852A(f5, f6, jArr, fArr);
                } else if (i == 2) {
                    float f7 = rectF.left;
                    float f8 = rectF.right;
                    Shader.TileMode tileMode3 = Shader.TileMode.CLAMP;
                    linearGradientM5852A = AbstractC7448b.m5861f(f7, f8, jArr, fArr);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException(AbstractC0000a.m11h(i, "Unexpected value: "));
                    }
                    float f9 = rectF.right;
                    float f10 = rectF.left;
                    Shader.TileMode tileMode4 = Shader.TileMode.CLAMP;
                    linearGradientM5852A = AbstractC7448b.m5861f(f9, f10, jArr, fArr);
                }
            }
            return new ComposeShader(shader, linearGradientM5852A, PorterDuff.Mode.DST_IN);
        }

        private static LinearGradient createBaseGradientShader(int i, @NonNull int[] iArr, @NonNull float[] fArr, @NonNull RectF rectF) {
            if (!ExpandableDrawable.WIDE_GAMUT_SUPPORTED || Build.VERSION.SDK_INT < 29) {
                if (i == 0 || i == 1) {
                    return new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
                }
                if (i == 2 || i == 3) {
                    return new LinearGradient(0.0f, rectF.top, 0.0f, rectF.bottom, iArr, fArr, Shader.TileMode.CLAMP);
                }
                throw new IllegalStateException(AbstractC0000a.m11h(i, "Unexpected direction: "));
            }
            int length = iArr.length;
            ColorSpace colorSpace = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
            long[] jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = Color.convert(iArr[i2], colorSpace);
            }
            if (i == 0 || i == 1) {
                float f = rectF.left;
                float f4 = rectF.right;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                return AbstractC7448b.m5861f(f, f4, jArr, fArr);
            }
            if (i != 2 && i != 3) {
                throw new IllegalStateException(AbstractC0000a.m11h(i, "Unexpected direction: "));
            }
            float f5 = rectF.top;
            float f6 = rectF.bottom;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            return AbstractC7448b.m5852A(f5, f6, jArr, fArr);
        }

        private void createShaders(int i, @NonNull ExpandEdgeColorInfo expandEdgeColorInfo, @NonNull ExpandTuneData expandTuneData, @NonNull RectF rectF, @NonNull RectF rectF2, @NonNull RectF rectF3, BitmapShader bitmapShader, int i2, int i4) {
            int[] edgeColors = expandEdgeColorInfo.getEdgeColors();
            float[] edgeColorPositions = expandEdgeColorInfo.getEdgeColorPositions();
            updateOutpaintingColorPositions(i, expandEdgeColorInfo, expandTuneData, rectF);
            updateOverlapColorPositions(expandEdgeColorInfo, expandTuneData);
            Shader shaderComposeOutpaintingShader = composeOutpaintingShader(i, this.mOutpaintingColors, this.mOutpaintingPositions, rectF, rectF3, createBaseGradientShader(i, edgeColors, edgeColorPositions, rectF3));
            if (expandEdgeColorInfo.isSolidColor() || bitmapShader == null) {
                this.mShader = composeOverlapShader(i, this.mOverlapColors, this.mOverlapPositions, rectF2, shaderComposeOutpaintingShader);
                return;
            }
            float fMin = Math.min(expandTuneData.getBlurRadius() * 2.0f, Math.max(i2, i4) * 0.02f);
            RectF rectF4 = new RectF(rectF2);
            if (i == 0) {
                rectF4.bottom = (rectF4.height() * 0.5f) + rectF4.top;
                rectF4.top -= Math.max(fMin, rectF2.height() * 0.05f);
            } else if (i == 1) {
                rectF4.top = rectF4.bottom - (rectF4.height() * 0.5f);
                rectF4.bottom = Math.max(fMin, rectF2.height() * 0.05f) + rectF4.bottom;
            } else if (i == 2) {
                rectF4.right = (rectF4.width() * 0.5f) + rectF4.right;
                rectF4.left -= Math.max(fMin, rectF2.width() * 0.05f);
            } else if (i == 3) {
                rectF4.left -= rectF4.width() * 0.5f;
                rectF4.right = Math.max(fMin, rectF2.width() * 0.05f) + rectF4.right;
            }
            this.mShader = composeOverlapShader(i, this.mReversedOverlapColors, this.mReversedOverlapPositions, rectF2, new ComposeShader(bitmapShader, composeOverlapShader(i, this.mOverlapColors, this.mOverlapPositions, rectF4, shaderComposeOutpaintingShader), PorterDuff.Mode.SRC_ATOP));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Paint getPaint() {
            return this.mPaint;
        }

        private Shader getShader() {
            return this.mShader;
        }

        private boolean hasNoChanges(@NonNull ExpandEdgeColorInfo expandEdgeColorInfo, @NonNull RectF rectF, @NonNull RectF rectF2) {
            return expandEdgeColorInfo.equals(this.mCachedEdgeColorInfo) && this.mCachedOutpaintingRectF.equals(rectF) && this.mCachedImageBoundsRectF.equals(rectF2);
        }

        private void updateOutpaintingColorPositions(int i, @NonNull ExpandEdgeColorInfo expandEdgeColorInfo, @NonNull ExpandTuneData expandTuneData, @NonNull RectF rectF) {
            int iMax = Math.max(2, (int) (ExpandableDrawable.isVertical(i) ? rectF.height() : rectF.width()));
            float[] fArr = this.mOutpaintingPositions;
            if (fArr == null || fArr.length != iMax || expandTuneData.mNeedInvalidate) {
                int[] iArr = this.mOutpaintingColors;
                if (iArr == null || iArr.length != iMax) {
                    this.mOutpaintingColors = new int[iMax];
                    this.mOutpaintingPositions = new float[iMax];
                }
                PathInterpolator outpaintingPathInterpolator = expandTuneData.getOutpaintingPathInterpolator();
                int areaColor = expandEdgeColorInfo.getAreaColor();
                for (int i2 = 0; i2 < iMax; i2++) {
                    float f = i2 / (iMax - 1);
                    this.mOutpaintingColors[i2] = ExpandableDrawable.getTransparentColor(areaColor, (int) (outpaintingPathInterpolator.getInterpolation(f) * 255.0f));
                    this.mOutpaintingPositions[i2] = f;
                }
            }
        }

        private void updateOverlapColorPositions(@NonNull ExpandEdgeColorInfo expandEdgeColorInfo, @NonNull ExpandTuneData expandTuneData) {
            float[] fArr = this.mOverlapPositions;
            if (fArr == null || fArr.length != 10 || expandTuneData.mNeedInvalidate) {
                int[] iArr = this.mOverlapColors;
                if (iArr == null || iArr.length != 10) {
                    this.mOverlapColors = new int[10];
                    this.mReversedOverlapColors = new int[10];
                    this.mOverlapPositions = new float[10];
                    this.mReversedOverlapPositions = new float[10];
                }
                PathInterpolator overlapPathInterpolator = expandTuneData.getOverlapPathInterpolator();
                int areaColor = expandEdgeColorInfo.getAreaColor();
                for (int i = 0; i < 10; i++) {
                    float f = i / 9.0f;
                    this.mOverlapPositions[i] = f;
                    this.mReversedOverlapPositions[i] = (0.7f * f) + 0.3f;
                    int interpolation = (int) (overlapPathInterpolator.getInterpolation(1.0f - f) * 255.0f);
                    this.mOverlapColors[i] = ExpandableDrawable.getTransparentColor(areaColor, interpolation);
                    this.mReversedOverlapColors[i] = ExpandableDrawable.getTransparentColor(areaColor, interpolation);
                }
            }
        }

        public void invalidate() {
            this.mIsValid = false;
            this.mShader = null;
        }

        public boolean isValid() {
            return this.mIsValid;
        }

        public void updateShaders(@NonNull Canvas canvas, int i, @NonNull ExpandEdgeColorInfo expandEdgeColorInfo, @NonNull ExpandTuneData expandTuneData, @NonNull RectF rectF, @NonNull RectF rectF2, @NonNull RectF rectF3, boolean z, BitmapShader bitmapShader, int i2, int i4) {
            if (z || !this.mIsValid || !hasNoChanges(expandEdgeColorInfo, rectF, rectF3) || expandTuneData.mNeedInvalidate) {
                cacheParameters(expandEdgeColorInfo, rectF, rectF3);
                createShaders(i, expandEdgeColorInfo, expandTuneData, rectF, rectF2, rectF3, bitmapShader, i2, i4);
                this.mDitheringShaderFactory.applyDithering(canvas, this.mPaint, this.mShader, i, 3);
                this.mIsValid = true;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExpandableConstantState extends Drawable.ConstantState {
        private static final String TAG = "ExpandableConstantState";
        int mChangingConfigurations;
        private boolean mDebugDrawAreaAnalysis;
        private boolean mDebugDrawBlendRect;
        private boolean mDebugDrawGradientAnalysis;
        private boolean mDebugDrawImageBounds;
        private boolean mDebugDrawOverlapDepthMax;
        private boolean mDebugDrawOverlapRect;
        private final ExpandAnalysisData mExpandAnalysisData;
        private final ExpandTuneData mExpandTuneData;
        private boolean mHasAnyDebugFlags;
        Drawable mOriginalDrawable;

        public /* synthetic */ ExpandableConstantState(Drawable drawable, ExpandAnalysisData expandAnalysisData, int i) {
            this(drawable, expandAnalysisData);
        }

        private ExpandEdgeColorInfo[] getAllExpandEdgeColorInfos() {
            return this.mExpandAnalysisData.getAllEdgeColorInfos();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ExpandAnalysisData getExpandAnalysisData() {
            return this.mExpandAnalysisData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ExpandEdgeColorInfo getExpandEdgeColorInfo(int i) {
            return this.mExpandAnalysisData.edgeColorInfo[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ExpandTuneData getExpandTuneData() {
            return this.mExpandTuneData;
        }

        private void updateDebugFlags() {
            this.mHasAnyDebugFlags = this.mDebugDrawGradientAnalysis || this.mDebugDrawAreaAnalysis || this.mDebugDrawOverlapRect || this.mDebugDrawBlendRect || this.mDebugDrawImageBounds || this.mDebugDrawOverlapDepthMax;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mOriginalDrawable.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public String getEdgeAnalysisData() {
            return this.mExpandAnalysisData.getString();
        }

        public int getExtractedBitmapHeight() {
            return this.mExpandAnalysisData.getExtractedBitmapHeight();
        }

        public int getExtractedBitmapWidth() {
            return this.mExpandAnalysisData.getExtractedBitmapWidth();
        }

        @Nullable
        public Drawable getOriginalDrawable() {
            return this.mOriginalDrawable;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean isDebugDrawAreaAnalysis() {
            return this.mDebugDrawAreaAnalysis;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean isDebugDrawBlendRect() {
            return this.mDebugDrawBlendRect;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean isDebugDrawGradientAnalysis() {
            return this.mDebugDrawGradientAnalysis;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean isDebugDrawImageBounds() {
            return this.mDebugDrawImageBounds;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean isDebugDrawOverlapDepthMax() {
            return this.mDebugDrawOverlapDepthMax;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean isDebugDrawOverlapRect() {
            return this.mDebugDrawOverlapRect;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new ExpandableDrawable(this, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setDebugDrawAreaAnalysis(boolean z) {
            this.mDebugDrawAreaAnalysis = z;
            updateDebugFlags();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setDebugDrawBlendRect(boolean z) {
            this.mDebugDrawBlendRect = z;
            updateDebugFlags();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setDebugDrawGradientAnalysis(boolean z) {
            this.mDebugDrawGradientAnalysis = z;
            updateDebugFlags();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setDebugDrawImageBounds(boolean z) {
            this.mDebugDrawImageBounds = z;
            updateDebugFlags();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setDebugDrawOverlapDepthMax(boolean z) {
            this.mDebugDrawOverlapDepthMax = z;
            updateDebugFlags();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setDebugDrawOverlapRect(boolean z) {
            this.mDebugDrawOverlapRect = z;
            updateDebugFlags();
        }

        public void setExtractedBitmapSize(int i, int i2) {
            this.mExpandAnalysisData.setExtractedBitmapSize(i, i2);
        }

        public void setOriginalDrawable(@Nullable Drawable drawable) {
            this.mOriginalDrawable = drawable;
            if (drawable != null) {
                this.mChangingConfigurations = drawable.getChangingConfigurations();
            }
        }

        public ExpandableConstantState(Drawable drawable) {
            this.mDebugDrawGradientAnalysis = false;
            this.mDebugDrawAreaAnalysis = false;
            this.mDebugDrawOverlapRect = false;
            this.mDebugDrawBlendRect = false;
            this.mDebugDrawImageBounds = false;
            this.mDebugDrawOverlapDepthMax = false;
            this.mHasAnyDebugFlags = false;
            this.mChangingConfigurations = 0;
            this.mOriginalDrawable = drawable;
            this.mExpandTuneData = new ExpandTuneData();
            this.mExpandAnalysisData = new ExpandAnalysisData();
            if (drawable != null) {
                this.mChangingConfigurations = drawable.getChangingConfigurations();
            }
        }

        public ExpandableConstantState(@NonNull Drawable drawable, @Nullable String str) {
            this(drawable, ExpandAnalysisData.parse(str));
        }

        private ExpandableConstantState(@NonNull Drawable drawable, @Nullable ExpandAnalysisData expandAnalysisData) {
            this.mDebugDrawGradientAnalysis = false;
            this.mDebugDrawAreaAnalysis = false;
            this.mDebugDrawOverlapRect = false;
            this.mDebugDrawBlendRect = false;
            this.mDebugDrawImageBounds = false;
            this.mDebugDrawOverlapDepthMax = false;
            this.mHasAnyDebugFlags = false;
            this.mChangingConfigurations = 0;
            this.mOriginalDrawable = drawable;
            this.mExpandTuneData = new ExpandTuneData();
            this.mExpandAnalysisData = expandAnalysisData != null ? new ExpandAnalysisData(expandAnalysisData) : new ExpandAnalysisData();
            this.mChangingConfigurations = drawable.getChangingConfigurations();
        }

        public ExpandableConstantState(ExpandableConstantState expandableConstantState) {
            this.mDebugDrawGradientAnalysis = false;
            this.mDebugDrawAreaAnalysis = false;
            this.mDebugDrawOverlapRect = false;
            this.mDebugDrawBlendRect = false;
            this.mDebugDrawImageBounds = false;
            this.mDebugDrawOverlapDepthMax = false;
            this.mHasAnyDebugFlags = false;
            this.mChangingConfigurations = 0;
            if (expandableConstantState != null) {
                Drawable drawable = expandableConstantState.mOriginalDrawable;
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    Objects.requireNonNull(constantState);
                    Drawable drawableNewDrawable = constantState.newDrawable();
                    this.mOriginalDrawable = drawableNewDrawable;
                    drawableNewDrawable.mutate();
                } else {
                    this.mOriginalDrawable = null;
                }
                this.mExpandTuneData = new ExpandTuneData(expandableConstantState.mExpandTuneData);
                this.mExpandAnalysisData = new ExpandAnalysisData(expandableConstantState.mExpandAnalysisData);
                this.mHasAnyDebugFlags = expandableConstantState.mHasAnyDebugFlags;
                this.mDebugDrawGradientAnalysis = expandableConstantState.mDebugDrawGradientAnalysis;
                this.mDebugDrawAreaAnalysis = expandableConstantState.mDebugDrawAreaAnalysis;
                this.mDebugDrawOverlapRect = expandableConstantState.mDebugDrawOverlapRect;
                this.mDebugDrawBlendRect = expandableConstantState.mDebugDrawBlendRect;
                this.mDebugDrawImageBounds = expandableConstantState.mDebugDrawImageBounds;
                this.mDebugDrawOverlapDepthMax = expandableConstantState.mDebugDrawOverlapDepthMax;
                this.mChangingConfigurations = expandableConstantState.mChangingConfigurations;
                return;
            }
            this.mOriginalDrawable = null;
            this.mExpandTuneData = new ExpandTuneData();
            this.mExpandAnalysisData = new ExpandAnalysisData();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        WIDE_GAMUT_SUPPORTED = true;
        RENDER_NODE_BLUR_SUPPORTED = i >= 31;
    }

    public /* synthetic */ ExpandableDrawable(ExpandableConstantState expandableConstantState, int i) {
        this(expandableConstantState);
    }

    private void analyzeDirectionColors(int i, float f, int i2, int i4, int i5, @NonNull AverageColorExtractor averageColorExtractor, @NonNull AverageColorExtractor averageColorExtractor2) {
        int i6;
        ExpandableDrawable expandableDrawable;
        ExpandEdgeColorInfo expandEdgeColorInfoCalcExpandEdgeColorInfo;
        ExpandEdgeColorInfo expandEdgeColorInfo = this.mState.getExpandEdgeColorInfo(i);
        if (expandEdgeColorInfo == null) {
            return;
        }
        try {
            expandEdgeColorInfoCalcExpandEdgeColorInfo = calcExpandEdgeColorInfo(i, f, i2, i4, i5, averageColorExtractor, averageColorExtractor2);
            i6 = i;
            expandableDrawable = this;
        } catch (Exception e) {
            e = e;
            i6 = i;
            expandableDrawable = this;
        }
        try {
            if (expandEdgeColorInfoCalcExpandEdgeColorInfo.isValid()) {
                expandEdgeColorInfo.copyFrom(expandEdgeColorInfoCalcExpandEdgeColorInfo);
            }
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            Log.e(expandableDrawable.TAG, "Failed to analyze colors for direction " + getDirectionName(i6), exc);
            expandEdgeColorInfo.updateColorData(VUtilString.GRAY, getTestColors(i6), null);
        }
    }

    private double[] applyAntiMoireCorrection(@NonNull double[] dArr, @NonNull double[] dArr2, double d, float f) {
        double[] dArr3 = new double[3];
        double d2 = ((double) (f * f)) * 2.25d;
        if (d <= d2) {
            dArr3[0] = dArr2[0];
            dArr3[1] = dArr2[1];
            dArr3[2] = dArr2[2];
            return dArr3;
        }
        double d3 = 1.0d - (d2 / d);
        double d4 = dArr2[0];
        double d5 = ((dArr[0] - d4) * d3 * 0.7d) + d4;
        dArr3[0] = d5;
        double d6 = dArr2[1];
        dArr3[1] = ((dArr[1] - d6) * d3 * 0.5d) + d6;
        double d7 = dArr2[2];
        dArr3[2] = ((dArr[2] - d7) * d3 * 0.5d) + d7;
        dArr3[0] = Math.max(0.0d, Math.min(100.0d, d5));
        dArr3[1] = Math.max(-128.0d, Math.min(127.0d, dArr3[1]));
        dArr3[2] = Math.max(-128.0d, Math.min(127.0d, dArr3[2]));
        return dArr3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00de: MOVE (r3 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:223), block:B:16:0x00de */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014d  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.media.ImageReader] */
    /* JADX WARN: Type inference failed for: r2v13, types: [android.media.ImageReader] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.media.ImageReader] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.graphics.HardwareRenderer] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.graphics.HardwareRenderer] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9, types: [android.graphics.HardwareRenderer] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14, types: [android.media.Image, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.media.Image] */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.media.Image] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.hardware.HardwareBuffer] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [android.hardware.HardwareBuffer, java.lang.Object] */
    @Nullable
    @SuppressLint({WarningType.NewApi})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap applyHardwareBlur(@NonNull Bitmap bitmap, float f) throws Throwable {
        ?? r2;
        RenderNode renderNodeM5862g;
        ?? r22;
        HardwareBuffer hardwareBuffer;
        ?? M5860e;
        RenderNode renderNode;
        ?? AcquireNextImage;
        ?? r23;
        ?? hardwareBuffer2;
        float fMin;
        HardwareBuffer hardwareBuffer3 = null;
        if (!RENDER_NODE_BLUR_SUPPORTED) {
            Log.e(this.TAG, "applyHardwareBlur: unsupported");
            return null;
        }
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        ?? NewInstance = 1036831949;
        try {
            try {
                fMin = Math.min(Math.max(f, 0.1f), 25.0f);
                NewInstance = ImageReader.newInstance(bitmap.getWidth(), bitmap.getHeight(), 1, 1, 768L);
            } catch (Throwable th) {
                th = th;
                hardwareBuffer3 = hardwareBuffer;
            }
        } catch (Exception e) {
            e = e;
            r22 = 0;
            renderNodeM5862g = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            renderNodeM5862g = null;
        }
        try {
            AbstractC7448b.m5869n();
            renderNodeM5862g = AbstractC7448b.m5862g();
            try {
                AbstractC7448b.m5855D();
                M5860e = AbstractC7448b.m5860e();
            } catch (Exception e2) {
                e = e2;
                renderNode = null;
                r23 = NewInstance;
                AcquireNextImage = renderNode;
                NewInstance = r23;
                M5860e = renderNode;
                hardwareBuffer2 = AcquireNextImage;
                Log.e(this.TAG, "HardwareRenderer blur failed: " + e.getMessage(), e);
                if (hardwareBuffer2 != 0) {
                }
                if (AcquireNextImage != 0) {
                }
                if (NewInstance != 0) {
                }
                if (renderNodeM5862g != null) {
                }
                if (M5860e != 0) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                M5860e = 0;
                NewInstance = NewInstance;
                AcquireNextImage = M5860e;
                if (hardwareBuffer3 != null) {
                    hardwareBuffer3.close();
                }
                if (AcquireNextImage != 0) {
                    AcquireNextImage.close();
                }
                if (NewInstance != 0) {
                    NewInstance.close();
                }
                if (renderNodeM5862g != null) {
                    renderNodeM5862g.discardDisplayList();
                }
                if (M5860e != 0) {
                    M5860e.destroy();
                }
                throw th;
            }
            try {
                M5860e.setSurface(NewInstance.getSurface());
                M5860e.setContentRoot(renderNodeM5862g);
                renderNodeM5862g.setPosition(0, 0, NewInstance.getWidth(), NewInstance.getHeight());
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                renderNodeM5862g.setRenderEffect(RenderEffect.createBlurEffect(fMin, fMin, Shader.TileMode.CLAMP));
                renderNodeM5862g.beginRecording().drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                renderNodeM5862g.endRecording();
                M5860e.createRenderRequest().setWaitForPresent(true).syncAndDraw();
                AcquireNextImage = NewInstance.acquireNextImage();
                Objects.requireNonNull(AcquireNextImage, "No Image");
                try {
                    hardwareBuffer2 = AcquireNextImage.getHardwareBuffer();
                    Objects.requireNonNull(hardwareBuffer2, "No HardwareBuffer");
                    try {
                        Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer2, null);
                        Objects.requireNonNull(bitmapWrapHardwareBuffer, "Create Bitmap Failed");
                        long jElapsedRealtimeNanos2 = SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos;
                        Log.i(this.TAG, "applyHardwareBlur: size: " + bitmap.getWidth() + "x" + bitmap.getHeight() + " radius: " + fMin + " took" + jElapsedRealtimeNanos2 + "ns ");
                        Bitmap bitmapCopy = bitmapWrapHardwareBuffer.copy(Bitmap.Config.ARGB_8888, false);
                        hardwareBuffer2.close();
                        AcquireNextImage.close();
                        NewInstance.close();
                        renderNodeM5862g.discardDisplayList();
                        M5860e.destroy();
                        return bitmapCopy;
                    } catch (Exception e3) {
                        e = e3;
                        Log.e(this.TAG, "HardwareRenderer blur failed: " + e.getMessage(), e);
                        if (hardwareBuffer2 != 0) {
                            hardwareBuffer2.close();
                        }
                        if (AcquireNextImage != 0) {
                            AcquireNextImage.close();
                        }
                        if (NewInstance != 0) {
                            NewInstance.close();
                        }
                        if (renderNodeM5862g != null) {
                            renderNodeM5862g.discardDisplayList();
                        }
                        if (M5860e != 0) {
                            M5860e.destroy();
                        }
                        return null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    hardwareBuffer2 = 0;
                } catch (Throwable th4) {
                    th = th4;
                    if (hardwareBuffer3 != null) {
                    }
                    if (AcquireNextImage != 0) {
                    }
                    if (NewInstance != 0) {
                    }
                    if (renderNodeM5862g != null) {
                    }
                    if (M5860e != 0) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                AcquireNextImage = 0;
                NewInstance = NewInstance;
                M5860e = M5860e;
                hardwareBuffer2 = AcquireNextImage;
                Log.e(this.TAG, "HardwareRenderer blur failed: " + e.getMessage(), e);
                if (hardwareBuffer2 != 0) {
                }
                if (AcquireNextImage != 0) {
                }
                if (NewInstance != 0) {
                }
                if (renderNodeM5862g != null) {
                }
                if (M5860e != 0) {
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                AcquireNextImage = 0;
            }
        } catch (Exception e7) {
            e = e7;
            renderNodeM5862g = null;
            r22 = NewInstance;
            renderNode = renderNodeM5862g;
            r23 = r22;
            AcquireNextImage = renderNode;
            NewInstance = r23;
            M5860e = renderNode;
            hardwareBuffer2 = AcquireNextImage;
            Log.e(this.TAG, "HardwareRenderer blur failed: " + e.getMessage(), e);
            if (hardwareBuffer2 != 0) {
            }
            if (AcquireNextImage != 0) {
            }
            if (NewInstance != 0) {
            }
            if (renderNodeM5862g != null) {
            }
            if (M5860e != 0) {
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            renderNodeM5862g = null;
            r2 = NewInstance;
            M5860e = renderNodeM5862g;
            NewInstance = r2;
            AcquireNextImage = M5860e;
            if (hardwareBuffer3 != null) {
            }
            if (AcquireNextImage != 0) {
            }
            if (NewInstance != 0) {
            }
            if (renderNodeM5862g != null) {
            }
            if (M5860e != 0) {
            }
            throw th;
        }
    }

    private ExpandEdgeColorInfo calcExpandEdgeColorInfo(int i, float f, int i2, int i4, int i5, @Nullable AverageColorExtractor averageColorExtractor, @Nullable AverageColorExtractor averageColorExtractor2) {
        int i6;
        int edgeColor;
        Rect rect;
        int i7;
        int i8;
        ExpandEdgeColorInfo expandEdgeColorInfo = new ExpandEdgeColorInfo();
        boolean zIsVertical = isVertical(i);
        if (averageColorExtractor == null || averageColorExtractor2 == null) {
            expandEdgeColorInfo.updateColorData(VUtilString.GRAY, new int[]{VUtilString.GRAY, VUtilString.GRAY, VUtilString.GRAY}, new float[]{0.0f, 0.5f, 1.0f});
            return expandEdgeColorInfo;
        }
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int originalWidth = averageColorExtractor2.getOriginalWidth() - 1;
        int originalHeight = averageColorExtractor2.getOriginalHeight() - 1;
        int originalWidth2 = averageColorExtractor.getOriginalWidth();
        int i9 = originalWidth2 - 1;
        int originalHeight2 = averageColorExtractor.getOriginalHeight();
        int i10 = originalHeight2 - 1;
        if (i == 0) {
            i6 = 1;
            rect2.set(0, 0, i9, 1);
            rect3.set(0, 0, originalWidth, i4);
            rect4.set(0, 0, i9, i5);
        } else if (i == 1) {
            i6 = 1;
            rect2.set(0, originalHeight2 - 2, i9, i10);
            rect3.set(0, originalHeight - i4, originalWidth, originalHeight);
            rect4.set(0, i10 - i5, i9, i10);
        } else if (i != 2) {
            if (i == 3) {
                rect2.set(originalWidth2 - 2, 0, i9, i10);
                rect3.set(originalWidth - i4, 0, originalWidth, originalHeight);
                rect4.set(i9 - i5, 0, i9, i10);
            }
            i6 = 1;
        } else {
            i6 = 1;
            rect2.set(0, 0, 1, i10);
            rect3.set(0, 0, i4, originalHeight);
            rect4.set(0, 0, i5, i10);
        }
        int averageColor = averageColorExtractor.getAverageColor(rect2);
        ExpandableDrawable expandableDrawable = this;
        if (expandableDrawable.isSolidEdgeColor(zIsVertical, rect2, averageColor, 100, averageColorExtractor)) {
            float[] fArr = new float[i6];
            fArr[0] = 0.0f;
            expandEdgeColorInfo.updateColorData(averageColor, new int[]{averageColor}, fArr);
            Log.i(expandableDrawable.TAG, "calcExpandEdgeColorInfo: direction=" + getDirectionName(i) + ", solidedgeColor=" + Integer.toHexString(averageColor));
            return expandEdgeColorInfo;
        }
        int averageColor2 = averageColorExtractor.getAverageColor(rect4);
        boolean z = zIsVertical;
        int i11 = i;
        AverageColorExtractor averageColorExtractor3 = averageColorExtractor;
        int i12 = 5;
        int i13 = 100;
        Rect rect5 = rect4;
        while (true) {
            edgeColor = expandableDrawable.getEdgeColor(i11, z, rect5, i13, i12, averageColorExtractor3);
            boolean z2 = z;
            rect = rect5;
            i7 = i12 + 2;
            i8 = i13 + 10;
            if (i7 >= 12 || averageColor2 != edgeColor) {
                break;
            }
            expandableDrawable = this;
            averageColorExtractor3 = averageColorExtractor;
            z = z2;
            rect5 = rect;
            i12 = i7;
            i13 = i8;
            i11 = i;
        }
        ExpandEdgeColorInfo multipleEdgeColors = getMultipleEdgeColors(i, edgeColor, i2, f, rect3, averageColorExtractor2);
        Log.i(this.TAG, "calcExpandEdgeColorInfo: direction=" + getDirectionName(i) + ", edgeColor=" + Integer.toHexString(edgeColor) + " from: " + rect + ", edgeColors=" + multipleEdgeColors + ", threshold:" + i7 + ", sampleCount:" + i8);
        return multipleEdgeColors;
    }

    private double calculateColorDistance(@NonNull double[] dArr, @NonNull double[] dArr2) {
        double d = dArr[0] - dArr2[0];
        double d2 = dArr[1] - dArr2[1];
        double d3 = dArr[2] - dArr2[2];
        return (d3 * d3) + (d2 * d2) + (2.0d * d * d);
    }

    private void calculateOverlapDepthMaxRect(int i, int i2, int i4, @NonNull ExpandTuneData expandTuneData, @NonNull RectF rectF) {
    }

    private void clearAllEdgeColorCache() {
        for (int i = 0; i < 4; i++) {
            ExpandEdgeColorInfo expandEdgeColorInfo = this.mState.getExpandEdgeColorInfo(i);
            if (expandEdgeColorInfo != null) {
                expandEdgeColorInfo.clear();
            }
        }
    }

    private void drawDebugRects(Canvas canvas, RectF rectF, boolean[] zArr) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawHWInner(@NonNull Canvas canvas) throws Throwable {
        Image imageAcquireNextImage;
        ImageReader imageReaderNewInstance;
        RenderNode renderNodeM5853B;
        HardwareRenderer hardwareRendererM5860e;
        HardwareBuffer hardwareBuffer;
        if (!RENDER_NODE_BLUR_SUPPORTED) {
            Log.e(this.TAG, "drawHWInner: unsupported");
            return;
        }
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        Matrix matrix = canvas.getMatrix();
        HardwareBuffer hardwareBuffer2 = null;
        try {
            imageReaderNewInstance = ImageReader.newInstance(canvas.getWidth(), canvas.getHeight(), 1, 1, 768L);
        } catch (Exception e) {
            e = e;
            imageAcquireNextImage = null;
            imageReaderNewInstance = null;
            renderNodeM5853B = null;
        } catch (Throwable th) {
            th = th;
            imageAcquireNextImage = null;
            imageReaderNewInstance = null;
            renderNodeM5853B = null;
        }
        try {
            AbstractC7448b.m5869n();
            renderNodeM5853B = AbstractC7448b.m5853B();
            try {
                AbstractC7448b.m5855D();
                hardwareRendererM5860e = AbstractC7448b.m5860e();
                try {
                    hardwareRendererM5860e.setSurface(imageReaderNewInstance.getSurface());
                    hardwareRendererM5860e.setContentRoot(renderNodeM5853B);
                    renderNodeM5853B.setPosition(0, 0, imageReaderNewInstance.getWidth(), imageReaderNewInstance.getHeight());
                    RecordingCanvas recordingCanvasBeginRecording = renderNodeM5853B.beginRecording();
                    recordingCanvasBeginRecording.setMatrix(matrix);
                    drawInner(recordingCanvasBeginRecording);
                    renderNodeM5853B.endRecording();
                    hardwareRendererM5860e.createRenderRequest().setWaitForPresent(true).syncAndDraw();
                    imageAcquireNextImage = imageReaderNewInstance.acquireNextImage();
                    Objects.requireNonNull(imageAcquireNextImage, "No Image");
                    try {
                        try {
                            hardwareBuffer = imageAcquireNextImage.getHardwareBuffer();
                            Objects.requireNonNull(hardwareBuffer, "No HardwareBuffer");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, null);
                        Objects.requireNonNull(bitmapWrapHardwareBuffer, "Null  HardwareBuffer hardwareBitmap");
                        int iSave = canvas.save();
                        canvas.setMatrix(null);
                        canvas.drawBitmap(bitmapWrapHardwareBuffer.copy(Bitmap.Config.ARGB_8888, false), 0.0f, 0.0f, (Paint) null);
                        canvas.restoreToCount(iSave);
                        long jElapsedRealtimeNanos2 = SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos;
                        Log.i(this.TAG, "drawHWInner: size: " + canvas.getWidth() + "x" + canvas.getHeight() + " took" + jElapsedRealtimeNanos2 + "ns ");
                        hardwareBuffer.close();
                        imageAcquireNextImage.close();
                        imageReaderNewInstance.close();
                        renderNodeM5853B.discardDisplayList();
                        hardwareRendererM5860e.destroy();
                    } catch (Exception e3) {
                        e = e3;
                        hardwareBuffer2 = hardwareBuffer;
                        Log.e(this.TAG, "drawHWInner failed: " + e.getMessage(), e);
                        if (hardwareBuffer2 != null) {
                            hardwareBuffer2.close();
                        }
                        if (imageAcquireNextImage != null) {
                            imageAcquireNextImage.close();
                        }
                        if (imageReaderNewInstance != null) {
                            imageReaderNewInstance.close();
                        }
                        if (renderNodeM5853B != null) {
                            renderNodeM5853B.discardDisplayList();
                        }
                        if (hardwareRendererM5860e == 0) {
                            hardwareRendererM5860e.destroy();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        hardwareBuffer2 = hardwareBuffer;
                        if (hardwareBuffer2 != null) {
                            hardwareBuffer2.close();
                        }
                        if (imageAcquireNextImage != null) {
                            imageAcquireNextImage.close();
                        }
                        if (imageReaderNewInstance != null) {
                            imageReaderNewInstance.close();
                        }
                        if (renderNodeM5853B != null) {
                            renderNodeM5853B.discardDisplayList();
                        }
                        if (hardwareRendererM5860e != 0) {
                            hardwareRendererM5860e.destroy();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    imageAcquireNextImage = null;
                } catch (Throwable th4) {
                    th = th4;
                    imageAcquireNextImage = null;
                }
            } catch (Exception e6) {
                e = e6;
                imageAcquireNextImage = null;
                hardwareRendererM5860e = 0;
            } catch (Throwable th5) {
                th = th5;
                imageAcquireNextImage = null;
                hardwareRendererM5860e = 0;
            }
        } catch (Exception e7) {
            e = e7;
            imageAcquireNextImage = null;
            renderNodeM5853B = null;
            hardwareRendererM5860e = renderNodeM5853B;
            Log.e(this.TAG, "drawHWInner failed: " + e.getMessage(), e);
            if (hardwareBuffer2 != null) {
            }
            if (imageAcquireNextImage != null) {
            }
            if (imageReaderNewInstance != null) {
            }
            if (renderNodeM5853B != null) {
            }
            if (hardwareRendererM5860e == 0) {
            }
        } catch (Throwable th6) {
            th = th6;
            imageAcquireNextImage = null;
            renderNodeM5853B = null;
            hardwareRendererM5860e = renderNodeM5853B;
            if (hardwareBuffer2 != null) {
            }
            if (imageAcquireNextImage != null) {
            }
            if (imageReaderNewInstance != null) {
            }
            if (renderNodeM5853B != null) {
            }
            if (hardwareRendererM5860e != 0) {
            }
            throw th;
        }
    }

    private void drawInner(@NonNull Canvas canvas) throws Throwable {
        ExpandableDrawable expandableDrawable;
        long jNanoTime = System.nanoTime();
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        ExpandableConstantState expandableConstantState = this.mState;
        Drawable originalDrawable = expandableConstantState.getOriginalDrawable();
        if (originalDrawable == null) {
            return;
        }
        ExpandTuneData tuneData = getTuneData();
        Rect bounds = getBounds();
        originalDrawable.setBounds(bounds);
        originalDrawable.draw(canvas);
        Matrix matrix = canvas.getMatrix();
        if (RENDER_NODE_BLUR_SUPPORTED) {
            updateBlurredBitmapShaderMatrix(matrix);
        }
        ExpandTuneData expandTuneData = expandableConstantState.getExpandTuneData();
        if (expandableConstantState.getExtractedBitmapWidth() <= 0 || expandableConstantState.getExtractedBitmapHeight() <= 0) {
            expandableDrawable = this;
        } else {
            boolean zIsIdentity = matrix.isIdentity();
            int iSave = !zIsIdentity ? canvas.save() : -1;
            if (zIsIdentity) {
                this.mImageBoundsInView.set(bounds);
            } else {
                this.mTempBoundsRectF.set(bounds);
                matrix.mapRect(this.mImageBoundsInView, this.mTempBoundsRectF);
                canvas.setMatrix(null);
            }
            this.mNeedsColorAnalysis = expandTuneData.mNeedInvalidate;
            performColorAnalysis(originalDrawable);
            this.mNeedsUpdateShaders = (!this.mNeedsUpdateShaders && this.mCanvasWidth == width && this.mCanvasHeight == height) ? false : true;
            this.mCanvasWidth = width;
            this.mCanvasHeight = height;
            expandableDrawable = this;
            expandableDrawable.drawOutpaintingEffects(canvas, width, height, tuneData, this.mBlurredBitmapShader);
            expandTuneData.mNeedInvalidate = false;
            if (!zIsIdentity) {
                canvas.restoreToCount(iSave);
            }
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        Log.i(expandableDrawable.TAG, "draw: took " + jNanoTime2 + VPathDataCmd.NoStroke);
    }

    private void drawOutpaintingEffects(@NonNull Canvas canvas, int i, int i2, @NonNull ExpandTuneData expandTuneData, BitmapShader bitmapShader) {
        int i4;
        RectF rectF;
        ExpandableDrawable expandableDrawable;
        RectF rectF2;
        int i5;
        RectF rectF3;
        int i6;
        ExpandableDrawable expandableDrawable2;
        RectF rectF4 = this.mImageBoundsInView;
        RectF rectF5 = this.mTempOutpaintingRectF;
        RectF rectF6 = this.mTempOverlapRectF;
        RectF rectF7 = this.mTempOutpaintingShaderRectF;
        int i7 = (int) (rectF4.left - 0.5f);
        int i8 = (int) (rectF4.top - 0.5f);
        int i9 = (int) (rectF4.right + 0.5f);
        int i10 = (int) (rectF4.bottom + 0.5f);
        int i11 = i8 > 0 ? 1 : 0;
        int i12 = i11;
        boolean z = i10 < i2 && (i12 = i12 + 1) > 0;
        boolean z2 = i7 > 0 && (i12 = i12 + 1) > 0;
        boolean z3 = i9 < i && (i12 = i12 + 1) > 0;
        if (i12 == 0) {
            this.mNeedsUpdateShaders = false;
            return;
        }
        ExpandEdgeColorInfo[] allEdgeColorInfos = this.mState.getExpandAnalysisData().getAllEdgeColorInfos();
        float maxOutpaintingTransitionDepth = expandTuneData.getMaxOutpaintingTransitionDepth();
        float fMax = maxOutpaintingTransitionDepth * Math.max(i, i2);
        float f = maxOutpaintingTransitionDepth * 100.0f;
        if (i11 != 0) {
            ExpandEdgeColorInfo expandEdgeColorInfo = allEdgeColorInfos[0];
            float maxColorDistance = this.mState.getExpandEdgeColorInfo(0).getMaxColorDistance() * f;
            if (i8 < fMax) {
                float f4 = i8;
                float f5 = i;
                rectF5.set(0.0f, f4 - fMax, f5, f4);
                rectF7.set(0.0f, f4 - maxColorDistance, f5, f4);
            } else {
                float f6 = i;
                float f7 = i8;
                rectF5.set(0.0f, 0.0f, f6, f7);
                rectF7.set(0.0f, f7 - maxColorDistance, f6, f7);
            }
            getOverlapRectF(0, expandTuneData, expandEdgeColorInfo.isSolidColor(), rectF4, i, i2, rectF6);
            i4 = i2;
            i5 = i;
            drawUnifiedGradientOutpainting(0, canvas, expandTuneData, expandEdgeColorInfo, bitmapShader, rectF5, rectF6, rectF7, rectF4);
            expandableDrawable = this;
            rectF2 = rectF7;
            rectF5 = rectF5;
            rectF = rectF6;
        } else {
            i4 = i2;
            rectF = rectF6;
            expandableDrawable = this;
            rectF2 = rectF7;
            i5 = i;
        }
        if (z) {
            ExpandEdgeColorInfo expandEdgeColorInfo2 = allEdgeColorInfos[1];
            float maxColorDistance2 = expandableDrawable.mState.getExpandEdgeColorInfo(1).getMaxColorDistance() * f;
            if (i4 - i10 < fMax) {
                float f8 = i10;
                float f9 = i5;
                rectF5.set(0.0f, f8, f9, f8 + fMax);
                rectF2.set(0.0f, f8, f9, maxColorDistance2 + f8);
            } else {
                float f10 = i10;
                float f11 = i5;
                rectF5.set(0.0f, f10, f11, i4);
                rectF2.set(0.0f, f10, f11, maxColorDistance2 + f10);
            }
            RectF rectF8 = rectF2;
            getOverlapRectF(1, expandTuneData, expandEdgeColorInfo2.isSolidColor(), rectF4, i5, i4, rectF);
            ExpandableDrawable expandableDrawable3 = expandableDrawable;
            RectF rectF9 = rectF;
            RectF rectF10 = rectF5;
            rectF4 = rectF4;
            expandableDrawable3.drawUnifiedGradientOutpainting(1, canvas, expandTuneData, expandEdgeColorInfo2, bitmapShader, rectF10, rectF9, rectF8, rectF4);
            rectF3 = rectF8;
            rectF5 = rectF10;
            rectF = rectF9;
            expandableDrawable = expandableDrawable3;
        } else {
            rectF3 = rectF2;
        }
        if (z2) {
            ExpandEdgeColorInfo expandEdgeColorInfo3 = allEdgeColorInfos[2];
            float maxColorDistance3 = expandableDrawable.mState.getExpandEdgeColorInfo(2).getMaxColorDistance() * f;
            if (i7 < fMax) {
                float f12 = i7;
                float f13 = i4;
                rectF5.set(f12 - fMax, 0.0f, f12, f13);
                rectF3.set(f12 - maxColorDistance3, 0.0f, f12, f13);
            } else {
                float f14 = i7;
                float f15 = i4;
                rectF5.set(0.0f, 0.0f, f14, f15);
                rectF3.set(f14 - maxColorDistance3, 0.0f, f14, f15);
            }
            getOverlapRectF(2, expandTuneData, expandEdgeColorInfo3.isSolidColor(), rectF4, i, i4, rectF);
            i6 = i;
            ExpandableDrawable expandableDrawable4 = expandableDrawable;
            RectF rectF11 = rectF;
            RectF rectF12 = rectF5;
            expandableDrawable4.drawUnifiedGradientOutpainting(2, canvas, expandTuneData, expandEdgeColorInfo3, bitmapShader, rectF12, rectF11, rectF3, rectF4);
            rectF5 = rectF12;
            rectF = rectF11;
            expandableDrawable = expandableDrawable4;
        } else {
            i6 = i;
        }
        if (z3) {
            ExpandEdgeColorInfo expandEdgeColorInfo4 = allEdgeColorInfos[3];
            float maxColorDistance4 = f * expandableDrawable.mState.getExpandEdgeColorInfo(3).getMaxColorDistance();
            if (i6 - i9 < fMax) {
                float f16 = i9;
                float f17 = i4;
                rectF5.set(f16, 0.0f, f16 + fMax, f17);
                rectF3.set(f16, 0.0f, f16 + maxColorDistance4, f17);
            } else {
                float f18 = i9;
                float f19 = i4;
                rectF5.set(f18, 0.0f, i6, f19);
                rectF3.set(f18, 0.0f, f18 + maxColorDistance4, f19);
            }
            getOverlapRectF(3, expandTuneData, expandEdgeColorInfo4.isSolidColor(), rectF4, i6, i4, rectF);
            expandableDrawable2 = expandableDrawable;
            expandableDrawable2.drawUnifiedGradientOutpainting(3, canvas, expandTuneData, expandEdgeColorInfo4, bitmapShader, rectF5, rectF, rectF3, rectF4);
        } else {
            expandableDrawable2 = expandableDrawable;
        }
        expandableDrawable2.mNeedsUpdateShaders = false;
    }

    private void drawUnifiedGradientOutpainting(int i, @NonNull Canvas canvas, @NonNull ExpandTuneData expandTuneData, @NonNull ExpandEdgeColorInfo expandEdgeColorInfo, @Nullable BitmapShader bitmapShader, @NonNull RectF rectF, @NonNull RectF rectF2, @NonNull RectF rectF3, @NonNull RectF rectF4) {
        if (expandEdgeColorInfo != null && expandEdgeColorInfo.isValid()) {
            rectF.union(rectF2);
            ExpandDrawInfo expandDrawInfo = this.mGradientCaches[i];
            expandDrawInfo.updateShaders(canvas, i, expandEdgeColorInfo, expandTuneData, rectF3, rectF2, rectF4, this.mNeedsUpdateShaders, bitmapShader, this.mCanvasWidth, this.mCanvasHeight);
            canvas.drawRect(rectF, expandDrawInfo.getPaint());
            return;
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("drawUnifiedGradientOutpainting() skipped with: direction = [");
        sb.append(i);
        sb.append("], outpaintingRectF = [");
        sb.append(rectF);
        sb.append("], imageBoundsInViewRectF = [");
        sb.append(rectF4);
        sb.append("], edgeColorInfo.valid: ");
        sb.append(expandEdgeColorInfo != null && expandEdgeColorInfo.isValid());
        Log.e(str, sb.toString());
    }

    private Bitmap getBlurredBitmap(@NonNull Drawable drawable) {
        Bitmap bitmap;
        ExpandTuneData tuneData = getTuneData();
        float bitmapShaderScale = tuneData.getBitmapShaderScale();
        Rect bounds = drawable.getBounds();
        int i = bounds.left;
        int i2 = bounds.top;
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (bounds.isEmpty()) {
            if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                iWidth = drawable.getIntrinsicWidth();
                iHeight = drawable.getIntrinsicHeight();
            } else {
                int width = bitmap.getWidth();
                iHeight = bitmap.getHeight();
                iWidth = width;
            }
            i = 0;
            drawable.setBounds(0, 0, iWidth, iHeight);
            i2 = 0;
        }
        float f = (bitmapShaderScale * 1000.0f) / (iWidth > iHeight ? iWidth : iHeight);
        int i4 = (int) (iWidth * f);
        int i5 = (int) (iHeight * f);
        this.mBlurredBitmapWidth = i4;
        this.mBlurredBitmapHeight = i5;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(f, f);
        canvas.translate(-i, -i2);
        drawable.draw(canvas);
        float blurRadius = tuneData.getBlurRadius();
        if (blurRadius <= 0.0f || !RENDER_NODE_BLUR_SUPPORTED) {
            return null;
        }
        try {
            return applyHardwareBlur(bitmapCreateBitmap, blurRadius);
        } catch (Exception e) {
            Log.w(this.TAG, "updateBitmapShader: Failed to apply HardwareRenderer blur, using original bitmap: " + e.getMessage());
            return null;
        }
    }

    @NonNull
    private String getDirectionName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "RIGHT" : "LEFT" : "BOTTOM" : AbstractBottomUpParser.TOP_NODE;
    }

    private int getEdgeColor(int i, boolean z, @NonNull Rect rect, int i2, int i4, AverageColorExtractor averageColorExtractor) {
        int i5;
        int i6;
        long jNanoTime = System.nanoTime();
        int iWidth = rect.width();
        int iHeight = rect.height();
        int iMin = Math.min(i2, z ? iWidth : iHeight);
        if (iMin < 1) {
            throw new IllegalArgumentException("count is too small " + i2 + "/ " + rect);
        }
        float f = 1.0f / iMin;
        Rect[] rectArr = new Rect[iMin];
        int i7 = rect.left;
        int i8 = rect.top;
        int i9 = rect.right;
        int i10 = rect.bottom;
        if (z) {
            float f4 = iWidth * f;
            int i11 = ((int) (f4 + 0.5f)) + i7;
            int i12 = i7;
            int i13 = 0;
            while (i13 < iMin) {
                rectArr[i13] = new Rect(i12, i8, i11, i10);
                int i14 = ((int) (((i13 + 2) * f4) + 0.5f)) + i7;
                i13++;
                i12 = i11;
                i11 = i14;
            }
            i5 = 0;
        } else {
            i5 = 0;
            float f5 = iHeight * f;
            int i15 = ((int) (f5 + 0.5f)) + i8;
            int i16 = i8;
            int i17 = 0;
            while (i17 < iMin) {
                rectArr[i17] = new Rect(i7, i16, i9, i15);
                int i18 = ((int) (((i17 + 2) * f5) + 0.5f)) + i8;
                i17++;
                i16 = i15;
                i15 = i18;
            }
        }
        int[][] averageRGBColors = averageColorExtractor.getAverageRGBColors(rectArr);
        if (averageRGBColors == null || averageRGBColors.length != iMin) {
            Log.e(this.TAG, "getEdgeColor: averageRGBs failed");
            return -16777216;
        }
        int[] iArr = averageRGBColors[i5];
        double[] lABFastRGB = ColorConverter.getLABFastRGB(iArr[i5], iArr[1], iArr[2]);
        ArrayList arrayList = new ArrayList();
        EdgeColorGroup edgeColorGroup = new EdgeColorGroup(0, lABFastRGB[i5], lABFastRGB[1], lABFastRGB[2]);
        arrayList.add(edgeColorGroup);
        int i19 = 1;
        while (i19 < iMin) {
            int[] iArr2 = averageRGBColors[i19];
            double[] lABFastRGB2 = ColorConverter.getLABFastRGB(iArr2[i5], iArr2[1], iArr2[2]);
            double d = lABFastRGB2[i5];
            double d2 = lABFastRGB2[1];
            double d3 = lABFastRGB2[2];
            if (edgeColorGroup.isSameGroup(i4, d, d2, d3)) {
                i6 = i19;
                edgeColorGroup.add(i6, d, d2, d3);
            } else {
                int i20 = i19;
                EdgeColorGroup edgeColorGroup2 = new EdgeColorGroup(i20, d, d2, d3);
                i6 = i20;
                arrayList.add(edgeColorGroup2);
                edgeColorGroup = edgeColorGroup2;
            }
            i19 = i6 + 1;
        }
        final float f6 = i2 * 0.1f;
        arrayList.sort(new Comparator() { // from class: com.samsung.android.sesl.extendImage.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ExpandableDrawable.lambda$getEdgeColor$0(f6, (ExpandableDrawable.EdgeColorGroup) obj, (ExpandableDrawable.EdgeColorGroup) obj2);
            }
        });
        int iMin2 = Math.min(arrayList.size(), 20);
        for (int i21 = i5; i21 < iMin2; i21++) {
            EdgeColorGroup edgeColorGroup3 = (EdgeColorGroup) arrayList.get(i21);
            Log.i(this.TAG, "getEdgeColor:" + getDirectionName(i) + " [" + i21 + " / " + arrayList.size() + "]" + edgeColorGroup3);
        }
        EdgeColorGroup edgeColorGroup4 = (EdgeColorGroup) arrayList.get(i5);
        Rect rect2 = new Rect();
        if (edgeColorGroup4.length() < f6) {
            rect2.set(rect);
        } else {
            rect2.set(rectArr[edgeColorGroup4.getStart()]);
            rect2.union(rectArr[edgeColorGroup4.getEnd()]);
        }
        int averageColor = averageColorExtractor.getAverageColor(rect2);
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("getEdgeColor: ");
        sb.append(getDirectionName(i));
        sb.append(" #");
        sb.append(Integer.toHexString(averageColor));
        sb.append(" Group: ");
        sb.append(edgeColorGroup4);
        sb.append(" took: ");
        sb.append(jNanoTime2);
        AbstractC11014a.m12338w(sb, VPathDataCmd.NoStroke, str);
        return averageColor;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ExpandEdgeColorInfo getMultipleEdgeColors(int i, int i2, int i4, float f, @NonNull Rect rect, @NonNull AverageColorExtractor averageColorExtractor) {
        double d;
        int[] iArr;
        float[] fArr;
        Rect[] rectArr;
        Rect rect2;
        int i5;
        double d2;
        float f4;
        boolean z;
        double lABSaturation;
        ExpandableDrawable expandableDrawable = this;
        int[] iArr2 = new int[i4];
        float[] fArr2 = new float[i4];
        Rect[] rectArr2 = new Rect[i4];
        float f5 = 1.0f / (i4 * 2);
        float f6 = i4;
        double[] lABFastRGB = ColorConverter.getLABFastRGB(i2);
        double d3 = lABFastRGB[0];
        double lABSaturation2 = ColorConverter.getLABSaturation(lABFastRGB[1], lABFastRGB[2]);
        float f7 = f6 - 2.0f;
        float fWidth = rect.width() / f7;
        float fHeight = rect.height() / f7;
        int iMax = Math.max(1, (int) fWidth);
        int i6 = iMax >> 1;
        int iMax2 = Math.max(1, (int) fHeight);
        int i7 = iMax2 >> 1;
        Rect rect3 = new Rect();
        if (isVertical(i)) {
            int i8 = 0;
            while (i8 < i4) {
                int i9 = (rect.left + ((int) (i8 * fWidth))) - i6;
                int i10 = i8;
                rectArr2[i10] = new Rect(i9, rect.top, Math.min(rect.right, i9 + iMax + i6), rect.bottom);
                i8 = i10 + 1;
                lABSaturation2 = lABSaturation2;
            }
            d = lABSaturation2;
        } else {
            d = lABSaturation2;
            int i11 = 0;
            while (i11 < i4) {
                int i12 = (rect.top + ((int) (i11 * fHeight))) - i7;
                rectArr2[i11] = new Rect(rect.left, i12, rect.right, Math.min(rect.bottom, i12 + iMax2 + i7));
                i11++;
                iMax2 = iMax2;
            }
        }
        float f8 = 1.0f / f6;
        double d4 = f * f * 1.44f;
        float f9 = (float) (((double) f) * (((1.0d - d) * 1.100000023841858d) + 1.0d));
        double dMax = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i13 = 0;
        int i14 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        while (i13 < i4) {
            float[] fArr3 = fArr2;
            Rect rect4 = rectArr2[i13];
            double d7 = dMax;
            float f12 = (i13 * f8) + f5;
            if (rect4.isEmpty()) {
                Rect rect5 = rect3;
                rectArr = rectArr2;
                rect2 = rect5;
                i5 = i13;
                d2 = d4;
                dMax = d7;
                f4 = f8;
                iArr2[i5] = -7829368;
            } else {
                double[] lABFastRGB2 = ColorConverter.getLABFastRGB(averageColorExtractor.getAverageColor(rect4));
                i5 = i13;
                double dCalculateColorDistance = expandableDrawable.calculateColorDistance(lABFastRGB, lABFastRGB2);
                Rect rect6 = rect3;
                rectArr = rectArr2;
                rect2 = rect6;
                d2 = d4;
                f4 = f8;
                double[] dArrApplyAntiMoireCorrection = expandableDrawable.applyAntiMoireCorrection(lABFastRGB, lABFastRGB2, dCalculateColorDistance, f9);
                double d8 = dArrApplyAntiMoireCorrection[0];
                double d9 = dArrApplyAntiMoireCorrection[1];
                double d10 = dArrApplyAntiMoireCorrection[2];
                float fFastAngleDeg = ColorConverter.fastAngleDeg(d9, d10);
                double lABSaturation3 = ColorConverter.getLABSaturation(d9, d10);
                double dAbs = Math.abs(d5 - d8);
                double dAcuteAngle = ColorConverter.acuteAngle(fFastAngleDeg, f10);
                double dAbs2 = Math.abs(d6 - lABSaturation3);
                if (i14 <= 0) {
                    z = false;
                    if (i14 == 0 || !z) {
                        iArr2[i14] = ColorConverter.getRGBFromLAB(dArrApplyAntiMoireCorrection);
                        fArr3[i14] = f12;
                        i14++;
                        rect2 = new Rect(rect4);
                        f11 = f12;
                        f10 = fFastAngleDeg;
                        lABSaturation = lABSaturation3;
                    } else {
                        rect2.union(rect4);
                        double[] lABFastRGB3 = ColorConverter.getLABFastRGB(averageColorExtractor.getAverageColor(rect2, null));
                        double[] dArrApplyAntiMoireCorrection2 = expandableDrawable.applyAntiMoireCorrection(lABFastRGB, lABFastRGB3, expandableDrawable.calculateColorDistance(lABFastRGB, lABFastRGB3), f9);
                        double d11 = dArrApplyAntiMoireCorrection2[1];
                        double d12 = dArrApplyAntiMoireCorrection2[2];
                        d8 = dArrApplyAntiMoireCorrection2[0];
                        float fFastAngleDeg2 = ColorConverter.fastAngleDeg(d11, d12);
                        lABSaturation = ColorConverter.getLABSaturation(d11, d12);
                        int i15 = i14 - 1;
                        iArr2[i15] = ColorConverter.getRGBFromLAB(dArrApplyAntiMoireCorrection2);
                        fArr3[i15] = AbstractC0622a.m1155a(f12, f11, 2.0f, f11);
                        f10 = fFastAngleDeg2;
                    }
                    dMax = Math.max(d7, Math.abs(d3 - d8));
                    d6 = lABSaturation;
                    d5 = d8;
                } else {
                    if (dCalculateColorDistance <= d2) {
                        double d13 = f9;
                        if (dAbs <= d13) {
                            double d14 = 1.100000023841858d - lABSaturation3;
                            if (dAcuteAngle > 3.6d * d13 * d14 || dAbs2 > d13 * 1.24d * d14) {
                            }
                            if (i14 == 0) {
                                iArr2[i14] = ColorConverter.getRGBFromLAB(dArrApplyAntiMoireCorrection);
                                fArr3[i14] = f12;
                                i14++;
                                rect2 = new Rect(rect4);
                                f11 = f12;
                                f10 = fFastAngleDeg;
                                lABSaturation = lABSaturation3;
                                dMax = Math.max(d7, Math.abs(d3 - d8));
                                d6 = lABSaturation;
                                d5 = d8;
                            }
                        }
                    }
                    z = true;
                    if (i14 == 0) {
                    }
                }
            }
            i13 = i5 + 1;
            Rect[] rectArr3 = rectArr;
            rect3 = rect2;
            rectArr2 = rectArr3;
            expandableDrawable = this;
            fArr2 = fArr3;
            f8 = f4;
            d4 = d2;
        }
        float[] fArr4 = fArr2;
        double d15 = ((double) f9) * 1.5d;
        if (dMax > d15 && i4 > 3) {
            return getMultipleEdgeColors(i, i2, i4 / 2, f * 1.1f, rect, averageColorExtractor);
        }
        if (dMax > d15) {
            ExpandEdgeColorInfo expandEdgeColorInfo = new ExpandEdgeColorInfo();
            expandEdgeColorInfo.updateColorData(i2, new int[]{i2, ColorConverter.getRGBFromLAB(lABFastRGB)}, new float[]{0.0f, 1.0f});
            return expandEdgeColorInfo;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i14; i17++) {
            int i18 = iArr2[i17];
            if ((i18 >>> 24) != 0) {
                if (i16 != i17) {
                    iArr2[i16] = i18;
                    fArr4[i16] = fArr4[i17];
                }
                i16++;
            }
        }
        if (i16 == 0 || i14 <= 2) {
            Log.e(this.TAG, "getMultipleEdgeColors: no major colors, using fallback " + i16 + "/" + i14);
            iArr = new int[]{i2, i2};
            fArr = new float[]{0.0f, 1.0f};
        } else if (i16 < i4) {
            int[] iArr3 = new int[i16];
            float[] fArr5 = new float[i16];
            for (int i19 = 0; i19 < i16; i19++) {
                iArr3[i19] = iArr2[i19];
                fArr5[i19] = fArr4[i19];
            }
            iArr = iArr3;
            fArr = fArr5;
        } else {
            iArr = iArr2;
            fArr = fArr4;
        }
        Log.i(this.TAG, "getMultipleEdgeColors:  pos:" + Arrays.toString(fArr) + " " + ColorConverter.toHexString(iArr));
        ExpandEdgeColorInfo expandEdgeColorInfo2 = new ExpandEdgeColorInfo();
        expandEdgeColorInfo2.updateColorData(i2, iArr, fArr);
        return expandEdgeColorInfo2;
    }

    private static RectF getOverlapRectF(int i, @NonNull ExpandTuneData expandTuneData, boolean z, @NonNull RectF rectF, int i2, int i4, @Nullable RectF rectF2) {
        float f;
        float fAbs;
        float fAbs2;
        if (rectF2 == null) {
            rectF2 = new RectF();
        } else {
            rectF2.setEmpty();
        }
        float overlapDepthRatioMax = z ? expandTuneData.getOverlapDepthRatioMax() / 3.0f : expandTuneData.getOverlapDepthRatioMax();
        float overlapDepthRatio = expandTuneData.getOverlapDepthRatio();
        if (i == 0) {
            f = overlapDepthRatioMax * i4;
            fAbs = Math.abs(rectF.top) * overlapDepthRatio;
            fAbs2 = Math.abs(rectF.height());
        } else if (i == 1) {
            float f4 = i4;
            f = overlapDepthRatioMax * f4;
            fAbs = Math.abs(f4 - rectF.bottom) * overlapDepthRatio;
            fAbs2 = Math.abs(rectF.height());
        } else if (i == 2) {
            f = overlapDepthRatioMax * i2;
            fAbs = Math.abs(rectF.left) * overlapDepthRatio;
            fAbs2 = Math.abs(rectF.width());
        } else {
            if (i != 3) {
                throw new IllegalStateException(AbstractC0000a.m11h(i, "Unexpected direction: "));
            }
            float f5 = i2;
            f = overlapDepthRatioMax * f5;
            fAbs = Math.abs(f5 - rectF.right) * overlapDepthRatio;
            fAbs2 = Math.abs(rectF.width());
        }
        float fMin = Math.min(Math.min(fAbs * fAbs, f), fAbs2);
        if (i == 0) {
            float f6 = rectF.left;
            float f7 = rectF.top;
            rectF2.set(f6, f7, rectF.right, fMin + f7);
            return rectF2;
        }
        if (i == 1) {
            float f8 = rectF.left;
            float f9 = rectF.bottom;
            rectF2.set(f8, f9 - fMin, rectF.right, f9);
            return rectF2;
        }
        if (i == 2) {
            float f10 = rectF.left;
            rectF2.set(f10, rectF.top, fMin + f10, rectF.bottom);
            return rectF2;
        }
        if (i != 3) {
            return rectF2;
        }
        float f11 = rectF.right;
        rectF2.set(f11 - fMin, rectF.top, f11, rectF.bottom);
        return rectF2;
    }

    @NonNull
    private int[] getTestColors(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? new int[]{VUtilString.GRAY, VUtilString.GRAY, VUtilString.GRAY} : new int[]{VUtilString.CYAN, -65536, -256} : new int[]{VUtilString.MAGENTA, -16776961, VUtilString.GREEN} : new int[]{-256, VUtilString.MAGENTA, VUtilString.CYAN} : new int[]{-65536, VUtilString.GREEN, -16776961};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getTransparentColor(int i, int i2) {
        return (i & 16777215) | (Math.min(255, Math.max(0, i2)) << 24);
    }

    private void init() {
        for (int i = 0; i < 4; i++) {
            this.mGradientCaches[i] = new ExpandDrawInfo();
        }
    }

    private void invalidateColorAnalysis() {
        this.mNeedsColorAnalysis = true;
        Log.d(this.TAG, "Color analysis invalidated");
    }

    private void invalidateGradientCaches() {
        for (ExpandDrawInfo expandDrawInfo : this.mGradientCaches) {
            expandDrawInfo.invalidate();
        }
    }

    private boolean isSolidEdgeColor(boolean z, @NonNull Rect rect, int i, int i2, @NonNull AverageColorExtractor averageColorExtractor) {
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        int iWidth = rect.width();
        int iHeight = rect.height();
        int iMin = Math.min(i2, z ? iWidth : iHeight);
        if (iMin < 1) {
            throw new IllegalArgumentException("count is too small " + i2 + "/ " + rect);
        }
        float f = 1.0f / iMin;
        Rect[] rectArr = new Rect[iMin];
        int i4 = rect.left;
        int i5 = rect.top;
        int i6 = rect.right;
        int i7 = rect.bottom;
        if (z) {
            float fMax = Math.max(1.0f, iWidth * f);
            int i8 = ((int) (fMax + 0.5f)) + i4;
            int i9 = i4;
            int i10 = 0;
            while (i10 < iMin) {
                rectArr[i10] = new Rect(i9, i5, i8, i7);
                int i11 = ((int) (((i10 + 2) * fMax) + 0.5f)) + i4;
                i10++;
                i9 = i8;
                i8 = i11;
            }
        } else {
            float fMax2 = Math.max(1.0f, iHeight * f);
            int i12 = ((int) (fMax2 + 0.5f)) + i5;
            int i13 = i5;
            int i14 = 0;
            while (i14 < iMin) {
                rectArr[i14] = new Rect(i4, i13, i6, i12);
                int i15 = ((int) (((i14 + 2) * fMax2) + 0.5f)) + i5;
                i14++;
                i13 = i12;
                i12 = i15;
            }
        }
        int[][] averageRGBColors = averageColorExtractor.getAverageRGBColors(rectArr);
        if (averageRGBColors == null || averageRGBColors.length != iMin) {
            Log.e(this.TAG, "isSolidEdgeColor: averageRGBs failed");
            return false;
        }
        int length = averageRGBColors.length;
        for (int i16 = 0; i16 < length; i16++) {
            int[] iArr = averageRGBColors[i16];
            int i17 = iRed - iArr[0];
            int i18 = iGreen - iArr[1];
            int i19 = iBlue - iArr[2];
            if (i17 > 10 || i17 < -10 || i18 > 10 || i18 < -10 || i19 > 10 || i19 < -10) {
                String str = this.TAG;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i17, i18, "isSolidEdgeColor: false:", SQLKeyword.COMMA, SQLKeyword.COMMA);
                AbstractC2821a.m2235z(sbM1173s, i19, iRed, " avg: ", "/");
                AbstractC2821a.m2235z(sbM1173s, iGreen, iBlue, "/", " area: ");
                sbM1173s.append(iArr[0]);
                sbM1173s.append("/");
                sbM1173s.append(iArr[1]);
                sbM1173s.append("/");
                sbM1173s.append(iArr[2]);
                sbM1173s.append(rectArr[i16]);
                Log.i(str, sbM1173s.toString());
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isVertical(int i) {
        return i == 0 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getEdgeColor$0(float f, EdgeColorGroup edgeColorGroup, EdgeColorGroup edgeColorGroup2) {
        int length = edgeColorGroup.length();
        int length2 = edgeColorGroup2.length();
        boolean z = ((float) length) >= f;
        return z != (((float) length2) >= f) ? z ? -1 : 1 : z ? Double.compare(edgeColorGroup.getWeight(), edgeColorGroup2.getWeight()) : Integer.compare(length2, length);
    }

    private void performColorAnalysis(Drawable drawable) throws Throwable {
        boolean z;
        AverageColorExtractor averageColorExtractor;
        AverageColorExtractor averageColorExtractor2;
        Bitmap blurredBitmap;
        ExpandableDrawable expandableDrawable = this;
        if (!expandableDrawable.mNeedsColorAnalysis || expandableDrawable.mIsAnalyzing || drawable == null) {
            return;
        }
        ExpandTuneData expandTuneData = expandableDrawable.mState.getExpandTuneData();
        long jNanoTime = System.nanoTime();
        expandableDrawable.mIsAnalyzing = true;
        Log.d(expandableDrawable.TAG, "Starting one-time color analysis for all directions");
        expandableDrawable.clearAllEdgeColorCache();
        AverageColorExtractor averageColorExtractor3 = null;
        try {
            try {
                averageColorExtractor = new AverageColorExtractor(drawable);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!RENDER_NODE_BLUR_SUPPORTED || expandTuneData.getBlurRadius() <= 0.0f || (blurredBitmap = getBlurredBitmap(drawable)) == null) {
                expandableDrawable.mBlurredBitmapShader = null;
                averageColorExtractor2 = averageColorExtractor;
            } else {
                expandableDrawable.updateBlurredBitmapShader(blurredBitmap);
                averageColorExtractor2 = new AverageColorExtractor(blurredBitmap.copy(Bitmap.Config.ARGB_8888, false));
            }
            int originalWidth = averageColorExtractor.getOriginalWidth();
            int originalHeight = averageColorExtractor.getOriginalHeight();
            int originalWidth2 = averageColorExtractor2.getOriginalWidth();
            int originalHeight2 = averageColorExtractor2.getOriginalHeight();
            expandableDrawable.mState.setExtractedBitmapSize(originalWidth, originalHeight);
            float sampleLGap = expandTuneData.getSampleLGap();
            int gradientSampleCount = expandTuneData.getGradientSampleCount();
            int i = (int) ((originalHeight / originalWidth) * gradientSampleCount);
            int iMin = Math.min(originalWidth, originalHeight);
            int iMax = Math.max(1, Math.round(Math.min(originalWidth2, originalHeight2) * expandTuneData.getGradientAnalysisRatio()));
            int iMax2 = Math.max(1, Math.round(iMin * expandTuneData.getEdgeAnalysisRatio()));
            expandableDrawable.analyzeDirectionColors(0, sampleLGap, gradientSampleCount, iMax, iMax2, averageColorExtractor, averageColorExtractor2);
            analyzeDirectionColors(1, sampleLGap, gradientSampleCount, iMax, iMax2, averageColorExtractor, averageColorExtractor2);
            analyzeDirectionColors(2, sampleLGap, i, iMax, iMax2, averageColorExtractor, averageColorExtractor2);
            expandableDrawable = this;
            expandableDrawable.analyzeDirectionColors(3, sampleLGap, i, iMax, iMax2, averageColorExtractor, averageColorExtractor2);
            z = false;
            expandableDrawable.mNeedsColorAnalysis = false;
            Log.d(expandableDrawable.TAG, "Color analysis completed for all directions");
            averageColorExtractor.cleanup();
        } catch (Exception e2) {
            e = e2;
            averageColorExtractor3 = averageColorExtractor;
            Log.e(expandableDrawable.TAG, "Failed to perform color analysis", e);
            if (averageColorExtractor3 != null) {
                averageColorExtractor3.cleanup();
            }
            z = false;
        } catch (Throwable th2) {
            th = th2;
            averageColorExtractor3 = averageColorExtractor;
            if (averageColorExtractor3 != null) {
                averageColorExtractor3.cleanup();
            }
            expandableDrawable.mIsAnalyzing = false;
            expandableDrawable.mNeedsUpdateShaders = true;
            throw th;
        }
        expandableDrawable.mIsAnalyzing = z;
        expandableDrawable.mNeedsUpdateShaders = true;
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        Log.i(expandableDrawable.TAG, "performColorAnalysis: took " + jNanoTime2 + VPathDataCmd.NoStroke);
    }

    private void updateBlurredBitmapShader(@NonNull Drawable drawable) {
        if (getTuneData().getBlurRadius() <= 0.0f || !RENDER_NODE_BLUR_SUPPORTED) {
            this.mBlurredBitmapShader = null;
            return;
        }
        try {
            Bitmap blurredBitmap = getBlurredBitmap(drawable);
            if (blurredBitmap == null) {
                Log.w(this.TAG, "updateBitmapShader: null bitmap ");
            } else {
                updateBlurredBitmapShader(blurredBitmap);
            }
        } catch (Exception e) {
            Log.w(this.TAG, "updateBitmapShader: Failed to apply HardwareRenderer blur, using original bitmap: " + e.getMessage());
        }
    }

    private void updateBlurredBitmapShaderMatrix(Matrix matrix) {
        Rect bounds = getBounds();
        int i = this.mBlurredBitmapWidth;
        float fWidth = bounds.width() / i;
        float fHeight = bounds.height() / this.mBlurredBitmapHeight;
        this.mBlurredBitmapShaderMatrix.reset();
        this.mBlurredBitmapShaderMatrix.postScale(fWidth, fHeight);
        this.mBlurredBitmapShaderMatrix.postTranslate(bounds.left, bounds.top);
        this.mBlurredBitmapShaderMatrix.postConcat(matrix);
        BitmapShader bitmapShader = this.mBlurredBitmapShader;
        if (bitmapShader != null) {
            bitmapShader.setLocalMatrix(this.mBlurredBitmapShaderMatrix);
        }
    }

    public static ExpandableDrawable wrap(Drawable drawable) {
        return drawable instanceof ExpandableDrawable ? (ExpandableDrawable) drawable : new ExpandableDrawable(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(@NonNull Resources.Theme theme) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        return originalDrawable != null && originalDrawable.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.clearColorFilter();
        }
    }

    public void clearGradientCaches() {
        invalidateGradientCaches();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) throws Throwable {
        if (canvas.isHardwareAccelerated() || !RENDER_NODE_BLUR_SUPPORTED) {
            drawInner(canvas);
        } else {
            drawHWInner(canvas);
        }
    }

    @NonNull
    public Bitmap getBitmap(int i, int i2, @Nullable Matrix matrix) throws Throwable {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (matrix != null) {
            canvas.setMatrix(matrix);
        }
        draw(canvas);
        return bitmapCreateBitmap;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getBitmapShaderScale() {
        return this.mState.getExpandTuneData().getBitmapShaderScale();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getBlurRadius() {
        return this.mState.getExpandTuneData().getBlurRadius();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            return originalDrawable.getChangingConfigurations();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            return originalDrawable.getColorFilter();
        }
        return null;
    }

    public String getCompressedAnalysisData() {
        return this.mState.getEdgeAnalysisData();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable.ConstantState getConstantState() {
        return this.mState;
    }

    @Nullable
    public Drawable getDrawable() {
        return this.mState.getOriginalDrawable();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getEdgeAnalysisRatio() {
        return this.mState.getExpandTuneData().getEdgeAnalysisRatio();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getGradientAnalysisRatio() {
        return this.mState.getExpandTuneData().getGradientAnalysisRatio();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getGradientSampleCount() {
        return this.mState.getExpandTuneData().getGradientSampleCount();
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            return originalDrawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            return originalDrawable.getIntrinsicWidth();
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getMaxOutpaintingTransitionDepth() {
        return this.mState.getExpandTuneData().getMaxOutpaintingTransitionDepth();
    }

    public float getMaxOverlapRatio() {
        return this.mState.mExpandTuneData.getOverlapDepthRatioMax();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            return originalDrawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Insets getOpticalInsets() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (Build.VERSION.SDK_INT >= 29) {
            return originalDrawable != null ? originalDrawable.getOpticalInsets() : Insets.NONE;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.getOutline(outline);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getOutpaintingAlphaCurve() {
        return this.mState.getExpandTuneData().getOutpaintingAlphaCurve();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getOverlapAlphaCurve() {
        return this.mState.getExpandTuneData().getOverlapAlphaCurve();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getOverlapDepthMax() {
        return this.mState.getExpandTuneData().getOverlapDepthRatioMax();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getOverlapDepthRatio() {
        return this.mState.getExpandTuneData().getOverlapDepthRatio();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        return originalDrawable != null && originalDrawable.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getSampleLGap() {
        return this.mState.getExpandTuneData().getSampleLGap();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public int[] getState() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        return originalDrawable != null ? originalDrawable.getState() : new int[0];
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            return originalDrawable.getTransparentRegion();
        }
        return null;
    }

    @NonNull
    public ExpandTuneData getTuneData() {
        return this.mState.mExpandTuneData;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        return originalDrawable != null && originalDrawable.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isFilterBitmap() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        return originalDrawable != null && originalDrawable.isFilterBitmap();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        return originalDrawable != null && originalDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.jumpToCurrentState();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void loadDebugTuneData(@NonNull Context context) {
        this.mState.mExpandTuneData.loadDebugValues(context);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!canApplyTheme() && this.mState.mChangingConfigurations == 0) {
            return this;
        }
        ExpandableDrawable expandableDrawable = new ExpandableDrawable(new ExpandableConstantState(this.mState));
        Drawable originalDrawable = expandableDrawable.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.mutate();
        }
        return expandableDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        this.mImageBoundsInView.set(rect);
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setBounds(rect);
        }
        invalidateGradientCaches();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void resetTuneDataToDefaults() {
        this.mState.mExpandTuneData.resetToDefaults();
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void saveDebugTuneData(@NonNull Context context) {
        this.mState.mExpandTuneData.saveDebugValues(context);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setAutoMirrored(z);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setBitmapShaderScale(float f) {
        this.mState.getExpandTuneData().setBitmapShaderScale(f);
        Drawable drawable = this.mState.mOriginalDrawable;
        if (drawable != null) {
            updateBlurredBitmapShader(drawable);
        }
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setBlurRadius(float f) {
        this.mState.getExpandTuneData().setBlurRadius(f);
        Drawable drawable = this.mState.mOriginalDrawable;
        if (drawable != null) {
            updateBlurredBitmapShader(drawable);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setChangingConfigurations(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setColorFilter(colorFilter);
        }
    }

    public void setDrawable(@Nullable Drawable drawable) {
        if (drawable != this.mState.getOriginalDrawable()) {
            this.mState.setOriginalDrawable(drawable);
            invalidateColorAnalysis();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeAnalysisRatio(float f) {
        this.mState.getExpandTuneData().setEdgeAnalysisRatio(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setFilterBitmap(z);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setGradientAnalysisRatio(float f) {
        this.mState.getExpandTuneData().setGradientAnalysisRatio(f);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setGradientSampleCount(int i) {
        this.mState.getExpandTuneData().setGradientSampleCount(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f4) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setHotspot(f, f4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i4, int i5) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setHotspotBounds(i, i2, i4, i5);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxOutpaintingTransitionDepth(float f) {
        this.mState.getExpandTuneData().setMaxOutpaintingTransitionDepth(f);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOutpaintingAlphaCurve(float f) {
        this.mState.getExpandTuneData().setOutpaintingAlphaCurve(f);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOverlapAlphaCurve(float f) {
        this.mState.getExpandTuneData().setOverlapAlphaCurve(f);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOverlapDepthMax(float f) {
        this.mState.getExpandTuneData().setOverlapDepthMax(f);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOverlapDepthRatio(float f) {
        this.mState.getExpandTuneData().setOverlapDepthRatio(f);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSampleLGap(float f) {
        this.mState.getExpandTuneData().setSampleLGap(f);
        invalidateColorAnalysis();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            return originalDrawable.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintBlendMode(@Nullable BlendMode blendMode) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        originalDrawable.setTintBlendMode(blendMode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable originalDrawable = this.mState.getOriginalDrawable();
        if (originalDrawable != null) {
            originalDrawable.setVisible(z, z2);
        }
        return visible;
    }

    public ExpandableDrawable(@NonNull Drawable drawable) throws Throwable {
        this.TAG = "ExpandableDrawable" + hashCode();
        this.mImageBoundsInView = new RectF();
        this.mCanvasWidth = 0;
        this.mCanvasHeight = 0;
        this.mDebugPaint = new Paint(3);
        this.mNeedsColorAnalysis = true;
        this.mNeedsUpdateShaders = true;
        this.mIsAnalyzing = false;
        this.mGradientAnalysisRectFs = null;
        this.mAreaAnalysisRectFs = null;
        this.mOutpaintingRectFs = null;
        this.mBlendRectFs = null;
        this.mOverlapDepthMaxRectFs = null;
        this.mGradientCaches = new ExpandDrawInfo[4];
        this.mBlurredBitmapShaderMatrix = new Matrix();
        this.mBlurredBitmapWidth = 1;
        this.mBlurredBitmapHeight = 1;
        this.mTempOutpaintingRectF = new RectF();
        this.mTempOverlapRectF = new RectF();
        this.mTempOutpaintingShaderRectF = new RectF();
        this.mTempBoundsRectF = new RectF();
        this.mState = new ExpandableConstantState(drawable);
        init();
        setBounds(drawable.getBounds());
        performColorAnalysis(drawable);
    }

    private void updateBlurredBitmapShader(@NonNull Bitmap bitmap) {
        try {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            if (Build.VERSION.SDK_INT >= 34) {
                bitmapShader.setFilterMode(2);
                bitmapShader.setMaxAnisotropy(4);
            }
            bitmapShader.setLocalMatrix(this.mBlurredBitmapShaderMatrix);
            this.mBlurredBitmapShader = bitmapShader;
        } catch (Exception e) {
            this.mBlurredBitmapShader = null;
            Log.w(this.TAG, "updateBitmapShader: Failed to apply HardwareRenderer blur, using original bitmap: " + e.getMessage());
        }
    }

    public ExpandableDrawable(@NonNull Drawable drawable, @Nullable ExpandAnalysisData expandAnalysisData) throws Throwable {
        this.TAG = "ExpandableDrawable" + hashCode();
        this.mImageBoundsInView = new RectF();
        int i = 0;
        this.mCanvasWidth = 0;
        this.mCanvasHeight = 0;
        this.mDebugPaint = new Paint(3);
        this.mNeedsColorAnalysis = true;
        this.mNeedsUpdateShaders = true;
        this.mIsAnalyzing = false;
        this.mGradientAnalysisRectFs = null;
        this.mAreaAnalysisRectFs = null;
        this.mOutpaintingRectFs = null;
        this.mBlendRectFs = null;
        this.mOverlapDepthMaxRectFs = null;
        this.mGradientCaches = new ExpandDrawInfo[4];
        this.mBlurredBitmapShaderMatrix = new Matrix();
        this.mBlurredBitmapWidth = 1;
        this.mBlurredBitmapHeight = 1;
        this.mTempOutpaintingRectF = new RectF();
        this.mTempOverlapRectF = new RectF();
        this.mTempOutpaintingShaderRectF = new RectF();
        this.mTempBoundsRectF = new RectF();
        init();
        if (expandAnalysisData != null && expandAnalysisData.isValid()) {
            this.mState = new ExpandableConstantState(drawable, expandAnalysisData, i);
            updateBlurredBitmapShader(drawable);
        } else {
            ExpandableConstantState expandableConstantState = new ExpandableConstantState(drawable);
            this.mState = expandableConstantState;
            performColorAnalysis(drawable);
            if (expandAnalysisData != null) {
                ExpandEdgeColorInfo[] allEdgeColorInfos = expandableConstantState.getExpandAnalysisData().getAllEdgeColorInfos();
                ExpandEdgeColorInfo[] allEdgeColorInfos2 = expandAnalysisData.getAllEdgeColorInfos();
                while (i < 4) {
                    ExpandEdgeColorInfo expandEdgeColorInfo = allEdgeColorInfos2[i];
                    if (expandEdgeColorInfo.isValid()) {
                        allEdgeColorInfos[i].copyFrom(expandEdgeColorInfo);
                        Log.i(this.TAG, "ExpandableDrawable: copy loadedEdgeColorInfo[" + i + "]:" + expandEdgeColorInfo);
                    }
                    i++;
                }
            }
        }
        setBounds(drawable.getBounds());
    }

    private ExpandableDrawable(@NonNull ExpandableConstantState expandableConstantState) throws Throwable {
        this.TAG = "ExpandableDrawable" + hashCode();
        this.mImageBoundsInView = new RectF();
        this.mCanvasWidth = 0;
        this.mCanvasHeight = 0;
        this.mDebugPaint = new Paint(3);
        this.mNeedsColorAnalysis = true;
        this.mNeedsUpdateShaders = true;
        this.mIsAnalyzing = false;
        this.mGradientAnalysisRectFs = null;
        this.mAreaAnalysisRectFs = null;
        this.mOutpaintingRectFs = null;
        this.mBlendRectFs = null;
        this.mOverlapDepthMaxRectFs = null;
        this.mGradientCaches = new ExpandDrawInfo[4];
        this.mBlurredBitmapShaderMatrix = new Matrix();
        this.mBlurredBitmapWidth = 1;
        this.mBlurredBitmapHeight = 1;
        this.mTempOutpaintingRectF = new RectF();
        this.mTempOverlapRectF = new RectF();
        this.mTempOutpaintingShaderRectF = new RectF();
        this.mTempBoundsRectF = new RectF();
        this.mState = expandableConstantState;
        init();
        performColorAnalysis(expandableConstantState.mOriginalDrawable);
    }
}
