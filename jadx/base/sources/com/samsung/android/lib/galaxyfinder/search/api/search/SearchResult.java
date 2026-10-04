package com.samsung.android.lib.galaxyfinder.search.api.search;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.samsung.android.lib.galaxyfinder.search.api.payload.IntentResultItemPayload;
import com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 (*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001(B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nH\u0002¢\u0006\u0002\u0010\fJ\u001d\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u000e\u0010$\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010%\u001a\u00020&J\u001d\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u0010\u001e\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/SearchResult;", "T", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "", "query", "", "baseType", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)V", "cursorColumns", "", "getCursorColumns", "()[Ljava/lang/String;", "itemColumns", "getItemColumns", "mItems", "", "resultItems", "", "getResultItems", "()Ljava/util/List;", "resultType", "getResultType", "()Ljava/lang/String;", "resultVersion", "getResultVersion", "totalCount", "", "_getItemColumns", "_transformCursorRaw", "item", "(Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;)[Ljava/lang/Object;", "addResultItem", "", "(Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;)V", "getCursorRaw", "setTotalCount", "toResultCursor", "Landroid/database/Cursor;", "transformCursorRaw", "Companion", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class SearchResult<T extends SearchResultItem> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Class<T> baseType;

    @NotNull
    private final List<T> mItems;

    @NotNull
    private final String query;
    private int totalCount;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004H\u0002¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/SearchResult$Companion;", "", "()V", "concat", "", "B", "first", "second", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <B> B[] concat(B[] first, B[] second) {
            B[] merge = (B[]) Arrays.copyOf(first, first.length + second.length);
            System.arraycopy(second, 0, merge, first.length, second.length);
            Intrinsics.checkNotNullExpressionValue(merge, "merge");
            return merge;
        }

        private Companion() {
        }
    }

    public SearchResult(@NotNull String query, @NotNull Class<T> baseType) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(baseType, "baseType");
        this.query = query;
        this.baseType = baseType;
        this.totalCount = -1;
        this.mItems = new ArrayList();
    }

    private final String[] _getItemColumns() {
        return new String[]{"key", "icon", "text", "text2", "group", "view_payload", "action1_label", "action1_payload", "action2_label", "action2_payload", "action3_label", "action3_payload", "extras"};
    }

    private final Object[] _transformCursorRaw(T item) {
        String itemKey = item.getItemKey();
        Uri icon = item.getIcon();
        String text = item.getText();
        String text2 = item.getText2();
        String group = item.getGroup();
        IntentResultItemPayload payload = item.getPayload();
        return new Object[]{itemKey, icon, text, text2, group, payload != null ? payload.getStringFromPayload() : null, item.getActionLabel(0), item.getActionPayloadStr(0), item.getActionLabel(1), item.getActionPayloadStr(1), item.getActionLabel(2), item.getActionPayloadStr(2), item.getExtras()};
    }

    private final String[] getCursorColumns() {
        return (String[]) INSTANCE.concat(_getItemColumns(), getItemColumns());
    }

    private final Object[] getCursorRaw(T item) {
        return INSTANCE.concat(_transformCursorRaw(item), transformCursorRaw(item));
    }

    private final List<T> getResultItems() {
        return this.mItems;
    }

    public final void addResultItem(@NotNull T item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.mItems.add(item);
    }

    @NotNull
    public abstract String[] getItemColumns();

    @NotNull
    public abstract String getResultType();

    @NotNull
    public abstract String getResultVersion();

    public final void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @NotNull
    public final Cursor toResultCursor() {
        String[] cursorColumns = getCursorColumns();
        Object[] objArrCopyOf = Arrays.copyOf(new String[]{"2.1.7", this.query, getResultType(), getResultVersion(), String.valueOf(this.totalCount)}, cursorColumns.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        MatrixCursor matrixCursor = new MatrixCursor(cursorColumns);
        matrixCursor.addRow((String[]) objArrCopyOf);
        Iterator<T> it = getResultItems().iterator();
        while (it.hasNext()) {
            matrixCursor.addRow(getCursorRaw(it.next()));
        }
        return matrixCursor;
    }

    @NotNull
    public abstract Object[] transformCursorRaw(@NotNull T item);
}
