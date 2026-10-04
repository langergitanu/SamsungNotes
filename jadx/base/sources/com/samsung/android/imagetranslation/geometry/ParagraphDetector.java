package com.samsung.android.imagetranslation.geometry;

import android.graphics.Point;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ParagraphDetector {
    private ParagraphAlgorithm mMode = ParagraphAlgorithm.RANDOM_FOREST;

    /* JADX INFO: renamed from: com.samsung.android.imagetranslation.geometry.ParagraphDetector$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C71231 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$imagetranslation$geometry$ParagraphDetector$ParagraphAlgorithm */
        static final /* synthetic */ int[] f4781x96b3b697;

        static {
            int[] iArr = new int[ParagraphAlgorithm.values().length];
            f4781x96b3b697 = iArr;
            try {
                iArr[ParagraphAlgorithm.RANDOM_FOREST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4781x96b3b697[ParagraphAlgorithm.DATA_SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ParagraphAlgorithm {
        RANDOM_FOREST,
        DATA_SET
    }

    private boolean dataSet(Point[] pointArr, Point[] pointArr2, int i, int i2) {
        return false;
    }

    private boolean randomForest(Point[] pointArr, Point[] pointArr2, int i, int i2) {
        return false;
    }

    public boolean isSameParagraph(Point[] pointArr, Point[] pointArr2, int i, int i2) {
        int i4 = C71231.f4781x96b3b697[this.mMode.ordinal()];
        if (i4 == 1) {
            return randomForest(pointArr, pointArr2, i, i2);
        }
        if (i4 != 2) {
            return false;
        }
        return dataSet(pointArr, pointArr2, i, i2);
    }
}
