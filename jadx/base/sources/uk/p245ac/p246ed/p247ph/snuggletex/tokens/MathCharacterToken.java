package uk.p245ac.p246ed.p247ph.snuggletex.tokens;

import uk.p245ac.p246ed.p247ph.snuggletex.definitions.LaTeXMode;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathCharacter;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.TextFlowContext;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathCharacterToken extends FlowToken {
    private final MathCharacter mathCharacter;

    public MathCharacterToken(FrozenSlice frozenSlice, MathCharacter mathCharacter) {
        super(frozenSlice, TokenType.MATH_CHARACTER, LaTeXMode.MATH, (TextFlowContext) null, mathCharacter.getInterpretationMap());
        this.mathCharacter = mathCharacter;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.tokens.Token
    public MathCharacter getMathCharacter() {
        return this.mathCharacter;
    }
}
