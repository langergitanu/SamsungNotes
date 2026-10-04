package com.samsung.android.sdk.pen.document.textspan;

import com.samsung.android.sdk.pen.SpenError;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tR$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenTimeStampSpan;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "<init>", "()V", "startPosition", "", "endPosition", "timeStamp", "", "(IIJ)V", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTimeStampSpan extends SpenTextSpanBase {
    private long timeStamp;

    public SpenTimeStampSpan() {
        super(19, 0, 0, 2);
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final void setTimeStamp(long j) {
        if (j < 0) {
            SpenError.ThrowUncheckedException(3);
        }
        this.timeStamp = j;
    }

    public SpenTimeStampSpan(int i, int i2, long j) {
        super(19, i, i2, 2);
        if (j < 0) {
            SpenError.ThrowUncheckedException(3);
        }
        setTimeStamp(j);
    }
}
