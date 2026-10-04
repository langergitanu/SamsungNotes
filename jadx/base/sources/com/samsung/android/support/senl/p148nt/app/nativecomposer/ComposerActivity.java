package com.samsung.android.support.senl.p148nt.app.nativecomposer;

import com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.basic.view.ComposerFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/nativecomposer/ComposerActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/base/BaseComposerActivity;", "<init>", "()V", "getConcreteClass", "Ljava/lang/Class;", "getClassName", "", "createFragment", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/BaseComposerFragment;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComposerActivity extends BaseComposerActivity {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public BaseComposerFragment createFragment() {
        return new ComposerFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public String getClassName() {
        String name = ComposerActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public Class<?> getConcreteClass() {
        return ComposerActivity.class;
    }
}
