package com.samsung.scsp.error;

import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.samsung.scsp.framework.core.ScspException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ErrorSupplier {
    private static final Map<Class<?>, Function<Throwable, Result>> ERROR_SUPPLIER_MAP = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultHolder {
        private Result result;

        public ResultHolder(Throwable th) {
            this.result = new Result(0, "Not defined error. There is exception {" + th + "}");
        }
    }

    static {
        add(ScspException.class, new C11419a(3));
    }

    public static void add(Class<?> cls, Function<Throwable, Result> function) {
        ERROR_SUPPLIER_MAP.put(cls, function);
    }

    public static Result get(final Throwable th) {
        final ResultHolder resultHolder = new ResultHolder(th);
        ERROR_SUPPLIER_MAP.entrySet().stream().filter(new C7233a(th, 4)).findFirst().ifPresent(new Consumer() { // from class: com.samsung.scsp.error.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ErrorSupplier.lambda$get$2(resultHolder, th, (Map.Entry) obj);
            }
        });
        return resultHolder.result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$get$1(Throwable th, Map.Entry entry) {
        return ((Class) entry.getKey()).isInstance(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$get$2(ResultHolder resultHolder, Throwable th, Map.Entry entry) {
        resultHolder.result = (Result) ((Function) entry.getValue()).apply(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Result lambda$static$0(Throwable th) {
        ScspException scspException = (ScspException) th;
        return new Result(scspException.rcode, scspException.rmsg);
    }
}
