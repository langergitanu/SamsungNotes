package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.java.awt.BorderLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionPatternDetector;", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionPatternDetector$Listener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionPatternDetector$Listener;)V", "mPatternMatchingData", "", "mPatternStartTime", "", "mListener", "mViewWidth", "", "mViewHeight", "setViewSize", "", "width", "height", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "checkPatternElement", "Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionPatternDetector$PatternElement;", "e", "matchPattern", "currentPattern", "close", "Listener", "PatternElement", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenWritingOptionPatternDetector {
    private static final long PATTERN_EXPIRED_TIME = 6000;

    @NotNull
    private static final String TAG = "OptionPatternDetector";

    @NotNull
    private static final PatternElement[] mPattern;

    @Nullable
    private Listener mListener;

    @NotNull
    private final boolean[] mPatternMatchingData;

    @NotNull
    private final long[] mPatternStartTime;
    private int mViewHeight;
    private int mViewWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionPatternDetector$Listener;", "", "onPatternMatched", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface Listener {
        void onPatternMatched();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionPatternDetector$PatternElement;", "", "<init>", "(Ljava/lang/String;I)V", "LeftTop", "Top", "RightTop", "Left", BorderLayout.CENTER, "Right", "LeftBottom", "Bottom", "RightBottom", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class PatternElement {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PatternElement[] $VALUES;
        public static final PatternElement LeftTop = new PatternElement("LeftTop", 0);
        public static final PatternElement Top = new PatternElement("Top", 1);
        public static final PatternElement RightTop = new PatternElement("RightTop", 2);
        public static final PatternElement Left = new PatternElement("Left", 3);
        public static final PatternElement Center = new PatternElement(BorderLayout.CENTER, 4);
        public static final PatternElement Right = new PatternElement("Right", 5);
        public static final PatternElement LeftBottom = new PatternElement("LeftBottom", 6);
        public static final PatternElement Bottom = new PatternElement("Bottom", 7);
        public static final PatternElement RightBottom = new PatternElement("RightBottom", 8);

        private static final /* synthetic */ PatternElement[] $values() {
            return new PatternElement[]{LeftTop, Top, RightTop, Left, Center, Right, LeftBottom, Bottom, RightBottom};
        }

        static {
            PatternElement[] patternElementArr$values = $values();
            $VALUES = patternElementArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(patternElementArr$values);
        }

        private PatternElement(String str, int i) {
        }

        @NotNull
        public static EnumEntries<PatternElement> getEntries() {
            return $ENTRIES;
        }

        public static PatternElement valueOf(String str) {
            return (PatternElement) Enum.valueOf(PatternElement.class, str);
        }

        public static PatternElement[] values() {
            return (PatternElement[]) $VALUES.clone();
        }
    }

    static {
        PatternElement patternElement = PatternElement.LeftTop;
        PatternElement patternElement2 = PatternElement.Right;
        PatternElement patternElement3 = PatternElement.Top;
        PatternElement patternElement4 = PatternElement.Left;
        PatternElement patternElement5 = PatternElement.RightBottom;
        PatternElement patternElement6 = PatternElement.Center;
        PatternElement patternElement7 = PatternElement.LeftBottom;
        PatternElement patternElement8 = PatternElement.Bottom;
        PatternElement patternElement9 = PatternElement.RightTop;
        mPattern = new PatternElement[]{patternElement, patternElement2, patternElement3, patternElement4, patternElement5, patternElement6, patternElement7, patternElement8, patternElement9, patternElement, patternElement2, patternElement3, patternElement4, patternElement5, patternElement6, patternElement7, patternElement8, patternElement9};
    }

    public SpenWritingOptionPatternDetector(@Nullable Context context, @Nullable Listener listener) {
        PatternElement[] patternElementArr = mPattern;
        boolean[] zArr = new boolean[patternElementArr.length];
        this.mPatternMatchingData = zArr;
        long[] jArr = new long[patternElementArr.length];
        this.mPatternStartTime = jArr;
        this.mListener = listener;
        Arrays.fill(zArr, false);
        Arrays.fill(jArr, 0L);
    }

    @NotNull
    public final PatternElement checkPatternElement(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        float x = e.getX();
        float y2 = e.getY();
        double d = x;
        int i = this.mViewWidth;
        if (d < ((double) i) * 0.33d) {
            double d2 = y2;
            int i2 = this.mViewHeight;
            return d2 < ((double) i2) * 0.33d ? PatternElement.LeftTop : d2 < ((double) i2) * 0.66d ? PatternElement.Left : PatternElement.LeftBottom;
        }
        if (d < ((double) i) * 0.66d) {
            double d3 = y2;
            int i4 = this.mViewHeight;
            return d3 < ((double) i4) * 0.33d ? PatternElement.Top : d3 < ((double) i4) * 0.66d ? PatternElement.Center : PatternElement.Bottom;
        }
        double d4 = y2;
        int i5 = this.mViewHeight;
        return d4 < ((double) i5) * 0.33d ? PatternElement.RightTop : d4 < ((double) i5) * 0.66d ? PatternElement.Right : PatternElement.RightBottom;
    }

    public final void close() {
        this.mListener = null;
    }

    public final boolean matchPattern(@NotNull PatternElement currentPattern) {
        Intrinsics.checkNotNullParameter(currentPattern, "currentPattern");
        int length = mPattern.length - 1;
        while (true) {
            boolean z = false;
            if (length <= 0) {
                break;
            }
            boolean[] zArr = this.mPatternMatchingData;
            int i = length - 1;
            if (zArr[i] && currentPattern == mPattern[length]) {
                z = true;
            }
            zArr[length] = z;
            long[] jArr = this.mPatternStartTime;
            jArr[length] = jArr[i];
            length--;
        }
        PatternElement[] patternElementArr = mPattern;
        if (!(patternElementArr.length == 0)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long[] jArr2 = this.mPatternStartTime;
            jArr2[0] = jCurrentTimeMillis;
            boolean[] zArr2 = this.mPatternMatchingData;
            zArr2[0] = currentPattern == patternElementArr[0];
            if (jCurrentTimeMillis - jArr2[patternElementArr.length - 1] < PATTERN_EXPIRED_TIME && zArr2[patternElementArr.length - 1]) {
                return true;
            }
        }
        return false;
    }

    public final boolean onTouchEvent(@NotNull MotionEvent event) {
        Listener listener;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 1 || !matchPattern(checkPatternElement(event)) || (listener = this.mListener) == null) {
            return false;
        }
        listener.onPatternMatched();
        return false;
    }

    public final void setViewSize(int width, int height) {
        this.mViewWidth = width;
        this.mViewHeight = height;
    }
}
