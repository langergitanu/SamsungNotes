package opennlp.tools.chunker;

import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.TokenTag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultChunkerSequenceValidator implements SequenceValidator<TokenTag> {
    private boolean validOutcome(String str, String str2) {
        if (!str.startsWith("I-")) {
            return true;
        }
        if (str2 == null || str2.equals("O")) {
            return false;
        }
        return str2.substring(2).equals(str.substring(2));
    }

    @Override // opennlp.tools.util.SequenceValidator
    public boolean validSequence(int i, TokenTag[] tokenTagArr, String[] strArr, String str) {
        return validOutcome(str, strArr);
    }

    private boolean validOutcome(String str, String[] strArr) {
        return validOutcome(str, strArr.length > 0 ? strArr[strArr.length - 1] : null);
    }
}
