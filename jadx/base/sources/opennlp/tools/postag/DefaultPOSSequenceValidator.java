package opennlp.tools.postag;

import java.util.Arrays;
import opennlp.tools.util.SequenceValidator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultPOSSequenceValidator implements SequenceValidator<String> {
    private final TagDictionary tagDictionary;

    public DefaultPOSSequenceValidator(TagDictionary tagDictionary) {
        this.tagDictionary = tagDictionary;
    }

    @Override // opennlp.tools.util.SequenceValidator
    public boolean validSequence(int i, String[] strArr, String[] strArr2, String str) {
        String[] tags;
        TagDictionary tagDictionary = this.tagDictionary;
        return tagDictionary == null || (tags = tagDictionary.getTags(strArr[i])) == null || Arrays.asList(tags).contains(str);
    }
}
