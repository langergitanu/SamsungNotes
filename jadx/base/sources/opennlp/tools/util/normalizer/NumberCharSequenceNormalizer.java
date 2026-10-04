package opennlp.tools.util.normalizer;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NumberCharSequenceNormalizer implements CharSequenceNormalizer {
    private static final long serialVersionUID = -782056416383201122L;
    private static final Pattern NUMBER_REGEX = Pattern.compile("\\d+");
    private static final NumberCharSequenceNormalizer INSTANCE = new NumberCharSequenceNormalizer();

    public static NumberCharSequenceNormalizer getInstance() {
        return INSTANCE;
    }

    @Override // opennlp.tools.util.normalizer.CharSequenceNormalizer
    public CharSequence normalize(CharSequence charSequence) {
        return NUMBER_REGEX.matcher(charSequence).replaceAll(" ");
    }
}
