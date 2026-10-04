package androidx.compose.p109ui.text.android.selection;

import android.text.TextPaint;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@RequiresApi(29)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinderApi29;", "Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "text", "", "textPaint", "Landroid/text/TextPaint;", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;)V", "next", "", TypedValues.Cycle.S_WAVE_OFFSET, "previous", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class GraphemeClusterSegmentFinderApi29 extends GraphemeClusterSegmentFinder {
    public static final int $stable = 8;

    @NotNull
    private final CharSequence text;

    @NotNull
    private final TextPaint textPaint;

    public GraphemeClusterSegmentFinderApi29(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint) {
        this.text = charSequence;
        this.textPaint = textPaint;
    }

    @Override // androidx.compose.p109ui.text.android.selection.GraphemeClusterSegmentFinder
    public int next(int offset) {
        TextPaint textPaint = this.textPaint;
        CharSequence charSequence = this.text;
        return textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, offset, 0);
    }

    @Override // androidx.compose.p109ui.text.android.selection.GraphemeClusterSegmentFinder
    public int previous(int offset) {
        TextPaint textPaint = this.textPaint;
        CharSequence charSequence = this.text;
        return textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, offset, 2);
    }
}
