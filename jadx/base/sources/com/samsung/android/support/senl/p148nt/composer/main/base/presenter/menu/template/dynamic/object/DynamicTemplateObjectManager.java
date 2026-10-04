package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.object;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectLine;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.addons.base.utils.FileUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.PageSizeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateObjectUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DateTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DayOfWeekTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.GeneratedImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Image;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.ByteStreamsKt;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 T2\u00020\u0001:\u0002STB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017J\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0015J.\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&J.\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&J\u0010\u0010*\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010,J.\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&J\u000e\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0015J\u0012\u00100\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u001a\u00100\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00102\u001a\u00020&H\u0002J.\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&J.\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u0002082\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&J \u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010<\u001a\u0004\u0018\u00010\u0015J\u0016\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u0018\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u001c\u0010G\u001a\u00020\u00132\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\u001c\u0010J\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010K\u001a\u00020\u0015J\u001e\u0010L\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010K\u001a\u00020\u0015H\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0015H\u0002J\u000e\u0010N\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u00020P8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006U"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager;", "", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "optionMenuAddPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuAddPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuAddPresenter;)V", "getComposerModel", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "getComposerViewPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "getOptionMenuAddPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuAddPresenter;", "handler", "Landroid/os/Handler;", "setPdfBackground", "", "backgroundFileName", "", "templatePageIndex", "", "endAction", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager$PdfBackgroundCallback;", "addDefaultBackground", "targetPageIndex", "color", "addImageBackground", "background", "addTextBox", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/TextBox;", "docPageSize", "Landroid/graphics/PointF;", "templatePageSize", "initTimeInMillis", "", "addDateTextBox", "dateTextBox", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DateTextBox;", "updateDateTextBox", "objectTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "addDayOfDayOfWeekTextBox", "dayOfWeekTextBox", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DayOfWeekTextBox;", "updateDayOfWeekTextBox", "objectTextBoxId", "timeInMillis", "addImage", "image", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Image;", "addGeneratedImage", "generatedImage", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/GeneratedImage;", "updateImage", "", "targetObjectId", "path", "releaseImage", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "objectImage", "Lcom/samsung/android/sdk/pen/document/SpenObjectImage;", "decorateBorder", "element", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "bound", "Landroid/graphics/RectF;", "insertObjectInBound", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "findObjectTextBoxById", "id", "findObjectImageById", "findObjectById", "findPageIndexByObjectId", "objectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "PdfBackgroundCallback", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDynamicTemplateObjectManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DynamicTemplateObjectManager.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n+ 3 Point.kt\nandroidx/core/graphics/PointKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,366:1\n29#2:367\n147#3:368\n147#3:369\n147#3:370\n147#3:371\n147#3:372\n1869#4,2:373\n*S KotlinDebug\n*F\n+ 1 DynamicTemplateObjectManager.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager\n*L\n56#1:367\n138#1:368\n159#1:369\n188#1:370\n236#1:371\n259#1:372\n295#1:373,2\n*E\n"})
public final class DynamicTemplateObjectManager {
    private static final String TAG = Logger.createDynamicTemplateLog("ObjectManager");

    @NotNull
    private final ComposerModel composerModel;

    @NotNull
    private final ComposerViewPresenter composerViewPresenter;

    @NotNull
    private final Handler handler;

    @NotNull
    private final OptionMenuAddPresenter optionMenuAddPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager$PdfBackgroundCallback;", "", "onSuccess", "", "pageIndex", "", "onFailed", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface PdfBackgroundCallback {
        void onFailed();

        void onSuccess(int pageIndex);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.object.DynamicTemplateObjectManager$setPdfBackground$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager$setPdfBackground$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/Task$Callback;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/TaskAddPdf$ResultValues;", "onSuccess", "", "result", "onError", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C98801 implements Task.Callback<TaskAddPdf.ResultValues> {
        final /* synthetic */ Task.Callback<TaskAddPdf.ResultValues> $defaultCallback;
        final /* synthetic */ PdfBackgroundCallback $endAction;

        public C98801(PdfBackgroundCallback pdfBackgroundCallback, Task.Callback<TaskAddPdf.ResultValues> callback) {
            this.$endAction = pdfBackgroundCallback;
            this.$defaultCallback = callback;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onError(TaskAddPdf.ResultValues result) {
            Logger.m10999d(DynamicTemplateObjectManager.TAG, "setPdfBackground#onError");
            DynamicTemplateObjectManager.this.handler.post(new RunnableC9881a(this.$defaultCallback, result, 1));
            this.$endAction.onFailed();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onSuccess(TaskAddPdf.ResultValues result) {
            Integer firstPageIndex;
            Logger.m10999d(DynamicTemplateObjectManager.TAG, "setPdfBackground#onSuccess");
            DynamicTemplateObjectManager.this.handler.post(new RunnableC9881a(this.$defaultCallback, result, 0));
            this.$endAction.onSuccess((result == null || (firstPageIndex = result.getFirstPageIndex()) == null) ? 0 : firstPageIndex.intValue());
        }
    }

    public DynamicTemplateObjectManager(@NotNull ComposerModel composerModel, @NotNull ComposerViewPresenter composerViewPresenter, @NotNull OptionMenuAddPresenter optionMenuAddPresenter) {
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(optionMenuAddPresenter, "optionMenuAddPresenter");
        this.composerModel = composerModel;
        this.composerViewPresenter = composerViewPresenter;
        this.optionMenuAddPresenter = optionMenuAddPresenter;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ void addDefaultBackground$default(DynamicTemplateObjectManager dynamicTemplateObjectManager, int i, int i2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = ColorKt.m18579toArgb8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
        }
        dynamicTemplateObjectManager.addDefaultBackground(i, i2);
    }

    private final void decorateBorder(Element element, RectF bound) {
        List<Pair<SpenObjectLine, RectF>> listMakeObjectBorders = DynamicTemplateObjectUtil.makeObjectBorders(bound, element);
        if (listMakeObjectBorders.isEmpty()) {
            return;
        }
        Iterator<T> it = listMakeObjectBorders.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            insertObjectInBound((SpenObjectBase) pair.getFirst(), (RectF) pair.getSecond());
        }
    }

    private final SpenObjectBase findObjectById(String id) {
        int pageCount;
        if (!TextUtils.isEmpty(id) && this.composerModel.getDoc().getPageCount() - 2 >= 0) {
            int i = 0;
            while (true) {
                SpenWPage spenWPage = this.composerModel.getDoc().getPageList().get(i);
                Intrinsics.checkNotNullExpressionValue(spenWPage, "get(...)");
                SpenObjectBase spenObjectBaseFindObjectById = DynamicTemplateObjectUtil.findObjectById(spenWPage, id);
                if (spenObjectBaseFindObjectById == null) {
                    if (i == pageCount) {
                        break;
                    }
                    i++;
                } else {
                    return spenObjectBaseFindObjectById;
                }
            }
        }
        return null;
    }

    private final SpenObjectImage findObjectImageById(SpenWPage page, String id) {
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        SpenObjectBase spenObjectBaseFindObjectById = page != null ? DynamicTemplateObjectUtil.findObjectById(page, 4, id) : findObjectById(id);
        SpenObjectImage spenObjectImage = spenObjectBaseFindObjectById instanceof SpenObjectImage ? (SpenObjectImage) spenObjectBaseFindObjectById : null;
        if (spenObjectImage == null) {
            return null;
        }
        return spenObjectImage;
    }

    public static /* synthetic */ SpenObjectImage findObjectImageById$default(DynamicTemplateObjectManager dynamicTemplateObjectManager, SpenWPage spenWPage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            spenWPage = null;
        }
        return dynamicTemplateObjectManager.findObjectImageById(spenWPage, str);
    }

    public static /* synthetic */ SpenObjectTextBox findObjectTextBoxById$default(DynamicTemplateObjectManager dynamicTemplateObjectManager, SpenWPage spenWPage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            spenWPage = null;
        }
        return dynamicTemplateObjectManager.findObjectTextBoxById(spenWPage, str);
    }

    private final ObjectManager getObjectManager() {
        ObjectManager objectManager = this.composerViewPresenter.getObjectManager();
        Intrinsics.checkNotNullExpressionValue(objectManager, "getObjectManager(...)");
        return objectManager;
    }

    private final void insertObjectInBound(SpenObjectBase objectBase, RectF bound) {
        getObjectManager().insertObjectInBound(objectBase, bound, false, false);
    }

    public final void addDateTextBox(@NotNull DateTextBox dateTextBox, @NotNull PointF docPageSize, @NotNull PointF templatePageSize, int templatePageIndex, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(dateTextBox, "dateTextBox");
        Intrinsics.checkNotNullParameter(docPageSize, "docPageSize");
        Intrinsics.checkNotNullParameter(templatePageSize, "templatePageSize");
        float f = docPageSize.x;
        float f4 = templatePageSize.x;
        RectF rectFConvertElementRectToDocRect = DynamicTemplateUtil.INSTANCE.convertElementRectToDocRect(dateTextBox, docPageSize, templatePageSize, new PointF(this.composerModel.getDoc().getPage(templatePageIndex).getOffset()));
        SpenObjectTextBox spenObjectTextBoxMakeObjectDateTextBox = DynamicTemplateObjectUtil.makeObjectDateTextBox(dateTextBox, rectFConvertElementRectToDocRect, f4, f, initTimeInMillis);
        updateDateTextBox(spenObjectTextBoxMakeObjectDateTextBox);
        decorateBorder(dateTextBox, rectFConvertElementRectToDocRect);
        insertObjectInBound(spenObjectTextBoxMakeObjectDateTextBox, rectFConvertElementRectToDocRect);
    }

    public final void addDayOfDayOfWeekTextBox(@NotNull DayOfWeekTextBox dayOfWeekTextBox, @NotNull PointF docPageSize, @NotNull PointF templatePageSize, int templatePageIndex, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(dayOfWeekTextBox, "dayOfWeekTextBox");
        Intrinsics.checkNotNullParameter(docPageSize, "docPageSize");
        Intrinsics.checkNotNullParameter(templatePageSize, "templatePageSize");
        float f = docPageSize.x;
        float f4 = templatePageSize.x;
        RectF rectFConvertElementRectToDocRect = DynamicTemplateUtil.INSTANCE.convertElementRectToDocRect(dayOfWeekTextBox, docPageSize, templatePageSize, new PointF(this.composerModel.getDoc().getPage(templatePageIndex).getOffset()));
        SpenObjectTextBox spenObjectTextBoxMakeObjectDayOfWeekTextBox = DynamicTemplateObjectUtil.makeObjectDayOfWeekTextBox(dayOfWeekTextBox, rectFConvertElementRectToDocRect, f4, f, initTimeInMillis);
        updateDayOfWeekTextBox(spenObjectTextBoxMakeObjectDayOfWeekTextBox);
        decorateBorder(dayOfWeekTextBox, rectFConvertElementRectToDocRect);
        insertObjectInBound(spenObjectTextBoxMakeObjectDayOfWeekTextBox, rectFConvertElementRectToDocRect);
    }

    public final void addDefaultBackground(int targetPageIndex, int color) {
        PointF pageSize = PageSizeUtil.getPageSize(this.composerModel.getDoc().getPage(targetPageIndex));
        RectF rectF = new RectF(0.0f, 0.0f, pageSize.x, pageSize.y);
        rectF.offset(r5.getOffset().x, r5.getOffset().y);
        insertObjectInBound(DynamicTemplateObjectUtil.makeObjectShape(rectF, color), rectF);
    }

    public final void addGeneratedImage(@NotNull GeneratedImage generatedImage, @NotNull PointF docPageSize, @NotNull PointF templatePageSize, int templatePageIndex, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(generatedImage, "generatedImage");
        Intrinsics.checkNotNullParameter(docPageSize, "docPageSize");
        Intrinsics.checkNotNullParameter(templatePageSize, "templatePageSize");
        float f = docPageSize.x;
        float f4 = templatePageSize.x;
        RectF rectFConvertElementRectToDocRect = DynamicTemplateUtil.INSTANCE.convertElementRectToDocRect(generatedImage, docPageSize, templatePageSize, new PointF(this.composerModel.getDoc().getPage(templatePageIndex).getOffset()));
        SpenObjectImage spenObjectImageMakeGeneratedImage = DynamicTemplateObjectUtil.makeGeneratedImage(generatedImage, rectFConvertElementRectToDocRect, initTimeInMillis);
        SpenObjectTextBox spenObjectTextBoxMakeObjectTextBoxForGenerateImage = DynamicTemplateObjectUtil.makeObjectTextBoxForGenerateImage(generatedImage, rectFConvertElementRectToDocRect, f4, f, initTimeInMillis);
        decorateBorder(generatedImage, rectFConvertElementRectToDocRect);
        insertObjectInBound(spenObjectImageMakeGeneratedImage, rectFConvertElementRectToDocRect);
        insertObjectInBound(spenObjectTextBoxMakeObjectTextBoxForGenerateImage, rectFConvertElementRectToDocRect);
    }

    public final void addImage(@NotNull Image image, @NotNull PointF docPageSize, @NotNull PointF templatePageSize, int templatePageIndex, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(docPageSize, "docPageSize");
        Intrinsics.checkNotNullParameter(templatePageSize, "templatePageSize");
        float f = docPageSize.x;
        float f4 = templatePageSize.x;
        RectF rectFConvertElementRectToDocRect = DynamicTemplateUtil.INSTANCE.convertElementRectToDocRect(image, docPageSize, templatePageSize, new PointF(this.composerModel.getDoc().getPage(templatePageIndex).getOffset()));
        SpenObjectImage spenObjectImageMakeImage = DynamicTemplateObjectUtil.makeImage(image, rectFConvertElementRectToDocRect, initTimeInMillis);
        SpenObjectTextBox spenObjectTextBoxMakeObjectTextBoxForInsertImage = DynamicTemplateObjectUtil.makeObjectTextBoxForInsertImage(image, rectFConvertElementRectToDocRect, f4, f, initTimeInMillis);
        decorateBorder(image, rectFConvertElementRectToDocRect);
        insertObjectInBound(spenObjectImageMakeImage, rectFConvertElementRectToDocRect);
        insertObjectInBound(spenObjectTextBoxMakeObjectTextBoxForInsertImage, rectFConvertElementRectToDocRect);
    }

    public final void addImageBackground(int templatePageIndex, @NotNull String background) {
        Intrinsics.checkNotNullParameter(background, "background");
        Context applicationContext = this.composerViewPresenter.getActivity().getApplicationContext();
        File cacheDir = applicationContext.getCacheDir();
        if (cacheDir == null) {
            Logger.m11000e(TAG, "addImageBackground, ignore, cacheDir is null");
            return;
        }
        String strM757C = AbstractC0541b.m757C(cacheDir.getPath(), File.separator, Constant.BG_CACHE_PATH);
        if (!FileUtils.isExistedFile(strM757C)) {
            FileUtils.INSTANCE.makeDirectory(strM757C);
        }
        File file = new File(AbstractC0541b.m757C(strM757C, "/bg_cache", DynamicTemplateUtil.getExtension(background)));
        InputStream inputStreamOpen = applicationContext.getAssets().open(background);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                Intrinsics.checkNotNull(inputStreamOpen);
                ByteStreamsKt.copyTo$default(inputStreamOpen, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                CloseableKt.closeFinally(inputStreamOpen, null);
                PointF pageSize = PageSizeUtil.getPageSize(this.composerModel.getDoc().getPage(templatePageIndex));
                RectF rectF = new RectF(0.0f, 0.0f, pageSize.x, pageSize.y);
                rectF.offset(r7.getOffset().x, r7.getOffset().y);
                String path = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                insertObjectInBound(DynamicTemplateObjectUtil.makeObjectImageForBackground(rectF, path, System.currentTimeMillis()), rectF);
                FileUtils.deleteFile(strM757C);
            } finally {
            }
        } finally {
        }
    }

    public final void addTextBox(@NotNull TextBox textBox, @NotNull PointF docPageSize, @NotNull PointF templatePageSize, int templatePageIndex, long initTimeInMillis) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        Intrinsics.checkNotNullParameter(docPageSize, "docPageSize");
        Intrinsics.checkNotNullParameter(templatePageSize, "templatePageSize");
        float f = docPageSize.x;
        float f4 = templatePageSize.x;
        RectF rectFConvertElementRectToDocRect = DynamicTemplateUtil.INSTANCE.convertElementRectToDocRect(textBox, docPageSize, templatePageSize, new PointF(this.composerModel.getDoc().getPage(templatePageIndex).getOffset()));
        SpenObjectTextBox spenObjectTextBoxMakeObjectTextBox = DynamicTemplateObjectUtil.makeObjectTextBox(textBox, rectFConvertElementRectToDocRect, f4, f, initTimeInMillis);
        decorateBorder(textBox, rectFConvertElementRectToDocRect);
        insertObjectInBound(spenObjectTextBoxMakeObjectTextBox, rectFConvertElementRectToDocRect);
    }

    @Nullable
    public final SpenObjectTextBox findObjectTextBoxById(@Nullable SpenWPage page, @NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        SpenObjectBase spenObjectBaseFindObjectById = page != null ? DynamicTemplateObjectUtil.findObjectById(page, 2, id) : findObjectById(id);
        SpenObjectTextBox spenObjectTextBox = spenObjectBaseFindObjectById instanceof SpenObjectTextBox ? (SpenObjectTextBox) spenObjectBaseFindObjectById : null;
        if (spenObjectTextBox == null) {
            return null;
        }
        return spenObjectTextBox;
    }

    public final int findPageIndexByObjectId(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        int pageCount = this.composerModel.getDoc().getPageCount() - 2;
        if (pageCount < 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            SpenWPage spenWPage = this.composerModel.getDoc().getPageList().get(i);
            Intrinsics.checkNotNullExpressionValue(spenWPage, "get(...)");
            if (DynamicTemplateObjectUtil.findObjectById(spenWPage, id) != null) {
                return i;
            }
            if (i == pageCount) {
                return -1;
            }
            i++;
        }
    }

    @NotNull
    public final ComposerModel getComposerModel() {
        return this.composerModel;
    }

    @NotNull
    public final ComposerViewPresenter getComposerViewPresenter() {
        return this.composerViewPresenter;
    }

    @NotNull
    public final OptionMenuAddPresenter getOptionMenuAddPresenter() {
        return this.optionMenuAddPresenter;
    }

    public final void releaseImage(@NotNull SpenWPage page, @NotNull SpenObjectImage objectImage) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectImage, "objectImage");
        DynamicTemplateObjectUtil.INSTANCE.releaseImage(page, objectImage);
        getObjectManager().clearSelectObject();
    }

    public final void setPdfBackground(@NotNull String backgroundFileName, int templatePageIndex, @NotNull PdfBackgroundCallback endAction) {
        Intrinsics.checkNotNullParameter(backgroundFileName, "backgroundFileName");
        Intrinsics.checkNotNullParameter(endAction, "endAction");
        String str = TAG;
        Logger.m10999d(str, "setPdfBackground# start");
        Uri uri = Uri.parse("android.resource://" + BaseUtils.getContext().getPackageName() + "/raw/" + backgroundFileName);
        String encode = Logger.getEncode(uri.toString());
        StringBuilder sb = new StringBuilder("initTemplateBackground start, uri: ");
        sb.append(encode);
        Logger.m10999d(str, sb.toString());
        OptionMenuPdfPresenter.Param paramCreate = new OptionMenuPdfPresenter.ParamFactory(CollectionsKt.mutableListOf(uri), null).create();
        TaskAddPdf.InputValues taskAddPdfInputValues = this.optionMenuAddPresenter.getOptionMenuPdfPresenter().getTaskAddPdfInputValues(paramCreate, templatePageIndex);
        Task.Callback<TaskAddPdf.ResultValues> taskAddPdfCallback = this.optionMenuAddPresenter.getOptionMenuPdfPresenter().getTaskAddPdfCallback(paramCreate);
        Intrinsics.checkNotNullExpressionValue(taskAddPdfCallback, "getTaskAddPdfCallback(...)");
        TaskAddPdf taskAddPdf = new TaskAddPdf();
        taskAddPdf.setInputValue(taskAddPdfInputValues);
        taskAddPdf.setTaskCallback(new C98801(endAction, taskAddPdfCallback));
        taskAddPdf.run();
    }

    public final void updateDateTextBox(@Nullable SpenObjectTextBox objectTextBox) {
        if (objectTextBox == null) {
            return;
        }
        objectTextBox.setText(DynamicTemplateUtil.convertTimeInMillisToDate(DynamicTemplateUtil.getDateTextBoxTimeInMillis(objectTextBox), DynamicTemplateUtil.getDateTextBoxFormat(objectTextBox)));
    }

    public final void updateDayOfWeekTextBox(@NotNull String objectTextBoxId) {
        Intrinsics.checkNotNullParameter(objectTextBoxId, "objectTextBoxId");
        updateDayOfWeekTextBox(findObjectTextBoxById(null, objectTextBoxId));
    }

    public final boolean updateImage(@NotNull String targetObjectId, int targetPageIndex, @Nullable String path) {
        Intrinsics.checkNotNullParameter(targetObjectId, "targetObjectId");
        SpenWPage spenWPage = this.composerModel.getDoc().getPageList().get(targetPageIndex);
        Intrinsics.checkNotNullExpressionValue(spenWPage, "get(...)");
        SpenWPage spenWPage2 = spenWPage;
        SpenObjectImage spenObjectImageFindObjectImageById$default = findObjectImageById$default(this, null, targetObjectId, 1, null);
        if (spenObjectImageFindObjectImageById$default == null) {
            return false;
        }
        DynamicTemplateObjectUtil.INSTANCE.updateImage(spenWPage2, spenObjectImageFindObjectImageById$default, path);
        getObjectManager().clearSelectObject();
        return true;
    }

    private final void updateDayOfWeekTextBox(SpenObjectTextBox objectTextBox) {
        updateDayOfWeekTextBox(objectTextBox, DynamicTemplateUtil.getDateTextBoxTimeInMillis(findObjectTextBoxById(null, DynamicTemplateUtil.INSTANCE.getGroupedObjectId(objectTextBox))));
    }

    private final void updateDayOfWeekTextBox(SpenObjectTextBox objectTextBox, long timeInMillis) {
        if (objectTextBox == null) {
            return;
        }
        if (DynamicTemplateUtil.getDayOfWeekTextBoxDisplayType(objectTextBox) == 1) {
            objectTextBox.setText(DynamicTemplateUtil.convertTimeInMillisToWeekByTodayIsType(timeInMillis));
        } else {
            objectTextBox.setText(DynamicTemplateUtil.convertTimeInMillisToWeek(timeInMillis));
        }
    }
}
