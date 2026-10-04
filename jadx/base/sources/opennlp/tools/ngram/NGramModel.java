package opennlp.tools.ngram;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.dictionary.serializer.Attributes;
import opennlp.tools.dictionary.serializer.DictionaryEntryPersistor;
import opennlp.tools.dictionary.serializer.Entry;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.StringList;
import opennlp.tools.util.StringUtil;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NGramModel implements Iterable<StringList> {
    protected static final String COUNT = "count";
    private final Map<StringList, Integer> mNGrams = new LinkedHashMap();

    public NGramModel() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Entry entry) throws InvalidFormatException {
        try {
            String value = entry.attributes().getValue("count");
            if (value == null) {
                throw new InvalidFormatException("The count attribute must be set!");
            }
            int i = Integer.parseInt(value);
            add(entry.tokens());
            setCount(entry.tokens(), i);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("The count attribute '", null, "' must be a number!"), e);
        }
    }

    public void add(StringList stringList) {
        if (contains(stringList)) {
            setCount(stringList, getCount(stringList) + 1);
        } else {
            this.mNGrams.put(stringList, 1);
        }
    }

    public boolean contains(StringList stringList) {
        return this.mNGrams.containsKey(stringList);
    }

    public void cutoff(int i, int i2) {
        if (i > 0 || i2 < Integer.MAX_VALUE) {
            Iterator<StringList> it = iterator();
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
        if (obj instanceof NGramModel) {
            return this.mNGrams.equals(((NGramModel) obj).mNGrams);
        }
        return false;
    }

    public int getCount(StringList stringList) {
        Integer num = this.mNGrams.get(stringList);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int hashCode() {
        return this.mNGrams.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<StringList> iterator() {
        return this.mNGrams.keySet().iterator();
    }

    public int numberOfGrams() {
        Iterator<StringList> it = iterator();
        int count = 0;
        while (it.hasNext()) {
            count += getCount(it.next());
        }
        return count;
    }

    public void remove(StringList stringList) {
        this.mNGrams.remove(stringList);
    }

    public void serialize(OutputStream outputStream) {
        DictionaryEntryPersistor.serialize(outputStream, new Iterator<Entry>() { // from class: opennlp.tools.ngram.NGramModel.1
            private final Iterator<StringList> mDictionaryIterator;

            {
                this.mDictionaryIterator = NGramModel.this.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.mDictionaryIterator.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public Entry next() {
                StringList next = this.mDictionaryIterator.next();
                Attributes attributes = new Attributes();
                attributes.setValue("count", Integer.toString(NGramModel.this.getCount(next)));
                return new Entry(next, attributes);
            }
        }, false);
    }

    public void setCount(StringList stringList, int i) {
        if (this.mNGrams.put(stringList, Integer.valueOf(i)) != null) {
            return;
        }
        this.mNGrams.remove(stringList);
        throw new NoSuchElementException();
    }

    public int size() {
        return this.mNGrams.size();
    }

    public Dictionary toDictionary() {
        return toDictionary(false);
    }

    public String toString() {
        return AbstractC0000a.m11h(size(), "Size: ");
    }

    public Dictionary toDictionary(boolean z) {
        Dictionary dictionary = new Dictionary(z);
        Iterator<StringList> it = iterator();
        while (it.hasNext()) {
            dictionary.put(it.next());
        }
        return dictionary;
    }

    public NGramModel(InputStream inputStream) {
        DictionaryEntryPersistor.create(inputStream, new C11253j(this, 19));
    }

    public void add(StringList stringList, int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, i2, "minLength and maxLength param must be at least 1. minLength=", ", maxLength= "));
        }
        if (i > i2) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, i2, "minLength param must not be larger than maxLength param. minLength=", ", maxLength= "));
        }
        while (i < i2 + 1) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + i;
                if (i5 - 1 < stringList.size()) {
                    String[] strArr = new String[i];
                    for (int i6 = i4; i6 < i5; i6++) {
                        strArr[i6 - i4] = stringList.getToken(i6);
                    }
                    add(new StringList(strArr));
                    i4++;
                }
            }
            i++;
        }
    }

    public void add(CharSequence charSequence, int i, int i2) {
        CharBuffer lowerCaseCharBuffer = StringUtil.toLowerCaseCharBuffer(charSequence);
        while (i < i2 + 1) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + i;
                if (i5 - 1 < charSequence.length()) {
                    add(new StringList(lowerCaseCharBuffer.subSequence(i4, i5).toString()));
                    i4++;
                }
            }
            i++;
        }
    }
}
