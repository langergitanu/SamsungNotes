package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.AbsItemOrderInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultItemOrder;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarOrderManager {
    private static final String ITEM_ORDER_CANDIDATE_KEY = "settings_candidate_toolbar_item_order";
    private static final String ITEM_ORDER_KEY = "settings_toolbar_item_order";
    private static final String ITEM_ORDER_PREFERENCE = "Settings";
    private static final String TAG = Logger.createTag("HwToolbarOrderManager");
    private int[] mChainViewIds;
    private final ComponentFactory mComponentFactory;
    private final AbsToolbarContainerLayout mFloatingContainer;
    private final HwToolbarPresenterImpl mHwToolbarPresenter;
    private final ViewGroup mItemContainer;
    private int firstDividerId = 0;
    private int secondDividerId = 0;
    private final LinkedHashMap<DefaultItemOrder.ItemInfo, AbsItemOrderInfo> mItemInfoLinkedMap = new LinkedHashMap<>();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarOrderManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C105771 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$model$menu$toolbar$hw$setting$constants$DefaultItemOrder$ItemInfo */
        static final /* synthetic */ int[] f7223x48ae29d5;

        static {
            int[] iArr = new int[DefaultItemOrder.ItemInfo.values().length];
            f7223x48ae29d5 = iArr;
            try {
                iArr[DefaultItemOrder.ItemInfo.Pen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Highlighter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.DirectWrite.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Eraser.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Selection.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Style.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.ConvertText.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Shape.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Undo.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Redo.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.EasyWritePad.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Align.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.LockCanvas.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.QuickColor.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.QuickSize.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.TextMode.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.Assistance.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.LaserPen.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.CleanUpAndConvertText.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.AiAssist.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.MoveOnlyMode.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.SmartPen.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f7223x48ae29d5[DefaultItemOrder.ItemInfo.CustomToolbarSetting.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory {
        @NonNull
        HwToolbarItem createHwToolbarAiAssist(View view, HwToolbarItemContract hwToolbarItemContract);

        @NonNull
        HwToolbarItem createHwToolbarCustomToolbarSetting(View view, HwToolbarItemContract hwToolbarItemContract);
    }

    public HwToolbarOrderManager(ViewGroup viewGroup, AbsToolbarContainerLayout absToolbarContainerLayout, HwToolbarPresenterImpl hwToolbarPresenterImpl, @NonNull ComponentFactory componentFactory) {
        this.mItemContainer = viewGroup;
        this.mFloatingContainer = absToolbarContainerLayout;
        this.mHwToolbarPresenter = hwToolbarPresenterImpl;
        this.mComponentFactory = componentFactory;
    }

    private void applyGapMargin(boolean z) {
        if (DeviceInfo.isVSTModel()) {
            return;
        }
        connectConstraint(z, getItemGapMargin(this.mItemContainer.getResources().getConfiguration().orientation));
    }

    private void bindItemView(LinkedHashMap<Integer, HwToolbarItem> linkedHashMap, HwToolbarItemContract hwToolbarItemContract, DefaultItemOrder.ItemInfo itemInfo, View view) {
        switch (C105771.f7223x48ae29d5[itemInfo.ordinal()]) {
            case 1:
                HwToolbarPen hwToolbarPen = new HwToolbarPen(view, hwToolbarItemContract);
                hwToolbarPen.setViewId(2);
                linkedHashMap.put(Integer.valueOf(hwToolbarPen.getViewId()), hwToolbarPen);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarPen.getViewId());
                break;
            case 2:
                HwToolbarHighlighter hwToolbarHighlighter = new HwToolbarHighlighter(view, hwToolbarItemContract);
                hwToolbarHighlighter.setViewId(2048);
                linkedHashMap.put(Integer.valueOf(hwToolbarHighlighter.getViewId()), hwToolbarHighlighter);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarHighlighter.getViewId());
                break;
            case 3:
                HwToolbarDirectWrite hwToolbarDirectWrite = new HwToolbarDirectWrite(view, hwToolbarItemContract);
                hwToolbarDirectWrite.setViewId(8192);
                linkedHashMap.put(Integer.valueOf(hwToolbarDirectWrite.getViewId()), hwToolbarDirectWrite);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarDirectWrite.getViewId());
                break;
            case 4:
                HwToolbarEraser hwToolbarEraser = new HwToolbarEraser(view, hwToolbarItemContract);
                hwToolbarEraser.setViewId(4);
                linkedHashMap.put(Integer.valueOf(hwToolbarEraser.getViewId()), hwToolbarEraser);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarEraser.getViewId());
                break;
            case 5:
                HwToolbarSelection hwToolbarSelection = new HwToolbarSelection(view, hwToolbarItemContract);
                hwToolbarSelection.setViewId(8);
                linkedHashMap.put(Integer.valueOf(hwToolbarSelection.getViewId()), hwToolbarSelection);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarSelection.getViewId());
                break;
            case 6:
                HwToolbarStyle hwToolbarStyle = new HwToolbarStyle(view, hwToolbarItemContract);
                hwToolbarStyle.setViewId(16);
                linkedHashMap.put(Integer.valueOf(hwToolbarStyle.getViewId()), hwToolbarStyle);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarStyle.getViewId());
                break;
            case 7:
                HwToolbarConvertText hwToolbarConvertText = new HwToolbarConvertText(view, hwToolbarItemContract);
                hwToolbarConvertText.setViewId(32);
                linkedHashMap.put(Integer.valueOf(hwToolbarConvertText.getViewId()), hwToolbarConvertText);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarConvertText.getViewId());
                break;
            case 8:
                HwToolbarShapeRecognition hwToolbarShapeRecognition = new HwToolbarShapeRecognition(view, hwToolbarItemContract);
                hwToolbarShapeRecognition.setViewId(64);
                linkedHashMap.put(Integer.valueOf(hwToolbarShapeRecognition.getViewId()), hwToolbarShapeRecognition);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarShapeRecognition.getViewId());
                break;
            case 9:
                HwToolbarUndo hwToolbarUndo = new HwToolbarUndo(view, hwToolbarItemContract);
                hwToolbarUndo.setViewId(256);
                linkedHashMap.put(Integer.valueOf(hwToolbarUndo.getViewId()), hwToolbarUndo);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarUndo.getViewId());
                break;
            case 10:
                HwToolbarRedo hwToolbarRedo = new HwToolbarRedo(view, hwToolbarItemContract);
                hwToolbarRedo.setViewId(512);
                linkedHashMap.put(Integer.valueOf(hwToolbarRedo.getViewId()), hwToolbarRedo);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarRedo.getViewId());
                break;
            case 11:
                HwToolbarEasyWritingPad hwToolbarEasyWritingPad = new HwToolbarEasyWritingPad(view, hwToolbarItemContract);
                hwToolbarEasyWritingPad.setViewId(1024);
                linkedHashMap.put(Integer.valueOf(hwToolbarEasyWritingPad.getViewId()), hwToolbarEasyWritingPad);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarEasyWritingPad.getViewId());
                break;
            case 12:
                HwToolbarAlignmentRecognition hwToolbarAlignmentRecognition = new HwToolbarAlignmentRecognition(view, hwToolbarItemContract);
                hwToolbarAlignmentRecognition.setViewId(128);
                linkedHashMap.put(Integer.valueOf(hwToolbarAlignmentRecognition.getViewId()), hwToolbarAlignmentRecognition);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarAlignmentRecognition.getViewId());
                break;
            case 13:
                HwToolbarLockCanvas hwToolbarLockCanvas = new HwToolbarLockCanvas(view, hwToolbarItemContract);
                hwToolbarLockCanvas.setViewId(4096);
                linkedHashMap.put(Integer.valueOf(hwToolbarLockCanvas.getViewId()), hwToolbarLockCanvas);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarLockCanvas.getViewId());
                break;
            case 14:
                bindQuickColorItem(linkedHashMap, hwToolbarItemContract, view);
                break;
            case 15:
                bindQuickSizeItem(linkedHashMap, hwToolbarItemContract, view);
                break;
            case 16:
                HwToolbarTextMode hwToolbarTextMode = new HwToolbarTextMode(view, hwToolbarItemContract);
                hwToolbarTextMode.setViewId(65536);
                linkedHashMap.put(Integer.valueOf(hwToolbarTextMode.getViewId()), hwToolbarTextMode);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarTextMode.getViewId());
                break;
            case 17:
                HwToolbarAssistance hwToolbarAssistance = new HwToolbarAssistance(view, hwToolbarItemContract);
                hwToolbarAssistance.setViewId(131072);
                linkedHashMap.put(Integer.valueOf(hwToolbarAssistance.getViewId()), hwToolbarAssistance);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarAssistance.getViewId());
                break;
            case 18:
                HwToolbarLaserPen hwToolbarLaserPen = new HwToolbarLaserPen(view, hwToolbarItemContract);
                hwToolbarLaserPen.setViewId(262144);
                linkedHashMap.put(Integer.valueOf(hwToolbarLaserPen.getViewId()), hwToolbarLaserPen);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarLaserPen.getViewId());
                break;
            case 19:
                HwToolbarCleanUpAndConvertText hwToolbarCleanUpAndConvertText = new HwToolbarCleanUpAndConvertText(view, hwToolbarItemContract);
                hwToolbarCleanUpAndConvertText.setViewId(524288);
                linkedHashMap.put(Integer.valueOf(hwToolbarCleanUpAndConvertText.getViewId()), hwToolbarCleanUpAndConvertText);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarCleanUpAndConvertText.getViewId());
                break;
            case 20:
                HwToolbarItem hwToolbarItemCreateHwToolbarAiAssist = this.mComponentFactory.createHwToolbarAiAssist(view, hwToolbarItemContract);
                hwToolbarItemCreateHwToolbarAiAssist.setViewId(1048576);
                linkedHashMap.put(Integer.valueOf(hwToolbarItemCreateHwToolbarAiAssist.getViewId()), hwToolbarItemCreateHwToolbarAiAssist);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarItemCreateHwToolbarAiAssist.getViewId());
                break;
            case 21:
                HwToolbarMoveOnlyMode hwToolbarMoveOnlyMode = new HwToolbarMoveOnlyMode(view, hwToolbarItemContract);
                hwToolbarMoveOnlyMode.setViewId(2097152);
                linkedHashMap.put(Integer.valueOf(hwToolbarMoveOnlyMode.getViewId()), hwToolbarMoveOnlyMode);
                this.mHwToolbarPresenter.getHWToolbarPolicyManager().setPolicy(hwToolbarMoveOnlyMode.getViewId());
                break;
            case 22:
                HashMap map = new HashMap();
                for (int i : HwToolbarConstants.SMART_PEN_ITEMS) {
                    HwToolbarItem hwToolbarItem = linkedHashMap.get(Integer.valueOf(i));
                    if (hwToolbarItem != null) {
                        map.put(Integer.valueOf(i), hwToolbarItem);
                    }
                }
                HwToolbarSmartPen hwToolbarSmartPen = new HwToolbarSmartPen(view, hwToolbarItemContract, map);
                hwToolbarSmartPen.setViewId(4194304);
                linkedHashMap.put(Integer.valueOf(hwToolbarSmartPen.getViewId()), hwToolbarSmartPen);
                break;
            case 23:
                HwToolbarItem hwToolbarItemCreateHwToolbarCustomToolbarSetting = this.mComponentFactory.createHwToolbarCustomToolbarSetting(view, hwToolbarItemContract);
                hwToolbarItemCreateHwToolbarCustomToolbarSetting.setViewId(8388608);
                linkedHashMap.put(Integer.valueOf(hwToolbarItemCreateHwToolbarCustomToolbarSetting.getViewId()), hwToolbarItemCreateHwToolbarCustomToolbarSetting);
                break;
            default:
                Logger.m11003i(TAG, "bindItemView error : " + itemInfo.name());
                break;
        }
    }

    private void bindQuickColorItem(LinkedHashMap<Integer, HwToolbarItem> linkedHashMap, HwToolbarItemContract hwToolbarItemContract, View view) {
        int[] iArr = {C9086R.id.hw_toolbar_quick_color_1, C9086R.id.hw_toolbar_quick_color_2, C9086R.id.hw_toolbar_quick_color_3, C9086R.id.hw_toolbar_quick_color_4, C9086R.id.hw_toolbar_quick_color_5};
        int[] iArr2 = {16385, 16387, 16389, 16393, 16407};
        for (int i = 0; i < 5; i++) {
            HwToolbarQuickColor hwToolbarQuickColor = new HwToolbarQuickColor(view.findViewById(iArr[i]), hwToolbarItemContract);
            hwToolbarQuickColor.setViewId(iArr2[i]);
            linkedHashMap.put(Integer.valueOf(hwToolbarQuickColor.getViewId()), hwToolbarQuickColor);
        }
    }

    private void bindQuickSizeItem(LinkedHashMap<Integer, HwToolbarItem> linkedHashMap, HwToolbarItemContract hwToolbarItemContract, View view) {
        int[] iArr = {C9086R.id.hw_toolbar_quick_size_1, C9086R.id.hw_toolbar_quick_size_2, C9086R.id.hw_toolbar_quick_size_3};
        int[] iArr2 = {32769, 32771, 32773};
        for (int i = 0; i < 3; i++) {
            HwToolbarQuickSize hwToolbarQuickSize = new HwToolbarQuickSize(view.findViewById(iArr[i]), hwToolbarItemContract);
            hwToolbarQuickSize.setViewId(iArr2[i]);
            linkedHashMap.put(Integer.valueOf(hwToolbarQuickSize.getViewId()), hwToolbarQuickSize);
        }
    }

    private LinkedHashMap<Integer, HwToolbarItem> buildItemLayout(HwToolbarItemContract hwToolbarItemContract) {
        LinkedHashMap<Integer, HwToolbarItem> linkedHashMap = new LinkedHashMap<>();
        this.mChainViewIds = new int[this.mItemInfoLinkedMap.size()];
        this.mItemContainer.removeAllViews();
        int i = 0;
        for (Map.Entry<DefaultItemOrder.ItemInfo, AbsItemOrderInfo> entry : this.mItemInfoLinkedMap.entrySet()) {
            View viewInflateView = entry.getValue().inflateView(this.mItemContainer.getContext());
            if (DeviceInfo.isVSTModel()) {
                int dimensionPixelSize = viewInflateView.getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_ripple_size_for_vst);
                viewInflateView.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            }
            this.mItemContainer.addView(viewInflateView);
            int i2 = i + 1;
            this.mChainViewIds[i] = viewInflateView.getId();
            bindItemView(linkedHashMap, hwToolbarItemContract, entry.getKey(), viewInflateView);
            if (this.mHwToolbarPresenter.isTabletLayout()) {
                if (entry.getKey() == DefaultItemOrder.ItemInfo.Divider) {
                    this.firstDividerId = viewInflateView.getId();
                } else if (entry.getKey() == DefaultItemOrder.ItemInfo.Divider2) {
                    this.secondDividerId = viewInflateView.getId();
                }
            }
            i = i2;
        }
        return linkedHashMap;
    }

    private void connectConstraint(boolean z, int i) {
        ViewGroup viewGroup = this.mItemContainer;
        if (viewGroup instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) viewGroup;
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            if (z) {
                connectToHorizon(constraintSet, i, this.mChainViewIds);
            } else {
                connectToVertical(constraintSet, i, this.mChainViewIds);
            }
            constraintSet.applyTo(constraintLayout);
        }
    }

    private void connectToHorizon(ConstraintSet constraintSet, int i, int[] iArr) {
        constraintSet.createHorizontalChainRtl(0, 6, 0, 7, iArr, null, 0);
        for (int i2 : iArr) {
            constraintSet.connect(i2, 3, 0, 3);
            constraintSet.connect(i2, 4, 0, 4);
            constraintSet.setMargin(i2, 4, 0);
            constraintSet.setMargin(i2, 7, i);
        }
        constraintSet.setMargin(iArr[iArr.length - 1], 7, 0);
    }

    private void connectToVertical(ConstraintSet constraintSet, int i, int[] iArr) {
        constraintSet.createVerticalChain(0, 3, 0, 4, iArr, null, 0);
        for (int i2 : iArr) {
            constraintSet.connect(i2, 6, 0, 6);
            constraintSet.connect(i2, 7, 0, 7);
            constraintSet.setMargin(i2, 7, 0);
            constraintSet.setMargin(i2, 4, i);
        }
        constraintSet.setMargin(iArr[iArr.length - 1], 4, 0);
    }

    private void disableItems(DefaultItemOrder.ItemInfo... itemInfoArr) {
        for (DefaultItemOrder.ItemInfo itemInfo : itemInfoArr) {
            this.mItemInfoLinkedMap.remove(itemInfo);
        }
        if (this.mHwToolbarPresenter.isTabletLayout()) {
            return;
        }
        this.mItemInfoLinkedMap.remove(DefaultItemOrder.ItemInfo.QuickColor);
        this.mItemInfoLinkedMap.remove(DefaultItemOrder.ItemInfo.QuickSize);
    }

    private int getItemGapMargin(int i) {
        if (!this.mHwToolbarPresenter.isTabletLayout()) {
            Logger.m11003i(TAG, "getItemGapMargin - Normal size");
            return this.mItemContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_gap_normal);
        }
        boolean zIsHorizontal = isHorizontal();
        if (this.mFloatingContainer.isStateDocking() && zIsHorizontal && i == 2) {
            Logger.m11003i(TAG, "getItemGapMargin - Wide, Landscape");
            return this.mItemContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_gap_extend_wide_side);
        }
        if (this.mFloatingContainer.isStateDocking() && !zIsHorizontal && i == 1) {
            Logger.m11003i(TAG, "getItemGapMargin - Wide, Portrait");
            return this.mItemContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_gap_extend_wide_side);
        }
        if (zIsHorizontal || i != 2) {
            Logger.m11003i(TAG, "getItemGapMargin - Normal size");
            return this.mItemContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_gap_normal);
        }
        Logger.m11003i(TAG, "getItemGapMargin - Small, Landscape");
        return this.mItemContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_gap_small_narrow_side);
    }

    private boolean isHorizontal() {
        boolean z = false;
        if (DeviceInfo.isVSTModel()) {
            return false;
        }
        if (!this.mFloatingContainer.isStateDocking() ? this.mFloatingContainer.hasStoredRotate() : !(this.mFloatingContainer.getDockingType() == 0 || this.mFloatingContainer.getDockingType() == 1)) {
            z = true;
        }
        return !z;
    }

    private boolean isNeededPostFixToolbarItem() {
        return this.mHwToolbarPresenter.isPdfReader() || this.mHwToolbarPresenter.isCoeditNote();
    }

    private boolean loadCustomToolbarItemOrderListForPhone() {
        HwToolbarItemHelper.reflectNewItem();
        String string = SharedPreferencesCompat.getInstance("Settings").getString("settings_toolbar_item_order", "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        this.mItemInfoLinkedMap.clear();
        loadPrefixToolbarItemOrder();
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                DefaultItemOrder.ItemInfo itemInfoFind = DefaultItemOrder.ItemInfo.find(jSONArray.getString(i));
                this.mItemInfoLinkedMap.put(itemInfoFind, itemInfoFind.getInfo());
            }
            loadPostFixToolbarItemOrder();
            Logger.m11003i(TAG, "loadCustomToolbarItemOrderListForPhone# : " + this.mItemInfoLinkedMap);
            return true;
        } catch (NoSuchFieldException | JSONException e) {
            Logger.m11000e(TAG, e.getMessage());
            return false;
        }
    }

    private boolean loadCustomToolbarItemOrderListForTablet() {
        HwToolbarItemHelper.reflectNewItem();
        String string = SharedPreferencesCompat.getInstance("Settings").getString("settings_toolbar_item_order", "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        this.mItemInfoLinkedMap.clear();
        loadPrefixToolbarItemOrder();
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                LinkedHashMap<DefaultItemOrder.ItemInfo, AbsItemOrderInfo> linkedHashMap = this.mItemInfoLinkedMap;
                DefaultItemOrder.ItemInfo itemInfo = DefaultItemOrder.ItemInfo.Divider;
                linkedHashMap.put(itemInfo, itemInfo.getInfo());
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                DefaultItemOrder.ItemInfo itemInfoFind = DefaultItemOrder.ItemInfo.find(jSONArray.getString(i));
                this.mItemInfoLinkedMap.put(itemInfoFind, itemInfoFind.getInfo());
            }
            loadPostFixToolbarItemOrder();
            Logger.m11003i(TAG, "loadCustomToolbarItemOrderListForTablet# : " + this.mItemInfoLinkedMap);
            return true;
        } catch (NoSuchFieldException e) {
            e = e;
            Logger.m11000e(TAG, e.getMessage());
            return false;
        } catch (JSONException e2) {
            e = e2;
            Logger.m11000e(TAG, e.getMessage());
            return false;
        }
    }

    private void loadDefaultToolbarItemOrderForPhone() {
        this.mItemInfoLinkedMap.clear();
        loadPrefixToolbarItemOrder();
        for (DefaultItemOrder.PhoneItem phoneItem : DefaultItemOrder.PhoneItem.values()) {
            this.mItemInfoLinkedMap.put(phoneItem.getItemInfo(), phoneItem.getItemInfo().getInfo());
        }
        loadPostFixToolbarItemOrder();
    }

    private void loadDefaultToolbarItemOrderForTablet() {
        this.mItemInfoLinkedMap.clear();
        for (DefaultItemOrder.ItemInfo itemInfo : DefaultItemOrder.ItemInfo.values()) {
            this.mItemInfoLinkedMap.put(itemInfo, itemInfo.getInfo());
        }
        if (isNeededPostFixToolbarItem()) {
            this.mItemInfoLinkedMap.remove(DefaultItemOrder.ItemInfo.Divider2);
            this.mItemInfoLinkedMap.remove(DefaultItemOrder.ItemInfo.CustomToolbarSetting);
        }
    }

    private void loadPostFixToolbarItemOrder() {
        if (isNeededPostFixToolbarItem()) {
            return;
        }
        for (DefaultItemOrder.PostfixItem postfixItem : DefaultItemOrder.PostfixItem.values()) {
            this.mItemInfoLinkedMap.put(postfixItem.getItemInfo(), postfixItem.getItemInfo().getInfo());
        }
    }

    private void loadPrefixToolbarItemOrder() {
        for (DefaultItemOrder.PrefixItem prefixItem : DefaultItemOrder.PrefixItem.values()) {
            this.mItemInfoLinkedMap.put(prefixItem.getItemInfo(), prefixItem.getItemInfo().getInfo());
        }
    }

    private void loadToolbarItemOrder() {
        if (DeviceInfo.isVSTModel()) {
            loadVSTToolbarItemOrder();
            return;
        }
        if (this.mHwToolbarPresenter.isTabletLayout()) {
            if (loadCustomToolbarItemOrderListForTablet()) {
                return;
            }
            loadDefaultToolbarItemOrderForTablet();
        } else {
            if (loadCustomToolbarItemOrderListForPhone()) {
                return;
            }
            loadDefaultToolbarItemOrderForPhone();
        }
    }

    private void loadVSTToolbarItemOrder() {
        this.mItemInfoLinkedMap.clear();
        for (DefaultItemOrder.VSTItem vSTItem : DefaultItemOrder.VSTItem.values()) {
            this.mItemInfoLinkedMap.put(vSTItem.getItemInfo(), vSTItem.getItemInfo().getInfo());
        }
    }

    private void setRotateLayout(boolean z) {
        Iterator<Map.Entry<DefaultItemOrder.ItemInfo, AbsItemOrderInfo>> it = this.mItemInfoLinkedMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setHorizontal(this.mItemContainer, z);
        }
    }

    private void updateToolbarOutsideOnTablet(boolean z) {
        if (!this.mHwToolbarPresenter.isTabletLayout() || DeviceInfo.isVSTModel()) {
            return;
        }
        View viewFindViewById = this.mFloatingContainer.findViewById(C9086R.id.hw_toolbar_scroll_view);
        int dimensionPixelSize = this.mFloatingContainer.getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_gap_normal);
        int i = 0;
        if (!z) {
            i = dimensionPixelSize;
            dimensionPixelSize = 0;
        }
        viewFindViewById.setPadding(dimensionPixelSize, i, dimensionPixelSize, i);
    }

    public LinkedHashMap<Integer, HwToolbarItem> buildItemViewByOrder(HwToolbarItemContract hwToolbarItemContract, DefaultItemOrder.ItemInfo... itemInfoArr) {
        loadToolbarItemOrder();
        disableItems(itemInfoArr);
        return buildItemLayout(hwToolbarItemContract);
    }

    public LinkedHashMap<Integer, HwToolbarItem> getCandidateItemList(HwToolbarItemContract hwToolbarItemContract) {
        String string = SharedPreferencesCompat.getInstance("Settings").getString("settings_candidate_toolbar_item_order", "");
        LinkedHashMap<Integer, HwToolbarItem> linkedHashMap = new LinkedHashMap<>();
        if (TextUtils.isEmpty(string)) {
            return linkedHashMap;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                DefaultItemOrder.ItemInfo itemInfoFind = DefaultItemOrder.ItemInfo.find(jSONArray.getString(i));
                bindItemView(linkedHashMap, hwToolbarItemContract, itemInfoFind, itemInfoFind.getInfo().inflateView(this.mItemContainer.getContext()));
            }
            Logger.m11003i(TAG, "load candidate btn Map# : " + linkedHashMap);
            return linkedHashMap;
        } catch (NoSuchFieldException e) {
            e = e;
            AbstractC8014b.m7205g(e, new StringBuilder("getCandidateItemList# : "), TAG);
            return linkedHashMap;
        } catch (JSONException e2) {
            e = e2;
            AbstractC8014b.m7205g(e, new StringBuilder("getCandidateItemList# : "), TAG);
            return linkedHashMap;
        }
    }

    public void hideDividerIfNecessary() {
        if (this.mHwToolbarPresenter.isTabletLayout()) {
            int childCount = this.mItemContainer.getChildCount();
            View view = null;
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = this.mItemContainer.getChildAt(i);
                if (childAt.getId() == this.firstDividerId) {
                    z = true;
                    view = childAt;
                } else if (childAt.getId() == this.secondDividerId) {
                    break;
                } else if (z && childAt.getVisibility() == 0) {
                    return;
                }
            }
            if (view != null) {
                Logger.m11003i(TAG, "hideDividerIfNecessary# Hide divider");
                view.setVisibility(8);
            }
        }
    }

    public void updateGapMargin() {
        applyGapMargin(isHorizontal());
    }

    public void updateItemLayout(int i) {
        if (i == 2) {
            updateOrientation();
        } else {
            updateGapMargin();
        }
    }

    public void updateOrientation() {
        boolean zIsHorizontal = isHorizontal();
        setRotateLayout(zIsHorizontal);
        applyGapMargin(zIsHorizontal);
        updateToolbarOutsideOnTablet(zIsHorizontal);
    }
}
