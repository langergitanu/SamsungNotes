package androidx.compose.p109ui.graphics;

import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0007\u001a\u00020\b\u001a\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, m13886d2 = {"DefaultCameraDistance", "", "DefaultShadowColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultShadowColor", "()J", "J", "GraphicsLayerScope", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "rememberGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGraphicsLayerScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GraphicsLayerScope.kt\nandroidx/compose/ui/graphics/GraphicsLayerScopeKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,464:1\n77#2:465\n1225#3,6:466\n*S KotlinDebug\n*F\n+ 1 GraphicsLayerScope.kt\nandroidx/compose/ui/graphics/GraphicsLayerScopeKt\n*L\n258#1:465\n259#1:466,6\n*E\n"})
public final class GraphicsLayerScopeKt {
    public static final float DefaultCameraDistance = 8.0f;
    private static final long DefaultShadowColor = Color.INSTANCE.m18551getBlack0d7_KjU();

    @NotNull
    public static final GraphicsLayerScope GraphicsLayerScope() {
        return new ReusableGraphicsLayerScope();
    }

    public static final long getDefaultShadowColor() {
        return DefaultShadowColor;
    }

    @Composable
    @ComposableOpenTarget(index = -1)
    @NotNull
    public static final GraphicsLayer rememberGraphicsLayer(@Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(158092365, i, -1, "androidx.compose.ui.graphics.rememberGraphicsLayer (GraphicsLayerScope.kt:256)");
        }
        GraphicsContext graphicsContext = (GraphicsContext) composer.consume(CompositionLocalsKt.getLocalGraphicsContext());
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new GraphicsContextObserver(graphicsContext);
            composer.updateRememberedValue(objRememberedValue);
        }
        GraphicsLayer graphicsLayer = ((GraphicsContextObserver) objRememberedValue).getGraphicsLayer();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return graphicsLayer;
    }
}
