package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface IHwToolbarSmartPenGroup {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Child {
        void setParent(Parent parent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parent {
        void notifyEnabled(int i, boolean z);

        void notifyFunctionEnabled(int i, boolean z);

        void notifySelected(int i, boolean z);
    }
}
