package androidx.compose.p109ui.draw;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.painter.Painter;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.node.DrawModifierNodeKt;
import androidx.compose.p109ui.node.LayoutModifierNodeKt;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000eHÆ\u0003JG\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\b\u0010#\u001a\u00020\u0002H\u0016J\u0013\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0016J\f\u0010.\u001a\u00020,*\u00020/H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, m13886d2 = {"Landroidx/compose/ui/draw/PainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/PainterNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class PainterElement extends ModifierNodeElement<PainterNode> {

    @NotNull
    private final Alignment alignment;
    private final float alpha;

    @Nullable
    private final ColorFilter colorFilter;

    @NotNull
    private final ContentScale contentScale;

    @NotNull
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    public PainterElement(@NotNull Painter painter, boolean z, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float f, @Nullable ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    public static /* synthetic */ PainterElement copy$default(PainterElement painterElement, Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 1) != 0) {
            painter = painterElement.painter;
        }
        if ((i & 2) != 0) {
            z = painterElement.sizeToIntrinsics;
        }
        if ((i & 4) != 0) {
            alignment = painterElement.alignment;
        }
        if ((i & 8) != 0) {
            contentScale = painterElement.contentScale;
        }
        if ((i & 16) != 0) {
            f = painterElement.alpha;
        }
        if ((i & 32) != 0) {
            colorFilter = painterElement.colorFilter;
        }
        float f4 = f;
        ColorFilter colorFilter2 = colorFilter;
        return painterElement.copy(painter, z, alignment, contentScale, f4, colorFilter2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Painter getPainter() {
        return this.painter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @NotNull
    public final PainterElement copy(@NotNull Painter painter, boolean sizeToIntrinsics, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float alpha, @Nullable ColorFilter colorFilter) {
        return new PainterElement(painter, sizeToIntrinsics, alignment, contentScale, alpha, colorFilter);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PainterElement)) {
            return false;
        }
        PainterElement painterElement = (PainterElement) other;
        return Intrinsics.areEqual(this.painter, painterElement.painter) && this.sizeToIntrinsics == painterElement.sizeToIntrinsics && Intrinsics.areEqual(this.alignment, painterElement.alignment) && Intrinsics.areEqual(this.contentScale, painterElement.contentScale) && Float.compare(this.alpha, painterElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, painterElement.colorFilter);
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @Nullable
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @NotNull
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @NotNull
    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        int iM1156b = AbstractC0622a.m1156b(this.alpha, (this.contentScale.hashCode() + ((this.alignment.hashCode() + AbstractC0622a.m1160f(this.sizeToIntrinsics, this.painter.hashCode() * 31, 31)) * 31)) * 31, 31);
        ColorFilter colorFilter = this.colorFilter;
        return iM1156b + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("paint");
        inspectorInfo.getProperties().set("painter", this.painter);
        AbstractC0622a.m1163i(this.sizeToIntrinsics, inspectorInfo.getProperties(), "sizeToIntrinsics", inspectorInfo).set("alignment", this.alignment);
        inspectorInfo.getProperties().set("contentScale", this.contentScale);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
    }

    @NotNull
    public String toString() {
        return "PainterElement(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public PainterNode getNode() {
        return new PainterNode(this.painter, this.sizeToIntrinsics, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull PainterNode node) {
        boolean sizeToIntrinsics = node.getSizeToIntrinsics();
        boolean z = this.sizeToIntrinsics;
        boolean z2 = sizeToIntrinsics != z || (z && !Size.m18349equalsimpl0(node.getPainter().mo19196getIntrinsicSizeNHjbRc(), this.painter.mo19196getIntrinsicSizeNHjbRc()));
        node.setPainter(this.painter);
        node.setSizeToIntrinsics(this.sizeToIntrinsics);
        node.setAlignment(this.alignment);
        node.setContentScale(this.contentScale);
        node.setAlpha(this.alpha);
        node.setColorFilter(this.colorFilter);
        if (z2) {
            LayoutModifierNodeKt.invalidateMeasurement(node);
        }
        DrawModifierNodeKt.invalidateDraw(node);
    }
}
