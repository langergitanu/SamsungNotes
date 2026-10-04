package androidx.glance.layout;

import androidx.annotation.RestrictTo;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
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
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/layout/EmittableBox;", "Landroidx/glance/EmittableWithChildren;", "()V", "contentAlignment", "Landroidx/glance/layout/Alignment;", "getContentAlignment", "()Landroidx/glance/layout/Alignment;", "setContentAlignment", "(Landroidx/glance/layout/Alignment;)V", "modifier", "Landroidx/glance/GlanceModifier;", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "copy", "Landroidx/glance/Emittable;", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Box.kt\nandroidx/glance/layout/EmittableBox\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n1549#2:76\n1620#2,3:77\n*S KotlinDebug\n*F\n+ 1 Box.kt\nandroidx/glance/layout/EmittableBox\n*L\n35#1:76\n35#1:77,3\n*E\n"})
public final class EmittableBox extends EmittableWithChildren {
    public static final int $stable = 8;

    @NotNull
    private Alignment contentAlignment;

    @NotNull
    private GlanceModifier modifier;

    public EmittableBox() {
        super(0, false, 3, null);
        this.modifier = GlanceModifier.INSTANCE;
        this.contentAlignment = Alignment.INSTANCE.getTopStart();
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableBox emittableBox = new EmittableBox();
        emittableBox.setModifier(getModifier());
        emittableBox.contentAlignment = this.contentAlignment;
        List<Emittable> children = emittableBox.getChildren();
        List<Emittable> children2 = getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(children2));
        Iterator<T> it = children2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        children.addAll(arrayList);
        return emittableBox;
    }

    @NotNull
    public final Alignment getContentAlignment() {
        return this.contentAlignment;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public GlanceModifier getModifier() {
        return this.modifier;
    }

    public final void setContentAlignment(@NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.contentAlignment = alignment;
    }

    @Override // androidx.glance.Emittable
    public void setModifier(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<set-?>");
        this.modifier = glanceModifier;
    }

    @NotNull
    public String toString() {
        GlanceModifier modifier = getModifier();
        Alignment alignment = this.contentAlignment;
        String strChildrenToString = childrenToString();
        StringBuilder sb = new StringBuilder("EmittableBox(modifier=");
        sb.append(modifier);
        sb.append(", contentAlignment=");
        sb.append(alignment);
        sb.append("children=[\n");
        return AbstractC0622a.m1170p(strChildrenToString, "\n])", sb);
    }
}
