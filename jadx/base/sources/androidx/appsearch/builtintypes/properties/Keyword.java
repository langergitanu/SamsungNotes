package androidx.appsearch.builtintypes.properties;

import androidx.appsearch.annotation.Document;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Document
public final class Keyword {

    @Document.StringProperty(indexingType = 2)
    final String mAsText;

    @Document.Namespace
    String mNamespace = "";

    @Document.InterfaceC0555Id
    String mId = "";

    public Keyword(String str) {
        this.mAsText = (String) Preconditions.checkNotNull(str);
    }

    public String asText() {
        return this.mAsText;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Keyword.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mAsText, ((Keyword) obj).mAsText);
    }

    public int hashCode() {
        return Objects.hashCode(this.mAsText);
    }
}
