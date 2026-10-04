package opennlp.tools.util;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import java.io.Serializable;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Span implements Comparable<Span>, Serializable {
    private static final long serialVersionUID = -7648780019844573507L;
    private final int end;
    private final double prob;
    private final int start;
    private final String type;

    public Span(int i, int i2, String str) {
        this(i, i2, str, 0.0d);
    }

    public static String[] spansToStrings(Span[] spanArr, CharSequence charSequence) {
        String[] strArr = new String[spanArr.length];
        int length = spanArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = spanArr[i].getCoveredText(charSequence).toString();
        }
        return strArr;
    }

    public boolean contains(Span span) {
        return this.start <= span.getStart() && span.getEnd() <= this.end;
    }

    public boolean crosses(Span span) {
        int start = span.getStart();
        if (contains(span) || span.contains(this)) {
            return false;
        }
        if (getStart() > start || start >= getEnd()) {
            return start <= getStart() && getStart() < span.getEnd();
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Span) {
            Span span = (Span) obj;
            if (getStart() == span.getStart() && getEnd() == span.getEnd() && Objects.equals(getType(), span.getType())) {
                return true;
            }
        }
        return false;
    }

    public CharSequence getCoveredText(CharSequence charSequence) {
        if (getEnd() <= charSequence.length()) {
            return charSequence.subSequence(getStart(), getEnd());
        }
        throw new IllegalArgumentException("The span " + this + " is outside the given text which has length " + charSequence.length() + "!");
    }

    public int getEnd() {
        return this.end;
    }

    public double getProb() {
        return this.prob;
    }

    public int getStart() {
        return this.start;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(getStart()), Integer.valueOf(getEnd()), getType());
    }

    public boolean intersects(Span span) {
        int start = span.getStart();
        if (contains(span) || span.contains(this)) {
            return true;
        }
        if (getStart() > start || start >= getEnd()) {
            return start <= getStart() && getStart() < span.getEnd();
        }
        return true;
    }

    public int length() {
        return this.end - this.start;
    }

    public boolean startsWith(Span span) {
        return getStart() == span.getStart() && contains(span);
    }

    public String toString() {
        StringBuilder sbM1627q = AbstractC2322a.m1627q(15, "[");
        sbM1627q.append(getStart());
        sbM1627q.append("..");
        sbM1627q.append(getEnd());
        sbM1627q.append(")");
        if (getType() != null) {
            sbM1627q.append(" ");
            sbM1627q.append(getType());
        }
        return sbM1627q.toString();
    }

    public Span trim(CharSequence charSequence) {
        int start = getStart();
        for (int start2 = getStart(); start2 < getEnd() && StringUtil.isWhitespace(charSequence.charAt(start2)); start2++) {
            start++;
        }
        int end = getEnd();
        for (int end2 = getEnd(); end2 > getStart() && StringUtil.isWhitespace(charSequence.charAt(end2 - 1)); end2--) {
            end--;
        }
        return (start == getStart() && end == getEnd()) ? this : start > end ? new Span(getStart(), getStart(), getType()) : new Span(start, end, getType());
    }

    public Span(int i, int i2, String str, double d) {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "start index must be zero or greater: "));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "end index must be zero or greater: "));
        }
        if (i > i2) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, i2, "start index must not be larger than end index: start=", ", end="));
        }
        this.start = i;
        this.end = i2;
        this.prob = d;
        this.type = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Span span) {
        if (getStart() < span.getStart()) {
            return -1;
        }
        if (getStart() == span.getStart()) {
            if (getEnd() > span.getEnd()) {
                return -1;
            }
            if (getEnd() < span.getEnd()) {
                return 1;
            }
            if (getType() == null && span.getType() == null) {
                return 0;
            }
            if (getType() != null && span.getType() != null) {
                return getType().compareTo(span.getType());
            }
            if (getType() != null) {
                return -1;
            }
        }
        return 1;
    }

    public boolean contains(int i) {
        return this.start <= i && i < this.end;
    }

    public static String[] spansToStrings(Span[] spanArr, String[] strArr) {
        String[] strArr2 = new String[spanArr.length];
        StringBuilder sb = new StringBuilder();
        int length = spanArr.length;
        for (int i = 0; i < length; i++) {
            sb.setLength(0);
            int start = spanArr[i].getStart();
            while (start < spanArr[i].getEnd()) {
                start = AbstractC2821a.m2213d(sb, start, 1, strArr[start], " ");
            }
            strArr2[i] = sb.substring(0, sb.length() - 1);
        }
        return strArr2;
    }

    public Span(int i, int i2) {
        this(i, i2, null, 0.0d);
    }

    public Span(int i, int i2, double d) {
        this(i, i2, null, d);
    }

    public Span(Span span, int i) {
        this(span.start + i, span.end + i, span.getType(), span.getProb());
    }

    public Span(Span span, double d) {
        this(span.start, span.end, span.getType(), d);
    }
}
