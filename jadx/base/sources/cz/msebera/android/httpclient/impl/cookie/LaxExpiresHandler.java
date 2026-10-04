package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class LaxExpiresHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final BitSet DELIMS;
    private static final Map<String, Integer> MONTHS;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final Pattern YEAR_PATTERN;

    static {
        BitSet bitSet = new BitSet();
        bitSet.set(9);
        for (int i = 32; i <= 47; i++) {
            bitSet.set(i);
        }
        for (int i2 = 59; i2 <= 64; i2++) {
            bitSet.set(i2);
        }
        for (int i4 = 91; i4 <= 96; i4++) {
            bitSet.set(i4);
        }
        for (int i5 = 123; i5 <= 126; i5++) {
            bitSet.set(i5);
        }
        DELIMS = bitSet;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(12);
        concurrentHashMap.put("jan", 0);
        concurrentHashMap.put("feb", 1);
        concurrentHashMap.put("mar", 2);
        concurrentHashMap.put("apr", 3);
        concurrentHashMap.put("may", 4);
        concurrentHashMap.put("jun", 5);
        concurrentHashMap.put("jul", 6);
        concurrentHashMap.put("aug", 7);
        concurrentHashMap.put("sep", 8);
        concurrentHashMap.put("oct", 9);
        concurrentHashMap.put("nov", 10);
        concurrentHashMap.put("dec", 11);
        MONTHS = concurrentHashMap;
        TIME_PATTERN = Pattern.compile("^([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})([^0-9].*)?$");
        DAY_OF_MONTH_PATTERN = Pattern.compile("^([0-9]{1,2})([^0-9].*)?$");
        MONTH_PATTERN = Pattern.compile("^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)(.*)?$", 2);
        YEAR_PATTERN = Pattern.compile("^([0-9]{2,4})([^0-9].*)?$");
    }

    private void copyContent(CharSequence charSequence, ParserCursor parserCursor, StringBuilder sb) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charSequence.charAt(pos2);
            if (DELIMS.get(cCharAt)) {
                break;
            }
            pos++;
            sb.append(cCharAt);
        }
        parserCursor.updatePos(pos);
    }

    private void skipDelims(CharSequence charSequence, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            if (!DELIMS.get(charSequence.charAt(pos2))) {
                break;
            }
            pos++;
        }
        parserCursor.updatePos(pos);
    }

    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.EXPIRES_ATTR;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        LaxExpiresHandler laxExpiresHandler = this;
        Args.notNull(setCookie, "Cookie");
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int iIntValue = 0;
        while (!parserCursor.atEnd()) {
            try {
                laxExpiresHandler.skipDelims(str, parserCursor);
                sb.setLength(0);
                laxExpiresHandler.copyContent(str, parserCursor, sb);
                if (sb.length() == 0) {
                    break;
                }
                if (!z) {
                    Matcher matcher = TIME_PATTERN.matcher(sb);
                    if (matcher.matches()) {
                        i4 = Integer.parseInt(matcher.group(1));
                        i5 = Integer.parseInt(matcher.group(2));
                        i6 = Integer.parseInt(matcher.group(3));
                        z = true;
                    } else if (!z2) {
                        Matcher matcher2 = DAY_OF_MONTH_PATTERN.matcher(sb);
                        if (matcher2.matches()) {
                            i2 = Integer.parseInt(matcher2.group(1));
                            z2 = true;
                        } else if (!z3) {
                            Matcher matcher3 = MONTH_PATTERN.matcher(sb);
                            if (matcher3.matches()) {
                                iIntValue = MONTHS.get(matcher3.group(1).toLowerCase(Locale.ROOT)).intValue();
                                z3 = true;
                            } else if (!z4) {
                                Matcher matcher4 = YEAR_PATTERN.matcher(sb);
                                if (matcher4.matches()) {
                                    i = Integer.parseInt(matcher4.group(1));
                                    z4 = true;
                                }
                            }
                        }
                    }
                }
                laxExpiresHandler = this;
            } catch (NumberFormatException unused) {
                throw new MalformedCookieException("Invalid 'expires' attribute: ".concat(str));
            }
        }
        if (!z || !z2 || !z3 || !z4) {
            throw new MalformedCookieException("Invalid 'expires' attribute: ".concat(str));
        }
        if (i >= 70 && i <= 99) {
            i += 1900;
        }
        if (i >= 0 && i <= 69) {
            i += 2000;
        }
        if (i2 < 1 || i2 > 31 || i < 1601 || i4 > 23 || i5 > 59 || i6 > 59) {
            throw new MalformedCookieException("Invalid 'expires' attribute: ".concat(str));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(UTC);
        calendar.setTimeInMillis(0L);
        calendar.set(13, i6);
        calendar.set(12, i5);
        calendar.set(11, i4);
        calendar.set(5, i2);
        calendar.set(2, iIntValue);
        calendar.set(1, i);
        setCookie.setExpiryDate(calendar.getTime());
    }
}
