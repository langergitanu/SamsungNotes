package p071Q2;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder.OldNotifyHolder;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.UnsupportedTranslationLanguageAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.TableAndCellMoreMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.view.TableColorPalette;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceSpeedAdapter;

/* JADX INFO: renamed from: Q2.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC0220b implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f657a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f658b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f659c;

    public /* synthetic */ ViewOnClickListenerC0220b(Object obj, int i, int i2) {
        this.f657a = i2;
        this.f659c = obj;
        this.f658b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f657a) {
            case 0:
                OldNotifyHolder.decorateItemView$lambda$0((OldNotifyHolder) this.f659c, this.f658b, view);
                break;
            case 1:
                UnsupportedTranslationLanguageAdapter.getView$lambda$0((UnsupportedTranslationLanguageAdapter) this.f659c, this.f658b, view);
                break;
            case 2:
                RtMenuTable.initLineTypeButton$lambda$16((RtMenuTable) this.f659c, this.f658b, view);
                break;
            case 3:
                TableAndCellMoreMenu.initDeleteCellsButton$lambda$6((TableAndCellMoreMenu) this.f659c, this.f658b, view);
                break;
            case 4:
                VoiceSpeedAdapter.onBindViewHolder$lambda$0((VoiceSpeedAdapter) this.f659c, this.f658b, view);
                break;
            default:
                TableColorPalette.initPaletteInfo$lambda$0((TableColorPalette) this.f659c, this.f658b, view);
                break;
        }
    }
}
