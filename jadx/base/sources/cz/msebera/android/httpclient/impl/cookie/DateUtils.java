package cz.msebera.android.httpclient.impl.cookie;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public final class DateUtils {
    public static final TimeZone GMT = TimeZone.getTimeZone(TimeZones.GMT_ID);
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    private DateUtils() {
    }

    public static String formatDate(Date date) {
        return cz.msebera.android.httpclient.client.utils.DateUtils.formatDate(date);
    }

    public static Date parseDate(String str) {
        return parseDate(str, null, null);
    }

    public static String formatDate(Date date, String str) {
        return cz.msebera.android.httpclient.client.utils.DateUtils.formatDate(date, str);
    }

    public static Date parseDate(String str, String[] strArr) {
        return parseDate(str, strArr, null);
    }

    public static Date parseDate(String str, String[] strArr, Date date) throws DateParseException {
        Date date2 = cz.msebera.android.httpclient.client.utils.DateUtils.parseDate(str, strArr, date);
        if (date2 != null) {
            return date2;
        }
        throw new DateParseException(AbstractC0541b.m772n("Unable to parse the date ", str));
    }
}
