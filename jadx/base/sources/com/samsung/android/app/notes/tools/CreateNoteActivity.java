package com.samsung.android.app.notes.tools;

import android.app.ActivityOptions;
import android.os.Bundle;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.PopupNoteActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/notes/tools/CreateNoteActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/popupnote/PopupNoteActivity;", "<init>", "()V", "getConcreteClass", "Ljava/lang/Class;", "getClassName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "checkHorizontalFolded", "setFullScreenMode", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CreateNoteActivity extends PopupNoteActivity {
    private final void checkHorizontalFolded() {
        if (!FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() || getIntent().getBooleanExtra(FoldedPopupUtil.POSTURE_LAUNCHED_KEY, false)) {
            return;
        }
        FoldedPopupUtil.INSTANCE.getFoldedActivityOptions(this, new C0061b(this, 20));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkHorizontalFolded$lambda$0(CreateNoteActivity createNoteActivity, ActivityOptions activityOptions) {
        if (activityOptions != null) {
            createNoteActivity.getIntent().putExtra(FoldedPopupUtil.POSTURE_LAUNCHED_KEY, true);
            createNoteActivity.finish();
            createNoteActivity.startActivity(createNoteActivity.getIntent(), activityOptions.toBundle());
        }
    }

    private final void setFullScreenMode() {
        if (getIntent().getBooleanExtra(FoldedPopupUtil.POSTURE_LAUNCHED_KEY, false)) {
            getIntent().putExtra(ComposerConstants.ARG_FULLSCREEN_MODE, true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public String getClassName() {
        String name = CreateNoteActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public Class<?> getConcreteClass() {
        return CreateNoteActivity.class;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.popupnote.PopupNoteActivity, com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardLocked(getApplicationContext())) {
            WindowManagerCompat.INSTANCE.getInstance().setShowWhenLocked(this, true, false);
            Intrinsics.checkNotNull(getIntent().putExtra(ComposerConstants.ARG_FULLSCREEN_MODE, true));
        } else {
            checkHorizontalFolded();
            setFullScreenMode();
        }
    }
}
