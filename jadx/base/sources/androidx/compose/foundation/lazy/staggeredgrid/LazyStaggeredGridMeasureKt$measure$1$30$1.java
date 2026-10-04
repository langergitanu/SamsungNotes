package androidx.compose.foundation.lazy.staggeredgrid;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LazyStaggeredGridMeasureKt$measure$1$30$1 extends Lambda implements Function1<LazyStaggeredGridMeasuredItem, CharSequence> {
    public static final LazyStaggeredGridMeasureKt$measure$1$30$1 INSTANCE = new LazyStaggeredGridMeasureKt$measure$1$30$1();

    public LazyStaggeredGridMeasureKt$measure$1$30$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final CharSequence invoke(@NotNull LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem) {
        return String.valueOf(lazyStaggeredGridMeasuredItem.getIndex());
    }
}
