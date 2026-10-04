package com.opencsv;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvMalformedLineException;
import com.opencsv.exceptions.CsvMultilineLimitBrokenException;
import com.opencsv.exceptions.CsvRuntimeException;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.processor.RowProcessor;
import com.opencsv.stream.reader.LineReader;
import com.opencsv.validators.LineValidatorAggregator;
import com.opencsv.validators.RowValidatorAggregator;
import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.MalformedInputException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.zip.ZipException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CSVReader implements Closeable, Iterable<String[]> {
    static final int CONTEXT_MULTILINE_EXCEPTION_MESSAGE_SIZE = 100;
    public static final boolean DEFAULT_KEEP_CR = false;
    public static final int DEFAULT_MULTILINE_LIMIT = 0;
    public static final int DEFAULT_SKIP_LINES = 0;
    public static final boolean DEFAULT_VERIFY_READER = true;
    private static final int MAX_WIDTH = 100;
    protected static final List<Class<? extends IOException>> PASSTHROUGH_EXCEPTIONS = Collections.unmodifiableList(Arrays.asList(CharacterCodingException.class, CharConversionException.class, UnsupportedEncodingException.class, UTFDataFormatException.class, ZipException.class, FileNotFoundException.class, MalformedInputException.class));
    public static final int READ_AHEAD_LIMIT = 2;

    /* JADX INFO: renamed from: br */
    protected BufferedReader f3667br;
    protected Locale errorLocale;
    protected boolean hasNext;
    protected boolean keepCR;
    protected LineReader lineReader;
    private final LineValidatorAggregator lineValidatorAggregator;
    protected long linesRead;
    protected boolean linesSkipped;
    protected int multilineLimit;
    protected ICSVParser parser;
    protected String[] peekedLine;
    protected final Queue<OrderedObject<String>> peekedLines;
    protected long recordsRead;
    private final RowProcessor rowProcessor;
    private final RowValidatorAggregator rowValidatorAggregator;
    protected int skipLines;
    protected boolean verifyReader;

    public CSVReader(Reader reader) {
        this(reader, 0, new CSVParser(',', '\"', '\\', false, true, false, ICSVParser.DEFAULT_NULL_FIELD_INDICATOR, Locale.getDefault()), false, true, 0, Locale.getDefault(), new LineValidatorAggregator(), new RowValidatorAggregator(), null);
    }

    private String[] flexibleRead(boolean z, boolean z2) throws CsvMalformedLineException, CsvValidationException, CsvMultilineLimitBrokenException {
        if (this.peekedLines.isEmpty()) {
            primeNextRecord();
        }
        if (z2) {
            for (OrderedObject<String> orderedObject : this.peekedLines) {
                validateLine(orderedObject.getOrdinal(), orderedObject.getElement());
            }
            validateResult(this.peekedLine, this.linesRead);
        }
        String[] strArr = this.peekedLine;
        if (z) {
            this.peekedLines.clear();
            this.peekedLine = null;
            if (strArr != null) {
                this.recordsRead++;
            }
        }
        return strArr;
    }

    private void primeNextRecord() throws CsvMalformedLineException, CsvMultilineLimitBrokenException {
        long j = this.linesRead + 1;
        int i = 0;
        do {
            String nextLine = getNextLine();
            this.peekedLines.add(new OrderedObject<>(j, nextLine));
            i++;
            if (!this.hasNext) {
                if (this.parser.isPending()) {
                    throw new CsvMalformedLineException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("unterminated.quote"), StringUtils.abbreviate(this.parser.getPendingText(), 100)), j, this.parser.getPendingText());
                }
                return;
            }
            int i2 = this.multilineLimit;
            if (i2 > 0 && i > i2) {
                long j2 = this.recordsRead + 1;
                String pendingText = this.parser.getPendingText();
                if (pendingText.length() > 100) {
                    pendingText = pendingText.substring(0, 100);
                }
                throw new CsvMultilineLimitBrokenException(String.format(this.errorLocale, ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("multiline.limit.broken"), Integer.valueOf(this.multilineLimit), Long.valueOf(j2), pendingText), j2, this.parser.getPendingText(), this.multilineLimit);
            }
            String[] lineMulti = this.parser.parseLineMulti(nextLine);
            if (lineMulti.length > 0) {
                String[] strArr = this.peekedLine;
                if (strArr == null) {
                    this.peekedLine = lineMulti;
                } else {
                    this.peekedLine = combineResultsFromMultipleReads(strArr, lineMulti);
                }
            }
        } while (this.parser.isPending());
        if (this.keepCR) {
            String[] strArr2 = this.peekedLine;
            int length = strArr2.length - 1;
            String str = strArr2[length];
            if (str == null || !str.endsWith(StringUtils.f9761CR)) {
                return;
            }
            String[] strArr3 = this.peekedLine;
            strArr3[length] = AbstractC2322a.m1614d(1, 0, strArr3[length]);
        }
    }

    private void validateLine(long j, String str) throws CsvValidationException {
        try {
            this.lineValidatorAggregator.validate(str);
        } catch (CsvValidationException e) {
            e.setLineNumber(j);
            throw e;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3667br.close();
    }

    public String[] combineResultsFromMultipleReads(String[] strArr, String[] strArr2) {
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public long getLinesRead() {
        return this.linesRead;
    }

    public int getMultilineLimit() {
        return this.multilineLimit;
    }

    public String getNextLine() {
        if (isClosed()) {
            this.hasNext = false;
            return null;
        }
        if (!this.linesSkipped) {
            for (int i = 0; i < this.skipLines; i++) {
                this.lineReader.readLine();
                this.linesRead++;
            }
            this.linesSkipped = true;
        }
        String line = this.lineReader.readLine();
        if (line == null) {
            this.hasNext = false;
        } else {
            this.linesRead++;
        }
        if (this.hasNext) {
            return line;
        }
        return null;
    }

    public ICSVParser getParser() {
        return this.parser;
    }

    public long getRecordsRead() {
        return this.recordsRead;
    }

    public int getSkipLines() {
        return this.skipLines;
    }

    public boolean isClosed() throws IOException {
        if (!this.verifyReader) {
            return false;
        }
        try {
            this.f3667br.mark(2);
            int i = this.f3667br.read();
            this.f3667br.reset();
            return i == -1;
        } catch (IOException e) {
            if (PASSTHROUGH_EXCEPTIONS.contains(e.getClass())) {
                throw e;
            }
            return true;
        }
    }

    @Override // java.lang.Iterable
    public Iterator<String[]> iterator() {
        try {
            CSVIterator cSVIterator = new CSVIterator(this);
            cSVIterator.setErrorLocale(this.errorLocale);
            return cSVIterator;
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean keepCarriageReturns() {
        return this.keepCR;
    }

    public String[] peek() {
        try {
            return flexibleRead(false, false);
        } catch (CsvValidationException unused) {
            return null;
        }
    }

    public List<String[]> readAll() {
        LinkedList linkedList = new LinkedList();
        while (this.hasNext) {
            String[] next = readNext();
            if (next != null) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    public String[] readNext() {
        return flexibleRead(true, true);
    }

    public String[] readNextSilently() {
        try {
            return flexibleRead(true, false);
        } catch (CsvValidationException e) {
            throw new CsvRuntimeException("A CSValidationException was thrown from the runNextSilently method which should not happen", e);
        }
    }

    public void setErrorLocale(Locale locale) {
        Locale locale2 = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        this.errorLocale = locale2;
        ICSVParser iCSVParser = this.parser;
        if (iCSVParser != null) {
            iCSVParser.setErrorLocale(locale2);
        }
    }

    public void skip(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            readNextSilently();
        }
    }

    public void validateResult(String[] strArr, long j) throws CsvValidationException {
        if (strArr != null) {
            RowProcessor rowProcessor = this.rowProcessor;
            if (rowProcessor != null) {
                rowProcessor.processRow(strArr);
            }
            try {
                this.rowValidatorAggregator.validate(strArr);
            } catch (CsvValidationException e) {
                e.setLineNumber(j);
                throw e;
            }
        }
    }

    public boolean verifyReader() {
        return this.verifyReader;
    }

    public CSVReader(Reader reader, int i, ICSVParser iCSVParser, boolean z, boolean z2, int i2, Locale locale, LineValidatorAggregator lineValidatorAggregator, RowValidatorAggregator rowValidatorAggregator, RowProcessor rowProcessor) {
        this.hasNext = true;
        this.multilineLimit = 0;
        this.linesRead = 0L;
        this.recordsRead = 0L;
        this.peekedLine = null;
        this.peekedLines = new LinkedList();
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
        this.f3667br = bufferedReader;
        this.lineReader = new LineReader(bufferedReader, z);
        this.skipLines = i;
        this.parser = iCSVParser;
        this.keepCR = z;
        this.verifyReader = z2;
        this.multilineLimit = i2;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        this.lineValidatorAggregator = lineValidatorAggregator;
        this.rowValidatorAggregator = rowValidatorAggregator;
        this.rowProcessor = rowProcessor;
    }
}
