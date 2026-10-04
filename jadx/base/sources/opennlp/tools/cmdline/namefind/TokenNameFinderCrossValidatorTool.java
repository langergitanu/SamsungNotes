package opennlp.tools.cmdline.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import opennlp.tools.cmdline.AbstractCrossValidatorTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.CVParams;
import opennlp.tools.cmdline.params.FineGrainedEvaluatorParams;
import opennlp.tools.namefind.BilouCodec;
import opennlp.tools.namefind.BioCodec;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleTypeFilter;
import opennlp.tools.namefind.TokenNameFinderCrossValidator;
import opennlp.tools.namefind.TokenNameFinderEvaluationMonitor;
import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenNameFinderCrossValidatorTool extends AbstractCrossValidatorTool<NameSample, CVToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokenNameFinderCrossValidatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CVToolParams extends TrainingParams, CVParams, FineGrainedEvaluatorParams {
    }

    public TokenNameFinderCrossValidatorTool() {
        super(NameSample.class, CVToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "K-fold cross validator for the learnable Name Finder";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        TokenNameFinderFineGrainedReportListener tokenNameFinderFineGrainedReportListener;
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((CVToolParams) this.params).getParams(), true);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters == null) {
            this.mlParams = new TrainingParameters();
        }
        byte[] bArrOpenFeatureGeneratorBytes = TokenNameFinderTrainerTool.openFeatureGeneratorBytes(((CVToolParams) this.params).getFeaturegen());
        try {
            Map<String, Object> mapLoadResources = TokenNameFinderTrainerTool.loadResources(((CVToolParams) this.params).getResources(), ((CVToolParams) this.params).getFeaturegen());
            if (((CVToolParams) this.params).getNameTypes() != null) {
                this.sampleStream = new NameSampleTypeFilter(((CVToolParams) this.params).getNameTypes().split(","), (ObjectStream<NameSample>) this.sampleStream);
            }
            LinkedList linkedList = new LinkedList();
            if (((CVToolParams) this.params).getMisclassified().booleanValue()) {
                linkedList.add(new NameEvaluationErrorListener());
            }
            String sequenceCodec = ((CVToolParams) this.params).getSequenceCodec();
            if ("BIO".equals(sequenceCodec)) {
                sequenceCodec = BioCodec.class.getName();
            } else if ("BILOU".equals(sequenceCodec)) {
                sequenceCodec = BilouCodec.class.getName();
            }
            try {
                SequenceCodec<String> sequenceCodecInstantiateSequenceCodec = TokenNameFinderFactory.instantiateSequenceCodec(sequenceCodec);
                File reportOutputFile = ((CVToolParams) this.params).getReportOutputFile();
                if (reportOutputFile != null) {
                    CmdLineUtil.checkOutputFile("Report Output File", reportOutputFile);
                    try {
                        tokenNameFinderFineGrainedReportListener = new TokenNameFinderFineGrainedReportListener(sequenceCodecInstantiateSequenceCodec, new FileOutputStream(reportOutputFile));
                        linkedList.add(tokenNameFinderFineGrainedReportListener);
                    } catch (FileNotFoundException e) {
                        throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while creating Name Finder fine-grained report file: ", e.getMessage()));
                    }
                } else {
                    tokenNameFinderFineGrainedReportListener = null;
                }
                try {
                    try {
                        try {
                            TokenNameFinderCrossValidator tokenNameFinderCrossValidator = new TokenNameFinderCrossValidator(((CVToolParams) this.params).getLang(), ((CVToolParams) this.params).getType(), this.mlParams, TokenNameFinderFactory.create(((CVToolParams) this.params).getFactory(), bArrOpenFeatureGeneratorBytes, mapLoadResources, sequenceCodecInstantiateSequenceCodec), (TokenNameFinderEvaluationMonitor[]) linkedList.toArray(new TokenNameFinderEvaluationMonitor[0]));
                            tokenNameFinderCrossValidator.evaluate(this.sampleStream, ((CVToolParams) this.params).getFolds().intValue());
                            try {
                                this.sampleStream.close();
                            } catch (IOException unused) {
                            }
                            Logger logger2 = logger;
                            logger2.info(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
                            if (reportOutputFile != null) {
                                tokenNameFinderFineGrainedReportListener.writeReport();
                            }
                            logger2.info(tokenNameFinderCrossValidator.getFMeasure().toString());
                        } catch (IOException e2) {
                            throw createTerminationIOException(e2);
                        }
                    } finally {
                    }
                } catch (InvalidFormatException e3) {
                    throw new TerminateToolException(-1, e3.getMessage(), e3);
                }
            } catch (InvalidFormatException e5) {
                throw new TerminateToolException(-1, e5.getMessage(), e5);
            }
        } catch (IOException e6) {
            throw new TerminateToolException(-1, "IO error while loading resources", e6);
        }
    }
}
