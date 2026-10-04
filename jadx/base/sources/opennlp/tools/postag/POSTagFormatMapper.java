package opennlp.tools.postag;

import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.stt.base.audio.C11496b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSTagFormatMapper {
    private static final Map<String, String> CONVERSION_TABLE_PENN_TO_UD;
    private static final Map<String, String> CONVERSION_TABLE_UD_TO_PENN;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) POSTagFormatMapper.class);
    private final POSTagFormat modelFormat;

    /* JADX INFO: renamed from: opennlp.tools.postag.POSTagFormatMapper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C136441 {
        static final /* synthetic */ int[] $SwitchMap$opennlp$tools$postag$POSTagFormat;

        static {
            int[] iArr = new int[POSTagFormat.values().length];
            $SwitchMap$opennlp$tools$postag$POSTagFormat = iArr;
            try {
                iArr[POSTagFormat.UD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$opennlp$tools$postag$POSTagFormat[POSTagFormat.PENN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        HashMap map = new HashMap();
        CONVERSION_TABLE_PENN_TO_UD = map;
        HashMap map2 = new HashMap();
        CONVERSION_TABLE_UD_TO_PENN = map2;
        map.put(ContentUtils.HASH_SYMBOL, "SYM");
        map.put("$", "SYM");
        map.put("''", "PUNCT");
        map.put(",", "PUNCT");
        map.put("-LRB-", "PUNCT");
        map.put("-RRB-", "PUNCT");
        map.put(Extension.DOT, "PUNCT");
        map.put(":", "PUNCT");
        map.put("AFX", "ADJ");
        map.put("CC", "CCONJ");
        map.put("CD", "NUM");
        map.put("DT", "DET");
        map.put("EX", "PRON");
        map.put("FW", "X");
        map.put("HYPH", "PUNCT");
        map.put("IN", "ADP");
        map.put("JJ", "ADJ");
        map.put("JJR", "ADJ");
        map.put("JJS", "ADJ");
        map.put("LS", "X");
        map.put("MD", "VERB");
        map.put("NIL", "X");
        map.put("NN", "NOUN");
        map.put("NNP", "PROPN");
        map.put("NNPS", "PROPN");
        map.put("NNS", "NOUN");
        map.put("PDT", "DET");
        map.put("POS", "PART");
        map.put("PRP", "PRON");
        map.put("PRP$", "DET");
        map.put("RB", "ADV");
        map.put("RBR", "ADV");
        map.put("RBS", "ADV");
        map.put("RP", "ADP");
        map.put("SYM", "SYM");
        map.put("TO", "PART");
        map.put("UH", "INTJ");
        map.put("VB", "VERB");
        map.put("VBD", "VERB");
        map.put("VBG", "VERB");
        map.put("VBN", "VERB");
        map.put("VBP", "VERB");
        map.put("VBZ", "VERB");
        map.put("WDT", "DET");
        map.put("WP", "PRON");
        map.put("WP$", "DET");
        map.put("WRB", "ADV");
        map2.put("ADJ", "JJ");
        map2.put("ADP", "IN");
        map2.put("ADV", "RB");
        map2.put("AUX", "MD");
        map2.put("CCONJ", "CC");
        map2.put("DET", "DT");
        map2.put("INTJ", "UH");
        map2.put("NOUN", "NN");
        map2.put("NUM", "CD");
        map2.put("PART", "RP");
        map2.put("PRON", "PRP");
        map2.put("PROPN", "NNP");
        map2.put("PUNCT", Extension.DOT);
        map2.put("SCONJ", "IN");
        map2.put("SYM", "SYM");
        map2.put("VERB", "VB");
        map2.put("X", "FW");
    }

    public POSTagFormatMapper(String[] strArr) {
        this.modelFormat = guessModelTagFormat(strArr);
    }

    public static POSTagFormat guessFormat(POSModel pOSModel) {
        Objects.requireNonNull(pOSModel, "POSModel must not be NULL.");
        Objects.requireNonNull(pOSModel.getPosSequenceModel(), "POSSequenceModel must not be NULL.");
        return new POSTagFormatMapper(pOSModel.getPosSequenceModel().getOutcomes()).getGuessedFormat();
    }

    private POSTagFormat guessModelTagFormat(String[] strArr) {
        Objects.requireNonNull(strArr, "Outcomes must not be NULL.");
        int i = 0;
        int i2 = 0;
        for (String str : strArr) {
            if (CONVERSION_TABLE_UD_TO_PENN.containsKey(str)) {
                i++;
            }
            if (CONVERSION_TABLE_PENN_TO_UD.containsKey(str)) {
                i2++;
            }
        }
        if (i > i2) {
            return POSTagFormat.UD;
        }
        if (i2 > i) {
            return POSTagFormat.PENN;
        }
        logger.warn("Detected an unknown POS format.");
        return POSTagFormat.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$convertTags$0(int i) {
        return new String[i];
    }

    public String convertTag(String str) {
        int i = C136441.$SwitchMap$opennlp$tools$postag$POSTagFormat[this.modelFormat.ordinal()];
        if (i == 1) {
            return CONVERSION_TABLE_UD_TO_PENN.getOrDefault(str, MsalUtils.QUERY_STRING_SYMBOL);
        }
        if (i != 2) {
            return str;
        }
        if ("NOUN".equals(str)) {
            logger.warn("Ambiguity detected: NN can be 'NN' or 'NNS' depending on the number. Returning 'NN'.");
        }
        if ("PART".equals(str)) {
            logger.warn("Ambiguity detected: PART can be 'RP' or 'TO'. Returning 'RP'.");
        }
        if ("PROPN".equals(str)) {
            logger.warn("Ambiguity detected: Can be 'NNP' or 'NNPS. Returning 'NNP'");
        }
        if ("PUNCT".equals(str)) {
            logger.warn("Ambiguity detected: PUNCT needs specific punctuation mapping. Returning '.'");
        }
        if ("VERB".equals(str)) {
            logger.warn("Ambiguity detected: VERB can be 'VB', 'VBD', 'VBG', 'VBN', 'VBP', 'VBZ'. Returning 'VERB'.");
        }
        return CONVERSION_TABLE_PENN_TO_UD.getOrDefault(str, MsalUtils.QUERY_STRING_SYMBOL);
    }

    public String[] convertTags(List<String> list) {
        Objects.requireNonNull(list, "Supplied tags must not be NULL.");
        return (String[]) list.stream().map(new C0332a(this, 13)).toArray(new C11496b(4));
    }

    public POSTagFormat getGuessedFormat() {
        return this.modelFormat;
    }
}
