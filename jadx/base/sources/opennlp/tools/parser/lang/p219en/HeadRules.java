package opennlp.tools.parser.lang.p219en;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.Constituent;
import opennlp.tools.parser.GapLabeler;
import opennlp.tools.parser.Parse;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.SerializableArtifact;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HeadRules implements opennlp.tools.parser.HeadRules, GapLabeler, SerializableArtifact {
    private Map<String, HeadRule> headRules;
    private final Set<String> punctSet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeadRule {
        public final boolean leftToRight;
        public final String[] tags;

        public HeadRule(boolean z, String[] strArr) {
            this.leftToRight = z;
            for (String str : strArr) {
                Objects.requireNonNull(str, "tags must not contain null values");
            }
            this.tags = strArr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof HeadRule) {
                HeadRule headRule = (HeadRule) obj;
                if (headRule.leftToRight == this.leftToRight && Arrays.equals(headRule.tags, this.tags)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(this.leftToRight), Integer.valueOf(Arrays.hashCode(this.tags)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeadRulesSerializer implements ArtifactSerializer<HeadRules> {
        @Override // opennlp.tools.util.model.ArtifactSerializer
        public HeadRules create(InputStream inputStream) {
            return new HeadRules(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)));
        }

        @Override // opennlp.tools.util.model.ArtifactSerializer
        public void serialize(HeadRules headRules, OutputStream outputStream) throws IOException {
            headRules.serialize(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        }
    }

    public HeadRules(Reader reader) throws IOException {
        readHeadRules(new BufferedReader(reader));
        HashSet hashSet = new HashSet();
        this.punctSet = hashSet;
        hashSet.add(Extension.DOT);
        hashSet.add(",");
        hashSet.add("``");
        hashSet.add("''");
    }

    private void readHeadRules(BufferedReader bufferedReader) throws IOException {
        this.headRules = new HashMap(30);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            String strNextToken = stringTokenizer.nextToken();
            String strNextToken2 = stringTokenizer.nextToken();
            String strNextToken3 = stringTokenizer.nextToken();
            String[] strArr = new String[Integer.parseInt(strNextToken) - 2];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                strArr[i] = stringTokenizer.nextToken();
                i++;
            }
            this.headRules.put(strNextToken2, new HeadRule(strNextToken3.equals("1"), strArr));
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HeadRules) {
            HeadRules headRules = (HeadRules) obj;
            if (headRules.headRules.equals(this.headRules) && headRules.punctSet.equals(this.punctSet)) {
                return true;
            }
        }
        return false;
    }

    @Override // opennlp.tools.util.model.SerializableArtifact
    public Class<?> getArtifactSerializerClass() {
        return HeadRulesSerializer.class;
    }

    @Override // opennlp.tools.parser.HeadRules
    public Parse getHead(Parse[] parseArr, String str) {
        int i = 0;
        if (AbstractBottomUpParser.TOK_NODE.equals(parseArr[0].getType())) {
            return null;
        }
        if (!str.equals("NP") && !str.equals("NX")) {
            HeadRule headRule = this.headRules.get(str);
            if (headRule == null) {
                return parseArr[parseArr.length - 1].getHead();
            }
            String[] strArr = headRule.tags;
            int length = parseArr.length;
            int length2 = strArr.length;
            if (!headRule.leftToRight) {
                int length3 = strArr.length;
                while (i < length3) {
                    String str2 = strArr[i];
                    for (int i2 = length - 1; i2 >= 0; i2--) {
                        if (parseArr[i2].getType().equals(str2)) {
                            return parseArr[i2].getHead();
                        }
                    }
                    i++;
                }
                return parseArr[length - 1].getHead();
            }
            for (String str3 : strArr) {
                for (Parse parse : parseArr) {
                    if (parse.getType().equals(str3)) {
                        return parse.getHead();
                    }
                }
            }
            return parseArr[0].getHead();
        }
        String[] strArr2 = {"NN", "NNP", "NNPS", "NNS", "NX", "JJR", "POS"};
        for (int length4 = parseArr.length - 1; length4 >= 0; length4--) {
            for (int i4 = 6; i4 >= 0; i4--) {
                if (parseArr[length4].getType().equals(strArr2[i4])) {
                    return parseArr[length4].getHead();
                }
            }
        }
        int length5 = parseArr.length;
        while (i < length5) {
            Parse parse2 = parseArr[i];
            if (parse2.getType().equals("NP")) {
                return parse2.getHead();
            }
            i++;
        }
        String[] strArr3 = {"$", "ADJP", "PRN"};
        for (int length6 = parseArr.length - 1; length6 >= 0; length6--) {
            for (int i5 = 2; i5 >= 0; i5--) {
                if (parseArr[length6].getType().equals(strArr3[i5])) {
                    return parseArr[length6].getHead();
                }
            }
        }
        String[] strArr4 = {"JJ", "JJS", "RB", "QP"};
        for (int length7 = parseArr.length - 1; length7 >= 0; length7--) {
            for (int i6 = 3; i6 >= 0; i6--) {
                if (parseArr[length7].getType().equals(strArr4[i6])) {
                    return parseArr[length7].getHead();
                }
            }
        }
        return parseArr[parseArr.length - 1].getHead();
    }

    @Override // opennlp.tools.parser.HeadRules
    public Set<String> getPunctuationTags() {
        return this.punctSet;
    }

    public int hashCode() {
        return Objects.hash(this.headRules, this.punctSet);
    }

    @Override // opennlp.tools.parser.GapLabeler
    public void labelGaps(Stack<Constituent> stack) {
        if (stack.size() > 4) {
            Constituent constituent = stack.get(stack.size() - 2);
            Constituent constituent2 = stack.get(stack.size() - 3);
            Constituent constituent3 = stack.get(stack.size() - 4);
            Constituent constituent4 = stack.get(stack.size() - 5);
            if (constituent.getLabel().equals("NP") && constituent2.getLabel().equals("S") && constituent3.getLabel().equals("SBAR")) {
                constituent.setLabel(constituent.getLabel() + "-G");
                constituent2.setLabel(constituent2.getLabel() + "-G");
                constituent3.setLabel(constituent3.getLabel() + "-G");
                return;
            }
            if (constituent.getLabel().equals("NP") && constituent2.getLabel().equals("VP") && constituent3.getLabel().equals("S") && constituent4.getLabel().equals("SBAR")) {
                constituent.setLabel(constituent.getLabel() + "-G");
                constituent2.setLabel(constituent2.getLabel() + "-G");
                constituent3.setLabel(constituent3.getLabel() + "-G");
                constituent4.setLabel(constituent4.getLabel() + "-G");
            }
        }
    }

    public void serialize(Writer writer) throws IOException {
        for (Map.Entry<String, HeadRule> entry : this.headRules.entrySet()) {
            String key = entry.getKey();
            HeadRule value = entry.getValue();
            writer.write(Integer.toString(value.tags.length + 2));
            writer.write(32);
            writer.write(key);
            writer.write(32);
            if (value.leftToRight) {
                writer.write("1");
            } else {
                writer.write("0");
            }
            for (String str : value.tags) {
                writer.write(32);
                writer.write(str);
            }
            writer.write(10);
        }
        writer.flush();
    }
}
