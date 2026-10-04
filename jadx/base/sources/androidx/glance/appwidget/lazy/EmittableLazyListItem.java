package androidx.glance.appwidget.lazy;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.Emittable;
import androidx.glance.EmittableLazyItemWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.SizeModifiersKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/appwidget/lazy/EmittableLazyListItem;", "Landroidx/glance/EmittableLazyItemWithChildren;", "()V", "itemId", "", "getItemId", "()J", "setItemId", "(J)V", "modifier", "Landroidx/glance/GlanceModifier;", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "copy", "Landroidx/glance/Emittable;", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/EmittableLazyListItem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,316:1\n1549#2:317\n1620#2,3:318\n*S KotlinDebug\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/EmittableLazyListItem\n*L\n300#1:317\n300#1:318,3\n*E\n"})
public final class EmittableLazyListItem extends EmittableLazyItemWithChildren {
    public static final int $stable = 8;
    private long itemId;

    @NotNull
    private GlanceModifier modifier = SizeModifiersKt.fillMaxWidth(SizeModifiersKt.wrapContentHeight(GlanceModifier.INSTANCE));

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableLazyListItem emittableLazyListItem = new EmittableLazyListItem();
        emittableLazyListItem.itemId = this.itemId;
        emittableLazyListItem.setAlignment(getAlignment());
        List<Emittable> children = emittableLazyListItem.getChildren();
        List<Emittable> children2 = getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(children2));
        Iterator<T> it = children2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        children.addAll(arrayList);
        return emittableLazyListItem;
    }

    public final long getItemId() {
        return this.itemId;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public GlanceModifier getModifier() {
        return this.modifier;
    }

    public final void setItemId(long j) {
        this.itemId = j;
    }

    @Override // androidx.glance.Emittable
    public void setModifier(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<set-?>");
        this.modifier = glanceModifier;
    }

    @NotNull
    public String toString() {
        GlanceModifier modifier = getModifier();
        Alignment alignment = getAlignment();
        String strChildrenToString = childrenToString();
        StringBuilder sb = new StringBuilder("EmittableLazyListItem(modifier=");
        sb.append(modifier);
        sb.append(", alignment=");
        sb.append(alignment);
        sb.append(", children=[\n");
        return AbstractC0622a.m1170p(strChildrenToString, "\n])", sb);
    }
}
