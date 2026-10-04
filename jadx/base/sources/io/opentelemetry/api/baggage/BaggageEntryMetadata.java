package io.opentelemetry.api.baggage;

import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public interface BaggageEntryMetadata {
    static BaggageEntryMetadata create(String str) {
        return ImmutableEntryMetadata.create(str);
    }

    static BaggageEntryMetadata empty() {
        return ImmutableEntryMetadata.EMPTY;
    }

    String getValue();
}
