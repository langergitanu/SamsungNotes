package opennlp.tools.cmdline.namefind;

import java.io.OutputStream;
import java.util.Comparator;
import java.util.Map;
import opennlp.tools.cmdline.FineGrainedReportListener;
import opennlp.tools.log.LogPrintStream;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.TokenNameFinderEvaluationMonitor;
import opennlp.tools.util.SequenceCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenNameFinderFineGrainedReportListener extends FineGrainedReportListener implements TokenNameFinderEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokenNameFinderFineGrainedReportListener.class);
    private final SequenceCodec<String> sequenceCodec;

    public TokenNameFinderFineGrainedReportListener(SequenceCodec<String> sequenceCodec) {
        this(sequenceCodec, new LogPrintStream(logger));
    }

    private void statsAdd(NameSample nameSample, NameSample nameSample2) {
        getStats().add(new String[nameSample.getSentence().length], this.sequenceCodec.encode(nameSample.getNames(), nameSample.getSentence().length), this.sequenceCodec.encode(nameSample2.getNames(), nameSample2.getSentence().length));
    }

    @Override // opennlp.tools.cmdline.FineGrainedReportListener
    public Comparator<String> getLabelComparator(Map<String, FineGrainedReportListener.Counter> map) {
        return new FineGrainedReportListener.GroupedLabelComparator(map);
    }

    @Override // opennlp.tools.cmdline.FineGrainedReportListener
    public Comparator<String> getMatrixLabelComparator(Map<String, FineGrainedReportListener.ConfusionMatrixLine> map) {
        return new FineGrainedReportListener.GroupedMatrixLabelComparator(map);
    }

    @Override // opennlp.tools.cmdline.FineGrainedReportListener
    public void writeReport() {
        printGeneralStatistics();
        printTagsErrorRank();
        printGeneralConfusionTable();
    }

    public TokenNameFinderFineGrainedReportListener(SequenceCodec<String> sequenceCodec, OutputStream outputStream) {
        super(outputStream);
        this.sequenceCodec = sequenceCodec;
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void correctlyClassified(NameSample nameSample, NameSample nameSample2) {
        statsAdd(nameSample, nameSample2);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(NameSample nameSample, NameSample nameSample2) {
        statsAdd(nameSample, nameSample2);
    }
}
