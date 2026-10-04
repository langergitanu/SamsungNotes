package uk.p245ac.p246ed.p247ph.snuggletex.samples;

import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleEngine;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleInput;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MinimalExample {
    public static void main(String[] strArr) {
        SnuggleSession snuggleSessionCreateSession = new SnuggleEngine().createSession();
        SnuggleInput snuggleInput = new SnuggleInput("$$ x+2=3 $$");
        snuggleSessionCreateSession.parseInput(snuggleInput);
        String strBuildXMLString = snuggleSessionCreateSession.buildXMLString();
        System.out.println("Input " + snuggleInput.getString() + " was converted to:\n" + strBuildXMLString);
    }
}
