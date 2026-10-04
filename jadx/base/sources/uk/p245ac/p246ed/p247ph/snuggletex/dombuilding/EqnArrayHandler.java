package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.List;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class EqnArrayHandler implements EnvironmentHandler {
    static final String[] COLUMN_ALIGNMENTS = {"right", "center", "left"};

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(final DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        final int i = TabularHandler.computeTableDimensions(environmentToken.getContent())[1];
        if (i > 3) {
            dOMBuilder.appendOrThrowError(element, environmentToken, CoreErrorCode.TDEM01, Integer.valueOf(i));
        } else {
            dOMBuilder.buildMathElement(element, environmentToken, environmentToken.getContent(), true, new DOMBuilder.MathContentBuilderCallback() { // from class: uk.ac.ed.ph.snuggletex.dombuilding.EqnArrayHandler.1
                @Override // uk.ac.ed.ph.snuggletex.internal.DOMBuilder.MathContentBuilderCallback
                public void buildMathElementContent(Element element2, ArgumentContainerToken argumentContainerToken, boolean z) {
                    Element elementAppendMathMLElement = dOMBuilder.appendMathMLElement(element2, "mtable");
                    for (FlowToken flowToken : argumentContainerToken) {
                        Element elementAppendMathMLElement2 = dOMBuilder.appendMathMLElement(elementAppendMathMLElement, "mtr");
                        List<FlowToken> contents = ((CommandToken) flowToken).getArguments()[0].getContents();
                        int i2 = 0;
                        for (FlowToken flowToken2 : contents) {
                            Element elementAppendMathMLElement3 = dOMBuilder.appendMathMLElement(elementAppendMathMLElement2, "mtd");
                            elementAppendMathMLElement3.setAttribute("columnalign", EqnArrayHandler.COLUMN_ALIGNMENTS[i2]);
                            dOMBuilder.handleTokens(elementAppendMathMLElement3, ((CommandToken) flowToken2).getArguments()[0].getContents(), true);
                            i2++;
                        }
                        for (int i4 = 0; i4 < i - contents.size(); i4++) {
                            dOMBuilder.appendMathMLElement(elementAppendMathMLElement2, "mtd");
                        }
                    }
                }
            });
        }
    }
}
