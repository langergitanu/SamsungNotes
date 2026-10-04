package opennlp.tools.cmdline.parser;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractEvaluatorTool;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EvaluatorParams;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserEvaluationMonitor;
import opennlp.tools.parser.ParserEvaluator;
import opennlp.tools.parser.ParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserEvaluatorTool extends AbstractEvaluatorTool<Parse, EvaluatorParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ParserEvaluatorTool.class);

    public ParserEvaluatorTool() {
        super(Parse.class, EvaluatorParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Measures the performance of the Parser model with the reference data";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        ParserEvaluator parserEvaluator = new ParserEvaluator(ParserFactory.create(new ParserModelLoader().load(((EvaluatorParams) this.params).getModel())), new ParserEvaluationMonitor[0]);
        logger.info("Evaluating ... ");
        try {
            try {
                parserEvaluator.evaluate(this.sampleStream);
                Logger logger2 = logger;
                logger2.info(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
                logger2.info(parserEvaluator.getFMeasure().toString());
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
