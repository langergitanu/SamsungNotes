package androidx.coordinatorlayout.widget;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface AppBarLayoutBehavior {
    boolean seslCanChangeToHideState();

    int seslGetCurrentAppBarState();

    boolean seslIsCollapsed();

    boolean seslIsHided();

    void seslSetExpanded(boolean z);

    void seslSetHide();

    void seslSetIsMouse(boolean z);

    boolean useFloatingToolbar();
}
