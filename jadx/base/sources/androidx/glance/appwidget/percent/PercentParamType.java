package androidx.glance.appwidget.percent;

import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/appwidget/percent/PercentParamType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toInt", "toInt-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@JvmInline
public final class PercentParamType {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int LAYOUT_WIDTH = m21363constructorimpl(8);
    private static final int LAYOUT_HEIGHT = m21363constructorimpl(9);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/percent/PercentParamType$Companion;", "", "()V", "LAYOUT_HEIGHT", "Landroidx/glance/appwidget/percent/PercentParamType;", "getLAYOUT_HEIGHT-lhCYxaY", "()I", "I", "LAYOUT_WIDTH", "getLAYOUT_WIDTH-lhCYxaY", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getLAYOUT_HEIGHT-lhCYxaY, reason: not valid java name */
        public final int m21370getLAYOUT_HEIGHTlhCYxaY() {
            return PercentParamType.LAYOUT_HEIGHT;
        }

        /* JADX INFO: renamed from: getLAYOUT_WIDTH-lhCYxaY, reason: not valid java name */
        public final int m21371getLAYOUT_WIDTHlhCYxaY() {
            return PercentParamType.LAYOUT_WIDTH;
        }

        private Companion() {
        }
    }

    private /* synthetic */ PercentParamType(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PercentParamType m21362boximpl(int i) {
        return new PercentParamType(i);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21364equalsimpl(int i, Object obj) {
        return (obj instanceof PercentParamType) && i == ((PercentParamType) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21365equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21366hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21368toStringimpl(int i) {
        return AbstractC0541b.m767i(i, "PercentParamType(value=", ")");
    }

    public boolean equals(Object obj) {
        return m21364equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m21366hashCodeimpl(this.value);
    }

    public String toString() {
        return m21368toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m21363constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m21367toIntimpl(int i) {
        return i;
    }
}
