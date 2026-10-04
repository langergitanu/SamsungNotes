package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RowFunctionValidator implements RowValidator {
    private String failureMessage;
    private Function<String[], Boolean> testFunction;

    public RowFunctionValidator(Function<String[], Boolean> function, String str) {
        this.testFunction = function;
        this.failureMessage = str;
    }

    @Override // com.opencsv.validators.RowValidator
    public boolean isValid(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        return this.testFunction.apply(strArr).booleanValue();
    }

    @Override // com.opencsv.validators.RowValidator
    public void validate(String[] strArr) throws CsvValidationException {
        if (!isValid(strArr)) {
            throw new CsvValidationException(this.failureMessage);
        }
    }
}
