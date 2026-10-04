package opennlp.tools.postag;

import opennlp.tools.util.Sequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface POSTagger {
    String[] tag(String[] strArr);

    String[] tag(String[] strArr, Object[] objArr);

    Sequence[] topKSequences(String[] strArr);

    Sequence[] topKSequences(String[] strArr, Object[] objArr);
}
