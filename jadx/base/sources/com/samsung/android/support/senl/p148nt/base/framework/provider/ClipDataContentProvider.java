package com.samsung.android.support.senl.p148nt.base.framework.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002JK\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J/\u0010 \u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\"J9\u0010#\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000eH\u0016¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/framework/provider/ClipDataContentProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "attachInfo", "", "context", "Landroid/content/Context;", "info", "Landroid/content/pm/ProviderInfo;", "onCreate", "", "addRoot", "name", "", "root", "Ljava/io/File;", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "isUriOfNoteListToDrag", "getType", "insert", "values", "Landroid/content/ContentValues;", OpenSessionApi.ITEM_LIMIT_DELETE, "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", Constants.ARG_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "openFile", "Landroid/os/ParcelFileDescriptor;", "mode", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nClipDataContentProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClipDataContentProvider.kt\ncom/samsung/android/support/senl/nt/base/framework/provider/ClipDataContentProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,271:1\n1#2:272\n*E\n"})
public final class ClipDataContentProvider extends ContentProvider {

    @Nullable
    private static String AUTHORITY = null;

    @NotNull
    private static final String CONTENTSCHEME = "content://";

    @NotNull
    private static final String MIME_TYPE_UNKNOWN = "application/octet-stream";

    @NotNull
    private static final String TAG = "ClipDataContentProvider";

    @NotNull
    private static final String USERIDPARAM = "@";
    private static final boolean mIsContainedUserId = true;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[] COLUMNS = {"_display_name", "_size"};

    @NotNull
    private static final HashMap<String, File> mRoots = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J-\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ-\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010$\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u000f\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/framework/provider/ClipDataContentProvider$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CONTENTSCHEME", "USERIDPARAM", "MIME_TYPE_UNKNOWN", "COLUMNS", "", "[Ljava/lang/String;", "mIsContainedUserId", "", "AUTHORITY", "mRoots", "Ljava/util/HashMap;", "Ljava/io/File;", "Lkotlin/collections/HashMap;", "setAuthority", "", "authority", "copyOf", ShareApi.ORIGINAL_SIZE_IMAGE, "newLength", "", "([Ljava/lang/String;I)[Ljava/lang/String;", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "getUriForFile", "Landroid/net/Uri;", "file", "getFileForUri", "uri", "isFileExistWithFilePath", "filePath", "getUri", "clipboardPath", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nClipDataContentProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClipDataContentProvider.kt\ncom/samsung/android/support/senl/nt/base/framework/provider/ClipDataContentProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,271:1\n1#2:272\n29#3:273\n*S KotlinDebug\n*F\n+ 1 ClipDataContentProvider.kt\ncom/samsung/android/support/senl/nt/base/framework/provider/ClipDataContentProvider$Companion\n*L\n217#1:273\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String[] copyOf(String[] original, int newLength) {
            String[] strArr = new String[newLength];
            System.arraycopy(original, 0, strArr, 0, newLength);
            return strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            if (encodedPath == null) {
                throw new IllegalArgumentException(AbstractC0541b.m771m("Unable to get EncodedPath for ", uri));
            }
            int iM14128B = StringsKt.m14128B(encodedPath, '/', 1, 4);
            String strSubstring = encodedPath.substring(1, iM14128B);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strDecode = Uri.decode(strSubstring);
            String strSubstring2 = encodedPath.substring(iM14128B + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            String strDecode2 = Uri.decode(strSubstring2);
            Intrinsics.checkNotNullExpressionValue(strDecode2, "decode(...)");
            File file = (File) ClipDataContentProvider.mRoots.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException(AbstractC0541b.m771m("Unable to find configured root for ", uri).toString());
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                Intrinsics.checkNotNullExpressionValue(canonicalFile, "getCanonicalFile(...)");
                String path = canonicalFile.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                String path2 = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
                if (StringsKt.m14145S(path, path2)) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException(AbstractC2322a.m1617g(file2, "Failed to resolve canonical path for "));
            }
        }

        private final Uri getUriForFile(File file) {
            Map.Entry entry;
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.checkNotNullExpressionValue(canonicalPath, "getCanonicalPath(...)");
                Map.Entry entry2 = null;
                loop0: while (true) {
                    entry = entry2;
                    for (Object obj : ClipDataContentProvider.mRoots.entrySet()) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map.Entry<kotlin.String?, java.io.File>");
                        entry2 = (Map.Entry) obj;
                        String path = ((File) entry2.getValue()).getPath();
                        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                        if (!StringsKt.m14145S(canonicalPath, path) || (entry != null && path.length() <= ((File) entry.getValue()).getPath().length())) {
                        }
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException(("Failed to find configured root that contains " + ((Object) canonicalPath)).toString());
                }
                String path2 = ((File) entry.getValue()).getPath();
                Intrinsics.checkNotNull(path2);
                if (StringsKt.m14167w(path2, "/")) {
                    strSubstring = canonicalPath.substring(path2.length());
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                }
                String strM1615e = AbstractC2322a.m1615e(UserHandleCompat.INSTANCE.getInstance().getUserId(0), "@");
                String strM757C = AbstractC0541b.m757C(Uri.encode((String) entry.getKey()), "/", Uri.encode(strSubstring, "/"));
                return Uri.parse("content://" + strM1615e + ClipDataContentProvider.AUTHORITY + "/" + ((Object) strM757C));
            } catch (IOException unused) {
                throw new IllegalArgumentException(AbstractC2322a.m1617g(file, "Failed to resolve canonical path for "));
            }
        }

        private final boolean isFileExistWithFilePath(String filePath) {
            if (!TextUtils.isEmpty(filePath) && AbstractC2322a.m1607A(filePath)) {
                return true;
            }
            AbstractC4539a.m3214x("isFileExistWithFilePath, the path is invalid : ", filePath, ClipDataContentProvider.TAG);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void setAuthority(String authority) {
            ClipDataContentProvider.AUTHORITY = authority;
        }

        @JvmStatic
        @Nullable
        public final Uri getUri(@NotNull String clipboardPath) {
            Intrinsics.checkNotNullParameter(clipboardPath, "clipboardPath");
            if (!isFileExistWithFilePath(clipboardPath)) {
                Logger.m8698e(ClipDataContentProvider.TAG, "getUri, the path is invalid.");
                return null;
            }
            Uri uriForFile = getUriForFile(new File(clipboardPath));
            AbstractC4539a.m3206p("getUri, uri: ", Logger.getEncode(uriForFile.toString()), ClipDataContentProvider.TAG);
            return uriForFile;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object[] copyOf(Object[] original, int newLength) {
            Object[] objArr = new Object[newLength];
            System.arraycopy(original, 0, objArr, 0, newLength);
            return objArr;
        }
    }

    private final void addRoot(String name, File root) {
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        try {
            File canonicalFile = root.getCanonicalFile();
            Intrinsics.checkNotNullExpressionValue(canonicalFile, "getCanonicalFile(...)");
            mRoots.put(name, canonicalFile);
        } catch (IOException e) {
            throw new IllegalArgumentException(AbstractC2322a.m1617g(root, "Failed to resolve canonical path for "), e);
        }
    }

    @JvmStatic
    @Nullable
    public static final Uri getUri(@NotNull String str) {
        return INSTANCE.getUri(str);
    }

    private final boolean isUriOfNoteListToDrag(Uri uri) {
        try {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            int iM14131E = StringsKt.m14131E("/", 0, 6, string);
            String string2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            String strSubstring = string2.substring(iM14131E + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (Intrinsics.areEqual("NotesList.sdocx", strSubstring)) {
                Logger.m8702i(TAG, "isUriOfNoteListToDrag true");
                return true;
            }
        } catch (Exception e) {
            Logger.m8698e(TAG, "isUriOfNoteListToDrag e =" + e);
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NotNull Context context, @NotNull ProviderInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        try {
            Logger.m8697d(TAG, "attachInfo, ProviderInfo info: " + info);
            Companion companion = INSTANCE;
            String authority = info.authority;
            Intrinsics.checkNotNullExpressionValue(authority, "authority");
            companion.setAuthority(authority);
            super.attachInfo(context, info);
        } catch (Exception e) {
            AbstractC4539a.m3214x("attachInfo e: ", e.getMessage(), TAG);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No external delete");
    }

    @Override // android.content.ContentProvider
    @NotNull
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        File fileForUri = INSTANCE.getFileForUri(uri);
        String name = fileForUri.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        int iM14130D = StringsKt.m14130D(name, '.');
        if (iM14130D < 0) {
            return "application/octet-stream";
        }
        String name2 = fileForUri.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        String strSubstring = name2.substring(iM14130D + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(strSubstring);
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        addRoot("notes_clipboard", new File(context.getFilesDir(), Constants.CLIPBOARD_FILE_PREFIX));
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String mode) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (!TextUtils.equals(mode, "r")) {
            AbstractC4539a.m3214x("openFile, need readonly but this mode =", mode, TAG);
            return null;
        }
        if (isUriOfNoteListToDrag(uri)) {
            return null;
        }
        int mode2 = ParcelFileDescriptor.parseMode(mode);
        File fileForUri = INSTANCE.getFileForUri(uri);
        if (!fileForUri.exists()) {
            Logger.m8698e(TAG, "openFile file=" + fileForUri.getAbsolutePath() + " does not exist");
            throw new FileNotFoundException(uri.getPath());
        }
        String callingPackage = getCallingPackage();
        String encode = Logger.getEncode(uri.toString());
        String encode2 = Logger.getEncode(fileForUri.getAbsolutePath());
        StringBuilder sbM16m = AbstractC0000a.m16m("openFile (", callingPackage, ") Uri = ", encode, ", path =");
        sbM16m.append(encode2);
        sbM16m.append(" exists");
        Logger.m8702i(TAG, sbM16m.toString());
        return ParcelFileDescriptor.open(fileForUri, mode2);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int i;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (isUriOfNoteListToDrag(uri)) {
            return null;
        }
        File fileForUri = INSTANCE.getFileForUri(uri);
        if (projection == null) {
            projection = COLUMNS;
        }
        String[] strArr = new String[projection.length];
        Object[] objArr = new Object[projection.length];
        Iterator it = ArrayIteratorKt.iterator(projection);
        int i2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (Intrinsics.areEqual("_display_name", str)) {
                strArr[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileForUri.getName();
            } else if (Intrinsics.areEqual("_size", str)) {
                strArr[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(fileForUri.length());
            }
            i2 = i;
        }
        Companion companion = INSTANCE;
        String[] strArrCopyOf = companion.copyOf(strArr, i2);
        Object[] objArrCopyOf = companion.copyOf(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArrCopyOf, 1);
        matrixCursor.addRow(objArrCopyOf);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No external updates");
    }
}
