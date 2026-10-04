package opennlp.tools.namefind;

import opennlp.tools.util.SequenceValidator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BilouNameFinderSequenceValidator implements SequenceValidator<String> {
    @Override // opennlp.tools.util.SequenceValidator
    public boolean validSequence(int i, String[] strArr, String[] strArr2, String str) {
        if (str.endsWith("cont") || str.endsWith(BilouCodec.LAST)) {
            int length = strArr2.length - 1;
            if (length == -1 || strArr2[length].endsWith("other") || strArr2[length].endsWith(BilouCodec.UNIT) || (strArr2[length].endsWith(BilouCodec.LAST) && (str.endsWith("cont") || str.endsWith(BilouCodec.LAST)))) {
                return false;
            }
            if (strArr2[length].endsWith("cont") || strArr2[length].endsWith("start")) {
                String strExtractNameType = NameFinderME.extractNameType(strArr2[length]);
                String strExtractNameType2 = NameFinderME.extractNameType(str);
                if (strExtractNameType != null || strExtractNameType2 != null) {
                    if (strExtractNameType2 != null) {
                        return strExtractNameType2.equals(strExtractNameType);
                    }
                    return false;
                }
            }
        }
        if (strArr2.length <= 0 || !(str.endsWith("start") || str.endsWith("other") || str.endsWith(BilouCodec.UNIT))) {
            return true;
        }
        return (strArr2[strArr2.length - 1].endsWith("start") || strArr2[strArr2.length - 1].endsWith("cont")) ? false : true;
    }
}
