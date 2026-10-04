package com.microsoft.identity.common.adal.internal.cache;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.util.ProcessUtil;
import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.microsoft.identity.common.java.telemetry.ITelemetryCallback;
import com.microsoft.identity.common.java.util.ported.DateUtilities;
import com.microsoft.identity.common.logging.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.DigestException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import net.jcip.annotations.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class StorageHelper implements IStorageHelper {
    private static final String ADALKS = "adalks";
    private static final String ANDROID_KEY_STORE = "AndroidKeyStore";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String CURRENT_ACTIVE_BROKER = "current_active_broker";
    public static final int DATA_KEY_LENGTH = 16;
    private static final String ENCODE_VERSION = "E1";
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String HMAC_KEY_HASH_ALGORITHM = "SHA256";
    public static final int HMAC_LENGTH = 32;
    private static final String KEYSPEC_ALGORITHM = "AES";
    private static final int KEY_FILE_SIZE = 1024;
    private static final int KEY_SIZE = 256;
    private static final String KEY_STORE_CERT_ALIAS = "AdalKey";
    private static final int KEY_VERSION_BLOB_LENGTH = 4;
    private static final String TAG = "StorageHelper";
    public static final String VERSION_ANDROID_KEY_STORE = "A001";
    public static final String VERSION_USER_DEFINED = "U001";
    private static final String WRAP_ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final boolean sShouldEncryptWithKeyStoreKey = false;
    private String mBlobVersion;
    private SecretKey mCachedKeyStoreEncryptedKey;
    private final Context mContext;
    private SecretKey mEncryptionHMACKey;
    private SecretKey mEncryptionKey;

    @GuardedBy("this")
    private KeyPair mKeyPair;
    private final SecureRandom mRandom;
    private ITelemetryCallback mTelemetryCallback;

    @VisibleForTesting(otherwise = 2)
    public static final AtomicReference<String> LAST_KNOWN_THUMBPRINT = new AtomicReference<>("");
    public static final AtomicBoolean FIRST_TIME = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.microsoft.identity.common.adal.internal.cache.StorageHelper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C62291 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$adal$internal$cache$StorageHelper$KeyType */
        static final /* synthetic */ int[] f3580x98edcb9f;

        static {
            int[] iArr = new int[KeyType.values().length];
            f3580x98edcb9f = iArr;
            try {
                iArr[KeyType.LEGACY_AUTHENTICATOR_APP_KEY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3580x98edcb9f[KeyType.LEGACY_COMPANY_PORTAL_KEY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3580x98edcb9f[KeyType.ADAL_USER_DEFINED_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3580x98edcb9f[KeyType.KEYSTORE_ENCRYPTED_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum EncryptionType {
        USER_DEFINED,
        ANDROID_KEY_STORE,
        UNENCRYPTED
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum KeyType {
        LEGACY_AUTHENTICATOR_APP_KEY,
        LEGACY_COMPANY_PORTAL_KEY,
        ADAL_USER_DEFINED_KEY,
        KEYSTORE_ENCRYPTED_KEY
    }

    public StorageHelper(@NonNull Context context) {
        this(context, null);
    }

    public static synchronized void applyKeyStoreLocaleWorkarounds(@NonNull Locale locale) {
    }

    private void assertHMac(byte[] bArr, int i, int i2, byte[] bArr2) throws DigestException {
        if (bArr2.length != i2 - i) {
            throw new IllegalArgumentException("Unexpected HMAC length");
        }
        byte b = 0;
        for (int i4 = i; i4 < i2; i4++) {
            b = (byte) (b | (bArr2[i4 - i] ^ bArr[i4]));
        }
        if (b != 0) {
            throw new DigestException();
        }
    }

    @NonNull
    private String decryptWithSecretKey(@NonNull byte[] bArr, @NonNull SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, DigestException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        SecretKey hMacKey = getHMacKey(secretKey);
        int length = bArr.length;
        int i = length - 48;
        int length2 = bArr.length - 32;
        int i2 = length - 52;
        if (i < 0 || length2 < 0 || i2 < 0) {
            throw new IOException("Invalid byte array input for decryption.");
        }
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(hMacKey);
        mac.update(bArr, 0, length2);
        byte[] bArrDoFinal = mac.doFinal();
        logIfKeyHasChanged(hMacKey);
        assertHMac(bArr, length2, bArr.length, bArrDoFinal);
        cipher.init(2, secretKey, new IvParameterSpec(bArr, i, 16));
        return new String(cipher.doFinal(bArr, 4, i2), AuthenticationConstants.CHARSET_UTF8);
    }

    private void emitDecryptionFailureTelemetryIfNeeded(@NonNull KeyType keyType, @NonNull Exception exc) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        String string = defaultSharedPreferences.getString(CURRENT_ACTIVE_BROKER, "");
        String packageName = this.mContext.getPackageName();
        if (string.equalsIgnoreCase(packageName)) {
            return;
        }
        String str = "Decryption failed with key: " + keyType.name() + " Active broker: " + packageName + " Exception: " + exc.toString();
        Logger.info("StorageHelper:emitDecryptionFailureTelemetryIfNeeded", str);
        ITelemetryCallback iTelemetryCallback = this.mTelemetryCallback;
        if (iTelemetryCallback != null) {
            iTelemetryCallback.logEvent(AuthenticationConstants.TelemetryEvents.DECRYPTION_ERROR, Boolean.TRUE, str);
        }
        defaultSharedPreferences.edit().putString(CURRENT_ACTIVE_BROKER, packageName).apply();
    }

    @TargetApi(18)
    private synchronized KeyPair generateKeyPairFromAndroidKeyStore() {
        try {
            synchronized ((DateUtilities.isLocaleCalendarNonGregorian(Locale.getDefault()) ? DateUtilities.LOCALE_CHANGE_LOCK : new Object())) {
                Locale locale = Locale.getDefault();
                applyKeyStoreLocaleWorkarounds(locale);
                KeyPair keyPair = readKeyPair();
                try {
                    if (keyPair != null) {
                        Logger.verbose("StorageHelper:generateKeyPairFromAndroidKeyStore", "Existing keypair was found.  Returning existing key rather than generating new one.");
                        return keyPair;
                    }
                    try {
                        logFlowStart("StorageHelper:generateKeyPairFromAndroidKeyStore", AuthenticationConstants.TelemetryEvents.KEYSTORE_WRITE_START);
                        KeyStore.getInstance(ANDROID_KEY_STORE).load(null);
                        Logger.verbose("StorageHelper:generateKeyPairFromAndroidKeyStore", "Generate KeyPair from AndroidKeyStore");
                        Calendar calendar = Calendar.getInstance();
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.add(1, 100);
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, ANDROID_KEY_STORE);
                        keyPairGenerator.initialize(getKeyPairGeneratorSpec(this.mContext, calendar.getTime(), calendar2.getTime()));
                        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
                        logFlowSuccess("StorageHelper:generateKeyPairFromAndroidKeyStore", AuthenticationConstants.TelemetryEvents.KEYSTORE_WRITE_END, "");
                        return keyPairGenerateKeyPair;
                    } catch (IOException e) {
                        e = e;
                        logFlowError("StorageHelper:generateKeyPairFromAndroidKeyStore", AuthenticationConstants.TelemetryEvents.KEYSTORE_WRITE_END, e.toString(), e);
                        throw e;
                    } catch (IllegalStateException e2) {
                        logFlowError("StorageHelper:generateKeyPairFromAndroidKeyStore", AuthenticationConstants.TelemetryEvents.KEYSTORE_WRITE_END, e2.toString(), e2);
                        throw new KeyStoreException(e2);
                    } catch (GeneralSecurityException e3) {
                        e = e3;
                        logFlowError("StorageHelper:generateKeyPairFromAndroidKeyStore", AuthenticationConstants.TelemetryEvents.KEYSTORE_WRITE_END, e.toString(), e);
                        throw e;
                    }
                } finally {
                    Locale.setDefault(locale);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private byte[] getByteArrayFromEncryptedBlob(@NonNull String str) {
        char cCharAt = str.charAt(0);
        validateEncodeVersion(str, cCharAt - 'a');
        return Base64.decode(str.substring(cCharAt - '`'), 0);
    }

    private char getEncodeVersionLengthPrefix() {
        return (char) 99;
    }

    private SecretKey getHMacKey(SecretKey secretKey) {
        byte[] encoded = secretKey.getEncoded();
        return encoded != null ? new SecretKeySpec(MessageDigest.getInstance(HMAC_KEY_HASH_ALGORITHM).digest(encoded), "AES") : secretKey;
    }

    @TargetApi(18)
    private AlgorithmParameterSpec getKeyPairGeneratorSpec(Context context, Date date, Date date2) {
        Locale locale = Locale.ROOT;
        return new KeyPairGeneratorSpec.Builder(context).setAlias("AdalKey").setSubject(new X500Principal(AbstractC0541b.m772n("CN=AdalKey, OU=", getPackageName()))).setSerialNumber(BigInteger.ONE).setStartDate(date).setEndDate(date2).build();
    }

    private static SecretKey getSecretKey(byte[] bArr) {
        if (bArr != null) {
            return new SecretKeySpec(bArr, "AES");
        }
        throw new IllegalArgumentException("rawBytes");
    }

    @Nullable
    @TargetApi(18)
    private synchronized SecretKey getUnwrappedSecretKey() {
        Logger.verbose("StorageHelper:getUnwrappedSecretKey", "Reading SecretKey");
        byte[] keyData = readKeyData();
        if (keyData == null) {
            Logger.verbose("StorageHelper:getUnwrappedSecretKey", "Key data is null");
            return null;
        }
        KeyPair keyPair = readKeyPair();
        this.mKeyPair = keyPair;
        if (keyPair == null) {
            return null;
        }
        SecretKey secretKeyUnwrap = unwrap(keyData);
        Logger.verbose("StorageHelper:getUnwrappedSecretKey", "Finished reading SecretKey");
        return secretKeyUnwrap;
    }

    @Nullable
    private synchronized SecretKey loadKeyStoreEncryptedKey() {
        SecretKey secretKey = this.mCachedKeyStoreEncryptedKey;
        if (secretKey != null) {
            return secretKey;
        }
        try {
            SecretKey unwrappedSecretKey = getUnwrappedSecretKey();
            this.mCachedKeyStoreEncryptedKey = unwrappedSecretKey;
            return unwrappedSecretKey;
        } catch (IOException | GeneralSecurityException e) {
            Logger.error("StorageHelper:loadKeyStoreEncryptedKey", ErrorStrings.ANDROIDKEYSTORE_FAILED, e);
            this.mKeyPair = null;
            this.mCachedKeyStoreEncryptedKey = null;
            deleteKeyFile();
            resetKeyPairFromAndroidKeyStore();
            throw e;
        }
    }

    private void logEvent(@NonNull String str, @NonNull String str2, @NonNull boolean z, @NonNull String str3) {
        Logger.verbose(str, str2 + ": " + str3);
        ITelemetryCallback iTelemetryCallback = this.mTelemetryCallback;
        if (iTelemetryCallback != null) {
            iTelemetryCallback.logEvent(str2, Boolean.valueOf(z), str3);
        }
    }

    private void logFlowError(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Exception exc) {
        Logger.error(str, str2 + " failed: " + str3, exc);
        ITelemetryCallback iTelemetryCallback = this.mTelemetryCallback;
        if (iTelemetryCallback != null) {
            iTelemetryCallback.logEvent(str2, Boolean.TRUE, str3);
        }
    }

    private void logFlowStart(@NonNull String str, @NonNull String str2) {
        Logger.verbose(str, str2 + " started.");
        ITelemetryCallback iTelemetryCallback = this.mTelemetryCallback;
        if (iTelemetryCallback != null) {
            iTelemetryCallback.logEvent(str2, Boolean.FALSE, "");
        }
    }

    private void logFlowSuccess(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        Logger.verbose(str, str2 + " successfully finished: " + str3);
        ITelemetryCallback iTelemetryCallback = this.mTelemetryCallback;
        if (iTelemetryCallback != null) {
            iTelemetryCallback.logEvent(str2, Boolean.FALSE, str3);
        }
    }

    private boolean logIfKeyHasChanged(@NonNull SecretKey secretKey) {
        String keyThumbPrintFromHmacKey = KeyUtil.getKeyThumbPrintFromHmacKey(secretKey);
        AtomicReference<String> atomicReference = LAST_KNOWN_THUMBPRINT;
        if (!atomicReference.get().equals(keyThumbPrintFromHmacKey)) {
            atomicReference.set(keyThumbPrintFromHmacKey);
            if (!FIRST_TIME.compareAndSet(false, true)) {
                Logger.info("StorageHelper:logIfKeyHasChanged", "Using key with thumbprint that has changed " + keyThumbPrintFromHmacKey);
                return true;
            }
        }
        return false;
    }

    @Nullable
    private byte[] readKeyData() throws IOException {
        File file = new File(this.mContext.getDir(getPackageName(), 0), "adalks");
        if (!file.exists()) {
            return null;
        }
        Logger.verbose("StorageHelper:readKeyData", "Reading key data from a file");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    fileInputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    @Nullable
    private synchronized KeyPair readKeyPair() {
        Logger.verbose("StorageHelper:readKeyPair", "Reading Key entry");
        try {
            logFlowStart("StorageHelper:readKeyPair", AuthenticationConstants.TelemetryEvents.KEYSTORE_READ_START);
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            Certificate certificate = keyStore.getCertificate("AdalKey");
            Key key = keyStore.getKey("AdalKey", null);
            if (certificate != null && key != null) {
                KeyPair keyPair = new KeyPair(certificate.getPublicKey(), (PrivateKey) key);
                logFlowSuccess("StorageHelper:readKeyPair", AuthenticationConstants.TelemetryEvents.KEYSTORE_READ_END, "KeyStore KeyPair is loaded.");
                return keyPair;
            }
            logFlowSuccess("StorageHelper:readKeyPair", AuthenticationConstants.TelemetryEvents.KEYSTORE_READ_END, "KeyStore is empty.");
            Logger.verbose("StorageHelper:readKeyPair", "Key entry doesn't exist.");
            return null;
        } catch (IOException e) {
            e = e;
            logFlowError("StorageHelper:readKeyPair", AuthenticationConstants.TelemetryEvents.KEYSTORE_READ_END, e.toString(), e);
            throw e;
        } catch (RuntimeException e2) {
            logFlowError("StorageHelper:readKeyPair", AuthenticationConstants.TelemetryEvents.KEYSTORE_READ_END, e2.toString(), e2);
            throw new KeyStoreException(e2);
        } catch (GeneralSecurityException e3) {
            e = e3;
            logFlowError("StorageHelper:readKeyPair", AuthenticationConstants.TelemetryEvents.KEYSTORE_READ_END, e.toString(), e);
            throw e;
        }
    }

    @SuppressLint({"GetInstance"})
    @TargetApi(18)
    private synchronized SecretKey unwrap(byte[] bArr) {
        Cipher cipher;
        cipher = Cipher.getInstance(WRAP_ALGORITHM);
        cipher.init(4, this.mKeyPair.getPrivate());
        try {
        } catch (IllegalArgumentException e) {
            throw new KeyStoreException(e);
        }
        return (SecretKey) cipher.unwrap(bArr, "AES", 3);
    }

    private void validateEncodeVersion(String str, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Encode version length: '", "' is not valid, it must be greater of equal to 0"));
        }
        if (!str.substring(1, i + 1).equals(ENCODE_VERSION)) {
            throw new IllegalArgumentException("Unsupported encode version received. Encode version supported is: 'E1'");
        }
    }

    @SuppressLint({"GetInstance"})
    @TargetApi(18)
    private synchronized byte[] wrap(SecretKey secretKey) {
        Cipher cipher;
        Logger.verbose("StorageHelper:wrap", "Wrap secret key.");
        cipher = Cipher.getInstance(WRAP_ALGORITHM);
        cipher.init(3, this.mKeyPair.getPublic());
        return cipher.wrap(secretKey);
    }

    private void writeKeyData(byte[] bArr) throws IOException {
        Logger.verbose("StorageHelper:writeKeyData", "Writing key data to a file");
        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.mContext.getDir(getPackageName(), 0), "adalks"));
        try {
            fileOutputStream.write(bArr);
        } finally {
            fileOutputStream.close();
        }
    }

    @Override // com.microsoft.identity.common.adal.internal.cache.IStorageHelper
    public String decrypt(String str) throws GeneralSecurityException {
        Logger.verbose("StorageHelper:decrypt", "Starting decryption");
        if (StringExtensions.isNullOrBlank(str)) {
            throw new IllegalArgumentException("Input is empty or null");
        }
        if (getEncryptionType(str) == EncryptionType.UNENCRYPTED) {
            Logger.warn("StorageHelper:decrypt", "This string is not encrypted. Finished decryption.");
            return str;
        }
        if (this.mTelemetryCallback != null) {
            try {
                if (loadSecretKey(KeyType.KEYSTORE_ENCRYPTED_KEY) == null) {
                    this.mTelemetryCallback.logEvent("StorageHelper:decrypt", Boolean.FALSE, "KEY_DECRYPTION_KEYSTORE_KEY_NOT_INITIALIZED");
                }
            } catch (Exception unused) {
                this.mTelemetryCallback.logEvent("StorageHelper:decrypt", Boolean.FALSE, "KEY_DECRYPTION_KEYSTORE_KEY_FAILED_TO_LOAD");
            }
        }
        List<KeyType> keysForDecryptionType = getKeysForDecryptionType(str, getPackageName());
        byte[] byteArrayFromEncryptedBlob = getByteArrayFromEncryptedBlob(str);
        for (KeyType keyType : keysForDecryptionType) {
            try {
                SecretKey secretKeyLoadSecretKey = loadSecretKey(keyType);
                if (secretKeyLoadSecretKey != null) {
                    String strDecryptWithSecretKey = decryptWithSecretKey(byteArrayFromEncryptedBlob, secretKeyLoadSecretKey);
                    Logger.verbose("StorageHelper:decrypt", "Finished decryption with keyType:" + keyType.name());
                    return strDecryptWithSecretKey;
                }
            } catch (IOException | GeneralSecurityException e) {
                emitDecryptionFailureTelemetryIfNeeded(keyType, e);
            }
        }
        Logger.info("StorageHelper:decrypt", "Tried all decryption keys and decryption still fails. Throw an exception.");
        throw new GeneralSecurityException(ErrorStrings.DECRYPTION_FAILED);
    }

    public void deleteKeyFile() {
        File file = new File(this.mContext.getDir(getPackageName(), 0), "adalks");
        if (file.exists()) {
            Logger.verbose("StorageHelper:deleteKeyFile", "Delete KeyFile");
            if (file.delete()) {
                return;
            }
            Logger.verbose("StorageHelper:deleteKeyFile", "Delete KeyFile failed");
        }
    }

    public SecretKey deserializeSecretKey(@NonNull String str) {
        return getSecretKey(Base64.decode(str, 0));
    }

    @Override // com.microsoft.identity.common.adal.internal.cache.IStorageHelper
    public String encrypt(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (StringExtensions.isNullOrBlank(str)) {
            throw new IllegalArgumentException("Input is empty or null");
        }
        Logger.verbose("StorageHelper:encrypt", "Starting encryption");
        SecretKey secretKeyLoadSecretKeyForEncryption = loadSecretKeyForEncryption();
        this.mEncryptionKey = secretKeyLoadSecretKeyForEncryption;
        SecretKey hMacKey = getHMacKey(secretKeyLoadSecretKeyForEncryption);
        this.mEncryptionHMACKey = hMacKey;
        logIfKeyHasChanged(hMacKey);
        Logger.verbose("StorageHelper:encrypt", "Encrypt version:" + this.mBlobVersion);
        String str2 = this.mBlobVersion;
        Charset charset = AuthenticationConstants.CHARSET_UTF8;
        byte[] bytes = str2.getBytes(charset);
        byte[] bytes2 = str.getBytes(charset);
        byte[] bArr = new byte[16];
        this.mRandom.nextBytes(bArr);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        Mac mac = Mac.getInstance("HmacSHA256");
        cipher.init(1, this.mEncryptionKey, ivParameterSpec);
        byte[] bArrDoFinal = cipher.doFinal(bytes2);
        mac.init(this.mEncryptionHMACKey);
        mac.update(bytes);
        mac.update(bArrDoFinal);
        mac.update(bArr);
        byte[] bArrDoFinal2 = mac.doFinal();
        byte[] bArr2 = new byte[bytes.length + bArrDoFinal.length + 16 + bArrDoFinal2.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArrDoFinal, 0, bArr2, bytes.length, bArrDoFinal.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length + bArrDoFinal.length, 16);
        System.arraycopy(bArrDoFinal2, 0, bArr2, bytes.length + bArrDoFinal.length + 16, bArrDoFinal2.length);
        String str3 = new String(Base64.encode(bArr2, 2), charset);
        Logger.verbose("StorageHelper:encrypt", "Finished encryption");
        return getEncodeVersionLengthPrefix() + ENCODE_VERSION + str3;
    }

    public synchronized SecretKey generateKeyStoreEncryptedKey() {
        SecretKey secretKeyGenerateSecretKey = generateSecretKey();
        this.mCachedKeyStoreEncryptedKey = secretKeyGenerateSecretKey;
        saveKeyStoreEncryptedKey(secretKeyGenerateSecretKey);
        logEvent("StorageHelper:generateKeyStoreEncryptedKey", AuthenticationConstants.TelemetryEvents.KEY_CREATED, false, "New key is generated.");
        return this.mCachedKeyStoreEncryptedKey;
    }

    public SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256, this.mRandom);
        return keyGenerator.generateKey();
    }

    public EncryptionType getEncryptionType(@NonNull String str) {
        try {
            String str2 = new String(getByteArrayFromEncryptedBlob(str), 0, 4, AuthenticationConstants.CHARSET_UTF8);
            return "U001".equalsIgnoreCase(str2) ? EncryptionType.USER_DEFINED : "A001".equalsIgnoreCase(str2) ? EncryptionType.ANDROID_KEY_STORE : EncryptionType.UNENCRYPTED;
        } catch (Exception unused) {
            return EncryptionType.UNENCRYPTED;
        }
    }

    @NonNull
    public List<KeyType> getKeysForDecryptionType(@NonNull String str, @NonNull String str2) {
        ArrayList arrayList = new ArrayList();
        EncryptionType encryptionType = getEncryptionType(str);
        if (encryptionType != EncryptionType.USER_DEFINED) {
            if (encryptionType == EncryptionType.ANDROID_KEY_STORE) {
                arrayList.add(KeyType.KEYSTORE_ENCRYPTED_KEY);
            }
            return arrayList;
        }
        if (!isBrokerProcess()) {
            arrayList.add(KeyType.ADAL_USER_DEFINED_KEY);
            return arrayList;
        }
        if (AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME.equalsIgnoreCase(str2) || AuthenticationConstants.Broker.BROKER_HOST_APP_PACKAGE_NAME.equalsIgnoreCase(str2)) {
            arrayList.add(KeyType.LEGACY_COMPANY_PORTAL_KEY);
            arrayList.add(KeyType.LEGACY_AUTHENTICATOR_APP_KEY);
            return arrayList;
        }
        if (!AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME.equalsIgnoreCase(str2)) {
            throw new IllegalStateException("Unexpected Broker package name.");
        }
        arrayList.add(KeyType.LEGACY_AUTHENTICATOR_APP_KEY);
        arrayList.add(KeyType.LEGACY_COMPANY_PORTAL_KEY);
        return arrayList;
    }

    public String getPackageName() {
        return this.mContext.getPackageName();
    }

    public boolean isBrokerProcess() {
        return ProcessUtil.isBrokerProcess(this.mContext);
    }

    @Nullable
    public SecretKey loadSecretKey(@NonNull KeyType keyType) throws GeneralSecurityException {
        int i = C62291.f3580x98edcb9f[keyType.ordinal()];
        if (i == 1) {
            return getSecretKey(AuthenticationSettings.INSTANCE.getBrokerSecretKeys().get(AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME));
        }
        if (i == 2) {
            return getSecretKey(AuthenticationSettings.INSTANCE.getBrokerSecretKeys().get(AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME));
        }
        if (i == 3) {
            return getSecretKey(AuthenticationSettings.INSTANCE.getSecretKeyData());
        }
        if (i == 4) {
            return loadKeyStoreEncryptedKey();
        }
        Logger.verbose("StorageHelper:loadSecretKey", "Unknown KeyType. This code should never be reached.");
        throw new GeneralSecurityException("unknown_error");
    }

    @Override // com.microsoft.identity.common.adal.internal.cache.IStorageHelper
    public synchronized SecretKey loadSecretKeyForEncryption() {
        SecretKey secretKey = this.mEncryptionKey;
        if (secretKey != null && this.mEncryptionHMACKey != null) {
            return secretKey;
        }
        if (isBrokerProcess()) {
            if (this.mTelemetryCallback != null) {
                try {
                    if (loadSecretKey(KeyType.KEYSTORE_ENCRYPTED_KEY) == null) {
                        this.mTelemetryCallback.logEvent("StorageHelper:loadSecretKeyForEncryption", Boolean.FALSE, "KEY_ENCRYPTION_KEYSTORE_KEY_NOT_INITIALIZED");
                    }
                } catch (Exception unused) {
                    this.mTelemetryCallback.logEvent("StorageHelper:loadSecretKeyForEncryption", Boolean.FALSE, "KEY_ENCRYPTION_KEYSTORE_KEY_FAILED_TO_LOAD");
                }
            }
            setBlobVersion("U001");
            if (AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME.equalsIgnoreCase(getPackageName())) {
                return loadSecretKey(KeyType.LEGACY_AUTHENTICATOR_APP_KEY);
            }
            return loadSecretKey(KeyType.LEGACY_COMPANY_PORTAL_KEY);
        }
        if (AuthenticationSettings.INSTANCE.getSecretKeyData() != null) {
            setBlobVersion("U001");
            return loadSecretKey(KeyType.ADAL_USER_DEFINED_KEY);
        }
        setBlobVersion("A001");
        try {
            SecretKey secretKeyLoadSecretKey = loadSecretKey(KeyType.KEYSTORE_ENCRYPTED_KEY);
            if (secretKeyLoadSecretKey != null) {
                return secretKeyLoadSecretKey;
            }
        } catch (IOException | GeneralSecurityException unused2) {
        }
        Logger.verbose("StorageHelper:loadSecretKeyForEncryption", "Keystore-encrypted key does not exist, try to generate new keys.");
        return generateKeyStoreEncryptedKey();
    }

    @TargetApi(18)
    public synchronized void resetKeyPairFromAndroidKeyStore() {
        KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
        keyStore.load(null);
        keyStore.deleteEntry("AdalKey");
    }

    public synchronized void saveKeyStoreEncryptedKey(@NonNull SecretKey secretKey) {
        try {
            if (this.mKeyPair == null) {
                this.mKeyPair = generateKeyPairFromAndroidKeyStore();
            }
            writeKeyData(wrap(secretKey));
        } catch (Throwable th) {
            throw th;
        }
    }

    public String serializeSecretKey(@NonNull SecretKey secretKey) {
        return Base64.encodeToString(secretKey.getEncoded(), 0);
    }

    public void setBlobVersion(@NonNull String str) {
        this.mBlobVersion = str;
    }

    @VisibleForTesting(otherwise = 5)
    public boolean testKeyChange() {
        return logIfKeyHasChanged(getHMacKey(loadSecretKeyForEncryption()));
    }

    @VisibleForTesting(otherwise = 5)
    public String testThumbprint() {
        return KeyUtil.getKeyThumbPrint(loadSecretKeyForEncryption());
    }

    @SuppressLint({"TrulyRandom"})
    public StorageHelper(@NonNull Context context, @Nullable ITelemetryCallback iTelemetryCallback) {
        this.mEncryptionKey = null;
        this.mEncryptionHMACKey = null;
        this.mCachedKeyStoreEncryptedKey = null;
        this.mContext = context.getApplicationContext();
        this.mRandom = new SecureRandom();
        this.mTelemetryCallback = iTelemetryCallback;
    }
}
