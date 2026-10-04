package androidx.compose.p109ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001e\u001f !B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00078Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f\u0088\u0001\n\u0092\u0001\u00020\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, m13886d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "constructor-impl", "(III)I", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "(I)I", "getStrategy-fcGXIks", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", "copy", "copy-gijOMQM", "(IIII)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
public final class LineBreak {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private static final int Unspecified;
    private final int mask;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "()V", "Heading", "Landroidx/compose/ui/text/style/LineBreak;", "getHeading-rAG3T2k$annotations", "getHeading-rAG3T2k", "()I", "I", "Paragraph", "getParagraph-rAG3T2k$annotations", "getParagraph-rAG3T2k", "Simple", "getSimple-rAG3T2k$annotations", "getSimple-rAG3T2k", "Unspecified", "getUnspecified-rAG3T2k$annotations", "getUnspecified-rAG3T2k", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getHeading-rAG3T2k, reason: not valid java name */
        public final int m20787getHeadingrAG3T2k() {
            return LineBreak.Heading;
        }

        /* JADX INFO: renamed from: getParagraph-rAG3T2k, reason: not valid java name */
        public final int m20788getParagraphrAG3T2k() {
            return LineBreak.Paragraph;
        }

        /* JADX INFO: renamed from: getSimple-rAG3T2k, reason: not valid java name */
        public final int m20789getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        /* JADX INFO: renamed from: getUnspecified-rAG3T2k, reason: not valid java name */
        public final int m20790getUnspecifiedrAG3T2k() {
            return LineBreak.Unspecified;
        }

        private Companion() {
        }

        @Stable
        /* JADX INFO: renamed from: getHeading-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20783getHeadingrAG3T2k$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getParagraph-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20784getParagraphrAG3T2k$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getSimple-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20785getSimplerAG3T2k$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20786getUnspecifiedrAG3T2k$annotations() {
        }
    }

    static {
        Strategy.Companion companion = Strategy.INSTANCE;
        int iM20800getSimplefcGXIks = companion.m20800getSimplefcGXIks();
        Strictness.Companion companion2 = Strictness.INSTANCE;
        int iM20811getNormalusljTpc = companion2.m20811getNormalusljTpc();
        WordBreak.Companion companion3 = WordBreak.INSTANCE;
        Simple = m20771constructorimpl(LineBreak_androidKt.packBytes(iM20800getSimplefcGXIks, iM20811getNormalusljTpc, companion3.m20821getDefaultjp8hJ3c()));
        Heading = m20771constructorimpl(LineBreak_androidKt.packBytes(companion.m20798getBalancedfcGXIks(), companion2.m20810getLooseusljTpc(), companion3.m20822getPhrasejp8hJ3c()));
        Paragraph = m20771constructorimpl(LineBreak_androidKt.packBytes(companion.m20799getHighQualityfcGXIks(), companion2.m20812getStrictusljTpc(), companion3.m20821getDefaultjp8hJ3c()));
        Unspecified = m20771constructorimpl(0);
    }

    private /* synthetic */ LineBreak(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineBreak m20770boximpl(int i) {
        return new LineBreak(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m20771constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: copy-gijOMQM, reason: not valid java name */
    public static final int m20773copygijOMQM(int i, int i2, int i4, int i5) {
        return m20772constructorimpl(i2, i4, i5);
    }

    /* JADX INFO: renamed from: copy-gijOMQM$default, reason: not valid java name */
    public static /* synthetic */ int m20774copygijOMQM$default(int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = m20777getStrategyfcGXIks(i);
        }
        if ((i6 & 2) != 0) {
            i4 = m20778getStrictnessusljTpc(i);
        }
        if ((i6 & 4) != 0) {
            i5 = m20779getWordBreakjp8hJ3c(i);
        }
        return m20773copygijOMQM(i, i2, i4, i5);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m20775equalsimpl(int i, Object obj) {
        return (obj instanceof LineBreak) && i == ((LineBreak) obj).getMask();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m20776equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public static final int m20777getStrategyfcGXIks(int i) {
        return Strategy.m20792constructorimpl(LineBreak_androidKt.unpackByte1(i));
    }

    /* JADX INFO: renamed from: getStrictness-usljTpc, reason: not valid java name */
    public static final int m20778getStrictnessusljTpc(int i) {
        return Strictness.m20803constructorimpl(LineBreak_androidKt.unpackByte2(i));
    }

    /* JADX INFO: renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public static final int m20779getWordBreakjp8hJ3c(int i) {
        return WordBreak.m20815constructorimpl(LineBreak_androidKt.unpackByte3(i));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m20780hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m20781toStringimpl(int i) {
        return "LineBreak(strategy=" + ((Object) Strategy.m20796toStringimpl(m20777getStrategyfcGXIks(i))) + ", strictness=" + ((Object) Strictness.m20807toStringimpl(m20778getStrictnessusljTpc(i))) + ", wordBreak=" + ((Object) WordBreak.m20819toStringimpl(m20779getWordBreakjp8hJ3c(i))) + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean equals(Object obj) {
        return m20775equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m20780hashCodeimpl(this.mask);
    }

    @NotNull
    public String toString() {
        return m20781toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m20772constructorimpl(int i, int i2, int i4) {
        return m20771constructorimpl(LineBreak_androidKt.packBytes(i, i2, i4));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @JvmInline
    public static final class Strategy {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final int Simple = m20792constructorimpl(1);
        private static final int HighQuality = m20792constructorimpl(2);
        private static final int Balanced = m20792constructorimpl(3);
        private static final int Unspecified = m20792constructorimpl(0);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "()V", "Balanced", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getBalanced-fcGXIks", "()I", "I", "HighQuality", "getHighQuality-fcGXIks", "Simple", "getSimple-fcGXIks", "Unspecified", "getUnspecified-fcGXIks", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m20798getBalancedfcGXIks() {
                return Strategy.Balanced;
            }

            /* JADX INFO: renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m20799getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* JADX INFO: renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m20800getSimplefcGXIks() {
                return Strategy.Simple;
            }

            /* JADX INFO: renamed from: getUnspecified-fcGXIks, reason: not valid java name */
            public final int m20801getUnspecifiedfcGXIks() {
                return Strategy.Unspecified;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Strategy(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strategy m20791boximpl(int i) {
            return new Strategy(i);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m20793equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m20794equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m20795hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        @NotNull
        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m20796toStringimpl(int i) {
            return m20794equalsimpl0(i, Simple) ? "Strategy.Simple" : m20794equalsimpl0(i, HighQuality) ? "Strategy.HighQuality" : m20794equalsimpl0(i, Balanced) ? "Strategy.Balanced" : m20794equalsimpl0(i, Unspecified) ? "Strategy.Unspecified" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m20793equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m20795hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m20796toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m20792constructorimpl(int i) {
            return i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @JvmInline
    public static final class Strictness {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m20803constructorimpl(1);
        private static final int Loose = m20803constructorimpl(2);
        private static final int Normal = m20803constructorimpl(3);
        private static final int Strict = m20803constructorimpl(4);
        private static final int Unspecified = m20803constructorimpl(0);
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, m13886d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getDefault-usljTpc", "()I", "I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "Unspecified", "getUnspecified-usljTpc", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m20809getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* JADX INFO: renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m20810getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* JADX INFO: renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m20811getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* JADX INFO: renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m20812getStrictusljTpc() {
                return Strictness.Strict;
            }

            /* JADX INFO: renamed from: getUnspecified-usljTpc, reason: not valid java name */
            public final int m20813getUnspecifiedusljTpc() {
                return Strictness.Unspecified;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Strictness(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strictness m20802boximpl(int i) {
            return new Strictness(i);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m20804equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m20805equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m20806hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        @NotNull
        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m20807toStringimpl(int i) {
            return m20805equalsimpl0(i, Default) ? "Strictness.None" : m20805equalsimpl0(i, Loose) ? "Strictness.Loose" : m20805equalsimpl0(i, Normal) ? "Strictness.Normal" : m20805equalsimpl0(i, Strict) ? "Strictness.Strict" : m20805equalsimpl0(i, Unspecified) ? "Strictness.Unspecified" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m20804equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m20806hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m20807toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m20803constructorimpl(int i) {
            return i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @JvmInline
    public static final class WordBreak {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m20815constructorimpl(1);
        private static final int Phrase = m20815constructorimpl(2);
        private static final int Unspecified = m20815constructorimpl(0);
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, m13886d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getDefault-jp8hJ3c", "()I", "I", "Phrase", "getPhrase-jp8hJ3c", "Unspecified", "getUnspecified-jp8hJ3c", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m20821getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* JADX INFO: renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m20822getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }

            /* JADX INFO: renamed from: getUnspecified-jp8hJ3c, reason: not valid java name */
            public final int m20823getUnspecifiedjp8hJ3c() {
                return WordBreak.Unspecified;
            }

            private Companion() {
            }
        }

        private /* synthetic */ WordBreak(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WordBreak m20814boximpl(int i) {
            return new WordBreak(i);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m20816equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m20817equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m20818hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        @NotNull
        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m20819toStringimpl(int i) {
            return m20817equalsimpl0(i, Default) ? "WordBreak.None" : m20817equalsimpl0(i, Phrase) ? "WordBreak.Phrase" : m20817equalsimpl0(i, Unspecified) ? "WordBreak.Unspecified" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m20816equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m20818hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m20819toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m20815constructorimpl(int i) {
            return i;
        }
    }
}
