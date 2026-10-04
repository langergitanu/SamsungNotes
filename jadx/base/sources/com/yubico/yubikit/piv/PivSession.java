package com.yubico.yubikit.piv;

import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.ApplicationSession;
import com.yubico.yubikit.core.application.BadResponseException;
import com.yubico.yubikit.core.application.Feature;
import com.yubico.yubikit.core.smartcard.Apdu;
import com.yubico.yubikit.core.smartcard.ApduException;
import com.yubico.yubikit.core.smartcard.ApduFormat;
import com.yubico.yubikit.core.smartcard.AppId;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.smartcard.SmartCardProtocol;
import com.yubico.yubikit.core.util.RandomUtils;
import com.yubico.yubikit.core.util.StringUtils;
import com.yubico.yubikit.core.util.Tlv;
import com.yubico.yubikit.core.util.Tlvs;
import com.yubico.yubikit.piv.KeyType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PivSession extends ApplicationSession<PivSession> {
    private static final int INDEX_PIN_POLICY = 0;
    private static final int INDEX_RETRIES_REMAINING = 1;
    private static final int INDEX_RETRIES_TOTAL = 0;
    private static final int INDEX_TOUCH_POLICY = 1;
    private static final byte INS_ATTEST = -7;
    private static final byte INS_AUTHENTICATE = -121;
    private static final byte INS_CHANGE_REFERENCE = 36;
    private static final byte INS_GENERATE_ASYMMETRIC = 71;
    private static final byte INS_GET_DATA = -53;
    private static final byte INS_GET_METADATA = -9;
    private static final byte INS_GET_SERIAL = -8;
    private static final byte INS_GET_VERSION = -3;
    private static final byte INS_IMPORT_KEY = -2;
    private static final byte INS_PUT_DATA = -37;
    private static final byte INS_RESET = -5;
    private static final byte INS_RESET_RETRY = 44;
    private static final byte INS_SET_MGMKEY = -1;
    private static final byte INS_SET_PIN_RETRIES = -6;
    private static final byte INS_VERIFY = 32;
    private static final byte ORIGIN_GENERATED = 1;
    private static final byte ORIGIN_IMPORTED = 2;
    private static final int PIN_LEN = 8;
    private static final byte PIN_P2 = -128;
    private static final int SLOT_CARD_MANAGEMENT = 155;
    private static final int TAG_AUTH_CHALLENGE = 129;
    private static final int TAG_AUTH_EXPONENTIATION = 133;
    private static final int TAG_AUTH_RESPONSE = 130;
    private static final int TAG_AUTH_WITNESS = 128;
    private static final int TAG_CERTIFICATE = 112;
    private static final int TAG_CERT_INFO = 113;
    private static final int TAG_DYN_AUTH = 124;
    private static final int TAG_GEN_ALGORITHM = 128;
    private static final int TAG_LRC = 254;
    private static final int TAG_METADATA_ALGO = 1;
    private static final int TAG_METADATA_IS_DEFAULT = 5;
    private static final int TAG_METADATA_ORIGIN = 3;
    private static final int TAG_METADATA_POLICY = 2;
    private static final int TAG_METADATA_PUBLIC_KEY = 4;
    private static final int TAG_METADATA_RETRIES = 6;
    private static final int TAG_OBJ_DATA = 83;
    private static final int TAG_OBJ_ID = 92;
    private static final int TAG_PIN_POLICY = 170;
    private static final int TAG_TOUCH_POLICY = 171;
    private int currentPinAttempts = 3;
    private int maxPinAttempts = 3;
    private final SmartCardProtocol protocol;
    private final Version version;
    public static final Feature<PivSession> FEATURE_P384 = new Feature.Versioned("Curve P384", 4, 0, 0);
    public static final Feature<PivSession> FEATURE_USAGE_POLICY = new Feature.Versioned("PIN/Touch Policy", 4, 0, 0);
    public static final Feature<PivSession> FEATURE_TOUCH_CACHED = new Feature.Versioned("Cached Touch Policy", 4, 3, 0);
    public static final Feature<PivSession> FEATURE_ATTESTATION = new Feature.Versioned("Attestation", 4, 3, 0);
    public static final Feature<PivSession> FEATURE_SERIAL = new Feature.Versioned("Serial Number", 5, 0, 0);
    public static final Feature<PivSession> FEATURE_METADATA = new Feature.Versioned("Metadata", 5, 3, 0);
    public static final Feature<PivSession> FEATURE_AES_KEY = new Feature.Versioned("AES Management Key", 5, 4, 0);
    public static final Feature<PivSession> FEATURE_RSA_GENERATION = new Feature<PivSession>("RSA key generation") { // from class: com.yubico.yubikit.piv.PivSession.1
        @Override // com.yubico.yubikit.core.application.Feature
        public boolean isSupportedBy(Version version) {
            return version.isLessThan(4, 2, 6) || version.isAtLeast(4, 3, 5);
        }
    };
    private static final byte[] KEY_PREFIX_P256 = {48, 89, 48, 19, 6, 7, 42, -122, 72, -50, 61, 2, 1, 6, 8, 42, -122, 72, -50, 61, 3, 1, 7, 3, 66, 0};
    private static final byte PUK_P2 = -127;
    private static final byte[] KEY_PREFIX_P384 = {48, 118, 48, 16, 6, 7, 42, -122, 72, -50, 61, 2, 1, 6, 5, 43, PUK_P2, 4, 0, 34, 3, 98, 0};
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PivSession.class);

    /* JADX INFO: renamed from: com.yubico.yubikit.piv.PivSession$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C119122 {
        static final /* synthetic */ int[] $SwitchMap$com$yubico$yubikit$piv$KeyType;
        static final /* synthetic */ int[] $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm;

        static {
            int[] iArr = new int[KeyType.values().length];
            $SwitchMap$com$yubico$yubikit$piv$KeyType = iArr;
            try {
                iArr[KeyType.ECCP256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yubico$yubikit$piv$KeyType[KeyType.ECCP384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[KeyType.Algorithm.values().length];
            $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm = iArr2;
            try {
                iArr2[KeyType.Algorithm.RSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm[KeyType.Algorithm.EC.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PivSession(SmartCardConnection smartCardConnection) {
        SmartCardProtocol smartCardProtocol = new SmartCardProtocol(smartCardConnection);
        this.protocol = smartCardProtocol;
        smartCardProtocol.select(AppId.PIV);
        Version versionFromBytes = Version.fromBytes(smartCardProtocol.sendAndReceive(new Apdu(0, -3, 0, 0, (byte[]) null)));
        this.version = versionFromBytes;
        smartCardProtocol.enableWorkarounds(versionFromBytes);
        if (smartCardConnection.isExtendedLengthApduSupported() && versionFromBytes.isAtLeast(4, 0, 0)) {
            smartCardProtocol.setApduFormat(ApduFormat.EXTENDED);
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "PIV session initialized (version={})", versionFromBytes);
    }

    private void blockPin() throws ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Verify PIN with invalid attempts until blocked");
        int pinAttempts = getPinAttempts();
        while (pinAttempts > 0) {
            try {
                verifyPin(new char[0]);
            } catch (InvalidPinException e) {
                pinAttempts = e.getAttemptsRemaining();
            }
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "PIN is blocked");
    }

    private void blockPuk() {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Verify PUK with invalid attempts until blocked");
        int attemptsRemaining = 1;
        while (attemptsRemaining > 0) {
            try {
                changeReference((byte) 44, (byte) -128, new char[0], new char[0]);
            } catch (InvalidPinException e) {
                attemptsRemaining = e.getAttemptsRemaining();
            }
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "PUK is blocked");
    }

    private static byte[] bytesToLength(BigInteger bigInteger, int i) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i) {
            return byteArray;
        }
        if (byteArray.length > i) {
            return Arrays.copyOfRange(byteArray, byteArray.length - i, byteArray.length);
        }
        byte[] bArr = new byte[i];
        System.arraycopy(byteArray, 0, bArr, i - byteArray.length, byteArray.length);
        return bArr;
    }

    private void changeReference(byte b, byte b5, char[] cArr, char[] cArr2) {
        byte b6;
        byte[] bArrPinBytes = pinBytes(cArr, cArr2);
        try {
            try {
                b6 = b5;
            } catch (ApduException e) {
                e = e;
                b6 = b5;
            }
            try {
                this.protocol.sendAndReceive(new Apdu(0, b, 0, b6, bArrPinBytes));
                Arrays.fill(bArrPinBytes, (byte) 0);
            } catch (ApduException e2) {
                e = e2;
                ApduException apduException = e;
                int retriesFromCode = getRetriesFromCode(apduException.getSw());
                if (retriesFromCode < 0) {
                    throw apduException;
                }
                if (b6 == -128) {
                    this.currentPinAttempts = retriesFromCode;
                }
                throw new InvalidPinException(retriesFromCode);
            }
        } catch (Throwable th) {
            Arrays.fill(bArrPinBytes, (byte) 0);
            throw th;
        }
    }

    private PinMetadata getPinPukMetadata(byte b) {
        require(FEATURE_METADATA);
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(this.protocol.sendAndReceive(new Apdu(0, -9, 0, b, (byte[]) null)));
        byte[] bArr = mapDecodeMap.get(6);
        return new PinMetadata(mapDecodeMap.get(5)[0] != 0, bArr[0], bArr[1]);
    }

    private int getRetriesFromCode(int i) {
        if (i == 27011) {
            return 0;
        }
        if (this.version.isLessThan(1, 0, 4)) {
            if (i < 25344 || i > 25599) {
                return -1;
            }
            return i & 255;
        }
        if (i < 25536 || i > 25551) {
            return -1;
        }
        return i & 15;
    }

    private X509Certificate parseCertificate(byte[] bArr) {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static List<BigInteger> parsePkcs8RsaKeyValues(byte[] bArr) throws UnsupportedEncodingException {
        try {
            List<Tlv> listDecodeList = Tlvs.decodeList(Tlvs.decodeMap(Tlvs.decodeMap(Tlvs.unpackValue(48, bArr)).get(4)).get(48));
            ArrayList arrayList = new ArrayList();
            Iterator<Tlv> it = listDecodeList.iterator();
            while (it.hasNext()) {
                arrayList.add(new BigInteger(it.next().getValue()));
            }
            if (((BigInteger) arrayList.remove(0)).intValue() == 0) {
                return arrayList;
            }
            throw new UnsupportedEncodingException("Expected value 0");
        } catch (BadResponseException e) {
            throw new UnsupportedEncodingException(e.getMessage());
        }
    }

    public static PublicKey parsePublicKeyFromDevice(KeyType keyType, byte[] bArr) {
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(bArr);
        try {
            return keyType.params.algorithm == KeyType.Algorithm.RSA ? publicRsaKey(new BigInteger(1, mapDecodeMap.get(129)), new BigInteger(1, mapDecodeMap.get(130))) : publicEccKey(keyType, mapDecodeMap.get(134));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] pinBytes(char[] cArr) {
        ByteBuffer byteBufferEncode = StandardCharsets.UTF_8.encode(CharBuffer.wrap(cArr));
        try {
            int iLimit = byteBufferEncode.limit() - byteBufferEncode.position();
            if (iLimit > 8) {
                throw new IllegalArgumentException("PIN/PUK must be no longer than 8 bytes");
            }
            byte[] bArrCopyOf = Arrays.copyOf(byteBufferEncode.array(), 8);
            Arrays.fill(bArrCopyOf, iLimit, 8, (byte) -1);
            return bArrCopyOf;
        } finally {
            Arrays.fill(byteBufferEncode.array(), (byte) 0);
        }
    }

    public static PublicKey publicEccKey(KeyType keyType, byte[] bArr) {
        byte[] bArr2;
        int i = C119122.$SwitchMap$com$yubico$yubikit$piv$KeyType[keyType.ordinal()];
        if (i == 1) {
            bArr2 = KEY_PREFIX_P256;
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Unsupported key type");
            }
            bArr2 = KEY_PREFIX_P384;
        }
        return KeyFactory.getInstance(keyType.params.algorithm.name()).generatePublic(new X509EncodedKeySpec(ByteBuffer.allocate(bArr2.length + bArr.length).put(bArr2).put(bArr).array()));
    }

    public static PublicKey publicRsaKey(BigInteger bigInteger, BigInteger bigInteger2) {
        return KeyFactory.getInstance(KeyType.Algorithm.RSA.name()).generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
    }

    private byte[] usePrivateKey(Slot slot, KeyType keyType, byte[] bArr, boolean z) throws ApduException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(130, null);
        linkedHashMap.put(Integer.valueOf(z ? 133 : 129), bArr);
        try {
            return Tlvs.unpackValue(130, Tlvs.unpackValue(124, this.protocol.sendAndReceive(new Apdu(0, -121, keyType.value, slot.value, new Tlv(124, Tlvs.encodeMap(linkedHashMap)).getBytes()))));
        } catch (ApduException e) {
            if (27264 == e.getSw()) {
                throw new ApduException(e.getSw(), String.format(Locale.ROOT, "Make sure that %s key is generated on slot %02X", keyType.name(), Integer.valueOf(slot.value)));
            }
            throw e;
        }
    }

    public X509Certificate attestKey(Slot slot) throws BadResponseException, ApduException {
        require(FEATURE_ATTESTATION);
        try {
            byte[] bArrSendAndReceive = this.protocol.sendAndReceive(new Apdu(0, -7, slot.value, 0, (byte[]) null));
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Attested key in slot {}", slot);
            return parseCertificate(bArrSendAndReceive);
        } catch (ApduException e) {
            if (27264 == e.getSw()) {
                throw new ApduException(e.getSw(), String.format(Locale.ROOT, "Make sure that key is generated on slot %02X", Integer.valueOf(slot.value)));
            }
            throw e;
        } catch (CertificateException e2) {
            throw new BadResponseException("Failed to parse certificate", e2);
        }
    }

    public void authenticate(ManagementKeyType managementKeyType, byte[] bArr) throws BadResponseException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Authenticating with key type: {}", managementKeyType);
        if (bArr.length != managementKeyType.keyLength) {
            throw new IllegalArgumentException(String.format("Management Key must be %d bytes", Integer.valueOf(managementKeyType.keyLength)));
        }
        byte[] bArrUnpackValue = Tlvs.unpackValue(128, Tlvs.unpackValue(124, this.protocol.sendAndReceive(new Apdu(0, -121, managementKeyType.value, 155, new Tlv(124, new Tlv(128, null).getBytes()).getBytes()))));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, managementKeyType.cipherName);
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Cipher cipher = Cipher.getInstance(managementKeyType.cipherName + "/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            linkedHashMap.put(128, cipher.doFinal(bArrUnpackValue));
            byte[] randomBytes = RandomUtils.getRandomBytes(managementKeyType.challengeLength);
            linkedHashMap.put(129, randomBytes);
            byte[] bArrUnpackValue2 = Tlvs.unpackValue(130, Tlvs.unpackValue(124, this.protocol.sendAndReceive(new Apdu(0, -121, managementKeyType.value, 155, new Tlv(124, Tlvs.encodeMap(linkedHashMap)).getBytes()))));
            cipher.init(1, secretKeySpec);
            byte[] bArrDoFinal = cipher.doFinal(randomBytes);
            if (MessageDigest.isEqual(bArrUnpackValue2, bArrDoFinal)) {
                return;
            }
            com.yubico.yubikit.core.internal.Logger.trace(logger2, "Expected response: {} and actual response {}", StringUtils.bytesToHex(bArrDoFinal), StringUtils.bytesToHex(bArrUnpackValue2));
            throw new BadResponseException("Calculated response for challenge is incorrect");
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] calculateSecret(Slot slot, ECPublicKey eCPublicKey) {
        KeyType keyTypeFromKey = KeyType.fromKey(eCPublicKey);
        int i = keyTypeFromKey.params.bitLength / 8;
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Performing key agreement with key in slot {} of type {}", slot, keyTypeFromKey);
        return usePrivateKey(slot, keyTypeFromKey, ByteBuffer.allocate((i * 2) + 1).put((byte) 4).put(bytesToLength(eCPublicKey.getW().getAffineX(), i)).put(bytesToLength(eCPublicKey.getW().getAffineY(), i)).array(), true);
    }

    public void changePin(char[] cArr, char[] cArr2) {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Changing PIN");
        changeReference((byte) 36, (byte) -128, cArr, cArr2);
        com.yubico.yubikit.core.internal.Logger.info(logger2, "New PIN set");
    }

    public void changePuk(char[] cArr, char[] cArr2) {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Changing PUK");
        changeReference((byte) 36, PUK_P2, cArr, cArr2);
        com.yubico.yubikit.core.internal.Logger.info(logger2, "New PUK set");
    }

    public void checkKeySupport(KeyType keyType, PinPolicy pinPolicy, TouchPolicy touchPolicy, boolean z) {
        if (this.version.major == 0) {
            return;
        }
        if (keyType == KeyType.ECCP384) {
            require(FEATURE_P384);
        }
        if (pinPolicy != PinPolicy.DEFAULT || touchPolicy != TouchPolicy.DEFAULT) {
            require(FEATURE_USAGE_POLICY);
            if (touchPolicy == TouchPolicy.CACHED) {
                require(FEATURE_TOUCH_CACHED);
            }
        }
        if (z && keyType.params.algorithm == KeyType.Algorithm.RSA) {
            require(FEATURE_RSA_GENERATION);
        }
        if (this.version.isAtLeast(4, 4, 0) && this.version.isLessThan(4, 5, 0)) {
            if (keyType == KeyType.RSA1024) {
                throw new UnsupportedOperationException("RSA 1024 is not supported on YubiKey FIPS");
            }
            if (pinPolicy == PinPolicy.NEVER) {
                throw new UnsupportedOperationException("PinPolicy.NEVER is not allowed on YubiKey FIPS");
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.protocol.close();
    }

    @Deprecated
    public byte[] decrypt(Slot slot, byte[] bArr, Cipher cipher) {
        KeyType keyType;
        int length = bArr.length;
        if (length == 128) {
            keyType = KeyType.RSA1024;
        } else {
            if (length != 256) {
                throw new IllegalArgumentException("Invalid length of ciphertext");
            }
            keyType = KeyType.RSA2048;
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Decrypting data with key in slot {} of type {}", slot, keyType);
        return Padding.unpad(usePrivateKey(slot, keyType, bArr, false), cipher);
    }

    public void deleteCertificate(Slot slot) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Deleting certificate in slot {}", slot);
        putObject(slot.objectId, null);
    }

    public PublicKey generateKey(Slot slot, KeyType keyType, PinPolicy pinPolicy, TouchPolicy touchPolicy) {
        checkKeySupport(keyType, pinPolicy, touchPolicy, true);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(128, new byte[]{keyType.value});
        if (pinPolicy != PinPolicy.DEFAULT) {
            linkedHashMap.put(170, new byte[]{(byte) pinPolicy.value});
        }
        if (touchPolicy != TouchPolicy.DEFAULT) {
            linkedHashMap.put(171, new byte[]{(byte) touchPolicy.value});
        }
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Generating key with pin_policy={}, touch_policy={}", pinPolicy, touchPolicy);
        byte[] bArrSendAndReceive = this.protocol.sendAndReceive(new Apdu(0, 71, 0, slot.value, new Tlv(-84, Tlvs.encodeMap(linkedHashMap)).getBytes()));
        com.yubico.yubikit.core.internal.Logger.info(logger2, "Private key generated in slot {} of type {}", slot, keyType);
        return parsePublicKeyFromDevice(keyType, Tlvs.unpackValue(32585, bArrSendAndReceive));
    }

    public X509Certificate getCertificate(Slot slot) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Reading certificate in slot {}", slot);
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(getObject(slot.objectId));
        byte[] bArr = mapDecodeMap.get(113);
        byte[] bArrDecompress = mapDecodeMap.get(112);
        if (bArr != null && bArr.length > 0 && bArr[0] != 0) {
            try {
                bArrDecompress = GzipUtils.decompress(bArrDecompress);
            } catch (IOException e) {
                throw new BadResponseException("Failed to decompress certificate", e);
            }
        }
        try {
            return parseCertificate(bArrDecompress);
        } catch (CertificateException e2) {
            throw new BadResponseException("Failed to parse certificate: ", e2);
        }
    }

    public ManagementKeyMetadata getManagementKeyMetadata() {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Getting management key metadata");
        require(FEATURE_METADATA);
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(this.protocol.sendAndReceive(new Apdu(0, -9, 0, 155, (byte[]) null)));
        return new ManagementKeyMetadata(mapDecodeMap.containsKey(1) ? ManagementKeyType.fromValue(mapDecodeMap.get(1)[0]) : ManagementKeyType.TDES, mapDecodeMap.get(5)[0] != 0, TouchPolicy.fromValue(mapDecodeMap.get(2)[1]));
    }

    public byte[] getObject(int i) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Reading data from object slot {}", Integer.toString(i, 16));
        return Tlvs.unpackValue(83, this.protocol.sendAndReceive(new Apdu(0, -53, 63, 255, new Tlv(92, ObjectId.getBytes(i)).getBytes())));
    }

    public int getPinAttempts() throws ApduException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Getting PIN attempts");
        if (supports(FEATURE_METADATA)) {
            return getPinMetadata().getAttemptsRemaining();
        }
        try {
            this.protocol.sendAndReceive(new Apdu(0, 32, 0, -128, (byte[]) null));
            com.yubico.yubikit.core.internal.Logger.debug(logger2, "Using cached value, may be incorrect");
            return this.currentPinAttempts;
        } catch (ApduException e) {
            int retriesFromCode = getRetriesFromCode(e.getSw());
            if (retriesFromCode < 0) {
                throw e;
            }
            this.currentPinAttempts = retriesFromCode;
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Using value from empty verify");
            return retriesFromCode;
        }
    }

    public PinMetadata getPinMetadata() {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Getting PIN metadata");
        return getPinPukMetadata((byte) -128);
    }

    public PinMetadata getPukMetadata() {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Getting PUK metadata");
        return getPinPukMetadata(PUK_P2);
    }

    public int getSerialNumber() {
        require(FEATURE_SERIAL);
        return ByteBuffer.wrap(this.protocol.sendAndReceive(new Apdu(0, -8, 0, 0, (byte[]) null))).getInt();
    }

    public SlotMetadata getSlotMetadata(Slot slot) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Getting metadata for slot {}", slot);
        require(FEATURE_METADATA);
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(this.protocol.sendAndReceive(new Apdu(0, -9, 0, slot.value, (byte[]) null)));
        byte[] bArr = mapDecodeMap.get(2);
        return new SlotMetadata(KeyType.fromValue(mapDecodeMap.get(1)[0]), PinPolicy.fromValue(bArr[0]), TouchPolicy.fromValue(bArr[1]), mapDecodeMap.get(3)[0] == 1, mapDecodeMap.get(4));
    }

    @Override // com.yubico.yubikit.core.application.ApplicationSession
    public Version getVersion() {
        return this.version;
    }

    public void putCertificate(Slot slot, X509Certificate x509Certificate, boolean z) {
        byte[] bArr = {z ? (byte) 1 : (byte) 0};
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Storing {}certificate in slot {}", z ? "compressed " : "", slot);
        try {
            byte[] encoded = x509Certificate.getEncoded();
            if (z) {
                encoded = GzipUtils.compress(encoded);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(112, encoded);
            linkedHashMap.put(113, bArr);
            linkedHashMap.put(254, null);
            putObject(slot.objectId, Tlvs.encodeMap(linkedHashMap));
        } catch (CertificateEncodingException e) {
            throw new IllegalArgumentException("Failed to get encoded version of certificate", e);
        }
    }

    public KeyType putKey(Slot slot, PrivateKey privateKey, PinPolicy pinPolicy, TouchPolicy touchPolicy) {
        List<BigInteger> pkcs8RsaKeyValues;
        KeyType keyTypeFromKey = KeyType.fromKey(privateKey);
        checkKeySupport(keyTypeFromKey, pinPolicy, touchPolicy, false);
        KeyType.KeyParams keyParams = keyTypeFromKey.params;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = C119122.$SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm[keyParams.algorithm.ordinal()];
        if (i == 1) {
            if (privateKey instanceof RSAPrivateCrtKey) {
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) privateKey;
                pkcs8RsaKeyValues = Arrays.asList(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
            } else {
                if (!"PKCS#8".equals(privateKey.getFormat())) {
                    throw new UnsupportedEncodingException("Unsupported private key encoding");
                }
                pkcs8RsaKeyValues = parsePkcs8RsaKeyValues(privateKey.getEncoded());
            }
            if (pkcs8RsaKeyValues.get(1).intValue() != 65537) {
                throw new UnsupportedEncodingException("Unsupported RSA public exponent");
            }
            int i2 = (keyParams.bitLength / 8) / 2;
            linkedHashMap.put(1, bytesToLength(pkcs8RsaKeyValues.get(3), i2));
            linkedHashMap.put(2, bytesToLength(pkcs8RsaKeyValues.get(4), i2));
            linkedHashMap.put(3, bytesToLength(pkcs8RsaKeyValues.get(5), i2));
            linkedHashMap.put(4, bytesToLength(pkcs8RsaKeyValues.get(6), i2));
            linkedHashMap.put(5, bytesToLength(pkcs8RsaKeyValues.get(7), i2));
        } else if (i == 2) {
            linkedHashMap.put(6, bytesToLength(((ECPrivateKey) privateKey).getS(), keyParams.bitLength / 8));
        }
        if (pinPolicy != PinPolicy.DEFAULT) {
            linkedHashMap.put(170, new byte[]{(byte) pinPolicy.value});
        }
        if (touchPolicy != TouchPolicy.DEFAULT) {
            linkedHashMap.put(171, new byte[]{(byte) touchPolicy.value});
        }
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Importing key with pin_policy={}, touch_policy={}", pinPolicy, touchPolicy);
        this.protocol.sendAndReceive(new Apdu(0, -2, keyTypeFromKey.value, slot.value, Tlvs.encodeMap(linkedHashMap)));
        com.yubico.yubikit.core.internal.Logger.info(logger2, "Private key imported in slot {} of type {}", slot, keyTypeFromKey);
        return keyTypeFromKey;
    }

    public void putObject(int i, @Nullable byte[] bArr) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Writing data to object slot {}", Integer.toString(i, 16));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(92, ObjectId.getBytes(i));
        linkedHashMap.put(83, bArr);
        this.protocol.sendAndReceive(new Apdu(0, -37, 63, 255, Tlvs.encodeMap(linkedHashMap)));
    }

    public byte[] rawSignOrDecrypt(Slot slot, KeyType keyType, byte[] bArr) {
        KeyType.KeyParams keyParams = keyType.params;
        int i = keyParams.bitLength / 8;
        if (bArr.length > i) {
            if (keyParams.algorithm != KeyType.Algorithm.EC) {
                throw new IllegalArgumentException("Payload too large for key");
            }
            bArr = Arrays.copyOf(bArr, i);
        } else if (bArr.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, i - bArr.length, bArr.length);
            bArr = bArr2;
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Decrypting data with key in slot {} of type {}", slot, keyType);
        return usePrivateKey(slot, keyType, bArr, false);
    }

    public void reset() throws ApduException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Preparing PIV reset");
        blockPin();
        blockPuk();
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Sending reset");
        this.protocol.sendAndReceive(new Apdu(0, -5, 0, 0, (byte[]) null));
        this.currentPinAttempts = 3;
        this.maxPinAttempts = 3;
        com.yubico.yubikit.core.internal.Logger.info(logger2, "PIV application data reset performed");
    }

    public void setManagementKey(ManagementKeyType managementKeyType, byte[] bArr, boolean z) throws IOException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Setting management key of type: {}", managementKeyType);
        if (managementKeyType != ManagementKeyType.TDES) {
            require(FEATURE_AES_KEY);
        }
        if (z) {
            require(FEATURE_USAGE_POLICY);
        }
        if (bArr.length != managementKeyType.keyLength) {
            throw new IllegalArgumentException(String.format("Management key must be %d bytes", Integer.valueOf(managementKeyType.keyLength)));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(managementKeyType.value);
        byteArrayOutputStream.write(new Tlv(155, bArr).getBytes());
        this.protocol.sendAndReceive(new Apdu(0, -1, 255, z ? 254 : 255, byteArrayOutputStream.toByteArray()));
        com.yubico.yubikit.core.internal.Logger.info(logger2, "Management key set");
    }

    public void setPinAttempts(int i, int i2) {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Setting PIN/PUK attempts ({}, {})", Integer.valueOf(i), Integer.valueOf(i2));
        this.protocol.sendAndReceive(new Apdu(0, -6, i, i2, (byte[]) null));
        this.maxPinAttempts = i;
        this.currentPinAttempts = i;
        com.yubico.yubikit.core.internal.Logger.info(logger2, "PIN/PUK attempts set");
    }

    @Deprecated
    public byte[] sign(Slot slot, KeyType keyType, byte[] bArr, Signature signature) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Signing data with key in slot {} of type {} using algorithm {}", slot, keyType, signature);
        return usePrivateKey(slot, keyType, Padding.pad(keyType, bArr, signature), false);
    }

    public void unblockPin(char[] cArr, char[] cArr2) {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Using PUK to set new PIN");
        changeReference((byte) 44, (byte) -128, cArr, cArr2);
        com.yubico.yubikit.core.internal.Logger.info(logger2, "New PIN set");
    }

    public void verifyPin(char[] cArr) {
        try {
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Verifying PIN");
            this.protocol.sendAndReceive(new Apdu(0, 32, 0, -128, pinBytes(cArr)));
            this.currentPinAttempts = this.maxPinAttempts;
        } catch (ApduException e) {
            int retriesFromCode = getRetriesFromCode(e.getSw());
            if (retriesFromCode < 0) {
                throw e;
            }
            this.currentPinAttempts = retriesFromCode;
            throw new InvalidPinException(retriesFromCode);
        }
    }

    private static byte[] pinBytes(char[] cArr, char[] cArr2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArrPinBytes = pinBytes(cArr);
        byte[] bArrPinBytes2 = pinBytes(cArr2);
        try {
            try {
                byteArrayOutputStream.write(bArrPinBytes);
                byteArrayOutputStream.write(bArrPinBytes2);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } finally {
            Arrays.fill(bArrPinBytes, (byte) 0);
            Arrays.fill(bArrPinBytes2, (byte) 0);
        }
    }

    public void putCertificate(Slot slot, X509Certificate x509Certificate) {
        putCertificate(slot, x509Certificate, false);
    }
}
