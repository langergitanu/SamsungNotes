package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import uk.p245ac.p246ed.p247ph.snuggletex.InputError;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleInput;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleLogicException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.CoreErrorCode;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.WorkingDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SnuggleInputReader implements WorkingDocument.SourceContext {
    private final SnuggleInput input;
    private int inputLength;
    private int[] newlineIndices = null;
    private WorkingDocument resultingDocument = null;
    private final SessionContext sessionContext;

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.internal.SnuggleInputReader$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144911 {
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType;

        static {
            int[] iArr = new int[SnuggleInput.InputType.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType = iArr;
            try {
                iArr[SnuggleInput.InputType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType[SnuggleInput.InputType.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType[SnuggleInput.InputType.INPUT_STREAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType[SnuggleInput.InputType.READER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SnuggleInputReader(SessionContext sessionContext, SnuggleInput snuggleInput) {
        this.sessionContext = sessionContext;
        this.input = snuggleInput;
    }

    private int[] calculateNewlineIndicesAndCheckCodePoints(StringBuilder sb) {
        int codePoint;
        ArrayList arrayList = new ArrayList();
        arrayList.add(-1);
        int length = sb.length();
        int i = 0;
        char c = 0;
        while (i < length) {
            char cCharAt = sb.charAt(i);
            if (cCharAt == '\n') {
                arrayList.add(Integer.valueOf(i));
            }
            if (Character.isHighSurrogate(c)) {
                if (Character.isLowSurrogate(cCharAt)) {
                    codePoint = Character.toCodePoint(c, cCharAt);
                    if (!Character.isISOControl(codePoint) && codePoint != 13 && codePoint != 10 && codePoint != 9) {
                        this.sessionContext.registerError(new InputError(CoreErrorCode.TTEG02, null, Integer.toHexString(codePoint), Integer.valueOf(i)));
                        sb.setCharAt(i, ' ');
                    }
                } else {
                    recordSurrogateError(sb, i - 1, c);
                }
            } else if (Character.isLowSurrogate(cCharAt)) {
                recordSurrogateError(sb, i, cCharAt);
            } else {
                codePoint = cCharAt;
                if (!Character.isISOControl(codePoint)) {
                }
            }
            i++;
            c = cCharAt;
        }
        if (Character.isHighSurrogate(c)) {
            recordSurrogateError(sb, sb.length() - 1, c);
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    private Reader createReader(InputStream inputStream, String str) {
        return str != null ? new InputStreamReader(inputStream, str) : new InputStreamReader(inputStream);
    }

    private StringBuilder readCharacterStream(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb;
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    private StringBuilder readInputData() {
        int i = C144911.$SwitchMap$uk$ac$ed$ph$snuggletex$SnuggleInput$InputType[this.input.getType().ordinal()];
        if (i == 1) {
            return new StringBuilder(this.input.getString());
        }
        if (i == 2) {
            return readCharacterStream(createReader(new FileInputStream(this.input.getFile()), this.input.getEncoding()));
        }
        if (i == 3) {
            return readCharacterStream(createReader(this.input.getInputStream(), this.input.getEncoding()));
        }
        if (i == 4) {
            return readCharacterStream(this.input.getReader());
        }
        throw new SnuggleLogicException("Unexpected switch case: " + this.input.getType());
    }

    private void recordSurrogateError(StringBuilder sb, int i, char c) {
        this.sessionContext.registerError(new InputError(CoreErrorCode.TTEG05, null, Integer.toHexString(c), Integer.valueOf(i)));
        sb.setCharAt(i, ' ');
    }

    public WorkingDocument createWorkingDocument() {
        StringBuilder inputData = readInputData();
        this.inputLength = inputData.length();
        this.newlineIndices = calculateNewlineIndicesAndCheckCodePoints(inputData);
        WorkingDocument workingDocument = new WorkingDocument(inputData, this);
        this.resultingDocument = workingDocument;
        return workingDocument;
    }

    public SnuggleInput getInput() {
        return this.input;
    }

    public int[] getLineAndColumn(int i) {
        int[] iArr;
        if (this.newlineIndices == null) {
            throw new IllegalStateException("Input has not yet been read");
        }
        if (i < 0 || i > this.inputLength) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = 0;
        while (true) {
            iArr = this.newlineIndices;
            if (i2 >= iArr.length || iArr[i2] >= i) {
                break;
            }
            i2++;
        }
        return new int[]{i2, i - iArr[i2 - 1]};
    }

    public SessionContext getSessionContext() {
        return this.sessionContext;
    }
}
