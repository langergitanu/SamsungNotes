package androidx.compose.p109ui.node;

import androidx.compose.p109ui.geometry.MutableRect;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H&J\"\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0010H&ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001eH&ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&ø\u0001\u0000¢\u0006\u0004\b$\u0010 JP\u0010%\u001a\u00020\u000328\u0010&\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030'2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030+H&J\u001a\u0010,\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000¢\u0006\u0004\b-\u0010\u000eJ\b\u0010.\u001a\u00020\u0003H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u00062À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/node/OwnedLayer;", "", "destroy", "", "drawLayer", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", SecureFolderConstants.TEMP_FOLDER_NAME, "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "drawBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "invalidateParentLayer", "Lkotlin/Function0;", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface OwnedLayer {
    void destroy();

    void drawLayer(@NotNull Canvas canvas, @Nullable GraphicsLayer parentLayer);

    void invalidate();

    /* JADX INFO: renamed from: inverseTransform-58bKbWc, reason: not valid java name */
    void mo20137inverseTransform58bKbWc(@NotNull float[] matrix);

    /* JADX INFO: renamed from: isInLayer-k-4lQ0M, reason: not valid java name */
    boolean mo20138isInLayerk4lQ0M(long position);

    void mapBounds(@NotNull MutableRect rect, boolean inverse);

    /* JADX INFO: renamed from: mapOffset-8S9VItk, reason: not valid java name */
    long mo20139mapOffset8S9VItk(long point, boolean inverse);

    /* JADX INFO: renamed from: move--gyyYBs, reason: not valid java name */
    void mo20140movegyyYBs(long position);

    /* JADX INFO: renamed from: resize-ozmzZPI, reason: not valid java name */
    void mo20141resizeozmzZPI(long size);

    void reuseLayer(@NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, @NotNull Function0<Unit> invalidateParentLayer);

    /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
    void mo20142transform58bKbWc(@NotNull float[] matrix);

    void updateDisplayList();

    void updateLayerProperties(@NotNull ReusableGraphicsLayerScope scope);
}
