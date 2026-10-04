package androidx.compose.foundation.text.handwriting;

import androidx.compose.p109ui.Modifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"handwritingHandler", "Landroidx/compose/ui/Modifier;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class HandwritingHandler_androidKt {
    @NotNull
    public static final Modifier handwritingHandler(@NotNull Modifier modifier) {
        return StylusHandwriting_androidKt.isStylusHandwritingSupported() ? modifier.then(new HandwritingHandlerElement()) : modifier;
    }
}
