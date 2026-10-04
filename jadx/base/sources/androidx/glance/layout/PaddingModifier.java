package androidx.glance.layout;

import android.content.res.Resources;
import androidx.annotation.RestrictTo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0011\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0086\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006%"}, m13886d2 = {"Landroidx/glance/layout/PaddingModifier;", "Landroidx/glance/GlanceModifier$Element;", "left", "Landroidx/glance/layout/PaddingDimension;", "start", "top", "right", "end", "bottom", "(Landroidx/glance/layout/PaddingDimension;Landroidx/glance/layout/PaddingDimension;Landroidx/glance/layout/PaddingDimension;Landroidx/glance/layout/PaddingDimension;Landroidx/glance/layout/PaddingDimension;Landroidx/glance/layout/PaddingDimension;)V", "getBottom", "()Landroidx/glance/layout/PaddingDimension;", "getEnd", "getLeft", "getRight", "getStart", "getTop", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "plus", "toDp", "Landroidx/glance/layout/PaddingInDp;", "resources", "Landroid/content/res/Resources;", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/glance/layout/PaddingModifier\n+ 2 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,276:1\n51#2:277\n51#2:278\n51#2:279\n51#2:280\n51#2:281\n51#2:282\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/glance/layout/PaddingModifier\n*L\n222#1:277\n223#1:278\n224#1:279\n225#1:280\n226#1:281\n227#1:282\n*E\n"})
public final /* data */ class PaddingModifier implements GlanceModifier.Element {
    public static final int $stable = 0;

    @NotNull
    private final PaddingDimension bottom;

    @NotNull
    private final PaddingDimension end;

    @NotNull
    private final PaddingDimension left;

    @NotNull
    private final PaddingDimension right;

    @NotNull
    private final PaddingDimension start;

    @NotNull
    private final PaddingDimension top;

    public PaddingModifier() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PaddingModifier copy$default(PaddingModifier paddingModifier, PaddingDimension paddingDimension, PaddingDimension paddingDimension2, PaddingDimension paddingDimension3, PaddingDimension paddingDimension4, PaddingDimension paddingDimension5, PaddingDimension paddingDimension6, int i, Object obj) {
        if ((i & 1) != 0) {
            paddingDimension = paddingModifier.left;
        }
        if ((i & 2) != 0) {
            paddingDimension2 = paddingModifier.start;
        }
        if ((i & 4) != 0) {
            paddingDimension3 = paddingModifier.top;
        }
        if ((i & 8) != 0) {
            paddingDimension4 = paddingModifier.right;
        }
        if ((i & 16) != 0) {
            paddingDimension5 = paddingModifier.end;
        }
        if ((i & 32) != 0) {
            paddingDimension6 = paddingModifier.bottom;
        }
        PaddingDimension paddingDimension7 = paddingDimension5;
        PaddingDimension paddingDimension8 = paddingDimension6;
        return paddingModifier.copy(paddingDimension, paddingDimension2, paddingDimension3, paddingDimension4, paddingDimension7, paddingDimension8);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PaddingDimension getLeft() {
        return this.left;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PaddingDimension getStart() {
        return this.start;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PaddingDimension getTop() {
        return this.top;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PaddingDimension getRight() {
        return this.right;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PaddingDimension getEnd() {
        return this.end;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PaddingDimension getBottom() {
        return this.bottom;
    }

    @NotNull
    public final PaddingModifier copy(@NotNull PaddingDimension left, @NotNull PaddingDimension start, @NotNull PaddingDimension top, @NotNull PaddingDimension right, @NotNull PaddingDimension end, @NotNull PaddingDimension bottom) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        return new PaddingModifier(left, start, top, right, end, bottom);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaddingModifier)) {
            return false;
        }
        PaddingModifier paddingModifier = (PaddingModifier) other;
        return Intrinsics.areEqual(this.left, paddingModifier.left) && Intrinsics.areEqual(this.start, paddingModifier.start) && Intrinsics.areEqual(this.top, paddingModifier.top) && Intrinsics.areEqual(this.right, paddingModifier.right) && Intrinsics.areEqual(this.end, paddingModifier.end) && Intrinsics.areEqual(this.bottom, paddingModifier.bottom);
    }

    @NotNull
    public final PaddingDimension getBottom() {
        return this.bottom;
    }

    @NotNull
    public final PaddingDimension getEnd() {
        return this.end;
    }

    @NotNull
    public final PaddingDimension getLeft() {
        return this.left;
    }

    @NotNull
    public final PaddingDimension getRight() {
        return this.right;
    }

    @NotNull
    public final PaddingDimension getStart() {
        return this.start;
    }

    @NotNull
    public final PaddingDimension getTop() {
        return this.top;
    }

    public int hashCode() {
        return this.bottom.hashCode() + ((this.end.hashCode() + ((this.right.hashCode() + ((this.top.hashCode() + ((this.start.hashCode() + (this.left.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public final PaddingModifier plus(@NotNull PaddingModifier other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new PaddingModifier(this.left.plus(other.left), this.start.plus(other.start), this.top.plus(other.top), this.right.plus(other.right), this.end.plus(other.end), this.bottom.plus(other.bottom));
    }

    @NotNull
    public final PaddingInDp toDp(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new PaddingInDp(C2256Dp.m20968constructorimpl(PaddingKt.toDp(this.left.getResourceIds(), resources) + this.left.m21479getDpD9Ej5fM()), C2256Dp.m20968constructorimpl(PaddingKt.toDp(this.start.getResourceIds(), resources) + this.start.m21479getDpD9Ej5fM()), C2256Dp.m20968constructorimpl(PaddingKt.toDp(this.top.getResourceIds(), resources) + this.top.m21479getDpD9Ej5fM()), C2256Dp.m20968constructorimpl(PaddingKt.toDp(this.right.getResourceIds(), resources) + this.right.m21479getDpD9Ej5fM()), C2256Dp.m20968constructorimpl(PaddingKt.toDp(this.end.getResourceIds(), resources) + this.end.m21479getDpD9Ej5fM()), C2256Dp.m20968constructorimpl(PaddingKt.toDp(this.bottom.getResourceIds(), resources) + this.bottom.m21479getDpD9Ej5fM()), null);
    }

    @NotNull
    public String toString() {
        return "PaddingModifier(left=" + this.left + ", start=" + this.start + ", top=" + this.top + ", right=" + this.right + ", end=" + this.end + ", bottom=" + this.bottom + ")";
    }

    public PaddingModifier(@NotNull PaddingDimension left, @NotNull PaddingDimension start, @NotNull PaddingDimension top, @NotNull PaddingDimension right, @NotNull PaddingDimension end, @NotNull PaddingDimension bottom) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        this.left = left;
        this.start = start;
        this.top = top;
        this.right = right;
        this.end = end;
        this.bottom = bottom;
    }

    public /* synthetic */ PaddingModifier(PaddingDimension paddingDimension, PaddingDimension paddingDimension2, PaddingDimension paddingDimension3, PaddingDimension paddingDimension4, PaddingDimension paddingDimension5, PaddingDimension paddingDimension6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension, (i & 2) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension2, (i & 4) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension3, (i & 8) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension4, (i & 16) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension5, (i & 32) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension6);
    }
}
