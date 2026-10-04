package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultItemOrder {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AiAssist extends AbsItemOrderInfo {
        public AiAssist() {
            super(C9086R.layout.comp_btn_ai_menu);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Align extends AbsItemOrderInfo {
        public Align() {
            super(C9086R.layout.comp_btn_align_recognition);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Assistance extends AbsItemOrderInfo {
        public Assistance() {
            super(C9086R.layout.comp_btn_assistance);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CleanUpAndConvertText extends AbsItemOrderInfo {
        public CleanUpAndConvertText() {
            super(C9086R.layout.comp_btn_ai_menu_hw);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ConvertText extends AbsItemOrderInfo {
        public ConvertText() {
            super(C9086R.layout.comp_btn_convert_text);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CustomToolbarSetting extends AbsItemOrderInfo {
        public CustomToolbarSetting() {
            super(C9086R.layout.comp_btn_custom_toolbar_setting);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DirectWrite extends AbsItemOrderInfo {
        public DirectWrite() {
            super(C9086R.layout.comp_btn_direct_write);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Divider extends AbsItemOrderInfo {
        public Divider() {
            super(C9086R.layout.comp_toolbar_divider);
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.AbsItemOrderInfo
        public void setHorizontal(View view, boolean z) {
            super.setHorizontal(view, z);
            View viewFindViewById = view.findViewById(getViewId());
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            int dimension = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.comp_toolbar_divider_width);
            int dimension2 = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.comp_toolbar_divider_height);
            if (z) {
                layoutParams.width = dimension;
                layoutParams.height = dimension2;
            } else {
                layoutParams.width = dimension2;
                layoutParams.height = dimension;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Divider2 extends AbsItemOrderInfo {
        public Divider2() {
            super(C9086R.layout.comp_toolbar_divider_2);
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.AbsItemOrderInfo
        public void setHorizontal(View view, boolean z) {
            super.setHorizontal(view, z);
            View viewFindViewById = view.findViewById(getViewId());
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            int dimension = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.comp_toolbar_divider_width);
            int dimension2 = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.comp_toolbar_divider_height);
            if (z) {
                layoutParams.width = dimension;
                layoutParams.height = dimension2;
            } else {
                layoutParams.width = dimension2;
                layoutParams.height = dimension;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EasyWritePad extends AbsItemOrderInfo {
        public EasyWritePad() {
            super(C9086R.layout.comp_btn_easy_pad);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Eraser extends AbsItemOrderInfo {
        public Eraser() {
            super(C9086R.layout.comp_btn_eraser);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Highlighter extends AbsItemOrderInfo {
        public Highlighter() {
            super(C9086R.layout.comp_btn_highlighter);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ItemInfo {
        MoveOnlyMode(new MoveOnlyMode()),
        TextMode(new TextMode()),
        Pen(new Pen()),
        Highlighter(new Highlighter()),
        Eraser(new Eraser()),
        Selection(new Selection()),
        AiAssist(new AiAssist()),
        Divider(new Divider()),
        QuickColor(new QuickColor()),
        QuickSize(new QuickSize()),
        Undo(new Undo()),
        Redo(new Redo()),
        CleanUpAndConvertText(new CleanUpAndConvertText()),
        Assistance(new Assistance()),
        DirectWrite(new DirectWrite()),
        Align(new Align()),
        ConvertText(new ConvertText()),
        LaserPen(new LaserPen()),
        Style(new Style()),
        SmartPen(new SmartPen()),
        EasyWritePad(new EasyWritePad()),
        Shape(new Shape()),
        LockCanvas(new LockCanvas()),
        Divider2(new Divider2()),
        CustomToolbarSetting(new CustomToolbarSetting());

        AbsItemOrderInfo mOrderInfo;

        ItemInfo(AbsItemOrderInfo absItemOrderInfo) {
            this.mOrderInfo = absItemOrderInfo;
        }

        public static ItemInfo find(@NonNull String str) throws NoSuchFieldException {
            for (ItemInfo itemInfo : values()) {
                if (str.equals(itemInfo.name())) {
                    return itemInfo;
                }
            }
            throw new NoSuchFieldException(AbstractC0541b.m772n("not found ItemInfo ", str));
        }

        public AbsItemOrderInfo getInfo() {
            return this.mOrderInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LaserPen extends AbsItemOrderInfo {
        public LaserPen() {
            super(C9086R.layout.comp_btn_laser_pen);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LockCanvas extends AbsItemOrderInfo {
        public LockCanvas() {
            super(C9086R.layout.comp_btn_lock_canvas);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MoveOnlyMode extends AbsItemOrderInfo {
        public MoveOnlyMode() {
            super(C9086R.layout.comp_btn_move_only_mode);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Pen extends AbsItemOrderInfo {
        public Pen() {
            super(C9086R.layout.comp_btn_pen);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PhoneItem {
        Undo(ItemInfo.Undo),
        Redo(ItemInfo.Redo),
        CleanUpAndConvertText(ItemInfo.CleanUpAndConvertText),
        Assistance(ItemInfo.Assistance),
        DirectWrite(ItemInfo.DirectWrite),
        Align(ItemInfo.Align),
        ConvertText(ItemInfo.ConvertText),
        LaserPen(ItemInfo.LaserPen),
        Style(ItemInfo.Style),
        SmartPen(ItemInfo.SmartPen),
        EasyWritePad(ItemInfo.EasyWritePad),
        Shape(ItemInfo.Shape),
        LockCanvas(ItemInfo.LockCanvas);

        ItemInfo mItemInfo;

        PhoneItem(ItemInfo itemInfo) {
            this.mItemInfo = itemInfo;
        }

        public ItemInfo getItemInfo() {
            return this.mItemInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PostfixItem {
        Divider2(ItemInfo.Divider2),
        CustomToolbarSetting(ItemInfo.CustomToolbarSetting);

        ItemInfo mItemInfo;

        PostfixItem(ItemInfo itemInfo) {
            this.mItemInfo = itemInfo;
        }

        public ItemInfo getItemInfo() {
            return this.mItemInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PrefixItem {
        MoveOnlyMode(ItemInfo.MoveOnlyMode),
        TextMode(ItemInfo.TextMode),
        Pen(ItemInfo.Pen),
        Highlighter(ItemInfo.Highlighter),
        Eraser(ItemInfo.Eraser),
        Selection(ItemInfo.Selection),
        AiAssist(ItemInfo.AiAssist);

        ItemInfo mItemInfo;

        PrefixItem(ItemInfo itemInfo) {
            this.mItemInfo = itemInfo;
        }

        public ItemInfo getItemInfo() {
            return this.mItemInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class QuickColor extends RotationItemOrderInfo {
        public QuickColor() {
            super(C9086R.layout.comp_btn_quick_color);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class QuickSize extends RotationItemOrderInfo {
        public QuickSize() {
            super(C9086R.layout.comp_btn_quick_size);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Redo extends AbsItemOrderInfo {
        public Redo() {
            super(C9086R.layout.comp_btn_redo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RotationItemOrderInfo extends AbsItemOrderInfo {
        public RotationItemOrderInfo(@NonNull int i) {
            super(i);
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.AbsItemOrderInfo
        public void setHorizontal(View view, boolean z) {
            super.setHorizontal(view, z);
            View viewFindViewById = view.findViewById(getViewId());
            if (viewFindViewById instanceof LinearLayout) {
                ((LinearLayout) viewFindViewById).setOrientation(!z ? 1 : 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Selection extends AbsItemOrderInfo {
        public Selection() {
            super(C9086R.layout.comp_btn_selection_type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Shape extends AbsItemOrderInfo {
        public Shape() {
            super(C9086R.layout.comp_btn_shape_recognition);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SmartPen extends AbsItemOrderInfo {
        public SmartPen() {
            super(C9086R.layout.comp_btn_smart_pen);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Style extends AbsItemOrderInfo {
        public Style() {
            super(C9086R.layout.comp_btn_style);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TabletItem {
        QuickColor(ItemInfo.QuickColor),
        QuickSize(ItemInfo.QuickSize),
        Undo(ItemInfo.Undo),
        Redo(ItemInfo.Redo),
        CleanUpAndConvertText(ItemInfo.CleanUpAndConvertText),
        Assistance(ItemInfo.Assistance),
        DirectWrite(ItemInfo.DirectWrite),
        Align(ItemInfo.Align),
        ConvertText(ItemInfo.ConvertText),
        LaserPen(ItemInfo.LaserPen),
        Style(ItemInfo.Style),
        SmartPen(ItemInfo.SmartPen),
        EasyWritePad(ItemInfo.EasyWritePad),
        Shape(ItemInfo.Shape),
        LockCanvas(ItemInfo.LockCanvas);

        ItemInfo mItemInfo;

        TabletItem(ItemInfo itemInfo) {
            this.mItemInfo = itemInfo;
        }

        public static TabletItem find(@NonNull String str) {
            for (TabletItem tabletItem : values()) {
                if (str.equals(tabletItem.name())) {
                    return tabletItem;
                }
            }
            return null;
        }

        public ItemInfo getItemInfo() {
            return this.mItemInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TextMode extends AbsItemOrderInfo {
        public TextMode() {
            super(C9086R.layout.comp_btn_text_mode);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Undo extends AbsItemOrderInfo {
        public Undo() {
            super(C9086R.layout.comp_btn_undo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum VSTItem {
        AiAssist(ItemInfo.AiAssist),
        Pen(ItemInfo.Pen),
        Highlighter(ItemInfo.Highlighter),
        Eraser(ItemInfo.Eraser),
        QuickColor(ItemInfo.QuickColor),
        QuickSize(ItemInfo.QuickSize),
        Undo(ItemInfo.Undo),
        Redo(ItemInfo.Redo),
        MoveOnlyMode(ItemInfo.MoveOnlyMode);

        ItemInfo mItemInfo;

        VSTItem(ItemInfo itemInfo) {
            this.mItemInfo = itemInfo;
        }

        public ItemInfo getItemInfo() {
            return this.mItemInfo;
        }
    }
}
