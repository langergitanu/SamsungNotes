package androidx.compose.foundation;

import androidx.compose.p109ui.draw.DrawModifier;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m13886d2 = {"Landroidx/compose/foundation/IndicationModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "indicationInstance", "Landroidx/compose/foundation/IndicationInstance;", "(Landroidx/compose/foundation/IndicationInstance;)V", "getIndicationInstance", "()Landroidx/compose/foundation/IndicationInstance;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class IndicationModifier implements DrawModifier {

    @NotNull
    private final IndicationInstance indicationInstance;

    public IndicationModifier(@NotNull IndicationInstance indicationInstance) {
        this.indicationInstance = indicationInstance;
    }

    @Override // androidx.compose.p109ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        this.indicationInstance.drawIndication(contentDrawScope);
    }

    @NotNull
    public final IndicationInstance getIndicationInstance() {
        return this.indicationInstance;
    }
}
