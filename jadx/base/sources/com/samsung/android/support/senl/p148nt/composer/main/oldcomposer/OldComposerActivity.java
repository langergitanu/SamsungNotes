package com.samsung.android.support.senl.p148nt.composer.main.oldcomposer;

import com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.view.OldComposerFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/oldcomposer/OldComposerActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/base/BaseComposerActivity;", "<init>", "()V", "createFragment", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/BaseComposerFragment;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OldComposerActivity extends BaseComposerActivity {
    public OldComposerActivity() {
        NavigationBarUtil.enrollExcludedListToHideNavigationBar(OldComposerActivity.class);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public BaseComposerFragment createFragment() {
        return new OldComposerFragment();
    }
}
