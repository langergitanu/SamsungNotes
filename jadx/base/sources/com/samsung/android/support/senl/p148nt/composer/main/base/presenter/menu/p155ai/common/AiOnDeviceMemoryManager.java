package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.content.Context;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.framework.app.SmartMemoryManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/common/AiOnDeviceMemoryManager;", "", "<init>", "()V", "ready", "", "hashCode", "", NotesConstants.KEY_CALLER, "", "release", "printCallers", "forceRelease", "context", "Landroid/content/Context;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAiOnDeviceMemoryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiOnDeviceMemoryManager.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/common/AiOnDeviceMemoryManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n1869#2,2:82\n*S KotlinDebug\n*F\n+ 1 AiOnDeviceMemoryManager.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/common/AiOnDeviceMemoryManager\n*L\n44#1:82,2\n*E\n"})
public final class AiOnDeviceMemoryManager {
    private static final boolean DEBUG = true;
    private static final int MEM_SIZE = 573440;

    @Nullable
    private static AiOnDeviceMemoryManager sInstance;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("AiOnDeviceMemoryManager", AiConstants.PREFIX_TAG);

    @NotNull
    private static HashMap<Integer, String> callers = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\bH\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/common/AiOnDeviceMemoryManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "sInstance", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/common/AiOnDeviceMemoryManager;", "MEM_SIZE", "", "DEBUG", "", "callers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getInstance", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized AiOnDeviceMemoryManager getInstance() {
            AiOnDeviceMemoryManager aiOnDeviceMemoryManager;
            try {
                if (AiOnDeviceMemoryManager.sInstance == null) {
                    AiOnDeviceMemoryManager.sInstance = new AiOnDeviceMemoryManager(null);
                }
                aiOnDeviceMemoryManager = AiOnDeviceMemoryManager.sInstance;
                Intrinsics.checkNotNull(aiOnDeviceMemoryManager);
            } catch (Throwable th) {
                throw th;
            }
            return aiOnDeviceMemoryManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AiOnDeviceMemoryManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final synchronized AiOnDeviceMemoryManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void printCallers() {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Integer, String>> setEntrySet = callers.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append(entry.getKey() + "," + entry.getValue() + "/");
        }
        if (sb.length() > 0) {
            Logger.m10999d(TAG, "printCallers# " + ((Object) sb));
        }
    }

    public final void forceRelease(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = TAG;
        AbstractC0000a.m3D(callers.size(), "forceRelease# start ", str);
        synchronized (this) {
            try {
                printCallers();
                if (!callers.isEmpty()) {
                    SmartMemoryManagerCompat.INSTANCE.getInstance().release(context);
                    callers.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Logger.m10999d(str, "forceRelease# end");
    }

    public final void ready(int hashCode, @NotNull String caller) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Context appContext = ApplicationManager.INSTANCE.getInstance().getAppContext();
        if (appContext == null) {
            return;
        }
        String str = TAG;
        AbstractC8014b.m7221w(AbstractC2322a.m1629s("ready# start ", hashCode, " ", caller, " "), str, callers.size());
        synchronized (this) {
            try {
                printCallers();
                if (callers.isEmpty()) {
                    SmartMemoryManagerCompat companion = SmartMemoryManagerCompat.INSTANCE.getInstance();
                    companion.prepare(appContext);
                    companion.request(appContext, 0, MEM_SIZE);
                }
                callers.put(Integer.valueOf(hashCode), caller);
            } catch (Throwable th) {
                throw th;
            }
        }
        Logger.m10999d(str, "ready# end");
    }

    public final void release(int hashCode, @NotNull String caller) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Context appContext = ApplicationManager.INSTANCE.getInstance().getAppContext();
        if (appContext == null) {
            return;
        }
        String str = TAG;
        AbstractC8014b.m7221w(AbstractC2322a.m1629s("release# start ", hashCode, " ", caller, " "), str, callers.size());
        synchronized (this) {
            try {
                printCallers();
                callers.remove(Integer.valueOf(hashCode));
                if (callers.isEmpty()) {
                    SmartMemoryManagerCompat.INSTANCE.getInstance().release(appContext);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Logger.m10999d(str, "release# end");
    }

    private AiOnDeviceMemoryManager() {
    }
}
