package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAManager;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemSave;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItem;", "view", "Landroid/view/View;", "menuItemContract", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/item/MenuItemContract;)V", "onClick", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuItemSave extends MenuItem {

    @NotNull
    private static final String TAG = SOLogger.createTag("MenuItemSave");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuItemSave(@NotNull View view, @Nullable MenuItemContract menuItemContract) {
        super(view, menuItemContract, null, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNull(menuItemContract);
        if (VoiceAssistantTTS.INSTANCE.isVoiceAssistantEnabled(view.getContext())) {
            CharSequence contentDescription = view.getContentDescription();
            this.mView.setContentDescription(((Object) contentDescription) + SQLKeyword.COMMA + view.getResources().getString(C9086R.string.button_string_button));
        }
        int i = C9086R.drawable.screenoff_rectangle_button_ripple_effect_show_button_shape;
        ButtonShapeUtil.changeCustomButtonBackgroundUnchangedTextColor(view, i, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.item.MenuItem
    public void onClick() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onClick# ");
        SAManager.Companion companion = SAManager.INSTANCE;
        companion.getINSTANCE().onSaveClicked();
        companion.getINSTANCE().setExitReason(6);
        this.mMenuItemContract.onSave();
    }
}
