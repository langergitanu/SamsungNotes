package io.opentelemetry.context.propagation;

import io.opentelemetry.context.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ThreadSafe
public interface TextMapPropagator {
    static TextMapPropagator composite(TextMapPropagator... textMapPropagatorArr) {
        return composite(Arrays.asList(textMapPropagatorArr));
    }

    static TextMapPropagator noop() {
        return NoopTextMapPropagator.getInstance();
    }

    <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter);

    Collection<String> fields();

    <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter);

    static TextMapPropagator composite(Iterable<TextMapPropagator> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<TextMapPropagator> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList.isEmpty() ? NoopTextMapPropagator.getInstance() : arrayList.size() == 1 ? (TextMapPropagator) arrayList.get(0) : new MultiTextMapPropagator(arrayList);
    }
}
