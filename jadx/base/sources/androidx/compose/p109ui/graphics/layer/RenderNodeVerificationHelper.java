package androidx.compose.p109ui.graphics.layer;

import android.graphics.RenderNode;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.graphics.RenderEffect;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/RenderNodeVerificationHelper;", "", "()V", "setRenderEffect", "", "renderNode", "Landroid/graphics/RenderNode;", "target", "Landroidx/compose/ui/graphics/RenderEffect;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RenderNodeVerificationHelper {

    @NotNull
    public static final RenderNodeVerificationHelper INSTANCE = new RenderNodeVerificationHelper();

    private RenderNodeVerificationHelper() {
    }

    @DoNotInline
    public final void setRenderEffect(@NotNull RenderNode renderNode, @Nullable RenderEffect target) {
        renderNode.setRenderEffect(target != null ? target.asAndroidRenderEffect() : null);
    }
}
