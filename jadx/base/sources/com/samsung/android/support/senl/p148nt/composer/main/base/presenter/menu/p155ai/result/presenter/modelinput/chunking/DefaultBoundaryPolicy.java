package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/DefaultBoundaryPolicy;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/chunking/BoundaryPolicy;", "<init>", "()V", "isSentenceEnd", "", "before", "", "ch", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DefaultBoundaryPolicy implements BoundaryPolicy {

    @NotNull
    public static final DefaultBoundaryPolicy INSTANCE = new DefaultBoundaryPolicy();

    private DefaultBoundaryPolicy() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.BoundaryPolicy
    public boolean isSentenceEnd(char before, char ch) {
        if (ch != '\n' && ch != 12290) {
            if (before != '.' && before != '!' && before != '?') {
                return false;
            }
            if (ch != '\t' && ch != ' ') {
                return false;
            }
        }
        return true;
    }
}
