package com.opencsv.bean;

import com.opencsv.exceptions.CsvException;
import java.util.function.ToLongFunction;

/* JADX INFO: renamed from: com.opencsv.bean.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6633p implements ToLongFunction {
    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((CsvException) obj).getLineNumber();
    }
}
