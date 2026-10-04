package com.samsung.android.support.senl.p148nt.stt.picker.presenter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.loader.content.AsyncTaskLoader;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.ContentFileData;
import com.samsung.android.support.senl.p148nt.model.utils.VoiceDataUtil;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AudioFormat;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.model.RecordingItem;
import com.samsung.android.support.senl.p148nt.stt.picker.utils.InitialKoreanUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001:\u0001 BS\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0018\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/CursorLoaderTask;", "Landroidx/loader/content/AsyncTaskLoader;", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "projection", "", "", "args", "Landroid/os/Bundle;", "mRecordingItemList", "", "", "<init>", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Ljava/util/Map;)V", "[Ljava/lang/String;", "mCachedRecordingItemDataMaps", "", "onReset", "", "loadInBackground", "getColumnIndex", "cursorName", "Landroid/database/Cursor;", "columnName", "removeFileType", "title", "getCachedRecordingItemData", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCursorLoaderTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CursorLoaderTask.kt\ncom/samsung/android/support/senl/nt/stt/picker/presenter/CursorLoaderTask\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,154:1\n739#2,9:155\n37#3:164\n36#3,3:165\n*S KotlinDebug\n*F\n+ 1 CursorLoaderTask.kt\ncom/samsung/android/support/senl/nt/stt/picker/presenter/CursorLoaderTask\n*L\n93#1:155,9\n94#1:164\n94#1:165,3\n*E\n"})
public final class CursorLoaderTask extends AsyncTaskLoader<ArrayList<RecordingItem>> {

    @NotNull
    public static final String TAG = "CursorLoaderTask";

    @NotNull
    private final Bundle args;

    @NotNull
    private Map<Long, RecordingItem> mCachedRecordingItemDataMaps;

    @NotNull
    private final Map<Integer, ArrayList<RecordingItem>> mRecordingItemList;

    @Nullable
    private final String[] projection;

    @NotNull
    private final Uri uri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CursorLoaderTask(@NotNull Context context, @NotNull Uri uri, @Nullable String[] strArr, @NotNull Bundle args, @NotNull Map<Integer, ArrayList<RecordingItem>> mRecordingItemList) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(mRecordingItemList, "mRecordingItemList");
        this.uri = uri;
        this.projection = strArr;
        this.args = args;
        this.mRecordingItemList = mRecordingItemList;
        this.mCachedRecordingItemDataMaps = new HashMap();
    }

    private final void getCachedRecordingItemData() {
        for (int i = 0; i < 3; i++) {
            ArrayList<RecordingItem> arrayList = this.mRecordingItemList.get(Integer.valueOf(i));
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!arrayList.get(i2).getIsInternalPath()) {
                        this.mCachedRecordingItemDataMaps.put(Long.valueOf(arrayList.get(i2).getMediaId()), arrayList.get(i2));
                    }
                }
            }
        }
    }

    private final int getColumnIndex(Cursor cursorName, String columnName) {
        return cursorName.getColumnIndex(columnName);
    }

    private final String removeFileType(String title) {
        if (!StringsKt.m14167w(title, AudioFormat.ExtType.EXT_M4A)) {
            return title;
        }
        String strSubstring = title.substring(0, StringsKt.m14131E(AudioFormat.ExtType.EXT_M4A, 0, 6, title));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        Logger.m12713i(TAG, "onReset");
        onStopLoading();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0194 A[Catch: all -> 0x017c, TryCatch #1 {all -> 0x017c, blocks: (B:15:0x00a6, B:17:0x00ab, B:28:0x00f5, B:30:0x00fb, B:32:0x0101, B:34:0x0107, B:36:0x010d, B:39:0x0116, B:41:0x0125, B:43:0x012e, B:45:0x0154, B:46:0x015c, B:48:0x0162, B:51:0x016f, B:55:0x0184, B:57:0x0194, B:68:0x01db, B:70:0x01e9, B:72:0x0210, B:60:0x01b0, B:54:0x0180, B:73:0x0219, B:76:0x0228), top: B:85:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01db A[Catch: all -> 0x017c, TryCatch #1 {all -> 0x017c, blocks: (B:15:0x00a6, B:17:0x00ab, B:28:0x00f5, B:30:0x00fb, B:32:0x0101, B:34:0x0107, B:36:0x010d, B:39:0x0116, B:41:0x0125, B:43:0x012e, B:45:0x0154, B:46:0x015c, B:48:0x0162, B:51:0x016f, B:55:0x0184, B:57:0x0194, B:68:0x01db, B:70:0x01e9, B:72:0x0210, B:60:0x01b0, B:54:0x0180, B:73:0x0219, B:76:0x0228), top: B:85:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b9 A[SYNTHETIC] */
    @Override // androidx.loader.content.AsyncTaskLoader
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<RecordingItem> loadInBackground() {
        String str;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        RecordingItem recordingItem;
        boolean z4;
        List listEmptyList;
        int i2;
        int length;
        String string = this.args.getString("searchTag");
        boolean z5 = this.args.getBoolean("searchInitial");
        int i4 = this.args.getInt("limit");
        int i5 = this.args.getInt("FilterInfo");
        getCachedRecordingItemData();
        ArrayList<RecordingItem> arrayList = new ArrayList<>();
        if ((string == null || string.length() == 0) && i5 == -1) {
            return arrayList;
        }
        List<ContentFileData> contentFileDataSearch = VoiceDataUtil.getContentFileDataSearch(getContext(), this.args.getString("SQLQuery"));
        Intrinsics.checkNotNull(contentFileDataSearch);
        if (!contentFileDataSearch.isEmpty()) {
            for (ContentFileData contentFileData : contentFileDataSearch) {
                String str2 = contentFileData.docPath;
                String str3 = File.separator;
                arrayList.add(new RecordingItem(-1L, AbstractC2322a.m1622l(str2, str3, "media", str3, contentFileData.contentFilePath), "", contentFileData.createdAt, contentFileData.displayName, (int) contentFileData.size, true));
            }
        }
        Cursor cursorQuery = getContext().getContentResolver().query(this.uri, this.projection, this.args.getString("selectionQuery"), null, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor != null) {
                int columnIndex = getColumnIndex(cursor, "_id");
                int columnIndex2 = getColumnIndex(cursor, "title");
                int columnIndex3 = getColumnIndex(cursor, "_display_name");
                int columnIndex4 = getColumnIndex(cursor, "datetaken");
                int columnIndex5 = getColumnIndex(cursor, "date_modified");
                int columnIndex6 = getColumnIndex(cursor, XmlErrorCodes.DURATION);
                int columnIndex7 = getColumnIndex(cursor, "mime_type");
                int columnIndex8 = getColumnIndex(cursor, "_data");
                int columnIndex9 = getColumnIndex(cursor, "_size");
                if (columnIndex >= 0 && columnIndex2 >= 0 && columnIndex5 >= 0 && columnIndex6 >= 0 && columnIndex3 >= 0 && columnIndex4 >= 0 && columnIndex7 >= 0 && columnIndex8 >= 0 && columnIndex9 >= 0) {
                    if (cursor.getCount() > 0 && !cursor.isClosed() && cursor.moveToFirst()) {
                        while (!cursor.isAfterLast() && cursor.getPosition() != -1 && i4 > 0) {
                            RecordingItem recordingItem2 = new RecordingItem();
                            long j = cursor.getLong(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            if (z5) {
                                Intrinsics.checkNotNull(string2);
                                String strRemoveFileType = removeFileType(string2);
                                if (string != null) {
                                    Locale locale = Locale.getDefault();
                                    z2 = true;
                                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                                    String lowerCase = string.toLowerCase(locale);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    List<String> listSplit = new Regex(" +").split(lowerCase, 0);
                                    if (listSplit.isEmpty()) {
                                        listEmptyList = CollectionsKt.emptyList();
                                        i2 = 0;
                                        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                                        length = strArr.length;
                                        boolean zCheckInitialTitle = false;
                                        while (true) {
                                            if (i2 < length) {
                                            }
                                            i2++;
                                            string = str;
                                            z5 = z;
                                            i4 = i;
                                        }
                                        z4 = zCheckInitialTitle;
                                    } else {
                                        ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                                        while (listIterator.hasPrevious()) {
                                            if (listIterator.previous().length() != 0) {
                                                listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                                                break;
                                            }
                                        }
                                        listEmptyList = CollectionsKt.emptyList();
                                        i2 = 0;
                                        String[] strArr2 = (String[]) listEmptyList.toArray(new String[0]);
                                        length = strArr2.length;
                                        boolean zCheckInitialTitle2 = false;
                                        while (true) {
                                            if (i2 < length) {
                                                str = string;
                                                z = z5;
                                                i = i4;
                                                break;
                                            }
                                            String str4 = strArr2[i2];
                                            str = string;
                                            InitialKoreanUtil initialKoreanUtil = InitialKoreanUtil.INSTANCE;
                                            z = z5;
                                            char[] charArray = str4.toCharArray();
                                            i = i4;
                                            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                                            zCheckInitialTitle2 = initialKoreanUtil.checkInitialTitle(charArray, strRemoveFileType);
                                            if (!zCheckInitialTitle2) {
                                                break;
                                            }
                                            i2++;
                                            string = str;
                                            z5 = z;
                                            i4 = i;
                                        }
                                        z4 = zCheckInitialTitle2;
                                    }
                                    if (!z3 || (recordingItem = this.mCachedRecordingItemDataMaps.get(Long.valueOf(j))) == null) {
                                        i4 = i;
                                    } else {
                                        recordingItem2.setMediaId(j);
                                        recordingItem2.setPath(recordingItem.getPath());
                                        recordingItem2.setTitle(recordingItem.getTitle());
                                        recordingItem2.setDate(recordingItem.getDate());
                                        recordingItem2.setSize(recordingItem.getSize());
                                        arrayList.add(recordingItem2);
                                        i4 = i - 1;
                                    }
                                    cursor.moveToNext();
                                    string = str;
                                    z5 = z;
                                } else {
                                    str = string;
                                    z = z5;
                                    i = i4;
                                    z2 = true;
                                    z4 = false;
                                }
                                if (!z4) {
                                    z3 = false;
                                }
                                if (z3) {
                                    i4 = i;
                                }
                                cursor.moveToNext();
                                string = str;
                                z5 = z;
                            } else {
                                str = string;
                                z = z5;
                                i = i4;
                                z2 = true;
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            cursor.moveToNext();
                            string = str;
                            z5 = z;
                        }
                    }
                }
                Logger.m12711e(TAG, "can not get column index - return null");
                cursor.close();
                CloseableKt.closeFinally(cursorQuery, null);
                return arrayList;
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorQuery, null);
            return arrayList;
        } finally {
        }
    }
}
