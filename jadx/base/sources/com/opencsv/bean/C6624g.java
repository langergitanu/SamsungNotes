package com.opencsv.bean;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.function.BiFunction;

/* JADX INFO: renamed from: com.opencsv.bean.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6624g implements BiFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3683a;

    public /* synthetic */ C6624g(int i) {
        this.f3683a = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        DateTimeFormatter dateTimeFormatter = (DateTimeFormatter) obj;
        switch (this.f3683a) {
            case 0:
                return ConverterDate.lambda$determineWriteTemporalConversionFunction$0(dateTimeFormatter, (TemporalAccessor) obj2);
            case 1:
                return dateTimeFormatter.format((TemporalAccessor) obj2);
            case 2:
                return dateTimeFormatter.parse((String) obj2);
            case 3:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$11(dateTimeFormatter, (String) obj2);
            case 4:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$12(dateTimeFormatter, (String) obj2);
            case 5:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$13(dateTimeFormatter, (String) obj2);
            case 6:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$14(dateTimeFormatter, (String) obj2);
            case 7:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$15(dateTimeFormatter, (String) obj2);
            case 8:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$16(dateTimeFormatter, (String) obj2);
            case 9:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$17(dateTimeFormatter, (String) obj2);
            case 10:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$18(dateTimeFormatter, (String) obj2);
            case 11:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$19(dateTimeFormatter, (String) obj2);
            case 12:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$20(dateTimeFormatter, (String) obj2);
            case 13:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$2(dateTimeFormatter, (String) obj2);
            case 14:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$3(dateTimeFormatter, (String) obj2);
            case 15:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$4(dateTimeFormatter, (String) obj2);
            case 16:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$5(dateTimeFormatter, (String) obj2);
            case 17:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$6(dateTimeFormatter, (String) obj2);
            case 18:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$7(dateTimeFormatter, (String) obj2);
            case 19:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$8(dateTimeFormatter, (String) obj2);
            case 20:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$9(dateTimeFormatter, (String) obj2);
            default:
                return ConverterDate.lambda$determineReadTemporalConversionFunction$10(dateTimeFormatter, (String) obj2);
        }
    }
}
