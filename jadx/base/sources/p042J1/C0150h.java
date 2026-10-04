package p042J1;

import android.os.Environment;
import com.samsung.android.app.notes.sync.utils.StorageHelper$StorageVolume$Type;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: renamed from: J1.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0150h {

    /* JADX INFO: renamed from: a */
    public static final String f447a;

    /* JADX INFO: renamed from: b */
    public static final String[] f448b;

    /* JADX INFO: renamed from: c */
    public static final String[] f449c;

    /* JADX INFO: renamed from: d */
    public static final String[] f450d;

    static {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        int iIndexOf = absolutePath.indexOf(File.separatorChar, 1);
        if (iIndexOf != -1) {
            f447a = absolutePath.substring(0, iIndexOf + 1);
        } else {
            f447a = File.separator;
        }
        f448b = new String[]{"rootfs", "tmpfs", "dvpts", "proc", "sysfs", "none"};
        f449c = new String[]{"obb", "asec"};
        f450d = new String[]{"tmpfs", "rootfs", "romfs", "devpts", "sysfs", "proc", "cgroup", "debugfs"};
    }

    /* JADX INFO: renamed from: a */
    public static boolean m368a(String str, String[] strArr) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, File.separator);
        while (true) {
            if (!stringTokenizer.hasMoreElements()) {
                return false;
            }
            String strNextToken = stringTokenizer.nextToken();
            for (String str2 : strArr) {
                if (strNextToken.equals(str2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m369b(ArrayList arrayList, C0149g c0149g, boolean z) {
        StorageHelper$StorageVolume$Type storageHelper$StorageVolume$Type;
        File file = c0149g.f441a;
        if (file.equals(Environment.getExternalStorageDirectory()) && Environment.isExternalStorageEmulated()) {
            storageHelper$StorageVolume$Type = StorageHelper$StorageVolume$Type.INTERNAL;
        } else {
            String absolutePath = file.getAbsolutePath();
            if (absolutePath != null) {
                int length = absolutePath.length() - 3;
                for (int i = 0; i <= length; i++) {
                    if (absolutePath.regionMatches(true, i, "usb", 0, 3)) {
                        storageHelper$StorageVolume$Type = StorageHelper$StorageVolume$Type.USB;
                        break;
                    }
                }
                storageHelper$StorageVolume$Type = StorageHelper$StorageVolume$Type.EXTERNAL;
            } else {
                storageHelper$StorageVolume$Type = StorageHelper$StorageVolume$Type.EXTERNAL;
            }
        }
        if (storageHelper$StorageVolume$Type != StorageHelper$StorageVolume$Type.USB) {
            c0149g.f446f = storageHelper$StorageVolume$Type;
            if (file.equals(Environment.getExternalStorageDirectory())) {
                c0149g.f444d = Environment.isExternalStorageRemovable();
            } else {
                c0149g.f444d = storageHelper$StorageVolume$Type != StorageHelper$StorageVolume$Type.INTERNAL;
            }
            c0149g.f445e = storageHelper$StorageVolume$Type == StorageHelper$StorageVolume$Type.INTERNAL;
            if (z) {
                arrayList.add(0, c0149g);
            } else {
                arrayList.add(c0149g);
            }
        }
    }
}
