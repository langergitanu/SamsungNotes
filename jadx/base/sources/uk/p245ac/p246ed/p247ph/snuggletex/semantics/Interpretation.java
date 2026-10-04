package uk.p245ac.p246ed.p247ph.snuggletex.semantics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface Interpretation {
    public static final Interpretation TABULAR = new MarkerInterpretation(InterpretationType.TABULAR);
    public static final Interpretation LIST = new MarkerInterpretation(InterpretationType.LIST);
    public static final Interpretation STYLE_SENTINEL = new MarkerInterpretation(InterpretationType.STYLE_SENTINEL);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MarkerInterpretation implements Interpretation {
        private final InterpretationType type;

        public MarkerInterpretation(InterpretationType interpretationType) {
            this.type = interpretationType;
        }

        @Override // uk.p245ac.p246ed.p247ph.snuggletex.semantics.Interpretation
        public InterpretationType getType() {
            return this.type;
        }
    }

    InterpretationType getType();
}
