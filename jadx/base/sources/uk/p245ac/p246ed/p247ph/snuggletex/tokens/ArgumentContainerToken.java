package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.ComputedStyle;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.DumpMode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectDumperOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@ObjectDumperOptions(DumpMode.DEEP)
public final class ArgumentContainerToken extends Token implements Iterable<FlowToken> {
    public static final ArgumentContainerToken[] EMPTY_ARRAY = new ArgumentContainerToken[0];
    private final List<FlowToken> contents;

    public ArgumentContainerToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, List<FlowToken> list) {
        super(frozenSlice, TokenType.ARGUMENT_CONTAINER, laTeXMode, new Interpretation[0]);
        this.contents = list;
    }

    public static ArgumentContainerToken createEmptyContainer(Token token, LaTeXMode laTeXMode, ComputedStyle computedStyle) {
        return new ArgumentContainerToken(token.getSlice(), laTeXMode, Collections.EMPTY_LIST, computedStyle);
    }

    public static ArgumentContainerToken createFromContiguousTokens(Token token, LaTeXMode laTeXMode, List<? extends FlowToken> list, ComputedStyle computedStyle) {
        return createFromContiguousTokens(token, laTeXMode, list, 0, list.size(), computedStyle);
    }

    public static ArgumentContainerToken createFromSingleToken(LaTeXMode laTeXMode, FlowToken flowToken) {
        return createFromSingleToken(laTeXMode, flowToken, flowToken.getComputedStyle());
    }

    @ObjectDumperOptions(DumpMode.DEEP)
    public List<FlowToken> getContents() {
        return this.contents;
    }

    @Override // java.lang.Iterable
    public Iterator<FlowToken> iterator() {
        return this.contents.iterator();
    }

    public static ArgumentContainerToken createFromContiguousTokens(Token token, LaTeXMode laTeXMode, List<? extends FlowToken> list, int i, int i2, ComputedStyle computedStyle) {
        if (i <= i2) {
            return list.size() > 0 ? new ArgumentContainerToken(list.get(i).getSlice().rightOuterSpan(list.get(i2 - 1).getSlice()), laTeXMode, new ArrayList(list.subList(i, i2)), computedStyle) : createEmptyContainer(token, laTeXMode, computedStyle);
        }
        throw new IllegalArgumentException("startIndex must be <= endIndex");
    }

    public static ArgumentContainerToken createFromSingleToken(LaTeXMode laTeXMode, FlowToken flowToken, ComputedStyle computedStyle) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(flowToken);
        return new ArgumentContainerToken(flowToken.getSlice(), laTeXMode, arrayList, computedStyle);
    }

    public ArgumentContainerToken(FrozenSlice frozenSlice, LaTeXMode laTeXMode, List<FlowToken> list, ComputedStyle computedStyle) {
        super(frozenSlice, TokenType.ARGUMENT_CONTAINER, laTeXMode, new Interpretation[0]);
        this.contents = list;
        this.computedStyle = computedStyle;
    }
}
