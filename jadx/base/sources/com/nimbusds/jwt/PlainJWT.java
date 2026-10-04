package com.nimbusds.jwt;

import com.nimbusds.jose.JOSEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.PlainHeader;
import com.nimbusds.jose.PlainObject;
import com.nimbusds.jose.util.Base64URL;
import java.text.ParseException;
import java.util.Map;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class PlainJWT extends PlainObject implements JWT {
    private static final long serialVersionUID = 1;
    private JWTClaimsSet claimsSet;

    public PlainJWT(JWTClaimsSet jWTClaimsSet) {
        super(jWTClaimsSet.toPayload());
        this.claimsSet = jWTClaimsSet;
    }

    public static PlainJWT parse(String str) throws ParseException {
        Base64URL[] base64URLArrSplit = JOSEObject.split(str);
        if (base64URLArrSplit[2].toString().isEmpty()) {
            return new PlainJWT(base64URLArrSplit[0], base64URLArrSplit[1]);
        }
        throw new ParseException("Unexpected third Base64URL part in the unsecured JWT object", 0);
    }

    @Override // com.nimbusds.jwt.JWT
    public JWTClaimsSet getJWTClaimsSet() throws ParseException {
        JWTClaimsSet jWTClaimsSet = this.claimsSet;
        if (jWTClaimsSet != null) {
            return jWTClaimsSet;
        }
        Map<String, Object> jSONObject = getPayload().toJSONObject();
        if (jSONObject == null) {
            throw new ParseException("Payload of unsecured JOSE object is not a valid JSON object", 0);
        }
        JWTClaimsSet jWTClaimsSet2 = JWTClaimsSet.parse(jSONObject);
        this.claimsSet = jWTClaimsSet2;
        return jWTClaimsSet2;
    }

    @Override // com.nimbusds.jose.JOSEObject
    public void setPayload(Payload payload) {
        this.claimsSet = null;
        super.setPayload(payload);
    }

    public PlainJWT(PlainHeader plainHeader, JWTClaimsSet jWTClaimsSet) {
        super(plainHeader, jWTClaimsSet.toPayload());
        this.claimsSet = jWTClaimsSet;
    }

    public PlainJWT(Base64URL base64URL, Base64URL base64URL2) {
        super(base64URL, base64URL2);
    }
}
