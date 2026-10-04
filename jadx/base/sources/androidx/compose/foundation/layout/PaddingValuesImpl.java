package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0013\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000bJ\u001d\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000bJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016R$\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR$\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR$\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m13886d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "getBottom-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getStart-D9Ej5fM$annotations", "getStart-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingValuesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,484:1\n1#2:485\n149#3:486\n149#3:487\n149#3:488\n149#3:489\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingValuesImpl\n*L\n303#1:486\n305#1:487\n307#1:488\n309#1:489\n*E\n"})
public final class PaddingValuesImpl implements PaddingValues {
    public static final int $stable = 0;
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValuesImpl(float f, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM, reason: from getter */
    public float getBottom() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public float mo15805calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public float mo15806calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM, reason: from getter */
    public float getTop() {
        return this.top;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof PaddingValuesImpl)) {
            return false;
        }
        PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) other;
        return C2256Dp.m20973equalsimpl0(this.start, paddingValuesImpl.start) && C2256Dp.m20973equalsimpl0(this.top, paddingValuesImpl.top) && C2256Dp.m20973equalsimpl0(this.end, paddingValuesImpl.end) && C2256Dp.m20973equalsimpl0(this.bottom, paddingValuesImpl.bottom);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m15875getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name and from getter */
    public final float getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m15878getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return C2256Dp.m20974hashCodeimpl(this.bottom) + AbstractC0622a.m1153C(this.end, AbstractC0622a.m1153C(this.top, C2256Dp.m20974hashCodeimpl(this.start) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("PaddingValues(start=");
        AbstractC0622a.m1151A(sb, ", top=", this.start);
        AbstractC0622a.m1151A(sb, ", end=", this.top);
        AbstractC0622a.m1151A(sb, ", bottom=", this.end);
        sb.append((Object) C2256Dp.m20979toStringimpl(this.bottom));
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }

    private PaddingValuesImpl(float f, float f4, float f5, float f6) {
        this.start = f;
        this.top = f4;
        this.end = f5;
        this.bottom = f6;
        if (f < 0.0f) {
            throw new IllegalArgumentException("Start padding must be non-negative");
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Top padding must be non-negative");
        }
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("End padding must be non-negative");
        }
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Bottom padding must be non-negative");
        }
    }

    public /* synthetic */ PaddingValuesImpl(float f, float f4, float f5, float f6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i & 2) != 0 ? C2256Dp.m20968constructorimpl(0) : f4, (i & 4) != 0 ? C2256Dp.m20968constructorimpl(0) : f5, (i & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f6, null);
    }

    @Stable
    /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m15871getBottomD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getEnd-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m15872getEndD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getStart-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m15873getStartD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m15874getTopD9Ej5fM$annotations() {
    }
}
