package uk.p245ac.p246ed.p247ph.snuggletex;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface InputContext {
    int charAt(int i);

    CharSequence extract();

    CharSequence extract(int i, int i2);

    SnuggleInput getInput();

    int indexOf(int i, char c);

    int indexOf(int i, String str);

    boolean isRegionWhitespace(int i, int i2);

    int length();

    boolean matchesAt(int i, char c);

    boolean matchesAt(int i, String str);
}
