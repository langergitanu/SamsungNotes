package androidx.compose.runtime;

import androidx.collection.AbstractC0622a;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u001cJ\u000e\u0010<\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0007J=\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u0001`/H\u0000¢\u0006\u0002\bAJ\u008f\u0001\u0010=\u001a\u00020>2\u0006\u00108\u001a\u00020B2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$2\u0006\u0010*\u001a\u00020\u001c2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0000¢\u0006\u0004\bA\u0010CJ\u0006\u0010D\u001a\u00020>J\u0006\u0010E\u001a\u00020>J\u0006\u0010F\u001a\u00020!J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001c0HH\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010\u00032\u0006\u0010J\u001a\u00020%H\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u001cH\u0002J\u0016\u0010N\u001a\u00020!2\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001c0HH\u0002J\u001d\u0010Q\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010H2\u0006\u0010R\u001a\u00020\u001cH\u0000¢\u0006\u0002\bSJ\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00030UH\u0096\u0002J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001c0HH\u0002J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001c0HH\u0002J\u0006\u0010X\u001a\u00020@J\u0006\u0010Y\u001a\u00020BJ\u000e\u0010Z\u001a\u00020!2\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001c0HH\u0002J7\u0010\\\u001a\u0002H]\"\u0004\b\u0000\u0010]2!\u0010^\u001a\u001d\u0012\u0013\u0012\u00110@¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(?\u0012\u0004\u0012\u0002H]0_H\u0086\b¢\u0006\u0002\u0010bJ\u0087\u0001\u0010c\u001a\u00020>2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$2\u0006\u0010*\u001a\u00020\u001c2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0000¢\u0006\u0004\bd\u0010eJ\u001f\u0010f\u001a\u0004\u0018\u00010%2\u0006\u0010M\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020\u001cH\u0000¢\u0006\u0002\bhJ\u001d\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0H2\u0006\u0010M\u001a\u00020\u001cH\u0000¢\u0006\u0002\bjJ\u0010\u0010k\u001a\u0004\u0018\u00010.2\u0006\u0010M\u001a\u00020\u001cJ\u0006\u0010l\u001a\u00020mJ\u0012\u0010n\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\u001cH\u0002J\u0006\u0010o\u001a\u00020>J7\u0010p\u001a\u0002H]\"\u0004\b\u0000\u0010]2!\u0010^\u001a\u001d\u0012\u0013\u0012\u00110B¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H]0_H\u0086\b¢\u0006\u0002\u0010bJ \u0010q\u001a\u00020\u001c*\u00060rj\u0002`s2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010t\u001a\u00020\u001cH\u0002R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\"R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$@BX\u0086\u000e¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u001e\u0010*\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR:\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u0001`/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u00107R\u001e\u00108\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"¨\u0006u"}, m13886d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime_release", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime_release", "(Landroidx/collection/MutableIntObjectMap;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "getSourceInformationMap$runtime_release", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime_release", "(Ljava/util/HashMap;)V", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchor", "index", "anchorIndex", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "collectCalledByInformation", "collectSourceInformation", "containsMark", "dataIndexes", "", "find", "identityToFind", "findEffectiveRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "group", "groupContainsAnchor", "groupIndex", "groupSizes", "invalidateGroupsWithKey", "target", "invalidateGroupsWithKey$runtime_release", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", "read", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "slot", "slotIndex", "slot$runtime_release", "slotsOf", "slotsOf$runtime_release", "sourceInformationOf", "toDebugString", "", "tryAnchor", "verifyWellFormed", "write", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSlotTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 5 SlotTable.kt\nandroidx/compose/runtime/SlotTableKt\n+ 6 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 7 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,4179:1\n159#1,8:4265\n175#1,5:4273\n181#1,3:4285\n1#2:4180\n1#2:4284\n4553#3,7:4181\n4553#3,7:4188\n4553#3,7:4195\n4553#3,7:4215\n4553#3,7:4222\n4553#3,7:4236\n4553#3,7:4243\n4553#3,7:4250\n33#4,7:4202\n33#4,7:4229\n33#4,7:4258\n50#4,7:4288\n50#4,7:4295\n33#4,7:4306\n33#4,7:4313\n33#4,7:4321\n33#4,7:4328\n50#4,7:4335\n50#4,7:4342\n50#4,7:4349\n50#4,7:4356\n50#4,7:4363\n50#4,7:4370\n50#4,7:4377\n50#4,7:4384\n50#4,7:4391\n50#4,7:4398\n50#4,7:4405\n33#4,7:4416\n33#4,7:4423\n4046#5,6:4209\n89#6:4257\n33#7,6:4278\n33#7,4:4302\n38#7:4320\n33#7,4:4412\n38#7:4430\n*S KotlinDebug\n*F\n+ 1 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n*L\n358#1:4265,8\n395#1:4273,5\n395#1:4285,3\n395#1:4284\n204#1:4181,7\n205#1:4188,7\n221#1:4195,7\n234#1:4215,7\n245#1:4222,7\n265#1:4236,7\n266#1:4243,7\n278#1:4250,7\n222#1:4202,7\n246#1:4229,7\n307#1:4258,7\n514#1:4288,7\n521#1:4295,7\n530#1:4306,7\n533#1:4313,7\n556#1:4321,7\n559#1:4328,7\n452#1:4335,7\n457#1:4342,7\n460#1:4349,7\n466#1:4356,7\n469#1:4363,7\n473#1:4370,7\n479#1:4377,7\n483#1:4384,7\n492#1:4391,7\n497#1:4398,7\n502#1:4405,7\n542#1:4416,7\n545#1:4423,7\n225#1:4209,6\n281#1:4257\n397#1:4278,6\n528#1:4302,4\n528#1:4320\n539#1:4412,4\n539#1:4430\n*E\n"})
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    public static final int $stable = 8;

    @Nullable
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int groupsSize;
    private int readers;
    private int slotsSize;

    @Nullable
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private int version;
    private boolean writer;

    @NotNull
    private int[] groups = new int[0];

    @NotNull
    private Object[] slots = new Object[0];

    @NotNull
    private ArrayList<Anchor> anchors = new ArrayList<>();

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final int emitGroup(StringBuilder sb, int i, int i2) {
        String sourceInformation;
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append(' ');
        }
        AbstractC1974b.m1330w(i, "Group(", ")", sb);
        GroupSourceInformation groupSourceInformationSourceInformationOf = sourceInformationOf(i);
        if (groupSourceInformationSourceInformationOf != null && (sourceInformation = groupSourceInformationSourceInformationOf.getSourceInformation()) != null && (StringsKt.m14145S(sourceInformation, "C(") || StringsKt.m14145S(sourceInformation, "CC("))) {
            int iM14129C = StringsKt.m14129C("(", 0, 6, sourceInformation) + 1;
            int iM14128B = StringsKt.m14128B(sourceInformation, PropertyUtils.MAPPED_DELIM2, 0, 6);
            sb.append(" ");
            String strSubstring = sourceInformation.substring(iM14129C, iM14128B);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            sb.append("()");
        }
        sb.append(" key=");
        sb.append(SlotTableKt.key(this.groups, i));
        int iGroupSize = SlotTableKt.groupSize(this.groups, i);
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, i));
        sb.append(", size=");
        sb.append(iGroupSize);
        if (SlotTableKt.hasMark(this.groups, i)) {
            sb.append(", mark");
        }
        if (SlotTableKt.containsMark(this.groups, i)) {
            sb.append(", contains mark");
        }
        int iEmitGroup$dataIndex = emitGroup$dataIndex(this, i);
        int iEmitGroup = i + 1;
        int iEmitGroup$dataIndex2 = emitGroup$dataIndex(this, iEmitGroup);
        if (iEmitGroup$dataIndex < 0 || iEmitGroup$dataIndex > iEmitGroup$dataIndex2 || iEmitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + iEmitGroup$dataIndex + '-' + iEmitGroup$dataIndex2 + '*');
        } else {
            if (SlotTableKt.hasObjectKey(this.groups, i)) {
                sb.append(" objectKey=" + SlotTableKt.summarize(String.valueOf(this.slots[SlotTableKt.objectKeyIndex(this.groups, i)]), 10));
            }
            if (SlotTableKt.isNode(this.groups, i)) {
                sb.append(" node=" + SlotTableKt.summarize(String.valueOf(this.slots[SlotTableKt.nodeIndex(this.groups, i)]), 10));
            }
            if (SlotTableKt.hasAux(this.groups, i)) {
                sb.append(" aux=" + SlotTableKt.summarize(String.valueOf(this.slots[SlotTableKt.auxIndex(this.groups, i)]), 10));
            }
            int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i);
            if (iSlotAnchor < iEmitGroup$dataIndex2) {
                AbstractC1974b.m1330w(iSlotAnchor, ", slots=[", ": ", sb);
                for (int i5 = iSlotAnchor; i5 < iEmitGroup$dataIndex2; i5++) {
                    if (i5 != iSlotAnchor) {
                        sb.append(SQLKeyword.COMMA);
                    }
                    sb.append(SlotTableKt.summarize(String.valueOf(this.slots[i5]), 10));
                }
                sb.append("]");
            }
        }
        sb.append('\n');
        int i6 = i + iGroupSize;
        while (iEmitGroup < i6) {
            iEmitGroup += emitGroup(sb, iEmitGroup, i2 + 1);
        }
        return iGroupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        return i >= slotTable.groupsSize ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int group) {
        int iParentAnchor = group;
        while (iParentAnchor > 0) {
            for (Object obj : new DataIterator(this, iParentAnchor)) {
                if (obj instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                    if (recomposeScopeImpl.getUsed() && iParentAnchor != group) {
                        return recomposeScopeImpl;
                    }
                    recomposeScopeImpl.setForcedRecompose(true);
                }
            }
            iParentAnchor = SlotTableKt.parentAnchor(this.groups, iParentAnchor);
        }
        return null;
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    private static final void invalidateGroupsWithKey$lambda$20$scanGroup(SlotReader slotReader, MutableIntSet mutableIntSet, List<Anchor> list, Ref.BooleanRef booleanRef, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope;
        int groupKey = slotReader.getGroupKey();
        if (!mutableIntSet.contains(groupKey)) {
            slotReader.startGroup();
            while (!slotReader.isGroupEnd()) {
                invalidateGroupsWithKey$lambda$20$scanGroup(slotReader, mutableIntSet, list, booleanRef, slotTable, list2);
            }
            slotReader.endGroup();
            return;
        }
        if (groupKey != -3) {
            list.add(SlotReader.anchor$default(slotReader, 0, 1, null));
        }
        if (booleanRef.element) {
            RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope2 = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
            if (recomposeScopeImplFindEffectiveRecomposeScope2 != null) {
                list2.add(recomposeScopeImplFindEffectiveRecomposeScope2);
                Anchor anchor = recomposeScopeImplFindEffectiveRecomposeScope2.getAnchor();
                if (anchor != null && anchor.getLocation() == slotReader.getCurrentGroup() && (recomposeScopeImplFindEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getParent())) != null) {
                    list2.add(recomposeScopeImplFindEffectiveRecomposeScope);
                }
            } else {
                booleanRef.element = false;
                list2.clear();
            }
        }
        slotReader.skipGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    private final Anchor tryAnchor(int index) {
        int i;
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
        }
        if (index < 0 || index >= (i = this.groupsSize)) {
            return null;
        }
        return SlotTableKt.find(this.anchors, index, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static final int verifyWellFormed$validateGroup(Ref.IntRef intRef, SlotTable slotTable, int i, int i2) {
        int i4 = intRef.element;
        int i5 = i4 + 1;
        intRef.element = i5;
        int iParentAnchor = SlotTableKt.parentAnchor(slotTable.groups, i4);
        if ((iParentAnchor == i) == false) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i4, i, "Invalid parent index detected at ", ", expected parent index to be ", " found ");
            sbM1173s.append(iParentAnchor);
            PreconditionsKt.throwIllegalStateException(sbM1173s.toString());
        }
        int iGroupSize = SlotTableKt.groupSize(slotTable.groups, i4) + i4;
        if ((iGroupSize <= slotTable.groupsSize) == false) {
            PreconditionsKt.throwIllegalStateException("A group extends past the end of the table at " + i4);
        }
        if ((iGroupSize <= i2) == false) {
            PreconditionsKt.throwIllegalStateException("A group extends past its parent group at " + i4);
        }
        int iDataAnchor = SlotTableKt.dataAnchor(slotTable.groups, i4);
        int iDataAnchor2 = i4 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i5);
        if ((iDataAnchor2 <= slotTable.slots.length) == false) {
            PreconditionsKt.throwIllegalStateException("Slots for " + i4 + " extend past the end of the slot table");
        }
        if ((iDataAnchor <= iDataAnchor2) == false) {
            PreconditionsKt.throwIllegalStateException("Invalid data anchor at " + i4);
        }
        if ((SlotTableKt.slotAnchor(slotTable.groups, i4) <= iDataAnchor2) == false) {
            PreconditionsKt.throwIllegalStateException("Slots start out of range at " + i4);
        }
        if ((iDataAnchor2 - iDataAnchor >= (SlotTableKt.hasAux(slotTable.groups, i4) ? 1 : 0) + ((SlotTableKt.hasObjectKey(slotTable.groups, i4) ? 1 : 0) + (SlotTableKt.isNode(slotTable.groups, i4) ? 1 : 0))) == false) {
            PreconditionsKt.throwIllegalStateException("Not enough slots added for group " + i4);
        }
        boolean zIsNode = SlotTableKt.isNode(slotTable.groups, i4);
        if (((zIsNode && slotTable.slots[SlotTableKt.nodeIndex(slotTable.groups, i4)] == null) ? false : true) == false) {
            PreconditionsKt.throwIllegalStateException("No node recorded for a node group at " + i4);
        }
        int iVerifyWellFormed$validateGroup = 0;
        while (intRef.element < iGroupSize) {
            iVerifyWellFormed$validateGroup += verifyWellFormed$validateGroup(intRef, slotTable, i4, iGroupSize);
        }
        int iNodeCount = SlotTableKt.nodeCount(slotTable.groups, i4);
        int iGroupSize2 = SlotTableKt.groupSize(slotTable.groups, i4);
        if ((iNodeCount == iVerifyWellFormed$validateGroup) == false) {
            StringBuilder sbM1173s2 = AbstractC0622a.m1173s(i4, iNodeCount, "Incorrect node count detected at ", ", expected ", ", received ");
            sbM1173s2.append(iVerifyWellFormed$validateGroup);
            PreconditionsKt.throwIllegalStateException(sbM1173s2.toString());
        }
        int i6 = intRef.element - i4;
        if ((iGroupSize2 == i6) == false) {
            StringBuilder sbM1173s3 = AbstractC0622a.m1173s(i4, iGroupSize2, "Incorrect slot count detected at ", ", expected ", ", received ");
            sbM1173s3.append(i6);
            PreconditionsKt.throwIllegalStateException(sbM1173s3.toString());
        }
        if (SlotTableKt.containsAnyMark(slotTable.groups, i4)) {
            if (!(i4 <= 0 || SlotTableKt.containsMark(slotTable.groups, i))) {
                PreconditionsKt.throwIllegalStateException("Expected group " + i + " to record it contains a mark because " + i4 + " does");
            }
        }
        if (zIsNode) {
            return 1;
        }
        return iVerifyWellFormed$validateGroup;
    }

    private static final void verifyWellFormed$verifySourceGroup(SlotTable slotTable, GroupSourceInformation groupSourceInformation) {
        ArrayList<Object> groups = groupSourceInformation.getGroups();
        if (groups != null) {
            int size = groups.size();
            for (int i = 0; i < size; i++) {
                Object obj = groups.get(i);
                if (obj instanceof Anchor) {
                    Anchor anchor = (Anchor) obj;
                    if (!anchor.getValid()) {
                        PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                    }
                    if (!slotTable.ownsAnchor(anchor)) {
                        PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                    }
                } else if (obj instanceof GroupSourceInformation) {
                    verifyWellFormed$verifySourceGroup(slotTable, (GroupSourceInformation) obj);
                }
            }
        }
    }

    @NotNull
    public final Anchor anchor(int index) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to create an anchor location instead");
        }
        boolean z = false;
        if (index >= 0 && index < this.groupsSize) {
            z = true;
        }
        if (!z) {
            PreconditionsKt.throwIllegalArgumentException("Parameter index is out of range");
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, index, this.groupsSize);
        if (iSearch >= 0) {
            return arrayList.get(iSearch);
        }
        Anchor anchor = new Anchor(index);
        arrayList.add(-(iSearch + 1), anchor);
        return anchor;
    }

    public final int anchorIndex(@NotNull Anchor anchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }
        if (!anchor.getValid()) {
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }
        return anchor.getLocation();
    }

    public final void close$runtime_release(@NotNull SlotReader reader, @Nullable HashMap<Anchor, GroupSourceInformation> sourceInformationMap) {
        if (!(reader.getTable() == this && this.readers > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }
        this.readers--;
        if (sourceInformationMap != null) {
            synchronized (this) {
                try {
                    HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
                    if (map != null) {
                        map.putAll(sourceInformationMap);
                    } else {
                        this.sourceInformationMap = sourceInformationMap;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void collectCalledByInformation() {
        this.calledByMap = new MutableIntObjectMap<>(0, 1, null);
    }

    public final void collectSourceInformation() {
        this.sourceInformationMap = new HashMap<>();
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && SlotTableKt.containsMark(this.groups, 0);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    @Nullable
    public CompositionGroup find(@NotNull Object identityToFind) {
        return new SlotTableGroup(this, 0, 0, 4, null).find(identityToFind);
    }

    @NotNull
    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    @Nullable
    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime_release() {
        return this.calledByMap;
    }

    @NotNull
    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    @NotNull
    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    @Nullable
    public final HashMap<Anchor, GroupSourceInformation> getSourceInformationMap$runtime_release() {
        return this.sourceInformationMap;
    }

    /* JADX INFO: renamed from: getVersion$runtime_release, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: getWriter$runtime_release, reason: from getter */
    public final boolean getWriter() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int groupIndex, @NotNull Anchor anchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Writer is active");
        }
        if (!(groupIndex >= 0 && groupIndex < this.groupsSize)) {
            ComposerKt.composeImmediateRuntimeError("Invalid group index");
        }
        if (ownsAnchor(anchor)) {
            int iGroupSize = SlotTableKt.groupSize(this.groups, groupIndex) + groupIndex;
            int location$runtime_release = anchor.getLocation();
            if (groupIndex <= location$runtime_release && location$runtime_release < iGroupSize) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int target) {
        MutableIntSet mutableIntSet;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
        mutableIntSet2.add(target);
        mutableIntSet2.add(-3);
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        if (mutableIntObjectMap != null && (mutableIntSet = mutableIntObjectMap.get(target)) != null) {
            mutableIntSet2.addAll(mutableIntSet);
        }
        SlotReader slotReaderOpenReader = openReader();
        try {
            invalidateGroupsWithKey$lambda$20$scanGroup(slotReaderOpenReader, mutableIntSet2, arrayList, booleanRef, this, arrayList2);
            Unit unit = Unit.INSTANCE;
            slotReaderOpenReader.close();
            SlotWriter slotWriterOpenWriter = openWriter();
            try {
                slotWriterOpenWriter.startGroup();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Anchor anchor = (Anchor) arrayList.get(i);
                    if (anchor.toIndexFor(slotWriterOpenWriter) >= slotWriterOpenWriter.getCurrentGroup()) {
                        slotWriterOpenWriter.seek(anchor);
                        slotWriterOpenWriter.bashCurrentGroup();
                    }
                }
                slotWriterOpenWriter.skipToGroupEnd();
                slotWriterOpenWriter.endGroup();
                slotWriterOpenWriter.close(true);
                if (booleanRef.element) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        } catch (Throwable th2) {
            slotReaderOpenReader.close();
            throw th2;
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    @NotNull
    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.readers++;
        return new SlotReader(this);
    }

    @NotNull
    public final SlotWriter openWriter() {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (!(this.readers <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(@NotNull Anchor anchor) {
        int iSearch;
        return anchor.getValid() && (iSearch = SlotTableKt.search(this.anchors, anchor.getLocation(), this.groupsSize)) >= 0 && Intrinsics.areEqual(this.anchors.get(iSearch), anchor);
    }

    public final <T> T read(@NotNull Function1<? super SlotReader, ? extends T> block) {
        SlotReader slotReaderOpenReader = openReader();
        try {
            return block.invoke(slotReaderOpenReader);
        } finally {
            InlineMarker.finallyStart(1);
            slotReaderOpenReader.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final void setAnchors$runtime_release(@NotNull ArrayList<Anchor> arrayList) {
        this.anchors = arrayList;
    }

    public final void setCalledByMap$runtime_release(@Nullable MutableIntObjectMap<MutableIntSet> mutableIntObjectMap) {
        this.calledByMap = mutableIntObjectMap;
    }

    public final void setSourceInformationMap$runtime_release(@Nullable HashMap<Anchor, GroupSourceInformation> map) {
        this.sourceInformationMap = map;
    }

    public final void setTo$runtime_release(@NotNull int[] groups, int groupsSize, @NotNull Object[] slots, int slotsSize, @NotNull ArrayList<Anchor> anchors, @Nullable HashMap<Anchor, GroupSourceInformation> sourceInformationMap, @Nullable MutableIntObjectMap<MutableIntSet> calledByMap) {
        this.groups = groups;
        this.groupsSize = groupsSize;
        this.slots = slots;
        this.slotsSize = slotsSize;
        this.anchors = anchors;
        this.sourceInformationMap = sourceInformationMap;
        this.calledByMap = calledByMap;
    }

    public final void setVersion$runtime_release(int i) {
        this.version = i;
    }

    @Nullable
    public final Object slot$runtime_release(int group, int slotIndex) {
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, group);
        int i = group + 1;
        return (slotIndex < 0 || slotIndex >= (i < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i) : this.slots.length) - iSlotAnchor) ? Composer.INSTANCE.getEmpty() : this.slots[iSlotAnchor + slotIndex];
    }

    @NotNull
    public final List<Object> slotsOf$runtime_release(int group) {
        int iDataAnchor = SlotTableKt.dataAnchor(this.groups, group);
        int i = group + 1;
        return ArraysKt.toList(this.slots).subList(iDataAnchor, i < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i) : this.slots.length);
    }

    @Nullable
    public final GroupSourceInformation sourceInformationOf(int group) {
        Anchor anchorTryAnchor;
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map == null || (anchorTryAnchor = tryAnchor(group)) == null) {
            return null;
        }
        return map.get(anchorTryAnchor);
    }

    @NotNull
    public final String toDebugString() {
        if (this.writer) {
            return toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        sb.append('\n');
        int i = this.groupsSize;
        if (i > 0) {
            int iEmitGroup = 0;
            while (iEmitGroup < i) {
                iEmitGroup += emitGroup(sb, iEmitGroup, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void verifyWellFormed() {
        int i;
        int i2;
        Ref.IntRef intRef = new Ref.IntRef();
        int i4 = -1;
        if (this.groupsSize > 0) {
            while (true) {
                i = intRef.element;
                i2 = this.groupsSize;
                if (i >= i2) {
                    break;
                } else {
                    verifyWellFormed$validateGroup(intRef, this, -1, SlotTableKt.groupSize(this.groups, i) + i);
                }
            }
            if (!(i == i2)) {
                PreconditionsKt.throwIllegalStateException("Incomplete group at root " + intRef.element + " expected to be " + this.groupsSize);
            }
        }
        int length = this.slots.length;
        for (int i5 = this.slotsSize; i5 < length; i5++) {
            if (!(this.slots[i5] == null)) {
                PreconditionsKt.throwIllegalStateException("Non null value in the slot gap at index " + i5);
            }
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            int indexFor = arrayList.get(i6).toIndexFor(this);
            if (!(indexFor >= 0 && indexFor <= this.groupsSize)) {
                PreconditionsKt.throwIllegalArgumentException("Invalid anchor, location out of bound");
            }
            if (!(i4 < indexFor)) {
                PreconditionsKt.throwIllegalArgumentException("Anchor is out of order");
            }
            i6++;
            i4 = indexFor;
        }
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map != null) {
            for (Map.Entry<Anchor, GroupSourceInformation> entry : map.entrySet()) {
                Anchor key = entry.getKey();
                GroupSourceInformation value = entry.getValue();
                if (!key.getValid()) {
                    PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                }
                if (!ownsAnchor(key)) {
                    PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                }
                verifyWellFormed$verifySourceGroup(this, value);
            }
        }
    }

    public final <T> T write(@NotNull Function1<? super SlotWriter, ? extends T> block) {
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            T tInvoke = block.invoke(slotWriterOpenWriter);
            InlineMarker.finallyStart(1);
            slotWriterOpenWriter.close(true);
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            slotWriterOpenWriter.close(false);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public final void close$runtime_release(@NotNull SlotWriter writer, @NotNull int[] groups, int groupsSize, @NotNull Object[] slots, int slotsSize, @NotNull ArrayList<Anchor> anchors, @Nullable HashMap<Anchor, GroupSourceInformation> sourceInformationMap, @Nullable MutableIntObjectMap<MutableIntSet> calledByMap) {
        if (!(writer.getTable() == this && this.writer)) {
            PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
        }
        this.writer = false;
        setTo$runtime_release(groups, groupsSize, slots, slotsSize, anchors, sourceInformationMap, calledByMap);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    @NotNull
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }
}
