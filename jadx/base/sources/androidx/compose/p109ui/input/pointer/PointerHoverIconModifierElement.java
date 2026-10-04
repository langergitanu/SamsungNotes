package androidx.compose.p109ui.input.pointer;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\f\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "getOverrideDescendants", "()Z", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class PointerHoverIconModifierElement extends ModifierNodeElement<PointerHoverIconModifierNode> {
    public static final int $stable = 0;

    @NotNull
    private final PointerIcon icon;
    private final boolean overrideDescendants;

    public /* synthetic */ PointerHoverIconModifierElement(PointerIcon pointerIcon, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pointerIcon, (i & 2) != 0 ? false : z);
    }

    public static /* synthetic */ PointerHoverIconModifierElement copy$default(PointerHoverIconModifierElement pointerHoverIconModifierElement, PointerIcon pointerIcon, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerIcon = pointerHoverIconModifierElement.icon;
        }
        if ((i & 2) != 0) {
            z = pointerHoverIconModifierElement.overrideDescendants;
        }
        return pointerHoverIconModifierElement.copy(pointerIcon, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PointerIcon getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    @NotNull
    public final PointerHoverIconModifierElement copy(@NotNull PointerIcon icon, boolean overrideDescendants) {
        return new PointerHoverIconModifierElement(icon, overrideDescendants);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointerHoverIconModifierElement)) {
            return false;
        }
        PointerHoverIconModifierElement pointerHoverIconModifierElement = (PointerHoverIconModifierElement) other;
        return Intrinsics.areEqual(this.icon, pointerHoverIconModifierElement.icon) && this.overrideDescendants == pointerHoverIconModifierElement.overrideDescendants;
    }

    @NotNull
    public final PointerIcon getIcon() {
        return this.icon;
    }

    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return Boolean.hashCode(this.overrideDescendants) + (this.icon.hashCode() * 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("pointerHoverIcon");
        inspectorInfo.getProperties().set("icon", this.icon);
        inspectorInfo.getProperties().set("overrideDescendants", Boolean.valueOf(this.overrideDescendants));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("PointerHoverIconModifierElement(icon=");
        sb.append(this.icon);
        sb.append(", overrideDescendants=");
        return AbstractC0622a.m1172r(sb, this.overrideDescendants, PropertyUtils.MAPPED_DELIM2);
    }

    public PointerHoverIconModifierElement(@NotNull PointerIcon pointerIcon, boolean z) {
        this.icon = pointerIcon;
        this.overrideDescendants = z;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    public PointerHoverIconModifierNode create() {
        return new PointerHoverIconModifierNode(this.icon, this.overrideDescendants);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull PointerHoverIconModifierNode node) {
        node.setIcon(this.icon);
        node.setOverrideDescendants(this.overrideDescendants);
    }
}
