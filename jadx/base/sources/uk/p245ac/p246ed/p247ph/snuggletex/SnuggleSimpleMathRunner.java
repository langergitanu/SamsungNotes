package uk.p245ac.p246ed.p247ph.snuggletex;

import java.io.IOException;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MathMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SnuggleSimpleMathRunner {
    private final SnuggleSession session;

    public SnuggleSimpleMathRunner(SnuggleSession snuggleSession) {
        this.session = snuggleSession;
    }

    public Element doMathInput(String str) {
        return doMathInput(str, this.session.defaultDOMOutputOptions);
    }

    public List<InputError> getLastErrors() {
        return this.session.getErrors();
    }

    public Element doMathInput(String str, DOMOutputOptions dOMOutputOptions) {
        ConstraintUtilities.ensureNotNull(str, "Math Mode Input");
        String str2 = "\\[" + str + "\\]";
        this.session.reset();
        try {
            this.session.parseInput(new SnuggleInput(str2, "Math Mode Input"));
            NodeList nodeListBuildDOMSubtree = this.session.buildDOMSubtree(dOMOutputOptions);
            if (!this.session.getErrors().isEmpty()) {
                return null;
            }
            if (nodeListBuildDOMSubtree.getLength() != 1) {
                throw new IllegalArgumentException("Input did not yield exactly 1 result element");
            }
            Element element = (Element) nodeListBuildDOMSubtree.item(0);
            if (MathMLUtilities.isMathMLElement(element, "math")) {
                return element;
            }
            throw new IllegalArgumentException("Input did not yield exactly 1 <math> element");
        } catch (IOException unused) {
            throw new SnuggleLogicException("Unexpected IOException");
        }
    }

    public String doMathInput(String str, XMLStringOutputOptions xMLStringOutputOptions) {
        Element elementDoMathInput = doMathInput(str, (DOMOutputOptions) xMLStringOutputOptions);
        if (elementDoMathInput != null) {
            return MathMLUtilities.serializeElement(elementDoMathInput, xMLStringOutputOptions);
        }
        return null;
    }
}
