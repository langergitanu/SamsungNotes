package opennlp.tools.ngram;

import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import opennlp.tools.util.StringUtil;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NGramCharModel implements Iterable<CharSequence> {
    protected static final String COUNT = "count";
    private final Map<CharSequence, Integer> mNGrams = new HashMap();

    public void add(CharSequence charSequence) {
        if (contains(charSequence)) {
            setCount(charSequence, getCount(charSequence) + 1);
        } else {
            this.mNGrams.put(CharBuffer.wrap(charSequence), 1);
        }
    }

    public boolean contains(CharSequence charSequence) {
        if (charSequence instanceof CharBuffer) {
            return this.mNGrams.containsKey(charSequence);
        }
        if (charSequence != null) {
            return this.mNGrams.containsKey(CharBuffer.wrap(charSequence));
        }
        return false;
    }

    public void cutoff(int i, int i2) {
        if (i > 0 || i2 < Integer.MAX_VALUE) {
            Iterator<CharSequence> it = iterator();
            while (it.hasNext()) {
                int count = getCount(it.next());
                if (count < i || count > i2) {
                    it.remove();
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NGramCharModel) {
            return this.mNGrams.equals(((NGramCharModel) obj).mNGrams);
        }
        return false;
    }

    public int getCount(CharSequence charSequence) {
        Integer num = charSequence instanceof CharBuffer ? this.mNGrams.get(charSequence) : this.mNGrams.get(CharBuffer.wrap(charSequence));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int hashCode() {
        return this.mNGrams.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<CharSequence> iterator() {
        return this.mNGrams.keySet().iterator();
    }

    public int numberOfGrams() {
        Iterator<CharSequence> it = iterator();
        int count = 0;
        while (it.hasNext()) {
            count += getCount(it.next());
        }
        return count;
    }

    public void remove(CharSequence charSequence) {
        if (charSequence instanceof CharBuffer) {
            this.mNGrams.remove(charSequence);
        } else if (charSequence != null) {
            this.mNGrams.remove(CharBuffer.wrap(charSequence));
        }
    }

    public void setCount(CharSequence charSequence, int i) {
        if (this.mNGrams.put(charSequence, Integer.valueOf(i)) != null) {
            return;
        }
        this.mNGrams.remove(charSequence);
        throw new NoSuchElementException();
    }

    public int size() {
        return this.mNGrams.size();
    }

    public String toString() {
        return AbstractC0000a.m11h(size(), "Size: ");
    }

    public void add(CharSequence charSequence, int i, int i2) {
        CharBuffer lowerCaseCharBuffer = StringUtil.toLowerCaseCharBuffer(charSequence);
        while (i < i2 + 1) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + i;
                if (i5 - 1 < lowerCaseCharBuffer.length()) {
                    add(lowerCaseCharBuffer.subSequence(i4, i5));
                    i4++;
                }
            }
            i++;
        }
    }
}
