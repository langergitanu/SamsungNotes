package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class UnwrappedParallelMathMLDOM {
    private Element firstBranch;
    private Element mathElement;
    private final Map<String, String> textAnnotations = new HashMap();
    private final Map<String, NodeList> xmlAnnotations = new HashMap();

    public Element getFirstBranch() {
        return this.firstBranch;
    }

    public Element getMathElement() {
        return this.mathElement;
    }

    public Map<String, String> getTextAnnotations() {
        return this.textAnnotations;
    }

    public Map<String, NodeList> getXmlAnnotations() {
        return this.xmlAnnotations;
    }

    public void setFirstBranch(Element element) {
        this.firstBranch = element;
    }

    public void setMathElement(Element element) {
        this.mathElement = element;
    }
}
