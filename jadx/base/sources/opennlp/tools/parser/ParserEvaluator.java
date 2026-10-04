package opennlp.tools.parser;

import java.util.ArrayList;
import java.util.Stack;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.util.Span;
import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserEvaluator extends Evaluator<Parse> {
    private final FMeasure fmeasure;
    private final Parser parser;

    public ParserEvaluator(Parser parser, ParserEvaluationMonitor... parserEvaluationMonitorArr) {
        super(parserEvaluationMonitorArr);
        this.fmeasure = new FMeasure();
        this.parser = parser;
    }

    private static Span[] getConstituencySpans(Parse parse) {
        Stack stack = new Stack();
        if (parse.getChildCount() > 0) {
            for (Parse parse2 : parse.getChildren()) {
                stack.push(parse2);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!stack.isEmpty()) {
            Parse parse3 = (Parse) stack.pop();
            if (!parse3.isPosTag()) {
                Span span = parse3.getSpan();
                arrayList.add(new Span(span.getStart(), span.getEnd(), parse3.getType()));
                for (Parse parse4 : parse3.getChildren()) {
                    stack.push(parse4);
                }
            }
        }
        return (Span[]) arrayList.toArray(new Span[0]);
    }

    public final FMeasure getFMeasure() {
        return this.fmeasure;
    }

    @Override // opennlp.tools.util.eval.Evaluator
    public final Parse processSample(Parse parse) {
        ArrayList arrayList = new ArrayList();
        for (Parse parse2 : parse.getTokenNodes()) {
            arrayList.add(parse2.getSpan().getCoveredText(parse.getText()).toString());
        }
        Parse[] line = ParserTool.parseLine(String.join(" ", arrayList), this.parser, 1);
        if (line.length <= 0) {
            return null;
        }
        Parse parse3 = line[0];
        this.fmeasure.updateScores(getConstituencySpans(parse), getConstituencySpans(parse3));
        return parse3;
    }
}
