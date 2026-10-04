package androidx.compose.p109ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JØ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0003\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0003\u0010\u0016\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory;", "", "()V", "delegate", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "create", "Landroid/text/StaticLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "start", "end", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "isFallbackLineSpacingEnabled", DBSchema.DocumentThumbnail.LAYOUT, "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class StaticLayoutFactory {

    @NotNull
    public static final StaticLayoutFactory INSTANCE = new StaticLayoutFactory();

    @NotNull
    private static final StaticLayoutFactoryImpl delegate = new StaticLayoutFactory23();
    public static final int $stable = 8;

    private StaticLayoutFactory() {
    }

    public static /* synthetic */ StaticLayout create$default(StaticLayoutFactory staticLayoutFactory, CharSequence charSequence, TextPaint textPaint, int i, int i2, int i4, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i5, TextUtils.TruncateAt truncateAt, int i6, float f, float f4, int i7, boolean z, boolean z2, int i8, int i9, int i10, int i11, int[] iArr, int[] iArr2, int i12, Object obj) {
        int[] iArr3;
        StaticLayoutFactory staticLayoutFactory2;
        CharSequence charSequence2;
        TextPaint textPaint2;
        int i13;
        int i14 = (i12 & 8) != 0 ? 0 : i2;
        int length = (i12 & 16) != 0 ? charSequence.length() : i4;
        TextDirectionHeuristic dEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text_release = (i12 & 32) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text_release() : textDirectionHeuristic;
        Layout.Alignment dEFAULT_LAYOUT_ALIGNMENT$ui_text_release = (i12 & 64) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_LAYOUT_ALIGNMENT$ui_text_release() : alignment;
        int i15 = (i12 & 128) != 0 ? Integer.MAX_VALUE : i5;
        TextUtils.TruncateAt truncateAt2 = (i12 & 256) != 0 ? null : truncateAt;
        int i16 = (i12 & 512) != 0 ? i : i6;
        float f5 = (i12 & 1024) != 0 ? 1.0f : f;
        float f6 = (i12 & 2048) != 0 ? 0.0f : f4;
        int i17 = (i12 & 4096) != 0 ? 0 : i7;
        boolean z3 = (i12 & 8192) != 0 ? false : z;
        boolean z4 = (i12 & 16384) != 0 ? true : z2;
        int i18 = (32768 & i12) != 0 ? 0 : i8;
        int i19 = (65536 & i12) != 0 ? 0 : i9;
        int i20 = (131072 & i12) != 0 ? 0 : i10;
        int i21 = (262144 & i12) != 0 ? 0 : i11;
        int[] iArr4 = (524288 & i12) != 0 ? null : iArr;
        if ((i12 & 1048576) != 0) {
            iArr3 = null;
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            i13 = i;
            staticLayoutFactory2 = staticLayoutFactory;
        } else {
            iArr3 = iArr2;
            staticLayoutFactory2 = staticLayoutFactory;
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            i13 = i;
        }
        return staticLayoutFactory2.create(charSequence2, textPaint2, i13, i14, length, dEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text_release, dEFAULT_LAYOUT_ALIGNMENT$ui_text_release, i15, truncateAt2, i16, f5, f6, i17, z3, z4, i18, i19, i20, i21, iArr4, iArr3);
    }

    @NotNull
    public final StaticLayout create(@NotNull CharSequence text, @NotNull TextPaint paint, int width, int start, int end, @NotNull TextDirectionHeuristic textDir, @NotNull Layout.Alignment alignment, @IntRange(from = 0) int maxLines, @Nullable TextUtils.TruncateAt ellipsize, @IntRange(from = 0) int ellipsizedWidth, @FloatRange(from = 0.0d) float lineSpacingMultiplier, float lineSpacingExtra, int justificationMode, boolean includePadding, boolean useFallbackLineSpacing, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle, int hyphenationFrequency, @Nullable int[] leftIndents, @Nullable int[] rightIndents) {
        return delegate.create(new StaticLayoutParams(text, start, end, paint, width, textDir, alignment, maxLines, ellipsize, ellipsizedWidth, lineSpacingMultiplier, lineSpacingExtra, justificationMode, includePadding, useFallbackLineSpacing, breakStrategy, lineBreakStyle, lineBreakWordStyle, hyphenationFrequency, leftIndents, rightIndents));
    }

    public final boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout layout, boolean useFallbackLineSpacing) {
        return delegate.isFallbackLineSpacingEnabled(layout, useFallbackLineSpacing);
    }
}
