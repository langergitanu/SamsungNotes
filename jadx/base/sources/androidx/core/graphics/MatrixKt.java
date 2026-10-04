package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\b¨\u0006\u0010"}, m13886d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", "px", "py", "scaleMatrix", "sx", "sy", "translationMatrix", "tx", "ty", "times", "m", "values", "", "core-ktx_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matrix.kt\nandroidx/core/graphics/MatrixKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class MatrixKt {
    @NotNull
    public static final Matrix rotationMatrix(float f, float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f, f4, f5);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f, float f4, float f5, int i, Object obj) {
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i & 4) != 0) {
            f5 = 0.0f;
        }
        return rotationMatrix(f, f4, f5);
    }

    @NotNull
    public static final Matrix scaleMatrix(float f, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f4);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f4 = 1.0f;
        }
        return scaleMatrix(f, f4);
    }

    @NotNull
    public static final Matrix times(@NotNull Matrix matrix, @NotNull Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    @NotNull
    public static final Matrix translationMatrix(float f, float f4) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f, f4);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        return translationMatrix(f, f4);
    }

    @NotNull
    public static final float[] values(@NotNull Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
