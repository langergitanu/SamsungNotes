package com.opencsv.bean;

import com.opencsv.CSVReader;
import com.opencsv.ICSVParser;
import com.opencsv.bean.concurrent.CompleteFileReader;
import com.opencsv.bean.concurrent.LineExecutor;
import com.opencsv.bean.concurrent.ProcessCsvLine;
import com.opencsv.bean.concurrent.SingleLineReader;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerQueue;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerThrow;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvToBean<T> implements Iterable<T> {
    private CSVReader csvReader;
    private LineExecutor<T> executor;
    private MappingStrategy<? extends T> mappingStrategy;
    private final List<CsvException> capturedExceptions = new LinkedList();
    private CsvToBeanFilter filter = null;
    private CsvExceptionHandler exceptionHandler = new ExceptionHandlerThrow();
    private boolean orderedResults = true;
    private Locale errorLocale = Locale.getDefault();
    private List<BeanVerifier<T>> verifiers = Collections.EMPTY_LIST;
    private boolean ignoreEmptyLines = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CsvToBeanIterator implements Iterator<T> {
        private T bean;
        private final SingleLineReader lineReader;
        private String[] line = null;
        private long lineProcessed = 0;
        private final BlockingQueue<OrderedObject<T>> resultantBeansQueue = new ArrayBlockingQueue(1);
        private final BlockingQueue<OrderedObject<CsvException>> thrownExceptionsQueue = new LinkedBlockingQueue();

        public CsvToBeanIterator() {
            this.lineReader = new SingleLineReader(CsvToBean.this.csvReader, CsvToBean.this.ignoreEmptyLines);
            readSingleLine();
        }

        private void processException() {
            OrderedObject<CsvException> orderedObjectPoll = this.thrownExceptionsQueue.poll();
            while (orderedObjectPoll != null && orderedObjectPoll.getElement() != null) {
                CsvToBean.this.capturedExceptions.add(orderedObjectPoll.getElement());
                orderedObjectPoll = this.thrownExceptionsQueue.poll();
            }
        }

        private void readLineWithPossibleError() {
            this.bean = null;
            while (this.bean == null) {
                String[] nextLine = this.lineReader.readNextLine();
                this.line = nextLine;
                if (nextLine == null) {
                    break;
                }
                long linesRead = this.lineReader.getLinesRead();
                this.lineProcessed = linesRead;
                new ProcessCsvLine(linesRead, CsvToBean.this.mappingStrategy, CsvToBean.this.filter, CsvToBean.this.verifiers, this.line, this.resultantBeansQueue, this.thrownExceptionsQueue, new TreeSet(), CsvToBean.this.exceptionHandler).run();
                if (this.thrownExceptionsQueue.isEmpty()) {
                    OrderedObject<T> orderedObjectPoll = this.resultantBeansQueue.poll();
                    this.bean = orderedObjectPoll == null ? null : orderedObjectPoll.getElement();
                } else {
                    processException();
                }
            }
            if (this.line == null) {
                this.bean = null;
            }
        }

        private void readSingleLine() {
            try {
                readLineWithPossibleError();
            } catch (CsvValidationException | IOException e) {
                this.line = null;
                throw new RuntimeException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, CsvToBean.this.errorLocale).getString("parsing.error"), Long.valueOf(this.lineProcessed), Arrays.toString(this.line)), e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bean != null;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = this.bean;
            if (t == null) {
                throw new NoSuchElementException();
            }
            readSingleLine();
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, CsvToBean.this.errorLocale).getString("read.only.iterator"));
        }
    }

    private void prepareToReadInput() {
        CSVReader cSVReader;
        MappingStrategy<? extends T> mappingStrategy = this.mappingStrategy;
        if (mappingStrategy == null || (cSVReader = this.csvReader) == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("specify.strategy.reader"));
        }
        try {
            mappingStrategy.captureHeader(cSVReader);
        } catch (Exception e) {
            throw new RuntimeException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.error"), e);
        }
    }

    public List<CsvException> getCapturedExceptions() {
        LineExecutor<T> lineExecutor = this.executor;
        return lineExecutor != null ? lineExecutor.getCapturedExceptions() : this.capturedExceptions;
    }

    public CsvExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        prepareToReadInput();
        return new CsvToBeanIterator();
    }

    public List<T> parse() {
        return (List) stream().collect(Collectors.toList());
    }

    public void setCsvReader(CSVReader cSVReader) {
        this.csvReader = cSVReader;
    }

    public void setErrorLocale(Locale locale) {
        Locale locale2 = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        this.errorLocale = locale2;
        CSVReader cSVReader = this.csvReader;
        if (cSVReader != null) {
            cSVReader.setErrorLocale(locale2);
        }
        MappingStrategy<? extends T> mappingStrategy = this.mappingStrategy;
        if (mappingStrategy != null) {
            mappingStrategy.setErrorLocale(this.errorLocale);
        }
    }

    public void setExceptionHandler(CsvExceptionHandler csvExceptionHandler) {
        if (csvExceptionHandler != null) {
            this.exceptionHandler = csvExceptionHandler;
        }
    }

    public void setFilter(CsvToBeanFilter csvToBeanFilter) {
        this.filter = csvToBeanFilter;
    }

    public void setIgnoreEmptyLines(boolean z) {
        this.ignoreEmptyLines = z;
    }

    public void setMappingStrategy(MappingStrategy<? extends T> mappingStrategy) {
        this.mappingStrategy = mappingStrategy;
    }

    public void setOrderedResults(boolean z) {
        this.orderedResults = z;
    }

    public void setThrowExceptions(boolean z) {
        if (z) {
            this.exceptionHandler = new ExceptionHandlerThrow();
        } else {
            this.exceptionHandler = new ExceptionHandlerQueue();
        }
    }

    public void setVerifiers(List<BeanVerifier<T>> list) {
        this.verifiers = (List) ObjectUtils.defaultIfNull(list, Collections.EMPTY_LIST);
    }

    public Stream<T> stream() {
        prepareToReadInput();
        LineExecutor<T> lineExecutor = new LineExecutor<>(this.orderedResults, this.errorLocale, new CompleteFileReader(this.csvReader, this.filter, this.ignoreEmptyLines, this.mappingStrategy, this.exceptionHandler, this.verifiers));
        this.executor = lineExecutor;
        lineExecutor.prepare();
        return StreamSupport.stream(this.executor, false);
    }
}
