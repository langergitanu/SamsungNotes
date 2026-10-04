package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.List;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.AccentMap;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.TokenType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class AccentHandler implements CommandHandler {
    private final AccentMap accentMap;
    private final char combiningCharacter;
    private final String mathMLElementName;

    public AccentHandler(AccentMap accentMap, char c, String str) {
        this.accentMap = accentMap;
        this.combiningCharacter = c;
        this.mathMLElementName = str;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        if (!dOMBuilder.isBuildingMathMLIsland()) {
            handleCommandTextMode(dOMBuilder, element, commandToken);
        } else {
            if (this.mathMLElementName == null) {
                throw new SnuggleLogicException("Unexpected logic branch - unexpected accent found in MATH mode");
            }
            handleCommandMathMode(dOMBuilder, element, commandToken);
        }
    }

    public void handleCommandMathMode(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        char accentedMathChar = 0;
        List<FlowToken> contents = commandToken.getArguments()[0].getContents();
        if (this.accentMap != null && contents.size() == 1 && contents.get(0).hasInterpretationType(InterpretationType.MATH_CHARACTER)) {
            accentedMathChar = this.accentMap.getAccentedMathChar(contents.get(0).getMathCharacter().getCodePoint());
        }
        if (accentedMathChar != 0) {
            dOMBuilder.appendMathMLIdentifierElement(element, Character.toString(accentedMathChar));
            return;
        }
        Element elementAppendMathMLElement = dOMBuilder.appendMathMLElement(element, this.mathMLElementName);
        if (this.mathMLElementName.equals("mover")) {
            elementAppendMathMLElement.setAttribute("accent", "true");
        } else if (this.mathMLElementName.equals("munder")) {
            elementAppendMathMLElement.setAttribute("accentunder", "true");
        }
        dOMBuilder.handleMathTokensAsSingleElement(elementAppendMathMLElement, contents);
        dOMBuilder.appendMathMLOperatorElement(elementAppendMathMLElement, Character.toString(this.combiningCharacter));
    }

    public void handleCommandTextMode(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        List<FlowToken> contents = commandToken.getArguments()[0].getContents();
        if (contents.size() == 1 && contents.get(0).getType() != TokenType.TEXT_MODE_TEXT) {
            dOMBuilder.appendOrThrowError(element, commandToken, CoreErrorCode.TDETA0, new Object[0]);
            return;
        }
        CharSequence charSequenceExtract = contents.isEmpty() ? null : contents.get(0).getSlice().extract();
        if (charSequenceExtract == null || charSequenceExtract.length() == 0) {
            dOMBuilder.appendOrThrowError(element, commandToken, CoreErrorCode.TDETA1, new Object[0]);
            return;
        }
        char cCharAt = charSequenceExtract.charAt(0);
        char accentedTextChar = this.accentMap.getAccentedTextChar(cCharAt);
        if (accentedTextChar == 0) {
            dOMBuilder.appendOrThrowError(element, commandToken, CoreErrorCode.TDETA2, Character.toString(cCharAt));
            return;
        }
        dOMBuilder.appendTextNode(element, accentedTextChar + charSequenceExtract.subSequence(1, charSequenceExtract.length()).toString(), false);
    }

    public AccentHandler(AccentMap accentMap) {
        this(accentMap, (char) 0, null);
    }
}
