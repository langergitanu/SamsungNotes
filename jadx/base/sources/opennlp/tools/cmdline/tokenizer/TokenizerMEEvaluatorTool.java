package opennlp.tools.cmdline.tokenizer;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractEvaluatorTool;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EvaluatorParams;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenizerEvaluator;
import opennlp.tools.tokenize.TokenizerME;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenizerMEEvaluatorTool extends AbstractEvaluatorTool<TokenSample, EvalToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokenizerMEEvaluatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EvalToolParams extends EvaluatorParams {
    }

    public TokenizerMEEvaluatorTool() {
        super(TokenSample.class, EvalToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Measures the performance of the learnable tokenizer";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        TokenizerEvaluator tokenizerEvaluator = new TokenizerEvaluator(new TokenizerME(new TokenizerModelLoader().load(((EvalToolParams) this.params).getModel())), ((EvalToolParams) this.params).getMisclassified().booleanValue() ? new TokenEvaluationErrorListener() : null);
        logger.info("Evaluating ... ");
        try {
            try {
                tokenizerEvaluator.evaluate(this.sampleStream);
                Logger logger2 = logger;
                logger2.info(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
                logger2.info(tokenizerEvaluator.getFMeasure().toString());
            } catch (IOException e) {
                throw new TerminateToolException(-1, "IO error while reading test data: " + e.getMessage(), e);
            }
        } finally {
            try {
                this.sampleStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
