package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import uk.p245ac.p246ed.p247ph.snuggletex.InputError;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class ErrorToken extends FlowToken {
    private final InputError error;

    public ErrorToken(InputError inputError, LaTeXMode laTeXMode) {
        super(inputError.getSlice(), TokenType.ERROR, laTeXMode, TextFlowContext.START_NEW_XHTML_BLOCK, new Interpretation[0]);
        this.error = inputError;
    }

    public InputError getError() {
        return this.error;
    }
}
