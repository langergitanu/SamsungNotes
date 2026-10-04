package androidx.compose.p109ui.graphics.drawscope;

import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.ClipOp;
import androidx.compose.p109ui.graphics.Path;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@DrawScopeMarker
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H&J$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H&ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001c\u0010)\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006*À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "inset", "rotate", "degrees", "pivot", "rotate-Uv8p0NA", "(FJ)V", WiggleAnimationConfig.KEY_SCALE, "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface DrawTransform {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m19138getCenterF1C5BW0(@NotNull DrawTransform drawTransform) {
            return DrawTransform.super.mo19001getCenterF1C5BW0();
        }
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m19132clipPathmtrdDE$default(DrawTransform drawTransform, Path path, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
        }
        drawTransform.mo18999clipPathmtrdDE(path, i);
    }

    /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
    static /* synthetic */ void m19133clipRectN_I0leg$default(DrawTransform drawTransform, float f, float f4, float f5, float f6, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i2 & 1) != 0) {
            f = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f5 = Size.m18353getWidthimpl(drawTransform.mo19002getSizeNHjbRc());
        }
        if ((i2 & 8) != 0) {
            f6 = Size.m18350getHeightimpl(drawTransform.mo19002getSizeNHjbRc());
        }
        if ((i2 & 16) != 0) {
            i = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
        }
        drawTransform.mo19000clipRectN_I0leg(f, f4, f5, f6, i);
    }

    /* JADX INFO: renamed from: rotate-Uv8p0NA$default, reason: not valid java name */
    static /* synthetic */ void m19134rotateUv8p0NA$default(DrawTransform drawTransform, float f, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rotate-Uv8p0NA");
        }
        if ((i & 2) != 0) {
            j = drawTransform.mo19001getCenterF1C5BW0();
        }
        drawTransform.mo19003rotateUv8p0NA(f, j);
    }

    /* JADX INFO: renamed from: scale-0AR0LA0$default, reason: not valid java name */
    static /* synthetic */ void m19135scale0AR0LA0$default(DrawTransform drawTransform, float f, float f4, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale-0AR0LA0");
        }
        if ((i & 4) != 0) {
            j = drawTransform.mo19001getCenterF1C5BW0();
        }
        drawTransform.mo19004scale0AR0LA0(f, f4, j);
    }

    static /* synthetic */ void translate$default(DrawTransform drawTransform, float f, float f4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        }
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        drawTransform.translate(f, f4);
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo18999clipPathmtrdDE(@NotNull Path path, int clipOp);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo19000clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp);

    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    default long mo19001getCenterF1C5BW0() {
        float f = 2;
        return OffsetKt.Offset(Size.m18353getWidthimpl(mo19002getSizeNHjbRc()) / f, Size.m18350getHeightimpl(mo19002getSizeNHjbRc()) / f);
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo19002getSizeNHjbRc();

    void inset(float left, float top, float right, float bottom);

    /* JADX INFO: renamed from: rotate-Uv8p0NA */
    void mo19003rotateUv8p0NA(float degrees, long pivot);

    /* JADX INFO: renamed from: scale-0AR0LA0 */
    void mo19004scale0AR0LA0(float scaleX, float scaleY, long pivot);

    /* JADX INFO: renamed from: transform-58bKbWc */
    void mo19005transform58bKbWc(@NotNull float[] matrix);

    void translate(float left, float top);
}
