package org.apache.poi.openxml4j.opc.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.sdk.deepsky.donation.schema.DonationContract;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.apache.poi.openxml4j.util.Nullable;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class PackagePropertiesPart extends PackagePart implements PackageProperties {
    public static final String NAMESPACE_CP_URI = "http://schemas.openxmlformats.org/package/2006/metadata/core-properties";
    public static final String NAMESPACE_DCTERMS_URI = "http://purl.org/dc/terms/";
    public static final String NAMESPACE_DC_URI = "http://purl.org/dc/elements/1.1/";
    private final Pattern TIME_ZONE_PAT;
    private final String[] TZ_DATE_FORMATS;
    protected Nullable<String> category;
    protected Nullable<String> contentStatus;
    protected Nullable<String> contentType;
    protected Nullable<Date> created;
    protected Nullable<String> creator;
    protected Nullable<String> description;
    protected Nullable<String> identifier;
    protected Nullable<String> keywords;
    protected Nullable<String> language;
    protected Nullable<String> lastModifiedBy;
    protected Nullable<Date> lastPrinted;
    protected Nullable<Date> modified;
    protected Nullable<String> revision;
    protected Nullable<String> subject;
    protected Nullable<String> title;
    protected Nullable<String> version;
    private static final String DEFAULT_DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String[] DATE_FORMATS = {DEFAULT_DATEFORMAT, "yyyy-MM-dd'T'HH:mm:ss.SS'Z'", DonationContract.DONATION_DATE_FORMAT};

    public PackagePropertiesPart(OPCPackage oPCPackage, PackagePartName packagePartName) {
        super(oPCPackage, packagePartName, "application/vnd.openxmlformats-package.core-properties+xml");
        this.TZ_DATE_FORMATS = new String[]{"yyyy-MM-dd'T'HH:mm:ssz", "yyyy-MM-dd'T'HH:mm:ss.Sz", "yyyy-MM-dd'T'HH:mm:ss.SSz", "yyyy-MM-dd'T'HH:mm:ss.SSSz"};
        this.TIME_ZONE_PAT = Pattern.compile("([-+]\\d\\d):?(\\d\\d)");
        this.category = new Nullable<>();
        this.contentStatus = new Nullable<>();
        this.contentType = new Nullable<>();
        this.created = new Nullable<>();
        this.creator = new Nullable<>();
        this.description = new Nullable<>();
        this.identifier = new Nullable<>();
        this.keywords = new Nullable<>();
        this.language = new Nullable<>();
        this.lastModifiedBy = new Nullable<>();
        this.lastPrinted = new Nullable<>();
        this.modified = new Nullable<>();
        this.revision = new Nullable<>();
        this.subject = new Nullable<>();
        this.title = new Nullable<>();
        this.version = new Nullable<>();
    }

    private String getDateValue(Nullable<Date> nullable) {
        Date value;
        if (nullable == null || (value = nullable.getValue()) == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATEFORMAT, Locale.ROOT);
        simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
        return simpleDateFormat.format(value);
    }

    private Nullable<Date> setDateValue(String str) throws InvalidFormatException {
        if (str == null || str.equals("")) {
            return new Nullable<>();
        }
        Matcher matcher = this.TIME_ZONE_PAT.matcher(str);
        if (matcher.find()) {
            String str2 = str.substring(0, matcher.start()) + matcher.group(1) + matcher.group(2);
            for (String str3 : this.TZ_DATE_FORMATS) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, Locale.ROOT);
                simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
                Date date = simpleDateFormat.parse(str2, new ParsePosition(0));
                if (date != null) {
                    return new Nullable<>(date);
                }
            }
        }
        String strConcat = str.endsWith("Z") ? str : str.concat("Z");
        for (String str4 : DATE_FORMATS) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str4, Locale.ROOT);
            simpleDateFormat2.setTimeZone(LocaleUtil.TIMEZONE_UTC);
            Date date2 = simpleDateFormat2.parse(strConcat, new ParsePosition(0));
            if (date2 != null) {
                return new Nullable<>(date2);
            }
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.TZ_DATE_FORMATS;
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str5 = strArr[i];
            int i4 = i2 + 1;
            if (i2 > 0) {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(str5);
            i++;
            i2 = i4;
        }
        String[] strArr2 = DATE_FORMATS;
        int length2 = strArr2.length;
        for (int iM2213d = 0; iM2213d < length2; iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, SQLKeyword.COMMA, strArr2[iM2213d])) {
        }
        throw new InvalidFormatException("Date " + str + " not well formatted, expected format in: " + ((Object) sb));
    }

    private Nullable<String> setStringValue(String str) {
        return (str == null || str.equals("")) ? new Nullable<>() : new Nullable<>(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getCategoryProperty() {
        return this.category;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getContentStatusProperty() {
        return this.contentStatus;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getContentTypeProperty() {
        return this.contentType;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<Date> getCreatedProperty() {
        return this.created;
    }

    public String getCreatedPropertyString() {
        return getDateValue(this.created);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getCreatorProperty() {
        return this.creator;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getDescriptionProperty() {
        return this.description;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getIdentifierProperty() {
        return this.identifier;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getKeywordsProperty() {
        return this.keywords;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getLanguageProperty() {
        return this.language;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getLastModifiedByProperty() {
        return this.lastModifiedBy;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<Date> getLastPrintedProperty() {
        return this.lastPrinted;
    }

    public String getLastPrintedPropertyString() {
        return getDateValue(this.lastPrinted);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<Date> getModifiedProperty() {
        return this.modified;
    }

    public String getModifiedPropertyString() {
        return this.modified.hasValue() ? getDateValue(this.modified) : getDateValue(new Nullable<>(new Date()));
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        throw new InvalidOperationException("Can't use output stream to set properties !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getRevisionProperty() {
        return this.revision;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getSubjectProperty() {
        return this.subject;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getTitleProperty() {
        return this.title;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getVersionProperty() {
        return this.version;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean load(InputStream inputStream) {
        throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) {
        throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCategoryProperty(String str) {
        this.category = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setContentStatusProperty(String str) {
        this.contentStatus = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setContentTypeProperty(String str) {
        this.contentType = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCreatedProperty(String str) {
        try {
            this.created = setDateValue(str);
        } catch (InvalidFormatException e) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Date for created could not be parsed: ", str), e);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCreatorProperty(String str) {
        this.creator = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setDescriptionProperty(String str) {
        this.description = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setIdentifierProperty(String str) {
        this.identifier = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setKeywordsProperty(String str) {
        this.keywords = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setLanguageProperty(String str) {
        this.language = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setLastModifiedByProperty(String str) {
        this.lastModifiedBy = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setLastPrintedProperty(String str) {
        try {
            this.lastPrinted = setDateValue(str);
        } catch (InvalidFormatException e) {
            throw new IllegalArgumentException("lastPrinted  : " + e.getLocalizedMessage(), e);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setModifiedProperty(String str) {
        try {
            this.modified = setDateValue(str);
        } catch (InvalidFormatException e) {
            throw new IllegalArgumentException("modified  : " + e.getLocalizedMessage(), e);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setRevisionProperty(String str) {
        this.revision = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setSubjectProperty(String str) {
        this.subject = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setTitleProperty(String str) {
        this.title = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setVersionProperty(String str) {
        this.version = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setLastPrintedProperty(Nullable<Date> nullable) {
        if (nullable.hasValue()) {
            this.lastPrinted = nullable;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setModifiedProperty(Nullable<Date> nullable) {
        if (nullable.hasValue()) {
            this.modified = nullable;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCreatedProperty(Nullable<Date> nullable) {
        if (nullable.hasValue()) {
            this.created = nullable;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void close() {
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void flush() {
    }
}
