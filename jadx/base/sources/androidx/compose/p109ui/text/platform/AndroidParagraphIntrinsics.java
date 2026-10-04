package androidx.compose.p109ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.ParagraphIntrinsics;
import androidx.compose.p109ui.text.Placeholder;
import androidx.compose.p109ui.text.SpanStyle;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.android.LayoutIntrinsics;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.font.TypefaceResult;
import androidx.compose.p109ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u000202X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u00069"}, m13886d2 = {"Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;)V", "charSequence", "", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "emojiCompatProcessed", "", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "hasStaleResolvedFonts", "getHasStaleResolvedFonts", "()Z", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "getLayoutIntrinsics$ui_text_release", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "getPlaceholders", "()Ljava/util/List;", "resolvedTypefaces", "Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;", "getSpanStyles", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Ljava/lang/String;", "textDirectionHeuristic", "", "getTextDirectionHeuristic$ui_text_release", "()I", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {
    public static final int $stable = 8;

    @NotNull
    private final CharSequence charSequence;

    @NotNull
    private final Density density;
    private final boolean emojiCompatProcessed;

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    @NotNull
    private final LayoutIntrinsics layoutIntrinsics;

    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    @Nullable
    private TypefaceDirtyTrackerLinkedList resolvedTypefaces;

    @NotNull
    private final List<AnnotatedString.Range<SpanStyle>> spanStyles;

    @NotNull
    private final TextStyle style;

    @NotNull
    private final String text;
    private final int textDirectionHeuristic;

    @NotNull
    private final AndroidTextPaint textPaint;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.List, java.util.List<androidx.compose.ui.text.AnnotatedString$Range<androidx.compose.ui.text.SpanStyle>>] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
    public AndroidParagraphIntrinsics(@NotNull String str, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, @NotNull FontFamily.Resolver resolver, @NotNull Density density) {
        this.text = str;
        this.style = textStyle;
        this.spanStyles = list;
        this.placeholders = list2;
        this.fontFamilyResolver = resolver;
        this.density = density;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1, density.getDensity());
        this.textPaint = androidTextPaint;
        this.emojiCompatProcessed = !AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat(textStyle) ? false : EmojiCompatStatus.INSTANCE.getFontLoaded().getValue().booleanValue();
        this.textDirectionHeuristic = AndroidParagraphIntrinsics_androidKt.m20711resolveTextDirectionHeuristicsHklW4sA(textStyle.m20499getTextDirections_7Xco(), textStyle.getLocaleList());
        Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function4 = new Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface>() { // from class: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics$resolveTypeface$1
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Typeface invoke(FontFamily fontFamily, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis) {
                return m20710invokeDPcqOEQ(fontFamily, fontWeight, fontStyle.m20568unboximpl(), fontSynthesis.getValue());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-DPcqOEQ, reason: not valid java name */
            public final Typeface m20710invokeDPcqOEQ(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i, int i2) {
                State<Object> stateMo20540resolveDPcqOEQ = this.this$0.getFontFamilyResolver().mo20540resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
                if (stateMo20540resolveDPcqOEQ instanceof TypefaceResult.Immutable) {
                    Object value = stateMo20540resolveDPcqOEQ.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                    return (Typeface) value;
                }
                TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList = new TypefaceDirtyTrackerLinkedList(stateMo20540resolveDPcqOEQ, this.this$0.resolvedTypefaces);
                this.this$0.resolvedTypefaces = typefaceDirtyTrackerLinkedList;
                return typefaceDirtyTrackerLinkedList.getTypeface();
            }
        };
        TextPaintExtensions_androidKt.setTextMotion(androidTextPaint, textStyle.getTextMotion());
        SpanStyle spanStyleApplySpanStyle = TextPaintExtensions_androidKt.applySpanStyle(androidTextPaint, textStyle.toSpanStyle(), function4, density, !((Collection) list).isEmpty());
        if (spanStyleApplySpanStyle != null) {
            int size = list.size() + 1;
            list = new ArrayList<>(size);
            int i = 0;
            while (i < size) {
                list.add(i == 0 ? new AnnotatedString.Range<>(spanStyleApplySpanStyle, 0, this.text.length()) : this.spanStyles.get(i - 1));
                i++;
            }
        }
        CharSequence charSequenceCreateCharSequence = AndroidParagraphHelper_androidKt.createCharSequence(this.text, this.textPaint.getTextSize(), this.style, list, this.placeholders, this.density, function4, this.emojiCompatProcessed);
        this.charSequence = charSequenceCreateCharSequence;
        this.layoutIntrinsics = new LayoutIntrinsics(charSequenceCreateCharSequence, this.textPaint, this.textDirectionHeuristic);
    }

    @NotNull
    /* JADX INFO: renamed from: getCharSequence$ui_text_release, reason: from getter */
    public final CharSequence getCharSequence() {
        return this.charSequence;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @Override // androidx.compose.p109ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList = this.resolvedTypefaces;
        if (typefaceDirtyTrackerLinkedList != null ? typefaceDirtyTrackerLinkedList.isStaleResolvedFont() : false) {
            return true;
        }
        return !this.emojiCompatProcessed && AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat(this.style) && EmojiCompatStatus.INSTANCE.getFontLoaded().getValue().booleanValue();
    }

    @NotNull
    /* JADX INFO: renamed from: getLayoutIntrinsics$ui_text_release, reason: from getter */
    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    @Override // androidx.compose.p109ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.p109ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    @NotNull
    public final List<AnnotatedString.Range<SpanStyle>> getSpanStyles() {
        return this.spanStyles;
    }

    @NotNull
    public final TextStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: getTextDirectionHeuristic$ui_text_release, reason: from getter */
    public final int getTextDirectionHeuristic() {
        return this.textDirectionHeuristic;
    }

    @NotNull
    /* JADX INFO: renamed from: getTextPaint$ui_text_release, reason: from getter */
    public final AndroidTextPaint getTextPaint() {
        return this.textPaint;
    }
}
