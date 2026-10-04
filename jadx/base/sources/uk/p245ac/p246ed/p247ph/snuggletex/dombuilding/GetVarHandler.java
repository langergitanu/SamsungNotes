package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class GetVarHandler implements CommandHandler {
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        Object variable = dOMBuilder.getVariableManager().getVariable(commandToken.getOptionalArgument() != null ? dOMBuilder.extractStringValue(commandToken.getOptionalArgument()) : null, dOMBuilder.extractStringValue(commandToken.getArguments()[0]));
        if (variable != null) {
            dOMBuilder.appendTextNode(element, variable.toString(), false);
        }
    }
}
