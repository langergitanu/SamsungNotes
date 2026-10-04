package com.samsung.android.kmxservice.sdk.util;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERPrintableString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Asn1Utils {
    private static int bigIntegerToInt(BigInteger bigInteger) throws CertificateParsingException {
        if (bigInteger.compareTo(BigInteger.valueOf(2147483647L)) > 0 || bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new CertificateParsingException("INTEGER out of bounds");
        }
        return bigInteger.intValue();
    }

    private static long bigIntegerToLong(BigInteger bigInteger) throws CertificateParsingException {
        if (bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 || bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new CertificateParsingException("INTEGER out of bounds");
        }
        return bigInteger.longValue();
    }

    public static ASN1Encodable getAsn1EncodableFromBytes(byte[] bArr) throws CertificateParsingException {
        try {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
            try {
                ASN1Primitive object = aSN1InputStream.readObject();
                aSN1InputStream.close();
                return object;
            } finally {
            }
        } catch (IOException e) {
            throw new CertificateParsingException("Failed to parse SEQUENCE", e);
        }
    }

    public static ASN1Sequence getAsn1SequenceFromBytes(byte[] bArr) throws CertificateParsingException {
        try {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
            try {
                ASN1Sequence asn1SequenceFromStream = getAsn1SequenceFromStream(aSN1InputStream);
                aSN1InputStream.close();
                return asn1SequenceFromStream;
            } finally {
            }
        } catch (IOException e) {
            throw new CertificateParsingException("Failed to parse SEQUENCE", e);
        }
    }

    public static ASN1Sequence getAsn1SequenceFromStream(ASN1InputStream aSN1InputStream) throws CertificateParsingException {
        ASN1OctetString object = aSN1InputStream.readObject();
        if (!(object instanceof ASN1OctetString)) {
            if (object != null) {
                throw new CertificateParsingException("Expected octet stream, found ".concat(object.getClass().getName()));
            }
            throw new CertificateParsingException("Expected octet stream, asn1Primitive is NULL ");
        }
        ASN1InputStream aSN1InputStream2 = new ASN1InputStream(object.getOctets());
        try {
            ASN1Sequence object2 = aSN1InputStream2.readObject();
            if (object2 instanceof ASN1Sequence) {
                ASN1Sequence aSN1Sequence = object2;
                aSN1InputStream2.close();
                return aSN1Sequence;
            }
            if (object2 == null) {
                throw new CertificateParsingException("ASN1InputStream NULL");
            }
            throw new CertificateParsingException("Expected sequence, found ".concat(object2.getClass().getName()));
        } catch (Throwable th) {
            try {
                aSN1InputStream2.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean getBooleanFromAsn1(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (aSN1Encodable instanceof ASN1Boolean) {
            return ((ASN1Boolean) aSN1Encodable).isTrue();
        }
        throw new CertificateParsingException("Expected boolean, found ".concat(aSN1Encodable.getClass().getName()));
    }

    public static byte[] getByteArrayFromAsn1(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (aSN1Encodable == null) {
            throw new CertificateParsingException("Expected DEROctetString");
        }
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            aSN1Encodable = ((ASN1TaggedObject) aSN1Encodable).getObject();
        }
        if (aSN1Encodable instanceof DEROctetString) {
            return ((ASN1OctetString) aSN1Encodable).getOctets();
        }
        if (aSN1Encodable instanceof DERPrintableString) {
            return ((DERPrintableString) aSN1Encodable).getOctets();
        }
        throw new CertificateParsingException("Expected DEROctetString");
    }

    public static Date getDateFromAsn1(ASN1Primitive aSN1Primitive) {
        return new Date(getLongFromAsn1(aSN1Primitive).longValue());
    }

    public static int getIntegerFromAsn1(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (aSN1Encodable instanceof ASN1Integer) {
            return bigIntegerToInt(((ASN1Integer) aSN1Encodable).getValue());
        }
        if (aSN1Encodable instanceof ASN1Enumerated) {
            return bigIntegerToInt(((ASN1Enumerated) aSN1Encodable).getValue());
        }
        throw new CertificateParsingException("Integer value expected, " + aSN1Encodable.getClass().getName() + " found.");
    }

    public static Set<Integer> getIntegersFromAsn1Set(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (!(aSN1Encodable instanceof ASN1Set)) {
            throw new CertificateParsingException("Expected set, found ".concat(aSN1Encodable.getClass().getName()));
        }
        HashSet hashSet = new HashSet();
        Enumeration objects = ((ASN1Set) aSN1Encodable).getObjects();
        while (objects.hasMoreElements()) {
            hashSet.add(Integer.valueOf(getIntegerFromAsn1((ASN1Integer) objects.nextElement())));
        }
        return hashSet;
    }

    public static Long getLongFromAsn1(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (aSN1Encodable instanceof ASN1Integer) {
            return Long.valueOf(bigIntegerToLong(((ASN1Integer) aSN1Encodable).getValue()));
        }
        throw new CertificateParsingException("Integer value expected, " + aSN1Encodable.getClass().getName() + " found.");
    }

    public static String getStringFromAsn1OctetStreamAssumingUTF8(ASN1Encodable aSN1Encodable) throws CertificateParsingException {
        if (aSN1Encodable instanceof ASN1OctetString) {
            return new String(((ASN1OctetString) aSN1Encodable).getOctets(), StandardCharsets.UTF_8);
        }
        throw new CertificateParsingException("Expected octet string, found ".concat(aSN1Encodable.getClass().getName()));
    }
}
