package opennlp.tools.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Version {
    private static final String SNAPSHOT_MARKER = "-SNAPSHOT";
    private final int major;
    private final int minor;
    private final int revision;
    private final boolean snapshot;
    private static final String DEV_VERSION_STRING = "0.0.0-SNAPSHOT";
    public static final Version DEV_VERSION = parse(DEV_VERSION_STRING);

    public Version(int i, int i2, int i4, boolean z) {
        this.major = i;
        this.minor = i2;
        this.revision = i4;
        this.snapshot = z;
    }

    public static Version currentVersion() {
        Properties properties = new Properties();
        try {
            InputStream resourceAsStream = Version.class.getResourceAsStream("opennlp.version");
            if (resourceAsStream != null) {
                try {
                    properties.load(resourceAsStream);
                } finally {
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        String str = DEV_VERSION_STRING;
        String property = properties.getProperty("OpenNLP-Version", DEV_VERSION_STRING);
        if (!property.equals("${project.version}")) {
            str = property;
        }
        return parse(str);
    }

    public static Version parse(String str) {
        int iIndexOf = str.indexOf(46);
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(46, i);
        if (iIndexOf == -1 || iIndexOf2 == -1) {
            throw new NumberFormatException(AbstractC0541b.m773o("Invalid version format '", str, "', expected two dots!"));
        }
        int iIndexOf3 = str.indexOf(45);
        if (iIndexOf3 == -1) {
            iIndexOf3 = str.length();
        }
        return new Version(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(i, iIndexOf2)), Integer.parseInt(str.substring(iIndexOf2 + 1, iIndexOf3)), str.endsWith(SNAPSHOT_MARKER));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Version) {
            Version version = (Version) obj;
            if (getMajor() == version.getMajor() && getMinor() == version.getMinor() && getRevision() == version.getRevision() && isSnapshot() == version.isSnapshot()) {
                return true;
            }
        }
        return false;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int getRevision() {
        return this.revision;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(getMajor()), Integer.valueOf(getMinor()), Integer.valueOf(getRevision()), Boolean.valueOf(isSnapshot()));
    }

    public boolean isSnapshot() {
        return this.snapshot;
    }

    public String toString() {
        return getMajor() + Extension.DOT + getMinor() + Extension.DOT + getRevision() + (isSnapshot() ? SNAPSHOT_MARKER : "");
    }

    public Version(int i, int i2, int i4) {
        this(i, i2, i4, false);
    }
}
