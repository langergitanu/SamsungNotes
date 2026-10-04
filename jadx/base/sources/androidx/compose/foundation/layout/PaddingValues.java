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
@Stable
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0015\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateBottomPadding", "Landroidx/compose/ui/unit/Dp;", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "Absolute", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface PaddingValues {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0010J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u001e\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\u000b\u0010\tR\u001e\u0010\u0005\u001a\u00020\u00038\u0002X\u0083\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\f\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\r\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, m13886d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", TokenizerME.NO_SPLIT, "getLeft-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getTop-D9Ej5fM$annotations", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Immutable
    @SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingValues$Absolute\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,484:1\n1#2:485\n149#3:486\n149#3:487\n149#3:488\n149#3:489\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingValues$Absolute\n*L\n208#1:486\n210#1:487\n212#1:488\n214#1:489\n*E\n"})
    public static final class Absolute implements PaddingValues {
        public static final int $stable = 0;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float f, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
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
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
        public float mo15806calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            return this.right;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM, reason: from getter */
        public float getTop() {
            return this.top;
        }

        public boolean equals(@Nullable Object other) {
            if (!(other instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) other;
            return C2256Dp.m20973equalsimpl0(this.left, absolute.left) && C2256Dp.m20973equalsimpl0(this.top, absolute.top) && C2256Dp.m20973equalsimpl0(this.right, absolute.right) && C2256Dp.m20973equalsimpl0(this.bottom, absolute.bottom);
        }

        public int hashCode() {
            return C2256Dp.m20974hashCodeimpl(this.bottom) + AbstractC0622a.m1153C(this.right, AbstractC0622a.m1153C(this.top, C2256Dp.m20974hashCodeimpl(this.left) * 31, 31), 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("PaddingValues.Absolute(left=");
            AbstractC0622a.m1151A(sb, ", top=", this.left);
            AbstractC0622a.m1151A(sb, ", right=", this.top);
            AbstractC0622a.m1151A(sb, ", bottom=", this.right);
            sb.append((Object) C2256Dp.m20979toStringimpl(this.bottom));
            sb.append(PropertyUtils.MAPPED_DELIM2);
            return sb.toString();
        }

        private Absolute(float f, float f4, float f5, float f6) {
            this.left = f;
            this.top = f4;
            this.right = f5;
            this.bottom = f6;
            if (f < 0.0f) {
                throw new IllegalArgumentException("Left padding must be non-negative");
            }
            if (f4 < 0.0f) {
                throw new IllegalArgumentException("Top padding must be non-negative");
            }
            if (f5 < 0.0f) {
                throw new IllegalArgumentException("Right padding must be non-negative");
            }
            if (f6 < 0.0f) {
                throw new IllegalArgumentException("Bottom padding must be non-negative");
            }
        }

        public /* synthetic */ Absolute(float f, float f4, float f5, float f6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i & 2) != 0 ? C2256Dp.m20968constructorimpl(0) : f4, (i & 4) != 0 ? C2256Dp.m20968constructorimpl(0) : f5, (i & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f6, null);
        }

        @Stable
        /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m15867getBottomD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m15868getLeftD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m15869getRightD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m15870getTopD9Ej5fM$annotations() {
        }
    }

    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    float getBottom();

    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    float mo15805calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    float mo15806calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    float getTop();
}
