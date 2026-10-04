package org.apache.commons.collections4.properties;

import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import java.util.AbstractMap;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.iterators.IteratorEnumeration;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SortedProperties extends Properties {
    private static final long serialVersionUID = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AbstractMap.SimpleEntry lambda$entrySet$0(String str) {
        return new AbstractMap.SimpleEntry(str, getProperty(str));
    }

    private Stream<String> sortedKeys() {
        return keySet().stream().map(new C11419a(27)).sorted();
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return (Set) sortedKeys().map(new C0332a(this, 15)).collect(Collectors.toCollection(new C2747a(12)));
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public synchronized Enumeration<Object> keys() {
        return new IteratorEnumeration(((List) sortedKeys().collect(Collectors.toList())).iterator());
    }
}
