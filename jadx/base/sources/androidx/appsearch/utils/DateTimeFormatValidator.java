package androidx.appsearch.utils;

import androidx.annotation.RestrictTo;
import com.samsung.android.app.sdk.deepsky.donation.schema.DonationContract;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DateTimeFormatValidator {
    private DateTimeFormatValidator() {
    }

    public static boolean validateDateFormat(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setLenient(false);
        try {
            Date date = simpleDateFormat.parse(str2);
            if (date != null) {
                return str2.equals(simpleDateFormat.format(date));
            }
            return false;
        } catch (ParseException unused) {
            return false;
        }
    }

    public static boolean validateISO8601Date(String str) {
        return validateDateFormat(DonationContract.DONATION_DATE_FORMAT, str);
    }

    public static boolean validateISO8601DateTime(String str) {
        return validateDateFormat("yyyy-MM-dd'T'HH:mm", str) || validateDateFormat("yyyy-MM-dd'T'HH:mm:ss", str);
    }
}
