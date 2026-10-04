package com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph;

import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/AbsParagraphChecker;", "", "selectionPStart", "", "selectionPEnd", "<init>", "(II)V", "getSelectionPStart", "()I", "setSelectionPStart", "(I)V", "getSelectionPEnd", "setSelectionPEnd", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "checkParagraph", "paragraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "getResult", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsParagraphChecker {
    public static final int ALIGN_NONE = -1;
    public static final int FORMAT_NONE = -1;
    public static final int INDENT_DISABLE = -1;
    public static final int RETURN_TYPE_CONTINUE = 1;
    public static final int RETURN_TYPE_NONE = 0;
    public static final int TASK_NONE = 0;
    private boolean enable = true;
    private int selectionPEnd;
    private int selectionPStart;

    public AbsParagraphChecker(int i, int i2) {
        this.selectionPStart = i;
        this.selectionPEnd = i2;
    }

    public abstract int checkParagraph(@NotNull SpenTextParagraphBase paragraph);

    public final boolean getEnable() {
        return this.enable;
    }

    public abstract int getResult();

    public final int getSelectionPEnd() {
        return this.selectionPEnd;
    }

    public final int getSelectionPStart() {
        return this.selectionPStart;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final void setSelectionPEnd(int i) {
        this.selectionPEnd = i;
    }

    public final void setSelectionPStart(int i) {
        this.selectionPStart = i;
    }
}
