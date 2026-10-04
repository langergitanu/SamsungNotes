package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b\u001a5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\b\u000fH\u0083\b¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0001H\u0083\b\u001a;\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\"\u001a\u001d\u0010#\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001dH\u0002¢\u0006\u0002\u0010$\u001a\u001c\u0010%\u001a\u00020\u0005*\u00020\u00142\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0003H\u0002\u001a7\u0010(\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00122\b\b\u0002\u0010)\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\b\u001a\u001c\u0010+\u001a\u00020\u0003*\u00020\u00142\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a+\u0010.\u001a\u00020\u0005*\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\f\u00102\u001a\u00020\u0003*\u00020 H\u0002\u001a2\u00103\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001d2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b¢\u0006\u0002\u00104\u001a\u0016\u00105\u001a\u00020\u0003*\u00020 2\b\b\u0002\u00106\u001a\u00020\u0003H\u0000\u001a\u001e\u00107\u001a\u00020\u0003*\u00020 2\u0006\u00108\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a,\u0010;\u001a\u00020<*\u00020\u00142\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u0001H\u0003\u001a\u008c\u0001\u0010A\u001a\u00020<*\u00020\f2\u0006\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00032\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\u0014\u0010Y\u001a\u00020\u0005*\u00020 2\u0006\u0010Z\u001a\u00020\u0003H\u0002\u001a!\u0010[\u001a\u00020 *\u00020 2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\\"}, m13886d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[II)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "fastForEach", "reverse", "action", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-XtK8cYQ", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyStaggeredGridMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureKt\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 3 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext\n+ 4 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/SpanRange\n+ 5 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 7 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1354:1\n57#1,9:1356\n79#1,4:1365\n1033#1:1382\n1034#1,3:1387\n79#1,4:1390\n79#1,4:1394\n79#1,4:1398\n1033#1:1409\n1034#1,3:1414\n79#1,4:1425\n79#1,4:1429\n1033#1:1450\n1034#1,3:1455\n79#1,4:1460\n79#1,4:1466\n79#1,4:1470\n1033#1:1491\n1034#1,3:1496\n79#1,4:1499\n79#1,4:1503\n1093#1,4:1509\n79#1,4:1513\n79#1,4:1517\n79#1,4:1521\n1002#1,3:1525\n1020#1:1528\n1005#1:1533\n1006#1,9:1536\n1021#1:1552\n1016#1:1553\n79#1,4:1554\n1002#1,3:1558\n1020#1:1561\n1005#1:1566\n1006#1,9:1569\n1021#1:1585\n1016#1:1586\n79#1,4:1587\n79#1,4:1591\n67#1:1605\n1066#1,11:1609\n1033#1:1620\n1034#1,3:1625\n1020#1:1628\n1021#1:1641\n1033#1:1670\n1034#1,3:1675\n26#2:1355\n26#2:1507\n26#2:1508\n248#3:1369\n245#3:1370\n245#3:1376\n248#3:1402\n245#3:1403\n245#3:1419\n248#3:1437\n245#3:1438\n245#3:1444\n248#3:1478\n245#3:1479\n245#3:1485\n1029#4:1371\n1028#4:1372\n1027#4:1374\n1029#4:1377\n1028#4:1378\n1027#4:1380\n1027#4:1383\n1028#4:1385\n1029#4:1404\n1028#4:1405\n1027#4:1407\n1027#4:1410\n1028#4:1412\n1027#4:1417\n1029#4:1420\n1028#4:1421\n1027#4:1423\n1029#4:1439\n1028#4:1440\n1027#4:1442\n1029#4:1445\n1028#4:1446\n1027#4:1448\n1027#4:1451\n1028#4:1453\n1027#4:1458\n1029#4:1480\n1028#4:1481\n1027#4:1483\n1029#4:1486\n1028#4:1487\n1027#4:1489\n1027#4:1492\n1028#4:1494\n1027#4:1621\n1028#4:1623\n1027#4:1666\n1028#4:1668\n1027#4:1671\n1028#4:1673\n114#5:1373\n107#5:1375\n114#5:1379\n107#5:1381\n107#5:1384\n114#5:1386\n114#5:1406\n107#5:1408\n107#5:1411\n114#5:1413\n107#5:1418\n114#5:1422\n107#5:1424\n114#5:1441\n107#5:1443\n114#5:1447\n107#5:1449\n107#5:1452\n114#5:1454\n107#5:1459\n114#5:1482\n107#5:1484\n114#5:1488\n107#5:1490\n107#5:1493\n114#5:1495\n107#5:1622\n114#5:1624\n107#5:1667\n114#5:1669\n107#5:1672\n114#5:1674\n12774#6,2:1433\n12541#6,2:1435\n12774#6,2:1464\n12583#6,2:1474\n12774#6,2:1476\n12541#6,2:1534\n12583#6,2:1567\n12774#6,2:1601\n12583#6,2:1603\n12744#6,2:1607\n51#7,4:1529\n56#7:1545\n33#7,6:1546\n51#7,4:1562\n56#7:1578\n33#7,6:1579\n33#7,6:1595\n51#7,6:1629\n33#7,6:1635\n51#7,6:1642\n33#7,6:1648\n51#7,6:1654\n33#7,6:1660\n1#8:1606\n*S KotlinDebug\n*F\n+ 1 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureKt\n*L\n258#1:1356,9\n348#1:1365,4\n393#1:1382\n393#1:1387,3\n405#1:1390,4\n447#1:1394,4\n486#1:1398,4\n514#1:1409\n514#1:1414,3\n538#1:1425,4\n541#1:1429,4\n574#1:1450\n574#1:1455,3\n595#1:1460,4\n618#1:1466,4\n621#1:1470,4\n693#1:1491\n693#1:1496,3\n731#1:1499,4\n734#1:1503,4\n751#1:1509,4\n755#1:1513,4\n778#1:1517,4\n807#1:1521,4\n812#1:1525,3\n812#1:1528\n812#1:1533\n812#1:1536,9\n812#1:1552\n812#1:1553\n840#1:1554,4\n852#1:1558,3\n852#1:1561\n852#1:1566\n852#1:1569,9\n852#1:1585\n852#1:1586\n878#1:1587,4\n887#1:1591,4\n258#1:1605\n970#1:1609,11\n989#1:1620\n989#1:1625,3\n1004#1:1628\n1004#1:1641\n1046#1:1670\n1046#1:1675,3\n175#1:1355\n743#1:1507\n744#1:1508\n385#1:1369\n385#1:1370\n392#1:1376\n512#1:1402\n512#1:1403\n531#1:1419\n565#1:1437\n565#1:1438\n569#1:1444\n685#1:1478\n685#1:1479\n692#1:1485\n385#1:1371\n385#1:1372\n385#1:1374\n392#1:1377\n392#1:1378\n392#1:1380\n393#1:1383\n393#1:1385\n512#1:1404\n512#1:1405\n512#1:1407\n514#1:1410\n514#1:1412\n522#1:1417\n531#1:1420\n531#1:1421\n531#1:1423\n565#1:1439\n565#1:1440\n565#1:1442\n569#1:1445\n569#1:1446\n569#1:1448\n574#1:1451\n574#1:1453\n586#1:1458\n685#1:1480\n685#1:1481\n685#1:1483\n692#1:1486\n692#1:1487\n692#1:1489\n693#1:1492\n693#1:1494\n989#1:1621\n989#1:1623\n1033#1:1666\n1033#1:1668\n1046#1:1671\n1046#1:1673\n385#1:1373\n385#1:1375\n392#1:1379\n392#1:1381\n393#1:1384\n393#1:1386\n512#1:1406\n512#1:1408\n514#1:1411\n514#1:1413\n522#1:1418\n531#1:1422\n531#1:1424\n565#1:1441\n565#1:1443\n569#1:1447\n569#1:1449\n574#1:1452\n574#1:1454\n586#1:1459\n685#1:1482\n685#1:1484\n692#1:1488\n692#1:1490\n693#1:1493\n693#1:1495\n989#1:1622\n989#1:1624\n1033#1:1667\n1033#1:1669\n1046#1:1672\n1046#1:1674\n550#1:1433,2\n553#1:1435,2\n614#1:1464,2\n628#1:1474,2\n636#1:1476,2\n826#1:1534,2\n868#1:1567,2\n926#1:1601,2\n927#1:1603,2\n968#1:1607,2\n812#1:1529,4\n812#1:1545\n812#1:1546,6\n852#1:1562,4\n852#1:1578\n852#1:1579,6\n917#1:1595,6\n1004#1:1629,6\n1004#1:1635,6\n1020#1:1642,6\n1020#1:1648,6\n1020#1:1654,6\n1020#1:1660,6\n*E\n"})
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    @ExperimentalFoundationApi
    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int iIntValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                        long jM16060getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m16060getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m16069getAndMeasurejy6DScQ(iIntValue, jM16060getSpanRangelOCCd4c);
                        function1.invoke(lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ);
                        arrayList.add(lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iIntValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(iIntValue2)).booleanValue()) {
                    long jM16060getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m16060getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m16069getAndMeasurejy6DScQ(iIntValue2, jM16060getSpanRangelOCCd4c2);
                    function1.invoke(lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ2);
                    arrayList.add(lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i) {
        int size = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            size += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i2 = -1;
                    int i4 = Integer.MAX_VALUE;
                    for (int i5 = 0; i5 < length; i5++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemFirstOrNull = arrayDequeArr[i5].firstOrNull();
                        int index = lazyStaggeredGridMeasuredItemFirstOrNull != null ? lazyStaggeredGridMeasuredItemFirstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i4 > index) {
                            i2 = i5;
                            i4 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemRemoveFirst = arrayDequeArr[i2].removeFirst();
                    if (lazyStaggeredGridMeasuredItemRemoveFirst.getLane() == i2) {
                        long jM16075constructorimpl = SpanRange.m16075constructorimpl(lazyStaggeredGridMeasuredItemRemoveFirst.getLane(), lazyStaggeredGridMeasuredItemRemoveFirst.getSpan());
                        int iM16064maxInRangejy6DScQ = m16064maxInRangejy6DScQ(iArr, jM16075constructorimpl);
                        lazyStaggeredGridMeasuredItemRemoveFirst.position(iM16064maxInRangejy6DScQ, lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i2], i);
                        arrayList.add(lazyStaggeredGridMeasuredItemRemoveFirst);
                        int i6 = (int) (jM16075constructorimpl & 4294967295L);
                        for (int i7 = (int) (jM16075constructorimpl >> 32); i7 < i6; i7++) {
                            iArr[i7] = lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSizeWithSpacings() + iM16064maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                function1.invoke(list.get(i));
            }
            return;
        }
        int size2 = list.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i2 = size2 - 1;
            function1.invoke(list.get(size2));
            if (i2 < 0) {
                return;
            } else {
                size2 = i2;
            }
        }
    }

    public static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (!z) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                function1.invoke(list.get(i2));
            }
            return;
        }
        int size2 = list.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i4 = size2 - 1;
            function1.invoke(list.get(size2));
            if (i4 < 0) {
                return;
            } else {
                size2 = i4;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    /* JADX INFO: renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m16063forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i2 < i5) {
                i = i4;
                i2 = i5;
            }
        }
        return i;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int iIntValue = function1.invoke(tArr[i4]).intValue();
            if (i2 > iIntValue) {
                i = i4;
                i2 = iIntValue;
            }
        }
        return i;
    }

    public static final int indexOfMinValue(@NotNull int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i + 1;
            int i7 = iArr[i5];
            if (i6 <= i7 && i7 < i4) {
                i2 = i5;
                i4 = i7;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    /* JADX INFO: renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m16064maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int iMax = Integer.MIN_VALUE;
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            iMax = Math.max(iMax, iArr[i2]);
        }
        return iMax;
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x02f1, code lost:
    
        r5 = indexOfMinValue$default(r8, 0, 1, null);
        r6 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02fc, code lost:
    
        if (r5 == r6) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0302, code lost:
    
        if (r8[r5] != r8[r6]) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0304, code lost:
    
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0306, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0307, code lost:
    
        r6 = r28[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x030a, code lost:
    
        if (r6 != (-1)) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x030c, code lost:
    
        r6 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x030d, code lost:
    
        r6 = findPreviousItemIndex(r0, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0311, code lost:
    
        if (r6 >= 0) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0313, code lost:
    
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0315, code lost:
    
        if (r1 != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x031b, code lost:
    
        if (measure$lambda$41$misalignedStart(r10, r0, r8, r5) == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x031e, code lost:
    
        r15 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0321, code lost:
    
        if (r49 == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0323, code lost:
    
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x032e, code lost:
    
        if (r3 >= r1) goto L458;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0330, code lost:
    
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0337, code lost:
    
        r1 = r8.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x033b, code lost:
    
        if (r4 >= r1) goto L459;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x033d, code lost:
    
        r3[r4] = r8[r5];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x034b, code lost:
    
        return measure(r0, r26, r2, r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0357, code lost:
    
        r15 = r26;
        r10 = r28;
        r25 = r1;
        r47 = r2;
        r1 = r0.m16060getSpanRangelOCCd4c(r0.getItemProvider(), r6, r5);
        r5 = r0.getLaneInfo();
        r26 = r11;
        r28 = r12;
        r11 = (int) (r1 & 4294967295L);
        r12 = r3;
        r30 = r4;
        r3 = (int) (r1 >> 32);
        r4 = r11 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x037b, code lost:
    
        if (r4 == 1) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x037d, code lost:
    
        r14 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x037f, code lost:
    
        r14 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0380, code lost:
    
        r5.setLane(r6, r14);
        r5 = r0.getMeasuredItemProvider().m16069getAndMeasurejy6DScQ(r6, r1);
        r1 = m16064maxInRangejy6DScQ(r8, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0390, code lost:
    
        if (r4 == 1) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0392, code lost:
    
        r2 = r0.getLaneInfo().getGaps(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x039b, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x039c, code lost:
    
        if (r3 >= r11) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03a0, code lost:
    
        if (r8[r3] == r1) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03a2, code lost:
    
        r25 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03a4, code lost:
    
        r27[r3].addFirst(r5);
        r10[r3] = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03ab, code lost:
    
        if (r2 != null) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03ad, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03af, code lost:
    
        r4 = r2[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03b1, code lost:
    
        r8[r3] = (r5.getMainAxisSizeWithSpacings() + r1) + r4;
        r3 = r3 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:305:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0750  */
    @ExperimentalFoundationApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        int i2;
        int iIndexOf;
        int i4;
        int i5;
        int i6;
        int[] iArr3;
        int i7;
        int[] iArr4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr5;
        boolean z2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        List listEmptyList;
        int iM20937constrainHeightK40F9xA;
        boolean z3;
        boolean z4;
        boolean z5;
        int i20;
        List<Integer> list;
        boolean z6;
        int i21;
        boolean z7;
        int i22;
        int[] gaps;
        boolean z8;
        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            int iM20923getMinWidthimpl = Constraints.m20923getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints());
            int iM20922getMinHeightimpl = Constraints.m20922getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().onMeasured(0, iM20923getMinWidthimpl, iM20922getMinHeightimpl, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), false, lazyStaggeredGridMeasureContext.getLaneCount(), false, 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            long jM16019getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().m16019getMinSizeToFitDisappearingItemsYbymL2g();
            if (!IntSize.m21136equalsimpl0(jM16019getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
                iM20923getMinWidthimpl = ConstraintsKt.m20938constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), IntSize.m21138getWidthimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g));
                iM20922getMinHeightimpl = ConstraintsKt.m20937constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), IntSize.m21137getHeightimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g));
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, iM20923getMinWidthimpl, iM20922getMinHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null), false, lazyStaggeredGridMeasureContext.getIsVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m20923getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints()), Constraints.m20922getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints())), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding() + lazyStaggeredGridMeasureContext.getMainAxisAvailableSize(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        String str = "copyOf(this, size)";
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, size)");
        int[] iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf2, "copyOf(this, size)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, iArrCopyOf, itemCount);
        offsetBy(iArrCopyOf2, -i);
        int laneCount = lazyStaggeredGridMeasureContext2.getLaneCount();
        ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
        for (int i23 = 0; i23 < laneCount; i23++) {
            arrayDequeArr[i23] = new ArrayDeque(16);
        }
        offsetBy(iArrCopyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z9 = false;
        while (true) {
            if (!measure$lambda$41$hasSpaceBeforeFirst(iArrCopyOf, iArrCopyOf2, lazyStaggeredGridMeasureContext2)) {
                i2 = 0;
                iIndexOf = -1;
                break;
            }
            iIndexOf = indexOfMaxValue(iArrCopyOf);
            int i24 = iArrCopyOf[iIndexOf];
            int length = iArrCopyOf2.length;
            i2 = 0;
            for (int i25 = 0; i25 < length; i25++) {
                if (iArrCopyOf[i25] != iArrCopyOf[iIndexOf]) {
                    int i26 = iArrCopyOf2[i25];
                    int i27 = iArrCopyOf2[iIndexOf];
                    if (i26 < i27) {
                        iArrCopyOf2[i25] = i27;
                    }
                }
            }
            int iFindPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i24, iIndexOf);
            if (iFindPreviousItemIndex < 0) {
                break;
            }
            long jM16060getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m16060getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iFindPreviousItemIndex, iIndexOf);
            int i28 = (int) (jM16060getSpanRangelOCCd4c & 4294967295L);
            boolean z10 = z9;
            int i29 = (int) (jM16060getSpanRangelOCCd4c >> 32);
            int i30 = i28 - i29;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iFindPreviousItemIndex, i30 != 1 ? -2 : i29);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m16069getAndMeasurejy6DScQ(iFindPreviousItemIndex, jM16060getSpanRangelOCCd4c);
            int iM16064maxInRangejy6DScQ = m16064maxInRangejy6DScQ(iArrCopyOf2, jM16060getSpanRangelOCCd4c);
            int[] gaps2 = i30 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(iFindPreviousItemIndex) : null;
            boolean z11 = z10;
            while (i29 < i28) {
                iArrCopyOf[i29] = iFindPreviousItemIndex;
                int mainAxisSizeWithSpacings = lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + iM16064maxInRangejy6DScQ + (gaps2 == null ? 0 : gaps2[i29]);
                iArrCopyOf2[i29] = mainAxisSizeWithSpacings;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + mainAxisSizeWithSpacings <= 0) {
                    z11 = true;
                }
                i29++;
            }
            z9 = z11;
        }
        boolean z12 = z9;
        int i31 = -lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int i32 = iArrCopyOf2[i2];
        if (i32 < i31) {
            offsetBy(iArrCopyOf2, i31 - i32);
            i4 = i + i32;
        } else {
            i4 = i;
        }
        offsetBy(iArrCopyOf2, lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i33 = -1;
        if (iIndexOf == -1) {
            iIndexOf = ArraysKt.indexOf(iArrCopyOf, i2);
        }
        if (iIndexOf != -1 && measure$lambda$41$misalignedStart(iArrCopyOf, lazyStaggeredGridMeasureContext2, iArrCopyOf2, iIndexOf) && z) {
            lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
            int length2 = iArrCopyOf.length;
            int[] iArr6 = new int[length2];
            int i34 = 0;
            while (i34 < length2) {
                iArr6[i34] = i33;
                i34++;
                i33 = -1;
            }
            int length3 = iArrCopyOf2.length;
            int[] iArr7 = new int[length3];
            for (int i35 = 0; i35 < length3; i35++) {
                iArr7[i35] = iArrCopyOf2[iIndexOf];
            }
            return measure(lazyStaggeredGridMeasureContext2, i4, iArr6, iArr7, false);
        }
        int[] iArrCopyOf3 = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf3, "copyOf(this, size)");
        int length4 = iArrCopyOf2.length;
        int[] iArr8 = new int[length4];
        for (int i36 = 0; i36 < length4; i36++) {
            iArr8[i36] = -iArrCopyOf2[i36];
        }
        int mainAxisSpacing = lazyStaggeredGridMeasureContext2.getMainAxisSpacing() + i31;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getAfterContentPadding() + lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize(), 0);
        LazyLayoutMeasureScope lazyLayoutMeasureScope = measureScope;
        int i37 = i31;
        boolean z13 = z12;
        int iIndexOfMinValue$default = indexOfMinValue$default(iArrCopyOf3, 0, 1, null);
        int laneCount2 = 0;
        while (iIndexOfMinValue$default != -1 && laneCount2 < lazyStaggeredGridMeasureContext2.getLaneCount()) {
            int i38 = iArrCopyOf3[iIndexOfMinValue$default];
            int iIndexOfMinValue = indexOfMinValue(iArrCopyOf3, i38);
            laneCount2++;
            if (i38 >= 0) {
                int i39 = i4;
                long jM16060getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m16060getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i38, iIndexOfMinValue$default);
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m16069getAndMeasurejy6DScQ(i38, jM16060getSpanRangelOCCd4c2);
                ArrayDeque[] arrayDequeArr2 = arrayDequeArr;
                int[] iArr9 = iArrCopyOf;
                int[] iArr10 = iArrCopyOf2;
                int i40 = (int) (jM16060getSpanRangelOCCd4c2 & 4294967295L);
                String str2 = str;
                int i41 = laneCount;
                int i42 = (int) (jM16060getSpanRangelOCCd4c2 >> 32);
                int i43 = i40 - i42;
                lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(i38, i43 != 1 ? -2 : i42);
                int iM16064maxInRangejy6DScQ2 = m16064maxInRangejy6DScQ(iArr8, jM16060getSpanRangelOCCd4c2);
                for (int i44 = i42; i44 < i40; i44++) {
                    iArr8[i44] = lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + iM16064maxInRangejy6DScQ2;
                    iArrCopyOf3[i44] = i38;
                    arrayDequeArr2[i44].addLast(lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ2);
                }
                if (iM16064maxInRangejy6DScQ2 >= mainAxisSpacing || iArr8[i42] > mainAxisSpacing) {
                    z8 = z13;
                } else {
                    lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ2.setVisible(false);
                    z8 = true;
                }
                laneCount2 = i43 != 1 ? lazyStaggeredGridMeasureContext2.getLaneCount() : laneCount2;
                z13 = z8;
                str = str2;
                iIndexOfMinValue$default = iIndexOfMinValue;
                i4 = i39;
                arrayDequeArr = arrayDequeArr2;
                iArrCopyOf = iArr9;
                iArrCopyOf2 = iArr10;
                laneCount = i41;
            } else {
                iIndexOfMinValue$default = iIndexOfMinValue;
            }
        }
        int i45 = i4;
        int i46 = laneCount;
        ArrayDeque[] arrayDequeArr3 = arrayDequeArr;
        int[] iArr11 = iArrCopyOf;
        int[] iArr12 = iArrCopyOf2;
        String str3 = str;
        loop9: while (true) {
            for (int i47 = 0; i47 < length4; i47++) {
                int i48 = iArr8[i47];
                if (i48 < iCoerceAtLeast || i48 <= 0) {
                    i5 = i46;
                    break;
                }
            }
            i5 = i46;
            for (int i49 = 0; i49 < i5; i49++) {
                if (!arrayDequeArr3[i49].isEmpty()) {
                    i6 = 1;
                    break loop9;
                }
            }
            i6 = 1;
            int iIndexOfMinValue$default2 = indexOfMinValue$default(iArr8, 0, 1, null);
            int iMaxOrThrow = ArraysKt.maxOrThrow(iArrCopyOf3) + 1;
            if (iMaxOrThrow >= itemCount) {
                break;
            }
            boolean z14 = z13;
            int i50 = i37;
            int i51 = i5;
            int i52 = length4;
            LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
            int i53 = i45;
            int i54 = iCoerceAtLeast;
            long jM16060getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m16060getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iMaxOrThrow, iIndexOfMinValue$default2);
            i46 = i51;
            int i55 = (int) (jM16060getSpanRangelOCCd4c3 & 4294967295L);
            int[] iArr13 = iArrCopyOf3;
            int i56 = (int) (jM16060getSpanRangelOCCd4c3 >> 32);
            int i57 = i55 - i56;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iMaxOrThrow, i57 != 1 ? -2 : i56);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m16069getAndMeasurejy6DScQ(iMaxOrThrow, jM16060getSpanRangelOCCd4c3);
            int iM16064maxInRangejy6DScQ3 = m16064maxInRangejy6DScQ(iArr8, jM16060getSpanRangelOCCd4c3);
            if (i57 != 1) {
                gaps = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(iMaxOrThrow);
                if (gaps == null) {
                    gaps = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                gaps = null;
            }
            for (int i58 = i56; i58 < i55; i58++) {
                if (gaps != null) {
                    gaps[i58] = iM16064maxInRangejy6DScQ3 - iArr8[i58];
                }
                iArr13[i58] = iMaxOrThrow;
                iArr8[i58] = lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings() + iM16064maxInRangejy6DScQ3;
                arrayDequeArr3[i58].addLast(lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ3);
            }
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(iMaxOrThrow, gaps);
            if (iM16064maxInRangejy6DScQ3 < mainAxisSpacing && iArr8[i56] <= mainAxisSpacing) {
                lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ3.setVisible(false);
            }
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            i37 = i50;
            z13 = z14;
            iCoerceAtLeast = i54;
            i45 = i53;
            length4 = i52;
            iArrCopyOf3 = iArr13;
            lazyLayoutMeasureScope = lazyLayoutMeasureScope2;
        }
        int i59 = 0;
        while (i59 < i5) {
            ArrayDeque arrayDeque = arrayDequeArr3[i59];
            while (arrayDeque.size() > i6 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIsVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps3 = lazyStaggeredGridMeasuredItem.getSpan() != i6 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr12[i59] = iArr12[i59] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i59]));
                i6 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr11[i59] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i59++;
            i6 = 1;
        }
        int length5 = iArrCopyOf3.length;
        int i60 = 0;
        while (true) {
            if (i60 >= length5) {
                break;
            }
            if (iArrCopyOf3[i60] == itemCount - 1) {
                offsetBy(iArr8, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            }
            i60++;
        }
        int i61 = 0;
        while (true) {
            if (i61 >= length4) {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr8[indexOfMaxValue(iArr8)];
                iArr3 = iArr12;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr8, mainAxisAvailableSize);
                boolean z15 = false;
                loop26: while (true) {
                    int length6 = iArr3.length;
                    int i62 = 0;
                    while (true) {
                        if (i62 >= length6) {
                            i7 = i45;
                            iArr4 = iArr11;
                            break loop26;
                        }
                        if (iArr3[i62] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        }
                        i62++;
                        length4 = length4;
                        iArr11 = iArr11;
                        i45 = i45;
                    }
                    mainAxisAvailableSize = i14;
                    iCoerceAtLeast = i17;
                    z15 = z2;
                    itemCount = i15;
                    length4 = i16;
                    i5 = i18;
                    iArr11 = iArr5;
                    i45 = i13;
                }
                int i63 = mainAxisAvailableSize;
                i8 = i5;
                i9 = itemCount;
                i10 = length4;
                i11 = iCoerceAtLeast;
                if (z15 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i7, iArr4, iArr3, false);
                }
                i12 = i7 + i63;
                int i64 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i64 < 0) {
                    i12 += i64;
                    offsetBy(iArr8, i64);
                    offsetBy(iArr3, -i64);
                }
            } else {
                if (iArr8[i61] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i8 = i5;
                    i12 = i45;
                    iArr4 = iArr11;
                    iArr3 = iArr12;
                    i9 = itemCount;
                    i10 = length4;
                    i11 = iCoerceAtLeast;
                    break;
                }
                i61++;
            }
        }
        float scrollToBeConsumed = (MathKt.getSign(Math.round(lazyStaggeredGridMeasureContext2.getState().getScrollToBeConsumed())) != MathKt.getSign(i12) || Math.abs(Math.round(lazyStaggeredGridMeasureContext2.getState().getScrollToBeConsumed())) < Math.abs(i12)) ? lazyStaggeredGridMeasureContext2.getState().getScrollToBeConsumed() : i12;
        int[] iArrCopyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf4, str3);
        int length7 = iArrCopyOf4.length;
        for (int i65 = 0; i65 < length7; i65++) {
            iArrCopyOf4[i65] = -iArrCopyOf4[i65];
        }
        int i66 = i8;
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i67 = 0; i67 < i66; i67++) {
                ArrayDeque arrayDeque2 = arrayDequeArr3[i67];
                int size = arrayDeque2.size();
                int i68 = 0;
                while (i68 < size) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i68);
                    int[] gaps4 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings2 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps4 == null ? 0 : gaps4[i67]);
                    if (i68 == CollectionsKt.getLastIndex(arrayDeque2) || (i22 = iArr3[i67]) == 0 || i22 < mainAxisSizeWithSpacings2) {
                        break;
                    }
                    iArr3[i67] = i22 - mainAxisSizeWithSpacings2;
                    i68++;
                    iArr4[i67] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i68)).getIndex();
                }
            }
        }
        int afterContentPadding = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int iM20921getMaxWidthimpl = lazyStaggeredGridMeasureContext2.getIsVertical() ? Constraints.m20921getMaxWidthimpl(lazyStaggeredGridMeasureContext2.getConstraints()) : ConstraintsKt.m20938constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr8) + afterContentPadding);
        int iM20937constrainHeightK40F9xA2 = lazyStaggeredGridMeasureContext2.getIsVertical() ? ConstraintsKt.m20937constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr8) + afterContentPadding) : Constraints.m20920getMaxHeightimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        int afterContentPadding2 = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + (Math.min(lazyStaggeredGridMeasureContext2.getIsVertical() ? iM20937constrainHeightK40F9xA2 : iM20921getMaxWidthimpl, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i69 = iArrCopyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size2 = pinnedItems.size() - 1;
        if (size2 >= 0) {
            listEmptyList = null;
            while (true) {
                int i70 = size2 - 1;
                int iIntValue = pinnedItems.get(size2).intValue();
                int lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue);
                int i71 = i69;
                if (lane == -2 || lane == -1) {
                    for (int i72 = 0; i72 < i66; i72++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr3[i72].firstOrNull();
                        if (!((lazyStaggeredGridMeasuredItem4 != null ? lazyStaggeredGridMeasuredItem4.getIndex() : -1) > iIntValue)) {
                            z7 = false;
                            break;
                        }
                    }
                    z7 = true;
                } else {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr3[lane].firstOrNull();
                    if ((lazyStaggeredGridMeasuredItem5 != null ? lazyStaggeredGridMeasuredItem5.getIndex() : -1) <= iIntValue) {
                        z7 = false;
                        break;
                    }
                    z7 = true;
                }
                if (z7) {
                    i19 = afterContentPadding;
                    long jM16060getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m16060getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue, 0);
                    if (listEmptyList == null) {
                        listEmptyList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m16069getAndMeasurejy6DScQ(iIntValue, jM16060getSpanRangelOCCd4c4);
                    int mainAxisSizeWithSpacings3 = i71 - lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings();
                    lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ4.position(mainAxisSizeWithSpacings3, 0, afterContentPadding2);
                    listEmptyList.add(lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ4);
                    i69 = mainAxisSizeWithSpacings3;
                } else {
                    i19 = afterContentPadding;
                    i69 = i71;
                }
                if (i70 < 0) {
                    break;
                }
                afterContentPadding = i19;
                size2 = i70;
            }
        } else {
            i19 = afterContentPadding;
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        int i73 = i11;
        List<LazyStaggeredGridMeasuredItem> listCalculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr3, iArrCopyOf4, afterContentPadding2);
        int i74 = iArrCopyOf4[0];
        List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size3 = pinnedItems2.size();
        int i75 = 0;
        List listEmptyList2 = null;
        while (i75 < size3) {
            int iIntValue2 = pinnedItems2.get(i75).intValue();
            int i76 = i9;
            if (iIntValue2 >= i76) {
                list = pinnedItems2;
                i20 = size3;
            } else {
                int lane2 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue2);
                i20 = size3;
                if (lane2 == -2 || lane2 == -1) {
                    int length8 = iArrCopyOf3.length;
                    int i77 = 0;
                    while (i77 < length8) {
                        list = pinnedItems2;
                        if (iArrCopyOf3[i77] < iIntValue2) {
                            i77++;
                            pinnedItems2 = list;
                        }
                    }
                    list = pinnedItems2;
                    z6 = true;
                } else {
                    if (iArrCopyOf3[lane2] >= iIntValue2) {
                        list = pinnedItems2;
                    }
                    list = pinnedItems2;
                    z6 = true;
                }
                if (z6) {
                    i21 = i75;
                } else {
                    long jM16060getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext2.m16060getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue2, 0);
                    if (listEmptyList2 == null) {
                        listEmptyList2 = new ArrayList();
                    }
                    i21 = i75;
                    List list2 = listEmptyList2;
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m16069getAndMeasurejy6DScQ(iIntValue2, jM16060getSpanRangelOCCd4c5);
                    lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ5.position(i74, 0, afterContentPadding2);
                    int mainAxisSizeWithSpacings4 = lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings() + i74;
                    list2.add(lazyStaggeredGridMeasuredItemM16069getAndMeasurejy6DScQ5);
                    listEmptyList2 = list2;
                    i74 = mainAxisSizeWithSpacings4;
                }
                i75 = i21 + 1;
                size3 = i20;
                i9 = i76;
                pinnedItems2 = list;
            }
            z6 = false;
            if (z6) {
            }
            i75 = i21 + 1;
            size3 = i20;
            i9 = i76;
            pinnedItems2 = list;
        }
        int i78 = i9;
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(listEmptyList);
        arrayList.addAll(listCalculateVisibleItems);
        arrayList.addAll(listEmptyList2);
        lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation_release().onMeasured((int) scrollToBeConsumed, iM20921getMaxWidthimpl, iM20937constrainHeightK40F9xA2, arrayList, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.getIsVertical(), false, lazyStaggeredGridMeasureContext2.getLaneCount(), false, ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr8) + i19, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
        int i79 = iM20921getMaxWidthimpl;
        long jM16019getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation_release().m16019getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.m21136equalsimpl0(jM16019getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m21143getZeroYbymL2g())) {
            iM20937constrainHeightK40F9xA = iM20937constrainHeightK40F9xA2;
        } else {
            int i80 = lazyStaggeredGridMeasureContext2.getIsVertical() ? iM20937constrainHeightK40F9xA2 : i79;
            int iM20938constrainWidthK40F9xA = ConstraintsKt.m20938constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), Math.max(i79, IntSize.m21138getWidthimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g2)));
            iM20937constrainHeightK40F9xA = ConstraintsKt.m20937constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), Math.max(iM20937constrainHeightK40F9xA2, IntSize.m21137getHeightimpl(jM16019getMinSizeToFitDisappearingItemsYbymL2g2)));
            int i81 = lazyStaggeredGridMeasureContext2.getIsVertical() ? iM20937constrainHeightK40F9xA : iM20938constrainWidthK40F9xA;
            if (i81 != i80) {
                int size4 = arrayList.size();
                for (int i82 = 0; i82 < size4; i82++) {
                    ((LazyStaggeredGridMeasuredItem) arrayList.get(i82)).updateMainAxisLayoutSize(i81);
                }
            }
            i79 = iM20938constrainWidthK40F9xA;
        }
        int i83 = i10;
        int i84 = 0;
        while (true) {
            if (i84 >= i83) {
                z3 = false;
                break;
            }
            if (iArr8[i84] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                z3 = true;
                break;
            }
            i84++;
        }
        if (!z3) {
            int length9 = iArrCopyOf3.length;
            int i85 = 0;
            while (true) {
                if (i85 >= length9) {
                    z5 = true;
                    break;
                }
                if (!(iArrCopyOf3[i85] < i78 + (-1))) {
                    z5 = false;
                    break;
                }
                i85++;
            }
            z4 = z5;
        }
        Function1<Placeable.PlacementScope, Unit> function1 = new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                List<LazyStaggeredGridMeasuredItem> list3 = arrayList;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                int size5 = list3.size();
                for (int i86 = 0; i86 < size5; i86++) {
                    list3.get(i86).place(placementScope, lazyStaggeredGridMeasureContext3);
                }
                ObservableScopeInvalidator.m16028attachToScopeimpl(lazyStaggeredGridMeasureContext2.getState().m16073getPlacementScopeInvalidatorzYiylxw$foundation_release());
            }
        };
        LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
        int i86 = iM20937constrainHeightK40F9xA;
        return new LazyStaggeredGridMeasureResult(iArr4, iArr3, scrollToBeConsumed, MeasureScope.layout$default(lazyLayoutMeasureScope3, i79, i86, null, function1, 4, null), z4, lazyStaggeredGridMeasureContext2.getIsVertical(), z13, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope3, i78, listCalculateVisibleItems, IntSizeKt.IntSize(i79, i86), i37, i73, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
    }

    private static final boolean measure$lambda$41$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$41$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i4 = 0; i4 < length2; i4++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i4], i4) != -1 && iArr2[i4] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    @ExperimentalFoundationApi
    @NotNull
    /* JADX INFO: renamed from: measureStaggeredGrid-XtK8cYQ, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m16065measureStaggeredGridXtK8cYQ(@NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, @NotNull LazyStaggeredGridState lazyStaggeredGridState, @NotNull List<Integer> list, @NotNull LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, @NotNull LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i4, int i5, @NotNull CoroutineScope coroutineScope, @NotNull GraphicsContext graphicsContext) {
        int iM16064maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i4, i5, z2, i2, coroutineScope, graphicsContext, null);
        int[] iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release.length || (iM16064maxInRangejy6DScQ = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release[i6]) == -1) {
                    iM16064maxInRangejy6DScQ = i6 == 0 ? 0 : m16064maxInRangejy6DScQ(iArr, SpanRange.m16075constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = iM16064maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                iArr2[i7] = i7 < scrollOffsets.length ? scrollOffsets[i7] : i7 == 0 ? 0 : iArr2[i7 - 1];
                i7++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.getScrollToBeConsumed()), iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release, scrollOffsets, true);
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    @ExperimentalFoundationApi
    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
