package com.samsung.android.support.senl.addons.brush;

import com.samsung.android.support.senl.addons.base.AbsToolActivity;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView;
import com.samsung.android.support.senl.addons.brush.util.BrushToastHandler;
import com.samsung.android.support.senl.addons.brush.view.BrushView;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0005H\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/AbsBrushActivity;", "Lcom/samsung/android/support/senl/addons/base/AbsToolActivity;", "<init>", "()V", "initialize", "", "createView", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/BaseFragmentView;", "getViewTag", "", "onDestroy", "onResume", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBrushActivity extends AbsToolActivity {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushActivity");

    @Override // com.samsung.android.support.senl.addons.base.AbsToolActivity
    @Nullable
    public BaseFragmentView createView() {
        return new BrushView();
    }

    @Override // com.samsung.android.support.senl.addons.base.AbsToolActivity
    @Nullable
    public String getViewTag() {
        return BrushView.INSTANCE.getTAG();
    }

    @Override // com.samsung.android.support.senl.addons.base.AbsToolActivity
    public void initialize() {
        super.initialize();
        Logger.m7100d(TAG, "initialize");
        BrushToastHandler.INSTANCE.setContext(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Logger.m7100d(TAG, "onDestroy");
        BrushToastHandler.INSTANCE.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.AbsToolActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Logger.m7100d(TAG, "onResume() - forceHideSoftInput");
        InputMethodCompat.INSTANCE.getInstance().forceHideSoftInput(this);
    }
}
