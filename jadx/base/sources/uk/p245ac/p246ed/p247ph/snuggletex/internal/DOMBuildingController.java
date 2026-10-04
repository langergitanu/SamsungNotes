package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMPostProcessor;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleConstants;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class DOMBuildingController {
    private final DOMOutputOptions options;
    private final SessionContext sessionContext;

    public DOMBuildingController(SessionContext sessionContext, DOMOutputOptions dOMOutputOptions) {
        this.sessionContext = sessionContext;
        this.options = dOMOutputOptions;
    }

    public void buildDOMSubtree(Element element, List<FlowToken> list) {
        Element element2;
        DOMPostProcessor[] dOMPostProcessors = this.options.getDOMPostProcessors();
        if (dOMPostProcessors == null || dOMPostProcessors.length <= 0) {
            new DOMBuilder(this.sessionContext, element, this.options).buildDOMSubtree(list);
            return;
        }
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        Element elementCreateElementNS = documentNewDocument.createElementNS(SnuggleConstants.SNUGGLETEX_NAMESPACE, "root");
        documentNewDocument.appendChild(elementCreateElementNS);
        new DOMBuilder(this.sessionContext, elementCreateElementNS, this.options).buildDOMSubtree(list);
        for (int i = 0; i < dOMPostProcessors.length; i++) {
            Document documentPostProcessDOM = dOMPostProcessors[i].postProcessDOM(documentNewDocument, this.options, this.sessionContext.getStylesheetManager());
            if (i == dOMPostProcessors.length - 1) {
                element2 = element;
            } else {
                NodeList childNodes = elementCreateElementNS.getChildNodes();
                for (int length = childNodes.getLength() - 1; length >= 0; length--) {
                    elementCreateElementNS.removeChild(childNodes.item(length));
                }
                element2 = elementCreateElementNS;
            }
            NodeList childNodes2 = documentPostProcessDOM.getDocumentElement().getChildNodes();
            int length2 = childNodes2.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                element2.appendChild(element2.getOwnerDocument().adoptNode(childNodes2.item(0)));
            }
        }
    }
}
