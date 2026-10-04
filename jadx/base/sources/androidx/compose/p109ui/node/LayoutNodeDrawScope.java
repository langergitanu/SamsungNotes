package androidx.compose.p109ui.node;

import androidx.annotation.FloatRange;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathEffect;
import androidx.compose.p109ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J<\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010)Jq\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:Jq\u0010*\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>JY\u0010?\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010@\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJY\u0010?\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u0010@\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\b\u0010E\u001a\u00020 H\u0016J<\u0010F\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010'H\u0000ø\u0001\u0000¢\u0006\u0004\bG\u0010HJO\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJm\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020O2\b\b\u0002\u0010S\u001a\u00020Q2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJw\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020O2\b\b\u0002\u0010S\u001a\u00020Q2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010V\u001a\u00020WH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YJk\u0010Z\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010cJk\u0010Z\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bd\u0010eJY\u0010f\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hJY\u0010f\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bi\u0010jJM\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020m2\u0006\u0010+\u001a\u00020,2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bn\u0010oJM\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020m2\u0006\u0010;\u001a\u00020<2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bp\u0010qJq\u0010r\u001a\u00020 2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\t0t2\u0006\u0010u\u001a\u00020v2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010xJq\u0010r\u001a\u00020 2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\t0t2\u0006\u0010u\u001a\u00020v2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020_2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010zJY\u0010{\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b|\u0010hJY\u0010{\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010jJf\u0010~\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\t\b\u0002\u0010\u007f\u001a\u00030\u0080\u00012\b\b\u0003\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001Jf\u0010~\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\t\b\u0002\u0010\u007f\u001a\u00030\u0080\u00012\b\b\u0002\u00103\u001a\u0002042\b\b\u0003\u00102\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001d\u0010\u0085\u0001\u001a\u00020 *\u00020\u00152\u0006\u0010!\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'J@\u0010\u0086\u0001\u001a\u00020 *\u00020'2\b\b\u0002\u0010\u001c\u001a\u00020Q2\u001a\u0010\u0087\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 0\u0088\u0001¢\u0006\u0003\b\u0089\u0001H\u0096\u0001ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u001c\u0010\u008c\u0001\u001a\u00030\u008d\u0001*\u00030\u008e\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001c\u0010\u008c\u0001\u001a\u00030\u008d\u0001*\u00030\u0091\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001c\u0010\u0094\u0001\u001a\u00030\u008e\u0001*\u00030\u0091\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u001e\u0010\u0094\u0001\u001a\u00030\u008e\u0001*\u00020\rH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001f\u0010\u0094\u0001\u001a\u00030\u008e\u0001*\u00030\u008d\u0001H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0099\u0001J\u001b\u0010\u009a\u0001\u001a\u00030\u009b\u0001*\u00020\u001dH\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u001b\u0010\u009e\u0001\u001a\u00020\r*\u00030\u008e\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010\u0098\u0001J\u001b\u0010\u009e\u0001\u001a\u00020\r*\u00030\u0091\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010\u0096\u0001J\u0010\u0010¡\u0001\u001a\u00030¢\u0001*\u00030£\u0001H\u0097\u0001J\u001b\u0010¤\u0001\u001a\u00020\u001d*\u00030\u009b\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b¥\u0001\u0010\u009d\u0001J\u001c\u0010¦\u0001\u001a\u00030\u0091\u0001*\u00030\u008e\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001e\u0010¦\u0001\u001a\u00030\u0091\u0001*\u00020\rH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010¨\u0001J\u001f\u0010¦\u0001\u001a\u00030\u0091\u0001*\u00030\u008d\u0001H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010ª\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\r8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0012\u0010\u0018\u001a\u00020\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006«\u0001"}, m13886d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawDirect", "drawDirect-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "performDraw", "record", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutNodeDrawScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutNodeDrawScope.kt\nandroidx/compose/ui/node/LayoutNodeDrawScope\n+ 2 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n+ 3 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 4 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 5 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 6 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 7 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n*L\n1#1,133:1\n256#2:134\n329#2,26:225\n80#3:135\n80#3:179\n80#3:180\n80#3:181\n432#4,6:136\n442#4,2:143\n444#4,8:148\n452#4,9:159\n461#4,8:171\n432#4,6:182\n442#4,2:189\n444#4,8:194\n452#4,9:205\n461#4,8:217\n249#5:142\n249#5:188\n245#6,3:145\n248#6,3:168\n245#6,3:191\n248#6,3:214\n1208#7:156\n1187#7,2:157\n1208#7:202\n1187#7,2:203\n*S KotlinDebug\n*F\n+ 1 LayoutNodeDrawScope.kt\nandroidx/compose/ui/node/LayoutNodeDrawScope\n*L\n48#1:134\n102#1:225,26\n56#1:135\n63#1:179\n75#1:180\n88#1:181\n56#1:136,6\n56#1:143,2\n56#1:148,8\n56#1:159,9\n56#1:171,8\n88#1:182,6\n88#1:189,2\n88#1:194,8\n88#1:205,9\n88#1:217,8\n56#1:142\n88#1:188\n56#1:145,3\n56#1:168,3\n88#1:191,3\n88#1:214,3\n56#1:156\n56#1:157,2\n88#1:202\n88#1:203,2\n*E\n"})
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    public static final int $stable = 0;

    @NotNull
    private final CanvasDrawScope canvasDrawScope;

    @Nullable
    private DrawModifierNode drawNode;

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNodeDrawScope() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: draw-eZhPAX0$ui_release, reason: not valid java name */
    public final void m20017draweZhPAX0$ui_release(@NotNull Canvas canvas, long size, @NotNull NodeCoordinator coordinator, @NotNull Modifier.Node drawNode, @Nullable GraphicsLayer layer) {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(4);
        Modifier.Node nodePop = drawNode;
        MutableVector mutableVector = null;
        while (nodePop != null) {
            if (nodePop instanceof DrawModifierNode) {
                m20018drawDirecteZhPAX0$ui_release(canvas, size, coordinator, (DrawModifierNode) nodePop, layer);
            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                int i = 0;
                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            nodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodePop != null) {
                                mutableVector.add(nodePop);
                                nodePop = null;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                }
                if (i == 1) {
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-illE91I */
    public void mo18973drawArcillE91I(@NotNull Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18973drawArcillE91I(brush, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    public void mo18974drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18974drawArcyD3GUKo(color, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-V9BoPsw */
    public void mo18975drawCircleV9BoPsw(@NotNull Brush brush, float radius, long center, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18975drawCircleV9BoPsw(brush, radius, center, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    public void mo18976drawCircleVaOC9Bg(long color, float radius, long center, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18976drawCircleVaOC9Bg(color, radius, center, alpha, style, colorFilter, blendMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    @Override // androidx.compose.p109ui.graphics.drawscope.ContentDrawScope
    public void drawContent() {
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        Modifier.Node nodeNextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode);
        if (nodeNextDrawNode == 0) {
            NodeCoordinator nodeCoordinatorM19977requireCoordinator64DMado = DelegatableNodeKt.m19977requireCoordinator64DMado(drawModifierNode, NodeKind.m20090constructorimpl(4));
            if (nodeCoordinatorM19977requireCoordinator64DMado.getTail() == drawModifierNode.getNode()) {
                nodeCoordinatorM19977requireCoordinator64DMado = nodeCoordinatorM19977requireCoordinator64DMado.getWrapped();
                Intrinsics.checkNotNull(nodeCoordinatorM19977requireCoordinator64DMado);
            }
            nodeCoordinatorM19977requireCoordinator64DMado.performDraw(canvas, getDrawContext().getGraphicsLayer());
            return;
        }
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(4);
        MutableVector mutableVector = null;
        while (nodeNextDrawNode != 0) {
            if (nodeNextDrawNode instanceof DrawModifierNode) {
                performDraw((DrawModifierNode) nodeNextDrawNode, canvas, getDrawContext().getGraphicsLayer());
            } else if ((nodeNextDrawNode.getKindSet() & iM20090constructorimpl) != 0 && (nodeNextDrawNode instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) nodeNextDrawNode).getDelegate();
                int i = 0;
                nodeNextDrawNode = nodeNextDrawNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            nodeNextDrawNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodeNextDrawNode != 0) {
                                mutableVector.add(nodeNextDrawNode);
                                nodeNextDrawNode = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    nodeNextDrawNode = nodeNextDrawNode;
                }
                if (i == 1) {
                }
            }
            nodeNextDrawNode = DelegatableNodeKt.pop(mutableVector);
        }
    }

    /* JADX INFO: renamed from: drawDirect-eZhPAX0$ui_release, reason: not valid java name */
    public final void m20018drawDirecteZhPAX0$ui_release(@NotNull Canvas canvas, long size, @NotNull NodeCoordinator coordinator, @NotNull DrawModifierNode drawNode, @Nullable GraphicsLayer layer) {
        DrawModifierNode drawModifierNode = this.drawNode;
        this.drawNode = drawNode;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        LayoutDirection layoutDirection = coordinator.getLayoutDirection();
        Density density = canvasDrawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = canvasDrawScope.getDrawContext().getCanvas();
        long jMo18997getSizeNHjbRc = canvasDrawScope.getDrawContext().mo18997getSizeNHjbRc();
        GraphicsLayer graphicsLayer = canvasDrawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = canvasDrawScope.getDrawContext();
        drawContext.setDensity(coordinator);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo18998setSizeuvyYCjk(size);
        drawContext.setGraphicsLayer(layer);
        canvas.save();
        try {
            drawNode.draw(this);
            canvas.restore();
            DrawContext drawContext2 = canvasDrawScope.getDrawContext();
            drawContext2.setDensity(density);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer);
            this.drawNode = drawModifierNode;
        } catch (Throwable th) {
            canvas.restore();
            DrawContext drawContext3 = canvasDrawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas2);
            drawContext3.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
            drawContext3.setGraphicsLayer(graphicsLayer);
            throw th;
        }
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* JADX INFO: renamed from: drawImage-9jGpkUE */
    public /* synthetic */ void mo18977drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18977drawImage9jGpkUE(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    public void mo18978drawImageAZ2fEMs(@NotNull ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.canvasDrawScope.mo18978drawImageAZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    public void mo18979drawImagegbVJVH8(@NotNull ImageBitmap image, long topLeft, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18979drawImagegbVJVH8(image, topLeft, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc */
    public void mo18980drawLine1RTmtNc(@NotNull Brush brush, long start, long end, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18980drawLine1RTmtNc(brush, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    public void mo18981drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18981drawLineNGM6Ib0(color, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-AsUm42w */
    public void mo18982drawOvalAsUm42w(@NotNull Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18982drawOvalAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-n-J9OG0 */
    public void mo18983drawOvalnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18983drawOvalnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    public void mo18984drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18984drawPathGBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI */
    public void mo18985drawPathLG529CI(@NotNull Path path, long color, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18985drawPathLG529CI(path, color, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-F8ZwMP8 */
    public void mo18986drawPointsF8ZwMP8(@NotNull List<Offset> points, int pointMode, long color, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18986drawPointsF8ZwMP8(points, pointMode, color, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-Gsft0Ws */
    public void mo18987drawPointsGsft0Ws(@NotNull List<Offset> points, int pointMode, @NotNull Brush brush, float strokeWidth, int cap, @Nullable PathEffect pathEffect, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18987drawPointsGsft0Ws(points, pointMode, brush, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w */
    public void mo18988drawRectAsUm42w(@NotNull Brush brush, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18988drawRectAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    public void mo18989drawRectnJ9OG0(long color, long topLeft, long size, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18989drawRectnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    public void mo18990drawRoundRectZuiqVtQ(@NotNull Brush brush, long topLeft, long size, long cornerRadius, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18990drawRoundRectZuiqVtQ(brush, topLeft, size, cornerRadius, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    public void mo18991drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, @NotNull DrawStyle style, @FloatRange(from = 0.0d, m705to = 1.0d) float alpha, @Nullable ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo18991drawRoundRectuAw5IA(color, topLeft, size, cornerRadius, style, alpha, colorFilter, blendMode);
    }

    @NotNull
    public final CanvasDrawScope getCanvasDrawScope() {
        return this.canvasDrawScope;
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    public long mo19075getCenterF1C5BW0() {
        return this.canvasDrawScope.mo19075getCenterF1C5BW0();
    }

    @Override // androidx.compose.p109ui.unit.Density
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    @NotNull
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public long mo19076getSizeNHjbRc() {
        return this.canvasDrawScope.mo19076getSizeNHjbRc();
    }

    public final void performDraw(@NotNull DrawModifierNode drawModifierNode, @NotNull Canvas canvas, @Nullable GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinatorM19977requireCoordinator64DMado = DelegatableNodeKt.m19977requireCoordinator64DMado(drawModifierNode, NodeKind.m20090constructorimpl(4));
        nodeCoordinatorM19977requireCoordinator64DMado.getLayoutNode().getMDrawScope$ui_release().m20018drawDirecteZhPAX0$ui_release(canvas, IntSizeKt.m21150toSizeozmzZPI(nodeCoordinatorM19977requireCoordinator64DMado.mo19863getSizeYbymL2g()), nodeCoordinatorM19977requireCoordinator64DMado, drawModifierNode, graphicsLayer);
    }

    @Override // androidx.compose.p109ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: record-JVtK1S4 */
    public void mo19077recordJVtK1S4(@NotNull GraphicsLayer graphicsLayer, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        this.canvasDrawScope.mo19077recordJVtK1S4(graphicsLayer, j, function1);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo15539roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.mo15539roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo15540roundToPx0680j_4(float f) {
        return this.canvasDrawScope.mo15540roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo15541toDpGaN1DYA(long j) {
        return this.canvasDrawScope.mo15541toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo15542toDpu2uoSUM(float f) {
        return this.canvasDrawScope.mo15542toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo15544toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.mo15544toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo15545toPxR2X_6o(long j) {
        return this.canvasDrawScope.mo15545toPxR2X_6o(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo15546toPx0680j_4(float f) {
        return this.canvasDrawScope.mo15546toPx0680j_4(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        return this.canvasDrawScope.toRect(dpRect);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo15547toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.mo15547toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo15548toSp0xMU5do(float f) {
        return this.canvasDrawScope.mo15548toSp0xMU5do(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo15549toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo15549toSpkPz2Gy4(f);
    }

    public LayoutNodeDrawScope(@NotNull CanvasDrawScope canvasDrawScope) {
        this.canvasDrawScope = canvasDrawScope;
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo15543toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo15543toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo15550toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.mo15550toSpkPz2Gy4(i);
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
