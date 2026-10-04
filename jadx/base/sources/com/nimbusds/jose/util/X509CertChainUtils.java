package com.nimbusds.jose.util;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.openssl.PEMParser;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class X509CertChainUtils {
    private X509CertChainUtils() {
    }

    public static List<X509Certificate> parse(List<Base64> list) throws ParseException {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                X509Certificate x509Certificate = X509CertUtils.parse(list.get(i).decode());
                if (x509Certificate == null) {
                    throw new ParseException(AbstractC0000a.m11h(i, "Invalid X.509 certificate at position "), 0);
                }
                linkedList.add(x509Certificate);
            }
        }
        return linkedList;
    }

    public static List<UUID> store(KeyStore keyStore, List<X509Certificate> list) throws KeyStoreException {
        LinkedList linkedList = new LinkedList();
        for (X509Certificate x509Certificate : list) {
            UUID uuidRandomUUID = UUID.randomUUID();
            keyStore.setCertificateEntry(uuidRandomUUID.toString(), x509Certificate);
            linkedList.add(uuidRandomUUID);
        }
        return linkedList;
    }

    public static List<Base64> toBase64List(List<Object> list) throws ParseException {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj == null) {
                throw new ParseException(AbstractC0541b.m767i(i, "The X.509 certificate at position ", " must not be null"), 0);
            }
            if (!(obj instanceof String)) {
                throw new ParseException(AbstractC0541b.m767i(i, "The X.509 certificate at position ", " must be encoded as a Base64 string"), 0);
            }
            linkedList.add(new Base64((String) obj));
        }
        return linkedList;
    }

    public static List<X509Certificate> parse(File file) {
        return parse(new String(Files.readAllBytes(file.toPath()), StandardCharset.UTF_8));
    }

    public static List<X509Certificate> parse(String str) {
        Object object;
        PEMParser pEMParser = new PEMParser(new StringReader(str));
        LinkedList linkedList = new LinkedList();
        do {
            object = pEMParser.readObject();
            if (object instanceof X509CertificateHolder) {
                linkedList.add(X509CertUtils.parseWithException(((X509CertificateHolder) object).getEncoded()));
            }
        } while (object != null);
        return linkedList;
    }
}
