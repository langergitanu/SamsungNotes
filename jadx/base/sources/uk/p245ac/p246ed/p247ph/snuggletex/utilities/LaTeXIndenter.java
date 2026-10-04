package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class LaTeXIndenter {
    private static final String BEGIN = "\\begin";
    public static final int DEFAULT_INDENT_WIDTH = 2;
    public static final int DEFAULT_MAX_INDENT_LEVEL = 10;
    private static final String END = "\\end";
    private int blankLineCount;
    private int indentLevel;
    private final Writer outputWriter;
    private ParsingState parsingState;
    private boolean verbatimMode;
    private static final String LINE_SEPARATOR = System.getProperty(SystemProperties.LINE_SEPARATOR);
    private static final Pattern BEGIN_PATTERN = Pattern.compile("\\\\begin\\s*+\\{(.+?)\\}");
    private static final Pattern END_PATTERN = Pattern.compile("\\\\end\\s*+\\{(.+?)\\}");
    private int indentWidth = 2;
    private int maxIndentLevel = 10;
    private boolean compactingBlankLines = true;

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.utilities.LaTeXIndenter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144961 {

        /* JADX INFO: renamed from: $SwitchMap$uk$ac$ed$ph$snuggletex$utilities$LaTeXIndenter$ParsingState */
        static final /* synthetic */ int[] f10308x581c8729;

        static {
            int[] iArr = new int[ParsingState.values().length];
            f10308x581c8729 = iArr;
            try {
                iArr[ParsingState.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10308x581c8729[ParsingState.EMPTY_LINES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10308x581c8729[ParsingState.BEGIN_DECLARATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10308x581c8729[ParsingState.END_DECLARATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ParsingState {
        DEFAULT,
        EMPTY_LINES,
        BEGIN_DECLARATION,
        END_DECLARATION
    }

    public LaTeXIndenter(Writer writer) {
        this.outputWriter = writer;
        reset();
    }

    private void createIndent(int i) throws IOException {
        int i2 = this.maxIndentLevel;
        if (i > i2) {
            i = i2;
        }
        int i4 = i * this.indentWidth;
        for (int i5 = 0; i5 < i4; i5++) {
            this.outputWriter.write(32);
        }
    }

    private void handleLine(String str) throws IOException {
        String str2 = LINE_SEPARATOR;
        String strReplace = str.replace(str2, "");
        if (!this.verbatimMode) {
            strReplace = strReplace.trim();
        }
        boolean z = !this.verbatimMode && strReplace.length() == 0;
        int i = C144961.f10308x581c8729[this.parsingState.ordinal()];
        if (i == 1) {
            if (!z) {
                handleLineInDefaultState(strReplace);
                return;
            } else {
                this.parsingState = ParsingState.EMPTY_LINES;
                this.blankLineCount++;
                return;
            }
        }
        if (i == 2) {
            if (z) {
                this.blankLineCount++;
                return;
            }
            this.outputWriter.write(str2);
            if (!this.compactingBlankLines) {
                for (int i2 = 1; i2 < this.blankLineCount; i2++) {
                    this.outputWriter.write(LINE_SEPARATOR);
                }
            }
            this.blankLineCount = 0;
            this.parsingState = ParsingState.DEFAULT;
            handleLineInDefaultState(strReplace);
            return;
        }
        if (i == 3) {
            if (z) {
                return;
            }
            this.parsingState = ParsingState.DEFAULT;
            handleLineInDefaultState(AbstractC0541b.m772n(BEGIN, strReplace));
            return;
        }
        if (i != 4) {
            throw new IllegalStateException("Unexpected switch case " + this.parsingState);
        }
        if (z) {
            return;
        }
        this.parsingState = ParsingState.DEFAULT;
        handleLineInDefaultState(AbstractC0541b.m772n(END, strReplace));
    }

    private void handleLineFragmentInDefaultState(String str) throws IOException {
        boolean z;
        if (this.verbatimMode) {
            z = false;
        } else {
            if (str.startsWith(END)) {
                this.indentLevel--;
                z = true;
            } else {
                z = false;
            }
            createIndent(this.indentLevel);
        }
        this.outputWriter.write(str);
        this.outputWriter.write(LINE_SEPARATOR);
        Matcher matcher = END_PATTERN.matcher(str);
        while (matcher.find()) {
            if (!this.verbatimMode) {
                this.indentLevel--;
            } else if (matcher.group(1).equals("verbatim")) {
                this.verbatimMode = false;
            }
        }
        if (z) {
            this.indentLevel++;
        }
        Matcher matcher2 = BEGIN_PATTERN.matcher(str);
        while (matcher2.find()) {
            if (!this.verbatimMode) {
                if (matcher2.group(1).equals("verbatim")) {
                    this.verbatimMode = true;
                } else {
                    this.indentLevel++;
                }
            }
        }
    }

    private void handleLineInDefaultState(String str) throws IOException {
        if (str.endsWith(BEGIN)) {
            handleLineFragmentInDefaultState(AbstractC2322a.m1614d(6, 0, str));
            this.parsingState = ParsingState.BEGIN_DECLARATION;
        } else if (!str.endsWith(END)) {
            handleLineFragmentInDefaultState(str);
        } else {
            handleLineFragmentInDefaultState(AbstractC2322a.m1614d(4, 0, str));
            this.parsingState = ParsingState.END_DECLARATION;
        }
    }

    public int getIndentWidth() {
        return this.indentWidth;
    }

    public int getMaxIndentLevel() {
        return this.maxIndentLevel;
    }

    public boolean isCompactingBlankLines() {
        return this.compactingBlankLines;
    }

    public void reset() {
        this.indentLevel = 0;
        this.verbatimMode = false;
        this.blankLineCount = 0;
        this.parsingState = ParsingState.DEFAULT;
    }

    public void run(Reader reader) throws IOException {
        reset();
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                } else {
                    handleLine(line);
                }
            } finally {
                reader.close();
            }
        }
    }

    public void setCompactingBlankLines(boolean z) {
        this.compactingBlankLines = z;
    }

    public void setIndentWidth(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("indentWidth must be non-negative");
        }
        this.indentWidth = i;
    }

    public void setMaxIndentLevel(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("maxIndentLevel must be non-negative");
        }
        this.maxIndentLevel = i;
    }
}
