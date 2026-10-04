package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.ArrayList;
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
public final class ArrayHandler implements EnvironmentHandler {
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        int i = TabularHandler.computeTableDimensions(environmentToken.getContent())[1];
        ArgumentContainerToken argumentContainerToken = environmentToken.getArguments()[0];
        CharSequence charSequenceExtract = environmentToken.getArguments()[0].getSlice().extract();
        if (charSequenceExtract.length() == 0) {
            dOMBuilder.appendOrThrowError(element, argumentContainerToken, CoreErrorCode.TDEMA1, new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList(charSequenceExtract.length());
        for (int i2 = 0; i2 < charSequenceExtract.length(); i2++) {
            char cCharAt = charSequenceExtract.charAt(i2);
            if (cCharAt == 'c') {
                arrayList.add("center");
            } else if (cCharAt == 'l') {
                arrayList.add("left");
            } else if (cCharAt != 'r') {
                dOMBuilder.appendOrThrowError(element, argumentContainerToken, CoreErrorCode.TDEMA0, String.valueOf(cCharAt));
                arrayList.add("center");
            } else {
                arrayList.add("right");
            }
        }
        int size = arrayList.size();
        if (size < i) {
            dOMBuilder.appendOrThrowError(element, argumentContainerToken, CoreErrorCode.TDEMA2, Integer.valueOf(charSequenceExtract.length()), Integer.valueOf(i));
        }
        Element elementAppendMathMLElement = dOMBuilder.appendMathMLElement(element, "mtable");
        for (FlowToken flowToken : environmentToken.getContent()) {
            Element elementAppendMathMLElement2 = dOMBuilder.appendMathMLElement(elementAppendMathMLElement, "mtr");
            List<FlowToken> contents = ((CommandToken) flowToken).getArguments()[0].getContents();
            int size2 = contents.size();
            for (int i4 = 0; i4 < size && i4 < size2; i4++) {
                FlowToken flowToken2 = contents.get(i4);
                Element elementAppendMathMLElement3 = dOMBuilder.appendMathMLElement(elementAppendMathMLElement2, "mtd");
                elementAppendMathMLElement3.setAttribute("columnalign", (String) arrayList.get(i4));
                dOMBuilder.handleTokens(elementAppendMathMLElement3, ((CommandToken) flowToken2).getArguments()[0].getContents(), true);
            }
            for (int i5 = 0; i5 < size - size2; i5++) {
                dOMBuilder.appendMathMLElement(elementAppendMathMLElement2, "mtd");
            }
        }
    }
}
