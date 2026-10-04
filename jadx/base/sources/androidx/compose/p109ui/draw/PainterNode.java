package androidx.compose.p109ui.draw;

import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.painter.Painter;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.ScaleFactorKt;
import androidx.compose.p109ui.node.DrawModifierNode;
import androidx.compose.p109ui.node.LayoutModifierNode;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSizeKt;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0016\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J&\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, m13886d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", BaseWidgetConstant.SET_COLOR_FILTER, "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPainterModifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PainterModifier.kt\nandroidx/compose/ui/draw/PainterNode\n+ 2 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 4 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,362:1\n198#2:363\n26#3:364\n26#3:365\n26#3:366\n26#3:367\n26#3:368\n26#3:369\n128#4,7:370\n*S KotlinDebug\n*F\n+ 1 PainterModifier.kt\nandroidx/compose/ui/draw/PainterNode\n*L\n163#1:363\n273#1:364\n280#1:365\n299#1:366\n300#1:367\n329#1:368\n330#1:369\n341#1:370,7\n*E\n"})
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {

    @NotNull
    private Alignment alignment;
    private float alpha;

    @Nullable
    private ColorFilter colorFilter;

    @NotNull
    private ContentScale contentScale;

    @NotNull
    private Painter painter;
    private boolean sizeToIntrinsics;

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m18176calculateScaledSizeE7KxVPU(long dstSize) {
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        long jSize = SizeKt.Size(!m18178hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize()) ? Size.m18353getWidthimpl(dstSize) : Size.m18353getWidthimpl(this.painter.getIntrinsicSize()), !m18177hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize()) ? Size.m18350getHeightimpl(dstSize) : Size.m18350getHeightimpl(this.painter.getIntrinsicSize()));
        return (Size.m18353getWidthimpl(dstSize) == 0.0f || Size.m18350getHeightimpl(dstSize) == 0.0f) ? Size.INSTANCE.m18362getZeroNHjbRc() : ScaleFactorKt.m19959timesUQTWf7w(jSize, this.contentScale.mo19846computeScaleFactorH7hwNQA(jSize, dstSize));
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.getIntrinsicSize() != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m18177hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (Size.m18349equalsimpl0(j, Size.INSTANCE.m18361getUnspecifiedNHjbRc())) {
            return false;
        }
        float fM18350getHeightimpl = Size.m18350getHeightimpl(j);
        return (Float.isInfinite(fM18350getHeightimpl) || Float.isNaN(fM18350getHeightimpl)) ? false : true;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m18178hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (Size.m18349equalsimpl0(j, Size.INSTANCE.m18361getUnspecifiedNHjbRc())) {
            return false;
        }
        float fM18353getWidthimpl = Size.m18353getWidthimpl(j);
        return (Float.isInfinite(fM18353getWidthimpl) || Float.isNaN(fM18353getWidthimpl)) ? false : true;
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m18179modifyConstraintsZezNO4M(long constraints) {
        boolean z = false;
        boolean z2 = Constraints.m20917getHasBoundedWidthimpl(constraints) && Constraints.m20916getHasBoundedHeightimpl(constraints);
        if (Constraints.m20919getHasFixedWidthimpl(constraints) && Constraints.m20918getHasFixedHeightimpl(constraints)) {
            z = true;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m20912copyZbe2FdA$default(constraints, Constraints.m20921getMaxWidthimpl(constraints), 0, Constraints.m20920getMaxHeightimpl(constraints), 0, 10, null);
        }
        long jMo19196getIntrinsicSizeNHjbRc = this.painter.getIntrinsicSize();
        long jM18176calculateScaledSizeE7KxVPU = m18176calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m20938constrainWidthK40F9xA(constraints, m18178hasSpecifiedAndFiniteWidthuvyYCjk(jMo19196getIntrinsicSizeNHjbRc) ? Math.round(Size.m18353getWidthimpl(jMo19196getIntrinsicSizeNHjbRc)) : Constraints.m20923getMinWidthimpl(constraints)), ConstraintsKt.m20937constrainHeightK40F9xA(constraints, m18177hasSpecifiedAndFiniteHeightuvyYCjk(jMo19196getIntrinsicSizeNHjbRc) ? Math.round(Size.m18350getHeightimpl(jMo19196getIntrinsicSizeNHjbRc)) : Constraints.m20922getMinHeightimpl(constraints))));
        return Constraints.m20912copyZbe2FdA$default(constraints, ConstraintsKt.m20938constrainWidthK40F9xA(constraints, Math.round(Size.m18353getWidthimpl(jM18176calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m20937constrainHeightK40F9xA(constraints, Math.round(Size.m18350getHeightimpl(jM18176calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.p109ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) throws Throwable {
        ContentDrawScope contentDrawScope2;
        long jMo19196getIntrinsicSizeNHjbRc = this.painter.getIntrinsicSize();
        long jSize = SizeKt.Size(m18178hasSpecifiedAndFiniteWidthuvyYCjk(jMo19196getIntrinsicSizeNHjbRc) ? Size.m18353getWidthimpl(jMo19196getIntrinsicSizeNHjbRc) : Size.m18353getWidthimpl(contentDrawScope.mo19076getSizeNHjbRc()), m18177hasSpecifiedAndFiniteHeightuvyYCjk(jMo19196getIntrinsicSizeNHjbRc) ? Size.m18350getHeightimpl(jMo19196getIntrinsicSizeNHjbRc) : Size.m18350getHeightimpl(contentDrawScope.mo19076getSizeNHjbRc()));
        long jM18362getZeroNHjbRc = (Size.m18353getWidthimpl(contentDrawScope.mo19076getSizeNHjbRc()) == 0.0f || Size.m18350getHeightimpl(contentDrawScope.mo19076getSizeNHjbRc()) == 0.0f) ? Size.INSTANCE.m18362getZeroNHjbRc() : ScaleFactorKt.m19959timesUQTWf7w(jSize, this.contentScale.mo19846computeScaleFactorH7hwNQA(jSize, contentDrawScope.mo19076getSizeNHjbRc()));
        long jMo18130alignKFBX0sM = this.alignment.mo18130alignKFBX0sM(IntSizeKt.IntSize(Math.round(Size.m18353getWidthimpl(jM18362getZeroNHjbRc)), Math.round(Size.m18350getHeightimpl(jM18362getZeroNHjbRc))), IntSizeKt.IntSize(Math.round(Size.m18353getWidthimpl(contentDrawScope.mo19076getSizeNHjbRc())), Math.round(Size.m18350getHeightimpl(contentDrawScope.mo19076getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float fM21096getXimpl = IntOffset.m21096getXimpl(jMo18130alignKFBX0sM);
        float fM21097getYimpl = IntOffset.m21097getYimpl(jMo18130alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(fM21096getXimpl, fM21097getYimpl);
        try {
            contentDrawScope2 = contentDrawScope;
            try {
                this.painter.m19202drawx_KDEd0(contentDrawScope2, jM18362getZeroNHjbRc, this.alpha, this.colorFilter);
                contentDrawScope2.getDrawContext().getTransform().translate(-fM21096getXimpl, -fM21097getYimpl);
                contentDrawScope2.drawContent();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                contentDrawScope2.getDrawContext().getTransform().translate(-fM21096getXimpl, -fM21097getYimpl);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            contentDrawScope2 = contentDrawScope;
        }
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @Nullable
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @NotNull
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @NotNull
    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        long jM18179modifyConstraintsZezNO4M = m18179modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m20922getMinHeightimpl(jM18179modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        long jM18179modifyConstraintsZezNO4M = m18179modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m20923getMinWidthimpl(jM18179modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo15266measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        final Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(m18179modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        long jM18179modifyConstraintsZezNO4M = m18179modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m20922getMinHeightimpl(jM18179modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.p109ui.node.LayoutModifierNode
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        long jM18179modifyConstraintsZezNO4M = m18179modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m20923getMinWidthimpl(jM18179modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public final void setAlignment(@NotNull Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(@NotNull ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final void setPainter(@NotNull Painter painter) {
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    @NotNull
    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + PropertyUtils.MAPPED_DELIM2;
    }

    public PainterNode(@NotNull Painter painter, boolean z, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float f, @Nullable ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }
}
