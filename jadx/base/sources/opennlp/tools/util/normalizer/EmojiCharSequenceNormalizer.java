package opennlp.tools.util.normalizer;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EmojiCharSequenceNormalizer implements CharSequenceNormalizer {
    private static final long serialVersionUID = 4553401197981667914L;
    private static final EmojiCharSequenceNormalizer INSTANCE = new EmojiCharSequenceNormalizer();
    private static final Pattern EMOJI_REGEX = Pattern.compile("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+");

    public static EmojiCharSequenceNormalizer getInstance() {
        return INSTANCE;
    }

    @Override // opennlp.tools.util.normalizer.CharSequenceNormalizer
    public CharSequence normalize(CharSequence charSequence) {
        return EMOJI_REGEX.matcher(charSequence).replaceAll(" ");
    }
}
