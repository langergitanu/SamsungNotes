package opennlp.tools.cmdline.namefind;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NameSampleCountersStream extends FilterObjectStream<NameSample, NameSample> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) NameSampleCountersStream.class);
    private Map<String, Integer> nameCounters;
    private int sentenceCount;
    private int tokenCount;

    public NameSampleCountersStream(ObjectStream<NameSample> objectStream) {
        super(objectStream);
        this.nameCounters = new HashMap();
    }

    public Map<String, Integer> getNameCounters() {
        return Collections.unmodifiableMap(this.nameCounters);
    }

    public int getSentenceCount() {
        return this.sentenceCount;
    }

    public int getTokenCount() {
        return this.tokenCount;
    }

    public void printSummary() {
        Logger logger2 = logger;
        logger2.info("Training data summary:");
        logger2.info("#Sentences: {}", Integer.valueOf(getSentenceCount()));
        logger2.info("#Tokens: {}", Integer.valueOf(getTokenCount()));
        int iIntValue = 0;
        for (Map.Entry<String, Integer> entry : getNameCounters().entrySet()) {
            logger.info("# {} entities: {}", entry.getKey(), entry.getValue());
            iIntValue += entry.getValue().intValue();
        }
        logger.info("# total: {}", Integer.valueOf(iIntValue));
    }

    @Override // opennlp.tools.util.FilterObjectStream, opennlp.tools.util.ObjectStream
    public void reset() {
        super.reset();
        this.sentenceCount = 0;
        this.tokenCount = 0;
        this.nameCounters = new HashMap();
    }

    @Override // opennlp.tools.util.ObjectStream
    public NameSample read() {
        NameSample nameSample = (NameSample) this.samples.read();
        if (nameSample != null) {
            this.sentenceCount++;
            this.tokenCount += nameSample.getSentence().length;
            for (Span span : nameSample.getNames()) {
                Integer num = this.nameCounters.get(span.getType());
                if (num == null) {
                    num = 0;
                }
                this.nameCounters.put(span.getType(), Integer.valueOf(num.intValue() + 1));
            }
        }
        return nameSample;
    }
}
