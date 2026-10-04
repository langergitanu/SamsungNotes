package opennlp.tools.tokenize.lang;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.Set;
import java.util.regex.Pattern;
import opennlp.tools.tokenize.DefaultTokenContextGenerator;
import opennlp.tools.tokenize.TokenContextGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Factory {
    public static final Pattern DEFAULT_ALPHANUMERIC = Pattern.compile("^[A-Za-z0-9]+$");
    private static final Pattern PORTUGUESE = Pattern.compile("^[0-9a-záãâàéêíóõôúüçA-ZÁÃÂÀÉÊÍÓÕÔÚÜÇ]+$");
    private static final Pattern FRENCH = Pattern.compile("^[a-zA-Z0-9àâäèéêëîïôœùûüÿçÀÂÄÈÉÊËÎÏÔŒÙÛÜŸÇ]+$");
    private static final Pattern DUTCH = Pattern.compile("^[A-Za-z0-9äöüëèéïĳÄÖÜËÉÈÏĲ]+$");
    private static final Pattern GERMAN = Pattern.compile("^[A-Za-z0-9äéöüÄÉÖÜß]+$");
    private static final Pattern POLISH = Pattern.compile("^[A-Za-z0-9żźćńółęąśŻŹĆĄŚĘŁÓŃ]+$");
    private static final Pattern ITALIAN = Pattern.compile("^[0-9a-zàèéìîíòóùüA-ZÀÈÉÌÎÍÒÓÙÜ]+$");
    private static final Pattern SPANISH = Pattern.compile("^[0-9a-záéíóúüýñA-ZÁÉÍÓÚÝÑ]+$");
    private static final Pattern CATALAN = Pattern.compile("^[0-9a-zàèéíïòóúüçA-ZÀÈÉÍÏÒÓÚÜÇ]+$");

    public TokenContextGenerator createTokenContextGenerator(String str, Set<String> set) {
        return new DefaultTokenContextGenerator(set);
    }

    public Pattern getAlphanumeric(String str) {
        return (LangPackConfigConstants.LANGUAGE_CODE_ES.equals(str) || "spa".equals(str)) ? SPANISH : (LangPackConfigConstants.LANGUAGE_CODE_IT.equals(str) || "ita".equals(str)) ? ITALIAN : (LangPackConfigConstants.LANGUAGE_CODE_PT.equals(str) || "por".equals(str)) ? PORTUGUESE : ("ca".equals(str) || "cat".equals(str)) ? CATALAN : (LangPackConfigConstants.LANGUAGE_CODE_PL.equals(str) || "pol".equals(str)) ? POLISH : (LangPackConfigConstants.LANGUAGE_CODE_DE.equals(str) || "deu".equals(str) || "ger".equals(str)) ? GERMAN : (LangPackConfigConstants.LANGUAGE_CODE_FR.equals(str) || "fre".equals(str) || "fra".equals(str)) ? FRENCH : ("nl".equals(str) || "nld".equals(str) || "dut".equals(str)) ? DUTCH : DEFAULT_ALPHANUMERIC;
    }
}
