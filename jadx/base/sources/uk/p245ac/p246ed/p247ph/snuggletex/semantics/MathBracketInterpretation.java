package uk.p245ac.p246ed.p247ph.snuggletex.semantics;

import uk.p245ac.p246ed.p247ph.snuggletex.definitions.MathCharacter;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathBracketInterpretation implements MathInterpretation {
    private final BracketType bracketType;
    private final MathCharacter mfencedAttributeCharacter;
    private final boolean pairingInferencePossible;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum BracketType {
        OPENER,
        CLOSER,
        OPENER_OR_CLOSER
    }

    public MathBracketInterpretation(MathCharacter mathCharacter, BracketType bracketType, boolean z) {
        this.mfencedAttributeCharacter = mathCharacter;
        this.bracketType = bracketType;
        this.pairingInferencePossible = z;
    }

    public BracketType getBracketType() {
        return this.bracketType;
    }

    public MathCharacter getMfencedAttributeCharacter() {
        return this.mfencedAttributeCharacter;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation
    public InterpretationType getType() {
        return InterpretationType.MATH_BRACKET;
    }

    public boolean isPairingInferencePossible() {
        return this.pairingInferencePossible;
    }

    public String toString() {
        return ObjectUtilities.beanToString(this);
    }
}
