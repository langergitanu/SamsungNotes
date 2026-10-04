package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.appcompat.widget.SwitchCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.BaseColorPalette;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorPicker;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.CellStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TableStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.TableCellSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.view.TableColorPalette;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p071Q2.ViewOnClickListenerC0220b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0010\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J,\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0004J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0019H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0019H\u0002J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u0014H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\nJ\b\u00100\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u0014H\u0014J\b\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0019H\u0016J\u0010\u00107\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0019H\u0016J\b\u00108\u001a\u00020\u0014H\u0016J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001bJ\u000e\u0010<\u001a\u00020:2\u0006\u0010,\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020:2\u0006\u0010&\u001a\u00020\u0019J\b\u0010>\u001a\u00020:H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/richtext/item/RtMenuTable;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/richtext/item/AbsRtMenuPopupWindow;", "container", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "mColorPicker", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/ColorPicker;", "mTableStyle", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/TableStyle;", "mLineStyleTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTableColorPalette", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/table/view/TableColorPalette;", "inflateView", "context", "Landroid/content/Context;", "initButtons", "", "rtState", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/SpanStates;", "initButton", "id", "", "selected", "", "onClickListener", "Landroid/view/View$OnClickListener;", "initScrollView", "initCloseButton", "initBoldButton", "initItalicButton", "initUnderlineButton", "initStrikethroughButton", "initFontColorButton", "updateFontColor", "color", "initFontSizeButton", "updateFontSizeText", "size", "initAlignButton", "updateAlignImageView", "align", "initTableColorPalette", "initHighlightHeader", "initLineTypeButton", "showPopup", "tableStyle", "hidePopup", "onUpdatePopup", "getCellStyle", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;", "setBgColor", "setBgColorWithHSV", "applyStyle", "getOnOffSwitchForSADetail", "", "switch", "getCharTextAlignForSADetail", "getCharTableBgColorForSADetail", "getLogTag", "Companion", "Cell", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class RtMenuTable extends AbsRtMenuPopupWindow {

    @NotNull
    private static final String TAG;

    @NotNull
    private final ColorPicker mColorPicker;

    @NotNull
    private ArrayList<View> mLineStyleTypes;
    private TableColorPalette mTableColorPalette;

    @NotNull
    private TableStyle mTableStyle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/richtext/item/RtMenuTable$Cell;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/richtext/item/RtMenuTable;", "container", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "mCellStyle", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;", "getMCellStyle", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;", "setMCellStyle", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/common/CellStyle;)V", "showPopup", "", "cellStyle", "inflateView", "context", "Landroid/content/Context;", "getCellStyle", "setBgColor", "color", "", "setBgColorWithHSV", "applyStyle", "getLogTag", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Cell extends RtMenuTable {

        @NotNull
        private static final String TAG;

        @NotNull
        private CellStyle mCellStyle;

        static {
            String strCreateTag = Logger.createTag("RtMenuTable.Cell");
            Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
            TAG = strCreateTag;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cell(@NotNull View container, @NotNull View view) {
            super(container, view);
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(view, "view");
            this.mCellStyle = new CellStyle();
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable
        public void applyStyle() {
            HashMap map = new HashMap();
            map.put("Color", getCharTableBgColorForSADetail(this.mCellStyle.getCellBgColor()));
            map.put("Font size", String.valueOf(this.mCellStyle.getFontSize()));
            map.put("Bold", getOnOffSwitchForSADetail(this.mCellStyle.getIsBold()));
            map.put("Italic", getOnOffSwitchForSADetail(this.mCellStyle.getIsItalic()));
            map.put("Underline", getOnOffSwitchForSADetail(this.mCellStyle.getIsUnderline()));
            map.put("Strikethrough", getOnOffSwitchForSADetail(this.mCellStyle.getIsStrikethrough()));
            map.put("Font color", Integer.toHexString(this.mCellStyle.getFontColor()));
            map.put("Font align", getCharTextAlignForSADetail(this.mCellStyle.getAlign()));
            ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_CELL_STYLE_DIALOG, map);
            this.mPresenter.getRtTableAndCellStylePresenter().applyCellStyle(this.mCellStyle);
            hidePopup();
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable
        @NotNull
        /* JADX INFO: renamed from: getCellStyle, reason: from getter */
        public CellStyle getMCellStyle() {
            return this.mCellStyle;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
        @NotNull
        public String getLogTag() {
            return TAG;
        }

        @NotNull
        public final CellStyle getMCellStyle() {
            return this.mCellStyle;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
        @NotNull
        public View inflateView(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(C9086R.layout.comp_rt_popup_table_style_setting, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(C9086R.id.dialog_title)).setText(C9086R.string.composer_table_cell_style_dialog_title);
            viewInflate.findViewById(C9086R.id.table_design_setting_layout).setVisibility(8);
            if (this.mPresenter.getRtTableAndCellStylePresenter().isSelectedHeaderCells()) {
                viewInflate.findViewById(C9086R.id.cell_background_setting_layout).setVisibility(8);
            }
            Intrinsics.checkNotNull(viewInflate);
            return viewInflate;
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable
        public void setBgColor(int color) {
            this.mCellStyle.setCellBgColor(color);
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable
        public void setBgColorWithHSV(int color) {
            this.mCellStyle.setCellBgColorWithHSV(color);
            this.mCellStyle.setUpdatedData(128);
        }

        public final void setMCellStyle(@NotNull CellStyle cellStyle) {
            Intrinsics.checkNotNullParameter(cellStyle, "<set-?>");
            this.mCellStyle = cellStyle;
        }

        public final void showPopup(@NotNull CellStyle cellStyle) {
            Intrinsics.checkNotNullParameter(cellStyle, "cellStyle");
            this.mCellStyle = new CellStyle(cellStyle);
            showPopup();
        }
    }

    static {
        String strCreateTag = Logger.createTag("RtMenuTable");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RtMenuTable(@NotNull View container, @NotNull View view) {
        super(container, view);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(view, "view");
        this.mTableStyle = new TableStyle();
        this.mLineStyleTypes = new ArrayList<>();
        this.mColorPicker = new ColorPicker(container.getContext(), container, new ColorPicker.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable.1
            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.Contract
            public void onColorChangedByPicker(int color) {
                AbstractC0000a.m3D(color, "onColorChangedByPicker# ", RtMenuTable.this.getLogTag());
                TableColorPalette tableColorPalette = RtMenuTable.this.mTableColorPalette;
                if (tableColorPalette == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTableColorPalette");
                    tableColorPalette = null;
                }
                tableColorPalette.onColorChangedByPicker(color);
                RtMenuTable.this.setBgColor(color);
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.Contract
            public void release() {
            }
        });
    }

    private final void initAlignButton(View container) {
        initButton(container, C9086R.id.richtext_align, false, new ViewOnClickListenerC10835a(container, this, 0));
        updateAlignImageView(getMCellStyle().getAlign());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAlignButton$lambda$11(View view, RtMenuTable rtMenuTable, View view2) {
        View viewFindViewById = view.findViewById(C9086R.id.richtext_align);
        viewFindViewById.setTag(Integer.valueOf(rtMenuTable.getMCellStyle().getAlign()));
        rtMenuTable.mPresenter.showAlignSetting(viewFindViewById, new C10837c(rtMenuTable, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAlignButton$lambda$11$lambda$10(RtMenuTable rtMenuTable, int i) {
        rtMenuTable.getMCellStyle().setAlign(i);
        rtMenuTable.getMCellStyle().setUpdatedData(16);
        rtMenuTable.updateAlignImageView(i);
    }

    private final void initBoldButton(View container) {
        initButton(container, C9086R.id.comp_table_btn_bold, getMCellStyle().getIsBold(), new ViewOnClickListenerC10835a(this, container, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBoldButton$lambda$2(RtMenuTable rtMenuTable, View view, View view2) {
        rtMenuTable.getMCellStyle().setBold(!rtMenuTable.getMCellStyle().getIsBold());
        rtMenuTable.getMCellStyle().setUpdatedData(1);
        view.findViewById(C9086R.id.comp_table_btn_bold).setSelected(rtMenuTable.getMCellStyle().getIsBold());
    }

    private final void initCloseButton(View container) {
        final int i = 0;
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ RtMenuTable f7261b;

            {
                this.f7261b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        this.f7261b.hidePopup();
                        break;
                    default:
                        this.f7261b.applyStyle();
                        break;
                }
            }
        };
        View viewFindViewById = container.findViewById(C9086R.id.close_btn);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
        viewFindViewById.setOnClickListener(onClickListener);
        container.findViewById(C9086R.id.dialog_cancel).setOnClickListener(onClickListener);
        final int i2 = 1;
        container.findViewById(C9086R.id.dialog_done).setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ RtMenuTable f7261b;

            {
                this.f7261b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        this.f7261b.hidePopup();
                        break;
                    default:
                        this.f7261b.applyStyle();
                        break;
                }
            }
        });
    }

    private final void initFontColorButton(View container) {
        initButton(container, C9086R.id.comp_table_btn_text_color, getMCellStyle().getIsStrikethrough(), new ViewOnClickListenerC10835a(this, container, 4));
        updateFontColor(getMCellStyle().getFontColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFontColorButton$lambda$7(RtMenuTable rtMenuTable, View view, View view2) {
        rtMenuTable.mPresenter.showFontColorSetting(view.findViewById(C9086R.id.comp_table_btn_text_color), new C10837c(rtMenuTable, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFontColorButton$lambda$7$lambda$6(RtMenuTable rtMenuTable, int i) {
        rtMenuTable.getMCellStyle().setFontColorWithHSV(i);
        rtMenuTable.getMCellStyle().setUpdatedData(64);
        rtMenuTable.updateFontColor(i);
    }

    private final void initFontSizeButton(View container) {
        initButton(container, C9086R.id.richtext_font_size, false, new ViewOnClickListenerC10835a(container, this, 1));
        updateFontSizeText(getMCellStyle().getFontSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFontSizeButton$lambda$9(View view, RtMenuTable rtMenuTable, View view2) {
        View viewFindViewById = view.findViewById(C9086R.id.richtext_font_size);
        viewFindViewById.setTag(Integer.valueOf(rtMenuTable.getMCellStyle().getFontSize()));
        rtMenuTable.mPresenter.showFontSizeSetting(viewFindViewById, new C10837c(rtMenuTable, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFontSizeButton$lambda$9$lambda$8(RtMenuTable rtMenuTable, int i) {
        rtMenuTable.getMCellStyle().setFontSize(i);
        rtMenuTable.getMCellStyle().setUpdatedData(32);
        rtMenuTable.updateFontSizeText(i);
    }

    private final void initHighlightHeader(View container) {
        View viewFindViewById = container.findViewById(C9086R.id.comp_table_setting_header_row_switch_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final SwitchCompat switchCompat = (SwitchCompat) viewFindViewById;
        switchCompat.setChecked(this.mTableStyle.getIsHighlightHeaderRow());
        final int i = 0;
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ RtMenuTable f7265b;

            {
                this.f7265b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                switch (i) {
                    case 0:
                        RtMenuTable.initHighlightHeader$lambda$12(this.f7265b, compoundButton, z);
                        break;
                    default:
                        RtMenuTable.initHighlightHeader$lambda$14(this.f7265b, compoundButton, z);
                        break;
                }
            }
        });
        final int i2 = 0;
        container.findViewById(C9086R.id.comp_table_setting_header_row_layout).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        RtMenuTable.initHighlightHeader$lambda$13(switchCompat, view);
                        break;
                    default:
                        RtMenuTable.initHighlightHeader$lambda$15(switchCompat, view);
                        break;
                }
            }
        });
        View viewFindViewById2 = container.findViewById(C9086R.id.comp_table_setting_header_column_switch_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final SwitchCompat switchCompat2 = (SwitchCompat) viewFindViewById2;
        switchCompat2.setChecked(this.mTableStyle.getIsHighlightHeaderColumn());
        final int i4 = 1;
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ RtMenuTable f7265b;

            {
                this.f7265b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                switch (i4) {
                    case 0:
                        RtMenuTable.initHighlightHeader$lambda$12(this.f7265b, compoundButton, z);
                        break;
                    default:
                        RtMenuTable.initHighlightHeader$lambda$14(this.f7265b, compoundButton, z);
                        break;
                }
            }
        });
        container.findViewById(C9086R.id.comp_table_setting_header_column_layout).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        RtMenuTable.initHighlightHeader$lambda$13(switchCompat2, view);
                        break;
                    default:
                        RtMenuTable.initHighlightHeader$lambda$15(switchCompat2, view);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHighlightHeader$lambda$12(RtMenuTable rtMenuTable, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        rtMenuTable.mTableStyle.setHighlightHeaderRow(z);
        rtMenuTable.mTableStyle.setUpdatedData(256);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHighlightHeader$lambda$13(SwitchCompat switchCompat, View view) {
        switchCompat.setChecked(!switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHighlightHeader$lambda$14(RtMenuTable rtMenuTable, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        rtMenuTable.mTableStyle.setHighlightHeaderColumn(z);
        rtMenuTable.mTableStyle.setUpdatedData(512);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHighlightHeader$lambda$15(SwitchCompat switchCompat, View view) {
        switchCompat.setChecked(!switchCompat.isChecked());
    }

    private final void initItalicButton(View container) {
        initButton(container, C9086R.id.comp_table_btn_italic, getMCellStyle().getIsItalic(), new ViewOnClickListenerC10835a(this, container, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItalicButton$lambda$3(RtMenuTable rtMenuTable, View view, View view2) {
        rtMenuTable.getMCellStyle().setItalic(!rtMenuTable.getMCellStyle().getIsItalic());
        rtMenuTable.getMCellStyle().setUpdatedData(2);
        view.findViewById(C9086R.id.comp_table_btn_italic).setSelected(rtMenuTable.getMCellStyle().getIsItalic());
    }

    private final void initLineTypeButton(View container) {
        int[] iArr = {C9086R.id.comp_table_styles_1, C9086R.id.comp_table_styles_2, C9086R.id.comp_table_styles_3, C9086R.id.comp_table_styles_4, C9086R.id.comp_table_styles_5};
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            this.mLineStyleTypes.add(container.findViewById(i2));
            int i4 = i2 - C9086R.id.comp_table_styles_1;
            initButton(container, i2, this.mTableStyle.getTableLineType() == i4, new ViewOnClickListenerC0220b(this, i4, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLineTypeButton$lambda$16(RtMenuTable rtMenuTable, int i, View view) {
        Iterator<View> it = rtMenuTable.mLineStyleTypes.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            View next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.setSelected(false);
        }
        view.setSelected(true);
        rtMenuTable.mTableStyle.setTableLineType(i);
        rtMenuTable.mTableStyle.setUpdatedData(1024);
    }

    private final void initScrollView(View container) {
        View viewFindViewById = container.findViewById(C9086R.id.table_style_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewCompat.INSTANCE.getInstance().setShadowAlpha(viewFindViewById, 0.5f);
    }

    private final void initStrikethroughButton(View container) {
        initButton(container, C9086R.id.comp_table_btn_strikethrough, getMCellStyle().getIsStrikethrough(), new ViewOnClickListenerC10835a(this, container, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initStrikethroughButton$lambda$5(RtMenuTable rtMenuTable, View view, View view2) {
        rtMenuTable.getMCellStyle().setStrikethrough(!rtMenuTable.getMCellStyle().getIsStrikethrough());
        rtMenuTable.getMCellStyle().setUpdatedData(8);
        view.findViewById(C9086R.id.comp_table_btn_strikethrough).setSelected(rtMenuTable.getMCellStyle().getIsStrikethrough());
    }

    private final void initTableColorPalette() {
        Context context = this.mView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TableColorPalette tableColorPalette = new TableColorPalette(context, new BaseColorPalette.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable.initTableColorPalette.1
            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public int getBackgroundColor() {
                return RtMenuTable.this.mPresenter.getBackgroundColor();
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public boolean isDarkTheme() {
                return RtMenuTable.this.mPresenter.isComposerViewDarkTheme();
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public void notifyChangedColor(int color) {
                RtMenuTable.this.setBgColorWithHSV(color);
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.BaseColorPalette.Contract
            public void notifyChangedPaletteId(int paletteId) {
                AbstractC0000a.m3D(paletteId, "notifyChangedPaletteId# ", RtMenuTable.this.getLogTag());
            }
        });
        this.mTableColorPalette = tableColorPalette;
        tableColorPalette.initPalette(getMCellStyle().getIsCellBgColorEnabled(), getMCellStyle().getCellBgColor());
        TableColorPalette tableColorPalette2 = this.mTableColorPalette;
        TableColorPalette tableColorPalette3 = null;
        if (tableColorPalette2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTableColorPalette");
            tableColorPalette2 = null;
        }
        View viewFindViewById = this.mDialogContainer.findViewById(C9086R.id.preset_color_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        tableColorPalette2.initPresetLayout((RelativeLayout) viewFindViewById);
        TableColorPalette tableColorPalette4 = this.mTableColorPalette;
        if (tableColorPalette4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTableColorPalette");
        } else {
            tableColorPalette3 = tableColorPalette4;
        }
        tableColorPalette3.setPaletteActionListener(new BaseColorPalette.OnPaletteActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable.initTableColorPalette.2
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onButtonClick(int pageIndex, int childAt, boolean isSelected) {
                if (childAt == 7) {
                    if (RtMenuTable.this.mColorPicker.isShowingColorPicker()) {
                        return;
                    }
                    ColorPicker colorPicker = RtMenuTable.this.mColorPicker;
                    RtMenuTable rtMenuTable = RtMenuTable.this;
                    colorPicker.showColorPickerPopup(rtMenuTable.mDialogContainer, rtMenuTable.getMCellStyle().getFontColor(), RtMenuTable.this.mPresenter.getBackgroundColor(), RtMenuTable.this.mPresenter.getColorTheme(), false);
                    return;
                }
                TableColorPalette tableColorPalette5 = RtMenuTable.this.mTableColorPalette;
                if (tableColorPalette5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTableColorPalette");
                    tableColorPalette5 = null;
                }
                tableColorPalette5.setSelectedColor(childAt);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onPaletteSwipe(int pageIndex, int direction) {
            }
        });
    }

    private final void initUnderlineButton(View container) {
        initButton(container, C9086R.id.comp_table_btn_underline, getMCellStyle().getIsUnderline(), new ViewOnClickListenerC10835a(this, container, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUnderlineButton$lambda$4(RtMenuTable rtMenuTable, View view, View view2) {
        rtMenuTable.getMCellStyle().setUnderline(!rtMenuTable.getMCellStyle().getIsUnderline());
        rtMenuTable.getMCellStyle().setUpdatedData(4);
        view.findViewById(C9086R.id.comp_table_btn_underline).setSelected(rtMenuTable.getMCellStyle().getIsUnderline());
    }

    private final void updateAlignImageView(int align) {
        View viewFindViewById = this.mDialogContainer.findViewById(C9086R.id.richtext_align_spinner_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        if (align == -1) {
            imageView.setVisibility(4);
            return;
        }
        if (align == 0) {
            imageView.setImageResource(C9086R.drawable.comp_rt_toolbar_ic_align_left);
            imageView.setVisibility(0);
        } else if (align == 1) {
            imageView.setImageResource(C9086R.drawable.comp_rt_toolbar_ic_align_right);
            imageView.setVisibility(0);
        } else if (align != 2) {
            imageView.setVisibility(4);
        } else {
            imageView.setImageResource(C9086R.drawable.comp_rt_toolbar_ic_align_center);
            imageView.setVisibility(0);
        }
    }

    private final void updateFontColor(int color) {
        View viewFindViewById = this.mDialogContainer.findViewById(C9086R.id.richtext_textColor);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((ImageView) viewFindViewById).setImageTintList(ColorStateList.valueOf(getColorTheme(color)));
    }

    private final void updateFontSizeText(int size) {
        View viewFindViewById = this.mDialogContainer.findViewById(C9086R.id.richtext_font_size_spinner_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        textView.setVisibility(size <= -1 ? 4 : 0);
        textView.setText(String.valueOf(size));
    }

    public void applyStyle() {
        HashMap map = new HashMap();
        map.put("Color", getCharTableBgColorForSADetail(this.mTableStyle.getTableBgColor()));
        map.put("Font size", String.valueOf(this.mTableStyle.getCellStyle().getFontSize()));
        map.put("Bold", getOnOffSwitchForSADetail(this.mTableStyle.getCellStyle().getIsBold()));
        map.put("Italic", getOnOffSwitchForSADetail(this.mTableStyle.getCellStyle().getIsItalic()));
        map.put("Underline", getOnOffSwitchForSADetail(this.mTableStyle.getCellStyle().getIsUnderline()));
        map.put("Strikethrough", getOnOffSwitchForSADetail(this.mTableStyle.getCellStyle().getIsStrikethrough()));
        map.put("Font color", Integer.toHexString(this.mTableStyle.getCellStyle().getFontColor()));
        map.put("Font align", getCharTextAlignForSADetail(this.mTableStyle.getCellStyle().getAlign()));
        map.put("Highlight a", getOnOffSwitchForSADetail(this.mTableStyle.getIsHighlightHeaderRow()));
        map.put("Highlight b", getOnOffSwitchForSADetail(this.mTableStyle.getIsHighlightHeaderColumn()));
        map.put("Border style", String.valueOf((char) (this.mTableStyle.getTableLineType() + 97)));
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_TABLE_STYLE_DIALOG, map);
        this.mPresenter.getRtTableAndCellStylePresenter().applyTableStyle(this.mTableStyle);
        this.mTableStyle.save();
        hidePopup();
        this.mPresenter.getRtTableAndCellStylePresenter().updateTable();
    }

    @NotNull
    /* JADX INFO: renamed from: getCellStyle */
    public CellStyle getMCellStyle() {
        return this.mTableStyle.getCellStyle();
    }

    @NotNull
    public final String getCharTableBgColorForSADetail(int color) {
        int[] intArray = this.mView.getContext().getResources().getIntArray(C9086R.array.table_color_set);
        if (intArray != null) {
            int iIndexOf = ArraysKt.indexOf(intArray, color);
            return iIndexOf != -1 ? String.valueOf((char) (iIndexOf + 97)) : "";
        }
        String hexString = Integer.toHexString(color);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        return hexString;
    }

    @NotNull
    public final String getCharTextAlignForSADetail(int align) {
        return align != 0 ? align != 1 ? "b" : "c" : "a";
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    @NotNull
    public String getLogTag() {
        return TAG;
    }

    @NotNull
    public final String getOnOffSwitchForSADetail(boolean z) {
        return z ? "1" : "0";
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public boolean hidePopup() {
        return super.hidePopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    @NotNull
    public View inflateView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C9086R.layout.comp_rt_popup_table_style_setting, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    public final void initButton(@NotNull View container, @IdRes int id, boolean selected, @Nullable View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewById = container.findViewById(id);
        viewFindViewById.setOnClickListener(onClickListener);
        viewFindViewById.setSelected(selected);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow
    public void initButtons(@NotNull View container, @NotNull SpanStates rtState) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(rtState, "rtState");
        initScrollView(container);
        initCloseButton(container);
        initBoldButton(container);
        initItalicButton(container);
        initUnderlineButton(container);
        initStrikethroughButton(container);
        initFontColorButton(container);
        initFontSizeButton(container);
        initAlignButton(container);
        initTableColorPalette();
        initHighlightHeader(container);
        initLineTypeButton(container);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void onUpdatePopup() {
        if (this.mPopupWindow != null && isPopupShowing()) {
            RectF selectedCellRect = this.mPresenter.getRtTableAndCellStylePresenter().getSelectedCellRect(this.mDialogContainer.getMeasuredWidth());
            if (selectedCellRect == null) {
                hidePopup();
            } else {
                this.mPopupWindow.update((int) selectedCellRect.left, (int) selectedCellRect.top, -1, -1);
            }
        }
        if (this.mColorPicker.isShowingColorPicker()) {
            this.mColorPicker.setOrientationMode(this.mView.getContext().getResources().getConfiguration().orientation);
        }
    }

    public void setBgColor(int color) {
        this.mTableStyle.setTableBgColor(color);
    }

    public void setBgColorWithHSV(int color) {
        this.mTableStyle.setTableBgColorWithHSV(color);
        this.mTableStyle.setUpdatedData(2048);
        if (this.mTableStyle.getIsHighlightHeaderRow()) {
            this.mTableStyle.setUpdatedData(256);
        }
        if (this.mTableStyle.getIsHighlightHeaderColumn()) {
            this.mTableStyle.setUpdatedData(512);
        }
    }

    public final void showPopup(@NotNull TableStyle tableStyle) {
        Intrinsics.checkNotNullParameter(tableStyle, "tableStyle");
        this.mTableStyle = new TableStyle(tableStyle);
        showPopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopupWindow, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.AbsRtMenuPopup
    public void showPopup() {
        initPopupWindow(this.mView.getContext());
        this.mPopupWindow.setHeight(-2);
        OptionMenuPopupWindowHelper.setDefaultState(this.mPopupWindow, this.mView.getContext());
        RectF selectedCellRect = this.mPresenter.getRtTableAndCellStylePresenter().getSelectedCellRect(this.mDialogContainer.getMeasuredWidth());
        if (selectedCellRect == null) {
            Logger.m10999d(getLogTag(), "show# table rect is null");
            this.mPopupWindow.showAtLocation(this.mContainer, 17, 0, 0);
        } else {
            this.mPopupWindow.showAtLocation(this.mContainer, 0, (int) selectedCellRect.left, (int) selectedCellRect.top);
            this.mPopupWindow.update();
            this.mPopupWindow.getContentView().requestFocus();
        }
    }
}
