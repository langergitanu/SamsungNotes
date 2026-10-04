package androidx.compose.p109ui.platform;

import android.view.View;
import androidx.compose.p109ui.platform.WindowRecomposerFactory;
import androidx.compose.runtime.Recomposer;

/* JADX INFO: renamed from: androidx.compose.ui.platform.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C2213m implements WindowRecomposerFactory {
    @Override // androidx.compose.p109ui.platform.WindowRecomposerFactory
    public final Recomposer createRecomposer(View view) {
        return WindowRecomposerFactory.Companion.LifecycleAware$lambda$0(view);
    }
}
