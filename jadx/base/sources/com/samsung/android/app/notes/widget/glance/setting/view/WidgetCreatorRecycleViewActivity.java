package com.samsung.android.app.notes.widget.glance.setting.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.emoji2.text.flatbuffer.C2747a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.google.android.material.oneui.dividerbuttonlayout.DividerButtonLayout;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorAdapter;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.RecyclerViewCustom;
import com.samsung.android.support.senl.p145cm.base.framework.view.DisplayCutoutCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p017D1.C0061b;
import p027F3.RunnableC0101a;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0015J\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0006\u0010\u001d\u001a\u00020\u0014J \u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012J\b\u0010#\u001a\u00020\u0014H\u0017J\b\u0010$\u001a\u00020\u0014H\u0014J\b\u0010%\u001a\u00020\u0014H\u0014J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0016H\u0014J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0015J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorRecycleViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "mToolbarText", "Landroid/widget/TextView;", "mCreatorListView", "Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/RecyclerViewCustom;", "mSave", "Landroid/view/MenuItem;", "mListItems", "", "", "mWidgetCreatorAdapter", "Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter;", "mCheckedState", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "disableSystemBarInsets", "view", "Landroid/view/View;", "maskSupplier", "Ljava/util/function/Supplier;", "setListItems", "initCancelSavePortrait", "enableMenuItem", "item", "isEnable", "", "alpha", "onBackPressed", "onPause", "onDestroy", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onRestoreInstanceState", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCreatorRecycleViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCreatorRecycleViewActivity.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorRecycleViewActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,227:1\n1563#2:228\n1634#2,3:229\n1#3:232\n*S KotlinDebug\n*F\n+ 1 WidgetCreatorRecycleViewActivity.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorRecycleViewActivity\n*L\n103#1:228\n103#1:229,3\n*E\n"})
public final class WidgetCreatorRecycleViewActivity extends AppCompatActivity {

    @NotNull
    private static final String TAG = "WidgetCreatorRecycleViewActivity";
    public static final int WIDGET_TEXT_BUTTON_TEXT_SIZE = 18;
    public static final int WIDGET_TEXT_TOOLBAR_TEXT_SIZE = 21;

    @NotNull
    private List<Integer> mCheckedState = CollectionsKt.emptyList();

    @Nullable
    private RecyclerViewCustom mCreatorListView;

    @Nullable
    private List<String> mListItems;

    @Nullable
    private MenuItem mSave;

    @Nullable
    private Toolbar mToolbar;

    @Nullable
    private TextView mToolbarText;

    @Nullable
    private WidgetCreatorAdapter mWidgetCreatorAdapter;
    public static final int $stable = 8;

    private final void disableSystemBarInsets(View view, Supplier<Integer> maskSupplier) {
        if (Build.VERSION.SDK_INT > 34) {
            ViewCompat.setOnApplyWindowInsetsListener(view, new C0061b(maskSupplier, 21));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat disableSystemBarInsets$lambda$5(Supplier supplier, View v, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Object obj = supplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Insets insets = windowInsets.getInsets(((Number) obj).intValue());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = insets.left;
        marginLayoutParams.bottomMargin = insets.bottom;
        marginLayoutParams.rightMargin = insets.right;
        marginLayoutParams.topMargin = insets.top;
        v.setLayoutParams(marginLayoutParams);
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer onCreate$lambda$0() {
        return Integer.valueOf(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$2(WidgetCreatorRecycleViewActivity widgetCreatorRecycleViewActivity, View view, MotionEvent motionEvent) {
        if (widgetCreatorRecycleViewActivity.getResources().getConfiguration().orientation != 1) {
            return false;
        }
        view.getParent().requestDisallowInterceptTouchEvent(true);
        view.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(WidgetCreatorRecycleViewActivity widgetCreatorRecycleViewActivity, int i, RoundCornerOverlayView roundCornerOverlayView) {
        RecyclerViewCustom recyclerViewCustom = widgetCreatorRecycleViewActivity.mCreatorListView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, recyclerViewCustom != null ? recyclerViewCustom.getHeight() : 0);
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i);
        roundCornerOverlayView.setLayoutParams(layoutParams);
        roundCornerOverlayView.invalidate();
    }

    private final List<String> setListItems() {
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{getResources().getString(C6635R.string.widget_creator_open_samsung_notes), getResources().getString(C6635R.string.widget_creator_start_note_text), getResources().getString(C6635R.string.widget_creator_start_note_handwriting), getResources().getString(C6635R.string.widget_creator_start_note_drawing), getResources().getString(C6635R.string.widget_creator_start_note_image), getResources().getString(C6635R.string.widget_creator_start_note_recording)});
        this.mListItems = listListOf;
        Intrinsics.checkNotNull(listListOf, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        return listListOf;
    }

    public final void enableMenuItem(@Nullable MenuItem item, boolean isEnable, int alpha) {
        Drawable icon;
        if (item != null) {
            item.setEnabled(isEnable);
        }
        if (item == null || (icon = item.getIcon()) == null) {
            return;
        }
        icon.setAlpha(alpha);
    }

    public final void initCancelSavePortrait() {
        DividerButtonLayout dividerButtonLayout = (DividerButtonLayout) findViewById(C6635R.id.widget_creator_divider_button_layout);
        dividerButtonLayout.inflateMenu(C6635R.menu.widget_setting_menu);
        dividerButtonLayout.setOnMenuItemClickListener(new DividerButtonLayout.OnMenuItemClickListener() { // from class: com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity.initCancelSavePortrait.1
            @Override // com.google.android.material.oneui.dividerbuttonlayout.DividerButtonLayout.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                if (item.getItemId() != C6635R.id.save) {
                    WidgetCreatorRecycleViewActivity.this.finish();
                    return true;
                }
                WidgetCreatorAdapter widgetCreatorAdapter = WidgetCreatorRecycleViewActivity.this.mWidgetCreatorAdapter;
                List<Integer> selectedItem = widgetCreatorAdapter != null ? widgetCreatorAdapter.getSelectedItem() : null;
                Intent intent = new Intent();
                intent.putIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS, (ArrayList) selectedItem);
                WidgetCreatorRecycleViewActivity.this.setResult(-1, intent);
                WidgetCreatorRecycleViewActivity.this.finish();
                return true;
            }
        });
        MenuItem menuItemFindItem = dividerButtonLayout.getMenu().findItem(C6635R.id.save);
        this.mSave = menuItemFindItem;
        if (menuItemFindItem != null) {
            if (this.mCheckedState.size() >= 4) {
                enableMenuItem(this.mSave, true, 100);
            } else {
                enableMenuItem(this.mSave, false, 40);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed: ");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x016e  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        List<Integer> arrayList;
        Resources resources;
        super.onCreate(savedInstanceState);
        setContentView(C6635R.layout.widget_creator_setting_control);
        this.mToolbar = (Toolbar) findViewById(C6635R.id.toolbar);
        this.mToolbarText = (TextView) findViewById(C6635R.id.tv_toolbar);
        Intent intent = getIntent();
        ArrayList<Integer> integerArrayListExtra = intent != null ? intent.getIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS) : null;
        TextView textView = this.mToolbarText;
        if (textView != null) {
            textView.setText(getResources().getQuantityString(C6635R.plurals.plurals_select_up_to_shortcuts, integerArrayListExtra != null ? integerArrayListExtra.size() : 0, integerArrayListExtra != null ? Integer.valueOf(integerArrayListExtra.size()) : null));
        }
        int color = getResources().getColor(C6635R.color.widget_setting_background, getTheme());
        boolean z = !ContextUtils.isNightMode(this);
        DisplayCutoutCompat.INSTANCE.getInstance().setDisplayCutoutBGColor(this, color);
        SystemUi.setStatusBarTheme(this, color, z);
        SystemUi.setNavigationBarTheme(this, color, z);
        WindowManagerCompat.INSTANCE.getInstance().controlIndicatorBar(this);
        View viewFindViewById = findViewById(C6635R.id.widget_creator_setting_control_root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        disableSystemBarInsets(viewFindViewById, new C2747a(1));
        setSupportActionBar(this.mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayShowTitleEnabled(false);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setBackgroundDrawable(new ColorDrawable(color));
        }
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new ViewOnClickListenerC0157a(this, 6));
        }
        RecyclerViewCustom recyclerViewCustom = (RecyclerViewCustom) findViewById(C6635R.id.widget_creator_setting_list);
        this.mCreatorListView = recyclerViewCustom;
        int dimensionPixelSize = (recyclerViewCustom == null || (resources = recyclerViewCustom.getResources()) == null) ? 10 : resources.getDimensionPixelSize(C6635R.dimen.widget_creator_setting_padding);
        RecyclerViewCustom recyclerViewCustom2 = this.mCreatorListView;
        if (recyclerViewCustom2 != null) {
            recyclerViewCustom2.seslSetFillHorizontalPaddingEnabled(true, dimensionPixelSize, color);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        RecyclerViewCustom recyclerViewCustom3 = this.mCreatorListView;
        RecyclerView.ItemAnimator itemAnimator = recyclerViewCustom3 != null ? recyclerViewCustom3.getItemAnimator() : null;
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        RecyclerViewCustom recyclerViewCustom4 = this.mCreatorListView;
        if (recyclerViewCustom4 != null) {
            recyclerViewCustom4.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 2));
        }
        RecyclerViewCustom recyclerViewCustom5 = this.mCreatorListView;
        if (recyclerViewCustom5 != null) {
            recyclerViewCustom5.setLayoutManager(linearLayoutManager);
        }
        View viewFindViewById2 = findViewById(C6635R.id.widget_creator_setting_overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        RoundCornerOverlayView roundCornerOverlayView = (RoundCornerOverlayView) viewFindViewById2;
        RecyclerViewCustom recyclerViewCustom6 = this.mCreatorListView;
        if (recyclerViewCustom6 != null) {
            recyclerViewCustom6.post(new RunnableC0101a(this, dimensionPixelSize, roundCornerOverlayView, 6));
        }
        if (savedInstanceState != null) {
            ArrayList<Integer> integerArrayList = savedInstanceState.getIntegerArrayList("checked_states");
            if (integerArrayList == null || (arrayList = CollectionsKt.toList(integerArrayList)) == null) {
                arrayList = CollectionsKt.emptyList();
            }
        } else if (integerArrayListExtra != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(integerArrayListExtra));
            for (Integer num : integerArrayListExtra) {
                num.getClass();
                arrayList2.add(num);
            }
            arrayList = CollectionsKt.sorted(arrayList2);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
        }
        this.mCheckedState = arrayList;
        List<String> listItems = setListItems();
        this.mListItems = listItems;
        Intrinsics.checkNotNull(listItems);
        WidgetCreatorAdapter widgetCreatorAdapter = new WidgetCreatorAdapter(listItems, this.mCheckedState, new WidgetCreatorAdapter.OnSelectionChangeListener() { // from class: com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity.onCreate.6
            @Override // com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorAdapter.OnSelectionChangeListener
            @SuppressLint({"NotifyDataSetChanged"})
            public void onSelectionChangeListener(int selectedCount) {
                if (selectedCount >= 4) {
                    WidgetCreatorRecycleViewActivity widgetCreatorRecycleViewActivity = WidgetCreatorRecycleViewActivity.this;
                    widgetCreatorRecycleViewActivity.enableMenuItem(widgetCreatorRecycleViewActivity.mSave, true, 100);
                } else {
                    WidgetCreatorRecycleViewActivity widgetCreatorRecycleViewActivity2 = WidgetCreatorRecycleViewActivity.this;
                    widgetCreatorRecycleViewActivity2.enableMenuItem(widgetCreatorRecycleViewActivity2.mSave, false, 40);
                }
            }
        });
        this.mWidgetCreatorAdapter = widgetCreatorAdapter;
        RecyclerViewCustom recyclerViewCustom7 = this.mCreatorListView;
        if (recyclerViewCustom7 != null) {
            recyclerViewCustom7.setAdapter(widgetCreatorAdapter);
        }
        initCancelSavePortrait();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override // android.app.Activity
    @SuppressLint({"NotifyDataSetChanged"})
    public void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        List<Integer> listEmptyList;
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Integer> integerArrayList = savedInstanceState.getIntegerArrayList("checked_states");
        if (integerArrayList == null || (listEmptyList = CollectionsKt.toList(integerArrayList)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        this.mCheckedState = listEmptyList;
        WidgetCreatorAdapter widgetCreatorAdapter = this.mWidgetCreatorAdapter;
        if (widgetCreatorAdapter != null) {
            widgetCreatorAdapter.setCheckedState(listEmptyList);
        }
        WidgetCreatorAdapter widgetCreatorAdapter2 = this.mWidgetCreatorAdapter;
        if (widgetCreatorAdapter2 != null) {
            widgetCreatorAdapter2.notifyDataSetChanged();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        WidgetCreatorAdapter widgetCreatorAdapter = this.mWidgetCreatorAdapter;
        List<Integer> selectedItem = widgetCreatorAdapter != null ? widgetCreatorAdapter.getSelectedItem() : null;
        outState.putIntegerArrayList("checked_states", selectedItem != null ? new ArrayList<>(selectedItem) : null);
    }
}
