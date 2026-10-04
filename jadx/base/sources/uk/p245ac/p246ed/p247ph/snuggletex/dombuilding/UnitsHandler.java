package uk.p245ac.p246ed.p247ph.snuggletex.dombuilding;

import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.vladsch.flexmark.util.html.Attribute;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.DOMBuilder;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.CommandToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class UnitsHandler implements CommandHandler {
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.dombuilding.CommandHandler
    public void handleCommand(DOMBuilder dOMBuilder, Element element, CommandToken commandToken) {
        Element elementAppendMathMLIdentifierElement = dOMBuilder.appendMathMLIdentifierElement(element, dOMBuilder.extractStringValue(commandToken.getArguments()[0]));
        elementAppendMathMLIdentifierElement.setAttribute("mathvariant", FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL);
        elementAppendMathMLIdentifierElement.setAttribute(Attribute.CLASS_ATTR, "MathML-Unit");
    }
}
