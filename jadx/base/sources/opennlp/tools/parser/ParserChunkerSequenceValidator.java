package opennlp.tools.parser;

import java.util.HashMap;
import java.util.Map;
import opennlp.tools.util.SequenceValidator;
import opennlp.tools.util.TokenTag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserChunkerSequenceValidator implements SequenceValidator<TokenTag> {
    private final Map<String, String> continueStartMap;

    public ParserChunkerSequenceValidator(String[] strArr) {
        this.continueStartMap = new HashMap(strArr.length);
        for (String str : strArr) {
            if (str.startsWith(AbstractBottomUpParser.CONT)) {
                this.continueStartMap.put(str, AbstractBottomUpParser.START + str.substring(2));
            }
        }
    }

    public boolean validSequence(int i, String[] strArr, String[] strArr2, String str) {
        if (!this.continueStartMap.containsKey(str)) {
            return true;
        }
        int length = strArr2.length - 1;
        if (length == -1) {
            return false;
        }
        String str2 = strArr2[length];
        if (str2.equals(str) || str2.equals(this.continueStartMap.get(str))) {
            return true;
        }
        str2.equals("O");
        return false;
    }

    @Override // opennlp.tools.util.SequenceValidator
    public boolean validSequence(int i, TokenTag[] tokenTagArr, String[] strArr, String str) {
        return validSequence(i, TokenTag.extractTokens(tokenTagArr), strArr, str);
    }
}
