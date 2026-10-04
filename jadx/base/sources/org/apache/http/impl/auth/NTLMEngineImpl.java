package org.apache.http.impl.auth;

import android.util.Base64;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sivs.p144ai.sdkcommon.language.LlmServiceConst;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.EncodingUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
final class NTLMEngineImpl implements NTLMEngine {
    static final String DEFAULT_CHARSET = "ASCII";
    protected static final int FLAG_DOMAIN_PRESENT = 4096;
    protected static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
    protected static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
    protected static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
    protected static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
    protected static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
    protected static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
    protected static final int FLAG_REQUEST_NTLMv1 = 512;
    protected static final int FLAG_REQUEST_SEAL = 32;
    protected static final int FLAG_REQUEST_SIGN = 16;
    protected static final int FLAG_REQUEST_TARGET = 4;
    protected static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    protected static final int FLAG_REQUEST_VERSION = 33554432;
    protected static final int FLAG_TARGETINFO_PRESENT = 8388608;
    protected static final int FLAG_WORKSTATION_PRESENT = 8192;
    private static final SecureRandom RND_GEN;
    private static final byte[] SIGNATURE;
    private String credentialCharset = "ASCII";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HMACMD5 {
        protected byte[] ipad;
        protected MessageDigest md5;
        protected byte[] opad;

        public HMACMD5(byte[] bArr) throws NTLMEngineException {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                this.md5 = messageDigest;
                this.ipad = new byte[64];
                this.opad = new byte[64];
                int length = bArr.length;
                if (length > 64) {
                    messageDigest.update(bArr);
                    bArr = this.md5.digest();
                    length = bArr.length;
                }
                int i = 0;
                while (i < length) {
                    this.ipad[i] = (byte) (54 ^ bArr[i]);
                    this.opad[i] = (byte) (92 ^ bArr[i]);
                    i++;
                }
                while (i < 64) {
                    this.ipad[i] = CtapException.ERR_PIN_REQUIRED;
                    this.opad[i] = 92;
                    i++;
                }
                this.md5.reset();
                this.md5.update(this.ipad);
            } catch (Exception e) {
                throw new NTLMEngineException(AbstractC2322a.m1619i(e, new StringBuilder("Error getting md5 message digest implementation: ")), e);
            }
        }

        public byte[] getOutput() {
            byte[] bArrDigest = this.md5.digest();
            this.md5.update(this.opad);
            return this.md5.digest(bArrDigest);
        }

        public void update(byte[] bArr) {
            this.md5.update(bArr);
        }

        public void update(byte[] bArr, int i, int i2) {
            this.md5.update(bArr, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MD4 {

        /* JADX INFO: renamed from: A */
        protected int f10019A = 1732584193;

        /* JADX INFO: renamed from: B */
        protected int f10020B = -271733879;

        /* JADX INFO: renamed from: C */
        protected int f10021C = -1732584194;

        /* JADX INFO: renamed from: D */
        protected int f10022D = 271733878;
        protected long count = 0;
        protected byte[] dataBuffer = new byte[64];

        public byte[] getOutput() {
            int i = (int) (this.count & 63);
            int i2 = i < 56 ? 56 - i : 120 - i;
            byte[] bArr = new byte[i2 + 8];
            bArr[0] = -128;
            for (int i4 = 0; i4 < 8; i4++) {
                bArr[i2 + i4] = (byte) ((this.count * 8) >>> (i4 * 8));
            }
            update(bArr);
            byte[] bArr2 = new byte[16];
            NTLMEngineImpl.writeULong(bArr2, this.f10019A, 0);
            NTLMEngineImpl.writeULong(bArr2, this.f10020B, 4);
            NTLMEngineImpl.writeULong(bArr2, this.f10021C, 8);
            NTLMEngineImpl.writeULong(bArr2, this.f10022D, 12);
            return bArr2;
        }

        public void processBuffer() {
            int[] iArr = new int[16];
            for (int i = 0; i < 16; i++) {
                byte[] bArr = this.dataBuffer;
                int i2 = i * 4;
                iArr[i] = (bArr[i2] & 255) + ((bArr[i2 + 1] & 255) << 8) + ((bArr[i2 + 2] & 255) << 16) + ((bArr[i2 + 3] & 255) << 24);
            }
            int i4 = this.f10019A;
            int i5 = this.f10020B;
            int i6 = this.f10021C;
            int i7 = this.f10022D;
            round1(iArr);
            round2(iArr);
            round3(iArr);
            this.f10019A += i4;
            this.f10020B += i5;
            this.f10021C += i6;
            this.f10022D += i7;
        }

        public void round1(int[] iArr) {
            int iRotintlft = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14964F(this.f10020B, this.f10021C, this.f10022D) + iArr[0], 3);
            this.f10019A = iRotintlft;
            int iRotintlft2 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14964F(iRotintlft, this.f10020B, this.f10021C) + iArr[1], 7);
            this.f10022D = iRotintlft2;
            int iRotintlft3 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14964F(iRotintlft2, this.f10019A, this.f10020B) + iArr[2], 11);
            this.f10021C = iRotintlft3;
            int iRotintlft4 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14964F(iRotintlft3, this.f10022D, this.f10019A) + iArr[3], 19);
            this.f10020B = iRotintlft4;
            int iRotintlft5 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14964F(iRotintlft4, this.f10021C, this.f10022D) + iArr[4], 3);
            this.f10019A = iRotintlft5;
            int iRotintlft6 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14964F(iRotintlft5, this.f10020B, this.f10021C) + iArr[5], 7);
            this.f10022D = iRotintlft6;
            int iRotintlft7 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14964F(iRotintlft6, this.f10019A, this.f10020B) + iArr[6], 11);
            this.f10021C = iRotintlft7;
            int iRotintlft8 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14964F(iRotintlft7, this.f10022D, this.f10019A) + iArr[7], 19);
            this.f10020B = iRotintlft8;
            int iRotintlft9 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14964F(iRotintlft8, this.f10021C, this.f10022D) + iArr[8], 3);
            this.f10019A = iRotintlft9;
            int iRotintlft10 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14964F(iRotintlft9, this.f10020B, this.f10021C) + iArr[9], 7);
            this.f10022D = iRotintlft10;
            int iRotintlft11 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14964F(iRotintlft10, this.f10019A, this.f10020B) + iArr[10], 11);
            this.f10021C = iRotintlft11;
            int iRotintlft12 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14964F(iRotintlft11, this.f10022D, this.f10019A) + iArr[11], 19);
            this.f10020B = iRotintlft12;
            int iRotintlft13 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14964F(iRotintlft12, this.f10021C, this.f10022D) + iArr[12], 3);
            this.f10019A = iRotintlft13;
            int iRotintlft14 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14964F(iRotintlft13, this.f10020B, this.f10021C) + iArr[13], 7);
            this.f10022D = iRotintlft14;
            int iRotintlft15 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14964F(iRotintlft14, this.f10019A, this.f10020B) + iArr[14], 11);
            this.f10021C = iRotintlft15;
            this.f10020B = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14964F(iRotintlft15, this.f10022D, this.f10019A) + iArr[15], 19);
        }

        public void round2(int[] iArr) {
            int iRotintlft = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14965G(this.f10020B, this.f10021C, this.f10022D) + iArr[0] + 1518500249, 3);
            this.f10019A = iRotintlft;
            int iRotintlft2 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14965G(iRotintlft, this.f10020B, this.f10021C) + iArr[4] + 1518500249, 5);
            this.f10022D = iRotintlft2;
            int iRotintlft3 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14965G(iRotintlft2, this.f10019A, this.f10020B) + iArr[8] + 1518500249, 9);
            this.f10021C = iRotintlft3;
            int iRotintlft4 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14965G(iRotintlft3, this.f10022D, this.f10019A) + iArr[12] + 1518500249, 13);
            this.f10020B = iRotintlft4;
            int iRotintlft5 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14965G(iRotintlft4, this.f10021C, this.f10022D) + iArr[1] + 1518500249, 3);
            this.f10019A = iRotintlft5;
            int iRotintlft6 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14965G(iRotintlft5, this.f10020B, this.f10021C) + iArr[5] + 1518500249, 5);
            this.f10022D = iRotintlft6;
            int iRotintlft7 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14965G(iRotintlft6, this.f10019A, this.f10020B) + iArr[9] + 1518500249, 9);
            this.f10021C = iRotintlft7;
            int iRotintlft8 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14965G(iRotintlft7, this.f10022D, this.f10019A) + iArr[13] + 1518500249, 13);
            this.f10020B = iRotintlft8;
            int iRotintlft9 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14965G(iRotintlft8, this.f10021C, this.f10022D) + iArr[2] + 1518500249, 3);
            this.f10019A = iRotintlft9;
            int iRotintlft10 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14965G(iRotintlft9, this.f10020B, this.f10021C) + iArr[6] + 1518500249, 5);
            this.f10022D = iRotintlft10;
            int iRotintlft11 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14965G(iRotintlft10, this.f10019A, this.f10020B) + iArr[10] + 1518500249, 9);
            this.f10021C = iRotintlft11;
            int iRotintlft12 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14965G(iRotintlft11, this.f10022D, this.f10019A) + iArr[14] + 1518500249, 13);
            this.f10020B = iRotintlft12;
            int iRotintlft13 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14965G(iRotintlft12, this.f10021C, this.f10022D) + iArr[3] + 1518500249, 3);
            this.f10019A = iRotintlft13;
            int iRotintlft14 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14965G(iRotintlft13, this.f10020B, this.f10021C) + iArr[7] + 1518500249, 5);
            this.f10022D = iRotintlft14;
            int iRotintlft15 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14965G(iRotintlft14, this.f10019A, this.f10020B) + iArr[11] + 1518500249, 9);
            this.f10021C = iRotintlft15;
            this.f10020B = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14965G(iRotintlft15, this.f10022D, this.f10019A) + iArr[15] + 1518500249, 13);
        }

        public void round3(int[] iArr) {
            int iRotintlft = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14966H(this.f10020B, this.f10021C, this.f10022D) + iArr[0] + 1859775393, 3);
            this.f10019A = iRotintlft;
            int iRotintlft2 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14966H(iRotintlft, this.f10020B, this.f10021C) + iArr[8] + 1859775393, 9);
            this.f10022D = iRotintlft2;
            int iRotintlft3 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14966H(iRotintlft2, this.f10019A, this.f10020B) + iArr[4] + 1859775393, 11);
            this.f10021C = iRotintlft3;
            int iRotintlft4 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14966H(iRotintlft3, this.f10022D, this.f10019A) + iArr[12] + 1859775393, 15);
            this.f10020B = iRotintlft4;
            int iRotintlft5 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14966H(iRotintlft4, this.f10021C, this.f10022D) + iArr[2] + 1859775393, 3);
            this.f10019A = iRotintlft5;
            int iRotintlft6 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14966H(iRotintlft5, this.f10020B, this.f10021C) + iArr[10] + 1859775393, 9);
            this.f10022D = iRotintlft6;
            int iRotintlft7 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14966H(iRotintlft6, this.f10019A, this.f10020B) + iArr[6] + 1859775393, 11);
            this.f10021C = iRotintlft7;
            int iRotintlft8 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14966H(iRotintlft7, this.f10022D, this.f10019A) + iArr[14] + 1859775393, 15);
            this.f10020B = iRotintlft8;
            int iRotintlft9 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14966H(iRotintlft8, this.f10021C, this.f10022D) + iArr[1] + 1859775393, 3);
            this.f10019A = iRotintlft9;
            int iRotintlft10 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14966H(iRotintlft9, this.f10020B, this.f10021C) + iArr[9] + 1859775393, 9);
            this.f10022D = iRotintlft10;
            int iRotintlft11 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14966H(iRotintlft10, this.f10019A, this.f10020B) + iArr[5] + 1859775393, 11);
            this.f10021C = iRotintlft11;
            int iRotintlft12 = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14966H(iRotintlft11, this.f10022D, this.f10019A) + iArr[13] + 1859775393, 15);
            this.f10020B = iRotintlft12;
            int iRotintlft13 = NTLMEngineImpl.rotintlft(this.f10019A + NTLMEngineImpl.m14966H(iRotintlft12, this.f10021C, this.f10022D) + iArr[3] + 1859775393, 3);
            this.f10019A = iRotintlft13;
            int iRotintlft14 = NTLMEngineImpl.rotintlft(this.f10022D + NTLMEngineImpl.m14966H(iRotintlft13, this.f10020B, this.f10021C) + iArr[11] + 1859775393, 9);
            this.f10022D = iRotintlft14;
            int iRotintlft15 = NTLMEngineImpl.rotintlft(this.f10021C + NTLMEngineImpl.m14966H(iRotintlft14, this.f10019A, this.f10020B) + iArr[7] + 1859775393, 11);
            this.f10021C = iRotintlft15;
            this.f10020B = NTLMEngineImpl.rotintlft(this.f10020B + NTLMEngineImpl.m14966H(iRotintlft15, this.f10022D, this.f10019A) + iArr[15] + 1859775393, 15);
        }

        public void update(byte[] bArr) {
            byte[] bArr2;
            int i = (int) (this.count & 63);
            int i2 = 0;
            while (true) {
                int length = (bArr.length - i2) + i;
                bArr2 = this.dataBuffer;
                if (length < bArr2.length) {
                    break;
                }
                int length2 = bArr2.length - i;
                System.arraycopy(bArr, i2, bArr2, i, length2);
                this.count += (long) length2;
                i2 += length2;
                processBuffer();
                i = 0;
            }
            if (i2 < bArr.length) {
                int length3 = bArr.length - i2;
                System.arraycopy(bArr, i2, bArr2, i, length3);
                this.count += (long) length3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Type1Message extends NTLMMessage {
        protected byte[] domainBytes;
        protected byte[] hostBytes;

        public Type1Message(String str, String str2) throws NTLMEngineException {
            try {
                String strConvertHost = NTLMEngineImpl.convertHost(str2);
                String strConvertDomain = NTLMEngineImpl.convertDomain(str);
                this.hostBytes = strConvertHost != null ? strConvertHost.getBytes("ASCII") : null;
                this.domainBytes = strConvertDomain != null ? strConvertDomain.toUpperCase(Locale.ENGLISH).getBytes("ASCII") : null;
            } catch (UnsupportedEncodingException e) {
                throw new NTLMEngineException("Unicode unsupported: " + e.getMessage(), e);
            }
        }

        @Override // org.apache.http.impl.auth.NTLMEngineImpl.NTLMMessage
        public String getResponse() {
            prepareResponse(40, 1);
            addULong(-1576500735);
            addUShort(0);
            addUShort(0);
            addULong(40);
            addUShort(0);
            addUShort(0);
            addULong(40);
            addUShort(261);
            addULong(LlmServiceConst.Error.Code.AUTH_ERROR_PACKAGE_NOT_REGISTERED_IN_WHITELIST);
            addUShort(3840);
            return super.getResponse();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Type2Message extends NTLMMessage {
        protected byte[] challenge;
        protected int flags;
        protected String target;
        protected byte[] targetInfo;

        public Type2Message(String str) throws NTLMEngineException {
            super(str, 2);
            byte[] bArr = new byte[8];
            this.challenge = bArr;
            readBytes(bArr, 24);
            int uLong = readULong(20);
            this.flags = uLong;
            if ((uLong & 1) == 0) {
                throw new NTLMEngineException("NTLM type 2 message has flags that make no sense: " + Integer.toString(this.flags));
            }
            this.target = null;
            if (getMessageLength() >= 20) {
                byte[] securityBuffer = readSecurityBuffer(12);
                if (securityBuffer.length != 0) {
                    try {
                        this.target = new String(securityBuffer, "UnicodeLittleUnmarked");
                    } catch (UnsupportedEncodingException e) {
                        throw new NTLMEngineException(e.getMessage(), e);
                    }
                }
            }
            this.targetInfo = null;
            if (getMessageLength() >= 48) {
                byte[] securityBuffer2 = readSecurityBuffer(40);
                if (securityBuffer2.length != 0) {
                    this.targetInfo = securityBuffer2;
                }
            }
        }

        public byte[] getChallenge() {
            return this.challenge;
        }

        public int getFlags() {
            return this.flags;
        }

        public String getTarget() {
            return this.target;
        }

        public byte[] getTargetInfo() {
            return this.targetInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Type3Message extends NTLMMessage {
        protected byte[] domainBytes;
        protected byte[] hostBytes;
        protected byte[] lmResp;
        protected byte[] ntResp;
        protected byte[] sessionKey;
        protected int type2Flags;
        protected byte[] userBytes;

        public Type3Message(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) throws NTLMEngineException {
            byte[] lanManagerSessionKey;
            byte[] bytes;
            this.type2Flags = i;
            String strConvertHost = NTLMEngineImpl.convertHost(str2);
            String strConvertDomain = NTLMEngineImpl.convertDomain(str);
            CipherGen cipherGen = new CipherGen(strConvertDomain, str3, str4, bArr, str5, bArr2);
            try {
                if ((8388608 & i) != 0 && bArr2 != null && str5 != null) {
                    this.ntResp = cipherGen.getNTLMv2Response();
                    this.lmResp = cipherGen.getLMv2Response();
                    lanManagerSessionKey = (i & 128) != 0 ? cipherGen.getLanManagerSessionKey() : cipherGen.getNTLMv2UserSessionKey();
                } else if ((524288 & i) != 0) {
                    this.ntResp = cipherGen.getNTLM2SessionResponse();
                    this.lmResp = cipherGen.getLM2SessionResponse();
                    lanManagerSessionKey = (i & 128) != 0 ? cipherGen.getLanManagerSessionKey() : cipherGen.getNTLM2SessionResponseUserSessionKey();
                } else {
                    this.ntResp = cipherGen.getNTLMResponse();
                    this.lmResp = cipherGen.getLMResponse();
                    lanManagerSessionKey = (i & 128) != 0 ? cipherGen.getLanManagerSessionKey() : cipherGen.getNTLMUserSessionKey();
                }
            } catch (NTLMEngineException unused) {
                this.ntResp = new byte[0];
                this.lmResp = cipherGen.getLMResponse();
                lanManagerSessionKey = (i & 128) != 0 ? cipherGen.getLanManagerSessionKey() : cipherGen.getLMUserSessionKey();
            }
            if ((i & 16) == 0) {
                this.sessionKey = null;
            } else if ((1073741824 & i) != 0) {
                this.sessionKey = NTLMEngineImpl.RC4(cipherGen.getSecondaryKey(), lanManagerSessionKey);
            } else {
                this.sessionKey = lanManagerSessionKey;
            }
            if (strConvertHost != null) {
                try {
                    bytes = strConvertHost.getBytes("UnicodeLittleUnmarked");
                } catch (UnsupportedEncodingException e) {
                    throw new NTLMEngineException("Unicode not supported: " + e.getMessage(), e);
                }
            } else {
                bytes = null;
            }
            this.hostBytes = bytes;
            this.domainBytes = strConvertDomain != null ? strConvertDomain.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked") : null;
            this.userBytes = str3.getBytes("UnicodeLittleUnmarked");
        }

        @Override // org.apache.http.impl.auth.NTLMEngineImpl.NTLMMessage
        public String getResponse() {
            int length = this.ntResp.length;
            int length2 = this.lmResp.length;
            byte[] bArr = this.domainBytes;
            int length3 = bArr != null ? bArr.length : 0;
            byte[] bArr2 = this.hostBytes;
            int length4 = bArr2 != null ? bArr2.length : 0;
            int length5 = this.userBytes.length;
            byte[] bArr3 = this.sessionKey;
            int length6 = bArr3 != null ? bArr3.length : 0;
            int i = length2 + 72;
            int i2 = i + length;
            int i4 = i2 + length3;
            int i5 = i4 + length5;
            int i6 = i5 + length4;
            prepareResponse(i6 + length6, 3);
            addUShort(length2);
            addUShort(length2);
            addULong(72);
            addUShort(length);
            addUShort(length);
            addULong(i);
            addUShort(length3);
            addUShort(length3);
            addULong(i2);
            addUShort(length5);
            addUShort(length5);
            addULong(i4);
            addUShort(length4);
            addUShort(length4);
            addULong(i5);
            addUShort(length6);
            addUShort(length6);
            addULong(i6);
            int i7 = this.type2Flags;
            addULong((i7 & 4) | (524928 & i7) | 33554432 | (32768 & i7) | (i7 & 32) | (i7 & 16) | (536870912 & i7) | (Integer.MIN_VALUE & i7) | (1073741824 & i7) | (8388608 & i7) | (i7 & 1));
            addUShort(261);
            addULong(LlmServiceConst.Error.Code.AUTH_ERROR_PACKAGE_NOT_REGISTERED_IN_WHITELIST);
            addUShort(3840);
            addBytes(this.lmResp);
            addBytes(this.ntResp);
            addBytes(this.domainBytes);
            addBytes(this.userBytes);
            addBytes(this.hostBytes);
            byte[] bArr4 = this.sessionKey;
            if (bArr4 != null) {
                addBytes(bArr4);
            }
            return super.getResponse();
        }
    }

    static {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception unused) {
            secureRandom = null;
        }
        RND_GEN = secureRandom;
        byte[] bytes = EncodingUtils.getBytes("NTLMSSP", "ASCII");
        byte[] bArr = new byte[bytes.length + 1];
        SIGNATURE = bArr;
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        bArr[bytes.length] = 0;
    }

    /* JADX INFO: renamed from: F */
    public static int m14964F(int i, int i2, int i4) {
        return ((~i) & i4) | (i2 & i);
    }

    /* JADX INFO: renamed from: G */
    public static int m14965G(int i, int i2, int i4) {
        return (i & (i2 | i4)) | (i2 & i4);
    }

    /* JADX INFO: renamed from: H */
    public static int m14966H(int i, int i2, int i4) {
        return (i ^ i2) ^ i4;
    }

    public static byte[] RC4(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        try {
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(bArr2, "RC4"));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertDomain(String str) {
        return stripDotSuffix(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertHost(String str) {
        return stripDotSuffix(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] createBlob(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[bArr3.length + 20 + bArr2.length + 4];
        System.arraycopy(new byte[]{1, 1, 0, 0}, 0, bArr4, 0, 4);
        System.arraycopy(new byte[4], 0, bArr4, 4, 4);
        System.arraycopy(bArr3, 0, bArr4, 8, bArr3.length);
        int length = bArr3.length;
        System.arraycopy(bArr, 0, bArr4, 8 + length, 8);
        System.arraycopy(new byte[4], 0, bArr4, length + 16, 4);
        int i = length + 20;
        System.arraycopy(bArr2, 0, bArr4, i, bArr2.length);
        System.arraycopy(new byte[4], 0, bArr4, i + bArr2.length, 4);
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Key createDESKey(byte[] bArr, int i) {
        byte[] bArr2 = new byte[7];
        System.arraycopy(bArr, i, bArr2, 0, 7);
        byte b = bArr2[0];
        byte b5 = bArr2[1];
        byte b6 = bArr2[2];
        byte b7 = bArr2[3];
        byte b8 = bArr2[4];
        byte b9 = bArr2[5];
        byte b10 = bArr2[6];
        byte[] bArr3 = {b, (byte) ((b << 7) | ((b5 & 255) >>> 1)), (byte) ((b5 << 6) | ((b6 & 255) >>> 2)), (byte) ((b6 << 5) | ((b7 & 255) >>> 3)), (byte) ((b7 << 4) | ((b8 & 255) >>> 4)), (byte) (((b9 & 255) >>> 5) | (b8 << 3)), (byte) ((b9 << 2) | ((b10 & 255) >>> 6)), (byte) (b10 << 1)};
        oddParity(bArr3);
        return new SecretKeySpec(bArr3, "DES");
    }

    public static byte[] hmacMD5(byte[] bArr, byte[] bArr2) {
        HMACMD5 hmacmd5 = new HMACMD5(bArr2);
        hmacmd5.update(bArr);
        return hmacmd5.getOutput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] lmHash(String str) throws NTLMEngineException {
        try {
            byte[] bytes = str.toUpperCase(Locale.ENGLISH).getBytes("US-ASCII");
            byte[] bArr = new byte[14];
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 14));
            Key keyCreateDESKey = createDESKey(bArr, 0);
            Key keyCreateDESKey2 = createDESKey(bArr, 7);
            byte[] bytes2 = "KGS!@#$%".getBytes("US-ASCII");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, keyCreateDESKey);
            byte[] bArrDoFinal = cipher.doFinal(bytes2);
            cipher.init(1, keyCreateDESKey2);
            byte[] bArrDoFinal2 = cipher.doFinal(bytes2);
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArrDoFinal, 0, bArr2, 0, 8);
            System.arraycopy(bArrDoFinal2, 0, bArr2, 8, 8);
            return bArr2;
        } catch (Exception e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] lmResponse(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        try {
            byte[] bArr3 = new byte[21];
            System.arraycopy(bArr, 0, bArr3, 0, 16);
            Key keyCreateDESKey = createDESKey(bArr3, 0);
            Key keyCreateDESKey2 = createDESKey(bArr3, 7);
            Key keyCreateDESKey3 = createDESKey(bArr3, 14);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, keyCreateDESKey);
            byte[] bArrDoFinal = cipher.doFinal(bArr2);
            cipher.init(1, keyCreateDESKey2);
            byte[] bArrDoFinal2 = cipher.doFinal(bArr2);
            cipher.init(1, keyCreateDESKey3);
            byte[] bArrDoFinal3 = cipher.doFinal(bArr2);
            byte[] bArr4 = new byte[24];
            System.arraycopy(bArrDoFinal, 0, bArr4, 0, 8);
            System.arraycopy(bArrDoFinal2, 0, bArr4, 8, 8);
            System.arraycopy(bArrDoFinal3, 0, bArr4, 16, 8);
            return bArr4;
        } catch (Exception e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] lmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        try {
            HMACMD5 hmacmd5 = new HMACMD5(bArr);
            Locale locale = Locale.ENGLISH;
            hmacmd5.update(str2.toUpperCase(locale).getBytes("UnicodeLittleUnmarked"));
            if (str != null) {
                hmacmd5.update(str.toUpperCase(locale).getBytes("UnicodeLittleUnmarked"));
            }
            return hmacmd5.getOutput();
        } catch (UnsupportedEncodingException e) {
            throw new NTLMEngineException("Unicode not supported! " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] lmv2Response(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        HMACMD5 hmacmd5 = new HMACMD5(bArr);
        hmacmd5.update(bArr2);
        hmacmd5.update(bArr3);
        byte[] output = hmacmd5.getOutput();
        byte[] bArr4 = new byte[output.length + bArr3.length];
        System.arraycopy(output, 0, bArr4, 0, output.length);
        System.arraycopy(bArr3, 0, bArr4, output.length, bArr3.length);
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] makeRandomChallenge() throws NTLMEngineException {
        SecureRandom secureRandom = RND_GEN;
        if (secureRandom == null) {
            throw new NTLMEngineException("Random generator not available");
        }
        byte[] bArr = new byte[8];
        synchronized (secureRandom) {
            secureRandom.nextBytes(bArr);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] makeSecondaryKey() throws NTLMEngineException {
        SecureRandom secureRandom = RND_GEN;
        if (secureRandom == null) {
            throw new NTLMEngineException("Random generator not available");
        }
        byte[] bArr = new byte[16];
        synchronized (secureRandom) {
            secureRandom.nextBytes(bArr);
        }
        return bArr;
    }

    public static byte[] ntlm2SessionResponse(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NTLMEngineException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr2);
            messageDigest.update(bArr3);
            byte[] bArrDigest = messageDigest.digest();
            byte[] bArr4 = new byte[8];
            System.arraycopy(bArrDigest, 0, bArr4, 0, 8);
            return lmResponse(bArr, bArr4);
        } catch (Exception e) {
            if (e instanceof NTLMEngineException) {
                throw ((NTLMEngineException) e);
            }
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] ntlmHash(String str) throws NTLMEngineException {
        try {
            byte[] bytes = str.getBytes("UnicodeLittleUnmarked");
            MD4 md4 = new MD4();
            md4.update(bytes);
            return md4.getOutput();
        } catch (UnsupportedEncodingException e) {
            throw new NTLMEngineException("Unicode not supported: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] ntlmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        try {
            HMACMD5 hmacmd5 = new HMACMD5(bArr);
            hmacmd5.update(str2.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
            if (str != null) {
                hmacmd5.update(str.getBytes("UnicodeLittleUnmarked"));
            }
            return hmacmd5.getOutput();
        } catch (UnsupportedEncodingException e) {
            throw new NTLMEngineException("Unicode not supported! " + e.getMessage(), e);
        }
    }

    private static void oddParity(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            if (((((((((b >>> 7) ^ (b >>> 6)) ^ (b >>> 5)) ^ (b >>> 4)) ^ (b >>> 3)) ^ (b >>> 2)) ^ (b >>> 1)) & 1) == 0) {
                bArr[i] = (byte) (b | 1);
            } else {
                bArr[i] = (byte) (b & (-2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readSecurityBuffer(byte[] bArr, int i) throws NTLMEngineException {
        int uShort = readUShort(bArr, i);
        int uLong = readULong(bArr, i + 4);
        if (bArr.length < uLong + uShort) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
        }
        byte[] bArr2 = new byte[uShort];
        System.arraycopy(bArr, uLong, bArr2, 0, uShort);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readULong(byte[] bArr, int i) throws NTLMEngineException {
        if (bArr.length < i + 4) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
        }
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readUShort(byte[] bArr, int i) throws NTLMEngineException {
        if (bArr.length < i + 2) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
        }
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public static int rotintlft(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    private static String stripDotSuffix(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(Extension.DOT);
        return iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
    }

    public static void writeULong(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    @Override // org.apache.http.impl.auth.NTLMEngine
    public String generateType1Msg(String str, String str2) {
        return getType1Message(str2, str);
    }

    @Override // org.apache.http.impl.auth.NTLMEngine
    public String generateType3Msg(String str, String str2, String str3, String str4, String str5) {
        Type2Message type2Message = new Type2Message(str5);
        return getType3Message(str, str2, str4, str3, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
    }

    public String getCredentialCharset() {
        return this.credentialCharset;
    }

    public final String getResponseFor(String str, String str2, String str3, String str4, String str5) {
        if (str == null || str.trim().equals("")) {
            return getType1Message(str4, str5);
        }
        Type2Message type2Message = new Type2Message(str);
        return getType3Message(str2, str3, str4, str5, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
    }

    public String getType1Message(String str, String str2) {
        return new Type1Message(str2, str).getResponse();
    }

    public String getType3Message(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) {
        return new Type3Message(str4, str3, str, str2, bArr, i, str5, bArr2).getResponse();
    }

    public void setCredentialCharset(String str) {
        this.credentialCharset = str;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NTLMMessage {
        private int currentOutputPosition;
        private byte[] messageContents;

        public NTLMMessage() {
            this.messageContents = null;
            this.currentOutputPosition = 0;
        }

        public void addByte(byte b) {
            byte[] bArr = this.messageContents;
            int i = this.currentOutputPosition;
            bArr[i] = b;
            this.currentOutputPosition = i + 1;
        }

        public void addBytes(byte[] bArr) {
            if (bArr == null) {
                return;
            }
            for (byte b : bArr) {
                byte[] bArr2 = this.messageContents;
                int i = this.currentOutputPosition;
                bArr2[i] = b;
                this.currentOutputPosition = i + 1;
            }
        }

        public void addULong(int i) {
            addByte((byte) (i & 255));
            addByte((byte) ((i >> 8) & 255));
            addByte((byte) ((i >> 16) & 255));
            addByte((byte) ((i >> 24) & 255));
        }

        public void addUShort(int i) {
            addByte((byte) (i & 255));
            addByte((byte) ((i >> 8) & 255));
        }

        public int getMessageLength() {
            return this.currentOutputPosition;
        }

        public int getPreambleLength() {
            return NTLMEngineImpl.SIGNATURE.length + 4;
        }

        public String getResponse() {
            byte[] bArr = this.messageContents;
            int length = bArr.length;
            int i = this.currentOutputPosition;
            if (length > i) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                bArr = bArr2;
            }
            return EncodingUtils.getAsciiString(Base64.encode(bArr, 2));
        }

        public void prepareResponse(int i, int i2) {
            this.messageContents = new byte[i];
            this.currentOutputPosition = 0;
            addBytes(NTLMEngineImpl.SIGNATURE);
            addULong(i2);
        }

        public byte readByte(int i) throws NTLMEngineException {
            byte[] bArr = this.messageContents;
            if (bArr.length >= i + 1) {
                return bArr[i];
            }
            throw new NTLMEngineException("NTLM: Message too short");
        }

        public void readBytes(byte[] bArr, int i) throws NTLMEngineException {
            byte[] bArr2 = this.messageContents;
            if (bArr2.length < bArr.length + i) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            System.arraycopy(bArr2, i, bArr, 0, bArr.length);
        }

        public byte[] readSecurityBuffer(int i) {
            return NTLMEngineImpl.readSecurityBuffer(this.messageContents, i);
        }

        public int readULong(int i) {
            return NTLMEngineImpl.readULong(this.messageContents, i);
        }

        public int readUShort(int i) {
            return NTLMEngineImpl.readUShort(this.messageContents, i);
        }

        public NTLMMessage(String str, int i) throws NTLMEngineException {
            this.messageContents = null;
            this.currentOutputPosition = 0;
            byte[] bArrDecode = Base64.decode(EncodingUtils.getBytes(str, "ASCII"), 2);
            this.messageContents = bArrDecode;
            if (bArrDecode.length >= NTLMEngineImpl.SIGNATURE.length) {
                for (int i2 = 0; i2 < NTLMEngineImpl.SIGNATURE.length; i2++) {
                    if (this.messageContents[i2] != NTLMEngineImpl.SIGNATURE[i2]) {
                        throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
                    }
                }
                int uLong = readULong(NTLMEngineImpl.SIGNATURE.length);
                if (uLong == i) {
                    this.currentOutputPosition = this.messageContents.length;
                    return;
                }
                throw new NTLMEngineException("NTLM type " + Integer.toString(i) + " message expected - instead got type " + Integer.toString(uLong));
            }
            throw new NTLMEngineException("NTLM message decoding error - packet too short");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CipherGen {
        protected final byte[] challenge;
        protected byte[] clientChallenge;
        protected byte[] clientChallenge2;
        protected final String domain;
        protected byte[] lanManagerSessionKey;
        protected byte[] lm2SessionResponse;
        protected byte[] lmHash;
        protected byte[] lmResponse;
        protected byte[] lmUserSessionKey;
        protected byte[] lmv2Hash;
        protected byte[] lmv2Response;
        protected byte[] ntlm2SessionResponse;
        protected byte[] ntlm2SessionResponseUserSessionKey;
        protected byte[] ntlmHash;
        protected byte[] ntlmResponse;
        protected byte[] ntlmUserSessionKey;
        protected byte[] ntlmv2Blob;
        protected byte[] ntlmv2Hash;
        protected byte[] ntlmv2Response;
        protected byte[] ntlmv2UserSessionKey;
        protected final String password;
        protected byte[] secondaryKey;
        protected final String target;
        protected final byte[] targetInformation;
        protected byte[] timestamp;
        protected final String user;

        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            this.lmHash = null;
            this.lmResponse = null;
            this.ntlmHash = null;
            this.ntlmResponse = null;
            this.ntlmv2Hash = null;
            this.lmv2Hash = null;
            this.lmv2Response = null;
            this.ntlmv2Blob = null;
            this.ntlmv2Response = null;
            this.ntlm2SessionResponse = null;
            this.lm2SessionResponse = null;
            this.lmUserSessionKey = null;
            this.ntlmUserSessionKey = null;
            this.ntlmv2UserSessionKey = null;
            this.ntlm2SessionResponseUserSessionKey = null;
            this.lanManagerSessionKey = null;
            this.domain = str;
            this.target = str4;
            this.user = str2;
            this.password = str3;
            this.challenge = bArr;
            this.targetInformation = bArr2;
            this.clientChallenge = bArr3;
            this.clientChallenge2 = bArr4;
            this.secondaryKey = bArr5;
            this.timestamp = bArr6;
        }

        public byte[] getClientChallenge() {
            if (this.clientChallenge == null) {
                this.clientChallenge = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge;
        }

        public byte[] getClientChallenge2() {
            if (this.clientChallenge2 == null) {
                this.clientChallenge2 = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge2;
        }

        public byte[] getLM2SessionResponse() {
            if (this.lm2SessionResponse == null) {
                byte[] clientChallenge = getClientChallenge();
                byte[] bArr = new byte[24];
                this.lm2SessionResponse = bArr;
                System.arraycopy(clientChallenge, 0, bArr, 0, clientChallenge.length);
                byte[] bArr2 = this.lm2SessionResponse;
                Arrays.fill(bArr2, clientChallenge.length, bArr2.length, (byte) 0);
            }
            return this.lm2SessionResponse;
        }

        public byte[] getLMHash() {
            if (this.lmHash == null) {
                this.lmHash = NTLMEngineImpl.lmHash(this.password);
            }
            return this.lmHash;
        }

        public byte[] getLMResponse() {
            if (this.lmResponse == null) {
                this.lmResponse = NTLMEngineImpl.lmResponse(getLMHash(), this.challenge);
            }
            return this.lmResponse;
        }

        public byte[] getLMUserSessionKey() {
            if (this.lmUserSessionKey == null) {
                this.lmUserSessionKey = new byte[16];
                System.arraycopy(getLMHash(), 0, this.lmUserSessionKey, 0, 8);
                Arrays.fill(this.lmUserSessionKey, 8, 16, (byte) 0);
            }
            return this.lmUserSessionKey;
        }

        public byte[] getLMv2Hash() {
            if (this.lmv2Hash == null) {
                this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, getNTLMHash());
            }
            return this.lmv2Hash;
        }

        public byte[] getLMv2Response() {
            if (this.lmv2Response == null) {
                this.lmv2Response = NTLMEngineImpl.lmv2Response(getLMv2Hash(), this.challenge, getClientChallenge());
            }
            return this.lmv2Response;
        }

        public byte[] getLanManagerSessionKey() throws NTLMEngineException {
            if (this.lanManagerSessionKey == null) {
                try {
                    byte[] bArr = new byte[14];
                    System.arraycopy(getLMHash(), 0, bArr, 0, 8);
                    Arrays.fill(bArr, 8, 14, (byte) -67);
                    Key keyCreateDESKey = NTLMEngineImpl.createDESKey(bArr, 0);
                    Key keyCreateDESKey2 = NTLMEngineImpl.createDESKey(bArr, 7);
                    byte[] bArr2 = new byte[8];
                    System.arraycopy(getLMResponse(), 0, bArr2, 0, 8);
                    Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher.init(1, keyCreateDESKey);
                    byte[] bArrDoFinal = cipher.doFinal(bArr2);
                    Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher2.init(1, keyCreateDESKey2);
                    byte[] bArrDoFinal2 = cipher2.doFinal(bArr2);
                    byte[] bArr3 = new byte[16];
                    this.lanManagerSessionKey = bArr3;
                    System.arraycopy(bArrDoFinal, 0, bArr3, 0, bArrDoFinal.length);
                    System.arraycopy(bArrDoFinal2, 0, this.lanManagerSessionKey, bArrDoFinal.length, bArrDoFinal2.length);
                } catch (Exception e) {
                    throw new NTLMEngineException(e.getMessage(), e);
                }
            }
            return this.lanManagerSessionKey;
        }

        public byte[] getNTLM2SessionResponse() {
            if (this.ntlm2SessionResponse == null) {
                this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), this.challenge, getClientChallenge());
            }
            return this.ntlm2SessionResponse;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey() {
            if (this.ntlm2SessionResponseUserSessionKey == null) {
                byte[] lM2SessionResponse = getLM2SessionResponse();
                byte[] bArr = this.challenge;
                byte[] bArr2 = new byte[bArr.length + lM2SessionResponse.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(lM2SessionResponse, 0, bArr2, this.challenge.length, lM2SessionResponse.length);
                this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(bArr2, getNTLMUserSessionKey());
            }
            return this.ntlm2SessionResponseUserSessionKey;
        }

        public byte[] getNTLMHash() {
            if (this.ntlmHash == null) {
                this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
            }
            return this.ntlmHash;
        }

        public byte[] getNTLMResponse() {
            if (this.ntlmResponse == null) {
                this.ntlmResponse = NTLMEngineImpl.lmResponse(getNTLMHash(), this.challenge);
            }
            return this.ntlmResponse;
        }

        public byte[] getNTLMUserSessionKey() {
            if (this.ntlmUserSessionKey == null) {
                MD4 md4 = new MD4();
                md4.update(getNTLMHash());
                this.ntlmUserSessionKey = md4.getOutput();
            }
            return this.ntlmUserSessionKey;
        }

        public byte[] getNTLMv2Blob() {
            if (this.ntlmv2Blob == null) {
                this.ntlmv2Blob = NTLMEngineImpl.createBlob(getClientChallenge2(), this.targetInformation, getTimestamp());
            }
            return this.ntlmv2Blob;
        }

        public byte[] getNTLMv2Hash() {
            if (this.ntlmv2Hash == null) {
                this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, getNTLMHash());
            }
            return this.ntlmv2Hash;
        }

        public byte[] getNTLMv2Response() {
            if (this.ntlmv2Response == null) {
                this.ntlmv2Response = NTLMEngineImpl.lmv2Response(getNTLMv2Hash(), this.challenge, getNTLMv2Blob());
            }
            return this.ntlmv2Response;
        }

        public byte[] getNTLMv2UserSessionKey() {
            if (this.ntlmv2UserSessionKey == null) {
                byte[] nTLMv2Hash = getNTLMv2Hash();
                byte[] bArr = new byte[16];
                System.arraycopy(getNTLMv2Response(), 0, bArr, 0, 16);
                this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(bArr, nTLMv2Hash);
            }
            return this.ntlmv2UserSessionKey;
        }

        public byte[] getSecondaryKey() {
            if (this.secondaryKey == null) {
                this.secondaryKey = NTLMEngineImpl.makeSecondaryKey();
            }
            return this.secondaryKey;
        }

        public byte[] getTimestamp() {
            if (this.timestamp == null) {
                long jCurrentTimeMillis = (System.currentTimeMillis() + 11644473600000L) * 10000;
                this.timestamp = new byte[8];
                for (int i = 0; i < 8; i++) {
                    this.timestamp[i] = (byte) jCurrentTimeMillis;
                    jCurrentTimeMillis >>>= 8;
                }
            }
            return this.timestamp;
        }

        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2) {
            this(str, str2, str3, bArr, str4, bArr2, null, null, null, null);
        }
    }
}
