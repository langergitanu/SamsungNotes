package opennlp.tools.formats.conllu;

import java.util.ArrayList;
import java.util.Objects;
import opennlp.tools.lemmatizer.LemmaSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConlluLemmaSampleStream extends FilterObjectStream<ConlluSentence, LemmaSample> {
    private final ConlluTagset tagset;

    public ConlluLemmaSampleStream(ObjectStream<ConlluSentence> objectStream, ConlluTagset conlluTagset) {
        super(objectStream);
        Objects.requireNonNull(conlluTagset);
        this.tagset = conlluTagset;
    }

    @Override // opennlp.tools.util.ObjectStream
    public LemmaSample read() {
        ConlluSentence conlluSentence = (ConlluSentence) this.samples.read();
        if (conlluSentence == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (ConlluWordLine conlluWordLine : conlluSentence.getWordLines()) {
            arrayList.add(conlluWordLine.getForm());
            arrayList2.add(conlluWordLine.getPosTag(this.tagset));
            arrayList3.add(conlluWordLine.getLemma());
        }
        return new LemmaSample(arrayList, arrayList2, arrayList3);
    }
}
