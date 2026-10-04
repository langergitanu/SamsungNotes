package opennlp.tools.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import opennlp.tools.util.jvm.StringInterners;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringList implements Iterable<String> {
    private final boolean caseSensitive;
    private final String[] tokens;

    public StringList(String str) {
        this(true, str);
    }

    public boolean compareToIgnoreCase(StringList stringList) {
        if (size() != stringList.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (getToken(i).compareToIgnoreCase(stringList.getToken(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StringList)) {
            return false;
        }
        StringList stringList = (StringList) obj;
        return this.caseSensitive ? Arrays.equals(this.tokens, stringList.tokens) : compareToIgnoreCase(stringList);
    }

    public String getToken(int i) {
        return this.tokens[i];
    }

    public int hashCode() {
        return StringUtil.toLowerCase(toString()).hashCode();
    }

    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: opennlp.tools.util.StringList.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < StringList.this.size();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StringList stringList = StringList.this;
                int i = this.index;
                this.index = i + 1;
                return stringList.getToken(i);
            }
        };
    }

    public int size() {
        return this.tokens.length;
    }

    public StringList toCaseInsensitive() {
        return isCaseSensitive() ? new StringList(false, this.tokens) : this;
    }

    public StringList toCaseSensitive() {
        return !isCaseSensitive() ? new StringList(true, this.tokens) : this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            sb.append(getToken(i));
            if (i < size() - 1) {
                sb.append(',');
            }
        }
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }

    public StringList(String... strArr) {
        this(true, strArr);
    }

    public StringList(boolean z, String... strArr) {
        Objects.requireNonNull(strArr, "tokens must not be null");
        if (strArr.length != 0) {
            this.tokens = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                this.tokens[i] = StringInterners.intern(strArr[i]);
            }
            this.caseSensitive = z;
            return;
        }
        throw new IllegalArgumentException("tokens must not be empty");
    }
}
