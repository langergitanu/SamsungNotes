package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006J \u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000f0\t\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\tJ,\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000f0\u0005\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000f0\u0005J \u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\t\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\tJ\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotIndexManager;", "", "<init>", "()V", "USER_TO_RENDER_INDEX", "", "", "RENDER_TO_USER_INDEX", "RENDER_ORDER", "", "userToRenderIndex", "userIndex", "renderToUserIndex", "renderIndex", "convertToRenderOrder", "T", "userOrderData", "convertToRenderOrderMap", "userOrderMap", "convertToUserOrder", "renderOrderData", "getDebugInfo", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpotIndexManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpotIndexManager.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotIndexManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1#2:106\n1557#3:107\n1628#3,3:108\n1557#3:111\n1628#3,3:112\n*S KotlinDebug\n*F\n+ 1 SpotIndexManager.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotIndexManager\n*L\n64#1:107\n64#1:108,3\n86#1:111\n86#1:112,3\n*E\n"})
public final class SpotIndexManager {

    @NotNull
    public static final SpotIndexManager INSTANCE = new SpotIndexManager();

    @NotNull
    private static final Map<Integer, Integer> USER_TO_RENDER_INDEX = MapsKt.mapOf(TuplesKt.m13893to(0, 0), TuplesKt.m13893to(1, 3), TuplesKt.m13893to(2, 1), TuplesKt.m13893to(3, 2));

    @NotNull
    private static final Map<Integer, Integer> RENDER_TO_USER_INDEX = MapsKt.mapOf(TuplesKt.m13893to(0, 0), TuplesKt.m13893to(1, 2), TuplesKt.m13893to(2, 3), TuplesKt.m13893to(3, 1));

    @NotNull
    private static final List<Integer> RENDER_ORDER = CollectionsKt.listOf((Object[]) new Integer[]{0, 2, 3, 1});

    private SpotIndexManager() {
    }

    @NotNull
    public final <T> List<T> convertToRenderOrder(@NotNull List<? extends T> userOrderData) {
        Intrinsics.checkNotNullParameter(userOrderData, "userOrderData");
        if (userOrderData.size() != 4) {
            throw new IllegalArgumentException("Data list must have exactly 4 elements");
        }
        List<Integer> list = RENDER_ORDER;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(userOrderData.get(((Number) it.next()).intValue()));
        }
        return arrayList;
    }

    @NotNull
    public final <T> Map<Integer, T> convertToRenderOrderMap(@NotNull Map<Integer, ? extends T> userOrderMap) {
        Intrinsics.checkNotNullParameter(userOrderMap, "userOrderMap");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (int i = 0; i < 4; i++) {
            T t = userOrderMap.get(Integer.valueOf(INSTANCE.renderToUserIndex(i)));
            if (t != null) {
                mapCreateMapBuilder.put(Integer.valueOf(i), t);
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    @NotNull
    public final <T> List<T> convertToUserOrder(@NotNull List<? extends T> renderOrderData) {
        Intrinsics.checkNotNullParameter(renderOrderData, "renderOrderData");
        if (renderOrderData.size() != 4) {
            throw new IllegalArgumentException("Data list must have exactly 4 elements");
        }
        IntRange intRange = new IntRange(0, 3);
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(intRange));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(renderOrderData.get(INSTANCE.userToRenderIndex(((IntIterator) it).nextInt())));
        }
        return arrayList;
    }

    @NotNull
    public final String getDebugInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Spot Index Mapping ===");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("User -> Render: " + USER_TO_RENDER_INDEX);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("Render -> User: " + RENDER_TO_USER_INDEX);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("Render Order (Z-order): " + RENDER_ORDER);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("Z-depth: A(0) -> C(2) -> D(3) -> B(1)");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final int renderToUserIndex(int renderIndex) {
        if (renderIndex < 0 || renderIndex >= 4) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(renderIndex, "Render index must be between 0 and 3, but was ").toString());
        }
        Integer num = RENDER_TO_USER_INDEX.get(Integer.valueOf(renderIndex));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int userToRenderIndex(int userIndex) {
        if (userIndex < 0 || userIndex >= 4) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(userIndex, "User index must be between 0 and 3, but was ").toString());
        }
        Integer num = USER_TO_RENDER_INDEX.get(Integer.valueOf(userIndex));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
