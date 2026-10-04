package opennlp.tools.parser;

import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Constituent {
    private String label;
    private final Span span;

    public Constituent(String str, Span span) {
        this.label = str;
        this.span = span;
    }

    public String getLabel() {
        return this.label;
    }

    public Span getSpan() {
        return this.span;
    }

    public void setLabel(String str) {
        this.label = str;
    }
}
