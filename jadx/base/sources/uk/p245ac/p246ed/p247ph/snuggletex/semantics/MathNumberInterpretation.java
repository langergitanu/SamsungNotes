package uk.p245ac.p246ed.p247ph.snuggletex.semantics;

import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathNumberInterpretation implements MathInterpretation {
    private final CharSequence number;

    public MathNumberInterpretation(CharSequence charSequence) {
        this.number = charSequence;
    }

    public CharSequence getNumber() {
        return this.number;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation
    public InterpretationType getType() {
        return InterpretationType.MATH_NUMBER;
    }

    public String toString() {
        return ObjectUtilities.beanToString(this);
    }
}
