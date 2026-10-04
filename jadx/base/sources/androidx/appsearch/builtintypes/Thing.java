package androidx.appsearch.builtintypes;

import androidx.annotation.OptIn;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__Thing.SCHEMA_NAME)
public class Thing {

    @Document.StringProperty
    private final List<String> mAlternateNames;

    @Document.CreationTimestampMillis
    private final long mCreationTimestampMillis;

    @Document.StringProperty
    private final String mDescription;

    @Document.Score
    private final int mDocumentScore;

    @Document.TtlMillis
    private final long mDocumentTtlMillis;

    @Document.InterfaceC0555Id
    private final String mId;

    @Document.StringProperty
    private final String mImage;

    @Document.StringProperty(indexingType = 2)
    private final String mName;

    @Document.Namespace
    private final String mNamespace;

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    @Document.DocumentProperty
    private final List<PotentialAction> mPotentialActions;

    @Document.StringProperty
    private final String mUrl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Document.BuilderProducer
    public static final class Builder extends BuilderImpl<Builder> {
        public Builder(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl addAlternateName(String str) {
            return super.addAlternateName(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ BuilderImpl addPotentialAction(PotentialAction potentialAction) {
            return super.addPotentialAction(potentialAction);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing build() {
            return super.build();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl clearAlternateNames() {
            return super.clearAlternateNames();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ BuilderImpl clearPotentialActions() {
            return super.clearPotentialActions();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setAlternateNames(List list) {
            return super.setAlternateNames(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setCreationTimestampMillis(long j) {
            return super.setCreationTimestampMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setDescription(String str) {
            return super.setDescription(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setDocumentScore(int i) {
            return super.setDocumentScore(i);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setDocumentTtlMillis(long j) {
            return super.setDocumentTtlMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ BuilderImpl setImage(String str) {
            return super.setImage(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setName(String str) {
            return super.setName(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ BuilderImpl setPotentialActions(List list) {
            return super.setPotentialActions(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setUrl(String str) {
            return super.setUrl(str);
        }

        public Builder(Thing thing) {
            super(thing);
        }
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public Thing(String str, String str2, int i, long j, long j2, String str3, List<String> list, String str4, String str5, String str6, List<PotentialAction> list2) {
        this.mNamespace = (String) Preconditions.checkNotNull(str);
        this.mId = (String) Preconditions.checkNotNull(str2);
        this.mDocumentScore = i;
        this.mCreationTimestampMillis = j;
        this.mDocumentTtlMillis = j2;
        this.mName = str3;
        if (list == null) {
            this.mAlternateNames = Collections.EMPTY_LIST;
        } else {
            this.mAlternateNames = Collections.unmodifiableList(list);
        }
        this.mDescription = str4;
        this.mImage = str5;
        this.mUrl = str6;
        if (list2 == null) {
            this.mPotentialActions = Collections.EMPTY_LIST;
        } else {
            this.mPotentialActions = Collections.unmodifiableList(list2);
        }
    }

    public List<String> getAlternateNames() {
        return this.mAlternateNames;
    }

    public long getCreationTimestampMillis() {
        return this.mCreationTimestampMillis;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getDocumentScore() {
        return this.mDocumentScore;
    }

    public long getDocumentTtlMillis() {
        return this.mDocumentTtlMillis;
    }

    public String getId() {
        return this.mId;
    }

    @ExperimentalAppSearchApi
    public String getImage() {
        return this.mImage;
    }

    public String getName() {
        return this.mName;
    }

    public String getNamespace() {
        return this.mNamespace;
    }

    @ExperimentalAppSearchApi
    public List<PotentialAction> getPotentialActions() {
        return this.mPotentialActions;
    }

    public String getUrl() {
        return this.mUrl;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<T extends BuilderImpl<T>> {
        protected List<String> mAlternateNames;
        private boolean mBuilt;
        protected long mCreationTimestampMillis;
        protected String mDescription;
        protected int mDocumentScore;
        protected long mDocumentTtlMillis;
        protected final String mId;
        protected String mImage;
        protected String mName;
        protected final String mNamespace;

        @OptIn(markerClass = {ExperimentalAppSearchApi.class})
        protected List<PotentialAction> mPotentialActions;
        protected String mUrl;

        public BuilderImpl(String str, String str2) {
            this.mAlternateNames = new ArrayList();
            this.mPotentialActions = new ArrayList();
            this.mBuilt = false;
            this.mNamespace = (String) Preconditions.checkNotNull(str);
            this.mId = (String) Preconditions.checkNotNull(str2);
            this.mCreationTimestampMillis = -1L;
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mAlternateNames = new ArrayList(this.mAlternateNames);
                this.mPotentialActions = new ArrayList(this.mPotentialActions);
                this.mBuilt = false;
            }
        }

        public T addAlternateName(String str) {
            resetIfBuilt();
            Preconditions.checkNotNull(str);
            this.mAlternateNames.add(str);
            return this;
        }

        @ExperimentalAppSearchApi
        public T addPotentialAction(PotentialAction potentialAction) {
            resetIfBuilt();
            Preconditions.checkNotNull(potentialAction);
            this.mPotentialActions.add(potentialAction);
            return this;
        }

        public Thing build() {
            this.mBuilt = true;
            return new Thing(this.mNamespace, this.mId, this.mDocumentScore, this.mCreationTimestampMillis, this.mDocumentTtlMillis, this.mName, this.mAlternateNames, this.mDescription, this.mImage, this.mUrl, this.mPotentialActions);
        }

        public T clearAlternateNames() {
            resetIfBuilt();
            this.mAlternateNames.clear();
            return this;
        }

        @ExperimentalAppSearchApi
        public T clearPotentialActions() {
            resetIfBuilt();
            this.mPotentialActions.clear();
            return this;
        }

        public T setAlternateNames(List<String> list) {
            resetIfBuilt();
            clearAlternateNames();
            if (list != null) {
                this.mAlternateNames.addAll(list);
            }
            return this;
        }

        public T setCreationTimestampMillis(long j) {
            resetIfBuilt();
            this.mCreationTimestampMillis = j;
            return this;
        }

        public T setDescription(String str) {
            resetIfBuilt();
            this.mDescription = str;
            return this;
        }

        public T setDocumentScore(int i) {
            resetIfBuilt();
            this.mDocumentScore = i;
            return this;
        }

        public T setDocumentTtlMillis(long j) {
            resetIfBuilt();
            this.mDocumentTtlMillis = j;
            return this;
        }

        @ExperimentalAppSearchApi
        public T setImage(String str) {
            resetIfBuilt();
            this.mImage = str;
            return this;
        }

        public T setName(String str) {
            resetIfBuilt();
            this.mName = str;
            return this;
        }

        @ExperimentalAppSearchApi
        public T setPotentialActions(List<PotentialAction> list) {
            resetIfBuilt();
            clearPotentialActions();
            if (list != null) {
                this.mPotentialActions.addAll(list);
            }
            return this;
        }

        public T setUrl(String str) {
            resetIfBuilt();
            this.mUrl = str;
            return this;
        }

        @OptIn(markerClass = {ExperimentalAppSearchApi.class})
        public BuilderImpl(Thing thing) {
            this(thing.getNamespace(), thing.getId());
            this.mDocumentScore = thing.getDocumentScore();
            this.mCreationTimestampMillis = thing.getCreationTimestampMillis();
            this.mDocumentTtlMillis = thing.getDocumentTtlMillis();
            this.mName = thing.getName();
            this.mAlternateNames = new ArrayList(thing.getAlternateNames());
            this.mDescription = thing.getDescription();
            this.mImage = thing.getImage();
            this.mUrl = thing.getUrl();
            this.mPotentialActions = new ArrayList(thing.getPotentialActions());
        }
    }
}
