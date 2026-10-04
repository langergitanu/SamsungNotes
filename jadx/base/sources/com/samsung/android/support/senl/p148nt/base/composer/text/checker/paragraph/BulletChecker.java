package com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph;

import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/BulletChecker;", "Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/AbsParagraphChecker;", "selectionPStart", "", "selectionPEnd", "<init>", "(II)V", "before", "Lcom/samsung/android/sdk/pen/document/textspan/SpenBulletParagraph;", "getBefore", "()Lcom/samsung/android/sdk/pen/document/textspan/SpenBulletParagraph;", "setBefore", "(Lcom/samsung/android/sdk/pen/document/textspan/SpenBulletParagraph;)V", "checkParagraph", "paragraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "getResult", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BulletChecker extends AbsParagraphChecker {

    @Nullable
    private SpenBulletParagraph before;

    public BulletChecker(int i, int i2) {
        super(i, i2);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph.AbsParagraphChecker
    public int checkParagraph(@NotNull SpenTextParagraphBase paragraph) {
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        if (!getEnable()) {
            return 1;
        }
        if (paragraph.getStart() == getSelectionPStart()) {
            this.before = (SpenBulletParagraph) paragraph;
            return 1;
        }
        SpenBulletParagraph spenBulletParagraph = (SpenBulletParagraph) paragraph;
        SpenBulletParagraph spenBulletParagraph2 = this.before;
        if (spenBulletParagraph2 != null) {
            Intrinsics.checkNotNull(spenBulletParagraph2);
            if (spenBulletParagraph2.getBulletType() == spenBulletParagraph.getBulletType()) {
                this.before = spenBulletParagraph;
                return 1;
            }
        }
        setEnable(false);
        return 0;
    }

    @Nullable
    public final SpenBulletParagraph getBefore() {
        return this.before;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph.AbsParagraphChecker
    public int getResult() {
        SpenBulletParagraph spenBulletParagraph;
        if (!getEnable() || (spenBulletParagraph = this.before) == null) {
            return 0;
        }
        Intrinsics.checkNotNull(spenBulletParagraph);
        if (spenBulletParagraph.getEnd() != getSelectionPEnd()) {
            return 0;
        }
        SpenBulletParagraph spenBulletParagraph2 = this.before;
        Intrinsics.checkNotNull(spenBulletParagraph2);
        return spenBulletParagraph2.getBulletType();
    }

    public final void setBefore(@Nullable SpenBulletParagraph spenBulletParagraph) {
        this.before = spenBulletParagraph;
    }
}
