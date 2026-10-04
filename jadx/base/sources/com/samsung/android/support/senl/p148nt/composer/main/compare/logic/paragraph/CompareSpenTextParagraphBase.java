package com.samsung.android.support.senl.p148nt.composer.main.compare.logic.paragraph;

import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/paragraph/CompareSpenTextParagraphBase;", "", "<init>", "()V", "isNotSame", "", "o1", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "o2", "isNotSameParagraph", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class CompareSpenTextParagraphBase {
    public final boolean isNotSame(@Nullable SpenTextParagraphBase o12, @Nullable SpenTextParagraphBase o22) {
        if (o12 == null && o22 == null) {
            return false;
        }
        if (o12 == null || o22 == null || o12.getType() != o22.getType()) {
            return true;
        }
        int type = o12.getType();
        return (type != 2 ? type != 3 ? type != 5 ? new CompareSpenTextParagraphBase() : new CompareSpenBulletParagraph() : new CompareSpenAlignmentParagraph() : new CompareSpenIndentLevelParagraph()).isNotSameParagraph(o12, o22);
    }

    public boolean isNotSameParagraph(@Nullable SpenTextParagraphBase o12, @Nullable SpenTextParagraphBase o22) {
        return false;
    }
}
