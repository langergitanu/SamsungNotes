package com.samsung.android.app.notes.widget.configure;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.cover.setting.WidgetSingleCoverSettingActivity;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b'\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H&J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\rH\u0014J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/configure/AbsWidgetConfigureActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mAppWidgetId", "", "mActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getMActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "providerClass", "Ljava/lang/Class;", "getProviderClass", "()Ljava/lang/Class;", "maxCount", "getMaxCount", "()I", "widgetCount", "getWidgetCount", "startPickerActivity", "widgetId", "startMultiSelectPicker", "startSingleSelectPicker", "startSettingCover", "onDestroy", "setWidgetResult", "result", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsWidgetConfigureActivity extends AppCompatActivity {

    @NotNull
    public static final String TAG = "AbsWidgetConfigureActivity";

    @NotNull
    private final ActivityResultLauncher<Intent> mActivityResultLauncher;
    private int mAppWidgetId;
    public static final int $stable = 8;

    public AbsWidgetConfigureActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0061b(this, 3));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.mActivityResultLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mActivityResultLauncher$lambda$0(AbsWidgetConfigureActivity absWidgetConfigureActivity, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        WidgetLogger.m5155i(TAG, "onActivityResult# resultCode: " + resultCode);
        absWidgetConfigureActivity.setWidgetResult(resultCode);
    }

    private final void setWidgetResult(int result) {
        Intent intent = new Intent();
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mAppWidgetId);
        setResult(result, intent);
        finishAndRemoveTask();
    }

    private final void startSettingCover(int widgetId) {
        Intent intent = new Intent(this, (Class<?>) WidgetSingleCoverSettingActivity.class);
        intent.setAction(WidgetConstant.ACTION_MEMO_PICK);
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, companion.getUUID(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, companion.getTransparency(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, companion.getBackgroundColor(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, companion.getDarkMode(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, companion.getWidgetMatchSetting(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, companion.getWidgetBackgroundShape(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, companion.getWidgetBackgroundOnOff(widgetId));
        this.mActivityResultLauncher.launch(intent);
    }

    @NotNull
    public final ActivityResultLauncher<Intent> getMActivityResultLauncher() {
        return this.mActivityResultLauncher;
    }

    public abstract int getMaxCount();

    @Nullable
    public abstract Class<?> getProviderClass();

    public abstract int getWidgetCount();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            WidgetLogger.INSTANCE.m5157e(TAG, "extra info null");
            return;
        }
        this.mAppWidgetId = extras.getInt(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, 0);
        int maxCount = getMaxCount();
        int widgetCount = getWidgetCount();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(this.mAppWidgetId, maxCount, "Add mAppWidgetId: ", ", maxCount: ", ", widgetCount: ");
        sbM1173s.append(widgetCount);
        WidgetLogger.m5155i(TAG, sbM1173s.toString());
        if (!BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            if (maxCount < 0 || maxCount > widgetCount) {
                startPickerActivity(this.mAppWidgetId);
                return;
            }
            WidgetUtils.Companion.showWidgetMaximumToast$default(WidgetUtils.INSTANCE, this, 0, 2, null);
            setWidgetResult(0);
            WidgetLogger.m5156w(TAG, "Add mAppWidgetId: " + this.mAppWidgetId + " cancel.");
            return;
        }
        if (widgetCount >= maxCount) {
            WidgetUtils.Companion.showWidgetMaximumToast$default(WidgetUtils.INSTANCE, this, 0, 2, null);
            setWidgetResult(0);
            WidgetLogger.m5156w(TAG, "Add mAppWidgetId: " + this.mAppWidgetId + " cancel.");
            return;
        }
        WidgetBroadcast.INSTANCE.sendPickNewEmptyWidget(this, this.mAppWidgetId);
        setWidgetResult(-1);
        WidgetLogger.m5156w(TAG, "Add mAppWidgetId: " + this.mAppWidgetId + " ok.");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mActivityResultLauncher.unregister();
    }

    public final void startMultiSelectPicker(int widgetId) {
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(this, NoteListAccessHandler.getNotePickerClass());
        intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        this.mActivityResultLauncher.launch(intent);
    }

    public abstract void startPickerActivity(int widgetId);

    public final void startSingleSelectPicker(int widgetId) {
        Intent intent;
        if (WidgetAccessHandler.INSTANCE.getWidgetResolverClass() == null || NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        if (NotesDataRepositoryFactory.newInstance(this).createMainListDocumentDataRepository().getAllNoteCount(0, true) == 0) {
            intent = new Intent(this, ComposerAccessHandler.getComposerActivityClass());
            intent.setAction(ComposerConstants.ACTION_NEW_MEMO);
            intent.putExtra(ComposerConstants.NEW_MEMO_FROM_PICKER, widgetId);
            intent.putExtra("tool_type", 1);
        } else {
            intent = new Intent(this, NoteListAccessHandler.getNotePickerClass());
            intent.setAction(WidgetConstant.ACTION_MEMO_PICK);
            intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
            intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        }
        this.mActivityResultLauncher.launch(intent);
    }
}
