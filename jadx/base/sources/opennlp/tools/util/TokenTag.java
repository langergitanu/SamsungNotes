package opennlp.tools.util;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenTag extends AbstractC12991c {
    private final String[] additionalData;
    private final String tag;
    private final String token;

    public TokenTag(String str, String str2, String[] strArr) {
        this.token = str;
        this.tag = str2;
        if (strArr != null) {
            this.additionalData = (String[]) Arrays.copyOf(strArr, strArr.length);
        } else {
            this.additionalData = null;
        }
    }

    public static TokenTag[] create(String[] strArr, String[] strArr2) {
        TokenTag[] tokenTagArr = new TokenTag[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            tokenTagArr[i] = new TokenTag(strArr[i], strArr2[i], null);
        }
        return tokenTagArr;
    }

    public static String[] extractTags(TokenTag[] tokenTagArr) {
        String[] strArr = new String[tokenTagArr.length];
        for (int i = 0; i < tokenTagArr.length; i++) {
            strArr[i] = tokenTagArr[i].tag();
        }
        return strArr;
    }

    public static String[] extractTokens(TokenTag[] tokenTagArr) {
        String[] strArr = new String[tokenTagArr.length];
        for (int i = 0; i < tokenTagArr.length; i++) {
            strArr[i] = tokenTagArr[i].token();
        }
        return strArr;
    }

    public String[] additionalData() {
        return this.additionalData;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TokenTag)) {
            return false;
        }
        TokenTag tokenTag = (TokenTag) obj;
        return Objects.equals(this.token, tokenTag.token) && Objects.equals(this.tag, tokenTag.tag) && Objects.equals(this.additionalData, tokenTag.additionalData);
    }

    public final int hashCode() {
        String str = this.token;
        String str2 = this.tag;
        String[] strArr = this.additionalData;
        return Objects.hashCode(strArr) + ((Objects.hashCode(str2) + (Objects.hashCode(str) * 31)) * 31);
    }

    public String tag() {
        return this.tag;
    }

    public String toString() {
        return AbstractC0541b.m757C(this.token, "_", this.tag);
    }

    public String token() {
        return this.token;
    }
}
