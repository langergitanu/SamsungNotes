package androidx.compose.p109ui.graphics.drawscope;

import androidx.annotation.FloatRange;
import androidx.compose.p109ui.geometry.CornerRadius;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p109ui.graphics.BlendMode;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.FilterQuality;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.Paint;
import androidx.compose.p109ui.graphics.PaintingStyle;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathEffect;
import androidx.compose.p109ui.graphics.StrokeCap;
import androidx.compose.p109ui.graphics.StrokeJoin;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002\u0092\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&JH\u0010\u0019\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*Jl\u0010+\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105Jj\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107JL\u00108\u001a\u0002092\u0006\u0010\u0003\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090@¢\u0006\u0002\bAH\u0086\bø\u0001\u0000¢\u0006\u0004\bB\u0010CJf\u0010D\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJf\u0010D\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bM\u0010NJN\u0010O\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bR\u0010SJN\u0010O\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJF\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010I\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ^\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0017ø\u0001\u0000¢\u0006\u0004\ba\u0010bJf\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\bc\u0010dJ`\u0010e\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ`\u0010e\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bj\u0010kJN\u0010l\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bm\u0010nJN\u0010l\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bo\u0010pJF\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bt\u0010uJF\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010'\u001a\u00020(2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bv\u0010wJf\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\b}\u0010~Jg\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001JP\u0010\u0081\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0082\u0001\u0010nJP\u0010\u0081\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0083\u0001\u0010pJ[\u0010\u0084\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J[\u0010\u0084\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\t\u0010\u008b\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u008c\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u008d\u0001\u001a\u00020\u00112\u0007\u0010\u008e\u0001\u001a\u00020\u001dH\u0002J!\u0010\u008f\u0001\u001a\u00020(*\u00020(2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0093\u0001"}, m13886d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "()V", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "strokePaint", "configurePaint", "brush", "Landroidx/compose/ui/graphics/Brush;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "strokeWidth", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "draw", "", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCanvasDrawScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CanvasDrawScope.kt\nandroidx/compose/ui/graphics/drawscope/CanvasDrawScope\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,791:1\n1#2:792\n*E\n"})
public final class CanvasDrawScope implements DrawScope {

    @Nullable
    private Paint fillPaint;

    @Nullable
    private Paint strokePaint;

    @NotNull
    private final DrawParams drawParams = new DrawParams(null, null, null, 0, 15, null);

    @NotNull
    private final DrawContext drawContext = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1

        @Nullable
        private GraphicsLayer graphicsLayer;

        @NotNull
        private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        @NotNull
        public Canvas getCanvas() {
            return this.this$0.getDrawParams().getCanvas();
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        @NotNull
        public Density getDensity() {
            return this.this$0.getDrawParams().getDensity();
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        @Nullable
        public GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        @NotNull
        public LayoutDirection getLayoutDirection() {
            return this.this$0.getDrawParams().getLayoutDirection();
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo18997getSizeNHjbRc() {
            return this.this$0.getDrawParams().m18995getSizeNHjbRc();
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        @NotNull
        public DrawTransform getTransform() {
            return this.transform;
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        public void setCanvas(@NotNull Canvas canvas) {
            this.this$0.getDrawParams().setCanvas(canvas);
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        public void setDensity(@NotNull Density density) {
            this.this$0.getDrawParams().setDensity(density);
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        public void setGraphicsLayer(@Nullable GraphicsLayer graphicsLayer) {
            this.graphicsLayer = graphicsLayer;
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        public void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
            this.this$0.getDrawParams().setLayoutDirection(layoutDirection);
        }

        @Override // androidx.compose.p109ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public void mo18998setSizeuvyYCjk(long j) {
            this.this$0.getDrawParams().m18996setSizeuvyYCjk(j);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0016\u0010\u001f\u001a\u00020\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u00020\tX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m13886d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @PublishedApi
    public static final /* data */ class DrawParams {

        @NotNull
        private Canvas canvas;

        @NotNull
        private Density density;

        @NotNull
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(density, layoutDirection, canvas, j);
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss$default, reason: not valid java name */
        public static /* synthetic */ DrawParams m18992copyUg5Nnss$default(DrawParams drawParams, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                density = drawParams.density;
            }
            if ((i & 2) != 0) {
                layoutDirection = drawParams.layoutDirection;
            }
            if ((i & 4) != 0) {
                canvas = drawParams.canvas;
            }
            if ((i & 8) != 0) {
                j = drawParams.size;
            }
            Canvas canvas2 = canvas;
            return drawParams.m18994copyUg5Nnss(density, layoutDirection, canvas2, j);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Density getDensity() {
            return this.density;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Canvas getCanvas() {
            return this.canvas;
        }

        /* JADX INFO: renamed from: component4-NH-jbRc, reason: not valid java name and from getter */
        public final long getSize() {
            return this.size;
        }

        @NotNull
        /* JADX INFO: renamed from: copy-Ug5Nnss, reason: not valid java name */
        public final DrawParams m18994copyUg5Nnss(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long size) {
            return new DrawParams(density, layoutDirection, canvas, size, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) other;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m18349equalsimpl0(this.size, drawParams.size);
        }

        @NotNull
        public final Canvas getCanvas() {
            return this.canvas;
        }

        @NotNull
        public final Density getDensity() {
            return this.density;
        }

        @NotNull
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m18995getSizeNHjbRc() {
            return this.size;
        }

        public int hashCode() {
            return Size.m18354hashCodeimpl(this.size) + ((this.canvas.hashCode() + ((this.layoutDirection.hashCode() + (this.density.hashCode() * 31)) * 31)) * 31);
        }

        public final void setCanvas(@NotNull Canvas canvas) {
            this.canvas = canvas;
        }

        public final void setDensity(@NotNull Density density) {
            this.density = density;
        }

        public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m18996setSizeuvyYCjk(long j) {
            this.size = j;
        }

        @NotNull
        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m18357toStringimpl(this.size)) + PropertyUtils.MAPPED_DELIM2;
        }

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j) {
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = j;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? DrawContextKt.getDefaultDensity() : density, (i & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i & 4) != 0 ? new EmptyCanvas() : canvas, (i & 8) != 0 ? Size.INSTANCE.m18362getZeroNHjbRc() : j, null);
        }
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m18963configurePaint2qPWKa0(long color, DrawStyle style, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint paintSelectPaint = selectPaint(style);
        long jM18971modulate5vOe2sY = m18971modulate5vOe2sY(color, alpha);
        if (!Color.m18526equalsimpl0(paintSelectPaint.mo18398getColor0d7_KjU(), jM18971modulate5vOe2sY)) {
            paintSelectPaint.mo18404setColor8_81llA(jM18971modulate5vOe2sY);
        }
        if (paintSelectPaint.getInternalShader() != null) {
            paintSelectPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(paintSelectPaint.getInternalColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m18436equalsimpl0(paintSelectPaint.get_blendMode(), blendMode)) {
            paintSelectPaint.mo18403setBlendModes9anfk8(blendMode);
        }
        if (!FilterQuality.m18620equalsimpl0(paintSelectPaint.mo18399getFilterQualityfv9h1I(), filterQuality)) {
            paintSelectPaint.mo18405setFilterQualityvDHp3xo(filterQuality);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    public static /* synthetic */ Paint m18964configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i4, Object obj) {
        return canvasDrawScope.m18963configurePaint2qPWKa0(j, drawStyle, f, colorFilter, i, (i4 & 32) != 0 ? DrawScope.INSTANCE.m19079getDefaultFilterQualityfv9h1I() : i2);
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m18965configurePaintswdJneE(Brush brush, DrawStyle style, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint paintSelectPaint = selectPaint(style);
        if (brush != null) {
            brush.mo18472applyToPq9zytI(mo19076getSizeNHjbRc(), paintSelectPaint, alpha);
        } else {
            if (paintSelectPaint.getInternalShader() != null) {
                paintSelectPaint.setShader(null);
            }
            long jMo18398getColor0d7_KjU = paintSelectPaint.mo18398getColor0d7_KjU();
            Color.Companion companion = Color.INSTANCE;
            if (!Color.m18526equalsimpl0(jMo18398getColor0d7_KjU, companion.m18551getBlack0d7_KjU())) {
                paintSelectPaint.mo18404setColor8_81llA(companion.m18551getBlack0d7_KjU());
            }
            if (paintSelectPaint.getAlpha() != alpha) {
                paintSelectPaint.setAlpha(alpha);
            }
        }
        if (!Intrinsics.areEqual(paintSelectPaint.getInternalColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m18436equalsimpl0(paintSelectPaint.get_blendMode(), blendMode)) {
            paintSelectPaint.mo18403setBlendModes9anfk8(blendMode);
        }
        if (!FilterQuality.m18620equalsimpl0(paintSelectPaint.mo18399getFilterQualityfv9h1I(), filterQuality)) {
            paintSelectPaint.mo18405setFilterQualityvDHp3xo(filterQuality);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    public static /* synthetic */ Paint m18966configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i4, Object obj) {
        if ((i4 & 32) != 0) {
            i2 = DrawScope.INSTANCE.m19079getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m18965configurePaintswdJneE(brush, drawStyle, f, colorFilter, i, i2);
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m18967configureStrokePaintQ_0CZUI(long color, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        long jM18971modulate5vOe2sY = m18971modulate5vOe2sY(color, alpha);
        if (!Color.m18526equalsimpl0(paintObtainStrokePaint.mo18398getColor0d7_KjU(), jM18971modulate5vOe2sY)) {
            paintObtainStrokePaint.mo18404setColor8_81llA(jM18971modulate5vOe2sY);
        }
        if (paintObtainStrokePaint.getInternalShader() != null) {
            paintObtainStrokePaint.setShader(null);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getInternalColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m18436equalsimpl0(paintObtainStrokePaint.get_blendMode(), blendMode)) {
            paintObtainStrokePaint.mo18403setBlendModes9anfk8(blendMode);
        }
        if (paintObtainStrokePaint.getStrokeWidth() != strokeWidth) {
            paintObtainStrokePaint.setStrokeWidth(strokeWidth);
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != miter) {
            paintObtainStrokePaint.setStrokeMiterLimit(miter);
        }
        if (!StrokeCap.m18874equalsimpl0(paintObtainStrokePaint.mo18400getStrokeCapKaPHkGw(), cap)) {
            paintObtainStrokePaint.mo18406setStrokeCapBeK7IIE(cap);
        }
        if (!StrokeJoin.m18884equalsimpl0(paintObtainStrokePaint.mo18401getStrokeJoinLxFBmk8(), join)) {
            paintObtainStrokePaint.mo18407setStrokeJoinWw9F2mQ(join);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getPathEffect(), pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m18620equalsimpl0(paintObtainStrokePaint.mo18399getFilterQualityfv9h1I(), filterQuality)) {
            paintObtainStrokePaint.mo18405setFilterQualityvDHp3xo(filterQuality);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    public static /* synthetic */ Paint m18968configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, float f4, int i, int i2, PathEffect pathEffect, float f5, ColorFilter colorFilter, int i4, int i5, int i6, Object obj) {
        return canvasDrawScope.m18967configureStrokePaintQ_0CZUI(j, f, f4, i, i2, pathEffect, f5, colorFilter, i4, (i6 & 512) != 0 ? DrawScope.INSTANCE.m19079getDefaultFilterQualityfv9h1I() : i5);
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m18969configureStrokePaintho4zsrM(Brush brush, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        if (brush != null) {
            brush.mo18472applyToPq9zytI(mo19076getSizeNHjbRc(), paintObtainStrokePaint, alpha);
        } else if (paintObtainStrokePaint.getAlpha() != alpha) {
            paintObtainStrokePaint.setAlpha(alpha);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getInternalColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m18436equalsimpl0(paintObtainStrokePaint.get_blendMode(), blendMode)) {
            paintObtainStrokePaint.mo18403setBlendModes9anfk8(blendMode);
        }
        if (paintObtainStrokePaint.getStrokeWidth() != strokeWidth) {
            paintObtainStrokePaint.setStrokeWidth(strokeWidth);
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != miter) {
            paintObtainStrokePaint.setStrokeMiterLimit(miter);
        }
        if (!StrokeCap.m18874equalsimpl0(paintObtainStrokePaint.mo18400getStrokeCapKaPHkGw(), cap)) {
            paintObtainStrokePaint.mo18406setStrokeCapBeK7IIE(cap);
        }
        if (!StrokeJoin.m18884equalsimpl0(paintObtainStrokePaint.mo18401getStrokeJoinLxFBmk8(), join)) {
            paintObtainStrokePaint.mo18407setStrokeJoinWw9F2mQ(join);
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getPathEffect(), pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m18620equalsimpl0(paintObtainStrokePaint.mo18399getFilterQualityfv9h1I(), filterQuality)) {
            paintObtainStrokePaint.mo18405setFilterQualityvDHp3xo(filterQuality);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    public static /* synthetic */ Paint m18970configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f, float f4, int i, int i2, PathEffect pathEffect, float f5, ColorFilter colorFilter, int i4, int i5, int i6, Object obj) {
        return canvasDrawScope.m18969configureStrokePaintho4zsrM(brush, f, f4, i, i2, pathEffect, f5, colorFilter, i4, (i6 & 512) != 0 ? DrawScope.INSTANCE.m19079getDefaultFilterQualityfv9h1I() : i5);
    }

    /* JADX INFO: renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m18971modulate5vOe2sY(long j, float f) {
        return f == 1.0f ? j : Color.m18524copywmQWz5c$default(j, Color.m18527getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo18408setStylek9PVt8s(PaintingStyle.INSTANCE.m18792getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo18408setStylek9PVt8s(PaintingStyle.INSTANCE.m18793getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new NoWhenBranchMatchedException();
        }
        Paint paintObtainStrokePaint = obtainStrokePaint();
        Stroke stroke = (Stroke) drawStyle;
        if (paintObtainStrokePaint.getStrokeWidth() != stroke.getWidth()) {
            paintObtainStrokePaint.setStrokeWidth(stroke.getWidth());
        }
        if (!StrokeCap.m18874equalsimpl0(paintObtainStrokePaint.mo18400getStrokeCapKaPHkGw(), stroke.getCap())) {
            paintObtainStrokePaint.mo18406setStrokeCapBeK7IIE(stroke.getCap());
        }
        if (paintObtainStrokePaint.getStrokeMiterLimit() != stroke.getMiter()) {
            paintObtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
        }
        if (!StrokeJoin.m18884equalsimpl0(paintObtainStrokePaint.mo18401getStrokeJoinLxFBmk8(), stroke.getJoin())) {
            paintObtainStrokePaint.mo18407setStrokeJoinWw9F2mQ(stroke.getJoin());
        }
        if (!Intrinsics.areEqual(paintObtainStrokePaint.getPathEffect(), stroke.getPathEffect())) {
            paintObtainStrokePaint.setPathEffect(stroke.getPathEffect());
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: draw-yzxVdVo, reason: not valid java name */
    public final void m18972drawyzxVdVo(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long size, @NotNull Function1<? super DrawScope, Unit> block) {
        DrawParams drawParams = getDrawParams();
        Density density2 = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas2 = drawParams.getCanvas();
        long size2 = drawParams.getSize();
        DrawParams drawParams2 = getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m18996setSizeuvyYCjk(size);
        canvas.save();
        block.invoke(this);
        canvas.restore();
        DrawParams drawParams3 = getDrawParams();
        drawParams3.setDensity(density2);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas2);
        drawParams3.m18996setSizeuvyYCjk(size2);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-illE91I, reason: not valid java name */
    public void mo18973drawArcillE91I(@NotNull Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawArc(Offset.m18284getXimpl(topLeft), Offset.m18285getYimpl(topLeft), Size.m18353getWidthimpl(size) + Offset.m18284getXimpl(topLeft), Size.m18350getHeightimpl(size) + Offset.m18285getYimpl(topLeft), startAngle, sweepAngle, useCenter, m18966configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void mo18974drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawArc(Offset.m18284getXimpl(topLeft), Offset.m18285getYimpl(topLeft), Size.m18353getWidthimpl(size) + Offset.m18284getXimpl(topLeft), Size.m18350getHeightimpl(size) + Offset.m18285getYimpl(topLeft), startAngle, sweepAngle, useCenter, m18964configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-V9BoPsw, reason: not valid java name */
    public void mo18975drawCircleV9BoPsw(@NotNull Brush brush, float radius, long center, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo18381drawCircle9KIMszo(center, radius, m18966configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo18976drawCircleVaOC9Bg(long color, float radius, long center, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo18381drawCircle9KIMszo(center, radius, m18964configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* JADX INFO: renamed from: drawImage-9jGpkUE, reason: not valid java name */
    public /* synthetic */ void mo18977drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo18383drawImageRectHPBpro0(image, srcOffset, srcSize, dstOffset, dstSize, m18966configurePaintswdJneE$default(this, null, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo18978drawImageAZ2fEMs(@NotNull ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.drawParams.getCanvas().mo18383drawImageRectHPBpro0(image, srcOffset, srcSize, dstOffset, dstSize, m18965configurePaintswdJneE(null, style, alpha, colorFilter, blendMode, filterQuality));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo18979drawImagegbVJVH8(@NotNull ImageBitmap image, long topLeft, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo18382drawImaged4ec7I(image, topLeft, m18966configurePaintswdJneE$default(this, null, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo18980drawLine1RTmtNc(@NotNull Brush brush, long start, long end, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo18384drawLineWko1d7g(start, end, m18970configureStrokePaintho4zsrM$default(this, brush, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m18889getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo18981drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo18384drawLineWko1d7g(start, end, m18968configureStrokePaintQ_0CZUI$default(this, color, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m18889getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-AsUm42w, reason: not valid java name */
    public void mo18982drawOvalAsUm42w(@NotNull Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawOval(Offset.m18284getXimpl(topLeft), Offset.m18285getYimpl(topLeft), Size.m18353getWidthimpl(size) + Offset.m18284getXimpl(topLeft), Size.m18350getHeightimpl(size) + Offset.m18285getYimpl(topLeft), m18966configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-n-J9OG0, reason: not valid java name */
    public void mo18983drawOvalnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawOval(Offset.m18284getXimpl(topLeft), Offset.m18285getYimpl(topLeft), Size.m18353getWidthimpl(size) + Offset.m18284getXimpl(topLeft), Size.m18350getHeightimpl(size) + Offset.m18285getYimpl(topLeft), m18964configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo18984drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPath(path, m18966configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo18985drawPathLG529CI(@NotNull Path path, long color, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPath(path, m18964configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public void mo18986drawPointsF8ZwMP8(@NotNull List<Offset> points, int pointMode, long color, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo18385drawPointsO7TthRY(pointMode, points, m18968configureStrokePaintQ_0CZUI$default(this, color, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m18889getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-Gsft0Ws, reason: not valid java name */
    public void mo18987drawPointsGsft0Ws(@NotNull List<Offset> points, int pointMode, @NotNull Brush brush, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo18385drawPointsO7TthRY(pointMode, points, m18970configureStrokePaintho4zsrM$default(this, brush, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m18889getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo18988drawRectAsUm42w(@NotNull Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRect(Offset.m18284getXimpl(topLeft), Offset.m18285getYimpl(topLeft), Size.m18353getWidthimpl(size) + Offset.m18284getXimpl(topLeft), Size.m18350getHeightimpl(size) + Offset.m18285getYimpl(topLeft), m18966configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo18989drawRectnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRect(Offset.m18284getXimpl(topLeft), Offset.m18285getYimpl(topLeft), Size.m18353getWidthimpl(size) + Offset.m18284getXimpl(topLeft), Size.m18350getHeightimpl(size) + Offset.m18285getYimpl(topLeft), m18964configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo18990drawRoundRectZuiqVtQ(@NotNull Brush brush, long topLeft, long size, long cornerRadius, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m18284getXimpl(topLeft), Offset.m18285getYimpl(topLeft), Size.m18353getWidthimpl(size) + Offset.m18284getXimpl(topLeft), Size.m18350getHeightimpl(size) + Offset.m18285getYimpl(topLeft), CornerRadius.m18259getXimpl(cornerRadius), CornerRadius.m18260getYimpl(cornerRadius), m18966configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo18991drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, @NotNull DrawStyle style, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m18284getXimpl(topLeft), Offset.m18285getYimpl(topLeft), Size.m18353getWidthimpl(size) + Offset.m18284getXimpl(topLeft), Size.m18350getHeightimpl(size) + Offset.m18285getYimpl(topLeft), CornerRadius.m18259getXimpl(cornerRadius), CornerRadius.m18260getYimpl(cornerRadius), m18964configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p109ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    @NotNull
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    @NotNull
    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    @PublishedApi
    public static /* synthetic */ void getDrawParams$annotations() {
    }
}
