package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "SearchSuggestionResultCreator")
public final class SearchSuggestionResult extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<SearchSuggestionResult> CREATOR = new StubCreators.SearchSuggestionResultCreator();
    private Integer mHashCode;

    @AbstractSafeParcelable.Field(getter = "getSuggestedResult", m1109id = 1)
    private final String mSuggestedResult;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private String mSuggestedResult = "";

        public SearchSuggestionResult build() {
            return new SearchSuggestionResult(this.mSuggestedResult);
        }

        @CanIgnoreReturnValue
        public Builder setSuggestedResult(String str) {
            Preconditions.checkNotNull(str);
            Preconditions.checkStringNotEmpty(str);
            this.mSuggestedResult = str;
            return this;
        }
    }

    @AbstractSafeParcelable.Constructor
    public SearchSuggestionResult(@AbstractSafeParcelable.Param(m1110id = 1) String str) {
        this.mSuggestedResult = (String) Preconditions.checkNotNull(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchSuggestionResult) {
            return this.mSuggestedResult.equals(((SearchSuggestionResult) obj).mSuggestedResult);
        }
        return false;
    }

    public String getSuggestedResult() {
        return this.mSuggestedResult;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(this.mSuggestedResult.hashCode());
        }
        return this.mHashCode.intValue();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
