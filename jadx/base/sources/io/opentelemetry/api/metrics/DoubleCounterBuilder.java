package io.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface DoubleCounterBuilder {
    DoubleCounter build();

    default ObservableDoubleMeasurement buildObserver() {
        return DefaultMeter.getInstance().counterBuilder("noop").ofDoubles().buildObserver();
    }

    ObservableDoubleCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer);

    DoubleCounterBuilder setDescription(String str);

    DoubleCounterBuilder setUnit(String str);
}
