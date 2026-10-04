package cz.msebera.android.httpclient.conn.util;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public final class PublicSuffixMatcherLoader {
    private static volatile PublicSuffixMatcher DEFAULT_INSTANCE;

    public static PublicSuffixMatcher getDefault() {
        if (DEFAULT_INSTANCE == null) {
            synchronized (PublicSuffixMatcherLoader.class) {
                if (DEFAULT_INSTANCE == null) {
                    URL resource = PublicSuffixMatcherLoader.class.getResource("/mozilla/public-suffix-list.txt");
                    if (resource != null) {
                        try {
                            DEFAULT_INSTANCE = load(resource);
                        } catch (IOException e) {
                            HttpClientAndroidLog httpClientAndroidLog = new HttpClientAndroidLog(PublicSuffixMatcherLoader.class);
                            if (httpClientAndroidLog.isWarnEnabled()) {
                                httpClientAndroidLog.warn("Failure loading public suffix list from default resource", e);
                            }
                        }
                    } else {
                        DEFAULT_INSTANCE = new PublicSuffixMatcher(Arrays.asList("com"), null);
                    }
                }
            }
        }
        return DEFAULT_INSTANCE;
    }

    private static PublicSuffixMatcher load(InputStream inputStream) {
        return new PublicSuffixMatcher(new PublicSuffixListParser().parseByType(new InputStreamReader(inputStream, Consts.UTF_8)));
    }

    public static PublicSuffixMatcher load(URL url) throws IOException {
        Args.notNull(url, TextConst.ENTITY_TYPE_URL);
        InputStream inputStreamOpenStream = url.openStream();
        try {
            return load(inputStreamOpenStream);
        } finally {
            inputStreamOpenStream.close();
        }
    }

    public static PublicSuffixMatcher load(File file) throws IOException {
        Args.notNull(file, "File");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return load(fileInputStream);
        } finally {
            fileInputStream.close();
        }
    }
}
