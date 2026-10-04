package p042J1;

import com.samsung.android.app.notes.sync.utils.StorageHelper$StorageVolume$Type;
import java.io.File;

/* JADX INFO: renamed from: J1.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0149g {

    /* JADX INFO: renamed from: a */
    public final File f441a;

    /* JADX INFO: renamed from: b */
    public final String f442b;

    /* JADX INFO: renamed from: c */
    public boolean f443c;

    /* JADX INFO: renamed from: d */
    public boolean f444d;

    /* JADX INFO: renamed from: e */
    public boolean f445e;

    /* JADX INFO: renamed from: f */
    public StorageHelper$StorageVolume$Type f446f;

    public C0149g(File file, String str) {
        this.f441a = file;
        this.f442b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || C0149g.class != obj.getClass()) {
            return false;
        }
        File file = ((C0149g) obj).f441a;
        File file2 = this.f441a;
        return file2 == null ? file == null : file2.equals(file);
    }

    public final int hashCode() {
        File file = this.f441a;
        return 31 + (file == null ? 0 : file.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f441a.getAbsolutePath());
        sb.append(this.f443c ? " ro " : " rw ");
        sb.append(this.f446f);
        sb.append(this.f444d ? " R " : "");
        sb.append(this.f445e ? " E " : "");
        sb.append(this.f442b);
        return sb.toString();
    }
}
