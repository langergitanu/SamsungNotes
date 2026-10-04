package androidx.collection;

import androidx.appcompat.widget.AbstractC0541b;
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
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J&\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0006\u0010\u001a\u001a\u00020\u0016J&\u0010\u001a\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0011\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0004H\u0086\u0002J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0004J&\u0010 \u001a\u00020\u00042\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0013\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0001JD\u0010$\u001a\u00020%26\u0010&\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020%0\u0018H\u0086\bø\u0001\u0000J/\u0010)\u001a\u00020%2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020%0*H\u0081\bø\u0001\u0000J/\u0010,\u001a\u00020%2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020%0*H\u0086\bø\u0001\u0000J/\u0010-\u001a\u00020%2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020%0*H\u0086\bø\u0001\u0000J\u0011\u0010.\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0004H\u0086\u0002J\u0016\u0010/\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0019J\"\u00101\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001902H\u0086\bø\u0001\u0000J\b\u00103\u001a\u00020\u0004H\u0016J\u0006\u00104\u001a\u00020\u0016J\u0006\u00105\u001a\u00020\u0016J:\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u00020\u00042\b\b\u0002\u0010=\u001a\u000209H\u0007Jx\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u00020\u00042\b\b\u0002\u0010=\u001a\u00020928\b\u0004\u0010>\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002090\u0018H\u0087\bø\u0001\u0000J\u0006\u0010?\u001a\u00020\u0016J\b\u0010@\u001a\u000207H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0018\u0010\u0006\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0018\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002R\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0018\u0010\u0013\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u0082\u0001\u0001A\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006B"}, m13886d2 = {"Landroidx/collection/IntLongMap;", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "getCapacity", "()I", "keys", "", "getKeys$annotations", GroupContract.Group.META_DATA, "", "getMetadata$annotations", "size", "getSize", "values", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableIntLongMap;", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIntLongMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntLongMap.kt\nandroidx/collection/IntLongMap\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 3 IntSet.kt\nandroidx/collection/IntSetKt\n*L\n1#1,1131:1\n358#1,6:1134\n368#1,3:1141\n371#1,9:1145\n358#1,6:1154\n368#1,3:1161\n371#1,9:1165\n358#1,6:1174\n368#1,3:1181\n371#1,9:1185\n386#1,4:1194\n358#1,6:1198\n368#1,3:1205\n371#1,2:1209\n390#1,2:1211\n374#1,6:1213\n392#1:1219\n386#1,4:1220\n358#1,6:1224\n368#1,3:1231\n371#1,2:1235\n390#1,2:1237\n374#1,6:1239\n392#1:1245\n386#1,4:1246\n358#1,6:1250\n368#1,3:1257\n371#1,2:1261\n390#1,2:1263\n374#1,6:1265\n392#1:1271\n411#1,3:1272\n358#1,6:1275\n368#1,3:1282\n371#1,2:1286\n414#1,2:1288\n374#1,6:1290\n416#1:1296\n386#1,4:1297\n358#1,6:1301\n368#1,3:1308\n371#1,2:1312\n390#1,2:1314\n374#1,6:1316\n392#1:1322\n386#1,4:1323\n358#1,6:1327\n368#1,3:1334\n371#1,2:1338\n390#1,2:1340\n374#1,6:1342\n392#1:1348\n386#1,4:1349\n358#1,6:1353\n368#1,3:1360\n371#1,2:1364\n390#1,2:1366\n374#1,6:1368\n392#1:1374\n386#1,4:1375\n358#1,6:1379\n368#1,3:1386\n371#1,2:1390\n390#1,2:1392\n374#1,6:1394\n392#1:1400\n386#1,4:1401\n358#1,6:1405\n368#1,3:1412\n371#1,2:1416\n390#1,2:1418\n374#1,6:1420\n392#1:1426\n386#1,4:1427\n358#1,6:1431\n368#1,3:1438\n371#1,2:1442\n390#1,2:1444\n374#1,6:1446\n392#1:1452\n520#1,11:1469\n386#1,4:1480\n358#1,6:1484\n368#1,3:1491\n371#1,2:1495\n390#1:1497\n531#1,10:1498\n391#1:1508\n374#1,6:1509\n392#1:1515\n541#1,2:1516\n520#1,11:1518\n386#1,4:1529\n358#1,6:1533\n368#1,3:1540\n371#1,2:1544\n390#1:1546\n531#1,10:1547\n391#1:1557\n374#1,6:1558\n392#1:1564\n541#1,2:1565\n520#1,11:1567\n386#1,4:1578\n358#1,6:1582\n368#1,3:1589\n371#1,2:1593\n390#1:1595\n531#1,10:1596\n391#1:1606\n374#1,6:1607\n392#1:1613\n541#1,2:1614\n520#1,11:1616\n386#1,4:1627\n358#1,6:1631\n368#1,3:1638\n371#1,2:1642\n390#1:1644\n531#1,10:1645\n391#1:1655\n374#1,6:1656\n392#1:1662\n541#1,2:1663\n520#1,11:1665\n386#1,4:1676\n358#1,6:1680\n368#1,3:1687\n371#1,2:1691\n390#1:1693\n531#1,10:1694\n391#1:1704\n374#1,6:1705\n392#1:1711\n541#1,2:1712\n1956#2:1132\n1820#2:1133\n1956#2:1140\n1820#2:1144\n1956#2:1160\n1820#2:1164\n1956#2:1180\n1820#2:1184\n1956#2:1204\n1820#2:1208\n1956#2:1230\n1820#2:1234\n1956#2:1256\n1820#2:1260\n1956#2:1281\n1820#2:1285\n1956#2:1307\n1820#2:1311\n1956#2:1333\n1820#2:1337\n1956#2:1359\n1820#2:1363\n1956#2:1385\n1820#2:1389\n1956#2:1411\n1820#2:1415\n1956#2:1437\n1820#2:1441\n1728#2:1456\n1724#2:1457\n1925#2,3:1458\n1939#2,3:1461\n1865#2:1464\n1853#2:1465\n1847#2:1466\n1860#2:1467\n1948#2:1468\n1956#2:1490\n1820#2:1494\n1956#2:1539\n1820#2:1543\n1956#2:1588\n1820#2:1592\n1956#2:1637\n1820#2:1641\n1956#2:1686\n1820#2:1690\n921#3,3:1453\n*S KotlinDebug\n*F\n+ 1 IntLongMap.kt\nandroidx/collection/IntLongMap\n*L\n389#1:1134,6\n389#1:1141,3\n389#1:1145,9\n401#1:1154,6\n401#1:1161,3\n401#1:1165,9\n413#1:1174,6\n413#1:1181,3\n413#1:1185,9\n422#1:1194,4\n422#1:1198,6\n422#1:1205,3\n422#1:1209,2\n422#1:1211,2\n422#1:1213,6\n422#1:1219\n432#1:1220,4\n432#1:1224,6\n432#1:1231,3\n432#1:1235,2\n432#1:1237,2\n432#1:1239,6\n432#1:1245\n448#1:1246,4\n448#1:1250,6\n448#1:1257,3\n448#1:1261,2\n448#1:1263,2\n448#1:1265,6\n448#1:1271\n471#1:1272,3\n471#1:1275,6\n471#1:1282,3\n471#1:1286,2\n471#1:1288,2\n471#1:1290,6\n471#1:1296\n495#1:1297,4\n495#1:1301,6\n495#1:1308,3\n495#1:1312,2\n495#1:1314,2\n495#1:1316,6\n495#1:1322\n530#1:1323,4\n530#1:1327,6\n530#1:1334,3\n530#1:1338,2\n530#1:1340,2\n530#1:1342,6\n530#1:1348\n530#1:1349,4\n530#1:1353,6\n530#1:1360,3\n530#1:1364,2\n530#1:1366,2\n530#1:1368,6\n530#1:1374\n551#1:1375,4\n551#1:1379,6\n551#1:1386,3\n551#1:1390,2\n551#1:1392,2\n551#1:1394,6\n551#1:1400\n577#1:1401,4\n577#1:1405,6\n577#1:1412,3\n577#1:1416,2\n577#1:1418,2\n577#1:1420,6\n577#1:1426\n599#1:1427,4\n599#1:1431,6\n599#1:1438,3\n599#1:1442,2\n599#1:1444,2\n599#1:1446,6\n599#1:1452\n-1#1:1469,11\n-1#1:1480,4\n-1#1:1484,6\n-1#1:1491,3\n-1#1:1495,2\n-1#1:1497\n-1#1:1498,10\n-1#1:1508\n-1#1:1509,6\n-1#1:1515\n-1#1:1516,2\n-1#1:1518,11\n-1#1:1529,4\n-1#1:1533,6\n-1#1:1540,3\n-1#1:1544,2\n-1#1:1546\n-1#1:1547,10\n-1#1:1557\n-1#1:1558,6\n-1#1:1564\n-1#1:1565,2\n-1#1:1567,11\n-1#1:1578,4\n-1#1:1582,6\n-1#1:1589,3\n-1#1:1593,2\n-1#1:1595\n-1#1:1596,10\n-1#1:1606\n-1#1:1607,6\n-1#1:1613\n-1#1:1614,2\n-1#1:1616,11\n-1#1:1627,4\n-1#1:1631,6\n-1#1:1638,3\n-1#1:1642,2\n-1#1:1644\n-1#1:1645,10\n-1#1:1655\n-1#1:1656,6\n-1#1:1662\n-1#1:1663,2\n-1#1:1665,11\n-1#1:1676,4\n-1#1:1680,6\n-1#1:1687,3\n-1#1:1691,2\n-1#1:1693\n-1#1:1694,10\n-1#1:1704\n-1#1:1705,6\n-1#1:1711\n-1#1:1712,2\n363#1:1132\n370#1:1133\n389#1:1140\n389#1:1144\n401#1:1160\n401#1:1164\n413#1:1180\n413#1:1184\n422#1:1204\n422#1:1208\n432#1:1230\n432#1:1234\n448#1:1256\n448#1:1260\n471#1:1281\n471#1:1285\n495#1:1307\n495#1:1311\n530#1:1333\n530#1:1337\n530#1:1359\n530#1:1363\n551#1:1385\n551#1:1389\n577#1:1411\n577#1:1415\n599#1:1437\n599#1:1441\n619#1:1456\n622#1:1457\n626#1:1458,3\n627#1:1461,3\n628#1:1464\n629#1:1465\n629#1:1466\n633#1:1467\n636#1:1468\n-1#1:1490\n-1#1:1494\n-1#1:1539\n-1#1:1543\n-1#1:1588\n-1#1:1592\n-1#1:1637\n-1#1:1641\n-1#1:1686\n-1#1:1690\n618#1:1453,3\n*E\n"})
public abstract class IntLongMap {

    @JvmField
    public int _capacity;

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public int[] keys;

    @JvmField
    @NotNull
    public long[] metadata;

    @JvmField
    @NotNull
    public long[] values;

    public /* synthetic */ IntLongMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
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
        return intLongMap.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final boolean all(@NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        if (!predicate.invoke(Integer.valueOf(iArr[i5]), Long.valueOf(jArr[i5])).booleanValue()) {
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

    public final boolean contains(int key) {
        return findKeyIndex(key) >= 0;
    }

    public final boolean containsKey(int key) {
        return findKeyIndex(key) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsValue(long value) {
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr2[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128 && value == jArr[(i << 3) + i4]) {
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

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof IntLongMap)) {
            return false;
        }
        IntLongMap intLongMap = (IntLongMap) other;
        if (intLongMap.get_size() != get_size()) {
            return false;
        }
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr2[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            if (jArr[i5] != intLongMap.get(iArr[i5])) {
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
    public final int findKeyIndex(int key) {
        int iHashCode = Integer.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i4 = this._capacity;
        int i5 = (i >>> 7) & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (((long) i2) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
    }

    public final void forEach(@NotNull Function2<? super Integer, ? super Long, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        block.invoke(Integer.valueOf(iArr[i5]), Long.valueOf(jArr[i5]));
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

    public final void forEachKey(@NotNull Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int[] iArr = this.keys;
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

    public final void forEachValue(@NotNull Function1<? super Long, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        block.invoke(Long.valueOf(jArr[(i << 3) + i4]));
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

    public final long get(int key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        throw new NoSuchElementException(AbstractC0000a.m11h(key, "Cannot find value for key "));
    }

    /* JADX INFO: renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    public final long getOrDefault(int key, long defaultValue) {
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : defaultValue;
    }

    public final long getOrElse(int key, @NotNull Function0<Long> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex < 0 ? defaultValue.invoke().longValue() : this.values[iFindKeyIndex];
    }

    /* JADX INFO: renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        iHashCode += Integer.hashCode(iArr[i5]) ^ Long.hashCode(jArr[i5]);
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

    @NotNull
    public String toString() {
        int i;
        int i2;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(Parse.BRACKET_LCB);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                long j = jArr2[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((255 & j) < 128) {
                            int i8 = (i4 << 3) + i7;
                            int i9 = iArr[i8];
                            i2 = i4;
                            long j2 = jArr[i8];
                            sb.append(i9);
                            sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                            sb.append(j2);
                            i5++;
                            if (i5 < this._size) {
                                sb.append(SQLKeyword.COMMA);
                            }
                        } else {
                            i2 = i4;
                        }
                        j >>= 8;
                        i7++;
                        i4 = i2;
                    }
                    int i10 = i4;
                    if (i6 != 8) {
                        break;
                    }
                    i = i10;
                } else {
                    i = i4;
                }
                if (i == length) {
                    break;
                }
                i4 = i + 1;
            }
        }
        return AbstractC0541b.m766h('}', "s.append('}').toString()", sb);
    }

    private IntLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean any(@NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr2[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            if (predicate.invoke(Integer.valueOf(iArr[i5]), Long.valueOf(jArr[i5])).booleanValue()) {
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

    public final int count(@NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j) < 128) {
                        int i6 = (i << 3) + i5;
                        if (predicate.invoke(Integer.valueOf(iArr[i6]), Long.valueOf(jArr[i6])).booleanValue()) {
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

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 function2, int i2, Object obj) {
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
            int[] iArr = intLongMap.keys;
            long[] jArr3 = intLongMap.values;
            long[] jArr4 = intLongMap.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i6 = 0;
                int i7 = 0;
                loop0: while (true) {
                    long j = jArr4[i6];
                    int i8 = i6;
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i9 = 8;
                        int i10 = 8 - ((~(i8 - length)) >>> 31);
                        int i11 = 0;
                        while (i11 < i10) {
                            if ((j & 255) < 128) {
                                int i12 = (i8 << 3) + i11;
                                int i13 = iArr[i12];
                                long j2 = jArr3[i12];
                                if (i7 == i5) {
                                    sbM779u.append(charSequence5);
                                    break loop0;
                                }
                                if (i7 != 0) {
                                    sbM779u.append(separator);
                                }
                                i4 = i9;
                                jArr2 = jArr4;
                                sbM779u.append((CharSequence) function2.invoke(Integer.valueOf(i13), Long.valueOf(j2)));
                                i7++;
                            } else {
                                jArr2 = jArr4;
                                i4 = i9;
                            }
                            j >>= i4;
                            i11++;
                            i9 = i4;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        if (i10 != i9) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    if (i8 == length) {
                        break;
                    }
                    i6 = i8 + 1;
                    jArr4 = jArr;
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
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM1174t = AbstractC0622a.m1174t(postfix, "postfix", truncated, "truncated", prefix);
        int[] iArr3 = this.keys;
        long[] jArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr4[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            i = i5;
                            int i9 = iArr3[i8];
                            iArr2 = iArr3;
                            jArr2 = jArr3;
                            long j2 = jArr2[i8];
                            if (i4 == limit) {
                                sbM1174t.append(truncated);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM1174t.append(separator);
                            }
                            sbM1174t.append(i9);
                            sbM1174t.append('=');
                            sbM1174t.append(j2);
                            i4++;
                        } else {
                            iArr2 = iArr3;
                            jArr2 = jArr3;
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                        iArr3 = iArr2;
                        jArr3 = jArr2;
                    }
                    iArr = iArr3;
                    jArr = jArr3;
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                    jArr = jArr3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                iArr3 = iArr;
                jArr3 = jArr;
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0096 A[PHI: r12
      0x0096: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0047, B:19:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        CharSequence separator2 = separator;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        StringBuilder sbM779u = AbstractC0541b.m779u(truncated, "truncated", transform, "transform", prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr2[i];
                int i4 = i;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i4 << 3) + i6;
                            int i8 = iArr[i7];
                            long j2 = jArr[i7];
                            if (i2 == limit) {
                                sbM779u.append(truncated);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sbM779u.append(separator2);
                            }
                            sbM779u.append(transform.invoke(Integer.valueOf(i8), Long.valueOf(j2)));
                            i2++;
                        }
                        j >>= 8;
                        i6++;
                        separator2 = separator;
                    }
                    if (i5 != 8) {
                        break;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i = i4 + 1;
                    separator2 = separator;
                }
            }
            sbM779u.append(postfix);
        } else {
            sbM779u.append(postfix);
        }
        String string = sbM779u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, @NotNull CharSequence charSequence2, int i, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> function2) {
        int i2;
        CharSequence separator = charSequence;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence2, "postfix", function2, "transform", prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i4 = 0;
            int i5 = 0;
            loop0: while (true) {
                long j = jArr2[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i4 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j & 255) < 128) {
                            int i9 = (i4 << 3) + i8;
                            int i10 = iArr[i9];
                            long j2 = jArr[i9];
                            i2 = i6;
                            if (i5 == i) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i5 != 0) {
                                sbM779u.append(separator);
                            }
                            sbM779u.append(function2.invoke(Integer.valueOf(i10), Long.valueOf(j2)));
                            i5++;
                        } else {
                            i2 = i6;
                        }
                        j >>= i2;
                        i8++;
                        separator = charSequence;
                        i6 = i2;
                    }
                    if (i7 != i6) {
                        break;
                    }
                }
                if (i4 == length) {
                    break;
                }
                i4++;
                separator = charSequence;
            }
            sbM779u.append(charSequence2);
        } else {
            sbM779u.append(charSequence2);
        }
        String string = sbM779u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0090 A[PHI: r11
      0x0090: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003e, B:20:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> function2) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence, "postfix", function2, "transform", prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr2[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            int i9 = iArr[i8];
                            long j2 = jArr[i8];
                            i = i5;
                            if (i4 == -1) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM779u.append(separator);
                            }
                            sbM779u.append(function2.invoke(Integer.valueOf(i9), Long.valueOf(j2)));
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[PHI: r10
      0x0083: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0033, B:20:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> function2) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence, "prefix", function2, "transform", charSequence);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr2[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            int i9 = iArr[i8];
                            long j2 = jArr[i8];
                            if (i4 == -1) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM779u.append(separator);
                            }
                            i = i5;
                            sbM779u.append(function2.invoke(Integer.valueOf(i9), Long.valueOf(j2)));
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x0089 A[PHI: r11
      0x0089: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0037, B:20:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr2[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            int i9 = iArr[i8];
                            long j2 = jArr[i8];
                            i = i5;
                            if (i4 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(Integer.valueOf(i9), Long.valueOf(j2)));
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[PHI: r10
      0x007e: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x002c, B:20:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        int i;
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr2[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i2 << 3) + i7;
                            int i9 = iArr[i8];
                            long j2 = jArr[i8];
                            if (i4 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb.append((CharSequence) SQLKeyword.COMMA);
                            }
                            Integer numValueOf = Integer.valueOf(i9);
                            i = i5;
                            sb.append(transform.invoke(numValueOf, Long.valueOf(j2)));
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
