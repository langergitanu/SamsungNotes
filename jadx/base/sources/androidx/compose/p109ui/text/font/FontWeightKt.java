package androidx.compose.p109ui.text.font;

import androidx.compose.p109ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m13886d2 = {"lerp", "Landroidx/compose/ui/text/font/FontWeight;", "start", "stop", "fraction", "", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FontWeightKt {
    @NotNull
    public static final FontWeight lerp(@NotNull FontWeight fontWeight, @NotNull FontWeight fontWeight2, float f) {
        return new FontWeight(RangesKt.coerceIn(MathHelpersKt.lerp(fontWeight.getWeight(), fontWeight2.getWeight(), f), 1, 1000));
    }
}
