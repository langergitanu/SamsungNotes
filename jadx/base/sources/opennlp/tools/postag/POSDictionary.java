package opennlp.tools.postag;

import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.dictionary.serializer.Attributes;
import opennlp.tools.dictionary.serializer.DictionaryEntryPersistor;
import opennlp.tools.dictionary.serializer.Entry;
import opennlp.tools.postag.POSTaggerFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.StringList;
import opennlp.tools.util.StringUtil;
import opennlp.tools.util.model.SerializableArtifact;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSDictionary implements Iterable<String>, MutableTagDictionary, SerializableArtifact {
    private boolean caseSensitive;
    private Map<String, String[]> dictionary;

    public POSDictionary() {
        this(true);
    }

    public static POSDictionary create(InputStream inputStream) {
        POSDictionary pOSDictionary = new POSDictionary();
        boolean zCreate = DictionaryEntryPersistor.create(inputStream, new C11253j(pOSDictionary, 20));
        pOSDictionary.caseSensitive = zCreate;
        if (!zCreate) {
            HashMap map = new HashMap();
            for (Map.Entry<String, String[]> entry : pOSDictionary.dictionary.entrySet()) {
                map.put(StringUtil.toLowerCase(entry.getKey()), entry.getValue());
            }
            pOSDictionary.dictionary = map;
        }
        return pOSDictionary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$create$0(POSDictionary pOSDictionary, Entry entry) throws InvalidFormatException {
        String[] strArrSplit = entry.attributes().getValue("tags").split(" ");
        StringList stringList = entry.tokens();
        if (stringList.size() == 1) {
            pOSDictionary.dictionary.put(stringList.getToken(0), strArrSplit);
        } else {
            throw new InvalidFormatException("Each entry must have exactly one token! " + stringList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String tagsToString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof POSDictionary) {
            POSDictionary pOSDictionary = (POSDictionary) obj;
            if (this.dictionary.size() == pOSDictionary.dictionary.size()) {
                for (String str : this) {
                    if (!Arrays.equals(getTags(str), pOSDictionary.getTags(str))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // opennlp.tools.util.model.SerializableArtifact
    public Class<?> getArtifactSerializerClass() {
        return POSTaggerFactory.POSDictionarySerializer.class;
    }

    @Override // opennlp.tools.postag.TagDictionary
    public String[] getTags(String str) {
        return this.caseSensitive ? this.dictionary.get(str) : this.dictionary.get(StringUtil.toLowerCase(str));
    }

    public int hashCode() {
        int[] iArr = new int[this.dictionary.size()];
        int[] iArr2 = new int[this.dictionary.size()];
        int i = 0;
        for (String str : this) {
            iArr[i] = str.hashCode();
            iArr2[i] = Arrays.hashCode(getTags(str));
            i++;
        }
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        return Objects.hash(Integer.valueOf(Arrays.hashCode(iArr)), Integer.valueOf(Arrays.hashCode(iArr2)));
    }

    @Override // opennlp.tools.postag.TagDictionary
    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.dictionary.keySet().iterator();
    }

    @Override // opennlp.tools.postag.MutableTagDictionary
    public String[] put(String str, String... strArr) {
        return this.caseSensitive ? this.dictionary.put(str, strArr) : this.dictionary.put(StringUtil.toLowerCase(str), strArr);
    }

    public void serialize(OutputStream outputStream) {
        DictionaryEntryPersistor.serialize(outputStream, new Iterator<Entry>() { // from class: opennlp.tools.postag.POSDictionary.1
            final Iterator<String> iterator;

            {
                this.iterator = POSDictionary.this.dictionary.keySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public Entry next() {
                String next = this.iterator.next();
                Attributes attributes = new Attributes();
                attributes.setValue("tags", POSDictionary.tagsToString(POSDictionary.this.getTags(next)));
                return new Entry(new StringList(next), attributes);
            }
        }, this.caseSensitive);
    }

    public String toString() {
        return "POSDictionary{size=" + this.dictionary.size() + ", caseSensitive=" + this.caseSensitive + "}";
    }

    public POSDictionary(boolean z) {
        this.caseSensitive = true;
        this.dictionary = new HashMap();
        this.caseSensitive = z;
    }
}
