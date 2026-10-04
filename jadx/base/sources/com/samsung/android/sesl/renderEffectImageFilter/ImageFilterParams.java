package com.samsung.android.sesl.renderEffectImageFilter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImageFilterParams {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BGColorAdjustment {
        public float amount = 0.0f;
        public float minLevel = 0.0f;
        public float maxLevel = 1.0f;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Direction {
        UP(0),
        RIGHT(1),
        DOWN(2),
        LEFT(3);

        private int type;

        Direction(int i) {
            this.type = i;
        }

        public int getNumericType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GradientBlur {
        public float direction = 0.0f;
        public float percent = 0.0f;
        public float pivotPercent = 0.0f;

        /* JADX INFO: renamed from: p1 */
        public float f5259p1 = 0.42f;

        /* JADX INFO: renamed from: p2 */
        public float f5260p2 = 0.58f;
        public OverlayType overlayType = OverlayType.NORMAL;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GradientColor {
        public Direction direction;
        public float percent = 0.0f;
        public float pivotPercent = 0.0f;
        public float pivotAlphaPercent = 0.0f;
        public float controlP1 = 0.47f;
        public float controlP2 = 0.58f;
        public int[] colors = {-16776961, 65535};
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OffsetTransition {
        public Direction direction;
        public float percent = 0.0f;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum OverlayType {
        NORMAL(0),
        OVERLAY(1),
        MASK(2);

        private int type;

        OverlayType(int i) {
            this.type = i;
        }

        public int getNumericType() {
            return this.type;
        }
    }
}
