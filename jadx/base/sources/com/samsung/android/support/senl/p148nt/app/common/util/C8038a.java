package com.samsung.android.support.senl.p148nt.app.common.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.common.util.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8038a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6074a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Window f6075b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f6076c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ AppBarLayout f6077d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ FloatingToolbarLayout f6078e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ FloatingBottomLayout f6079f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ ViewGroup f6080g;

    public /* synthetic */ C8038a(Window window, View view, ViewGroup viewGroup, AppBarLayout appBarLayout, FloatingToolbarLayout floatingToolbarLayout, FloatingBottomLayout floatingBottomLayout, int i) {
        this.f6074a = i;
        this.f6075b = window;
        this.f6076c = view;
        this.f6080g = viewGroup;
        this.f6077d = appBarLayout;
        this.f6078e = floatingToolbarLayout;
        this.f6079f = floatingBottomLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f6074a) {
            case 0:
                return WidgetInsetUtils.applyWindowInsetsForFolderList$lambda$11(this.f6075b, this.f6076c, (RecyclerView) this.f6080g, this.f6077d, this.f6078e, this.f6079f, (WindowInsetsCompat) obj);
            default:
                return WidgetInsetUtils.applyWindowInsetsForSetting$lambda$2(this.f6075b, this.f6076c, this.f6080g, this.f6077d, this.f6078e, this.f6079f, (WindowInsetsCompat) obj);
        }
    }
}
