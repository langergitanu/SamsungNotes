package com.google.android.material.oneui.floatingdock.util;

import android.graphics.Rect;
import androidx.collection.AbstractC0622a;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import com.google.android.material.oneui.floatingdock.FloatingDockLogTag;
import com.google.android.material.oneui.floatingdock.FloatingPane;
import com.google.android.material.oneui.floatingdock.IFloatingPaneCallback;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0001J\u001f\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001J\u0017\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0003J\u0017\u0010\u001a\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0096\u0003J\u0011\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0096\u0003J\u0011\u0010 \u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0001J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"H\u0096\u0001J\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0006\u0010\u0014\u001a\u00020\rH\u0096\u0001J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0016J\u0012\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J(\u0010)\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0016J\"\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020.H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0012\u00106\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J \u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020;H\u0016J\u001a\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020>H\u0016ø\u0001\u0000¢\u0006\u0004\b?\u00105J\u0010\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\rH\u0016J\u0011\u0010B\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0001J\u0017\u0010C\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001J\u0011\u0010D\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0096\u0001J\u0017\u0010E\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001J\u0019\u0010F\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0003J\u001f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;", "", "Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback;", "Lcom/google/android/material/oneui/floatingdock/FloatingDockLogTag;", "callbacks", "(Ljava/util/List;)V", "getCallbacks", "()Ljava/util/List;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "size", "", "getSize", "()I", "add", "", "element", "", "index", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "onFloatingMoved", "left", "top", "onInsert", "rect", "Landroid/graphics/Rect;", "onLayoutChanged", "right", "bottom", "onMinimizedChanged", "mode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "isMinimized", "onMinimizedChanged-oaV7IQU", "(IZ)V", "onModeChanged", "newMode", "onModeChanged-J5JjPLc", "(I)V", "onPreInsert", "onResizeAnimate", Constants.MessagePayloadKeys.FROM, "to", XmlErrorCodes.DURATION, "", "onStateChanged", "state", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneState;", "onStateChanged-IywsXb8", "onVisibilityChanged", "visibility", "remove", "removeAll", "removeAt", "retainAll", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "subList", "fromIndex", "toIndex", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingPaneCallbackNotifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingPaneCallbackNotifier.kt\ncom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,62:1\n1855#2,2:63\n1855#2,2:65\n1855#2,2:67\n1855#2,2:69\n1855#2,2:71\n1855#2,2:73\n1855#2,2:75\n1855#2,2:77\n1855#2,2:79\n*S KotlinDebug\n*F\n+ 1 FloatingPaneCallbackNotifier.kt\ncom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier\n*L\n17#1:63,2\n22#1:65,2\n27#1:67,2\n32#1:69,2\n37#1:71,2\n42#1:73,2\n47#1:75,2\n52#1:77,2\n59#1:79,2\n*E\n"})
public final class FloatingPaneCallbackNotifier implements List<IFloatingPaneCallback>, IFloatingPaneCallback, FloatingDockLogTag, KMutableList {

    @NotNull
    private final List<IFloatingPaneCallback> callbacks;

    @NotNull
    private final String logTag;

    public FloatingPaneCallbackNotifier(@NotNull List<IFloatingPaneCallback> callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.callbacks = callbacks;
        this.logTag = "FloatingPaneCallbackNotifier";
    }

    @Override // java.util.List
    public void add(int index, @NotNull IFloatingPaneCallback element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.callbacks.add(index, element);
    }

    @Override // java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends IFloatingPaneCallback> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.callbacks.addAll(index, elements);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.callbacks.clear();
    }

    public boolean contains(@NotNull IFloatingPaneCallback element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.callbacks.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.callbacks.containsAll(elements);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    @NotNull
    public IFloatingPaneCallback get(int index) {
        return this.callbacks.get(index);
    }

    @NotNull
    public final List<IFloatingPaneCallback> getCallbacks() {
        return this.callbacks;
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    public int getSize() {
        return this.callbacks.size();
    }

    public int indexOf(@NotNull IFloatingPaneCallback element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.callbacks.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.callbacks.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<IFloatingPaneCallback> iterator() {
        return this.callbacks.iterator();
    }

    public int lastIndexOf(@NotNull IFloatingPaneCallback element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.callbacks.lastIndexOf(element);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<IFloatingPaneCallback> listIterator() {
        return this.callbacks.listIterator();
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    public void onFloatingMoved(int left, int top) {
        LogTagHelperKt.debug(this, "callback onFloatingMoved " + left + SQLKeyword.COMMA + top);
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onFloatingMoved(left, top);
        }
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    public void onInsert(@Nullable Rect rect) {
        LogTagHelperKt.debug(this, "callback OnInsert=" + rect);
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onInsert(rect);
        }
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    public void onLayoutChanged(int left, int top, int right, int bottom) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(left, top, "callback onLayoutChanged left=", ", top=", ", right=");
        sbM1173s.append(right);
        sbM1173s.append(", bottom=");
        sbM1173s.append(bottom);
        LogTagHelperKt.debug(this, sbM1173s.toString());
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onLayoutChanged(left, top, right, bottom);
        }
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    /* JADX INFO: renamed from: onMinimizedChanged-oaV7IQU, reason: not valid java name and merged with bridge method [inline-methods] */
    public void onMinimizedChanged(int mode, boolean isMinimized) {
        LogTagHelperKt.debug(this, "callback onMinimizedChanged mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", isMinimized=" + isMinimized);
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onMinimizedChanged(mode, isMinimized);
        }
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    /* JADX INFO: renamed from: onModeChanged-J5JjPLc, reason: not valid java name and merged with bridge method [inline-methods] */
    public void onModeChanged(int newMode) {
        LogTagHelperKt.debug(this, "callback OnModeChanged=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(newMode)));
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onModeChanged(newMode);
        }
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    public void onPreInsert(@Nullable Rect rect) {
        LogTagHelperKt.debug(this, "callback OnPreInsert=" + rect);
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onPreInsert(rect);
        }
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    public void onResizeAnimate(@NotNull Rect from, @NotNull Rect to, long duration) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        LogTagHelperKt.debug(this, "callback onResizeAnimate from=" + from + " -> to=" + to + ", duration=" + duration);
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onResizeAnimate(from, to, duration);
        }
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    /* JADX INFO: renamed from: onStateChanged-IywsXb8, reason: not valid java name and merged with bridge method [inline-methods] */
    public void onStateChanged(int state) {
        LogTagHelperKt.debug(this, "callback onStateChanged state=" + ((Object) FloatingPane.FloatingPaneState.m22093toStringimpl(state)));
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onStateChanged(state);
        }
    }

    @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
    public void onVisibilityChanged(int visibility) {
        LogTagHelperKt.debug(this, "callback OnVisibilityChanged=" + visibility);
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((IFloatingPaneCallback) it.next()).onVisibilityChanged(visibility);
        }
    }

    public boolean remove(@NotNull IFloatingPaneCallback element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.callbacks.remove(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.callbacks.removeAll(elements);
    }

    @NotNull
    public IFloatingPaneCallback removeAt(int index) {
        return this.callbacks.remove(index);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.callbacks.retainAll(elements);
    }

    @Override // java.util.List
    @NotNull
    public IFloatingPaneCallback set(int index, @NotNull IFloatingPaneCallback element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.callbacks.set(index, element);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    @NotNull
    public List<IFloatingPaneCallback> subList(int fromIndex, int toIndex) {
        return this.callbacks.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(@NotNull IFloatingPaneCallback element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.callbacks.add(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends IFloatingPaneCallback> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.callbacks.addAll(elements);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof IFloatingPaneCallback) {
            return contains((IFloatingPaneCallback) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof IFloatingPaneCallback) {
            return indexOf((IFloatingPaneCallback) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof IFloatingPaneCallback) {
            return lastIndexOf((IFloatingPaneCallback) obj);
        }
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<IFloatingPaneCallback> listIterator(int index) {
        return this.callbacks.listIterator(index);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public final /* bridge */ IFloatingPaneCallback remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof IFloatingPaneCallback) {
            return remove((IFloatingPaneCallback) obj);
        }
        return false;
    }
}
