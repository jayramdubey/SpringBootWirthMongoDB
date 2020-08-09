package com.cts.personservice.config.tenant;


import com.cts.personservice.config.ServletRequestContext;

import static com.cts.personservice.constant.Constants.RequestHeader.X_TENANT_ID;
import static java.util.Objects.isNull;

public class TenantIdProviderRequestHeader implements TenantIdProvider {

    private final TenantConfigProvider tenantConfigProvider;

    public TenantIdProviderRequestHeader(TenantConfigProvider tenantConfigProvider) {
        this.tenantConfigProvider = tenantConfigProvider;
    }

    @Override
    public String getId() {
        String tenantId = null;
        if (!isNull(ServletRequestContext.get(X_TENANT_ID))) {
            tenantId = (String) ServletRequestContext.get(X_TENANT_ID);
        } else {
            tenantId = tenantConfigProvider.getDefault().getId();
        }
        return tenantId;
    }
}
