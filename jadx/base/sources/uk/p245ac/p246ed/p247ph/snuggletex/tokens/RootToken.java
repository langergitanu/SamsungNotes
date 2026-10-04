package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import java.util.Iterator;
import java.util.List;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.WorkingDocument;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.DumpMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectDumperOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@ObjectDumperOptions(DumpMode.DEEP)
public final class RootToken extends Token implements Iterable<FlowToken> {
    private final List<FlowToken> contents;
    private final WorkingDocument workingDocument;

    public RootToken(WorkingDocument workingDocument, List<FlowToken> list) {
        super(workingDocument.freezeSlice(0, workingDocument.length()), TokenType.ROOT, LaTeXMode.PARAGRAPH, new Interpretation[0]);
        this.workingDocument = workingDocument;
        this.contents = list;
    }

    @ObjectDumperOptions(DumpMode.DEEP)
    public List<FlowToken> getContents() {
        return this.contents;
    }

    public WorkingDocument getWorkingDocument() {
        return this.workingDocument;
    }

    @Override // java.lang.Iterable
    public Iterator<FlowToken> iterator() {
        return this.contents.iterator();
    }
}
