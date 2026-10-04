package androidx.compose.p109ui.draw;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.runtime.Stable;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0007¨\u0006\u0005"}, m13886d2 = {"clip", "Landroidx/compose/ui/Modifier;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "clipToBounds", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ClipKt {
    @Stable
    @NotNull
    public static final Modifier clip(@NotNull Modifier modifier, @NotNull Shape shape) {
        return GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape, true, null, 0L, 0L, 0, 124927, null);
    }

    @Stable
    @NotNull
    public static final Modifier clipToBounds(@NotNull Modifier modifier) {
        return GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, true, null, 0L, 0L, 0, 126975, null);
    }
}
