package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import com.vladsch.flexmark.util.html.Attribute;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ErrorToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class VerbatimHandler implements CommandHandler, EnvironmentHandler {
    private final boolean starred;

    public VerbatimHandler(boolean z) {
        this.starred = z;
    }

    private void appendEmbeddedErrors(DOMBuilder dOMBuilder, Element element, ArgumentContainerToken argumentContainerToken) {
        for (FlowToken flowToken : argumentContainerToken.getContents()) {
            if (flowToken.getType() == TokenType.ERROR) {
                dOMBuilder.appendErrorElement(element, (ErrorToken) flowToken);
            }
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        ArgumentContainerToken argumentContainerToken = commandToken.getArguments()[0];
        String string = argumentContainerToken.getSlice().extract().toString();
        String strReplace = this.starred ? string.replace(' ', (char) 9251) : string.replace(' ', (char) 160);
        Element elementAppendXHTMLElement = dOMBuilder.appendXHTMLElement(element, "span");
        elementAppendXHTMLElement.setAttribute(Attribute.CLASS_ATTR, "verb");
        dOMBuilder.appendTextNode(elementAppendXHTMLElement, strReplace, false);
        appendEmbeddedErrors(dOMBuilder, element, argumentContainerToken);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        String string = environmentToken.getContent().getSlice().extract().toString();
        Element elementAppendXHTMLElement = dOMBuilder.appendXHTMLElement(element, "pre");
        elementAppendXHTMLElement.setAttribute(Attribute.CLASS_ATTR, "verbatim");
        dOMBuilder.appendTextNode(elementAppendXHTMLElement, string, false);
        appendEmbeddedErrors(dOMBuilder, element, environmentToken.getContent());
    }
}
