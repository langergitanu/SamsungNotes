package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
final class ColorCutQuantizer {
    static final int COMPONENT_BLUE = -1;
    static final int COMPONENT_GREEN = -2;
    static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() { // from class: androidx.palette.graphics.ColorCutQuantizer.1
        @Override // java.util.Comparator
        public int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.getVolume() - vbox.getVolume();
        }
    };
    final int[] mColors;
    final Palette.Filter[] mFilters;
    final int[] mHistogram;
    final List<Palette.Swatch> mQuantizedColors;
    private final float[] mTempHsl = new float[3];

    @Nullable
    final TimingLogger mTimingLogger = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Vbox {
        private int mLowerIndex;
        private int mMaxBlue;
        private int mMaxGreen;
        private int mMaxRed;
        private int mMinBlue;
        private int mMinGreen;
        private int mMinRed;
        private int mPopulation;
        private int mUpperIndex;

        public Vbox(int i, int i2) {
            this.mLowerIndex = i;
            this.mUpperIndex = i2;
            fitBox();
        }

        public final boolean canSplit() {
            return getColorCount() > 1;
        }

        public final int findSplitPoint() {
            int longestColorDimension = getLongestColorDimension();
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.mColors;
            int[] iArr2 = colorCutQuantizer.mHistogram;
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(iArr, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            int i = this.mPopulation / 2;
            int i2 = this.mLowerIndex;
            int i4 = 0;
            while (true) {
                int i5 = this.mUpperIndex;
                if (i2 > i5) {
                    return this.mLowerIndex;
                }
                i4 += iArr2[iArr[i2]];
                if (i4 >= i) {
                    return Math.min(i5 - 1, i2);
                }
                i2++;
            }
        }

        public final void fitBox() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.mColors;
            int[] iArr2 = colorCutQuantizer.mHistogram;
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = 0;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MAX_VALUE;
            for (int i9 = this.mLowerIndex; i9 <= this.mUpperIndex; i9++) {
                int i10 = iArr[i9];
                i6 += iArr2[i10];
                int iQuantizedRed = ColorCutQuantizer.quantizedRed(i10);
                int iQuantizedGreen = ColorCutQuantizer.quantizedGreen(i10);
                int iQuantizedBlue = ColorCutQuantizer.quantizedBlue(i10);
                if (iQuantizedRed > i2) {
                    i2 = iQuantizedRed;
                }
                if (iQuantizedRed < i) {
                    i = iQuantizedRed;
                }
                if (iQuantizedGreen > i4) {
                    i4 = iQuantizedGreen;
                }
                if (iQuantizedGreen < i7) {
                    i7 = iQuantizedGreen;
                }
                if (iQuantizedBlue > i5) {
                    i5 = iQuantizedBlue;
                }
                if (iQuantizedBlue < i8) {
                    i8 = iQuantizedBlue;
                }
            }
            this.mMinRed = i;
            this.mMaxRed = i2;
            this.mMinGreen = i7;
            this.mMaxGreen = i4;
            this.mMinBlue = i8;
            this.mMaxBlue = i5;
            this.mPopulation = i6;
        }

        public final Palette.Swatch getAverageColor() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.mColors;
            int[] iArr2 = colorCutQuantizer.mHistogram;
            int iQuantizedRed = 0;
            int i = 0;
            int iQuantizedGreen = 0;
            int iQuantizedBlue = 0;
            for (int i2 = this.mLowerIndex; i2 <= this.mUpperIndex; i2++) {
                int i4 = iArr[i2];
                int i5 = iArr2[i4];
                i += i5;
                iQuantizedRed += ColorCutQuantizer.quantizedRed(i4) * i5;
                iQuantizedGreen += ColorCutQuantizer.quantizedGreen(i4) * i5;
                iQuantizedBlue += i5 * ColorCutQuantizer.quantizedBlue(i4);
            }
            float f = i;
            return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(Math.round(iQuantizedRed / f), Math.round(iQuantizedGreen / f), Math.round(iQuantizedBlue / f)), i);
        }

        public final int getColorCount() {
            return (this.mUpperIndex + 1) - this.mLowerIndex;
        }

        public final int getLongestColorDimension() {
            int i = this.mMaxRed - this.mMinRed;
            int i2 = this.mMaxGreen - this.mMinGreen;
            int i4 = this.mMaxBlue - this.mMinBlue;
            if (i < i2 || i < i4) {
                return (i2 < i || i2 < i4) ? -1 : -2;
            }
            return -3;
        }

        public final int getVolume() {
            return ((this.mMaxBlue - this.mMinBlue) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxRed - this.mMinRed) + 1);
        }

        public final Vbox splitBox() {
            if (!canSplit()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int iFindSplitPoint = findSplitPoint();
            Vbox vbox = ColorCutQuantizer.this.new Vbox(iFindSplitPoint + 1, this.mUpperIndex);
            this.mUpperIndex = iFindSplitPoint;
            fitBox();
            return vbox;
        }
    }

    public ColorCutQuantizer(int[] iArr, int i, Palette.Filter[] filterArr) {
        this.mFilters = filterArr;
        int[] iArr2 = new int[32768];
        this.mHistogram = iArr2;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int iQuantizeFromRgb888 = quantizeFromRgb888(iArr[i2]);
            iArr[i2] = iQuantizeFromRgb888;
            iArr2[iQuantizeFromRgb888] = iArr2[iQuantizeFromRgb888] + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 32768; i5++) {
            if (iArr2[i5] > 0 && shouldIgnoreColor(i5)) {
                iArr2[i5] = 0;
            }
            if (iArr2[i5] > 0) {
                i4++;
            }
        }
        int[] iArr3 = new int[i4];
        this.mColors = iArr3;
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                iArr3[i6] = i7;
                i6++;
            }
        }
        if (i4 > i) {
            this.mQuantizedColors = quantizePixels(i);
            return;
        }
        this.mQuantizedColors = new ArrayList();
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = iArr3[i8];
            this.mQuantizedColors.add(new Palette.Swatch(approximateToRgb888(i9), iArr2[i9]));
        }
    }

    public static int approximateToRgb888(int i, int i2, int i4) {
        return Color.rgb(modifyWordWidth(i, 5, 8), modifyWordWidth(i2, 5, 8), modifyWordWidth(i4, 5, 8));
    }

    private List<Palette.Swatch> generateAverageColors(Collection<Vbox> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<Vbox> it = collection.iterator();
        while (it.hasNext()) {
            Palette.Swatch averageColor = it.next().getAverageColor();
            if (!shouldIgnoreColor(averageColor)) {
                arrayList.add(averageColor);
            }
        }
        return arrayList;
    }

    public static void modifySignificantOctet(int[] iArr, int i, int i2, int i4) {
        if (i == -2) {
            while (i2 <= i4) {
                int i5 = iArr[i2];
                iArr[i2] = quantizedBlue(i5) | (quantizedGreen(i5) << 10) | (quantizedRed(i5) << 5);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i4) {
            int i6 = iArr[i2];
            iArr[i2] = quantizedRed(i6) | (quantizedBlue(i6) << 10) | (quantizedGreen(i6) << 5);
            i2++;
        }
    }

    private static int modifyWordWidth(int i, int i2, int i4) {
        return (i4 > i2 ? i << (i4 - i2) : i >> (i2 - i4)) & ((1 << i4) - 1);
    }

    private static int quantizeFromRgb888(int i) {
        return modifyWordWidth(Color.blue(i), 8, 5) | (modifyWordWidth(Color.red(i), 8, 5) << 10) | (modifyWordWidth(Color.green(i), 8, 5) << 5);
    }

    private List<Palette.Swatch> quantizePixels(int i) {
        PriorityQueue<Vbox> priorityQueue = new PriorityQueue<>(i, VBOX_COMPARATOR_VOLUME);
        priorityQueue.offer(new Vbox(0, this.mColors.length - 1));
        splitBoxes(priorityQueue, i);
        return generateAverageColors(priorityQueue);
    }

    public static int quantizedBlue(int i) {
        return i & 31;
    }

    public static int quantizedGreen(int i) {
        return (i >> 5) & 31;
    }

    public static int quantizedRed(int i) {
        return (i >> 10) & 31;
    }

    private boolean shouldIgnoreColor(int i) {
        int iApproximateToRgb888 = approximateToRgb888(i);
        ColorUtils.colorToHSL(iApproximateToRgb888, this.mTempHsl);
        return shouldIgnoreColor(iApproximateToRgb888, this.mTempHsl);
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i) {
        Vbox vboxPoll;
        while (priorityQueue.size() < i && (vboxPoll = priorityQueue.poll()) != null && vboxPoll.canSplit()) {
            priorityQueue.offer(vboxPoll.splitBox());
            priorityQueue.offer(vboxPoll);
        }
    }

    public List<Palette.Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }

    private boolean shouldIgnoreColor(Palette.Swatch swatch) {
        return shouldIgnoreColor(swatch.getRgb(), swatch.getHsl());
    }

    private static int approximateToRgb888(int i) {
        return approximateToRgb888(quantizedRed(i), quantizedGreen(i), quantizedBlue(i));
    }

    private boolean shouldIgnoreColor(int i, float[] fArr) {
        Palette.Filter[] filterArr = this.mFilters;
        if (filterArr != null && filterArr.length > 0) {
            int length = filterArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!this.mFilters[i2].isAllowed(i, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
