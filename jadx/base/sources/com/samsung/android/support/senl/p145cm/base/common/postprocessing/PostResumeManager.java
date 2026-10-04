package com.samsung.android.support.senl.p145cm.base.common.postprocessing;

import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostResumeManager;", "", "<init>", "()V", "createToken", "Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostResumeManager$Token;", "addLogic", "", ResponseType.TOKEN, "tag", "", "logic", "Ljava/lang/Runnable;", "removeLogic", "", "executeNotesListLogics", "Token", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PostResumeManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "PostResumeManager";
    public static final int TAG_ACTIVITY_ON_RESUME = 1;
    public static final int TAG_ATTACH_PHONE_DRAWER_ON_RESUME = 101;
    public static final int TAG_ATTACH_TABLET_DRAWER_ON_RESUME = 102;
    public static final int TAG_PRESENTER_ON_RESUME = 2;

    @Nullable
    private static PostResumeManager mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostResumeManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "TAG_ACTIVITY_ON_RESUME", "", "TAG_PRESENTER_ON_RESUME", "TAG_ATTACH_PHONE_DRAWER_ON_RESUME", "TAG_ATTACH_TABLET_DRAWER_ON_RESUME", "mInstance", "Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostResumeManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostResumeManager;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized PostResumeManager getInstance() {
            PostResumeManager postResumeManager;
            try {
                if (PostResumeManager.mInstance == null) {
                    PostResumeManager.mInstance = new PostResumeManager(null);
                }
                postResumeManager = PostResumeManager.mInstance;
                Intrinsics.checkNotNull(postResumeManager);
            } catch (Throwable th) {
                throw th;
            }
            return postResumeManager;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/postprocessing/PostResumeManager$Token;", "", "<init>", "()V", "mListMap", "Ljava/util/HashMap;", "", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "getMListMap", "()Ljava/util/HashMap;", "setMListMap", "(Ljava/util/HashMap;)V", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
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

    public /* synthetic */ PostResumeManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public static final synchronized PostResumeManager getInstance() {
        return INSTANCE.getInstance();
    }

    public final synchronized void addLogic(@Nullable Token token, int tag, @Nullable Runnable logic) {
        LoggerBase.INSTANCE.m7132d(TAG, "addLogic# token : " + token + ", tag : " + tag);
        if (token != null) {
            token.getMListMap().put(Integer.valueOf(tag), logic);
        }
    }

    @NotNull
    public final Token createToken() {
        return new Token();
    }

    public final synchronized void executeNotesListLogics(@Nullable Token token) {
        if (token != null) {
            try {
                if (!token.getMListMap().isEmpty()) {
                    LoggerBase.INSTANCE.m7132d(TAG, "executeNotesListLogics# NotesListMap : " + token.getMListMap().keySet());
                    for (Runnable runnable : token.getMListMap().values()) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    token.getMListMap().clear();
                    return;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LoggerBase.INSTANCE.m7132d(TAG, "executeNotesListLogics# token is null or mListMap is empty");
    }

    public final synchronized boolean removeLogic(@Nullable Token token, int tag) {
        if (token != null) {
            return token.getMListMap().remove(Integer.valueOf(tag)) != null;
        }
        return false;
    }

    private PostResumeManager() {
    }
}
