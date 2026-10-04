package androidx.compose.p109ui.window;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(29)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, m13886d2 = {"Landroidx/compose/ui/window/PopupLayoutHelperImpl29;", "Landroidx/compose/ui/window/PopupLayoutHelperImpl;", "()V", "setGestureExclusionRects", "", "composeView", "Landroid/view/View;", "width", "", "height", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class PopupLayoutHelperImpl29 extends PopupLayoutHelperImpl {
    @Override // androidx.compose.p109ui.window.PopupLayoutHelperImpl, androidx.compose.p109ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(@NotNull View composeView, int width, int height) {
        composeView.setSystemGestureExclusionRects(CollectionsKt.mutableListOf(new Rect(0, 0, width, height)));
    }
}
