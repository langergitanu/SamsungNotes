package androidx.compose.foundation.draganddrop;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0083\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\rJ\u001a\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007HÆ\u0003J/\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJT\u0010\u0015\u001a\u00020\u00002\u0019\b\u0002\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00072)\b\u0002\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H\u0016J\f\u0010!\u001a\u00020\u0006*\u00020\"H\u0016R4\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, m13886d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropSourceElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getDrawDragDecoration", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/draganddrop/DragAndDropSourceElement;", "create", "equals", "", "other", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class DragAndDropSourceElement extends ModifierNodeElement<DragAndDropSourceNode> {

    @NotNull
    private final Function2<DragAndDropSourceScope, Continuation<? super Unit>, Object> dragAndDropSourceHandler;

    @NotNull
    private final Function1<DrawScope, Unit> drawDragDecoration;

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropSourceElement(@NotNull Function1<? super DrawScope, Unit> function1, @NotNull Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.drawDragDecoration = function1;
        this.dragAndDropSourceHandler = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DragAndDropSourceElement copy$default(DragAndDropSourceElement dragAndDropSourceElement, Function1 function1, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = dragAndDropSourceElement.drawDragDecoration;
        }
        if ((i & 2) != 0) {
            function2 = dragAndDropSourceElement.dragAndDropSourceHandler;
        }
        return dragAndDropSourceElement.copy(function1, function2);
    }

    @NotNull
    public final Function1<DrawScope, Unit> component1() {
        return this.drawDragDecoration;
    }

    @NotNull
    public final Function2<DragAndDropSourceScope, Continuation<? super Unit>, Object> component2() {
        return this.dragAndDropSourceHandler;
    }

    @NotNull
    public final DragAndDropSourceElement copy(@NotNull Function1<? super DrawScope, Unit> drawDragDecoration, @NotNull Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> dragAndDropSourceHandler) {
        return new DragAndDropSourceElement(drawDragDecoration, dragAndDropSourceHandler);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DragAndDropSourceElement)) {
            return false;
        }
        DragAndDropSourceElement dragAndDropSourceElement = (DragAndDropSourceElement) other;
        return Intrinsics.areEqual(this.drawDragDecoration, dragAndDropSourceElement.drawDragDecoration) && Intrinsics.areEqual(this.dragAndDropSourceHandler, dragAndDropSourceElement.dragAndDropSourceHandler);
    }

    @NotNull
    public final Function2<DragAndDropSourceScope, Continuation<? super Unit>, Object> getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    @NotNull
    public final Function1<DrawScope, Unit> getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public int hashCode() {
        return this.dragAndDropSourceHandler.hashCode() + (this.drawDragDecoration.hashCode() * 31);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("dragSource");
        inspectorInfo.getProperties().set("drawDragDecoration", this.drawDragDecoration);
        inspectorInfo.getProperties().set("dragAndDropSourceHandler", this.dragAndDropSourceHandler);
    }

    @NotNull
    public String toString() {
        return "DragAndDropSourceElement(drawDragDecoration=" + this.drawDragDecoration + ", dragAndDropSourceHandler=" + this.dragAndDropSourceHandler + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    @NotNull
    /* JADX INFO: renamed from: create */
    public DragAndDropSourceNode getNode() {
        return new DragAndDropSourceNode(this.drawDragDecoration, this.dragAndDropSourceHandler);
    }

    @Override // androidx.compose.p109ui.node.ModifierNodeElement
    public void update(@NotNull DragAndDropSourceNode node) {
        node.setDrawDragDecoration(this.drawDragDecoration);
        node.setDragAndDropSourceHandler(this.dragAndDropSourceHandler);
    }
}
