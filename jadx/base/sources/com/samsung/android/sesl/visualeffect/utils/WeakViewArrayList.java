package com.samsung.android.sesl.visualeffect.utils;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(24)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/WeakViewArrayList;", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "weakRefManager", "Lcom/samsung/android/sesl/visualeffect/utils/VUID;", "add", "", VPathDataCmd.RCurveTo, "remove", "forEachAlive", "", "action", "Ljava/util/function/Consumer;", "clear", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWeakViewArrayList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeakViewArrayList.kt\ncom/samsung/android/sesl/visualeffect/utils/WeakViewArrayList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1611#2,9:35\n1863#2:44\n1864#2:46\n1620#2:47\n1#3:45\n*S KotlinDebug\n*F\n+ 1 WeakViewArrayList.kt\ncom/samsung/android/sesl/visualeffect/utils/WeakViewArrayList\n*L\n25#1:35,9\n25#1:44\n25#1:46\n25#1:47\n25#1:45\n*E\n"})
public final class WeakViewArrayList extends ArrayList<WeakReference<View>> {

    @NotNull
    private final VUID weakRefManager = new VUID(0, 1, null);

    public final boolean add(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return add(this.weakRefManager.getOrCreateMemoized(v));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.weakRefManager.clear();
        super.clear();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof WeakReference) {
            return contains((WeakReference<View>) obj);
        }
        return false;
    }

    public final void forEachAlive(@NotNull Consumer<View> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<View>> it = iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null) {
                arrayList.add(view);
            }
        }
        arrayList.forEach(action);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof WeakReference) {
            return indexOf((WeakReference<View>) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof WeakReference) {
            return lastIndexOf((WeakReference<View>) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ WeakReference<View> remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ WeakReference<View> removeAt(int i) {
        return remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* bridge */ boolean contains(WeakReference<View> weakReference) {
        return super.contains((Object) weakReference);
    }

    public /* bridge */ int indexOf(WeakReference<View> weakReference) {
        return super.indexOf((Object) weakReference);
    }

    public /* bridge */ int lastIndexOf(WeakReference<View> weakReference) {
        return super.lastIndexOf((Object) weakReference);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof WeakReference) {
            return remove((WeakReference<View>) obj);
        }
        return false;
    }

    public /* bridge */ boolean remove(WeakReference<View> weakReference) {
        return super.remove((Object) weakReference);
    }

    public final boolean remove(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        WeakReference<View> weakReferenceForget = this.weakRefManager.forget(v);
        if (weakReferenceForget != null) {
            return super.remove((Object) weakReferenceForget);
        }
        return false;
    }
}
