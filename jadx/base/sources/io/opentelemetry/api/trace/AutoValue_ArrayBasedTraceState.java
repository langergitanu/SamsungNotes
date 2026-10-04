package io.opentelemetry.api.trace;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class AutoValue_ArrayBasedTraceState extends ArrayBasedTraceState {
    private final List<String> entries;

    public AutoValue_ArrayBasedTraceState(List<String> list) {
        if (list == null) {
            throw new NullPointerException("Null entries");
        }
        this.entries = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ArrayBasedTraceState) {
            return this.entries.equals(((ArrayBasedTraceState) obj).getEntries());
        }
        return false;
    }

    @Override // io.opentelemetry.api.trace.ArrayBasedTraceState
    public List<String> getEntries() {
        return this.entries;
    }

    public int hashCode() {
        return this.entries.hashCode() ^ 1000003;
    }

    public String toString() {
        return AbstractC0541b.m777s(new StringBuilder("ArrayBasedTraceState{entries="), this.entries, "}");
    }
}
