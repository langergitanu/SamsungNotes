package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class SimpleXHTMLContainerBuildingHandler implements CommandHandler, EnvironmentHandler {
    private final String cssClassName;
    private final String xhtmlElementName;

    public SimpleXHTMLContainerBuildingHandler(String str) {
        this(str, null);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        handleContent(dOMBuilder, element, commandToken.getArguments()[0]);
    }

    public void handleContent(DOMBuilder dOMBuilder, Element element, ArgumentContainerToken argumentContainerToken) {
        Element elementAppendXHTMLElement = dOMBuilder.appendXHTMLElement(element, this.xhtmlElementName);
        String str = this.cssClassName;
        if (str != null) {
            dOMBuilder.applyCSSStyle(elementAppendXHTMLElement, str);
        }
        dOMBuilder.handleTokens(elementAppendXHTMLElement, argumentContainerToken.getContents(), true);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        handleContent(dOMBuilder, element, environmentToken.getContent());
    }

    public SimpleXHTMLContainerBuildingHandler(String str, String str2) {
        this.xhtmlElementName = str;
        this.cssClassName = str2;
    }
}
