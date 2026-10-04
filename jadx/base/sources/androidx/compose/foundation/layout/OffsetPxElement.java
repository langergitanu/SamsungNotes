package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0013\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\f\u0010\u001d\u001a\u00020\f*\u00020\u000bH\u0016R\"\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/foundation/layout/OffsetPxElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetPxNode;", TypedValues.Cycle.S_WAVE_OFFSET, "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "rtlAware", "", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "", "(Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;)V", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getOffset", "getRtlAware", "()Z", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class OffsetPxElement extends ModifierNodeElement<OffsetPxNode> {

    @NotNull
    private final Function1<InspectorInfo, Unit> inspectorInfo;

    @NotNull
    private final Function1<Density, IntOffset> offset;
    private final boolean rtlAware;

    /* JADX WARN: Multi-variable type inference failed */
    public OffsetPxElement(@NotNull Function1<? super Density, IntOffset> function1, boolean z, @NotNull Function1<? super InspectorInfo, Unit> function12) {
        this.offset = function1;
        this.rtlAware = z;
        this.inspectorInfo = function12;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        OffsetPxElement offsetPxElement = other instanceof OffsetPxElement ? (OffsetPxElement) other : null;
        return offsetPxElement != null && this.offset == offsetPxElement.offset && this.rtlAware == offsetPxElement.rtlAware;
    }

    @NotNull
    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    @NotNull
    public final Function1<Density, IntOffset> getOffset() {
        return this.offset;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return Boolean.hashCode(this.rtlAware) + (this.offset.hashCode() * 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        this.inspectorInfo.invoke(inspectorInfo);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("OffsetPxModifier(offset=");
        sb.append(this.offset);
        sb.append(", rtlAware=");
        return AbstractC0622a.m1172r(sb, this.rtlAware, PropertyUtils.MAPPED_DELIM2);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public OffsetPxNode getNode() {
        return new OffsetPxNode(this.offset, this.rtlAware);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull OffsetPxNode node) {
        node.setOffset(this.offset);
        node.setRtlAware(this.rtlAware);
    }
}
