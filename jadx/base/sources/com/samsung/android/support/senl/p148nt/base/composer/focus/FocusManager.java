package com.samsung.android.support.senl.p148nt.base.composer.focus;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;", "", "<init>", "()V", "mainTarget", "Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;", "getMainTarget", "()Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;", "setMainTarget", "(Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;)V", "subTargetList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "value", "curFocusTarget", "getCurFocusTarget", "addTarget", "", "target", "removeTarget", "getFocusTarget", "excludeTarget", "hasFocus", "", "updateFocusTarget", "FTarget", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FocusManager {

    @Nullable
    private FTarget curFocusTarget;
    public FTarget mainTarget;

    @NotNull
    private final ArrayList<FTarget> subTargetList = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;", "", "hasFocus", "", "requestFocus", "", "onLoseFocus", "onGetFocus", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface FTarget {
        boolean hasFocus();

        void onGetFocus();

        void onLoseFocus();

        void requestFocus();
    }

    public static /* synthetic */ FTarget getFocusTarget$default(FocusManager focusManager, FTarget fTarget, int i, Object obj) {
        if ((i & 1) != 0) {
            fTarget = null;
        }
        return focusManager.getFocusTarget(fTarget);
    }

    public static /* synthetic */ boolean hasFocus$default(FocusManager focusManager, FTarget fTarget, int i, Object obj) {
        if ((i & 1) != 0) {
            fTarget = null;
        }
        return focusManager.hasFocus(fTarget);
    }

    public final void addTarget(@NotNull FTarget target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (this.subTargetList.contains(target)) {
            return;
        }
        this.subTargetList.add(target);
    }

    @Nullable
    public final FTarget getCurFocusTarget() {
        return this.curFocusTarget;
    }

    @JvmOverloads
    @Nullable
    public final FTarget getFocusTarget() {
        return getFocusTarget$default(this, null, 1, null);
    }

    @NotNull
    public final FTarget getMainTarget() {
        FTarget fTarget = this.mainTarget;
        if (fTarget != null) {
            return fTarget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainTarget");
        return null;
    }

    @JvmOverloads
    public final boolean hasFocus() {
        return hasFocus$default(this, null, 1, null);
    }

    public final void removeTarget(@NotNull FTarget target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.subTargetList.remove(target);
        if (Intrinsics.areEqual(this.curFocusTarget, target)) {
            FTarget mainTarget = getMainTarget();
            this.curFocusTarget = mainTarget;
            if (mainTarget != null) {
                mainTarget.onGetFocus();
            }
        }
    }

    public final void setMainTarget(@NotNull FTarget fTarget) {
        Intrinsics.checkNotNullParameter(fTarget, "<set-?>");
        this.mainTarget = fTarget;
    }

    public final void updateFocusTarget(@Nullable FTarget target) {
        FTarget fTarget = this.curFocusTarget;
        if (fTarget != null) {
            fTarget.onLoseFocus();
        }
        this.curFocusTarget = target;
        if (target != null) {
            target.onGetFocus();
        }
    }

    @JvmOverloads
    @Nullable
    public final FTarget getFocusTarget(@Nullable FTarget excludeTarget) {
        if (!Intrinsics.areEqual(getMainTarget(), excludeTarget) && getMainTarget().hasFocus()) {
            return getMainTarget();
        }
        Iterator<FTarget> it = this.subTargetList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            FTarget next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            FTarget fTarget = next;
            if (!Intrinsics.areEqual(fTarget, excludeTarget) && fTarget.hasFocus()) {
                return fTarget;
            }
        }
        return null;
    }

    @JvmOverloads
    public final boolean hasFocus(@Nullable FTarget excludeTarget) {
        return getFocusTarget(excludeTarget) != null;
    }
}
