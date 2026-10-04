package androidx.appsearch.builtintypes;

import androidx.appsearch.annotation.Document;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document(name = C$$__AppSearch__PotentialAction.SCHEMA_NAME)
@ExperimentalAppSearchApi
public class PotentialAction {

    @Document.StringProperty
    private final String mDescription;

    @Document.InterfaceC0555Id
    final String mId;

    @Document.StringProperty
    private final String mName;

    @Document.Namespace
    final String mNamespace;

    @Document.StringProperty
    private final String mUri;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private String mDescription;
        private String mName;
        private String mUri;

        public Builder() {
        }

        public PotentialAction build() {
            return new PotentialAction("", "", this.mName, this.mDescription, this.mUri);
        }

        public Builder setDescription(String str) {
            this.mDescription = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setUri(String str) {
            this.mUri = str;
            return this;
        }

        public Builder(PotentialAction potentialAction) {
            this.mName = potentialAction.getName();
            this.mDescription = potentialAction.getDescription();
            this.mUri = potentialAction.getUri();
        }
    }

    public PotentialAction(String str, String str2, String str3, String str4, String str5) {
        this.mNamespace = (String) Preconditions.checkNotNull(str);
        this.mId = (String) Preconditions.checkNotNull(str2);
        this.mName = str3;
        this.mDescription = str4;
        this.mUri = str5;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getName() {
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }
}
