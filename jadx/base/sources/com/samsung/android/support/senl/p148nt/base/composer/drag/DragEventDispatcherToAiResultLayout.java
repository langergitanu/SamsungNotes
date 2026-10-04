package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.view.DragEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcherToAiResultLayout;", "", "aiMenuResultLayoutManager", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcherToAiResultLayout$IAiMenuResultLayoutManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcherToAiResultLayout$IAiMenuResultLayoutManager;)V", "dispatchDragEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/DragEvent;", "IAiMenuResultLayoutManager", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DragEventDispatcherToAiResultLayout {

    @NotNull
    private final IAiMenuResultLayoutManager aiMenuResultLayoutManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcherToAiResultLayout$IAiMenuResultLayoutManager;", "", "dispatchDragEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/DragEvent;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IAiMenuResultLayoutManager {
        boolean dispatchDragEvent(@NotNull View view, @NotNull DragEvent event);
    }

    public DragEventDispatcherToAiResultLayout(@NotNull IAiMenuResultLayoutManager aiMenuResultLayoutManager) {
        Intrinsics.checkNotNullParameter(aiMenuResultLayoutManager, "aiMenuResultLayoutManager");
        this.aiMenuResultLayoutManager = aiMenuResultLayoutManager;
    }

    public final boolean dispatchDragEvent(@NotNull View view, @NotNull DragEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        return this.aiMenuResultLayoutManager.dispatchDragEvent(view, event);
    }
}
