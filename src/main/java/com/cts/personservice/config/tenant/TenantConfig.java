package com.cts.personservice.config.tenant;

import java.util.List;
import java.util.Map;

public class TenantConfig {

    private String id;
    private String name;
    private boolean defaultTenant;
    private Map<String, List<String>> validators;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefaultTenant() {
        return defaultTenant;
    }

    public void setDefaultTenant(boolean defaultTenant) {
        this.defaultTenant = defaultTenant;
    }

    public Map<String, List<String>> getValidators() {
        return validators;
    }

    public void setValidators(Map<String, List<String>> validators) {
        this.validators = validators;
    }
}
