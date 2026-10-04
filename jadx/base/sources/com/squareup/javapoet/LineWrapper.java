package com.squareup.javapoet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class LineWrapper {
    private boolean closed;
    private final int columnLimit;
    private final String indent;
    private FlushType nextFlush;
    private final RecordingAppendable out;
    private final StringBuilder buffer = new StringBuilder();
    private int column = 0;
    private int indentLevel = -1;

    /* JADX INFO: renamed from: com.squareup.javapoet.LineWrapper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C117101 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$javapoet$LineWrapper$FlushType;

        static {
            int[] iArr = new int[FlushType.values().length];
            $SwitchMap$com$squareup$javapoet$LineWrapper$FlushType = iArr;
            try {
                iArr[FlushType.WRAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$javapoet$LineWrapper$FlushType[FlushType.SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$javapoet$LineWrapper$FlushType[FlushType.EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FlushType {
        WRAP,
        SPACE,
        EMPTY
    }

    public LineWrapper(Appendable appendable, String str, int i) {
        Util.checkNotNull(appendable, "out == null", new Object[0]);
        this.out = new RecordingAppendable(appendable);
        this.indent = str;
        this.columnLimit = i;
    }

    private void flush(FlushType flushType) {
        int i;
        int i2 = C117101.$SwitchMap$com$squareup$javapoet$LineWrapper$FlushType[flushType.ordinal()];
        if (i2 == 1) {
            this.out.append('\n');
            int i4 = 0;
            while (true) {
                i = this.indentLevel;
                if (i4 >= i) {
                    break;
                }
                this.out.append(this.indent);
                i4++;
            }
            int length = this.indent.length() * i;
            this.column = length;
            this.column = this.buffer.length() + length;
        } else if (i2 == 2) {
            this.out.append(' ');
        } else if (i2 != 3) {
            throw new IllegalArgumentException("Unknown FlushType: " + flushType);
        }
        this.out.append(this.buffer);
        StringBuilder sb = this.buffer;
        sb.delete(0, sb.length());
        this.indentLevel = -1;
        this.nextFlush = null;
    }

    public void append(String str) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.nextFlush != null) {
            int iIndexOf = str.indexOf(10);
            if (iIndexOf == -1) {
                if (str.length() + this.column <= this.columnLimit) {
                    this.buffer.append(str);
                    this.column = str.length() + this.column;
                    return;
                }
            }
            flush((iIndexOf == -1 || this.column + iIndexOf > this.columnLimit) ? FlushType.WRAP : this.nextFlush);
        }
        this.out.append(str);
        this.column = str.lastIndexOf(10) != -1 ? (str.length() - r0) - 1 : str.length() + this.column;
    }

    public void close() {
        FlushType flushType = this.nextFlush;
        if (flushType != null) {
            flush(flushType);
        }
        this.closed = true;
    }

    public char lastChar() {
        return this.out.lastChar;
    }

    public void wrappingSpace(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        FlushType flushType = this.nextFlush;
        if (flushType != null) {
            flush(flushType);
        }
        this.column++;
        this.nextFlush = FlushType.SPACE;
        this.indentLevel = i;
    }

    public void zeroWidthSpace(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.column == 0) {
            return;
        }
        FlushType flushType = this.nextFlush;
        if (flushType != null) {
            flush(flushType);
        }
        this.nextFlush = FlushType.EMPTY;
        this.indentLevel = i;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class RecordingAppendable implements Appendable {
        private final Appendable delegate;
        char lastChar = 0;

        public RecordingAppendable(Appendable appendable) {
            this.delegate = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            int length = charSequence.length();
            if (length != 0) {
                this.lastChar = charSequence.charAt(length - 1);
            }
            return this.delegate.append(charSequence);
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            return append(charSequence.subSequence(i, i2));
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) {
            this.lastChar = c;
            return this.delegate.append(c);
        }
    }
}
