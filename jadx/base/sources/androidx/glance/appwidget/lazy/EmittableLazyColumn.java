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
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/appwidget/lazy/EmittableLazyColumn;", "Landroidx/glance/appwidget/lazy/EmittableLazyList;", "()V", "copy", "Landroidx/glance/Emittable;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/EmittableLazyColumn\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,316:1\n1549#2:317\n1620#2,3:318\n*S KotlinDebug\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/EmittableLazyColumn\n*L\n313#1:317\n313#1:318,3\n*E\n"})
public final class EmittableLazyColumn extends EmittableLazyList {
    public static final int $stable = 0;

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableLazyColumn emittableLazyColumn = new EmittableLazyColumn();
        emittableLazyColumn.setModifier(getModifier());
        emittableLazyColumn.m21340setHorizontalAlignmentuMT220(getHorizontalAlignment());
        emittableLazyColumn.setActivityOptions(getActivityOptions());
        List<Emittable> children = emittableLazyColumn.getChildren();
        List<Emittable> children2 = getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(children2));
        Iterator<T> it = children2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        children.addAll(arrayList);
        return emittableLazyColumn;
    }
}
