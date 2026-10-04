package androidx.glance.layout;

import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
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
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u0011X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/layout/EmittableRow;", "Landroidx/glance/EmittableWithChildren;", "()V", "horizontalAlignment", "Landroidx/glance/layout/Alignment$Horizontal;", "getHorizontalAlignment-PGIyAqw", "()I", "setHorizontalAlignment-uMT2-20", "(I)V", "I", "modifier", "Landroidx/glance/GlanceModifier;", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "verticalAlignment", "Landroidx/glance/layout/Alignment$Vertical;", "getVerticalAlignment-mnfRV0w", "setVerticalAlignment-Je2gTW8", "copy", "Landroidx/glance/Emittable;", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nRow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Row.kt\nandroidx/glance/layout/EmittableRow\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1549#2:101\n1620#2,3:102\n*S KotlinDebug\n*F\n+ 1 Row.kt\nandroidx/glance/layout/EmittableRow\n*L\n37#1:101\n37#1:102,3\n*E\n"})
public final class EmittableRow extends EmittableWithChildren {
    public static final int $stable = 8;
    private int horizontalAlignment;

    @NotNull
    private GlanceModifier modifier;
    private int verticalAlignment;

    /* JADX WARN: Multi-variable type inference failed */
    public EmittableRow() {
        super(0, 0 == true ? 1 : 0, 3, null);
        this.modifier = GlanceModifier.INSTANCE;
        Alignment.Companion companion = Alignment.INSTANCE;
        this.horizontalAlignment = companion.m21433getStartPGIyAqw();
        this.verticalAlignment = companion.m21434getTopmnfRV0w();
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableRow emittableRow = new EmittableRow();
        emittableRow.setModifier(getModifier());
        emittableRow.horizontalAlignment = this.horizontalAlignment;
        emittableRow.verticalAlignment = this.verticalAlignment;
        List<Emittable> children = emittableRow.getChildren();
        List<Emittable> children2 = getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(children2));
        Iterator<T> it = children2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        children.addAll(arrayList);
        return emittableRow;
    }

    /* JADX INFO: renamed from: getHorizontalAlignment-PGIyAqw, reason: not valid java name and from getter */
    public final int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public GlanceModifier getModifier() {
        return this.modifier;
    }

    /* JADX INFO: renamed from: getVerticalAlignment-mnfRV0w, reason: not valid java name and from getter */
    public final int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    /* JADX INFO: renamed from: setHorizontalAlignment-uMT2-20, reason: not valid java name */
    public final void m21474setHorizontalAlignmentuMT220(int i) {
        this.horizontalAlignment = i;
    }

    @Override // androidx.glance.Emittable
    public void setModifier(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<set-?>");
        this.modifier = glanceModifier;
    }

    /* JADX INFO: renamed from: setVerticalAlignment-Je2gTW8, reason: not valid java name */
    public final void m21475setVerticalAlignmentJe2gTW8(int i) {
        this.verticalAlignment = i;
    }

    @NotNull
    public String toString() {
        GlanceModifier modifier = getModifier();
        String strM21440toStringimpl = Alignment.Horizontal.m21440toStringimpl(this.horizontalAlignment);
        String strM21450toStringimpl = Alignment.Vertical.m21450toStringimpl(this.verticalAlignment);
        String strChildrenToString = childrenToString();
        StringBuilder sb = new StringBuilder("EmittableRow(modifier=");
        sb.append(modifier);
        sb.append(", horizontalAlignment=");
        sb.append(strM21440toStringimpl);
        sb.append(", verticalAlignment=");
        return AbstractC0541b.m776r(sb, strM21450toStringimpl, ", children=[\n", strChildrenToString, "\n])");
    }
}
