package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.node.MotionReferencePlacementDelegate;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J=\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0019\u0010#\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e\u0018\u00010$¢\u0006\u0002\b&H$ø\u0001\u0000¢\u0006\u0004\b'\u0010(J*\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0014ø\u0001\u0000¢\u0006\u0004\b'\u0010+R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR,\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@DX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR,\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0017@DX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, m13886d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "()V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "()J", "J", "", "height", "getHeight", "()I", "measuredHeight", "getMeasuredHeight", "value", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "setMeasuredSize-ozmzZPI", "(J)V", "measuredWidth", "getMeasuredWidth", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "width", "getWidth", "onMeasuredSizeChanged", "", "placeAt", "position", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "PlacementScope", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private int width;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private long apparentToRealOffset = IntOffset.INSTANCE.m21106getZeronOccac();

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn(IntSize.m21138getWidthimpl(this.measuredSize), Constraints.m20923getMinWidthimpl(this.measurementConstraints), Constraints.m20921getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt.coerceIn(IntSize.m21137getHeightimpl(this.measuredSize), Constraints.m20922getMinHeightimpl(this.measurementConstraints), Constraints.m20920getMaxHeightimpl(this.measurementConstraints));
        this.apparentToRealOffset = IntOffsetKt.IntOffset((this.width - IntSize.m21138getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m21137getHeightimpl(this.measuredSize)) / 2);
    }

    /* JADX INFO: renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getApparentToRealOffset() {
        return this.apparentToRealOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // androidx.compose.p109ui.layout.Measured
    public int getMeasuredHeight() {
        return IntSize.m21137getHeightimpl(this.measuredSize);
    }

    /* JADX INFO: renamed from: getMeasuredSize-YbymL2g, reason: not valid java name and from getter */
    public final long getMeasuredSize() {
        return this.measuredSize;
    }

    @Override // androidx.compose.p109ui.layout.Measured
    public int getMeasuredWidth() {
        return IntSize.m21138getWidthimpl(this.measuredSize);
    }

    /* JADX INFO: renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name and from getter */
    public final long getMeasurementConstraints() {
        return this.measurementConstraints;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo19916placeAtf8xVGno(long position, float zIndex, @NotNull GraphicsLayer layer) {
        mo19856placeAtf8xVGno(position, zIndex, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public abstract void mo19856placeAtf8xVGno(long position, float zIndex, @Nullable Function1<? super GraphicsLayerScope, Unit> layerBlock);

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    public final void m19917setMeasuredSizeozmzZPI(long j) {
        if (IntSize.m21136equalsimpl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        onMeasuredSizeChanged();
    }

    /* JADX INFO: renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m19918setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m20914equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        onMeasuredSizeChanged();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015J\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\f\u0010\u001a\u001a\u00020\u0012*\u00020\u001bH\u0002J&\u0010\u001c\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b \u0010!J$\u0010\u001c\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u0017JD\u0010$\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u001b\b\b\u0010%\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014¢\u0006\u0002\b\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\b'\u0010(J/\u0010$\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0080\bø\u0001\u0000¢\u0006\u0004\b'\u0010+JD\u0010,\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u001b\b\b\u0010%\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014¢\u0006\u0002\b\u0015H\u0080\bø\u0001\u0000¢\u0006\u0004\b-\u0010(J/\u0010,\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0080\bø\u0001\u0000¢\u0006\u0004\b-\u0010+J&\u0010.\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b/\u0010!J$\u0010.\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u0017J.\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b1\u00102JA\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015ø\u0001\u0000¢\u0006\u0004\b1\u0010(J,\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001f\u001a\u00020\u0017J?\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015J.\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b4\u00102JA\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015ø\u0001\u0000¢\u0006\u0004\b4\u0010(J,\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001f\u001a\u00020\u0017J?\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, m13886d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "()V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "motionFrameOfReferencePlacement", "", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "withMotionFrameOfReferencePlacement", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "current", "", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "handleMotionFrameOfReferencePlacement", "Landroidx/compose/ui/layout/Placeable;", ServerResultMeetingParser.PLACE, "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "place-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "placeApparentToRealOffset", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "placeApparentToRealOffset-aW-9-wM$ui_release", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/layout/Placeable;JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui_release", "placeRelative", "placeRelative-70tqf50", "placeRelativeWithLayer", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "placeWithLayer", "placeWithLayer-aW-9-wM", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @PlacementScopeMarker
    @SourceDebugExtension({"SMAP\nPlaceable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Placeable.kt\nandroidx/compose/ui/layout/Placeable$PlacementScope\n*L\n1#1,594:1\n452#1,2:595\n486#1,3:597\n455#1,2:600\n486#1,3:602\n461#1:605\n452#1,2:606\n486#1,3:608\n455#1,2:611\n486#1,3:613\n461#1:616\n486#1,3:617\n486#1,3:620\n452#1,2:623\n486#1,3:625\n455#1,2:628\n486#1,3:630\n461#1:633\n452#1,2:634\n486#1,3:636\n455#1,2:639\n486#1,3:641\n461#1:644\n486#1,3:645\n486#1,3:648\n496#1,3:651\n496#1,3:654\n469#1,2:657\n496#1,3:659\n472#1,2:662\n496#1,3:664\n478#1:667\n469#1,2:668\n496#1,3:670\n472#1,2:673\n496#1,3:675\n478#1:678\n486#1,3:679\n486#1,3:682\n496#1,3:685\n496#1,3:688\n*S KotlinDebug\n*F\n+ 1 Placeable.kt\nandroidx/compose/ui/layout/Placeable$PlacementScope\n*L\n215#1:595,2\n215#1:597,3\n215#1:600,2\n215#1:602,3\n215#1:605\n233#1:606,2\n233#1:608,3\n233#1:611,2\n233#1:613,3\n233#1:616\n247#1:617,3\n260#1:620,3\n284#1:623,2\n284#1:625,3\n284#1:628,2\n284#1:630,3\n284#1:633\n310#1:634,2\n310#1:636,3\n310#1:639,2\n310#1:641,3\n310#1:644\n332#1:645,3\n352#1:648,3\n374#1:651,3\n394#1:654,3\n420#1:657,2\n420#1:659,3\n420#1:662,2\n420#1:664,3\n420#1:667\n444#1:668,2\n444#1:670,3\n444#1:673,2\n444#1:675,3\n444#1:678\n453#1:679,3\n455#1:682,3\n470#1:685,3\n472#1:688,3\n*E\n"})
    public static abstract class PlacementScope {
        public static final int $stable = 8;
        private boolean motionFrameOfReferencePlacement;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void handleMotionFrameOfReferencePlacement(Placeable placeable) {
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).setPlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i4 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.place(placeable, i, i2, f);
        }

        /* JADX INFO: renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m19919place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m19925place70tqf50(placeable, j, f);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i4 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.placeRelative(placeable, i, i2, f);
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m19920placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m19930placeRelative70tqf50(placeable, j, f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i4 & 4) != 0) {
                f = 0.0f;
            }
            float f4 = f;
            if ((i4 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i2, f4, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m19921placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f4 = f;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m19931placeRelativeWithLayeraW9wM(placeable, j, f4, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i4 & 4) != 0) {
                f = 0.0f;
            }
            float f4 = f;
            if ((i4 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i, i2, f4, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m19923placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f4 = f;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m19933placeWithLayeraW9wM(placeable, j, f4, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        @Nullable
        public LayoutCoordinates getCoordinates() {
            return null;
        }

        @NotNull
        public abstract LayoutDirection getParentLayoutDirection();

        public abstract int getParentWidth();

        public final void place(@NotNull Placeable placeable, int i, int i2, float f) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* JADX INFO: renamed from: place-70tqf50, reason: not valid java name */
        public final void m19925place70tqf50(@NotNull Placeable placeable, long j, float f) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* JADX INFO: renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m19927placeApparentToRealOffsetaW9wM$ui_release(@NotNull Placeable placeable, long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
        }

        /* JADX INFO: renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m19929placeAutoMirroredaW9wM$ui_release(@NotNull Placeable placeable, long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m21096getXimpl(j), IntOffset.m21097getYimpl(j));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, function1);
            }
        }

        public final void placeRelative(@NotNull Placeable placeable, int i, int i2, float f) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m21096getXimpl(jIntOffset), IntOffset.m21097getYimpl(jIntOffset));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset2, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
            }
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m19930placeRelative70tqf50(@NotNull Placeable placeable, long j, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m21096getXimpl(j), IntOffset.m21097getYimpl(j));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
            }
        }

        public final void placeRelativeWithLayer(@NotNull Placeable placeable, int i, int i2, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, function1);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m21096getXimpl(jIntOffset), IntOffset.m21097getYimpl(jIntOffset));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset2, placeable.apparentToRealOffset), f, function1);
            }
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m19931placeRelativeWithLayeraW9wM(@NotNull Placeable placeable, long j, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m21096getXimpl(j), IntOffset.m21097getYimpl(j));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, function1);
            }
        }

        public final void placeWithLayer(@NotNull Placeable placeable, int i, int i2, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, function1);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m19933placeWithLayeraW9wM(@NotNull Placeable placeable, long j, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo19856placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
        }

        public final void withMotionFrameOfReferencePlacement(@NotNull Function1<? super PlacementScope, Unit> block) {
            this.motionFrameOfReferencePlacement = true;
            block.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i4 & 8) != 0) {
                f = 0.0f;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i2, graphicsLayer, f);
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m19922placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            placementScope.m19932placeRelativeWithLayeraW9wM(placeable, j, graphicsLayer, f);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i4 & 8) != 0) {
                f = 0.0f;
            }
            placementScope.placeWithLayer(placeable, i, i2, graphicsLayer, f);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m19924placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            placementScope.m19934placeWithLayeraW9wM(placeable, j, graphicsLayer, f);
        }

        /* JADX INFO: renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m19926placeApparentToRealOffsetaW9wM$ui_release(@NotNull Placeable placeable, long j, float f, @NotNull GraphicsLayer graphicsLayer) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m19934placeWithLayeraW9wM(@NotNull Placeable placeable, long j, @NotNull GraphicsLayer graphicsLayer, float f) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        public final void placeWithLayer(@NotNull Placeable placeable, int i, int i2, @NotNull GraphicsLayer graphicsLayer, float f) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        /* JADX INFO: renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m19928placeAutoMirroredaW9wM$ui_release(@NotNull Placeable placeable, long j, float f, @NotNull GraphicsLayer graphicsLayer) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m21096getXimpl(j), IntOffset.m21097getYimpl(j));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
            }
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m19932placeRelativeWithLayeraW9wM(@NotNull Placeable placeable, long j, @NotNull GraphicsLayer graphicsLayer, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m21096getXimpl(j), IntOffset.m21097getYimpl(j));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
            }
        }

        public final void placeRelativeWithLayer(@NotNull Placeable placeable, int i, int i2, @NotNull GraphicsLayer graphicsLayer, float f) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m21096getXimpl(jIntOffset), IntOffset.m21097getYimpl(jIntOffset));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo19916placeAtf8xVGno(IntOffset.m21100plusqkQi6aY(jIntOffset2, placeable.apparentToRealOffset), f, graphicsLayer);
            }
        }

        public float current(@NotNull Ruler ruler, float f) {
            return f;
        }
    }
}
