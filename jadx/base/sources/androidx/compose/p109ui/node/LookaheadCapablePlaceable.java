package androidx.compose.p109ui.node;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.AlignmentLine;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.layout.PlaceableKt;
import androidx.compose.p109ui.layout.Ruler;
import androidx.compose.p109ui.layout.RulerScope;
import androidx.compose.p109ui.layout.VerticalAlignmentLine;
import androidx.compose.p109ui.layout.VerticalRuler;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010?\u001a\u00020@2\u0006\u0010!\u001a\u00020\"2\u0006\u0010A\u001a\u000205H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH&J\u0017\u0010F\u001a\u00020@2\b\u0010G\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\bHJ\u0010\u0010F\u001a\u00020@2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00002\u0006\u0010A\u001a\u000205H\u0002J\u0016\u0010L\u001a\u00020M2\u0006\u0010A\u001a\u0002052\u0006\u0010N\u001a\u00020MJ\u0011\u0010O\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0086\u0002J\u0010\u0010P\u001a\u00020@2\u0006\u0010A\u001a\u000205H\u0002J`\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020C2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0U2\u0019\u0010V\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020@\u0018\u00010W¢\u0006\u0002\bX2\u0017\u0010Y\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020@0W¢\u0006\u0002\bXH\u0016J&\u0010Z\u001a\u00020@2\u001c\u0010[\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"07j\b\u0012\u0004\u0012\u00020\"`806H\u0002J\u0016\u0010\\\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010]\u001a\u00020MJ\u0016\u0010^\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010]\u001a\u00020MJ\r\u0010_\u001a\u00020@H ¢\u0006\u0002\b`J\f\u0010a\u001a\u00020@*\u00020bH\u0004J\u0014\u0010c\u001a\u00020\u0013*\u00020\"2\u0006\u0010d\u001a\u00020\"H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u001aR\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020&X \u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\rR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u000200X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u00102R2\u00103\u001a&\u0012\u0004\u0012\u000205\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"07j\b\u0012\u0004\u0012\u00020\"`806\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, m13886d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "()V", "_rulerScope", "Landroidx/compose/ui/layout/RulerScope;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "isLookingAhead$annotations", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "parent", "getParent", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/node/WeakReference;", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/layout/RulerScope;", "rulerValues", "Landroidx/collection/MutableObjectFloatMap;", "rulerValuesCache", "addRulerReader", "", "ruler", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "captureRulers", "result", "captureRulers$ui_release", "placeableResult", "Landroidx/compose/ui/node/PlaceableResult;", "findAncestorRulerDefiner", "findRulerValue", "", "defaultValue", "get", "invalidateChildrenOfDefiningRuler", DBSchema.DocumentThumbnail.LAYOUT, "width", "height", "alignmentLines", "", "rulers", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "notifyRulerValueChange", "layoutNodes", "provideRelativeRulerValue", "value", "provideRulerValue", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "replace$ui_release", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLayoutNodeAncestor", DBSchema.CategoryTreeClosure.ANCESTOR, "Companion", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLookaheadDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LookaheadDelegate.kt\nandroidx/compose/ui/node/LookaheadCapablePlaceable\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 ScatterSet.kt\nandroidx/collection/MutableScatterSet\n+ 5 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 6 ScatterMap.kt\nandroidx/collection/MutableScatterMap\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 8 LookaheadDelegate.kt\nandroidx/compose/ui/node/LookaheadDelegateKt\n+ 9 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 10 ObjectFloatMap.kt\nandroidx/collection/ObjectFloatMap\n*L\n1#1,491:1\n418#2,3:492\n363#2,6:495\n373#2,3:502\n376#2,2:506\n422#2:508\n423#2:536\n379#2,6:537\n424#2:543\n363#2,6:545\n373#2,3:552\n376#2,2:556\n379#2,6:562\n418#2,3:580\n363#2,6:583\n373#2,3:590\n376#2,2:594\n422#2,2:596\n379#2,6:598\n424#2:604\n418#2,3:605\n363#2,6:608\n373#2,3:615\n376#2,2:619\n422#2,2:621\n379#2,6:623\n424#2:629\n1810#3:501\n1672#3:505\n1810#3:518\n1672#3:522\n1810#3:551\n1672#3:555\n1810#3:589\n1672#3:593\n1810#3:614\n1672#3:618\n1810#3:641\n1672#3:645\n1810#3:666\n1672#3:670\n1810#3:693\n1672#3:697\n842#4,2:509\n845#4,4:525\n849#4:535\n237#5,7:511\n248#5,3:519\n251#5,2:523\n254#5,6:529\n267#5,4:682\n237#5,7:686\n248#5,3:694\n251#5,2:698\n272#5,2:700\n254#5,6:702\n274#5:708\n1047#6:544\n1049#6,4:558\n1053#6:568\n863#6:569\n1#7:570\n1#7:630\n341#8:571\n342#8:577\n345#8:579\n42#9,5:572\n48#9:578\n401#10,4:631\n373#10,6:635\n383#10,3:642\n386#10,2:646\n406#10,2:648\n389#10,6:650\n408#10:656\n415#10,3:657\n373#10,6:660\n383#10,3:667\n386#10,2:671\n419#10,2:673\n389#10,6:675\n421#10:681\n*S KotlinDebug\n*F\n+ 1 LookaheadDelegate.kt\nandroidx/compose/ui/node/LookaheadCapablePlaceable\n*L\n163#1:492,3\n163#1:495,6\n163#1:502,3\n163#1:506,2\n163#1:508\n163#1:536\n163#1:537,6\n163#1:543\n166#1:545,6\n166#1:552,3\n166#1:556,2\n166#1:562,6\n232#1:580,3\n232#1:583,6\n232#1:590,3\n232#1:594,2\n232#1:596,2\n232#1:598,6\n232#1:604\n247#1:605,3\n247#1:608,6\n247#1:615,3\n247#1:619,2\n247#1:621,2\n247#1:623,6\n247#1:629\n163#1:501\n163#1:505\n164#1:518\n164#1:522\n166#1:551\n166#1:555\n232#1:589\n232#1:593\n247#1:614\n247#1:618\n268#1:641\n268#1:645\n281#1:666\n281#1:670\n291#1:693\n291#1:697\n164#1:509,2\n164#1:525,4\n164#1:535\n164#1:511,7\n164#1:519,3\n164#1:523,2\n164#1:529,6\n291#1:682,4\n291#1:686,7\n291#1:694,3\n291#1:698,2\n291#1:700,2\n291#1:702,6\n291#1:708\n166#1:544\n166#1:558,4\n166#1:568\n171#1:569\n171#1:570\n211#1:571\n211#1:577\n211#1:579\n211#1:572,5\n211#1:578\n268#1:631,4\n268#1:635,6\n268#1:642,3\n268#1:646,2\n268#1:648,2\n268#1:650,6\n268#1:656\n281#1:657,3\n281#1:660,6\n281#1:667,3\n281#1:671,2\n281#1:673,2\n281#1:675,6\n281#1:681\n*E\n"})
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    public static final int $stable = 0;

    @NotNull
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = new Function1<PlaceableResult, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlaceableResult placeableResult) {
            invoke2(placeableResult);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull PlaceableResult placeableResult) {
            if (placeableResult.isValidOwnerScope()) {
                placeableResult.getPlaceable().captureRulers(placeableResult);
            }
        }
    };

    @Nullable
    private RulerScope _rulerScope;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;

    @NotNull
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);

    @Nullable
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;

    @Nullable
    private MutableObjectFloatMap<Ruler> rulerValues;

    @Nullable
    private MutableObjectFloatMap<Ruler> rulerValuesCache;

    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x009f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addRulerReader(LayoutNode layoutNode, Ruler ruler) {
        char c;
        long j;
        long j2;
        long j3;
        int i;
        int i2;
        long[] jArr;
        long[] jArr2;
        long j5;
        int i4;
        char c2;
        long j6;
        int i5;
        int i6;
        int i7;
        boolean z;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        char c4 = 7;
        long j7 = -9187201950435737472L;
        int i8 = 8;
        if (mutableScatterMap != null) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i9 = 0;
                j2 = 128;
                while (true) {
                    long j8 = jArr3[i9];
                    j3 = 255;
                    if ((((~j8) << c4) & j8 & j7) != j7) {
                        int i10 = 8 - ((~(i9 - length)) >>> 31);
                        int i11 = 0;
                        while (i11 < i10) {
                            if ((j8 & 255) < 128) {
                                c2 = c4;
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) objArr[(i9 << 3) + i11];
                                j6 = j7;
                                Object[] objArr2 = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    int i12 = i8;
                                    int i13 = 0;
                                    while (true) {
                                        int i14 = length2;
                                        long j9 = jArr4[i13];
                                        jArr2 = jArr3;
                                        j5 = j8;
                                        if ((((~j9) << c2) & j9 & j6) != j6) {
                                            int i15 = 8 - ((~(i13 - i14)) >>> 31);
                                            int i16 = 0;
                                            while (i16 < i15) {
                                                if ((j9 & 255) < 128) {
                                                    int i17 = (i13 << 3) + i16;
                                                    LayoutNode layoutNode2 = (LayoutNode) ((WeakReference) objArr2[i17]).get();
                                                    i6 = i16;
                                                    if (layoutNode2 != null) {
                                                        boolean zIsAttached = layoutNode2.isAttached();
                                                        i7 = i11;
                                                        z = zIsAttached;
                                                        if (z) {
                                                            mutableScatterSet.removeElementAt(i17);
                                                        }
                                                    } else {
                                                        i7 = i11;
                                                    }
                                                    if (z) {
                                                    }
                                                } else {
                                                    i6 = i16;
                                                    i7 = i11;
                                                }
                                                j9 >>= i12;
                                                i16 = i6 + 1;
                                                i11 = i7;
                                            }
                                            i4 = i11;
                                            if (i15 != i12) {
                                                break;
                                            }
                                        } else {
                                            i4 = i11;
                                        }
                                        length2 = i14;
                                        if (i13 == length2) {
                                            break;
                                        }
                                        i13++;
                                        jArr3 = jArr2;
                                        j8 = j5;
                                        i11 = i4;
                                        i12 = 8;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j5 = j8;
                                    i4 = i11;
                                }
                                i5 = 8;
                            } else {
                                jArr2 = jArr3;
                                j5 = j8;
                                i4 = i11;
                                c2 = c4;
                                j6 = j7;
                                i5 = i8;
                            }
                            i8 = i5;
                            j8 = j5 >> i5;
                            c4 = c2;
                            j7 = j6;
                            i11 = i4 + 1;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        c = c4;
                        j = j7;
                        if (i10 != i8) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                        c = c4;
                        j = j7;
                    }
                    if (i9 == length) {
                        break;
                    }
                    i9++;
                    c4 = c;
                    j7 = j;
                    jArr3 = jArr;
                    i8 = 8;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 128;
                j3 = 255;
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 != null) {
            long[] jArr5 = mutableScatterMap2.metadata;
            int length3 = jArr5.length - 2;
            if (length3 >= 0) {
                int i18 = 0;
                while (true) {
                    long j10 = jArr5[i18];
                    if ((((~j10) << c) & j10 & j) != j) {
                        int i19 = 8 - ((~(i18 - length3)) >>> 31);
                        for (int i20 = 0; i20 < i19; i20++) {
                            if ((j10 & j3) < j2) {
                                int i21 = (i18 << 3) + i20;
                                if (((MutableScatterSet) mutableScatterMap2.values[i21]).isEmpty()) {
                                    mutableScatterMap2.removeValueAt(i21);
                                }
                            }
                            j10 >>= 8;
                        }
                        if (i19 != 8) {
                            break;
                        }
                    }
                    if (i18 == length3) {
                        break;
                    } else {
                        i18++;
                    }
                }
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap3 = this.rulerReaders;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (mutableScatterMap3 == null) {
            i = 0;
            i2 = 1;
            mutableScatterMap3 = new MutableScatterMap<>(i, i2, defaultConstructorMarker);
            this.rulerReaders = mutableScatterMap3;
        } else {
            i = 0;
            i2 = 1;
        }
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet2 = mutableScatterMap3.get(ruler);
        if (mutableScatterSet2 == null) {
            mutableScatterSet2 = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            mutableScatterMap3.set(ruler, mutableScatterSet2);
        }
        mutableScatterSet2.plusAssign(new WeakReference<>(layoutNode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void captureRulers(final PlaceableResult placeableResult) {
        long j;
        long j2;
        LookaheadCapablePlaceable parent;
        long j3;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSetRemove;
        OwnerSnapshotObserver snapshotObserver;
        char c;
        char c2;
        if (this.isPlacingForAlignment) {
            return;
        }
        Function1<RulerScope, Unit> rulers = placeableResult.getResult().getRulers();
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        char c4 = 7;
        long j5 = -9187201950435737472L;
        int i = 0;
        if (rulers == null) {
            if (mutableScatterMap != null) {
                Object[] objArr = mutableScatterMap.values;
                long[] jArr = mutableScatterMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i2 = 0;
                    while (true) {
                        long j6 = jArr[i2];
                        if ((((~j6) << c4) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i4 = 8 - ((~(i2 - length)) >>> 31);
                            int i5 = 0;
                            while (i5 < i4) {
                                if ((j6 & 255) < 128) {
                                    c2 = c4;
                                    notifyRulerValueChange((MutableScatterSet) objArr[(i2 << 3) + i5]);
                                } else {
                                    c2 = c4;
                                }
                                j6 >>= 8;
                                i5++;
                                c4 = c2;
                            }
                            c = c4;
                            if (i4 != 8) {
                                break;
                            }
                        } else {
                            c = c4;
                        }
                        if (i2 == length) {
                            break;
                        }
                        i2++;
                        c4 = c;
                    }
                }
                mutableScatterMap.clear();
                return;
            }
            return;
        }
        long j7 = 128;
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValuesCache;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i6 = 1;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(i, i6, defaultConstructorMarker);
            this.rulerValuesCache = mutableObjectFloatMap;
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap2 = this.rulerValues;
        if (mutableObjectFloatMap2 == null) {
            mutableObjectFloatMap2 = new MutableObjectFloatMap<>(i, i6, defaultConstructorMarker);
            this.rulerValues = mutableObjectFloatMap2;
        }
        mutableObjectFloatMap.putAll(mutableObjectFloatMap2);
        mutableObjectFloatMap2.clear();
        Owner owner = getLayoutNode().getOwner();
        if (owner != null && (snapshotObserver = owner.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(placeableResult, onCommitAffectingRuler, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulers.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function1<RulerScope, Unit> rulers2 = placeableResult.getResult().getRulers();
                    if (rulers2 != null) {
                        rulers2.invoke(this.getRulerScope());
                    }
                }
            });
        }
        if (mutableScatterMap != null) {
            Object[] objArr2 = mutableObjectFloatMap.keys;
            float[] fArr = mutableObjectFloatMap.values;
            long[] jArr2 = mutableObjectFloatMap.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i7 = 0;
                while (true) {
                    long j8 = jArr2[i7];
                    j = j5;
                    if ((((~j8) << 7) & j8 & j) != j) {
                        int i8 = 8 - ((~(i7 - length2)) >>> 31);
                        int i9 = i;
                        while (i9 < i8) {
                            if ((j8 & 255) < j7) {
                                int i10 = (i7 << 3) + i9;
                                Ruler ruler = (Ruler) objArr2[i10];
                                j3 = j7;
                                if (mutableObjectFloatMap2.getOrDefault(ruler, Float.NaN) != fArr[i10] && (mutableScatterSetRemove = mutableScatterMap.remove(ruler)) != null) {
                                    notifyRulerValueChange(mutableScatterSetRemove);
                                }
                            } else {
                                j3 = j7;
                            }
                            j8 >>= 8;
                            i9++;
                            j7 = j3;
                        }
                        j2 = j7;
                        if (i8 != 8) {
                            break;
                        }
                    } else {
                        j2 = j7;
                    }
                    if (i7 == length2) {
                        break;
                    }
                    i7++;
                    j5 = j;
                    j7 = j2;
                    i = 0;
                }
            } else {
                j = -9187201950435737472L;
                j2 = 128;
            }
        }
        Object[] objArr3 = mutableObjectFloatMap2.keys;
        long[] jArr3 = mutableObjectFloatMap2.metadata;
        int length3 = jArr3.length - 2;
        if (length3 >= 0) {
            int i11 = 0;
            while (true) {
                long j9 = jArr3[i11];
                if ((((~j9) << 7) & j9 & j) != j) {
                    int i12 = 8 - ((~(i11 - length3)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((j9 & 255) < j2) {
                            Ruler ruler2 = (Ruler) objArr3[(i11 << 3) + i13];
                            if (!mutableObjectFloatMap.contains(ruler2) && (parent = getParent()) != null) {
                                parent.invalidateChildrenOfDefiningRuler(ruler2);
                            }
                        }
                        j9 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    } else if (i11 == length3) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        mutableObjectFloatMap.clear();
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = lookaheadCapablePlaceable.rulerValues;
            if (mutableObjectFloatMap != null && mutableObjectFloatMap.contains(ruler)) {
                return lookaheadCapablePlaceable;
            }
            LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
            if (parent == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    private final void invalidateChildrenOfDefiningRuler(Ruler ruler) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = findAncestorRulerDefiner(ruler).rulerReaders;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSetRemove = mutableScatterMap != null ? mutableScatterMap.remove(ruler) : null;
        if (mutableScatterSetRemove != null) {
            notifyRulerValueChange(mutableScatterSetRemove);
        }
    }

    private final boolean isLayoutNodeAncestor(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode == layoutNode2) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            return isLayoutNodeAncestor(parent$ui_release, layoutNode2);
        }
        return false;
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> layoutNodes) {
        LayoutNode layoutNode;
        Object[] objArr = layoutNodes.elements;
        long[] jArr = layoutNodes.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i4]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui_release(false);
                        } else {
                            layoutNode.requestRelayout$ui_release(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public abstract int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine);

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void captureRulers$ui_release(@Nullable MeasureResult result) {
        if (result != null) {
            captureRulers(new PlaceableResult(result, this));
            return;
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        if (mutableScatterMap != null) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i4 = 0; i4 < i2; i4++) {
                            if ((255 & j) < 128) {
                                notifyRulerValueChange((MutableScatterSet) objArr[(i << 3) + i4]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i == length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 != null) {
            mutableScatterMap2.clear();
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap != null) {
            mutableObjectFloatMap.clear();
        }
    }

    public final float findRulerValue(@NotNull Ruler ruler, float defaultValue) {
        if (this.isPlacingForAlignment) {
            return defaultValue;
        }
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = lookaheadCapablePlaceable.rulerValues;
            float orDefault = mutableObjectFloatMap != null ? mutableObjectFloatMap.getOrDefault(ruler, Float.NaN) : Float.NaN;
            if (!Float.isNaN(orDefault)) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return ruler.calculateCoordinate$ui_release(orDefault, lookaheadCapablePlaceable.getCoordinates(), getCoordinates());
            }
            LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
            if (parent == null) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return defaultValue;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    @Override // androidx.compose.p109ui.layout.Measured
    public final int get(@NotNull AlignmentLine alignmentLine) {
        int iCalculateAlignmentLine;
        if (getHasMeasureResult() && (iCalculateAlignmentLine = calculateAlignmentLine(alignmentLine)) != Integer.MIN_VALUE) {
            return iCalculateAlignmentLine + (alignmentLine instanceof VerticalAlignmentLine ? IntOffset.m21096getXimpl(getApparentToRealOffset()) : IntOffset.m21097getYimpl(getApparentToRealOffset()));
        }
        return Integer.MIN_VALUE;
    }

    @NotNull
    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    @Nullable
    public abstract LookaheadCapablePlaceable getChild();

    @NotNull
    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.p109ui.node.MeasureScopeWithLayoutNode
    @NotNull
    public abstract LayoutNode getLayoutNode();

    @NotNull
    public abstract MeasureResult getMeasureResult$ui_release();

    @Nullable
    public abstract LookaheadCapablePlaceable getParent();

    @NotNull
    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long getPosition();

    @NotNull
    public final RulerScope getRulerScope() {
        RulerScope rulerScope = this._rulerScope;
        return rulerScope == null ? new RulerScope() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$rulerScope$1
            @Override // androidx.compose.p109ui.layout.RulerScope
            @NotNull
            public LayoutCoordinates getCoordinates() {
                this.this$0.getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
                return this.this$0.getCoordinates();
            }

            @Override // androidx.compose.p109ui.unit.Density
            public float getDensity() {
                return this.this$0.getDensity();
            }

            @Override // androidx.compose.p109ui.unit.FontScaling
            public float getFontScale() {
                return this.this$0.getFontScale();
            }

            @Override // androidx.compose.p109ui.layout.RulerScope
            public void provides(@NotNull Ruler ruler, float f) {
                this.this$0.provideRulerValue(ruler, f);
            }

            @Override // androidx.compose.p109ui.layout.RulerScope
            public void providesRelative(@NotNull VerticalRuler verticalRuler, float f) {
                this.this$0.provideRelativeRulerValue(verticalRuler, f);
            }
        } : rulerScope;
    }

    public final void invalidateAlignmentLinesFromPositionChange(@NotNull NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped = nodeCoordinator.getWrapped();
        if (!Intrinsics.areEqual(wrapped != null ? wrapped.getLayoutNode() : null, nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    @Override // androidx.compose.p109ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    @Override // androidx.compose.p109ui.node.MotionReferencePlacementDelegate
    /* JADX INFO: renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    /* JADX INFO: renamed from: isPlacingForAlignment$ui_release, reason: from getter */
    public final boolean getIsPlacingForAlignment() {
        return this.isPlacingForAlignment;
    }

    /* JADX INFO: renamed from: isShallowPlacing$ui_release, reason: from getter */
    public final boolean getIsShallowPlacing() {
        return this.isShallowPlacing;
    }

    @Override // androidx.compose.p109ui.layout.MeasureScope
    @NotNull
    public MeasureResult layout(final int width, final int height, @NotNull final Map<AlignmentLine, Integer> alignmentLines, @Nullable final Function1<? super RulerScope, Unit> rulers, @NotNull final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        if (!((width & (-16777216)) == 0 && ((-16777216) & height) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.layout.1
            @Override // androidx.compose.p109ui.layout.MeasureResult
            @NotNull
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return alignmentLines;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            /* JADX INFO: renamed from: getHeight, reason: from getter */
            public int getF1178$h() {
                return height;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            @Nullable
            public Function1<RulerScope, Unit> getRulers() {
                return rulers;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            /* JADX INFO: renamed from: getWidth, reason: from getter */
            public int getF1179$w() {
                return width;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            public void placeChildren() {
                placementBlock.invoke(this.getPlacementScope());
            }
        };
    }

    public final void provideRelativeRulerValue(@NotNull Ruler ruler, float value) {
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValues = mutableObjectFloatMap;
        }
        if (getLayoutDirection() != LayoutDirection.Ltr) {
            value = getWidth() - value;
        }
        mutableObjectFloatMap.set(ruler, value);
    }

    public final void provideRulerValue(@NotNull Ruler ruler, float value) {
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValues = mutableObjectFloatMap;
        }
        mutableObjectFloatMap.set(ruler, value);
    }

    public abstract void replace$ui_release();

    @Override // androidx.compose.p109ui.node.MotionReferencePlacementDelegate
    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    public final void setPlacingForAlignment$ui_release(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final void setShallowPlacing$ui_release(boolean z) {
        this.isShallowPlacing = z;
    }

    public static /* synthetic */ void isLookingAhead$annotations() {
    }
}
