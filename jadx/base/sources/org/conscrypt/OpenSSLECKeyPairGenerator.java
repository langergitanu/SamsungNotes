package org.conscrypt;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class OpenSSLECKeyPairGenerator extends KeyPairGenerator {
    private static final String ALGORITHM = "EC";
    private static final int DEFAULT_KEY_SIZE = 256;
    private static final Map<Integer, String> SIZE_TO_CURVE_NAME;
    private OpenSSLECGroupContext group;

    static {
        HashMap map = new HashMap();
        SIZE_TO_CURVE_NAME = map;
        AbstractC6670b.m4751l(JPEG.APP0, map, "secp224r1", 256, "prime256v1");
        AbstractC6670b.m4751l(384, map, "secp384r1", 521, "secp521r1");
    }

    public OpenSSLECKeyPairGenerator() {
        super(ALGORITHM);
    }

    public static void assertCurvesAreValid() {
        ArrayList arrayList = new ArrayList();
        for (String str : SIZE_TO_CURVE_NAME.values()) {
            if (OpenSSLECGroupContext.getCurveByName(str) == null) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() <= 0) {
            return;
        }
        throw new AssertionError("Invalid curve names: " + Arrays.toString(arrayList.toArray()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.group == null) {
            String str = SIZE_TO_CURVE_NAME.get(256);
            OpenSSLECGroupContext curveByName = OpenSSLECGroupContext.getCurveByName(str);
            this.group = curveByName;
            if (curveByName == null) {
                throw new RuntimeException(AbstractC0541b.m772n("Curve not recognized: ", str));
            }
        }
        OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.EC_KEY_generate_key(this.group.getNativeRef()));
        return new KeyPair(new OpenSSLECPublicKey(this.group, openSSLKey), new OpenSSLECPrivateKey(this.group, openSSLKey));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        String str = SIZE_TO_CURVE_NAME.get(Integer.valueOf(i));
        if (str == null) {
            throw new InvalidParameterException(AbstractC0000a.m11h(i, "unknown key size "));
        }
        OpenSSLECGroupContext curveByName = OpenSSLECGroupContext.getCurveByName(str);
        if (curveByName == null) {
            throw new InvalidParameterException("unknown curve ".concat(str));
        }
        this.group = curveByName;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof ECParameterSpec) {
            this.group = OpenSSLECGroupContext.getInstance((ECParameterSpec) algorithmParameterSpec);
            return;
        }
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            String name = ((ECGenParameterSpec) algorithmParameterSpec).getName();
            OpenSSLECGroupContext curveByName = OpenSSLECGroupContext.getCurveByName(name);
            if (curveByName != null) {
                this.group = curveByName;
                return;
            }
            throw new InvalidAlgorithmParameterException(AbstractC0541b.m772n("unknown curve name: ", name));
        }
        throw new InvalidAlgorithmParameterException("parameter must be ECParameterSpec or ECGenParameterSpec");
    }
}
