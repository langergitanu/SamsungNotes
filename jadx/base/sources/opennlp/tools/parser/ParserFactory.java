package opennlp.tools.parser;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserFactory {
    private ParserFactory() {
    }

    public static Parser create(ParserModel parserModel, int i, double d) {
        if (ParserType.CHUNKING.equals(parserModel.getParserType())) {
            return new opennlp.tools.parser.chunking.Parser(parserModel, i, d);
        }
        if (ParserType.TREEINSERT.equals(parserModel.getParserType())) {
            return new opennlp.tools.parser.treeinsert.Parser(parserModel, i, d);
        }
        throw new IllegalStateException(AbstractC0541b.m772n("Unexpected ParserType: ", parserModel.getParserType().name()));
    }

    public static Parser create(ParserModel parserModel) {
        return create(parserModel, 20, 0.95d);
    }
}
