package opennlp.tools.util.normalizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AggregateCharSequenceNormalizer implements CharSequenceNormalizer {
    private static final long serialVersionUID = 5514902020184083235L;
    private final CharSequenceNormalizer[] normalizers;

    public AggregateCharSequenceNormalizer(CharSequenceNormalizer... charSequenceNormalizerArr) {
        this.normalizers = charSequenceNormalizerArr;
    }

    @Override // opennlp.tools.util.normalizer.CharSequenceNormalizer
    public CharSequence normalize(CharSequence charSequence) {
        for (CharSequenceNormalizer charSequenceNormalizer : this.normalizers) {
            charSequence = charSequenceNormalizer.normalize(charSequence);
        }
        return charSequence;
    }
}
