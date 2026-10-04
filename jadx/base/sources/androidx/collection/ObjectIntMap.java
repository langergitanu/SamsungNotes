package androidx.collection;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.internal.ContainerHelpersKt;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.parser.Parse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0006\u0010\u001c\u001a\u00020\u0019J&\u0010\u001c\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0015\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010'JD\u0010(\u001a\u00020)26\u0010*\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020)0\u001bH\u0086\bø\u0001\u0000J/\u0010-\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020)0.H\u0081\bø\u0001\u0000J/\u00100\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J/\u00101\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J\u0016\u00102\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010'J\u001b\u00103\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u0005¢\u0006\u0002\u00105J'\u00106\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u00002\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000507H\u0086\bø\u0001\u0000¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\u0005H\u0016J\u0006\u0010:\u001a\u00020\u0019J\u0006\u0010;\u001a\u00020\u0019J:\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020?H\u0007Jx\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020?28\b\u0004\u0010D\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020?0\u001bH\u0087\bø\u0001\u0000J\u0006\u0010E\u001a\u00020\u0019J\b\u0010F\u001a\u00020=H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000f\u0012\u0004\b\u000e\u0010\u0003R\u0018\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u0018\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u0082\u0001\u0001G\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006H"}, m13886d2 = {"Landroidx/collection/ObjectIntMap;", "K", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "getCapacity", "()I", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", GroupContract.Group.META_DATA, "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "any", "contains", "key", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "(Ljava/lang/Object;)I", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "(Ljava/lang/Object;I)I", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)I", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableObjectIntMap;", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nObjectIntMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectIntMap.kt\nandroidx/collection/ObjectIntMap\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1158:1\n374#1,6:1161\n384#1,3:1168\n387#1,9:1172\n374#1,6:1181\n384#1,3:1188\n387#1,9:1192\n374#1,6:1201\n384#1,3:1208\n387#1,9:1212\n402#1,4:1221\n374#1,6:1225\n384#1,3:1232\n387#1,2:1236\n407#1,2:1238\n390#1,6:1240\n409#1:1246\n402#1,4:1247\n374#1,6:1251\n384#1,3:1258\n387#1,2:1262\n407#1,2:1264\n390#1,6:1266\n409#1:1272\n402#1,4:1273\n374#1,6:1277\n384#1,3:1284\n387#1,2:1288\n407#1,2:1290\n390#1,6:1292\n409#1:1298\n429#1,3:1299\n374#1,6:1302\n384#1,3:1309\n387#1,2:1313\n432#1,2:1315\n390#1,6:1317\n434#1:1323\n402#1,4:1324\n374#1,6:1328\n384#1,3:1335\n387#1,2:1339\n407#1,2:1341\n390#1,6:1343\n409#1:1349\n402#1,4:1350\n374#1,6:1354\n384#1,3:1361\n387#1,2:1365\n407#1,2:1367\n390#1,6:1369\n409#1:1375\n402#1,4:1376\n374#1,6:1380\n384#1,3:1387\n387#1,2:1391\n407#1,2:1393\n390#1,6:1395\n409#1:1401\n402#1,4:1402\n374#1,6:1406\n384#1,3:1413\n387#1,2:1417\n407#1,2:1419\n390#1,6:1421\n409#1:1427\n402#1,4:1428\n374#1,6:1432\n384#1,3:1439\n387#1,2:1443\n407#1,2:1445\n390#1,6:1447\n409#1:1453\n402#1,4:1454\n374#1,6:1458\n384#1,3:1465\n387#1,2:1469\n407#1,2:1471\n390#1,6:1473\n409#1:1479\n538#1,11:1496\n402#1,4:1507\n374#1,6:1511\n384#1,3:1518\n387#1,2:1522\n407#1:1524\n549#1,10:1525\n408#1:1535\n390#1,6:1536\n409#1:1542\n559#1,2:1543\n538#1,11:1545\n402#1,4:1556\n374#1,6:1560\n384#1,3:1567\n387#1,2:1571\n407#1:1573\n549#1,10:1574\n408#1:1584\n390#1,6:1585\n409#1:1591\n559#1,2:1592\n538#1,11:1594\n402#1,4:1605\n374#1,6:1609\n384#1,3:1616\n387#1,2:1620\n407#1:1622\n549#1,10:1623\n408#1:1633\n390#1,6:1634\n409#1:1640\n559#1,2:1641\n538#1,11:1643\n402#1,4:1654\n374#1,6:1658\n384#1,3:1665\n387#1,2:1669\n407#1:1671\n549#1,10:1672\n408#1:1682\n390#1,6:1683\n409#1:1689\n559#1,2:1690\n538#1,11:1692\n402#1,4:1703\n374#1,6:1707\n384#1,3:1714\n387#1,2:1718\n407#1:1720\n549#1,10:1721\n408#1:1731\n390#1,6:1732\n409#1:1738\n559#1,2:1739\n1956#2:1159\n1820#2:1160\n1956#2:1167\n1820#2:1171\n1956#2:1187\n1820#2:1191\n1956#2:1207\n1820#2:1211\n1956#2:1231\n1820#2:1235\n1956#2:1257\n1820#2:1261\n1956#2:1283\n1820#2:1287\n1956#2:1308\n1820#2:1312\n1956#2:1334\n1820#2:1338\n1956#2:1360\n1820#2:1364\n1956#2:1386\n1820#2:1390\n1956#2:1412\n1820#2:1416\n1956#2:1438\n1820#2:1442\n1956#2:1464\n1820#2:1468\n1714#2,3:1480\n1728#2:1483\n1724#2:1484\n1925#2,3:1485\n1939#2,3:1488\n1865#2:1491\n1853#2:1492\n1847#2:1493\n1860#2:1494\n1948#2:1495\n1956#2:1517\n1820#2:1521\n1956#2:1566\n1820#2:1570\n1956#2:1615\n1820#2:1619\n1956#2:1664\n1820#2:1668\n1956#2:1713\n1820#2:1717\n*S KotlinDebug\n*F\n+ 1 ObjectIntMap.kt\nandroidx/collection/ObjectIntMap\n*L\n405#1:1161,6\n405#1:1168,3\n405#1:1172,9\n418#1:1181,6\n418#1:1188,3\n418#1:1192,9\n431#1:1201,6\n431#1:1208,3\n431#1:1212,9\n440#1:1221,4\n440#1:1225,6\n440#1:1232,3\n440#1:1236,2\n440#1:1238,2\n440#1:1240,6\n440#1:1246\n450#1:1247,4\n450#1:1251,6\n450#1:1258,3\n450#1:1262,2\n450#1:1264,2\n450#1:1266,6\n450#1:1272\n466#1:1273,4\n466#1:1277,6\n466#1:1284,3\n466#1:1288,2\n466#1:1290,2\n466#1:1292,6\n466#1:1298\n489#1:1299,3\n489#1:1302,6\n489#1:1309,3\n489#1:1313,2\n489#1:1315,2\n489#1:1317,6\n489#1:1323\n513#1:1324,4\n513#1:1328,6\n513#1:1335,3\n513#1:1339,2\n513#1:1341,2\n513#1:1343,6\n513#1:1349\n548#1:1350,4\n548#1:1354,6\n548#1:1361,3\n548#1:1365,2\n548#1:1367,2\n548#1:1369,6\n548#1:1375\n548#1:1376,4\n548#1:1380,6\n548#1:1387,3\n548#1:1391,2\n548#1:1393,2\n548#1:1395,6\n548#1:1401\n569#1:1402,4\n569#1:1406,6\n569#1:1413,3\n569#1:1417,2\n569#1:1419,2\n569#1:1421,6\n569#1:1427\n598#1:1428,4\n598#1:1432,6\n598#1:1439,3\n598#1:1443,2\n598#1:1445,2\n598#1:1447,6\n598#1:1453\n620#1:1454,4\n620#1:1458,6\n620#1:1465,3\n620#1:1469,2\n620#1:1471,2\n620#1:1473,6\n620#1:1479\n-1#1:1496,11\n-1#1:1507,4\n-1#1:1511,6\n-1#1:1518,3\n-1#1:1522,2\n-1#1:1524\n-1#1:1525,10\n-1#1:1535\n-1#1:1536,6\n-1#1:1542\n-1#1:1543,2\n-1#1:1545,11\n-1#1:1556,4\n-1#1:1560,6\n-1#1:1567,3\n-1#1:1571,2\n-1#1:1573\n-1#1:1574,10\n-1#1:1584\n-1#1:1585,6\n-1#1:1591\n-1#1:1592,2\n-1#1:1594,11\n-1#1:1605,4\n-1#1:1609,6\n-1#1:1616,3\n-1#1:1620,2\n-1#1:1622\n-1#1:1623,10\n-1#1:1633\n-1#1:1634,6\n-1#1:1640\n-1#1:1641,2\n-1#1:1643,11\n-1#1:1654,4\n-1#1:1658,6\n-1#1:1665,3\n-1#1:1669,2\n-1#1:1671\n-1#1:1672,10\n-1#1:1682\n-1#1:1683,6\n-1#1:1689\n-1#1:1690,2\n-1#1:1692,11\n-1#1:1703,4\n-1#1:1707,6\n-1#1:1714,3\n-1#1:1718,2\n-1#1:1720\n-1#1:1721,10\n-1#1:1731\n-1#1:1732,6\n-1#1:1738\n-1#1:1739,2\n379#1:1159\n386#1:1160\n405#1:1167\n405#1:1171\n418#1:1187\n418#1:1191\n431#1:1207\n431#1:1211\n440#1:1231\n440#1:1235\n450#1:1257\n450#1:1261\n466#1:1283\n466#1:1287\n489#1:1308\n489#1:1312\n513#1:1334\n513#1:1338\n548#1:1360\n548#1:1364\n548#1:1386\n548#1:1390\n569#1:1412\n569#1:1416\n598#1:1438\n598#1:1442\n620#1:1464\n620#1:1468\n639#1:1480,3\n640#1:1483\n643#1:1484\n647#1:1485,3\n648#1:1488,3\n649#1:1491\n650#1:1492\n650#1:1493\n654#1:1494\n657#1:1495\n-1#1:1517\n-1#1:1521\n-1#1:1566\n-1#1:1570\n-1#1:1615\n-1#1:1619\n-1#1:1664\n-1#1:1668\n-1#1:1713\n-1#1:1717\n*E\n"})
public abstract class ObjectIntMap<K> {

    @JvmField
    public int _capacity;

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public Object[] keys;

    @JvmField
    @NotNull
    public long[] metadata;

    @JvmField
    @NotNull
    public int[] values;

    public /* synthetic */ ObjectIntMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String joinToString$default(ObjectIntMap objectIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
            charSequence = SQLKeyword.COMMA;
        }
        if ((i2 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return objectIntMap.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final boolean all(@NotNull Function2<? super K, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
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
                        int i5 = (i << 3) + i4;
                        if (!predicate.invoke(objArr[i5], Integer.valueOf(iArr[i5])).booleanValue()) {
                            return false;
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

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean contains(K key) {
        return findKeyIndex(key) >= 0;
    }

    public final boolean containsKey(K key) {
        return findKeyIndex(key) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsValue(int value) {
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128 && value == iArr[(i << 3) + i4]) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return false;
    }

    public final int count() {
        return get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ObjectIntMap)) {
            return false;
        }
        ObjectIntMap objectIntMap = (ObjectIntMap) other;
        if (objectIntMap.get_size() != get_size()) {
            return false;
        }
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            if (iArr[i5] != objectIntMap.get(objArr[i5])) {
                                return false;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return true;
    }

    @PublishedApi
    public final int findKeyIndex(K key) {
        int i = 0;
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i2 = iHashCode ^ (iHashCode << 16);
        int i4 = i2 & 127;
        int i5 = this._capacity;
        int i6 = i2 >>> 7;
        while (true) {
            int i7 = i6 & i5;
            long[] jArr = this.metadata;
            int i8 = i7 >> 3;
            int i9 = (i7 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (((long) i4) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i7) & i5;
                if (Intrinsics.areEqual(this.keys[iNumberOfTrailingZeros], key)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i += 8;
            i6 = i7 + i;
        }
    }

    public final void forEach(@NotNull Function2<? super K, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                        block.invoke(objArr[i5], Integer.valueOf(iArr[i5]));
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
    public final void forEachIndexed(@NotNull Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
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
                        AbstractC0541b.m784z(i << 3, i4, block);
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

    public final void forEachKey(@NotNull Function1<? super K, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.keys;
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
                        block.invoke(objArr[(i << 3) + i4]);
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

    public final void forEachValue(@NotNull Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int[] iArr = this.values;
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
                        block.invoke(Integer.valueOf(iArr[(i << 3) + i4]));
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

    public final int get(K key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        throw new NoSuchElementException(AbstractC0622a.m1165k(key, "There is no key ", " in the map"));
    }

    /* JADX INFO: renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    public final int getOrDefault(K key, int defaultValue) {
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : defaultValue;
    }

    public final int getOrElse(K key, @NotNull Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : defaultValue.invoke().intValue();
    }

    /* JADX INFO: renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        Object obj = objArr[i5];
                        iHashCode += Integer.hashCode(iArr[i5]) ^ (obj != null ? obj.hashCode() : 0);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return iHashCode;
                }
            }
            if (i == length) {
                return iHashCode;
            }
            i++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e A[PHI: r8
      0x006e: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x0030, B:22:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(Parse.BRACKET_LCB);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i << 3) + i5;
                            Object obj = objArr[i6];
                            int i7 = iArr[i6];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                            sb.append(i7);
                            i2++;
                            if (i2 < this._size) {
                                sb.append(SQLKeyword.COMMA);
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return AbstractC0541b.m766h('}', "s.append('}').toString()", sb);
    }

    private ObjectIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = IntSetKt.getEmptyIntArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean any(@NotNull Function2<? super K, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            if (predicate.invoke(objArr[i5], Integer.valueOf(iArr[i5])).booleanValue()) {
                                return true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return false;
    }

    public final int count(@NotNull Function2<? super K, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j) < 128) {
                        int i6 = (i << 3) + i5;
                        if (predicate.invoke(objArr[i6], Integer.valueOf(iArr[i6])).booleanValue()) {
                            i2++;
                        }
                    }
                    j >>= 8;
                }
                if (i4 != 8) {
                    return i2;
                }
            }
            if (i == length) {
                return i2;
            }
            i++;
        }
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(ObjectIntMap objectIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 function2, int i2, Object obj) {
        long[] jArr;
        long[] jArr2;
        int i4;
        if (obj == null) {
            CharSequence separator = (i2 & 1) != 0 ? SQLKeyword.COMMA : charSequence;
            CharSequence prefix = (i2 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i2 & 4) == 0 ? charSequence3 : "";
            int i5 = (i2 & 8) != 0 ? -1 : i;
            CharSequence charSequence5 = (i2 & 16) != 0 ? "..." : charSequence4;
            Intrinsics.checkNotNullParameter(separator, "separator");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(postfix, "postfix");
            StringBuilder sbM779u = AbstractC0541b.m779u(charSequence5, "truncated", function2, "transform", prefix);
            Object[] objArr = objectIntMap.keys;
            int[] iArr = objectIntMap.values;
            long[] jArr3 = objectIntMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i6 = 0;
                int i7 = 0;
                loop0: while (true) {
                    long j = jArr3[i6];
                    int i8 = i6;
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i9 = 8;
                        int i10 = 8 - ((~(i8 - length)) >>> 31);
                        int i11 = 0;
                        while (i11 < i10) {
                            if ((j & 255) < 128) {
                                int i12 = (i8 << 3) + i11;
                                i4 = i9;
                                Object obj2 = objArr[i12];
                                int i13 = iArr[i12];
                                if (i7 == i5) {
                                    sbM779u.append(charSequence5);
                                    break loop0;
                                }
                                if (i7 != 0) {
                                    sbM779u.append(separator);
                                }
                                jArr2 = jArr3;
                                sbM779u.append((CharSequence) function2.invoke(obj2, Integer.valueOf(i13)));
                                i7++;
                            } else {
                                jArr2 = jArr3;
                                i4 = i9;
                            }
                            j >>= i4;
                            i11++;
                            i9 = i4;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i10 != i9) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i8 == length) {
                        break;
                    }
                    i6 = i8 + 1;
                    jArr3 = jArr;
                }
                sbM779u.append(postfix);
            } else {
                sbM779u.append(postfix);
            }
            String string = sbM779u.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated) {
        Object[] objArr;
        Object[] objArr2;
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM1174t = AbstractC0622a.m1174t(postfix, "postfix", truncated, "truncated", prefix);
        Object[] objArr3 = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            i = i5;
                            Object obj = objArr3[i8];
                            int i9 = iArr[i8];
                            objArr2 = objArr3;
                            if (i4 == limit) {
                                sbM1174t.append(truncated);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM1174t.append(separator);
                            }
                            sbM1174t.append(obj);
                            sbM1174t.append('=');
                            sbM1174t.append(i9);
                            i4++;
                        } else {
                            objArr2 = objArr3;
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        objArr3 = objArr2;
                        i5 = i;
                    }
                    objArr = objArr3;
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    objArr = objArr3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                objArr3 = objArr;
            }
            sbM1174t.append(postfix);
        } else {
            sbM1174t.append(postfix);
        }
        String string = sbM1174t.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @PublishedApi
    public static /* synthetic */ void getKeys$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated, @NotNull Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
        Object[] objArr;
        Object[] objArr2;
        CharSequence separator2 = separator;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        StringBuilder sbM779u = AbstractC0541b.m779u(truncated, "truncated", transform, "transform", prefix);
        Object[] objArr3 = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                int i4 = i;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i4 << 3) + i6;
                            Object obj = objArr3[i7];
                            int i8 = iArr[i7];
                            objArr2 = objArr3;
                            if (i2 == limit) {
                                sbM779u.append(truncated);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sbM779u.append(separator2);
                            }
                            sbM779u.append(transform.invoke(obj, Integer.valueOf(i8)));
                            i2++;
                        } else {
                            objArr2 = objArr3;
                        }
                        j >>= 8;
                        i6++;
                        separator2 = separator;
                        objArr3 = objArr2;
                    }
                    objArr = objArr3;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr3;
                }
                if (i4 == length) {
                    break;
                }
                i = i4 + 1;
                separator2 = separator;
                objArr3 = objArr;
            }
            sbM779u.append(postfix);
        } else {
            sbM779u.append(postfix);
        }
        String string = sbM779u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008d A[PHI: r11
      0x008d: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003e, B:20:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, int i, @NotNull Function2<? super K, ? super Integer, ? extends CharSequence> function2) {
        int i2;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence, "postfix", function2, "transform", prefix);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i4 = 0;
            int i5 = 0;
            loop0: while (true) {
                long j = jArr[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i4 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j & 255) < 128) {
                            int i9 = (i4 << 3) + i8;
                            i2 = i6;
                            Object obj = objArr[i9];
                            int i10 = iArr[i9];
                            if (i5 == i) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i5 != 0) {
                                sbM779u.append(separator);
                            }
                            sbM779u.append(function2.invoke(obj, Integer.valueOf(i10)));
                            i5++;
                        } else {
                            i2 = i6;
                        }
                        j >>= i2;
                        i8++;
                        i6 = i2;
                    }
                    if (i7 != i6) {
                        break;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                }
            }
            sbM779u.append(charSequence);
        } else {
            sbM779u.append(charSequence);
        }
        String string = sbM779u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008c A[PHI: r11
      0x008c: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003e, B:20:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, @NotNull Function2<? super K, ? super Integer, ? extends CharSequence> function2) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence, "postfix", function2, "transform", prefix);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            i = i5;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            if (i4 == -1) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM779u.append(separator);
                            }
                            sbM779u.append(function2.invoke(obj, Integer.valueOf(i9)));
                            i4++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sbM779u.append(charSequence);
        } else {
            sbM779u.append(charSequence);
        }
        String string = sbM779u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[PHI: r10
      0x007f: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0033, B:20:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence charSequence, @NotNull Function2<? super K, ? super Integer, ? extends CharSequence> function2) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence, "prefix", function2, "transform", charSequence);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            i = i5;
                            if (i4 == -1) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM779u.append(separator);
                            }
                            sbM779u.append(function2.invoke(obj, Integer.valueOf(i9)));
                            i4++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sbM779u.append((CharSequence) "");
        } else {
            sbM779u.append((CharSequence) "");
        }
        String string = sbM779u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085 A[PHI: r11
      0x0085: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0037, B:20:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            i = i5;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            if (i4 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(obj, Integer.valueOf(i9)));
                            i4++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append((CharSequence) "");
        } else {
            sb.append((CharSequence) "");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[PHI: r10
      0x007a: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x002c, B:20:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull Function2<? super K, ? super Integer, ? extends CharSequence> transform) {
        int i;
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            i = i5;
                            if (i4 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb.append((CharSequence) SQLKeyword.COMMA);
                            }
                            sb.append(transform.invoke(obj, Integer.valueOf(i9)));
                            i4++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append((CharSequence) "");
        } else {
            sb.append((CharSequence) "");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
