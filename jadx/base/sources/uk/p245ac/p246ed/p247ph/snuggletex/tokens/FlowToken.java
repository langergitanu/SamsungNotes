package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import java.util.EnumMap;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.InterpretationType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class FlowToken extends Token {
    protected final TextFlowContext textFlowContext;

    public FlowToken(FrozenSlice frozenSlice, TokenType tokenType, LaTeXMode laTeXMode, TextFlowContext textFlowContext, Interpretation... interpretationArr) {
        super(frozenSlice, tokenType, laTeXMode, interpretationArr);
        this.textFlowContext = textFlowContext;
    }

    public TextFlowContext getTextFlowContext() {
        return this.textFlowContext;
    }

    public FlowToken(FrozenSlice frozenSlice, TokenType tokenType, LaTeXMode laTeXMode, TextFlowContext textFlowContext, EnumMap<InterpretationType, Interpretation> enumMap) {
        super(frozenSlice, tokenType, laTeXMode, enumMap);
        this.textFlowContext = textFlowContext;
    }
}
