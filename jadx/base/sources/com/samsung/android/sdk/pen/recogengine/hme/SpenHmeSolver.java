package com.samsung.android.sdk.pen.recogengine.hme;

import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\nJ\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\tj\b\u0012\u0004\u0012\u00020\u000e`\u000b2\u0006\u0010\f\u001a\u00020\nJ6\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeSolver;", "", "<init>", "()V", "mNativeHandle", "", "close", "", "solve", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", HtmlConstants.LATEX, "calculate", "Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeSolverPair;", "setSettingParams", "angleUnit", "", "decimalDigits", "maxDigitsDecimalNotation", "jlocale", "decimalSeparator", "", "thousandsSeparator", "AngleUnit", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeSolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenHmeLineSplitter";
    private long mNativeHandle = INSTANCE.Native_init();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeSolver$AngleUnit;", "", "<init>", "(Ljava/lang/String;I)V", "RADIAN", "DEGREE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AngleUnit {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AngleUnit[] $VALUES;
        public static final AngleUnit RADIAN = new AngleUnit("RADIAN", 0);
        public static final AngleUnit DEGREE = new AngleUnit("DEGREE", 1);

        private static final /* synthetic */ AngleUnit[] $values() {
            return new AngleUnit[]{RADIAN, DEGREE};
        }

        static {
            AngleUnit[] angleUnitArr$values = $values();
            $VALUES = angleUnitArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(angleUnitArr$values);
        }

        private AngleUnit(String str, int i) {
        }

        @NotNull
        public static EnumEntries<AngleUnit> getEntries() {
            return $ENTRIES;
        }

        public static AngleUnit valueOf(String str) {
            return (AngleUnit) Enum.valueOf(AngleUnit.class, str);
        }

        public static AngleUnit[] values() {
            return (AngleUnit[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J)\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\r2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0083 J)\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\r2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0083 JA\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeSolver$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "Native_finalize", "", "nativeHandle", "Native_solve", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", HtmlConstants.LATEX, "Native_calculate", "Lcom/samsung/android/sdk/pen/recogengine/hme/SpenHmeSolverPair;", "Native_setSettingParams", "angleUnit", "", "decimalDigits", "maxDigitsDecimalNotation", "jlocale", "decimalSeparator", "", "thousandsSeparator", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenHmeSolverPair> Native_calculate(long nativeHandle, String latex) {
            return SpenHmeSolver.Native_calculate(nativeHandle, latex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenHmeSolver.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init() {
            return SpenHmeSolver.Native_init();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSettingParams(long nativeHandle, int angleUnit, int decimalDigits, int maxDigitsDecimalNotation, String jlocale, char decimalSeparator, char thousandsSeparator) {
            SpenHmeSolver.Native_setSettingParams(nativeHandle, angleUnit, decimalDigits, maxDigitsDecimalNotation, jlocale, decimalSeparator, thousandsSeparator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<String> Native_solve(long nativeHandle, String latex) {
            return SpenHmeSolver.Native_solve(nativeHandle, latex);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenHmeSolverPair> Native_calculate(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSettingParams(long j, int i, int i2, int i4, String str, char c, char c2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<String> Native_solve(long j, String str);

    @NotNull
    public final ArrayList<SpenHmeSolverPair> calculate(@NotNull String latex) {
        Intrinsics.checkNotNullParameter(latex, "latex");
        return INSTANCE.Native_calculate(this.mNativeHandle, latex);
    }

    public final void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    public final void setSettingParams(int angleUnit, int decimalDigits, int maxDigitsDecimalNotation, @NotNull String jlocale, char decimalSeparator, char thousandsSeparator) {
        Intrinsics.checkNotNullParameter(jlocale, "jlocale");
        INSTANCE.Native_setSettingParams(this.mNativeHandle, angleUnit, decimalDigits, maxDigitsDecimalNotation, jlocale, decimalSeparator, thousandsSeparator);
    }

    @NotNull
    public final ArrayList<String> solve(@NotNull String latex) {
        Intrinsics.checkNotNullParameter(latex, "latex");
        return INSTANCE.Native_solve(this.mNativeHandle, latex);
    }
}
