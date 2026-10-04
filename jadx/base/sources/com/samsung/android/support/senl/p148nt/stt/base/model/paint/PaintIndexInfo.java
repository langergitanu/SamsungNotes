package com.samsung.android.support.senl.p148nt.stt.base.model.paint;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007R$\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintIndexInfo;", "", "<init>", "()V", "start", "", "end", "(II)V", "value", TextConst.KEY_START_INDEX, "getStartIndex", "()I", "setStartIndex", "(I)V", TextConst.KEY_END_INDEX, "getEndIndex", "setEndIndex", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PaintIndexInfo {
    public static final int UNSET = -1;
    private int endIndex;
    private int startIndex;

    public PaintIndexInfo() {
        this.startIndex = -1;
        this.endIndex = -1;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final void setEndIndex(int i) {
        this.endIndex = i;
    }

    public final void setStartIndex(int i) {
        this.startIndex = i;
    }

    public PaintIndexInfo(int i, int i2) {
        this.startIndex = i;
        this.endIndex = i2;
    }
}
