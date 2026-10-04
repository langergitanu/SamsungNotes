package com.samsung.android.support.senl.p148nt.base.composer.action;

import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/action/PasteHelper;", "", "<init>", "()V", "rearrangeText", "Landroid/text/SpannableStringBuilder;", "ssb", "start", "", "end", "removeImageSpan", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PasteHelper {

    @NotNull
    public static final PasteHelper INSTANCE = new PasteHelper();

    private PasteHelper() {
    }

    @NotNull
    public final SpannableStringBuilder rearrangeText(@NotNull SpannableStringBuilder ssb, int start, int end) {
        Intrinsics.checkNotNullParameter(ssb, "ssb");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        while (start < end) {
            String string = ssb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            int iM14129C = StringsKt.m14129C("\n", start, 4, string);
            if (iM14129C < 0 || iM14129C > end) {
                iM14129C = end - 1;
            }
            int i = iM14129C + 1;
            spannableStringBuilder.append(ssb.subSequence(start, i));
            start = i;
        }
        return spannableStringBuilder;
    }

    public final boolean removeImageSpan(@NotNull SpannableStringBuilder ssb) {
        Intrinsics.checkNotNullParameter(ssb, "ssb");
        ImageSpan[] imageSpanArr = (ImageSpan[]) ssb.getSpans(0, ssb.length(), ImageSpan.class);
        Iterator it = ArrayIteratorKt.iterator(imageSpanArr);
        while (it.hasNext()) {
            ImageSpan imageSpan = (ImageSpan) it.next();
            int spanStart = ssb.getSpanStart(imageSpan);
            int spanEnd = ssb.getSpanEnd(imageSpan);
            ssb.removeSpan(imageSpan);
            ssb.replace(spanStart, spanEnd, "");
        }
        return imageSpanArr == null || imageSpanArr.length == 0;
    }
}
