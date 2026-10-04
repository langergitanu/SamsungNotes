package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle;

import android.os.Build;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.SemBlurCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity$updateActivityContainer$1$2", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NoteStyleActivity$updateActivityContainer$1$2 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ ViewGroup $it;
    final /* synthetic */ NoteStyleActivity this$0;

    public NoteStyleActivity$updateActivityContainer$1$2(ViewGroup viewGroup, NoteStyleActivity noteStyleActivity) {
        this.$it = viewGroup;
        this.this$0 = noteStyleActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreDraw$lambda$0(ViewGroup viewGroup, NoteStyleActivity noteStyleActivity) {
        viewGroup.setForeground(noteStyleActivity.getResources().getDrawable(C9086R.drawable.note_style_activity_border));
        viewGroup.setBackground(noteStyleActivity.getDrawable(C9086R.drawable.note_style_round_corner_bg));
        if (Build.VERSION.SDK_INT >= 35) {
            SemBlurCompat.setBlurEffectPreset$default(viewGroup, 0, ContextUtils.isNightMode(noteStyleActivity) ? 120 : 105, (Integer) null, Float.valueOf(noteStyleActivity.getResources().getDimension(C9086R.dimen.note_style_corner_radius)), (Integer) null, 32, (Object) null);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.$it.getViewTreeObserver().removeOnPreDrawListener(this);
        ViewGroup viewGroup = this.$it;
        viewGroup.post(new RunnableC9844c(viewGroup, this.this$0, 19));
        return true;
    }
}
