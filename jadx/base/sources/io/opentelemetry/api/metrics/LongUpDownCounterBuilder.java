package io.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface LongUpDownCounterBuilder {
    LongUpDownCounter build();

    default ObservableLongMeasurement buildObserver() {
        return DefaultMeter.getInstance().upDownCounterBuilder("noop").buildObserver();
    }

    ObservableLongUpDownCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer);

    DoubleUpDownCounterBuilder ofDoubles();

    LongUpDownCounterBuilder setDescription(String str);

    LongUpDownCounterBuilder setUnit(String str);
}
