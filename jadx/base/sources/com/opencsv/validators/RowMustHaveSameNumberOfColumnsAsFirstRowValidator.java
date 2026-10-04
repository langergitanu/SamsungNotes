package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RowMustHaveSameNumberOfColumnsAsFirstRowValidator implements RowValidator {
    private static final int NO_ROWS = 0;
    private int numRows = 0;

    private boolean firstRowNotSetYet() {
        return this.numRows == 0;
    }

    @Override // com.opencsv.validators.RowValidator
    public boolean isValid(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            if (firstRowNotSetYet()) {
                this.numRows = strArr.length;
            }
            if (strArr.length == this.numRows) {
                return true;
            }
        }
        return false;
    }

    @Override // com.opencsv.validators.RowValidator
    public void validate(String[] strArr) throws CsvValidationException {
        if (isValid(strArr)) {
            return;
        }
        if (firstRowNotSetYet()) {
            throw new CsvValidationException("First row should not be empty or null");
        }
        if (strArr != null && strArr.length != 0) {
            throw new CsvValidationException(String.format("Row was expected to have %d elements but had %d instead", Integer.valueOf(this.numRows), Integer.valueOf(strArr.length)));
        }
        throw new CsvValidationException("Row should not be empty or null");
    }
}
