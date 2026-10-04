package uk.p245ac.p246ed.p247ph.snuggletex.semantics;

import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathIdentifierInterpretation implements MathInterpretation {
    private final String name;

    public MathIdentifierInterpretation(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation
    public InterpretationType getType() {
        return InterpretationType.MATH_IDENTIFIER;
    }

    public String toString() {
        return ObjectUtilities.beanToString(this);
    }
}
