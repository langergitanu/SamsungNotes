package com.samsung.android.support.senl.p148nt.word.common;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/common/OfficeCropHeight;", "", "previous", "", "current", "<init>", "(II)V", "getPrevious", "()I", "setPrevious", "(I)V", "getCurrent", "setCurrent", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OfficeCropHeight {
    private int current;
    private int previous;

    public OfficeCropHeight(int i, int i2) {
        this.previous = i;
        this.current = i2;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final int getPrevious() {
        return this.previous;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setPrevious(int i) {
        this.previous = i;
    }
}
