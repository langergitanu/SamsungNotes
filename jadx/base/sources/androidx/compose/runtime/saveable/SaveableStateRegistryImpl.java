package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/runtime/saveable/SaveableStateRegistryImpl;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", CategoryConstants.Restored.UUID_PREFIX, "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "", "valueProviders", "", "Lkotlin/Function0;", "value", "consumeRestored", "key", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "runtime-saveable_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSaveableStateRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SaveableStateRegistry.kt\nandroidx/compose/runtime/saveable/SaveableStateRegistryImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,171:1\n1#2:172\n361#3,7:173\n215#4,2:180\n*S KotlinDebug\n*F\n+ 1 SaveableStateRegistry.kt\nandroidx/compose/runtime/saveable/SaveableStateRegistryImpl\n*L\n131#1:173,7\n146#1:180,2\n*E\n"})
final class SaveableStateRegistryImpl implements SaveableStateRegistry {

    @NotNull
    private final Function1<Object, Boolean> canBeSaved;

    @NotNull
    private final Map<String, List<Object>> restored;

    @NotNull
    private final Map<String, List<Function0<Object>>> valueProviders;

    public SaveableStateRegistryImpl(@Nullable Map<String, ? extends List<? extends Object>> map, @NotNull Function1<Object, Boolean> function1) {
        Map<String, List<Object>> mutableMap;
        this.canBeSaved = function1;
        this.restored = (map == null || (mutableMap = MapsKt.toMutableMap(map)) == null) ? new LinkedHashMap<>() : mutableMap;
        this.valueProviders = new LinkedHashMap();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(@NotNull Object value) {
        return this.canBeSaved.invoke(value).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @Nullable
    public Object consumeRestored(@NotNull String key) {
        List<Object> listRemove = this.restored.remove(key);
        if (listRemove == null || listRemove.isEmpty()) {
            return null;
        }
        if (listRemove.size() > 1) {
            this.restored.put(key, listRemove.subList(1, listRemove.size()));
        }
        return listRemove.get(0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @NotNull
    public Map<String, List<Object>> performSave() {
        Map<String, List<Object>> mutableMap = MapsKt.toMutableMap(this.restored);
        for (Map.Entry<String, List<Function0<Object>>> entry : this.valueProviders.entrySet()) {
            String key = entry.getKey();
            List<Function0<Object>> value = entry.getValue();
            if (value.size() == 1) {
                Object objInvoke = value.get(0).invoke();
                if (objInvoke == null) {
                    continue;
                } else {
                    if (!canBeSaved(objInvoke)) {
                        throw new IllegalStateException(RememberSaveableKt.generateCannotBeSavedErrorMessage(objInvoke).toString());
                    }
                    mutableMap.put(key, CollectionsKt.arrayListOf(objInvoke));
                }
            } else {
                int size = value.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object objInvoke2 = value.get(i).invoke();
                    if (objInvoke2 != null && !canBeSaved(objInvoke2)) {
                        throw new IllegalStateException(RememberSaveableKt.generateCannotBeSavedErrorMessage(objInvoke2).toString());
                    }
                    arrayList.add(objInvoke2);
                }
                mutableMap.put(key, arrayList);
            }
        }
        return mutableMap;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @NotNull
    public SaveableStateRegistry.Entry registerProvider(@NotNull final String key, @NotNull final Function0<? extends Object> valueProvider) {
        if (SaveableStateRegistryKt.fastIsBlank(key)) {
            throw new IllegalArgumentException("Registered key is empty or blank");
        }
        Map<String, List<Function0<Object>>> map = this.valueProviders;
        List<Function0<Object>> arrayList = map.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(key, arrayList);
        }
        arrayList.add(valueProvider);
        return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl.registerProvider.3
            @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
            public void unregister() {
                List list = (List) SaveableStateRegistryImpl.this.valueProviders.remove(key);
                if (list != null) {
                    list.remove(valueProvider);
                }
                if (list == null || list.isEmpty()) {
                    return;
                }
                SaveableStateRegistryImpl.this.valueProviders.put(key, list);
            }
        };
    }
}
