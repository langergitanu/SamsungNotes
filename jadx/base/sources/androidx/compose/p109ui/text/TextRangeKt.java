package androidx.compose.p109ui.text;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0004\u001a\u0013\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a$\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m13886d2 = {"TextRange", "Landroidx/compose/ui/text/TextRange;", "index", "", "(I)J", "start", "end", "(II)J", "packWithCheck", "", "coerceIn", "minimumValue", "maximumValue", "coerceIn-8ffj60Q", "(JII)J", "substring", "", "", Bixby2Constants.BIXBY_PARAM_RANGE, "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextRange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextRange.kt\nandroidx/compose/ui/text/TextRangeKt\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,129:1\n100#2:130\n*S KotlinDebug\n*F\n+ 1 TextRange.kt\nandroidx/compose/ui/text/TextRangeKt\n*L\n127#1:130\n*E\n"})
public final class TextRangeKt {
    public static final long TextRange(int i, int i2) {
        return TextRange.m20445constructorimpl(packWithCheck(i, i2));
    }

    /* JADX INFO: renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m20462coerceIn8ffj60Q(long j, int i, int i2) {
        int iCoerceIn = RangesKt.coerceIn(TextRange.m20456getStartimpl(j), i, i2);
        int iCoerceIn2 = RangesKt.coerceIn(TextRange.m20451getEndimpl(j), i, i2);
        return (iCoerceIn == TextRange.m20456getStartimpl(j) && iCoerceIn2 == TextRange.m20451getEndimpl(j)) ? j : TextRange(iCoerceIn, iCoerceIn2);
    }

    private static final long packWithCheck(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1168n("start cannot be negative. [start: ", i, ", end: ", i2, PropertyUtils.INDEXED_DELIM2).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1168n("end cannot be negative. [start: ", i, ", end: ", i2, PropertyUtils.INDEXED_DELIM2).toString());
        }
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    @NotNull
    /* JADX INFO: renamed from: substring-FDrldGo, reason: not valid java name */
    public static final String m20463substringFDrldGo(@NotNull CharSequence charSequence, long j) {
        return charSequence.subSequence(TextRange.m20454getMinimpl(j), TextRange.m20453getMaximpl(j)).toString();
    }

    public static final long TextRange(int i) {
        return TextRange(i, i);
    }
}
