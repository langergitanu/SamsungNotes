package org.apache.commons.lang3.function;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.notes.bixby.BixbyManagerContract;
import com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.Bixby2;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectFindUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateObjectUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.DocConverterHelper;
import com.samsung.android.support.senl.p148nt.word.DocConverterConfiguration;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.util.DeviceUtil;

/* JADX INFO: renamed from: org.apache.commons.lang3.function.N */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13849N implements FailableLongToDoubleFunction, FailableLongToIntFunction, FailableObjDoubleConsumer, FailableObjIntConsumer, FailableObjLongConsumer, FailableToBooleanFunction, FailableToDoubleBiFunction, FailableToDoubleFunction, FailableToIntBiFunction, FailableToIntFunction, FailableToLongBiFunction, FailableToLongFunction, ObjectFindUtil.Finder, DocConverterHelper.Creator, FaultBarrier.ThrowableSupplier, BixbyManagerContract.IBixby2Action {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9846a;

    public /* synthetic */ C13849N(int i) {
        this.f9846a = i;
    }

    @Override // org.apache.commons.lang3.function.FailableObjDoubleConsumer
    public void accept(Object obj, double d) {
        FailableObjDoubleConsumer.lambda$static$0(obj, d);
    }

    @Override // org.apache.commons.lang3.function.FailableToBooleanFunction
    public boolean applyAsBoolean(Object obj) {
        return FailableToBooleanFunction.lambda$static$0(obj);
    }

    @Override // org.apache.commons.lang3.function.FailableLongToDoubleFunction
    public double applyAsDouble(long j) {
        return FailableLongToDoubleFunction.lambda$static$0(j);
    }

    @Override // org.apache.commons.lang3.function.FailableLongToIntFunction
    public int applyAsInt(long j) {
        return FailableLongToIntFunction.lambda$static$0(j);
    }

    @Override // org.apache.commons.lang3.function.FailableToLongFunction
    public long applyAsLong(Object obj) {
        return FailableToLongFunction.lambda$static$0(obj);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.share.DocConverterHelper.Creator
    public DocConverterHelper create() {
        return DocConverterConfiguration.setup$lambda$0();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectFindUtil.Finder
    public boolean find(String str, SpenObjectBase spenObjectBase) {
        return DynamicTemplateObjectUtil.findObjectById$lambda$9(str, spenObjectBase);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f9846a) {
            case 14:
                return DeviceUtil.lambda$getOneUiVersion$3();
            case 15:
                return DeviceUtil.lambda$getModelCode$4();
            case 16:
                return DeviceUtil.lambda$getWatchDeviceName$11();
            case 17:
                return DeviceUtil.lambda$getOneUiVersionValue$2();
            case 18:
                return DeviceUtil.lambda$getCsc$10();
            default:
                return DeviceUtil.lambda$getIso3CountryCode$9();
        }
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerContract.IBixby2Action
    public IBixby2ActionBackgound registerBixby2Action() {
        return new Bixby2.Bixby2ActionBackground();
    }

    @Override // org.apache.commons.lang3.function.FailableObjIntConsumer
    public void accept(Object obj, int i) {
        FailableObjIntConsumer.lambda$static$0(obj, i);
    }

    @Override // org.apache.commons.lang3.function.FailableToDoubleFunction
    public double applyAsDouble(Object obj) {
        return FailableToDoubleFunction.lambda$static$0(obj);
    }

    @Override // org.apache.commons.lang3.function.FailableToIntFunction
    public int applyAsInt(Object obj) {
        return FailableToIntFunction.lambda$static$0(obj);
    }

    @Override // org.apache.commons.lang3.function.FailableToLongBiFunction
    public long applyAsLong(Object obj, Object obj2) {
        return FailableToLongBiFunction.lambda$static$0(obj, obj2);
    }

    @Override // org.apache.commons.lang3.function.FailableObjLongConsumer
    public void accept(Object obj, long j) {
        FailableObjLongConsumer.lambda$static$0(obj, j);
    }

    @Override // org.apache.commons.lang3.function.FailableToDoubleBiFunction
    public double applyAsDouble(Object obj, Object obj2) {
        return FailableToDoubleBiFunction.lambda$static$0(obj, obj2);
    }

    @Override // org.apache.commons.lang3.function.FailableToIntBiFunction
    public int applyAsInt(Object obj, Object obj2) {
        return FailableToIntBiFunction.lambda$static$0(obj, obj2);
    }
}
