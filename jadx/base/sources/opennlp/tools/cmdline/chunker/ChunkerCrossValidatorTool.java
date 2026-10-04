package opennlp.tools.cmdline.chunker;

import java.io.IOException;
import java.util.LinkedList;
import opennlp.tools.chunker.ChunkSample;
import opennlp.tools.chunker.ChunkerCrossValidator;
import opennlp.tools.chunker.ChunkerEvaluationMonitor;
import opennlp.tools.chunker.ChunkerFactory;
import opennlp.tools.cmdline.AbstractCrossValidatorTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.params.CVParams;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ChunkerCrossValidatorTool extends AbstractCrossValidatorTool<ChunkSample, CVToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ChunkerCrossValidatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CVToolParams extends TrainingParams, CVParams {
    }

    public ChunkerCrossValidatorTool() {
        super(ChunkSample.class, CVToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "K-fold cross validator for the chunker";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((CVToolParams) this.params).getParams(), false);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        LinkedList linkedList = new LinkedList();
        if (((CVToolParams) this.params).getMisclassified().booleanValue()) {
            linkedList.add(new ChunkEvaluationErrorListener());
        }
        try {
            try {
                ChunkerCrossValidator chunkerCrossValidator = new ChunkerCrossValidator(((CVToolParams) this.params).getLang(), this.mlParams, ChunkerFactory.create(((CVToolParams) this.params).getFactory()), (ChunkerEvaluationMonitor[]) linkedList.toArray(new ChunkerEvaluationMonitor[0]));
                chunkerCrossValidator.evaluate(this.sampleStream, ((CVToolParams) this.params).getFolds().intValue());
                logger.info(chunkerCrossValidator.getFMeasure().toString());
            } finally {
                try {
                    this.sampleStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (IOException e) {
            throw createTerminationIOException(e);
        }
    }
}
