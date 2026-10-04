package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\f\u0010 \u001a\u00020\u000b*\u00020\nH\u0016R\"\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m13886d2 = {"Landroidx/compose/foundation/layout/OffsetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetNode;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getRtlAware", "()Z", "getX-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getY-D9Ej5fM", "create", "equals", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class OffsetElement extends ModifierNodeElement<OffsetNode> {

    @NotNull
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final boolean rtlAware;
    private final float x;
    private final float y;

    public /* synthetic */ OffsetElement(float f, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, z, function1);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        OffsetElement offsetElement = other instanceof OffsetElement ? (OffsetElement) other : null;
        return offsetElement != null && C2256Dp.m20973equalsimpl0(this.x, offsetElement.x) && C2256Dp.m20973equalsimpl0(this.y, offsetElement.y) && this.rtlAware == offsetElement.rtlAware;
    }

    @NotNull
    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name and from getter */
    public final float getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name and from getter */
    public final float getY() {
        return this.y;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return Boolean.hashCode(this.rtlAware) + AbstractC0622a.m1153C(this.y, C2256Dp.m20974hashCodeimpl(this.x) * 31, 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        this.inspectorInfo.invoke(inspectorInfo);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("OffsetModifierElement(x=");
        AbstractC0622a.m1151A(sb, ", y=", this.x);
        AbstractC0622a.m1151A(sb, ", rtlAware=", this.y);
        return AbstractC0622a.m1172r(sb, this.rtlAware, PropertyUtils.MAPPED_DELIM2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private OffsetElement(float f, float f4, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        this.x = f;
        this.y = f4;
        this.rtlAware = z;
        this.inspectorInfo = function1;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public OffsetNode getNode() {
        return new OffsetNode(this.x, this.y, this.rtlAware, null);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull OffsetNode node) {
        node.m15818setX0680j_4(this.x);
        node.m15819setY0680j_4(this.y);
        node.setRtlAware(this.rtlAware);
    }
}
