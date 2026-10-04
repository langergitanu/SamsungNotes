package opennlp.tools.postag;

import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WordTagSampleStream extends FilterObjectStream<String, POSSample> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) WordTagSampleStream.class);

    public WordTagSampleStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public POSSample read() {
        String str = (String) this.samples.read();
        if (str == null) {
            return null;
        }
        try {
            return POSSample.parse(str);
        } catch (InvalidFormatException e) {
            logger.warn("Error during parsing, ignoring sentence: {}", str, e);
            return new POSSample(new String[0], new String[0]);
        }
    }
}
