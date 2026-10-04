package opennlp.tools.dictionary;

import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import opennlp.tools.dictionary.serializer.Attributes;
import opennlp.tools.dictionary.serializer.DictionaryEntryPersistor;
import opennlp.tools.dictionary.serializer.Entry;
import opennlp.tools.util.StringList;
import opennlp.tools.util.model.DictionarySerializer;
import opennlp.tools.util.model.SerializableArtifact;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Dictionary implements Iterable<StringList>, SerializableArtifact {
    private final Set<StringList> entrySet;
    private final boolean isCaseSensitive;
    private int maxTokenCount;
    private int minTokenCount;

    public Dictionary() {
        this(false);
    }

    private StringList applyCaseSensitivity(StringList stringList) {
        return this.isCaseSensitive ? stringList.toCaseSensitive() : stringList.toCaseInsensitive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Entry entry) {
        put(entry.tokens());
    }

    public static Dictionary parseOneEntryPerLine(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        Dictionary dictionary = new Dictionary();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return dictionary;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            int iCountTokens = stringTokenizer.countTokens();
            String[] strArr = new String[iCountTokens];
            if (iCountTokens > 0) {
                int i = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    strArr[i] = stringTokenizer.nextToken();
                    i++;
                }
                dictionary.put(new StringList(strArr));
            }
        }
    }

    public Set<String> asStringSet() {
        return new AbstractSet<String>() { // from class: opennlp.tools.dictionary.Dictionary.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof String) {
                    return Dictionary.this.entrySet.contains(new StringList(Dictionary.this.isCaseSensitive, (String) obj));
                }
                return false;
            }

            @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
            public boolean equals(Object obj) {
                if (!(obj instanceof Set)) {
                    return false;
                }
                Set set = (Set) obj;
                if (Dictionary.this.entrySet.size() != set.size()) {
                    return false;
                }
                Iterator it = set.iterator();
                for (StringList stringList : Dictionary.this.entrySet) {
                    if (Dictionary.this.isCaseSensitive) {
                        if (!stringList.equals(new StringList(true, (String) it.next()))) {
                            return false;
                        }
                    } else if (!stringList.compareToIgnoreCase(new StringList(false, (String) it.next()))) {
                        return false;
                    }
                }
                return true;
            }

            @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return Dictionary.this.entrySet.hashCode();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<String> iterator() {
                final Iterator it = Dictionary.this.entrySet.iterator();
                return new Iterator<String>() { // from class: opennlp.tools.dictionary.Dictionary.3.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public String next() {
                        return ((StringList) it.next()).getToken(0);
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Dictionary.this.entrySet.size();
            }
        };
    }

    public boolean contains(StringList stringList) {
        return this.entrySet.contains(applyCaseSensitivity(stringList));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Dictionary) {
            return this.entrySet.equals(((Dictionary) obj).entrySet);
        }
        return false;
    }

    @Override // opennlp.tools.util.model.SerializableArtifact
    public Class<?> getArtifactSerializerClass() {
        return DictionarySerializer.class;
    }

    public int getMaxTokenCount() {
        return this.maxTokenCount;
    }

    public int getMinTokenCount() {
        return this.minTokenCount;
    }

    public int hashCode() {
        return this.entrySet.hashCode();
    }

    public boolean isCaseSensitive() {
        return this.isCaseSensitive;
    }

    @Override // java.lang.Iterable
    public Iterator<StringList> iterator() {
        final Iterator<StringList> it = this.entrySet.iterator();
        return new Iterator<StringList>() { // from class: opennlp.tools.dictionary.Dictionary.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }

            @Override // java.util.Iterator
            public StringList next() {
                return (StringList) it.next();
            }
        };
    }

    public void put(StringList stringList) {
        this.entrySet.add(applyCaseSensitivity(stringList));
        this.minTokenCount = StrictMath.min(this.minTokenCount, stringList.size());
        this.maxTokenCount = StrictMath.max(this.maxTokenCount, stringList.size());
    }

    public void remove(StringList stringList) {
        this.entrySet.remove(applyCaseSensitivity(stringList));
    }

    public void serialize(OutputStream outputStream) {
        DictionaryEntryPersistor.serialize(outputStream, new Iterator<Entry>() { // from class: opennlp.tools.dictionary.Dictionary.2
            private final Iterator<StringList> dictionaryIterator;

            {
                this.dictionaryIterator = Dictionary.this.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.dictionaryIterator.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public Entry next() {
                return new Entry(this.dictionaryIterator.next(), new Attributes());
            }
        }, this.isCaseSensitive);
    }

    public int size() {
        return this.entrySet.size();
    }

    public String toString() {
        return this.entrySet.toString();
    }

    public Dictionary(boolean z) {
        this.entrySet = new HashSet();
        this.minTokenCount = 99999;
        this.maxTokenCount = 0;
        this.isCaseSensitive = z;
    }

    public Dictionary(InputStream inputStream) {
        this.entrySet = new HashSet();
        this.minTokenCount = 99999;
        this.maxTokenCount = 0;
        this.isCaseSensitive = DictionaryEntryPersistor.create(inputStream, new C11253j(this, 17));
    }
}
