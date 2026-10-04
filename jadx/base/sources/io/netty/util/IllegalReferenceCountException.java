package io.netty.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class IllegalReferenceCountException extends IllegalStateException {
    private static final long serialVersionUID = -2507492394288153468L;

    public IllegalReferenceCountException() {
    }

    public IllegalReferenceCountException(int i) {
        this(AbstractC0000a.m11h(i, "refCnt: "));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IllegalReferenceCountException(int i, int i2) {
        String strM11h;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "refCnt: ", SQLKeyword.COMMA);
        if (i2 > 0) {
            strM11h = AbstractC0000a.m11h(i2, "increment: ");
        } else {
            strM11h = "decrement: " + (-i2);
        }
        sbM778t.append(strM11h);
        this(sbM778t.toString());
    }

    public IllegalReferenceCountException(String str) {
        super(str);
    }

    public IllegalReferenceCountException(String str, Throwable th) {
        super(str, th);
    }

    public IllegalReferenceCountException(Throwable th) {
        super(th);
    }
}
