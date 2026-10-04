package com.opencsv.bean.validators;

import com.opencsv.bean.BeanField;
import com.opencsv.exceptions.CsvValidationException;
import java.util.ResourceBundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MustMatchRegexExpression implements StringValidator {
    private String regex = "";

    @Override // com.opencsv.bean.validators.StringValidator
    public boolean isValid(String str) {
        if (this.regex.isEmpty()) {
            return true;
        }
        return str.matches(this.regex);
    }

    @Override // com.opencsv.bean.validators.StringValidator
    public void setParameterString(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.regex = str;
    }

    @Override // com.opencsv.bean.validators.StringValidator
    public void validate(String str, BeanField beanField) throws CsvValidationException {
        if (!isValid(str)) {
            throw new CsvValidationException(String.format(ResourceBundle.getBundle("mustMatchRegex", beanField.getErrorLocale()).getString("validator.regex.mismatch"), beanField.getField().getName(), str, this.regex));
        }
    }
}
