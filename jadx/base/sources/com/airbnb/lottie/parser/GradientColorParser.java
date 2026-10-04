package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class GradientColorParser implements ValueParser<GradientColor> {
    private int colorPoints;

    public GradientColorParser(int i) {
        this.colorPoints = i;
    }

    private GradientColor addOpacityStopsToGradientIfNeeded(GradientColor gradientColor, List<Float> list) {
        int i = this.colorPoints * 4;
        if (list.size() <= i) {
            return gradientColor;
        }
        float[] positions = gradientColor.getPositions();
        int[] colors = gradientColor.getColors();
        int size = (list.size() - i) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                fArr[i2] = list.get(i).floatValue();
            } else {
                fArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        float[] fArrMergeUniqueElements = mergeUniqueElements(gradientColor.getPositions(), fArr);
        int length = fArrMergeUniqueElements.length;
        int[] iArr = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            float f = fArrMergeUniqueElements[i4];
            int iBinarySearch = Arrays.binarySearch(positions, f);
            int iBinarySearch2 = Arrays.binarySearch(fArr, f);
            if (iBinarySearch < 0 || iBinarySearch2 > 0) {
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = -(iBinarySearch2 + 1);
                }
                iArr[i4] = getColorInBetweenColorStops(f, fArr2[iBinarySearch2], positions, colors);
            } else {
                iArr[i4] = getColorInBetweenOpacityStops(f, colors[iBinarySearch], fArr, fArr2);
            }
        }
        return new GradientColor(fArrMergeUniqueElements, iArr);
    }

    private int getColorInBetweenOpacityStops(float f, int i, float[] fArr, float[] fArr2) {
        float fLerp;
        if (fArr2.length < 2 || f <= fArr[0]) {
            return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
        }
        for (int i2 = 1; i2 < fArr.length; i2++) {
            float f4 = fArr[i2];
            if (f4 >= f || i2 == fArr.length - 1) {
                if (f4 <= f) {
                    fLerp = fArr2[i2];
                } else {
                    int i4 = i2 - 1;
                    float f5 = fArr[i4];
                    fLerp = MiscUtils.lerp(fArr2[i4], fArr2[i2], (f - f5) / (f4 - f5));
                }
                return Color.argb((int) (fLerp * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    public static float[] mergeUniqueElements(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i = 0;
        int i2 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            float f = i2 < fArr.length ? fArr[i2] : Float.NaN;
            float f4 = i4 < fArr2.length ? fArr2[i4] : Float.NaN;
            if (Float.isNaN(f4) || f < f4) {
                fArr3[i5] = f;
                i2++;
            } else if (Float.isNaN(f) || f4 < f) {
                fArr3[i5] = f4;
                i4++;
            } else {
                fArr3[i5] = f;
                i2++;
                i4++;
                i++;
            }
        }
        return i == 0 ? fArr3 : Arrays.copyOf(fArr3, length - i);
    }

    public int getColorInBetweenColorStops(float f, float f4, float[] fArr, int[] iArr) {
        if (iArr.length < 2 || f == fArr[0]) {
            return iArr[0];
        }
        for (int i = 1; i < fArr.length; i++) {
            float f5 = fArr[i];
            if (f5 >= f || i == fArr.length - 1) {
                if (i == fArr.length - 1 && f >= f5) {
                    return Color.argb((int) (f4 * 255.0f), Color.red(iArr[i]), Color.green(iArr[i]), Color.blue(iArr[i]));
                }
                int i2 = i - 1;
                float f6 = fArr[i2];
                int iEvaluate = GammaEvaluator.evaluate((f - f6) / (f5 - f6), iArr[i2], iArr[i]);
                return Color.argb((int) (f4 * 255.0f), Color.red(iEvaluate), Color.green(iEvaluate), Color.blue(iEvaluate));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf  */
    @Override // com.airbnb.lottie.parser.ValueParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GradientColor parse(JsonReader jsonReader, float f) {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.colorPoints = 2;
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = arrayList.size() / 4;
        }
        int i = this.colorPoints;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.colorPoints * 4; i5++) {
            int i6 = i5 / 4;
            double dFloatValue = ((Float) arrayList.get(i5)).floatValue();
            int i7 = i5 % 4;
            if (i7 != 0) {
                if (i7 == 1) {
                    i2 = (int) (dFloatValue * 255.0d);
                } else if (i7 == 2) {
                    i4 = (int) (dFloatValue * 255.0d);
                } else if (i7 == 3) {
                    iArr[i6] = Color.argb(255, i2, i4, (int) (dFloatValue * 255.0d));
                }
            } else if (i6 > 0) {
                float f4 = (float) dFloatValue;
                if (fArr[i6 - 1] >= f4) {
                    fArr[i6] = f4 + 0.01f;
                } else {
                    fArr[i6] = (float) dFloatValue;
                }
            }
        }
        return addOpacityStopsToGradientIfNeeded(new GradientColor(fArr, iArr), arrayList);
    }
}
