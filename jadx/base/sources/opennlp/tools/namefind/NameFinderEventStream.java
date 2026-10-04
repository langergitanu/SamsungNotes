package opennlp.tools.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.emoji2.text.flatbuffer.C2747a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.Span;
import opennlp.tools.util.featuregen.AdditionalContextFeatureGenerator;
import opennlp.tools.util.featuregen.WindowFeatureGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NameFinderEventStream extends AbstractEventStream<NameSample> {
    private final AdditionalContextFeatureGenerator additionalContextFeatureGenerator;
    private final SequenceCodec<String> codec;
    private final NameContextGenerator contextGenerator;
    private final String defaultType;

    public NameFinderEventStream(ObjectStream<NameSample> objectStream, String str, NameContextGenerator nameContextGenerator, SequenceCodec<String> sequenceCodec) {
        super(objectStream);
        AdditionalContextFeatureGenerator additionalContextFeatureGenerator = new AdditionalContextFeatureGenerator();
        this.additionalContextFeatureGenerator = additionalContextFeatureGenerator;
        C2747a c2747a = new C2747a(10);
        Object obj = sequenceCodec;
        if (sequenceCodec == null) {
            Object obj2 = c2747a.get();
            Objects.requireNonNull(obj2, "supplier.get()");
            obj = obj2;
        }
        this.codec = (SequenceCodec) obj;
        this.contextGenerator = nameContextGenerator;
        nameContextGenerator.addFeatureGenerator(new WindowFeatureGenerator(additionalContextFeatureGenerator, 8, 8));
        this.defaultType = str;
    }

    public static String[][] additionalContext(String[] strArr, Map<String, String> map) {
        String[][] strArr2 = (String[][]) Array.newInstance((Class<?>) String.class, strArr.length, 1);
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i][0] = AbstractC0541b.m772n("pd=", map.get(strArr[i]));
        }
        return strArr2;
    }

    public static List<Event> generateEvents(String[] strArr, String[] strArr2, NameContextGenerator nameContextGenerator) {
        ArrayList arrayList = new ArrayList(strArr2.length);
        for (int i = 0; i < strArr2.length; i++) {
            arrayList.add(new Event(strArr2[i], nameContextGenerator.getContext(i, strArr, strArr2, null)));
        }
        nameContextGenerator.updateAdaptiveData(strArr, strArr2);
        return arrayList;
    }

    @Deprecated(forRemoval = true)
    public static String[] generateOutcomes(Span[] spanArr, String str, int i) {
        String[] strArr = new String[i];
        Arrays.fill(strArr, "other");
        for (Span span : spanArr) {
            if (span.getType() == null) {
                strArr[span.getStart()] = AbstractC0541b.m756B(str, "-start");
            } else {
                strArr[span.getStart()] = AbstractC0541b.m756B(span.getType(), "-start");
            }
            int start = span.getStart();
            while (true) {
                start++;
                if (start < span.getEnd()) {
                    if (span.getType() == null) {
                        strArr[start] = AbstractC0541b.m756B(str, "-cont");
                    } else {
                        strArr[start] = AbstractC0541b.m756B(span.getType(), "-cont");
                    }
                }
            }
        }
        return strArr;
    }

    private void overrideType(Span[] spanArr) {
        for (int i = 0; i < spanArr.length; i++) {
            Span span = spanArr[i];
            spanArr[i] = new Span(span.getStart(), span.getEnd(), this.defaultType, span.getProb());
        }
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(NameSample nameSample) {
        if (nameSample.isClearAdaptiveDataSet()) {
            this.contextGenerator.clearAdaptiveData();
        }
        Span[] names = nameSample.getNames();
        if (this.defaultType != null) {
            overrideType(names);
        }
        String[] strArrEncode = this.codec.encode(names, nameSample.getSentence().length);
        this.additionalContextFeatureGenerator.setCurrentContext(nameSample.getAdditionalContext());
        String[] strArr = new String[nameSample.getSentence().length];
        for (int i = 0; i < nameSample.getSentence().length; i++) {
            strArr[i] = nameSample.getSentence()[i];
        }
        return generateEvents(strArr, strArrEncode, this.contextGenerator).iterator();
    }
}
