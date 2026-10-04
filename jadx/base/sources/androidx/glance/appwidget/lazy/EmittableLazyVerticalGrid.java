package androidx.glance.appwidget.lazy;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.Emittable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/appwidget/lazy/EmittableLazyVerticalGrid;", "Landroidx/glance/appwidget/lazy/EmittableLazyVerticalGridList;", "()V", "copy", "Landroidx/glance/Emittable;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/EmittableLazyVerticalGrid\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,379:1\n1549#2:380\n1620#2,3:381\n*S KotlinDebug\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/EmittableLazyVerticalGrid\n*L\n317#1:380\n317#1:381,3\n*E\n"})
public final class EmittableLazyVerticalGrid extends EmittableLazyVerticalGridList {
    public static final int $stable = 0;

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableLazyVerticalGrid emittableLazyVerticalGrid = new EmittableLazyVerticalGrid();
        emittableLazyVerticalGrid.setModifier(getModifier());
        emittableLazyVerticalGrid.m21342setHorizontalAlignmentuMT220(getHorizontalAlignment());
        emittableLazyVerticalGrid.setGridCells(getGridCells());
        emittableLazyVerticalGrid.setActivityOptions(getActivityOptions());
        List<Emittable> children = emittableLazyVerticalGrid.getChildren();
        List<Emittable> children2 = getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(children2));
        Iterator<T> it = children2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        children.addAll(arrayList);
        return emittableLazyVerticalGrid;
    }
}
