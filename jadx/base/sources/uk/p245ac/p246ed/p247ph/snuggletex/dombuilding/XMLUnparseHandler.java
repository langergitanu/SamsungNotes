package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import com.vladsch.flexmark.util.html.Attribute;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.SerializationOptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class XMLUnparseHandler implements EnvironmentHandler, CommandHandler {
    private void handle(DOMBuilder dOMBuilder, Element element, ArgumentContainerToken argumentContainerToken, boolean z) {
        dOMBuilder.handleTokens(element, argumentContainerToken, true);
        SerializationOptions serializationOptions = new SerializationOptions();
        serializationOptions.setIndenting(z);
        serializationOptions.setEncoding("UTF-8");
        String strSerializeNodeChildren = XMLUtilities.serializeNodeChildren(dOMBuilder.getSessionContext().getStylesheetManager(), element, serializationOptions);
        NodeList childNodes = element.getChildNodes();
        for (int length = childNodes.getLength() - 1; length >= 0; length--) {
            element.removeChild(childNodes.item(length));
        }
        dOMBuilder.appendXHTMLTextElement(element, z ? "pre" : "span", strSerializeNodeChildren, true).setAttribute(Attribute.CLASS_ATTR, "unparsed-xml");
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        handle(dOMBuilder, element, commandToken.getArguments()[0], false);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        handle(dOMBuilder, element, environmentToken.getContent(), true);
    }
}
