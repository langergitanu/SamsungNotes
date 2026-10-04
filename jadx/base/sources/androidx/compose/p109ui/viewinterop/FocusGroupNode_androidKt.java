package androidx.compose.p109ui.viewinterop;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusModifierKt;
import androidx.compose.p109ui.focus.FocusOwner;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\u0005*\u00020\rH\u0002¨\u0006\u000e"}, m13886d2 = {"getCurrentlyFocusedRect", "Landroid/graphics/Rect;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "hostView", "Landroid/view/View;", "embeddedView", "containsDescendant", "", "other", "focusInteropModifier", "Landroidx/compose/ui/Modifier;", "getView", "Landroidx/compose/ui/Modifier$Node;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusGroupNode.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusGroupNode.android.kt\nandroidx/compose/ui/viewinterop/FocusGroupNode_androidKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n1#2:241\n*E\n"})
public final class FocusGroupNode_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsDescendant(View view, View view2) {
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view.getParent()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Modifier focusInteropModifier(@NotNull Modifier modifier) {
        return FocusModifierKt.focusTarget(FocusModifierKt.focusTarget(modifier.then(FocusGroupPropertiesElement.INSTANCE)).then(FocusTargetPropertiesElement.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCurrentlyFocusedRect(FocusOwner focusOwner, View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        androidx.compose.p109ui.geometry.Rect focusRect = focusOwner.getFocusRect();
        if (focusRect == null) {
            return null;
        }
        return new Rect((((int) focusRect.getLeft()) + iArr[0]) - iArr2[0], (((int) focusRect.getTop()) + iArr[1]) - iArr2[1], (((int) focusRect.getRight()) + iArr[0]) - iArr2[0], (((int) focusRect.getBottom()) + iArr[1]) - iArr2[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View getView(Modifier.Node node) {
        View interopView = DelegatableNodeKt.requireLayoutNode(node.getNode()).getInteropView();
        if (interopView != null) {
            return interopView;
        }
        throw new IllegalStateException("Could not fetch interop view");
    }
}
