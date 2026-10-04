package opennlp.tools.dictionary.serializer;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.util.StringList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Entry extends AbstractC12991c {
    private final Attributes attributes;
    private final StringList tokens;

    public Entry(StringList stringList, Attributes attributes) {
        this.tokens = stringList;
        this.attributes = attributes;
    }

    public Attributes attributes() {
        return this.attributes;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return Objects.equals(this.tokens, entry.tokens) && Objects.equals(this.attributes, entry.attributes);
    }

    public final int hashCode() {
        StringList stringList = this.tokens;
        Attributes attributes = this.attributes;
        return Objects.hashCode(attributes) + (Objects.hashCode(stringList) * 31);
    }

    public final String toString() {
        Object[] objArr = {this.tokens, this.attributes};
        String[] strArrSplit = "tokens;attributes".length() == 0 ? new String[0] : "tokens;attributes".split(";");
        StringBuilder sb = new StringBuilder("Entry[");
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]);
            sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            sb.append(objArr[i]);
            if (i != strArrSplit.length - 1) {
                sb.append(SQLKeyword.COMMA);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public StringList tokens() {
        return this.tokens;
    }
}
