package com.opencsv.exceptions;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvChainedException extends CsvException {
    private final List<CsvFieldAssignmentException> exceptionChain;

    public CsvChainedException(CsvFieldAssignmentException csvFieldAssignmentException) {
        LinkedList linkedList = new LinkedList();
        this.exceptionChain = linkedList;
        linkedList.add(csvFieldAssignmentException);
    }

    public void add(CsvFieldAssignmentException csvFieldAssignmentException) {
        this.exceptionChain.add(csvFieldAssignmentException);
    }

    public List<CsvFieldAssignmentException> getExceptionChain() {
        return this.exceptionChain;
    }

    public CsvFieldAssignmentException getFirstException() {
        if (this.exceptionChain.isEmpty()) {
            return null;
        }
        return this.exceptionChain.get(0);
    }

    public boolean hasOnlyOneException() {
        return this.exceptionChain.size() == 1;
    }

    @Override // com.opencsv.exceptions.CsvException
    public void setLine(String[] strArr) {
        super.setLine(strArr);
        this.exceptionChain.forEach(new C4191n(strArr, 1));
    }

    @Override // com.opencsv.exceptions.CsvException
    public void setLineNumber(final long j) {
        super.setLineNumber(j);
        this.exceptionChain.forEach(new Consumer() { // from class: com.opencsv.exceptions.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((CsvFieldAssignmentException) obj).setLineNumber(j);
            }
        });
    }
}
