package androidx.glance.appwidget;

import androidx.annotation.DimenRes;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.internal.StabilityInferred;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u0006HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m13886d2 = {"Landroidx/glance/appwidget/MarginDimension;", "", "resource", "", "(I)V", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "Landroidx/compose/ui/unit/Dp;", "resourceId", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDp-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getResourceId", "()I", "component1", "component1-D9Ej5fM", "component2", "copy", "copy-D5KLDUw", "(FI)Landroidx/glance/appwidget/MarginDimension;", "equals", "", "other", "hashCode", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMargin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Margin.kt\nandroidx/glance/appwidget/MarginDimension\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,190:1\n154#2:191\n*S KotlinDebug\n*F\n+ 1 Margin.kt\nandroidx/glance/appwidget/MarginDimension\n*L\n186#1:191\n*E\n"})
public final /* data */ class MarginDimension {
    public static final int $stable = 0;
    private final float dp;
    private final int resourceId;

    public /* synthetic */ MarginDimension(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ MarginDimension m21300copyD5KLDUw$default(MarginDimension marginDimension, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = marginDimension.dp;
        }
        if ((i2 & 2) != 0) {
            i = marginDimension.resourceId;
        }
        return marginDimension.m21302copyD5KLDUw(f, i);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDp() {
        return this.dp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getResourceId() {
        return this.resourceId;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final MarginDimension m21302copyD5KLDUw(float dp, int resourceId) {
        return new MarginDimension(dp, resourceId, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarginDimension)) {
            return false;
        }
        MarginDimension marginDimension = (MarginDimension) other;
        return C2256Dp.m20973equalsimpl0(this.dp, marginDimension.dp) && this.resourceId == marginDimension.resourceId;
    }

    /* JADX INFO: renamed from: getDp-D9Ej5fM, reason: not valid java name */
    public final float m21303getDpD9Ej5fM() {
        return this.dp;
    }

    public final int getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return Integer.hashCode(this.resourceId) + (C2256Dp.m20974hashCodeimpl(this.dp) * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC1974b.m1319l("MarginDimension(dp=", this.resourceId, C2256Dp.m20979toStringimpl(this.dp), ", resourceId=", ")");
    }

    private MarginDimension(float f, int i) {
        this.dp = f;
        this.resourceId = i;
    }

    public MarginDimension(@DimenRes int i) {
        this(0.0f, i, 1, null);
    }

    public /* synthetic */ MarginDimension(float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i2 & 2) != 0 ? 0 : i, null);
    }
}
