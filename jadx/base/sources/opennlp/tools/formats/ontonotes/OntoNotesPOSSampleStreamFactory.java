package opennlp.tools.formats.ontonotes;

import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.formats.convert.ParseToPOSSampleStream;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OntoNotesPOSSampleStreamFactory extends AbstractSampleStreamFactory<POSSample, OntoNotesFormatParameters> {
    private final OntoNotesParseSampleStreamFactory parseSampleStreamFactory;

    public OntoNotesPOSSampleStreamFactory() {
        super(OntoNotesFormatParameters.class);
        this.parseSampleStreamFactory = new OntoNotesParseSampleStreamFactory();
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(POSSample.class, "ontonotes", new OntoNotesPOSSampleStreamFactory());
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<POSSample> create(String[] strArr) {
        return new ParseToPOSSampleStream(this.parseSampleStreamFactory.create(strArr));
    }
}
