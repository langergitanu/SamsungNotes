package androidx.compose.foundation.text;

import androidx.compose.p109ui.layout.ParentDataModifier;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\u0000*\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/foundation/text/TextRangeLayoutModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "measurePolicy", "Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;", "(Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;)V", "getMeasurePolicy", "()Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextRangeLayoutModifier implements ParentDataModifier {
    public static final int $stable = 0;

    @NotNull
    private final TextRangeScopeMeasurePolicy measurePolicy;

    public TextRangeLayoutModifier(@NotNull TextRangeScopeMeasurePolicy textRangeScopeMeasurePolicy) {
        this.measurePolicy = textRangeScopeMeasurePolicy;
    }

    @NotNull
    public final TextRangeScopeMeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.p109ui.layout.ParentDataModifier
    @NotNull
    public TextRangeLayoutModifier modifyParentData(@NotNull Density density, @Nullable Object obj) {
        return this;
    }
}
