package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.common.SyncInitState$InitState;
import com.samsung.android.app.notes.sync.p135db.AbstractC6736e;
import com.samsung.android.app.notes.sync.p135db.AbstractC6739h;
import com.samsung.android.app.notes.sync.p135db.RunnableC6738g;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.sync.SyncInitializer;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.tag.HashTagData;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import p044K.AbstractC0159b;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HashTagNoteProvider extends ContentProvider {
    private static final String AUTHORITY_HASH_TAG_NOTE = "com.samsung.android.app.notes.hashtagnote";
    private static final String DOC_UUID = "docUuid";
    private static final String TAG = "HashTagNoteProvider";
    private static final String TAGSERVICE_PACKAGE_NAME = "com.samsung.android.service.tagservice";
    private static final String TAG_LIST = "tagList";

    private Bundle addTags(@NonNull Context context, String str, Bundle bundle) {
        boolean zAddTagsByDocUuid;
        boolean z;
        Logger.m8697d(TAG, "insert tag start");
        if (TextUtils.isEmpty(str)) {
            Logger.m8697d(TAG, "insert sDocUuidSegment fail ");
            return null;
        }
        try {
            UUID uuidFromString = UUID.fromString(str);
            if (bundle == null) {
                Logger.m8697d(TAG, "insert extras null");
                return null;
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(TAG_LIST);
            if (stringArrayList == null) {
                Logger.m8697d(TAG, "insert tag string list null");
                return null;
            }
            if (stringArrayList.isEmpty()) {
                Logger.m8697d(TAG, "insert tag array empty");
                return null;
            }
            String path = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getPath(uuidFromString.toString());
            if (path != null && path.endsWith(".sdocx")) {
                zAddTagsByDocUuid = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().addTagsByDocUuid(stringArrayList, uuidFromString.toString());
                z = false;
            } else if (path == null || !path.endsWith(".sdoc")) {
                zAddTagsByDocUuid = false;
                z = false;
            } else {
                ArrayList arrayListM4831a = AbstractC6736e.m4831a(uuidFromString.toString());
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(new HashTagData().setName(it.next()));
                }
                AbstractC6739h.m4837d(context, arrayListM4831a, arrayList, uuidFromString.toString(), false);
                z = true;
                zAddTagsByDocUuid = false;
            }
            Logger.m8700f(TAG, "insert tag request sDocUUID " + uuidFromString);
            if (!zAddTagsByDocUuid && !z) {
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("result", 0);
            return bundle2;
        } catch (IllegalArgumentException unused) {
            Logger.m8697d(TAG, "insert sdocUuid parse fail ");
            return null;
        }
    }

    private boolean init(@NonNull Context context) {
        try {
            SyncInitializer.lazyInitialize(context.getApplicationContext());
            if (AbstractC0159b.f493a == SyncInitState$InitState.initialized) {
                return true;
            }
            Debugger.m8615i(TAG, "Not initialized!!");
            return false;
        } catch (Exception unused) {
            Debugger.m8615i(TAG, "Not initialized!");
            return false;
        }
    }

    private boolean isCalledFromDisallowedPackage() {
        return !TAGSERVICE_PACKAGE_NAME.equals(getCallingPackage());
    }

    private Bundle isSupportBulkInsertTag() {
        Logger.m8697d(TAG, "get supported start");
        Bundle bundle = new Bundle();
        bundle.putBoolean("result", true);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$delete$0(Context context, UUID uuid) {
        try {
            DocumentWriteResolver.delete(context, uuid.toString(), 2, TAG);
        } catch (Exception e) {
            Logger.m8697d(TAG, "delete sdoc request final error : " + e);
        }
    }

    private Bundle requestShareFile(@NonNull Context context, String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = null;
        }
        if (str == null) {
            Logger.m8697d(TAG, "call uuid fail");
            return null;
        }
        List<NotesTagEntity> tagListByDocUuid = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().getTagListByDocUuid(str);
        ArrayList arrayListM4831a = AbstractC6736e.m4831a(str);
        if ((tagListByDocUuid == null || tagListByDocUuid.isEmpty()) && arrayListM4831a.isEmpty()) {
            Logger.m8697d(TAG, "call tag exist fail");
            return null;
        }
        int lockType = NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getLockType(str);
        if (lockType >= 1 || lockType == -2) {
            Logger.m8697d(TAG, "delete tag locked fail");
            return null;
        }
        String path = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getPath(str);
        if (TextUtils.isEmpty(path)) {
            Logger.m8697d(TAG, "call filePath fail");
            return null;
        }
        Uri uri = ShareFileProvider.getUri(context, path, AbstractC0541b.m774p("Notes_Tag_", new SimpleDateFormat("yyMMdd_HHmmss", Locale.ENGLISH).format(new Date()), "_", UUID.randomUUID().toString().substring(r5.length() - 3)));
        if (uri == null) {
            Logger.m8697d(TAG, "call file provider fail");
            return null;
        }
        context.grantUriPermission(TAGSERVICE_PACKAGE_NAME, uri, 1);
        bundle.putString("content_path", uri.toString());
        return bundle;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] contentValuesArr) {
        Logger.m8697d(TAG, "insert tag start");
        Context context = getContext();
        int i = 0;
        if (context == null || !init(context) || isCalledFromDisallowedPackage() || uri.getAuthority() == null) {
            return 0;
        }
        if (!AUTHORITY_HASH_TAG_NOTE.equals(uri.getAuthority())) {
            Logger.m8697d(TAG, "insert authority fail");
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int length = contentValuesArr.length;
        int i2 = 0;
        while (i2 < length) {
            ContentValues contentValues = contentValuesArr[i2];
            String asString = contentValues.getAsString(TAG_LIST);
            String asString2 = contentValues.getAsString(DOC_UUID);
            if (asString == null) {
                Logger.m8697d(TAG, "insert tag string null");
                return i;
            }
            if (asString2 == null) {
                Logger.m8697d(TAG, "insert tag string null");
                return i;
            }
            try {
                UUID.fromString(asString2);
                String[] strArrSplit = asString.split(ContentUtils.HASH_SYMBOL, 50);
                if (strArrSplit.length == 0) {
                    Logger.m8697d(TAG, "insert tag array null");
                    return i;
                }
                ArrayList arrayList5 = new ArrayList();
                int length2 = strArrSplit.length;
                int i4 = i;
                while (i < length2) {
                    String str = strArrSplit[i];
                    if (!TextUtils.isEmpty(str)) {
                        arrayList5.add(str);
                    }
                    i++;
                }
                if (asString2.isEmpty() || arrayList5.isEmpty()) {
                    return i4;
                }
                int lockType = NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getLockType(asString2);
                if (lockType >= 1 || lockType == -2) {
                    Logger.m8697d(TAG, "insert tag locked fail");
                    return i4;
                }
                String path = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getPath(asString2);
                if (path != null && path.endsWith(".sdocx")) {
                    arrayList.add(asString2);
                    arrayList2.add(arrayList5);
                } else if (path != null && path.endsWith(".sdoc")) {
                    arrayList3.add(asString2);
                    arrayList4.add(arrayList5);
                }
                i2++;
                i = i4;
            } catch (IllegalArgumentException unused) {
                int i5 = i;
                Logger.m8697d(TAG, "insert sdocUuid parse fail ");
                return i5;
            }
        }
        int i6 = i;
        if (!arrayList.isEmpty()) {
            NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().addTagsByDocUuidList(arrayList2, arrayList);
        }
        if (!arrayList3.isEmpty()) {
            Debugger.m8607d("HashTagWriteResolver", "updateHashTagsBySdocUuidFromProvider start");
            for (int i7 = i6; i7 < arrayList3.size(); i7++) {
                ArrayList arrayListM4831a = AbstractC6736e.m4831a((String) arrayList3.get(i7));
                ArrayList arrayList6 = new ArrayList(arrayListM4831a);
                Iterator it = ((List) arrayList4.get(i7)).iterator();
                int i8 = i6;
                while (it.hasNext()) {
                    HashTagData name = new HashTagData().setName((String) it.next());
                    if (!arrayListM4831a.contains(name)) {
                        arrayList6.add(name);
                        i8 = 1;
                    }
                }
                if (i8 != 0) {
                    NotesDatabaseManager.getInstance().runInTransaction(new RunnableC6738g(context, arrayListM4831a, arrayList6, arrayList3, i7));
                }
            }
            C14477a.m15065b().m15073i();
            new NotesTagRepository(context).notifyTagBoard();
        }
        return arrayList3.size() + arrayList.size();
    }

    @Override // android.content.ContentProvider
    public Bundle call(@NonNull String str, String str2, Bundle bundle) {
        Logger.m8697d(TAG, "call start");
        Context context = getContext();
        if (context == null || !init(context) || isCalledFromDisallowedPackage()) {
            return null;
        }
        str.getClass();
        switch (str) {
            case "isSupportBulkInsertTag":
                return isSupportBulkInsertTag();
            case "addTags":
                return addTags(context, str2, bundle);
            case "requestShareFile":
                return requestShareFile(context, str2);
            default:
                Logger.m8697d(TAG, "call method fail");
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        Logger.m8697d(TAG, "delete start");
        Context context = getContext();
        if (context != null && init(context) && !isCalledFromDisallowedPackage()) {
            if (!AUTHORITY_HASH_TAG_NOTE.equals(uri.getAuthority())) {
                Logger.m8697d(TAG, "delete authority fail");
                return 0;
            }
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(lastPathSegment)) {
                Logger.m8697d(TAG, "delete sDocUuidSegment fail ");
                return 0;
            }
            try {
                UUID uuidFromString = UUID.fromString(lastPathSegment);
                List<NotesTagEntity> tagListByDocUuid = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().getTagListByDocUuid(uuidFromString.toString());
                ArrayList arrayListM4831a = AbstractC6736e.m4831a(uuidFromString.toString());
                if ((tagListByDocUuid == null || tagListByDocUuid.isEmpty()) && arrayListM4831a.isEmpty()) {
                    Logger.m8697d(TAG, "delete tag exist fail");
                    return 0;
                }
                int lockType = NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getLockType(uuidFromString.toString());
                if (lockType >= 1 || lockType == -2) {
                    Logger.m8697d(TAG, "delete tag locked fail");
                    return 0;
                }
                Logger.m8700f(TAG, "delete request sDocUUID " + uuidFromString);
                new Handler(Looper.getMainLooper()).post(new RunnableC8515c(context, uuidFromString, 14));
                return 1;
            } catch (IllegalArgumentException unused) {
                Logger.m8697d(TAG, "delete sdocUuid parse fail ");
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Logger.m8697d(TAG, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
