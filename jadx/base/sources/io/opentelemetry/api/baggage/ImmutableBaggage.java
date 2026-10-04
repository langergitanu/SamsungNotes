package io.opentelemetry.api.baggage;

import io.opentelemetry.api.internal.ImmutableKeyValuePairs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
final class ImmutableBaggage extends ImmutableKeyValuePairs<String, BaggageEntry> implements Baggage {
    private static final Baggage EMPTY = new Builder().build();

    private ImmutableBaggage(Object[] objArr) {
        super(objArr, Comparator.naturalOrder());
    }

    public static BaggageBuilder builder() {
        return new Builder();
    }

    public static Baggage empty() {
        return EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Baggage sortAndFilterToBaggage(Object[] objArr) {
        return new ImmutableBaggage(objArr);
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    @Nullable
    public String getEntryValue(String str) {
        BaggageEntry baggageEntry = get(str);
        if (baggageEntry != null) {
            return baggageEntry.getValue();
        }
        return null;
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    public BaggageBuilder toBuilder() {
        return new Builder(new ArrayList(data()));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder implements BaggageBuilder {
        private final List<Object> data;

        public Builder() {
            this.data = new ArrayList();
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public Baggage build() {
            return ImmutableBaggage.sortAndFilterToBaggage(this.data.toArray());
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata) {
            if (str != null && str2 != null && baggageEntryMetadata != null) {
                this.data.add(str);
                this.data.add(ImmutableEntry.create(str2, baggageEntryMetadata));
            }
            return this;
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder remove(String str) {
            if (str == null) {
                return this;
            }
            this.data.add(str);
            this.data.add(null);
            return this;
        }

        public Builder(List<Object> list) {
            this.data = list;
        }
    }
}
