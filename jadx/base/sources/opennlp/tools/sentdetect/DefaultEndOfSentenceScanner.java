package opennlp.tools.sentdetect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultEndOfSentenceScanner implements EndOfSentenceScanner {
    private final Set<Character> eosCharacters = new HashSet();

    public DefaultEndOfSentenceScanner(char[] cArr) {
        for (char c : cArr) {
            this.eosCharacters.add(Character.valueOf(c));
        }
    }

    @Override // opennlp.tools.sentdetect.EndOfSentenceScanner
    public Set<Character> getEOSCharacters() {
        return this.eosCharacters;
    }

    @Override // opennlp.tools.sentdetect.EndOfSentenceScanner
    public List<Integer> getPositions(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            if (this.eosCharacters.contains(Character.valueOf(charSequence.charAt(i)))) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @Override // opennlp.tools.sentdetect.EndOfSentenceScanner
    public List<Integer> getPositions(StringBuffer stringBuffer) {
        return getPositions(stringBuffer.toString().toCharArray());
    }

    @Override // opennlp.tools.sentdetect.EndOfSentenceScanner
    public List<Integer> getPositions(char[] cArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cArr.length; i++) {
            if (this.eosCharacters.contains(Character.valueOf(cArr[i]))) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }
}
