package androidx.compose.foundation.draganddrop;

import android.graphics.Picture;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p109ui.draw.CacheDrawScope;
import androidx.compose.p109ui.draw.DrawResult;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "", "()V", "cachedPicture", "Landroid/graphics/Picture;", "cachePicture", "Landroidx/compose/ui/draw/DrawResult;", "scope", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawDragShadow", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidDragAndDropSource.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidDragAndDropSource.android.kt\nandroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback\n+ 2 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,146:1\n256#2:147\n*S KotlinDebug\n*F\n+ 1 AndroidDragAndDropSource.android.kt\nandroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback\n*L\n118#1:147\n*E\n"})
final class CacheDrawScopeDragShadowCallback {

    @Nullable
    private Picture cachedPicture;

    @NotNull
    public final DrawResult cachePicture(@NotNull CacheDrawScope scope) {
        final Picture picture = new Picture();
        this.cachedPicture = picture;
        final int iM18353getWidthimpl = (int) Size.m18353getWidthimpl(scope.m18174getSizeNHjbRc());
        final int iM18350getHeightimpl = (int) Size.m18350getHeightimpl(scope.m18174getSizeNHjbRc());
        return scope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.draganddrop.CacheDrawScopeDragShadowCallback$cachePicture$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ContentDrawScope contentDrawScope) {
                Canvas Canvas = AndroidCanvas_androidKt.Canvas(picture.beginRecording(iM18353getWidthimpl, iM18350getHeightimpl));
                LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
                long jMo19076getSizeNHjbRc = contentDrawScope.mo19076getSizeNHjbRc();
                Density density = contentDrawScope.getDrawContext().getDensity();
                LayoutDirection layoutDirection2 = contentDrawScope.getDrawContext().getLayoutDirection();
                Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
                long jMo18997getSizeNHjbRc = contentDrawScope.getDrawContext().mo18997getSizeNHjbRc();
                GraphicsLayer graphicsLayer = contentDrawScope.getDrawContext().getGraphicsLayer();
                DrawContext drawContext = contentDrawScope.getDrawContext();
                drawContext.setDensity(contentDrawScope);
                drawContext.setLayoutDirection(layoutDirection);
                drawContext.setCanvas(Canvas);
                drawContext.mo18998setSizeuvyYCjk(jMo19076getSizeNHjbRc);
                drawContext.setGraphicsLayer(null);
                Canvas.save();
                try {
                    contentDrawScope.drawContent();
                    Canvas.restore();
                    DrawContext drawContext2 = contentDrawScope.getDrawContext();
                    drawContext2.setDensity(density);
                    drawContext2.setLayoutDirection(layoutDirection2);
                    drawContext2.setCanvas(canvas);
                    drawContext2.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
                    drawContext2.setGraphicsLayer(graphicsLayer);
                    picture.endRecording();
                    AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas()).drawPicture(picture);
                } catch (Throwable th) {
                    Canvas.restore();
                    DrawContext drawContext3 = contentDrawScope.getDrawContext();
                    drawContext3.setDensity(density);
                    drawContext3.setLayoutDirection(layoutDirection2);
                    drawContext3.setCanvas(canvas);
                    drawContext3.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
                    drawContext3.setGraphicsLayer(graphicsLayer);
                    throw th;
                }
            }
        });
    }

    public final void drawDragShadow(@NotNull DrawScope drawScope) {
        Picture picture = this.cachedPicture;
        if (picture == null) {
            throw new IllegalArgumentException("No cached drag shadow. Check if Modifier.cacheDragShadow(painter) was called.");
        }
        AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()).drawPicture(picture);
    }
}
