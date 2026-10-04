package androidx.compose.p109ui.platform;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi29;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "()V", "tmpMatrix", "Landroid/graphics/Matrix;", "tmpPosition", "", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class CalculateMatrixToWindowApi29 implements CalculateMatrixToWindow {

    @NotNull
    private final Matrix tmpMatrix = new Matrix();

    @NotNull
    private final int[] tmpPosition = new int[2];

    @Override // androidx.compose.p109ui.platform.CalculateMatrixToWindow
    @DoNotInline
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo20188calculateMatrixToWindowEL8BTi8(@NotNull View view, @NotNull float[] matrix) {
        this.tmpMatrix.reset();
        view.transformMatrixToGlobal(this.tmpMatrix);
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            view = parent;
            parent = view.getParent();
        }
        view.getLocationOnScreen(this.tmpPosition);
        int[] iArr = this.tmpPosition;
        int i = iArr[0];
        int i2 = iArr[1];
        view.getLocationInWindow(iArr);
        int[] iArr2 = this.tmpPosition;
        this.tmpMatrix.postTranslate(iArr2[0] - i, iArr2[1] - i2);
        AndroidMatrixConversions_androidKt.m18396setFromtUYjHk(matrix, this.tmpMatrix);
    }
}
