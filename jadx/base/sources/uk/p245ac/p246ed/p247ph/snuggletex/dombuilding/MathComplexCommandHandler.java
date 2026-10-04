package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathComplexCommandHandler implements CommandHandler {
    private final String elementName;

    public MathComplexCommandHandler(String str) {
        this.elementName = str;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        Element elementAppendMathMLElement = dOMBuilder.appendMathMLElement(element, this.elementName);
        for (ArgumentContainerToken argumentContainerToken : commandToken.getArguments()) {
            dOMBuilder.handleMathTokensAsSingleElement(elementAppendMathMLElement, argumentContainerToken);
        }
    }
}
