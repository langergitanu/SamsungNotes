package com.vladsch.flexmark.util.builder;

import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.vladsch.flexmark.util.builder.BuilderBase;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.data.NullableDataKey;
import com.vladsch.flexmark.util.data.SharedDataKeys;
import com.vladsch.flexmark.util.misc.Extension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.commons.lang3.exception.C13833a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BuilderBase<T extends BuilderBase<T>> extends MutableDataSet {
    private Extension currentExtension;
    private final HashMap<Class<?>, HashSet<Object>> extensionApiPoints;
    private final HashSet<Class<?>> loadedExtensions;

    public BuilderBase(@Nullable DataHolder dataHolder) {
        super(dataHolder);
        this.loadedExtensions = new HashSet<>();
        this.extensionApiPoints = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HashSet lambda$addExtensionApiPoint$0(Class cls) {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeExtensions$1(Collection collection, Extension extension) {
        return collection.contains(extension.getClass());
    }

    public static DataHolder removeExtensions(@NotNull DataHolder dataHolder, @NotNull Collection<Class<? extends Extension>> collection) {
        DataKey<Collection<Extension>> dataKey = SharedDataKeys.EXTENSIONS;
        if (!dataHolder.contains(dataKey)) {
            return dataHolder;
        }
        ArrayList arrayList = new ArrayList(dataKey.get(dataHolder));
        return arrayList.removeIf(new C7233a(collection, 17)) ? dataHolder instanceof MutableDataHolder ? ((MutableDataHolder) dataHolder).set((DataKey<ArrayList>) dataKey, arrayList) : dataHolder.toMutable().set((DataKey<ArrayList>) dataKey, arrayList).toImmutable() : dataHolder;
    }

    public void addExtensionApiPoint(@NotNull Object obj) {
        Extension extension = this.currentExtension;
        if (extension != null) {
            this.extensionApiPoints.computeIfAbsent(extension.getClass(), new C13833a(15)).add(obj);
        }
    }

    @NotNull
    public abstract Object build();

    @NotNull
    public final T extensions(@NotNull Collection<? extends Extension> collection) {
        ArrayList arrayList = new ArrayList(collection.size() + SharedDataKeys.EXTENSIONS.get(this).size());
        for (Extension extension : collection) {
            this.currentExtension = extension;
            if (!this.loadedExtensions.contains(extension.getClass())) {
                preloadExtension(extension);
                arrayList.add(extension);
            }
            this.currentExtension = null;
        }
        for (Extension extension2 : collection) {
            this.currentExtension = extension2;
            Class<?> cls = extension2.getClass();
            if (!this.loadedExtensions.contains(cls) && loadExtension(extension2)) {
                this.loadedExtensions.add(cls);
                arrayList.add(extension2);
            }
            this.currentExtension = null;
        }
        if (!arrayList.isEmpty()) {
            DataKey dataKey = SharedDataKeys.EXTENSIONS;
            arrayList.addAll(0, (Collection) dataKey.get(this));
            set((DataKey<ArrayList>) dataKey, arrayList);
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder, com.vladsch.flexmark.util.data.MutableDataHolder
    @Deprecated
    public <V> V get(@NotNull DataKey<V> dataKey) {
        return dataKey.get(this);
    }

    public abstract boolean loadExtension(@NotNull Extension extension);

    public void loadExtensions() {
        DataKey<Collection<Extension>> dataKey = SharedDataKeys.EXTENSIONS;
        if (contains(dataKey)) {
            extensions(dataKey.get(this));
        }
    }

    public abstract void preloadExtension(@NotNull Extension extension);

    public abstract void removeApiPoint(@NotNull Object obj);

    @Override // com.vladsch.flexmark.util.data.MutableDataSet, com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public /* bridge */ /* synthetic */ MutableDataHolder set(@NotNull DataKey dataKey, @NotNull Object obj) {
        return set((DataKey<Object>) dataKey, obj);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataSet, com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public /* bridge */ /* synthetic */ MutableDataHolder set(@NotNull NullableDataKey nullableDataKey, @Nullable Object obj) {
        return set((NullableDataKey<Object>) nullableDataKey, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vladsch.flexmark.util.data.MutableDataSet, com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public <V> MutableDataSet set(@NotNull DataKey<V> dataKey, @NotNull V v) {
        addExtensionApiPoint(dataKey);
        return super.set(dataKey, v);
    }

    public BuilderBase() {
        this.loadedExtensions = new HashSet<>();
        this.extensionApiPoints = new HashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vladsch.flexmark.util.data.MutableDataSet, com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public <V> MutableDataSet set(@NotNull NullableDataKey<V> nullableDataKey, @Nullable V v) {
        addExtensionApiPoint(nullableDataKey);
        return super.set(nullableDataKey, v);
    }
}
