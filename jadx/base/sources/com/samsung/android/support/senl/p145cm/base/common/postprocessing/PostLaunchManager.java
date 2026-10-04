package com.samsung.android.support.senl.p145cm.base.common.postprocessing;

import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\"\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0006J\u0018\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\f2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0019\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0006R.\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostLaunchManager;", "", "<init>", "()V", "mBaseMap", "Ljava/util/HashMap;", "", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "createToken", "Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostLaunchManager$Token;", "addBaseLogic", "", "tag", "logic", "addLogic", ResponseType.TOKEN, "hasBaseLogic", "", "hasLogic", "executeBaseLogics", "escapeTags", "", "executeBaseLogic", "executeLogics", "removeLogic", "Token", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PostLaunchManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int INTELLIGENCE_SEARCH_SETUP = 304;

    @NotNull
    private static final String TAG = "PostLaunchManager";
    public static final int TAG_ATTACH_DRAWER = 102;
    public static final int TAG_COMPOSER_SETUP = 201;
    public static final int TAG_CONNECT_ADDONS = 108;
    public static final int TAG_CONTINUITY_SERVICE_RESISTER = 6;
    public static final int TAG_DOC_CONVERTER_CONFIGURATION = 204;
    public static final int TAG_DOC_SCAN_CACHE_DELETE = 203;
    public static final int TAG_INIT_ACCESS_HANDLER = 1;
    public static final int TAG_MEMO_APPLICATION_BASE_SETUP = 2;
    public static final int TAG_MEMO_APPLICATION_DB_DUPLICATE_CHECK = 5;
    public static final int TAG_MEMO_APPLICATION_DB_RESTORE = 4;
    public static final int TAG_MEMO_APPLICATION_SIDE_SETUP = 3;
    public static final int TAG_NETWORK_OPERATION = 104;
    public static final int TAG_NOTES_FRAGMENT_ACTIVITY_CREATED = 105;
    public static final int TAG_RECOGNIZER_SETUP = 302;
    public static final int TAG_RESTORE_CACHE = 202;
    public static final int TAG_SECURE_FOLDER_MOVE = 303;
    public static final int TAG_SYNC_SETUP = 301;
    public static final int TAG_UNBLOCK_TOUCH = 103;

    @Nullable
    private static PostLaunchManager mInstance;

    @NotNull
    private HashMap<Integer, Runnable> mBaseMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostLaunchManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "TAG_INIT_ACCESS_HANDLER", "", "TAG_MEMO_APPLICATION_BASE_SETUP", "TAG_MEMO_APPLICATION_SIDE_SETUP", "TAG_MEMO_APPLICATION_DB_RESTORE", "TAG_MEMO_APPLICATION_DB_DUPLICATE_CHECK", "TAG_CONTINUITY_SERVICE_RESISTER", "TAG_ATTACH_DRAWER", "TAG_UNBLOCK_TOUCH", "TAG_NETWORK_OPERATION", "TAG_NOTES_FRAGMENT_ACTIVITY_CREATED", "TAG_CONNECT_ADDONS", "TAG_COMPOSER_SETUP", "TAG_RESTORE_CACHE", "TAG_DOC_SCAN_CACHE_DELETE", "TAG_DOC_CONVERTER_CONFIGURATION", "TAG_SYNC_SETUP", "TAG_RECOGNIZER_SETUP", "TAG_SECURE_FOLDER_MOVE", "INTELLIGENCE_SEARCH_SETUP", "mInstance", "Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostLaunchManager;", "getInstance", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized PostLaunchManager getInstance() {
            PostLaunchManager postLaunchManager;
            try {
                if (PostLaunchManager.mInstance == null) {
                    PostLaunchManager.mInstance = new PostLaunchManager(null);
                }
                postLaunchManager = PostLaunchManager.mInstance;
                Intrinsics.checkNotNull(postLaunchManager);
            } catch (Throwable th) {
                throw th;
            }
            return postLaunchManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostLaunchManager$Token;", "", "<init>", "()V", "mListMap", "Ljava/util/HashMap;", "", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "getMListMap", "()Ljava/util/HashMap;", "setMListMap", "(Ljava/util/HashMap;)V", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Token {

        @NotNull
        private HashMap<Integer, Runnable> mListMap = new HashMap<>();

        @NotNull
        public final HashMap<Integer, Runnable> getMListMap() {
            return this.mListMap;
        }

        public final void setMListMap(@NotNull HashMap<Integer, Runnable> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.mListMap = map;
        }
    }

    public /* synthetic */ PostLaunchManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final synchronized PostLaunchManager getInstance() {
        return INSTANCE.getInstance();
    }

    public final synchronized void addBaseLogic(int tag, @Nullable Runnable logic) {
        this.mBaseMap.put(Integer.valueOf(tag), logic);
    }

    public final synchronized void addLogic(@Nullable Token token, int tag, @Nullable Runnable logic) {
        if (token != null) {
            token.getMListMap().put(Integer.valueOf(tag), logic);
        }
    }

    @NotNull
    public final Token createToken() {
        return new Token();
    }

    public final synchronized void executeBaseLogic(int tag) {
        Runnable runnable = this.mBaseMap.get(Integer.valueOf(tag));
        if (runnable != null) {
            LoggerBase.INSTANCE.m7132d(TAG, "executeBaseLogic# BaseMap TAG : " + tag);
            runnable.run();
            this.mBaseMap.remove(Integer.valueOf(tag));
        }
    }

    public final synchronized void executeBaseLogics() {
        try {
            if (this.mBaseMap.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.mBaseMap.values());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = arrayList.get(i);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable");
                Runnable runnable = (Runnable) obj;
                if (this.mBaseMap.values().contains(runnable)) {
                    runnable.run();
                }
            }
            LoggerBase.INSTANCE.m7132d(TAG, "executeBaseLogics# BaseMap TAG : " + this.mBaseMap.keySet());
            this.mBaseMap.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void executeLogics(@Nullable Token token) {
        try {
            if (!this.mBaseMap.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.mBaseMap.values());
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Object obj = arrayList.get(i);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable");
                    Runnable runnable = (Runnable) obj;
                    if (this.mBaseMap.values().contains(runnable)) {
                        runnable.run();
                    }
                }
                LoggerBase.INSTANCE.m7132d(TAG, "executeLogics# BaseMap TAG : " + this.mBaseMap.keySet());
                this.mBaseMap.clear();
            }
            if (token != null && !token.getMListMap().isEmpty()) {
                ArrayList arrayList2 = new ArrayList(token.getMListMap().values());
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Object obj2 = arrayList2.get(i2);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.Runnable");
                    Runnable runnable2 = (Runnable) obj2;
                    if (token.getMListMap().values().contains(runnable2)) {
                        runnable2.run();
                    }
                }
                LoggerBase.INSTANCE.m7132d(TAG, "executeLogics# NotesListMap TAG : " + token.getMListMap().keySet());
                token.getMListMap().clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean hasBaseLogic(int tag) {
        return this.mBaseMap.containsKey(Integer.valueOf(tag));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        if (r3.getMListMap().containsKey(java.lang.Integer.valueOf(r4)) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean hasLogic(@Nullable Token token, int tag) {
        if (!this.mBaseMap.containsKey(Integer.valueOf(tag))) {
            if (token != null) {
            }
            return false;
        }
        return true;
    }

    public final synchronized boolean removeLogic(@Nullable Token token, int tag) {
        if (token != null) {
            return token.getMListMap().remove(Integer.valueOf(tag)) != null;
        }
        return false;
    }

    private PostLaunchManager() {
        this.mBaseMap = new HashMap<>();
    }

    public final synchronized void executeBaseLogics(@NotNull List<Integer> escapeTags) {
        try {
            Intrinsics.checkNotNullParameter(escapeTags, "escapeTags");
            if (this.mBaseMap.isEmpty()) {
                return;
            }
            HashMap<Integer, Runnable> map = new HashMap<>();
            for (Map.Entry<Integer, Runnable> entry : this.mBaseMap.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (escapeTags.contains(Integer.valueOf(iIntValue))) {
                    map.put(Integer.valueOf(iIntValue), entry.getValue());
                } else {
                    Runnable value = entry.getValue();
                    if (value != null) {
                        value.run();
                    }
                    LoggerBase.INSTANCE.m7132d(TAG, "executeBaseLogics# entry.getKey : " + entry.getKey());
                }
            }
            this.mBaseMap.clear();
            if (!map.isEmpty()) {
                this.mBaseMap = map;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
