package androidx.compose.p109ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u001e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, m13886d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "hitPointerIdsAndNodes", "Landroidx/collection/MutableLongObjectMap;", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/input/pointer/Node;", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNodes", "", "Landroidx/compose/ui/Modifier$Node;", "prunePointerIdsAndChangesNotInNodesList", "", "addHitPath-QJqDSyo", "(JLjava/util/List;Z)V", "clearPreviouslyHitModifierNodeCache", "dispatchChanges", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "processCancel", "removeDetachedPointerInputNodes", "removeInvalidPointerIdsAndChanges", "", "hitNodes", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHitPathTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HitPathTracker.kt\nandroidx/compose/ui/input/pointer/HitPathTracker\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 3 LongObjectMap.kt\nandroidx/collection/MutableLongObjectMap\n+ 4 ObjectList.kt\nandroidx/collection/ObjectListKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 LongObjectMap.kt\nandroidx/collection/LongObjectMap\n+ 7 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,647:1\n366#2,12:648\n728#3:660\n728#3:663\n1580#4:661\n1580#4:664\n1#5:662\n1#5:665\n382#6,4:666\n354#6,6:670\n364#6,3:677\n367#6,2:681\n387#6,2:683\n370#6,6:685\n389#6:691\n1810#7:676\n1672#7:680\n*S KotlinDebug\n*F\n+ 1 HitPathTracker.kt\nandroidx/compose/ui/input/pointer/HitPathTracker\n*L\n77#1:648,12\n86#1:660\n101#1:663\n86#1:661\n101#1:664\n86#1:662\n101#1:665\n110#1:666,4\n110#1:670,6\n110#1:677,3\n110#1:681,2\n110#1:683,2\n110#1:685,6\n110#1:691\n110#1:676\n110#1:680\n*E\n"})
public final class HitPathTracker {
    public static final int $stable = 8;

    @NotNull
    private final LayoutCoordinates rootCoordinates;

    @NotNull
    private final NodeParent root = new NodeParent();

    @NotNull
    private final MutableLongObjectMap<MutableObjectList<Node>> hitPointerIdsAndNodes = new MutableLongObjectMap<>(10);

    public HitPathTracker(@NotNull LayoutCoordinates layoutCoordinates) {
        this.rootCoordinates = layoutCoordinates;
    }

    /* JADX INFO: renamed from: addHitPath-QJqDSyo$default, reason: not valid java name */
    public static /* synthetic */ void m19653addHitPathQJqDSyo$default(HitPathTracker hitPathTracker, long j, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        hitPathTracker.m19654addHitPathQJqDSyo(j, list, z);
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    private final void removeInvalidPointerIdsAndChanges(long pointerId, MutableObjectList<Node> hitNodes) {
        this.root.removeInvalidPointerIdsAndChanges(pointerId, hitNodes);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX INFO: renamed from: addHitPath-QJqDSyo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m19654addHitPathQJqDSyo(long pointerId, @NotNull List<? extends Modifier.Node> pointerInputNodes, boolean prunePointerIdsAndChangesNotInNodesList) {
        MutableObjectList<Node> mutableObjectList;
        Node node;
        Node node2;
        NodeParent nodeParent = this.root;
        this.hitPointerIdsAndNodes.clear();
        int size = pointerInputNodes.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            Modifier.Node node3 = pointerInputNodes.get(i);
            if (z) {
                MutableVector<Node> children = nodeParent.getChildren();
                int size2 = children.getSize();
                if (size2 > 0) {
                    Node[] content = children.getContent();
                    int i2 = 0;
                    do {
                        node = content[i2];
                        if (Intrinsics.areEqual(node.getModifierNode(), node3)) {
                            break;
                        } else {
                            i2++;
                        }
                    } while (i2 < size2);
                    node = null;
                    node2 = node;
                    if (node2 == null) {
                        node2.markIsIn();
                        node2.getPointerIds().m19819add0FcD4WY(pointerId);
                        MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap = this.hitPointerIdsAndNodes;
                        MutableObjectList<Node> mutableObjectList2 = mutableLongObjectMap.get(pointerId);
                        if (mutableObjectList2 == null) {
                            mutableObjectList2 = new MutableObjectList<>(0, 1, null);
                            mutableLongObjectMap.set(pointerId, mutableObjectList2);
                        }
                        mutableObjectList2.add(node2);
                        nodeParent = node2;
                    } else {
                        z = false;
                        Node node4 = new Node(node3);
                        node4.getPointerIds().m19819add0FcD4WY(pointerId);
                        MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap2 = this.hitPointerIdsAndNodes;
                        mutableObjectList = mutableLongObjectMap2.get(pointerId);
                        if (mutableObjectList != null) {
                        }
                        mutableObjectList.add(node4);
                        nodeParent.getChildren().add(node4);
                        nodeParent = node4;
                    }
                } else {
                    node = null;
                    node2 = node;
                    if (node2 == null) {
                    }
                }
            } else {
                Node node42 = new Node(node3);
                node42.getPointerIds().m19819add0FcD4WY(pointerId);
                MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap22 = this.hitPointerIdsAndNodes;
                mutableObjectList = mutableLongObjectMap22.get(pointerId);
                if (mutableObjectList != null) {
                    mutableObjectList = new MutableObjectList<>(0, 1, null);
                    mutableLongObjectMap22.set(pointerId, mutableObjectList);
                }
                mutableObjectList.add(node42);
                nodeParent.getChildren().add(node42);
                nodeParent = node42;
            }
        }
        if (!prunePointerIdsAndChangesNotInNodesList) {
            return;
        }
        MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap3 = this.hitPointerIdsAndNodes;
        long[] jArr = mutableLongObjectMap3.keys;
        Object[] objArr = mutableLongObjectMap3.values;
        long[] jArr2 = mutableLongObjectMap3.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i4 = 0;
        while (true) {
            long j = jArr2[i4];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i5 = 8 - ((~(i4 - length)) >>> 31);
                for (int i6 = 0; i6 < i5; i6++) {
                    if ((255 & j) < 128) {
                        int i7 = (i4 << 3) + i6;
                        removeInvalidPointerIdsAndChanges(jArr[i7], (MutableObjectList) objArr[i7]);
                    }
                    j >>= 8;
                }
                if (i5 != 8) {
                    return;
                }
            }
            if (i4 == length) {
                return;
            } else {
                i4++;
            }
        }
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        this.root.clear();
    }

    public final boolean dispatchChanges(@NotNull InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds)) {
            return this.root.dispatchFinalEventPass(internalPointerEvent) || this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds);
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: getRoot$ui_release, reason: from getter */
    public final NodeParent getRoot() {
        return this.root;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        clearPreviouslyHitModifierNodeCache();
    }

    public final void removeDetachedPointerInputNodes() {
        this.root.removeDetachedPointerInputModifierNodes();
    }
}
