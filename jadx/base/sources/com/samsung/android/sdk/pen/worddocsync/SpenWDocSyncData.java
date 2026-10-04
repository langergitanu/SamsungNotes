package com.samsung.android.sdk.pen.worddocsync;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.sdk.pen.document.SpenInvalidCacheException;
import com.samsung.android.sdk.pen.document.SpenInvalidPasswordException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b<\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 w2\u00020\u0001:\u0001wB\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010g\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010j\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010k\u001a\u00020h2\b\u0010l\u001a\u0004\u0018\u00010\u001bJ\b\u0010m\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010n\u001a\u00020h2\u0006\u0010o\u001a\u00020\u0000J\u000e\u0010p\u001a\u00020h2\u0006\u0010q\u001a\u00020\u0010J\b\u0010r\u001a\u00020hH\u0004J\b\u0010s\u001a\u00020hH\u0002J\b\u0010t\u001a\u00020hH\u0002J\b\u0010u\u001a\u00020hH\u0002J\b\u0010v\u001a\u00020hH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R-\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c`\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0011\u0010(\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b)\u0010%R$\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020+8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u00020+2\u0006\u0010*\u001a\u00020+8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R$\u00104\u001a\u00020+2\u0006\u0010*\u001a\u00020+8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R$\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R$\u0010>\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R$\u0010@\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010CR$\u0010D\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\"\"\u0004\bF\u0010CR$\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\"\"\u0004\bJ\u0010CR$\u0010L\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010\"\"\u0004\bN\u0010CR$\u0010P\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\"\"\u0004\bR\u0010CRD\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0014j\b\u0012\u0004\u0012\u00020\u001b`\u00162\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0014j\b\u0012\u0004\u0012\u00020\u001b`\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010\u0018\"\u0004\bU\u0010VR$\u0010W\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010\"\"\u0004\bY\u0010CR$\u0010[\u001a\u00020+2\u0006\u0010Z\u001a\u00020+8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\\\u0010.\"\u0004\b]\u00100R$\u0010^\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010\"\"\u0004\b`\u0010CR$\u0010a\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bb\u0010\"\"\u0004\bc\u0010CR$\u0010d\u001a\u00020+2\u0006\u0010*\u001a\u00020+8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\be\u0010.\"\u0004\bf\u00100¨\u0006x"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncData;", "", "<init>", "()V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mNativeHandle", "", "mContext", "isInitialized", "", "downSyncInstance", "getDownSyncInstance", "()Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncData;", "noteTree", "Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncNoteTree;", "getNoteTree", "()Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncNoteTree;", "contentFileList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncContentFile;", "Lkotlin/collections/ArrayList;", "getContentFileList", "()Ljava/util/ArrayList;", "objectStrokeMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncObjectStroke;", "Lkotlin/collections/HashMap;", "getObjectStrokeMap", "()Ljava/util/HashMap;", "contentFileDirPath", "getContentFileDirPath", "()Ljava/lang/String;", "objectStrokeCount", "getObjectStrokeCount", "()I", "nonObjectStrokeCount", "getNonObjectStrokeCount", "bodyObjectCount", "getBodyObjectCount", "time", "", "syncModifiedTime", "getSyncModifiedTime", "()J", "setSyncModifiedTime", "(J)V", "displayCreatedTime", "getDisplayCreatedTime", "setDisplayCreatedTime", "displayModifiedTime", "getDisplayModifiedTime", "setDisplayModifiedTime", "flag", "isLocked", "()Z", "setLocked", "(Z)V", "isConverted", "setConverted", "isFavorite", "setFavorite", "bookmark", "getBookmark", "setBookmark", "(Ljava/lang/String;)V", "state", "getState", "setState", "uuid", "appNoteUuid", "getAppNoteUuid", "setAppNoteUuid", "id", SyncDBSchema.SyncInfo.COMMIT_ID, "getCommitId", "setCommitId", "name", IdentityApiContract.Parameter.MODEL_NAME, "getModelName", "setModelName", "tagList", "getTagList", "setTagList", "(Ljava/util/ArrayList;)V", "mappedUuid", "getMappedUuid", "setMappedUuid", "index", DBSchema.MappedDocument.MAPPED_AT, "getMappedAt", "setMappedAt", DBSchema.Document.MS_SYNC_ACCOUNT_ID, "getMsSyncAccountId", "setMsSyncAccountId", DBSchema.Document.MS_SYNC_DOCUMENT_UUID, "getMsSyncDocumentUuid", "setMsSyncDocumentUuid", DBSchema.Document.MS_LAST_SYNC_TIME, "getMsLastSyncTime", "setMsLastSyncTime", "readWDoc", "", "sdocxPath", "writeWDoc", "parseXml", "xmlString", "composeXml", Constants.ARG_UPDATE, "updatedPartData", "removeUnchangedData", "requestedNoteTree", "finalize", "checkInitialized", "throwCheckedExceptionLoadWNote", "throwCheckedExceptionSaveWNote", "throwUncheckedException", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenWDocSyncData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWDocSyncData.kt\ncom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,534:1\n1#2:535\n*E\n"})
public final class SpenWDocSyncData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LOG_TAG = "Model_WDocSyncData";
    private boolean isInitialized;

    @Nullable
    private Context mContext;
    private int mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0083 J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\nH\u0083 J\u001b\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0083 J\u001b\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0083 J\u001b\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010\u0019\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0083 J\u0019\u0010\u001c\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001bH\u0083 J!\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010\r\u001a\u00020\nH\u0083 J-\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020$0#j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020$`%2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0011\u0010&\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0011\u0010'\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0011\u0010(\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0011\u0010)\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010*\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u001bH\u0083 J\u0011\u0010,\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010-\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u001bH\u0083 J\u0011\u0010.\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010/\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u001bH\u0083 J\u0011\u00100\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u00101\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0013H\u0083 J\u0011\u00103\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u00104\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0013H\u0083 J\u0011\u00105\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u00106\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0013H\u0083 J\u0011\u00107\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u00108\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0005H\u0083 J\u0011\u0010:\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010;\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0005H\u0083 J\u0011\u0010=\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010>\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0005H\u0083 J\u0011\u0010@\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010A\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u0005H\u0083 J\u0011\u0010C\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010D\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u0005H\u0083 J\u0011\u0010F\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J)\u0010G\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001fj\b\u0012\u0004\u0012\u00020\u0005`!H\u0083 J!\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001fj\b\u0012\u0004\u0012\u00020\u0005`!2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010J\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0005H\u0083 J\u0011\u0010K\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010L\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u001bH\u0083 J\u0011\u0010N\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010O\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u0005H\u0083 J\u0011\u0010P\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010Q\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0005H\u0083 J\u0011\u0010R\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0083 J\u0019\u0010S\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u001bH\u0083 J\u0011\u0010T\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\nH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006U"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncData$Companion;", "", "<init>", "()V", "LOG_TAG", "", "printXml", "", "sml_str", "WDocSyncData_init", "", "appFilesDirPath", "WDocSyncData_finalize", "nativeHandle", "WDocSyncData_getDownSyncInstance", "Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncData;", "WDocSyncData_getNoteTree", "Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncNoteTree;", "WDocSyncData_readWDoc", "", "sdocxPath", "WDocSyncData_writeWDoc", "WDocSyncData_parseXml", "xmlString", "WDocSyncData_composeXml", "WDocSyncData_update", "updatedPartDataNativeHandle", "", "WDocSyncData_removeUnchangedData", "requestedNoteTreeNativeHandle", "WDocSyncData_getContentFileList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncContentFile;", "Lkotlin/collections/ArrayList;", "WDocSyncData_getObjectStrokeMap", "Ljava/util/HashMap;", "Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncObjectStroke;", "Lkotlin/collections/HashMap;", "WDocSyncData_getContentFileDirPath", "WDocSyncData_getObjectStrokeCount", "WDocSyncData_getNonObjectStrokeCount", "WDocSyncData_getBodyObjectCount", "WDocSyncData_setSyncModifiedTime", "time", "WDocSyncData_getSyncModifiedTime", "WDocSyncData_setDisplayCreatedTime", "WDocSyncData_getDisplayCreatedTime", "WDocSyncData_setDisplayModifiedTime", "WDocSyncData_getDisplayModifiedTime", "WDocSyncData_setLocked", "flag", "WDocSyncData_isLocked", "WDocSyncData_setConverted", "WDocSyncData_isConverted", "WDocSyncData_setFavorite", "WDocSyncData_isFavorite", "WDocSyncData_setBookmark", "bookmark", "WDocSyncData_getBookmark", "WDocSyncData_setState", "state", "WDocSyncData_getState", "WDocSyncData_setAppNoteUuid", "uuid", "WDocSyncData_getAppNoteUuid", "WDocSyncData_setCommitId", "id", "WDocSyncData_getCommitId", "WDocSyncData_setModelName", "name", "WDocSyncData_getModelName", "WDocSyncData_setTagList", "tagList", "WDocSyncData_getTagList", "WDocSyncData_setMappedUuid", "WDocSyncData_getMappedUuid", "WDocSyncData_setMappedAt", "index", "WDocSyncData_getMappedAt", "WDocSyncData_setMsSyncAccountId", "WDocSyncData_getMsSyncAccountId", "WDocSyncData_setMsSyncDocumentUuid", "WDocSyncData_getMsSyncDocumentUuid", "WDocSyncData_setMsLastSyncTime", "WDocSyncData_getMsLastSyncTime", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpenWDocSyncData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWDocSyncData.kt\ncom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncData$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,534:1\n731#2,9:535\n731#2,9:546\n37#3,2:544\n37#3,2:555\n*S KotlinDebug\n*F\n+ 1 SpenWDocSyncData.kt\ncom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncData$Companion\n*L\n429#1:535,9\n434#1:546,9\n429#1:544,2\n434#1:555,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_composeXml(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_composeXml(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void WDocSyncData_finalize(int nativeHandle) {
            SpenWDocSyncData.WDocSyncData_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getAppNoteUuid(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getAppNoteUuid(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WDocSyncData_getBodyObjectCount(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getBodyObjectCount(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getBookmark(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getBookmark(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getCommitId(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getCommitId(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getContentFileDirPath(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getContentFileDirPath(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenWDocSyncContentFile> WDocSyncData_getContentFileList(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getContentFileList(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long WDocSyncData_getDisplayCreatedTime(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getDisplayCreatedTime(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long WDocSyncData_getDisplayModifiedTime(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getDisplayModifiedTime(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenWDocSyncData WDocSyncData_getDownSyncInstance(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getDownSyncInstance(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long WDocSyncData_getMappedAt(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getMappedAt(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getMappedUuid(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getMappedUuid(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getModelName(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getModelName(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long WDocSyncData_getMsLastSyncTime(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getMsLastSyncTime(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getMsSyncAccountId(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getMsSyncAccountId(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getMsSyncDocumentUuid(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getMsSyncDocumentUuid(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WDocSyncData_getNonObjectStrokeCount(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getNonObjectStrokeCount(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenWDocSyncNoteTree WDocSyncData_getNoteTree(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getNoteTree(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WDocSyncData_getObjectStrokeCount(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getObjectStrokeCount(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final HashMap<String, SpenWDocSyncObjectStroke> WDocSyncData_getObjectStrokeMap(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getObjectStrokeMap(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncData_getState(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getState(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long WDocSyncData_getSyncModifiedTime(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getSyncModifiedTime(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<String> WDocSyncData_getTagList(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_getTagList(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int WDocSyncData_init(String appFilesDirPath) {
            return SpenWDocSyncData.WDocSyncData_init(appFilesDirPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_isConverted(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_isConverted(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_isFavorite(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_isFavorite(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_isLocked(int nativeHandle) {
            return SpenWDocSyncData.WDocSyncData_isLocked(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_parseXml(int nativeHandle, String xmlString) {
            return SpenWDocSyncData.WDocSyncData_parseXml(nativeHandle, xmlString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_readWDoc(int nativeHandle, String sdocxPath) {
            return SpenWDocSyncData.WDocSyncData_readWDoc(nativeHandle, sdocxPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_removeUnchangedData(int nativeHandle, long requestedNoteTreeNativeHandle) {
            return SpenWDocSyncData.WDocSyncData_removeUnchangedData(nativeHandle, requestedNoteTreeNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setAppNoteUuid(int nativeHandle, String uuid) {
            return SpenWDocSyncData.WDocSyncData_setAppNoteUuid(nativeHandle, uuid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setBookmark(int nativeHandle, String bookmark) {
            return SpenWDocSyncData.WDocSyncData_setBookmark(nativeHandle, bookmark);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setCommitId(int nativeHandle, String id) {
            return SpenWDocSyncData.WDocSyncData_setCommitId(nativeHandle, id);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setConverted(int nativeHandle, boolean flag) {
            return SpenWDocSyncData.WDocSyncData_setConverted(nativeHandle, flag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setDisplayCreatedTime(int nativeHandle, long time) {
            return SpenWDocSyncData.WDocSyncData_setDisplayCreatedTime(nativeHandle, time);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setDisplayModifiedTime(int nativeHandle, long time) {
            return SpenWDocSyncData.WDocSyncData_setDisplayModifiedTime(nativeHandle, time);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setFavorite(int nativeHandle, boolean flag) {
            return SpenWDocSyncData.WDocSyncData_setFavorite(nativeHandle, flag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setLocked(int nativeHandle, boolean flag) {
            return SpenWDocSyncData.WDocSyncData_setLocked(nativeHandle, flag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setMappedAt(int nativeHandle, long index) {
            return SpenWDocSyncData.WDocSyncData_setMappedAt(nativeHandle, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setMappedUuid(int nativeHandle, String uuid) {
            return SpenWDocSyncData.WDocSyncData_setMappedUuid(nativeHandle, uuid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setModelName(int nativeHandle, String name) {
            return SpenWDocSyncData.WDocSyncData_setModelName(nativeHandle, name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setMsLastSyncTime(int nativeHandle, long time) {
            return SpenWDocSyncData.WDocSyncData_setMsLastSyncTime(nativeHandle, time);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setMsSyncAccountId(int nativeHandle, String id) {
            return SpenWDocSyncData.WDocSyncData_setMsSyncAccountId(nativeHandle, id);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setMsSyncDocumentUuid(int nativeHandle, String uuid) {
            return SpenWDocSyncData.WDocSyncData_setMsSyncDocumentUuid(nativeHandle, uuid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setState(int nativeHandle, String state) {
            return SpenWDocSyncData.WDocSyncData_setState(nativeHandle, state);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setSyncModifiedTime(int nativeHandle, long time) {
            return SpenWDocSyncData.WDocSyncData_setSyncModifiedTime(nativeHandle, time);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_setTagList(int nativeHandle, ArrayList<String> tagList) {
            return SpenWDocSyncData.WDocSyncData_setTagList(nativeHandle, tagList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_update(int nativeHandle, long updatedPartDataNativeHandle) {
            return SpenWDocSyncData.WDocSyncData_update(nativeHandle, updatedPartDataNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncData_writeWDoc(int nativeHandle, String sdocxPath) {
            return SpenWDocSyncData.WDocSyncData_writeWDoc(nativeHandle, sdocxPath);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ce A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void printXml(@NotNull String sml_str) {
            List listEmptyList;
            List listEmptyList2;
            String[] strArr;
            Intrinsics.checkNotNullParameter(sml_str, "sml_str");
            Log.d(SpenWDocSyncData.LOG_TAG, "printXml");
            List<String> listSplit = new Regex("<").split(sml_str, 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            int length = 0;
            for (String str : (String[]) listEmptyList.toArray(new String[0])) {
                if (!TextUtils.isEmpty(str)) {
                    Log.d(SpenWDocSyncData.LOG_TAG, length + " : <" + str);
                    List<String> listSplit2 = new Regex(">").split(str, 0);
                    if (listSplit2.isEmpty()) {
                        listEmptyList2 = CollectionsKt.emptyList();
                        strArr = (String[]) listEmptyList2.toArray(new String[0]);
                        if (!StringsKt.m14167w(strArr[0], "/")) {
                        }
                        if (strArr.length <= 1) {
                        }
                    } else {
                        ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() != 0) {
                                listEmptyList2 = AbstractC12991c.m14000u(listIterator2, 1, listSplit2);
                                break;
                            }
                        }
                        listEmptyList2 = CollectionsKt.emptyList();
                        strArr = (String[]) listEmptyList2.toArray(new String[0]);
                        length = !StringsKt.m14167w(strArr[0], "/") ? length + 2 : length + 1;
                        if (strArr.length <= 1) {
                            length += strArr[1].length();
                        }
                    }
                }
            }
            AbstractC0541b.m755A(length, "Size = ", SpenWDocSyncData.LOG_TAG);
        }

        private Companion() {
        }
    }

    private SpenWDocSyncData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_composeXml(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void WDocSyncData_finalize(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getAppNoteUuid(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WDocSyncData_getBodyObjectCount(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getBookmark(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getCommitId(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getContentFileDirPath(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenWDocSyncContentFile> WDocSyncData_getContentFileList(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long WDocSyncData_getDisplayCreatedTime(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long WDocSyncData_getDisplayModifiedTime(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenWDocSyncData WDocSyncData_getDownSyncInstance(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long WDocSyncData_getMappedAt(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getMappedUuid(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getModelName(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long WDocSyncData_getMsLastSyncTime(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getMsSyncAccountId(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getMsSyncDocumentUuid(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WDocSyncData_getNonObjectStrokeCount(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenWDocSyncNoteTree WDocSyncData_getNoteTree(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WDocSyncData_getObjectStrokeCount(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native HashMap<String, SpenWDocSyncObjectStroke> WDocSyncData_getObjectStrokeMap(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncData_getState(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long WDocSyncData_getSyncModifiedTime(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<String> WDocSyncData_getTagList(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int WDocSyncData_init(String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_isConverted(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_isFavorite(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_isLocked(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_parseXml(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_readWDoc(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_removeUnchangedData(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setAppNoteUuid(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setBookmark(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setCommitId(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setConverted(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setDisplayCreatedTime(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setDisplayModifiedTime(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setFavorite(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setLocked(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setMappedAt(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setMappedUuid(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setModelName(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setMsLastSyncTime(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setMsSyncAccountId(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setMsSyncDocumentUuid(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setState(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setSyncModifiedTime(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_setTagList(int i, ArrayList<String> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_update(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncData_writeWDoc(int i, String str);

    private final void checkInitialized() {
        if (this.mNativeHandle == 0) {
            throw new IllegalStateException("native handle is not initialized");
        }
        if (!this.isInitialized) {
            throw new IllegalStateException("WDocSyncData is not initialized");
        }
    }

    private final void throwCheckedExceptionLoadWNote() throws SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        int error = SpenError.getError();
        if (error == 17) {
            throw new SpenInvalidPasswordException(AbstractC0541b.m772n("E_INVALID_PASSWORD : the password is wrong. : ", SpenError.getErrorModule()));
        }
        if (error == 19) {
            throw new SpenAlreadyClosedException("SpenWDocSyncData(" + this + ") is already closed.: " + SpenError.getErrorModule());
        }
        if (error == 24) {
            throw new SpenBoundFileNotFoundException(AbstractC0541b.m772n("E_BOUND_FILE_NOT_FOUND - Can not find bound file.: ", SpenError.getErrorModule()));
        }
        if (error == 25) {
            throw new SpenInvalidCacheException(AbstractC0541b.m772n("E_INVALID_CACHE - Cache is invalid.: ", SpenError.getErrorModule()));
        }
        switch (error) {
            case 10:
            case 11:
                throw new IOException(AbstractC2322a.m1616f(error, "errno(", ") ", SpenError.getErrorModule()));
            case 12:
                throw new SpenUnsupportedVersionException(AbstractC0541b.m772n("E_UNSUPPORTED_VERSION - Unsupported version of WNote file format. : ", SpenError.getErrorModule()));
            case 13:
                throw new SpenUnsupportedTypeException(AbstractC0541b.m772n("E_UNSUPPORTED_TYPE - It does not correspond to the WNote file format. : ", SpenError.getErrorModule()));
            default:
                SpenError.ThrowUncheckedException(error);
                return;
        }
    }

    private final void throwCheckedExceptionSaveWNote() throws IOException {
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throw new IOException(AbstractC2322a.m1616f(error, "errno(", ") ", SpenError.getErrorModule()));
        }
        if (error != 19) {
            if (error == 24) {
                throw new SpenBoundFileNotFoundException(AbstractC0541b.m772n("E_BOUND_FILE_NOT_FOUND - Can not find bound file.: ", SpenError.getErrorModule()));
            }
            if (error == 25) {
                throw new SpenInvalidCacheException(AbstractC0541b.m772n("E_INVALID_CACHE - Cache is invalid.: ", SpenError.getErrorModule()));
            }
            SpenError.ThrowUncheckedException(error);
            return;
        }
        throw new SpenAlreadyClosedException("SpenWDocSyncData(" + this + ") is already closed.: " + SpenError.getErrorModule());
    }

    private final void throwUncheckedException() {
        int error = SpenError.getError();
        if (error != 19) {
            SpenError.ThrowUncheckedException(error);
            return;
        }
        throw new SpenAlreadyClosedException("SpenWDocSyncData(" + this + ") is already closed");
    }

    @Nullable
    public final String composeXml() {
        checkInitialized();
        return INSTANCE.WDocSyncData_composeXml(this.mNativeHandle);
    }

    public final void finalize() {
        Log.i(LOG_TAG, "finalize() : " + hashCode());
        INSTANCE.WDocSyncData_finalize(this.mNativeHandle);
        this.mNativeHandle = 0;
    }

    @NotNull
    public final String getAppNoteUuid() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getAppNoteUuid(this.mNativeHandle);
    }

    public final int getBodyObjectCount() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getBodyObjectCount(this.mNativeHandle);
    }

    @NotNull
    public final String getBookmark() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getBookmark(this.mNativeHandle);
    }

    @NotNull
    public final String getCommitId() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getCommitId(this.mNativeHandle);
    }

    @NotNull
    public final String getContentFileDirPath() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getContentFileDirPath(this.mNativeHandle);
    }

    @NotNull
    public final ArrayList<SpenWDocSyncContentFile> getContentFileList() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getContentFileList(this.mNativeHandle);
    }

    public final long getDisplayCreatedTime() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getDisplayCreatedTime(this.mNativeHandle);
    }

    public final long getDisplayModifiedTime() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getDisplayModifiedTime(this.mNativeHandle);
    }

    @NotNull
    public final SpenWDocSyncData getDownSyncInstance() {
        return INSTANCE.WDocSyncData_getDownSyncInstance(this.mNativeHandle);
    }

    public final long getMappedAt() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getMappedAt(this.mNativeHandle);
    }

    @NotNull
    public final String getMappedUuid() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getMappedUuid(this.mNativeHandle);
    }

    @NotNull
    public final String getModelName() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getModelName(this.mNativeHandle);
    }

    public final long getMsLastSyncTime() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getMsLastSyncTime(this.mNativeHandle);
    }

    @NotNull
    public final String getMsSyncAccountId() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getMsSyncAccountId(this.mNativeHandle);
    }

    @NotNull
    public final String getMsSyncDocumentUuid() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getMsSyncDocumentUuid(this.mNativeHandle);
    }

    public final int getNonObjectStrokeCount() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getNonObjectStrokeCount(this.mNativeHandle);
    }

    @NotNull
    public final SpenWDocSyncNoteTree getNoteTree() {
        return INSTANCE.WDocSyncData_getNoteTree(this.mNativeHandle);
    }

    public final int getObjectStrokeCount() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getObjectStrokeCount(this.mNativeHandle);
    }

    @NotNull
    public final HashMap<String, SpenWDocSyncObjectStroke> getObjectStrokeMap() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getObjectStrokeMap(this.mNativeHandle);
    }

    @NotNull
    public final String getState() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getState(this.mNativeHandle);
    }

    public final long getSyncModifiedTime() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getSyncModifiedTime(this.mNativeHandle);
    }

    @NotNull
    public final ArrayList<String> getTagList() {
        checkInitialized();
        return INSTANCE.WDocSyncData_getTagList(this.mNativeHandle);
    }

    public final boolean isConverted() {
        checkInitialized();
        return INSTANCE.WDocSyncData_isConverted(this.mNativeHandle);
    }

    public final boolean isFavorite() {
        checkInitialized();
        return INSTANCE.WDocSyncData_isFavorite(this.mNativeHandle);
    }

    public final boolean isLocked() {
        checkInitialized();
        return INSTANCE.WDocSyncData_isLocked(this.mNativeHandle);
    }

    public final void parseXml(@Nullable String xmlString) throws SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        if (this.isInitialized) {
            throw new IllegalStateException("parseXml() - WDocSyncData is already initialized");
        }
        if (TextUtils.isEmpty(xmlString)) {
            throw new IllegalArgumentException("parseXml() - xml string is invalid");
        }
        if (!INSTANCE.WDocSyncData_parseXml(this.mNativeHandle, xmlString)) {
            throwCheckedExceptionLoadWNote();
        }
        this.isInitialized = true;
    }

    public final void readWDoc(@Nullable String sdocxPath) throws SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        if (this.isInitialized) {
            throw new IllegalStateException("readWDoc() - WDocSyncData is already initialized");
        }
        if (TextUtils.isEmpty(sdocxPath)) {
            throw new IllegalArgumentException("readWDoc() - sdocx path is invalid");
        }
        if (!INSTANCE.WDocSyncData_readWDoc(this.mNativeHandle, sdocxPath)) {
            throwCheckedExceptionLoadWNote();
        }
        this.isInitialized = true;
    }

    public final void removeUnchangedData(@NotNull SpenWDocSyncNoteTree requestedNoteTree) {
        Intrinsics.checkNotNullParameter(requestedNoteTree, "requestedNoteTree");
        checkInitialized();
        if (INSTANCE.WDocSyncData_removeUnchangedData(this.mNativeHandle, requestedNoteTree.getNativeHandle())) {
            return;
        }
        throwUncheckedException();
    }

    public final void setAppNoteUuid(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setAppNoteUuid(this.mNativeHandle, uuid)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setBookmark(@NotNull String bookmark) {
        Intrinsics.checkNotNullParameter(bookmark, "bookmark");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setBookmark(this.mNativeHandle, bookmark)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setCommitId(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setCommitId(this.mNativeHandle, id)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setConverted(boolean z) {
        checkInitialized();
        if (INSTANCE.WDocSyncData_setConverted(this.mNativeHandle, z)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setDisplayCreatedTime(long j) {
        checkInitialized();
        if (INSTANCE.WDocSyncData_setDisplayCreatedTime(this.mNativeHandle, j)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setDisplayModifiedTime(long j) {
        checkInitialized();
        if (INSTANCE.WDocSyncData_setDisplayModifiedTime(this.mNativeHandle, j)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setFavorite(boolean z) {
        checkInitialized();
        if (INSTANCE.WDocSyncData_setFavorite(this.mNativeHandle, z)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setLocked(boolean z) {
        checkInitialized();
        if (INSTANCE.WDocSyncData_setLocked(this.mNativeHandle, z)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setMappedAt(long j) {
        checkInitialized();
        if (INSTANCE.WDocSyncData_setMappedAt(this.mNativeHandle, j)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setMappedUuid(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setMappedUuid(this.mNativeHandle, uuid)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setModelName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setModelName(this.mNativeHandle, name)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setMsLastSyncTime(long j) {
        checkInitialized();
        if (INSTANCE.WDocSyncData_setMsLastSyncTime(this.mNativeHandle, j)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setMsSyncAccountId(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setMsSyncAccountId(this.mNativeHandle, id)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setMsSyncDocumentUuid(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setMsSyncDocumentUuid(this.mNativeHandle, uuid)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setState(@NotNull String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setState(this.mNativeHandle, state)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setSyncModifiedTime(long j) {
        checkInitialized();
        if (INSTANCE.WDocSyncData_setSyncModifiedTime(this.mNativeHandle, j)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setTagList(@NotNull ArrayList<String> tagList) {
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        checkInitialized();
        if (INSTANCE.WDocSyncData_setTagList(this.mNativeHandle, tagList)) {
            return;
        }
        throwUncheckedException();
    }

    public final void update(@NotNull SpenWDocSyncData updatedPartData) {
        Intrinsics.checkNotNullParameter(updatedPartData, "updatedPartData");
        checkInitialized();
        if (INSTANCE.WDocSyncData_update(this.mNativeHandle, updatedPartData.mNativeHandle)) {
            return;
        }
        throwUncheckedException();
    }

    public final void writeWDoc(@Nullable String sdocxPath) throws IOException {
        checkInitialized();
        if (TextUtils.isEmpty(sdocxPath)) {
            throw new IllegalArgumentException("writeWDoc() - sdocx path is invalid");
        }
        if (INSTANCE.WDocSyncData_writeWDoc(this.mNativeHandle, sdocxPath)) {
            return;
        }
        throwCheckedExceptionSaveWNote();
    }

    public SpenWDocSyncData(@Nullable Context context) {
        this.mContext = context;
        Companion companion = INSTANCE;
        Intrinsics.checkNotNull(context);
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        int iWDocSyncData_init = companion.WDocSyncData_init(absolutePath);
        this.mNativeHandle = iWDocSyncData_init;
        if (iWDocSyncData_init == 0) {
            throwUncheckedException();
        }
    }
}
