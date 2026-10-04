package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class AnchorHandler implements CommandHandler {
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        ArgumentContainerToken argumentContainerToken = commandToken.getArguments()[0];
        String strValidateXMLId = dOMBuilder.validateXMLId(element, argumentContainerToken, dOMBuilder.extractStringValue(argumentContainerToken));
        if (strValidateXMLId != null) {
            Element elementAppendXHTMLElement = dOMBuilder.appendXHTMLElement(element, "a");
            elementAppendXHTMLElement.setAttribute("id", strValidateXMLId);
            elementAppendXHTMLElement.setIdAttribute("id", true);
        }
    }
}
