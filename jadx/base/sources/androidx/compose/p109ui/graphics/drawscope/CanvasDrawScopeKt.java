package androidx.compose.p109ui.graphics.drawscope;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.InlineClassHelperKt;
import androidx.compose.p109ui.graphics.Path;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m13886d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo18999clipPathmtrdDE(@NotNull Path path, int clipOp) {
                drawContext.getCanvas().mo18378clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo19000clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                drawContext.getCanvas().mo18379clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo19001getCenterF1C5BW0() {
                return SizeKt.m18363getCenteruvyYCjk(mo19002getSizeNHjbRc());
            }

            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo19002getSizeNHjbRc() {
                return drawContext.mo18997getSizeNHjbRc();
            }

            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas canvas = drawContext.getCanvas();
                DrawContext drawContext2 = drawContext;
                long jSize = SizeKt.Size(Size.m18353getWidthimpl(mo19002getSizeNHjbRc()) - (right + left), Size.m18350getHeightimpl(mo19002getSizeNHjbRc()) - (bottom + top));
                if (!(Size.m18353getWidthimpl(jSize) >= 0.0f && Size.m18350getHeightimpl(jSize) >= 0.0f)) {
                    InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext2.mo18998setSizeuvyYCjk(jSize);
                canvas.translate(left, top);
            }

            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo19003rotateUv8p0NA(float degrees, long pivot) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m18284getXimpl(pivot), Offset.m18285getYimpl(pivot));
                canvas.rotate(degrees);
                canvas.translate(-Offset.m18284getXimpl(pivot), -Offset.m18285getYimpl(pivot));
            }

            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo19004scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m18284getXimpl(pivot), Offset.m18285getYimpl(pivot));
                canvas.scale(scaleX, scaleY);
                canvas.translate(-Offset.m18284getXimpl(pivot), -Offset.m18285getYimpl(pivot));
            }

            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo19005transform58bKbWc(@NotNull float[] matrix) {
                drawContext.getCanvas().mo18380concat58bKbWc(matrix);
            }

            @Override // androidx.compose.p109ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                drawContext.getCanvas().translate(left, top);
            }
        };
    }
}
