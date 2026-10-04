package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import android.app.Activity;
import android.graphics.PointF;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.addons.base.utils.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.object.DynamicTemplateObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import p107a4.RunnableC0355a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u001a\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u0015H\u0002J \u0010$\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader;", "", "<init>", "()V", "templateParser", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/XmlTemplateParser;", "templateObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "init", "", "release", "loadTemplateData", "templatePath", "", "targetPageIndex", "", "endAction", "Ljava/lang/Runnable;", "initTemplatePages", XmlTemplateConstants.TEMPLATE, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Template;", "initTemplatePage", "templatePage", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Page;", "templatePageIndex", "initWPage", "initPdfBackground", "initImageBackground", "initDefaultBackground", "color", "initTemplateContents", "initTemplateGroup", "group", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Group;", "docPageSize", "Landroid/graphics/PointF;", "templatePageSize", "softInputManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "getSoftInputManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "objectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDynamicTemplateLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DynamicTemplateLoader.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,244:1\n439#2:245\n*S KotlinDebug\n*F\n+ 1 DynamicTemplateLoader.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader\n*L\n105#1:245\n*E\n"})
public final class DynamicTemplateLoader {
    private static final String TAG = Logger.createDynamicTemplateLog("Loader");
    private ComposerModel composerModel;
    private ComposerViewPresenter composerViewPresenter;
    private ControllerManager controllerManager;
    private DynamicTemplateObjectManager templateObjectManager;

    @NotNull
    private final XmlTemplateParser templateParser = new XmlTemplateParser();

    private final ObjectManager getObjectManager() {
        ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
            composerViewPresenter = null;
        }
        ObjectManager objectManager = composerViewPresenter.getObjectManager();
        Intrinsics.checkNotNullExpressionValue(objectManager, "getObjectManager(...)");
        return objectManager;
    }

    private final void initDefaultBackground(int targetPageIndex, int color) {
        DynamicTemplateObjectManager dynamicTemplateObjectManager = this.templateObjectManager;
        if (dynamicTemplateObjectManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
            dynamicTemplateObjectManager = null;
        }
        dynamicTemplateObjectManager.addDefaultBackground(targetPageIndex, color);
    }

    public static /* synthetic */ void initDefaultBackground$default(DynamicTemplateLoader dynamicTemplateLoader, int i, int i2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = ColorKt.m18579toArgb8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
        }
        dynamicTemplateLoader.initDefaultBackground(i, i2);
    }

    private final void initImageBackground(Page templatePage, int templatePageIndex) {
        DynamicTemplateObjectManager dynamicTemplateObjectManager = this.templateObjectManager;
        if (dynamicTemplateObjectManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
            dynamicTemplateObjectManager = null;
        }
        dynamicTemplateObjectManager.addImageBackground(templatePageIndex, templatePage.getBackground());
    }

    private final int initPdfBackground(Page templatePage, int templatePageIndex) throws InterruptedException {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = templatePageIndex;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DynamicTemplateObjectManager dynamicTemplateObjectManager = this.templateObjectManager;
        if (dynamicTemplateObjectManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
            dynamicTemplateObjectManager = null;
        }
        dynamicTemplateObjectManager.setPdfBackground(FileUtils.INSTANCE.extractFileName(templatePage.getBackground()), intRef.element, new DynamicTemplateObjectManager.PdfBackgroundCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader.initPdfBackground.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.object.DynamicTemplateObjectManager.PdfBackgroundCallback
            public void onFailed() {
                countDownLatch.countDown();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.object.DynamicTemplateObjectManager.PdfBackgroundCallback
            public void onSuccess(int pageIndex) {
                intRef.element = pageIndex;
                booleanRef.element = true;
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        if (!booleanRef.element) {
            Logger.m11000e(TAG, "initTemplatePage, setPdfBackground, failed, skip");
            return intRef.element;
        }
        Logger.m11004w(TAG, "initTemplatePage, after setPdfBackground, templatePageIndex: " + templatePageIndex + ", pageIndex: " + intRef.element);
        return intRef.element;
    }

    private final void initTemplateContents(Page templatePage, int templatePageIndex, int targetPageIndex) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        RunnableC0355a runnableC0355a = new RunnableC0355a(templatePage, this, targetPageIndex, countDownLatch, 5);
        if (templatePageIndex != targetPageIndex) {
            ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
            if (composerViewPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
                composerViewPresenter = null;
            }
            composerViewPresenter.getHandler().postDelayed(runnableC0355a, 200L);
        } else {
            runnableC0355a.run();
        }
        countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTemplateContents$lambda$0(Page page, DynamicTemplateLoader dynamicTemplateLoader, int i, CountDownLatch countDownLatch) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C9879xafe08dc3(page, dynamicTemplateLoader, i, countDownLatch, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTemplateGroup(Group group, PointF docPageSize, PointF templatePageSize, int templatePageIndex) {
        int i;
        PointF pointF;
        PointF pointF2;
        int size = group.getElements().size();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        while (i2 < size) {
            Element element = group.getElements().get(i2);
            DynamicTemplateObjectManager dynamicTemplateObjectManager = null;
            if (element instanceof Image) {
                DynamicTemplateObjectManager dynamicTemplateObjectManager2 = this.templateObjectManager;
                if (dynamicTemplateObjectManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                } else {
                    dynamicTemplateObjectManager = dynamicTemplateObjectManager2;
                }
                Image image = (Image) element;
                pointF2 = templatePageSize;
                i = templatePageIndex;
                DynamicTemplateObjectManager dynamicTemplateObjectManager3 = dynamicTemplateObjectManager;
                pointF = docPageSize;
                dynamicTemplateObjectManager3.addImage(image, pointF, pointF2, i, jCurrentTimeMillis);
            } else {
                i = templatePageIndex;
                if (element instanceof GeneratedImage) {
                    DynamicTemplateObjectManager dynamicTemplateObjectManager4 = this.templateObjectManager;
                    if (dynamicTemplateObjectManager4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                    } else {
                        dynamicTemplateObjectManager = dynamicTemplateObjectManager4;
                    }
                    GeneratedImage generatedImage = (GeneratedImage) element;
                    pointF2 = templatePageSize;
                    DynamicTemplateObjectManager dynamicTemplateObjectManager5 = dynamicTemplateObjectManager;
                    pointF = docPageSize;
                    dynamicTemplateObjectManager5.addGeneratedImage(generatedImage, pointF, pointF2, i, jCurrentTimeMillis);
                } else if (element instanceof DateTextBox) {
                    DynamicTemplateObjectManager dynamicTemplateObjectManager6 = this.templateObjectManager;
                    if (dynamicTemplateObjectManager6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                    } else {
                        dynamicTemplateObjectManager = dynamicTemplateObjectManager6;
                    }
                    DateTextBox dateTextBox = (DateTextBox) element;
                    pointF2 = templatePageSize;
                    DynamicTemplateObjectManager dynamicTemplateObjectManager7 = dynamicTemplateObjectManager;
                    pointF = docPageSize;
                    dynamicTemplateObjectManager7.addDateTextBox(dateTextBox, pointF, pointF2, i, jCurrentTimeMillis);
                } else if (element instanceof DayOfWeekTextBox) {
                    DynamicTemplateObjectManager dynamicTemplateObjectManager8 = this.templateObjectManager;
                    if (dynamicTemplateObjectManager8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                    } else {
                        dynamicTemplateObjectManager = dynamicTemplateObjectManager8;
                    }
                    DayOfWeekTextBox dayOfWeekTextBox = (DayOfWeekTextBox) element;
                    pointF2 = templatePageSize;
                    DynamicTemplateObjectManager dynamicTemplateObjectManager9 = dynamicTemplateObjectManager;
                    pointF = docPageSize;
                    dynamicTemplateObjectManager9.addDayOfDayOfWeekTextBox(dayOfWeekTextBox, pointF, pointF2, i, jCurrentTimeMillis);
                } else if (element instanceof TextBox) {
                    DynamicTemplateObjectManager dynamicTemplateObjectManager10 = this.templateObjectManager;
                    if (dynamicTemplateObjectManager10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
                    } else {
                        dynamicTemplateObjectManager = dynamicTemplateObjectManager10;
                    }
                    TextBox textBox = (TextBox) element;
                    pointF2 = templatePageSize;
                    DynamicTemplateObjectManager dynamicTemplateObjectManager11 = dynamicTemplateObjectManager;
                    pointF = docPageSize;
                    dynamicTemplateObjectManager11.addTextBox(textBox, pointF, pointF2, i, jCurrentTimeMillis);
                } else {
                    pointF = docPageSize;
                    pointF2 = templatePageSize;
                }
            }
            i2++;
            docPageSize = pointF;
            templatePageSize = pointF2;
            templatePageIndex = i;
        }
    }

    private final void initTemplatePage(Page templatePage, int templatePageIndex) throws InterruptedException {
        int iInitWPage = initWPage(templatePageIndex);
        Constant.BackgroundType backgroundType = DynamicTemplateUtil.getBackgroundType(templatePage.getBackground());
        if (backgroundType == Constant.BackgroundType.PDF) {
            iInitWPage = initPdfBackground(templatePage, iInitWPage);
        } else if (backgroundType == Constant.BackgroundType.IMAGE) {
            initImageBackground(templatePage, templatePageIndex);
        }
        initDefaultBackground(templatePageIndex, backgroundType == Constant.BackgroundType.COLOR ? android.graphics.Color.parseColor(templatePage.getBackground()) : ColorKt.m18579toArgb8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU()));
        initTemplateContents(templatePage, templatePageIndex, iInitWPage);
        ComposerModel composerModel = this.composerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel = null;
        }
        composerModel.getDoc().getPage(iInitWPage).setTemplateType(17);
    }

    private final void initTemplatePages(Template template, int targetPageIndex) throws InterruptedException {
        int size = template.getPages().size();
        for (int i = 0; i < size; i++) {
            initTemplatePage(template.getPages().get(i), targetPageIndex + i);
        }
    }

    private final int initWPage(int templatePageIndex) {
        ComposerModel composerModel = this.composerModel;
        ComposerViewPresenter composerViewPresenter = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel = null;
        }
        int pageCount = composerModel.getDoc().getPageCount() - 1;
        ComposerModel composerModel2 = this.composerModel;
        if (composerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel2 = null;
        }
        SpenWPage page = composerModel2.getDoc().getPage(templatePageIndex);
        if (pageCount > templatePageIndex && !page.hasPDF() && !page.hasBackgroundImage() && page.getObjectList().isEmpty()) {
            return templatePageIndex;
        }
        String str = TAG;
        Logger.m11004w(str, "initWPage, attach new page");
        ComposerModel composerModel3 = this.composerModel;
        if (composerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel3 = null;
        }
        int i = templatePageIndex + 1;
        composerModel3.getDoc().insertPage(i);
        ComposerViewPresenter composerViewPresenter2 = this.composerViewPresenter;
        if (composerViewPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
        } else {
            composerViewPresenter = composerViewPresenter2;
        }
        composerViewPresenter.getNoteManager().updatePageLayout();
        Logger.m11004w(str, "initWPage, after attach new page, targetPageIndex: " + i);
        return i;
    }

    @NotNull
    public final SoftInputManager getSoftInputManager() {
        ControllerManager controllerManager = this.controllerManager;
        if (controllerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controllerManager");
            controllerManager = null;
        }
        SoftInputManager softInputManager = controllerManager.getSoftInputManager();
        Intrinsics.checkNotNullExpressionValue(softInputManager, "getSoftInputManager(...)");
        return softInputManager;
    }

    public final void init(@NotNull DynamicTemplateObjectManager templateObjectManager, @NotNull ComposerModel composerModel, @NotNull ControllerManager controllerManager, @NotNull ComposerViewPresenter composerViewPresenter) {
        Intrinsics.checkNotNullParameter(templateObjectManager, "templateObjectManager");
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Logger.m10999d(TAG, "init");
        this.templateObjectManager = templateObjectManager;
        this.composerModel = composerModel;
        this.controllerManager = controllerManager;
        this.composerViewPresenter = composerViewPresenter;
    }

    public final void loadTemplateData(@NotNull String templatePath, int targetPageIndex, @NotNull Runnable endAction) {
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        Intrinsics.checkNotNullParameter(endAction, "endAction");
        String str = TAG;
        ComposerModel composerModel = this.composerModel;
        ComposerViewPresenter composerViewPresenter = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel = null;
        }
        int pageLayoutWidth = composerModel.getDoc().getPageLayoutWidth();
        ComposerModel composerModel2 = this.composerModel;
        if (composerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel2 = null;
        }
        int pageLayoutHeight = composerModel2.getDoc().getPageLayoutHeight();
        String encode = Logger.getEncode(templatePath);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(pageLayoutWidth, pageLayoutHeight, "loadTemplateData, docWidth: ", ", docHeight: ", ", targetPageIndex: ");
        sbM1173s.append(targetPageIndex);
        sbM1173s.append(", templatePath: ");
        sbM1173s.append(encode);
        Logger.m11000e(str, sbM1173s.toString());
        ComposerViewPresenter composerViewPresenter2 = this.composerViewPresenter;
        if (composerViewPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
            composerViewPresenter2 = null;
        }
        composerViewPresenter2.getNoteManager().setAddPageBlocked(str, true);
        ComposerModel composerModel3 = this.composerModel;
        if (composerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel3 = null;
        }
        composerModel3.getDoc().beginHistoryGroup("loadTemplateData");
        getObjectManager().clearSelectObject();
        XmlTemplateParser xmlTemplateParser = this.templateParser;
        ComposerViewPresenter composerViewPresenter3 = this.composerViewPresenter;
        if (composerViewPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
            composerViewPresenter3 = null;
        }
        Activity activity = composerViewPresenter3.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        initTemplatePages(xmlTemplateParser.parseXmlString(DynamicTemplateUtil.getXmlStringFromAssetFile(activity, templatePath)), targetPageIndex);
        ComposerViewPresenter composerViewPresenter4 = this.composerViewPresenter;
        if (composerViewPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
            composerViewPresenter4 = null;
        }
        composerViewPresenter4.getNoteManager().updateDummyPage();
        ComposerModel composerModel4 = this.composerModel;
        if (composerModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel4 = null;
        }
        composerModel4.getDoc().endHistoryGroup();
        ComposerModel composerModel5 = this.composerModel;
        if (composerModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel5 = null;
        }
        composerModel5.getDoc().clearHistory();
        ComposerModel composerModel6 = this.composerModel;
        if (composerModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel6 = null;
        }
        composerModel6.getDoc().clearChangedFlag();
        ComposerViewPresenter composerViewPresenter5 = this.composerViewPresenter;
        if (composerViewPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
        } else {
            composerViewPresenter = composerViewPresenter5;
        }
        composerViewPresenter.getNoteManager().setAddPageBlocked(str, false);
        endAction.run();
    }

    public final void release() {
        Logger.m10999d(TAG, "release");
    }
}
