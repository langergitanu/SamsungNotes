package androidx.compose.p109ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.p109ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ\u001e\u0010\u0011\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0016\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi21;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "tmpLocation", "", "[F", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "transformMatrixToWindow", "transformMatrixToWindow-EL8BTi8", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {

    @NotNull
    private final int[] tmpLocation;

    @NotNull
    private final float[] tmpMatrix;

    public /* synthetic */ CalculateMatrixToWindowApi21(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    /* JADX INFO: renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m20189preConcattUYjHk(float[] fArr, Matrix matrix) {
        AndroidMatrixConversions_androidKt.m18396setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m20186preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m20190preTranslate3XD1CNM(float[] fArr, float f, float f4) {
        AndroidComposeView_androidKt.m20187preTranslatecG2Xzmc(fArr, f, f4, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m20191transformMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m20191transformMatrixToWindowEL8BTi8((View) parent, matrix);
            m20190preTranslate3XD1CNM(matrix, -view.getScrollX(), -view.getScrollY());
            m20190preTranslate3XD1CNM(matrix, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.tmpLocation);
            m20190preTranslate3XD1CNM(matrix, -view.getScrollX(), -view.getScrollY());
            m20190preTranslate3XD1CNM(matrix, r0[0], r0[1]);
        }
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        m20189preConcattUYjHk(matrix, matrix2);
    }

    @Override // androidx.compose.p109ui.platform.CalculateMatrixToWindow
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo20188calculateMatrixToWindowEL8BTi8(@NotNull View view, @NotNull float[] matrix) {
        androidx.compose.p109ui.graphics.Matrix.m18765resetimpl(matrix);
        m20191transformMatrixToWindowEL8BTi8(view, matrix);
    }

    private CalculateMatrixToWindowApi21(float[] fArr) {
        this.tmpMatrix = fArr;
        this.tmpLocation = new int[2];
    }
}
