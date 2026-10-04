package cz.msebera.android.httpclient.conn.util;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public final class PublicSuffixListParser {
    public PublicSuffixList parse(Reader reader) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new PublicSuffixList(DomainType.UNKNOWN, arrayList, arrayList2);
            }
            if (!line.isEmpty() && !line.startsWith("//")) {
                if (line.startsWith(Extension.DOT)) {
                    line = line.substring(1);
                }
                boolean zStartsWith = line.startsWith("!");
                if (zStartsWith) {
                    line = line.substring(1);
                }
                if (zStartsWith) {
                    arrayList2.add(line);
                } else {
                    arrayList.add(line);
                }
            }
        }
    }

    public List<PublicSuffixList> parseByType(Reader reader) throws IOException {
        ArrayList arrayList = new ArrayList(2);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            DomainType domainType = null;
            ArrayList arrayList2 = null;
            ArrayList arrayList3 = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return arrayList;
                }
                if (!line.isEmpty()) {
                    if (line.startsWith("//")) {
                        if (domainType == null) {
                            if (line.contains("===BEGIN ICANN DOMAINS===")) {
                                domainType = DomainType.ICANN;
                            } else if (line.contains("===BEGIN PRIVATE DOMAINS===")) {
                                domainType = DomainType.PRIVATE;
                            }
                        } else if (line.contains("===END ICANN DOMAINS===") || line.contains("===END PRIVATE DOMAINS===")) {
                            break;
                        }
                    } else if (domainType != null) {
                        if (line.startsWith(Extension.DOT)) {
                            line = line.substring(1);
                        }
                        boolean zStartsWith = line.startsWith("!");
                        if (zStartsWith) {
                            line = line.substring(1);
                        }
                        if (zStartsWith) {
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(line);
                        } else {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(line);
                        }
                    }
                }
            }
            if (arrayList2 != null) {
                arrayList.add(new PublicSuffixList(domainType, arrayList2, arrayList3));
            }
        }
    }
}
