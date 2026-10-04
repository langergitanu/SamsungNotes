package com.samsung.android.support.senl.p148nt.app.lock.model.scenario;

import android.os.Build;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0016\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016RF\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/scenario/LockScenario;", "Lcom/samsung/android/support/senl/nt/app/lock/model/scenario/ILockScenario;", "viewQueue", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "lockScenarioType", "useFinger", "", "useIris", "(IZZ)V", "value", "getViewQueue", "()Ljava/util/ArrayList;", "makeViewQueue", "", "insertFront", "lockViewType", "nextViewType", "getNextViewType", "()I", "hasNext", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockScenario implements ILockScenario {

    @Nullable
    private ArrayList<Integer> viewQueue;

    public LockScenario(@Nullable ArrayList<Integer> arrayList) {
        this.viewQueue = arrayList;
    }

    private final void makeViewQueue(int lockScenarioType, boolean useFinger, boolean useIris) {
        this.viewQueue = new ArrayList<>();
        if (lockScenarioType == 11) {
            ArrayList<Integer> viewQueue = getViewQueue();
            Intrinsics.checkNotNull(viewQueue);
            viewQueue.add(11);
            return;
        }
        switch (lockScenarioType) {
            case 1:
                ArrayList<Integer> viewQueue2 = getViewQueue();
                Intrinsics.checkNotNull(viewQueue2);
                viewQueue2.add(1);
                break;
            case 2:
                ArrayList<Integer> viewQueue3 = getViewQueue();
                Intrinsics.checkNotNull(viewQueue3);
                viewQueue3.add(6);
                break;
            case 3:
                ArrayList<Integer> viewQueue4 = getViewQueue();
                Intrinsics.checkNotNull(viewQueue4);
                viewQueue4.add(2);
                break;
            case 4:
                ArrayList<Integer> viewQueue5 = getViewQueue();
                Intrinsics.checkNotNull(viewQueue5);
                viewQueue5.add(21);
                break;
            case 5:
                if (useFinger && useIris) {
                    ArrayList<Integer> viewQueue6 = getViewQueue();
                    Intrinsics.checkNotNull(viewQueue6);
                    viewQueue6.add(5);
                } else if (!useFinger) {
                    if (!useIris) {
                        ArrayList<Integer> viewQueue7 = getViewQueue();
                        Intrinsics.checkNotNull(viewQueue7);
                        viewQueue7.add(2);
                    } else if (Build.VERSION.SDK_INT >= 29) {
                        ArrayList<Integer> viewQueue8 = getViewQueue();
                        Intrinsics.checkNotNull(viewQueue8);
                        viewQueue8.add(4);
                    } else {
                        ArrayList<Integer> viewQueue9 = getViewQueue();
                        Intrinsics.checkNotNull(viewQueue9);
                        viewQueue9.add(41);
                    }
                } else if (Build.VERSION.SDK_INT >= 28) {
                    ArrayList<Integer> viewQueue10 = getViewQueue();
                    Intrinsics.checkNotNull(viewQueue10);
                    viewQueue10.add(3);
                } else {
                    ArrayList<Integer> viewQueue11 = getViewQueue();
                    Intrinsics.checkNotNull(viewQueue11);
                    viewQueue11.add(31);
                }
                break;
            case 6:
                ArrayList<Integer> viewQueue12 = getViewQueue();
                Intrinsics.checkNotNull(viewQueue12);
                viewQueue12.add(7);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.model.scenario.ILockScenario
    public int getNextViewType() {
        ArrayList<Integer> viewQueue = getViewQueue();
        if (viewQueue == null || viewQueue.isEmpty()) {
            return -1;
        }
        ArrayList<Integer> viewQueue2 = getViewQueue();
        Intrinsics.checkNotNull(viewQueue2);
        Integer numRemove = viewQueue2.remove(0);
        Intrinsics.checkNotNullExpressionValue(numRemove, "removeAt(...)");
        return numRemove.intValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.model.scenario.ILockScenario
    @Nullable
    public ArrayList<Integer> getViewQueue() {
        return this.viewQueue;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.model.scenario.ILockScenario
    public boolean hasNext() {
        ArrayList<Integer> viewQueue = getViewQueue();
        return !(viewQueue == null || viewQueue.isEmpty());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.model.scenario.ILockScenario
    public void insertFront(int lockViewType) {
        ArrayList<Integer> viewQueue = getViewQueue();
        if (viewQueue != null) {
            viewQueue.add(0, Integer.valueOf(lockViewType));
        }
    }

    public LockScenario(int i, boolean z, boolean z2) {
        makeViewQueue(i, z, z2);
    }
}
