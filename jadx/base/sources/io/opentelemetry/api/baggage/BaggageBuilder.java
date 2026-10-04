package io.opentelemetry.api.baggage;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface BaggageBuilder {
    Baggage build();

    default BaggageBuilder put(String str, String str2) {
        return put(str, str2, BaggageEntryMetadata.empty());
    }

    BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata);

    BaggageBuilder remove(String str);
}
