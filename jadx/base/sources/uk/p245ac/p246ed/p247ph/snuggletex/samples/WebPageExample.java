package uk.p245ac.p246ed.p247ph.snuggletex.samples;

import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleEngine;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleInput;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleSession;
import uk.p245ac.p246ed.p247ph.snuggletex.WebPageOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.WebPageOutputOptionsBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class WebPageExample {
    public static void main(String[] strArr) {
        SnuggleSession snuggleSessionCreateSession = new SnuggleEngine().createSession();
        snuggleSessionCreateSession.parseInput(new SnuggleInput("$$ a^2 = b^2 + c^2 $$"));
        WebPageOutputOptions webPageOutputOptionsCreateHTML5MathJaxOptions = WebPageOutputOptionsBuilder.createHTML5MathJaxOptions();
        webPageOutputOptionsCreateHTML5MathJaxOptions.setTitle("My Web Page");
        webPageOutputOptionsCreateHTML5MathJaxOptions.setAddingTitleHeading(true);
        webPageOutputOptionsCreateHTML5MathJaxOptions.setIndenting(true);
        webPageOutputOptionsCreateHTML5MathJaxOptions.setAddingMathSourceAnnotations(true);
        webPageOutputOptionsCreateHTML5MathJaxOptions.setIncludingStyleElement(false);
        snuggleSessionCreateSession.writeWebPage(webPageOutputOptionsCreateHTML5MathJaxOptions, System.out);
    }
}
