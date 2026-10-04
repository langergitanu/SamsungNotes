package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.processor.RowProcessor;
import com.opencsv.validators.LineValidatorAggregator;
import com.opencsv.validators.RowValidatorAggregator;
import java.io.Reader;
import java.util.Locale;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class CSVReaderBaseBuilder<T> {
    protected boolean keepCR;
    protected final Reader reader;
    protected final LineValidatorAggregator lineValidatorAggregator = new LineValidatorAggregator();
    protected final RowValidatorAggregator rowValidatorAggregator = new RowValidatorAggregator();
    private final CSVParserBuilder parserBuilder = new CSVParserBuilder();
    protected int skipLines = 0;
    protected ICSVParser icsvParser = null;
    protected boolean verifyReader = true;
    protected CSVReaderNullFieldIndicator nullFieldIndicator = CSVReaderNullFieldIndicator.NEITHER;
    protected int multilineLimit = 0;
    protected Locale errorLocale = Locale.getDefault();
    protected RowProcessor rowProcessor = null;

    public CSVReaderBaseBuilder(Reader reader) {
        this.reader = reader;
    }

    public abstract T build();

    public ICSVParser getCsvParser() {
        return this.icsvParser;
    }

    public Locale getErrorLocale() {
        return this.errorLocale;
    }

    public LineValidatorAggregator getLineValidatorAggregator() {
        return this.lineValidatorAggregator;
    }

    public int getMultilineLimit() {
        return this.multilineLimit;
    }

    public ICSVParser getOrCreateCsvParser() {
        return (ICSVParser) ObjectUtils.defaultIfNull(this.icsvParser, this.parserBuilder.withFieldAsNull(this.nullFieldIndicator).withErrorLocale(this.errorLocale).build());
    }

    public Reader getReader() {
        return this.reader;
    }

    public RowValidatorAggregator getRowValidatorAggregator() {
        return this.rowValidatorAggregator;
    }

    public int getSkipLines() {
        return this.skipLines;
    }

    public boolean isVerifyReader() {
        return this.verifyReader;
    }

    public boolean keepCarriageReturn() {
        return this.keepCR;
    }
}
