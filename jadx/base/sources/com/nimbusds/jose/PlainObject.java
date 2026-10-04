package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import java.text.ParseException;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class PlainObject extends JOSEObject {
    private static final long serialVersionUID = 1;
    private final PlainHeader header;

    public PlainObject(Payload payload) {
        if (payload == null) {
            throw new IllegalArgumentException("The payload must not be null");
        }
        setPayload(payload);
        this.header = new PlainHeader();
    }

    public static PlainObject parse(String str) throws ParseException {
        Base64URL[] base64URLArrSplit = JOSEObject.split(str);
        if (base64URLArrSplit[2].toString().isEmpty()) {
            return new PlainObject(base64URLArrSplit[0], base64URLArrSplit[1]);
        }
        throw new ParseException("Unexpected third Base64URL part", 0);
    }

    @Override // com.nimbusds.jose.JOSEObject
    public String serialize() {
        return this.header.toBase64URL().toString() + '.' + getPayload().toBase64URL().toString() + '.';
    }

    @Override // com.nimbusds.jose.JOSEObject
    public PlainHeader getHeader() {
        return this.header;
    }

    public PlainObject(PlainHeader plainHeader, Payload payload) {
        if (plainHeader != null) {
            this.header = plainHeader;
            if (payload != null) {
                setPayload(payload);
                return;
            }
            throw new IllegalArgumentException("The payload must not be null");
        }
        throw new IllegalArgumentException("The unsecured header must not be null");
    }

    public PlainObject(Base64URL base64URL, Base64URL base64URL2) throws ParseException {
        if (base64URL != null) {
            try {
                this.header = PlainHeader.parse(base64URL);
                if (base64URL2 != null) {
                    setPayload(new Payload(base64URL2));
                    setParsedParts(base64URL, base64URL2, null);
                    return;
                }
                throw new IllegalArgumentException("The second part must not be null");
            } catch (ParseException e) {
                throw new ParseException("Invalid unsecured header: " + e.getMessage(), 0);
            }
        }
        throw new IllegalArgumentException("The first part must not be null");
    }
}
