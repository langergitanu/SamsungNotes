package opennlp.tools.tokenize;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Detokenizer {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DetokenizationOperation {
        MERGE_TO_RIGHT,
        MERGE_TO_LEFT,
        MERGE_BOTH,
        NO_OPERATION
    }

    String detokenize(String[] strArr, String str);

    DetokenizationOperation[] detokenize(String[] strArr);
}
