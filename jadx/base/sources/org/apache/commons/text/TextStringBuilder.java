package org.apache.commons.text;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.C13834b;
import org.apache.commons.text.matcher.StringMatcher;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TextStringBuilder implements CharSequence, Appendable, Serializable, Builder<String> {
    static final int CAPACITY = 32;
    private static final int EOS = -1;
    private static final int MAX_BUFFER_SIZE = 2147483639;
    private static final char SPACE = ' ';
    private static final long serialVersionUID = 1;
    private char[] buffer;
    private String newLine;
    private String nullText;
    private int reallocations;
    private int size;
    private static final int FALSE_STRING_SIZE = Boolean.FALSE.toString().length();
    private static final int TRUE_STRING_SIZE = Boolean.TRUE.toString().length();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class TextStringBuilderTokenizer extends StringTokenizer {
        public TextStringBuilderTokenizer() {
        }

        @Override // org.apache.commons.text.StringTokenizer
        public String getContent() {
            String content = super.getContent();
            return content == null ? TextStringBuilder.this.toString() : content;
        }

        @Override // org.apache.commons.text.StringTokenizer
        public List<String> tokenize(char[] cArr, int i, int i2) {
            return cArr == null ? super.tokenize(TextStringBuilder.this.getBuffer(), 0, TextStringBuilder.this.size()) : super.tokenize(cArr, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class TextStringBuilderWriter extends Writer {
        public TextStringBuilderWriter() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            TextStringBuilder.this.append(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            TextStringBuilder.this.append(cArr, i, i2);
        }

        @Override // java.io.Writer
        public void write(int i) {
            TextStringBuilder.this.append((char) i);
        }

        @Override // java.io.Writer
        public void write(String str) {
            TextStringBuilder.this.append(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) {
            TextStringBuilder.this.append(str, i, i2);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }

    public TextStringBuilder() {
        this(32);
    }

    private void appendFalse(int i) {
        char[] cArr = this.buffer;
        cArr[i] = 'f';
        cArr[i + 1] = 'a';
        cArr[i + 2] = 'l';
        cArr[i + 3] = 's';
        cArr[i + 4] = 'e';
        this.size += FALSE_STRING_SIZE;
    }

    private void appendTrue(int i) {
        char[] cArr = this.buffer;
        cArr[i] = 't';
        cArr[i + 1] = 'r';
        cArr[i + 2] = 'u';
        cArr[i + 3] = 'e';
        this.size += TRUE_STRING_SIZE;
    }

    private static int createPositiveCapacity(int i) {
        if (i >= 0) {
            return Math.max(i, MAX_BUFFER_SIZE);
        }
        throw new OutOfMemoryError("Unable to allocate array size: " + Integer.toUnsignedString(i));
    }

    private void deleteImpl(int i, int i2, int i4) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i2, cArr, i, this.size - i2);
        this.size -= i4;
    }

    private void ensureCapacityInternal(int i) {
        if (i - this.buffer.length > 0) {
            resizeBuffer(i);
        }
    }

    private void reallocate(int i) {
        this.buffer = Arrays.copyOf(this.buffer, i);
        this.reallocations++;
    }

    private void replaceImpl(int i, int i2, int i4, String str, int i5) {
        int i6 = (this.size - i4) + i5;
        if (i5 != i4) {
            ensureCapacityInternal(i6);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i2, cArr, i + i5, this.size - i2);
            this.size = i6;
        }
        if (i5 > 0) {
            str.getChars(0, i5, this.buffer, i);
        }
    }

    private void resizeBuffer(int i) {
        int length = this.buffer.length * 2;
        if (Integer.compareUnsigned(length, i) < 0) {
            length = i;
        }
        if (Integer.compareUnsigned(length, MAX_BUFFER_SIZE) > 0) {
            length = createPositiveCapacity(i);
        }
        reallocate(length);
    }

    public static TextStringBuilder wrap(char[] cArr) {
        Objects.requireNonNull(cArr, "initialBuffer");
        return new TextStringBuilder(cArr, cArr.length);
    }

    public TextStringBuilder appendAll(Iterable<?> iterable) {
        if (iterable != null) {
            iterable.forEach(new C13834b(this, 7));
        }
        return this;
    }

    public TextStringBuilder appendFixedWidthPadLeft(int i, int i2, char c) {
        return appendFixedWidthPadLeft(String.valueOf(i), i2, c);
    }

    public TextStringBuilder appendFixedWidthPadRight(int i, int i2, char c) {
        return appendFixedWidthPadRight(String.valueOf(i), i2, c);
    }

    public TextStringBuilder appendNewLine() {
        String str = this.newLine;
        if (str != null) {
            return append(str);
        }
        append(System.lineSeparator());
        return this;
    }

    public TextStringBuilder appendNull() {
        String str = this.nullText;
        return str == null ? this : append(str);
    }

    public TextStringBuilder appendPadding(int i, char c) {
        if (i >= 0) {
            ensureCapacityInternal(this.size + i);
            for (int i2 = 0; i2 < i; i2++) {
                char[] cArr = this.buffer;
                int i4 = this.size;
                this.size = i4 + 1;
                cArr[i4] = c;
            }
        }
        return this;
    }

    public TextStringBuilder appendSeparator(char c) {
        if (isNotEmpty()) {
            append(c);
        }
        return this;
    }

    public void appendTo(Appendable appendable) throws IOException {
        if (appendable instanceof Writer) {
            ((Writer) appendable).write(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuilder) {
            ((StringBuilder) appendable).append(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuffer) {
            ((StringBuffer) appendable).append(this.buffer, 0, this.size);
        } else if (appendable instanceof CharBuffer) {
            ((CharBuffer) appendable).put(this.buffer, 0, this.size);
        } else {
            appendable.append(this);
        }
    }

    public TextStringBuilder appendWithSeparators(Iterable<?> iterable, String str) {
        if (iterable != null) {
            appendWithSeparators(iterable.iterator(), str);
        }
        return this;
    }

    public TextStringBuilder appendln(boolean z) {
        return append(z).appendNewLine();
    }

    public Reader asReader() {
        return new TextStringBuilderReader();
    }

    public StringTokenizer asTokenizer() {
        return new TextStringBuilderTokenizer();
    }

    public Writer asWriter() {
        return new TextStringBuilderWriter();
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        validateIndex(i);
        return this.buffer[i];
    }

    public TextStringBuilder clear() {
        this.size = 0;
        return this;
    }

    public boolean contains(char c) {
        char[] cArr = this.buffer;
        for (int i = 0; i < this.size; i++) {
            if (cArr[i] == c) {
                return true;
            }
        }
        return false;
    }

    public TextStringBuilder delete(int i, int i2) {
        int iValidateRange = validateRange(i, i2);
        int i4 = iValidateRange - i;
        if (i4 > 0) {
            deleteImpl(i, iValidateRange, i4);
        }
        return this;
    }

    public TextStringBuilder deleteAll(char c) {
        int i = 0;
        while (i < this.size) {
            if (this.buffer[i] == c) {
                int i2 = i;
                do {
                    i2++;
                    if (i2 >= this.size) {
                        break;
                    }
                } while (this.buffer[i2] == c);
                int i4 = i2 - i;
                deleteImpl(i, i2, i4);
                i = i2 - i4;
            }
            i++;
        }
        return this;
    }

    public TextStringBuilder deleteCharAt(int i) {
        validateIndex(i);
        deleteImpl(i, i + 1, 1);
        return this;
    }

    public TextStringBuilder deleteFirst(char c) {
        for (int i = 0; i < this.size; i++) {
            if (this.buffer[i] == c) {
                deleteImpl(i, i + 1, 1);
                return this;
            }
        }
        return this;
    }

    public char drainChar(int i) {
        validateIndex(i);
        char c = this.buffer[i];
        deleteCharAt(i);
        return c;
    }

    public int drainChars(int i, int i2, char[] cArr, int i4) {
        int i5 = i2 - i;
        if (isEmpty() || i5 == 0 || cArr.length == 0) {
            return 0;
        }
        int iMin = Math.min(Math.min(this.size, i5), cArr.length - i4);
        getChars(i, iMin, cArr, i4);
        delete(i, iMin);
        return iMin;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i = this.size;
        if (length > i) {
            return false;
        }
        int i2 = i - length;
        int i4 = 0;
        while (i4 < length) {
            if (this.buffer[i2] != str.charAt(i4)) {
                return false;
            }
            i4++;
            i2++;
        }
        return true;
    }

    public TextStringBuilder ensureCapacity(int i) {
        if (i > 0) {
            ensureCapacityInternal(i);
        }
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof TextStringBuilder) && equals((TextStringBuilder) obj);
    }

    public boolean equalsIgnoreCase(TextStringBuilder textStringBuilder) {
        if (this == textStringBuilder) {
            return true;
        }
        int i = this.size;
        if (i != textStringBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = textStringBuilder.buffer;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            char c = cArr[i2];
            char c2 = cArr2[i2];
            if (c != c2 && Character.toUpperCase(c) != Character.toUpperCase(c2)) {
                return false;
            }
        }
        return true;
    }

    public char[] getBuffer() {
        return this.buffer;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        System.arraycopy(this.buffer, 0, cArr, 0, length);
        return cArr;
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        char[] cArr = this.buffer;
        int i = 0;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + cArr[i2];
        }
        return i;
    }

    public int indexOf(char c) {
        return indexOf(c, 0);
    }

    public TextStringBuilder insert(int i, boolean z) {
        validateIndex(i);
        if (z) {
            int i2 = this.size;
            int i4 = TRUE_STRING_SIZE;
            ensureCapacityInternal(i2 + i4);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i, cArr, i4 + i, this.size - i);
            appendTrue(i);
            return this;
        }
        int i5 = this.size;
        int i6 = FALSE_STRING_SIZE;
        ensureCapacityInternal(i5 + i6);
        char[] cArr2 = this.buffer;
        System.arraycopy(cArr2, i, cArr2, i6 + i, this.size - i);
        appendFalse(i);
        return this;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isNotEmpty() {
        return this.size != 0;
    }

    public boolean isReallocated() {
        return this.reallocations > 0;
    }

    public int lastIndexOf(char c) {
        return lastIndexOf(c, this.size - 1);
    }

    public String leftString(int i) {
        if (i <= 0) {
            return "";
        }
        int i2 = this.size;
        return i >= i2 ? new String(this.buffer, 0, i2) : new String(this.buffer, 0, i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.size;
    }

    public String midString(int i, int i2) {
        int i4;
        if (i < 0) {
            i = 0;
        }
        return (i2 <= 0 || i >= (i4 = this.size)) ? "" : i4 <= i + i2 ? new String(this.buffer, i, i4 - i) : new String(this.buffer, i, i2);
    }

    public TextStringBuilder minimizeCapacity() {
        int length = this.buffer.length;
        int i = this.size;
        if (length > i) {
            reallocate(i);
        }
        return this;
    }

    public int readFrom(CharBuffer charBuffer) {
        int i = this.size;
        int iRemaining = charBuffer.remaining();
        ensureCapacityInternal(this.size + iRemaining);
        charBuffer.get(this.buffer, this.size, iRemaining);
        int i2 = this.size + iRemaining;
        this.size = i2;
        return i2 - i;
    }

    public TextStringBuilder replace(int i, int i2, String str) {
        int iValidateRange = validateRange(i, i2);
        replaceImpl(i, iValidateRange, iValidateRange - i, str, str == null ? 0 : str.length());
        return this;
    }

    public TextStringBuilder replaceAll(char c, char c2) {
        if (c != c2) {
            for (int i = 0; i < this.size; i++) {
                char[] cArr = this.buffer;
                if (cArr[i] == c) {
                    cArr[i] = c2;
                }
            }
        }
        return this;
    }

    public TextStringBuilder replaceFirst(char c, char c2) {
        if (c != c2) {
            for (int i = 0; i < this.size; i++) {
                char[] cArr = this.buffer;
                if (cArr[i] == c) {
                    cArr[i] = c2;
                    return this;
                }
            }
        }
        return this;
    }

    public TextStringBuilder reverse() {
        int i = this.size;
        if (i != 0) {
            int i2 = i / 2;
            char[] cArr = this.buffer;
            int i4 = i - 1;
            int i5 = 0;
            while (i5 < i2) {
                char c = cArr[i5];
                cArr[i5] = cArr[i4];
                cArr[i4] = c;
                i5++;
                i4--;
            }
        }
        return this;
    }

    public String rightString(int i) {
        if (i <= 0) {
            return "";
        }
        int i2 = this.size;
        return i >= i2 ? new String(this.buffer, 0, i2) : new String(this.buffer, i2 - i, i);
    }

    public TextStringBuilder set(CharSequence charSequence) {
        clear();
        append(charSequence);
        return this;
    }

    public TextStringBuilder setCharAt(int i, char c) {
        validateIndex(i);
        this.buffer[i] = c;
        return this;
    }

    public TextStringBuilder setLength(int i) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        int i2 = this.size;
        if (i < i2) {
            this.size = i;
            return this;
        }
        if (i > i2) {
            ensureCapacityInternal(i);
            int i4 = this.size;
            this.size = i;
            Arrays.fill(this.buffer, i4, i, (char) 0);
        }
        return this;
    }

    public TextStringBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public TextStringBuilder setNullText(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 > this.size) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i <= i2) {
            return substring(i, i2);
        }
        throw new StringIndexOutOfBoundsException(i2 - i);
    }

    public String substring(int i) {
        return substring(i, this.size);
    }

    public char[] toCharArray() {
        int i = this.size;
        return i == 0 ? ArrayUtils.EMPTY_CHAR_ARRAY : Arrays.copyOf(this.buffer, i);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        stringBuffer.append(this.buffer, 0, this.size);
        return stringBuffer;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(this.size);
        sb.append(this.buffer, 0, this.size);
        return sb;
    }

    public TextStringBuilder trim() {
        int i = this.size;
        if (i != 0) {
            char[] cArr = this.buffer;
            int i2 = 0;
            while (i2 < i && cArr[i2] <= ' ') {
                i2++;
            }
            while (i2 < i && cArr[i - 1] <= ' ') {
                i--;
            }
            int i4 = this.size;
            if (i < i4) {
                delete(i, i4);
            }
            if (i2 > 0) {
                delete(0, i2);
            }
        }
        return this;
    }

    public void validateIndex(int i) {
        if (i < 0 || i >= this.size) {
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    public int validateRange(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        int i4 = this.size;
        if (i2 > i4) {
            i2 = i4;
        }
        if (i <= i2) {
            return i2;
        }
        throw new StringIndexOutOfBoundsException("end < start");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class TextStringBuilderReader extends Reader {
        private int mark;
        private int pos;

        public TextStringBuilderReader() {
        }

        @Override // java.io.Reader
        public void mark(int i) {
            this.mark = this.pos;
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.Reader
        public int read() {
            if (!ready()) {
                return -1;
            }
            TextStringBuilder textStringBuilder = TextStringBuilder.this;
            int i = this.pos;
            this.pos = i + 1;
            return textStringBuilder.charAt(i);
        }

        @Override // java.io.Reader
        public boolean ready() {
            return this.pos < TextStringBuilder.this.size();
        }

        @Override // java.io.Reader
        public void reset() {
            this.pos = this.mark;
        }

        @Override // java.io.Reader
        public long skip(long j) {
            if (((long) this.pos) + j > TextStringBuilder.this.size()) {
                j = TextStringBuilder.this.size() - this.pos;
            }
            if (j < 0) {
                return 0L;
            }
            this.pos = Math.addExact(this.pos, Math.toIntExact(j));
            return j;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            int i4;
            if (i < 0 || i2 < 0 || i > cArr.length || (i4 = i + i2) > cArr.length || i4 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.pos >= TextStringBuilder.this.size()) {
                return -1;
            }
            if (this.pos + i2 > TextStringBuilder.this.size()) {
                i2 = TextStringBuilder.this.size() - this.pos;
            }
            TextStringBuilder textStringBuilder = TextStringBuilder.this;
            int i5 = this.pos;
            textStringBuilder.getChars(i5, i5 + i2, cArr, i);
            this.pos += i2;
            return i2;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    private TextStringBuilder(char[] cArr, int i) {
        Objects.requireNonNull(cArr, "initialBuffer");
        this.buffer = cArr;
        if (i >= 0 && i <= cArr.length) {
            this.size = i;
            return;
        }
        throw new IllegalArgumentException("initialBuffer.length=" + cArr.length + ", length=" + i);
    }

    public TextStringBuilder appendAll(Iterator<?> it) {
        if (it != null) {
            it.forEachRemaining(new C13834b(this, 7));
        }
        return this;
    }

    public TextStringBuilder appendFixedWidthPadLeft(Object obj, int i, char c) {
        if (i > 0) {
            ensureCapacityInternal(this.size + i);
            String string = Objects.toString(obj, getNullText());
            if (string == null) {
                string = "";
            }
            int length = string.length();
            if (length >= i) {
                string.getChars(length - i, length, this.buffer, this.size);
            } else {
                int i2 = this.size;
                int i4 = (i - length) + i2;
                Arrays.fill(this.buffer, i2, i4, c);
                string.getChars(0, length, this.buffer, i4);
            }
            this.size += i;
        }
        return this;
    }

    public TextStringBuilder appendFixedWidthPadRight(Object obj, int i, char c) {
        if (i > 0) {
            ensureCapacityInternal(this.size + i);
            String string = Objects.toString(obj, getNullText());
            if (string == null) {
                string = "";
            }
            int length = string.length();
            if (length >= i) {
                string.getChars(0, i, this.buffer, this.size);
            } else {
                string.getChars(0, length, this.buffer, this.size);
                int i2 = this.size + length;
                Arrays.fill(this.buffer, i2, (i2 + i) - length, c);
            }
            this.size += i;
        }
        return this;
    }

    public TextStringBuilder appendWithSeparators(Iterator<?> it, String str) {
        if (it != null) {
            String string = Objects.toString(str, "");
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(string);
                }
            }
        }
        return this;
    }

    public TextStringBuilder appendln(char c) {
        return append(c).appendNewLine();
    }

    @Override // org.apache.commons.text.Builder
    @Deprecated
    public String build() {
        return toString();
    }

    public boolean equals(TextStringBuilder textStringBuilder) {
        int i;
        if (this == textStringBuilder) {
            return true;
        }
        if (textStringBuilder == null || (i = this.size) != textStringBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = textStringBuilder.buffer;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (cArr[i2] != cArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.function.Supplier
    public String get() {
        return toString();
    }

    public int indexOf(char c, int i) {
        int iMax = Math.max(0, i);
        if (iMax >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (iMax < this.size) {
            if (cArr[iMax] == c) {
                return iMax;
            }
            iMax++;
        }
        return -1;
    }

    public int lastIndexOf(char c, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (i < 0) {
            return -1;
        }
        while (i >= 0) {
            if (this.buffer[i] == c) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public String substring(int i, int i2) {
        return new String(this.buffer, i, validateRange(i, i2) - i);
    }

    public char[] toCharArray(int i, int i2) {
        int iValidateRange = validateRange(i, i2);
        return iValidateRange - i == 0 ? ArrayUtils.EMPTY_CHAR_ARRAY : Arrays.copyOfRange(this.buffer, i, iValidateRange);
    }

    public static TextStringBuilder wrap(char[] cArr, int i) {
        return new TextStringBuilder(cArr, i);
    }

    public <T> TextStringBuilder appendAll(T... tArr) {
        if (tArr != null && tArr.length > 0) {
            for (T t : tArr) {
                append(t);
            }
        }
        return this;
    }

    public TextStringBuilder appendSeparator(char c, char c2) {
        if (isEmpty()) {
            append(c2);
            return this;
        }
        append(c);
        return this;
    }

    public TextStringBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public TextStringBuilder append(boolean z) {
        if (z) {
            ensureCapacityInternal(this.size + TRUE_STRING_SIZE);
            appendTrue(this.size);
            return this;
        }
        ensureCapacityInternal(this.size + FALSE_STRING_SIZE);
        appendFalse(this.size);
        return this;
    }

    public TextStringBuilder appendln(char[] cArr, int i, int i2) {
        return append(cArr, i, i2).appendNewLine();
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public TextStringBuilder deleteFirst(String str) {
        int iIndexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (iIndexOf = indexOf(str, 0)) >= 0) {
            deleteImpl(iIndexOf, iIndexOf + length, length);
        }
        return this;
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    public TextStringBuilder replace(StringMatcher stringMatcher, String str, int i, int i2, int i4) {
        return replaceImpl(stringMatcher, str, i, validateRange(i, i2), i4);
    }

    public TextStringBuilder replaceAll(String str, String str2) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int length2 = str2 == null ? 0 : str2.length();
            int iIndexOf = indexOf(str, 0);
            while (iIndexOf >= 0) {
                replaceImpl(iIndexOf, iIndexOf + length, length, str2, length2);
                iIndexOf = indexOf(str, iIndexOf + length2);
            }
        }
        return this;
    }

    public TextStringBuilder replaceFirst(String str, String str2) {
        int iIndexOf;
        int length = str == null ? 0 : str.length();
        if (length <= 0 || (iIndexOf = indexOf(str, 0)) < 0) {
            return this;
        }
        replaceImpl(iIndexOf, iIndexOf + length, length, str2, str2 != null ? str2.length() : 0);
        return this;
    }

    public TextStringBuilder appendln(double d) {
        return append(d).appendNewLine();
    }

    public boolean contains(StringMatcher stringMatcher) {
        return indexOf(stringMatcher, 0) >= 0;
    }

    public void getChars(int i, int i2, char[] cArr, int i4) {
        if (i >= 0) {
            if (i2 < 0 || i2 > length()) {
                throw new StringIndexOutOfBoundsException(i2);
            }
            if (i <= i2) {
                System.arraycopy(this.buffer, i, cArr, i4, i2 - i);
                return;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        r9 = r9 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int lastIndexOf(String str, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (str != null && i >= 0) {
            int length = str.length();
            if (length > 0 && length <= this.size) {
                if (length == 1) {
                    return lastIndexOf(str.charAt(0), i);
                }
                int i4 = (i - length) + 1;
                while (i4 >= 0) {
                    for (int i5 = 0; i5 < length; i5++) {
                        if (str.charAt(i5) != this.buffer[i4 + i5]) {
                            break;
                        }
                    }
                    return i4;
                }
            }
            if (length == 0) {
                return i;
            }
        }
        return -1;
    }

    private TextStringBuilder replaceImpl(StringMatcher stringMatcher, String str, int i, int i2, int i4) {
        String str2;
        if (stringMatcher != null && this.size != 0) {
            int length = str == null ? 0 : str.length();
            int i5 = i;
            while (i5 < i2 && i4 != 0) {
                int iIsMatch = stringMatcher.isMatch(this.buffer, i5, i, i2);
                if (iIsMatch > 0) {
                    str2 = str;
                    replaceImpl(i5, i5 + iIsMatch, iIsMatch, str2, length);
                    i2 = (i2 - iIsMatch) + length;
                    i5 = (i5 + length) - 1;
                    if (i4 > 0) {
                        i4--;
                    }
                } else {
                    str2 = str;
                }
                i5++;
                str = str2;
            }
        }
        return this;
    }

    public TextStringBuilder appendSeparator(char c, int i) {
        if (i > 0) {
            append(c);
        }
        return this;
    }

    public TextStringBuilder appendln(float f) {
        return append(f).appendNewLine();
    }

    public TextStringBuilder deleteAll(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int iIndexOf = indexOf(str, 0);
            while (iIndexOf >= 0) {
                deleteImpl(iIndexOf, iIndexOf + length, length);
                iIndexOf = indexOf(str, iIndexOf);
            }
        }
        return this;
    }

    public int readFrom(Readable readable) throws IOException {
        if (readable instanceof Reader) {
            return readFrom((Reader) readable);
        }
        if (readable instanceof CharBuffer) {
            return readFrom((CharBuffer) readable);
        }
        int i = this.size;
        while (true) {
            ensureCapacityInternal(this.size + 1);
            char[] cArr = this.buffer;
            int i2 = this.size;
            int i4 = readable.read(CharBuffer.wrap(cArr, i2, cArr.length - i2));
            if (i4 == -1) {
                return this.size - i;
            }
            this.size += i4;
        }
    }

    public TextStringBuilder(CharSequence charSequence) {
        this(StringUtils.length(charSequence) + 32);
        if (charSequence != null) {
            append(charSequence);
        }
    }

    public TextStringBuilder appendSeparator(String str) {
        return appendSeparator(str, (String) null);
    }

    public TextStringBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            String string = Objects.toString(str, "");
            append(objArr[0]);
            for (int i = 1; i < objArr.length; i++) {
                append(string);
                append(objArr[i]);
            }
        }
        return this;
    }

    public TextStringBuilder appendln(int i) {
        return append(i).appendNewLine();
    }

    public TextStringBuilder deleteFirst(StringMatcher stringMatcher) {
        return replace(stringMatcher, null, 0, this.size, 1);
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    @Override // java.lang.Appendable
    public TextStringBuilder append(char c) {
        ensureCapacityInternal(length() + 1);
        char[] cArr = this.buffer;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c;
        return this;
    }

    public TextStringBuilder appendSeparator(String str, int i) {
        if (str != null && i > 0) {
            append(str);
        }
        return this;
    }

    public TextStringBuilder appendln(long j) {
        return append(j).appendNewLine();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int indexOf(String str, int i) {
        int iMax = Math.max(0, i);
        if (str != null && iMax < this.size) {
            int length = str.length();
            if (length == 1) {
                return indexOf(str.charAt(0), iMax);
            }
            if (length == 0) {
                return iMax;
            }
            int i2 = this.size;
            if (length > i2) {
                return -1;
            }
            char[] cArr = this.buffer;
            int i4 = (i2 - length) + 1;
            while (iMax < i4) {
                for (int i5 = 0; i5 < length; i5++) {
                    if (str.charAt(i5) != cArr[iMax + i5]) {
                        break;
                    }
                }
                return iMax;
            }
        }
        return -1;
    }

    public TextStringBuilder insert(int i, char c) {
        validateIndex(i);
        ensureCapacityInternal(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i, cArr, i + 1, this.size - i);
        this.buffer[i] = c;
        this.size++;
        return this;
    }

    public TextStringBuilder replaceFirst(StringMatcher stringMatcher, String str) {
        return replace(stringMatcher, str, 0, this.size, 1);
    }

    public TextStringBuilder(int i) {
        this.buffer = new char[i <= 0 ? 32 : i];
    }

    public TextStringBuilder appendSeparator(String str, String str2) {
        if (isEmpty()) {
            str = str2;
        }
        if (str != null) {
            append(str);
        }
        return this;
    }

    public TextStringBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public TextStringBuilder replaceAll(StringMatcher stringMatcher, String str) {
        return replace(stringMatcher, str, 0, this.size, -1);
    }

    public TextStringBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    public TextStringBuilder deleteAll(StringMatcher stringMatcher) {
        return replace(stringMatcher, null, 0, this.size, -1);
    }

    public int lastIndexOf(StringMatcher stringMatcher) {
        return lastIndexOf(stringMatcher, this.size);
    }

    public TextStringBuilder(String str) {
        this(StringUtils.length(str) + 32);
        if (str != null) {
            append(str);
        }
    }

    public TextStringBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacityInternal(length2 + length);
            System.arraycopy(cArr, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public TextStringBuilder appendln(String str, int i, int i2) {
        return append(str, i, i2).appendNewLine();
    }

    public int lastIndexOf(StringMatcher stringMatcher, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (stringMatcher != null && i >= 0) {
            char[] cArr = this.buffer;
            int i4 = i + 1;
            while (i >= 0) {
                if (stringMatcher.isMatch(cArr, i, 0, i4) > 0) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public TextStringBuilder appendln(String str, Object... objArr) {
        return append(str, objArr).appendNewLine();
    }

    public TextStringBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public TextStringBuilder insert(int i, char[] cArr) {
        validateIndex(i);
        if (cArr == null) {
            return insert(i, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacityInternal(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i, cArr2, i + length, this.size - i);
            System.arraycopy(cArr, 0, this.buffer, i, length);
            this.size += length;
        }
        return this;
    }

    public TextStringBuilder appendln(StringBuffer stringBuffer, int i, int i2) {
        return append(stringBuffer, i, i2).appendNewLine();
    }

    public TextStringBuilder appendln(StringBuilder sb) {
        return append(sb).appendNewLine();
    }

    public int indexOf(StringMatcher stringMatcher) {
        return indexOf(stringMatcher, 0);
    }

    public TextStringBuilder appendln(StringBuilder sb, int i, int i2) {
        return append(sb, i, i2).appendNewLine();
    }

    public int indexOf(StringMatcher stringMatcher, int i) {
        int i2;
        int iMax = Math.max(0, i);
        if (stringMatcher != null && iMax < (i2 = this.size)) {
            char[] cArr = this.buffer;
            for (int i4 = iMax; i4 < i2; i4++) {
                if (stringMatcher.isMatch(cArr, i4, iMax, i2) > 0) {
                    return i4;
                }
            }
        }
        return -1;
    }

    public int readFrom(Reader reader) {
        int i = this.size;
        ensureCapacityInternal(i + 1);
        char[] cArr = this.buffer;
        int i2 = this.size;
        int i4 = reader.read(cArr, i2, cArr.length - i2);
        if (i4 == -1) {
            return -1;
        }
        do {
            int i5 = this.size + i4;
            this.size = i5;
            ensureCapacityInternal(i5 + 1);
            char[] cArr2 = this.buffer;
            int i6 = this.size;
            i4 = reader.read(cArr2, i6, cArr2.length - i6);
        } while (i4 != -1);
        return this.size - i;
    }

    public TextStringBuilder append(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return appendNull();
        }
        if (i >= 0 && i <= cArr.length) {
            if (i2 < 0 || i + i2 > cArr.length) {
                throw new StringIndexOutOfBoundsException(AbstractC0000a.m11h(i2, "Invalid length: "));
            }
            if (i2 > 0) {
                int length = length();
                ensureCapacityInternal(length + i2);
                System.arraycopy(cArr, i, this.buffer, length, i2);
                this.size += i2;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException(AbstractC0000a.m11h(i2, "Invalid startIndex: "));
    }

    public TextStringBuilder appendln(TextStringBuilder textStringBuilder) {
        return append(textStringBuilder).appendNewLine();
    }

    public TextStringBuilder appendln(TextStringBuilder textStringBuilder, int i, int i2) {
        return append(textStringBuilder, i, i2).appendNewLine();
    }

    public TextStringBuilder insert(int i, char[] cArr, int i2, int i4) {
        validateIndex(i);
        if (cArr == null) {
            return insert(i, this.nullText);
        }
        if (i2 >= 0 && i2 <= cArr.length) {
            if (i4 < 0 || i2 + i4 > cArr.length) {
                throw new StringIndexOutOfBoundsException(AbstractC0000a.m11h(i4, "Invalid length: "));
            }
            if (i4 > 0) {
                ensureCapacityInternal(this.size + i4);
                char[] cArr2 = this.buffer;
                System.arraycopy(cArr2, i, cArr2, i + i4, this.size - i);
                System.arraycopy(cArr, i2, this.buffer, i, i4);
                this.size += i4;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException(AbstractC0000a.m11h(i2, "Invalid offset: "));
    }

    public int readFrom(Reader reader, int i) throws IOException {
        if (i <= 0) {
            return 0;
        }
        int i2 = this.size;
        ensureCapacityInternal(i2 + i);
        int i4 = reader.read(this.buffer, this.size, i);
        if (i4 == -1) {
            return -1;
        }
        do {
            i -= i4;
            int i5 = this.size + i4;
            this.size = i5;
            i4 = reader.read(this.buffer, i5, i);
            if (i <= 0) {
                break;
            }
        } while (i4 != -1);
        return this.size - i2;
    }

    public TextStringBuilder append(CharBuffer charBuffer) {
        return append(charBuffer, 0, StringUtils.length(charBuffer));
    }

    public TextStringBuilder append(CharBuffer charBuffer, int i, int i2) {
        if (charBuffer == null) {
            return appendNull();
        }
        if (charBuffer.hasArray()) {
            int iRemaining = charBuffer.remaining();
            if (i < 0 || i > iRemaining) {
                throw new StringIndexOutOfBoundsException("startIndex must be valid");
            }
            if (i2 >= 0 && i + i2 <= iRemaining) {
                int length = length();
                ensureCapacityInternal(length + i2);
                System.arraycopy(charBuffer.array(), charBuffer.position() + charBuffer.arrayOffset() + i, this.buffer, length, i2);
                this.size += i2;
                return this;
            }
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        append(charBuffer.toString(), i, i2);
        return this;
    }

    public TextStringBuilder insert(int i, double d) {
        return insert(i, String.valueOf(d));
    }

    public TextStringBuilder insert(int i, float f) {
        return insert(i, String.valueOf(f));
    }

    public TextStringBuilder insert(int i, int i2) {
        return insert(i, String.valueOf(i2));
    }

    public TextStringBuilder insert(int i, long j) {
        return insert(i, String.valueOf(j));
    }

    public TextStringBuilder insert(int i, Object obj) {
        if (obj == null) {
            return insert(i, this.nullText);
        }
        return insert(i, obj.toString());
    }

    public TextStringBuilder insert(int i, String str) {
        int length;
        validateIndex(i);
        if (str == null) {
            str = this.nullText;
        }
        if (str != null && (length = str.length()) > 0) {
            int i2 = this.size + length;
            ensureCapacityInternal(i2);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i, cArr, i + length, this.size - i);
            this.size = i2;
            str.getChars(0, length, this.buffer, i);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public TextStringBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            return appendNull();
        }
        if (charSequence instanceof TextStringBuilder) {
            return append((TextStringBuilder) charSequence);
        }
        if (charSequence instanceof StringBuilder) {
            return append((StringBuilder) charSequence);
        }
        if (charSequence instanceof StringBuffer) {
            return append((StringBuffer) charSequence);
        }
        if (charSequence instanceof CharBuffer) {
            return append((CharBuffer) charSequence);
        }
        return append(charSequence.toString());
    }

    @Override // java.lang.Appendable
    public TextStringBuilder append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return appendNull();
        }
        if (i2 <= 0) {
            throw new StringIndexOutOfBoundsException("endIndex must be valid");
        }
        if (i < i2) {
            return append(charSequence.toString(), i, i2 - i);
        }
        throw new StringIndexOutOfBoundsException("endIndex must be greater than startIndex");
    }

    public TextStringBuilder append(double d) {
        return append(String.valueOf(d));
    }

    public TextStringBuilder append(float f) {
        return append(String.valueOf(f));
    }

    public TextStringBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public TextStringBuilder append(long j) {
        return append(String.valueOf(j));
    }

    public TextStringBuilder append(Object obj) {
        if (obj == null) {
            return appendNull();
        }
        if (obj instanceof CharSequence) {
            return append((CharSequence) obj);
        }
        return append(obj.toString());
    }

    public TextStringBuilder append(String str) {
        return append(str, 0, StringUtils.length(str));
    }

    public TextStringBuilder append(String str, int i, int i2) {
        int i4;
        if (str == null) {
            return appendNull();
        }
        if (i >= 0 && i <= str.length()) {
            if (i2 < 0 || (i4 = i + i2) > str.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i2 > 0) {
                int length = length();
                ensureCapacityInternal(length + i2);
                str.getChars(i, i4, this.buffer, length);
                this.size += i2;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public TextStringBuilder append(String str, Object... objArr) {
        return append(String.format(str, objArr));
    }

    public TextStringBuilder append(StringBuffer stringBuffer) {
        return append(stringBuffer, 0, StringUtils.length(stringBuffer));
    }

    public TextStringBuilder append(StringBuffer stringBuffer, int i, int i2) {
        int i4;
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i >= 0 && i <= stringBuffer.length()) {
            if (i2 < 0 || (i4 = i + i2) > stringBuffer.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i2 > 0) {
                int length = length();
                ensureCapacityInternal(length + i2);
                stringBuffer.getChars(i, i4, this.buffer, length);
                this.size += i2;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public TextStringBuilder append(StringBuilder sb) {
        return append(sb, 0, StringUtils.length(sb));
    }

    public TextStringBuilder append(StringBuilder sb, int i, int i2) {
        int i4;
        if (sb == null) {
            return appendNull();
        }
        if (i >= 0 && i <= sb.length()) {
            if (i2 < 0 || (i4 = i + i2) > sb.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i2 > 0) {
                int length = length();
                ensureCapacityInternal(length + i2);
                sb.getChars(i, i4, this.buffer, length);
                this.size += i2;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public TextStringBuilder append(TextStringBuilder textStringBuilder) {
        return append(textStringBuilder, 0, StringUtils.length(textStringBuilder));
    }

    public TextStringBuilder append(TextStringBuilder textStringBuilder, int i, int i2) {
        int i4;
        if (textStringBuilder == null) {
            return appendNull();
        }
        if (i >= 0 && i <= textStringBuilder.length()) {
            if (i2 < 0 || (i4 = i + i2) > textStringBuilder.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i2 > 0) {
                int length = length();
                ensureCapacityInternal(length + i2);
                textStringBuilder.getChars(i, i4, this.buffer, length);
                this.size += i2;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }
}
