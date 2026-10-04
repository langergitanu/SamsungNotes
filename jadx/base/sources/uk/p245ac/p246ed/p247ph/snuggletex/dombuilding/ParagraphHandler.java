package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.List;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class ParagraphHandler implements CommandHandler {
    private void buildParagraph(DOMBuilder dOMBuilder, Element element, List<FlowToken> list) {
        boolean z;
        if (dOMBuilder.isBuildingMathMLIsland()) {
            z = true;
        } else {
            element = dOMBuilder.appendXHTMLElement(element, "p");
            z = false;
        }
        dOMBuilder.handleTokens(element, list, !z);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        buildParagraph(dOMBuilder, element, commandToken.getArguments()[0].getContents());
    }
}
