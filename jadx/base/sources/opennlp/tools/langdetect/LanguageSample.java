package opennlp.tools.langdetect;

import java.io.Serializable;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class LanguageSample extends AbstractC12991c implements Serializable {
    private static final long serialVersionUID = -4791295976215940258L;
    private final CharSequence context;
    private final Language language;

    public LanguageSample(Language language, CharSequence charSequence) {
        Objects.requireNonNull(language, "language must not be null");
        this.language = language;
        Objects.requireNonNull(charSequence, "context must not be null");
        this.context = charSequence;
    }

    public CharSequence context() {
        return this.context;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LanguageSample)) {
            return false;
        }
        LanguageSample languageSample = (LanguageSample) obj;
        return Objects.equals(this.language, languageSample.language) && Objects.equals(this.context, languageSample.context);
    }

    public final int hashCode() {
        Language language = this.language;
        CharSequence charSequence = this.context;
        return Objects.hashCode(charSequence) + (Objects.hashCode(language) * 31);
    }

    public Language language() {
        return this.language;
    }

    public String toString() {
        return this.language.getLang() + "\t" + ((Object) this.context);
    }
}
