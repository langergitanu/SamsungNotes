package com.opencsv.bean.processor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertEmptyOrBlankStringsToDefault implements StringProcessor {
    String defaultValue;

    @Override // com.opencsv.bean.processor.StringProcessor
    public String processString(String str) {
        return (str == null || str.trim().isEmpty()) ? this.defaultValue : str;
    }

    @Override // com.opencsv.bean.processor.StringProcessor
    public void setParameterString(String str) {
        this.defaultValue = str;
    }
}
