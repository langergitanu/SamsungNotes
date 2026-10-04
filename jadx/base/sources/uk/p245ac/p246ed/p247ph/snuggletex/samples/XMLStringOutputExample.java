package uk.p245ac.p246ed.p247ph.snuggletex.samples;

import uk.p245ac.p246ed.p247ph.snuggletex.SerializationMethod;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleEngine;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleInput;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleSession;
import uk.p245ac.p246ed.p247ph.snuggletex.XMLStringOutputOptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class XMLStringOutputExample {
    public static void main(String[] strArr) {
        SnuggleSession snuggleSessionCreateSession = new SnuggleEngine().createSession();
        snuggleSessionCreateSession.parseInput(new SnuggleInput("\\section*{The quadratic formula}$$ \\frac{-b \\pm \\sqrt{b^2-4ac}}{2a} $$"));
        XMLStringOutputOptions xMLStringOutputOptions = new XMLStringOutputOptions();
        xMLStringOutputOptions.setSerializationMethod(SerializationMethod.XHTML);
        xMLStringOutputOptions.setIndenting(true);
        xMLStringOutputOptions.setEncoding("UTF-8");
        xMLStringOutputOptions.setAddingMathSourceAnnotations(true);
        xMLStringOutputOptions.setUsingNamedEntities(true);
        System.out.println(snuggleSessionCreateSession.buildXMLString(xMLStringOutputOptions));
    }
}
