package com.opencsv.bean;

import com.opencsv.bean.util.OpencsvUtils;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RegexToBeanField<T> extends AbstractFieldMapEntry<String, String, T> {
    private final Pattern regex;

    public RegexToBeanField(String str, BeanField<T, String> beanField, Locale locale) {
        super(beanField, locale);
        this.regex = OpencsvUtils.compilePattern(str, 2, BeanFieldJoin.class, this.errorLocale);
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public boolean contains(String str) {
        return this.regex.matcher(str).matches();
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public String getInitializer() {
        return this.regex.pattern();
    }
}
