package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import java.util.Iterator;
import java.util.List;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.DumpMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectDumperOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class BraceContainerToken extends FlowToken implements Iterable<FlowToken> {
    private final List<FlowToken> contents;

    public BraceContainerToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, List<FlowToken> list) {
        super(frozenSlice, TokenType.BRACE_CONTAINER, laTeXMode, (TextFlowContext) null, new Interpretation[0]);
        this.contents = list;
    }

    @ObjectDumperOptions(DumpMode.DEEP)
    public List<FlowToken> getContents() {
        return this.contents;
    }

    @Override // java.lang.Iterable
    public Iterator<FlowToken> iterator() {
        return this.contents.iterator();
    }
}
