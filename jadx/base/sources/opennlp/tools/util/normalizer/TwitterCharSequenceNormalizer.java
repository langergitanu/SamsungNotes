package opennlp.tools.util.normalizer;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TwitterCharSequenceNormalizer implements CharSequenceNormalizer {
    private static final long serialVersionUID = -8155452559337913929L;
    private static final Pattern HASH_USER_REGEX = Pattern.compile("[#@]\\S+");
    private static final Pattern RT_REGEX = Pattern.compile("\\b(rt[ :])+", 2);
    private static final Pattern FACE_REGEX = Pattern.compile("[:;x]-?[()dop]", 2);
    private static final Pattern LAUGH_REGEX = Pattern.compile("([hj])+([aieou])+(\\1+\\2+)+", 2);
    private static final TwitterCharSequenceNormalizer INSTANCE = new TwitterCharSequenceNormalizer();

    public static TwitterCharSequenceNormalizer getInstance() {
        return INSTANCE;
    }

    @Override // opennlp.tools.util.normalizer.CharSequenceNormalizer
    public CharSequence normalize(CharSequence charSequence) {
        return LAUGH_REGEX.matcher(FACE_REGEX.matcher(RT_REGEX.matcher(HASH_USER_REGEX.matcher(charSequence).replaceAll(" ")).replaceAll(" ")).replaceAll(" ")).replaceAll("$1$2$1$2");
    }
}
