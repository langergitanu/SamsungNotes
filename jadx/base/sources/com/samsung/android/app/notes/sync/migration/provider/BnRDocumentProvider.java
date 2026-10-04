package com.samsung.android.app.notes.sync.migration.provider;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.UriPermission;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.provider.DocumentsContract;
import android.provider.DocumentsProvider;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p001A.AbstractC0000a;
import p079T.AbstractC0299q;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BnRDocumentProvider extends DocumentsProvider {
    public static final String AUTHORITY = "com.samsung.android.app.notes.bnrDocuments";
    private static final String ROOT = "root";
    private static final String TAG = "SS$".concat("BnRDocumentProvider");
    private static final String[] DEFAULT_ROOT_PROJECTION = {"root_id", "flags", "icon", "title", "document_id", "available_bytes"};
    private static final String[] DEFAULT_DOCUMENT_PROJECTION = {"document_id", "mime_type", "_display_name", "last_modified", "flags", "_size"};
    private static File mBaseDir = null;
    private static int URI_PERMISSION_READ_WRITE = 3;
    private static Map<String, Set<Uri>> grantedPermissions = new HashMap();
    private static long totalGrantedTime = 0;

    public static boolean delDir(File file, boolean z, List<String> list) {
        boolean zDelete = false;
        zDelete = false;
        zDelete = false;
        if (file != null && file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                boolean zDelete2 = false;
                for (File file2 : fileArrListFiles) {
                    if (list == null || !list.contains(file2.getName())) {
                        if (file2.isDirectory()) {
                            zDelete2 = delDir(file2, true, list);
                        } else {
                            zDelete2 = file2.delete();
                            String str = TAG;
                            Locale locale = Locale.ENGLISH;
                            AbstractC0299q.m643n(str, AbstractC0541b.m775q("file [", file2.getAbsolutePath(), "] was deleted [", String.valueOf(zDelete2), "]"));
                        }
                    }
                }
                zDelete = zDelete2;
            }
            if (z) {
                zDelete = file.delete();
            }
            AbstractC0299q.m643n(TAG, String.format(Locale.ENGLISH, "delDir ret[%b], name[%s], delOwn[%b]", Boolean.valueOf(zDelete), file, Boolean.valueOf(z)));
        }
        return zDelete;
    }

    private static synchronized File getBaseDir(Context context) {
        File parentFile;
        try {
            if (mBaseDir == null && (parentFile = context.getFilesDir().getParentFile()) != null) {
                mBaseDir = new File(parentFile.toString());
            }
        } catch (Throwable th) {
            throw th;
        }
        return mBaseDir;
    }

    private static int getCallingOrSelfUriPermissionModeFlags(Context context, Uri uri) {
        int i = context.checkCallingOrSelfUriPermission(uri, 1) != 0 ? 0 : 1;
        if (context.checkCallingOrSelfUriPermission(uri, 2) == 0) {
            i |= 2;
        }
        return context.checkCallingOrSelfUriPermission(uri, 65) == 0 ? i | 64 : i;
    }

    public static String getDocIdForFile(Context context, File file) throws FileNotFoundException {
        File parentFile = context.getFilesDir().getParentFile();
        if (parentFile == null) {
            throw new FileNotFoundException("getDocIdForFile, parentFile is null!");
        }
        File file2 = new File(parentFile.getAbsolutePath());
        if (!file2.exists()) {
            throw new FileNotFoundException("getDocIdForFile, baseDir does not exist!");
        }
        String path = file2.getPath();
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.indexOf(path) < 0) {
            throw new FileNotFoundException(AbstractC0541b.m775q("[", absolutePath, "] is not in rootPath[", path, "]"));
        }
        String strM772n = AbstractC0541b.m772n("root:", path.equals(absolutePath) ? "" : path.endsWith("/") ? absolutePath.substring(path.length()) : absolutePath.substring(path.length() + 1));
        AbstractC0299q.m603M(TAG, String.format(Locale.ENGLISH, "getDocIdForFile path[%s], docId[%s]", file, strM772n));
        return strM772n;
    }

    private Uri getDocumentUri(String str, List<UriPermission> list) throws FileNotFoundException {
        boolean zIsChildDocument;
        String docIdForFile = getDocIdForFile(getContext(), new File(str));
        UriPermission uriPermission = null;
        UriPermission uriPermission2 = null;
        for (UriPermission uriPermission3 : list) {
            Uri uri = uriPermission3.getUri();
            if (AUTHORITY.equals(uri.getAuthority())) {
                if (DocumentsContract.isTreeUri(uri)) {
                    zIsChildDocument = isChildDocument(DocumentsContract.getTreeDocumentId(uri), docIdForFile);
                    if (zIsChildDocument) {
                        uriPermission2 = uriPermission3;
                    }
                } else if (Objects.equals(docIdForFile, DocumentsContract.getDocumentId(uri))) {
                    zIsChildDocument = true;
                    uriPermission = uriPermission3;
                } else {
                    zIsChildDocument = false;
                }
                if (zIsChildDocument) {
                    break;
                }
            }
        }
        if (uriPermission2 != null) {
            return DocumentsContract.buildDocumentUriUsingTree(uriPermission2.getUri(), docIdForFile);
        }
        if (uriPermission != null) {
            return uriPermission.getUri();
        }
        throw new SecurityException("The app is not given any access to the document under path " + str + " with permissions granted in " + list);
    }

    private File getFileForDocId(String str) throws FileNotFoundException {
        File baseDir = getBaseDir(getContext());
        if (str.equals(ROOT)) {
            return baseDir;
        }
        int iIndexOf = str.indexOf(58, 1);
        if (iIndexOf < 0) {
            throw new FileNotFoundException("Missing root for ".concat(str));
        }
        File file = new File(baseDir, str.substring(iIndexOf + 1));
        if (file.exists()) {
            return file;
        }
        throw new FileNotFoundException("Missing file for " + str + " at " + file);
    }

    public static String getFileName(String str) {
        return getFileName(str, false);
    }

    public static Uri getGrantedSingleDocumentUri(@NonNull Context context, @NonNull File file, String str) {
        Uri uriBuildDocumentUri = null;
        try {
            uriBuildDocumentUri = DocumentsContract.buildDocumentUri(AUTHORITY, getDocIdForFile(context, file));
            grantUriPermission(context, str, uriBuildDocumentUri);
            return uriBuildDocumentUri;
        } catch (Exception e) {
            AbstractC0299q.m643n(TAG, "getGrantedSingleDocumentUri " + e.getMessage());
            return uriBuildDocumentUri;
        }
    }

    private static String getTypeForFile(File file) {
        return file.isDirectory() ? "vnd.android.document/directory" : getTypeForName(file.getName());
    }

    private static String getTypeForName(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    public static synchronized int grantUriPermission(@NonNull Context context, @NonNull String str, @NonNull Uri uri) {
        return grantUriPermission(context, str, uri, URI_PERMISSION_READ_WRITE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void includeFile(MatrixCursor matrixCursor, String str, File file) throws FileNotFoundException {
        int i;
        if (str == null) {
            str = getDocIdForFile(getContext(), file);
        } else {
            file = getFileForDocId(str);
        }
        if (file.isDirectory()) {
            i = (file.isDirectory() && file.canWrite()) ? 8 : 0;
        } else if (file.canWrite()) {
            i = 6;
        }
        String name = file.getName();
        String typeForFile = getTypeForFile(file);
        if (typeForFile.startsWith(Constants.MIME_IMAGE_START)) {
            i |= 1;
        }
        MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
        rowBuilderNewRow.add("document_id", str);
        rowBuilderNewRow.add("_display_name", name);
        rowBuilderNewRow.add("_size", Long.valueOf(file.length()));
        rowBuilderNewRow.add("mime_type", typeForFile);
        rowBuilderNewRow.add("last_modified", Long.valueOf(file.lastModified()));
        rowBuilderNewRow.add("flags", Integer.valueOf(i));
    }

    private static synchronized boolean isGrantedPackage(@NonNull String str) {
        return grantedPermissions.containsKey(str);
    }

    private static String[] resolveDocumentProjection(String[] strArr) {
        return strArr != null ? strArr : DEFAULT_DOCUMENT_PROJECTION;
    }

    private static String[] resolveRootProjection(String[] strArr) {
        return strArr != null ? strArr : DEFAULT_ROOT_PROJECTION;
    }

    @Override // android.provider.DocumentsProvider, android.content.ContentProvider
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        String str3 = TAG;
        Locale locale = Locale.ENGLISH;
        String string = bundle != null ? bundle.toString() : "";
        StringBuilder sbM16m = AbstractC0000a.m16m("call method [", str, "] arg[", str2, "] extars[");
        sbM16m.append(string);
        sbM16m.append("]");
        AbstractC0299q.m643n(str3, sbM16m.toString());
        if (AbstractC14517a.f10348c == null) {
            AbstractC0299q.m603M(str3, "getContextWrapper is null, setContextWrapper");
            AbstractC14517a.f10348c = new ContextWrapper(getContext());
        }
        if (!"getDocumentId".equals(str) || bundle == null) {
            return super.call(str, str2, bundle);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("com.samsung.android.app.notes.bnrDocuments.extra.uriPermissions");
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("uri", getDocumentUri(str2, parcelableArrayList));
            return bundle2;
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(AbstractC0541b.m773o("File in ", str2, " is not found."), e);
        }
    }

    @Override // android.provider.DocumentsProvider
    public String createDocument(String str, String str2, String str3) throws FileNotFoundException {
        Uri uriBuildDocumentUri = DocumentsContract.buildDocumentUri(AUTHORITY, str);
        File file = new File(getFileForDocId(str).getPath(), str3);
        try {
            if ("vnd.android.document/directory".equals(str2)) {
                file.mkdirs();
            } else {
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
            }
            String docIdForFile = getDocIdForFile(getContext(), file);
            Uri uriBuildDocumentUri2 = DocumentsContract.buildDocumentUri(AUTHORITY, docIdForFile);
            String callingPackage = getCallingPackage();
            int callingOrSelfUriPermissionModeFlags = getCallingOrSelfUriPermissionModeFlags(getContext(), uriBuildDocumentUri);
            if ("com.samsung.android.scloud".equals(callingPackage) || "com.sec.android.easyMover".equals(callingPackage)) {
                grantUriPermission(getContext(), callingPackage, uriBuildDocumentUri2, callingOrSelfUriPermissionModeFlags);
                AbstractC0299q.m603M(TAG, String.format(Locale.ENGLISH, "createDocument grant permission caller[%s], parent[%s], new[%s], flag[%d]", callingPackage, uriBuildDocumentUri, uriBuildDocumentUri2, Integer.valueOf(callingOrSelfUriPermissionModeFlags)));
            }
            String str4 = TAG;
            Locale locale = Locale.ENGLISH;
            AbstractC0299q.m643n(str4, "createDocument ret [" + docIdForFile + "]");
            return docIdForFile;
        } catch (IOException unused) {
            throw new FileNotFoundException(AbstractC0541b.m774p("Failed to create document with name ", str3, " and documentId ", str));
        }
    }

    @Override // android.provider.DocumentsProvider
    public void deleteDocument(String str) throws FileNotFoundException {
        String str2 = TAG;
        AbstractC0299q.m643n(str2, "deleteDocument");
        if (!delDir(getFileForDocId(str), true, null)) {
            throw new FileNotFoundException(AbstractC0541b.m772n("Failed to delete document with id ", str));
        }
        AbstractC0299q.m603M(str2, "deleteDocument file with id " + str);
    }

    @Override // android.provider.DocumentsProvider
    public String getDocumentType(String str) {
        return getTypeForFile(getFileForDocId(str));
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        AbstractC0299q.m603M(TAG, "onCreate");
        return true;
    }

    @Override // android.provider.DocumentsProvider
    public ParcelFileDescriptor openDocument(String str, String str2, CancellationSignal cancellationSignal) {
        return ParcelFileDescriptor.open(getFileForDocId(str), ParcelFileDescriptor.parseMode(str2));
    }

    @Override // android.provider.DocumentsProvider
    public Cursor queryChildDocuments(String str, String[] strArr, String str2) throws FileNotFoundException {
        AbstractC0299q.m643n(TAG, "queryChildDocuments, parentDocumentId: " + str + " sortOrder: " + str2);
        MatrixCursor matrixCursor = new MatrixCursor(resolveDocumentProjection(strArr));
        File[] fileArrListFiles = getFileForDocId(str).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                includeFile(matrixCursor, null, file);
            }
        }
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public Cursor queryDocument(String str, String[] strArr) throws FileNotFoundException {
        AbstractC0299q.m643n(TAG, "queryDocument : " + str);
        MatrixCursor matrixCursor = new MatrixCursor(resolveDocumentProjection(strArr));
        includeFile(matrixCursor, str, null);
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public Cursor queryRoots(String[] strArr) {
        String str = TAG;
        AbstractC0299q.m603M(str, "queryRoots");
        String callingPackage = getCallingPackage();
        if (!isGrantedPackage(callingPackage)) {
            AbstractC0299q.m603M(str, "queryRoots is not granted package: " + callingPackage);
            return null;
        }
        File baseDir = getBaseDir(getContext());
        MatrixCursor matrixCursor = new MatrixCursor(resolveRootProjection(strArr));
        MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
        rowBuilderNewRow.add("root_id", ROOT);
        rowBuilderNewRow.add("flags", 13);
        rowBuilderNewRow.add("title", "com.samsung.android.app.notes");
        rowBuilderNewRow.add("document_id", getDocIdForFile(getContext(), baseDir));
        rowBuilderNewRow.add("available_bytes", Long.valueOf(baseDir.getFreeSpace()));
        return matrixCursor;
    }

    public static String getFileName(String str, boolean z) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String name = new File(str).getName();
        return !TextUtils.isEmpty(name) ? (!z || (iLastIndexOf = name.lastIndexOf(Extension.DOT)) <= 0) ? name : name.substring(0, iLastIndexOf) : "";
    }

    public static synchronized int grantUriPermission(@NonNull Context context, @NonNull String str, @NonNull Uri uri, int i) {
        return grantUriPermission(context, str, new Uri[]{uri}, i);
    }

    public static synchronized int grantUriPermission(@NonNull Context context, @NonNull String str, @NonNull Uri[] uriArr, int i) {
        int i2;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Set<Uri> hashSet = grantedPermissions.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                grantedPermissions.put(str, hashSet);
            }
            i2 = 0;
            for (Uri uri : uriArr) {
                hashSet.add(uri);
                context.grantUriPermission(str, uri, i);
                AbstractC0299q.m643n(TAG, String.format(Locale.ENGLISH, "grantUriPermission toPackage[%s] uri[%s]", str, uri));
                i2++;
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            totalGrantedTime += jElapsedRealtime2;
            String str2 = TAG;
            Locale locale = Locale.ENGLISH;
            AbstractC0299q.m603M(str2, "grantUriPermission toPackage[" + str + "], [" + i2 + "] uri granted [" + jElapsedRealtime2 + " / " + totalGrantedTime + "]");
        } catch (Throwable th) {
            throw th;
        }
        return i2;
    }
}
