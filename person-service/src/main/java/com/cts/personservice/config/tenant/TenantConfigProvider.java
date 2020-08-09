package com.cts.personservice.config.tenant;

import java.util.List;

public interface TenantConfigProvider {

    List<TenantConfig> getAll();
    TenantConfig getDefault();
    TenantConfig get(String tenantId);
}
