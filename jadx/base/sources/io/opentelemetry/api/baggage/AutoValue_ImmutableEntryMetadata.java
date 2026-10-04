package io.opentelemetry.api.baggage;

import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class AutoValue_ImmutableEntryMetadata extends ImmutableEntryMetadata {
    private final String value;

    public AutoValue_ImmutableEntryMetadata(String str) {
        if (str == null) {
            throw new NullPointerException("Null value");
        }
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEntryMetadata) {
            return this.value.equals(((ImmutableEntryMetadata) obj).getValue());
        }
        return false;
    }

    @Override // io.opentelemetry.api.baggage.ImmutableEntryMetadata, io.opentelemetry.api.baggage.BaggageEntryMetadata
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }

    public String toString() {
        return AbstractC0622a.m1170p(this.value, "}", new StringBuilder("ImmutableEntryMetadata{value="));
    }
}
