package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SafeParcelable.Class(creator = "SearchResultPageCreator")
public class SearchResultPage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SearchResultPage> CREATOR = new StubCreators.SearchResultPageCreator();

    @AbstractSafeParcelable.Field(getter = "getNextPageToken", m1109id = 1)
    private final long mNextPageToken;

    @AbstractSafeParcelable.Field(getter = "getResults", m1109id = 2)
    private final List<SearchResult> mResults;

    @AbstractSafeParcelable.Constructor
    public SearchResultPage(@AbstractSafeParcelable.Param(m1110id = 1) long j, @AbstractSafeParcelable.Param(m1110id = 2) List<SearchResult> list) {
        this.mNextPageToken = j;
        this.mResults = list;
    }

    public long getNextPageToken() {
        return this.mNextPageToken;
    }

    public List<SearchResult> getResults() {
        List<SearchResult> list = this.mResults;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    public SearchResultPage() {
        this.mNextPageToken = 0L;
        this.mResults = Collections.EMPTY_LIST;
    }
}
