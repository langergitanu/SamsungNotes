package com.samsung.android.sesl.extendImage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ExpandEdgeColorInfo {
    private int mAreaColor = VUtilString.GRAY;
    private int[] mEdgeColors = new int[0];
    private float[] mEdgeColorPositions = new float[0];
    private boolean mIsValid = false;
    private boolean mIsSolidColor = false;
    private int mMaxColorDistance = -1;

    private int calculateMaxColorDistance() {
        int[] iArr = this.mEdgeColors;
        if (iArr.length == 0) {
            return 0;
        }
        int i = this.mAreaColor;
        int i2 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = i & 255;
        int iMax = 0;
        for (int i6 : iArr) {
            iMax = Math.max(iMax, Math.max(Math.max(Math.abs(i2 - ((i6 >> 16) & 255)), Math.abs(i4 - ((i6 >> 8) & 255))), Math.abs(i5 - (i6 & 255))));
        }
        return iMax;
    }

    public void clear() {
        this.mAreaColor = VUtilString.GRAY;
        this.mEdgeColors = new int[0];
        this.mEdgeColorPositions = new float[0];
        this.mIsValid = false;
        this.mMaxColorDistance = -1;
    }

    public void copyFrom(@NonNull ExpandEdgeColorInfo expandEdgeColorInfo) {
        this.mAreaColor = expandEdgeColorInfo.mAreaColor;
        this.mEdgeColors = (int[]) expandEdgeColorInfo.mEdgeColors.clone();
        this.mEdgeColorPositions = (float[]) expandEdgeColorInfo.mEdgeColorPositions.clone();
        this.mIsSolidColor = expandEdgeColorInfo.mIsSolidColor;
        this.mIsValid = expandEdgeColorInfo.mIsValid;
        this.mMaxColorDistance = -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            ExpandEdgeColorInfo expandEdgeColorInfo = (ExpandEdgeColorInfo) obj;
            if (this.mAreaColor == expandEdgeColorInfo.mAreaColor && this.mIsValid == expandEdgeColorInfo.mIsValid && Arrays.equals(this.mEdgeColors, expandEdgeColorInfo.mEdgeColors) && Arrays.equals(this.mEdgeColorPositions, expandEdgeColorInfo.mEdgeColorPositions)) {
                return true;
            }
        }
        return false;
    }

    public int getAreaColor() {
        return this.mAreaColor;
    }

    public float[] getEdgeColorPositions() {
        float[] fArr = this.mEdgeColorPositions;
        return (fArr == null || 1 == fArr.length) ? new float[]{0.0f, 1.0f} : (float[]) fArr.clone();
    }

    public int[] getEdgeColors() {
        int[] iArr = this.mEdgeColors;
        if (iArr != null && 1 != iArr.length) {
            return (int[]) iArr.clone();
        }
        int i = this.mAreaColor;
        return new int[]{i, i};
    }

    public int getMaxColorDistance() {
        if (this.mMaxColorDistance == -1) {
            this.mMaxColorDistance = calculateMaxColorDistance();
        }
        return this.mMaxColorDistance;
    }

    public float[] getRawEdgeColorPositions() {
        return this.mEdgeColorPositions;
    }

    public int[] getRawEdgeColors() {
        return this.mEdgeColors;
    }

    public int getSize() {
        return this.mEdgeColors.length;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mAreaColor), Integer.valueOf(Arrays.hashCode(this.mEdgeColors)), Integer.valueOf(Arrays.hashCode(this.mEdgeColorPositions)), Boolean.valueOf(this.mIsValid));
    }

    public boolean isSolidColor() {
        return this.mIsSolidColor;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setValid(boolean z) {
        this.mIsValid = z;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ExpandEdgeColorInfo{areaColor=");
        sb.append(Integer.toHexString(this.mAreaColor));
        sb.append(", edgeColors=");
        sb.append(this.mEdgeColors.length);
        sb.append("/ ");
        sb.append(ColorConverter.toHexString(this.mEdgeColors));
        sb.append(", positions=");
        sb.append(this.mEdgeColorPositions.length);
        sb.append("/ ");
        sb.append(Arrays.toString(this.mEdgeColorPositions));
        sb.append(" isSolid=");
        sb.append(this.mIsSolidColor);
        sb.append(", isValid=");
        return AbstractC0622a.m1172r(sb, this.mIsValid, '}');
    }

    public void updateColorData(int i, @Nullable int[] iArr, @Nullable float[] fArr) {
        this.mAreaColor = i;
        boolean z = false;
        this.mEdgeColors = iArr != null ? (int[]) iArr.clone() : new int[0];
        this.mEdgeColorPositions = fArr != null ? (float[]) fArr.clone() : new float[0];
        int[] iArr2 = this.mEdgeColors;
        if (1 == iArr2.length && this.mAreaColor == iArr2[0]) {
            z = true;
        }
        this.mIsSolidColor = z;
        this.mIsValid = true;
        this.mMaxColorDistance = -1;
    }
}
