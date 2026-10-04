package org.apache.commons.text.p223io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.TextStringBuilder;
import org.apache.commons.text.matcher.StringMatcher;
import org.apache.commons.text.matcher.StringMatcherFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringSubstitutorReader extends FilterReader {
    private static final int EOS = -1;
    private final TextStringBuilder buffer;
    private boolean eos;
    private final StringMatcher prefixEscapeMatcher;
    private final char[] read1CharBuffer;
    private final StringSubstitutor stringSubstitutor;
    private int toDrain;

    public StringSubstitutorReader(Reader reader, StringSubstitutor stringSubstitutor) {
        super(reader);
        this.buffer = new TextStringBuilder();
        this.read1CharBuffer = new char[]{0};
        this.stringSubstitutor = new StringSubstitutor(stringSubstitutor);
        this.prefixEscapeMatcher = StringMatcherFactory.INSTANCE.charMatcher(stringSubstitutor.getEscapeChar()).andThen(stringSubstitutor.getVariablePrefixMatcher());
    }

    private int buffer(int i) throws IOException {
        int from = this.buffer.readFrom(((FilterReader) this).in, i);
        this.eos = from == -1;
        return from;
    }

    private int bufferOrDrainOnEos(int i, char[] cArr, int i2, int i4) {
        return drainOnEos(buffer(i), cArr, i2, i4);
    }

    private int drain(char[] cArr, int i, int i2) {
        int iDrainChars = this.buffer.drainChars(0, Math.min(this.buffer.length(), i2), cArr, i);
        this.toDrain -= iDrainChars;
        if (!this.buffer.isEmpty() && this.toDrain != 0) {
            return iDrainChars;
        }
        this.toDrain = 0;
        return iDrainChars;
    }

    private int drainOnEos(int i, char[] cArr, int i2, int i4) {
        if (i != -1) {
            return i;
        }
        if (!this.buffer.isNotEmpty()) {
            return -1;
        }
        this.toDrain = this.buffer.size();
        return drain(cArr, i2, i4);
    }

    private boolean isBufferMatchAt(StringMatcher stringMatcher, int i) {
        return stringMatcher.isMatch(this.buffer, i) == stringMatcher.size();
    }

    private boolean isDraining() {
        return this.toDrain > 0;
    }

    private int readCount(int i, int i2) {
        int size = this.buffer.size() - i2;
        if (size >= i) {
            return 0;
        }
        return i - size;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        int i;
        do {
            i = read(this.read1CharBuffer, 0, 1);
            if (i == -1) {
                return -1;
            }
        } while (i < 1);
        return this.read1CharBuffer[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bc, code lost:
    
        if (r2 > 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bf, code lost:
    
        r12 = r9.stringSubstitutor.getVariableSuffixMatcher();
        r4 = java.lang.Math.max(r4, r12.size());
        buffer(readCount(r4, r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d6, code lost:
    
        if (r9.eos == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d8, code lost:
    
        r9.stringSubstitutor.replaceIn(r9.buffer);
        r9.toDrain = r9.buffer.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ed, code lost:
    
        return (r3 + drain(r10, r3, r2)) - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f2, code lost:
    
        if (isBufferMatchAt(r12, r6) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f4, code lost:
    
        r7 = r7 - 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f8, code lost:
    
        if (r7 != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ff, code lost:
    
        if (isBufferMatchAt(r5, r6) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0101, code lost:
    
        r7 = r7 + 1;
        r8 = r5.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0107, code lost:
    
        r6 = r8 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0110, code lost:
    
        if (isBufferMatchAt(r9.prefixEscapeMatcher, r6) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0112, code lost:
    
        r7 = r7 + 1;
        r8 = r9.prefixEscapeMatcher.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011b, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0125, code lost:
    
        if (buffer(readCount(r4, r6)) != (-1)) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012d, code lost:
    
        if (r6 < r9.buffer.size()) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012f, code lost:
    
        r1 = java.lang.Math.max(0, r9.buffer.size() - r6);
        r4 = r9.stringSubstitutor;
        r5 = r9.buffer;
        r4.replaceIn(r5, 0, java.lang.Math.min(r5.size(), r6 + 1));
        r12 = r9.buffer.size() - r1;
        r0 = java.lang.Math.min(r2, r12);
        r9.toDrain = r12;
        drain(r10, r3, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015d, code lost:
    
        return (r3 - r11) + r0;
     */
    @Override // java.io.FilterReader, java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i4;
        int i5;
        int size;
        int i6;
        int iBufferOrDrainOnEos;
        if (this.eos && this.buffer.isEmpty()) {
            return -1;
        }
        if (i2 <= 0) {
            return 0;
        }
        if (isDraining()) {
            int iDrain = drain(cArr, i, Math.min(this.toDrain, i2));
            if (iDrain != i2) {
                i4 = i + iDrain;
                i5 = i2 - iDrain;
            }
            return i2;
        }
        i4 = i;
        i5 = i2;
        int size2 = this.prefixEscapeMatcher.size();
        buffer(readCount(size2, 0));
        if (this.buffer.length() < size2 && i5 < size2) {
            int iDrain2 = (i4 + drain(cArr, i4, i5)) - i;
            if (!this.eos || iDrain2 > 0) {
                return iDrain2;
            }
            return -1;
        }
        if (this.eos) {
            this.stringSubstitutor.replaceIn(this.buffer);
            this.toDrain = this.buffer.size();
            int iDrain3 = (i4 + drain(cArr, i4, i5)) - i;
            if (!this.eos || iDrain3 > 0) {
                return iDrain3;
            }
            return -1;
        }
        StringMatcher variablePrefixMatcher = this.stringSubstitutor.getVariablePrefixMatcher();
        while (true) {
            if (i5 <= 0) {
                size = 0;
                i6 = 0;
                break;
            }
            i6 = 1;
            if (isBufferMatchAt(variablePrefixMatcher, 0)) {
                size = variablePrefixMatcher.size();
                break;
            }
            if (isBufferMatchAt(this.prefixEscapeMatcher, 0)) {
                size = this.prefixEscapeMatcher.size();
                break;
            }
            int iDrain4 = drain(cArr, i4, 1);
            i4 += iDrain4;
            i5 -= iDrain4;
            if (this.buffer.size() < size2) {
                iBufferOrDrainOnEos = bufferOrDrainOnEos(size2, cArr, i4, i5);
                if (this.eos || isDraining()) {
                    break;
                }
            }
        }
        if (iBufferOrDrainOnEos != -1) {
            i4 += iBufferOrDrainOnEos;
        }
        int i7 = i4 - i;
        if (i7 > 0) {
            return i7;
        }
        return -1;
    }
}
