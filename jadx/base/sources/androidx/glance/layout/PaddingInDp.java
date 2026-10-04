package androidx.glance.layout;

import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000bJ\u0016\u0010\u0014\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u000bJ\u0016\u0010\u0016\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u000bJ\u0016\u0010\u0018\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000bJ\u0016\u0010\u001a\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u0016\u0010\u001c\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000bJO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\"J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\"J\t\u0010)\u001a\u00020*HÖ\u0001R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m13886d2 = {"Landroidx/glance/layout/PaddingInDp;", "", "left", "Landroidx/compose/ui/unit/Dp;", "start", "top", "right", "end", "bottom", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getEnd-D9Ej5fM", "getLeft-D9Ej5fM", "getRight-D9Ej5fM", "getStart-D9Ej5fM", "getTop-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "component5", "component5-D9Ej5fM", "component6", "component6-D9Ej5fM", "copy", "copy-erZIsFM", "(FFFFFF)Landroidx/glance/layout/PaddingInDp;", "equals", "", "other", "hashCode", "", "toAbsolute", "isRtl", "toRelative", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/glance/layout/PaddingInDp\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,276:1\n154#2:277\n154#2:278\n154#2:279\n154#2:280\n154#2:281\n154#2:282\n51#3:283\n51#3:284\n51#3:285\n51#3:286\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/glance/layout/PaddingInDp\n*L\n251#1:277\n252#1:278\n253#1:279\n254#1:280\n255#1:281\n256#1:282\n261#1:283\n263#1:284\n270#1:285\n272#1:286\n*E\n"})
public final /* data */ class PaddingInDp {
    public static final int $stable = 0;
    private final float bottom;
    private final float end;
    private final float left;
    private final float right;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingInDp(float f, float f4, float f5, float f6, float f7, float f8, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, f7, f8);
    }

    /* JADX INFO: renamed from: copy-erZIsFM$default, reason: not valid java name */
    public static /* synthetic */ PaddingInDp m21480copyerZIsFM$default(PaddingInDp paddingInDp, float f, float f4, float f5, float f6, float f7, float f8, int i, Object obj) {
        if ((i & 1) != 0) {
            f = paddingInDp.left;
        }
        if ((i & 2) != 0) {
            f4 = paddingInDp.start;
        }
        if ((i & 4) != 0) {
            f5 = paddingInDp.top;
        }
        if ((i & 8) != 0) {
            f6 = paddingInDp.right;
        }
        if ((i & 16) != 0) {
            f7 = paddingInDp.end;
        }
        if ((i & 32) != 0) {
            f8 = paddingInDp.bottom;
        }
        float f9 = f7;
        float f10 = f8;
        return paddingInDp.m21487copyerZIsFM(f, f4, f5, f6, f9, f10);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component5-D9Ej5fM, reason: not valid java name and from getter */
    public final float getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBottom() {
        return this.bottom;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-erZIsFM, reason: not valid java name */
    public final PaddingInDp m21487copyerZIsFM(float left, float start, float top, float right, float end, float bottom) {
        return new PaddingInDp(left, start, top, right, end, bottom, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaddingInDp)) {
            return false;
        }
        PaddingInDp paddingInDp = (PaddingInDp) other;
        return C2256Dp.m20973equalsimpl0(this.left, paddingInDp.left) && C2256Dp.m20973equalsimpl0(this.start, paddingInDp.start) && C2256Dp.m20973equalsimpl0(this.top, paddingInDp.top) && C2256Dp.m20973equalsimpl0(this.right, paddingInDp.right) && C2256Dp.m20973equalsimpl0(this.end, paddingInDp.end) && C2256Dp.m20973equalsimpl0(this.bottom, paddingInDp.bottom);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m21488getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m21489getEndD9Ej5fM() {
        return this.end;
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m21490getLeftD9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m21491getRightD9Ej5fM() {
        return this.right;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m21492getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m21493getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return C2256Dp.m20974hashCodeimpl(this.bottom) + AbstractC0622a.m1153C(this.end, AbstractC0622a.m1153C(this.right, AbstractC0622a.m1153C(this.top, AbstractC0622a.m1153C(this.start, C2256Dp.m20974hashCodeimpl(this.left) * 31, 31), 31), 31), 31);
    }

    @NotNull
    public final PaddingInDp toAbsolute(boolean isRtl) {
        return new PaddingInDp(C2256Dp.m20968constructorimpl(this.left + (isRtl ? this.end : this.start)), 0.0f, this.top, C2256Dp.m20968constructorimpl(this.right + (isRtl ? this.start : this.end)), 0.0f, this.bottom, 18, null);
    }

    @NotNull
    public final PaddingInDp toRelative(boolean isRtl) {
        return new PaddingInDp(0.0f, C2256Dp.m20968constructorimpl(this.start + (isRtl ? this.right : this.left)), this.top, 0.0f, C2256Dp.m20968constructorimpl(this.end + (isRtl ? this.left : this.right)), this.bottom, 9, null);
    }

    @NotNull
    public String toString() {
        String strM20979toStringimpl = C2256Dp.m20979toStringimpl(this.left);
        String strM20979toStringimpl2 = C2256Dp.m20979toStringimpl(this.start);
        String strM20979toStringimpl3 = C2256Dp.m20979toStringimpl(this.top);
        String strM20979toStringimpl4 = C2256Dp.m20979toStringimpl(this.right);
        String strM20979toStringimpl5 = C2256Dp.m20979toStringimpl(this.end);
        String strM20979toStringimpl6 = C2256Dp.m20979toStringimpl(this.bottom);
        StringBuilder sbM16m = AbstractC0000a.m16m("PaddingInDp(left=", strM20979toStringimpl, ", start=", strM20979toStringimpl2, ", top=");
        AbstractC2821a.m2207B(sbM16m, strM20979toStringimpl3, ", right=", strM20979toStringimpl4, ", end=");
        return AbstractC0541b.m776r(sbM16m, strM20979toStringimpl5, ", bottom=", strM20979toStringimpl6, ")");
    }

    private PaddingInDp(float f, float f4, float f5, float f6, float f7, float f8) {
        this.left = f;
        this.start = f4;
        this.top = f5;
        this.right = f6;
        this.end = f7;
        this.bottom = f8;
    }

    public /* synthetic */ PaddingInDp(float f, float f4, float f5, float f6, float f7, float f8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i & 2) != 0 ? C2256Dp.m20968constructorimpl(0) : f4, (i & 4) != 0 ? C2256Dp.m20968constructorimpl(0) : f5, (i & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f6, (i & 16) != 0 ? C2256Dp.m20968constructorimpl(0) : f7, (i & 32) != 0 ? C2256Dp.m20968constructorimpl(0) : f8, null);
    }
}
