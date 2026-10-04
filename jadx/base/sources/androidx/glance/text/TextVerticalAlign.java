package androidx.glance.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.poi.java.awt.BorderLayout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/text/TextVerticalAlign;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@JvmInline
public final class TextVerticalAlign {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Top = m22046constructorimpl(1);
    private static final int Center = m22046constructorimpl(2);
    private static final int Bottom = m22046constructorimpl(3);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/text/TextVerticalAlign$Companion;", "", "()V", "Bottom", "Landroidx/glance/text/TextVerticalAlign;", "getBottom-J86Ipig", "()I", "I", BorderLayout.CENTER, "getCenter-J86Ipig", "Top", "getTop-J86Ipig", "values", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getBottom-J86Ipig, reason: not valid java name */
        public final int m22052getBottomJ86Ipig() {
            return TextVerticalAlign.Bottom;
        }

        /* JADX INFO: renamed from: getCenter-J86Ipig, reason: not valid java name */
        public final int m22053getCenterJ86Ipig() {
            return TextVerticalAlign.Center;
        }

        /* JADX INFO: renamed from: getTop-J86Ipig, reason: not valid java name */
        public final int m22054getTopJ86Ipig() {
            return TextVerticalAlign.Top;
        }

        @NotNull
        public final List<TextVerticalAlign> values() {
            return CollectionsKt.listOf((Object[]) new TextVerticalAlign[]{TextVerticalAlign.m22045boximpl(m22054getTopJ86Ipig()), TextVerticalAlign.m22045boximpl(m22053getCenterJ86Ipig()), TextVerticalAlign.m22045boximpl(m22052getBottomJ86Ipig())});
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextVerticalAlign(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextVerticalAlign m22045boximpl(int i) {
        return new TextVerticalAlign(i);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m22047equalsimpl(int i, Object obj) {
        return (obj instanceof TextVerticalAlign) && i == ((TextVerticalAlign) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m22048equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m22049hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m22050toStringimpl(int i) {
        return m22048equalsimpl0(i, Top) ? "Top" : m22048equalsimpl0(i, Center) ? BorderLayout.CENTER : m22048equalsimpl0(i, Bottom) ? "Bottom" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m22047equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m22049hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m22050toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m22046constructorimpl(int i) {
        return i;
    }
}
