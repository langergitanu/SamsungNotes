package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.List;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MatrixHandler implements EnvironmentHandler {
    private final String closer;
    private final int maxColumns;
    private final String opener;

    public MatrixHandler() {
        this(0, null, null);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        if (this.opener != null) {
            element = dOMBuilder.appendMathMLElement(element, "mfenced");
            element.setAttribute(AbstractCircuitBreaker.PROPERTY_NAME, this.opener);
            element.setAttribute("close", this.closer);
        }
        int i = TabularHandler.computeTableDimensions(environmentToken.getContent())[1];
        Element elementAppendMathMLElement = dOMBuilder.appendMathMLElement(element, "mtable");
        for (FlowToken flowToken : environmentToken.getContent()) {
            Element elementAppendMathMLElement2 = dOMBuilder.appendMathMLElement(elementAppendMathMLElement, "mtr");
            List<FlowToken> contents = ((CommandToken) flowToken).getArguments()[0].getContents();
            int size = contents.size();
            int i2 = this.maxColumns;
            if (i2 <= 0 || size <= i2) {
                for (int i4 = 0; i4 < i && i4 < size; i4++) {
                    dOMBuilder.handleTokens(dOMBuilder.appendMathMLElement(elementAppendMathMLElement2, "mtd"), ((CommandToken) contents.get(i4)).getArguments()[0].getContents(), true);
                }
                for (int i5 = 0; i5 < i - size; i5++) {
                    dOMBuilder.appendMathMLElement(elementAppendMathMLElement2, "mtd");
                }
            } else {
                dOMBuilder.appendOrThrowError(elementAppendMathMLElement2, flowToken, CoreErrorCode.TDEMM0, environmentToken.getEnvironment().getTeXName(), Integer.valueOf(this.maxColumns));
            }
        }
    }

    public MatrixHandler(String str, String str2) {
        this(0, str, str2);
    }

    public MatrixHandler(int i, String str, String str2) {
        this.maxColumns = i;
        this.opener = str;
        this.closer = str2;
    }
}
