package androidx.compose.p109ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(29)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/ui/text/android/Paint29;", "", "()V", "getTextBounds", "", "paint", "Landroid/graphics/Paint;", "text", "", "start", "", "end", "rect", "Landroid/graphics/Rect;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class Paint29 {

    @NotNull
    public static final Paint29 INSTANCE = new Paint29();

    private Paint29() {
    }

    @JvmStatic
    @DoNotInline
    public static final void getTextBounds(@NotNull Paint paint, @NotNull CharSequence text, int start, int end, @NotNull Rect rect) {
        paint.getTextBounds(text, start, end, rect);
    }
}
