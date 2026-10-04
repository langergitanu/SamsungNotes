package androidx.compose.p109ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.Placeholder;
import androidx.compose.p109ui.text.PlaceholderVerticalAlign;
import androidx.compose.p109ui.text.android.style.PlaceholderSpan;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a(\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\b8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, m13886d2 = {"spanUnit", "", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "setPlaceholder", "", "Landroid/text/Spannable;", "placeholder", "Landroidx/compose/ui/text/Placeholder;", "start", "end", "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholders", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPlaceholderExtensions.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaceholderExtensions.android.kt\nandroidx/compose/ui/text/platform/extensions/PlaceholderExtensions_androidKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,93:1\n33#2,6:94\n13579#3,2:100\n*S KotlinDebug\n*F\n+ 1 PlaceholderExtensions.android.kt\nandroidx/compose/ui/text/platform/extensions/PlaceholderExtensions_androidKt\n*L\n35#1:94,6\n48#1:100,2\n*E\n"})
public final class PlaceholderExtensions_androidKt {
    /* JADX INFO: renamed from: getSpanUnit--R2X_6o, reason: not valid java name */
    private static final int m20724getSpanUnitR2X_6o(long j) {
        long jM21160getTypeUIouoOA = TextUnit.m21160getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m21189equalsimpl0(jM21160getTypeUIouoOA, companion.m21194getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m21189equalsimpl0(jM21160getTypeUIouoOA, companion.m21193getEmUIouoOA()) ? 1 : 2;
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg, reason: not valid java name */
    private static final int m20726getSpanVerticalAligndo9XGg(int i) {
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.INSTANCE;
        if (PlaceholderVerticalAlign.m20374equalsimpl0(i, companion.m20378getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m20374equalsimpl0(i, companion.m20384getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m20374equalsimpl0(i, companion.m20379getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m20374equalsimpl0(i, companion.m20380getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m20374equalsimpl0(i, companion.m20383getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m20374equalsimpl0(i, companion.m20381getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m20374equalsimpl0(i, companion.m20382getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign");
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        for (Object obj : spannable.getSpans(i, i2, EmojiSpan.class)) {
            spannable.removeSpan((EmojiSpan) obj);
        }
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m21161getValueimpl(placeholder.getWidth()), m20724getSpanUnitR2X_6o(placeholder.getWidth()), TextUnit.m21161getValueimpl(placeholder.getHeight()), m20724getSpanUnitR2X_6o(placeholder.getHeight()), density.getDensity() * density.getFontScale(), m20726getSpanVerticalAligndo9XGg(placeholder.getPlaceholderVerticalAlign())), i, i2);
    }

    public static final void setPlaceholders(@NotNull Spannable spannable, @NotNull List<AnnotatedString.Range<Placeholder>> list, @NotNull Density density) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<Placeholder> range = list.get(i);
            setPlaceholder(spannable, range.component1(), range.getStart(), range.getEnd(), density);
        }
    }

    /* JADX INFO: renamed from: getSpanUnit--R2X_6o$annotations, reason: not valid java name */
    private static /* synthetic */ void m20725getSpanUnitR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg$annotations, reason: not valid java name */
    private static /* synthetic */ void m20727getSpanVerticalAligndo9XGg$annotations(int i) {
    }
}
