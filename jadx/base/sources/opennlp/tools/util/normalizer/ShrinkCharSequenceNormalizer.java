package opennlp.tools.util.normalizer;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ShrinkCharSequenceNormalizer implements CharSequenceNormalizer {
    private static final long serialVersionUID = -4511969661556543048L;
    private static final Pattern REPEATED_CHAR_REGEX = Pattern.compile("(.)\\1{2,}", 2);
    private static final Pattern SPACE_REGEX = Pattern.compile("\\s{2,}", 2);
    private static final ShrinkCharSequenceNormalizer INSTANCE = new ShrinkCharSequenceNormalizer();

    public static ShrinkCharSequenceNormalizer getInstance() {
        return INSTANCE;
    }

    @Override // opennlp.tools.util.normalizer.CharSequenceNormalizer
    public CharSequence normalize(CharSequence charSequence) {
        return REPEATED_CHAR_REGEX.matcher(SPACE_REGEX.matcher(charSequence).replaceAll(" ")).replaceAll("$1$1").trim();
    }
}
