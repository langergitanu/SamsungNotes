package com.samsung.android.support.senl.p148nt.composer.main.compare.logic.spantext;

import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/spantext/CompareSpenFontSizeSpan;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/spantext/CompareSpanBase;", "<init>", "()V", "isNotSameSpan", "", "o1", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "o2", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CompareSpenFontSizeSpan extends CompareSpanBase {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.compare.logic.spantext.CompareSpanBase
    public boolean isNotSameSpan(@Nullable SpenTextSpanBase o12, @Nullable SpenTextSpanBase o22) {
        Intrinsics.checkNotNull(o12, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan");
        float size = ((SpenFontSizeSpan) o12).getSize();
        Intrinsics.checkNotNull(o22, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan");
        return !(size == ((SpenFontSizeSpan) o22).getSize());
    }
}
