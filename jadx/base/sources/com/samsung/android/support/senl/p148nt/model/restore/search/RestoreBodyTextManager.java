package com.samsung.android.support.senl.p148nt.model.restore.search;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.legacy.SaveNoteContents;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.SDocBodyTextGetter;
import com.samsung.android.support.senl.p148nt.model.document.SDocXBodyTextGetter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\r\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\tJ\r\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0011J\u001d\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0015J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/restore/search/RestoreBodyTextManager;", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "execute", "", "setRestoreTargetDocuments", "setRestoreTargetDocuments$ntModel_release", "targetDocuments", "", "Landroid/util/Pair;", "", "getTargetDocuments", "()Ljava/util/List;", "restoreSearchText", "restoreSearchText$ntModel_release", "loadSearchTextFromDocument", "uuid", "path", "loadSearchTextFromDocument$ntModel_release", "getBodyTextFromDocument", "saveTextToTempDatabase", "textContent", "createTemporaryDatabase", "migrateFromTempDatabase", "migrateToDocumentTable", "resetTempDatabase", "dropTemporaryTable", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRestoreBodyTextManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RestoreBodyTextManager.kt\ncom/samsung/android/support/senl/nt/model/restore/search/RestoreBodyTextManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,193:1\n739#2,9:194\n37#3:203\n36#3,3:204\n108#4:207\n80#4,22:208\n108#4:230\n80#4,22:231\n*S KotlinDebug\n*F\n+ 1 RestoreBodyTextManager.kt\ncom/samsung/android/support/senl/nt/model/restore/search/RestoreBodyTextManager\n*L\n81#1:194,9\n82#1:203\n82#1:204,3\n128#1:207\n128#1:208,22\n129#1:230\n129#1:231,22\n*E\n"})
public final class RestoreBodyTextManager {
    private static final int APP_VERSION_START = 400605000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long MIGRATION_PERIOD = 10000;

    @NotNull
    public static final String PREFERENCE_KEY_NEED_TO_RESET = "needToRest_1";

    @NotNull
    public static final String PREFERENCE_KEY_RESET_DATA_LIST = "TextResetList";

    @NotNull
    public static final String PREFERENCE_NAME = "TextMiningPref";

    @NotNull
    public static final String PREFERENCE_VALUE_SEPARATOR = "<@sep#1>";

    @NotNull
    private static final String TAG;

    @NotNull
    private final Context appContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/restore/search/RestoreBodyTextManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PREFERENCE_NAME", "PREFERENCE_KEY_NEED_TO_RESET", "PREFERENCE_KEY_RESET_DATA_LIST", "PREFERENCE_VALUE_SEPARATOR", "MIGRATION_PERIOD", "", "APP_VERSION_START", "", "checkAppVersionToRestore", "", "lastVersionCode", "needToRestoreData", "", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void checkAppVersionToRestore(int lastVersionCode) {
            DataLogger.m12307i(RestoreBodyTextManager.TAG, "checkAppVersionToRestoreData, lastVersionCode : " + lastVersionCode);
            if (lastVersionCode >= RestoreBodyTextManager.APP_VERSION_START) {
                SharedPreferencesCompat.INSTANCE.getInstance(RestoreBodyTextManager.PREFERENCE_NAME).putBoolean(RestoreBodyTextManager.PREFERENCE_KEY_NEED_TO_RESET, true);
            }
        }

        @JvmStatic
        public final boolean needToRestoreData() {
            return SharedPreferencesCompat.INSTANCE.getInstance(RestoreBodyTextManager.PREFERENCE_NAME).getBoolean(RestoreBodyTextManager.PREFERENCE_KEY_NEED_TO_RESET, true);
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = ModelLogger.createTag("RestoreBodyTextManager");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public RestoreBodyTextManager(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    @JvmStatic
    public static final void checkAppVersionToRestore(int i) {
        INSTANCE.checkAppVersionToRestore(i);
    }

    private final void createTemporaryDatabase() {
        String str = TAG;
        DataLogger.m12307i(str, "createTemporaryDatabase");
        NotesDatabaseManager.getWritableDatabase().execSQL("CREATE TABLE IF NOT EXISTS `temporary_text_content` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `UUID` TEXT NOT NULL DEFAULT '', `content` BLOB NOT NULL, `strippedContent` BLOB NOT NULL, `filePath` TEXT NOT NULL)");
        DataLogger.m12307i(str, "createTemporaryDatabase - end");
    }

    private final void dropTemporaryTable() {
        DataLogger.m12307i(TAG, "dropTemporaryTable");
        NotesDatabaseManager.getWritableDatabase().execSQL("DROP TABLE IF EXISTS temporary_text_content");
    }

    private final String getBodyTextFromDocument(String path) {
        return StringsKt.m14167w(path, ".sdocx") ? new SDocXBodyTextGetter(this.appContext).getText(path) : new SDocBodyTextGetter(this.appContext).getText(path);
    }

    private final List<Pair<String, String>> getTargetDocuments() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = NotesDatabaseManager.getInstance().query(new SimpleSQLiteQuery("SELECT text_search.sdocUUID AS UUID, text_search.filePath AS filePath FROM text_search LEFT OUTER JOIN temporary_text_content ON text_search.sdocUUID = temporary_text_content.UUID WHERE temporary_text_content.UUID IS NULL AND LENGTH(text_search.strippedContent) == 30"));
        try {
            Cursor cursor = cursorQuery;
            int columnIndex = cursor.getColumnIndex("UUID");
            int columnIndex2 = cursor.getColumnIndex("filePath");
            if (columnIndex >= 0 && columnIndex2 >= 0) {
                if (cursor.moveToFirst()) {
                    do {
                        arrayList.add(new Pair(cursor.getString(columnIndex), cursor.getString(columnIndex2)));
                    } while (cursor.moveToNext());
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
                return arrayList;
            }
            CloseableKt.closeFinally(cursorQuery, null);
            return arrayList;
        } finally {
        }
    }

    private final void migrateFromTempDatabase() {
        DataLogger.m12307i(TAG, "migrateFromTempDatabase");
        migrateToDocumentTable();
        resetTempDatabase();
    }

    private final void migrateToDocumentTable() {
        NotesDatabaseManager.getWritableDatabase().execSQL("UPDATE OR ABORT text_search SET strippedContent = (SELECT temporary_text_content.strippedContent FROM temporary_text_content WHERE temporary_text_content.UUID=text_search.sdocUUID) WHERE EXISTS (SELECT temporary_text_content.strippedContent FROM temporary_text_content WHERE temporary_text_content.UUID=text_search.sdocUUID)");
    }

    @JvmStatic
    public static final boolean needToRestoreData() {
        return INSTANCE.needToRestoreData();
    }

    private final void resetTempDatabase() {
        NotesDatabaseManager.getWritableDatabase().execSQL("DELETE FROM temporary_text_content");
    }

    private final void saveTextToTempDatabase(String uuid, String path, String textContent) {
        if (TextUtils.isEmpty(textContent)) {
            return;
        }
        int length = textContent.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) textContent.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = textContent.subSequence(i, length + 1).toString();
        String strMakeStrippedContent = SaveNoteContents.makeStrippedContent(textContent);
        Intrinsics.checkNotNullExpressionValue(strMakeStrippedContent, "makeStrippedContent(...)");
        int length2 = strMakeStrippedContent.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare((int) strMakeStrippedContent.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                } else {
                    length2--;
                }
            } else if (z4) {
                i2++;
            } else {
                z3 = true;
            }
        }
        NotesDatabaseManager.getWritableDatabase().execSQL(AbstractC0541b.m776r(AbstractC0000a.m16m("INSERT OR REPLACE INTO `temporary_text_content` (`UUID`, `content`, `strippedContent`, `filePath`) VALUES ('", uuid, "', '", string, "', '"), strMakeStrippedContent.subSequence(i2, length2 + 1).toString(), "', '", path, "')"));
    }

    @WorkerThread
    public final void execute() {
        createTemporaryDatabase();
        setRestoreTargetDocuments$ntModel_release();
        restoreSearchText$ntModel_release();
    }

    public final void loadSearchTextFromDocument$ntModel_release(@NotNull String uuid, @NotNull String path) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(uuid) || TextUtils.isEmpty(path) || !AbstractC2322a.m1607A(path)) {
            return;
        }
        try {
            saveTextToTempDatabase(uuid, path, getBodyTextFromDocument(path));
        } catch (Exception e) {
            AbstractC11014a.m12314C("saveTextToTempDatabase, e : ", e.getMessage(), TAG);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void restoreSearchText$ntModel_release() {
        List listEmptyList;
        String[] strArr;
        if (SpenSdkInitializer.initialize(this.appContext)) {
            String str = TAG;
            DataLogger.m12307i(str, "restoreSearchText - start");
            SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance(PREFERENCE_NAME);
            Set<String> stringSet = companion.getStringSet(PREFERENCE_KEY_RESET_DATA_LIST, null);
            if (stringSet != null) {
                DataLogger.m12307i(str, "restoreSearchText, target size : " + stringSet.size());
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (String str2 : stringSet) {
                    if (!TextUtils.isEmpty(str2)) {
                        List listM13999t = AbstractC12991c.m13999t(0, PREFERENCE_VALUE_SEPARATOR, str2);
                        if (listM13999t.isEmpty()) {
                            listEmptyList = CollectionsKt.emptyList();
                            strArr = (String[]) listEmptyList.toArray(new String[0]);
                            if (strArr.length < 2) {
                            }
                        } else {
                            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                            while (listIterator.hasPrevious()) {
                                if (((String) listIterator.previous()).length() != 0) {
                                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                                    break;
                                }
                            }
                            listEmptyList = CollectionsKt.emptyList();
                            strArr = (String[]) listEmptyList.toArray(new String[0]);
                            if (strArr.length < 2) {
                                loadSearchTextFromDocument$ntModel_release(strArr[0], strArr[1]);
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                if (jCurrentTimeMillis2 - jCurrentTimeMillis >= 10000) {
                                    migrateFromTempDatabase();
                                    jCurrentTimeMillis = jCurrentTimeMillis2;
                                }
                            }
                        }
                    }
                }
                migrateFromTempDatabase();
                dropTemporaryTable();
                DataLogger.m12307i(TAG, "restoreSearchText - end");
            }
            companion.remove(PREFERENCE_KEY_RESET_DATA_LIST);
            companion.putBoolean(PREFERENCE_KEY_NEED_TO_RESET, false);
        }
    }

    public final void setRestoreTargetDocuments$ntModel_release() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Pair<String, String> pair : getTargetDocuments()) {
            linkedHashSet.add(pair.first + PREFERENCE_VALUE_SEPARATOR + pair.second);
        }
        SharedPreferencesCompat.INSTANCE.getInstance(PREFERENCE_NAME).putStringSet(PREFERENCE_KEY_RESET_DATA_LIST, linkedHashSet);
        DataLogger.m12307i(TAG, "setRestoreTargetDocuments, size : " + linkedHashSet.size());
    }
}
