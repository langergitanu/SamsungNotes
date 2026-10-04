package androidx.compose.p109ui.text.platform;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.EmojiSupportMatch;
import androidx.compose.p109ui.text.Placeholder;
import androidx.compose.p109ui.text.PlatformParagraphStyle;
import androidx.compose.p109ui.text.PlatformTextStyle;
import androidx.compose.p109ui.text.SpanStyle;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.p109ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p109ui.text.style.LineHeightStyle;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextIndent;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.emoji2.text.EmojiCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000]\n\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0001\u001a\u0080\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\f2\u0006\u0010\u0011\u001a\u00020\u00122&\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\f\u0010\u001c\u001a\u00020\u001b*\u00020\nH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001d"}, m13886d2 = {"NoopSpan", "androidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1", "Landroidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1;", "createCharSequence", "", "text", "", "contextFontSize", "", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "useEmojiCompat", "", "isIncludeFontPaddingEnabled", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidParagraphHelper_androidKt {

    @NotNull
    private static final AndroidParagraphHelper_androidKt$NoopSpan$1 NoopSpan = new CharacterStyle() { // from class: androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(@Nullable TextPaint p0) {
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.emoji2.text.EmojiCompat] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @NotNull
    public static final CharSequence createCharSequence(@NotNull String str, float f, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, @NotNull Density density, @NotNull Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4, boolean z) {
        String str2;
        CharSequence charSequenceProcess;
        float f4;
        Density density2;
        PlatformParagraphStyle paragraphStyle;
        if (z && EmojiCompat.isConfigured()) {
            PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
            EmojiSupportMatch emojiSupportMatchM20308boximpl = (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) ? null : EmojiSupportMatch.m20308boximpl(paragraphStyle.getEmojiSupportMatch());
            str2 = str;
            charSequenceProcess = EmojiCompat.get().process(str2, 0, str.length(), Integer.MAX_VALUE, emojiSupportMatchM20308boximpl == null ? 0 : EmojiSupportMatch.m20311equalsimpl0(emojiSupportMatchM20308boximpl.getValue(), EmojiSupportMatch.INSTANCE.m20315getAll_3YsG6Y()));
            Intrinsics.checkNotNull(charSequenceProcess);
        } else {
            str2 = str;
            charSequenceProcess = str2;
        }
        if (list.isEmpty() && list2.isEmpty() && Intrinsics.areEqual(textStyle.getTextIndent(), TextIndent.INSTANCE.getNone()) && TextUnitKt.m21179isUnspecifiedR2X_6o(textStyle.m20495getLineHeightXSAIIZE())) {
            return charSequenceProcess;
        }
        Spannable spannableString = charSequenceProcess instanceof Spannable ? (Spannable) charSequenceProcess : new SpannableString(charSequenceProcess);
        if (Intrinsics.areEqual(textStyle.getTextDecoration(), TextDecoration.INSTANCE.getUnderline())) {
            SpannableExtensions_androidKt.setSpan(spannableString, NoopSpan, 0, str2.length());
        }
        if (isIncludeFontPaddingEnabled(textStyle) && textStyle.getLineHeightStyle() == null) {
            SpannableExtensions_androidKt.m20735setLineHeightr9BaKPg(spannableString, textStyle.m20495getLineHeightXSAIIZE(), f, density);
            f4 = f;
            density2 = density;
        } else {
            LineHeightStyle lineHeightStyle = textStyle.getLineHeightStyle();
            if (lineHeightStyle == null) {
                lineHeightStyle = LineHeightStyle.INSTANCE.getDefault();
            }
            f4 = f;
            density2 = density;
            SpannableExtensions_androidKt.m20734setLineHeightKmRG4DE(spannableString, textStyle.m20495getLineHeightXSAIIZE(), f4, density2, lineHeightStyle);
        }
        SpannableExtensions_androidKt.setTextIndent(spannableString, textStyle.getTextIndent(), f4, density2);
        SpannableExtensions_androidKt.setSpanStyles(spannableString, textStyle, list, density2, function4);
        PlaceholderExtensions_androidKt.setPlaceholders(spannableString, list2, density2);
        return spannableString;
    }

    public static final boolean isIncludeFontPaddingEnabled(@NotNull TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        if (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) {
            return false;
        }
        return paragraphStyle.getIncludeFontPadding();
    }
}
