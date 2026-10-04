package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMPostProcessor;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class MathMLPostProcessor implements DOMPostProcessor {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DocumentWalker {
        private final Document inputDocument;
        private Node inputNode;
        private int mathmlCounter;
        private final Document outputDocument;
        private Node outputParentNode;

        public DocumentWalker(Document document, Document document2) {
            this.inputDocument = document;
            this.outputDocument = document2;
        }

        public void run() {
            this.outputParentNode = this.outputDocument;
            this.inputNode = this.inputDocument.getFirstChild();
            this.mathmlCounter = 0;
            while (true) {
                Node node = this.inputNode;
                if (node == null) {
                    return;
                }
                if (MathMLUtilities.isMathMLElement(node, "math")) {
                    MathMLPostProcessor mathMLPostProcessor = MathMLPostProcessor.this;
                    Element element = (Element) this.inputNode;
                    Document document = this.outputDocument;
                    Node node2 = this.outputParentNode;
                    int i = this.mathmlCounter;
                    this.mathmlCounter = i + 1;
                    mathMLPostProcessor.handleMathMLIsland(element, document, node2, i);
                } else {
                    Node nodeAdoptNode = this.outputDocument.adoptNode(this.inputNode.cloneNode(false));
                    this.outputParentNode.appendChild(nodeAdoptNode);
                    if (this.inputNode.hasChildNodes()) {
                        this.inputNode = this.inputNode.getFirstChild();
                        this.outputParentNode = nodeAdoptNode;
                    }
                }
                Node nextSibling = this.inputNode.getNextSibling();
                while (nextSibling == null) {
                    Node parentNode = this.inputNode.getParentNode();
                    this.inputNode = parentNode;
                    if (parentNode == null) {
                        break;
                    }
                    nextSibling = parentNode.getNextSibling();
                    this.outputParentNode = this.outputParentNode.getParentNode();
                }
                this.inputNode = nextSibling;
            }
        }
    }

    public abstract void handleMathMLIsland(Element element, Document document, Node node, int i);

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.DOMPostProcessor
    public final Document postProcessDOM(Document document, DOMOutputOptions dOMOutputOptions, StylesheetManager stylesheetManager) {
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        new DocumentWalker(document, documentNewDocument).run();
        return documentNewDocument;
    }
}
