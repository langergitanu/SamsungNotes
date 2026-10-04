package opennlp.tools.stemmer.snowball;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Among {
    public final Method method;
    public final int result;

    /* JADX INFO: renamed from: s */
    public final char[] f9693s;
    public final int substring_i;

    public Among(String str, int i, int i2) {
        this.f9693s = str.toCharArray();
        this.substring_i = i;
        this.result = i2;
        this.method = null;
    }

    public Among(String str, int i, int i2, String str2, Class<? extends AbstractSnowballStemmer> cls) {
        this.f9693s = str.toCharArray();
        this.substring_i = i;
        this.result = i2;
        try {
            this.method = cls.getDeclaredMethod(str2, null);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
