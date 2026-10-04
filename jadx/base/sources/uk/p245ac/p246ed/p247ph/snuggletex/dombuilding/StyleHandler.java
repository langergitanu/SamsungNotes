package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.Iterator;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.ComputedStyle;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class StyleHandler implements EnvironmentHandler {
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        ComputedStyle computedStyle = environmentToken.getComputedStyle();
        ArgumentContainerToken content = environmentToken.getContent();
        boolean zIsEmpty = content.getContents().isEmpty();
        Iterator<FlowToken> it = content.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().getTextFlowContext() == TextFlowContext.START_NEW_XHTML_BLOCK) {
                z = true;
            }
        }
        dOMBuilder.handleTokens(dOMBuilder.openStyle(element, computedStyle, z, zIsEmpty), content, false);
        dOMBuilder.closeStyle();
    }
}
