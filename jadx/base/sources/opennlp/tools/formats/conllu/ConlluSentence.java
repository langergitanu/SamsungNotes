package opennlp.tools.formats.conllu;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConlluSentence {
    private String documentId;
    private boolean newDocument;
    private boolean newParagraph;
    private String paragraphId;
    private final String sentenceIdComment;
    private final String textComment;
    private Map<Locale, String> textLang;
    private String translit;
    private final List<ConlluWordLine> wordLines;

    public ConlluSentence(List<ConlluWordLine> list, String str, String str2) {
        this.wordLines = list;
        this.sentenceIdComment = str;
        this.textComment = str2;
    }

    public Optional<String> getDocumentId() {
        return Optional.ofNullable(this.documentId);
    }

    public Optional<String> getParagraphId() {
        return Optional.ofNullable(this.paragraphId);
    }

    public String getSentenceIdComment() {
        return this.sentenceIdComment;
    }

    public String getTextComment() {
        return this.textComment;
    }

    public Optional<Map<Locale, String>> getTextLang() {
        return Optional.ofNullable(this.textLang);
    }

    public Optional<String> getTranslit() {
        return Optional.ofNullable(this.translit);
    }

    public List<ConlluWordLine> getWordLines() {
        return this.wordLines;
    }

    public boolean isNewDocument() {
        return this.newDocument;
    }

    public boolean isNewParagraph() {
        return this.newParagraph;
    }

    public ConlluSentence(List<ConlluWordLine> list, String str, String str2, boolean z, String str3, boolean z2, String str4, Map<Locale, String> map, String str5) {
        this.wordLines = list;
        this.sentenceIdComment = str;
        this.textComment = str2;
        this.newDocument = z;
        this.documentId = str3;
        this.newParagraph = z2;
        this.paragraphId = str4;
        this.textLang = map;
        this.translit = str5;
    }
}
