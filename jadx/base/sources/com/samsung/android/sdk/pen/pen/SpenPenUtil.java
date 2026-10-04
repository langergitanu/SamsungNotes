package com.samsung.android.sdk.pen.pen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.SpenSettingChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectShapeBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenFillColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0002\u0010\u0017J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002JC\u0010#\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010(J;\u0010)\u001a\u00020\u00102\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010,JH\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\"H\u0007J:\u00107\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020\u000bH\u0007J6\u0010:\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007J\u0016\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0007J.\u0010E\u001a\u00020\u00102\u0006\u0010B\u001a\u00020F2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007J6\u0010:\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0007J\u0018\u0010J\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0002J(\u0010L\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0007J \u0010M\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0007H\u0007J\u0018\u0010N\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u0005H\u0007J\u0018\u0010O\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u0005H\u0007J2\u0010P\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0007J!\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0007H\u0082 J)\u0010T\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006U"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/pen/SpenPenUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "X_INDEX", "", "Y_INDEX", "PRESSURE_INDEX", "POINT_START_X", "", "POINT_START_Y", "EVENT_STRIDE", "EVENT_POINT_STEP", "arrayCopy", "", "array", "", "", "copyArray", "([[F[[F)V", "arrayStrideCopy", "([[F)[[F", "getEventList", "penName", "(Ljava/lang/String;)[[F", "getPenMaxVal", "pen", "Lcom/samsung/android/sdk/pen/pen/SpenPen;", "penInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "getPenMinVal", "isFixedStroke", "", "adjustEventPosition", "eventList", "densityIndependentPixel", "datumXdp", "datumYdp", "([[FLcom/samsung/android/sdk/pen/pen/SpenPen;Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;FFF)F", "drawPen", "pixel", "progress", "([[FLcom/samsung/android/sdk/pen/pen/SpenPen;Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;FF)V", "drawLaserPenPreview", "context", "Landroid/content/Context;", "outBitmap", "Landroid/graphics/Bitmap;", "width", "height", "blurSize", "insideRatio", "isRainbowEnabled", "drawPenPreview", "isRTL", "isTooltipDrawing", "changeStyle", "selectedObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "sizeLevelInfo", "colorInfo", "canvasWidth", "canvasHeight", "changeFillEffect", "shapeObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "color", "changeLineEffect", "Lcom/samsung/android/sdk/pen/document/SpenObjectShapeBase;", "sizeLevel", "info", "Lcom/samsung/android/sdk/pen/SpenSettingChangeStyleInfo;", "convertSizeLevelToShapeStrokeWidth", "canvasSize", "convertSizeLevelToPxSize", "convertSizeLevelToDpSize", "getMinimumPenSize", "getMaximumPenSize", "convertSizeToSizeLevel", "size", "Native_convertSizeLevelToDpSize", "densityDpi", "Native_convertSizeLevelToPxSize", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenUtil {
    private static final int EVENT_POINT_STEP = 10;
    private static final int EVENT_STRIDE = 3;

    @NotNull
    public static final SpenPenUtil INSTANCE = new SpenPenUtil();
    private static final float POINT_START_X = 50.0f;
    private static final float POINT_START_Y = 100.0f;
    private static final int PRESSURE_INDEX = 2;

    @NotNull
    private static final String TAG = "SpenPenUtil";
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;

    private SpenPenUtil() {
    }

    private final native float Native_convertSizeLevelToDpSize(int densityDpi, String penName, int sizeLevel);

    private final native float Native_convertSizeLevelToPxSize(String penName, int sizeLevel, int canvasWidth, int canvasHeight);

    /* JADX WARN: Removed duplicated region for block: B:55:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0247  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float adjustEventPosition(float[][] eventList, SpenPen pen, SpenSettingPenInfo penInfo, float densityIndependentPixel, float datumXdp, float datumYdp) {
        float f;
        float f4;
        int i;
        float f5;
        boolean z;
        float f6;
        boolean zIsFixedStroke = isFixedStroke(penInfo.name);
        float penMaxVal = getPenMaxVal(pen, penInfo);
        float penMinVal = getPenMinVal(pen, penInfo);
        int i2 = penInfo.sizeLevel;
        float f7 = (((penMaxVal - penMinVal) * i2) / 100.0f) + penMinVal;
        if (i2 > 1) {
            penMinVal = i2 >= 100 ? penMaxVal : f7;
        }
        float f8 = datumXdp * densityIndependentPixel;
        float f9 = datumYdp * densityIndependentPixel;
        float f10 = penMinVal * densityIndependentPixel;
        float f11 = penMaxVal * densityIndependentPixel;
        if (!zIsFixedStroke || penInfo.name.compareTo(SpenPenManager.SPEN_LASER_PEN) == 0) {
            f10 *= 2.0f;
            f = f8 - ((f10 / (f11 * 2.0f)) * f10);
            f4 = f9 - (f10 / 2);
        } else {
            if (penInfo.name.compareTo(SpenPenManager.SPEN_MARKER4) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_FOUNTAIN_PEN) == 0) {
                f10 *= 2.0f;
            } else if (penInfo.name.compareTo(SpenPenManager.SPEN_INK_PEN2) == 0) {
                f10 *= 1.5f;
            }
            f = f8 - f10;
            f4 = f9 - f10;
        }
        float f12 = datumXdp / 36.0f;
        float f13 = datumYdp / 36.0f;
        float f14 = f / f8;
        float f15 = f4 / f9;
        float f16 = f8 / 2.0f;
        float f17 = f9 / 2.0f;
        int length = eventList.length;
        float f18 = 0.0f;
        float f19 = 0.0f;
        int i4 = 0;
        while (i4 < length) {
            float[] fArr = eventList[i4];
            int i5 = length;
            if (penInfo.name.compareTo(SpenPenManager.SPEN_FOUNTAIN_PEN) == 0) {
                i = i4;
                fArr[0] = ((float) (((double) f12) * 0.78d)) * fArr[0];
            } else {
                i = i4;
                if (penInfo.name.compareTo(SpenPenManager.SPEN_INK_PEN2) == 0) {
                    fArr[0] = ((float) (((double) f12) * 0.8d)) * fArr[0];
                } else if (penInfo.name.compareTo(SpenPenManager.SPEN_MARKER4) == 0) {
                    fArr[0] = ((float) (((double) f12) * 0.92d)) * fArr[0];
                } else if (penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) == 0) {
                    fArr[0] = ((float) (((double) f12) * 0.935d)) * fArr[0];
                } else {
                    fArr[0] = ((float) (((double) f12) * 0.87d)) * fArr[0];
                }
            }
            if (penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_MARKER) != 0) {
                f5 = f10;
                if (penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) != 0 && penInfo.name.compareTo(SpenPenManager.SPEN_MARKER3) != 0 && penInfo.name.compareTo(SpenPenManager.SPEN_MARKER4) != 0) {
                    fArr[1] = f13 * 1.2f * fArr[1];
                    z = zIsFixedStroke;
                    f6 = f14;
                }
                fArr[0] = fArr[0] * densityIndependentPixel;
                fArr[1] = fArr[1] * densityIndependentPixel;
                if (penInfo.name.compareTo(SpenPenManager.SPEN_FOUNTAIN_PEN) != 0) {
                    fArr[0] = fArr[0] - (0.78f * f16);
                } else if (penInfo.name.compareTo(SpenPenManager.SPEN_INK_PEN2) == 0) {
                    fArr[0] = fArr[0] - (0.81f * f16);
                } else {
                    fArr[0] = fArr[0] - (0.9f * f16);
                }
                if (penInfo.name.compareTo(SpenPenManager.SPEN_PENCIL2) != 0) {
                    fArr[1] = fArr[1] - (1.2f * f17);
                } else if (penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_MARKER) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_MARKER3) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_MARKER4) == 0) {
                    fArr[1] = fArr[1] - f17;
                } else {
                    fArr[1] = fArr[1] - (0.6f * f17);
                }
                if (penInfo.name.compareTo(SpenPenManager.SPEN_LASER_PEN) != 0) {
                    fArr[0] = f6 * 0.5f * fArr[0];
                    fArr[1] = 0.5f * f15 * fArr[1];
                } else if (!z) {
                    fArr[0] = fArr[0] * f6;
                    fArr[1] = fArr[1] * f15;
                    if (penInfo.name.compareTo(SpenPenManager.SPEN_MARKER3) == 0) {
                        fArr[1] = fArr[1] * 1.5f;
                    }
                }
                if (penInfo.name.compareTo(SpenPenManager.SPEN_LASER_PEN) != 0) {
                    if (f18 == 0.0f && f19 == 0.0f) {
                        f18 = 50.0f - fArr[0];
                        f19 = 100.0f - fArr[1];
                    }
                    fArr[0] = fArr[0] + f18;
                    fArr[1] = fArr[1] + f19;
                } else {
                    fArr[0] = fArr[0] + f16;
                    fArr[1] = fArr[1] + f17;
                }
                i4 = i + 1;
                length = i5;
                f10 = f5;
                zIsFixedStroke = z;
                f14 = f6;
            } else {
                f5 = f10;
            }
            z = zIsFixedStroke;
            f6 = f14;
            fArr[1] = fArr[1] * ((float) (((double) f13) * 0.95d));
            fArr[0] = fArr[0] * densityIndependentPixel;
            fArr[1] = fArr[1] * densityIndependentPixel;
            if (penInfo.name.compareTo(SpenPenManager.SPEN_FOUNTAIN_PEN) != 0) {
            }
            if (penInfo.name.compareTo(SpenPenManager.SPEN_PENCIL2) != 0) {
            }
            if (penInfo.name.compareTo(SpenPenManager.SPEN_LASER_PEN) != 0) {
            }
            if (penInfo.name.compareTo(SpenPenManager.SPEN_LASER_PEN) != 0) {
            }
            i4 = i + 1;
            length = i5;
            f10 = f5;
            zIsFixedStroke = z;
            f14 = f6;
        }
        return f10;
    }

    private final void arrayCopy(float[][] array, float[][] copyArray) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            float[] fArr = array[i];
            System.arraycopy(fArr, 0, copyArray[i], 0, fArr.length);
        }
    }

    private final float[][] arrayStrideCopy(float[][] array) {
        int length = (array.length / 3) + 1;
        float[][] fArr = new float[length][];
        for (int i = 0; i < length; i++) {
            fArr[i] = new float[array[0].length];
        }
        for (int i2 = 0; i2 < array.length; i2 += 3) {
            float[] fArr2 = array[i2];
            System.arraycopy(fArr2, 0, fArr[i2 / 3], 0, fArr2.length);
        }
        return fArr;
    }

    @JvmStatic
    public static final float convertSizeLevelToDpSize(@NotNull Context context, @NotNull String penName, int sizeLevel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(penName, "penName");
        return INSTANCE.Native_convertSizeLevelToDpSize(context.getApplicationContext().getResources().getDisplayMetrics().densityDpi, penName, sizeLevel);
    }

    @JvmStatic
    public static final float convertSizeLevelToPxSize(@NotNull String penName, int sizeLevel, int canvasWidth, int canvasHeight) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        return INSTANCE.Native_convertSizeLevelToPxSize(penName, sizeLevel, canvasWidth, canvasHeight);
    }

    private final float convertSizeLevelToShapeStrokeWidth(int sizeLevel, int canvasSize) {
        float maxLineWidth;
        if (sizeLevel <= 1) {
            maxLineWidth = SpenObjectShapeBase.INSTANCE.getMinLineWidth();
        } else if (sizeLevel >= 100) {
            maxLineWidth = SpenObjectShapeBase.INSTANCE.getMaxLineWidth();
        } else {
            SpenObjectShapeBase.Companion companion = SpenObjectShapeBase.INSTANCE;
            maxLineWidth = (((companion.getMaxLineWidth() - companion.getMinLineWidth()) * sizeLevel) / 100.0f) + companion.getMinLineWidth();
        }
        return (maxLineWidth * canvasSize) / 360.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int convertSizeToSizeLevel(@Nullable Context context, @NotNull String penName, float size, int canvasWidth, int canvasHeight) {
        Exception exc;
        float f;
        float maxSettingValue;
        SpenPen spenPenCreatePen;
        Intrinsics.checkNotNullParameter(penName, "penName");
        if (canvasWidth >= canvasHeight) {
            canvasWidth = canvasHeight;
        }
        SpenPenManager spenPenManager = new SpenPenManager(context);
        float minSettingValue = -1.0f;
        try {
            spenPenCreatePen = spenPenManager.createPen(penName);
            maxSettingValue = spenPenCreatePen.getMaxSettingValue();
        } catch (Exception e) {
            exc = e;
            f = -1.0f;
        }
        try {
            minSettingValue = spenPenCreatePen.getMinSettingValue();
            spenPenManager.destroyPen(spenPenCreatePen);
        } catch (Exception e2) {
            exc = e2;
            f = minSettingValue;
            minSettingValue = maxSettingValue;
            exc.printStackTrace();
            maxSettingValue = minSettingValue;
            minSettingValue = f;
        }
        float f4 = canvasWidth;
        float f5 = (maxSettingValue * f4) / 360.0f;
        float f6 = (f4 * minSettingValue) / 360.0f;
        int i = 1;
        if (size > f6) {
            if (size < f5) {
                int iRound = Math.round(((size - f6) / (f5 - f6)) * 100);
                if (iRound >= 1) {
                    i = iRound > 100 ? 100 : iRound;
                }
            }
        }
        Log.d(TAG, "convertSizeToSizeLevel penName : " + penName + " size : " + size);
        Log.d(TAG, "convertSizeToSizeLevel maxSize : " + maxSettingValue + " minSize : " + minSettingValue);
        Log.d(TAG, "convertSizeToSizeLevel maxValue : " + f5 + " minValue : " + f6);
        AbstractC0541b.m755A(i, "convertSizeToSizeLevel sizeLevel : ", TAG);
        return i;
    }

    @JvmStatic
    public static final void drawLaserPenPreview(@NotNull Context context, @NotNull Bitmap outBitmap, int width, int height, @NotNull SpenSettingPenInfo penInfo, float blurSize, float insideRatio, boolean isRainbowEnabled) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outBitmap, "outBitmap");
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        if (outBitmap.getWidth() == 0 || outBitmap.getHeight() == 0) {
            Log.e(TAG, "drawPenPreview wrong parameter");
            return;
        }
        Log.d(TAG, "drawPenPreview penName : " + penInfo.name + " size : " + penInfo.size);
        SpenPenUtil spenPenUtil = INSTANCE;
        float[][] eventList = spenPenUtil.getEventList(penInfo.name);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        SpenPenManager spenPenManager = new SpenPenManager(context);
        try {
            SpenPen spenPenCreatePreviewPen = spenPenManager.createPreviewPen(penInfo.name);
            int i = displayMetrics.densityDpi;
            float fAdjustEventPosition = spenPenUtil.adjustEventPosition(eventList, spenPenCreatePreviewPen, penInfo, i / 160.0f, (160.0f / i) * width, (160.0f / i) * height);
            spenPenCreatePreviewPen.setColor(penInfo.color);
            spenPenCreatePreviewPen.setBlurSize(blurSize);
            spenPenCreatePreviewPen.setInsideRatio(insideRatio);
            spenPenCreatePreviewPen.setRainbowEffectEnabled(isRainbowEnabled);
            spenPenCreatePreviewPen.setTypePointerEnabled(false);
            spenPenCreatePreviewPen.setSize(penInfo.size);
            spenPenCreatePreviewPen.setFixedWidth(penInfo.size);
            spenPenCreatePreviewPen.setBitmap(outBitmap);
            spenPenUtil.drawPen(eventList, spenPenCreatePreviewPen, penInfo, fAdjustEventPosition, 1.0f);
            spenPenCreatePreviewPen.setBitmap(null);
            spenPenManager.destroyPreviewPen(spenPenCreatePreviewPen);
            Log.d(TAG, "drawLaserPenPreview end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x02ae A[LOOP:6: B:79:0x02a8->B:81:0x02ae, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void drawPen(float[][] eventList, SpenPen pen, SpenSettingPenInfo penInfo, float pixel, float progress) throws Throwable {
        int i;
        char c;
        String str;
        Iterator<MotionEvent> it;
        long j;
        long j2;
        long j3;
        char c2;
        long j5;
        RectF rectF = new RectF();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j6 = jCurrentTimeMillis + ((long) 100);
        int length = ((int) (eventList.length * progress)) - 2;
        if (length < 1) {
            length = 1;
        }
        if (penInfo.name.compareTo(SpenPenManager.SPEN_MARKER3) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_MARKER4) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_MARKER) == 0) {
            ArrayList<MotionEvent> arrayList = new ArrayList<>();
            float[] fArr = eventList[0];
            int i2 = length;
            char c4 = 1;
            arrayList.add(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, fArr[0], fArr[1], fArr[2], pixel, 0, 0.0f, 0.0f, 0, 0));
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(1, i2, 10);
            if (1 <= progressionLastElement) {
                int i4 = 1;
                while (true) {
                    j = j6 + 1;
                    float[] fArr2 = eventList[i4];
                    i = i2;
                    c = c4;
                    int i5 = progressionLastElement;
                    int i6 = i4;
                    arrayList.add(MotionEvent.obtain(jCurrentTimeMillis, j, 2, fArr2[0], fArr2[c4], fArr2[2], pixel, 0, 0.0f, 0.0f, 0, 0));
                    if (i6 == i5) {
                        break;
                    }
                    j6 = j;
                    i4 = i6 + 10;
                    progressionLastElement = i5;
                    i2 = i;
                    c4 = c;
                }
                j6 = j;
            } else {
                i = i2;
                c = 1;
            }
            float[] fArr3 = eventList[i + 1];
            arrayList.add(MotionEvent.obtain(jCurrentTimeMillis, j6 + 1, 1, fArr3[0], fArr3[c], fArr3[2], pixel, 0, 0.0f, 0.0f, 0, 0));
            try {
                pen.redrawPen(arrayList, rectF);
                Iterator<MotionEvent> it2 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    MotionEvent next = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.recycle();
                }
                arrayList.clear();
                return;
            } catch (Exception e) {
                str = "next(...)";
                try {
                    e.printStackTrace();
                    Iterator<MotionEvent> it3 = arrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                    while (it3.hasNext()) {
                        MotionEvent next2 = it3.next();
                        Intrinsics.checkNotNullExpressionValue(next2, str);
                        next2.recycle();
                    }
                    arrayList.clear();
                    return;
                } catch (Throwable th) {
                    th = th;
                    it = arrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        MotionEvent next3 = it.next();
                        Intrinsics.checkNotNullExpressionValue(next3, str);
                        next3.recycle();
                    }
                    arrayList.clear();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                str = "next(...)";
                it = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                }
                arrayList.clear();
                throw th;
            }
        }
        if (!isFixedStroke(penInfo.name) && penInfo.name.compareTo(SpenPenManager.SPEN_LASER_PEN) != 0) {
            float[] fArr4 = eventList[0];
            float f = fArr4[0];
            float f4 = fArr4[1];
            float f5 = fArr4[2];
            int i7 = length;
            char c5 = 1;
            MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, f, f4, f5, pixel, 0, 0.0f, 0.0f, 0, 0);
            Intrinsics.checkNotNull(motionEventObtain);
            pen.draw(motionEventObtain, rectF);
            motionEventObtain.recycle();
            int progressionLastElement2 = ProgressionUtilKt.getProgressionLastElement(1, i7, 10);
            if (1 <= progressionLastElement2) {
                int i8 = 1;
                while (true) {
                    j5 = j6 + 1;
                    float[] fArr5 = eventList[i8];
                    c2 = c5;
                    int i9 = i8;
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(jCurrentTimeMillis, j5, 2, fArr5[0], fArr5[c5], fArr5[2], pixel, 0, 0.0f, 0.0f, 0, 0);
                    Intrinsics.checkNotNull(motionEventObtain2);
                    pen.draw(motionEventObtain2, rectF);
                    motionEventObtain2.recycle();
                    if (i9 == progressionLastElement2) {
                        break;
                    }
                    j6 = j5;
                    i8 = i9 + 10;
                    c5 = c2;
                }
                j6 = j5;
            } else {
                c2 = 1;
            }
            float[] fArr6 = eventList[i7 + 1];
            MotionEvent motionEventObtain3 = MotionEvent.obtain(jCurrentTimeMillis, j6 + 1, 1, fArr6[0], fArr6[c2], fArr6[2], pixel, 0, 0.0f, 0.0f, 0, 0);
            Intrinsics.checkNotNull(motionEventObtain3);
            pen.draw(motionEventObtain3, rectF);
            motionEventObtain3.recycle();
            return;
        }
        int i10 = length;
        if (penInfo.isFixedOpacity) {
            float[] fArr7 = eventList[0];
            MotionEvent motionEventObtain4 = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, fArr7[0], fArr7[1], fArr7[2], pixel, 0, 0.0f, 0.0f, 0, 0);
            int progressionLastElement3 = ProgressionUtilKt.getProgressionLastElement(1, i10, 10);
            if (1 <= progressionLastElement3) {
                int i11 = 1;
                while (true) {
                    j3 = j6 + 1;
                    float[] fArr8 = eventList[i11];
                    motionEventObtain4.addBatch(j3, fArr8[0], fArr8[1], fArr8[2], pixel, 0);
                    if (i11 == progressionLastElement3) {
                        break;
                    }
                    i11 += 10;
                    j6 = j3;
                }
            } else {
                j3 = j6;
            }
            float[] fArr9 = eventList[i10 + 1];
            motionEventObtain4.addBatch(j3, fArr9[0], fArr9[1], fArr9[2], pixel, 0);
            Intrinsics.checkNotNull(motionEventObtain4);
            pen.redrawPen(motionEventObtain4, rectF);
            motionEventObtain4.recycle();
            return;
        }
        float length2 = eventList.length;
        float[] fArr10 = eventList[0];
        MotionEvent motionEventObtain5 = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, fArr10[0], fArr10[1], fArr10[2] + 0.2f, pixel, 0, 0.0f, 0.0f, 0, 0);
        char c6 = 1;
        int progressionLastElement4 = ProgressionUtilKt.getProgressionLastElement(1, i10, 10);
        if (1 <= progressionLastElement4) {
            int i12 = 1;
            while (true) {
                j2 = j6 + 1;
                float[] fArr11 = eventList[i12];
                motionEventObtain5.addBatch(j2, fArr11[0], fArr11[c6], (((length2 - i12) / length2) * fArr11[2]) + 0.2f, pixel, 0);
                if (i12 == progressionLastElement4) {
                    break;
                }
                i12 += 10;
                j6 = j2;
                c6 = 1;
            }
            c6 = 1;
        } else {
            j2 = j6;
        }
        int i13 = i10 + 1;
        float[] fArr12 = eventList[i13];
        motionEventObtain5.addBatch(j2, fArr12[0], fArr12[c6], (((length2 - i13) / length2) * fArr12[2]) + 0.2f, pixel, 0);
        Intrinsics.checkNotNull(motionEventObtain5);
        pen.redrawPen(motionEventObtain5, rectF);
        motionEventObtain5.recycle();
    }

    @JvmStatic
    @JvmOverloads
    public static final void drawPenPreview(@NotNull Context context, @NotNull Bitmap outBitmap, @NotNull SpenSettingPenInfo penInfo, boolean z, boolean z2) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outBitmap, "outBitmap");
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        drawPenPreview$default(context, outBitmap, penInfo, z, z2, 0.0f, 32, null);
    }

    public static /* synthetic */ void drawPenPreview$default(Context context, Bitmap bitmap, SpenSettingPenInfo spenSettingPenInfo, boolean z, boolean z2, float f, int i, Object obj) throws Throwable {
        if ((i & 32) != 0) {
            f = 1.0f;
        }
        drawPenPreview(context, bitmap, spenSettingPenInfo, z, z2, f);
    }

    private final float[][] getEventList(String penName) {
        if (penName.compareTo(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) == 0 || penName.compareTo(SpenPenManager.SPEN_STRAIGHT_MARKER) == 0) {
            int length = SpenPenUtilData.STRAIGHT_LINE_PREVIEW_EVENT_LIST.length;
            float[][] fArr = new float[length][];
            for (int i = 0; i < length; i++) {
                fArr[i] = new float[SpenPenUtilData.STRAIGHT_LINE_PREVIEW_EVENT_LIST[0].length];
            }
            arrayCopy(SpenPenUtilData.STRAIGHT_LINE_PREVIEW_EVENT_LIST, fArr);
            return fArr;
        }
        if (penName.compareTo(SpenPenManager.SPEN_MARKER3) == 0 || penName.compareTo(SpenPenManager.SPEN_MARKER4) == 0) {
            return arrayStrideCopy(SpenPenUtilData.THICK_PEN_CURVE_PREVIEW_EVENT_LIST);
        }
        if (penName.compareTo(SpenPenManager.SPEN_PENCIL2) == 0) {
            int length2 = SpenPenUtilData.COIL_PREVIEW_EVENT_LIST.length;
            float[][] fArr2 = new float[length2][];
            for (int i2 = 0; i2 < length2; i2++) {
                fArr2[i2] = new float[SpenPenUtilData.COIL_PREVIEW_EVENT_LIST[0].length];
            }
            arrayCopy(SpenPenUtilData.COIL_PREVIEW_EVENT_LIST, fArr2);
            return fArr2;
        }
        int length3 = SpenPenUtilData.CURVE2_PREVIEW_EVENT_LIST.length;
        float[][] fArr3 = new float[length3][];
        for (int i4 = 0; i4 < length3; i4++) {
            fArr3[i4] = new float[SpenPenUtilData.CURVE2_PREVIEW_EVENT_LIST[0].length];
        }
        arrayCopy(SpenPenUtilData.CURVE2_PREVIEW_EVENT_LIST, fArr3);
        return fArr3;
    }

    @JvmStatic
    public static final float getMaximumPenSize(@NotNull Context context, @NotNull String penName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(penName, "penName");
        Log.i(TAG, "getMaximumPenSize - pen name=" + penName);
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        SpenPenManager spenPenManager = new SpenPenManager(context);
        float maxSettingValue = 0.0f;
        try {
            SpenPen spenPenCreatePen = spenPenManager.createPen(penName);
            maxSettingValue = spenPenCreatePen.getMaxSettingValue();
            spenPenManager.destroyPen(spenPenCreatePen);
            float f = (displayMetrics.densityDpi / 160.0f) * maxSettingValue;
            Log.i(TAG, "getMaximumPenSize - min=" + maxSettingValue);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return maxSettingValue;
        }
    }

    @JvmStatic
    public static final float getMinimumPenSize(@NotNull Context context, @NotNull String penName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(penName, "penName");
        Log.i(TAG, "getMinimumPenSize - pen name=" + penName);
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        SpenPenManager spenPenManager = new SpenPenManager(context);
        float minSettingValue = 0.0f;
        try {
            SpenPen spenPenCreatePen = spenPenManager.createPen(penName);
            minSettingValue = spenPenCreatePen.getMinSettingValue();
            spenPenManager.destroyPen(spenPenCreatePen);
            float f = (displayMetrics.densityDpi / 160.0f) * minSettingValue;
            Log.i(TAG, "getMinimumPenSize - min=" + f);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return minSettingValue;
        }
    }

    private final float getPenMaxVal(SpenPen pen, SpenSettingPenInfo penInfo) {
        if (penInfo.name.compareTo(SpenPenManager.SPEN_PENCIL2) == 0) {
            return 13.0f;
        }
        return (penInfo.name.compareTo(SpenPenManager.SPEN_MARKER3) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_MARKER4) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_MARKER) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) == 0) ? pen.getMaxSettingValue() * 0.65f : (penInfo.name.compareTo(SpenPenManager.SPEN_MOSAIC_PEN) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_MARKER2) == 0) ? 17.0f : 20.0f;
    }

    private final float getPenMinVal(SpenPen pen, SpenSettingPenInfo penInfo) {
        if (penInfo.name.compareTo(SpenPenManager.SPEN_PENCIL2) == 0) {
            return 1.8f;
        }
        return penInfo.name.compareTo(SpenPenManager.SPEN_INK_PEN) == 0 ? penInfo.sizeLevel <= 1 ? 3.0f : 5.0f : (penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_MARKER) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_MARKER3) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_MARKER4) == 0) ? pen.getMinSettingValue() : (penInfo.name.compareTo(SpenPenManager.SPEN_INK_PEN2) == 0 || penInfo.name.compareTo(SpenPenManager.SPEN_FOUNTAIN_PEN) == 0) ? 1.2f : 7.0f;
    }

    private final boolean isFixedStroke(String penName) {
        return (penName.compareTo(SpenPenManager.SPEN_STRAIGHT_MARKER) == 0 || penName.compareTo(SpenPenManager.SPEN_MARKER3) == 0) ? false : true;
    }

    public final void changeFillEffect(@NotNull SpenObjectShape shapeObject, int color) {
        Intrinsics.checkNotNullParameter(shapeObject, "shapeObject");
        SpenFillColorEffect spenFillColorEffect = new SpenFillColorEffect();
        spenFillColorEffect.setColorType(0);
        spenFillColorEffect.setSolidColor((color & 16777215) | (-16777216));
        shapeObject.setFillEffect(spenFillColorEffect);
    }

    public final void changeLineEffect(@NotNull SpenObjectShapeBase shapeObject, int color, int sizeLevel, int canvasWidth, int canvasHeight) {
        Intrinsics.checkNotNullParameter(shapeObject, "shapeObject");
        SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
        shapeObject.getLineColorEffect(spenLineColorEffect);
        spenLineColorEffect.setSolidColor((color & 16777215) | (spenLineColorEffect.getSolidColor() & (-16777216)));
        shapeObject.setLineColorEffect(spenLineColorEffect);
        SpenLineStyleEffect spenLineStyleEffect = new SpenLineStyleEffect();
        shapeObject.getLineStyleEffect(spenLineStyleEffect);
        if (canvasWidth >= canvasHeight) {
            canvasWidth = canvasHeight;
        }
        float fConvertSizeLevelToShapeStrokeWidth = convertSizeLevelToShapeStrokeWidth(sizeLevel, canvasWidth);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(canvasWidth, sizeLevel, "changeLineEffect - canvasSize : ", ", sizeLevel : ", ", size : ");
        sbM1173s.append(fConvertSizeLevelToShapeStrokeWidth);
        Log.i(TAG, sbM1173s.toString());
        spenLineStyleEffect.setWidth(fConvertSizeLevelToShapeStrokeWidth);
        shapeObject.setLineStyleEffect(spenLineStyleEffect);
    }

    public final void changeStyle(@NotNull Context context, @NotNull SpenObjectBase selectedObject, int sizeLevelInfo, int colorInfo, int canvasWidth, int canvasHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectedObject, "selectedObject");
        SpenSettingChangeStyleInfo spenSettingChangeStyleInfo = new SpenSettingChangeStyleInfo();
        spenSettingChangeStyleInfo.color = colorInfo;
        spenSettingChangeStyleInfo.sizeLevel = sizeLevelInfo;
        changeStyle(context, selectedObject, spenSettingChangeStyleInfo, canvasWidth, canvasHeight);
    }

    @JvmStatic
    @JvmOverloads
    public static final void drawPenPreview(@NotNull Context context, @NotNull Bitmap outBitmap, @NotNull SpenSettingPenInfo penInfo, boolean isRTL, boolean isTooltipDrawing, float progress) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outBitmap, "outBitmap");
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        if (outBitmap.getWidth() == 0 || outBitmap.getHeight() == 0) {
            Log.e(TAG, "drawPenPreview wrong parameter");
            return;
        }
        Log.d(TAG, "drawPenPreview penName : " + penInfo.name + " sizeLevel : " + penInfo.sizeLevel);
        SpenPenUtil spenPenUtil = INSTANCE;
        float[][] eventList = spenPenUtil.getEventList(penInfo.name);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        SpenPenManager spenPenManager = new SpenPenManager(context);
        try {
            SpenPen spenPenCreatePreviewPen = spenPenManager.createPreviewPen(penInfo.name);
            float height = outBitmap.getHeight();
            int i = displayMetrics.densityDpi;
            float fAdjustEventPosition = spenPenUtil.adjustEventPosition(eventList, spenPenCreatePreviewPen, penInfo, i / 160.0f, (160.0f / displayMetrics.densityDpi) * outBitmap.getWidth(), (160.0f / i) * height);
            spenPenCreatePreviewPen.setBitmap(outBitmap);
            spenPenCreatePreviewPen.setColor(penInfo.color);
            spenPenCreatePreviewPen.setSize(fAdjustEventPosition);
            spenPenCreatePreviewPen.setFixedWidthEnabled(penInfo.isFixedWidth);
            spenPenCreatePreviewPen.setFixedOpacityEnabled(penInfo.isFixedOpacity);
            spenPenCreatePreviewPen.setFixedWidth(fAdjustEventPosition);
            if (penInfo.name.compareTo(SpenPenManager.SPEN_MOSAIC_PEN) == 0) {
                Drawable drawable = context.getResources().getDrawable(C7932R.drawable.stroke);
                Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), outBitmap.getWidth(), outBitmap.getHeight(), true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
                if (isTooltipDrawing) {
                    spenPenCreatePreviewPen.setParticleSize(penInfo.particleSize);
                } else {
                    spenPenCreatePreviewPen.setParticleSize((displayMetrics.densityDpi / 160.0f) * penInfo.particleSize);
                }
                spenPenCreatePreviewPen.setReferenceBitmap(bitmapCreateScaledBitmap);
            }
            spenPenUtil.drawPen(eventList, spenPenCreatePreviewPen, penInfo, fAdjustEventPosition, progress);
            spenPenCreatePreviewPen.setBitmap(null);
            spenPenManager.destroyPreviewPen(spenPenCreatePreviewPen);
            if (isRTL) {
                Matrix matrix = new Matrix();
                matrix.setScale(1.0f, -1.0f);
                matrix.setScale(-1.0f, 1.0f);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(outBitmap, 0, 0, outBitmap.getWidth(), outBitmap.getHeight(), matrix, false);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                Canvas canvas = new Canvas();
                canvas.setBitmap(outBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
            }
            Log.d(TAG, "drawPenPreview end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void changeStyle(@Nullable Context context, @Nullable SpenObjectBase selectedObject, @Nullable SpenSettingChangeStyleInfo info, int canvasWidth, int canvasHeight) {
        if (selectedObject == null || info == null) {
            return;
        }
        int type = selectedObject.getType();
        if (type != 1) {
            if (type != 7) {
                if (type != 8) {
                    return;
                }
                INSTANCE.changeLineEffect((SpenObjectShapeBase) selectedObject, info.color, info.sizeLevel, canvasWidth, canvasHeight);
                return;
            } else {
                SpenObjectShape spenObjectShape = (SpenObjectShape) selectedObject;
                if (info.isBlankShape) {
                    spenObjectShape.resetFillEffect();
                } else {
                    INSTANCE.changeFillEffect(spenObjectShape, info.fillColor);
                }
                INSTANCE.changeLineEffect(spenObjectShape, info.color, info.sizeLevel, canvasWidth, canvasHeight);
                return;
            }
        }
        SpenObjectStroke spenObjectStroke = (SpenObjectStroke) selectedObject;
        spenObjectStroke.setColor((spenObjectStroke.getColor() & (-16777216)) | (info.color & 16777215));
        String penName = spenObjectStroke.getPenName();
        if (penName == null) {
            return;
        }
        float fConvertSizeLevelToPxSize = convertSizeLevelToPxSize(penName, info.sizeLevel, canvasWidth, canvasHeight);
        spenObjectStroke.setPenSize(fConvertSizeLevelToPxSize);
        if (spenObjectStroke.isFixedWidthEnabled()) {
            spenObjectStroke.setFixedWidth(fConvertSizeLevelToPxSize);
        }
        Log.d(TAG, "changeStyle end");
    }
}
