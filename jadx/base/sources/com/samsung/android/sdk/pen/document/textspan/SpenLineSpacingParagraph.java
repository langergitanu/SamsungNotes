package com.samsung.android.sdk.pen.document.textspan;

import com.samsung.android.sdk.pen.SpenError;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenLineSpacingParagraph;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "<init>", "()V", "startPosition", "", "endPosition", "type", "spacing", "", "(IIIF)V", "lineSpacingType", "getLineSpacingType", "()I", "setLineSpacingType", "(I)V", "lineSpacing", "getLineSpacing", "()F", "setLineSpacing", "(F)V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenLineSpacingParagraph extends SpenTextParagraphBase {
    public static final int TYPE_PERCENT = 1;
    public static final int TYPE_PIXEL = 0;
    private float lineSpacing;
    private int lineSpacingType;

    public SpenLineSpacingParagraph() {
        super(4);
    }

    public final float getLineSpacing() {
        return this.lineSpacing;
    }

    public final int getLineSpacingType() {
        return this.lineSpacingType;
    }

    public final void setLineSpacing(float f) {
        if (f < 0.0f && this.lineSpacingType == 0) {
            SpenError.ThrowUncheckedException(3);
        }
        if (f <= 0.0f && this.lineSpacingType == 1) {
            SpenError.ThrowUncheckedException(3);
        }
        this.lineSpacing = f;
    }

    public final void setLineSpacingType(int i) {
        if (i < 0 || i > 1) {
            SpenError.ThrowUncheckedException(7);
        }
        this.lineSpacingType = i;
        if (i == 1 && this.lineSpacing == 0.0f) {
            setLineSpacing(1.0f);
        }
    }

    public SpenLineSpacingParagraph(int i, int i2, int i4, float f) {
        super(4, i, i2);
        if (i2 < i) {
            SpenError.ThrowUncheckedException(3);
        }
        if (i4 != 0) {
            if (i4 != 1) {
                SpenError.ThrowUncheckedException(7);
            } else if (f <= 0.0f) {
                SpenError.ThrowUncheckedException(3);
            }
        } else if (f < 0.0f) {
            SpenError.ThrowUncheckedException(3);
        }
        setLineSpacingType(i4);
        setLineSpacing(f);
    }
}
