package androidx.compose.p109ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import android.text.SegmentFinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.text.input.internal.AbstractC1347e;
import androidx.compose.p109ui.text.android.selection.Api34SegmentFinder;
import androidx.compose.p109ui.text.android.selection.WordSegmentFinder;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@RequiresApi(34)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0001¢\u0006\u0002\b\u000e¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/ui/text/android/AndroidLayoutApi34;", "", "()V", "getRangeForRect", "", DBSchema.DocumentThumbnail.LAYOUT, "Landroidx/compose/ui/text/android/TextLayout;", "rectF", "Landroid/graphics/RectF;", "granularity", "", "inclusionStrategy", "Lkotlin/Function2;", "", "getRangeForRect$ui_text_release", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidLayoutApi34 {
    public static final int $stable = 0;

    @NotNull
    public static final AndroidLayoutApi34 INSTANCE = new AndroidLayoutApi34();

    private AndroidLayoutApi34() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRangeForRect$lambda$0(Function2 function2, RectF rectF, RectF rectF2) {
        return ((Boolean) function2.invoke(rectF, rectF2)).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.text.android.a] */
    @DoNotInline
    @Nullable
    public final int[] getRangeForRect$ui_text_release(@NotNull TextLayout layout, @NotNull RectF rectF, int granularity, @NotNull final Function2<? super RectF, ? super RectF, Boolean> inclusionStrategy) {
        SegmentFinder segmentFinderM1284p;
        if (granularity == 1) {
            segmentFinderM1284p = Api34SegmentFinder.INSTANCE.toAndroidSegmentFinder$ui_text_release(new WordSegmentFinder(layout.getText(), layout.getWordIterator()));
        } else {
            AbstractC1347e.m1289u();
            segmentFinderM1284p = AbstractC1347e.m1284p(AbstractC1347e.m1283o(layout.getText(), layout.getTextPaint()));
        }
        return layout.getLayout().getRangeForRect(rectF, segmentFinderM1284p, new Layout.TextInclusionStrategy() { // from class: androidx.compose.ui.text.android.a
            @Override // android.text.Layout.TextInclusionStrategy
            public final boolean isSegmentInside(RectF rectF2, RectF rectF3) {
                return AndroidLayoutApi34.getRangeForRect$lambda$0(inclusionStrategy, rectF2, rectF3);
            }
        });
    }
}
