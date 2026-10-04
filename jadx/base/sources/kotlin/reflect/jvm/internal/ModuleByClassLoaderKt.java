package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0006H\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getOrCreateModule", "Ljava/lang/Class;", "clearModuleByClassLoaderCache", "", "kotlin-reflection"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nmoduleByClassLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 moduleByClassLoader.kt\nkotlin/reflect/jvm/internal/ModuleByClassLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
public final class ModuleByClassLoaderKt {

    @NotNull
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = new ConcurrentHashMap();

    public static final void clearModuleByClassLoaderCache() {
        moduleByClassLoader.clear();
    }

    @NotNull
    public static final RuntimeModuleData getOrCreateModule(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(cls);
        WeakClassLoaderBox weakClassLoaderBox = new WeakClassLoaderBox(safeClassLoader);
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> concurrentMap = moduleByClassLoader;
        WeakReference<RuntimeModuleData> weakReference = concurrentMap.get(weakClassLoaderBox);
        if (weakReference != null) {
            RuntimeModuleData runtimeModuleData = weakReference.get();
            if (runtimeModuleData != null) {
                return runtimeModuleData;
            }
            concurrentMap.remove(weakClassLoaderBox, weakReference);
        }
        RuntimeModuleData runtimeModuleDataCreate = RuntimeModuleData.Companion.create(safeClassLoader);
        while (true) {
            try {
                ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> concurrentMap2 = moduleByClassLoader;
                WeakReference<RuntimeModuleData> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(weakClassLoaderBox, new WeakReference<>(runtimeModuleDataCreate));
                if (weakReferencePutIfAbsent == null) {
                    return runtimeModuleDataCreate;
                }
                RuntimeModuleData runtimeModuleData2 = weakReferencePutIfAbsent.get();
                if (runtimeModuleData2 != null) {
                    return runtimeModuleData2;
                }
                concurrentMap2.remove(weakClassLoaderBox, weakReferencePutIfAbsent);
            } finally {
                weakClassLoaderBox.setTemporaryStrongRef(null);
            }
        }
    }
}
