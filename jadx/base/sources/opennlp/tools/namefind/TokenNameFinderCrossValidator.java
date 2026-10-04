package opennlp.tools.namefind;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.commons.Sample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenNameFinderCrossValidator {
    private TokenNameFinderFactory factory;
    private final byte[] featureGeneratorBytes;
    private final FMeasure fmeasure;
    private final String languageCode;
    private final TokenNameFinderEvaluationMonitor[] listeners;
    private final TrainingParameters params;
    private final Map<String, Object> resources;
    private final String type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DocumentSample extends AbstractC12991c implements Sample {
        private static final long serialVersionUID = -4199121634493414749L;
        private final NameSample[] samples;

        public /* synthetic */ DocumentSample(NameSample[] nameSampleArr, int i) {
            this(nameSampleArr);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof DocumentSample) && Objects.equals(this.samples, ((DocumentSample) obj).samples);
        }

        public final int hashCode() {
            return Objects.hashCode(this.samples);
        }

        public NameSample[] samples() {
            return this.samples;
        }

        public final String toString() {
            Object[] objArr = {this.samples};
            String[] strArrSplit = "samples".length() == 0 ? new String[0] : "samples".split(";");
            StringBuilder sb = new StringBuilder();
            sb.append(DocumentSample.class.getSimpleName());
            sb.append("[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(SQLKeyword.COMMA);
                }
            }
            sb.append("]");
            return sb.toString();
        }

        private DocumentSample(NameSample[] nameSampleArr) {
            this.samples = nameSampleArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DocumentToNameSampleStream extends FilterObjectStream<DocumentSample, NameSample> {
        private Iterator<NameSample> documentSamples;

        public DocumentToNameSampleStream(ObjectStream<DocumentSample> objectStream) {
            super(objectStream);
            this.documentSamples = Collections.emptyIterator();
        }

        @Override // opennlp.tools.util.ObjectStream
        public NameSample read() {
            if (this.documentSamples.hasNext()) {
                return this.documentSamples.next();
            }
            DocumentSample documentSample = (DocumentSample) this.samples.read();
            if (documentSample == null) {
                return null;
            }
            this.documentSamples = Arrays.asList(documentSample.samples()).iterator();
            return read();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NameToDocumentSampleStream extends FilterObjectStream<NameSample, DocumentSample> {
        private NameSample beginSample;

        public NameToDocumentSampleStream(ObjectStream<NameSample> objectStream) {
            super(objectStream);
        }

        @Override // opennlp.tools.util.FilterObjectStream, opennlp.tools.util.ObjectStream
        public void reset() {
            super.reset();
            this.beginSample = null;
        }

        @Override // opennlp.tools.util.ObjectStream
        public DocumentSample read() {
            NameSample nameSample;
            ArrayList arrayList = new ArrayList();
            if (this.beginSample == null) {
                this.beginSample = (NameSample) this.samples.read();
            }
            NameSample nameSample2 = this.beginSample;
            if (nameSample2 == null) {
                return null;
            }
            arrayList.add(nameSample2);
            while (true) {
                nameSample = (NameSample) this.samples.read();
                if (nameSample == null) {
                    break;
                }
                if (nameSample.isClearAdaptiveDataSet()) {
                    this.beginSample = nameSample;
                    break;
                }
                arrayList.add(nameSample);
            }
            if (nameSample == null) {
                this.beginSample = null;
            }
            return new DocumentSample((NameSample[]) arrayList.toArray(new NameSample[0]), 0);
        }
    }

    public TokenNameFinderCrossValidator(String str, String str2, TrainingParameters trainingParameters, byte[] bArr, Map<String, Object> map, SequenceCodec<String> sequenceCodec, TokenNameFinderEvaluationMonitor... tokenNameFinderEvaluationMonitorArr) {
        this.fmeasure = new FMeasure();
        this.languageCode = str;
        this.type = str2;
        this.featureGeneratorBytes = bArr;
        this.resources = map;
        this.params = trainingParameters;
        this.listeners = tokenNameFinderEvaluationMonitorArr;
    }

    public void evaluate(ObjectStream<NameSample> objectStream, int i) {
        CrossValidationPartitioner crossValidationPartitioner = new CrossValidationPartitioner(new NameToDocumentSampleStream(objectStream), i);
        while (crossValidationPartitioner.hasNext()) {
            CrossValidationPartitioner.TrainingSampleStream next = crossValidationPartitioner.next();
            TokenNameFinderEvaluator tokenNameFinderEvaluator = new TokenNameFinderEvaluator(new NameFinderME(this.factory != null ? NameFinderME.train(this.languageCode, this.type, new DocumentToNameSampleStream(next), this.params, this.factory) : NameFinderME.train(this.languageCode, this.type, new DocumentToNameSampleStream(next), this.params, TokenNameFinderFactory.create(null, this.featureGeneratorBytes, this.resources, new BioCodec()))), this.listeners);
            tokenNameFinderEvaluator.evaluate(new DocumentToNameSampleStream(next.getTestSampleStream()));
            this.fmeasure.mergeInto(tokenNameFinderEvaluator.getFMeasure());
        }
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }

    public TokenNameFinderCrossValidator(String str, String str2, TrainingParameters trainingParameters, byte[] bArr, Map<String, Object> map, TokenNameFinderEvaluationMonitor... tokenNameFinderEvaluationMonitorArr) {
        this(str, str2, trainingParameters, bArr, map, new BioCodec(), tokenNameFinderEvaluationMonitorArr);
    }

    public TokenNameFinderCrossValidator(String str, String str2, TrainingParameters trainingParameters, TokenNameFinderFactory tokenNameFinderFactory, TokenNameFinderEvaluationMonitor... tokenNameFinderEvaluationMonitorArr) {
        this(str, str2, trainingParameters, null, null, new BioCodec(), tokenNameFinderEvaluationMonitorArr);
        this.factory = tokenNameFinderFactory;
    }
}
