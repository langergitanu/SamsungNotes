package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.layout.AlignmentLine;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\f\u0010\u001f\u001a\u00020\u000b*\u00020\nH\u0016R\u0019\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\"\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, m13886d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetDpElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AlignmentLineOffsetDpNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/Dp;", "after", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/layout/AlignmentLine;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfter-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "getBefore-D9Ej5fM", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "equals", "", "other", "", "hashCode", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class AlignmentLineOffsetDpElement extends ModifierNodeElement<AlignmentLineOffsetDpNode> {
    private final float after;

    @NotNull
    private final AlignmentLine alignmentLine;
    private final float before;

    @NotNull
    private final Function1<InspectorInfo, Unit> inspectorInfo;

    public /* synthetic */ AlignmentLineOffsetDpElement(AlignmentLine alignmentLine, float f, float f4, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine, f, f4, function1);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        AlignmentLineOffsetDpElement alignmentLineOffsetDpElement = other instanceof AlignmentLineOffsetDpElement ? (AlignmentLineOffsetDpElement) other : null;
        return alignmentLineOffsetDpElement != null && Intrinsics.areEqual(this.alignmentLine, alignmentLineOffsetDpElement.alignmentLine) && C2256Dp.m20973equalsimpl0(this.before, alignmentLineOffsetDpElement.before) && C2256Dp.m20973equalsimpl0(this.after, alignmentLineOffsetDpElement.after);
    }

    /* JADX INFO: renamed from: getAfter-D9Ej5fM, reason: not valid java name and from getter */
    public final float getAfter() {
        return this.after;
    }

    @NotNull
    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    /* JADX INFO: renamed from: getBefore-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBefore() {
        return this.before;
    }

    @NotNull
    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return C2256Dp.m20974hashCodeimpl(this.after) + AbstractC0622a.m1153C(this.before, this.alignmentLine.hashCode() * 31, 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        this.inspectorInfo.invoke(inspectorInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AlignmentLineOffsetDpElement(AlignmentLine alignmentLine, float f, float f4, Function1<? super InspectorInfo, Unit> function1) {
        this.alignmentLine = alignmentLine;
        this.before = f;
        this.after = f4;
        this.inspectorInfo = function1;
        if ((f < 0.0f && !C2256Dp.m20973equalsimpl0(f, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM())) || (f4 < 0.0f && !C2256Dp.m20973equalsimpl0(f4, C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM()))) {
            throw new IllegalArgumentException("Padding from alignment line must be a non-negative number");
        }
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public AlignmentLineOffsetDpNode getNode() {
        return new AlignmentLineOffsetDpNode(this.alignmentLine, this.before, this.after, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull AlignmentLineOffsetDpNode node) {
        node.setAlignmentLine(this.alignmentLine);
        node.m15717setBefore0680j_4(this.before);
        node.m15716setAfter0680j_4(this.after);
    }
}
