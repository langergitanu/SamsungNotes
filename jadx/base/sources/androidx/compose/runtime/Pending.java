package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import com.google.firebase.messaging.Constants;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0006J\u001e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006J\u0016\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R-\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00138FX\u0086\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, m13886d2 = {"Landroidx/compose/runtime/Pending;", "", "keyInfos", "", "Landroidx/compose/runtime/KeyInfo;", TextConst.KEY_START_INDEX, "", "(Ljava/util/List;I)V", "groupIndex", "getGroupIndex", "()I", "setGroupIndex", "(I)V", "groupInfos", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/GroupInfo;", "getKeyInfos", "()Ljava/util/List;", "keyMap", "Landroidx/compose/runtime/MutableScatterMultiMap;", "getKeyMap-SAeQiB4", "()Landroidx/collection/MutableScatterMap;", "keyMap$delegate", "Lkotlin/Lazy;", "getStartIndex", "used", "", "getUsed", "usedKeys", "getNext", "key", "dataKey", "nodePositionOf", "keyInfo", "recordUsed", "", "registerInsert", "", "insertIndex", "registerMoveNode", Constants.MessagePayloadKeys.FROM, "to", "count", "registerMoveSlot", "slotPositionOf", "updateNodeCount", "group", "newCount", "updatedNodeCountOf", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/Pending\n+ 2 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 3 IntObjectMap.kt\nandroidx/collection/IntObjectMap\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,4584:1\n33#2,7:4585\n409#3,3:4592\n355#3,6:4595\n365#3,3:4602\n368#3,2:4606\n413#3,2:4608\n371#3,6:4610\n415#3:4616\n409#3,3:4617\n355#3,6:4620\n365#3,3:4627\n368#3,2:4631\n413#3,2:4633\n371#3,6:4635\n415#3:4641\n409#3,3:4642\n355#3,6:4645\n365#3,3:4652\n368#3,2:4656\n413#3,2:4658\n371#3,6:4660\n415#3:4666\n409#3,3:4667\n355#3,6:4670\n365#3,3:4677\n368#3,2:4681\n413#3,2:4683\n371#3,6:4685\n415#3:4691\n409#3,3:4692\n355#3,6:4695\n365#3,3:4702\n368#3,2:4706\n413#3,2:4708\n371#3,6:4710\n415#3:4716\n1956#4:4601\n1820#4:4605\n1956#4:4626\n1820#4:4630\n1956#4:4651\n1820#4:4655\n1956#4:4676\n1820#4:4680\n1956#4:4701\n1820#4:4705\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/Pending\n*L\n126#1:4585,7\n173#1:4592,3\n173#1:4595,6\n173#1:4602,3\n173#1:4606,2\n173#1:4608,2\n173#1:4610,6\n173#1:4616\n179#1:4617,3\n179#1:4620,6\n179#1:4627,3\n179#1:4631,2\n179#1:4633,2\n179#1:4635,6\n179#1:4641\n189#1:4642,3\n189#1:4645,6\n189#1:4652,3\n189#1:4656,2\n189#1:4658,2\n189#1:4660,6\n189#1:4666\n195#1:4667,3\n195#1:4670,6\n195#1:4677,3\n195#1:4681,2\n195#1:4683,2\n195#1:4685,6\n195#1:4691\n215#1:4692,3\n215#1:4695,6\n215#1:4702,3\n215#1:4706,2\n215#1:4708,2\n215#1:4710,6\n215#1:4716\n173#1:4601\n173#1:4605\n179#1:4626\n179#1:4630\n189#1:4651\n189#1:4655\n195#1:4676\n195#1:4680\n215#1:4701\n215#1:4705\n*E\n"})
final class Pending {
    private int groupIndex;

    @NotNull
    private final MutableIntObjectMap<GroupInfo> groupInfos;

    @NotNull
    private final List<KeyInfo> keyInfos;

    /* JADX INFO: renamed from: keyMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy keyMap;
    private final int startIndex;

    @NotNull
    private final List<KeyInfo> usedKeys;

    public Pending(@NotNull List<KeyInfo> list, int i) {
        this.keyInfos = list;
        this.startIndex = i;
        if (!(i >= 0)) {
            PreconditionsKt.throwIllegalArgumentException("Invalid start index");
        }
        this.usedKeys = new ArrayList();
        MutableIntObjectMap<GroupInfo> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        int size = list.size();
        int nodes = 0;
        for (int i2 = 0; i2 < size; i2++) {
            KeyInfo keyInfo = this.keyInfos.get(i2);
            mutableIntObjectMap.set(keyInfo.getLocation(), new GroupInfo(i2, nodes, keyInfo.getNodes()));
            nodes += keyInfo.getNodes();
        }
        this.groupInfos = mutableIntObjectMap;
        this.keyMap = LazyKt.lazy(new Function0<MutableScatterMultiMap<Object, KeyInfo>>() { // from class: androidx.compose.runtime.Pending$keyMap$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ MutableScatterMultiMap<Object, KeyInfo> invoke() {
                return MutableScatterMultiMap.m17998boximpl(m18008invokeSAeQiB4());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-SAeQiB4, reason: not valid java name */
            public final MutableScatterMap m18008invokeSAeQiB4() {
                MutableScatterMap mutableScatterMapMultiMap = ComposerKt.multiMap(this.this$0.getKeyInfos().size());
                Pending pending = this.this$0;
                int size2 = pending.getKeyInfos().size();
                for (int i4 = 0; i4 < size2; i4++) {
                    KeyInfo keyInfo2 = pending.getKeyInfos().get(i4);
                    MutableScatterMultiMap.m18004putimpl(mutableScatterMapMultiMap, ComposerKt.getJoinedKey(keyInfo2), keyInfo2);
                }
                return mutableScatterMapMultiMap;
            }
        });
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    @NotNull
    public final List<KeyInfo> getKeyInfos() {
        return this.keyInfos;
    }

    @NotNull
    /* JADX INFO: renamed from: getKeyMap-SAeQiB4, reason: not valid java name */
    public final MutableScatterMap m18007getKeyMapSAeQiB4() {
        return ((MutableScatterMultiMap) this.keyMap.getValue()).getMap();
    }

    @Nullable
    public final KeyInfo getNext(int key, @Nullable Object dataKey) {
        return (KeyInfo) MutableScatterMultiMap.m18003popimpl(m18007getKeyMapSAeQiB4(), dataKey != null ? new JoinedKey(Integer.valueOf(key), dataKey) : Integer.valueOf(key));
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    @NotNull
    public final List<KeyInfo> getUsed() {
        return this.usedKeys;
    }

    public final int nodePositionOf(@NotNull KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(keyInfo.getLocation());
        if (groupInfo != null) {
            return groupInfo.getNodeIndex();
        }
        return -1;
    }

    public final boolean recordUsed(@NotNull KeyInfo keyInfo) {
        return this.usedKeys.add(keyInfo);
    }

    public final void registerInsert(@NotNull KeyInfo keyInfo, int insertIndex) {
        this.groupInfos.set(keyInfo.getLocation(), new GroupInfo(-1, insertIndex, 0));
    }

    public final void registerMoveNode(int from, int to, int count) {
        char c;
        long j;
        char c2;
        long j2;
        char c4 = 7;
        long j3 = -9187201950435737472L;
        if (from > to) {
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j5 = jArr[i];
                if ((((~j5) << c4) & j5 & j3) != j3) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i4 = 0;
                    while (i4 < i2) {
                        if ((j5 & 255) < 128) {
                            c2 = c4;
                            GroupInfo groupInfo = (GroupInfo) objArr[(i << 3) + i4];
                            j2 = j3;
                            int nodeIndex = groupInfo.getNodeIndex();
                            if (from <= nodeIndex && nodeIndex < from + count) {
                                groupInfo.setNodeIndex((nodeIndex - from) + to);
                            } else if (to <= nodeIndex && nodeIndex < from) {
                                groupInfo.setNodeIndex(nodeIndex + count);
                            }
                        } else {
                            c2 = c4;
                            j2 = j3;
                        }
                        j5 >>= 8;
                        i4++;
                        c4 = c2;
                        j3 = j2;
                    }
                    c = c4;
                    j = j3;
                    if (i2 != 8) {
                        return;
                    }
                } else {
                    c = c4;
                    j = j3;
                }
                if (i == length) {
                    return;
                }
                i++;
                c4 = c;
                j3 = j;
            }
        } else {
            if (to <= from) {
                return;
            }
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap2 = this.groupInfos;
            Object[] objArr2 = mutableIntObjectMap2.values;
            long[] jArr2 = mutableIntObjectMap2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                long j6 = jArr2[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length2)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((j6 & 255) < 128) {
                            GroupInfo groupInfo2 = (GroupInfo) objArr2[(i5 << 3) + i7];
                            int nodeIndex2 = groupInfo2.getNodeIndex();
                            if (from <= nodeIndex2 && nodeIndex2 < from + count) {
                                groupInfo2.setNodeIndex((nodeIndex2 - from) + to);
                            } else if (from + 1 <= nodeIndex2 && nodeIndex2 < to) {
                                groupInfo2.setNodeIndex(nodeIndex2 - count);
                            }
                        }
                        j6 >>= 8;
                    }
                    if (i6 != 8) {
                        return;
                    }
                }
                if (i5 == length2) {
                    return;
                } else {
                    i5++;
                }
            }
        }
    }

    public final void registerMoveSlot(int from, int to) {
        char c;
        long j;
        char c2;
        long j2;
        char c4 = 7;
        long j3 = -9187201950435737472L;
        if (from > to) {
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j5 = jArr[i];
                if ((((~j5) << c4) & j5 & j3) != j3) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i4 = 0;
                    while (i4 < i2) {
                        if ((j5 & 255) < 128) {
                            c2 = c4;
                            GroupInfo groupInfo = (GroupInfo) objArr[(i << 3) + i4];
                            j2 = j3;
                            int slotIndex = groupInfo.getSlotIndex();
                            if (slotIndex == from) {
                                groupInfo.setSlotIndex(to);
                            } else if (to <= slotIndex && slotIndex < from) {
                                groupInfo.setSlotIndex(slotIndex + 1);
                            }
                        } else {
                            c2 = c4;
                            j2 = j3;
                        }
                        j5 >>= 8;
                        i4++;
                        c4 = c2;
                        j3 = j2;
                    }
                    c = c4;
                    j = j3;
                    if (i2 != 8) {
                        return;
                    }
                } else {
                    c = c4;
                    j = j3;
                }
                if (i == length) {
                    return;
                }
                i++;
                c4 = c;
                j3 = j;
            }
        } else {
            if (to <= from) {
                return;
            }
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap2 = this.groupInfos;
            Object[] objArr2 = mutableIntObjectMap2.values;
            long[] jArr2 = mutableIntObjectMap2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                long j6 = jArr2[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length2)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((j6 & 255) < 128) {
                            GroupInfo groupInfo2 = (GroupInfo) objArr2[(i5 << 3) + i7];
                            int slotIndex2 = groupInfo2.getSlotIndex();
                            if (slotIndex2 == from) {
                                groupInfo2.setSlotIndex(to);
                            } else if (from + 1 <= slotIndex2 && slotIndex2 < to) {
                                groupInfo2.setSlotIndex(slotIndex2 - 1);
                            }
                        }
                        j6 >>= 8;
                    }
                    if (i6 != 8) {
                        return;
                    }
                }
                if (i5 == length2) {
                    return;
                } else {
                    i5++;
                }
            }
        }
    }

    public final void setGroupIndex(int i) {
        this.groupIndex = i;
    }

    public final int slotPositionOf(@NotNull KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(keyInfo.getLocation());
        if (groupInfo != null) {
            return groupInfo.getSlotIndex();
        }
        return -1;
    }

    public final boolean updateNodeCount(int group, int newCount) {
        int nodeIndex;
        GroupInfo groupInfo = this.groupInfos.get(group);
        if (groupInfo == null) {
            return false;
        }
        int nodeIndex2 = groupInfo.getNodeIndex();
        int nodeCount = newCount - groupInfo.getNodeCount();
        groupInfo.setNodeCount(newCount);
        if (nodeCount == 0) {
            return true;
        }
        MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        GroupInfo groupInfo2 = (GroupInfo) objArr[(i << 3) + i4];
                        if (groupInfo2.getNodeIndex() >= nodeIndex2 && !Intrinsics.areEqual(groupInfo2, groupInfo) && (nodeIndex = groupInfo2.getNodeIndex() + nodeCount) >= 0) {
                            groupInfo2.setNodeIndex(nodeIndex);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final int updatedNodeCountOf(@NotNull KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(keyInfo.getLocation());
        return groupInfo != null ? groupInfo.getNodeCount() : keyInfo.getNodes();
    }
}
