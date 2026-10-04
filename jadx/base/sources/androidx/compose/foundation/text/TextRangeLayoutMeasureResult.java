package androidx.compose.foundation.text;

import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/foundation/text/TextRangeLayoutMeasureResult;", "", "width", "", "height", ServerResultMeetingParser.PLACE, "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "(IILkotlin/jvm/functions/Function0;)V", "getHeight", "()I", "getPlace", "()Lkotlin/jvm/functions/Function0;", "getWidth", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextRangeLayoutMeasureResult {
    public static final int $stable = 0;
    private final int height;

    @NotNull
    private final Function0<IntOffset> place;
    private final int width;

    public TextRangeLayoutMeasureResult(int i, int i2, @NotNull Function0<IntOffset> function0) {
        this.width = i;
        this.height = i2;
        this.place = function0;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final Function0<IntOffset> getPlace() {
        return this.place;
    }

    public final int getWidth() {
        return this.width;
    }
}
