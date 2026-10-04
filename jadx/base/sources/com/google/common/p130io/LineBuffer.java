package com.google.common.p130io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    @CanIgnoreReturnValue
    private boolean finishLine(boolean z) {
        handleLine(this.line.toString(), this.sawReturn ? z ? "\r\n" : StringUtils.f9761CR : z ? "\n" : "");
        this.line = new StringBuilder();
        this.sawReturn = false;
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void add(char[] cArr, int i, int i2) {
        int i4;
        if (!this.sawReturn || i2 <= 0) {
            i4 = i;
        } else {
            if (finishLine(cArr[i] == '\n')) {
                i4 = i + 1;
            }
        }
        int i5 = i + i2;
        int i6 = i4;
        while (i4 < i5) {
            char c = cArr[i4];
            if (c == '\n') {
                this.line.append(cArr, i6, i4 - i6);
                finishLine(true);
            } else if (c != '\r') {
                i4++;
            } else {
                this.line.append(cArr, i6, i4 - i6);
                this.sawReturn = true;
                int i7 = i4 + 1;
                if (i7 < i5) {
                    if (finishLine(cArr[i7] == '\n')) {
                        i4 = i7;
                    }
                }
            }
            i6 = i4 + 1;
            i4++;
        }
        this.line.append(cArr, i6, i5 - i6);
    }

    public void finish() {
        if (this.sawReturn || this.line.length() > 0) {
            finishLine(false);
        }
    }

    public abstract void handleLine(String str, String str2);
}
