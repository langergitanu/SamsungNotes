package org.jsoup.parser;

import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenQueue {
    private static final char ESC = '\\';
    private int pos = 0;
    private String queue;

    public TokenQueue(String str) {
        Validate.notNull(str);
        this.queue = str;
    }

    private int remainingLength() {
        return this.queue.length() - this.pos;
    }

    public static String unescape(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '\\') {
                sb.append(c2);
            } else if (c != 0 && c == '\\') {
                sb.append(c2);
            }
            i++;
            c = c2;
        }
        return sb.toString();
    }

    public void addFirst(String str) {
        this.queue = AbstractC4539a.m3198h(AbstractC1974b.m1324q(str), this.queue, this.pos);
        this.pos = 0;
    }

    public void advance() {
        if (isEmpty()) {
            return;
        }
        this.pos++;
    }

    public String chompBalanced(char c, char c2) {
        char c4 = 0;
        int i = -1;
        int i2 = -1;
        int i4 = 0;
        while (!isEmpty()) {
            char cConsume = consume();
            Character chValueOf = Character.valueOf(cConsume);
            if (c4 == 0 || c4 != '\\') {
                if (chValueOf.equals(Character.valueOf(c))) {
                    i4++;
                    if (i == -1) {
                        i = this.pos;
                    }
                } else if (chValueOf.equals(Character.valueOf(c2))) {
                    i4--;
                }
            }
            if (i4 > 0 && c4 != 0) {
                i2 = this.pos;
            }
            if (i4 <= 0) {
                break;
            }
            c4 = cConsume;
        }
        return i2 >= 0 ? this.queue.substring(i, i2) : "";
    }

    public String chompTo(String str) {
        String strConsumeTo = consumeTo(str);
        matchChomp(str);
        return strConsumeTo;
    }

    public String chompToIgnoreCase(String str) {
        String strConsumeToIgnoreCase = consumeToIgnoreCase(str);
        matchChomp(str);
        return strConsumeToIgnoreCase;
    }

    public char consume() {
        String str = this.queue;
        int i = this.pos;
        this.pos = i + 1;
        return str.charAt(i);
    }

    public String consumeAttributeKey() {
        int i = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny('-', '_', ':'))) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeCssIdentifier() {
        int i = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny('-', '_'))) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeElementSelector() {
        int i = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny('|', '_', '-'))) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeTagName() {
        int i = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny(':', '_', '-'))) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeTo(String str) {
        int iIndexOf = this.queue.indexOf(str, this.pos);
        if (iIndexOf == -1) {
            return remainder();
        }
        String strSubstring = this.queue.substring(this.pos, iIndexOf);
        this.pos = strSubstring.length() + this.pos;
        return strSubstring;
    }

    public String consumeToAny(String... strArr) {
        int i = this.pos;
        while (!isEmpty() && !matchesAny(strArr)) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeToIgnoreCase(String str) {
        int i = this.pos;
        String strSubstring = str.substring(0, 1);
        boolean zEquals = strSubstring.toLowerCase().equals(strSubstring.toUpperCase());
        while (!isEmpty() && !matches(str)) {
            if (zEquals) {
                int iIndexOf = this.queue.indexOf(strSubstring, this.pos);
                int i2 = this.pos;
                int i4 = iIndexOf - i2;
                if (i4 == 0) {
                    this.pos = i2 + 1;
                } else if (i4 < 0) {
                    this.pos = this.queue.length();
                } else {
                    this.pos = i2 + i4;
                }
            } else {
                this.pos++;
            }
        }
        return this.queue.substring(i, this.pos);
    }

    public boolean consumeWhitespace() {
        boolean z = false;
        while (matchesWhitespace()) {
            this.pos++;
            z = true;
        }
        return z;
    }

    public String consumeWord() {
        int i = this.pos;
        while (matchesWord()) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public boolean isEmpty() {
        return remainingLength() == 0;
    }

    public boolean matchChomp(String str) {
        if (!matches(str)) {
            return false;
        }
        this.pos = str.length() + this.pos;
        return true;
    }

    public boolean matches(String str) {
        return this.queue.regionMatches(true, this.pos, str, 0, str.length());
    }

    public boolean matchesAny(String... strArr) {
        for (String str : strArr) {
            if (matches(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesCS(String str) {
        return this.queue.startsWith(str, this.pos);
    }

    public boolean matchesStartTag() {
        return remainingLength() >= 2 && this.queue.charAt(this.pos) == '<' && Character.isLetter(this.queue.charAt(this.pos + 1));
    }

    public boolean matchesWhitespace() {
        return !isEmpty() && StringUtil.isWhitespace(this.queue.charAt(this.pos));
    }

    public boolean matchesWord() {
        return !isEmpty() && Character.isLetterOrDigit(this.queue.charAt(this.pos));
    }

    public char peek() {
        if (isEmpty()) {
            return (char) 0;
        }
        return this.queue.charAt(this.pos);
    }

    public String remainder() {
        String str = this.queue;
        String strSubstring = str.substring(this.pos, str.length());
        this.pos = this.queue.length();
        return strSubstring;
    }

    public String toString() {
        return this.queue.substring(this.pos);
    }

    public void consume(String str) {
        if (!matches(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        if (length > remainingLength()) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.pos += length;
    }

    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        for (char c : cArr) {
            if (this.queue.charAt(this.pos) == c) {
                return true;
            }
        }
        return false;
    }

    public void addFirst(Character ch) {
        addFirst(ch.toString());
    }
}
