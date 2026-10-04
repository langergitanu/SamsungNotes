package androidx.appsearch.app;

import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.collection.ArrayMap;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class AppSearchBatchResult<KeyType, ValueType> {
    private final Map<KeyType, AppSearchResult<ValueType>> mAll;
    private final Map<KeyType, AppSearchResult<ValueType>> mFailures;
    private final Map<KeyType, ValueType> mSuccesses;

    public AppSearchBatchResult(Map<KeyType, ValueType> map, Map<KeyType, AppSearchResult<ValueType>> map2, Map<KeyType, AppSearchResult<ValueType>> map3) {
        this.mSuccesses = (Map) Preconditions.checkNotNull(map);
        this.mFailures = (Map) Preconditions.checkNotNull(map2);
        this.mAll = (Map) Preconditions.checkNotNull(map3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void checkSuccess() {
        if (isSuccess()) {
            return;
        }
        throw new IllegalStateException("AppSearchBatchResult has failures: " + this);
    }

    public Map<KeyType, AppSearchResult<ValueType>> getAll() {
        return Collections.unmodifiableMap(this.mAll);
    }

    public Map<KeyType, AppSearchResult<ValueType>> getFailures() {
        return Collections.unmodifiableMap(this.mFailures);
    }

    public Map<KeyType, ValueType> getSuccesses() {
        return Collections.unmodifiableMap(this.mSuccesses);
    }

    public boolean isSuccess() {
        return this.mFailures.isEmpty();
    }

    public String toString() {
        return "{\n  successes: " + this.mSuccesses + "\n  failures: " + this.mFailures + "\n}";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder<KeyType, ValueType> {
        private ArrayMap<KeyType, ValueType> mSuccesses = new ArrayMap<>();
        private ArrayMap<KeyType, AppSearchResult<ValueType>> mFailures = new ArrayMap<>();
        private ArrayMap<KeyType, AppSearchResult<ValueType>> mAll = new ArrayMap<>();
        private boolean mBuilt = false;

        public Builder() {
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mSuccesses = new ArrayMap<>(this.mSuccesses);
                this.mFailures = new ArrayMap<>(this.mFailures);
                this.mAll = new ArrayMap<>(this.mAll);
                this.mBuilt = false;
            }
        }

        public AppSearchBatchResult<KeyType, ValueType> build() {
            this.mBuilt = true;
            return new AppSearchBatchResult<>(this.mSuccesses, this.mFailures, this.mAll);
        }

        @CanIgnoreReturnValue
        public Builder<KeyType, ValueType> setFailure(KeyType keytype, int i, String str) {
            Preconditions.checkNotNull(keytype);
            resetIfBuilt();
            return setResult(keytype, AppSearchResult.newFailedResult(i, str));
        }

        @CanIgnoreReturnValue
        public Builder<KeyType, ValueType> setResult(KeyType keytype, AppSearchResult<ValueType> appSearchResult) {
            Preconditions.checkNotNull(keytype);
            Preconditions.checkNotNull(appSearchResult);
            resetIfBuilt();
            if (appSearchResult.isSuccess()) {
                this.mSuccesses.put(keytype, appSearchResult.getResultValue());
                this.mFailures.remove(keytype);
            } else {
                this.mFailures.put(keytype, appSearchResult);
                this.mSuccesses.remove(keytype);
            }
            this.mAll.put(keytype, appSearchResult);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<KeyType, ValueType> setSuccess(KeyType keytype, ValueType valuetype) {
            Preconditions.checkNotNull(keytype);
            resetIfBuilt();
            return setResult(keytype, AppSearchResult.newSuccessfulResult(valuetype));
        }

        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS)
        public Builder(AppSearchBatchResult<KeyType, ValueType> appSearchBatchResult) {
            this.mSuccesses.putAll(((AppSearchBatchResult) appSearchBatchResult).mSuccesses);
            this.mFailures.putAll(((AppSearchBatchResult) appSearchBatchResult).mFailures);
            this.mAll.putAll(((AppSearchBatchResult) appSearchBatchResult).mAll);
        }
    }
}
