package androidx.compose.foundation.text;

import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/foundation/text/TextRangeLayoutMeasureScope;", "", "()V", DBSchema.DocumentThumbnail.LAYOUT, "Landroidx/compose/foundation/text/TextRangeLayoutMeasureResult;", "width", "", "height", ServerResultMeetingParser.PLACE, "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextRangeLayoutMeasureScope {
    public static final int $stable = 0;

    @NotNull
    public final TextRangeLayoutMeasureResult layout(int width, int height, @NotNull Function0<IntOffset> place) {
        return new TextRangeLayoutMeasureResult(width, height, place);
    }
}
