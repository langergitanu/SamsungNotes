package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.AlignmentLine;
import androidx.compose.p109ui.layout.AlignmentLineKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p109ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B]\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00126\u0010\r\u001a2\u0012\u0004\u0012\u00020\u000f\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e¢\u0006\u0002\b\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J^\u0010!\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0004\u0012\u00020\u000f\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e¢\u0006\u0002\b\u0016J&\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*R\"\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001dR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;)V", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getBaselineCache$annotations", "()V", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateNode", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextFieldTextLayoutModifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextFieldTextLayoutModifier.kt\nandroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,174:1\n149#2:175\n26#3:176\n26#3:177\n*S KotlinDebug\n*F\n+ 1 TextFieldTextLayoutModifier.kt\nandroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode\n*L\n156#1:175\n161#1:176\n162#1:177\n*E\n"})
public final class TextFieldTextLayoutModifierNode extends Modifier.Node implements LayoutModifierNode, GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;

    @Nullable
    private Map<AlignmentLine, Integer> baselineCache;
    private boolean singleLine;

    @NotNull
    private TextLayoutState textLayoutState;

    public TextFieldTextLayoutModifierNode(@NotNull TextLayoutState textLayoutState, @NotNull TransformedTextFieldState transformedTextFieldState, @NotNull TextStyle textStyle, boolean z, @Nullable Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.textLayoutState = textLayoutState;
        this.singleLine = z;
        textLayoutState.setOnTextLayout(function2);
        TextLayoutState textLayoutState2 = this.textLayoutState;
        boolean z2 = this.singleLine;
        textLayoutState2.updateNonMeasureInputs(transformedTextFieldState, textStyle, z2, !z2);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        TextLayoutResult textLayoutResultM16387layoutWithNewMeasureInputshBUhpc = this.textLayoutState.m16387layoutWithNewMeasureInputshBUhpc(measureScope, measureScope.getLayoutDirection(), (FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFontFamilyResolver()), j);
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.INSTANCE.m20930fitPrioritizingWidthZbe2FdA(IntSize.m21138getWidthimpl(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getSize()), IntSize.m21138getWidthimpl(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getSize()), IntSize.m21137getHeightimpl(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getSize()), IntSize.m21137getHeightimpl(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getSize())));
        this.textLayoutState.m16388setMinHeightForSingleLineField0680j_4(this.singleLine ? measureScope.mo15543toDpu2uoSUM(TextDelegateKt.ceilToIntPx(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getLineBottom(0))) : C2256Dp.m20968constructorimpl(0));
        Map<AlignmentLine, Integer> linkedHashMap = this.baselineCache;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>(2);
        }
        linkedHashMap.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getFirstBaseline())));
        linkedHashMap.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getLastBaseline())));
        this.baselineCache = linkedHashMap;
        int iM21138getWidthimpl = IntSize.m21138getWidthimpl(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getSize());
        int iM21137getHeightimpl = IntSize.m21137getHeightimpl(textLayoutResultM16387layoutWithNewMeasureInputshBUhpc.getSize());
        Map<AlignmentLine, Integer> map = this.baselineCache;
        Intrinsics.checkNotNull(map);
        return measureScope.layout(iM21138getWidthimpl, iM21137getHeightimpl, map, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifierNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        });
    }

    @Override // androidx.compose.p109ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(@NotNull LayoutCoordinates coordinates) {
        this.textLayoutState.setTextLayoutNodeCoordinates(coordinates);
    }

    public final void updateNode(@NotNull TextLayoutState textLayoutState, @NotNull TransformedTextFieldState textFieldState, @NotNull TextStyle textStyle, boolean singleLine, @Nullable Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout) {
        this.textLayoutState = textLayoutState;
        textLayoutState.setOnTextLayout(onTextLayout);
        this.singleLine = singleLine;
        this.textLayoutState.updateNonMeasureInputs(textFieldState, textStyle, singleLine, !singleLine);
    }

    private static /* synthetic */ void getBaselineCache$annotations() {
    }
}
