package p042J1;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.utils.StorageHelper$StorageVolume$Type;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p086V.C0322h;

/* JADX INFO: renamed from: J1.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0155m {

    /* JADX INFO: renamed from: a */
    public static final byte[] f474a = {80, 75, 3, 4, 20, 0, CtapException.ERR_VENDOR_FIRST, 0};

    /* JADX INFO: renamed from: b */
    public static final byte[] f475b = {80, 75, 3, 4, 20, 0, CtapException.ERR_EXTENSION_FIRST, 0};

    /* JADX INFO: renamed from: c */
    public static final byte[] f476c = {80, 75, 3, 4};

    /* JADX INFO: renamed from: d */
    public static String f477d = null;

    /* JADX INFO: renamed from: e */
    public static String f478e = null;

    /* JADX INFO: renamed from: a */
    public static boolean m386a(String str) throws SyncException {
        File file = new File(str);
        if (!file.exists()) {
            throw new SyncException(312, AbstractC0541b.m772n("canUpload() : There is no file - ", str));
        }
        long length = file.length();
        Debugger.m8607d("SyncUtils", "canUpload() : size = " + length);
        return length / 1073741824 < 1;
    }

    /* JADX INFO: renamed from: b */
    public static String m387b(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        if (str.endsWith("/")) {
            sb.append(str2);
        } else {
            sb.append('/');
            sb.append(str2);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: c */
    public static void m388c(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        Debugger.m8609e("SyncUtils", e.getMessage());
                    }
                }
            }
            fileInputStream.close();
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                Debugger.m8609e("SyncUtils", e2.getMessage());
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    Debugger.m8609e("SyncUtils", e3.getMessage());
                }
            }
            if (fileOutputStream == null) {
                throw th;
            }
            try {
                fileOutputStream.close();
                throw th;
            } catch (IOException e5) {
                Debugger.m8609e("SyncUtils", e5.getMessage());
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m389d(File file) {
        try {
            FileUtils.deleteFile(file);
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("deleteRecursive - "), "SyncUtils");
        }
    }

    /* JADX INFO: renamed from: e */
    public static String m390e(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncUtils", "getExternalFilesDirInfo() : context is null)");
            return null;
        }
        if (f477d == null) {
            try {
                String absolutePath = context.getExternalFilesDir(null).getAbsolutePath();
                f477d = absolutePath;
                if (absolutePath != null && absolutePath.isEmpty()) {
                    Debugger.m8609e("SyncUtils", "getExternalFilesDirInfo() : externalFilesDir is empty! ");
                    f477d = null;
                }
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("getExternalFilesDirInfo() : "), "SyncUtils");
                return null;
            }
        }
        return f477d;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File m391f() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        StringBuilder sb;
        boolean z;
        boolean z2;
        C0149g c0149g;
        String path;
        File file;
        String str;
        StorageHelper$StorageVolume$Type storageHelper$StorageVolume$Type = StorageHelper$StorageVolume$Type.EXTERNAL;
        HashMap map = new HashMap();
        String str2 = C0150h.f447a;
        if (!str2.equals(File.separator)) {
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/mounts"), StandardCharsets.UTF_8));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line != null) {
                                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                                String strNextToken = stringTokenizer.nextToken();
                                String[] strArr = C0150h.f448b;
                                int length = strArr.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        z = false;
                                        break;
                                    }
                                    if (strArr[i].equals(strNextToken)) {
                                        z = true;
                                        break;
                                    }
                                    i++;
                                }
                                if (!z && CommonUtils.isCurrentUserStorageDevice(strNextToken)) {
                                    String strNextToken2 = stringTokenizer.nextToken();
                                    if (strNextToken2.startsWith(str2) && !C0150h.m368a(strNextToken2, C0150h.f449c)) {
                                        String strNextToken3 = stringTokenizer.nextToken();
                                        String[] strArr2 = C0150h.f450d;
                                        int length2 = strArr2.length;
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= length2) {
                                                z2 = false;
                                                break;
                                            }
                                            if (strArr2[i2].equals(strNextToken3)) {
                                                z2 = true;
                                                break;
                                            }
                                            i2++;
                                        }
                                        if (!z2) {
                                            File file2 = new File(strNextToken2);
                                            if (file2.canRead() && file2.canExecute()) {
                                                List arrayList = (List) map.get(strNextToken);
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList(3);
                                                    map.put(strNextToken, arrayList);
                                                }
                                                C0149g c0149g2 = new C0149g(file2, strNextToken3);
                                                StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), ",");
                                                while (true) {
                                                    if (!stringTokenizer2.hasMoreTokens()) {
                                                        break;
                                                    }
                                                    String strNextToken4 = stringTokenizer2.nextToken();
                                                    if (InternalZipConstants.WRITE_MODE.equals(strNextToken4)) {
                                                        c0149g2.f443c = false;
                                                        break;
                                                    }
                                                    if ("ro".equals(strNextToken4)) {
                                                        c0149g2.f443c = true;
                                                        break;
                                                    }
                                                }
                                                arrayList.add(c0149g2);
                                            }
                                        }
                                    }
                                }
                            } else {
                                try {
                                    break;
                                } catch (IOException e) {
                                    e = e;
                                    sb = new StringBuilder("getStorages : ");
                                    sb.append(e.toString());
                                    Debugger.m8609e("StorageHelper", sb.toString());
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            Log.e("StorageHelper", "getStorages", e);
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    e = e3;
                                    sb = new StringBuilder("getStorages : ");
                                    sb.append(e.toString());
                                    Debugger.m8609e("StorageHelper", sb.toString());
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (IOException e5) {
                            Debugger.m8609e("StorageHelper", "getStorages : " + e5.toString());
                            throw th;
                        }
                    }
                }
                bufferedReader2.close();
            } catch (IOException e6) {
                e = e6;
                bufferedReader2 = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                }
            }
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            List list = (List) ((Map.Entry) it.next()).getValue();
            if (list.size() == 1) {
                C0149g c0149g3 = (C0149g) list.get(0);
                boolean zEquals = c0149g3.f441a.equals(externalStorageDirectory);
                z3 |= zEquals;
                C0150h.m369b(arrayList2, c0149g3, zEquals);
            } else {
                int size = list.size();
                int i4 = 0;
                while (true) {
                    if (i4 < size) {
                        C0149g c0149g4 = (C0149g) list.get(i4);
                        if (c0149g4.f441a.equals(externalStorageDirectory)) {
                            C0150h.m369b(arrayList2, c0149g4, true);
                            z3 = true;
                            break;
                        }
                        if (i4 == size - 1) {
                            C0150h.m369b(arrayList2, c0149g4, false);
                        }
                        i4++;
                    }
                }
            }
        }
        if (!z3) {
            C0149g c0149g5 = new C0149g(externalStorageDirectory, "UNKNOWN");
            boolean zIsExternalStorageEmulated = Environment.isExternalStorageEmulated();
            c0149g5.f445e = zIsExternalStorageEmulated;
            c0149g5.f446f = zIsExternalStorageEmulated ? StorageHelper$StorageVolume$Type.INTERNAL : StorageHelper$StorageVolume$Type.EXTERNAL;
            c0149g5.f444d = Environment.isExternalStorageRemovable();
            c0149g5.f443c = Environment.getExternalStorageState().equals("mounted_ro");
            arrayList2.add(0, c0149g5);
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                c0149g = null;
                break;
            }
            c0149g = (C0149g) it2.next();
            StorageHelper$StorageVolume$Type storageHelper$StorageVolume$Type2 = c0149g.f446f;
            File file3 = c0149g.f441a;
            if (storageHelper$StorageVolume$Type2 == storageHelper$StorageVolume$Type && file3 != null && file3.exists() && file3.list() != null) {
                break;
            }
        }
        if (c0149g != null) {
            path = c0149g.f441a.getPath();
        } else {
            path = System.getenv("SECONDARY_STORAGE");
            if (path == null || path.isEmpty()) {
                path = "/storage/extSdCard";
            }
        }
        if (path != null) {
            file = new File(path);
            if (!file.exists() || file.list() == null) {
                file = null;
            }
        }
        if (file != null) {
            Debugger.m8615i("SyncUtils", "external sd card 0 : " + file.getPath());
            return file;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Debugger.m8607d("SyncUtils", "try storage volume list");
            for (StorageVolume storageVolume : ((StorageManager) C0322h.m670a().f815a.getAppContext().getSystemService(StorageManager.class)).getStorageVolumes()) {
                if (storageVolume.isRemovable()) {
                    try {
                        str = (String) StorageVolume.class.getMethod("getPath", null).invoke(storageVolume, null);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e7) {
                        Debugger.m8609e("SyncUtils", "getPath - " + e7.getMessage());
                        str = null;
                    }
                    File file4 = new File(str);
                    if (file4.exists() && file4.list() != null) {
                        Debugger.m8615i("SyncUtils", "external storage : " + file4.getPath());
                        return file4;
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return null;
        }
        HashSet<String> hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        try {
            Process processStart = new ProcessBuilder(new String[0]).command("mount").redirectErrorStream(true).start();
            processStart.waitFor();
            try {
                InputStream inputStream = processStart.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (inputStream.read(bArr) != -1) {
                        sb2.append(new String(bArr, StandardCharsets.UTF_8));
                    }
                    inputStream.close();
                } finally {
                }
            } catch (IOException e8) {
                Debugger.m8609e("GetExternalMounts", "getExternalMounts(), input streaming : " + e8.toString());
            }
        } catch (Exception e9) {
            AbstractC4539a.m3213w(e9, new StringBuilder("getExternalMounts() : "), "GetExternalMounts");
        }
        String[] strArrSplit = sb2.toString().split("\n");
        for (String str3 : strArrSplit) {
            String[] strArrSplit2 = str3.split(" ");
            if (strArrSplit2.length > 2 && strArrSplit2[0].startsWith("/mnt/media_rw/")) {
                if (strArrSplit2[1].startsWith("/storage/")) {
                    Debugger.m8615i("SyncUtils", "get the removable storage!");
                    hashSet.add(strArrSplit2[1]);
                }
            }
        }
        for (String str4 : hashSet) {
            File file5 = new File("/storage" + str4.substring(str4.lastIndexOf(47)));
            if (file5.exists() && file5.isDirectory()) {
                Debugger.m8615i("SyncUtils", "external sd card 1 : " + file5.getPath());
                return file5;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public static String m392g(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncUtils", "getFilesDirInfo() : context is null)");
            return null;
        }
        if (f478e == null) {
            try {
                String absolutePath = context.getFilesDir().getAbsolutePath();
                f478e = absolutePath;
                if (absolutePath != null && absolutePath.isEmpty()) {
                    Debugger.m8609e("SyncUtils", "getFilesDirInfo() : filesDir is empty! ");
                    f478e = null;
                }
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("getFilesDirInfo() : "), "SyncUtils");
                return null;
            }
        }
        return f478e;
    }

    /* JADX INFO: renamed from: h */
    public static JSONObject m393h(String str) throws Throwable {
        IOException iOException;
        Throwable th;
        String string;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e) {
            iOException = e;
        }
        try {
            FileChannel channel = fileInputStream.getChannel();
            string = Charset.defaultCharset().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size())).toString();
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                Debugger.m8609e("SyncUtils", e2.getMessage());
            }
        } catch (IOException e3) {
            iOException = e3;
            fileInputStream2 = fileInputStream;
            Debugger.m8609e("SyncUtils", iOException.getMessage());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    Debugger.m8609e("SyncUtils", e5.getMessage());
                }
            }
            string = "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                throw th;
            }
            try {
                fileInputStream2.close();
                throw th;
            } catch (IOException e6) {
                Debugger.m8609e("SyncUtils", e6.getMessage());
                throw th;
            }
        }
        return new JSONObject(string);
    }

    /* JADX INFO: renamed from: i */
    public static JSONObject m394i(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader;
        StringBuilder sb;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            try {
                sb = new StringBuilder();
            } finally {
            }
        } catch (JSONException e) {
            Debugger.m8609e("SyncUtils", e.getMessage());
            return null;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                JSONObject jSONObject = new JSONObject(sb.toString());
                bufferedReader.close();
                return jSONObject;
            }
            sb.append(line);
            sb.append('\n');
            Debugger.m8609e("SyncUtils", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    public static ArrayList m395j(ArrayList arrayList) throws Throwable {
        String strSubstring;
        ImportItem importItem;
        boolean zIsSnbAlreadyConverted;
        ImportItem importItem2;
        Object objCreateSPDConverter = C0322h.m670a().f823i.createSPDConverter();
        Object objCreateSNBConverter = C0322h.m670a().f823i.createSNBConverter();
        String lowerCase = Environment.getExternalStorageDirectory().getAbsolutePath().toLowerCase(Locale.getDefault());
        File fileM391f = m391f();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!str.isEmpty()) {
                int iLastIndexOf = str.lastIndexOf(47);
                String strSubstring2 = str.substring(iLastIndexOf + 1);
                String strSubstring3 = str.substring(0, iLastIndexOf);
                if (str.toLowerCase().endsWith("spd") || str.toLowerCase().endsWith("snb") || str.toLowerCase().endsWith("snbak")) {
                    File file = new File(str);
                    int i = 101;
                    if (strSubstring3.toLowerCase(Locale.getDefault()).startsWith(lowerCase)) {
                        strSubstring = strSubstring3.concat("/").substring(lowerCase.length() + strSubstring3.toLowerCase(Locale.getDefault()).indexOf(lowerCase) + 1);
                    } else if (fileM391f != null) {
                        String lowerCase2 = fileM391f.getAbsolutePath().toLowerCase(Locale.getDefault());
                        strSubstring = strSubstring3.concat("/").substring(lowerCase2.length() + strSubstring3.toLowerCase(Locale.getDefault()).indexOf(lowerCase2) + 1);
                        i = 103;
                    } else {
                        strSubstring = "";
                    }
                    int i2 = i;
                    if (str.toLowerCase().endsWith("spd")) {
                        zIsSnbAlreadyConverted = C0322h.m670a().f823i.isSpdAlreadyConverted(objCreateSPDConverter, str);
                        importItem = new ImportItem(20, strSubstring, strSubstring2, C0322h.m670a().f823i.getSpdLastModifiedTime(objCreateSPDConverter, str), str, zIsSnbAlreadyConverted);
                    } else if (str.toLowerCase().endsWith("snb")) {
                        zIsSnbAlreadyConverted = C0322h.m670a().f823i.isSnbAlreadyConverted(objCreateSNBConverter, str);
                        importItem = new ImportItem(20, strSubstring, strSubstring2, file.lastModified(), str, zIsSnbAlreadyConverted);
                    } else {
                        zIsSnbAlreadyConverted = false;
                        importItem = new ImportItem(31, strSubstring, strSubstring2, file.lastModified(), str, false);
                    }
                    importItem2 = importItem;
                    if (zIsSnbAlreadyConverted) {
                        AbstractC4539a.m3215y("isAlreadyConverted : ", "SyncUtils", zIsSnbAlreadyConverted);
                    }
                    importItem2.setLocationType(i2);
                    importItem2.setLocalFullPath(str);
                } else {
                    importItem2 = null;
                }
                if (importItem2 != null) {
                    arrayList2.add(importItem2);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: k */
    public static String m396k(Context context, long j) {
        Date date = new Date(j);
        return DateFormat.getDateFormat(context.getApplicationContext()).format(date) + " " + DateFormat.getTimeFormat(context.getApplicationContext()).format(date);
    }

    /* JADX INFO: renamed from: l */
    public static String m397l(String str) {
        String strM756B = AbstractC0541b.m756B(str, ".temp/");
        File file = new File(strM756B);
        if (file.exists() || file.mkdirs()) {
            return strM756B;
        }
        Debugger.m8609e("SyncUtils", "no .temp Directory");
        return null;
    }

    /* JADX INFO: renamed from: m */
    public static String m398m(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath(), "sync");
        if (!file.exists() && !file.mkdirs()) {
            Debugger.m8609e("SyncUtils", "sync folder was not created!");
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: renamed from: n */
    public static String m399n(Context context) {
        return PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(context);
    }

    /* JADX INFO: renamed from: o */
    public static String m400o(String str) {
        int iIndexOf = str.indexOf("_lc");
        return iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
    }

    /* JADX INFO: renamed from: p */
    public static boolean m401p() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocksLong = (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1048576;
        return Build.VERSION.SDK_INT >= 33 ? availableBlocksLong > 500 : availableBlocksLong > 100;
    }

    /* JADX INFO: renamed from: q */
    public static boolean m402q() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1048576 > 500;
    }

    /* JADX INFO: renamed from: r */
    public static boolean m403r(byte[] bArr, byte[] bArr2) {
        if (bArr2.length >= bArr.length) {
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                if (bArr[i] == bArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: s */
    public static boolean m404s(Context context) {
        String currentTaskPacakageName = C0322h.m670a().f815a.getCurrentTaskPacakageName(context);
        return TextUtils.isEmpty(currentTaskPacakageName) || !C0145c.m330o().equalsIgnoreCase(currentTaskPacakageName);
    }
}
