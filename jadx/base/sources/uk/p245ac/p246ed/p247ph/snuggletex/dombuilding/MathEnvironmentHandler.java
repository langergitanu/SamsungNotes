package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinEnvironment;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.EnvironmentToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathEnvironmentHandler implements EnvironmentHandler {
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.EnvironmentHandler
    public void handleEnvironment(DOMBuilder dOMBuilder, Element element, EnvironmentToken environmentToken) {
        BuiltinEnvironment environment = environmentToken.getEnvironment();
        if (dOMBuilder.isBuildingMathMLIsland()) {
            dOMBuilder.handleTokens(dOMBuilder.appendMathMLElement(element, "mrow"), environmentToken.getContent(), false);
        } else {
            dOMBuilder.buildMathElement(element, environmentToken, environmentToken.getContent(), environment == CorePackageDefinitions.ENV_DISPLAYMATH);
        }
    }
}
