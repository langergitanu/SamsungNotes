package com.samsung.android.sesl.extendImage;

import android.util.Base64;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UShort;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ExpandAnalysisData {
    private static final int PATTERN_GRADIENT = 3;
    private static final int PATTERN_LINEAR = 2;
    private static final int PATTERN_RAW = 0;
    private static final int PATTERN_UNIFORM = 1;
    private static final String TAG = "ExpandAnalysisData";
    final ExpandEdgeColorInfo[] edgeColorInfo;
    private int mExtractedBitmapHeight;
    private int mExtractedBitmapWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ColorPattern {
        final int baseColor;
        final int endColor;
        final int stepColor;
        final int type;

        public ColorPattern(int i, int i2, int i4, int i5) {
            this.type = i;
            this.baseColor = i2;
            this.stepColor = i4;
            this.endColor = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PositionPattern {
        final float end;
        final float start;
        final float step;
        final int type;

        public PositionPattern(int i, float f, float f4, float f5) {
            this.type = i;
            this.start = f;
            this.step = f4;
            this.end = f5;
        }
    }

    public ExpandAnalysisData() {
        this.edgeColorInfo = new ExpandEdgeColorInfo[4];
        this.mExtractedBitmapWidth = 0;
        this.mExtractedBitmapHeight = 0;
        for (int i = 0; i < 4; i++) {
            this.edgeColorInfo[i] = new ExpandEdgeColorInfo();
        }
    }

    private static ColorPattern analyzeColorPattern(int[] iArr, int i) {
        int i2 = 0;
        if (i <= 1) {
            return new ColorPattern(1, i > 0 ? iArr[0] : 0, 0, 0);
        }
        int i4 = iArr[0];
        for (int i5 = 1; i5 < i; i5++) {
            if (iArr[i5] != i4) {
                int i6 = iArr[0];
                int i7 = i - 1;
                int i8 = iArr[i7];
                int i9 = (i6 >> 16) & 255;
                int i10 = (i6 >> 8) & 255;
                int i11 = i6 & 255;
                int i12 = (i8 >> 16) & 255;
                int i13 = (i8 >> 8) & 255;
                int i14 = i8 & 255;
                int i15 = 1;
                while (i15 < i7) {
                    float f = i15 / i7;
                    int i16 = (int) (((i12 - i9) * f) + i9 + 0.5f);
                    int i17 = (int) (((i13 - i10) * f) + i10 + 0.5f);
                    int i18 = (int) (((i14 - i11) * f) + i11 + 0.5f);
                    int i19 = iArr[i15];
                    int iAbs = Math.abs(((i19 >> 16) & 255) - i16);
                    int iAbs2 = Math.abs(((i19 >> 8) & 255) - i17);
                    int iAbs3 = Math.abs((i19 & 255) - i18);
                    if (iAbs > 1 || iAbs2 > 1 || iAbs3 > 1) {
                        return new ColorPattern(0, 0, 0, 0);
                    }
                    i15++;
                    i2 = 0;
                }
                return new ColorPattern(3, i6, i2, i8);
            }
        }
        return new ColorPattern(1, i4, 0, 0);
    }

    private static PositionPattern analyzePositionPattern(float[] fArr, int i) {
        if (i <= 1) {
            return new PositionPattern(1, i > 0 ? fArr[0] : 0.0f, 0.0f, 0.0f);
        }
        float f = fArr[0];
        for (int i2 = 1; i2 < i; i2++) {
            if (Math.abs(fArr[i2] - f) > 0.001f) {
                float f4 = fArr[0];
                int i4 = i - 1;
                float f5 = fArr[i4];
                float f6 = (f5 - f4) / i4;
                for (int i5 = 1; i5 < i; i5++) {
                    if (Math.abs(fArr[i5] - ((i5 * f6) + f4)) > 0.001f) {
                        return new PositionPattern(0, 0.0f, 0.0f, 0.0f);
                    }
                }
                return new PositionPattern(2, f4, f6, f5);
            }
        }
        return new PositionPattern(1, f, 0.0f, 0.0f);
    }

    private int calculateBufferSize() {
        int i = 5;
        for (int i2 = 0; i2 < 4; i2++) {
            ExpandEdgeColorInfo expandEdgeColorInfo = this.edgeColorInfo[i2];
            int[] edgeColors = expandEdgeColorInfo.getEdgeColors();
            float[] edgeColorPositions = expandEdgeColorInfo.getEdgeColorPositions();
            int iMin = Math.min(Math.min(edgeColors.length, edgeColorPositions.length), 15);
            int i4 = i + 4;
            ColorPattern colorPatternAnalyzeColorPattern = analyzeColorPattern(edgeColors, iMin);
            PositionPattern positionPatternAnalyzePositionPattern = analyzePositionPattern(edgeColorPositions, iMin);
            int i5 = colorPatternAnalyzeColorPattern.type;
            int i6 = i5 != 1 ? i5 != 3 ? (iMin * 3) + i4 : i + 10 : i + 7;
            int i7 = positionPatternAnalyzePositionPattern.type;
            i = i7 != 1 ? i7 != 2 ? i6 + iMin : i6 + 2 : i6 + 1;
        }
        return i;
    }

    private String getUltraCompressedString() {
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(calculateBufferSize());
            int iMin = Math.min(this.mExtractedBitmapWidth, 65535);
            int iMin2 = Math.min(this.mExtractedBitmapHeight, 65535);
            byteBufferAllocate.putShort((short) iMin);
            byteBufferAllocate.putShort((short) iMin2);
            int i = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.edgeColorInfo[i2].isValid()) {
                    i |= 1 << i2;
                }
            }
            byteBufferAllocate.put((byte) i);
            for (int i4 = 0; i4 < 4; i4++) {
                ExpandEdgeColorInfo expandEdgeColorInfo = this.edgeColorInfo[i4];
                int areaColor = expandEdgeColorInfo.getAreaColor();
                byteBufferAllocate.put((byte) (areaColor >>> 16));
                byteBufferAllocate.put((byte) (areaColor >>> 8));
                byteBufferAllocate.put((byte) areaColor);
                int[] rawEdgeColors = expandEdgeColorInfo.getRawEdgeColors();
                float[] rawEdgeColorPositions = expandEdgeColorInfo.getRawEdgeColorPositions();
                int iMin3 = Math.min(Math.min(rawEdgeColors.length, rawEdgeColorPositions.length), 15);
                ColorPattern colorPatternAnalyzeColorPattern = analyzeColorPattern(rawEdgeColors, iMin3);
                PositionPattern positionPatternAnalyzePositionPattern = analyzePositionPattern(rawEdgeColorPositions, iMin3);
                byteBufferAllocate.put((byte) ((iMin3 & 15) | ((colorPatternAnalyzeColorPattern.type & 3) << 4) | ((positionPatternAnalyzePositionPattern.type & 3) << 6)));
                packColors(byteBufferAllocate, rawEdgeColors, iMin3, colorPatternAnalyzeColorPattern);
                packPositions(byteBufferAllocate, rawEdgeColorPositions, iMin3, positionPatternAnalyzePositionPattern);
            }
            return Base64.encodeToString(byteBufferAllocate.array(), 10);
        } catch (Exception e) {
            Log.e(TAG, "Failed to create hyper-compressed format", e);
            return "";
        }
    }

    private static void packColors(ByteBuffer byteBuffer, int[] iArr, int i, ColorPattern colorPattern) {
        int i2 = colorPattern.type;
        if (i2 == 1) {
            byteBuffer.put((byte) (colorPattern.baseColor >>> 16));
            byteBuffer.put((byte) (colorPattern.baseColor >>> 8));
            byteBuffer.put((byte) colorPattern.baseColor);
            return;
        }
        if (i2 == 3) {
            byteBuffer.put((byte) (colorPattern.baseColor >>> 16));
            byteBuffer.put((byte) (colorPattern.baseColor >>> 8));
            byteBuffer.put((byte) colorPattern.baseColor);
            byteBuffer.put((byte) (colorPattern.endColor >>> 16));
            byteBuffer.put((byte) (colorPattern.endColor >>> 8));
            byteBuffer.put((byte) colorPattern.endColor);
            return;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = iArr[i4];
            byteBuffer.put((byte) (i5 >>> 16));
            byteBuffer.put((byte) (i5 >>> 8));
            byteBuffer.put((byte) i5);
        }
    }

    private static void packPositions(ByteBuffer byteBuffer, float[] fArr, int i, PositionPattern positionPattern) {
        int i2 = positionPattern.type;
        if (i2 == 1) {
            byteBuffer.put((byte) ((Math.max(0.0f, Math.min(1.0f, positionPattern.start)) * 127.0f) + 0.5f));
            return;
        }
        if (i2 != 2) {
            for (int i4 = 0; i4 < i; i4++) {
                byteBuffer.put((byte) ((Math.max(0.0f, Math.min(1.0f, fArr[i4])) * 127.0f) + 0.5f));
            }
            return;
        }
        int iMax = (int) ((Math.max(0.0f, Math.min(1.0f, positionPattern.start)) * 127.0f) + 0.5f);
        int iMax2 = (int) ((Math.max(-1.0f, Math.min(1.0f, positionPattern.step)) * 127.0f) + 0.5f);
        byteBuffer.put((byte) iMax);
        byteBuffer.put((byte) iMax2);
    }

    public static ExpandAnalysisData parse(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return parseUltraCompressed(str);
            } catch (Exception e) {
                Log.e(TAG, "Failed to parse ultra-compressed ExpandAnalysisData", e);
            }
        }
        return null;
    }

    private static ExpandAnalysisData parseUltraCompressed(String str) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(Base64.decode(str, 10));
            int i = byteBufferWrap.getShort() & UShort.MAX_VALUE;
            int i2 = 65535 & byteBufferWrap.getShort();
            ExpandEdgeColorInfo[] expandEdgeColorInfoArr = new ExpandEdgeColorInfo[4];
            int i4 = byteBufferWrap.get() & 255;
            for (int i5 = 0; i5 < 4; i5++) {
                expandEdgeColorInfoArr[i5] = new ExpandEdgeColorInfo();
                int i6 = ((byteBufferWrap.get() & 255) << 16) | (-16777216) | ((byteBufferWrap.get() & 255) << 8) | (byteBufferWrap.get() & 255);
                byte b = byteBufferWrap.get();
                int i7 = b & 255;
                int i8 = b & 15;
                int[] iArrUnpackColors = unpackColors(byteBufferWrap, i8, (i7 >> 4) & 3);
                float[] fArrUnpackPositions = unpackPositions(byteBufferWrap, i8, (i7 >> 6) & 3);
                boolean z = true;
                if (((1 << i5) & i4) == 0) {
                    z = false;
                }
                expandEdgeColorInfoArr[i5].updateColorData(i6, iArrUnpackColors, fArrUnpackPositions);
                expandEdgeColorInfoArr[i5].setValid(z);
            }
            return new ExpandAnalysisData(expandEdgeColorInfoArr, i, i2);
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse hyper-compressed format: " + e.getMessage());
            throw new IllegalArgumentException("Invalid hyper-compressed format", e);
        }
    }

    private static int[] unpackColors(ByteBuffer byteBuffer, int i, int i2) {
        int[] iArr = new int[i];
        if (i2 == 1) {
            Arrays.fill(iArr, (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 16) | (-16777216) | ((byteBuffer.get() & 255) << 8));
            return iArr;
        }
        int i4 = 0;
        if (i2 != 3) {
            while (i4 < i) {
                iArr[i4] = ((byteBuffer.get() & 255) << 16) | (-16777216) | ((byteBuffer.get() & 255) << 8) | (byteBuffer.get() & 255);
                i4++;
            }
        } else {
            int i5 = ((byteBuffer.get() & 255) << 16) | (-16777216) | ((byteBuffer.get() & 255) << 8) | (byteBuffer.get() & 255);
            int i6 = (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 16) | (-16777216) | ((byteBuffer.get() & 255) << 8);
            if (i == 1) {
                iArr[0] = i5;
                return iArr;
            }
            int i7 = (i5 >> 16) & 255;
            int i8 = (i5 >> 8) & 255;
            int i9 = i5 & 255;
            int i10 = (i6 >> 16) & 255;
            int i11 = (i6 >> 8) & 255;
            int i12 = i6 & 255;
            while (i4 < i) {
                float f = i4 / (i - 1);
                iArr[i4] = ((int) (((i12 - i9) * f) + i9 + 0.5f)) | (((int) ((((i10 - i7) * f) + i7) + 0.5f)) << 16) | (-16777216) | (((int) ((((i11 - i8) * f) + i8) + 0.5f)) << 8);
                i4++;
            }
        }
        return iArr;
    }

    private static float[] unpackPositions(ByteBuffer byteBuffer, int i, int i2) {
        float[] fArr = new float[i];
        if (i2 == 1) {
            Arrays.fill(fArr, (byteBuffer.get() & 127) / 127.0f);
            return fArr;
        }
        int i4 = 0;
        if (i2 != 2) {
            while (i4 < i) {
                fArr[i4] = (byteBuffer.get() & 127) / 127.0f;
                i4++;
            }
        } else {
            float f = (byteBuffer.get() & 127) / 127.0f;
            float f4 = (byteBuffer.get() & 127) / 127.0f;
            while (i4 < i) {
                fArr[i4] = Math.max(0.0f, Math.min(1.0f, (i4 * f4) + f));
                i4++;
            }
        }
        return fArr;
    }

    public ExpandEdgeColorInfo[] getAllEdgeColorInfos() {
        return this.edgeColorInfo;
    }

    public int getExtractedBitmapHeight() {
        return this.mExtractedBitmapHeight;
    }

    public int getExtractedBitmapWidth() {
        return this.mExtractedBitmapWidth;
    }

    public String getString() {
        return getUltraCompressedString();
    }

    public boolean isValid() {
        for (ExpandEdgeColorInfo expandEdgeColorInfo : this.edgeColorInfo) {
            if (!expandEdgeColorInfo.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void setExtractedBitmapSize(int i, int i2) {
        this.mExtractedBitmapWidth = i;
        this.mExtractedBitmapHeight = i2;
    }

    public ExpandAnalysisData(ExpandEdgeColorInfo[] expandEdgeColorInfoArr, int i, int i2) {
        this.edgeColorInfo = new ExpandEdgeColorInfo[4];
        this.mExtractedBitmapWidth = 0;
        this.mExtractedBitmapHeight = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            this.edgeColorInfo[i4] = new ExpandEdgeColorInfo();
        }
        this.mExtractedBitmapWidth = i;
        this.mExtractedBitmapHeight = i2;
        for (int i5 = 0; i5 < Math.min(expandEdgeColorInfoArr.length, 4); i5++) {
            this.edgeColorInfo[i5].copyFrom(expandEdgeColorInfoArr[i5]);
        }
    }

    public ExpandAnalysisData(ExpandAnalysisData expandAnalysisData) {
        this.edgeColorInfo = new ExpandEdgeColorInfo[4];
        this.mExtractedBitmapWidth = 0;
        this.mExtractedBitmapHeight = 0;
        for (int i = 0; i < 4; i++) {
            this.edgeColorInfo[i] = new ExpandEdgeColorInfo();
        }
        this.mExtractedBitmapWidth = expandAnalysisData.mExtractedBitmapWidth;
        this.mExtractedBitmapHeight = expandAnalysisData.mExtractedBitmapHeight;
        for (int i2 = 0; i2 < 4; i2++) {
            this.edgeColorInfo[i2].copyFrom(expandAnalysisData.edgeColorInfo[i2]);
        }
    }
}
