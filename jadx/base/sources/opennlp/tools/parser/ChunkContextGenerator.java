package opennlp.tools.parser;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.ArrayList;
import opennlp.tools.chunker.ChunkerContextGenerator;
import opennlp.tools.util.Cache;
import opennlp.tools.util.TokenTag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkContextGenerator implements ChunkerContextGenerator {
    private static final String EOS = "eos";
    private Cache<String, String[]> contextsCache;
    private Object wordsKey;

    public ChunkContextGenerator() {
        this(0);
    }

    private String chunkandpostag(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(i);
        sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        sb.append(str);
        sb.append("|");
        sb.append(str2);
        if (i < 0) {
            sb.append("|");
            sb.append(str3);
        }
        return sb.toString();
    }

    private String chunkandpostagbo(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(i);
        sb.append("*=");
        sb.append(str);
        if (i < 0) {
            sb.append("|");
            sb.append(str2);
        }
        return sb.toString();
    }

    public ChunkContextGenerator(int i) {
        if (i > 0) {
            this.contextsCache = new Cache<>(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // opennlp.tools.chunker.ChunkerContextGenerator
    public String[] getContext(int i, String[] strArr, String[] strArr2, String[] strArr3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        ArrayList arrayList = new ArrayList(19);
        int i2 = i - 2;
        int i4 = i - 1;
        int i5 = i + 2;
        int i6 = i + 1;
        if (i2 >= 0) {
            str2 = strArr2[i2];
            str3 = strArr3[i2];
            str = strArr[i2];
        } else {
            str = EOS;
            str2 = str;
            str3 = str2;
        }
        if (i4 >= 0) {
            str5 = strArr2[i4];
            str6 = strArr3[i4];
            str4 = strArr[i4];
        } else {
            str4 = EOS;
            str5 = str4;
            str6 = str5;
        }
        String str11 = strArr2[i];
        String str12 = strArr[i];
        if (i6 < strArr2.length) {
            str8 = strArr2[i6];
            str7 = strArr[i6];
        } else {
            str7 = EOS;
            str8 = str7;
        }
        if (i5 < strArr2.length) {
            str9 = strArr2[i5];
            str10 = strArr[i5];
        } else {
            str9 = EOS;
            str10 = str9;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(str2);
        sb.append(str8);
        sb.append(str11);
        sb.append(str8);
        String strM1626p = AbstractC2322a.m1626p(sb, str9, str3, str6);
        Cache<String, String[]> cache = this.contextsCache;
        String str13 = str9;
        if (cache != null) {
            if (this.wordsKey == strArr) {
                String[] strArr4 = cache.get(strM1626p);
                if (strArr4 != null) {
                    return strArr4;
                }
            } else {
                cache.clear();
                this.wordsKey = strArr;
            }
        }
        String strChunkandpostag = chunkandpostag(-2, str, str2, str3);
        String strChunkandpostagbo = chunkandpostagbo(-2, str2, str3);
        String strChunkandpostag2 = chunkandpostag(-1, str4, str5, str6);
        String strChunkandpostagbo2 = chunkandpostagbo(-1, str5, str6);
        String strChunkandpostag3 = chunkandpostag(0, str12, str11, null);
        String strChunkandpostagbo3 = chunkandpostagbo(0, str11, null);
        String strChunkandpostag4 = chunkandpostag(1, str7, str8, null);
        String strChunkandpostagbo4 = chunkandpostagbo(1, str8, null);
        String strChunkandpostag5 = chunkandpostag(2, str10, str13, null);
        String strChunkandpostagbo5 = chunkandpostagbo(2, str13, null);
        arrayList.add("default");
        arrayList.add(strChunkandpostag);
        arrayList.add(strChunkandpostagbo);
        arrayList.add(strChunkandpostag2);
        arrayList.add(strChunkandpostagbo2);
        arrayList.add(strChunkandpostag3);
        arrayList.add(strChunkandpostagbo3);
        arrayList.add(strChunkandpostag4);
        arrayList.add(strChunkandpostagbo4);
        arrayList.add(strChunkandpostag5);
        arrayList.add(strChunkandpostagbo5);
        arrayList.add(strChunkandpostag2 + "," + strChunkandpostag3);
        arrayList.add(strChunkandpostagbo2 + "," + strChunkandpostag3);
        arrayList.add(strChunkandpostag2 + "," + strChunkandpostagbo3);
        arrayList.add(strChunkandpostagbo2 + "," + strChunkandpostagbo3);
        arrayList.add(strChunkandpostag3 + "," + strChunkandpostag4);
        arrayList.add(strChunkandpostagbo3 + "," + strChunkandpostag4);
        arrayList.add(strChunkandpostag3 + "," + strChunkandpostagbo4);
        arrayList.add(strChunkandpostagbo3 + "," + strChunkandpostagbo4);
        String[] strArr5 = (String[]) arrayList.toArray(new String[0]);
        Cache<String, String[]> cache2 = this.contextsCache;
        if (cache2 != null) {
            cache2.put(strM1626p, strArr5);
        }
        return strArr5;
    }

    @Override // opennlp.tools.util.BeamSearchContextGenerator
    public String[] getContext(int i, TokenTag[] tokenTagArr, String[] strArr, Object[] objArr) {
        return getContext(i, TokenTag.extractTokens(tokenTagArr), TokenTag.extractTags(tokenTagArr), strArr);
    }
}
