package com.samsung.android.app.sdk.deepsky.textextraction.capsule;

import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\u0016\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleContainer;", "", "()V", "appCapsuleList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/Capsule;", "capsuleList", "capsuleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper$CapsuleListener;", "getCapsuleListener", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper$CapsuleListener;", "setCapsuleListener", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper$CapsuleListener;)V", "size", "", "getSize", "()I", "addAppCapsule", "", "capsule", "appendCapsule", "getMergedCapsuleList", "initialize", "insertCapsule", "index", "isAppCapsuleAlreadyExists", "", "isCapsuleAlreadyExists", "isEmpty", "removeCapsule", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCapsuleContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CapsuleContainer.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleContainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1747#2,3:69\n1747#2,3:72\n*S KotlinDebug\n*F\n+ 1 CapsuleContainer.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleContainer\n*L\n58#1:69,3\n62#1:72,3\n*E\n"})
public final class CapsuleContainer {

    @NotNull
    private static final String TAG = "CapsuleContainer";

    @NotNull
    private final List<Capsule> appCapsuleList = new ArrayList();

    @NotNull
    private final List<Capsule> capsuleList = new ArrayList();

    @Nullable
    private CapsuleHelper.CapsuleListener capsuleListener;

    private final boolean isAppCapsuleAlreadyExists(Capsule capsule) {
        List<Capsule> list = this.appCapsuleList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((Capsule) it.next()).getTitle(), capsule.getTitle())) {
                return true;
            }
        }
        return false;
    }

    private final boolean isCapsuleAlreadyExists(Capsule capsule) {
        List<Capsule> list = this.capsuleList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((Capsule) it.next()).getTitle(), capsule.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public final void addAppCapsule(@NotNull Capsule capsule) {
        Intrinsics.checkNotNullParameter(capsule, "capsule");
        if (isAppCapsuleAlreadyExists(capsule)) {
            return;
        }
        this.appCapsuleList.add(capsule);
        LibLogger.m5429d(TAG, "CapsuleListener onAdd " + capsule.getCapsuleActionType());
        CapsuleHelper.CapsuleListener capsuleListener = this.capsuleListener;
        if (capsuleListener != null) {
            capsuleListener.onAdd(capsule.getCapsuleActionType());
        }
    }

    public final void appendCapsule(@NotNull Capsule capsule) {
        Intrinsics.checkNotNullParameter(capsule, "capsule");
        if (isCapsuleAlreadyExists(capsule)) {
            return;
        }
        this.capsuleList.add(capsule);
        LibLogger.m5429d(TAG, "CapsuleListener onAdd " + capsule.getCapsuleActionType());
        CapsuleHelper.CapsuleListener capsuleListener = this.capsuleListener;
        if (capsuleListener != null) {
            capsuleListener.onAdd(capsule.getCapsuleActionType());
        }
    }

    @Nullable
    public final CapsuleHelper.CapsuleListener getCapsuleListener() {
        return this.capsuleListener;
    }

    @NotNull
    public final List<Capsule> getMergedCapsuleList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.appCapsuleList);
        arrayList.addAll(this.capsuleList);
        return arrayList;
    }

    public final int getSize() {
        return this.capsuleList.size() + this.appCapsuleList.size();
    }

    public final void initialize() {
        this.appCapsuleList.clear();
        this.capsuleList.clear();
    }

    public final void insertCapsule(@NotNull Capsule capsule, int index) {
        Intrinsics.checkNotNullParameter(capsule, "capsule");
        if (isCapsuleAlreadyExists(capsule) || index < 0 || index > this.capsuleList.size()) {
            return;
        }
        this.capsuleList.add(index, capsule);
        LibLogger.m5429d(TAG, "CapsuleListener onAdd " + capsule.getCapsuleActionType());
        CapsuleHelper.CapsuleListener capsuleListener = this.capsuleListener;
        if (capsuleListener != null) {
            capsuleListener.onAdd(capsule.getCapsuleActionType());
        }
    }

    public final boolean isEmpty() {
        return this.appCapsuleList.isEmpty() && this.capsuleList.isEmpty();
    }

    public final void removeCapsule(@NotNull Capsule capsule) {
        Intrinsics.checkNotNullParameter(capsule, "capsule");
        this.capsuleList.remove(capsule);
    }

    public final void setCapsuleListener(@Nullable CapsuleHelper.CapsuleListener capsuleListener) {
        this.capsuleListener = capsuleListener;
    }
}
