package androidx.appsearch.builtintypes;

import android.net.Uri;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.builtintypes.Thing;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__Person.SCHEMA_NAME)
public class Person extends Thing {

    @Document.LongProperty
    final List<Long> mAdditionalNameTypes;

    @Document.StringProperty(indexingType = 2)
    final List<String> mAdditionalNames;

    @Document.StringProperty(indexingType = 2)
    private final List<String> mAffiliations;

    @Document.DocumentProperty(indexNestedProperties = true)
    private final List<ContactPoint> mContactPoints;

    @Document.StringProperty
    final String mExternalUri;

    @Document.StringProperty
    private final String mFamilyName;

    @Document.StringProperty
    private final String mGivenName;

    @Document.StringProperty
    final String mImageUri;

    @Document.BooleanProperty
    final boolean mIsBot;

    @Document.BooleanProperty
    final boolean mIsImportant;

    @Document.StringProperty
    private final String mMiddleName;

    @Document.StringProperty(indexingType = 2)
    private final List<String> mNotes;

    @Document.StringProperty
    private final List<String> mRelations;
    private final List<AdditionalName> mTypedAdditionalNames;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AdditionalName {
        public static final int TYPE_NICKNAME = 1;
        public static final int TYPE_PHONETIC_NAME = 2;
        public static final int TYPE_UNKNOWN = 0;
        private final int mType;
        private final String mValue;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface NameType {
        }

        public AdditionalName(int i, String str) {
            this.mType = Preconditions.checkArgumentInRange(i, 0, 2, "type");
            this.mValue = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdditionalName)) {
                return false;
            }
            AdditionalName additionalName = (AdditionalName) obj;
            return this.mType == additionalName.mType && this.mValue.equals(additionalName.mValue);
        }

        public int getType() {
            return this.mType;
        }

        public String getValue() {
            return this.mValue;
        }

        public int hashCode() {
            return (this.mType + this.mValue).hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends BuilderImpl<Builder> {
        public Builder(String str, String str2, String str3) {
            super(str, str2, str3);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl addAlternateName(String str) {
            return super.addAlternateName(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl addPotentialAction(PotentialAction potentialAction) {
            return super.addPotentialAction(potentialAction);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl, androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Person build() {
            return super.build();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl clearAlternateNames() {
            return super.clearAlternateNames();
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl clearPotentialActions() {
            return super.clearPotentialActions();
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setAdditionalNames(List list) {
            return super.setAdditionalNames(list);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setAffiliations(List list) {
            return super.setAffiliations(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setAlternateNames(List list) {
            return super.setAlternateNames(list);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setBot(boolean z) {
            return super.setBot(z);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setContactPoints(List list) {
            return super.setContactPoints(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setCreationTimestampMillis(long j) {
            return super.setCreationTimestampMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setDescription(String str) {
            return super.setDescription(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setDocumentScore(int i) {
            return super.setDocumentScore(i);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setDocumentTtlMillis(long j) {
            return super.setDocumentTtlMillis(j);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setExternalUri(Uri uri) {
            return super.setExternalUri(uri);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setFamilyName(String str) {
            return super.setFamilyName(str);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setGivenName(String str) {
            return super.setGivenName(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setImage(String str) {
            return super.setImage(str);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setImageUri(Uri uri) {
            return super.setImageUri(uri);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setImportant(boolean z) {
            return super.setImportant(z);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setMiddleName(String str) {
            return super.setMiddleName(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setName(String str) {
            return super.setName(str);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setNotes(List list) {
            return super.setNotes(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setPotentialActions(List list) {
            return super.setPotentialActions(list);
        }

        @Override // androidx.appsearch.builtintypes.Person.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setRelations(List list) {
            return super.setRelations(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setUrl(String str) {
            return super.setUrl(str);
        }

        public Builder(Person person) {
            super(person);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<T extends BuilderImpl<T>> extends Thing.BuilderImpl<T> {
        private List<Long> mAdditionalNameTypes;
        private List<String> mAdditionalNames;
        private List<String> mAffiliations;
        private List<ContactPoint> mContactPoints;
        private Uri mExternalUri;
        private String mFamilyName;
        private String mGivenName;
        private Uri mImageUri;
        boolean mIsBot;
        boolean mIsImportant;
        private String mMiddleName;
        private List<String> mNotes;
        private List<String> mRelations;

        public BuilderImpl(String str, String str2, String str3) {
            super(str, str2);
            List list = Collections.EMPTY_LIST;
            this.mNotes = list;
            this.mAdditionalNameTypes = list;
            this.mAdditionalNames = list;
            this.mAffiliations = list;
            this.mRelations = list;
            this.mContactPoints = list;
            this.mName = (String) Preconditions.checkNotNull(str3);
        }

        public T setAdditionalNames(List<AdditionalName> list) {
            Preconditions.checkNotNull(list);
            int size = list.size();
            this.mAdditionalNameTypes = new ArrayList(size);
            this.mAdditionalNames = new ArrayList(size);
            for (int i = 0; i < list.size(); i++) {
                this.mAdditionalNameTypes.add(Long.valueOf(Preconditions.checkArgumentInRange(list.get(i).getType(), 0, 2, "type")));
                this.mAdditionalNames.add(list.get(i).getValue());
            }
            return this;
        }

        public T setAffiliations(List<String> list) {
            this.mAffiliations = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public T setBot(boolean z) {
            this.mIsBot = z;
            return this;
        }

        public T setContactPoints(List<ContactPoint> list) {
            this.mContactPoints = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public T setExternalUri(Uri uri) {
            this.mExternalUri = (Uri) Preconditions.checkNotNull(uri);
            return this;
        }

        public T setFamilyName(String str) {
            this.mFamilyName = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public T setGivenName(String str) {
            this.mGivenName = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public T setImageUri(Uri uri) {
            this.mImageUri = (Uri) Preconditions.checkNotNull(uri);
            return this;
        }

        public T setImportant(boolean z) {
            this.mIsImportant = z;
            return this;
        }

        public T setMiddleName(String str) {
            this.mMiddleName = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public T setNotes(List<String> list) {
            this.mNotes = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public T setRelations(List<String> list) {
            this.mRelations = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public Person build() {
            Preconditions.checkState(this.mAdditionalNameTypes.size() == this.mAdditionalNames.size());
            String str = this.mNamespace;
            String str2 = this.mId;
            int i = this.mDocumentScore;
            long j = this.mCreationTimestampMillis;
            long j2 = this.mDocumentTtlMillis;
            String str3 = this.mName;
            List<String> list = this.mAlternateNames;
            String str4 = this.mDescription;
            String str5 = this.mImage;
            String str6 = this.mUrl;
            List<PotentialAction> list2 = this.mPotentialActions;
            String str7 = this.mGivenName;
            String str8 = this.mMiddleName;
            String str9 = this.mFamilyName;
            Uri uri = this.mExternalUri;
            String string = uri != null ? uri.toString() : null;
            Uri uri2 = this.mImageUri;
            return new Person(str, str2, i, j, j2, str3, list, str4, str5, str6, list2, str7, str8, str9, string, uri2 != null ? uri2.toString() : null, this.mIsImportant, this.mIsBot, new ArrayList(this.mNotes), new ArrayList(this.mAdditionalNameTypes), new ArrayList(this.mAdditionalNames), new ArrayList(this.mAffiliations), new ArrayList(this.mRelations), new ArrayList(this.mContactPoints));
        }

        public BuilderImpl(Person person) {
            super(new Thing.Builder(person).build());
            List list = Collections.EMPTY_LIST;
            this.mNotes = list;
            this.mAdditionalNameTypes = list;
            this.mAdditionalNames = list;
            this.mAffiliations = list;
            this.mRelations = list;
            this.mContactPoints = list;
            this.mDocumentScore = person.getDocumentScore();
            this.mCreationTimestampMillis = person.getCreationTimestampMillis();
            this.mDocumentTtlMillis = person.getDocumentTtlMillis();
            this.mGivenName = person.getGivenName();
            this.mMiddleName = person.getMiddleName();
            this.mFamilyName = person.getFamilyName();
            this.mExternalUri = person.getExternalUri();
            this.mImageUri = person.getImageUri();
            this.mIsImportant = person.isImportant();
            this.mIsBot = person.isBot();
            this.mNotes = person.getNotes();
            this.mAffiliations = person.getAffiliations();
            this.mRelations = person.getRelations();
            this.mContactPoints = person.getContactPoints();
            setAdditionalNames(person.getTypedAdditionalNames());
        }
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public Person(String str, String str2, int i, long j, long j2, String str3, List<String> list, String str4, String str5, String str6, List<PotentialAction> list2, String str7, String str8, String str9, String str10, String str11, boolean z, boolean z2, List<String> list3, List<Long> list4, List<String> list5, List<String> list6, List<String> list7, List<ContactPoint> list8) {
        super(str, str2, i, j, j2, str3, list, str4, str5, str6, list2);
        this.mGivenName = str7;
        this.mMiddleName = str8;
        this.mFamilyName = str9;
        this.mExternalUri = str10;
        this.mImageUri = str11;
        this.mIsImportant = z;
        this.mIsBot = z2;
        this.mNotes = Collections.unmodifiableList(list3);
        List<Long> listUnmodifiableList = Collections.unmodifiableList(list4);
        this.mAdditionalNameTypes = listUnmodifiableList;
        this.mAdditionalNames = Collections.unmodifiableList(list5);
        this.mAffiliations = Collections.unmodifiableList(list6);
        this.mRelations = Collections.unmodifiableList(list7);
        this.mContactPoints = Collections.unmodifiableList(list8);
        ArrayList arrayList = new ArrayList(listUnmodifiableList.size());
        for (int i2 = 0; i2 < this.mAdditionalNameTypes.size(); i2++) {
            arrayList.add(new AdditionalName(this.mAdditionalNameTypes.get(i2).intValue(), this.mAdditionalNames.get(i2)));
        }
        this.mTypedAdditionalNames = Collections.unmodifiableList(arrayList);
    }

    public List<String> getAdditionalNames() {
        return this.mAdditionalNames;
    }

    public List<String> getAffiliations() {
        return this.mAffiliations;
    }

    public List<ContactPoint> getContactPoints() {
        return this.mContactPoints;
    }

    public Uri getExternalUri() {
        String str = this.mExternalUri;
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    public String getFamilyName() {
        return this.mFamilyName;
    }

    public String getGivenName() {
        return this.mGivenName;
    }

    public Uri getImageUri() {
        String str = this.mImageUri;
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    public String getMiddleName() {
        return this.mMiddleName;
    }

    public List<String> getNotes() {
        return this.mNotes;
    }

    public List<String> getRelations() {
        return this.mRelations;
    }

    public List<AdditionalName> getTypedAdditionalNames() {
        return this.mTypedAdditionalNames;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }
}
