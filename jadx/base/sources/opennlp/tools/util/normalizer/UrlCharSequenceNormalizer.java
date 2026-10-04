package opennlp.tools.util.normalizer;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class UrlCharSequenceNormalizer implements CharSequenceNormalizer {
    private static final long serialVersionUID = 2023145028634552389L;
    private static final Pattern URL_REGEX = Pattern.compile("https?://[-_.?&~;+=/#0-9A-Za-z]+");
    private static final Pattern MAIL_REGEX = Pattern.compile("(?<![-+_.0-9A-Za-z])[-+_.0-9A-Za-z]+@[-0-9A-Za-z]+[-.0-9A-Za-z]+");
    private static final UrlCharSequenceNormalizer INSTANCE = new UrlCharSequenceNormalizer();

    public static UrlCharSequenceNormalizer getInstance() {
        return INSTANCE;
    }

    @Override // opennlp.tools.util.normalizer.CharSequenceNormalizer
    public CharSequence normalize(CharSequence charSequence) {
        return MAIL_REGEX.matcher(URL_REGEX.matcher(charSequence).replaceAll(" ")).replaceAll(" ");
    }
}
