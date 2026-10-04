package io.netty.util;

import androidx.compose.foundation.layout.AbstractC1038a;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Version {
    private static final String PROP_BUILD_DATE = ".buildDate";
    private static final String PROP_COMMIT_DATE = ".commitDate";
    private static final String PROP_LONG_COMMIT_HASH = ".longCommitHash";
    private static final String PROP_REPO_STATUS = ".repoStatus";
    private static final String PROP_SHORT_COMMIT_HASH = ".shortCommitHash";
    private static final String PROP_VERSION = ".version";
    private final String artifactId;
    private final String artifactVersion;
    private final long buildTimeMillis;
    private final long commitTimeMillis;
    private final String longCommitHash;
    private final String repositoryStatus;
    private final String shortCommitHash;

    private Version(String str, String str2, long j, long j2, String str3, String str4, String str5) {
        this.artifactId = str;
        this.artifactVersion = str2;
        this.buildTimeMillis = j;
        this.commitTimeMillis = j2;
        this.shortCommitHash = str3;
        this.longCommitHash = str4;
        this.repositoryStatus = str5;
    }

    public static Map<String, Version> identify() {
        return identify(null);
    }

    public static void main(String[] strArr) {
        Iterator<Version> it = identify().values().iterator();
        while (it.hasNext()) {
            System.err.println(it.next());
        }
    }

    private static long parseIso8601(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(str).getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public String artifactId() {
        return this.artifactId;
    }

    public String artifactVersion() {
        return this.artifactVersion;
    }

    public long buildTimeMillis() {
        return this.buildTimeMillis;
    }

    public long commitTimeMillis() {
        return this.commitTimeMillis;
    }

    public String longCommitHash() {
        return this.longCommitHash;
    }

    public String repositoryStatus() {
        return this.repositoryStatus;
    }

    public String shortCommitHash() {
        return this.shortCommitHash;
    }

    public String toString() {
        String strM1213n;
        StringBuilder sb = new StringBuilder();
        sb.append(this.artifactId);
        sb.append('-');
        sb.append(this.artifactVersion);
        sb.append('.');
        sb.append(this.shortCommitHash);
        if ("clean".equals(this.repositoryStatus)) {
            strM1213n = "";
        } else {
            strM1213n = AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.repositoryStatus, new StringBuilder(" (repository: "));
        }
        sb.append(strM1213n);
        return sb.toString();
    }

    public static Map<String, Version> identify(ClassLoader classLoader) {
        ClassLoader contextClassLoader = classLoader == null ? PlatformDependent.getContextClassLoader() : classLoader;
        Properties properties = new Properties();
        try {
            Enumeration<URL> resources = contextClassLoader.getResources("META-INF/io.netty.versions.properties");
            while (resources.hasMoreElements()) {
                InputStream inputStreamOpenStream = resources.nextElement().openStream();
                try {
                    properties.load(inputStreamOpenStream);
                    try {
                        inputStreamOpenStream.close();
                    } catch (Exception unused) {
                    }
                } finally {
                }
            }
        } catch (Exception unused2) {
        }
        HashSet<String> hashSet = new HashSet();
        for (String str : properties.keySet()) {
            int iIndexOf = str.indexOf(46);
            if (iIndexOf > 0) {
                String strSubstring = str.substring(0, iIndexOf);
                if (properties.containsKey(strSubstring + PROP_VERSION)) {
                    if (properties.containsKey(strSubstring + PROP_BUILD_DATE)) {
                        if (properties.containsKey(strSubstring + PROP_COMMIT_DATE)) {
                            if (properties.containsKey(strSubstring + PROP_SHORT_COMMIT_HASH)) {
                                if (properties.containsKey(strSubstring + PROP_LONG_COMMIT_HASH)) {
                                    if (properties.containsKey(strSubstring + PROP_REPO_STATUS)) {
                                        hashSet.add(strSubstring);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        TreeMap treeMap = new TreeMap();
        for (String str2 : hashSet) {
            treeMap.put(str2, new Version(str2, properties.getProperty(str2 + PROP_VERSION), parseIso8601(properties.getProperty(str2 + PROP_BUILD_DATE)), parseIso8601(properties.getProperty(str2 + PROP_COMMIT_DATE)), properties.getProperty(str2 + PROP_SHORT_COMMIT_HASH), properties.getProperty(str2 + PROP_LONG_COMMIT_HASH), properties.getProperty(str2 + PROP_REPO_STATUS)));
        }
        return treeMap;
    }
}
