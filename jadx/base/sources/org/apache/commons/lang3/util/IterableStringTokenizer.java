package org.apache.commons.lang3.util;

import com.samsung.android.sdk.scs.p142ai.asr.C7695k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IterableStringTokenizer extends StringTokenizer implements Iterable<String> {
    public IterableStringTokenizer(String str) {
        super(str);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: org.apache.commons.lang3.util.IterableStringTokenizer.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return IterableStringTokenizer.this.hasMoreElements();
            }

            @Override // java.util.Iterator
            public String next() {
                return Objects.toString(IterableStringTokenizer.this.nextElement(), null);
            }
        };
    }

    public String[] toArray() {
        return (String[]) toList().toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public List<String> toList() {
        ArrayList arrayList = new ArrayList();
        forEach(new C7695k(arrayList, 1));
        return arrayList;
    }

    public Stream<String> toStream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public IterableStringTokenizer(String str, String str2) {
        super(str, str2);
    }

    public IterableStringTokenizer(String str, String str2, boolean z) {
        super(str, str2, z);
    }
}
