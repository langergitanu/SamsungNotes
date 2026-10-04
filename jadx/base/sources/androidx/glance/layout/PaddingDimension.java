package androidx.glance.layout;

import androidx.annotation.DimenRes;
import androidx.annotation.RestrictTo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u0006HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0011\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m13886d2 = {"Landroidx/glance/layout/PaddingDimension;", "", "resource", "", "(I)V", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "Landroidx/compose/ui/unit/Dp;", "resourceIds", "", "(FLjava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDp-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getResourceIds", "()Ljava/util/List;", "component1", "component1-D9Ej5fM", "component2", "copy", "copy-D5KLDUw", "(FLjava/util/List;)Landroidx/glance/layout/PaddingDimension;", "equals", "", "other", "hashCode", "plus", "toString", "", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/glance/layout/PaddingDimension\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,276:1\n154#2:277\n51#3:278\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/glance/layout/PaddingDimension\n*L\n233#1:277\n240#1:278\n*E\n"})
public final /* data */ class PaddingDimension {
    private final float dp;

    @NotNull
    private final List<Integer> resourceIds;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final PaddingDimension Zero = new PaddingDimension(0.0f, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/layout/PaddingDimension$Companion;", "", "()V", "Zero", "Landroidx/glance/layout/PaddingDimension;", "getZero", "()Landroidx/glance/layout/PaddingDimension;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PaddingDimension getZero() {
            return PaddingDimension.Zero;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaddingDimension(float f, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ PaddingDimension m21476copyD5KLDUw$default(PaddingDimension paddingDimension, float f, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            f = paddingDimension.dp;
        }
        if ((i & 2) != 0) {
            list = paddingDimension.resourceIds;
        }
        return paddingDimension.m21478copyD5KLDUw(f, list);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDp() {
        return this.dp;
    }

    @NotNull
    public final List<Integer> component2() {
        return this.resourceIds;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final PaddingDimension m21478copyD5KLDUw(float dp, @NotNull List<Integer> resourceIds) {
        Intrinsics.checkNotNullParameter(resourceIds, "resourceIds");
        return new PaddingDimension(dp, resourceIds, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaddingDimension)) {
            return false;
        }
        PaddingDimension paddingDimension = (PaddingDimension) other;
        return C2256Dp.m20973equalsimpl0(this.dp, paddingDimension.dp) && Intrinsics.areEqual(this.resourceIds, paddingDimension.resourceIds);
    }

    /* JADX INFO: renamed from: getDp-D9Ej5fM, reason: not valid java name */
    public final float m21479getDpD9Ej5fM() {
        return this.dp;
    }

    @NotNull
    public final List<Integer> getResourceIds() {
        return this.resourceIds;
    }

    public int hashCode() {
        return this.resourceIds.hashCode() + (C2256Dp.m20974hashCodeimpl(this.dp) * 31);
    }

    @NotNull
    public final PaddingDimension plus(@NotNull PaddingDimension other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new PaddingDimension(C2256Dp.m20968constructorimpl(this.dp + other.dp), CollectionsKt.plus((Collection) this.resourceIds, (Iterable) other.resourceIds), null);
    }

    @NotNull
    public String toString() {
        return "PaddingDimension(dp=" + C2256Dp.m20979toStringimpl(this.dp) + ", resourceIds=" + this.resourceIds + ")";
    }

    private PaddingDimension(float f, List<Integer> resourceIds) {
        Intrinsics.checkNotNullParameter(resourceIds, "resourceIds");
        this.dp = f;
        this.resourceIds = resourceIds;
    }

    public PaddingDimension(@DimenRes int i) {
        this(0.0f, CollectionsKt.listOf(Integer.valueOf(i)), 1, null);
    }

    public /* synthetic */ PaddingDimension(float f, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i & 2) != 0 ? CollectionsKt.emptyList() : list, null);
    }
}
