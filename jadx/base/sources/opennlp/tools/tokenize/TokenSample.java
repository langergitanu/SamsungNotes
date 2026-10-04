package opennlp.tools.tokenize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import opennlp.tools.commons.Sample;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenSample implements Sample {
    public static final String DEFAULT_SEPARATOR_CHARS = "<SPLIT>";
    private static final String separatorChars = "<SPLIT>";
    private static final long serialVersionUID = 8520715903833887047L;
    private final String text;
    private final List<Span> tokenSpans;

    public TokenSample(String str, Span[] spanArr) {
        Objects.requireNonNull(spanArr, "tokenSpans must not be null");
        Objects.requireNonNull(str, "text must not be null");
        this.text = str;
        ArrayList arrayList = new ArrayList(spanArr.length);
        for (Span span : spanArr) {
            Objects.requireNonNull(span);
            arrayList.add(span);
        }
        this.tokenSpans = Collections.unmodifiableList(arrayList);
        for (Span span2 : spanArr) {
            if (span2.getStart() < 0 || span2.getStart() > str.length() || span2.getEnd() > str.length() || span2.getEnd() < 0) {
                throw new IllegalArgumentException("Span " + span2 + " is out of bounds, text length: " + str.length() + "!");
            }
        }
    }

    private static void addToken(StringBuilder sb, List<Span> list, String str, boolean z) {
        int length = sb.length();
        sb.append(str);
        list.add(new Span(length, sb.length()));
        if (z) {
            return;
        }
        sb.append(" ");
    }

    private boolean isMergeToLeft(Detokenizer.DetokenizationOperation detokenizationOperation) {
        return Detokenizer.DetokenizationOperation.MERGE_TO_LEFT.equals(detokenizationOperation) || Detokenizer.DetokenizationOperation.MERGE_BOTH.equals(detokenizationOperation);
    }

    private boolean isMergeToRight(Detokenizer.DetokenizationOperation detokenizationOperation) {
        return Detokenizer.DetokenizationOperation.MERGE_TO_RIGHT.equals(detokenizationOperation) || Detokenizer.DetokenizationOperation.MERGE_BOTH.equals(detokenizationOperation);
    }

    public static TokenSample parse(String str, String str2) {
        Objects.requireNonNull(str, "sampleString must not be null");
        Objects.requireNonNull(str2, "separatorChars must not be null");
        Span[] spanArr = WhitespaceTokenizer.INSTANCE.tokenizePos(str);
        ArrayList arrayList = new ArrayList((int) (((double) spanArr.length) * 1.2d));
        StringBuilder sb = new StringBuilder();
        for (Span span : spanArr) {
            String string = span.getCoveredText(str).toString();
            int length = 0;
            boolean z = false;
            while (true) {
                int iIndexOf = string.indexOf(str2, length);
                if (iIndexOf <= -1) {
                    break;
                }
                z = true;
                addToken(sb, arrayList, string.substring(length, iIndexOf), true);
                length = str2.length() + iIndexOf;
            }
            if (z) {
                addToken(sb, arrayList, string.substring(length), false);
            } else {
                addToken(sb, arrayList, string, false);
            }
        }
        return new TokenSample(sb.toString(), (Span[]) arrayList.toArray(new Span[0]));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TokenSample) {
            TokenSample tokenSample = (TokenSample) obj;
            if (getText().equals(tokenSample.getText()) && Arrays.equals(getTokenSpans(), tokenSample.getTokenSpans())) {
                return true;
            }
        }
        return false;
    }

    public String getText() {
        return this.text;
    }

    public Span[] getTokenSpans() {
        return (Span[]) this.tokenSpans.toArray(new Span[0]);
    }

    public int hashCode() {
        return Objects.hash(getText(), Integer.valueOf(Arrays.hashCode(getTokenSpans())));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int end = -1;
        for (Span span : this.tokenSpans) {
            if (end != -1) {
                sb.append(end == span.getStart() ? "<SPLIT>" : " ");
            }
            sb.append(span.getCoveredText(this.text));
            end = span.getEnd();
        }
        return sb.toString();
    }

    public TokenSample(Detokenizer detokenizer, String[] strArr) {
        Objects.requireNonNull(detokenizer, "detokenizer must not be null");
        Objects.requireNonNull(strArr, "tokens must not be null");
        Detokenizer.DetokenizationOperation[] detokenizationOperationArrDetokenize = detokenizer.detokenize(strArr);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < detokenizationOperationArrDetokenize.length; i++) {
            if (i > 0 && !isMergeToRight(detokenizationOperationArrDetokenize[i - 1]) && !isMergeToLeft(detokenizationOperationArrDetokenize[i])) {
                sb.append(' ');
            }
            int length = sb.length();
            sb.append(strArr[i]);
            arrayList.add(new Span(length, sb.length()));
        }
        this.text = sb.toString();
        this.tokenSpans = Collections.unmodifiableList(arrayList);
    }
}
