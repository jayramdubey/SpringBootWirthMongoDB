package com.cts.personservice.config.tenant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component
@ConfigurationProperties
public class TenantConfigProviderImpl implements TenantConfigProvider {

    private List<TenantConfig> tenants;

    public void setTenants(List<TenantConfig> tenants) {
        this.tenants = tenants;
    }

    @PostConstruct
    public void postConstruct() {
        long count = 0;
        if (!isEmpty(tenants)) {
            count = tenants.stream()
                    .filter(TenantConfig::isDefaultTenant)
                    .count();
        }

        if (count != 1) {
            throw new IllegalArgumentException("There should be exactly one default tenant");
        }
    }

    @Override
    public List<TenantConfig> getAll() {
        return tenants;
    }

    @Override
    public TenantConfig getDefault() {
        return tenants.stream()
                .filter(tenant -> tenant.isDefaultTenant())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No configuration found for default-tenant"));
    }

    @Override
    public TenantConfig get(String tenantId) {
        return tenants.stream()
                .filter(tenant -> tenant.getId().equals(tenantId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No configuration found for tenantId=" + tenantId));
    }
}
