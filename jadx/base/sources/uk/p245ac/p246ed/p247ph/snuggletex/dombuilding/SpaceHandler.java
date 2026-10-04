package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SpaceHandler implements CommandHandler {
    private final String mathWidth;
    private final String textString;

    public SpaceHandler(String str, String str2) {
        this.textString = str;
        this.mathWidth = str2;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        if (commandToken.getLatexMode() == LaTeXMode.MATH) {
            if (this.mathWidth != null) {
                dOMBuilder.appendMathMLElement(element, "mspace").setAttribute("width", this.mathWidth);
                return;
            }
            throw new SnuggleLogicException("Spacing token " + commandToken + " expectedly used in MATH mode");
        }
        String str = this.textString;
        if (str != null) {
            dOMBuilder.appendTextNode(element, str, false);
            return;
        }
        throw new SnuggleLogicException("Spacing token " + commandToken + " expectedly used in TEXT mode");
    }
}
