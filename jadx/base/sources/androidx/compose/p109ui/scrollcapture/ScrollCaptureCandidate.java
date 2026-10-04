package androidx.compose.p109ui.scrollcapture;

import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.semantics.SemanticsNode;
import androidx.compose.p109ui.unit.IntRect;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/ui/scrollcapture/ScrollCaptureCandidate;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", DBSchema.CategoryTreeClosure.DEPTH, "", "viewportBoundsInWindow", "Landroidx/compose/ui/unit/IntRect;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/semantics/SemanticsNode;ILandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getDepth", "()I", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getViewportBoundsInWindow", "()Landroidx/compose/ui/unit/IntRect;", "toString", "", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class ScrollCaptureCandidate {

    @NotNull
    private final LayoutCoordinates coordinates;
    private final int depth;

    @NotNull
    private final SemanticsNode node;

    @NotNull
    private final IntRect viewportBoundsInWindow;

    public ScrollCaptureCandidate(@NotNull SemanticsNode semanticsNode, int i, @NotNull IntRect intRect, @NotNull LayoutCoordinates layoutCoordinates) {
        this.node = semanticsNode;
        this.depth = i;
        this.viewportBoundsInWindow = intRect;
        this.coordinates = layoutCoordinates;
    }

    @NotNull
    public final LayoutCoordinates getCoordinates() {
        return this.coordinates;
    }

    public final int getDepth() {
        return this.depth;
    }

    @NotNull
    public final SemanticsNode getNode() {
        return this.node;
    }

    @NotNull
    public final IntRect getViewportBoundsInWindow() {
        return this.viewportBoundsInWindow;
    }

    @NotNull
    public String toString() {
        return "ScrollCaptureCandidate(node=" + this.node + ", depth=" + this.depth + ", viewportBoundsInWindow=" + this.viewportBoundsInWindow + ", coordinates=" + this.coordinates + PropertyUtils.MAPPED_DELIM2;
    }
}
