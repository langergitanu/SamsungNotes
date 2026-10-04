package androidx.compose.p109ui.autofill;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.firebase.messaging.Constants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0080\u0002¢\u0006\u0002\b\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Landroidx/compose/ui/autofill/ContentType;", "", "contentHint", "", "(Ljava/lang/String;)V", "contentHints", "", "(Ljava/util/Set;)V", "plus", "other", "plus$ui_release", "Companion", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ContentType {

    @NotNull
    private final Set<String> contentHints;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final ContentType Username = new ContentType("username");

    @NotNull
    private static final ContentType Password = new ContentType("password");

    @NotNull
    private static final ContentType EmailAddress = new ContentType(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS);

    @NotNull
    private static final ContentType NewUsername = new ContentType(HintConstants.AUTOFILL_HINT_NEW_USERNAME);

    @NotNull
    private static final ContentType NewPassword = new ContentType(HintConstants.AUTOFILL_HINT_NEW_PASSWORD);

    @NotNull
    private static final ContentType PostalAddress = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS);

    @NotNull
    private static final ContentType PostalCode = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_CODE);

    @NotNull
    private static final ContentType CreditCardNumber = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_NUMBER);

    @NotNull
    private static final ContentType CreditCardSecurityCode = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE);

    @NotNull
    private static final ContentType CreditCardExpirationDate = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE);

    @NotNull
    private static final ContentType CreditCardExpirationMonth = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH);

    @NotNull
    private static final ContentType CreditCardExpirationYear = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR);

    @NotNull
    private static final ContentType CreditCardExpirationDay = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY);

    @NotNull
    private static final ContentType AddressCountry = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY);

    @NotNull
    private static final ContentType AddressRegion = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION);

    @NotNull
    private static final ContentType AddressLocality = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY);

    @NotNull
    private static final ContentType AddressStreet = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS);

    @NotNull
    private static final ContentType AddressAuxiliaryDetails = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS);

    @NotNull
    private static final ContentType PostalCodeExtended = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE);

    @NotNull
    private static final ContentType PersonFullName = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME);

    @NotNull
    private static final ContentType PersonFirstName = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN);

    @NotNull
    private static final ContentType PersonLastName = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY);

    @NotNull
    private static final ContentType PersonMiddleName = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE);

    @NotNull
    private static final ContentType PersonMiddleInitial = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE_INITIAL);

    @NotNull
    private static final ContentType PersonNamePrefix = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_PREFIX);

    @NotNull
    private static final ContentType PersonNameSuffix = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_SUFFIX);

    @NotNull
    private static final ContentType PhoneNumber = new ContentType(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);

    @NotNull
    private static final ContentType PhoneNumberDevice = new ContentType(HintConstants.AUTOFILL_HINT_PHONE_NUMBER_DEVICE);

    @NotNull
    private static final ContentType PhoneCountryCode = new ContentType(HintConstants.AUTOFILL_HINT_PHONE_COUNTRY_CODE);

    @NotNull
    private static final ContentType PhoneNumberNational = new ContentType(HintConstants.AUTOFILL_HINT_PHONE_NATIONAL);

    @NotNull
    private static final ContentType Gender = new ContentType("gender");

    @NotNull
    private static final ContentType BirthDateFull = new ContentType(HintConstants.AUTOFILL_HINT_BIRTH_DATE_FULL);

    @NotNull
    private static final ContentType BirthDateDay = new ContentType(HintConstants.AUTOFILL_HINT_BIRTH_DATE_DAY);

    @NotNull
    private static final ContentType BirthDateMonth = new ContentType(HintConstants.AUTOFILL_HINT_BIRTH_DATE_MONTH);

    @NotNull
    private static final ContentType BirthDateYear = new ContentType(HintConstants.AUTOFILL_HINT_BIRTH_DATE_YEAR);

    @NotNull
    private static final ContentType SmsOtpCode = new ContentType(HintConstants.AUTOFILL_HINT_SMS_OTP);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020OH\u0000¢\u0006\u0002\bPR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0011\u00101\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0011\u00105\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0011\u00107\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0011\u00109\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0011\u0010;\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0011\u0010=\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0011\u0010?\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0011\u0010A\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006R\u0011\u0010C\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006R\u0011\u0010E\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0006R\u0011\u0010G\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0006R\u0011\u0010I\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0006R\u0011\u0010K\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0006¨\u0006Q"}, m13886d2 = {"Landroidx/compose/ui/autofill/ContentType$Companion;", "", "()V", "AddressAuxiliaryDetails", "Landroidx/compose/ui/autofill/ContentType;", "getAddressAuxiliaryDetails", "()Landroidx/compose/ui/autofill/ContentType;", "AddressCountry", "getAddressCountry", "AddressLocality", "getAddressLocality", "AddressRegion", "getAddressRegion", "AddressStreet", "getAddressStreet", "BirthDateDay", "getBirthDateDay", "BirthDateFull", "getBirthDateFull", "BirthDateMonth", "getBirthDateMonth", "BirthDateYear", "getBirthDateYear", "CreditCardExpirationDate", "getCreditCardExpirationDate", "CreditCardExpirationDay", "getCreditCardExpirationDay", "CreditCardExpirationMonth", "getCreditCardExpirationMonth", "CreditCardExpirationYear", "getCreditCardExpirationYear", "CreditCardNumber", "getCreditCardNumber", "CreditCardSecurityCode", "getCreditCardSecurityCode", "EmailAddress", "getEmailAddress", "Gender", "getGender", "NewPassword", "getNewPassword", "NewUsername", "getNewUsername", "Password", "getPassword", "PersonFirstName", "getPersonFirstName", "PersonFullName", "getPersonFullName", "PersonLastName", "getPersonLastName", "PersonMiddleInitial", "getPersonMiddleInitial", "PersonMiddleName", "getPersonMiddleName", "PersonNamePrefix", "getPersonNamePrefix", "PersonNameSuffix", "getPersonNameSuffix", "PhoneCountryCode", "getPhoneCountryCode", "PhoneNumber", "getPhoneNumber", "PhoneNumberDevice", "getPhoneNumberDevice", "PhoneNumberNational", "getPhoneNumberNational", "PostalAddress", "getPostalAddress", "PostalCode", "getPostalCode", "PostalCodeExtended", "getPostalCodeExtended", "SmsOtpCode", "getSmsOtpCode", "Username", "getUsername", Constants.MessagePayloadKeys.FROM, "value", "", "from$ui_release", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @NotNull
        public final ContentType from$ui_release(@NotNull String value) {
            switch (value.hashCode()) {
                case -1844815832:
                    if (value.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH)) {
                        return getCreditCardExpirationMonth();
                    }
                    break;
                case -1821235109:
                    if (value.equals(HintConstants.AUTOFILL_HINT_NEW_PASSWORD)) {
                        return getNewPassword();
                    }
                    break;
                case -1757573738:
                    if (value.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE)) {
                        return getCreditCardSecurityCode();
                    }
                    break;
                case -1682373820:
                    if (value.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY)) {
                        return getCreditCardExpirationDay();
                    }
                    break;
                case -1492157798:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE_INITIAL)) {
                        return getPersonMiddleInitial();
                    }
                    break;
                case -1327425451:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PHONE_COUNTRY_CODE)) {
                        return getPhoneCountryCode();
                    }
                    break;
                case -1249512767:
                    if (value.equals("gender")) {
                        return getGender();
                    }
                    break;
                case -1192969641:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)) {
                        return getPhoneNumber();
                    }
                    break;
                case -1151034798:
                    if (value.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_NUMBER)) {
                        return getCreditCardNumber();
                    }
                    break;
                case -1070931784:
                    if (value.equals(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS)) {
                        return getEmailAddress();
                    }
                    break;
                case -782964728:
                    if (value.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION)) {
                        return getAddressRegion();
                    }
                    break;
                case -742913724:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY)) {
                        return getPersonLastName();
                    }
                    break;
                case -724274829:
                    if (value.equals(HintConstants.AUTOFILL_HINT_BIRTH_DATE_MONTH)) {
                        return getBirthDateMonth();
                    }
                    break;
                case -613980922:
                    if (value.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE)) {
                        return getCreditCardExpirationDate();
                    }
                    break;
                case -613352043:
                    if (value.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR)) {
                        return getCreditCardExpirationYear();
                    }
                    break;
                case -398527665:
                    if (value.equals(HintConstants.AUTOFILL_HINT_BIRTH_DATE_DAY)) {
                        return getBirthDateDay();
                    }
                    break;
                case -265713450:
                    if (value.equals("username")) {
                        return getUsername();
                    }
                    break;
                case -50595520:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PHONE_NATIONAL)) {
                        return getPhoneNumberNational();
                    }
                    break;
                case 289393:
                    if (value.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS)) {
                        return getAddressStreet();
                    }
                    break;
                case 146220155:
                    if (value.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS)) {
                        return getAddressAuxiliaryDetails();
                    }
                    break;
                case 530622780:
                    if (value.equals(HintConstants.AUTOFILL_HINT_BIRTH_DATE_FULL)) {
                        return getBirthDateFull();
                    }
                    break;
                case 531173098:
                    if (value.equals(HintConstants.AUTOFILL_HINT_BIRTH_DATE_YEAR)) {
                        return getBirthDateYear();
                    }
                    break;
                case 678483840:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME)) {
                        return getPersonFullName();
                    }
                    break;
                case 956262285:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PHONE_NUMBER_DEVICE)) {
                        return getPhoneNumberDevice();
                    }
                    break;
                case 991032982:
                    if (value.equals(HintConstants.AUTOFILL_HINT_NEW_USERNAME)) {
                        return getNewUsername();
                    }
                    break;
                case 1216985755:
                    if (value.equals("password")) {
                        return getPassword();
                    }
                    break;
                case 1369618690:
                    if (value.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY)) {
                        return getAddressCountry();
                    }
                    break;
                case 1617991537:
                    if (value.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE)) {
                        return getPostalCodeExtended();
                    }
                    break;
                case 1662667945:
                    if (value.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS)) {
                        return getPostalAddress();
                    }
                    break;
                case 1781320055:
                    if (value.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY)) {
                        return getAddressLocality();
                    }
                    break;
                case 1834963923:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN)) {
                        return getPersonFirstName();
                    }
                    break;
                case 1865618463:
                    if (value.equals(HintConstants.AUTOFILL_HINT_SMS_OTP)) {
                        return getSmsOtpCode();
                    }
                    break;
                case 1917507122:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_PREFIX)) {
                        return getPersonNamePrefix();
                    }
                    break;
                case 1935279861:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE)) {
                        return getPersonMiddleName();
                    }
                    break;
                case 2006194929:
                    if (value.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_SUFFIX)) {
                        return getPersonNameSuffix();
                    }
                    break;
                case 2011152728:
                    if (value.equals(HintConstants.AUTOFILL_HINT_POSTAL_CODE)) {
                        return getPostalCode();
                    }
                    break;
            }
            return new ContentType(value);
        }

        @NotNull
        public final ContentType getAddressAuxiliaryDetails() {
            return ContentType.AddressAuxiliaryDetails;
        }

        @NotNull
        public final ContentType getAddressCountry() {
            return ContentType.AddressCountry;
        }

        @NotNull
        public final ContentType getAddressLocality() {
            return ContentType.AddressLocality;
        }

        @NotNull
        public final ContentType getAddressRegion() {
            return ContentType.AddressRegion;
        }

        @NotNull
        public final ContentType getAddressStreet() {
            return ContentType.AddressStreet;
        }

        @NotNull
        public final ContentType getBirthDateDay() {
            return ContentType.BirthDateDay;
        }

        @NotNull
        public final ContentType getBirthDateFull() {
            return ContentType.BirthDateFull;
        }

        @NotNull
        public final ContentType getBirthDateMonth() {
            return ContentType.BirthDateMonth;
        }

        @NotNull
        public final ContentType getBirthDateYear() {
            return ContentType.BirthDateYear;
        }

        @NotNull
        public final ContentType getCreditCardExpirationDate() {
            return ContentType.CreditCardExpirationDate;
        }

        @NotNull
        public final ContentType getCreditCardExpirationDay() {
            return ContentType.CreditCardExpirationDay;
        }

        @NotNull
        public final ContentType getCreditCardExpirationMonth() {
            return ContentType.CreditCardExpirationMonth;
        }

        @NotNull
        public final ContentType getCreditCardExpirationYear() {
            return ContentType.CreditCardExpirationYear;
        }

        @NotNull
        public final ContentType getCreditCardNumber() {
            return ContentType.CreditCardNumber;
        }

        @NotNull
        public final ContentType getCreditCardSecurityCode() {
            return ContentType.CreditCardSecurityCode;
        }

        @NotNull
        public final ContentType getEmailAddress() {
            return ContentType.EmailAddress;
        }

        @NotNull
        public final ContentType getGender() {
            return ContentType.Gender;
        }

        @NotNull
        public final ContentType getNewPassword() {
            return ContentType.NewPassword;
        }

        @NotNull
        public final ContentType getNewUsername() {
            return ContentType.NewUsername;
        }

        @NotNull
        public final ContentType getPassword() {
            return ContentType.Password;
        }

        @NotNull
        public final ContentType getPersonFirstName() {
            return ContentType.PersonFirstName;
        }

        @NotNull
        public final ContentType getPersonFullName() {
            return ContentType.PersonFullName;
        }

        @NotNull
        public final ContentType getPersonLastName() {
            return ContentType.PersonLastName;
        }

        @NotNull
        public final ContentType getPersonMiddleInitial() {
            return ContentType.PersonMiddleInitial;
        }

        @NotNull
        public final ContentType getPersonMiddleName() {
            return ContentType.PersonMiddleName;
        }

        @NotNull
        public final ContentType getPersonNamePrefix() {
            return ContentType.PersonNamePrefix;
        }

        @NotNull
        public final ContentType getPersonNameSuffix() {
            return ContentType.PersonNameSuffix;
        }

        @NotNull
        public final ContentType getPhoneCountryCode() {
            return ContentType.PhoneCountryCode;
        }

        @NotNull
        public final ContentType getPhoneNumber() {
            return ContentType.PhoneNumber;
        }

        @NotNull
        public final ContentType getPhoneNumberDevice() {
            return ContentType.PhoneNumberDevice;
        }

        @NotNull
        public final ContentType getPhoneNumberNational() {
            return ContentType.PhoneNumberNational;
        }

        @NotNull
        public final ContentType getPostalAddress() {
            return ContentType.PostalAddress;
        }

        @NotNull
        public final ContentType getPostalCode() {
            return ContentType.PostalCode;
        }

        @NotNull
        public final ContentType getPostalCodeExtended() {
            return ContentType.PostalCodeExtended;
        }

        @NotNull
        public final ContentType getSmsOtpCode() {
            return ContentType.SmsOtpCode;
        }

        @NotNull
        public final ContentType getUsername() {
            return ContentType.Username;
        }

        private Companion() {
        }
    }

    private ContentType(Set<String> set) {
        this.contentHints = set;
    }

    @NotNull
    public final ContentType plus$ui_release(@NotNull ContentType other) {
        return new ContentType((Set<String>) SetsKt.plus((Set) this.contentHints, (Iterable) other.contentHints));
    }

    public ContentType(@NotNull String str) {
        this((Set<String>) SetsKt.setOf(str));
    }
}
