package androidx.compose.p109ui.draw;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.GraphicsLayerScope;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0016\u0010\u0018\u001a\u00020\u0004HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0013J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0016\u0010\u001c\u001a\u00020\nHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000eJ\u0016\u0010\u001e\u001a\u00020\nHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u000eJE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u0002H\u0016J\u0019\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\u0002J\u0013\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u0002H\u0016J\f\u00102\u001a\u00020'*\u000203H\u0016R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, m13886d2 = {"Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/BlockGraphicsLayerModifier;", "elevation", "Landroidx/compose/ui/unit/Dp;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "clip", "", "ambientColor", "Landroidx/compose/ui/graphics/Color;", "spotColor", "(FLandroidx/compose/ui/graphics/Shape;ZJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAmbientColor-0d7_KjU", "()J", "J", "getClip", "()Z", "getElevation-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getSpotColor-0d7_KjU", "component1", "component1-D9Ej5fM", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "copy", "copy-gNMxBKI", "(FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "create", "createBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class ShadowGraphicsLayerElement extends ModifierNodeElement<BlockGraphicsLayerModifier> {
    public static final int $stable = 0;
    private final long ambientColor;
    private final boolean clip;
    private final float elevation;

    @NotNull
    private final Shape shape;
    private final long spotColor;

    public /* synthetic */ ShadowGraphicsLayerElement(float f, Shape shape, boolean z, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, shape, z, j, j2);
    }

    /* JADX INFO: renamed from: copy-gNMxBKI$default, reason: not valid java name */
    public static /* synthetic */ ShadowGraphicsLayerElement m18180copygNMxBKI$default(ShadowGraphicsLayerElement shadowGraphicsLayerElement, float f, Shape shape, boolean z, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = shadowGraphicsLayerElement.elevation;
        }
        if ((i & 2) != 0) {
            shape = shadowGraphicsLayerElement.shape;
        }
        if ((i & 4) != 0) {
            z = shadowGraphicsLayerElement.clip;
        }
        if ((i & 8) != 0) {
            j = shadowGraphicsLayerElement.ambientColor;
        }
        if ((i & 16) != 0) {
            j2 = shadowGraphicsLayerElement.spotColor;
        }
        long j3 = j2;
        boolean z2 = z;
        return shadowGraphicsLayerElement.m18184copygNMxBKI(f, shape, z2, j, j3);
    }

    private final Function1<GraphicsLayerScope, Unit> createBlock() {
        return new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.ShadowGraphicsLayerElement.createBlock.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GraphicsLayerScope graphicsLayerScope) {
                graphicsLayerScope.setShadowElevation(graphicsLayerScope.mo15546toPx0680j_4(ShadowGraphicsLayerElement.this.m18186getElevationD9Ej5fM()));
                graphicsLayerScope.setShape(ShadowGraphicsLayerElement.this.getShape());
                graphicsLayerScope.setClip(ShadowGraphicsLayerElement.this.getClip());
                graphicsLayerScope.mo18715setAmbientShadowColor8_81llA(ShadowGraphicsLayerElement.this.m18185getAmbientColor0d7_KjU());
                graphicsLayerScope.mo18717setSpotShadowColor8_81llA(ShadowGraphicsLayerElement.this.m18187getSpotColor0d7_KjU());
            }
        };
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getElevation() {
        return this.elevation;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getClip() {
        return this.clip;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getAmbientColor() {
        return this.ambientColor;
    }

    /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name and from getter */
    public final long getSpotColor() {
        return this.spotColor;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-gNMxBKI, reason: not valid java name */
    public final ShadowGraphicsLayerElement m18184copygNMxBKI(float elevation, @NotNull Shape shape, boolean clip, long ambientColor, long spotColor) {
        return new ShadowGraphicsLayerElement(elevation, shape, clip, ambientColor, spotColor, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShadowGraphicsLayerElement)) {
            return false;
        }
        ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) other;
        return C2256Dp.m20973equalsimpl0(this.elevation, shadowGraphicsLayerElement.elevation) && Intrinsics.areEqual(this.shape, shadowGraphicsLayerElement.shape) && this.clip == shadowGraphicsLayerElement.clip && Color.m18526equalsimpl0(this.ambientColor, shadowGraphicsLayerElement.ambientColor) && Color.m18526equalsimpl0(this.spotColor, shadowGraphicsLayerElement.spotColor);
    }

    /* JADX INFO: renamed from: getAmbientColor-0d7_KjU, reason: not valid java name */
    public final long m18185getAmbientColor0d7_KjU() {
        return this.ambientColor;
    }

    public final boolean getClip() {
        return this.clip;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m18186getElevationD9Ej5fM() {
        return this.elevation;
    }

    @NotNull
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: getSpotColor-0d7_KjU, reason: not valid java name */
    public final long m18187getSpotColor0d7_KjU() {
        return this.spotColor;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return Color.m18532hashCodeimpl(this.spotColor) + AbstractC0622a.m1158d(this.ambientColor, AbstractC0622a.m1160f(this.clip, (this.shape.hashCode() + (C2256Dp.m20974hashCodeimpl(this.elevation) * 31)) * 31, 31), 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName(VElementKey.SHADOW);
        AbstractC0622a.m1162h(this.elevation, inspectorInfo.getProperties(), "elevation", inspectorInfo).set(VMetaDataKey.META_KEY_SHAPE, this.shape);
        AbstractC0622a.m1163i(this.clip, inspectorInfo.getProperties(), "clip", inspectorInfo).set("ambientColor", Color.m18515boximpl(this.ambientColor));
        inspectorInfo.getProperties().set("spotColor", Color.m18515boximpl(this.spotColor));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ShadowGraphicsLayerElement(elevation=");
        AbstractC0622a.m1151A(sb, ", shape=", this.elevation);
        sb.append(this.shape);
        sb.append(", clip=");
        sb.append(this.clip);
        sb.append(", ambientColor=");
        sb.append((Object) Color.m18533toStringimpl(this.ambientColor));
        sb.append(", spotColor=");
        sb.append((Object) Color.m18533toStringimpl(this.spotColor));
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }

    private ShadowGraphicsLayerElement(float f, Shape shape, boolean z, long j, long j2) {
        this.elevation = f;
        this.shape = shape;
        this.clip = z;
        this.ambientColor = j;
        this.spotColor = j2;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public BlockGraphicsLayerModifier getNode() {
        return new BlockGraphicsLayerModifier(createBlock());
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull BlockGraphicsLayerModifier node) {
        node.setLayerBlock(createBlock());
        node.invalidateLayerBlock();
    }
}
