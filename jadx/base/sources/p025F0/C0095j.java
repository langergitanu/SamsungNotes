package p025F0;

import android.text.SpannableStringBuilder;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import java.util.List;

/* JADX INFO: renamed from: F0.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0095j implements ConvertSpenTextToSpannable.IObjectSpanConverter {
    @Override // com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.IObjectSpanConverter
    public final void convert(List list, SpannableStringBuilder spannableStringBuilder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int textIndex = ((SpenObjectSpan) list.get(size)).getTextIndex();
            int i = textIndex + 1;
            if (i <= spannableStringBuilder.length()) {
                spannableStringBuilder.replace(textIndex, i, "");
            }
        }
    }
}
