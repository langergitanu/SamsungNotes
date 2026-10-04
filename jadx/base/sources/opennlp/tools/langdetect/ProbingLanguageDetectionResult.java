package opennlp.tools.langdetect;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ProbingLanguageDetectionResult extends AbstractC12991c {
    private final Language[] languages;
    private final int length;

    public ProbingLanguageDetectionResult(Language[] languageArr, int i) {
        this.languages = languageArr;
        this.length = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ProbingLanguageDetectionResult)) {
            return false;
        }
        ProbingLanguageDetectionResult probingLanguageDetectionResult = (ProbingLanguageDetectionResult) obj;
        return this.length == probingLanguageDetectionResult.length && Objects.equals(this.languages, probingLanguageDetectionResult.languages);
    }

    public final int hashCode() {
        int i = this.length;
        return Objects.hashCode(this.languages) + (i * 31);
    }

    public Language[] languages() {
        return this.languages;
    }

    public int length() {
        return this.length;
    }

    public final String toString() {
        Object[] objArr = {this.languages, Integer.valueOf(this.length)};
        String[] strArrSplit = "languages;length".length() == 0 ? new String[0] : "languages;length".split(";");
        StringBuilder sb = new StringBuilder("ProbingLanguageDetectionResult[");
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]);
            sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            sb.append(objArr[i]);
            if (i != strArrSplit.length - 1) {
                sb.append(SQLKeyword.COMMA);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
