package androidx.compose.foundation.text;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.SolidColor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/foundation/text/BasicTextFieldDefaults;", "", "()V", "CursorBrush", "Landroidx/compose/ui/graphics/SolidColor;", "getCursorBrush", "()Landroidx/compose/ui/graphics/SolidColor;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class BasicTextFieldDefaults {

    @NotNull
    public static final BasicTextFieldDefaults INSTANCE = new BasicTextFieldDefaults();

    @NotNull
    private static final SolidColor CursorBrush = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), null);

    private BasicTextFieldDefaults() {
    }

    @NotNull
    public final SolidColor getCursorBrush() {
        return CursorBrush;
    }
}
