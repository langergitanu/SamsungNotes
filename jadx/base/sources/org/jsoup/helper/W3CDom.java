package org.jsoup.helper;

import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class W3CDom {
    protected DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class W3CBuilder implements NodeVisitor {
        private Element dest;
        private final Document doc;

        public W3CBuilder(Document document) {
            this.doc = document;
        }

        private void copyAttributes(Node node, Element element) {
            for (Attribute attribute : node.attributes()) {
                element.setAttribute(attribute.getKey(), attribute.getValue());
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof org.jsoup.nodes.Element) {
                org.jsoup.nodes.Element element = (org.jsoup.nodes.Element) node;
                Element elementCreateElement = this.doc.createElement(element.tagName());
                copyAttributes(element, elementCreateElement);
                Element element2 = this.dest;
                if (element2 == null) {
                    this.doc.appendChild(elementCreateElement);
                } else {
                    element2.appendChild(elementCreateElement);
                }
                this.dest = elementCreateElement;
                return;
            }
            if (node instanceof TextNode) {
                this.dest.appendChild(this.doc.createTextNode(((TextNode) node).getWholeText()));
            } else if (node instanceof Comment) {
                this.dest.appendChild(this.doc.createComment(((Comment) node).getData()));
            } else if (node instanceof DataNode) {
                this.dest.appendChild(this.doc.createTextNode(((DataNode) node).getWholeData()));
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if ((node instanceof org.jsoup.nodes.Element) && (this.dest.getParentNode() instanceof Element)) {
                this.dest = (Element) this.dest.getParentNode();
            }
        }
    }

    public String asString(Document document) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e) {
            throw new IllegalStateException(e);
        }
    }

    public void convert(org.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.isBlank(document.location())) {
            document2.setDocumentURI(document.location());
        }
        new NodeTraversor(new W3CBuilder(document2)).traverse(document.child(0));
    }

    public Document fromJsoup(org.jsoup.nodes.Document document) {
        Validate.notNull(document);
        try {
            Document documentNewDocument = this.factory.newDocumentBuilder().newDocument();
            convert(document, documentNewDocument);
            return documentNewDocument;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }
}
