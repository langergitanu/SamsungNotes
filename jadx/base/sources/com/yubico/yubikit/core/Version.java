package com.yubico.yubikit.core;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class Version implements Comparable<Version> {
    private static final Pattern VERSION_STRING_PATTERN = Pattern.compile("\\b(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\b");
    public final byte major;
    public final byte micro;
    public final byte minor;

    public Version(int i, int i2, int i4) {
        this(checkRange(i), checkRange(i2), checkRange(i4));
    }

    private static byte checkRange(int i) {
        if (i < 0 || i > 127) {
            throw new IllegalArgumentException("Version component out of supported range (0-127)");
        }
        return (byte) i;
    }

    private int compareToVersion(int i, int i2, int i4) {
        return Integer.compare((this.major << 16) | (this.minor << 8) | this.micro, (i << 16) | (i2 << 8) | i4);
    }

    public static Version fromBytes(byte[] bArr) {
        if (bArr.length >= 3) {
            return new Version(bArr[0], bArr[1], bArr[2]);
        }
        throw new IllegalArgumentException("Version byte array must contain 3 bytes.");
    }

    public static Version parse(String str) {
        Matcher matcher = VERSION_STRING_PATTERN.matcher(str);
        if (matcher.find()) {
            return new Version(Byte.parseByte(matcher.group(1)), Byte.parseByte(matcher.group(2)), Byte.parseByte(matcher.group(3)));
        }
        throw new IllegalArgumentException("Invalid version string");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Version.class == obj.getClass()) {
            Version version = (Version) obj;
            if (this.major == version.major && this.minor == version.minor && this.micro == version.micro) {
                return true;
            }
        }
        return false;
    }

    public byte[] getBytes() {
        return new byte[]{this.major, this.minor, this.micro};
    }

    public int hashCode() {
        return Objects.hash(Byte.valueOf(this.major), Byte.valueOf(this.minor), Byte.valueOf(this.micro));
    }

    public boolean isAtLeast(int i, int i2, int i4) {
        return compareToVersion(i, i2, i4) >= 0;
    }

    public boolean isLessThan(int i, int i2, int i4) {
        return compareToVersion(i, i2, i4) < 0;
    }

    public String toString() {
        Locale locale = Locale.ROOT;
        return (this.major & 255) + Extension.DOT + (this.minor & 255) + Extension.DOT + (this.micro & 255);
    }

    public Version(byte b, byte b5, byte b6) {
        this.major = b;
        this.minor = b5;
        this.micro = b6;
    }

    @Override // java.lang.Comparable
    public int compareTo(Version version) {
        return compareToVersion(version.major, version.minor, version.micro);
    }
}
