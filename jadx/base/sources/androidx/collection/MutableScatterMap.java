package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.sequences.Sequence;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001EB\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bJ\u0006\u0010\f\u001a\u00020\tJS\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u000028\u0010\u000f\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00028\u00010\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0019J'\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010\"\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010#J\u0017\u0010\"\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0086\nJ\u0017\u0010\"\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0086\nJ\u001e\u0010\"\u001a\u00020\t2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000'H\u0086\n¢\u0006\u0002\u0010(J\u0017\u0010\"\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0086\nJ\u0017\u0010\"\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0086\nJ\u001d\u0010+\u001a\u00020\t2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\nJ*\u0010+\u001a\u00020\t2\u001a\u0010-\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.0'H\u0086\n¢\u0006\u0002\u0010/J\u001d\u0010+\u001a\u00020\t2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.H\u0086\nJ#\u0010+\u001a\u00020\t2\u0018\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.0)H\u0086\nJ\u001d\u0010+\u001a\u00020\t2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000101H\u0086\nJ#\u0010+\u001a\u00020\t2\u0018\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.0*H\u0086\nJ\u001d\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0002\u00103J\u001a\u00104\u001a\u00020\t2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J'\u00104\u001a\u00020\t2\u001a\u0010-\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.0'¢\u0006\u0002\u0010/J \u00104\u001a\u00020\t2\u0018\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.0)J\u001a\u00104\u001a\u00020\t2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000101J \u00104\u001a\u00020\t2\u0018\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.0*J\u0015\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u00106J\u001b\u00105\u001a\u0002072\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0002\u00108J&\u00109\u001a\u00020\t2\u0018\u0010:\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002070\u0010H\u0086\bø\u0001\u0000J\u0017\u0010;\u001a\u0004\u0018\u00018\u00012\u0006\u0010<\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u001e\u0010@\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010AJ\u0006\u0010B\u001a\u00020\u0005J\u0019\u0010C\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020DH\u0082\bR\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, m13886d2 = {"Landroidx/collection/MutableScatterMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/ScatterMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "asMutableMap", "", "clear", "compute", "key", "computeBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "dropDeletes", "findFirstAvailableSlot", "hash1", "findInsertIndex", "(Ljava/lang/Object;)I", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "keys", "Landroidx/collection/ObjectList;", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "plusAssign", Constants.MessagePayloadKeys.FROM, "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "pair", "", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeIf", "predicate", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "(Ljava/lang/Object;Ljava/lang/Object;)V", "trim", "writeMetadata", "", "MutableMapWrapper", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap\n+ 2 RuntimeHelpers.kt\nandroidx/collection/internal/RuntimeHelpersKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 7 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 8 ObjectList.kt\nandroidx/collection/ObjectList\n*L\n1#1,1980:1\n46#2,5:1981\n1804#3,6:1986\n1956#3:2005\n1820#3:2009\n1714#3,3:2022\n1728#3:2026\n1724#3:2029\n1925#3,3:2034\n1939#3,3:2038\n1865#3:2042\n1853#3:2044\n1847#3:2045\n1860#3:2050\n1948#3:2052\n1714#3,3:2062\n1728#3:2066\n1724#3:2069\n1925#3,3:2074\n1939#3,3:2078\n1865#3:2082\n1853#3:2084\n1847#3:2085\n1860#3:2090\n1948#3:2092\n1956#3:2107\n1820#3:2111\n1956#3:2132\n1820#3:2136\n1780#3:2153\n1804#3,6:2154\n1792#3:2160\n1791#3,4:2161\n1804#3,6:2165\n1714#3,3:2171\n1724#3:2174\n1728#3:2175\n1925#3,3:2176\n1939#3,3:2179\n1865#3:2182\n1853#3:2183\n1847#3:2184\n1860#3:2185\n1948#3:2186\n1814#3:2187\n1770#3:2188\n1812#3:2189\n1770#3:2190\n1780#3:2191\n1804#3,6:2192\n1792#3:2198\n1791#3,4:2199\n1925#3,3:2203\n1956#3:2206\n1847#3:2207\n1770#3:2208\n1714#3,3:2209\n1724#3:2212\n1728#3:2213\n1804#3,6:2214\n1770#3:2220\n1728#3:2221\n1804#3,6:2222\n1804#3,6:2228\n1728#3:2234\n1804#3,6:2235\n1817#3:2241\n1770#3:2242\n1714#3,3:2243\n1724#3:2246\n1728#3:2247\n1780#3:2248\n1804#3,6:2249\n1792#3:2255\n1791#3,4:2256\n1804#3,6:2260\n1804#3,6:2266\n1#4:1992\n215#5,2:1993\n393#6,4:1995\n365#6,6:1999\n375#6,3:2006\n378#6,2:2010\n398#6,2:2012\n381#6,6:2014\n400#6:2020\n635#6:2021\n636#6:2025\n638#6,2:2027\n640#6,4:2030\n644#6:2037\n645#6:2041\n646#6:2043\n647#6,4:2046\n653#6:2051\n654#6,8:2053\n635#6:2061\n636#6:2065\n638#6,2:2067\n640#6,4:2070\n644#6:2077\n645#6:2081\n646#6:2083\n647#6,4:2086\n653#6:2091\n654#6,8:2093\n365#6,6:2101\n375#6,3:2108\n378#6,9:2112\n228#7,4:2121\n198#7,7:2125\n209#7,3:2133\n212#7,9:2137\n232#7:2146\n305#8,6:2147\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap\n*L\n822#1:1981,5\n850#1:1986,6\n974#1:2005\n974#1:2009\n1023#1:2022,3\n1023#1:2026\n1023#1:2029\n1023#1:2034,3\n1023#1:2038,3\n1023#1:2042\n1023#1:2044\n1023#1:2045\n1023#1:2050\n1023#1:2052\n1035#1:2062,3\n1035#1:2066\n1035#1:2069\n1035#1:2074,3\n1035#1:2078,3\n1035#1:2082\n1035#1:2084\n1035#1:2085\n1035#1:2090\n1035#1:2092\n1049#1:2107\n1049#1:2111\n1095#1:2132\n1095#1:2136\n1115#1:2153\n1115#1:2154,6\n1115#1:2160\n1115#1:2161,4\n1131#1:2165,6\n1147#1:2171,3\n1148#1:2174\n1149#1:2175\n1156#1:2176,3\n1157#1:2179,3\n1158#1:2182\n1159#1:2183\n1159#1:2184\n1163#1:2185\n1166#1:2186\n1175#1:2187\n1175#1:2188\n1181#1:2189\n1181#1:2190\n1182#1:2191\n1182#1:2192,6\n1182#1:2198\n1182#1:2199,4\n1197#1:2203,3\n1198#1:2206\n1200#1:2207\n1253#1:2208\n1268#1:2209,3\n1269#1:2212\n1280#1:2213\n1281#1:2214,6\n1290#1:2220\n1293#1:2221\n1294#1:2222,6\n1295#1:2228,6\n1307#1:2234\n1308#1:2235,6\n1350#1:2241\n1350#1:2242\n1352#1:2243,3\n1353#1:2246\n1355#1:2247\n1355#1:2248\n1355#1:2249,6\n1355#1:2255\n1355#1:2256,4\n1369#1:2260,6\n1375#1:2266,6\n965#1:1993,2\n974#1:1995,4\n974#1:1999,6\n974#1:2006,3\n974#1:2010,2\n974#1:2012,2\n974#1:2014,6\n974#1:2020\n1023#1:2021\n1023#1:2025\n1023#1:2027,2\n1023#1:2030,4\n1023#1:2037\n1023#1:2041\n1023#1:2043\n1023#1:2046,4\n1023#1:2051\n1023#1:2053,8\n1035#1:2061\n1035#1:2065\n1035#1:2067,2\n1035#1:2070,4\n1035#1:2077\n1035#1:2081\n1035#1:2083\n1035#1:2086,4\n1035#1:2091\n1035#1:2093,8\n1049#1:2101,6\n1049#1:2108,3\n1049#1:2112,9\n1095#1:2121,4\n1095#1:2125,7\n1095#1:2133,3\n1095#1:2137,9\n1095#1:2146\n1104#1:2147,6\n*E\n"})
public final class MutableScatterMap<K, V> extends ScatterMap<K, V> {
    private int growthLimit;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00112\u0014\u0010\u0017\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR&\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m13886d2 = {"Landroidx/collection/MutableScatterMap$MutableMapWrapper;", "Landroidx/collection/ScatterMap$MapWrapper;", "Landroidx/collection/ScatterMap;", "", "(Landroidx/collection/MutableScatterMap;)V", SearchIndexablesContract.RawData.COLUMN_ENTRIES, "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", Constants.MessagePayloadKeys.FROM, "", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1980:1\n215#2,2:1981\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper\n*L\n1674#1:1981,2\n*E\n"})
    public final class MutableMapWrapper extends ScatterMap<K, V>.MapWrapper implements Map<K, V>, KMutableMap {
        public MutableMapWrapper() {
            super();
        }

        @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
        public void clear() {
            MutableScatterMap.this.clear();
        }

        @Override // androidx.collection.ScatterMap.MapWrapper
        @NotNull
        public Set<Map.Entry<K, V>> getEntries() {
            return new MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap.this);
        }

        @Override // androidx.collection.ScatterMap.MapWrapper
        @NotNull
        public Set<K> getKeys() {
            return new MutableScatterMap$MutableMapWrapper$keys$1(MutableScatterMap.this);
        }

        @Override // androidx.collection.ScatterMap.MapWrapper
        @NotNull
        public Collection<V> getValues() {
            return new MutableScatterMap$MutableMapWrapper$values$1(MutableScatterMap.this);
        }

        @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
        @Nullable
        public V put(K key, V value) {
            return MutableScatterMap.this.put(key, value);
        }

        @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
        public void putAll(@NotNull Map<? extends K, ? extends V> from) {
            Intrinsics.checkNotNullParameter(from, "from");
            for (Map.Entry<? extends K, ? extends V> entry : from.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }

        @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
        @Nullable
        public V remove(Object key) {
            return MutableScatterMap.this.remove(key);
        }
    }

    public MutableScatterMap() {
        this(0, 1, null);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compareUnsigned(AbstractC0622a.m1161g(this._size, 32L), AbstractC0622a.m1161g(this._capacity, 25L)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes();
        }
    }

    private final void dropDeletes() {
        long[] jArr = this.metadata;
        int i = this._capacity;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        ScatterMapKt.convertMetadataForCleanup(jArr, i);
        int i2 = 0;
        int iFindEmptySlot = -1;
        while (i2 != i) {
            int i4 = i2 >> 3;
            int i5 = (i2 & 7) << 3;
            long j = (jArr[i4] >> i5) & 255;
            if (j == 128) {
                iFindEmptySlot = i2;
                i2++;
            } else {
                if (j == 254) {
                    Object obj = objArr[i2];
                    int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                    int i6 = iHashCode ^ (iHashCode << 16);
                    int i7 = i6 >>> 7;
                    int iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                    int i8 = i7 & i;
                    if (((iFindFirstAvailableSlot - i8) & i) / 8 == ((i2 - i8) & i) / 8) {
                        jArr[i4] = (((long) (i6 & 127)) << i5) | ((~(255 << i5)) & jArr[i4]);
                        jArr[ArraysKt.getLastIndex(jArr)] = jArr[0];
                    } else {
                        int i9 = iFindFirstAvailableSlot >> 3;
                        long j2 = jArr[i9];
                        int i10 = (iFindFirstAvailableSlot & 7) << 3;
                        if (((j2 >> i10) & 255) == 128) {
                            jArr[i9] = (j2 & (~(255 << i10))) | (((long) (i6 & 127)) << i10);
                            jArr[i4] = (jArr[i4] & (~(255 << i5))) | (128 << i5);
                            objArr[iFindFirstAvailableSlot] = objArr[i2];
                            objArr[i2] = null;
                            objArr2[iFindFirstAvailableSlot] = objArr2[i2];
                            objArr2[i2] = null;
                            iFindEmptySlot = i2;
                        } else {
                            jArr[i9] = (((long) (i6 & 127)) << i10) | (j2 & (~(255 << i10)));
                            if (iFindEmptySlot == -1) {
                                iFindEmptySlot = ScatterMapKt.findEmptySlot(jArr, i2 + 1, i);
                            }
                            objArr[iFindEmptySlot] = objArr[iFindFirstAvailableSlot];
                            objArr[iFindFirstAvailableSlot] = objArr[i2];
                            objArr[i2] = objArr[iFindEmptySlot];
                            objArr2[iFindEmptySlot] = objArr2[iFindFirstAvailableSlot];
                            objArr2[iFindFirstAvailableSlot] = objArr2[i2];
                            objArr2[i2] = objArr2[iFindEmptySlot];
                            i2--;
                        }
                        jArr[ArraysKt.getLastIndex(jArr)] = jArr[0];
                    }
                }
                i2++;
            }
        }
        initializeGrowth();
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i = this._capacity;
        int i2 = hash1 & i;
        int i4 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i5 = i2 >> 3;
            int i6 = (i2 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-i6) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i2 + (Long.numberOfTrailingZeros(j2) >> 3)) & i;
            }
            i4 += 8;
            i2 = (i2 + i4) & i;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((capacity + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.metadata = jArr;
        int i = capacity >> 3;
        long j = 255 << ((capacity & 7) << 3);
        jArr[i] = (jArr[i] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeStorage(int initialCapacity) {
        int iMax = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.keys = new Object[iMax];
        this.values = new Object[iMax];
    }

    private final void resizeStorage(int newCapacity) {
        int i;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i2 = this._capacity;
        initializeStorage(newCapacity);
        long[] jArr2 = this.metadata;
        Object[] objArr3 = this.keys;
        Object[] objArr4 = this.values;
        int i4 = this._capacity;
        int i5 = 0;
        while (i5 < i2) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i6 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i6 >>> 7);
                i = i5;
                long j = i6 & 127;
                int i7 = iFindFirstAvailableSlot >> 3;
                int i8 = (iFindFirstAvailableSlot & 7) << 3;
                long j2 = (j << i8) | (jArr2[i7] & (~(255 << i8)));
                jArr2[i7] = j2;
                jArr2[(((iFindFirstAvailableSlot - 7) & i4) + (i4 & 7)) >> 3] = j2;
                objArr3[iFindFirstAvailableSlot] = obj;
                objArr4[iFindFirstAvailableSlot] = objArr2[i];
            } else {
                i = i5;
            }
            i5 = i + 1;
        }
    }

    private final void writeMetadata(int index, long value) {
        long[] jArr = this.metadata;
        int i = index >> 3;
        int i2 = (index & 7) << 3;
        jArr[i] = (jArr[i] & (~(255 << i2))) | (value << i2);
        int i4 = this._capacity;
        int i5 = ((index - 7) & i4) + (i4 & 7);
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (value << i7) | (jArr[i6] & (~(255 << i7)));
    }

    @NotNull
    public final Map<K, V> asMutableMap() {
        return new MutableMapWrapper();
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            ArraysKt___ArraysJvmKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        ArraysKt___ArraysJvmKt.fill(this.values, (Object) null, 0, this._capacity);
        ArraysKt___ArraysJvmKt.fill(this.keys, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    public final V compute(K key, @NotNull Function2<? super K, ? super V, ? extends V> computeBlock) {
        Intrinsics.checkNotNullParameter(computeBlock, "computeBlock");
        int iFindInsertIndex = findInsertIndex(key);
        boolean z = iFindInsertIndex < 0;
        V vInvoke = computeBlock.invoke(key, z ? null : this.values[iFindInsertIndex]);
        if (!z) {
            this.values[iFindInsertIndex] = vInvoke;
            return vInvoke;
        }
        int i = ~iFindInsertIndex;
        this.keys[i] = key;
        this.values[i] = vInvoke;
        return vInvoke;
    }

    @PublishedApi
    public final int findInsertIndex(K key) {
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i >>> 7;
        int i4 = i & 127;
        int i5 = this._capacity;
        int i6 = i2 & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = i4;
            int i10 = i4;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j5 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int iNumberOfTrailingZeros = (i6 + (Long.numberOfTrailingZeros(j5) >> 3)) & i5;
                if (Intrinsics.areEqual(this.keys[iNumberOfTrailingZeros], key)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                }
                this._size++;
                int i11 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i12 = iFindFirstAvailableSlot >> 3;
                long j6 = jArr2[i12];
                int i13 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i11 - (((j6 >> i13) & 255) == 128 ? 1 : 0);
                int i14 = this._capacity;
                long j7 = ((~(255 << i13)) & j6) | (j2 << i13);
                jArr2[i12] = j7;
                jArr2[(((iFindFirstAvailableSlot - 7) & i14) + (i14 & 7)) >> 3] = j7;
                return ~iFindFirstAvailableSlot;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
            i4 = i10;
        }
    }

    public final V getOrPut(K key, @NotNull Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = get(key);
        if (v != null) {
            return v;
        }
        V vInvoke = defaultValue.invoke();
        set(key, vInvoke);
        return vInvoke;
    }

    public final void minusAssign(K key) {
        remove(key);
    }

    public final void plusAssign(@NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        set(pair.getFirst(), pair.getSecond());
    }

    @Nullable
    public final V put(K key, V value) {
        int iFindInsertIndex = findInsertIndex(key);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        }
        Object[] objArr = this.values;
        V v = (V) objArr[iFindInsertIndex];
        this.keys[iFindInsertIndex] = key;
        objArr[iFindInsertIndex] = value;
        return v;
    }

    public final void putAll(@NotNull Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            set(pair.component1(), pair.component2());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        r10 = -1;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V remove(K key) {
        int iNumberOfTrailingZeros;
        int i = 0;
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i2 = iHashCode ^ (iHashCode << 16);
        int i4 = i2 & 127;
        int i5 = this._capacity;
        int i6 = i2 >>> 7;
        loop0: while (true) {
            int i7 = i6 & i5;
            long[] jArr = this.metadata;
            int i8 = i7 >> 3;
            int i9 = (i7 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (((long) i4) * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i7) & i5;
                if (Intrinsics.areEqual(this.keys[iNumberOfTrailingZeros], key)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i += 8;
            i6 = i7 + i;
        }
        if (iNumberOfTrailingZeros >= 0) {
            return removeValueAt(iNumberOfTrailingZeros);
        }
        return null;
    }

    public final void removeIf(@NotNull Function2<? super K, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.metadata;
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
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        if (predicate.invoke(this.keys[i5], this.values[i5]).booleanValue()) {
                            removeValueAt(i5);
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

    @PublishedApi
    @Nullable
    public final V removeValueAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i2 = index >> 3;
        int i4 = (index & 7) << 3;
        long j = (jArr[i2] & (~(255 << i4))) | (254 << i4);
        jArr[i2] = j;
        jArr[(((index - 7) & i) + (i & 7)) >> 3] = j;
        this.keys[index] = null;
        Object[] objArr = this.values;
        V v = (V) objArr[index];
        objArr[index] = null;
        return v;
    }

    public final void set(K key, V value) {
        int iFindInsertIndex = findInsertIndex(key);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        }
        this.keys[iFindInsertIndex] = key;
        this.values[iFindInsertIndex] = value;
    }

    public final int trim() {
        int i = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i - this._capacity;
    }

    public /* synthetic */ MutableScatterMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(@NotNull K[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final void plusAssign(@NotNull Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        putAll(pairs);
    }

    public MutableScatterMap(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public final void plusAssign(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        putAll(pairs);
    }

    public final void putAll(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            set(pair.component1(), pair.component2());
        }
    }

    public final void minusAssign(@NotNull Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        putAll(pairs);
    }

    public final void plusAssign(@NotNull Map<K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final void putAll(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            set(pair.component1(), pair.component2());
        }
    }

    public final void minusAssign(@NotNull Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(@NotNull ScatterMap<K, V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final void putAll(@NotNull Map<K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry<K, ? extends V> entry : from.entrySet()) {
            set(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ScatterSet<K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Object[] objArr = keys.elements;
        long[] jArr = keys.metadata;
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
                    if ((255 & j) < 128) {
                        remove(objArr[(i << 3) + i4]);
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(K key, V value) {
        int iNumberOfTrailingZeros;
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i4 = this._capacity;
        int i5 = (i >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (((long) i2) * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (Intrinsics.areEqual(this.keys[iNumberOfTrailingZeros], key)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        if (iNumberOfTrailingZeros < 0 || !Intrinsics.areEqual(this.values[iNumberOfTrailingZeros], value)) {
            return false;
        }
        removeValueAt(iNumberOfTrailingZeros);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(@NotNull ScatterMap<K, V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Object[] objArr = from.keys;
        Object[] objArr2 = from.values;
        long[] jArr = from.metadata;
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
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        set(objArr[i5], objArr2[i5]);
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ObjectList<K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Object[] objArr = keys.content;
        int i = keys._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(objArr[i2]);
        }
    }
}
