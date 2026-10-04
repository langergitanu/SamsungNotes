package androidx.collection;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
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
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0006\u0010\u001c\u001a\u00020\u0019J&\u0010\u001c\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0011\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0005J\u0013\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0080\b¢\u0006\u0002\b'JD\u0010(\u001a\u00020)26\u0010*\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020)0\u001bH\u0086\bø\u0001\u0000J/\u0010-\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020)0.H\u0081\bø\u0001\u0000J/\u00100\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J/\u00101\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J\u0018\u00102\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0002\u00103J\u001b\u00104\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00105\u001a\u00028\u0000¢\u0006\u0002\u00106J'\u00107\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000008H\u0086\bø\u0001\u0000¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u0005H\u0016J\u0006\u0010;\u001a\u00020\u0019J\u0006\u0010<\u001a\u00020\u0019J:\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020@2\b\b\u0002\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020@H\u0007Jx\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020@2\b\b\u0002\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020@28\b\u0004\u0010E\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020@0\u001bH\u0087\bø\u0001\u0000J\u0006\u0010F\u001a\u00020\u0019J\b\u0010G\u001a\u00020>H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u0018\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u0017\u0012\u0004\b\u0016\u0010\u0003\u0082\u0001\u0001H\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, m13886d2 = {"Landroidx/collection/IntObjectMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "getCapacity", "()I", "keys", "", "getKeys$annotations", GroupContract.Group.META_DATA, "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "all", "", "predicate", "Lkotlin/Function2;", "any", "contains", "key", "containsKey", "containsValue", "value", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findKeyIndex", "findKeyIndex$collection", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(I)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableIntObjectMap;", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIntObjectMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntObjectMap.kt\nandroidx/collection/IntObjectMap\n+ 2 IntSet.kt\nandroidx/collection/IntSetKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1118:1\n620#1:1119\n621#1:1123\n623#1,2:1125\n625#1,4:1128\n629#1:1135\n630#1:1139\n631#1:1141\n632#1,4:1144\n638#1:1149\n639#1,8:1151\n620#1:1159\n621#1:1163\n623#1,2:1165\n625#1,4:1168\n629#1:1175\n630#1:1179\n631#1:1181\n632#1,4:1184\n638#1:1189\n639#1,8:1191\n355#1,6:1201\n365#1,3:1208\n368#1,9:1212\n355#1,6:1221\n365#1,3:1228\n368#1,9:1232\n355#1,6:1241\n365#1,3:1248\n368#1,9:1252\n383#1,4:1261\n355#1,6:1265\n365#1,3:1272\n368#1,2:1276\n388#1,2:1278\n371#1,6:1280\n390#1:1286\n383#1,4:1287\n355#1,6:1291\n365#1,3:1298\n368#1,2:1302\n388#1,2:1304\n371#1,6:1306\n390#1:1312\n383#1,4:1313\n355#1,6:1317\n365#1,3:1324\n368#1,2:1328\n388#1,2:1330\n371#1,6:1332\n390#1:1338\n620#1:1339\n621#1:1343\n623#1,2:1345\n625#1,4:1348\n629#1:1355\n630#1:1359\n631#1:1361\n632#1,4:1364\n638#1:1369\n639#1,8:1371\n620#1:1379\n621#1:1383\n623#1,2:1385\n625#1,4:1388\n629#1:1395\n630#1:1399\n631#1:1401\n632#1,4:1404\n638#1:1409\n639#1,8:1411\n409#1,3:1419\n355#1,6:1422\n365#1,3:1429\n368#1,2:1433\n413#1,2:1435\n371#1,6:1437\n415#1:1443\n383#1,4:1444\n355#1,6:1448\n365#1,3:1455\n368#1,2:1459\n388#1,2:1461\n371#1,6:1463\n390#1:1469\n383#1,4:1470\n355#1,6:1474\n365#1,3:1481\n368#1,2:1485\n388#1,2:1487\n371#1,6:1489\n390#1:1495\n383#1,4:1496\n355#1,6:1500\n365#1,3:1507\n368#1,2:1511\n388#1,2:1513\n371#1,6:1515\n390#1:1521\n383#1,4:1522\n355#1,6:1526\n365#1,3:1533\n368#1,2:1537\n388#1,2:1539\n371#1,6:1541\n390#1:1547\n383#1,4:1548\n355#1,6:1552\n365#1,3:1559\n368#1,2:1563\n388#1,2:1565\n371#1,6:1567\n390#1:1573\n383#1,4:1574\n355#1,6:1578\n365#1,3:1585\n368#1,2:1589\n388#1,2:1591\n371#1,6:1593\n390#1:1599\n519#1,11:1616\n383#1,4:1627\n355#1,6:1631\n365#1,3:1638\n368#1,2:1642\n388#1:1644\n530#1,10:1645\n389#1:1655\n371#1,6:1656\n390#1:1662\n540#1,2:1663\n519#1,11:1665\n383#1,4:1676\n355#1,6:1680\n365#1,3:1687\n368#1,2:1691\n388#1:1693\n530#1,10:1694\n389#1:1704\n371#1,6:1705\n390#1:1711\n540#1,2:1712\n519#1,11:1714\n383#1,4:1725\n355#1,6:1729\n365#1,3:1736\n368#1,2:1740\n388#1:1742\n530#1,10:1743\n389#1:1753\n371#1,6:1754\n390#1:1760\n540#1,2:1761\n519#1,11:1763\n383#1,4:1774\n355#1,6:1778\n365#1,3:1785\n368#1,2:1789\n388#1:1791\n530#1,10:1792\n389#1:1802\n371#1,6:1803\n390#1:1809\n540#1,2:1810\n519#1,11:1812\n383#1,4:1823\n355#1,6:1827\n365#1,3:1834\n368#1,2:1838\n388#1:1840\n530#1,10:1841\n389#1:1851\n371#1,6:1852\n390#1:1858\n540#1,2:1859\n921#2,3:1120\n921#2,3:1160\n921#2,3:1340\n921#2,3:1380\n921#2,3:1600\n1728#3:1124\n1724#3:1127\n1925#3,3:1132\n1939#3,3:1136\n1865#3:1140\n1853#3:1142\n1847#3:1143\n1860#3:1148\n1948#3:1150\n1728#3:1164\n1724#3:1167\n1925#3,3:1172\n1939#3,3:1176\n1865#3:1180\n1853#3:1182\n1847#3:1183\n1860#3:1188\n1948#3:1190\n1956#3:1199\n1820#3:1200\n1956#3:1207\n1820#3:1211\n1956#3:1227\n1820#3:1231\n1956#3:1247\n1820#3:1251\n1956#3:1271\n1820#3:1275\n1956#3:1297\n1820#3:1301\n1956#3:1323\n1820#3:1327\n1728#3:1344\n1724#3:1347\n1925#3,3:1352\n1939#3,3:1356\n1865#3:1360\n1853#3:1362\n1847#3:1363\n1860#3:1368\n1948#3:1370\n1728#3:1384\n1724#3:1387\n1925#3,3:1392\n1939#3,3:1396\n1865#3:1400\n1853#3:1402\n1847#3:1403\n1860#3:1408\n1948#3:1410\n1956#3:1428\n1820#3:1432\n1956#3:1454\n1820#3:1458\n1956#3:1480\n1820#3:1484\n1956#3:1506\n1820#3:1510\n1956#3:1532\n1820#3:1536\n1956#3:1558\n1820#3:1562\n1956#3:1584\n1820#3:1588\n1728#3:1603\n1724#3:1604\n1925#3,3:1605\n1939#3,3:1608\n1865#3:1611\n1853#3:1612\n1847#3:1613\n1860#3:1614\n1948#3:1615\n1956#3:1637\n1820#3:1641\n1956#3:1686\n1820#3:1690\n1956#3:1735\n1820#3:1739\n1956#3:1784\n1820#3:1788\n1956#3:1833\n1820#3:1837\n*S KotlinDebug\n*F\n+ 1 IntObjectMap.kt\nandroidx/collection/IntObjectMap\n*L\n322#1:1119\n322#1:1123\n322#1:1125,2\n322#1:1128,4\n322#1:1135\n322#1:1139\n322#1:1141\n322#1:1144,4\n322#1:1149\n322#1:1151,8\n332#1:1159\n332#1:1163\n332#1:1165,2\n332#1:1168,4\n332#1:1175\n332#1:1179\n332#1:1181\n332#1:1184,4\n332#1:1189\n332#1:1191,8\n386#1:1201,6\n386#1:1208,3\n386#1:1212,9\n399#1:1221,6\n399#1:1228,3\n399#1:1232,9\n411#1:1241,6\n411#1:1248,3\n411#1:1252,9\n421#1:1261,4\n421#1:1265,6\n421#1:1272,3\n421#1:1276,2\n421#1:1278,2\n421#1:1280,6\n421#1:1286\n431#1:1287,4\n431#1:1291,6\n431#1:1298,3\n431#1:1302,2\n431#1:1304,2\n431#1:1306,6\n431#1:1312\n447#1:1313,4\n447#1:1317,6\n447#1:1324,3\n447#1:1328,2\n447#1:1330,2\n447#1:1332,6\n447#1:1338\n457#1:1339\n457#1:1343\n457#1:1345,2\n457#1:1348,4\n457#1:1355\n457#1:1359\n457#1:1361\n457#1:1364,4\n457#1:1369\n457#1:1371,8\n463#1:1379\n463#1:1383\n463#1:1385,2\n463#1:1388,4\n463#1:1395\n463#1:1399\n463#1:1401\n463#1:1404,4\n463#1:1409\n463#1:1411,8\n470#1:1419,3\n470#1:1422,6\n470#1:1429,3\n470#1:1433,2\n470#1:1435,2\n470#1:1437,6\n470#1:1443\n494#1:1444,4\n494#1:1448,6\n494#1:1455,3\n494#1:1459,2\n494#1:1461,2\n494#1:1463,6\n494#1:1469\n529#1:1470,4\n529#1:1474,6\n529#1:1481,3\n529#1:1485,2\n529#1:1487,2\n529#1:1489,6\n529#1:1495\n529#1:1496,4\n529#1:1500,6\n529#1:1507,3\n529#1:1511,2\n529#1:1513,2\n529#1:1515,6\n529#1:1521\n550#1:1522,4\n550#1:1526,6\n550#1:1533,3\n550#1:1537,2\n550#1:1539,2\n550#1:1541,6\n550#1:1547\n576#1:1548,4\n576#1:1552,6\n576#1:1559,3\n576#1:1563,2\n576#1:1565,2\n576#1:1567,6\n576#1:1573\n602#1:1574,4\n602#1:1578,6\n602#1:1585,3\n602#1:1589,2\n602#1:1591,2\n602#1:1593,6\n602#1:1599\n-1#1:1616,11\n-1#1:1627,4\n-1#1:1631,6\n-1#1:1638,3\n-1#1:1642,2\n-1#1:1644\n-1#1:1645,10\n-1#1:1655\n-1#1:1656,6\n-1#1:1662\n-1#1:1663,2\n-1#1:1665,11\n-1#1:1676,4\n-1#1:1680,6\n-1#1:1687,3\n-1#1:1691,2\n-1#1:1693\n-1#1:1694,10\n-1#1:1704\n-1#1:1705,6\n-1#1:1711\n-1#1:1712,2\n-1#1:1714,11\n-1#1:1725,4\n-1#1:1729,6\n-1#1:1736,3\n-1#1:1740,2\n-1#1:1742\n-1#1:1743,10\n-1#1:1753\n-1#1:1754,6\n-1#1:1760\n-1#1:1761,2\n-1#1:1763,11\n-1#1:1774,4\n-1#1:1778,6\n-1#1:1785,3\n-1#1:1789,2\n-1#1:1791\n-1#1:1792,10\n-1#1:1802\n-1#1:1803,6\n-1#1:1809\n-1#1:1810,2\n-1#1:1812,11\n-1#1:1823,4\n-1#1:1827,6\n-1#1:1834,3\n-1#1:1838,2\n-1#1:1840\n-1#1:1841,10\n-1#1:1851\n-1#1:1852,6\n-1#1:1858\n-1#1:1859,2\n322#1:1120,3\n332#1:1160,3\n457#1:1340,3\n463#1:1380,3\n620#1:1600,3\n322#1:1124\n322#1:1127\n322#1:1132,3\n322#1:1136,3\n322#1:1140\n322#1:1142\n322#1:1143\n322#1:1148\n322#1:1150\n332#1:1164\n332#1:1167\n332#1:1172,3\n332#1:1176,3\n332#1:1180\n332#1:1182\n332#1:1183\n332#1:1188\n332#1:1190\n360#1:1199\n367#1:1200\n386#1:1207\n386#1:1211\n399#1:1227\n399#1:1231\n411#1:1247\n411#1:1251\n421#1:1271\n421#1:1275\n431#1:1297\n431#1:1301\n447#1:1323\n447#1:1327\n457#1:1344\n457#1:1347\n457#1:1352,3\n457#1:1356,3\n457#1:1360\n457#1:1362\n457#1:1363\n457#1:1368\n457#1:1370\n463#1:1384\n463#1:1387\n463#1:1392,3\n463#1:1396,3\n463#1:1400\n463#1:1402\n463#1:1403\n463#1:1408\n463#1:1410\n470#1:1428\n470#1:1432\n494#1:1454\n494#1:1458\n529#1:1480\n529#1:1484\n529#1:1506\n529#1:1510\n550#1:1532\n550#1:1536\n576#1:1558\n576#1:1562\n602#1:1584\n602#1:1588\n621#1:1603\n624#1:1604\n628#1:1605,3\n629#1:1608,3\n630#1:1611\n631#1:1612\n631#1:1613\n635#1:1614\n638#1:1615\n-1#1:1637\n-1#1:1641\n-1#1:1686\n-1#1:1690\n-1#1:1735\n-1#1:1739\n-1#1:1784\n-1#1:1788\n-1#1:1833\n-1#1:1837\n*E\n"})
public abstract class IntObjectMap<V> {

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
    public Object[] values;

    public /* synthetic */ IntObjectMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String joinToString$default(IntObjectMap intObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
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
        return intObjectMap.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final boolean all(@NotNull Function2<? super Integer, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                        if (!predicate.invoke(Integer.valueOf(iArr[i5]), objArr[i5]).booleanValue()) {
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0069, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean contains(int key) {
        int iNumberOfTrailingZeros;
        int iHashCode = Integer.hashCode(key) * ScatterMapKt.MurmurHashC1;
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
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        return iNumberOfTrailingZeros >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0069, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsKey(int key) {
        int iNumberOfTrailingZeros;
        int iHashCode = Integer.hashCode(key) * ScatterMapKt.MurmurHashC1;
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
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        return iNumberOfTrailingZeros >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsValue(V value) {
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128 && Intrinsics.areEqual(value, objArr[(i << 3) + i4])) {
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

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof IntObjectMap)) {
            return false;
        }
        IntObjectMap intObjectMap = (IntObjectMap) other;
        if (intObjectMap.get_size() != get_size()) {
            return false;
        }
        int[] iArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr[i5];
                            Object obj = objArr[i5];
                            if (obj == null) {
                                if (intObjectMap.get(i6) != null || !intObjectMap.containsKey(i6)) {
                                    break loop0;
                                }
                            } else if (!Intrinsics.areEqual(obj, intObjectMap.get(i6))) {
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

    public final int findKeyIndex$collection(int key) {
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

    public final void forEach(@NotNull Function2<? super Integer, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                        block.invoke(Integer.valueOf(iArr[i5]), objArr[i5]);
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

    public final void forEachValue(@NotNull Function1<? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.values;
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0063, code lost:
    
        r10 = -1;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V get(int key) {
        int iNumberOfTrailingZeros;
        int iHashCode = Integer.hashCode(key) * ScatterMapKt.MurmurHashC1;
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
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        if (iNumberOfTrailingZeros >= 0) {
            return (V) this.values[iNumberOfTrailingZeros];
        }
        return null;
    }

    /* JADX INFO: renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0063, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V getOrDefault(int key, V defaultValue) {
        int iNumberOfTrailingZeros;
        int iHashCode = Integer.hashCode(key) * ScatterMapKt.MurmurHashC1;
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
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        return iNumberOfTrailingZeros >= 0 ? (V) this.values[iNumberOfTrailingZeros] : defaultValue;
    }

    public final V getOrElse(int key, @NotNull Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = get(key);
        return v == null ? defaultValue.invoke() : v;
    }

    /* JADX INFO: renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                        int i6 = iArr[i5];
                        Object obj = objArr[i5];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ Integer.hashCode(i6);
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
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i7 = iArr[i6];
                            Object obj = objArr[i6];
                            sb.append(i7);
                            sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
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

    private IntObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean any(@NotNull Function2<? super Integer, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            if (predicate.invoke(Integer.valueOf(iArr[i5]), objArr[i5]).booleanValue()) {
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

    public final int count(@NotNull Function2<? super Integer, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                        if (predicate.invoke(Integer.valueOf(iArr[i6]), objArr[i6]).booleanValue()) {
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

    public static /* synthetic */ String joinToString$default(IntObjectMap intObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 function2, int i2, Object obj) {
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
            int[] iArr = intObjectMap.keys;
            Object[] objArr = intObjectMap.values;
            long[] jArr3 = intObjectMap.metadata;
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
                                int i13 = iArr[i12];
                                i4 = i9;
                                Object obj2 = objArr[i12];
                                if (i7 == i5) {
                                    sbM779u.append(charSequence5);
                                    break loop0;
                                }
                                if (i7 != 0) {
                                    sbM779u.append(separator);
                                }
                                jArr2 = jArr3;
                                sbM779u.append((CharSequence) function2.invoke(Integer.valueOf(i13), obj2));
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
        int[] iArr;
        int[] iArr2;
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM1174t = AbstractC0622a.m1174t(postfix, "postfix", truncated, "truncated", prefix);
        int[] iArr3 = this.keys;
        Object[] objArr = this.values;
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
                            int i9 = iArr3[i8];
                            Object obj = objArr[i8];
                            iArr2 = iArr3;
                            if (i4 == limit) {
                                sbM1174t.append(truncated);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM1174t.append(separator);
                            }
                            sbM1174t.append(i9);
                            sbM1174t.append('=');
                            sbM1174t.append(obj);
                            i4++;
                        } else {
                            iArr2 = iArr3;
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        iArr3 = iArr2;
                        i5 = i;
                    }
                    iArr = iArr3;
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                iArr3 = iArr;
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
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated, @NotNull Function2<? super Integer, ? super V, ? extends CharSequence> transform) {
        int[] iArr;
        int[] iArr2;
        CharSequence separator2 = separator;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        StringBuilder sbM779u = AbstractC0541b.m779u(truncated, "truncated", transform, "transform", prefix);
        int[] iArr3 = this.keys;
        Object[] objArr = this.values;
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
                            int i8 = iArr3[i7];
                            Object obj = objArr[i7];
                            iArr2 = iArr3;
                            if (i2 == limit) {
                                sbM779u.append(truncated);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sbM779u.append(separator2);
                            }
                            sbM779u.append(transform.invoke(Integer.valueOf(i8), obj));
                            i2++;
                        } else {
                            iArr2 = iArr3;
                        }
                        j >>= 8;
                        i6++;
                        separator2 = separator;
                        iArr3 = iArr2;
                    }
                    iArr = iArr3;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                }
                if (i4 == length) {
                    break;
                }
                i = i4 + 1;
                separator2 = separator;
                iArr3 = iArr;
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
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, int i, @NotNull Function2<? super Integer, ? super V, ? extends CharSequence> function2) {
        int i2;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence, "postfix", function2, "transform", prefix);
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i10 = iArr[i9];
                            i2 = i6;
                            Object obj = objArr[i9];
                            if (i5 == i) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i5 != 0) {
                                sbM779u.append(separator);
                            }
                            sbM779u.append(function2.invoke(Integer.valueOf(i10), obj));
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
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super V, ? extends CharSequence> function2) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence, "postfix", function2, "transform", prefix);
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i9 = iArr[i8];
                            i = i5;
                            Object obj = objArr[i8];
                            if (i4 == -1) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM779u.append(separator);
                            }
                            sbM779u.append(function2.invoke(Integer.valueOf(i9), obj));
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
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super V, ? extends CharSequence> function2) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        StringBuilder sbM779u = AbstractC0541b.m779u(charSequence, "prefix", function2, "transform", charSequence);
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i9 = iArr[i8];
                            Object obj = objArr[i8];
                            i = i5;
                            if (i4 == -1) {
                                sbM779u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM779u.append(separator);
                            }
                            sbM779u.append(function2.invoke(Integer.valueOf(i9), obj));
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
    public final String joinToString(@NotNull CharSequence separator, @NotNull Function2<? super Integer, ? super V, ? extends CharSequence> transform) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i9 = iArr[i8];
                            i = i5;
                            Object obj = objArr[i8];
                            if (i4 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(Integer.valueOf(i9), obj));
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
    public final String joinToString(@NotNull Function2<? super Integer, ? super V, ? extends CharSequence> transform) {
        int i;
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i9 = iArr[i8];
                            Object obj = objArr[i8];
                            i = i5;
                            if (i4 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb.append((CharSequence) SQLKeyword.COMMA);
                            }
                            sb.append(transform.invoke(Integer.valueOf(i9), obj));
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
