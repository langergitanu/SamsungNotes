package androidx.compose.p109ui.graphics;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0004H\u0000\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0002¨\u0006\b"}, m13886d2 = {"isLayerPersistenceEnabled", "", "()Z", "GraphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "layerContainer", "Landroid/view/ViewGroup;", "isLayerManagerInitialized", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidGraphicsContext_androidKt {
    @NotNull
    public static final GraphicsContext GraphicsContext(@NotNull ViewGroup viewGroup) {
        return new AndroidGraphicsContext(viewGroup);
    }

    public static final boolean isLayerManagerInitialized(@NotNull GraphicsContext graphicsContext) {
        Intrinsics.checkNotNull(graphicsContext, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidGraphicsContext");
        return ((AndroidGraphicsContext) graphicsContext).isLayerManagerInitialized();
    }

    public static final boolean isLayerPersistenceEnabled() {
        return false;
    }
}
