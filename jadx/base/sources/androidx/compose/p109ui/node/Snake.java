package androidx.compose.p109ui.node;

import androidx.collection.AbstractC0622a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b'\u0010\u000bJ\u000f\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000b\u0088\u0001\u0002¨\u0006,"}, m13886d2 = {"Landroidx/compose/ui/node/Snake;", "", "data", "", "constructor-impl", "([I)[I", "getData", "()[I", "diagonalSize", "", "getDiagonalSize-impl", "([I)I", "endX", "getEndX-impl", "endY", "getEndY-impl", "hasAdditionOrRemoval", "", "getHasAdditionOrRemoval-impl", "([I)Z", "isAddition", "isAddition-impl", "reverse", "getReverse-impl", "startX", "getStartX-impl", "startY", "getStartY-impl", "addDiagonalToStack", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "equals", "other", "equals-impl", "([ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
final class Snake {

    @NotNull
    private final int[] data;

    private /* synthetic */ Snake(int[] iArr) {
        this.data = iArr;
    }

    /* JADX INFO: renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m20148addDiagonalToStackimpl(int[] iArr, @NotNull IntStack intStack) {
        if (!m20156getHasAdditionOrRemovalimpl(iArr)) {
            intStack.pushDiagonal(m20158getStartXimpl(iArr), m20159getStartYimpl(iArr), m20154getEndXimpl(iArr) - m20158getStartXimpl(iArr));
            return;
        }
        if (m20157getReverseimpl(iArr)) {
            intStack.pushDiagonal(m20158getStartXimpl(iArr), m20159getStartYimpl(iArr), m20153getDiagonalSizeimpl(iArr));
        } else if (m20161isAdditionimpl(iArr)) {
            intStack.pushDiagonal(m20158getStartXimpl(iArr), m20159getStartYimpl(iArr) + 1, m20153getDiagonalSizeimpl(iArr));
        } else {
            intStack.pushDiagonal(m20158getStartXimpl(iArr) + 1, m20159getStartYimpl(iArr), m20153getDiagonalSizeimpl(iArr));
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m20149boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m20151equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual(iArr, ((Snake) obj).m20163unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m20152equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* JADX INFO: renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m20153getDiagonalSizeimpl(int[] iArr) {
        return Math.min(m20154getEndXimpl(iArr) - m20158getStartXimpl(iArr), m20155getEndYimpl(iArr) - m20159getStartYimpl(iArr));
    }

    /* JADX INFO: renamed from: getEndX-impl, reason: not valid java name */
    public static final int m20154getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* JADX INFO: renamed from: getEndY-impl, reason: not valid java name */
    public static final int m20155getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* JADX INFO: renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m20156getHasAdditionOrRemovalimpl(int[] iArr) {
        return m20155getEndYimpl(iArr) - m20159getStartYimpl(iArr) != m20154getEndXimpl(iArr) - m20158getStartXimpl(iArr);
    }

    /* JADX INFO: renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m20157getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* JADX INFO: renamed from: getStartX-impl, reason: not valid java name */
    public static final int m20158getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* JADX INFO: renamed from: getStartY-impl, reason: not valid java name */
    public static final int m20159getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m20160hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m20161isAdditionimpl(int[] iArr) {
        return m20155getEndYimpl(iArr) - m20159getStartYimpl(iArr) > m20154getEndXimpl(iArr) - m20158getStartXimpl(iArr);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m20162toStringimpl(int[] iArr) {
        StringBuilder sb = new StringBuilder("Snake(");
        sb.append(m20158getStartXimpl(iArr));
        sb.append(',');
        sb.append(m20159getStartYimpl(iArr));
        sb.append(',');
        sb.append(m20154getEndXimpl(iArr));
        sb.append(',');
        sb.append(m20155getEndYimpl(iArr));
        sb.append(',');
        return AbstractC0622a.m1172r(sb, m20157getReverseimpl(iArr), PropertyUtils.MAPPED_DELIM2);
    }

    public boolean equals(Object obj) {
        return m20151equalsimpl(this.data, obj);
    }

    @NotNull
    public final int[] getData() {
        return this.data;
    }

    public int hashCode() {
        return m20160hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m20162toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m20163unboximpl() {
        return this.data;
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m20150constructorimpl(@NotNull int[] iArr) {
        return iArr;
    }
}
