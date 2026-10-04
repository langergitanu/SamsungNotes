package opennlp.tools.sentdetect;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface EndOfSentenceScanner {
    Set<Character> getEOSCharacters();

    List<Integer> getPositions(CharSequence charSequence);

    List<Integer> getPositions(StringBuffer stringBuffer);

    List<Integer> getPositions(char[] cArr);
}
