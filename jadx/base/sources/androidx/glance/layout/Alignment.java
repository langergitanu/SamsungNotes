package androidx.glance.layout;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.java.awt.BorderLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/layout/Alignment;", "", "horizontal", "Landroidx/glance/layout/Alignment$Horizontal;", "vertical", "Landroidx/glance/layout/Alignment$Vertical;", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHorizontal-PGIyAqw", "()I", "I", "getVertical-mnfRV0w", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "Horizontal", "Vertical", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class Alignment {
    public static final int $stable = 0;
    private static final int Bottom;

    @NotNull
    private static final Alignment BottomCenter;

    @NotNull
    private static final Alignment BottomEnd;

    @NotNull
    private static final Alignment BottomStart;

    @NotNull
    private static final Alignment Center;

    @NotNull
    private static final Alignment CenterEnd;
    private static final int CenterHorizontally;

    @NotNull
    private static final Alignment CenterStart;
    private static final int CenterVertically;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int End;
    private static final int Start;
    private static final int Top;

    @NotNull
    private static final Alignment TopCenter;

    @NotNull
    private static final Alignment TopEnd;

    @NotNull
    private static final Alignment TopStart;
    private final int horizontal;
    private final int vertical;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\u0019\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001a\u0010\u0006R\u0019\u0010\u001b\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001c\u0010\u0006R\u0019\u0010\u001d\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001e\u0010\u0006R\u0019\u0010\u001f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u0011\u0010#\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u0011\u0010%\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, m13886d2 = {"Landroidx/glance/layout/Alignment$Companion;", "", "()V", "Bottom", "Landroidx/glance/layout/Alignment$Vertical;", "getBottom-mnfRV0w", "()I", "I", "BottomCenter", "Landroidx/glance/layout/Alignment;", "getBottomCenter", "()Landroidx/glance/layout/Alignment;", "BottomEnd", "getBottomEnd", "BottomStart", "getBottomStart", BorderLayout.CENTER, "getCenter", "CenterEnd", "getCenterEnd", "CenterHorizontally", "Landroidx/glance/layout/Alignment$Horizontal;", "getCenterHorizontally-PGIyAqw", "CenterStart", "getCenterStart", "CenterVertically", "getCenterVertically-mnfRV0w", "End", "getEnd-PGIyAqw", "Start", "getStart-PGIyAqw", "Top", "getTop-mnfRV0w", "TopCenter", "getTopCenter", "TopEnd", "getTopEnd", "TopStart", "getTopStart", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getBottom-mnfRV0w, reason: not valid java name */
        public final int m21429getBottommnfRV0w() {
            return Alignment.Bottom;
        }

        @NotNull
        public final Alignment getBottomCenter() {
            return Alignment.BottomCenter;
        }

        @NotNull
        public final Alignment getBottomEnd() {
            return Alignment.BottomEnd;
        }

        @NotNull
        public final Alignment getBottomStart() {
            return Alignment.BottomStart;
        }

        @NotNull
        public final Alignment getCenter() {
            return Alignment.Center;
        }

        @NotNull
        public final Alignment getCenterEnd() {
            return Alignment.CenterEnd;
        }

        /* JADX INFO: renamed from: getCenterHorizontally-PGIyAqw, reason: not valid java name */
        public final int m21430getCenterHorizontallyPGIyAqw() {
            return Alignment.CenterHorizontally;
        }

        @NotNull
        public final Alignment getCenterStart() {
            return Alignment.CenterStart;
        }

        /* JADX INFO: renamed from: getCenterVertically-mnfRV0w, reason: not valid java name */
        public final int m21431getCenterVerticallymnfRV0w() {
            return Alignment.CenterVertically;
        }

        /* JADX INFO: renamed from: getEnd-PGIyAqw, reason: not valid java name */
        public final int m21432getEndPGIyAqw() {
            return Alignment.End;
        }

        /* JADX INFO: renamed from: getStart-PGIyAqw, reason: not valid java name */
        public final int m21433getStartPGIyAqw() {
            return Alignment.Start;
        }

        /* JADX INFO: renamed from: getTop-mnfRV0w, reason: not valid java name */
        public final int m21434getTopmnfRV0w() {
            return Alignment.Top;
        }

        @NotNull
        public final Alignment getTopCenter() {
            return Alignment.TopCenter;
        }

        @NotNull
        public final Alignment getTopEnd() {
            return Alignment.TopEnd;
        }

        @NotNull
        public final Alignment getTopStart() {
            return Alignment.TopStart;
        }

        private Companion() {
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        Horizontal.Companion companion = Horizontal.INSTANCE;
        int iM21444getStartPGIyAqw = companion.m21444getStartPGIyAqw();
        Vertical.Companion companion2 = Vertical.INSTANCE;
        TopStart = new Alignment(iM21444getStartPGIyAqw, companion2.m21454getTopmnfRV0w(), defaultConstructorMarker);
        TopCenter = new Alignment(companion.m21442getCenterHorizontallyPGIyAqw(), companion2.m21454getTopmnfRV0w(), defaultConstructorMarker);
        TopEnd = new Alignment(companion.m21443getEndPGIyAqw(), companion2.m21454getTopmnfRV0w(), defaultConstructorMarker);
        CenterStart = new Alignment(companion.m21444getStartPGIyAqw(), companion2.m21453getCenterVerticallymnfRV0w(), defaultConstructorMarker);
        Center = new Alignment(companion.m21442getCenterHorizontallyPGIyAqw(), companion2.m21453getCenterVerticallymnfRV0w(), defaultConstructorMarker);
        CenterEnd = new Alignment(companion.m21443getEndPGIyAqw(), companion2.m21453getCenterVerticallymnfRV0w(), defaultConstructorMarker);
        BottomStart = new Alignment(companion.m21444getStartPGIyAqw(), companion2.m21452getBottommnfRV0w(), defaultConstructorMarker);
        BottomCenter = new Alignment(companion.m21442getCenterHorizontallyPGIyAqw(), companion2.m21452getBottommnfRV0w(), defaultConstructorMarker);
        BottomEnd = new Alignment(companion.m21443getEndPGIyAqw(), companion2.m21452getBottommnfRV0w(), defaultConstructorMarker);
        Top = companion2.m21454getTopmnfRV0w();
        CenterVertically = companion2.m21453getCenterVerticallymnfRV0w();
        Bottom = companion2.m21452getBottommnfRV0w();
        Start = companion.m21444getStartPGIyAqw();
        CenterHorizontally = companion.m21442getCenterHorizontallyPGIyAqw();
        End = companion.m21443getEndPGIyAqw();
    }

    public /* synthetic */ Alignment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(Alignment.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.glance.layout.Alignment");
        Alignment alignment = (Alignment) other;
        return Horizontal.m21438equalsimpl0(this.horizontal, alignment.horizontal) && Vertical.m21448equalsimpl0(this.vertical, alignment.vertical);
    }

    /* JADX INFO: renamed from: getHorizontal-PGIyAqw, reason: not valid java name and from getter */
    public final int getHorizontal() {
        return this.horizontal;
    }

    /* JADX INFO: renamed from: getVertical-mnfRV0w, reason: not valid java name and from getter */
    public final int getVertical() {
        return this.vertical;
    }

    public int hashCode() {
        return Vertical.m21449hashCodeimpl(this.vertical) + (Horizontal.m21439hashCodeimpl(this.horizontal) * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m775q("Alignment(horizontal=", Horizontal.m21440toStringimpl(this.horizontal), ", vertical=", Vertical.m21450toStringimpl(this.vertical), ")");
    }

    private Alignment(int i, int i2) {
        this.horizontal = i;
        this.vertical = i2;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/layout/Alignment$Horizontal;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @JvmInline
    public static final class Horizontal {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final int Start = m21436constructorimpl(0);
        private static final int CenterHorizontally = m21436constructorimpl(1);
        private static final int End = m21436constructorimpl(2);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, m13886d2 = {"Landroidx/glance/layout/Alignment$Horizontal$Companion;", "", "()V", "CenterHorizontally", "Landroidx/glance/layout/Alignment$Horizontal;", "getCenterHorizontally-PGIyAqw", "()I", "I", "End", "getEnd-PGIyAqw", "Start", "getStart-PGIyAqw", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getCenterHorizontally-PGIyAqw, reason: not valid java name */
            public final int m21442getCenterHorizontallyPGIyAqw() {
                return Horizontal.CenterHorizontally;
            }

            /* JADX INFO: renamed from: getEnd-PGIyAqw, reason: not valid java name */
            public final int m21443getEndPGIyAqw() {
                return Horizontal.End;
            }

            /* JADX INFO: renamed from: getStart-PGIyAqw, reason: not valid java name */
            public final int m21444getStartPGIyAqw() {
                return Horizontal.Start;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Horizontal(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Horizontal m21435boximpl(int i) {
            return new Horizontal(i);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m21437equalsimpl(int i, Object obj) {
            return (obj instanceof Horizontal) && i == ((Horizontal) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m21438equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m21439hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m21440toStringimpl(int i) {
            return AbstractC0541b.m767i(i, "Horizontal(value=", ")");
        }

        public boolean equals(Object obj) {
            return m21437equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m21439hashCodeimpl(this.value);
        }

        public String toString() {
            return m21440toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m21436constructorimpl(int i) {
            return i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/layout/Alignment$Vertical;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @JvmInline
    public static final class Vertical {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final int Top = m21446constructorimpl(0);
        private static final int CenterVertically = m21446constructorimpl(1);
        private static final int Bottom = m21446constructorimpl(2);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, m13886d2 = {"Landroidx/glance/layout/Alignment$Vertical$Companion;", "", "()V", "Bottom", "Landroidx/glance/layout/Alignment$Vertical;", "getBottom-mnfRV0w", "()I", "I", "CenterVertically", "getCenterVertically-mnfRV0w", "Top", "getTop-mnfRV0w", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getBottom-mnfRV0w, reason: not valid java name */
            public final int m21452getBottommnfRV0w() {
                return Vertical.Bottom;
            }

            /* JADX INFO: renamed from: getCenterVertically-mnfRV0w, reason: not valid java name */
            public final int m21453getCenterVerticallymnfRV0w() {
                return Vertical.CenterVertically;
            }

            /* JADX INFO: renamed from: getTop-mnfRV0w, reason: not valid java name */
            public final int m21454getTopmnfRV0w() {
                return Vertical.Top;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Vertical(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Vertical m21445boximpl(int i) {
            return new Vertical(i);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m21447equalsimpl(int i, Object obj) {
            return (obj instanceof Vertical) && i == ((Vertical) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m21448equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m21449hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m21450toStringimpl(int i) {
            return AbstractC0541b.m767i(i, "Vertical(value=", ")");
        }

        public boolean equals(Object obj) {
            return m21447equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m21449hashCodeimpl(this.value);
        }

        public String toString() {
            return m21450toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m21446constructorimpl(int i) {
            return i;
        }
    }
}
