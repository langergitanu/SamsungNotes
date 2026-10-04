package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import androidx.annotation.RequiresApi;
import androidx.documentfile.provider.DocumentFile;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/UriUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isUriForm", "", "uri", "saveBitmapToUri", "Landroid/net/Uri;", "contentResolver", "Landroid/content/ContentResolver;", "uuid", "bitmap", "Landroid/graphics/Bitmap;", "deleteUri", "", "printMediaStore", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nUriUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UriUtils.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/util/UriUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,109:1\n1#2:110\n*E\n"})
public final class UriUtils {

    @NotNull
    public static final UriUtils INSTANCE = new UriUtils();

    @NotNull
    private static final String TAG = SOLogger.createTag("UriUtils");

    private UriUtils() {
    }

    @RequiresApi(29)
    public final void deleteUri(@Nullable ContentResolver contentResolver, @Nullable String uri) {
        DocumentFile documentFileFromSingleUri;
        printMediaStore(contentResolver);
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null || (documentFileFromSingleUri = DocumentFile.fromSingleUri(applicationContext, Uri.parse(uri))) == null) {
            return;
        }
        boolean zExists = documentFileFromSingleUri.exists();
        SOLogger sOLogger = SOLogger.INSTANCE;
        sOLogger.SOLoggerD(TAG, "deleteUri# uri/exists" + sOLogger.SOLoggerGetEncord(uri) + "/" + zExists);
        if (!zExists || contentResolver == null) {
            return;
        }
        contentResolver.delete(Uri.parse(uri), null, null);
    }

    public final boolean isUriForm(@Nullable String uri) {
        boolean z = false;
        if (uri != null && StringsKt.m14162r(uri, "//media")) {
            z = true;
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        sOLogger.SOLoggerD(TAG, "isUriForm# uri/result" + sOLogger.SOLoggerGetEncord(uri) + "/" + z);
        return z;
    }

    @RequiresApi(29)
    public final void printMediaStore(@Nullable ContentResolver contentResolver) {
        Cursor cursorQuery;
        if (DeviceInfo.isUserMode()) {
            return;
        }
        String[] strArr = {"_id"};
        StringBuilder sb = new StringBuilder();
        if (contentResolver != null) {
            try {
                cursorQuery = contentResolver.query(MediaStore.Files.getContentUri("external_primary"), strArr, null, null, null);
            } catch (Exception e) {
                AbstractC0000a.m24u("printMediaStore# ", e.getMessage(), SOLogger.INSTANCE, TAG);
            }
        } else {
            cursorQuery = null;
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            if (cursor2 == null) {
                CloseableKt.closeFinally(cursor, null);
                return;
            }
            int columnIndex = cursor2.getColumnIndex("_id");
            while (cursor2.moveToNext()) {
                sb.append(SOLogger.INSTANCE.SOLoggerGetEncord(cursor2.getString(columnIndex)));
                sb.append(SQLKeyword.COMMA);
            }
            SOLogger.INSTANCE.SOLoggerD(TAG, "printMediaStore# lId " + ((Object) sb));
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
            return;
        } finally {
        }
        AbstractC0000a.m24u("printMediaStore# ", e.getMessage(), SOLogger.INSTANCE, TAG);
    }

    @RequiresApi(29)
    @NotNull
    public final Uri saveBitmapToUri(@Nullable ContentResolver contentResolver, @Nullable String uuid, @NotNull Bitmap bitmap) {
        Uri uriInsert;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ContentValues contentValues = new ContentValues();
        if (contentResolver == null || (uriInsert = contentResolver.insert(MediaStore.Files.getContentUri("external_primary"), contentValues)) == null) {
            Uri EMPTY = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            return EMPTY;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uriInsert, "w");
            try {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                        try {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                            CloseableKt.closeFinally(fileOutputStream, null);
                        } finally {
                        }
                    } catch (Exception e) {
                        SOLogger.INSTANCE.SOLoggerE(TAG, "saveBitmapTo# new FileOutputStream:" + e.getMessage());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(parcelFileDescriptorOpenFileDescriptor, null);
            } finally {
            }
        } catch (Exception e2) {
            AbstractC0000a.m24u("saveBitmapTo# openFileDescriptor:", e2.getMessage(), SOLogger.INSTANCE, TAG);
        }
        contentResolver.update(uriInsert, contentValues, null, null);
        SOLogger sOLogger = SOLogger.INSTANCE;
        sOLogger.SOLoggerD(TAG, "saveBitmapToUri# uuid/uri " + sOLogger.SOLoggerGetEncord(uuid) + "/" + uriInsert);
        return uriInsert;
    }
}
