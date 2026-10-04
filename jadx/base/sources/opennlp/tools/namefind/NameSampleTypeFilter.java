package opennlp.tools.namefind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NameSampleTypeFilter extends FilterObjectStream<NameSample, NameSample> {
    private final Set<String> types;

    public NameSampleTypeFilter(String[] strArr, ObjectStream<NameSample> objectStream) {
        super(objectStream);
        this.types = Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
    }

    @Override // opennlp.tools.util.ObjectStream
    public NameSample read() {
        NameSample nameSample = (NameSample) this.samples.read();
        if (nameSample == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Span span : nameSample.getNames()) {
            if (this.types.contains(span.getType())) {
                arrayList.add(span);
            }
        }
        return new NameSample(nameSample.getId(), nameSample.getSentence(), (Span[]) arrayList.toArray(new Span[0]), null, nameSample.isClearAdaptiveDataSet());
    }

    public NameSampleTypeFilter(Set<String> set, ObjectStream<NameSample> objectStream) {
        super(objectStream);
        HashSet hashSet = new HashSet(set.size());
        for (String str : set) {
            Objects.requireNonNull(str);
            hashSet.add(str);
        }
        this.types = Collections.unmodifiableSet(hashSet);
    }
}
