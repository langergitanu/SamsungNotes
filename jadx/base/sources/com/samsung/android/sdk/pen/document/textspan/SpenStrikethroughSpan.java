package com.samsung.android.sdk.pen.document.textspan;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\nR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenStrikethroughSpan;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "<init>", "()V", "startPosition", "", "endPosition", "expansionType", "isStrikethrough", "", "(IIIZ)V", "isStrikethroughStyleEnabled", "()Z", "setStrikethroughStyleEnabled", "(Z)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenStrikethroughSpan extends SpenTextSpanBase {
    private boolean isStrikethroughStyleEnabled;

    public SpenStrikethroughSpan() {
        super(20);
        this.isStrikethroughStyleEnabled = true;
    }

    /* JADX INFO: renamed from: isStrikethroughStyleEnabled, reason: from getter */
    public final boolean getIsStrikethroughStyleEnabled() {
        return this.isStrikethroughStyleEnabled;
    }

    public final void setStrikethroughStyleEnabled(boolean z) {
        this.isStrikethroughStyleEnabled = z;
    }

    public SpenStrikethroughSpan(int i, int i2, int i4, boolean z) {
        super(20, i, i2, i4);
        this.isStrikethroughStyleEnabled = z;
    }
}
