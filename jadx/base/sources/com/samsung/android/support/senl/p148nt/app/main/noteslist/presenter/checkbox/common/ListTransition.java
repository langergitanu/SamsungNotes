package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.checkbox.common;

import android.view.animation.DecelerateInterpolator;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionSet;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/checkbox/common/ListTransition;", "Landroidx/transition/TransitionSet;", "<init>", "()V", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ListTransition extends TransitionSet {
    public ListTransition() {
        addTransition(new ChangeBounds().setDuration(500L).setInterpolator(new DecelerateInterpolator()));
        setOrdering(0);
    }
}
