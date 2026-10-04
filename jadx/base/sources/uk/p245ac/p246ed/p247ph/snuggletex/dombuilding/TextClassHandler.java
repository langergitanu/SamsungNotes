package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.Iterator;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class TextClassHandler implements CommandHandler {
    private final String cssClassName;

    public TextClassHandler(String str) {
        this.cssClassName = str;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        if (dOMBuilder.isBuildingMathMLIsland()) {
            throw new SnuggleLogicException("This handler is not intended for use in MathML islands");
        }
        ArgumentContainerToken argumentContainerToken = commandToken.getArguments()[0];
        Iterator<FlowToken> it = argumentContainerToken.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().getTextFlowContext() == TextFlowContext.START_NEW_XHTML_BLOCK) {
                z = true;
            }
        }
        Element elementAppendXHTMLElement = dOMBuilder.appendXHTMLElement(element, z ? "div" : "span");
        dOMBuilder.applyCSSStyle(elementAppendXHTMLElement, this.cssClassName);
        dOMBuilder.handleTokens(elementAppendXHTMLElement, argumentContainerToken, false);
    }
}
