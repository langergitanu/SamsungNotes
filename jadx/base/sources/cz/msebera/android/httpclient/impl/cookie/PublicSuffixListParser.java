package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.util.PublicSuffixList;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
public class PublicSuffixListParser {
    private final PublicSuffixFilter filter;
    private final cz.msebera.android.httpclient.conn.util.PublicSuffixListParser parser = new cz.msebera.android.httpclient.conn.util.PublicSuffixListParser();

    public PublicSuffixListParser(PublicSuffixFilter publicSuffixFilter) {
        this.filter = publicSuffixFilter;
    }

    public void parse(Reader reader) throws IOException {
        PublicSuffixList publicSuffixList = this.parser.parse(reader);
        this.filter.setPublicSuffixes(publicSuffixList.getRules());
        this.filter.setExceptions(publicSuffixList.getExceptions());
    }
}
