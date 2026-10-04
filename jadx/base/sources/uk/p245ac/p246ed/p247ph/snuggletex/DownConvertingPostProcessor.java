package uk.p245ac.p246ed.p247ph.snuggletex;

import org.w3c.dom.Document;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MathMLDownConverter;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class DownConvertingPostProcessor implements DOMPostProcessor {
    @Override // uk.p245ac.p246ed.p247ph.snuggletex.DOMPostProcessor
    public Document postProcessDOM(Document document, DOMOutputOptions dOMOutputOptions, StylesheetManager stylesheetManager) {
        return new MathMLDownConverter(stylesheetManager, dOMOutputOptions).downConvertDOM(document);
    }
}
