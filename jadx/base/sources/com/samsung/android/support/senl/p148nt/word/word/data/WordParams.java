package com.samsung.android.support.senl.p148nt.word.word.data;

import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0015\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0012H\u0014¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/data/WordParams;", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "<init>", "()V", "isLongPage", "", "(Z)V", "sizeInWords", "", "setMargin", "", "left", "", "top", "right", "bottom", "configFontSize", "getSizesRecognize", "", "()[Ljava/lang/Integer;", "getFontSize", "", "fontSize", "getTextRecognizeDefaultFontSize", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WordParams extends OfficeParams {
    public static final int INCH_TO_DP = 160;
    public static final double LEFT_INDENTATION = -42.0d;
    public static final double LONG_INDENTATION = -237.0d;
    public static final int MARGIN = 36;
    public static final double MARGIN_TOP = 0.0d;
    public static final double NORMAL_INDENTATION = -42.0d;
    public static final int TEXT_RECOGNIZE_DEFAULT_FONT_SIZE = 20;

    @Nullable
    private static HashMap<Integer, Integer> sSize;
    private double[] sizeInWords;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final int[] sizeInNotes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 32, 33, 35, 36, 37, 39, 40, 41, 43, 44, 45, 47, 48, 49, 51, 52, 53, 55, 56, 57, 59, 60, 61, 64, 65, 69};

    @NotNull
    private static final double[] sizeInNormal = {1.5d, 3.5d, 5.0d, 7.0d, 9.0d, 10.5d, 12.5d, 14.5d, 16.0d, 18.0d, 20.0d, 21.5d, 23.5d, 25.5d, 27.0d, 29.5d, 30.5d, 32.5d, 34.0d, 36.0d, 37.5d, 40.0d, 43.0d, 43.5d, 44.5d, 48.5d, 49.0d, 53.0d, 54.5d, 58.0d, 59.0d, 61.0d, 64.0d, 64.0d, 66.0d, 69.0d, 75.0d, 75.0d, 76.0d, 78.5d, 80.0d, 84.0d, 88.5d, 88.5d, 89.0d, 92.0d, 93.0d, 95.0d, 95.0d, 95.0d, 95.0d, 96.0d, 96.0d, 115.0d, 115.0d, 120.0d};

    @NotNull
    private static final double[] sizeInLong = {1.0d, 2.5d, 3.5d, 5.0d, 6.0d, 7.5d, 8.5d, 10.0d, 11.0d, 12.5d, 13.5d, 15.0d, 16.5d, 17.5d, 19.0d, 20.0d, 21.0d, 23.0d, 24.0d, 25.5d, 26.5d, 28.0d, 29.0d, 30.0d, 30.5d, 33.5d, 33.5d, 35.5d, 37.0d, 39.0d, 41.0d, 42.0d, 44.0d, 44.0d, 46.0d, 48.0d, 51.5d, 54.5d, 54.5d, 55.5d, 56.0d, 57.5d, 60.0d, 60.0d, 62.0d, 68.0d, 69.0d, 69.0d, 70.0d, 72.0d, 72.0d, 76.0d, 76.0d, 78.5d, 80.0d, 85.0d};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/data/WordParams$Companion;", "", "<init>", "()V", "MARGIN", "", "MARGIN_TOP", "", "NORMAL_INDENTATION", "LONG_INDENTATION", "LEFT_INDENTATION", "TEXT_RECOGNIZE_DEFAULT_FONT_SIZE", "INCH_TO_DP", "sizeInNotes", "", "sizeInNormal", "", "sizeInLong", "sSize", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSSize", "()Ljava/util/HashMap;", "setSSize", "(Ljava/util/HashMap;)V", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final HashMap<Integer, Integer> getSSize() {
            return WordParams.sSize;
        }

        public final void setSSize(@Nullable HashMap<Integer, Integer> map) {
            WordParams.sSize = map;
        }

        private Companion() {
        }
    }

    public WordParams() {
        this.width = 1323;
        this.height = 1870;
        configFontSize();
    }

    private final void configFontSize() {
        sSize = new HashMap<>();
        int length = sizeInNotes.length;
        for (int i = 0; i < length; i++) {
            Integer numValueOf = Integer.valueOf(i);
            HashMap<Integer, Integer> map = sSize;
            Intrinsics.checkNotNull(map);
            map.put(Integer.valueOf(sizeInNotes[i]), numValueOf);
        }
    }

    private final void setMargin(int left, int top, int right, int bottom) {
        this.marginLeft = left;
        this.marginRight = right;
        this.marginTop = top;
        this.marginBottom = bottom;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.data.OfficeParams
    public double getFontSize(int fontSize) {
        int iCoerceAtLeast = RangesKt.coerceAtLeast(fontSize - getFontSizeDelta(), sizeInNotes[0]);
        while (true) {
            HashMap<Integer, Integer> map = sSize;
            Intrinsics.checkNotNull(map);
            if (map.containsKey(Integer.valueOf(iCoerceAtLeast))) {
                break;
            }
            iCoerceAtLeast--;
        }
        double[] dArr = this.sizeInWords;
        if (dArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sizeInWords");
            dArr = null;
        }
        HashMap<Integer, Integer> map2 = sSize;
        Intrinsics.checkNotNull(map2);
        Integer num = map2.get(Integer.valueOf(iCoerceAtLeast));
        Intrinsics.checkNotNull(num);
        return dArr[num.intValue()];
    }

    @Override // com.samsung.android.support.senl.p148nt.word.data.OfficeParams
    @NotNull
    public Integer[] getSizesRecognize() {
        return new Integer[0];
    }

    @Override // com.samsung.android.support.senl.p148nt.word.data.OfficeParams
    public int getTextRecognizeDefaultFontSize() {
        return 20;
    }

    public WordParams(boolean z) {
        this.width = 1323;
        this.height = 1870;
        if (z) {
            setMargin(2130, 0, 2130, 270);
            this.bgLeftIndentation = -237.0d;
            this.sizeInWords = sizeInLong;
        } else {
            setMargin(375, 0, 375, 270);
            this.bgLeftIndentation = -42.0d;
            this.sizeInWords = sizeInNormal;
        }
        configFontSize();
    }
}
