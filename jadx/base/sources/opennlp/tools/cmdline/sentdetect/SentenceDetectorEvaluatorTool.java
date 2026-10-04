package opennlp.tools.cmdline.sentdetect;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractEvaluatorTool;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EvaluatorParams;
import opennlp.tools.sentdetect.SentenceDetectorEvaluator;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SentenceDetectorEvaluatorTool extends AbstractEvaluatorTool<SentenceSample, EvalToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SentenceDetectorEvaluatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EvalToolParams extends EvaluatorParams {
    }

    public SentenceDetectorEvaluatorTool() {
        super(SentenceSample.class, EvalToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Measures the performance of the learnable sentence detector";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        SentenceDetectorEvaluator sentenceDetectorEvaluator = new SentenceDetectorEvaluator(new SentenceDetectorME(new SentenceModelLoader().load(((EvalToolParams) this.params).getModel())), ((EvalToolParams) this.params).getMisclassified().booleanValue() ? new SentenceEvaluationErrorListener() : null);
        logger.info("Evaluating ... ");
        try {
            try {
                sentenceDetectorEvaluator.evaluate(this.sampleStream);
                Logger logger2 = logger;
                logger2.info(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
                logger2.info(sentenceDetectorEvaluator.getFMeasure().toString());
            } catch (IOException e) {
                throw new TerminateToolException(-1, "IO error while reading training data or indexing data: " + e.getMessage(), e);
            }
        } finally {
            try {
                this.sampleStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
