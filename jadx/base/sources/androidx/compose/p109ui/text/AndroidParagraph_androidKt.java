package androidx.compose.p109ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.p109ui.text.TextGranularity;
import androidx.compose.p109ui.text.android.TextLayout;
import androidx.compose.p109ui.text.android.style.IndentationFixSpan;
import androidx.compose.p109ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p109ui.text.style.Hyphens;
import androidx.compose.p109ui.text.style.LineBreak;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001a\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\n\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001cH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002\u001a\u0016\u0010 \u001a\u00020\u0006*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (z && !TextUnit.m21158equalsimpl0(textStyle.m20492getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) && !TextUnit.m21158equalsimpl0(textStyle.m20492getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE())) {
            int iM20497getTextAligne0LSkKk = textStyle.m20497getTextAligne0LSkKk();
            TextAlign.Companion companion = TextAlign.INSTANCE;
            if (!TextAlign.m20853equalsimpl0(iM20497getTextAligne0LSkKk, companion.m20863getUnspecifiede0LSkKk()) && !TextAlign.m20853equalsimpl0(textStyle.m20497getTextAligne0LSkKk(), companion.m20862getStarte0LSkKk()) && !TextAlign.m20853equalsimpl0(textStyle.m20497getTextAligne0LSkKk(), companion.m20859getJustifye0LSkKk())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m20301toLayoutAlignaXe7zB0(int i) {
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m20853equalsimpl0(i, companion.m20860getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m20853equalsimpl0(i, companion.m20861getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m20853equalsimpl0(i, companion.m20857getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m20853equalsimpl0(i, companion.m20862getStarte0LSkKk()) && TextAlign.m20853equalsimpl0(i, companion.m20858getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m20302toLayoutBreakStrategyxImikfE(int i) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.INSTANCE;
        if (LineBreak.Strategy.m20794equalsimpl0(i, companion.m20800getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m20794equalsimpl0(i, companion.m20799getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m20794equalsimpl0(i, companion.m20798getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m20303toLayoutHyphenationFrequency3fSNIE(int i) {
        Hyphens.Companion companion = Hyphens.INSTANCE;
        if (Hyphens.m20763equalsimpl0(i, companion.m20767getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m20763equalsimpl0(i, companion.m20768getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m20304toLayoutLineBreakStylehpcqdu8(int i) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.INSTANCE;
        if (LineBreak.Strictness.m20805equalsimpl0(i, companion.m20809getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m20805equalsimpl0(i, companion.m20810getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m20805equalsimpl0(i, companion.m20811getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m20805equalsimpl0(i, companion.m20812getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m20305toLayoutLineBreakWordStylewPN0Rpw(int i) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.INSTANCE;
        return (!LineBreak.WordBreak.m20817equalsimpl0(i, companion.m20821getDefaultjp8hJ3c()) && LineBreak.WordBreak.m20817equalsimpl0(i, companion.m20822getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final int m20306toLayoutTextGranularityduNsdkg(int i) {
        TextGranularity.Companion companion = TextGranularity.INSTANCE;
        return (!TextGranularity.m20416equalsimpl0(i, companion.m20420getCharacterDRrd7Zo()) && TextGranularity.m20416equalsimpl0(i, companion.m20421getWordDRrd7Zo())) ? 1 : 0;
    }
}
