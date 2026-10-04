package opennlp.tools.parser;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum ParserType {
    CHUNKING,
    TREEINSERT;

    public static ParserType parse(String str) {
        ParserType parserType = CHUNKING;
        if (parserType.name().equals(str)) {
            return parserType;
        }
        ParserType parserType2 = TREEINSERT;
        if (parserType2.name().equals(str)) {
            return parserType2;
        }
        return null;
    }
}
