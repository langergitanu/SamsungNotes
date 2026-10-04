package androidx.glance.appwidget;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.SizeMode;
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
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u0017X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, m13886d2 = {"Landroidx/glance/appwidget/EmittableSizeBox;", "Landroidx/glance/EmittableWithChildren;", "()V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "<anonymous parameter 0>", "Landroidx/glance/GlanceModifier;", "modifier", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "previewSizeState", "", "getPreviewSizeState", "()I", "setPreviewSizeState", "(I)V", "size", "Landroidx/compose/ui/unit/DpSize;", "getSize-MYxV2XQ", "()J", "setSize-EaSLcWc", "(J)V", "J", "sizeMode", "Landroidx/glance/appwidget/SizeMode;", "getSizeMode", "()Landroidx/glance/appwidget/SizeMode;", "setSizeMode", "(Landroidx/glance/appwidget/SizeMode;)V", "copy", "Landroidx/glance/Emittable;", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSizeBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SizeBox.kt\nandroidx/glance/appwidget/EmittableSizeBox\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,126:1\n1549#2:127\n1620#2,3:128\n*S KotlinDebug\n*F\n+ 1 SizeBox.kt\nandroidx/glance/appwidget/EmittableSizeBox\n*L\n59#1:127\n59#1:128,3\n*E\n"})
public final class EmittableSizeBox extends EmittableWithChildren {
    public static final int $stable = 8;
    private float density;
    private int previewSizeState;
    private long size;

    @NotNull
    private SizeMode sizeMode;

    public EmittableSizeBox() {
        super(0, false, 3, null);
        this.size = DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ();
        this.sizeMode = SizeMode.Single.INSTANCE;
        this.density = -1.0f;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableSizeBox emittableSizeBox = new EmittableSizeBox();
        emittableSizeBox.size = this.size;
        emittableSizeBox.sizeMode = this.sizeMode;
        emittableSizeBox.previewSizeState = this.previewSizeState;
        emittableSizeBox.density = this.density;
        List<Emittable> children = emittableSizeBox.getChildren();
        List<Emittable> children2 = getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(children2));
        Iterator<T> it = children2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        children.addAll(arrayList);
        return emittableSizeBox;
    }

    public final float getDensity() {
        return this.density;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public GlanceModifier getModifier() {
        GlanceModifier modifier;
        Emittable emittable = (Emittable) CollectionsKt.singleOrNull((List) getChildren());
        return (emittable == null || (modifier = emittable.getModifier()) == null) ? SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE) : modifier;
    }

    public final int getPreviewSizeState() {
        return this.previewSizeState;
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    @NotNull
    public final SizeMode getSizeMode() {
        return this.sizeMode;
    }

    public final void setDensity(float f) {
        this.density = f;
    }

    @Override // androidx.glance.Emittable
    public void setModifier(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<anonymous parameter 0>");
        throw new IllegalAccessError("You cannot set the modifier of an EmittableSizeBox");
    }

    public final void setPreviewSizeState(int i) {
        this.previewSizeState = i;
    }

    /* JADX INFO: renamed from: setSize-EaSLcWc, reason: not valid java name */
    public final void m21288setSizeEaSLcWc(long j) {
        this.size = j;
    }

    public final void setSizeMode(@NotNull SizeMode sizeMode) {
        Intrinsics.checkNotNullParameter(sizeMode, "<set-?>");
        this.sizeMode = sizeMode;
    }

    @NotNull
    public String toString() {
        String strM21073toStringimpl = DpSize.m21073toStringimpl(this.size);
        SizeMode sizeMode = this.sizeMode;
        String strChildrenToString = childrenToString();
        StringBuilder sb = new StringBuilder("EmittableSizeBox(size=");
        sb.append(strM21073toStringimpl);
        sb.append(", sizeMode=");
        sb.append(sizeMode);
        sb.append(", children=[\n");
        return AbstractC0622a.m1170p(strChildrenToString, "\n])", sb);
    }
}
