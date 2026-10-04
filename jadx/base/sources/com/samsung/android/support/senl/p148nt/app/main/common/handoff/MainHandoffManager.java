package com.samsung.android.support.senl.p148nt.app.main.common.handoff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.RecentlyImported;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.model.MainHandoffData;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p044K.C0158a;
import p070Q1.RunnableC0218a;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 S2\u00020\u0001:\u0001SB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\u0006\u0010 \u001a\u00020!H\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0010\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010*\u001a\u00020\u000fJ\u0006\u0010+\u001a\u00020\u000fJ\u001a\u0010,\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010.\u001a\u00020\u000fJ\u001a\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010\u000b2\b\u00101\u001a\u0004\u0018\u00010\u000bJ\u0006\u00102\u001a\u00020\u000fJ\u0010\u00103\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u00010\u000bJ\u0016\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u001a\u00109\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u00107\u001a\u000208H\u0002J\u001a\u0010:\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010\u000b2\u0006\u00107\u001a\u000208H\u0002J \u0010<\u001a\u00020\u00162\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010#2\u0006\u00107\u001a\u000208H\u0002J\"\u0010>\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u000b2\u0006\u00107\u001a\u000208H\u0002J$\u0010@\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010\u000b2\b\u00101\u001a\u0004\u0018\u00010\u000b2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010A\u001a\u00020\u00162\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010B\u001a\u00020\u00162\u0006\u00107\u001a\u000208H\u0002J$\u0010C\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010\u000b2\b\u00101\u001a\u0004\u0018\u00010\u000b2\u0006\u00107\u001a\u000208H\u0002J\"\u0010D\u001a\u00020\u00162\u0006\u00105\u001a\u0002062\b\u0010E\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bJ \u0010F\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u001a\u0010I\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010J\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u000bH\u0002J\u0010\u0010M\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000106J\u0012\u0010N\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0010\u0010O\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u0006H\u0002R.\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006T"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffManager;", "", "<init>", "()V", "mLastDataMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/model/MainHandoffData;", "Lkotlin/collections/HashMap;", "mBackStackDataMap", "mTopActivityMap", "", "mVersionManager", "Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffVersionManager;", "isHandoffAction", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "canStartMain", "actionType", "mainHandoffData", "updateHandoffDataCanNotStartMainList", "", "updateHandoffDataCanNotStartTagNote", "updateHandoffDataCanNotStartOldNote", "updateHandoffDataCanNotStartGCSNote", "updateHandoffDataCanNotStartOldList", "updateHandoffDataCanNotStartGCSList", "updateHandoffDataCanNotStartCoeidt", "updateHandoffDataCanNotStartCoeditSpace", "updateDefaultHandoffData", HandoffConstant.GET_HANDOFF_DATA, "metaData", "Lorg/json/JSONObject;", "getValidSelectedTags", "", "getTags", "tagEntities", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesTagEntity;", "canStartMainList", NotesConstants.KEY_FOLDER_UUID, "canStartTagNote", "hasOldNoteInUse", "canStartOldNote", "categoryUuid", "canStartGCSList", "canStartGCSNote", "groupId", "spaceId", "canStartCoedit", "canStartCoeditSpace", "openNoteByHandoff", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "args", "Landroid/os/Bundle;", "openNoteByHandoffActionFolderMove", "openNoteByHandoffActionSearch", "searchText", "openNoteByHandoffActionTagNote", "selectedTags", "openNoteByHandoffActionOldNote", "oldCategoryUuid", "openNoteByHandoffActionGCSNote", "openNoteByHandoffActionOldList", "openNoteByHandoffActionCoedit", "openNoteByHandoffActionCoeditSpace", "handleHandoffAction", "activityType", "sendHandoffAction", "taskId", "mode", "sendHandoffActionInternal", "enableMainListHandoff", "isMainHandoffEnabled", NotesConstants.KEY_CALLER, "releaseHandoffAction", "releaseHandoffActionInternal", HandoffConstant.DISABLE_HANDOFF, "versionManager", "getVersionManager", "()Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffVersionManager;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MainHandoffManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "MainHandoffManager";

    @NotNull
    private static final ExecutorService mExecutorService;

    @Nullable
    private static MainHandoffManager mInstance;

    @NotNull
    private HashMap<Integer, MainHandoffData> mBackStackDataMap;

    @NotNull
    private HashMap<Integer, MainHandoffData> mLastDataMap;

    @NotNull
    private HashMap<Integer, String> mTopActivityMap;

    @Nullable
    private MainHandoffVersionManager mVersionManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "mInstance", "Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffManager;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized MainHandoffManager getInstance() {
            MainHandoffManager mainHandoffManager;
            try {
                if (MainHandoffManager.mInstance == null) {
                    MainHandoffManager.mInstance = new MainHandoffManager(null);
                }
                mainHandoffManager = MainHandoffManager.mInstance;
                Intrinsics.checkNotNull(mainHandoffManager);
            } catch (Throwable th) {
                throw th;
            }
            return mainHandoffManager;
        }

        private Companion() {
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        mExecutorService = executorServiceNewSingleThreadExecutor;
    }

    public /* synthetic */ MainHandoffManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void disableHandoff(int taskId) {
        HandoffUtils.INSTANCE.getInstance().disableHandoff();
        this.mLastDataMap.remove(Integer.valueOf(taskId));
        this.mBackStackDataMap.remove(Integer.valueOf(taskId));
        if (this.mLastDataMap.isEmpty() && this.mBackStackDataMap.isEmpty()) {
            mInstance = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0 A[Catch: JSONException -> 0x004f, TryCatch #0 {JSONException -> 0x004f, blocks: (B:6:0x0014, B:8:0x0028, B:12:0x0035, B:15:0x003f, B:43:0x00e1, B:18:0x0052, B:21:0x005c, B:22:0x0067, B:25:0x0070, B:26:0x007f, B:29:0x0088, B:30:0x0092, B:33:0x009b, B:34:0x00ab, B:36:0x00b1, B:37:0x00bb, B:38:0x00c1, B:41:0x00c8, B:42:0x00d0), top: B:47:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void enableMainListHandoff(MainHandoffData mainHandoffData) {
        if (isMainHandoffEnabled("enableMainListHandoff")) {
            JSONObject jSONObject = new JSONObject();
            try {
                String mActivityType = mainHandoffData.getMActivityType();
                String mActionType = mainHandoffData.getMActionType();
                jSONObject.put(HandoffConstant.KEY_ACTIVITY_TYPE, mActivityType);
                jSONObject.put("action", mActionType);
                if (mActionType != null) {
                    switch (mActionType.hashCode()) {
                        case -906336856:
                            if (!mActionType.equals("search")) {
                                MainLogger.m7255e(TAG, "enableMainListHandoff# unexpected action: " + mActionType);
                                Unit unit = Unit.INSTANCE;
                            } else {
                                jSONObject.put("search", mainHandoffData.getMSearchText());
                            }
                            break;
                        case -763995785:
                            if (!mActionType.equals("tag_note")) {
                                MainLogger.m7255e(TAG, "enableMainListHandoff# unexpected action: " + mActionType);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                JSONArray jSONArray = new JSONArray();
                                Set<String> selectedTags = mainHandoffData.getSelectedTags();
                                Intrinsics.checkNotNull(selectedTags);
                                Iterator<String> it = selectedTags.iterator();
                                while (it.hasNext()) {
                                    jSONArray.put(it.next());
                                }
                                jSONObject.put("tags", jSONArray);
                            }
                            break;
                        case 110587138:
                            if (!mActionType.equals("folder_move")) {
                                MainLogger.m7255e(TAG, "enableMainListHandoff# unexpected action: " + mActionType);
                                Unit unit22 = Unit.INSTANCE;
                            } else {
                                jSONObject.put("folder", mainHandoffData.getMFolderUuid());
                            }
                            break;
                        case 172863514:
                            if (!mActionType.equals("gcs_note")) {
                                MainLogger.m7255e(TAG, "enableMainListHandoff# unexpected action: " + mActionType);
                                Unit unit222 = Unit.INSTANCE;
                            } else {
                                jSONObject.put("group", mainHandoffData.getMGroupId());
                                jSONObject.put("space", mainHandoffData.getMSpaceId());
                            }
                            break;
                        case 198605578:
                            if (!mActionType.equals("old_note")) {
                                MainLogger.m7255e(TAG, "enableMainListHandoff# unexpected action: " + mActionType);
                                Unit unit2222 = Unit.INSTANCE;
                            } else {
                                jSONObject.put("category", mainHandoffData.getMCategoryUuid());
                            }
                            break;
                        case 283445245:
                            if (!mActionType.equals("coedit_space")) {
                                MainLogger.m7255e(TAG, "enableMainListHandoff# unexpected action: " + mActionType);
                                Unit unit22222 = Unit.INSTANCE;
                            } else {
                                jSONObject.put("group", mainHandoffData.getMGroupId());
                                jSONObject.put("space", mainHandoffData.getMSpaceId());
                            }
                            break;
                        default:
                            MainLogger.m7255e(TAG, "enableMainListHandoff# unexpected action: " + mActionType);
                            Unit unit222222 = Unit.INSTANCE;
                            break;
                    }
                }
                MainLogger.m7258i(TAG, "enableMainListHandoff# " + mainHandoffData);
                HandoffUtils.INSTANCE.getInstance().enableHandoff(jSONObject);
            } catch (JSONException e) {
                MainLogger.m7255e(TAG, e.getMessage());
            }
        }
    }

    private final Set<String> getTags(List<? extends NotesTagEntity> tagEntities) {
        HashSet hashSet = new HashSet();
        Iterator<? extends NotesTagEntity> it = tagEntities.iterator();
        while (it.hasNext()) {
            String normalizeName = it.next().getNormalizeName();
            Intrinsics.checkNotNullExpressionValue(normalizeName, "getNormalizeName(...)");
            hashSet.add(normalizeName);
        }
        return hashSet;
    }

    private final Set<String> getValidSelectedTags(JSONObject metaData) {
        HashSet hashSet = new HashSet();
        try {
            Object obj = metaData.get("tags");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            if (length > 0) {
                List<NotesTagEntity> allTags = DataManager.getInstance().getAllTags();
                Intrinsics.checkNotNullExpressionValue(allTags, "getAllTags(...)");
                Set<String> tags = getTags(allTags);
                for (int i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if (tags.contains(string)) {
                        Intrinsics.checkNotNull(string);
                        hashSet.add(string);
                    }
                }
            }
            return hashSet;
        } catch (JSONException e) {
            AbstractC6670b.m4738C("getValidSelectedTags# JSONException: ", e.getMessage(), TAG);
            return hashSet;
        }
    }

    private final MainHandoffVersionManager getVersionManager() {
        if (this.mVersionManager == null) {
            this.mVersionManager = new MainHandoffVersionManager();
        }
        MainHandoffVersionManager mainHandoffVersionManager = this.mVersionManager;
        Intrinsics.checkNotNull(mainHandoffVersionManager);
        return mainHandoffVersionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleHandoffAction$lambda$0(Activity activity, MainHandoffManager mainHandoffManager, String str, String str2) {
        if (CommonUtil.isNotAvailableActivity(activity) || mainHandoffManager.isHandoffAction(activity.getIntent())) {
            return;
        }
        mainHandoffManager.sendHandoffActionInternal(activity.getTaskId(), new MainHandoffData.HandoffDataBuilder().setActivityType(str).setActionType(str2).getMMainHandoffData());
    }

    private final boolean isMainHandoffEnabled(String caller) {
        return HandoffUtils.INSTANCE.getInstance().isHandoffEnabled(caller);
    }

    private final void openNoteByHandoffActionCoedit(Bundle args) {
        if (canStartCoedit()) {
            args.putInt("mode", 12);
            args.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.Coedit.UUID);
        } else {
            args.putInt("mode", 1);
            args.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.AllNotes.UUID);
        }
    }

    private final void openNoteByHandoffActionCoeditSpace(String groupId, String spaceId, Bundle args) {
        if (!canStartCoeditSpace(spaceId)) {
            openNoteByHandoffActionCoedit(args);
            return;
        }
        args.putInt("mode", 14);
        args.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.Coedit.UUID);
        args.putString(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.KEY_GROUP_ID, groupId);
        args.putString(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.KEY_SPACE_ID, spaceId);
    }

    private final void openNoteByHandoffActionFolderMove(String folderUuid, Bundle args) {
        if (!canStartMainList(folderUuid)) {
            folderUuid = FolderConstants.AllNotes.UUID;
        }
        if (Intrinsics.areEqual(FolderConstants.RecycleBin.UUID, folderUuid)) {
            args.putInt("mode", 5);
        } else {
            args.putInt("mode", 1);
        }
        args.putString(NotesConstants.KEY_FOLDER_UUID, folderUuid);
    }

    private final void openNoteByHandoffActionGCSNote(String groupId, String spaceId, Bundle args) {
        if (canStartGCSNote(groupId, spaceId)) {
            args.putString(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.KEY_GROUP_ID, groupId);
            args.putString(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.KEY_SPACE_ID, spaceId);
        } else {
            args.putInt("mode", 1);
            args.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.AllNotes.UUID);
        }
    }

    private final void openNoteByHandoffActionOldList(Bundle args) {
        if (hasOldNoteInUse()) {
            args.putInt("mode", 23);
            args.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.OldNotes.UUID);
        } else {
            args.putInt("mode", 1);
            args.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.AllNotes.UUID);
        }
    }

    private final void openNoteByHandoffActionOldNote(String actionType, String oldCategoryUuid, Bundle args) {
        if (canStartOldNote(actionType, oldCategoryUuid)) {
            args.putInt("mode", 21);
            args.putString(NotesConstants.KEY_CATEGORY_UUID, oldCategoryUuid);
        } else {
            args.putInt("mode", 1);
            args.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.AllNotes.UUID);
        }
    }

    private final void openNoteByHandoffActionSearch(String searchText, Bundle args) {
        args.putInt("mode", 3);
        args.putString(NotesConstants.BUNDLE_KEY_SEARCH, searchText);
    }

    private final void openNoteByHandoffActionTagNote(Set<String> selectedTags, Bundle args) {
        if (!canStartTagNote()) {
            args.putInt("mode", 1);
            args.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.AllNotes.UUID);
        } else {
            args.putInt("mode", 18);
            args.putString(NotesConstants.KEY_FOLDER_UUID, "tag:///");
            args.putSerializable(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.KEY_SELECTED_TAGS, (Serializable) selectedTags);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseHandoffActionInternal(Activity activity) {
        if (activity == null || isHandoffAction(activity.getIntent())) {
            return;
        }
        HandoffUtils.Companion companion = HandoffUtils.INSTANCE;
        int lastHandoffCaller = companion.getInstance().getLastHandoffCaller();
        AbstractC8014b.m7201c(lastHandoffCaller, "releaseHandoffAction, lastHandoffCaller: ", TAG);
        if (lastHandoffCaller == 0 && Intrinsics.areEqual(companion.getInstance().getActivityTypeFromClass(activity.getClass()), this.mTopActivityMap.get(Integer.valueOf(activity.getTaskId())))) {
            disableHandoff(activity.getTaskId());
        } else {
            MainLogger.m7258i(TAG, "releaseHandoffAction, skip");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHandoffAction$lambda$1(MainHandoffData mainHandoffData, int i, MainHandoffManager mainHandoffManager, int i2) {
        if (mainHandoffData == null) {
            return;
        }
        if (1 == i || 5 == i) {
            mainHandoffData.setActionType("folder_move");
        } else if (18 == i) {
            mainHandoffData.setActionType("tag_note");
        } else if (21 == i) {
            mainHandoffData.setActionType("old_note");
        } else if (24 == i) {
            mainHandoffData.setActionType("gcs_list");
        } else if (10 == i) {
            mainHandoffData.setActionType("gcs_note");
        } else if (12 == i) {
            mainHandoffData.setActionType("coedit");
        } else if (14 == i) {
            mainHandoffData.setActionType("coedit_space");
        } else if (3 != i) {
            return;
        } else {
            mainHandoffData.setActionType("search");
        }
        mainHandoffManager.sendHandoffActionInternal(i2, mainHandoffData);
    }

    private final void sendHandoffActionInternal(int taskId, MainHandoffData mainHandoffData) {
        String string;
        String string2;
        if (mainHandoffData != null && isMainHandoffEnabled("sendHandoffActionInternal")) {
            this.mTopActivityMap.put(Integer.valueOf(taskId), mainHandoffData.getMActivityType());
            MainHandoffData mainHandoffData2 = this.mLastDataMap.get(Integer.valueOf(taskId));
            if (Intrinsics.areEqual(mainHandoffData, mainHandoffData2) && HandoffUtils.INSTANCE.getInstance().getLastHandoffCaller() == 0) {
                AbstractC6670b.m4739D("sendHandoffActionInternal# same HandoffAction is called, sync enabled: ", TAG, C0158a.m407a().m417k());
                return;
            }
            MainLogger.m7258i(TAG, "sendHandoffActionInternal# ");
            boolean zAreEqual = Intrinsics.areEqual("search", mainHandoffData.getMActionType());
            String str = XMPConst.ARRAY_ITEM_NAME;
            if (zAreEqual || Intrinsics.areEqual("tag_note", mainHandoffData.getMActionType())) {
                this.mLastDataMap.put(Integer.valueOf(taskId), this.mBackStackDataMap.get(Integer.valueOf(taskId)));
                if (mainHandoffData2 != null && (string = mainHandoffData2.toString()) != null) {
                    str = string;
                }
                MainLogger.m7258i(TAG, "sendHandoffActionInternal# restore LastData as BackStackData: ".concat(str));
            } else {
                if (!mainHandoffData.isSameAction(mainHandoffData2)) {
                    this.mBackStackDataMap.put(Integer.valueOf(taskId), mainHandoffData2);
                    if (mainHandoffData2 != null && (string2 = mainHandoffData2.toString()) != null) {
                        str = string2;
                    }
                    MainLogger.m7258i(TAG, "sendHandoffActionInternal# save mBackStackData: ".concat(str));
                }
                MainLogger.m7258i(TAG, "sendHandoffActionInternal# taskId: [" + taskId + "]  " + mainHandoffData);
                this.mLastDataMap.put(Integer.valueOf(taskId), mainHandoffData);
            }
            enableMainListHandoff(mainHandoffData);
        }
    }

    private final void updateDefaultHandoffData(MainHandoffData mainHandoffData) {
        mainHandoffData.setActivityType("Main");
        mainHandoffData.setActionType("folder_move");
        mainHandoffData.setFolderUuid(FolderConstants.AllNotes.UUID);
    }

    private final void updateHandoffDataCanNotStartCoeditSpace(MainHandoffData mainHandoffData) {
        if (canStartCoeditSpace(mainHandoffData.getMSpaceId())) {
            return;
        }
        if (!canStartCoedit()) {
            updateDefaultHandoffData(mainHandoffData);
        } else {
            mainHandoffData.setActivityType("Main");
            mainHandoffData.setActionType("coedit");
        }
    }

    private final void updateHandoffDataCanNotStartCoeidt(MainHandoffData mainHandoffData) {
        if (canStartCoedit()) {
            return;
        }
        updateDefaultHandoffData(mainHandoffData);
    }

    private final void updateHandoffDataCanNotStartGCSList(MainHandoffData mainHandoffData) {
        if (canStartGCSList()) {
            return;
        }
        updateDefaultHandoffData(mainHandoffData);
    }

    private final void updateHandoffDataCanNotStartGCSNote(MainHandoffData mainHandoffData) {
        if (canStartGCSNote(mainHandoffData.getMFolderUuid(), mainHandoffData.getMSpaceId())) {
            return;
        }
        if (!canStartGCSList()) {
            updateDefaultHandoffData(mainHandoffData);
        } else {
            mainHandoffData.setActivityType("Main");
            mainHandoffData.setActionType("gcs_list");
        }
    }

    private final void updateHandoffDataCanNotStartMainList(MainHandoffData mainHandoffData) {
        if (canStartMainList(mainHandoffData.getMFolderUuid())) {
            return;
        }
        mainHandoffData.setFolderUuid(FolderConstants.AllNotes.UUID);
    }

    private final void updateHandoffDataCanNotStartOldList(MainHandoffData mainHandoffData) {
        if (hasOldNoteInUse()) {
            return;
        }
        updateDefaultHandoffData(mainHandoffData);
    }

    private final void updateHandoffDataCanNotStartOldNote(MainHandoffData mainHandoffData) {
        if (canStartOldNote(mainHandoffData.getMActionType(), mainHandoffData.getMCategoryUuid())) {
            return;
        }
        if (!hasOldNoteInUse()) {
            updateDefaultHandoffData(mainHandoffData);
        } else {
            mainHandoffData.setActivityType("Main");
            mainHandoffData.setActionType("old_list");
        }
    }

    private final void updateHandoffDataCanNotStartTagNote(MainHandoffData mainHandoffData) {
        if (canStartTagNote()) {
            return;
        }
        updateDefaultHandoffData(mainHandoffData);
    }

    public final boolean canStartCoedit() {
        return NotesUtils.isCoeditFeatureEnabled(BaseUtils.getApplicationContext());
    }

    public final boolean canStartCoeditSpace(@Nullable String spaceId) {
        if (canStartCoedit()) {
            return SesCoeditShareReadResolver.getInstance().isSpaceExist(spaceId);
        }
        return false;
    }

    public final boolean canStartGCSList() {
        return NotesUtils.getPreferenceMDESupported();
    }

    public final boolean canStartGCSNote(@Nullable String groupId, @Nullable String spaceId) {
        String groupId2;
        return canStartGCSList() && (groupId2 = SesShareReadResolver.getInstance().getGroupId(spaceId)) != null && Intrinsics.areEqual(groupId2, groupId);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        if (r4.equals("folder_list") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0096, code lost:
    
        if (r4.equals("search") == false) goto L53;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean canStartMain(@NotNull String actionType, @NotNull MainHandoffData mainHandoffData) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(mainHandoffData, "mainHandoffData");
        switch (actionType.hashCode()) {
            case -1355062154:
                if (actionType.equals("coedit")) {
                    updateHandoffDataCanNotStartCoeidt(mainHandoffData);
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            case -906336856:
                break;
            case -764061149:
                if (actionType.equals("tag_list")) {
                    MainLogger.m7258i(TAG, "removed actionType: ".concat(actionType));
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            case -763995785:
                if (actionType.equals("tag_note")) {
                    updateHandoffDataCanNotStartTagNote(mainHandoffData);
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            case 110551503:
                break;
            case 110587138:
                if (actionType.equals("folder_move")) {
                    updateHandoffDataCanNotStartMainList(mainHandoffData);
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            case 172798150:
                if (actionType.equals("gcs_list")) {
                    updateHandoffDataCanNotStartGCSList(mainHandoffData);
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            case 172863514:
                if (actionType.equals("gcs_note")) {
                    updateHandoffDataCanNotStartGCSNote(mainHandoffData);
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            case 198540214:
                if (actionType.equals("old_list")) {
                    updateHandoffDataCanNotStartOldList(mainHandoffData);
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            case 198605578:
                if (actionType.equals("old_note")) {
                    updateHandoffDataCanNotStartOldNote(mainHandoffData);
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            case 283445245:
                if (actionType.equals("coedit_space")) {
                    updateHandoffDataCanNotStartCoeditSpace(mainHandoffData);
                }
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
            default:
                MainLogger.m7258i(TAG, "unexpected actionType: ".concat(actionType));
                break;
        }
        return true;
    }

    public final boolean canStartMainList(@Nullable String folderUuid) {
        if (!FeatureUtils.isPreDefinedFolderUuid(folderUuid)) {
            return (TextUtils.isEmpty(folderUuid) || FolderManager.getInstance().getCategoryEntity(folderUuid) == null) ? false : true;
        }
        if (Intrinsics.areEqual("lock:///", folderUuid)) {
            return DataManager.getInstance().getAllLockedDataCount() > 0;
        }
        if (Intrinsics.areEqual("favorite:///", folderUuid)) {
            return DataManager.getInstance().getFavoriteItemCount() > 0;
        }
        if (!Intrinsics.areEqual("recentlyImported:///", folderUuid)) {
            return true;
        }
        MainListDocumentDataRepository mainListRepository = RepositoryManager.INSTANCE.getInstance().getMainListRepository();
        if (mainListRepository != null) {
            String selection = new RecentlyImported().getSelection();
            Intrinsics.checkNotNullExpressionValue(selection, "getSelection(...)");
            if (!mainListRepository.rawQuery(new SimpleSQLiteQuery(selection)).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean canStartOldNote(@Nullable String actionType, @Nullable String categoryUuid) {
        if (Intrinsics.areEqual("search", actionType)) {
            return true;
        }
        boolean zAreEqual = Intrinsics.areEqual("old_converted_notes", categoryUuid);
        return (zAreEqual && DataManager.getInstance().getAll_ConvertedCount() > 0) || !(zAreEqual || FolderManager.getInstance().getCategoryEntity(categoryUuid) == null);
    }

    public final boolean canStartTagNote() {
        List<MainListDocumentData> allWithTag = DataManager.getInstance().getAllWithTag();
        return (allWithTag == null || allWithTag.isEmpty()) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012f A[Catch: JSONException -> 0x006d, TRY_LEAVE, TryCatch #0 {JSONException -> 0x006d, blocks: (B:7:0x0021, B:9:0x003e, B:13:0x004b, B:16:0x0055, B:19:0x0070, B:22:0x007a, B:23:0x0089, B:55:0x0125, B:26:0x0093, B:29:0x009d, B:30:0x00b5, B:33:0x00bf, B:36:0x00c9, B:37:0x00d8, B:40:0x00e1, B:43:0x00ea, B:44:0x00f6, B:47:0x00ff, B:48:0x0109, B:51:0x0110, B:52:0x011c, B:56:0x012f), top: B:61:0x0021 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MainHandoffData getHandoffData(@NotNull JSONObject metaData) {
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        if (!getVersionManager().revisionOperation(metaData)) {
            return null;
        }
        MainHandoffData.HandoffDataBuilder handoffDataBuilder = new MainHandoffData.HandoffDataBuilder();
        try {
            String string = metaData.getString(HandoffConstant.KEY_ACTIVITY_TYPE);
            String string2 = metaData.getString("action");
            boolean z = metaData.getBoolean(HandoffConstant.KEY_SYNC_ENABLED);
            handoffDataBuilder.setActivityType(string);
            handoffDataBuilder.setActionType(string2);
            handoffDataBuilder.setSyncEnabledOnSender(z);
            if (string2 != null) {
                switch (string2.hashCode()) {
                    case -1355062154:
                        if (!string2.equals("coedit")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit = Unit.INSTANCE;
                        }
                        MainLogger.m7258i(TAG, "actionType: ".concat(string2));
                        Unit unit2 = Unit.INSTANCE;
                        break;
                    case -906336856:
                        if (!string2.equals("search")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit3 = Unit.INSTANCE;
                        } else {
                            handoffDataBuilder.setSearchText(metaData.getString("search")).getMMainHandoffData();
                        }
                        break;
                    case -764061149:
                        if (!string2.equals("tag_list")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit32 = Unit.INSTANCE;
                        } else {
                            MainLogger.m7258i(TAG, "removed actionType: ".concat(string2));
                            Unit unit4 = Unit.INSTANCE;
                        }
                        break;
                    case -763995785:
                        if (!string2.equals("tag_note")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit322 = Unit.INSTANCE;
                        } else {
                            handoffDataBuilder.setSelectedTags(getValidSelectedTags(metaData)).getMMainHandoffData();
                        }
                        break;
                    case 110551503:
                        if (!string2.equals("folder_list")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit3222 = Unit.INSTANCE;
                        }
                        MainLogger.m7258i(TAG, "actionType: ".concat(string2));
                        Unit unit22 = Unit.INSTANCE;
                        break;
                    case 110587138:
                        if (!string2.equals("folder_move")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit32222 = Unit.INSTANCE;
                        } else {
                            handoffDataBuilder.setFolderUuid(metaData.getString("folder")).getMMainHandoffData();
                        }
                        break;
                    case 172798150:
                        if (!string2.equals("gcs_list")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit322222 = Unit.INSTANCE;
                        }
                        MainLogger.m7258i(TAG, "actionType: ".concat(string2));
                        Unit unit222 = Unit.INSTANCE;
                        break;
                    case 172863514:
                        if (!string2.equals("gcs_note")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit3222222 = Unit.INSTANCE;
                        } else {
                            handoffDataBuilder.setGroupId(metaData.getString("group")).getMMainHandoffData();
                            handoffDataBuilder.setSpaceId(metaData.getString("space")).getMMainHandoffData();
                        }
                        break;
                    case 198540214:
                        if (!string2.equals("old_list")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit32222222 = Unit.INSTANCE;
                        }
                        MainLogger.m7258i(TAG, "actionType: ".concat(string2));
                        Unit unit2222 = Unit.INSTANCE;
                        break;
                    case 198605578:
                        if (!string2.equals("old_note")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit322222222 = Unit.INSTANCE;
                        } else {
                            handoffDataBuilder.setCategoryUuid(metaData.getString("category")).getMMainHandoffData();
                        }
                        break;
                    case 283445245:
                        if (!string2.equals("coedit_space")) {
                            MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                            Unit unit3222222222 = Unit.INSTANCE;
                        } else {
                            handoffDataBuilder.setGroupId(metaData.getString("group")).getMMainHandoffData();
                            handoffDataBuilder.setSpaceId(metaData.getString("space")).getMMainHandoffData();
                        }
                        break;
                    default:
                        MainLogger.m7258i(TAG, "unexpected actionType: " + string2);
                        Unit unit32222222222 = Unit.INSTANCE;
                        break;
                }
            }
        } catch (JSONException e) {
            AbstractC6670b.m4738C("getHandoffData#JSONException# ", e.getMessage(), TAG);
        }
        return handoffDataBuilder.getMMainHandoffData();
    }

    public final void handleHandoffAction(@NotNull Activity activity, @Nullable String activityType, @Nullable String actionType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        mExecutorService.execute(new RunnableC0218a(activity, this, activityType, actionType, 9));
    }

    public final boolean hasOldNoteInUse() {
        return DataManager.getInstance().hasOldNoteInUse();
    }

    public final boolean isHandoffAction(@Nullable Intent intent) {
        return (intent == null || intent.getAction() == null || !StringsKt__StringsJVMKt.equals(intent.getAction(), com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ACTION_HANDOFF, true)) ? false : true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int openNoteByHandoff(@NotNull Activity activity, @NotNull Bundle args) {
        Intent intent;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(args, "args");
        if (CommonUtil.isNotAvailableActivity(activity) || (intent = activity.getIntent()) == null) {
            return 0;
        }
        MainHandoffData mMainHandoffData = (MainHandoffData) intent.getSerializableExtra(HandoffConstant.KEY_HANDOFF_DATA);
        if (mMainHandoffData == null) {
            mMainHandoffData = new MainHandoffData.HandoffDataBuilder().setActionType("folder_move").setFolderUuid(FolderConstants.AllNotes.UUID).getMMainHandoffData();
        }
        if (!C0158a.m407a().m417k()) {
            HandoffUtils.INSTANCE.getInstance().showDialogDisableSyncTurnOn(new WeakReference<>(activity), null, null);
        } else if (!mMainHandoffData.getMIsSyncEnabledOnSender()) {
            HandoffUtils.INSTANCE.getInstance().showTurnOnSyncToast();
        }
        int i = intent.getBooleanExtra(HandoffConstant.KEY_HANDLE_HANDOFF_BASED_ON_CURRENT_ACTIVITY, false) ? 0 : 7;
        args.putInt(NotesConstants.KEY_CALLER, i);
        String mActionType = mMainHandoffData.getMActionType();
        if (mActionType != null) {
            switch (mActionType.hashCode()) {
                case -1355062154:
                    if (mActionType.equals("coedit")) {
                        openNoteByHandoffActionCoedit(args);
                        return i;
                    }
                    break;
                case -906336856:
                    if (mActionType.equals("search")) {
                        openNoteByHandoffActionSearch(mMainHandoffData.getMSearchText(), args);
                        return i;
                    }
                    break;
                case -764061149:
                    if (mActionType.equals("tag_list")) {
                        MainLogger.m7258i(TAG, "openNoteByHandoff# removed actionType: ".concat(mActionType));
                        return i;
                    }
                    break;
                case -763995785:
                    if (mActionType.equals("tag_note")) {
                        openNoteByHandoffActionTagNote(mMainHandoffData.getSelectedTags(), args);
                        return i;
                    }
                    break;
                case 110587138:
                    if (mActionType.equals("folder_move")) {
                        openNoteByHandoffActionFolderMove(mMainHandoffData.getMFolderUuid(), args);
                        return i;
                    }
                    break;
                case 172863514:
                    if (mActionType.equals("gcs_note")) {
                        openNoteByHandoffActionGCSNote(mMainHandoffData.getMGroupId(), mMainHandoffData.getMSpaceId(), args);
                        return i;
                    }
                    break;
                case 198540214:
                    if (mActionType.equals("old_list")) {
                        openNoteByHandoffActionOldList(args);
                        return i;
                    }
                    break;
                case 198605578:
                    if (mActionType.equals("old_note")) {
                        openNoteByHandoffActionOldNote(mActionType, mMainHandoffData.getMCategoryUuid(), args);
                        return i;
                    }
                    break;
                case 283445245:
                    if (mActionType.equals("coedit_space")) {
                        openNoteByHandoffActionCoeditSpace(mMainHandoffData.getMGroupId(), mMainHandoffData.getMSpaceId(), args);
                        return i;
                    }
                    break;
            }
        }
        AbstractC8014b.m7209k("openNoteByHandoff# unexpected actionType: ", mActionType, TAG);
        return i;
    }

    public final void releaseHandoffAction(@Nullable Activity activity) {
        mExecutorService.execute(new RunnableC4199v(this, activity, 22));
    }

    public final void sendHandoffAction(int taskId, int mode, @Nullable MainHandoffData mainHandoffData) {
        mExecutorService.execute(new RunnableC8212b(mainHandoffData, mode, this, taskId));
    }

    private MainHandoffManager() {
        this.mLastDataMap = new LinkedHashMap();
        this.mBackStackDataMap = new LinkedHashMap();
        this.mTopActivityMap = new LinkedHashMap();
    }
}
