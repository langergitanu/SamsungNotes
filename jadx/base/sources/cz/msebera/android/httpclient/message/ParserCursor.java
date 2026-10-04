package cz.msebera.android.httpclient.message;

import androidx.appcompat.widget.AbstractC0541b;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        this.lowerBound = i;
        this.upperBound = i2;
        this.pos = i;
    }

    public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getPos() {
        return this.pos;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        return "[" + Integer.toString(this.lowerBound) + '>' + Integer.toString(this.pos) + '>' + Integer.toString(this.upperBound) + PropertyUtils.INDEXED_DELIM2;
    }

    public void updatePos(int i) {
        if (i < this.lowerBound) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "pos: ", " < lowerBound: ");
            sbM778t.append(this.lowerBound);
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        if (i <= this.upperBound) {
            this.pos = i;
        } else {
            StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "pos: ", " > upperBound: ");
            sbM778t2.append(this.upperBound);
            throw new IndexOutOfBoundsException(sbM778t2.toString());
        }
    }
}
