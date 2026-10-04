package androidx.compose.p109ui.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.graphics.drawscope.DrawTransform;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextDrawStyleKt;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntSize;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.java.awt.GridBagConstraints;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001af\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001ah\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0080\u0001\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aj\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020/2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a&\u00102\u001a\u000203*\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, m13886d2 = {"clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", VElementKey.SHADOW, "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawText-LVfH_YU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawText-d8-rzKo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "size", "Landroidx/compose/ui/geometry/Size;", "drawText-JFhB2K4", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;JI)V", "", "drawText-TPWCCtM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJI)V", "textLayoutConstraints", "Landroidx/compose/ui/unit/Constraints;", "textLayoutConstraints-v_w8tDc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJ)J", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextPainter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextPainter.kt\nandroidx/compose/ui/text/TextPainterKt\n+ 2 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n+ 3 Color.kt\nandroidx/compose/ui/graphics/ColorKt\n+ 4 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n+ 5 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,399:1\n272#2,14:400\n272#2,14:414\n272#2,9:428\n282#2,4:440\n272#2,14:444\n702#3:437\n708#3:438\n696#3:439\n205#4:458\n205#4:461\n26#5:459\n26#5:460\n26#5:462\n26#5:463\n*S KotlinDebug\n*F\n+ 1 TextPainter.kt\nandroidx/compose/ui/text/TextPainterKt\n*L\n167#1:400,14\n233#1:414,14\n277#1:428,9\n277#1:440,4\n337#1:444,14\n284#1:437\n297#1:438\n297#1:439\n375#1:458\n387#1:461\n378#1:459\n380#1:460\n390#1:462\n392#1:463\n*E\n"})
public final class TextPainterKt {
    private static final void clip(DrawTransform drawTransform, TextLayoutResult textLayoutResult) {
        if (!textLayoutResult.getHasVisualOverflow() || TextOverflow.m20899equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m20908getVisiblegIe3tQ8())) {
            return;
        }
        DrawTransform.m19133clipRectN_I0leg$default(drawTransform, 0.0f, 0.0f, IntSize.m21138getWidthimpl(textLayoutResult.getSize()), IntSize.m21137getHeightimpl(textLayoutResult.getSize()), 0, 16, null);
    }

    /* JADX INFO: renamed from: drawText-JFhB2K4, reason: not valid java name */
    public static final void m20435drawTextJFhB2K4(@NotNull DrawScope drawScope, @NotNull TextMeasurer textMeasurer, @NotNull AnnotatedString annotatedString, long j, @NotNull TextStyle textStyle, int i, boolean z, int i2, @NotNull List<AnnotatedString.Range<Placeholder>> list, long j2, int i4) {
        TextLayoutResult textLayoutResultM20432measurexDpz5zY$default = TextMeasurer.m20432measurexDpz5zY$default(textMeasurer, annotatedString, textStyle, i, z, i2, list, m20443textLayoutConstraintsv_w8tDc(drawScope, j2, j), drawScope.getLayoutDirection(), drawScope, null, false, GridBagConstraints.ABOVE_BASELINE_TRAILING, null);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            transform.translate(Offset.m18284getXimpl(j), Offset.m18285getYimpl(j));
            clip(transform, textLayoutResultM20432measurexDpz5zY$default);
            textLayoutResultM20432measurexDpz5zY$default.getMultiParagraph().m20325paintLG529CI(drawScope.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i4);
        } finally {
            AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: drawText-LVfH_YU, reason: not valid java name */
    public static final void m20437drawTextLVfH_YU(@NotNull DrawScope drawScope, @NotNull TextLayoutResult textLayoutResult, @NotNull Brush brush, long j, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle, int i) {
        Shadow shadow2 = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration textDecoration2 = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle drawStyle2 = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            transform.translate(Offset.m18284getXimpl(j), Offset.m18285getYimpl(j));
            clip(transform, textLayoutResult);
            textLayoutResult.getMultiParagraph().m20327painthn5TExg(drawScope.getDrawContext().getCanvas(), brush, !Float.isNaN(f) ? f : textLayoutResult.getLayoutInput().getStyle().getAlpha(), shadow2, textDecoration2, drawStyle2, i);
        } finally {
            AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: drawText-TPWCCtM, reason: not valid java name */
    public static final void m20439drawTextTPWCCtM(@NotNull DrawScope drawScope, @NotNull TextMeasurer textMeasurer, @NotNull String str, long j, @NotNull TextStyle textStyle, int i, boolean z, int i2, long j2, int i4) {
        TextLayoutResult textLayoutResultM20432measurexDpz5zY$default = TextMeasurer.m20432measurexDpz5zY$default(textMeasurer, new AnnotatedString(str, null, null, 6, null), textStyle, i, z, i2, null, m20443textLayoutConstraintsv_w8tDc(drawScope, j2, j), drawScope.getLayoutDirection(), drawScope, null, false, 1568, null);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            transform.translate(Offset.m18284getXimpl(j), Offset.m18285getYimpl(j));
            clip(transform, textLayoutResultM20432measurexDpz5zY$default);
            textLayoutResultM20432measurexDpz5zY$default.getMultiParagraph().m20325paintLG529CI(drawScope.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m19078getDefaultBlendMode0nO6VwU() : i4);
        } finally {
            AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: drawText-d8-rzKo, reason: not valid java name */
    public static final void m20441drawTextd8rzKo(@NotNull DrawScope drawScope, @NotNull TextLayoutResult textLayoutResult, long j, long j2, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle, int i) {
        float alpha;
        int i2;
        Shadow shadow2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        Canvas canvas;
        MultiParagraph multiParagraph;
        Shadow shadow3 = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle drawStyle3 = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            transform.translate(Offset.m18284getXimpl(j2), Offset.m18285getYimpl(j2));
            clip(transform, textLayoutResult);
            Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
            if (brush == null || j != 16) {
                MultiParagraph multiParagraph2 = textLayoutResult.getMultiParagraph();
                Canvas canvas2 = drawScope.getDrawContext().getCanvas();
                if (j == 16) {
                    j = textLayoutResult.getLayoutInput().getStyle().m20486getColor0d7_KjU();
                }
                multiParagraph2.m20325paintLG529CI(canvas2, TextDrawStyleKt.m20877modulateDxMtmZc(j, f), shadow3, textDecoration3, drawStyle3, i);
            } else {
                MultiParagraph multiParagraph3 = textLayoutResult.getMultiParagraph();
                Canvas canvas3 = drawScope.getDrawContext().getCanvas();
                if (Float.isNaN(f)) {
                    alpha = textLayoutResult.getLayoutInput().getStyle().getAlpha();
                    i2 = i;
                    shadow2 = shadow3;
                    textDecoration2 = textDecoration3;
                    drawStyle2 = drawStyle3;
                    canvas = canvas3;
                    multiParagraph = multiParagraph3;
                } else {
                    alpha = f;
                    canvas = canvas3;
                    multiParagraph = multiParagraph3;
                    i2 = i;
                    shadow2 = shadow3;
                    textDecoration2 = textDecoration3;
                    drawStyle2 = drawStyle3;
                }
                multiParagraph.m20327painthn5TExg(canvas, brush, alpha, shadow2, textDecoration2, drawStyle2, i2);
            }
            AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
        } catch (Throwable th) {
            AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
            throw th;
        }
    }

    /* JADX INFO: renamed from: textLayoutConstraints-v_w8tDc, reason: not valid java name */
    private static final long m20443textLayoutConstraintsv_w8tDc(DrawScope drawScope, long j, long j2) {
        int iRound;
        int iRound2;
        int iRound3;
        int iRound4 = 0;
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats || Float.isNaN(Size.m18353getWidthimpl(j))) {
            iRound = Math.round((float) Math.ceil(Size.m18353getWidthimpl(drawScope.mo19076getSizeNHjbRc()) - Offset.m18284getXimpl(j2)));
            iRound2 = 0;
        } else {
            iRound2 = Math.round((float) Math.ceil(Size.m18353getWidthimpl(j)));
            iRound = iRound2;
        }
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats || Float.isNaN(Size.m18350getHeightimpl(j))) {
            iRound3 = Math.round((float) Math.ceil(Size.m18350getHeightimpl(drawScope.mo19076getSizeNHjbRc()) - Offset.m18285getYimpl(j2)));
        } else {
            iRound4 = Math.round((float) Math.ceil(Size.m18350getHeightimpl(j)));
            iRound3 = iRound4;
        }
        return ConstraintsKt.Constraints(iRound2, iRound, iRound4, iRound3);
    }
}
