package cz.msebera.android.httpclient.conn.util;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public final class PublicSuffixList {
    private final List<String> exceptions;
    private final List<String> rules;
    private final DomainType type;

    public PublicSuffixList(DomainType domainType, List<String> list, List<String> list2) {
        this.type = (DomainType) Args.notNull(domainType, "Domain type");
        this.rules = Collections.unmodifiableList((List) Args.notNull(list, "Domain suffix rules"));
        this.exceptions = Collections.unmodifiableList(list2 == null ? Collections.EMPTY_LIST : list2);
    }

    public List<String> getExceptions() {
        return this.exceptions;
    }

    public List<String> getRules() {
        return this.rules;
    }

    public DomainType getType() {
        return this.type;
    }

    public PublicSuffixList(List<String> list, List<String> list2) {
        this(DomainType.UNKNOWN, list, list2);
    }
}
