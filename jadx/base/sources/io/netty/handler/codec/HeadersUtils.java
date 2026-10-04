package io.netty.handler.codec;

import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HeadersUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DelegatingNameSet extends AbstractCollection<String> implements Set<String> {
        private final Headers<CharSequence, CharSequence, ?> headers;

        public DelegatingNameSet(Headers<CharSequence, CharSequence, ?> headers) {
            this.headers = (Headers) ObjectUtil.checkNotNull(headers, Contract.HEADERS);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.headers.contains(obj.toString());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.headers.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<String> iterator() {
            return new StringIterator(this.headers.names().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.headers.names().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StringEntry implements Map.Entry<String, String> {
        private final Map.Entry<CharSequence, CharSequence> entry;
        private String name;
        private String value;

        public StringEntry(Map.Entry<CharSequence, CharSequence> entry) {
            this.entry = entry;
        }

        public String toString() {
            return this.entry.toString();
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            if (this.name == null) {
                this.name = this.entry.getKey().toString();
            }
            return this.name;
        }

        @Override // java.util.Map.Entry
        public String getValue() {
            if (this.value == null && this.entry.getValue() != null) {
                this.value = this.entry.getValue().toString();
            }
            return this.value;
        }

        @Override // java.util.Map.Entry
        public String setValue(String str) {
            String value = getValue();
            this.entry.setValue(str);
            return value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StringEntryIterator implements Iterator<Map.Entry<String, String>> {
        private final Iterator<Map.Entry<CharSequence, CharSequence>> iter;

        public StringEntryIterator(Iterator<Map.Entry<CharSequence, CharSequence>> it) {
            this.iter = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<String, String> next() {
            return new StringEntry(this.iter.next());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StringIterator<T> implements Iterator<String> {
        private final Iterator<T> iter;

        public StringIterator(Iterator<T> it) {
            this.iter = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }

        @Override // java.util.Iterator
        public String next() {
            T next = this.iter.next();
            if (next != null) {
                return next.toString();
            }
            return null;
        }
    }

    private HeadersUtils() {
    }

    public static <K, V> List<String> getAllAsString(Headers<K, V, ?> headers, K k) {
        final List<V> all = headers.getAll(k);
        return new AbstractList<String>() { // from class: io.netty.handler.codec.HeadersUtils.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return all.size();
            }

            @Override // java.util.AbstractList, java.util.List
            public String get(int i) {
                Object obj = all.get(i);
                if (obj != null) {
                    return obj.toString();
                }
                return null;
            }
        };
    }

    public static <K, V> String getAsString(Headers<K, V, ?> headers, K k) {
        V v = headers.get(k);
        if (v != null) {
            return v.toString();
        }
        return null;
    }

    public static Iterator<Map.Entry<String, String>> iteratorAsString(Iterable<Map.Entry<CharSequence, CharSequence>> iterable) {
        return new StringEntryIterator(iterable.iterator());
    }

    public static Set<String> namesAsString(Headers<CharSequence, CharSequence, ?> headers) {
        return new DelegatingNameSet(headers);
    }

    public static <K, V> String toString(Class<?> cls, Iterator<Map.Entry<K, V>> it, int i) {
        String simpleName = cls.getSimpleName();
        if (i == 0) {
            return simpleName.concat(XMPConst.ARRAY_ITEM_NAME);
        }
        StringBuilder sb = new StringBuilder((i * 20) + simpleName.length() + 2);
        sb.append(simpleName);
        sb.append(PropertyUtils.INDEXED_DELIM);
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            sb.append(next.getKey());
            sb.append(": ");
            sb.append(next.getValue());
            sb.append(SQLKeyword.COMMA);
        }
        sb.setLength(sb.length() - 2);
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }
}
