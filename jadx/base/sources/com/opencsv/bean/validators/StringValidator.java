package com.opencsv.bean.validators;

import com.opencsv.bean.BeanField;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface StringValidator {
    boolean isValid(String str);

    void setParameterString(String str);

    void validate(String str, BeanField beanField);
}
