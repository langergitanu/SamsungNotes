package com.microsoft.identity.common.internal.util;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.util.ported.Predicate;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SharedPreferenceLongStorage extends AbstractSharedPrefNameValueStorage<Long> {
    public SharedPreferenceLongStorage(@NonNull IMultiTypeNameValueStorage iMultiTypeNameValueStorage) {
        super(iMultiTypeNameValueStorage);
        if (iMultiTypeNameValueStorage == null) {
            throw new NullPointerException("mManager is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @NonNull
    public Map<String, Long> getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : this.mManager.getAll().entrySet()) {
            try {
                map.put(entry.getKey(), Long.valueOf(Long.parseLong(entry.getValue())));
            } catch (NumberFormatException unused) {
            }
        }
        return map;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, Long>> getAllFilteredByKey(@NonNull Predicate<String> predicate) {
        if (predicate != null) {
            return new Iterator<Map.Entry<String, Long>>(predicate) { // from class: com.microsoft.identity.common.internal.util.SharedPreferenceLongStorage.1
                final Iterator<Map.Entry<String, String>> iterator;
                Map.Entry<String, Long> nextEntry = null;
                final /* synthetic */ Predicate val$keyFilter;

                {
                    this.val$keyFilter = predicate;
                    this.iterator = SharedPreferenceLongStorage.this.mManager.getAllFilteredByKey(predicate);
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.nextEntry != null) {
                        return true;
                    }
                    if (!this.iterator.hasNext()) {
                        return false;
                    }
                    do {
                        Map.Entry<String, String> next = this.iterator.next();
                        try {
                            this.nextEntry = new AbstractMap.SimpleEntry(next.getKey(), Long.valueOf(Long.parseLong(next.getValue())));
                        } catch (NumberFormatException unused) {
                            this.nextEntry = null;
                        }
                        if (this.nextEntry != null) {
                            break;
                        }
                    } while (this.iterator.hasNext());
                    return this.nextEntry != null;
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("Removal of elements is not supported");
                }

                @Override // java.util.Iterator
                public Map.Entry<String, Long> next() {
                    if (this.nextEntry == null && !hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Map.Entry<String, Long> entry = this.nextEntry;
                    this.nextEntry = null;
                    return entry;
                }
            };
        }
        throw new NullPointerException("keyFilter is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Long get(@NonNull String str) {
        if (str != null) {
            return Long.valueOf(this.mManager.getLong(str));
        }
        throw new NullPointerException("name is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(@NonNull String str, @Nullable Long l) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (l == null) {
            this.mManager.putString(str, null);
        } else {
            this.mManager.putLong(str, l.longValue());
        }
    }
}
