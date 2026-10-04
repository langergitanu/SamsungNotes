package androidx.core.net;

import android.net.Uri;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.util.Preconditions;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";

    /* JADX INFO: renamed from: CC */
    private static final String f1311CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";

    /* JADX INFO: renamed from: TO */
    private static final String f1312TO = "to";
    private HashMap<String, String> mHeaders = new HashMap<>();

    private MailTo() {
    }

    public static boolean isMailTo(String str) {
        return str != null && str.startsWith(MAILTO_SCHEME);
    }

    public static MailTo parse(String str) {
        String strDecode;
        String strSubstring;
        Preconditions.checkNotNull(str);
        if (!isMailTo(str)) {
            throw new ParseException("Not a mailto scheme");
        }
        int iIndexOf = str.indexOf(35);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf(63);
        if (iIndexOf2 == -1) {
            strDecode = Uri.decode(str.substring(7));
            strSubstring = null;
        } else {
            strDecode = Uri.decode(str.substring(7, iIndexOf2));
            strSubstring = str.substring(iIndexOf2 + 1);
        }
        MailTo mailTo = new MailTo();
        if (strSubstring != null) {
            for (String str2 : strSubstring.split(MsalUtils.QUERY_STRING_DELIMITER)) {
                String[] strArrSplit = str2.split(MarketingConstants.REFERRER_DELIMITER_U003D, 2);
                if (strArrSplit.length != 0) {
                    mailTo.mHeaders.put(Uri.decode(strArrSplit[0]).toLowerCase(Locale.ROOT), strArrSplit.length > 1 ? Uri.decode(strArrSplit[1]) : null);
                }
            }
        }
        String to = mailTo.getTo();
        if (to != null) {
            strDecode = AbstractC0541b.m757C(strDecode, SQLKeyword.COMMA, to);
        }
        mailTo.mHeaders.put(f1312TO, strDecode);
        return mailTo;
    }

    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    public String getBody() {
        return this.mHeaders.get("body");
    }

    public String getCc() {
        return this.mHeaders.get("cc");
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    public String getTo() {
        return this.mHeaders.get(f1312TO);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("mailto:?");
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode(entry.getValue()));
            sb.append(Typography.amp);
        }
        return sb.toString();
    }

    public static boolean isMailTo(Uri uri) {
        return uri != null && MAILTO.equals(uri.getScheme());
    }

    public static MailTo parse(Uri uri) {
        return parse(uri.toString());
    }
}
