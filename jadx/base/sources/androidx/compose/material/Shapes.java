package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Immutable;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/material/Shapes;", "", "small", "Landroidx/compose/foundation/shape/CornerBasedShape;", Constants.ScionAnalytics.PARAM_MEDIUM, "large", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class Shapes {

    @NotNull
    private final CornerBasedShape large;

    @NotNull
    private final CornerBasedShape medium;

    @NotNull
    private final CornerBasedShape small;

    public Shapes() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i, Object obj) {
        if ((i & 1) != 0) {
            cornerBasedShape = shapes.small;
        }
        if ((i & 2) != 0) {
            cornerBasedShape2 = shapes.medium;
        }
        if ((i & 4) != 0) {
            cornerBasedShape3 = shapes.large;
        }
        return shapes.copy(cornerBasedShape, cornerBasedShape2, cornerBasedShape3);
    }

    @NotNull
    public final Shapes copy(@NotNull CornerBasedShape small, @NotNull CornerBasedShape medium, @NotNull CornerBasedShape large) {
        Intrinsics.checkNotNullParameter(small, "small");
        Intrinsics.checkNotNullParameter(medium, "medium");
        Intrinsics.checkNotNullParameter(large, "large");
        return new Shapes(small, medium, large);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) other;
        return Intrinsics.areEqual(this.small, shapes.small) && Intrinsics.areEqual(this.medium, shapes.medium) && Intrinsics.areEqual(this.large, shapes.large);
    }

    @NotNull
    public final CornerBasedShape getLarge() {
        return this.large;
    }

    @NotNull
    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    @NotNull
    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public int hashCode() {
        return this.large.hashCode() + ((this.medium.hashCode() + (this.small.hashCode() * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "Shapes(small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + PropertyUtils.MAPPED_DELIM2;
    }

    public Shapes(@NotNull CornerBasedShape small, @NotNull CornerBasedShape medium, @NotNull CornerBasedShape large) {
        Intrinsics.checkNotNullParameter(small, "small");
        Intrinsics.checkNotNullParameter(medium, "medium");
        Intrinsics.checkNotNullParameter(large, "large");
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public /* synthetic */ Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(4)) : cornerBasedShape, (i & 2) != 0 ? RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(4)) : cornerBasedShape2, (i & 4) != 0 ? RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(C2256Dp.m20968constructorimpl(0)) : cornerBasedShape3);
    }
}
