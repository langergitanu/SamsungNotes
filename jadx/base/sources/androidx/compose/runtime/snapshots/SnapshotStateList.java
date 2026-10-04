package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0001SB\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\b\u0010&\u001a\u00020 H\u0016J3\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\u001d2\u001e\u0010)\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+0*H\u0082\bJ\u0016\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001fJ\u0016\u0010-\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010.\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0017H\u0096\u0002¢\u0006\u0002\u0010/J\u0015\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u001dH\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0096\u0002J\u0015\u00105\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000072\u0006\u0010!\u001a\u00020\u0017H\u0016J.\u00108\u001a\u0002H9\"\u0004\b\u0001\u001092\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u0002H90*H\u0082\b¢\u0006\u0002\u0010:J\"\u0010;\u001a\u00020\u001d2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u001d0*H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\rH\u0016J\u0015\u0010>\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u0016\u0010?\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0015\u0010@\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010/J\u0016\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017J\u0016\u0010D\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J+\u0010E\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u0017H\u0000¢\u0006\u0002\bHJ\u001e\u0010I\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017H\u0016J\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\bJ\b\u0010M\u001a\u00020NH\u0016J3\u0010O\u001a\u00020 2\b\b\u0002\u0010(\u001a\u00020\u001d2\u001e\u0010)\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+0*H\u0082\bJ3\u0010P\u001a\u0002H9\"\u0004\b\u0001\u001092\u001d\u0010)\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u0002H90*¢\u0006\u0002\bQH\u0082\b¢\u0006\u0002\u0010:J3\u0010R\u001a\u0002H9\"\u0004\b\u0001\u001092\u001d\u0010)\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u0002H90*¢\u0006\u0002\bQH\u0082\b¢\u0006\u0002\u0010:R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8AX\u0080\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006T"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "", "getSize", "()I", "structure", "getStructure$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "structural", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "toList", "toString", "", Constants.ARG_UPDATE, "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Stable
@SourceDebugExtension({"SMAP\nSnapshotStateList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SnapshotStateList\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 4 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,497:1\n171#1:498\n210#1,10:508\n220#1:519\n171#1:520\n221#1,9:522\n167#1:531\n230#1,7:537\n240#1,6:547\n203#1,17:553\n220#1:571\n171#1:572\n221#1,9:574\n167#1:583\n230#1,7:589\n240#1,6:599\n208#1:605\n210#1,10:606\n220#1:617\n171#1:618\n221#1,9:620\n167#1:629\n230#1,7:635\n240#1,6:645\n167#1:651\n210#1,10:662\n220#1:673\n171#1:674\n221#1,9:676\n167#1:685\n230#1,7:691\n240#1,6:701\n210#1,10:707\n220#1:718\n171#1:719\n221#1,9:721\n167#1:730\n230#1,7:736\n240#1,6:746\n203#1,17:753\n220#1:771\n171#1:772\n221#1,9:774\n167#1:783\n230#1,7:789\n240#1,6:799\n208#1:805\n207#1,13:806\n220#1:820\n171#1:821\n221#1,9:823\n167#1:832\n230#1,7:838\n240#1,6:848\n208#1:854\n176#1,5:855\n181#1:861\n171#1:862\n182#1,7:864\n167#1:871\n189#1,7:877\n198#1,3:887\n176#1,5:890\n181#1:896\n171#1:897\n182#1,7:899\n167#1:906\n189#1,7:912\n198#1,3:922\n171#1:925\n176#1,5:937\n181#1:943\n171#1:944\n182#1,7:946\n167#1:953\n189#1,7:959\n198#1,3:969\n171#1:973\n167#1:975\n214#1,6:986\n220#1:993\n171#1:994\n221#1,9:996\n167#1:1005\n230#1,7:1011\n240#1,6:1021\n214#1,7:1027\n171#1:1034\n221#1,9:1036\n167#1:1045\n230#1,7:1051\n240#1,6:1061\n171#1:1068\n167#1:1070\n171#1:1082\n167#1:1084\n2420#2:499\n2420#2:507\n2420#2:521\n2313#2,2:532\n1843#2:534\n2315#2,2:535\n2317#2,3:544\n2420#2:573\n2313#2,2:584\n1843#2:586\n2315#2,2:587\n2317#2,3:596\n2420#2:619\n2313#2,2:630\n1843#2:632\n2315#2,2:633\n2317#2,3:642\n2313#2,2:652\n1843#2:654\n2315#2,2:656\n2317#2,3:659\n2420#2:675\n2313#2,2:686\n1843#2:688\n2315#2,2:689\n2317#2,3:698\n2420#2:720\n2313#2,2:731\n1843#2:733\n2315#2,2:734\n2317#2,3:743\n2420#2:773\n2313#2,2:784\n1843#2:786\n2315#2,2:787\n2317#2,3:796\n2420#2:822\n2313#2,2:833\n1843#2:835\n2315#2,2:836\n2317#2,3:845\n2420#2:863\n2313#2,2:872\n1843#2:874\n2315#2,2:875\n2317#2,3:884\n2420#2:898\n2313#2,2:907\n1843#2:909\n2315#2,2:910\n2317#2,3:919\n2420#2:926\n2313#2,2:927\n1843#2:929\n2315#2,5:931\n2420#2:936\n2420#2:945\n2313#2,2:954\n1843#2:956\n2315#2,2:957\n2317#2,3:966\n2420#2:974\n2313#2,2:976\n1843#2:978\n2315#2,2:980\n2317#2,3:983\n2420#2:995\n2313#2,2:1006\n1843#2:1008\n2315#2,2:1009\n2317#2,3:1018\n2420#2:1035\n2313#2,2:1046\n1843#2:1048\n2315#2,2:1049\n2317#2,3:1058\n2420#2:1069\n2313#2,2:1071\n1843#2:1073\n2315#2,2:1075\n2317#2,3:1078\n2420#2:1083\n2313#2,2:1085\n1843#2:1087\n2315#2,2:1089\n2317#2,3:1092\n33#3,7:500\n89#4:518\n89#4:570\n89#4:616\n89#4:655\n89#4:658\n89#4:672\n89#4:717\n89#4:770\n89#4:819\n89#4:860\n89#4:895\n89#4:930\n89#4:942\n89#4:972\n89#4:979\n89#4:982\n89#4:992\n89#4:1067\n89#4:1074\n89#4:1077\n89#4:1081\n89#4:1088\n89#4:1091\n1#5:752\n*S KotlinDebug\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SnapshotStateList\n*L\n71#1:498\n118#1:508,10\n118#1:519\n118#1:520\n118#1:522,9\n118#1:531\n118#1:537,7\n118#1:547,6\n119#1:553,17\n119#1:571\n119#1:572\n119#1:574,9\n119#1:583\n119#1:589,7\n119#1:599,6\n119#1:605\n124#1:606,10\n124#1:617\n124#1:618\n124#1:620,9\n124#1:629\n124#1:635,7\n124#1:645,6\n126#1:651\n134#1:662,10\n134#1:673\n134#1:674\n134#1:676,9\n134#1:685\n134#1:691,7\n134#1:701,6\n135#1:707,10\n135#1:718\n135#1:719\n135#1:721,9\n135#1:730\n135#1:736,7\n135#1:746,6\n136#1:753,17\n136#1:771\n136#1:772\n136#1:774,9\n136#1:783\n136#1:789,7\n136#1:799,6\n136#1:805\n139#1:806,13\n139#1:820\n139#1:821\n139#1:823,9\n139#1:832\n139#1:838,7\n139#1:848,6\n139#1:854\n143#1:855,5\n143#1:861\n143#1:862\n143#1:864,7\n143#1:871\n143#1:877,7\n143#1:887,3\n150#1:890,5\n150#1:896\n150#1:897\n150#1:899,7\n150#1:906\n150#1:912,7\n150#1:922,3\n163#1:925\n173#1:937,5\n173#1:943\n173#1:944\n173#1:946,7\n173#1:953\n173#1:959,7\n173#1:969,3\n181#1:973\n188#1:975\n207#1:986,6\n207#1:993\n207#1:994\n207#1:996,9\n207#1:1005\n207#1:1011,7\n207#1:1021,6\n207#1:1027,7\n207#1:1034\n207#1:1036,9\n207#1:1045\n207#1:1051,7\n207#1:1061,6\n220#1:1068\n229#1:1070\n220#1:1082\n229#1:1084\n71#1:499\n114#1:507\n118#1:521\n118#1:532,2\n118#1:534\n118#1:535,2\n118#1:544,3\n119#1:573\n119#1:584,2\n119#1:586\n119#1:587,2\n119#1:596,3\n124#1:619\n124#1:630,2\n124#1:632\n124#1:633,2\n124#1:642,3\n126#1:652,2\n126#1:654\n126#1:656,2\n126#1:659,3\n134#1:675\n134#1:686,2\n134#1:688\n134#1:689,2\n134#1:698,3\n135#1:720\n135#1:731,2\n135#1:733\n135#1:734,2\n135#1:743,3\n136#1:773\n136#1:784,2\n136#1:786\n136#1:787,2\n136#1:796,3\n139#1:822\n139#1:833,2\n139#1:835\n139#1:836,2\n139#1:845,3\n143#1:863\n143#1:872,2\n143#1:874\n143#1:875,2\n143#1:884,3\n150#1:898\n150#1:907,2\n150#1:909\n150#1:910,2\n150#1:919,3\n163#1:926\n167#1:927,2\n167#1:929\n167#1:931,5\n171#1:936\n173#1:945\n173#1:954,2\n173#1:956\n173#1:957,2\n173#1:966,3\n181#1:974\n188#1:976,2\n188#1:978\n188#1:980,2\n188#1:983,3\n207#1:995\n207#1:1006,2\n207#1:1008\n207#1:1009,2\n207#1:1018,3\n207#1:1035\n207#1:1046,2\n207#1:1048\n207#1:1049,2\n207#1:1058,3\n220#1:1069\n229#1:1071,2\n229#1:1073\n229#1:1075,2\n229#1:1078,3\n220#1:1083\n229#1:1085,2\n229#1:1087\n229#1:1089,2\n229#1:1092,3\n108#1:500,7\n118#1:518\n119#1:570\n124#1:616\n126#1:655\n127#1:658\n134#1:672\n135#1:717\n136#1:770\n139#1:819\n143#1:860\n150#1:895\n167#1:930\n173#1:942\n180#1:972\n188#1:979\n189#1:982\n207#1:992\n219#1:1067\n229#1:1074\n230#1:1077\n219#1:1081\n229#1:1088\n230#1:1091\n*E\n"})
public final class SnapshotStateList<T> implements StateObject, List<T>, RandomAccess, KMutableList {
    public static final int $stable = 0;

    @NotNull
    private StateRecord firstStateRecord;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", XmlErrorCodes.LIST, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "structuralChange", "getStructuralChange$runtime_release", "setStructuralChange$runtime_release", "assign", "", "value", "create", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSnapshotStateList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n*L\n1#1,497:1\n89#2:498\n*S KotlinDebug\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord\n*L\n86#1:498\n*E\n"})
    public static final class StateListStateRecord<T> extends StateRecord {
        public static final int $stable = 8;

        @NotNull
        private PersistentList<? extends T> list;
        private int modification;
        private int structuralChange;

        public StateListStateRecord(@NotNull PersistentList<? extends T> persistentList) {
            this.list = persistentList;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(@NotNull StateRecord value) {
            synchronized (SnapshotStateListKt.sync) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord.assign$lambda$0>");
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                this.structuralChange = ((StateListStateRecord) value).structuralChange;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        @NotNull
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }

        @NotNull
        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        /* JADX INFO: renamed from: getModification$runtime_release, reason: from getter */
        public final int getModification() {
            return this.modification;
        }

        /* JADX INFO: renamed from: getStructuralChange$runtime_release, reason: from getter */
        public final int getStructuralChange() {
            return this.structuralChange;
        }

        public final void setList$runtime_release(@NotNull PersistentList<? extends T> persistentList) {
            this.list = persistentList;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public final void setStructuralChange$runtime_release(int i) {
            this.structuralChange = i;
        }
    }

    public SnapshotStateList() {
        PersistentList persistentListPersistentListOf = ExtensionsKt.persistentListOf();
        StateListStateRecord stateListStateRecord = new StateListStateRecord(persistentListPersistentListOf);
        if (Snapshot.INSTANCE.isInSnapshot()) {
            StateListStateRecord stateListStateRecord2 = new StateListStateRecord(persistentListPersistentListOf);
            stateListStateRecord2.setSnapshotId$runtime_release(1);
            stateListStateRecord.setNext$runtime_release(stateListStateRecord2);
        }
        this.firstStateRecord = stateListStateRecord;
    }

    private final boolean conditionalUpdate(boolean structural, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> block) {
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                    modification = stateListStateRecord.getModification();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> persistentListInvoke = block.invoke(list$runtime_release);
            z = false;
            if (Intrinsics.areEqual(persistentListInvoke, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        try {
                            if (stateListStateRecord3.getModification() == modification) {
                                stateListStateRecord3.setList$runtime_release(persistentListInvoke);
                                if (structural) {
                                    stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                                }
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                                z = true;
                            }
                            InlineMarker.finallyStart(1);
                        } finally {
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    public static /* synthetic */ boolean conditionalUpdate$default(SnapshotStateList snapshotStateList, boolean z, Function1 function1, int i, Object obj) {
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z2;
        Snapshot current;
        if ((i & 1) != 0) {
            z = true;
        }
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                    modification = stateListStateRecord.getModification();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> persistentList = (PersistentList) function1.invoke(list$runtime_release);
            z2 = false;
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, current);
                    synchronized (SnapshotStateListKt.sync) {
                        try {
                            if (stateListStateRecord3.getModification() == modification) {
                                stateListStateRecord3.setList$runtime_release(persistentList);
                                if (z) {
                                    stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                                }
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                                z2 = true;
                            }
                            InlineMarker.finallyStart(1);
                        } finally {
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!z2);
        return true;
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> block) {
        int modification;
        PersistentList<T> list$runtime_release;
        R rInvoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                    modification = stateListStateRecord.getModification();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            rInvoke = block.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        try {
                            if (stateListStateRecord3.getModification() == modification) {
                                stateListStateRecord3.setList$runtime_release(persistentListBuild);
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                                stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                                z = true;
                            } else {
                                z = false;
                            }
                            InlineMarker.finallyStart(1);
                        } finally {
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return rInvoke;
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> block) {
        int modification;
        PersistentList<T> list$runtime_release;
        Boolean boolInvoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            boolInvoke = block.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return boolInvoke.booleanValue();
    }

    private final void update(boolean structural, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> block) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                    modification = stateListStateRecord.getModification();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> persistentListInvoke = block.invoke(list$runtime_release);
            if (Intrinsics.areEqual(persistentListInvoke, list$runtime_release)) {
                return;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        try {
                            if (stateListStateRecord3.getModification() == modification) {
                                stateListStateRecord3.setList$runtime_release(persistentListInvoke);
                                if (structural) {
                                    stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                                }
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                                z = true;
                            } else {
                                z = false;
                            }
                            InlineMarker.finallyStart(1);
                        } finally {
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
    }

    public static /* synthetic */ void update$default(SnapshotStateList snapshotStateList, boolean z, Function1 function1, int i, Object obj) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z2;
        if ((i & 1) != 0) {
            z = true;
        }
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                    modification = stateListStateRecord.getModification();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> persistentList = (PersistentList) function1.invoke(list$runtime_release);
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                return;
            }
            StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, current);
                    synchronized (SnapshotStateListKt.sync) {
                        try {
                            if (stateListStateRecord3.getModification() == modification) {
                                stateListStateRecord3.setList$runtime_release(persistentList);
                                if (z) {
                                    stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                                }
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            InlineMarker.finallyStart(1);
                        } finally {
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!z2);
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return block.invoke(SnapshotKt.current((StateListStateRecord) firstStateRecord));
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        Snapshot current;
        R rInvoke;
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                rInvoke = block.invoke(SnapshotKt.writableRecord(stateListStateRecord, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return rInvoke;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentListAdd = list$runtime_release.add(element);
            z = false;
            if (Intrinsics.areEqual(persistentListAdd, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListAdd);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(final int index, @NotNull final Collection<? extends T> elements) {
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.addAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull List<T> list) {
                return Boolean.valueOf(list.addAll(index, elements));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot current;
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.INSTANCE.getCurrent();
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, current);
            synchronized (SnapshotStateListKt.sync) {
                stateListStateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification() + 1);
                stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange() + 1);
            }
        }
        SnapshotKt.notifyWrite(current, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return getReadable$runtime_release().getList$runtime_release().contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    @Override // java.util.List
    public T get(int index) {
        return getReadable$runtime_release().getList$runtime_release().get(index);
    }

    @JvmName(name = "getDebuggerDisplayValue")
    @NotNull
    public final List<T> getDebuggerDisplayValue() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getList$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @NotNull
    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord, this);
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    public final int getStructure$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getStructuralChange();
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(element);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(@NotNull StateRecord value) {
        value.setNext$runtime_release(getFirstStateRecord());
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.firstStateRecord = (StateListStateRecord) value;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentListRemoveAll = list$runtime_release.removeAll((Collection<? extends T>) elements);
            z = false;
            if (Intrinsics.areEqual(persistentListRemoveAll, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListRemoveAll);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    public T removeAt(int index) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(index);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentListRemoveAt = list$runtime_release.removeAt(index);
            if (Intrinsics.areEqual(persistentListRemoveAt, list$runtime_release)) {
                return t;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListRemoveAt);
                        z = true;
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return t;
    }

    public final void removeRange(int fromIndex, int toIndex) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(fromIndex, toIndex).clear();
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                return;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull final Collection<? extends Object> elements) {
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.retainAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull List<T> list) {
                return Boolean.valueOf(list.retainAll(elements));
            }
        });
    }

    public final int retainAllInRange$runtime_release(@NotNull Collection<? extends T> elements, int start, int end) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        int size = size();
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(start, end).retainAll(elements);
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return size - size();
    }

    @Override // java.util.List
    public T set(int index, T element) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(index);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentList = list$runtime_release.set(index, element);
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                return t;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentList);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return t;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    @NotNull
    public List<T> subList(int fromIndex, int toIndex) {
        if (!(fromIndex >= 0 && fromIndex <= toIndex && toIndex <= size())) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        return new SubList(this, fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @NotNull
    public final List<T> toList() {
        return getReadable$runtime_release().getList$runtime_release();
    }

    @NotNull
    public String toString() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getList$runtime_release() + ")@" + hashCode();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends T> elements) {
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentListAddAll = list$runtime_release.addAll(elements);
            z = false;
            if (Intrinsics.areEqual(persistentListAddAll, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListAddAll);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator(int index) {
        return new StateListIterator(this, index);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentListRemove = list$runtime_release.remove(element);
            z = false;
            if (Intrinsics.areEqual(persistentListRemove, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListRemove);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    @Override // java.util.List
    public void add(int index, T element) {
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentListAdd = list$runtime_release.add(index, element);
            if (Intrinsics.areEqual(persistentListAdd, list$runtime_release)) {
                return;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentListAdd);
                        z = true;
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
    }
}
