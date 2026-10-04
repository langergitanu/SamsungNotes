package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.util.Args;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class SubjectName {
    static final int DNS = 2;

    /* JADX INFO: renamed from: IP */
    static final int f8487IP = 7;
    private final int type;
    private final String value;

    public SubjectName(String str, int i) {
        this.value = (String) Args.notNull(str, "Value");
        this.type = Args.positive(i, PackageRelationship.TYPE_ATTRIBUTE_NAME);
    }

    public static SubjectName DNS(String str) {
        return new SubjectName(str, 2);
    }

    /* JADX INFO: renamed from: IP */
    public static SubjectName m13522IP(String str) {
        return new SubjectName(str, 7);
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
