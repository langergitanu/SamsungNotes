package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.SimpleToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class AbstractCustomXMLElementHandler implements EnvironmentHandler, CommandHandler {
    private void extractAttributes(DOMBuilder dOMBuilder, Element element, Element element2, ArgumentContainerToken argumentContainerToken) {
        for (FlowToken flowToken : argumentContainerToken) {
            if (flowToken.isCommand(CorePackageDefinitions.CMD_XML_ATTR)) {
                CommandToken commandToken = (CommandToken) flowToken;
                element2.setAttributeNS(dOMBuilder.extractStringValue(commandToken.getArguments()[0]), dOMBuilder.extractStringValue(commandToken.getArguments()[1]), dOMBuilder.extractStringValue(commandToken.getArguments()[2]));
            } else if (flowToken.getType() == TokenType.ERROR) {
                dOMBuilder.handleToken(element, flowToken);
            } else if (flowToken.getType() != TokenType.TEXT_MODE_TEXT || !((SimpleToken) flowToken).getSlice().isWhitespace()) {
                dOMBuilder.appendOrThrowError(element, flowToken, CoreErrorCode.TDEX00, new Object[0]);
            }
        }
    }

    public void buildCustomElement(DOMBuilder dOMBuilder, Element element, ArgumentContainerToken argumentContainerToken, ArgumentContainerToken argumentContainerToken2, ArgumentContainerToken argumentContainerToken3, ArgumentContainerToken argumentContainerToken4) {
        String strExtractStringValue = dOMBuilder.extractStringValue(argumentContainerToken2);
        dOMBuilder.validateURI(element, argumentContainerToken2, strExtractStringValue);
        String strExtractStringValue2 = dOMBuilder.extractStringValue(argumentContainerToken3);
        try {
            Element elementCreateElementNS = dOMBuilder.getDocument().createElementNS(strExtractStringValue, strExtractStringValue2);
            element.appendChild(elementCreateElementNS);
            if (argumentContainerToken != null) {
                extractAttributes(dOMBuilder, element, elementCreateElementNS, argumentContainerToken);
            }
            dOMBuilder.handleTokens(elementCreateElementNS, argumentContainerToken4, isBlock());
        } catch (DOMException e) {
            short s = e.code;
            if (s != 5 && s != 14) {
                throw e;
            }
            dOMBuilder.appendOrThrowError(element, argumentContainerToken3, CoreErrorCode.TDEX01, strExtractStringValue2);
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        buildCustomElement(dOMBuilder, element, commandToken.getOptionalArgument(), commandToken.getArguments()[0], commandToken.getArguments()[1], commandToken.getArguments()[2]);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        buildCustomElement(dOMBuilder, element, environmentToken.getOptionalArgument(), environmentToken.getArguments()[0], environmentToken.getArguments()[1], environmentToken.getContent());
    }

    public abstract boolean isBlock();
}
