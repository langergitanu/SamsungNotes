package androidx.compose.p109ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.PointerEventType;
import androidx.compose.p109ui.input.pointer.util.PointerIdArray;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.p109ui.node.PointerInputModifierNode;
import androidx.compose.p109ui.node.PointerInputModifierNodeKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0017\u0010!\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0#H\u0082\bJ.\u0010$\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u001a\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020\rH\u0002J\u0006\u0010(\u001a\u00020\u001dJ\u001e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000-H\u0016J\b\u0010.\u001a\u00020/H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "removeInvalidPointerIdsAndChanges", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "toString", "", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHitPathTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HitPathTracker.kt\nandroidx/compose/ui/input/pointer/Node\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 3 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 4 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 5 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 6 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 7 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 8 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 9 PointerIdArray.kt\nandroidx/compose/ui/input/pointer/util/PointerIdArray\n*L\n1#1,647:1\n587#1,5:659\n594#1:763\n587#1,5:764\n594#1:824\n460#2,11:648\n460#2,11:708\n460#2,11:813\n460#2,11:885\n84#3:664\n84#3:719\n84#3:769\n84#3:825\n84#3:896\n432#4,6:665\n442#4,2:672\n444#4,8:677\n452#4,9:688\n461#4,8:700\n432#4,6:720\n442#4,2:727\n444#4,8:732\n452#4,9:743\n461#4,8:755\n432#4,6:770\n442#4,2:777\n444#4,8:782\n452#4,9:793\n461#4,8:805\n432#4,6:826\n442#4,2:833\n444#4,8:838\n452#4,9:849\n461#4,8:861\n432#4,6:897\n442#4,2:904\n444#4,8:909\n452#4,9:920\n461#4,8:932\n249#5:671\n249#5:726\n249#5:776\n249#5:832\n249#5:903\n245#6,3:674\n248#6,3:697\n245#6,3:729\n248#6,3:752\n245#6,3:779\n248#6,3:802\n245#6,3:835\n248#6,3:858\n245#6,3:906\n248#6,3:929\n1208#7:685\n1187#7,2:686\n1208#7:740\n1187#7,2:741\n1208#7:790\n1187#7,2:791\n1208#7:846\n1187#7,2:847\n1208#7:917\n1187#7,2:918\n33#8,6:869\n116#8,2:876\n33#8,6:878\n118#8:884\n33#8,6:940\n178#9:875\n*S KotlinDebug\n*F\n+ 1 HitPathTracker.kt\nandroidx/compose/ui/input/pointer/Node\n*L\n361#1:659,5\n361#1:763\n400#1:764,5\n400#1:824\n344#1:648,11\n372#1:708,11\n410#1:813,11\n605#1:885,11\n366#1:664\n386#1:719\n404#1:769\n443#1:825\n606#1:896\n366#1:665,6\n366#1:672,2\n366#1:677,8\n366#1:688,9\n366#1:700,8\n386#1:720,6\n386#1:727,2\n386#1:732,8\n386#1:743,9\n386#1:755,8\n404#1:770,6\n404#1:777,2\n404#1:782,8\n404#1:793,9\n404#1:805,8\n443#1:826,6\n443#1:833,2\n443#1:838,8\n443#1:849,9\n443#1:861,8\n606#1:897,6\n606#1:904,2\n606#1:909,8\n606#1:920,9\n606#1:932,8\n366#1:671\n386#1:726\n404#1:776\n443#1:832\n606#1:903\n366#1:674,3\n366#1:697,3\n386#1:729,3\n386#1:752,3\n404#1:779,3\n404#1:802,3\n443#1:835,3\n443#1:858,3\n606#1:906,3\n606#1:929,3\n366#1:685\n366#1:686,2\n386#1:740\n386#1:741,2\n404#1:790\n404#1:791,2\n443#1:846\n443#1:847,2\n606#1:917\n606#1:918,2\n461#1:869,6\n515#1:876,2\n515#1:878,6\n515#1:884\n622#1:940,6\n502#1:875\n*E\n"})
public final class Node extends NodeParent {
    public static final int $stable = 8;

    @Nullable
    private LayoutCoordinates coordinates;

    @NotNull
    private final Modifier.Node modifierNode;

    @Nullable
    private PointerEvent pointerEvent;
    private boolean wasIn;

    @NotNull
    private final PointerIdArray pointerIds = new PointerIdArray();

    @NotNull
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(@NotNull Modifier.Node node) {
        this.modifierNode = node;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m18281equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0235  */
    /* JADX WARN: Type inference failed for: r5v28 */
    @Override // androidx.compose.p109ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean buildCache(@NotNull LongSparseArray<PointerInputChange> changes, @NotNull LayoutCoordinates parentCoordinates, @NotNull InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        PointerInputChange pointerInputChange;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        int i2;
        int i4;
        boolean zBuildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        boolean z4 = true;
        if (!this.modifierNode.getIsAttached()) {
            return true;
        }
        Modifier.Node nodePop = this.modifierNode;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(16);
        MutableVector mutableVector = null;
        while (nodePop != 0) {
            if (nodePop instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) nodePop);
            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                int i5 = 0;
                nodePop = nodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                        i5++;
                        if (i5 == 1) {
                            nodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodePop != 0) {
                                mutableVector.add(nodePop);
                                nodePop = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    nodePop = nodePop;
                }
                if (i5 == 1) {
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
        int size = changes.size();
        int i6 = 0;
        while (i6 < size) {
            long jKeyAt = changes.keyAt(i6);
            PointerInputChange pointerInputChangeValueAt = changes.valueAt(i6);
            if (this.pointerIds.contains(jKeyAt)) {
                boolean z5 = z4;
                int i7 = i6;
                long previousPosition = pointerInputChangeValueAt.getPreviousPosition();
                z3 = z5;
                long position = pointerInputChangeValueAt.getPosition();
                if (Offset.m18287isValidimpl(previousPosition) && Offset.m18287isValidimpl(position)) {
                    ArrayList arrayList = new ArrayList(pointerInputChangeValueAt.getHistorical().size());
                    List<HistoricalChange> historical = pointerInputChangeValueAt.getHistorical();
                    z2 = zBuildCache;
                    int size2 = historical.size();
                    i = size;
                    int i8 = 0;
                    while (i8 < size2) {
                        HistoricalChange historicalChange = historical.get(i8);
                        int i9 = size2;
                        int i10 = i8;
                        long position2 = historicalChange.getPosition();
                        if (Offset.m18287isValidimpl(position2)) {
                            long uptimeMillis = historicalChange.getUptimeMillis();
                            i4 = i7;
                            LayoutCoordinates layoutCoordinates = this.coordinates;
                            Intrinsics.checkNotNull(layoutCoordinates);
                            arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo19864localPositionOfR5De75A(parentCoordinates, position2), historicalChange.getOriginalEventPosition(), null));
                        } else {
                            i4 = i7;
                        }
                        i8 = i10 + 1;
                        size2 = i9;
                        i7 = i4;
                    }
                    i2 = i7;
                    LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates2 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates2);
                    long jMo19864localPositionOfR5De75A = layoutCoordinates2.mo19864localPositionOfR5De75A(parentCoordinates, previousPosition);
                    LayoutCoordinates layoutCoordinates3 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates3);
                    longSparseArray.put(jKeyAt, PointerInputChange.m19715copyOHpmEuE$default(pointerInputChangeValueAt, 0L, 0L, layoutCoordinates3.mo19864localPositionOfR5De75A(parentCoordinates, position), false, 0L, jMo19864localPositionOfR5De75A, false, 0, arrayList, 0L, 731, null));
                } else {
                    z2 = zBuildCache;
                    i = size;
                    i2 = i7;
                }
            } else {
                z2 = zBuildCache;
                i = size;
                z3 = z4;
                i2 = i6;
            }
            i6 = i2 + 1;
            z4 = z3;
            zBuildCache = z2;
            size = i;
        }
        boolean z6 = zBuildCache;
        boolean z7 = z4;
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return z7;
        }
        int size3 = this.pointerIds.getSize();
        while (true) {
            size3--;
            if (-1 >= size3) {
                break;
            }
            if (!changes.containsKey(this.pointerIds.m19821get_I2yYro(size3))) {
                this.pointerIds.removeAt(size3);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
        int size4 = this.relevantChanges.size();
        for (int i11 = 0; i11 < size4; i11++) {
            arrayList2.add(this.relevantChanges.valueAt(i11));
        }
        PointerEvent pointerEvent = new PointerEvent(arrayList2, internalPointerEvent);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size5 = changes2.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size5) {
                pointerInputChange = null;
                break;
            }
            PointerInputChange pointerInputChange2 = changes2.get(i12);
            if (internalPointerEvent.m19655activeHoverEvent0FcD4WY(pointerInputChange2.getId())) {
                pointerInputChange = pointerInputChange2;
                break;
            }
            i12++;
        }
        PointerInputChange pointerInputChange3 = pointerInputChange;
        if (pointerInputChange3 != null) {
            if (isInBounds) {
                z = false;
                if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                    Intrinsics.checkNotNull(this.coordinates);
                    this.isIn = !PointerEventKt.m19670isOutOfBoundsO0kMr_c(pointerInputChange3, r3.mo19863getSizeYbymL2g());
                }
            } else {
                z = false;
                this.isIn = false;
            }
            if (this.isIn != this.wasIn) {
                int type = pointerEvent.getType();
                PointerEventType.Companion companion = PointerEventType.INSTANCE;
                if (PointerEventType.m19675equalsimpl0(type, companion.m19681getMove7fucELk()) || PointerEventType.m19675equalsimpl0(pointerEvent.getType(), companion.m19679getEnter7fucELk()) || PointerEventType.m19675equalsimpl0(pointerEvent.getType(), companion.m19680getExit7fucELk())) {
                    pointerEvent.m19669setTypeEhbLWgg$ui_release(this.isIn ? companion.m19679getEnter7fucELk() : companion.m19680getExit7fucELk());
                } else {
                    int type2 = pointerEvent.getType();
                    PointerEventType.Companion companion2 = PointerEventType.INSTANCE;
                    if (PointerEventType.m19675equalsimpl0(type2, companion2.m19679getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                        pointerEvent.m19669setTypeEhbLWgg$ui_release(companion2.m19681getMove7fucELk());
                    } else if (PointerEventType.m19675equalsimpl0(pointerEvent.getType(), companion2.m19680getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                        pointerEvent.m19669setTypeEhbLWgg$ui_release(companion2.m19681getMove7fucELk());
                    }
                }
            }
        } else {
            z = false;
        }
        boolean z8 = (z6 || !PointerEventType.m19675equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m19681getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z7 : z;
        this.pointerEvent = pointerEvent;
        return z8;
    }

    @Override // androidx.compose.p109ui.input.pointer.NodeParent
    public void cleanUpHits(@NotNull InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            boolean pressed = pointerInputChange.getPressed();
            boolean zM19655activeHoverEvent0FcD4WY = internalPointerEvent.m19655activeHoverEvent0FcD4WY(pointerInputChange.getId());
            boolean z = this.isIn;
            if ((!pressed && !zM19655activeHoverEvent0FcD4WY) || (!pressed && !z)) {
                this.pointerIds.m19822remove0FcD4WY(pointerInputChange.getId());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m19675equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m19680getExit7fucELk());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // androidx.compose.p109ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i = 0;
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
        Modifier.Node nodePop = this.modifierNode;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(16);
        MutableVector mutableVector = null;
        while (nodePop != 0) {
            if (nodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) nodePop).onCancelPointerInput();
            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                int i2 = 0;
                nodePop = nodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                        i2++;
                        if (i2 == 1) {
                            nodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodePop != 0) {
                                mutableVector.add(nodePop);
                                nodePop = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    nodePop = nodePop;
                }
                if (i2 == 1) {
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // androidx.compose.p109ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(@NotNull InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long jMo19863getSizeYbymL2g = layoutCoordinates.mo19863getSizeYbymL2g();
            Modifier.Node nodePop = this.modifierNode;
            int iM20090constructorimpl = NodeKind.m20090constructorimpl(16);
            MutableVector mutableVector = null;
            while (nodePop != 0) {
                if (nodePop instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) nodePop).mo15382onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, jMo19863getSizeYbymL2g);
                } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                    int i2 = 0;
                    nodePop = nodePop;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                            i2++;
                            if (i2 == 1) {
                                nodePop = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (nodePop != 0) {
                                    mutableVector.add(nodePop);
                                    nodePop = 0;
                                }
                                mutableVector.add(delegate);
                            }
                        }
                        delegate = delegate.getChild();
                        nodePop = nodePop;
                    }
                    if (i2 == 1) {
                    }
                }
                nodePop = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.modifierNode.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
                Node[] content = children.getContent();
                do {
                    content[i].dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v18 */
    @Override // androidx.compose.p109ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(@NotNull LongSparseArray<PointerInputChange> changes, @NotNull LayoutCoordinates parentCoordinates, @NotNull InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        MutableVector<Node> children;
        int size;
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long jMo19863getSizeYbymL2g = layoutCoordinates.mo19863getSizeYbymL2g();
        Modifier.Node nodePop = this.modifierNode;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(16);
        MutableVector mutableVector = null;
        while (nodePop != 0) {
            if (nodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) nodePop).mo15382onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, jMo19863getSizeYbymL2g);
            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                int i = 0;
                nodePop = nodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            nodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodePop != 0) {
                                mutableVector.add(nodePop);
                                nodePop = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    nodePop = nodePop;
                }
                if (i == 1) {
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.modifierNode.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
            Node[] content = children.getContent();
            int i2 = 0;
            do {
                Node node = content[i2];
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
                i2++;
            } while (i2 < size);
        }
        if (this.modifierNode.getIsAttached()) {
            Modifier.Node nodePop2 = this.modifierNode;
            int iM20090constructorimpl2 = NodeKind.m20090constructorimpl(16);
            MutableVector mutableVector2 = null;
            while (nodePop2 != 0) {
                if (nodePop2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) nodePop2).mo15382onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, jMo19863getSizeYbymL2g);
                } else if ((nodePop2.getKindSet() & iM20090constructorimpl2) != 0 && (nodePop2 instanceof DelegatingNode)) {
                    Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate();
                    int i4 = 0;
                    nodePop2 = nodePop2;
                    while (delegate2 != null) {
                        if ((delegate2.getKindSet() & iM20090constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                nodePop2 = delegate2;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (nodePop2 != 0) {
                                    mutableVector2.add(nodePop2);
                                    nodePop2 = 0;
                                }
                                mutableVector2.add(delegate2);
                            }
                        }
                        delegate2 = delegate2.getChild();
                        nodePop2 = nodePop2;
                    }
                    if (i4 == 1) {
                    }
                }
                nodePop2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    @NotNull
    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    @NotNull
    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.p109ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, @NotNull MutableObjectList<Node> hitNodes) {
        if (this.pointerIds.contains(pointerIdValue) && !hitNodes.contains(this)) {
            this.pointerIds.remove(pointerIdValue);
            this.relevantChanges.remove(pointerIdValue);
        }
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i = 0;
            do {
                content[i].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
                i++;
            } while (i < size);
        }
    }

    @NotNull
    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + PropertyUtils.MAPPED_DELIM2;
    }
}
