package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001J0\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J0\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u001c\u001a\u00020\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenCustomObjectEventListener;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$CustomObjectEventListener;", "spenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "<init>", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", "getSpenWNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setSpenWNote", "listeners", "", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "onCustomObjectAdded", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "Lkotlin/collections/ArrayList;", "historyEventType", "", "onCustomObjectChanged", "changedInfo", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$CustomObjectEventListener$CustomObjectChangedInfo;", "onCustomObjectRemoved", "release", "isAliveNote", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenCustomObjectEventListener implements SpenWNote.CustomObjectEventListener {

    @Nullable
    private List<SpenWNote.CustomObjectEventListener> listeners;

    @Nullable
    private SpenWNote spenWNote;

    public SpenCustomObjectEventListener(@Nullable SpenWNote spenWNote) {
        this.spenWNote = spenWNote;
    }

    private final boolean isAliveNote() {
        SpenWNote spenWNote = this.spenWNote;
        return (spenWNote == null || spenWNote.isClosed()) ? false : true;
    }

    public final void addListener(@NotNull SpenWNote.CustomObjectEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.listeners == null) {
            this.listeners = new ArrayList();
            SpenWNote spenWNote = this.spenWNote;
            if (spenWNote != null) {
                spenWNote.registerCustomObjectEventListener(this);
            }
        }
        List<SpenWNote.CustomObjectEventListener> list = this.listeners;
        if (list != null) {
            list.add(listener);
        }
    }

    @Nullable
    public final SpenWNote getSpenWNote() {
        return this.spenWNote;
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
    public void onCustomObjectAdded(@NotNull SpenWPage page, @NotNull ArrayList<SpenCustomObject> objectList, int historyEventType) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        List<SpenWNote.CustomObjectEventListener> list = this.listeners;
        if (list != null) {
            Iterator<SpenWNote.CustomObjectEventListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCustomObjectAdded(page, objectList, historyEventType);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
    public void onCustomObjectChanged(@NotNull SpenWPage page, @NotNull SpenWNote.CustomObjectEventListener.CustomObjectChangedInfo changedInfo, int historyEventType) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
        List<SpenWNote.CustomObjectEventListener> list = this.listeners;
        if (list != null) {
            Iterator<SpenWNote.CustomObjectEventListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCustomObjectChanged(page, changedInfo, historyEventType);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
    public void onCustomObjectRemoved(@NotNull SpenWPage page, @NotNull ArrayList<SpenCustomObject> objectList, int historyEventType) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        List<SpenWNote.CustomObjectEventListener> list = this.listeners;
        if (list != null) {
            Iterator<SpenWNote.CustomObjectEventListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCustomObjectRemoved(page, objectList, historyEventType);
            }
        }
    }

    public final void release() {
        SpenWNote spenWNote;
        if (isAliveNote() && (spenWNote = this.spenWNote) != null) {
            spenWNote.deregisterCustomObjectEventListener(this);
        }
        List<SpenWNote.CustomObjectEventListener> list = this.listeners;
        if (list != null) {
            list.clear();
        }
        this.spenWNote = null;
    }

    public final void removeListener(@NotNull SpenWNote.CustomObjectEventListener listener) {
        SpenWNote spenWNote;
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<SpenWNote.CustomObjectEventListener> list = this.listeners;
        if (list != null) {
            list.remove(listener);
        }
        List<SpenWNote.CustomObjectEventListener> list2 = this.listeners;
        if (list2 == null || !list2.isEmpty() || !isAliveNote() || (spenWNote = this.spenWNote) == null) {
            return;
        }
        spenWNote.deregisterCustomObjectEventListener(this);
    }

    public final void setSpenWNote(@Nullable SpenWNote spenWNote) {
        this.spenWNote = spenWNote;
    }
}
