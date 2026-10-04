package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class VersionUtil {
    public static final String VERSION_FILE = "VERSION.txt";
    private static final Pattern VERSION_SEPARATOR = Pattern.compile("[-_./;:]");
    private final Version _version;

    public VersionUtil() {
        Version versionVersionFor;
        try {
            versionVersionFor = versionFor(getClass());
        } catch (Exception unused) {
            System.err.println("ERROR: Failed to load Version information for bundle (via " + getClass().getName() + ").");
            versionVersionFor = null;
        }
        this._version = versionVersionFor == null ? Version.unknownVersion() : versionVersionFor;
    }

    public static Version mavenVersionFor(ClassLoader classLoader, String str, String str2) {
        InputStream resourceAsStream = classLoader.getResourceAsStream("META-INF/maven/" + str.replaceAll(RemoteConstant.VERSION_DIVIDE, "/") + "/" + str2 + "/pom.properties");
        if (resourceAsStream != null) {
            try {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    Version version = parseVersion(properties.getProperty("version"), properties.getProperty("groupId"), properties.getProperty("artifactId"));
                    try {
                        resourceAsStream.close();
                    } catch (IOException unused) {
                    }
                    return version;
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
                resourceAsStream.close();
            } catch (Throwable th) {
                try {
                    resourceAsStream.close();
                } catch (IOException unused4) {
                }
                throw th;
            }
        }
        return Version.unknownVersion();
    }

    @Deprecated
    public static Version parseVersion(String str) {
        return parseVersion(str, null, null);
    }

    public static int parseVersionPart(String str) {
        String string = str.toString();
        int length = string.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = string.charAt(i2);
            if (cCharAt > '9' || cCharAt < '0') {
                break;
            }
            i = (i * 10) + (cCharAt - '0');
        }
        return i;
    }

    public static Version versionFor(Class<?> cls) {
        String line;
        String line2;
        Version version = null;
        try {
            InputStream resourceAsStream = cls.getResourceAsStream(VERSION_FILE);
            if (resourceAsStream != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
                    String line3 = bufferedReader.readLine();
                    if (line3 != null) {
                        line2 = bufferedReader.readLine();
                        if (line2 != null) {
                            line2 = line2.trim();
                            line = bufferedReader.readLine();
                            if (line != null) {
                                line = line.trim();
                            }
                        } else {
                            line = null;
                        }
                    } else {
                        line = null;
                        line2 = null;
                    }
                    version = parseVersion(line3, line2, line);
                    try {
                        resourceAsStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    try {
                        resourceAsStream.close();
                        throw th;
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        } catch (IOException unused) {
        }
        return version == null ? Version.unknownVersion() : version;
    }

    public Version version() {
        return this._version;
    }

    public static Version parseVersion(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return null;
        }
        String[] strArrSplit = VERSION_SEPARATOR.split(strTrim);
        return new Version(parseVersionPart(strArrSplit[0]), strArrSplit.length > 1 ? parseVersionPart(strArrSplit[1]) : 0, strArrSplit.length > 2 ? parseVersionPart(strArrSplit[2]) : 0, strArrSplit.length > 3 ? strArrSplit[3] : null, str2, str3);
    }
}
