package com.opencsv.bean.concurrent;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.concurrent.BlockingQueue;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ProcessCsvLine<T> implements Runnable {
    private final CsvExceptionHandler exceptionHandler;
    private final SortedSet<Long> expectedRecords;
    private final CsvToBeanFilter filter;
    private final String[] line;
    private final long lineNumber;
    private final MappingStrategy<? extends T> mapper;
    private final BlockingQueue<OrderedObject<T>> resultantBeanQueue;
    private final BlockingQueue<OrderedObject<CsvException>> thrownExceptionsQueue;
    private final List<BeanVerifier<T>> verifiers;

    public ProcessCsvLine(long j, MappingStrategy<? extends T> mappingStrategy, CsvToBeanFilter csvToBeanFilter, List<BeanVerifier<T>> list, String[] strArr, BlockingQueue<OrderedObject<T>> blockingQueue, BlockingQueue<OrderedObject<CsvException>> blockingQueue2, SortedSet<Long> sortedSet, CsvExceptionHandler csvExceptionHandler) {
        this.lineNumber = j;
        this.mapper = mappingStrategy;
        this.filter = csvToBeanFilter;
        this.verifiers = (List) ObjectUtils.defaultIfNull(new ArrayList(list), Collections.EMPTY_LIST);
        this.line = (String[]) ArrayUtils.clone(strArr);
        this.resultantBeanQueue = blockingQueue;
        this.thrownExceptionsQueue = blockingQueue2;
        this.expectedRecords = sortedSet;
        this.exceptionHandler = csvExceptionHandler;
    }

    private T processLine() {
        return this.mapper.populateNewBean(this.line);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CsvToBeanFilter csvToBeanFilter = this.filter;
            if (csvToBeanFilter != null && !csvToBeanFilter.allowLine(this.line)) {
                this.expectedRecords.remove(Long.valueOf(this.lineNumber));
                return;
            }
            T tProcessLine = processLine();
            ListIterator<BeanVerifier<T>> listIterator = this.verifiers.listIterator();
            boolean zVerifyBean = true;
            while (zVerifyBean && listIterator.hasNext()) {
                zVerifyBean = listIterator.next().verifyBean(tProcessLine);
            }
            if (zVerifyBean) {
                OpencsvUtils.queueRefuseToAcceptDefeat(this.resultantBeanQueue, new OrderedObject(this.lineNumber, tProcessLine));
            } else {
                this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            }
        } catch (CsvException e) {
            this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            e.setLine(this.line);
            OpencsvUtils.handleException(e, this.lineNumber, this.exceptionHandler, this.thrownExceptionsQueue);
        } catch (Exception e2) {
            this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            throw new RuntimeException(e2);
        }
    }
}
