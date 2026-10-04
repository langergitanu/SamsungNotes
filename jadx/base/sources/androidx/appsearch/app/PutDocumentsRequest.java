package androidx.appsearch.app;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.usagereporting.TakenAction;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class PutDocumentsRequest {
    private final List<GenericDocument> mDocuments;
    private final List<GenericDocument> mTakenActions;

    public PutDocumentsRequest(List<GenericDocument> list, List<GenericDocument> list2) {
        this.mDocuments = list;
        this.mTakenActions = list2;
    }

    public List<GenericDocument> getGenericDocuments() {
        return Collections.unmodifiableList(this.mDocuments);
    }

    @FlaggedApi(Flags.FLAG_ENABLE_PUT_DOCUMENTS_REQUEST_ADD_TAKEN_ACTIONS)
    public List<GenericDocument> getTakenActionGenericDocuments() {
        return Collections.unmodifiableList(this.mTakenActions);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private ArrayList<GenericDocument> mDocuments = new ArrayList<>();
        private ArrayList<GenericDocument> mTakenActions = new ArrayList<>();
        private boolean mBuilt = false;

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mDocuments = new ArrayList<>(this.mDocuments);
                this.mTakenActions = new ArrayList<>(this.mTakenActions);
                this.mBuilt = false;
            }
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addDocuments(Object... objArr) {
            Preconditions.checkNotNull(objArr);
            resetIfBuilt();
            return addDocuments(Arrays.asList(objArr));
        }

        @CanIgnoreReturnValue
        public Builder addGenericDocuments(GenericDocument... genericDocumentArr) {
            Preconditions.checkNotNull(genericDocumentArr);
            resetIfBuilt();
            return addGenericDocuments(Arrays.asList(genericDocumentArr));
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_PUT_DOCUMENTS_REQUEST_ADD_TAKEN_ACTIONS)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder addTakenActionGenericDocuments(GenericDocument... genericDocumentArr) {
            Preconditions.checkNotNull(genericDocumentArr);
            resetIfBuilt();
            return addTakenActionGenericDocuments(Arrays.asList(genericDocumentArr));
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        public Builder addTakenActions(TakenAction... takenActionArr) {
            Preconditions.checkNotNull(takenActionArr);
            resetIfBuilt();
            return addTakenActions(Arrays.asList(takenActionArr));
        }

        public PutDocumentsRequest build() {
            this.mBuilt = true;
            ArraySet arraySet = new ArraySet();
            for (int i = 0; i < this.mDocuments.size(); i++) {
                arraySet.add(this.mDocuments.get(i).getId());
            }
            for (int i2 = 0; i2 < this.mTakenActions.size(); i2++) {
                GenericDocument genericDocument = this.mTakenActions.get(i2);
                if (arraySet.contains(genericDocument.getId())) {
                    throw new IllegalArgumentException("Document id " + genericDocument.getId() + " cannot exist in both taken action and normal document");
                }
            }
            return new PutDocumentsRequest(this.mDocuments, this.mTakenActions);
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addDocuments(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(GenericDocument.fromDocumentClass(it.next()));
            }
            return addGenericDocuments(arrayList);
        }

        @CanIgnoreReturnValue
        public Builder addGenericDocuments(Collection<? extends GenericDocument> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mDocuments.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_PUT_DOCUMENTS_REQUEST_ADD_TAKEN_ACTIONS)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder addTakenActionGenericDocuments(Collection<? extends GenericDocument> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mTakenActions.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        public Builder addTakenActions(Collection<? extends TakenAction> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<? extends TakenAction> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(GenericDocument.fromDocumentClass(it.next()));
            }
            this.mTakenActions.addAll(arrayList);
            return this;
        }
    }
}
