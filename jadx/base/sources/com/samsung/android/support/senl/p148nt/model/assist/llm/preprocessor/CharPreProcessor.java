package com.samsung.android.support.senl.p148nt.model.assist.llm.preprocessor;

import android.text.TextUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CharPreProcessor {
    public static String convertCarriageReturnToNewLine(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        int iLastIndexOf = stringBuffer.lastIndexOf(StringUtils.f9761CR);
        int length = stringBuffer.length();
        if (iLastIndexOf == length - 1) {
            stringBuffer.append('\n');
            iLastIndexOf = stringBuffer.lastIndexOf(StringUtils.f9761CR, length - 2);
        }
        while (iLastIndexOf > 0) {
            int i = iLastIndexOf + 1;
            if (stringBuffer.charAt(i) != '\n' && stringBuffer.charAt(iLastIndexOf - 1) != '\n') {
                stringBuffer.insert(i, '\n');
            }
            iLastIndexOf = stringBuffer.lastIndexOf(StringUtils.f9761CR, iLastIndexOf - 1);
        }
        if (iLastIndexOf == 0 && stringBuffer.charAt(1) != '\n') {
            stringBuffer.insert(iLastIndexOf + 1, '\n');
        }
        return stringBuffer.toString();
    }
}
