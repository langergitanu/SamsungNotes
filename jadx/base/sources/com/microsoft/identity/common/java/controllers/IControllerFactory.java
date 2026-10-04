package com.microsoft.identity.common.java.controllers;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, m13886d2 = {"Lcom/microsoft/identity/common/java/controllers/IControllerFactory;", "", "getAllControllers", "", "Lcom/microsoft/identity/common/java/controllers/BaseController;", "getDefaultController", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface IControllerFactory {
    @NotNull
    List<BaseController> getAllControllers();

    @NotNull
    BaseController getDefaultController();
}
