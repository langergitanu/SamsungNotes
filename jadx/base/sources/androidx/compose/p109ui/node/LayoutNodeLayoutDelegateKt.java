package androidx.compose.p109ui.node;

import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.runtime.collection.MutableVector;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a9\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b*\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00070\fH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"MeasuredTwiceErrorMessage", "", "isOutMostLookaheadRoot", "", "Landroidx/compose/ui/node/LayoutNode;", "updateChildMeasurables", "", "T", "Landroidx/compose/ui/layout/Measurable;", RtspHeaders.Values.DESTINATION, "Landroidx/compose/runtime/collection/MutableVector;", "transform", "Lkotlin/Function1;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutNodeLayoutDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutNodeLayoutDelegate.kt\nandroidx/compose/ui/node/LayoutNodeLayoutDelegateKt\n+ 2 LayoutNode.kt\nandroidx/compose/ui/node/LayoutNode\n+ 3 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,1969:1\n204#2:1970\n476#3,11:1971\n*S KotlinDebug\n*F\n+ 1 LayoutNodeLayoutDelegate.kt\nandroidx/compose/ui/node/LayoutNodeLayoutDelegateKt\n*L\n1864#1:1970\n1864#1:1971,11\n*E\n"})
public final class LayoutNodeLayoutDelegateKt {

    @NotNull
    private static final String MeasuredTwiceErrorMessage = "measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()";

    public static final boolean isOutMostLookaheadRoot(@NotNull LayoutNode layoutNode) {
        if (layoutNode.getLookaheadRoot() == null) {
            return false;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        return (parent$ui_release != null ? parent$ui_release.getLookaheadRoot() : null) == null || layoutNode.getLayoutDelegate().getDetachedFromParentLookaheadPass();
    }

    private static final <T extends Measurable> void updateChildMeasurables(LayoutNode layoutNode, MutableVector<T> mutableVector, Function1<? super LayoutNode, ? extends T> function1) {
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector2.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode2 = content[i];
                if (mutableVector.getSize() <= i) {
                    mutableVector.add(function1.invoke(layoutNode2));
                } else {
                    mutableVector.set(i, function1.invoke(layoutNode2));
                }
                i++;
            } while (i < size);
        }
        mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.getSize());
    }
}
