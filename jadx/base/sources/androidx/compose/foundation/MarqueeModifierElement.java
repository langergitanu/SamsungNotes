package androidx.compose.foundation;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0010\u001a\u00020\u0004HÂ\u0003J\u0016\u0010\u0011\u001a\u00020\u0006HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001a\u00020\nHÂ\u0003J\u0016\u0010\u0017\u001a\u00020\fHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0002H\u0016J\f\u0010(\u001a\u00020&*\u00020)H\u0016R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\fX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m13886d2 = {"Landroidx/compose/foundation/MarqueeModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MarqueeModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", TokenizerME.NO_SPLIT, "component1", "component2", "component2-ZbEOnfQ", "()I", "component3", "component4", "component5", "component6", "component6-D9Ej5fM", "()F", "copy", "copy-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/foundation/MarqueeModifierElement;", "create", "equals", "", "other", "", "hashCode", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class MarqueeModifierElement extends ModifierNodeElement<MarqueeModifierNode> {
    private final int animationMode;
    private final int delayMillis;
    private final int initialDelayMillis;
    private final int iterations;

    @NotNull
    private final MarqueeSpacing spacing;
    private final float velocity;

    public /* synthetic */ MarqueeModifierElement(int i, int i2, int i4, int i5, MarqueeSpacing marqueeSpacing, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i4, i5, marqueeSpacing, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getIterations() {
        return this.iterations;
    }

    /* JADX INFO: renamed from: component2-ZbEOnfQ, reason: not valid java name and from getter */
    private final int getAnimationMode() {
        return this.animationMode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getDelayMillis() {
        return this.delayMillis;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final int getInitialDelayMillis() {
        return this.initialDelayMillis;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final MarqueeSpacing getSpacing() {
        return this.spacing;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name and from getter */
    private final float getVelocity() {
        return this.velocity;
    }

    /* JADX INFO: renamed from: copy-lWfNwf4$default, reason: not valid java name */
    public static /* synthetic */ MarqueeModifierElement m15492copylWfNwf4$default(MarqueeModifierElement marqueeModifierElement, int i, int i2, int i4, int i5, MarqueeSpacing marqueeSpacing, float f, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = marqueeModifierElement.iterations;
        }
        if ((i6 & 2) != 0) {
            i2 = marqueeModifierElement.animationMode;
        }
        if ((i6 & 4) != 0) {
            i4 = marqueeModifierElement.delayMillis;
        }
        if ((i6 & 8) != 0) {
            i5 = marqueeModifierElement.initialDelayMillis;
        }
        if ((i6 & 16) != 0) {
            marqueeSpacing = marqueeModifierElement.spacing;
        }
        if ((i6 & 32) != 0) {
            f = marqueeModifierElement.velocity;
        }
        MarqueeSpacing marqueeSpacing2 = marqueeSpacing;
        float f4 = f;
        return marqueeModifierElement.m15493copylWfNwf4(i, i2, i4, i5, marqueeSpacing2, f4);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-lWfNwf4, reason: not valid java name */
    public final MarqueeModifierElement m15493copylWfNwf4(int iterations, int animationMode, int delayMillis, int initialDelayMillis, @NotNull MarqueeSpacing spacing, float velocity) {
        return new MarqueeModifierElement(iterations, animationMode, delayMillis, initialDelayMillis, spacing, velocity, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarqueeModifierElement)) {
            return false;
        }
        MarqueeModifierElement marqueeModifierElement = (MarqueeModifierElement) other;
        return this.iterations == marqueeModifierElement.iterations && MarqueeAnimationMode.m15483equalsimpl0(this.animationMode, marqueeModifierElement.animationMode) && this.delayMillis == marqueeModifierElement.delayMillis && this.initialDelayMillis == marqueeModifierElement.initialDelayMillis && Intrinsics.areEqual(this.spacing, marqueeModifierElement.spacing) && C2256Dp.m20973equalsimpl0(this.velocity, marqueeModifierElement.velocity);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return C2256Dp.m20974hashCodeimpl(this.velocity) + ((this.spacing.hashCode() + AbstractC0622a.m1157c(this.initialDelayMillis, AbstractC0622a.m1157c(this.delayMillis, (MarqueeAnimationMode.m15484hashCodeimpl(this.animationMode) + (Integer.hashCode(this.iterations) * 31)) * 31, 31), 31)) * 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("basicMarquee");
        inspectorInfo.getProperties().set("iterations", Integer.valueOf(this.iterations));
        inspectorInfo.getProperties().set("animationMode", MarqueeAnimationMode.m15480boximpl(this.animationMode));
        inspectorInfo.getProperties().set("delayMillis", Integer.valueOf(this.delayMillis));
        inspectorInfo.getProperties().set("initialDelayMillis", Integer.valueOf(this.initialDelayMillis));
        inspectorInfo.getProperties().set("spacing", this.spacing);
        inspectorInfo.getProperties().set("velocity", C2256Dp.m20966boximpl(this.velocity));
    }

    @NotNull
    public String toString() {
        return "MarqueeModifierElement(iterations=" + this.iterations + ", animationMode=" + ((Object) MarqueeAnimationMode.m15485toStringimpl(this.animationMode)) + ", delayMillis=" + this.delayMillis + ", initialDelayMillis=" + this.initialDelayMillis + ", spacing=" + this.spacing + ", velocity=" + ((Object) C2256Dp.m20979toStringimpl(this.velocity)) + PropertyUtils.MAPPED_DELIM2;
    }

    private MarqueeModifierElement(int i, int i2, int i4, int i5, MarqueeSpacing marqueeSpacing, float f) {
        this.iterations = i;
        this.animationMode = i2;
        this.delayMillis = i4;
        this.initialDelayMillis = i5;
        this.spacing = marqueeSpacing;
        this.velocity = f;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public MarqueeModifierNode getNode() {
        return new MarqueeModifierNode(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull MarqueeModifierNode node) {
        node.m15496updatelWfNwf4(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity);
    }
}
