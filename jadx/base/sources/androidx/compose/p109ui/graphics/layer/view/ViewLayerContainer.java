package androidx.compose.p109ui.graphics.layer.view;

import android.content.Context;
import android.graphics.Canvas;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0004¨\u0006\n"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/view/ViewLayerContainer;", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchGetDisplayList", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ViewLayerContainer extends DrawChildContainer {
    public ViewLayerContainer(@NotNull Context context) {
        super(context);
    }

    public final void dispatchGetDisplayList() {
    }

    @Override // androidx.compose.p109ui.graphics.layer.view.DrawChildContainer, android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
    }
}
