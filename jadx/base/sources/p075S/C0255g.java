package p075S;

import com.samsung.android.ocr.stride.postocr.entity.URLCorrection;
import java.lang.Character;
import java.util.function.IntPredicate;
import opennlp.tools.tokenize.TokenizerME;

/* JADX INFO: renamed from: S.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0255g implements IntPredicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f705a;

    public /* synthetic */ C0255g(int i) {
        this.f705a = i;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        switch (this.f705a) {
            case 0:
                return Character.UnicodeScript.of(i) == Character.UnicodeScript.HAN || Character.UnicodeScript.of(i) == Character.UnicodeScript.HANGUL || Character.UnicodeScript.of(i) == Character.UnicodeScript.HIRAGANA || Character.UnicodeScript.of(i) == Character.UnicodeScript.KATAKANA;
            case 1:
                return URLCorrection.lambda$correctHttpPrefix$0(i);
            case 2:
                return Character.isDigit(i);
            default:
                return TokenizerME.lambda$tokenizePos$0(i);
        }
    }
}
