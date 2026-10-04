package com.samsung.android.support.senl.p148nt.composer.main.compare.logic.spantext;

import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/spantext/CompareSpanBase;", "", "<init>", "()V", "isNotSame", "", "o1", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "o2", "isNotSameSpan", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class CompareSpanBase {
    public final boolean isNotSame(@NotNull SpenTextSpanBase o12, @NotNull SpenTextSpanBase o22) {
        CompareSpanBase compareSpenForegroundColorSpan;
        Intrinsics.checkNotNullParameter(o12, "o1");
        Intrinsics.checkNotNullParameter(o22, "o2");
        if (o12.getType() != o22.getType()) {
            return true;
        }
        int type = o12.getType();
        if (type == 1) {
            compareSpenForegroundColorSpan = new CompareSpenForegroundColorSpan();
        } else if (type == 9) {
            compareSpenForegroundColorSpan = new CompareSpenHyperTextSpan();
        } else if (type == 3) {
            compareSpenForegroundColorSpan = new CompareSpenFontSizeSpan();
        } else if (type == 4) {
            compareSpenForegroundColorSpan = new CompareSpenFontNameSpan();
        } else if (type == 5) {
            compareSpenForegroundColorSpan = new CompareSpenBoldSpan();
        } else if (type == 6) {
            compareSpenForegroundColorSpan = new CompareSpenItalicSpan();
        } else if (type != 7) {
            switch (type) {
                case 15:
                    compareSpenForegroundColorSpan = new CompareSpenComposingBackgroundColorSpan();
                    break;
                case 16:
                    compareSpenForegroundColorSpan = new CompareSpenComposingSpan();
                    break;
                case 17:
                    compareSpenForegroundColorSpan = new CompareSpenBackgroundColorSpan();
                    break;
                case 18:
                    compareSpenForegroundColorSpan = new CompareSpenComposingTagSpan();
                    break;
                case 19:
                    compareSpenForegroundColorSpan = new CompareSpenTimeStampSpan();
                    break;
                case 20:
                    compareSpenForegroundColorSpan = new CompareSpenStrikeThroughSpan();
                    break;
                case 21:
                    compareSpenForegroundColorSpan = new CompareSpenSuggestionSpan();
                    break;
                case 22:
                    compareSpenForegroundColorSpan = new CompareSpenSpellCorrectionSpan();
                    break;
                default:
                    compareSpenForegroundColorSpan = new CompareSpanBase();
                    break;
            }
        } else {
            compareSpenForegroundColorSpan = new CompareSpenUnderlineSpan();
        }
        return compareSpenForegroundColorSpan.isNotSameSpan(o12, o22);
    }

    public boolean isNotSameSpan(@Nullable SpenTextSpanBase o12, @Nullable SpenTextSpanBase o22) {
        return false;
    }
}
