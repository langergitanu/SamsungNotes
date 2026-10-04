package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.List;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class ListEnvironmentHandler implements EnvironmentHandler, CommandHandler {
    private void handleListContent(DOMBuilder dOMBuilder, Element element, Element element2, List<FlowToken> list) {
        for (FlowToken flowToken : list) {
            if (flowToken.isCommand(CorePackageDefinitions.CMD_LIST_ITEM)) {
                handleListItem(dOMBuilder, element2, (CommandToken) flowToken);
            } else {
                if (flowToken.getType() != TokenType.ERROR) {
                    throw new SnuggleLogicException("List environments can only contain list items - this should have been handled earlier");
                }
                dOMBuilder.handleToken(element, flowToken);
            }
        }
    }

    private void handleListItem(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        dOMBuilder.handleTokens(dOMBuilder.appendXHTMLElement(element, "li"), commandToken.getArguments()[0], true);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        if (commandToken.isCommand(CorePackageDefinitions.CMD_LIST_ITEM)) {
            throw new SnuggleLogicException("List item outside environment - this should not have occurred");
        }
        if (commandToken.isCommand(CorePackageDefinitions.CMD_ITEM)) {
            dOMBuilder.appendOrThrowError(element, commandToken, CoreErrorCode.TDEL00, new Object[0]);
        }
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        String str;
        BuiltinEnvironment environment = environmentToken.getEnvironment();
        if (environment == CorePackageDefinitions.ENV_ITEMIZE) {
            str = "ul";
        } else {
            if (environment != CorePackageDefinitions.ENV_ENUMERATE) {
                throw new SnuggleLogicException("No logic to handle list environment " + environment.getTeXName());
            }
            str = "ol";
        }
        handleListContent(dOMBuilder, element, dOMBuilder.appendXHTMLElement(element, str), environmentToken.getContent().getContents());
    }
}
