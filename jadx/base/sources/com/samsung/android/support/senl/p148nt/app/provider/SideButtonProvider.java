package com.samsung.android.support.senl.p148nt.app.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.app.notes.memolist.MemoListActivity;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.nativecomposer.NativeComposerTriggerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016JO\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J1\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\"J;\u0010#\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010$J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/provider/SideButtonProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "SETTING_SIDE_BUTTON_METHOD", "", "SETTING_SIDE_BUTTON_KEY", "SETTING_SIDE_BUTTON_QUICK_LAUNCH_NOTES_LIST_KEY", "SETTING_SIDE_BUTTON_TYPE_NOTE_KEY", "SETTING_SIDE_BUTTON_HANDWRITING_NOTE_KEY", "SETTING_SIDE_BUTTON_DRAWING_NOTE_KEY", "SETTING_SIDE_BUTTON_VOICE_RECORD_NOTE_KEY", "SETTING_SIDE_BUTTON_IS_AVAILABLE_KEY", "SETTING_SIDE_BUTTON_INTENT_TYPE_KEY", "SETTING_SIDE_BUTTON_TITLE_KEY", "SETTING_SIDE_BUTTON_INTENT_URI_KEY", "onCreate", "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", OpenSessionApi.ITEM_LIMIT_DELETE, "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", Constants.ARG_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "extras", "setNewNoteType", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "type", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SideButtonProvider extends ContentProvider {

    @NotNull
    private final String SETTING_SIDE_BUTTON_METHOD = "sidebutton/getInfo";

    @NotNull
    private final String SETTING_SIDE_BUTTON_KEY = "key";

    @NotNull
    private final String SETTING_SIDE_BUTTON_QUICK_LAUNCH_NOTES_LIST_KEY = "key_quick_launch_notes";

    @NotNull
    private final String SETTING_SIDE_BUTTON_TYPE_NOTE_KEY = "key_type_note";

    @NotNull
    private final String SETTING_SIDE_BUTTON_HANDWRITING_NOTE_KEY = "key_handwriting_note";

    @NotNull
    private final String SETTING_SIDE_BUTTON_DRAWING_NOTE_KEY = "key_drawing_note";

    @NotNull
    private final String SETTING_SIDE_BUTTON_VOICE_RECORD_NOTE_KEY = "key_voice_record_note";

    @NotNull
    private final String SETTING_SIDE_BUTTON_IS_AVAILABLE_KEY = "isAvailable";

    @NotNull
    private final String SETTING_SIDE_BUTTON_INTENT_TYPE_KEY = "intentType";

    @NotNull
    private final String SETTING_SIDE_BUTTON_TITLE_KEY = "title";

    @NotNull
    private final String SETTING_SIDE_BUTTON_INTENT_URI_KEY = "intentUri";

    private final void setNewNoteType(Intent intent, String type) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            intent.setClassName(applicationContext, NativeComposerTriggerActivity.class.getName());
        }
        intent.setAction(ComposerConstants.ACTION_TASK_EDGE);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, type);
    }

    @Override // android.content.ContentProvider
    @NotNull
    public Bundle call(@NotNull String method, @Nullable String uri, @Nullable Bundle extras) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        Intrinsics.checkNotNullParameter(method, "method");
        Bundle bundle = new Bundle();
        if (!StringsKt__StringsJVMKt.equals(this.SETTING_SIDE_BUTTON_METHOD, method, true)) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Unknown Uri format: ", uri));
        }
        String string = null;
        String string2 = extras != null ? extras.getString(this.SETTING_SIDE_BUTTON_KEY) : null;
        Intent intent = new Intent();
        if (Intrinsics.areEqual(string2, this.SETTING_SIDE_BUTTON_QUICK_LAUNCH_NOTES_LIST_KEY)) {
            String str = this.SETTING_SIDE_BUTTON_TITLE_KEY;
            Context context = getContext();
            if (context != null && (resources5 = context.getResources()) != null) {
                string = resources5.getString(C8003R.string.task_edge_open_list);
            }
            bundle.putString(str, string);
            intent.setFlags(DriveFile.MODE_READ_WRITE);
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                intent.setClassName(applicationContext, MemoListActivity.class.getName());
            }
        } else if (Intrinsics.areEqual(string2, this.SETTING_SIDE_BUTTON_TYPE_NOTE_KEY)) {
            String str2 = this.SETTING_SIDE_BUTTON_TITLE_KEY;
            Context context2 = getContext();
            if (context2 != null && (resources4 = context2.getResources()) != null) {
                string = resources4.getString(C8003R.string.task_edge_add);
            }
            bundle.putString(str2, string);
            setNewNoteType(intent, ComposerConstants.NEW_MEMO_OPEN);
        } else if (Intrinsics.areEqual(string2, this.SETTING_SIDE_BUTTON_HANDWRITING_NOTE_KEY)) {
            String str3 = this.SETTING_SIDE_BUTTON_TITLE_KEY;
            Context context3 = getContext();
            if (context3 != null && (resources3 = context3.getResources()) != null) {
                string = resources3.getString(C8003R.string.task_edge_handwriting);
            }
            bundle.putString(str3, string);
            setNewNoteType(intent, ComposerConstants.NEW_MEMO_WRITING_OPEN);
        } else if (Intrinsics.areEqual(string2, this.SETTING_SIDE_BUTTON_DRAWING_NOTE_KEY)) {
            String str4 = this.SETTING_SIDE_BUTTON_TITLE_KEY;
            Context context4 = getContext();
            if (context4 != null && (resources2 = context4.getResources()) != null) {
                string = resources2.getString(C8003R.string.task_edge_drawing);
            }
            bundle.putString(str4, string);
            setNewNoteType(intent, ComposerConstants.NEW_MEMO_DRAWING_OPEN);
        } else if (Intrinsics.areEqual(string2, this.SETTING_SIDE_BUTTON_VOICE_RECORD_NOTE_KEY)) {
            String str5 = this.SETTING_SIDE_BUTTON_TITLE_KEY;
            Context context5 = getContext();
            if (context5 != null && (resources = context5.getResources()) != null) {
                string = resources.getString(C8003R.string.task_edge_voice);
            }
            bundle.putString(str5, string);
            setNewNoteType(intent, ComposerConstants.NEW_MEMO_VOICE_OPEN);
        }
        bundle.putBoolean(this.SETTING_SIDE_BUTTON_IS_AVAILABLE_KEY, true);
        bundle.putInt(this.SETTING_SIDE_BUTTON_INTENT_TYPE_KEY, 1);
        bundle.putString(this.SETTING_SIDE_BUTTON_INTENT_URI_KEY, intent.toUri(1));
        return bundle;
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }
}
