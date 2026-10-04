package opennlp.tools.langdetect;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Language implements Serializable {
    private static final long serialVersionUID = -2692630786925291644L;
    private final double confidence;
    private final String lang;

    public Language(String str) {
        this(str, 0.0d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Language) {
            return getLang().equals(((Language) obj).getLang());
        }
        return false;
    }

    public double getConfidence() {
        return this.confidence;
    }

    public String getLang() {
        return this.lang;
    }

    public int hashCode() {
        return Objects.hash(getLang(), Double.valueOf(getConfidence()));
    }

    public String toString() {
        return getLang() + " (" + this.confidence + ")";
    }

    public Language(String str, double d) {
        Objects.requireNonNull(str, "lang must not be null");
        this.lang = str;
        this.confidence = d;
    }
}
