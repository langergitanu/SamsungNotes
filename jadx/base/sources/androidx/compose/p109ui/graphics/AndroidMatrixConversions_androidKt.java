package androidx.compose.p109ui.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, m13886d2 = {"setFrom", "", "Landroid/graphics/Matrix;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidMatrixConversions_androidKt {
    /* JADX INFO: renamed from: setFrom-EL8BTi8, reason: not valid java name */
    public static final void m18395setFromEL8BTi8(@NotNull Matrix matrix, @NotNull float[] fArr) {
        float f = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = fArr[3];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        float f11 = fArr[8];
        float f12 = fArr[12];
        float f13 = fArr[13];
        float f14 = fArr[15];
        fArr[0] = f;
        fArr[1] = f7;
        fArr[2] = f12;
        fArr[3] = f4;
        fArr[4] = f8;
        fArr[5] = f13;
        fArr[6] = f6;
        fArr[7] = f10;
        fArr[8] = f14;
        matrix.setValues(fArr);
        fArr[0] = f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[3] = f6;
        fArr[4] = f7;
        fArr[5] = f8;
        fArr[6] = f9;
        fArr[7] = f10;
        fArr[8] = f11;
    }

    /* JADX INFO: renamed from: setFrom-tU-YjHk, reason: not valid java name */
    public static final void m18396setFromtUYjHk(@NotNull float[] fArr, @NotNull Matrix matrix) {
        matrix.getValues(fArr);
        float f = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = fArr[3];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        float f11 = fArr[8];
        fArr[0] = f;
        fArr[1] = f6;
        fArr[2] = 0.0f;
        fArr[3] = f9;
        fArr[4] = f4;
        fArr[5] = f7;
        fArr[6] = 0.0f;
        fArr[7] = f10;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f5;
        fArr[13] = f8;
        fArr[14] = 0.0f;
        fArr[15] = f11;
    }
}
