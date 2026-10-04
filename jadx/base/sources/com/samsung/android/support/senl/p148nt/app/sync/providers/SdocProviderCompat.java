package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.app.provider.helper.OldFinderSearchHelper;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.external.ExternalDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.OldDocumentThumbnailUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SdocProviderCompat extends ContentProvider {
    private static final String TAG = "SdocProviderCompat";

    private ParcelFileDescriptor getEmptyThumbnailParcelFileDescriptor() throws FileNotFoundException {
        Context context = getContext();
        if (context == null) {
            throw new FileNotFoundException("context is null");
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            throw new FileNotFoundException("cacheDir is null");
        }
        String strM1170p = AbstractC0622a.m1170p(File.separator, "emptyThumbnailForFinder.png", AbstractC1974b.m1324q(cacheDir.getAbsolutePath()));
        if (!AbstractC2322a.m1607A(strM1170p)) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(0);
            if (!ImageUtils.make(bitmapCreateBitmap, new File(strM1170p), 100, Bitmap.CompressFormat.PNG)) {
                throw new FileNotFoundException("empty thumbnail create failed");
            }
        }
        return ParcelFileDescriptor.open(new File(strM1170p), 268435456);
    }

    private Cursor queryNoteData(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return new ExternalDataRepository(NotesDatabaseManager.getInstance()).getDocumentData(strArr, uri.getQueryParameter("docUUID"), str, strArr2, str2);
    }

    private Cursor queryTagboardSdocData(Context context, String str, String[] strArr, String str2) {
        Logger.m8697d(TAG, "URI_TAGBOARD_SDOC_DATA_ID");
        return new SDocTagBoardProvider(context).getSdocDataForTagboard(str, strArr, str2);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        Logger.m8697d(TAG, "call method : " + str);
        str.getClass();
        switch (str) {
            case "getInAppSearchIntent":
                Context context = getContext();
                if (context == null) {
                    return null;
                }
                String packageName = context.getPackageName();
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEARCH");
                intent.setPackage(packageName);
                intent.setClassName(packageName, packageName + ".memolist.MemoListActivity");
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(ExternalDataConstants.Key.IN_APP_SEARCH_INTENT, intent);
                return bundle2;
            case "get_embedding_config":
                return ExternalDataUtils.getEmbeddingConfigBundle();
            case "get_selection_fields":
                return ExternalDataUtils.getSelectionFields();
            case "get_default_query_args":
                return ExternalDataUtils.getDefaultQueryArgs();
            default:
                return super.call(str, str2, bundle);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (getContext() == null) {
            Logger.m8703w(TAG, "dump, context is null");
            return;
        }
        DataUtils.setContext(getContext().getApplicationContext());
        try {
            SDocProviderDump.dump(getContext(), printWriter);
        } catch (Exception e) {
            Logger.m8698e(TAG, "Failed to dump : " + e.getMessage());
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        int i;
        String exportThumbnailPath = null;
        if (getContext() == null) {
            return null;
        }
        int iMatchID = DocProviderMatchUtil.matchID(uri);
        Logger.m8697d(TAG, "openFile match : " + iMatchID);
        String lastPathSegment = uri.getLastPathSegment();
        int i2 = 0;
        switch (iMatchID) {
            case 300:
                i = 0;
                break;
            case 301:
                i = 1;
                break;
            case 302:
                i = 2;
                break;
            default:
                throw new FileNotFoundException(AbstractC0541b.m771m("Invalid URI: ", uri));
        }
        MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(getContext()).createMainListDocumentDataRepository();
        if (lastPathSegment == null || ExternalDataConstants.URI_PATH_FINDER_THUMBNAIL.equals(lastPathSegment)) {
            throw new FileNotFoundException(AbstractC0541b.m771m("Invalid URI: ", uri));
        }
        MainListDocumentData mainListDocumentData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(lastPathSegment);
        if (mainListDocumentData == null) {
            throw new FileNotFoundException(AbstractC0541b.m771m("Invalid URI: ", uri));
        }
        if (mainListDocumentData.isSDoc()) {
            int iIntValue = (!TextUtils.isEmpty(mainListDocumentData.getContent()) ? mainListDocumentData.getSecondContentType() : mainListDocumentData.getFirstContentType()).intValue();
            if (3 == iIntValue) {
                exportThumbnailPath = OldDocumentThumbnailUtils.getHWThumbnailFilePath(getContext(), mainListDocumentData.getStrokeUuid(), DataConstants.GRID_POSTFIX);
            } else if (iIntValue != 0) {
                exportThumbnailPath = OldDocumentThumbnailUtils.getThumbnailFilePath(getContext(), mainListDocumentData.getContentUuid());
            }
        } else {
            exportThumbnailPath = PageCacheUtils.getExportThumbnailPath(getContext(), lastPathSegment, i);
        }
        if (TextUtils.isEmpty(exportThumbnailPath)) {
            if (i == 2) {
                return getEmptyThumbnailParcelFileDescriptor();
            }
            throw new FileNotFoundException(AbstractC0541b.m771m("Invalid URI: ", uri));
        }
        File file = new File(exportThumbnailPath);
        if (!file.exists()) {
            throw new FileNotFoundException("getPrivateFile failed ".concat(lastPathSegment));
        }
        if (str.isEmpty()) {
            str = "r";
        }
        if (str.contains("w")) {
            if (!file.exists()) {
                try {
                    if (file.getParentFile() != null && !file.getParentFile().mkdirs()) {
                        Logger.m8702i(TAG, "openFile() mkdirs fail");
                    }
                    if (!file.createNewFile()) {
                        Logger.m8702i(TAG, "openFile() createNewFile fail");
                    }
                } catch (IOException e) {
                    Logger.m8699e(TAG, "openFile()" + uri, e);
                    throw new FileNotFoundException(AbstractC0541b.m771m("can't create file for ", uri));
                }
            }
            i2 = 536870912;
        }
        if (str.contains("r")) {
            i2 |= 268435456;
        }
        if (str.contains(Marker.ANY_NON_NULL_MARKER)) {
            i2 |= 33554432;
        }
        return ParcelFileDescriptor.open(file, i2);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        if (getContext() == null) {
            Logger.m8697d(TAG, "query, context is null");
            return null;
        }
        int iMatchID = DocProviderMatchUtil.matchID(uri);
        AbstractC4539a.m3203m(iMatchID, "query matchId : ", TAG);
        if (iMatchID == -1) {
            return null;
        }
        DataUtils.setContext(getContext().getApplicationContext());
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorQueryNoteData = iMatchID != 19 ? iMatchID != 201 ? iMatchID == 400 ? queryNoteData(uri, strArr, str, strArr2, str2) : null : queryTagboardSdocData(getContext(), str, strArr2, str2) : new OldFinderSearchHelper().search(getContext(), uri, strArr2);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sbM1323p = AbstractC1974b.m1323p(cursorQueryNoteData == null ? 0L : cursorQueryNoteData.getCount(), "query, result: ", ", execution time: ");
        sbM1323p.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
        sbM1323p.append(", limit : 8000");
        Logger.m8702i(TAG, sbM1323p.toString());
        return cursorQueryNoteData;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
