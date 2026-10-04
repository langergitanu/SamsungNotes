package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CombinerTargetMatcher;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.StringUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.MathBracketInterpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathFenceHandler implements EnvironmentHandler {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BracketCombinerTargetMatcher implements CombinerTargetMatcher {
        @Override // uk.p245ac.p246ed.p247ph.snuggletex.definitions.CombinerTargetMatcher
        public boolean isAllowed(FlowToken flowToken) {
            return flowToken.hasInterpretationType(InterpretationType.MATH_BRACKET) || flowToken.getMathCharacterCodePoint() == 46;
        }
    }

    private String getBracket(ArgumentContainerToken argumentContainerToken) {
        List<FlowToken> contents = argumentContainerToken.getContents();
        String chars = null;
        if (contents.isEmpty()) {
            return null;
        }
        FlowToken flowToken = contents.get(0);
        InterpretationType interpretationType = InterpretationType.MATH_BRACKET;
        if (flowToken.hasInterpretationType(interpretationType)) {
            chars = ((MathBracketInterpretation) flowToken.getInterpretation(interpretationType)).getMfencedAttributeCharacter().getChars();
        } else if (flowToken.getMathCharacterCodePoint() == 46) {
            chars = "";
        }
        if (chars != null) {
            return chars;
        }
        throw new SnuggleLogicException("Bracket combiner was not of the expected form");
    }

    private void makeBracketed(DOMBuilder dOMBuilder, Element element, ArgumentContainerToken argumentContainerToken, String str, String str2) {
        Element elementAppendMathMLElement = dOMBuilder.appendMathMLElement(element, "mrow");
        if (str != null) {
            dOMBuilder.appendMathMLOperatorElement(elementAppendMathMLElement, str);
        }
        Iterator<FlowToken> it = argumentContainerToken.iterator();
        while (it.hasNext()) {
            dOMBuilder.handleToken(elementAppendMathMLElement, it.next());
        }
        if (str2 != null) {
            dOMBuilder.appendMathMLOperatorElement(elementAppendMathMLElement, str2);
        }
    }

    private void makeFenceGroup(DOMBuilder dOMBuilder, Element element, List<FlowToken> list) {
        dOMBuilder.handleMathTokensAsSingleElement(element, list);
    }

    private void makeMfenced(DOMBuilder dOMBuilder, Element element, ArgumentContainerToken argumentContainerToken, String str, String str2) {
        Element elementAppendMathMLElement = dOMBuilder.appendMathMLElement(element, "mfenced");
        elementAppendMathMLElement.setAttribute(AbstractCircuitBreaker.PROPERTY_NAME, StringUtilities.emptyIfNull(str));
        elementAppendMathMLElement.setAttribute("close", StringUtilities.emptyIfNull(str2));
        ArrayList arrayList = new ArrayList();
        for (FlowToken flowToken : argumentContainerToken) {
            if (flowToken.getMathCharacterCodePoint() == 44) {
                makeFenceGroup(dOMBuilder, elementAppendMathMLElement, arrayList);
                arrayList.clear();
            } else {
                arrayList.add(flowToken);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        makeFenceGroup(dOMBuilder, elementAppendMathMLElement, arrayList);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        ArgumentContainerToken content = environmentToken.getContent();
        String bracket = getBracket(environmentToken.getArguments()[0]);
        String bracket2 = getBracket(environmentToken.getArguments()[1]);
        if (bracket == null || bracket2 == null) {
            makeBracketed(dOMBuilder, element, content, bracket, bracket2);
        } else {
            makeMfenced(dOMBuilder, element, content, bracket, bracket2);
        }
    }
}
