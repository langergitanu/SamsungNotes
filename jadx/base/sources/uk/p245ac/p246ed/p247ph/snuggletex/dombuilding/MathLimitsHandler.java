package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import java.util.List;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.BuiltinCommand;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CorePackageDefinitions;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathLimitsHandler implements CommandHandler {
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        boolean z;
        String str;
        List<FlowToken> contents = commandToken.getArguments()[0].getContents();
        if (dOMBuilder.getOutputContext() == DOMBuilder.OutputContext.MATHML_BLOCK) {
            z = contents.size() == 1 && contents.get(0).hasInterpretationType(InterpretationType.MATH_BIG_LIMIT_OWNER);
        }
        BuiltinCommand command = commandToken.getCommand();
        if (command.equals(CorePackageDefinitions.CMD_MSUB_OR_MUNDER)) {
            str = z ? "munder" : "msub";
        } else if (command.equals(CorePackageDefinitions.CMD_MSUP_OR_MOVER)) {
            str = z ? "mover" : "msup";
        } else {
            if (!command.equals(CorePackageDefinitions.CMD_MSUBSUP_OR_MUNDEROVER)) {
                throw new SnuggleLogicException("Unexpected limit command " + command);
            }
            str = z ? "munderover" : "msubsup";
        }
        Element elementAppendMathMLElement = dOMBuilder.appendMathMLElement(element, str);
        for (ArgumentContainerToken argumentContainerToken : commandToken.getArguments()) {
            dOMBuilder.handleMathTokensAsSingleElement(elementAppendMathMLElement, argumentContainerToken);
        }
    }
}
