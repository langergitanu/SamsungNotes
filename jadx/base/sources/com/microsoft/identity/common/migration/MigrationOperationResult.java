package com.microsoft.identity.common.migration;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class MigrationOperationResult implements IMigrationOperationResult {
    private int mCountOfFailedRecords;
    private int mCountOfTotalRecords;
    private Map<String, Integer> mFailures = new HashMap();

    private static String createExceptionKey(@NonNull Exception exc) {
        return AbstractC0541b.m757C(exc.getClass().getSimpleName(), "::", exc.getMessage());
    }

    public void addFailure(@NonNull Exception exc) {
        String strCreateExceptionKey = createExceptionKey(exc);
        Integer num = this.mFailures.get(strCreateExceptionKey);
        if (num == null) {
            this.mFailures.put(strCreateExceptionKey, 1);
        } else {
            this.mFailures.put(strCreateExceptionKey, Integer.valueOf(num.intValue() + 1));
        }
        this.mCountOfFailedRecords++;
    }

    @Override // com.microsoft.identity.common.migration.IMigrationOperationResult
    public int getCountOfFailedRecords() {
        return this.mCountOfFailedRecords;
    }

    @Override // com.microsoft.identity.common.migration.IMigrationOperationResult
    public int getCountOfTotalRecords() {
        return this.mCountOfTotalRecords;
    }

    @Override // com.microsoft.identity.common.migration.IMigrationOperationResult
    public Map<String, Integer> getFailures() {
        return this.mFailures;
    }

    public void setCountOfTotalRecords(int i) {
        this.mCountOfTotalRecords = i;
    }
}
