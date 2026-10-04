package opennlp.tools.postag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSSampleEventStream extends AbstractEventStream<POSSample> {

    /* JADX INFO: renamed from: cg */
    private final POSContextGenerator f9685cg;

    public POSSampleEventStream(ObjectStream<POSSample> objectStream, POSContextGenerator pOSContextGenerator) {
        super(objectStream);
        this.f9685cg = pOSContextGenerator;
    }

    public static List<Event> generateEvents(String[] strArr, String[] strArr2, Object[] objArr, POSContextGenerator pOSContextGenerator) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new Event(strArr2[i], pOSContextGenerator.getContext(i, strArr, strArr2, objArr)));
        }
        return arrayList;
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(POSSample pOSSample) {
        return generateEvents(pOSSample.getSentence(), pOSSample.getTags(), pOSSample.getAdditionalContext(), this.f9685cg).iterator();
    }

    public POSSampleEventStream(ObjectStream<POSSample> objectStream) {
        this(objectStream, new DefaultPOSContextGenerator(null));
    }

    public static List<Event> generateEvents(String[] strArr, String[] strArr2, POSContextGenerator pOSContextGenerator) {
        return generateEvents(strArr, strArr2, null, pOSContextGenerator);
    }
}
