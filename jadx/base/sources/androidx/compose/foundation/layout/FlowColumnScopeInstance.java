package androidx.compose.foundation.layout;

import androidx.annotation.FloatRange;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.Measured;
import androidx.compose.p109ui.layout.VerticalAlignmentLine;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0097\u0001J!\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0097\u0001J\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0097\u0001J\u0014\u0010\u000f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J!\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0097\u0001¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/foundation/layout/FlowColumnScopeInstance;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "fillMaxColumnWidth", "fraction", "", "weight", VElementKey.FILL, "", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFlowLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowLayout.kt\nandroidx/compose/foundation/layout/FlowColumnScopeInstance\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1544:1\n1#2:1545\n*E\n"})
public final class FlowColumnScopeInstance implements ColumnScope, FlowColumnScope {
    public static final int $stable = 0;

    @NotNull
    public static final FlowColumnScopeInstance INSTANCE = new FlowColumnScopeInstance();
    private final /* synthetic */ ColumnScopeInstance $$delegate_0 = ColumnScopeInstance.INSTANCE;

    private FlowColumnScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    @Stable
    @NotNull
    public Modifier align(@NotNull Modifier modifier, @NotNull Alignment.Horizontal horizontal) {
        return this.$$delegate_0.align(modifier, horizontal);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    @Stable
    @NotNull
    public Modifier alignBy(@NotNull Modifier modifier, @NotNull VerticalAlignmentLine verticalAlignmentLine) {
        return this.$$delegate_0.alignBy(modifier, verticalAlignmentLine);
    }

    @Override // androidx.compose.foundation.layout.FlowColumnScope
    @NotNull
    public Modifier fillMaxColumnWidth(@NotNull Modifier modifier, float f) {
        double d = f;
        if (d < 0.0d) {
            throw new IllegalArgumentException(("invalid fraction " + f + "; must be greater than or equal to zero").toString());
        }
        if (d <= 1.0d) {
            return modifier.then(new FillCrossAxisSizeElement(f));
        }
        throw new IllegalArgumentException(("invalid fraction " + f + "; must not be greater than 1.0").toString());
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    @Stable
    @NotNull
    public Modifier weight(@NotNull Modifier modifier, @FloatRange(from = 0.0d, fromInclusive = false) float f, boolean z) {
        return this.$$delegate_0.weight(modifier, f, z);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    @Stable
    @NotNull
    public Modifier alignBy(@NotNull Modifier modifier, @NotNull Function1<? super Measured, Integer> function1) {
        return this.$$delegate_0.alignBy(modifier, function1);
    }
}
