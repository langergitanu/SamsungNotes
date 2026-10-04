package androidx.appsearch.builtintypes;

import androidx.annotation.OptIn;
import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.builtintypes.Thing;
import androidx.appsearch.builtintypes.properties.Keyword;
import androidx.core.util.Preconditions;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__ImageObject.SCHEMA_NAME)
public final class ImageObject extends Thing {

    @Document.BytesProperty
    private final byte[] mBytes;

    @Document.DocumentProperty(indexNestedProperties = true, name = SearchIndexablesContract.RawData.COLUMN_KEYWORDS)
    private final List<Keyword> mKeywords;

    @Document.StringProperty
    private final String mSha256;

    @Document.StringProperty
    private final String mThumbnailSha256;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends BuilderImpl<Builder> {
        public Builder(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl addAlternateName(String str) {
            return super.addAlternateName(str);
        }

        @Override // androidx.appsearch.builtintypes.ImageObject.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl addKeyword(Keyword keyword) {
            return super.addKeyword(keyword);
        }

        @Override // androidx.appsearch.builtintypes.ImageObject.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl addKeywords(Iterable iterable) {
            return super.addKeywords(iterable);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        @ExperimentalAppSearchApi
        public /* bridge */ /* synthetic */ Thing.BuilderImpl addPotentialAction(PotentialAction potentialAction) {
            return super.addPotentialAction(potentialAction);
        }

        @Override // androidx.appsearch.builtintypes.ImageObject.BuilderImpl, androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ ImageObject build() {
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

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setAlternateNames(List list) {
            return super.setAlternateNames(list);
        }

        @Override // androidx.appsearch.builtintypes.ImageObject.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setBytes(byte[] bArr) {
            return super.setBytes(bArr);
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

        @Override // androidx.appsearch.builtintypes.ImageObject.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setSha256(String str) {
            return super.setSha256(str);
        }

        @Override // androidx.appsearch.builtintypes.ImageObject.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl setThumbnailSha256(String str) {
            return super.setThumbnailSha256(str);
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public /* bridge */ /* synthetic */ Thing.BuilderImpl setUrl(String str) {
            return super.setUrl(str);
        }

        public Builder(ImageObject imageObject) {
            super(imageObject);
        }

        @Override // androidx.appsearch.builtintypes.ImageObject.BuilderImpl
        public /* bridge */ /* synthetic */ BuilderImpl addKeyword(String str) {
            return super.addKeyword(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BuilderImpl<Self extends BuilderImpl<Self>> extends Thing.BuilderImpl<Self> {
        protected byte[] mBytes;
        protected final List<Keyword> mKeywords;
        protected String mSha256;
        protected String mThumbnailSha256;

        public BuilderImpl(String str, String str2) {
            super(str, str2);
            this.mKeywords = new ArrayList();
            this.mSha256 = null;
            this.mThumbnailSha256 = null;
            this.mBytes = null;
        }

        public Self addKeyword(String str) {
            this.mKeywords.add(new Keyword((String) Preconditions.checkNotNull(str)));
            return this;
        }

        public Self addKeywords(Iterable<Keyword> iterable) {
            Iterator it = ((Iterable) Preconditions.checkNotNull(iterable)).iterator();
            while (it.hasNext()) {
                this.mKeywords.add((Keyword) Preconditions.checkNotNull((Keyword) it.next()));
            }
            return this;
        }

        public Self setBytes(byte[] bArr) {
            this.mBytes = bArr;
            return this;
        }

        public Self setSha256(String str) {
            this.mSha256 = str;
            return this;
        }

        public Self setThumbnailSha256(String str) {
            this.mThumbnailSha256 = str;
            return this;
        }

        public Self addKeyword(Keyword keyword) {
            this.mKeywords.add((Keyword) Preconditions.checkNotNull(keyword));
            return this;
        }

        @Override // androidx.appsearch.builtintypes.Thing.BuilderImpl
        public ImageObject build() {
            return new ImageObject(this.mNamespace, this.mId, this.mDocumentScore, this.mCreationTimestampMillis, this.mDocumentTtlMillis, this.mName, this.mAlternateNames, this.mDescription, this.mImage, this.mUrl, this.mPotentialActions, new ArrayList(this.mKeywords), this.mSha256, this.mThumbnailSha256, this.mBytes);
        }

        public BuilderImpl(ImageObject imageObject) {
            super(new Thing.Builder((Thing) Preconditions.checkNotNull(imageObject)).build());
            this.mKeywords = new ArrayList(imageObject.getKeywords());
            this.mSha256 = imageObject.getSha256();
            this.mThumbnailSha256 = imageObject.getThumbnailSha256();
            this.mBytes = imageObject.getBytes();
        }
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public ImageObject(String str, String str2, int i, long j, long j2, String str3, List<String> list, String str4, String str5, String str6, List<PotentialAction> list2, List<Keyword> list3, String str7, String str8, byte[] bArr) {
        super(str, str2, i, j, j2, str3, list, str4, str5, str6, list2);
        this.mKeywords = (List) Preconditions.checkNotNull(list3);
        this.mSha256 = str7;
        this.mThumbnailSha256 = str8;
        this.mBytes = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ImageObject.class == obj.getClass()) {
            ImageObject imageObject = (ImageObject) obj;
            if (this.mKeywords.equals(imageObject.mKeywords) && Objects.equals(this.mSha256, imageObject.mSha256) && Objects.equals(this.mThumbnailSha256, imageObject.mThumbnailSha256) && Arrays.equals(this.mBytes, imageObject.mBytes)) {
                return true;
            }
        }
        return false;
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public List<Keyword> getKeywords() {
        return this.mKeywords;
    }

    public String getSha256() {
        return this.mSha256;
    }

    public String getThumbnailSha256() {
        return this.mThumbnailSha256;
    }

    public int hashCode() {
        return Objects.hash(this.mKeywords, this.mSha256, this.mThumbnailSha256, Integer.valueOf(Arrays.hashCode(this.mBytes)));
    }
}
