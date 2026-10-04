package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import org.w3c.dom.Element;
import p001A.AbstractC0000a;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.ArgumentContainerToken;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class XMLNameOrIdHandler implements CommandHandler {

    /* JADX INFO: renamed from: ID */
    public static final int f10296ID = 1;
    public static final int NAME = 0;
    private final int checkType;

    public XMLNameOrIdHandler(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Bad check type "));
        }
        this.checkType = i;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        ArgumentContainerToken argumentContainerToken = commandToken.getArguments()[0];
        String strTrim = argumentContainerToken.getSlice().extract().toString().trim();
        if ((this.checkType == 1 ? dOMBuilder.validateXMLId(element, argumentContainerToken, strTrim) : dOMBuilder.validateXMLName(element, argumentContainerToken, strTrim)) != null) {
            dOMBuilder.appendTextNode(element, strTrim, true);
        }
    }
}
