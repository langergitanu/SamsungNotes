package com.samsung.android.support.senl.p148nt.app.settings.importnotes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.listener.OnBackKeyListener;
import com.samsung.android.support.senl.p148nt.app.common.listener.OnCustomKeyListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.AbsImportFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.ImportConstants;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.ImportDocumentFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.ImportFolderFragment;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/ImportActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mFragment", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/AbsImportFragment;", "mAnimationCallback", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$AnimationCallback;", "mApplyInsetListener", "Lcom/samsung/android/support/senl/nt/base/common/WindowInsetsManager$ApplyInsetListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "registerWindowInsetManager", "unregisterWindowInsetManager", "updateLayout", "updateListView", "onPause", "initToolbar", "initFragment", "getImportFragmentTag", "", "mode", "", "onCreateOptionsMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onPrepareOptionsMenu", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyDown", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportActivity.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/ImportActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,238:1\n1#2:239\n*E\n"})
public final class ImportActivity extends AppCompatActivity {

    @NotNull
    private static final String TAG = "ST$ImportActivity";

    @NotNull
    private final WindowInsetsManager.AnimationCallback mAnimationCallback = new WindowInsetsManager.AnimationCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.ImportActivity$mAnimationCallback$1
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onEnd(WindowInsetsAnimationCompat animation) throws Exception {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.this$0.updateListView();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onProgress(WindowInsetsCompat windowInsets, List<WindowInsetsAnimationCompat> runningAnimations) {
            Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        }
    };

    @NotNull
    private final WindowInsetsManager.ApplyInsetListener mApplyInsetListener = new WindowInsetsManager.ApplyInsetListener() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.ImportActivity$mApplyInsetListener$1
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.ApplyInsetListener
        public void onApplyInsets(View view, WindowInsetsCompat windowInsetsCompat) throws Exception {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsetsCompat");
            this.this$0.updateListView();
        }
    };

    @Nullable
    private AbsImportFragment mFragment;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DocTypeConstants> entries$0 = EnumEntriesKt.enumEntries(DocTypeConstants.values());
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocTypeConstants.values().length];
            try {
                iArr[DocTypeConstants.SDOC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DocTypeConstants.SDOCX_SCLOUD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DocTypeConstants.SNOTE_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DocTypeConstants.SNOTE_SCLOUD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DocTypeConstants.SNOTE_GOOGLEDRIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DocTypeConstants.MEMO_LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DocTypeConstants.MEMO_SCLOUD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DocTypeConstants.SCRAPBOOK_SCLOUD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final String getImportFragmentTag(int mode) {
        switch (WhenMappings.$EnumSwitchMapping$0[EntriesMappings.entries$0.get(mode).ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return ImportFolderFragment.TAG;
            case 6:
            case 7:
            case 8:
                return ImportDocumentFragment.TAG;
            default:
                return "";
        }
    }

    private final void initFragment() {
        int intExtra = getIntent().getIntExtra(ImportConstants.KEY_TYPE, DocTypeConstants.SNOTE_LOCAL.ordinal());
        String importFragmentTag = getImportFragmentTag(intExtra);
        MainLogger.m7258i(TAG, "initFragment, import mode : " + intExtra + ", tag: " + importFragmentTag);
        if (TextUtils.isEmpty(importFragmentTag)) {
            return;
        }
        AbsImportFragment absImportFragment = (AbsImportFragment) getSupportFragmentManager().findFragmentByTag(importFragmentTag);
        this.mFragment = absImportFragment;
        if (absImportFragment != null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ImportConstants.KEY_TYPE, intExtra);
        if (Intrinsics.areEqual(ImportFolderFragment.TAG, importFragmentTag)) {
            this.mFragment = new ImportFolderFragment();
            bundle.putString("account_name", getIntent().getStringExtra("account_name"));
        } else if (Intrinsics.areEqual(ImportDocumentFragment.TAG, importFragmentTag)) {
            this.mFragment = new ImportDocumentFragment();
        }
        AbsImportFragment absImportFragment2 = this.mFragment;
        if (absImportFragment2 != null) {
            absImportFragment2.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(C8003R.id.fragment_container, absImportFragment2, importFragmentTag).commitAllowingStateLoss();
            absImportFragment2.setHasOptionsMenu(true);
        }
    }

    private final void initToolbar() {
        ActionBar supportActionBar;
        setSupportActionBar((Toolbar) findViewById(C8003R.id.toolbar));
        if (getSupportActionBar() == null || (supportActionBar = getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    private final void registerWindowInsetManager() {
        if (CommonUtil.isNotAvailableActivity(this)) {
            return;
        }
        WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
        companion.getInstance().registerAnimationCallback(getWindow().getDecorView(), this.mAnimationCallback);
        companion.getInstance().registerApplyListener(getWindow().getDecorView(), this.mApplyInsetListener);
    }

    private final void unregisterWindowInsetManager() {
        WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
        companion.getInstance().unregisterAnimationCallback(getWindow().getDecorView());
        companion.getInstance().unregisterApplyListener(getWindow().getDecorView());
    }

    private final void updateLayout() throws Exception {
        DisplayUtils.updateListWidthByScreenSize(findViewById(C8003R.id.fragment_container));
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
        updateListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateListView() throws Exception {
        if (WidgetInsetUtils.getCanUseWindowInsets()) {
            WidgetInsetUtils.applyWindowInsetsForImportList(getWindow(), findViewById(C8003R.id.activity_container), (RecyclerView) findViewById(C8003R.id.recyclerview), (AppBarLayout) findViewById(C8003R.id.appbar_layout), (FloatingToolbarLayout) findViewById(C8003R.id.sesl_floating_toolbar_layout));
        } else {
            WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(findViewById(C8003R.id.activity_container));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) throws Exception {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateLayout();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) throws Exception {
        super.onCreate(savedInstanceState);
        AbstractC8014b.m7201c(hashCode(), "onCreate(), ", TAG);
        PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
        setContentView(C8003R.layout.import_activity);
        initToolbar();
        initFragment();
        ContextUtils.setTaskDescription(this, C8003R.color.task_description_title_color);
        updateLayout();
        registerWindowInsetManager();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        getMenuInflater().inflate(C8003R.menu.import_menu, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterWindowInsetManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AbsImportFragment absImportFragment = this.mFragment;
        return (absImportFragment == 0 || keyCode == 4 || !absImportFragment.isAdded() || !(absImportFragment instanceof OnCustomKeyListener)) ? super.onKeyDown(keyCode, event) : ((OnCustomKeyListener) absImportFragment).onCustomKeyEvent(keyCode, event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AbsImportFragment absImportFragment = this.mFragment;
        if (absImportFragment != 0) {
            if (keyCode == 4) {
                if (absImportFragment.isAdded() && (absImportFragment instanceof OnBackKeyListener) && ((OnBackKeyListener) absImportFragment).onBackKeyDown()) {
                    return true;
                }
            } else if (absImportFragment.isAdded() && (absImportFragment instanceof OnCustomKeyListener)) {
                return ((OnCustomKeyListener) absImportFragment).onCustomKeyEvent(keyCode, event);
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            finish();
            return true;
        }
        AbsImportFragment absImportFragment = this.mFragment;
        return absImportFragment != null ? absImportFragment.handleOptionsItemSelected(item) : super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        AbsImportFragment absImportFragment = this.mFragment;
        if (absImportFragment instanceof ImportDocumentFragment) {
            Intrinsics.checkNotNull(absImportFragment, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.ImportDocumentFragment");
            ((ImportDocumentFragment) absImportFragment).dismissHoverPopup();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        AbsImportFragment absImportFragment = this.mFragment;
        return absImportFragment != null ? absImportFragment.prepareOptionsMenu(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws Exception {
        super.onResume();
        updateLayout();
    }
}
