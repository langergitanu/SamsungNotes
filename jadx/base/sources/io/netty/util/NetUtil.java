package io.netty.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import io.netty.util.NetUtilInitializations;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class NetUtil {
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final boolean IPV4_PREFERRED;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final Collection<NetworkInterface> NETWORK_INTERFACES;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SoMaxConnAction implements PrivilegedAction<Integer> {
        private SoMaxConnAction() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.security.PrivilegedAction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer run() throws Throwable {
            BufferedReader bufferedReader;
            Exception e;
            Integer numSysctlGetInt;
            int iIntValue = PlatformDependent.isWindows() ? 200 : 128;
            File file = new File("/proc/sys/net/core/somaxconn");
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    if (file.exists()) {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        try {
                            try {
                                iIntValue = Integer.parseInt(bufferedReader.readLine());
                                if (NetUtil.logger.isDebugEnabled()) {
                                    NetUtil.logger.debug("{}: {}", file, Integer.valueOf(iIntValue));
                                }
                                bufferedReader2 = bufferedReader;
                            } catch (Exception e2) {
                                e = e2;
                                if (NetUtil.logger.isDebugEnabled()) {
                                    NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(iIntValue), e);
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return Integer.valueOf(iIntValue);
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        if (SystemPropertyUtil.getBoolean("io.netty.net.somaxconn.trySysctl", false)) {
                            numSysctlGetInt = NetUtil.sysctlGetInt("kern.ipc.somaxconn");
                            if (numSysctlGetInt == null) {
                                numSysctlGetInt = NetUtil.sysctlGetInt("kern.ipc.soacceptqueue");
                                if (numSysctlGetInt != null) {
                                    iIntValue = numSysctlGetInt.intValue();
                                }
                            } else {
                                iIntValue = numSysctlGetInt.intValue();
                            }
                        } else {
                            numSysctlGetInt = null;
                        }
                        if (numSysctlGetInt == null) {
                            NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(iIntValue));
                        }
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception e3) {
                bufferedReader = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return Integer.valueOf(iIntValue);
        }
    }

    static {
        boolean z = SystemPropertyUtil.getBoolean(SystemProperties.JAVA_NET_PREFER_IPV4_STACK, false);
        IPV4_PREFERRED = z;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) NetUtil.class);
        logger = internalLoggerFactory;
        String str = SystemPropertyUtil.get(SystemProperties.JAVA_NET_PREFER_IPV6_ADDRESSES, "false");
        if ("true".equalsIgnoreCase(str.trim())) {
            IPV6_ADDRESSES_PREFERRED = true;
        } else {
            IPV6_ADDRESSES_PREFERRED = false;
        }
        internalLoggerFactory.debug("-Djava.net.preferIPv4Stack: {}", Boolean.valueOf(z));
        internalLoggerFactory.debug("-Djava.net.preferIPv6Addresses: {}", str);
        Collection<NetworkInterface> collectionNetworkInterfaces = NetUtilInitializations.networkInterfaces();
        NETWORK_INTERFACES = collectionNetworkInterfaces;
        Inet4Address inet4AddressCreateLocalhost4 = NetUtilInitializations.createLocalhost4();
        LOCALHOST4 = inet4AddressCreateLocalhost4;
        Inet6Address inet6AddressCreateLocalhost6 = NetUtilInitializations.createLocalhost6();
        LOCALHOST6 = inet6AddressCreateLocalhost6;
        NetUtilInitializations.NetworkIfaceAndInetAddress networkIfaceAndInetAddressDetermineLoopback = NetUtilInitializations.determineLoopback(collectionNetworkInterfaces, inet4AddressCreateLocalhost4, inet6AddressCreateLocalhost6);
        LOOPBACK_IF = networkIfaceAndInetAddressDetermineLoopback.iface();
        LOCALHOST = networkIfaceAndInetAddressDetermineLoopback.address();
        SOMAXCONN = ((Integer) AccessController.doPrivileged(new SoMaxConnAction())).intValue();
    }

    private NetUtil() {
    }

    public static String bytesToIpAddress(byte[] bArr) {
        return bytesToIpAddress(bArr, 0, bArr.length);
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            return validIpV4ToBytes(str);
        }
        if (!isValidIpV6Address(str)) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = AbstractC2322a.m1614d(1, 1, str);
        }
        int iIndexOf = str.indexOf(37);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return getIPv6ByName(str, true);
    }

    public static InetAddress createInetAddressFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            try {
                return InetAddress.getByAddress(validIpV4ToBytes(str));
            } catch (UnknownHostException e) {
                throw new IllegalStateException(e);
            }
        }
        if (!isValidIpV6Address(str)) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = AbstractC2322a.m1614d(1, 1, str);
        }
        int iIndexOf = str.indexOf(37);
        if (iIndexOf < 0) {
            byte[] iPv6ByName = getIPv6ByName(str, true);
            if (iPv6ByName == null) {
                return null;
            }
            try {
                return InetAddress.getByAddress(iPv6ByName);
            } catch (UnknownHostException e2) {
                throw new IllegalStateException(e2);
            }
        }
        try {
            int i = Integer.parseInt(str.substring(iIndexOf + 1));
            byte[] iPv6ByName2 = getIPv6ByName(str.substring(0, iIndexOf), true);
            if (iPv6ByName2 == null) {
                return null;
            }
            try {
                return Inet6Address.getByAddress((String) null, iPv6ByName2, i);
            } catch (UnknownHostException e3) {
                throw new IllegalStateException(e3);
            }
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int decimalDigit(String str, int i) {
        return str.charAt(i) - '0';
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    public static String getHostname(InetSocketAddress inetSocketAddress) {
        return PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x018f, code lost:
    
        if (r7 > 2) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] getIPv6ByName(CharSequence charSequence, boolean z) {
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte[] bArr = new byte[16];
        int length = charSequence.length();
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int iDecodeHexNibble = 0;
        while (i9 < length) {
            char cCharAt = charSequence.charAt(i9);
            if (cCharAt == '.') {
                i11++;
                int i16 = i9 - i12;
                if (i16 > 3 || i12 < 0 || i11 > 3 || ((i13 > 0 && i14 + i15 < 12) || i9 + 1 >= length || i14 >= 16 || (i11 == 1 && (!z || (!(i14 == 0 || isValidIPv4Mapped(bArr, i14, i10, i15)) || ((i16 == 3 && !(isValidNumericChar(charSequence.charAt(i9 - 1)) && isValidNumericChar(charSequence.charAt(i9 - 2)) && isValidNumericChar(charSequence.charAt(i9 - 3)))) || ((i16 == 2 && !(isValidNumericChar(charSequence.charAt(i9 - 1)) && isValidNumericChar(charSequence.charAt(i9 - 2)))) || (i16 == 1 && !isValidNumericChar(charSequence.charAt(i9 - 1)))))))))) {
                    return null;
                }
                int i17 = iDecodeHexNibble << ((3 - i16) << 2);
                int i18 = (((i17 >> 4) & 15) * 10) + ((i17 & 15) * 100) + ((i17 >> 8) & 15);
                if (i18 > 255) {
                    return null;
                }
                bArr[i14] = (byte) i18;
                i14++;
            } else if (cCharAt == ':') {
                int i19 = i13 + 1;
                int i20 = i9 - i12;
                if (i20 > 4 || i11 > 0 || i19 > 8 || (i8 = i14 + 1) >= 16) {
                    return null;
                }
                int i21 = iDecodeHexNibble << ((4 - i20) << 2);
                if (i15 > 0) {
                    i15 -= 2;
                }
                bArr[i14] = (byte) (((i21 & 15) << 4) | ((i21 >> 4) & 15));
                i14 += 2;
                bArr[i8] = (byte) ((((i21 >> 8) & 15) << 4) | ((i21 >> 12) & 15));
                int i22 = i9 + 1;
                if (i22 >= length || charSequence.charAt(i22) != ':') {
                    i13 = i19;
                } else {
                    int i23 = i9 + 2;
                    if (i10 != 0 || (i23 < length && charSequence.charAt(i23) == ':')) {
                        return null;
                    }
                    i13 += 2;
                    i15 = 14 - i14;
                    i9 = i22;
                    i10 = i14;
                }
            } else {
                if (!isValidHexChar(cCharAt) || (i11 > 0 && !isValidNumericChar(cCharAt))) {
                    return null;
                }
                if (i12 < 0) {
                    i12 = i9;
                } else if (i9 - i12 > 4) {
                    return null;
                }
                iDecodeHexNibble += StringUtil.decodeHexNibble(cCharAt) << ((i9 - i12) << 2);
                i9++;
            }
            i12 = -1;
            iDecodeHexNibble = 0;
            i9++;
        }
        boolean z2 = i10 > 0;
        if (i11 > 0) {
            if (i12 > 0) {
                i5 = 3;
                if (i9 - i12 <= 3) {
                }
                return null;
            }
            i5 = 3;
            if (i11 == i5 && i14 < 16) {
                if (i13 != 0) {
                    if (i13 >= 2) {
                        if (z2 || i13 != 6) {
                            i7 = 0;
                        } else {
                            i7 = 0;
                            if (charSequence.charAt(0) == ':') {
                            }
                        }
                        if (z2 && i13 < 8) {
                            if (charSequence.charAt(i7) == ':') {
                            }
                            int i24 = iDecodeHexNibble << ((3 - (i9 - i12)) << 2);
                            i6 = (((i24 >> 4) & 15) * 10) + ((i24 & 15) * 100) + ((i24 >> 8) & 15);
                            if (i6 <= 255) {
                            }
                        }
                    }
                    return null;
                }
                int i242 = iDecodeHexNibble << ((3 - (i9 - i12)) << 2);
                i6 = (((i242 >> 4) & 15) * 10) + ((i242 & 15) * 100) + ((i242 >> 8) & 15);
                if (i6 <= 255) {
                    return null;
                }
                i2 = i14 + 1;
                bArr[i14] = (byte) i6;
            }
            return null;
        }
        int i25 = length - 1;
        if ((i12 > 0 && i9 - i12 > 4) || i13 < 2 || ((!z2 && (i13 + 1 != 8 || charSequence.charAt(0) == ':' || charSequence.charAt(i25) == ':')) || ((z2 && (i13 > 8 || (i13 == 8 && ((i10 <= 2 && charSequence.charAt(0) != ':') || (i10 >= 14 && charSequence.charAt(i25) != ':'))))) || (i = i14 + 1) >= 16 || ((i12 < 0 && charSequence.charAt(length - 2) != ':') || (i10 > 2 && charSequence.charAt(0) == ':'))))) {
            return null;
        }
        if (i12 >= 0 && (i4 = i9 - i12) <= 4) {
            iDecodeHexNibble <<= (4 - i4) << 2;
        }
        bArr[i14] = (byte) (((iDecodeHexNibble & 15) << 4) | ((iDecodeHexNibble >> 4) & 15));
        i2 = i14 + 2;
        bArr[i] = (byte) ((((iDecodeHexNibble >> 8) & 15) << 4) | ((iDecodeHexNibble >> 12) & 15));
        if (i2 < 16) {
            int i26 = i2 - i10;
            int i27 = 16 - i26;
            System.arraycopy(bArr, i10, bArr, i27, i26);
            Arrays.fill(bArr, i10, i27, (byte) 0);
        }
        if (i11 > 0) {
            bArr[11] = -1;
            bArr[10] = -1;
        }
        return bArr;
    }

    private static boolean inRangeEndExclusive(int i, int i2, int i4) {
        return i >= i2 && i < i4;
    }

    public static String intToIpAddress(int i) {
        StringBuilder sb = new StringBuilder(15);
        sb.append((i >> 24) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append(i & 255);
        return sb.toString();
    }

    public static int ipv4AddressToInt(Inet4Address inet4Address) {
        byte[] address = inet4Address.getAddress();
        return (address[3] & 255) | ((address[0] & 255) << 24) | ((address[1] & 255) << 16) | ((address[2] & 255) << 8);
    }

    private static byte ipv4WordToByte(String str, int i, int i2) {
        int iDecimalDigit = decimalDigit(str, i);
        int i4 = i + 1;
        if (i4 == i2) {
            return (byte) iDecimalDigit;
        }
        int iDecimalDigit2 = (iDecimalDigit * 10) + decimalDigit(str, i4);
        int i5 = i + 2;
        return i5 == i2 ? (byte) iDecimalDigit2 : (byte) ((iDecimalDigit2 * 10) + decimalDigit(str, i5));
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    private static boolean isValidHexChar(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'A' || c > 'F') {
            return c >= 'a' && c <= 'f';
        }
        return true;
    }

    private static boolean isValidIPv4Mapped(byte[] bArr, int i, int i2, int i4) {
        boolean z = i4 + i2 >= 14;
        return i <= 12 && i >= 2 && (!z || i2 < 12) && isValidIPv4MappedSeparators(bArr[i + (-1)], bArr[i + (-2)], z) && PlatformDependent.isZero(bArr, 0, i + (-3));
    }

    private static boolean isValidIPv4MappedChar(char c) {
        return c == 'f' || c == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b, byte b5, boolean z) {
        if (b != b5) {
            return false;
        }
        if (b != 0) {
            return !z && b5 == -1;
        }
        return true;
    }

    public static boolean isValidIpV4Address(CharSequence charSequence) {
        return isValidIpV4Address(charSequence, 0, charSequence.length());
    }

    private static boolean isValidIpV4Address0(CharSequence charSequence, int i, int i2) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i4 = i2 - i;
        return i4 <= 15 && i4 >= 7 && (iIndexOf = AsciiString.indexOf(charSequence, '.', i + 1)) > 0 && isValidIpV4Word(charSequence, i, iIndexOf) && (iIndexOf2 = AsciiString.indexOf(charSequence, '.', iIndexOf + 2)) > 0 && isValidIpV4Word(charSequence, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = AsciiString.indexOf(charSequence, '.', iIndexOf2 + 2)) > 0 && isValidIpV4Word(charSequence, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(charSequence, iIndexOf3 + 1, i2);
    }

    private static boolean isValidIpV4Word(CharSequence charSequence, int i, int i2) {
        char cCharAt;
        char cCharAt2;
        int i4 = i2 - i;
        if (i4 >= 1 && i4 <= 3 && (cCharAt = charSequence.charAt(i)) >= '0') {
            if (i4 == 3) {
                char cCharAt3 = charSequence.charAt(i + 1);
                return cCharAt3 >= '0' && (cCharAt2 = charSequence.charAt(i + 2)) >= '0' && ((cCharAt <= '1' && cCharAt3 <= '9' && cCharAt2 <= '9') || (cCharAt == '2' && cCharAt3 <= '5' && (cCharAt2 <= '5' || (cCharAt3 < '5' && cCharAt2 <= '9'))));
            }
            if (cCharAt <= '9' && (i4 == 1 || isValidNumericChar(charSequence.charAt(i + 1)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidIpV6Address(String str) {
        return isValidIpV6Address((CharSequence) str);
    }

    private static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    private static StringBuilder newSocketAddressStringBuilder(String str, String str2, boolean z) {
        int length = str.length();
        if (z) {
            StringBuilder sb = new StringBuilder(str2.length() + length + 1);
            sb.append(str);
            return sb;
        }
        StringBuilder sb2 = new StringBuilder(str2.length() + length + 3);
        if (length > 1 && str.charAt(0) == '[' && str.charAt(length - 1) == ']') {
            sb2.append(str);
            return sb2;
        }
        sb2.append(PropertyUtils.INDEXED_DELIM);
        sb2.append(str);
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        Process processStart = new ProcessBuilder("sysctl", str).start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream()));
            try {
                String line = bufferedReader.readLine();
                if (line != null && line.startsWith(str)) {
                    int length = line.length();
                    do {
                        length--;
                        if (length > str.length()) {
                        }
                    } while (Character.isDigit(line.charAt(length)));
                    return Integer.valueOf(line.substring(length + 1));
                }
                processStart.destroy();
                return null;
            } finally {
                bufferedReader.close();
            }
        } finally {
            processStart.destroy();
        }
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    public static String toSocketAddressString(InetSocketAddress inetSocketAddress) {
        StringBuilder sbNewSocketAddressStringBuilder;
        String strValueOf = String.valueOf(inetSocketAddress.getPort());
        if (inetSocketAddress.isUnresolved()) {
            sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(getHostname(inetSocketAddress), strValueOf, !isValidIpV6Address(r2));
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(toAddressString(address), strValueOf, address instanceof Inet4Address);
        }
        sbNewSocketAddressStringBuilder.append(':');
        sbNewSocketAddressStringBuilder.append(strValueOf);
        return sbNewSocketAddressStringBuilder.toString();
    }

    public static byte[] validIpV4ToBytes(String str) {
        int iIndexOf = str.indexOf(46, 1);
        byte bIpv4WordToByte = ipv4WordToByte(str, 0, iIndexOf);
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(46, iIndexOf + 2);
        byte bIpv4WordToByte2 = ipv4WordToByte(str, i, iIndexOf2);
        int iIndexOf3 = str.indexOf(46, iIndexOf2 + 2);
        return new byte[]{bIpv4WordToByte, bIpv4WordToByte2, ipv4WordToByte(str, iIndexOf2 + 1, iIndexOf3), ipv4WordToByte(str, iIndexOf3 + 1, str.length())};
    }

    public static String bytesToIpAddress(byte[] bArr, int i, int i2) {
        if (i2 != 4) {
            if (i2 == 16) {
                return toAddressString(bArr, i, false);
            }
            throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "length: ", " (expected: 4 or 16)"));
        }
        StringBuilder sb = new StringBuilder(15);
        sb.append(bArr[i] & 255);
        sb.append('.');
        sb.append(bArr[i + 1] & 255);
        sb.append('.');
        sb.append(bArr[i + 2] & 255);
        sb.append('.');
        sb.append(bArr[i + 3] & 255);
        return sb.toString();
    }

    public static Inet6Address getByName(CharSequence charSequence, boolean z) {
        byte[] iPv6ByName = getIPv6ByName(charSequence, z);
        if (iPv6ByName == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress((String) null, iPv6ByName, -1);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isValidIpV4Address(String str) {
        return isValidIpV4Address(str, 0, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d3, code lost:
    
        if (r3 >= 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d5, code lost:
    
        if (r2 != 7) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00d7, code lost:
    
        if (r8 <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00d9, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00da, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00dd, code lost:
    
        if ((r3 + 2) == r0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00df, code lost:
    
        if (r8 <= 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e3, code lost:
    
        if (r2 < 8) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00e5, code lost:
    
        if (r3 > r4) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e8, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00e9, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isValidIpV6Address(CharSequence charSequence) {
        int i;
        int i2;
        int length = charSequence.length();
        int i4 = 2;
        if (length >= 2) {
            char cCharAt = charSequence.charAt(0);
            if (cCharAt == '[') {
                length--;
                if (charSequence.charAt(length) != ']') {
                    return false;
                }
                cCharAt = charSequence.charAt(1);
                i = 1;
            } else {
                i = 0;
            }
            if (cCharAt != ':') {
                i2 = -1;
                i4 = 0;
            } else {
                if (charSequence.charAt(i + 1) != ':') {
                    return false;
                }
                int i5 = i;
                i += 2;
                i2 = i5;
            }
            int i6 = 0;
            int i7 = i;
            while (true) {
                if (i7 >= length) {
                    break;
                }
                char cCharAt2 = charSequence.charAt(i7);
                if (!isValidHexChar(cCharAt2)) {
                    if (cCharAt2 == '%') {
                        length = i7;
                        break;
                    }
                    if (cCharAt2 == '.') {
                        if ((i2 < 0 && i4 != 6) || ((i4 == 7 && i2 >= i) || i4 > 7)) {
                            return false;
                        }
                        int i8 = i7 - i6;
                        int i9 = i8 - 2;
                        if (isValidIPv4MappedChar(charSequence.charAt(i9))) {
                            if (!isValidIPv4MappedChar(charSequence.charAt(i8 - 3)) || !isValidIPv4MappedChar(charSequence.charAt(i8 - 4)) || !isValidIPv4MappedChar(charSequence.charAt(i8 - 5))) {
                                return false;
                            }
                            i9 = i8 - 7;
                        }
                        while (i9 >= i) {
                            char cCharAt3 = charSequence.charAt(i9);
                            if (cCharAt3 != '0' && cCharAt3 != ':') {
                                return false;
                            }
                            i9--;
                        }
                        int iIndexOf = AsciiString.indexOf(charSequence, '%', i8 + 7);
                        if (iIndexOf >= 0) {
                            length = iIndexOf;
                        }
                        return isValidIpV4Address(charSequence, i8, length);
                    }
                    if (cCharAt2 != ':' || i4 > 7) {
                        return false;
                    }
                    int i10 = i7 - 1;
                    if (charSequence.charAt(i10) != ':') {
                        i6 = 0;
                    } else {
                        if (i2 >= 0) {
                            return false;
                        }
                        i2 = i10;
                    }
                    i4++;
                } else {
                    if (i6 >= 4) {
                        return false;
                    }
                    i6++;
                }
                i7++;
            }
        } else {
            return false;
        }
    }

    public static String toAddressString(InetAddress inetAddress, boolean z) {
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (inetAddress instanceof Inet6Address) {
            return toAddressString(inetAddress.getAddress(), 0, z);
        }
        throw new IllegalArgumentException("Unhandled type: " + inetAddress);
    }

    private static boolean isValidIpV4Address(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof String) {
            return isValidIpV4Address((String) charSequence, i, i2);
        }
        if (charSequence instanceof AsciiString) {
            return isValidIpV4Address((AsciiString) charSequence, i, i2);
        }
        return isValidIpV4Address0(charSequence, i, i2);
    }

    private static boolean isValidIpV4Address(String str, int i, int i2) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i4 = i2 - i;
        return i4 <= 15 && i4 >= 7 && (iIndexOf = str.indexOf(46, i + 1)) > 0 && isValidIpV4Word(str, i, iIndexOf) && (iIndexOf2 = str.indexOf(46, iIndexOf + 2)) > 0 && isValidIpV4Word(str, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = str.indexOf(46, iIndexOf2 + 2)) > 0 && isValidIpV4Word(str, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(str, iIndexOf3 + 1, i2);
    }

    private static String toAddressString(byte[] bArr, int i, boolean z) {
        int i2;
        int i4;
        int[] iArr = new int[8];
        int i5 = i + 8;
        while (true) {
            i2 = 1;
            if (i >= i5) {
                break;
            }
            int i6 = i << 1;
            iArr[i] = (bArr[i6 + 1] & 255) | ((bArr[i6] & 255) << 8);
            i++;
        }
        int i7 = -1;
        boolean z2 = false;
        int i8 = -1;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        while (i10 < 8) {
            if (iArr[i10] == 0) {
                if (i8 < 0) {
                    i8 = i10;
                }
            } else if (i8 >= 0) {
                int i12 = i10 - i8;
                if (i12 > i11) {
                    i11 = i12;
                } else {
                    i8 = i9;
                }
                i9 = i8;
                i8 = -1;
            }
            i10++;
        }
        if (i8 < 0 || (i4 = i10 - i8) <= i11) {
            i8 = i9;
        } else {
            i11 = i4;
        }
        if (i11 == 1) {
            i11 = 0;
        } else {
            i7 = i8;
        }
        int i13 = i11 + i7;
        StringBuilder sb = new StringBuilder(39);
        if (i13 < 0) {
            sb.append(Integer.toHexString(iArr[0]));
            while (i2 < 8) {
                sb.append(':');
                sb.append(Integer.toHexString(iArr[i2]));
                i2++;
            }
        } else {
            if (inRangeEndExclusive(0, i7, i13)) {
                sb.append("::");
                if (z && i13 == 5 && iArr[5] == 65535) {
                    z2 = true;
                }
            } else {
                sb.append(Integer.toHexString(iArr[0]));
            }
            while (i2 < 8) {
                if (!inRangeEndExclusive(i2, i7, i13)) {
                    if (!inRangeEndExclusive(i2 - 1, i7, i13)) {
                        if (z2 && i2 != 6) {
                            sb.append('.');
                        } else {
                            sb.append(':');
                        }
                    }
                    if (z2 && i2 > 5) {
                        sb.append(iArr[i2] >> 8);
                        sb.append('.');
                        sb.append(iArr[i2] & 255);
                    } else {
                        sb.append(Integer.toHexString(iArr[i2]));
                    }
                } else if (!inRangeEndExclusive(i2 - 1, i7, i13)) {
                    sb.append("::");
                }
                i2++;
            }
        }
        return sb.toString();
    }

    public static String toSocketAddressString(String str, int i) {
        String strValueOf = String.valueOf(i);
        StringBuilder sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(str, strValueOf, !isValidIpV6Address(str));
        sbNewSocketAddressStringBuilder.append(':');
        sbNewSocketAddressStringBuilder.append(strValueOf);
        return sbNewSocketAddressStringBuilder.toString();
    }

    private static boolean isValidIpV4Address(AsciiString asciiString, int i, int i2) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i4 = i2 - i;
        return i4 <= 15 && i4 >= 7 && (iIndexOf = asciiString.indexOf('.', i + 1)) > 0 && isValidIpV4Word(asciiString, i, iIndexOf) && (iIndexOf2 = asciiString.indexOf('.', iIndexOf + 2)) > 0 && isValidIpV4Word(asciiString, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = asciiString.indexOf('.', iIndexOf2 + 2)) > 0 && isValidIpV4Word(asciiString, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(asciiString, iIndexOf3 + 1, i2);
    }
}
