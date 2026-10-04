package io.opentelemetry.api.baggage;

import com.google.auto.value.AutoValue;
import io.opentelemetry.api.internal.ValidationUtil;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@AutoValue
@Immutable
abstract class ImmutableEntryMetadata implements BaggageEntryMetadata {
    static final ImmutableEntryMetadata EMPTY = create("");

    public static ImmutableEntryMetadata create(String str) {
        if (str != null) {
            return new AutoValue_ImmutableEntryMetadata(str);
        }
        ValidationUtil.log("metadata is null");
        return EMPTY;
    }

    @Override // io.opentelemetry.api.baggage.BaggageEntryMetadata
    public abstract String getValue();
}
