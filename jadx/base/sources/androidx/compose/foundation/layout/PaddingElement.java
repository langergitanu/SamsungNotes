package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BN\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0002H\u0016J\f\u0010)\u001a\u00020\r*\u00020\fH\u0016R\"\u0010\u0007\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m13886d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingNode;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "setBottom-0680j_4", "(F)V", TokenizerME.NO_SPLIT, "getEnd-D9Ej5fM", "setEnd-0680j_4", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getStart-D9Ej5fM", "setStart-0680j_4", "getTop-D9Ej5fM", "setTop-0680j_4", "create", "equals", "other", "", "hashCode", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingElement\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,484:1\n149#2:485\n149#2:486\n149#2:487\n149#2:488\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingElement\n*L\n344#1:485\n345#1:486\n346#1:487\n347#1:488\n*E\n"})
final class PaddingElement extends ModifierNodeElement<PaddingNode> {
    private float bottom;
    private float end;

    @NotNull
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingElement(float f, float f4, float f5, float f6, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, z, function1);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        PaddingElement paddingElement = other instanceof PaddingElement ? (PaddingElement) other : null;
        return paddingElement != null && C2256Dp.m20973equalsimpl0(this.start, paddingElement.start) && C2256Dp.m20973equalsimpl0(this.top, paddingElement.top) && C2256Dp.m20973equalsimpl0(this.end, paddingElement.end) && C2256Dp.m20973equalsimpl0(this.bottom, paddingElement.bottom) && this.rtlAware == paddingElement.rtlAware;
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name and from getter */
    public final float getEnd() {
        return this.end;
    }

    @NotNull
    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return Boolean.hashCode(this.rtlAware) + AbstractC0622a.m1153C(this.bottom, AbstractC0622a.m1153C(this.end, AbstractC0622a.m1153C(this.top, C2256Dp.m20974hashCodeimpl(this.start) * 31, 31), 31), 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        this.inspectorInfo.invoke(inspectorInfo);
    }

    /* JADX INFO: renamed from: setBottom-0680j_4, reason: not valid java name */
    public final void m15843setBottom0680j_4(float f) {
        this.bottom = f;
    }

    /* JADX INFO: renamed from: setEnd-0680j_4, reason: not valid java name */
    public final void m15844setEnd0680j_4(float f) {
        this.end = f;
    }

    public final void setRtlAware(boolean z) {
        this.rtlAware = z;
    }

    /* JADX INFO: renamed from: setStart-0680j_4, reason: not valid java name */
    public final void m15845setStart0680j_4(float f) {
        this.start = f;
    }

    /* JADX INFO: renamed from: setTop-0680j_4, reason: not valid java name */
    public final void m15846setTop0680j_4(float f) {
        this.top = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaddingElement(float f, float f4, float f5, float f6, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        this.start = f;
        this.top = f4;
        this.end = f5;
        this.bottom = f6;
        this.rtlAware = z;
        this.inspectorInfo = function1;
        if (f >= 0.0f || C2256Dp.m20973equalsimpl0(f, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM())) {
            float f7 = this.top;
            if (f7 >= 0.0f || C2256Dp.m20973equalsimpl0(f7, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM())) {
                float f8 = this.end;
                if (f8 >= 0.0f || C2256Dp.m20973equalsimpl0(f8, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM())) {
                    float f9 = this.bottom;
                    if (f9 >= 0.0f || C2256Dp.m20973equalsimpl0(f9, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM())) {
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Padding must be non-negative");
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public PaddingNode getNode() {
        return new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull PaddingNode node) {
        node.m15865setStart0680j_4(this.start);
        node.m15866setTop0680j_4(this.top);
        node.m15864setEnd0680j_4(this.end);
        node.m15863setBottom0680j_4(this.bottom);
        node.setRtlAware(this.rtlAware);
    }

    public /* synthetic */ PaddingElement(float f, float f4, float f5, float f6, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i & 2) != 0 ? C2256Dp.m20968constructorimpl(0) : f4, (i & 4) != 0 ? C2256Dp.m20968constructorimpl(0) : f5, (i & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f6, z, function1, null);
    }
}
