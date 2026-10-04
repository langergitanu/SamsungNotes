package cz.msebera.android.httpclient.entity.mime;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MinimalField {
    private final String name;
    private final String value;

    public MinimalField(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getBody() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ": " + this.value;
    }
}
