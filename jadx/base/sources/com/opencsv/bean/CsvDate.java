package com.opencsv.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Target({ElementType.FIELD})
@Documented
@Repeatable(CsvDates.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvDate {
    String chronology() default "ISO";

    String[] profiles() default {""};

    String value() default "yyyyMMdd'T'HHmmss";

    String writeChronology() default "ISO";

    boolean writeChronologyEqualsReadChronology() default true;

    String writeFormat() default "yyyyMMdd'T'HHmmss";

    boolean writeFormatEqualsReadFormat() default true;
}
