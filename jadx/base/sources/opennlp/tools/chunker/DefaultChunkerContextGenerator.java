package opennlp.tools.chunker;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import opennlp.tools.util.TokenTag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultChunkerContextGenerator implements ChunkerContextGenerator {
    @Override // opennlp.tools.chunker.ChunkerContextGenerator
    public String[] getContext(int i, String[] strArr, String[] strArr2, String[] strArr3) {
        String strM772n;
        String strM772n2;
        String strM772n3;
        String strM772n4;
        String str;
        String str2;
        String strM772n5;
        String strM772n6;
        String strM772n7;
        String strM772n8;
        if (i < 2) {
            strM772n3 = "p_2=bos";
            strM772n = "w_2=bos";
            strM772n2 = "t_2=bos";
        } else {
            int i2 = i - 2;
            strM772n = AbstractC0541b.m772n("w_2=", strArr[i2]);
            strM772n2 = AbstractC0541b.m772n("t_2=", strArr2[i2]);
            strM772n3 = AbstractC0541b.m772n("p_2=", strArr3[i2]);
        }
        if (i < 1) {
            str2 = "w_1=bos";
            strM772n4 = "p_1=bos";
            str = "t_1=bos";
        } else {
            int i4 = i - 1;
            String strM772n9 = AbstractC0541b.m772n("w_1=", strArr[i4]);
            String strM772n10 = AbstractC0541b.m772n("t_1=", strArr2[i4]);
            strM772n4 = AbstractC0541b.m772n("p_1=", strArr3[i4]);
            str = strM772n10;
            str2 = strM772n9;
        }
        String strM772n11 = AbstractC0541b.m772n("w0=", strArr[i]);
        String strM772n12 = AbstractC0541b.m772n("t0=", strArr2[i]);
        int i5 = i + 1;
        if (i5 >= strArr.length) {
            strM772n5 = "w1=eos";
            strM772n6 = "t1=eos";
        } else {
            strM772n5 = AbstractC0541b.m772n("w1=", strArr[i5]);
            strM772n6 = AbstractC0541b.m772n("t1=", strArr2[i5]);
        }
        int i6 = i + 2;
        if (i6 >= strArr.length) {
            strM772n8 = "t2=eos";
            strM772n7 = "w2=eos";
        } else {
            strM772n7 = AbstractC0541b.m772n("w2=", strArr[i6]);
            strM772n8 = AbstractC0541b.m772n("t2=", strArr2[i6]);
        }
        return new String[]{strM772n, str2, strM772n11, strM772n5, strM772n7, AbstractC0541b.m756B(str2, strM772n11), AbstractC0541b.m756B(strM772n11, strM772n5), strM772n2, str, strM772n12, strM772n6, strM772n8, AbstractC0541b.m756B(strM772n2, str), AbstractC0541b.m756B(str, strM772n12), AbstractC0541b.m756B(strM772n12, strM772n6), AbstractC0541b.m756B(strM772n6, strM772n8), AbstractC0541b.m757C(strM772n2, str, strM772n12), AbstractC0541b.m757C(str, strM772n12, strM772n6), AbstractC0541b.m757C(strM772n12, strM772n6, strM772n8), strM772n3, strM772n4, AbstractC0541b.m756B(strM772n3, strM772n4), AbstractC0541b.m756B(strM772n4, strM772n2), AbstractC0541b.m756B(strM772n4, str), AbstractC0541b.m756B(strM772n4, strM772n12), AbstractC0541b.m756B(strM772n4, strM772n6), AbstractC0541b.m756B(strM772n4, strM772n8), AbstractC0541b.m757C(strM772n4, strM772n2, str), AbstractC0541b.m757C(strM772n4, str, strM772n12), AbstractC0541b.m757C(strM772n4, strM772n12, strM772n6), AbstractC0541b.m757C(strM772n4, strM772n6, strM772n8), AbstractC2821a.m2221l(strM772n4, strM772n2, str, strM772n12), AbstractC2821a.m2221l(strM772n4, str, strM772n12, strM772n6), AbstractC2821a.m2221l(strM772n4, strM772n12, strM772n6, strM772n8), AbstractC0541b.m756B(strM772n4, strM772n), AbstractC0541b.m756B(strM772n4, str2), AbstractC0541b.m756B(strM772n4, strM772n11), AbstractC0541b.m756B(strM772n4, strM772n5), AbstractC0541b.m756B(strM772n4, strM772n7), AbstractC0541b.m757C(strM772n4, str2, strM772n11), AbstractC0541b.m757C(strM772n4, strM772n11, strM772n5)};
    }

    @Override // opennlp.tools.util.BeamSearchContextGenerator
    public String[] getContext(int i, TokenTag[] tokenTagArr, String[] strArr, Object[] objArr) {
        return getContext(i, TokenTag.extractTokens(tokenTagArr), TokenTag.extractTags(tokenTagArr), strArr);
    }
}
