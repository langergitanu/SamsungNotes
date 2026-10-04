package androidx.compose.p109ui.text;

import androidx.annotation.IntRange;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.p109ui.text.font.Font;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.platform.AndroidMultiParagraphDraw_androidKt;
import androidx.compose.p109ui.text.style.ResolvedTextDirection;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nBY\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017BY\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aBY\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001eJ*\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020>2\b\b\u0001\u0010B\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010H\u001a\u00020:2\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010I\u001a\u00020:2\u0006\u0010G\u001a\u00020\u0005J\u0016\u0010J\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010N\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u0018\u0010O\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\tJ\u000e\u0010T\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010U\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010V\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010X\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u0018\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\\ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u000e\u0010_\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0005J\u0016\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0005J(\u0010d\u001a\u00020@2\u0006\u0010e\u001a\u00020:2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iø\u0001\u0000¢\u0006\u0004\bj\u0010kJ\u001b\u0010l\u001a\u00020@2\u0006\u0010G\u001a\u00020\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010nJ\u000e\u0010o\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0005JY\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\b\b\u0002\u0010v\u001a\u00020\t2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010x2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010z2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010|2\b\b\u0002\u0010}\u001a\u00020~ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001J@\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010x2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010zH\u0007ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001JT\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010x2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010z2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010|2\b\b\u0002\u0010}\u001a\u00020~ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0011\u0010\u0087\u0001\u001a\u00020q2\u0006\u0010G\u001a\u00020\u0005H\u0002J\u0011\u0010\u0088\u0001\u001a\u00020q2\u0006\u0010G\u001a\u00020\u0005H\u0002J\u0011\u0010\u0089\u0001\u001a\u00020q2\u0006\u0010M\u001a\u00020\u0005H\u0002R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b1\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u00103\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b4\u0010&R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u0010¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008a\u0001"}, m13886d2 = {"Landroidx/compose/ui/text/MultiParagraph;", "", "intrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "maxLines", "", "ellipsis", "", "width", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZ)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "lastBaseline", "getLastBaseline", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "paragraphInfoList", "Landroidx/compose/ui/text/ParagraphInfo;", "getParagraphInfoList$ui_text_release", "()Ljava/util/List;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "getWidth", "fillBoundingBoxes", "", Bixby2Constants.BIXBY_PARAM_RANGE, "Landroidx/compose/ui/text/TextRange;", "array", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)[F", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", TypedValues.Cycle.S_WAVE_OFFSET, "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBaseline", "lineIndex", "getLineBottom", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getRangeForRect", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", VElementKey.SHADOW, "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "requireIndexInRange", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMultiParagraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiParagraph.kt\nandroidx/compose/ui/text/MultiParagraph\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1149:1\n508#2,3:1150\n33#2,4:1153\n511#2:1157\n151#2,3:1158\n33#2,4:1161\n154#2,2:1165\n38#2:1167\n156#2:1168\n512#2,2:1169\n38#2:1171\n514#2:1172\n33#2,6:1174\n33#2,6:1180\n1#3:1173\n*S KotlinDebug\n*F\n+ 1 MultiParagraph.kt\nandroidx/compose/ui/text/MultiParagraph\n*L\n372#1:1150,3\n372#1:1153,4\n372#1:1157\n374#1:1158,3\n374#1:1161,4\n374#1:1165,2\n374#1:1167\n374#1:1168\n372#1:1169,2\n372#1:1171\n372#1:1172\n400#1:1174,6\n417#1:1180,6\n*E\n"})
public final class MultiParagraph {
    public static final int $stable = 8;
    private final boolean didExceedMaxLines;
    private final float height;

    @NotNull
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;

    @NotNull
    private final List<ParagraphInfo> paragraphInfoList;

    @NotNull
    private final List<Rect> placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i, z);
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public static /* synthetic */ int getLineEnd$default(MultiParagraph multiParagraph, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return multiParagraph.getLineEnd(i, z);
    }

    /* JADX INFO: renamed from: paint-RPmYEkk$default, reason: not valid java name */
    public static /* synthetic */ void m20319paintRPmYEkk$default(MultiParagraph multiParagraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Color.INSTANCE.m18561getUnspecified0d7_KjU();
        }
        multiParagraph.m20326paintRPmYEkk(canvas, j, (i & 4) != 0 ? null : shadow, (i & 8) != 0 ? null : textDecoration);
    }

    /* JADX INFO: renamed from: paint-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m20320painthn5TExg$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = Float.NaN;
        }
        multiParagraph.m20327painthn5TExg(canvas, brush, f, (i2 & 8) != 0 ? null : shadow, (i2 & 16) != 0 ? null : textDecoration, (i2 & 32) != 0 ? null : drawStyle, (i2 & 64) != 0 ? DrawScope.INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i);
    }

    private final void requireIndexInRange(int offset) {
        if (offset < 0 || offset >= getAnnotatedString().getText().length()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(offset, "offset(", ") is out of bounds [0, ");
            sbM778t.append(getAnnotatedString().length());
            sbM778t.append(PropertyUtils.MAPPED_DELIM2);
            throw new IllegalArgumentException(sbM778t.toString().toString());
        }
    }

    private final void requireIndexInRangeInclusiveEnd(int offset) {
        if (offset < 0 || offset > getAnnotatedString().getText().length()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(offset, "offset(", ") is out of bounds [0, ");
            sbM778t.append(getAnnotatedString().length());
            sbM778t.append(PropertyUtils.INDEXED_DELIM2);
            throw new IllegalArgumentException(sbM778t.toString().toString());
        }
    }

    private final void requireLineIndexInRange(int lineIndex) {
        if (lineIndex < 0 || lineIndex >= this.lineCount) {
            throw new IllegalArgumentException(AbstractC0000a.m13j(AbstractC0541b.m778t(lineIndex, "lineIndex(", ") is out of bounds [0, "), this.lineCount, PropertyUtils.MAPPED_DELIM2).toString());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final float[] m20321fillBoundingBoxes8ffj60Q(final long range, @NotNull final float[] array, @IntRange(from = 0) int arrayStart) {
        requireIndexInRange(TextRange.m20454getMinimpl(range));
        requireIndexInRangeInclusiveEnd(TextRange.m20453getMaximpl(range));
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = arrayStart;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        MultiParagraphKt.m20328findParagraphsByRangeSbBc2M(this.paragraphInfoList, range, new Function1<ParagraphInfo, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$fillBoundingBoxes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ParagraphInfo paragraphInfo) {
                invoke2(paragraphInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ParagraphInfo paragraphInfo) {
                long j = range;
                float[] fArr = array;
                Ref.IntRef intRef2 = intRef;
                Ref.FloatRef floatRef2 = floatRef;
                long jTextRange = TextRangeKt.TextRange(paragraphInfo.toLocalIndex(paragraphInfo.getStartIndex() > TextRange.m20454getMinimpl(j) ? paragraphInfo.getStartIndex() : TextRange.m20454getMinimpl(j)), paragraphInfo.toLocalIndex(paragraphInfo.getEndIndex() < TextRange.m20453getMaximpl(j) ? paragraphInfo.getEndIndex() : TextRange.m20453getMaximpl(j)));
                paragraphInfo.getParagraph().mo20287fillBoundingBoxes8ffj60Q(jTextRange, fArr, intRef2.element);
                int iM20452getLengthimpl = (TextRange.m20452getLengthimpl(jTextRange) * 4) + intRef2.element;
                for (int i = intRef2.element; i < iM20452getLengthimpl; i += 4) {
                    int i2 = i + 1;
                    float f = fArr[i2];
                    float f4 = floatRef2.element;
                    fArr[i2] = f + f4;
                    int i4 = i + 3;
                    fArr[i4] = fArr[i4] + f4;
                }
                intRef2.element = iM20452getLengthimpl;
                floatRef2.element = paragraphInfo.getParagraph().getHeight() + floatRef2.element;
            }
        });
        return array;
    }

    @NotNull
    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getBidiRunDirection(paragraphInfo.toLocalIndex(offset));
    }

    @NotNull
    public final Rect getBoundingBox(int offset) {
        requireIndexInRange(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getBoundingBox(paragraphInfo.toLocalIndex(offset)));
    }

    @NotNull
    public final Rect getCursorRect(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getCursorRect(paragraphInfo.toLocalIndex(offset)));
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getFirstBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getHorizontalPosition(paragraphInfo.toLocalIndex(offset), usePrimaryDirection);
    }

    @NotNull
    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final float getLastBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt.last((List) this.paragraphInfoList);
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLastBaseline());
    }

    public final float getLineBaseline(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBaseline(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineBottom(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBottom(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineEnd(paragraphInfo.toLocalLineIndex(lineIndex), visibleEnd));
    }

    public final int getLineForOffset(int offset) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset >= getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : offset < 0 ? 0 : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForOffset(paragraphInfo.toLocalIndex(offset)));
    }

    public final int getLineForVerticalPosition(float vertical) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, vertical));
        return paragraphInfo.getLength() == 0 ? paragraphInfo.getStartLineIndex() : paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForVerticalPosition(paragraphInfo.toLocalYPosition(vertical)));
    }

    public final float getLineHeight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineHeight(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getLineLeft(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineLeft(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getLineRight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineRight(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final int getLineStart(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineStart(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineTop(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineTop(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineWidth(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineWidth(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getMaxIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final float getMinIntrinsicWidth() {
        return this.intrinsics.getMinIntrinsicWidth();
    }

    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m20322getOffsetForPositionk4lQ0M(long position) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Offset.m18285getYimpl(position)));
        return paragraphInfo.getLength() == 0 ? paragraphInfo.getStartIndex() : paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().mo20289getOffsetForPositionk4lQ0M(paragraphInfo.m20337toLocalMKHz9U(position)));
    }

    @NotNull
    public final ResolvedTextDirection getParagraphDirection(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getParagraphDirection(paragraphInfo.toLocalIndex(offset));
    }

    @NotNull
    public final List<ParagraphInfo> getParagraphInfoList$ui_text_release() {
        return this.paragraphInfoList;
    }

    @NotNull
    public final Path getPathForRange(final int start, final int end) {
        if (start < 0 || start > end || end > getAnnotatedString().getText().length()) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(start, end, "Start(", ") or End(", ") is out of range [0..");
            sbM1173s.append(getAnnotatedString().getText().length());
            sbM1173s.append("), or start > end!");
            throw new IllegalArgumentException(sbM1173s.toString().toString());
        }
        if (start == end) {
            return AndroidPath_androidKt.Path();
        }
        final Path Path = AndroidPath_androidKt.Path();
        MultiParagraphKt.m20328findParagraphsByRangeSbBc2M(this.paragraphInfoList, TextRangeKt.TextRange(start, end), new Function1<ParagraphInfo, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph.getPathForRange.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ParagraphInfo paragraphInfo) {
                invoke2(paragraphInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ParagraphInfo paragraphInfo) {
                Path.m18795addPathUv8p0NA$default(Path, paragraphInfo.toGlobal(paragraphInfo.getParagraph().getPathForRange(paragraphInfo.toLocalIndex(start), paragraphInfo.toLocalIndex(end))), 0L, 2, null);
            }
        });
        return Path;
    }

    @NotNull
    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    /* JADX INFO: renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m20323getRangeForRect86BmAI(@NotNull Rect rect, int granularity, @NotNull TextInclusionStrategy inclusionStrategy) {
        TextRange.Companion companion;
        TextRange.Companion companion2;
        int iFindParagraphByY = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getTop());
        if (this.paragraphInfoList.get(iFindParagraphByY).getBottom() >= rect.getBottom() || iFindParagraphByY == CollectionsKt.getLastIndex(this.paragraphInfoList)) {
            ParagraphInfo paragraphInfo = this.paragraphInfoList.get(iFindParagraphByY);
            return ParagraphInfo.m20335toGlobalxdX6G0$default(paragraphInfo, paragraphInfo.getParagraph().mo20290getRangeForRect86BmAI(paragraphInfo.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
        }
        int iFindParagraphByY2 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getBottom());
        long jM20461getZerod9O1mEE = TextRange.INSTANCE.m20461getZerod9O1mEE();
        while (true) {
            companion = TextRange.INSTANCE;
            if (!TextRange.m20449equalsimpl0(jM20461getZerod9O1mEE, companion.m20461getZerod9O1mEE()) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo2 = this.paragraphInfoList.get(iFindParagraphByY);
            jM20461getZerod9O1mEE = ParagraphInfo.m20335toGlobalxdX6G0$default(paragraphInfo2, paragraphInfo2.getParagraph().mo20290getRangeForRect86BmAI(paragraphInfo2.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
            iFindParagraphByY++;
        }
        if (TextRange.m20449equalsimpl0(jM20461getZerod9O1mEE, companion.m20461getZerod9O1mEE())) {
            return companion.m20461getZerod9O1mEE();
        }
        long jM20461getZerod9O1mEE2 = companion.m20461getZerod9O1mEE();
        while (true) {
            companion2 = TextRange.INSTANCE;
            if (!TextRange.m20449equalsimpl0(jM20461getZerod9O1mEE2, companion2.m20461getZerod9O1mEE()) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo3 = this.paragraphInfoList.get(iFindParagraphByY2);
            jM20461getZerod9O1mEE2 = ParagraphInfo.m20335toGlobalxdX6G0$default(paragraphInfo3, paragraphInfo3.getParagraph().mo20290getRangeForRect86BmAI(paragraphInfo3.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
            iFindParagraphByY2--;
        }
        return TextRange.m20449equalsimpl0(jM20461getZerod9O1mEE2, companion2.m20461getZerod9O1mEE()) ? jM20461getZerod9O1mEE : TextRangeKt.TextRange(TextRange.m20456getStartimpl(jM20461getZerod9O1mEE), TextRange.m20451getEndimpl(jM20461getZerod9O1mEE2));
    }

    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m20324getWordBoundaryjx7JFs(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.m20336toGlobalxdX6G0(paragraphInfo.getParagraph().mo20291getWordBoundaryjx7JFs(paragraphInfo.toLocalIndex(offset)), false);
    }

    public final boolean isLineEllipsized(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        return this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex)).getParagraph().isLineEllipsized(lineIndex);
    }

    /* JADX INFO: renamed from: paint-LG529CI, reason: not valid java name */
    public final void m20325paintLG529CI(@NotNull Canvas canvas, long color, @Nullable Shadow shadow, @Nullable TextDecoration decoration, @Nullable DrawStyle drawStyle, int blendMode) {
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = list.get(i);
            paragraphInfo.getParagraph().mo20292paintLG529CI(canvas, color, shadow, decoration, drawStyle, blendMode);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the new paint function that takes canvas as the only required parameter.")
    /* JADX INFO: renamed from: paint-RPmYEkk, reason: not valid java name */
    public final /* synthetic */ void m20326paintRPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration decoration) {
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        int i = 0;
        while (i < size) {
            ParagraphInfo paragraphInfo = list.get(i);
            Canvas canvas2 = canvas;
            long j = color;
            paragraphInfo.getParagraph().mo20293paintRPmYEkk(canvas2, j, shadow, decoration);
            canvas2.translate(0.0f, paragraphInfo.getParagraph().getHeight());
            i++;
            canvas = canvas2;
            color = j;
        }
        canvas.restore();
    }

    /* JADX INFO: renamed from: paint-hn5TExg, reason: not valid java name */
    public final void m20327painthn5TExg(@NotNull Canvas canvas, @NotNull Brush brush, float alpha, @Nullable Shadow shadow, @Nullable TextDecoration decoration, @Nullable DrawStyle drawStyle, int blendMode) {
        AndroidMultiParagraphDraw_androidKt.m20707drawMultiParagraph7AXcY_I(this, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, i, z);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z) {
        boolean z2;
        int iM20920getMaxHeightimpl;
        this.intrinsics = multiParagraphIntrinsics;
        this.maxLines = i;
        if (Constraints.m20923getMinWidthimpl(j) == 0 && Constraints.m20922getMinHeightimpl(j) == 0) {
            ArrayList arrayList = new ArrayList();
            List<ParagraphIntrinsicInfo> infoList$ui_text_release = multiParagraphIntrinsics.getInfoList$ui_text_release();
            int size = infoList$ui_text_release.size();
            int i2 = 0;
            float f = 0.0f;
            int i4 = 0;
            while (i4 < size) {
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = infoList$ui_text_release.get(i4);
                ParagraphIntrinsics intrinsics = paragraphIntrinsicInfo.getIntrinsics();
                int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j);
                if (Constraints.m20916getHasBoundedHeightimpl(j)) {
                    iM20920getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m20920getMaxHeightimpl(j) - ParagraphKt.ceilToInt(f), 0);
                } else {
                    iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j);
                }
                Paragraph paragraphM20340Paragraph_EkL_Y = ParagraphKt.m20340Paragraph_EkL_Y(intrinsics, ConstraintsKt.Constraints$default(0, iM20921getMaxWidthimpl, 0, iM20920getMaxHeightimpl, 5, null), this.maxLines - i2, z);
                float height = paragraphM20340Paragraph_EkL_Y.getHeight() + f;
                int lineCount = paragraphM20340Paragraph_EkL_Y.getLineCount() + i2;
                arrayList.add(new ParagraphInfo(paragraphM20340Paragraph_EkL_Y, paragraphIntrinsicInfo.getStartIndex(), paragraphIntrinsicInfo.getEndIndex(), i2, lineCount, f, height));
                if (paragraphM20340Paragraph_EkL_Y.getDidExceedMaxLines() || (lineCount == this.maxLines && i4 != CollectionsKt.getLastIndex(this.intrinsics.getInfoList$ui_text_release()))) {
                    z2 = true;
                    i2 = lineCount;
                    f = height;
                    break;
                } else {
                    i4++;
                    i2 = lineCount;
                    f = height;
                }
            }
            z2 = false;
            this.height = f;
            this.lineCount = i2;
            this.didExceedMaxLines = z2;
            this.paragraphInfoList = arrayList;
            this.width = Constraints.m20921getMaxWidthimpl(j);
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i5);
                List<Rect> placeholderRects = paragraphInfo.getParagraph().getPlaceholderRects();
                ArrayList arrayList3 = new ArrayList(placeholderRects.size());
                int size3 = placeholderRects.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    Rect rect = placeholderRects.get(i6);
                    arrayList3.add(rect != null ? paragraphInfo.toGlobal(rect) : null);
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList3);
            }
            int size4 = arrayList2.size();
            List<Rect> listPlus = arrayList2;
            if (size4 < this.intrinsics.getPlaceholders().size()) {
                int size5 = this.intrinsics.getPlaceholders().size() - arrayList2.size();
                ArrayList arrayList4 = new ArrayList(size5);
                for (int i7 = 0; i7 < size5; i7++) {
                    arrayList4.add(null);
                }
                listPlus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4);
            }
            this.placeholderRects = listPlus;
            return;
        }
        throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, (i2 & 4) != 0 ? Integer.MAX_VALUE : i, (i2 & 8) != 0 ? false : z, null);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, (i2 & 2) != 0 ? Integer.MAX_VALUE : i, (i2 & 4) != 0 ? false : z, f);
    }

    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(intrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(@NotNull MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z, float f) {
        this(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null), i, z, null);
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, float f, Density density, Font.ResourceLoader resourceLoader, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) ((i2 & 4) != 0 ? CollectionsKt.emptyList() : list), (i2 & 8) != 0 ? Integer.MAX_VALUE : i, (i2 & 16) != 0 ? false : z, f, density, resourceLoader);
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated, use fontFamilyResolver instead", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    public MultiParagraph(@NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, float f, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader)), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null), i, z, null);
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, f, density, resolver, (List<AnnotatedString.Range<Placeholder>>) ((i2 & 32) != 0 ? CollectionsKt.emptyList() : list), (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? false : z);
    }

    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(@NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, float f, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull List<AnnotatedString.Range<Placeholder>> list, int i, boolean z) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null), i, z, null);
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list, (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? false : z, null);
    }

    private MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver), j, i, z, null);
    }
}
