package androidx.appsearch.builtintypes;

import androidx.annotation.OptIn;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.builtintypes.Thing;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__ContactPoint.SCHEMA_NAME)
public class ContactPoint extends Thing {

    @Document.StringProperty(indexingType = 2, name = "address")
    private final List<String> mAddresses;

    @Document.StringProperty(indexingType = 2, name = "email")
    private final List<String> mEmails;

    @Document.StringProperty(indexingType = 2)
    private final String mLabel;

    @Document.StringProperty(indexingType = 2, name = "telephone")
    private final List<String> mTelephones;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Document.BuilderProducer
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

        @Override // androidx.appsearch.builtintypes.ContactPoint.BuilderImpl, androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ ContactPoint build() {
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

        @Override // androidx.appsearch.builtintypes.ContactPoint.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setAddresses(List list) {
            return super.setAddresses(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setAlternateNames(List list) {
            return super.setAlternateNames(list);
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

        @Override // androidx.appsearch.builtintypes.ContactPoint.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setEmails(List list) {
            return super.setEmails(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setImage(String str) {
            return super.setImage(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setName(String str) {
            return super.setName(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setPotentialActions(List list) {
            return super.setPotentialActions(list);
        }

        @Override // androidx.appsearch.builtintypes.ContactPoint.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setTelephones(List list) {
            return super.setTelephones(list);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setUrl(String str) {
            return super.setUrl(str);
        }

        public Builder(ContactPoint contactPoint) {
            super(contactPoint);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<T extends BuilderImpl<T>> extends Thing.BuilderImpl<T> {
        private List<String> mAddresses;
        private List<String> mEmails;
        private String mLabel;
        private List<String> mTelephones;

        public BuilderImpl(String str, String str2, String str3) {
            super(str, str2);
            List<String> list = Collections.EMPTY_LIST;
            this.mAddresses = list;
            this.mEmails = list;
            this.mTelephones = list;
            this.mLabel = (String) Preconditions.checkNotNull(str3);
        }

        public T setAddresses(List<String> list) {
            this.mAddresses = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public T setEmails(List<String> list) {
            this.mEmails = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public T setTelephones(List<String> list) {
            this.mTelephones = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public ContactPoint build() {
            return new ContactPoint(this.mNamespace, this.mId, this.mDocumentScore, this.mCreationTimestampMillis, this.mDocumentTtlMillis, this.mName, this.mAlternateNames, this.mDescription, this.mImage, this.mUrl, this.mPotentialActions, this.mLabel, new ArrayList(this.mAddresses), new ArrayList(this.mEmails), new ArrayList(this.mTelephones));
        }

        public BuilderImpl(ContactPoint contactPoint) {
            super(new Thing.Builder(contactPoint).build());
            List<String> list = Collections.EMPTY_LIST;
            this.mAddresses = list;
            this.mEmails = list;
            this.mTelephones = list;
            this.mLabel = contactPoint.getLabel();
            this.mAddresses = contactPoint.getAddresses();
            this.mEmails = contactPoint.getEmails();
            this.mTelephones = contactPoint.getTelephones();
        }
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public ContactPoint(String str, String str2, int i, long j, long j2, String str3, List<String> list, String str4, String str5, String str6, List<PotentialAction> list2, String str7, List<String> list3, List<String> list4, List<String> list5) {
        super(str, str2, i, j, j2, str3, list, str4, str5, str6, list2);
        this.mLabel = str7;
        this.mAddresses = Collections.unmodifiableList(list3);
        this.mEmails = Collections.unmodifiableList(list4);
        this.mTelephones = Collections.unmodifiableList(list5);
    }

    public List<String> getAddresses() {
        return this.mAddresses;
    }

    public List<String> getEmails() {
        return this.mEmails;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public List<String> getTelephones() {
        return this.mTelephones;
    }
}
