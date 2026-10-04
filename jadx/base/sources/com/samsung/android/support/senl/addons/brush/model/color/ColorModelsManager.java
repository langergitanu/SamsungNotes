package com.samsung.android.support.senl.addons.brush.model.color;

import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.base.model.color.ColorModel;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.AbsBaseModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.brush.model.color.ColorInfoManager;
import com.samsung.android.support.senl.addons.brush.model.color.ColorPaletteModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b4\b\u0016\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001YB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\"\u001a\u00020#2\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\nJ\u0012\u0010*\u001a\u0004\u0018\u00010\u00122\u0006\u0010+\u001a\u00020\u0017H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020#H\u0002J \u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\fH\u0002J\b\u00104\u001a\u00020\u0019H\u0016J\u0010\u00105\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010%H\u0016J\u0010\u00106\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010%H\u0016J\b\u00107\u001a\u00020\u0017H\u0016J\u0010\u00108\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010%H\u0016J\u0016\u00109\u001a\u00020#2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00170%H\u0016J\b\u0010;\u001a\u00020#H\u0016J\b\u0010<\u001a\u00020#H\u0002J\u000e\u0010=\u001a\u00020#2\u0006\u00101\u001a\u00020\nJ\b\u0010>\u001a\u00020#H\u0016J\b\u0010?\u001a\u00020#H\u0016J\b\u0010@\u001a\u00020\u0017H\u0016J\u0010\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u0017H\u0016J\u0006\u0010C\u001a\u00020#J\u0010\u0010D\u001a\u00020#2\u0006\u00101\u001a\u00020\nH\u0002J\u0006\u0010E\u001a\u00020\u0017J\u0010\u0010F\u001a\u00020\u00172\u0006\u00101\u001a\u00020\nH\u0002J\u0010\u0010G\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\nJ\u0010\u0010H\u001a\u00020#2\u0006\u00101\u001a\u00020\nH\u0016J\b\u0010I\u001a\u00020\u0017H\u0016J\u0010\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020\u0017H\u0016J\u0010\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020\u0019H\u0016J\n\u0010N\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010O\u001a\u00020\u0017H\u0016J\u0018\u0010P\u001a\u00020#2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0017H\u0016J\b\u0010Q\u001a\u0004\u0018\u00010\nJ\n\u0010R\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010S\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\nJ\n\u0010T\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010U\u001a\u00020\u0017J\u0018\u0010V\u001a\u00020#2\u0006\u0010W\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0017H\u0002J \u0010V\u001a\u00020#2\u0006\u0010W\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/brush/model/color/IGradationColorModel;", "injector", "Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;", "settingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;)V", "mainColor", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "mMainColorIsSelected", "", "mSelectedColor", "Lcom/samsung/android/support/senl/addons/base/model/color/ColorModel;", "mPickerColor", "mPalettes", "", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel;", "recent", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorRecentModel;", "mColorModelInjector", "mEnabledIndexList", "", "mColorPickerRecent", "", "mActivatedPage", "mSelectedPage", "mColorPickerViewMode", "mSelectableMaxPalette", "mSelectedPalette", "mSettingsModel", "mSelectedListener", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorPaletteModel$OnSelectedListener;", "createModels", "", "tables", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "createRecentModel", "setMainColorModel", "colorModel", "getPalette", "index", "getRecent", "getColorPalletSize", "releaseSelectedPage", "mIsSetByGradation", "findMatchedColor", "color", "position", "isSkip", "getHSVColor", "getSelectedIndices", "getMaxPaletteIndices", "getMaxPaletteSelectable", "getSelectedPalettes", "changeSelectedPalette", XmlErrorCodes.LIST, "updatePalette", "releasePalettes", "addRecentColor", "next", "prev", "getActivatedPage", "setActivatedPage", "id", "close", "setColorSelection", "getSelectedPage", "updatePosition", "changeMainColorModel", "updateSelectPosition", "getColorPickerViewMode", "setColorPickerViewMode", "viewMode", "saveColorPickerRecentColor", "hsvColor", "getColorPickerRecent", "getColorPickerRecentNum", "updateColorAndPosition", "getMainColor", "getSelectedColor", "setColorPickerColor", "getColorPickerColor", "getColorGradationPosition", "setSelectedColor", "hsv", "isSetColor", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ColorModelsManager extends AbsBaseModel implements IGradationColorModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("ColorModelsManager");
    private int mActivatedPage;

    @Nullable
    private IColorModelInjector mColorModelInjector;

    @NotNull
    private List<float[]> mColorPickerRecent;
    private int mColorPickerViewMode;

    @Nullable
    private List<Integer> mEnabledIndexList;
    private boolean mIsSetByGradation;
    private boolean mMainColorIsSelected;

    @Nullable
    private List<ColorPaletteModel> mPalettes;

    @Nullable
    private IExtendedColor mPickerColor;
    private int mSelectableMaxPalette;

    @Nullable
    private ColorModel mSelectedColor;

    @NotNull
    private final ColorPaletteModel.OnSelectedListener mSelectedListener;
    private int mSelectedPage;

    @NotNull
    private final List<Integer> mSelectedPalette;

    @Nullable
    private SettingsModel mSettingsModel;

    @Nullable
    private IExtendedColor mainColor;

    @Nullable
    private ColorRecentModel recent;

    public ColorModelsManager(@NotNull IColorModelInjector injector, @Nullable SettingsModel settingsModel) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        this.mSelectedColor = new ColorModel(MarketingConstants.PopupConst.DEFAULT_COLOR_LINE, -1048576);
        this.mPalettes = new ArrayList();
        this.mEnabledIndexList = new ArrayList();
        this.mColorPickerRecent = new ArrayList();
        this.mActivatedPage = 1;
        this.mSelectedPage = -2;
        this.mColorPickerViewMode = 1;
        this.mSelectedPalette = new ArrayList();
        this.mSelectedListener = new ColorPaletteModel.OnSelectedListener() { // from class: com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager$mSelectedListener$1
            @Override // com.samsung.android.support.senl.addons.brush.model.color.ColorPaletteModel.OnSelectedListener
            public void onSelected(int page, int position, IExtendedColor color) {
                if (this.this$0.mSelectedPage != page) {
                    this.this$0.releaseSelectedPage();
                    this.this$0.mSelectedPage = page;
                }
                if (color != null) {
                    this.this$0.updateColorAndPosition(color, position);
                }
            }
        };
        this.mSettingsModel = settingsModel;
        this.mColorModelInjector = injector;
        createModels(injector.getPaletteDatum());
        createRecentModel(injector);
        ColorInfoManager.Companion companion = ColorInfoManager.INSTANCE;
        this.mColorPickerViewMode = companion.getInstance().loadViewMode();
        List<float[]> listLoadColorPickerRecentColor = companion.getInstance().loadColorPickerRecentColor();
        Intrinsics.checkNotNull(listLoadColorPickerRecentColor, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.FloatArray>");
        this.mColorPickerRecent = TypeIntrinsics.asMutableList(listLoadColorPickerRecentColor);
        this.mSelectableMaxPalette = 4;
    }

    private final void createModels(List<SpenColorPaletteData> tables) {
        if (tables == null) {
            return;
        }
        int size = tables.size();
        for (int i = 0; i < size; i++) {
            SpenColorPaletteData spenColorPaletteData = tables.get(i);
            Intrinsics.checkNotNull(spenColorPaletteData);
            int[] iArr = spenColorPaletteData.values;
            SpenColorPaletteData spenColorPaletteData2 = tables.get(i);
            Intrinsics.checkNotNull(spenColorPaletteData2);
            String[] strArr = spenColorPaletteData2.names;
            SpenColorPaletteData spenColorPaletteData3 = tables.get(i);
            Intrinsics.checkNotNull(spenColorPaletteData3);
            ColorPaletteModel colorPaletteModel = new ColorPaletteModel(i, iArr, strArr, 2, spenColorPaletteData3.index);
            List<ColorPaletteModel> list = this.mPalettes;
            Intrinsics.checkNotNull(list);
            list.add(colorPaletteModel);
            List<Integer> list2 = this.mEnabledIndexList;
            Intrinsics.checkNotNull(list2);
            SpenColorPaletteData spenColorPaletteData4 = tables.get(i);
            Intrinsics.checkNotNull(spenColorPaletteData4);
            list2.add(Integer.valueOf(spenColorPaletteData4.index));
            colorPaletteModel.setSelectionListener(this.mSelectedListener);
        }
        List<Integer> list3 = this.mSelectedPalette;
        List<Integer> list4 = this.mEnabledIndexList;
        Intrinsics.checkNotNull(list4);
        list3.addAll(list4);
    }

    private final void createRecentModel(IColorModelInjector injector) {
        int iLoadRecentColorSize = ColorInfoManager.INSTANCE.getInstance().loadRecentColorSize();
        int[] iArr = new int[iLoadRecentColorSize];
        int[] iArr2 = new int[iLoadRecentColorSize];
        float[][] fArr = new float[iLoadRecentColorSize][];
        for (int i = 0; i < iLoadRecentColorSize; i++) {
            fArr[i] = new float[3];
        }
        String[] strArr = new String[iLoadRecentColorSize];
        ColorInfoManager.INSTANCE.getInstance().loadRecentColor(injector, iLoadRecentColorSize, iArr, iArr2, fArr, strArr);
        ColorRecentModel colorRecentModel = new ColorRecentModel(-1, iArr, fArr, strArr, iArr2, injector);
        this.recent = colorRecentModel;
        colorRecentModel.setSelectionListener(this.mSelectedListener);
    }

    private final boolean findMatchedColor(IExtendedColor color, int position, boolean isSkip) {
        int i = (-1048576) & position;
        if (i == 4194304) {
            return false;
        }
        if (i == 2097152) {
            List<ColorPaletteModel> list = this.mPalettes;
            Intrinsics.checkNotNull(list);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                List<ColorPaletteModel> list2 = this.mPalettes;
                Intrinsics.checkNotNull(list2);
                if (list2.get(i2).selectColorPosition(color, position, isSkip)) {
                    Logger.m7100d(TAG, "find Matched Color in Palette");
                    return true;
                }
            }
        }
        if (i == 1048576) {
            ColorRecentModel colorRecentModel = this.recent;
            Boolean boolValueOf = colorRecentModel != null ? Boolean.valueOf(colorRecentModel.selectColorPosition(color, position, false)) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (boolValueOf.booleanValue()) {
                Logger.m7100d(TAG, "find Matched Color in Recent");
                return true;
            }
        }
        Logger.m7101e(TAG, "not find Matched Color");
        return false;
    }

    private final void releasePalettes() {
        List<ColorPaletteModel> list = this.mPalettes;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<ColorPaletteModel> list2 = this.mPalettes;
                Intrinsics.checkNotNull(list2);
                list2.get(i).setSelectionListener(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseSelectedPage() {
        ColorRecentModel colorRecentModel;
        int i = this.mSelectedPage;
        if (i >= 0) {
            List<ColorPaletteModel> list = this.mPalettes;
            Intrinsics.checkNotNull(list);
            if (i < list.size()) {
                List<ColorPaletteModel> list2 = this.mPalettes;
                Intrinsics.checkNotNull(list2);
                list2.get(this.mSelectedPage).releaseSelectedColor();
            }
        }
        if (this.mSelectedPage != -1 || (colorRecentModel = this.recent) == null) {
            return;
        }
        colorRecentModel.releaseSelectedColor();
    }

    private final void setColorSelection(IExtendedColor color) {
        releaseSelectedPage();
        this.mIsSetByGradation = !findMatchedColor(color, color.getMPosition(), true);
        notifyChanged(201);
    }

    private final void setSelectedColor(float[] hsv, int position) {
        SettingsModel settingsModel = this.mSettingsModel;
        Intrinsics.checkNotNull(settingsModel);
        setSelectedColor(hsv, position, settingsModel.getCurrentMode() != 5);
    }

    private final int updatePosition(IExtendedColor color) {
        List<ColorPaletteModel> list = this.mPalettes;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<ColorPaletteModel> list2 = this.mPalettes;
            Intrinsics.checkNotNull(list2);
            int colorPosition = list2.get(i).getColorPosition(color.getMColor());
            if (colorPosition != 4194304) {
                return colorPosition;
            }
        }
        ColorRecentModel colorRecentModel = this.recent;
        Integer numValueOf = colorRecentModel != null ? Integer.valueOf(colorRecentModel.getColorPosition(color.getMColor())) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    public final void addRecentColor(@NotNull IExtendedColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        ColorRecentModel colorRecentModel = this.recent;
        if (colorRecentModel != null) {
            colorRecentModel.push(color);
        }
    }

    public final void changeMainColorModel(@Nullable IExtendedColor colorModel) {
        this.mainColor = colorModel;
        this.mMainColorIsSelected = false;
        Intrinsics.checkNotNull(colorModel);
        float[] mhsv = colorModel.getMHSV();
        IExtendedColor iExtendedColor = this.mainColor;
        Intrinsics.checkNotNull(iExtendedColor);
        setSelectedColor(mhsv, iExtendedColor.getMPosition());
    }

    public void changeSelectedPalette(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (this.mSelectedColor != null) {
            this.mSelectedPalette.clear();
            this.mSelectedPalette.addAll(list);
        }
    }

    public final void close() {
        this.mainColor = null;
        this.mSelectedColor = null;
        if (this.mSettingsModel != null) {
            this.mSettingsModel = null;
        }
        if (this.mPalettes != null) {
            releasePalettes();
            List<ColorPaletteModel> list = this.mPalettes;
            Intrinsics.checkNotNull(list);
            list.clear();
            this.mPalettes = null;
        }
        ColorRecentModel colorRecentModel = this.recent;
        if (colorRecentModel != null) {
            Intrinsics.checkNotNull(colorRecentModel);
            colorRecentModel.setSelectionListener(null);
            this.recent = null;
        }
        List<Integer> list2 = this.mEnabledIndexList;
        Intrinsics.checkNotNull(list2);
        list2.clear();
        this.mEnabledIndexList = null;
    }

    /* JADX INFO: renamed from: getActivatedPage, reason: from getter */
    public int getMActivatedPage() {
        return this.mActivatedPage;
    }

    public final int getColorGradationPosition() {
        int i = this.mActivatedPage - 1;
        if (i < 0) {
            i = 0;
        }
        List<Integer> list = this.mEnabledIndexList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (i < list.size()) {
                List<Integer> list2 = this.mEnabledIndexList;
                Intrinsics.checkNotNull(list2);
                return (list2.get(i).intValue() << 8) | 4194304;
            }
        }
        return 4194304;
    }

    public int getColorPalletSize() {
        List<ColorPaletteModel> list = this.mPalettes;
        Intrinsics.checkNotNull(list);
        return list.size();
    }

    @Nullable
    public IExtendedColor getColorPickerColor() {
        if (this.mPickerColor == null) {
            this.mPickerColor = this.mainColor;
        }
        return this.mPickerColor;
    }

    @Nullable
    public float[] getColorPickerRecent() {
        float[] fArr = new float[this.mColorPickerRecent.size() * 3];
        int i = 0;
        for (int size = this.mColorPickerRecent.size() - 1; -1 < size; size--) {
            int i2 = i * 3;
            fArr[i2] = this.mColorPickerRecent.get(size)[0];
            fArr[i2 + 1] = this.mColorPickerRecent.get(size)[1];
            fArr[i2 + 2] = this.mColorPickerRecent.get(size)[2];
            i++;
        }
        return fArr;
    }

    public int getColorPickerRecentNum() {
        return this.mColorPickerRecent.size();
    }

    /* JADX INFO: renamed from: getColorPickerViewMode, reason: from getter */
    public int getMColorPickerViewMode() {
        return this.mColorPickerViewMode;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IGradationColorModel
    @NotNull
    public float[] getHSVColor() {
        IExtendedColor iExtendedColor = this.mainColor;
        if (iExtendedColor == null) {
            return new float[3];
        }
        Intrinsics.checkNotNull(iExtendedColor);
        return iExtendedColor.getMHSV();
    }

    @Nullable
    public final IExtendedColor getMainColor() {
        return this.mainColor;
    }

    @Nullable
    public List<Integer> getMaxPaletteIndices() {
        ArrayList arrayList = new ArrayList();
        int length = IColorPaletteModel.INSTANCE.getINFO_INDEX_ORDER_LIST().length;
        for (int i = 0; i < length; i++) {
            arrayList.add(Integer.valueOf(IColorPaletteModel.INSTANCE.getINFO_INDEX_ORDER_LIST()[i]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: getMaxPaletteSelectable, reason: from getter */
    public int getMSelectableMaxPalette() {
        return this.mSelectableMaxPalette;
    }

    @Nullable
    public ColorPaletteModel getPalette(int index) {
        List<ColorPaletteModel> list = this.mPalettes;
        Intrinsics.checkNotNull(list);
        return list.get(index);
    }

    @Nullable
    public ColorRecentModel getRecent() {
        return this.recent;
    }

    @Nullable
    public IExtendedColor getSelectedColor() {
        return this.mSelectedColor;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IGradationColorModel
    @Nullable
    public List<Integer> getSelectedIndices() {
        return this.mEnabledIndexList;
    }

    /* JADX INFO: renamed from: getSelectedPage, reason: from getter */
    public final int getMSelectedPage() {
        return this.mSelectedPage;
    }

    @Nullable
    public List<Integer> getSelectedPalettes() {
        return this.mSelectedPalette;
    }

    public void next() {
        int i = this.mActivatedPage + 1;
        this.mActivatedPage = i;
        List<ColorPaletteModel> list = this.mPalettes;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (i > list.size()) {
                this.mActivatedPage = 0;
            }
        }
    }

    public void prev() {
        int i = this.mActivatedPage - 1;
        this.mActivatedPage = i;
        List<ColorPaletteModel> list = this.mPalettes;
        if (list == null || i >= 0) {
            return;
        }
        Intrinsics.checkNotNull(list);
        this.mActivatedPage = list.size();
    }

    public void saveColorPickerRecentColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        int size = this.mColorPickerRecent.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            float[] fArr = this.mColorPickerRecent.get(i);
            if (Float.compare(fArr[0], hsvColor[0]) == 0 && Float.compare(fArr[1], hsvColor[1]) == 0 && Float.compare(fArr[2], hsvColor[2]) == 0) {
                this.mColorPickerRecent.remove(fArr);
                break;
            }
            i++;
        }
        this.mColorPickerRecent.add(hsvColor);
        if (this.mColorPickerRecent.size() > 6) {
            this.mColorPickerRecent.remove(0);
        }
        ColorInfoManager.INSTANCE.getInstance().saveColorPickerRecentColor(this.mColorPickerRecent);
    }

    public void setActivatedPage(int id) {
        List<Integer> list = this.mEnabledIndexList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list2 = this.mEnabledIndexList;
                Intrinsics.checkNotNull(list2);
                if (list2.get(i).intValue() == id) {
                    this.mActivatedPage = i + 1;
                    return;
                }
            }
            this.mActivatedPage = 0;
        }
    }

    public final void setColorPickerColor(@Nullable IExtendedColor color) {
        this.mPickerColor = color;
        notifyChanged(203);
    }

    public void setColorPickerViewMode(int viewMode) {
        this.mColorPickerViewMode = viewMode;
        ColorInfoManager.INSTANCE.getInstance().saveViewMode(this.mColorPickerViewMode);
    }

    public final void setMainColorModel(@Nullable IExtendedColor colorModel) {
        this.mainColor = colorModel;
        this.mMainColorIsSelected = true;
        if (colorModel == null) {
            return;
        }
        releaseSelectedPage();
        IExtendedColor iExtendedColor = this.mainColor;
        Intrinsics.checkNotNull(iExtendedColor);
        if (iExtendedColor.getMPosition() == -1048576) {
            IExtendedColor iExtendedColor2 = this.mainColor;
            Intrinsics.checkNotNull(iExtendedColor2);
            IExtendedColor iExtendedColor3 = this.mainColor;
            Intrinsics.checkNotNull(iExtendedColor3);
            iExtendedColor2.setPosition(updatePosition(iExtendedColor3));
        }
        IExtendedColor iExtendedColor4 = this.mainColor;
        Intrinsics.checkNotNull(iExtendedColor4);
        IExtendedColor iExtendedColor5 = this.mainColor;
        Intrinsics.checkNotNull(iExtendedColor5);
        boolean zFindMatchedColor = findMatchedColor(iExtendedColor4, iExtendedColor5.getMPosition(), true);
        this.mIsSetByGradation = !zFindMatchedColor;
        if (!zFindMatchedColor) {
            IExtendedColor iExtendedColor6 = this.mainColor;
            Intrinsics.checkNotNull(iExtendedColor6);
            if ((iExtendedColor6.getMPosition() & (-1048576)) != 4194304) {
                IExtendedColor iExtendedColor7 = this.mainColor;
                Intrinsics.checkNotNull(iExtendedColor7);
                iExtendedColor7.setPosition(4194304);
            }
        }
        IExtendedColor iExtendedColor8 = this.mainColor;
        Intrinsics.checkNotNull(iExtendedColor8);
        float[] mhsv = iExtendedColor8.getMHSV();
        IExtendedColor iExtendedColor9 = this.mainColor;
        Intrinsics.checkNotNull(iExtendedColor9);
        setSelectedColor(mhsv, iExtendedColor9.getMPosition());
        notifyChanged(202);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateColorAndPosition(@NotNull IExtendedColor color, int position) {
        Intrinsics.checkNotNullParameter(color, "color");
        IExtendedColor iExtendedColor = this.mainColor;
        if (iExtendedColor != null) {
            Intrinsics.checkNotNull(iExtendedColor);
            if (iExtendedColor.isRgbSame(color)) {
                IExtendedColor iExtendedColor2 = this.mainColor;
                Intrinsics.checkNotNull(iExtendedColor2);
                if (iExtendedColor2.getMPosition() != position) {
                    IExtendedColor iExtendedColor3 = this.mainColor;
                    Intrinsics.checkNotNull(iExtendedColor3);
                    iExtendedColor3.setColor(color);
                    IExtendedColor iExtendedColor4 = this.mainColor;
                    Intrinsics.checkNotNull(iExtendedColor4);
                    iExtendedColor4.setPosition(position);
                    IExtendedColor iExtendedColor5 = this.mainColor;
                    Intrinsics.checkNotNull(iExtendedColor5);
                    float[] mhsv = iExtendedColor5.getMHSV();
                    IExtendedColor iExtendedColor6 = this.mainColor;
                    Intrinsics.checkNotNull(iExtendedColor6);
                    setSelectedColor(mhsv, iExtendedColor6.getMPosition());
                    this.mIsSetByGradation = !findMatchedColor(color, position, false);
                }
            }
        }
        notifyChanged(201);
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IGradationColorModel
    public void updatePalette() {
        ArrayList arrayList = new ArrayList();
        int size = this.mSelectedPalette.size();
        for (int i = 0; i < size; i++) {
            SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
            spenColorPaletteData.index = this.mSelectedPalette.get(i).intValue();
            arrayList.add(spenColorPaletteData);
        }
        ColorInfoManager.INSTANCE.getInstance().saveColorPalettes(this.mSelectedPalette);
        IColorModelInjector iColorModelInjector = this.mColorModelInjector;
        Intrinsics.checkNotNull(iColorModelInjector);
        iColorModelInjector.getColorTables(arrayList);
        releasePalettes();
        List<ColorPaletteModel> list = this.mPalettes;
        Intrinsics.checkNotNull(list);
        list.clear();
        List<Integer> list2 = this.mEnabledIndexList;
        Intrinsics.checkNotNull(list2);
        list2.clear();
        this.mSelectedPalette.clear();
        createModels(arrayList);
        IExtendedColor iExtendedColor = this.mainColor;
        if (iExtendedColor == null || !this.mMainColorIsSelected) {
            return;
        }
        Intrinsics.checkNotNull(iExtendedColor);
        setColorSelection(iExtendedColor);
    }

    public void updateSelectPosition(@NotNull IExtendedColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        if (this.recent == null || (color.getMPosition() & (-1048576)) != 1048576) {
            return;
        }
        ColorRecentModel colorRecentModel = this.recent;
        Intrinsics.checkNotNull(colorRecentModel);
        colorRecentModel.updateSelectPosition(color);
    }

    public void setSelectedColor(@NotNull float[] hsv, int position, boolean isSetColor) {
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        ColorModel colorModel = this.mSelectedColor;
        if (colorModel != null && isSetColor && hsv.length == 3) {
            Intrinsics.checkNotNull(colorModel);
            colorModel.setColor(hsv);
            ColorModel colorModel2 = this.mSelectedColor;
            Intrinsics.checkNotNull(colorModel2);
            colorModel2.setPosition(position);
        }
    }
}
