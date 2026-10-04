package androidx.compose.p109ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/ui/window/PopupLayoutHelperImpl;", "Landroidx/compose/ui/window/PopupLayoutHelper;", "()V", "getWindowVisibleDisplayFrame", "", "composeView", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "setGestureExclusionRects", "width", "", "height", "updateViewLayout", "windowManager", "Landroid/view/WindowManager;", "popupView", ActionHandler.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
class PopupLayoutHelperImpl implements PopupLayoutHelper {
    @Override // androidx.compose.p109ui.window.PopupLayoutHelper
    public void getWindowVisibleDisplayFrame(@NotNull View composeView, @NotNull Rect outRect) {
        composeView.getWindowVisibleDisplayFrame(outRect);
    }

    @Override // androidx.compose.p109ui.window.PopupLayoutHelper
    public void updateViewLayout(@NotNull WindowManager windowManager, @NotNull View popupView, @NotNull ViewGroup.LayoutParams params) {
        windowManager.updateViewLayout(popupView, params);
    }

    @Override // androidx.compose.p109ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(@NotNull View composeView, int width, int height) {
    }
}
