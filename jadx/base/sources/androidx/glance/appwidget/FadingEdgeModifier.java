package androidx.glance.appwidget;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/appwidget/FadingEdgeModifier;", "Landroidx/glance/GlanceModifier$Element;", "edgeLength", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEdgeLength-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Landroidx/glance/appwidget/FadingEdgeModifier;", "equals", "", "other", "", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class FadingEdgeModifier implements GlanceModifier.Element {
    public static final int $stable = 0;
    private final float edgeLength;

    public /* synthetic */ FadingEdgeModifier(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    /* JADX INFO: renamed from: copy-0680j_4$default, reason: not valid java name */
    public static /* synthetic */ FadingEdgeModifier m21289copy0680j_4$default(FadingEdgeModifier fadingEdgeModifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = fadingEdgeModifier.edgeLength;
        }
        return fadingEdgeModifier.m21291copy0680j_4(f);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getEdgeLength() {
        return this.edgeLength;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-0680j_4, reason: not valid java name */
    public final FadingEdgeModifier m21291copy0680j_4(float edgeLength) {
        return new FadingEdgeModifier(edgeLength, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FadingEdgeModifier) && C2256Dp.m20973equalsimpl0(this.edgeLength, ((FadingEdgeModifier) other).edgeLength);
    }

    /* JADX INFO: renamed from: getEdgeLength-D9Ej5fM, reason: not valid java name */
    public final float m21292getEdgeLengthD9Ej5fM() {
        return this.edgeLength;
    }

    public int hashCode() {
        return C2256Dp.m20974hashCodeimpl(this.edgeLength);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m773o("FadingEdgeModifier(edgeLength=", C2256Dp.m20979toStringimpl(this.edgeLength), ")");
    }

    private FadingEdgeModifier(float f) {
        this.edgeLength = f;
    }
}
