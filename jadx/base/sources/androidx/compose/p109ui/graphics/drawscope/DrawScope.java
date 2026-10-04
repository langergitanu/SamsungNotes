package androidx.compose.p109ui.graphics.drawscope;

import androidx.annotation.FloatRange;
import androidx.compose.p109ui.geometry.CornerRadius;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.BlendMode;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.FilterQuality;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathEffect;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@DrawScopeMarker
@Metadata(m13885d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 u2\u00020\u0001:\u0001uJp\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jp\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b&\u0010'JX\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b*\u0010+JX\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b,\u0010-JN\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b1\u00102Jl\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H'ø\u0001\u0000¢\u0006\u0004\b9\u0010:Jv\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010;\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>Jj\u0010?\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bG\u0010HJj\u0010?\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bI\u0010JJX\u0010K\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bL\u0010MJX\u0010K\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bN\u0010OJL\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bS\u0010TJL\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010$\u001a\u00020%2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bU\u0010VJp\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b\\\u0010]Jp\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b^\u0010_JX\u0010`\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\ba\u0010MJX\u0010`\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bb\u0010OJb\u0010c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bf\u0010gJb\u0010c\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ\u001e\u0010j\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010k\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ9\u0010n\u001a\u00020\u0012*\u00020o2\b\b\u0002\u0010\u000e\u001a\u0002062\u0017\u0010p\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120q¢\u0006\u0002\brH\u0016ø\u0001\u0000¢\u0006\u0004\bs\u0010tR\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006vÀ\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "drawArc", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "offsetSize", TypedValues.Cycle.S_WAVE_OFFSET, "offsetSize-PENXr5M", "(JJ)J", "record", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "Companion", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface DrawScope extends Density {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.INSTANCE.m18467getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.INSTANCE.m18625getLowfv9h1I();

        private Companion() {
        }

        /* JADX INFO: renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m19078getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* JADX INFO: renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m19079getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m19085drawImageAZ2fEMs(@NotNull DrawScope drawScope, @NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j5, @FloatRange(from = 0.0d, m705to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
            DrawScope.super.mo18978drawImageAZ2fEMs(imageBitmap, j, j2, j3, j5, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m19100getCenterF1C5BW0(@NotNull DrawScope drawScope) {
            return DrawScope.super.mo19075getCenterF1C5BW0();
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m19101getSizeNHjbRc(@NotNull DrawScope drawScope) {
            return DrawScope.super.mo19076getSizeNHjbRc();
        }

        @Deprecated
        /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m19102recordJVtK1S4(@NotNull DrawScope drawScope, @NotNull GraphicsLayer graphicsLayer, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
            DrawScope.super.mo19077recordJVtK1S4(graphicsLayer, j, function1);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m19104roundToPxR2X_6o(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo15539roundToPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m19105roundToPx0680j_4(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo15540roundToPx0680j_4(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m19106toDpGaN1DYA(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo15541toDpGaN1DYA(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m19107toDpu2uoSUM(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo15542toDpu2uoSUM(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m19109toDpSizekrfVVM(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo15544toDpSizekrfVVM(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m19110toPxR2X_6o(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo15545toPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m19111toPx0680j_4(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo15546toPx0680j_4(f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull DrawScope drawScope, @NotNull DpRect dpRect) {
            return DrawScope.super.toRect(dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m19112toSizeXkaWNTQ(@NotNull DrawScope drawScope, long j) {
            return DrawScope.super.mo15547toSizeXkaWNTQ(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m19113toSp0xMU5do(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo15548toSp0xMU5do(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m19114toSpkPz2Gy4(@NotNull DrawScope drawScope, float f) {
            return DrawScope.super.mo15549toSpkPz2Gy4(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m19108toDpu2uoSUM(@NotNull DrawScope drawScope, int i) {
            return DrawScope.super.mo15543toDpu2uoSUM(i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m19115toSpkPz2Gy4(@NotNull DrawScope drawScope, int i) {
            return DrawScope.super.mo15550toSpkPz2Gy4(i);
        }
    }

    /* JADX INFO: renamed from: drawArc-illE91I$default, reason: not valid java name */
    static /* synthetic */ void m19054drawArcillE91I$default(DrawScope drawScope, Brush brush, float f, float f4, boolean z, long j, long j2, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long jM19073offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }
        long jM18300getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j;
        if ((i2 & 32) != 0) {
            drawScope2 = drawScope;
            jM19073offsetSizePENXr5M = drawScope2.m19073offsetSizePENXr5M(drawScope.mo19076getSizeNHjbRc(), jM18300getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM19073offsetSizePENXr5M = j2;
        }
        drawScope2.mo18973drawArcillE91I(brush, f, f4, z, jM18300getZeroF1C5BW0, jM19073offsetSizePENXr5M, (i2 & 64) != 0 ? 1.0f : f5, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawArc-yD3GUKo$default, reason: not valid java name */
    static /* synthetic */ void m19055drawArcyD3GUKo$default(DrawScope drawScope, long j, float f, float f4, boolean z, long j2, long j3, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long jM19073offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }
        long jM18300getZeroF1C5BW0 = (i2 & 16) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j2;
        if ((i2 & 32) != 0) {
            drawScope2 = drawScope;
            jM19073offsetSizePENXr5M = drawScope2.m19073offsetSizePENXr5M(drawScope.mo19076getSizeNHjbRc(), jM18300getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM19073offsetSizePENXr5M = j3;
        }
        drawScope2.mo18974drawArcyD3GUKo(j, f, f4, z, jM18300getZeroF1C5BW0, jM19073offsetSizePENXr5M, (i2 & 64) != 0 ? 1.0f : f5, (i2 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 256) != 0 ? null : colorFilter, (i2 & 512) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawCircle-V9BoPsw$default, reason: not valid java name */
    static /* synthetic */ void m19056drawCircleV9BoPsw$default(DrawScope drawScope, Brush brush, float f, long j, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }
        drawScope.mo18975drawCircleV9BoPsw(brush, (i2 & 2) != 0 ? Size.m18352getMinDimensionimpl(drawScope.mo19076getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.mo19075getCenterF1C5BW0() : j, (i2 & 8) != 0 ? 1.0f : f4, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
    static /* synthetic */ void m19057drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        if ((i2 & 2) != 0) {
            f = Size.m18352getMinDimensionimpl(drawScope.mo19076getSizeNHjbRc()) / 2.0f;
        }
        drawScope.mo18976drawCircleVaOC9Bg(j, f, (i2 & 4) != 0 ? drawScope.mo19075getCenterF1C5BW0() : j2, (i2 & 8) != 0 ? 1.0f : f4, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawImage-9jGpkUE$default, reason: not valid java name */
    static /* synthetic */ void m19058drawImage9jGpkUE$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j5, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }
        long jM21106getZeronOccac = (i2 & 2) != 0 ? IntOffset.INSTANCE.m21106getZeronOccac() : j;
        long jIntSize = (i2 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        drawScope.mo18977drawImage9jGpkUE(imageBitmap, jM21106getZeronOccac, jIntSize, (i2 & 8) != 0 ? IntOffset.INSTANCE.m21106getZeronOccac() : j3, (i2 & 16) != 0 ? jIntSize : j5, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 128) != 0 ? null : colorFilter, (i2 & 256) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
    static /* synthetic */ void m19059drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j5, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long jM21106getZeronOccac = (i4 & 2) != 0 ? IntOffset.INSTANCE.m21106getZeronOccac() : j;
        long jIntSize = (i4 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        drawScope.mo18978drawImageAZ2fEMs(imageBitmap, jM21106getZeronOccac, jIntSize, (i4 & 8) != 0 ? IntOffset.INSTANCE.m21106getZeronOccac() : j3, (i4 & 16) != 0 ? jIntSize : j5, (i4 & 32) != 0 ? 1.0f : f, (i4 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i, (i4 & 512) != 0 ? INSTANCE.m19079getDefaultFilterQualityfv9h1I() : i2);
    }

    /* JADX INFO: renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
    static /* synthetic */ void m19060drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.mo18979drawImagegbVJVH8(imageBitmap, (i2 & 2) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawLine-1RTmtNc$default, reason: not valid java name */
    static /* synthetic */ void m19061drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.mo18980drawLine1RTmtNc(brush, j, j2, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? Stroke.INSTANCE.m19147getDefaultCapKaPHkGw() : i, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f4, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i2);
    }

    /* JADX INFO: renamed from: drawLine-NGM6Ib0$default, reason: not valid java name */
    static /* synthetic */ void m19062drawLineNGM6Ib0$default(DrawScope drawScope, long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.mo18981drawLineNGM6Ib0(j, j2, j3, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? Stroke.INSTANCE.m19147getDefaultCapKaPHkGw() : i, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f4, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i2);
    }

    /* JADX INFO: renamed from: drawOval-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m19063drawOvalAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }
        long jM18300getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j;
        drawScope.mo18982drawOvalAsUm42w(brush, jM18300getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m19073offsetSizePENXr5M(drawScope.mo19076getSizeNHjbRc(), jM18300getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawOval-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m19064drawOvalnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }
        long jM18300getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j2;
        drawScope.mo18983drawOvalnJ9OG0(j, jM18300getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m19073offsetSizePENXr5M(drawScope.mo19076getSizeNHjbRc(), jM18300getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
    static /* synthetic */ void m19065drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f4 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = INSTANCE.m19078getDefaultBlendMode0nO6VwU();
        }
        drawScope.mo18984drawPathGBMwjPU(path, brush, f4, drawStyle2, colorFilter2, i);
    }

    /* JADX INFO: renamed from: drawPath-LG529CI$default, reason: not valid java name */
    static /* synthetic */ void m19066drawPathLG529CI$default(DrawScope drawScope, Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f4 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        drawScope.mo18985drawPathLG529CI(path, j, f4, drawStyle2, colorFilter, (i2 & 32) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawPoints-F8ZwMP8$default, reason: not valid java name */
    static /* synthetic */ void m19067drawPointsF8ZwMP8$default(DrawScope drawScope, List list, int i, long j, float f, int i2, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        drawScope.mo18986drawPointsF8ZwMP8(list, i, j, (i5 & 8) != 0 ? 0.0f : f, (i5 & 16) != 0 ? StrokeCap.INSTANCE.m18878getButtKaPHkGw() : i2, (i5 & 32) != 0 ? null : pathEffect, (i5 & 64) != 0 ? 1.0f : f4, (i5 & 128) != 0 ? null : colorFilter, (i5 & 256) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i4);
    }

    /* JADX INFO: renamed from: drawPoints-Gsft0Ws$default, reason: not valid java name */
    static /* synthetic */ void m19068drawPointsGsft0Ws$default(DrawScope drawScope, List list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }
        drawScope.mo18987drawPointsGsft0Ws(list, i, brush, (i5 & 8) != 0 ? 0.0f : f, (i5 & 16) != 0 ? StrokeCap.INSTANCE.m18878getButtKaPHkGw() : i2, (i5 & 32) != 0 ? null : pathEffect, (i5 & 64) != 0 ? 1.0f : f4, (i5 & 128) != 0 ? null : colorFilter, (i5 & 256) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i4);
    }

    /* JADX INFO: renamed from: drawRect-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m19069drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long jM18300getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j;
        drawScope.mo18988drawRectAsUm42w(brush, jM18300getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m19073offsetSizePENXr5M(drawScope.mo19076getSizeNHjbRc(), jM18300getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m19070drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long jM18300getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j2;
        drawScope.mo18989drawRectnJ9OG0(j, jM18300getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m19073offsetSizePENXr5M(drawScope.mo19076getSizeNHjbRc(), jM18300getZeroF1C5BW0) : j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
    static /* synthetic */ void m19071drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long jM18300getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j;
        drawScope.mo18990drawRoundRectZuiqVtQ(brush, jM18300getZeroF1C5BW0, (i2 & 4) != 0 ? drawScope.m19073offsetSizePENXr5M(drawScope.mo19076getSizeNHjbRc(), jM18300getZeroF1C5BW0) : j2, (i2 & 8) != 0 ? CornerRadius.INSTANCE.m18269getZerokKHJgLs() : j3, (i2 & 16) != 0 ? 1.0f : f, (i2 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
    static /* synthetic */ void m19072drawRoundRectuAw5IA$default(DrawScope drawScope, long j, long j2, long j3, long j5, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, Object obj) {
        DrawScope drawScope2;
        long jM19073offsetSizePENXr5M;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long jM18300getZeroF1C5BW0 = (i2 & 2) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j2;
        if ((i2 & 4) != 0) {
            drawScope2 = drawScope;
            jM19073offsetSizePENXr5M = drawScope2.m19073offsetSizePENXr5M(drawScope.mo19076getSizeNHjbRc(), jM18300getZeroF1C5BW0);
        } else {
            drawScope2 = drawScope;
            jM19073offsetSizePENXr5M = j3;
        }
        drawScope2.mo18991drawRoundRectuAw5IA(j, jM18300getZeroF1C5BW0, jM19073offsetSizePENXr5M, (i2 & 8) != 0 ? CornerRadius.INSTANCE.m18269getZerokKHJgLs() : j5, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? 1.0f : f, (i2 & 64) != 0 ? null : colorFilter, (i2 & 128) != 0 ? INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: offsetSize-PENXr5M, reason: not valid java name */
    private default long m19073offsetSizePENXr5M(long j, long j2) {
        return SizeKt.Size(Size.m18353getWidthimpl(j) - Offset.m18284getXimpl(j2), Size.m18350getHeightimpl(j) - Offset.m18285getYimpl(j2));
    }

    /* JADX INFO: renamed from: record-JVtK1S4$default, reason: not valid java name */
    static /* synthetic */ void m19074recordJVtK1S4$default(DrawScope drawScope, GraphicsLayer graphicsLayer, long j, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record-JVtK1S4");
        }
        if ((i & 1) != 0) {
            j = IntSizeKt.m21149toIntSizeuvyYCjk(drawScope.mo19076getSizeNHjbRc());
        }
        drawScope.mo19077recordJVtK1S4(graphicsLayer, j, function1);
    }

    /* JADX INFO: renamed from: drawArc-illE91I */
    void mo18973drawArcillE91I(@NotNull Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    void mo18974drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawCircle-V9BoPsw */
    void mo18975drawCircleV9BoPsw(@NotNull Brush brush, float radius, long center, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    void mo18976drawCircleVaOC9Bg(long color, float radius, long center, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* JADX INFO: renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo18977drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    default void mo18978drawImageAZ2fEMs(@NotNull ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode, int filterQuality) {
        m19059drawImageAZ2fEMs$default(this, image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, 0, 512, null);
    }

    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    void mo18979drawImagegbVJVH8(@NotNull ImageBitmap image, long topLeft, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawLine-1RTmtNc */
    void mo18980drawLine1RTmtNc(@NotNull Brush brush, long start, long end, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    void mo18981drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawOval-AsUm42w */
    void mo18982drawOvalAsUm42w(@NotNull Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawOval-n-J9OG0 */
    void mo18983drawOvalnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    void mo18984drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawPath-LG529CI */
    void mo18985drawPathLG529CI(@NotNull Path path, long color, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawPoints-F8ZwMP8 */
    void mo18986drawPointsF8ZwMP8(@NotNull List<Offset> points, int pointMode, long color, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawPoints-Gsft0Ws */
    void mo18987drawPointsGsft0Ws(@NotNull List<Offset> points, int pointMode, @NotNull Brush brush, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawRect-AsUm42w */
    void mo18988drawRectAsUm42w(@NotNull Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    void mo18989drawRectnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    void mo18990drawRoundRectZuiqVtQ(@NotNull Brush brush, long topLeft, long size, long cornerRadius, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    void mo18991drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, @NotNull DrawStyle style, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode);

    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    default long mo19075getCenterF1C5BW0() {
        return SizeKt.m18363getCenteruvyYCjk(getDrawContext().mo18997getSizeNHjbRc());
    }

    @NotNull
    DrawContext getDrawContext();

    @NotNull
    LayoutDirection getLayoutDirection();

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo19076getSizeNHjbRc() {
        return getDrawContext().mo18997getSizeNHjbRc();
    }

    /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
    default void mo19077recordJVtK1S4(@NotNull GraphicsLayer graphicsLayer, long j, @NotNull final Function1<? super DrawScope, Unit> function1) {
        graphicsLayer.m19170recordmLhObY(this, getLayoutDirection(), j, new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.drawscope.DrawScope$record$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DrawScope drawScope) {
                DrawScope drawScope2 = this.this$0;
                Density density = drawScope.getDrawContext().getDensity();
                LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                long jMo18997getSizeNHjbRc = drawScope.getDrawContext().mo18997getSizeNHjbRc();
                GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
                Function1<DrawScope, Unit> function12 = function1;
                Density density2 = drawScope2.getDrawContext().getDensity();
                LayoutDirection layoutDirection2 = drawScope2.getDrawContext().getLayoutDirection();
                Canvas canvas2 = drawScope2.getDrawContext().getCanvas();
                long jMo18997getSizeNHjbRc2 = drawScope2.getDrawContext().mo18997getSizeNHjbRc();
                GraphicsLayer graphicsLayer3 = drawScope2.getDrawContext().getGraphicsLayer();
                DrawContext drawContext = drawScope2.getDrawContext();
                drawContext.setDensity(density);
                drawContext.setLayoutDirection(layoutDirection);
                drawContext.setCanvas(canvas);
                drawContext.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
                drawContext.setGraphicsLayer(graphicsLayer2);
                canvas.save();
                try {
                    function12.invoke(drawScope2);
                } finally {
                    canvas.restore();
                    DrawContext drawContext2 = drawScope2.getDrawContext();
                    drawContext2.setDensity(density2);
                    drawContext2.setLayoutDirection(layoutDirection2);
                    drawContext2.setCanvas(canvas2);
                    drawContext2.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc2);
                    drawContext2.setGraphicsLayer(graphicsLayer3);
                }
            }
        });
    }
}
