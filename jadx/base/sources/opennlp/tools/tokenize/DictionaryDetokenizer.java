package opennlp.tools.tokenize;

import androidx.collection.AbstractC0622a;
import java.util.HashSet;
import opennlp.tools.tokenize.DetokenizationDictionary;
import opennlp.tools.tokenize.Detokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DictionaryDetokenizer implements Detokenizer {
    private final DetokenizationDictionary dict;

    public DictionaryDetokenizer(DetokenizationDictionary detokenizationDictionary) {
        this.dict = detokenizationDictionary;
    }

    @Override // opennlp.tools.tokenize.Detokenizer
    public Detokenizer.DetokenizationOperation[] detokenize(String[] strArr) {
        Detokenizer.DetokenizationOperation[] detokenizationOperationArr = new Detokenizer.DetokenizationOperation[strArr.length];
        HashSet hashSet = new HashSet();
        for (int i = 0; i < strArr.length; i++) {
            DetokenizationDictionary.Operation operation = this.dict.getOperation(strArr[i]);
            if (operation == null) {
                detokenizationOperationArr[i] = Detokenizer.DetokenizationOperation.NO_OPERATION;
            } else if (DetokenizationDictionary.Operation.MOVE_LEFT.equals(operation)) {
                detokenizationOperationArr[i] = Detokenizer.DetokenizationOperation.MERGE_TO_LEFT;
            } else if (DetokenizationDictionary.Operation.MOVE_RIGHT.equals(operation)) {
                detokenizationOperationArr[i] = Detokenizer.DetokenizationOperation.MERGE_TO_RIGHT;
            } else if (DetokenizationDictionary.Operation.MOVE_BOTH.equals(operation)) {
                detokenizationOperationArr[i] = Detokenizer.DetokenizationOperation.MERGE_BOTH;
            } else {
                if (!DetokenizationDictionary.Operation.RIGHT_LEFT_MATCHING.equals(operation)) {
                    throw new IllegalStateException("Unknown operation: " + operation);
                }
                if (hashSet.contains(strArr[i])) {
                    detokenizationOperationArr[i] = Detokenizer.DetokenizationOperation.MERGE_TO_LEFT;
                    hashSet.remove(strArr[i]);
                } else {
                    detokenizationOperationArr[i] = Detokenizer.DetokenizationOperation.MERGE_TO_RIGHT;
                    hashSet.add(strArr[i]);
                }
            }
        }
        return detokenizationOperationArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    @Override // opennlp.tools.tokenize.Detokenizer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String detokenize(String[] strArr, String str) {
        boolean z;
        boolean z2;
        Detokenizer.DetokenizationOperation[] detokenizationOperationArrDetokenize = detokenize(strArr);
        if (strArr.length == detokenizationOperationArrDetokenize.length) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < strArr.length) {
                sb.append(strArr[i]);
                int i2 = i + 1;
                if (i2 == detokenizationOperationArrDetokenize.length) {
                    z2 = false;
                    z = false;
                } else {
                    z = true;
                    if (!detokenizationOperationArrDetokenize[i2].equals(Detokenizer.DetokenizationOperation.MERGE_TO_LEFT)) {
                        Detokenizer.DetokenizationOperation detokenizationOperation = detokenizationOperationArrDetokenize[i2];
                        Detokenizer.DetokenizationOperation detokenizationOperation2 = Detokenizer.DetokenizationOperation.MERGE_BOTH;
                        if (detokenizationOperation.equals(detokenizationOperation2) || detokenizationOperationArrDetokenize[i].equals(Detokenizer.DetokenizationOperation.MERGE_TO_RIGHT) || detokenizationOperationArrDetokenize[i].equals(detokenizationOperation2)) {
                            z2 = true;
                            z = false;
                        } else {
                            z2 = false;
                        }
                    }
                }
                if (z) {
                    sb.append(' ');
                }
                if (z2 && str != null) {
                    sb.append(str);
                }
                i = i2;
            }
            return sb.toString();
        }
        throw new IllegalArgumentException(AbstractC0622a.m1164j(strArr.length, detokenizationOperationArrDetokenize.length, "tokens and operations array must have same length: tokens=", ", operations=", "!"));
    }
}
