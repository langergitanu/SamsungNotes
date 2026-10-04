package com.samsung.android.sesl.visualeffect.utils;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.C4191n;
import p123b3.C4202b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(24)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0003J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/WeakViewHashSet;", "Ljava/util/HashSet;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "Lkotlin/collections/HashSet;", "<init>", "()V", "weakRefManager", "Lcom/samsung/android/sesl/visualeffect/utils/VUID;", "add", "", VPathDataCmd.RCurveTo, "remove", "get", "forEachAlive", "", "action", "Ljava/util/function/Consumer;", "clear", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWeakViewHashSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeakViewHashSet.kt\ncom/samsung/android/sesl/visualeffect/utils/WeakViewHashSet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
public final class WeakViewHashSet extends HashSet<WeakReference<View>> {

    @NotNull
    private final VUID weakRefManager = new VUID(0, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit forEachAlive$lambda$2(Consumer consumer, WeakReference weakReference) {
        View view = (View) weakReference.get();
        if (view != null) {
            consumer.accept(view);
        }
        return Unit.INSTANCE;
    }

    public final boolean add(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return add(this.weakRefManager.getOrCreateMemoized(v));
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.weakRefManager.clear();
        super.clear();
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof WeakReference) {
            return contains((WeakReference<View>) obj);
        }
        return false;
    }

    public final void forEachAlive(@NotNull Consumer<View> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        super.forEach(new C4191n(new C4202b(action, 5), 16));
    }

    @Nullable
    public final WeakReference<View> get(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return this.weakRefManager.get(v);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof WeakReference) {
            return remove((WeakReference<View>) obj);
        }
        return false;
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* bridge */ boolean contains(WeakReference<View> weakReference) {
        return super.contains((Object) weakReference);
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
