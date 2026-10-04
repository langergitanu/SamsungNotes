package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.List;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathNegatableInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathNotHandler implements CommandHandler {
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        List<FlowToken> contents = commandToken.getCombinerTarget().getContents();
        if (contents.size() != 1) {
            throw new SnuggleLogicException("Expeted combiner of \\not to contain exactly 1 Token");
        }
        FlowToken flowToken = contents.get(0);
        InterpretationType interpretationType = InterpretationType.MATH_NEGATABLE;
        MathNegatableInterpretation mathNegatableInterpretation = (MathNegatableInterpretation) flowToken.getInterpretation(interpretationType);
        if (mathNegatableInterpretation != null) {
            dOMBuilder.appendMathCharacter(element, mathNegatableInterpretation.getNegatedCharacter());
            return;
        }
        throw new SnuggleLogicException("Expeted combiner of \\not to have a " + interpretationType + " Interpretation");
    }
}
