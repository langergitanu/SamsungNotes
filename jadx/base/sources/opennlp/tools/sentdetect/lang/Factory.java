package opennlp.tools.sentdetect.lang;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Collections;
import java.util.Set;
import opennlp.tools.sentdetect.DefaultEndOfSentenceScanner;
import opennlp.tools.sentdetect.DefaultSDContextGenerator;
import opennlp.tools.sentdetect.EndOfSentenceScanner;
import opennlp.tools.sentdetect.SDContextGenerator;
import opennlp.tools.sentdetect.lang.p221th.SentenceContextGenerator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Factory {
    public static final char[] ptEosCharacters = {'.', '?', '!', SQLKeyword.DELIMITER, ':', PropertyUtils.MAPPED_DELIM, PropertyUtils.MAPPED_DELIM2, 171, 187, '\'', '\"'};
    public static final char[] defaultEosCharacters = {'.', '!', '?'};
    public static final char[] thEosCharacters = {' ', '\n'};
    public static final char[] jpnEosCharacters = {12290, 65281, 65311};

    public EndOfSentenceScanner createEndOfSentenceScanner(String str) {
        return new DefaultEndOfSentenceScanner(getEOSCharacters(str));
    }

    public SDContextGenerator createSentenceContextGenerator(String str, Set<String> set) {
        return ("th".equals(str) || "tha".equals(str)) ? new SentenceContextGenerator() : (LangPackConfigConstants.LANGUAGE_CODE_PT.equals(str) || "por".equals(str)) ? new DefaultSDContextGenerator(set, ptEosCharacters) : new DefaultSDContextGenerator(set, defaultEosCharacters);
    }

    public char[] getEOSCharacters(String str) {
        return ("th".equals(str) || "tha".equals(str)) ? thEosCharacters : (LangPackConfigConstants.LANGUAGE_CODE_PT.equals(str) || "por".equals(str)) ? ptEosCharacters : "jpn".equals(str) ? jpnEosCharacters : defaultEosCharacters;
    }

    public EndOfSentenceScanner createEndOfSentenceScanner(char[] cArr) {
        return new DefaultEndOfSentenceScanner(cArr);
    }

    public SDContextGenerator createSentenceContextGenerator(Set<String> set, char[] cArr) {
        return new DefaultSDContextGenerator(set, cArr);
    }

    public SDContextGenerator createSentenceContextGenerator(String str) {
        return createSentenceContextGenerator(str, Collections.EMPTY_SET);
    }
}
