package androidx.compose.p109ui.scrollcapture;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LayoutCoordinatesKt;
import androidx.compose.p109ui.node.NodeCoordinator;
import androidx.compose.p109ui.platform.SemanticsUtils_androidKt;
import androidx.compose.p109ui.semantics.ScrollAxisRange;
import androidx.compose.p109ui.semantics.SemanticsActions;
import androidx.compose.p109ui.semantics.SemanticsConfigurationKt;
import androidx.compose.p109ui.semantics.SemanticsNode;
import androidx.compose.p109ui.semantics.SemanticsProperties;
import androidx.compose.p109ui.unit.IntRect;
import androidx.compose.p109ui.unit.IntRectKt;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u0015H\u0002\u001a\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018*\u00020\u0002H\u0002\u001a!\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0015H\u0082\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"E\u0010\u0005\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m13886d2 = {"canScrollVertically", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "getCanScrollVertically", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "scrollCaptureScrollByAction", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", TypedValues.Cycle.S_WAVE_OFFSET, "Lkotlin/coroutines/Continuation;", "", "getScrollCaptureScrollByAction", "(Landroidx/compose/ui/semantics/SemanticsNode;)Lkotlin/jvm/functions/Function2;", "visitScrollCaptureCandidates", "", "fromNode", DBSchema.CategoryTreeClosure.DEPTH, "", "onCandidate", "Lkotlin/Function1;", "Landroidx/compose/ui/scrollcapture/ScrollCaptureCandidate;", "getChildrenForSearch", "", "visitDescendants", "onNode", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScrollCapture.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScrollCapture.android.kt\nandroidx/compose/ui/scrollcapture/ScrollCapture_androidKt\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 4 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,232:1\n199#1:233\n200#1:237\n201#1,2:239\n203#1:242\n204#1,5:252\n1208#2:234\n1187#2,2:235\n1208#2:257\n1187#2,2:258\n138#3:238\n48#3:241\n138#3:260\n48#3:261\n138#3:262\n66#4,9:243\n*S KotlinDebug\n*F\n+ 1 ScrollCapture.android.kt\nandroidx/compose/ui/scrollcapture/ScrollCapture_androidKt\n*L\n134#1:233\n134#1:237\n134#1:239,2\n134#1:242\n134#1:252,5\n134#1:234\n134#1:235,2\n199#1:257\n199#1:258,2\n134#1:238\n134#1:241\n200#1:260\n202#1:261\n205#1:262\n140#1:243,9\n*E\n"})
public final class ScrollCapture_androidKt {
    private static final boolean getCanScrollVertically(SemanticsNode semanticsNode) {
        Function2<Offset, Continuation<? super Offset>, Object> scrollCaptureScrollByAction = getScrollCaptureScrollByAction(semanticsNode);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        return (scrollCaptureScrollByAction == null || scrollAxisRange == null || scrollAxisRange.getMaxValue().invoke().floatValue() <= 0.0f) ? false : true;
    }

    private static final List<SemanticsNode> getChildrenForSearch(SemanticsNode semanticsNode) {
        return semanticsNode.getChildren$ui_release(false, false, false);
    }

    @Nullable
    public static final Function2<Offset, Continuation<? super Offset>, Object> getScrollCaptureScrollByAction(@NotNull SemanticsNode semanticsNode) {
        return (Function2) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollByOffset());
    }

    private static final void visitDescendants(SemanticsNode semanticsNode, Function1<? super SemanticsNode, Boolean> function1) {
        MutableVector mutableVector = new MutableVector(new SemanticsNode[16], 0);
        mutableVector.addAll(mutableVector.getSize(), (List) getChildrenForSearch(semanticsNode));
        while (mutableVector.isNotEmpty()) {
            SemanticsNode semanticsNode2 = (SemanticsNode) AbstractC1974b.m1314g(mutableVector, 1);
            if (function1.invoke(semanticsNode2).booleanValue()) {
                mutableVector.addAll(mutableVector.getSize(), (List) getChildrenForSearch(semanticsNode2));
            }
        }
    }

    private static final void visitScrollCaptureCandidates(SemanticsNode semanticsNode, int i, Function1<? super ScrollCaptureCandidate, Unit> function1) {
        SemanticsNode semanticsNode2;
        MutableVector mutableVector = new MutableVector(new SemanticsNode[16], 0);
        List<SemanticsNode> childrenForSearch = getChildrenForSearch(semanticsNode);
        while (true) {
            mutableVector.addAll(mutableVector.getSize(), (List) childrenForSearch);
            while (mutableVector.isNotEmpty()) {
                semanticsNode2 = (SemanticsNode) AbstractC1974b.m1314g(mutableVector, 1);
                if (SemanticsUtils_androidKt.isVisible(semanticsNode2) && !semanticsNode2.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getDisabled())) {
                    NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = semanticsNode2.findCoordinatorToGetBounds$ui_release();
                    if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release == null) {
                        throw AbstractC1974b.m1327t("Expected semantics node to have a coordinator.");
                    }
                    LayoutCoordinates coordinates = nodeCoordinatorFindCoordinatorToGetBounds$ui_release.getCoordinates();
                    IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(LayoutCoordinatesKt.boundsInWindow(coordinates));
                    if (intRectRoundToIntRect.isEmpty()) {
                        continue;
                    } else {
                        if (!getCanScrollVertically(semanticsNode2)) {
                            break;
                        }
                        int i2 = 1 + i;
                        function1.invoke(new ScrollCaptureCandidate(semanticsNode2, i2, intRectRoundToIntRect, coordinates));
                        visitScrollCaptureCandidates(semanticsNode2, i2, function1);
                    }
                }
            }
            return;
            childrenForSearch = getChildrenForSearch(semanticsNode2);
        }
    }

    public static /* synthetic */ void visitScrollCaptureCandidates$default(SemanticsNode semanticsNode, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        visitScrollCaptureCandidates(semanticsNode, i, function1);
    }
}
