package com.samsung.android.sdk.pen.document.textspan;

import com.samsung.android.sdk.pen.SpenError;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\bR$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenAlignmentParagraph;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "<init>", "()V", "startPosition", "", "endPosition", "align", "(III)V", "alignment", "getAlignment", "()I", "setAlignment", "(I)V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenAlignmentParagraph extends SpenTextParagraphBase {
    public static final int ALIGN_BOTH = 3;
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 1;
    private int alignment;

    public SpenAlignmentParagraph() {
        super(3);
    }

    public final int getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(int i) {
        if (i < 0 || i > 3) {
            SpenError.ThrowUncheckedException(7);
        }
        this.alignment = i;
    }

    public SpenAlignmentParagraph(int i, int i2, int i4) {
        super(3, i, i2);
        if (i2 < i) {
            SpenError.ThrowUncheckedException(3);
        }
        if (i4 < 0 || i4 > 3) {
            SpenError.ThrowUncheckedException(7);
        }
        setAlignment(i4);
    }
}
