package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.view.Menu;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.BaseShareUtil;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTextBox;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareIntentCreationHelper;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareSelectedItemHelper;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.SpenObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0016\u001a\u00060\u0017R\u00020\u0000H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuShare;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuItem;", "context", "Landroid/content/Context;", "textManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;)V", "getContext", "()Landroid/content/Context;", "getTextManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "shareText", "createIntentToShare", "Landroid/content/Intent;", "handleResult", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuShare$HandleResult;", "Companion", "HandleResult", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultContextMenuShare extends AiResultContextMenuItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("SmContextMenuShare");

    @NotNull
    private final Context context;

    @NotNull
    private final SimpleEditView textManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuShare$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return AiResultContextMenuShare.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuShare$HandleResult;", "", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuShare;)V", "textSb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getTextSb", "()Ljava/lang/StringBuilder;", "setTextSb", "(Ljava/lang/StringBuilder;)V", "contentUris", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "getContentUris", "()Ljava/util/ArrayList;", "setContentUris", "(Ljava/util/ArrayList;)V", "charSequence", "", "getCharSequence", "()Ljava/lang/CharSequence;", "setCharSequence", "(Ljava/lang/CharSequence;)V", "typeList", "", "", "getTypeList", "()Ljava/util/List;", "setTypeList", "(Ljava/util/List;)V", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class HandleResult {

        @NotNull
        private StringBuilder textSb = new StringBuilder();

        @NotNull
        private ArrayList<Uri> contentUris = new ArrayList<>();

        @NotNull
        private CharSequence charSequence = "";

        @NotNull
        private List<Integer> typeList = new ArrayList();

        public HandleResult() {
        }

        @NotNull
        public final CharSequence getCharSequence() {
            return this.charSequence;
        }

        @NotNull
        public final ArrayList<Uri> getContentUris() {
            return this.contentUris;
        }

        @NotNull
        public final StringBuilder getTextSb() {
            return this.textSb;
        }

        @NotNull
        public final List<Integer> getTypeList() {
            return this.typeList;
        }

        public final void setCharSequence(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.charSequence = charSequence;
        }

        public final void setContentUris(@NotNull ArrayList<Uri> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.contentUris = arrayList;
        }

        public final void setTextSb(@NotNull StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "<set-?>");
            this.textSb = sb;
        }

        public final void setTypeList(@NotNull List<Integer> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.typeList = list;
        }
    }

    public AiResultContextMenuShare(@NotNull Context context, @NotNull SimpleEditView textManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        this.context = context;
        this.textManager = textManager;
    }

    private final Intent createIntentToShare(Context context, HandleResult handleResult) {
        String string = handleResult.getTextSb().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String string2 = StringsKt.trim((CharSequence) string).toString();
        String html = HtmlUtils.toHtml(SpannableString.valueOf(handleResult.getCharSequence()));
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        ShareSelectedItemHelper shareSelectedItemHelper = new ShareSelectedItemHelper(TAG2);
        Intent intentMakeBaseIntent = shareSelectedItemHelper.makeBaseIntent(string2, "", "text/plain", false);
        ArrayList arrayList = new ArrayList();
        ArrayList<Uri> contentUris = handleResult.getContentUris();
        Intrinsics.checkNotNull(html);
        arrayList.add(shareSelectedItemHelper.createIntentForEmail(contentUris, null, html, ""));
        intentMakeBaseIntent.putExtra("exit_on_sent", true);
        Intent intentCreateChooserIntentCompat = ShareIntentCreationHelper.createChooserIntentCompat(context, intentMakeBaseIntent, arrayList, ShareCallbackReceiver.ShareCaller.StickyMemo);
        Intrinsics.checkNotNullExpressionValue(intentCreateChooserIntentCompat, "createChooserIntentCompat(...)");
        return intentCreateChooserIntentCompat;
    }

    private final void shareText() {
        SpenObjectTextBox textBox = this.textManager.getTextBox();
        if (textBox == null) {
            return;
        }
        int selectedStart = textBox.getSelectedStart();
        int selectedEnd = textBox.getSelectedEnd();
        String text = textBox.getText();
        int length = text != null ? text.length() : 0;
        String TAG2 = TAG;
        AbstractC8014b.m7195A(AbstractC0622a.m1173s(length, selectedStart, "createIntentToShare#handleTextBox#", ", start : ", ", end : "), TAG2, selectedEnd);
        if (selectedEnd < selectedStart || selectedStart > length || selectedEnd > length || selectedStart < 0 || selectedEnd < 0 || selectedStart == selectedEnd) {
            Logger.m11000e(TAG2, "createIntentToShare#handleTextBox# Text Box is IndexOutOfBounds");
            return;
        }
        SpenObjectShape spenObjectShapeCopyText = SpenObjectTextFactory.INSTANCE.copyText(textBox, textBox.getSelectedStart(), textBox.getSelectedEnd() - 1);
        HandleResult handleResult = new HandleResult();
        CharSequence charSequenceHandleText = new HandleTextBox().handleText(new HandleTextBox.InputBuilder(spenObjectShapeCopyText).setCharSequence(handleResult.getCharSequence()).setTextSb(handleResult.getTextSb()).setConverter(null).done());
        Intrinsics.checkNotNullExpressionValue(charSequenceHandleText, "handleText(...)");
        handleResult.setCharSequence(charSequenceHandleText);
        handleResult.getTypeList().add(2);
        Intent intentCreateIntentToShare = createIntentToShare(this.context, handleResult);
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        BaseShareUtil.startChooserActivity(TAG2, this.context, intentCreateIntentToShare, 2, 0, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        AiResultContextMenuCode aiResultContextMenuCode = AiResultContextMenuCode.CONTEXT_MENU_ID_SHARE;
        menu.add(0, aiResultContextMenuCode.getId(), aiResultContextMenuCode.getId(), C8875R.string.ctx_menu_share).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public boolean canShow() {
        return this.textManager.isSelected();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void executeMenu() {
        if (this.textManager.isSelected()) {
            shareText();
            this.textManager.clearSelection();
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final SimpleEditView getTextManager() {
        return this.textManager;
    }
}
