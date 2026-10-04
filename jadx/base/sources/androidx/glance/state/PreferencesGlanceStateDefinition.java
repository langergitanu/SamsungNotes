package androidx.glance.state;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.glance.AbstractC2821a;
import androidx.glance.oneui.common.GlanceLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\u0018\u0010\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Landroidx/glance/state/PreferencesGlanceStateDefinition;", "Landroidx/glance/state/GlanceStateDefinition;", "Landroidx/datastore/preferences/core/Preferences;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "defaultState", "getDefaultState", "()Landroidx/datastore/preferences/core/Preferences;", "prefDataStores", "Ljava/util/concurrent/ConcurrentHashMap;", "", "cancelCoroutine", "", "context", "Landroid/content/Context;", "fileKey", "cancelCoroutine$glance_release", "getDataStore", "Landroidx/datastore/core/DataStore;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocation", "Ljava/io/File;", "getOrPutDataStore", "getOrPutDataStore$glance_release", "setCoroutineScope", "scope", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PreferencesGlanceStateDefinition implements GlanceStateDefinition<Preferences> {

    @Nullable
    private static CoroutineScope coroutineScope;

    @NotNull
    public static final PreferencesGlanceStateDefinition INSTANCE = new PreferencesGlanceStateDefinition();

    @NotNull
    private static ConcurrentHashMap<String, CoroutineScope> prefDataStores = new ConcurrentHashMap<>();
    public static final int $stable = 8;

    private PreferencesGlanceStateDefinition() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void cancelCoroutine$glance_release(@NotNull Context context, @NotNull String fileKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        CoroutineScope coroutineScope2 = prefDataStores.get(fileKey);
        if (coroutineScope2 != null) {
            if (CoroutineScopeKt.isActive(coroutineScope2)) {
                GlanceLog.INSTANCE.m2301i("GWT:GlanceStateDefinition", "Cancel an already running DataStore coroutine.");
                CoroutineScopeKt.cancel$default(coroutineScope2, null, 1, null);
            }
            GlanceLog.INSTANCE.m2297d("GWT:GlanceStateDefinition", "Remove an already running DataStore coroutine.");
            prefDataStores.remove(fileKey);
        }
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    @Nullable
    public Object getDataStore(@NotNull final Context context, @NotNull final String str, @NotNull Continuation<? super DataStore<Preferences>> continuation) {
        DataStore dataStoreCreate$default;
        GlanceLog.INSTANCE.m2301i("GWT:GlanceStateDefinition", "create PreferenceDataStore / " + str + " , " + coroutineScope);
        ReplaceFileCorruptionHandler replaceFileCorruptionHandler = new ReplaceFileCorruptionHandler(new Function1<CorruptionException, Preferences>() { // from class: androidx.glance.state.PreferencesGlanceStateDefinition$getDataStore$corruptionHandler$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Preferences invoke(@NotNull CorruptionException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.printStackTrace();
                return PreferencesFactory.createEmpty();
            }
        });
        CoroutineScope coroutineScope2 = coroutineScope;
        return (coroutineScope2 == null || (dataStoreCreate$default = PreferenceDataStoreFactory.create$default(PreferenceDataStoreFactory.INSTANCE, replaceFileCorruptionHandler, null, coroutineScope2, new Function0<File>() { // from class: androidx.glance.state.PreferencesGlanceStateDefinition$getDataStore$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final File invoke() {
                return PreferenceDataStoreFile.preferencesDataStoreFile(context, str);
            }
        }, 2, null)) == null) ? PreferenceDataStoreFactory.create$default(PreferenceDataStoreFactory.INSTANCE, replaceFileCorruptionHandler, null, null, new Function0<File>() { // from class: androidx.glance.state.PreferencesGlanceStateDefinition.getDataStore.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final File invoke() {
                return PreferenceDataStoreFile.preferencesDataStoreFile(context, str);
            }
        }, 6, null) : dataStoreCreate$default;
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    @NotNull
    public File getLocation(@NotNull Context context, @NotNull String fileKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        return PreferenceDataStoreFile.preferencesDataStoreFile(context, fileKey);
    }

    @Nullable
    public final Object getOrPutDataStore$glance_release(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super DataStore<Preferences>> continuation) {
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        boolean zExists = PreferenceDataStoreFile.preferencesDataStoreFile(context, str).exists();
        boolean zContains = prefDataStores.contains(str);
        StringBuilder sbM2229t = AbstractC2821a.m2229t("getOrPutDataStore / ", str, " / ", zExists, " / ");
        sbM2229t.append(zContains);
        companion.m2297d("GWT:GlanceStateDefinition", sbM2229t.toString());
        if (!PreferenceDataStoreFile.preferencesDataStoreFile(context, str).exists() && prefDataStores.contains(str)) {
            cancelCoroutine$glance_release(context, str);
        }
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        coroutineScope = CoroutineScope;
        ConcurrentHashMap<String, CoroutineScope> concurrentHashMap = prefDataStores;
        Intrinsics.checkNotNull(CoroutineScope);
        concurrentHashMap.put(str, CoroutineScope);
        return getDataStore(context, str, continuation);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setCoroutineScope(@NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        coroutineScope = scope;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.glance.state.GlanceStateDefinition
    @NotNull
    public Preferences getDefaultState() {
        return PreferencesFactory.createEmpty();
    }
}
