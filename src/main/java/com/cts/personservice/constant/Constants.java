package com.cts.personservice.constant;

public final class Constants {
    private Constants() {
    }

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String APP_NAME = "/person-service";
    public static final String TOTAL_RESULTS = "Total results found for person search is={}";
    public static final String PERSON_NOT_FOUND_WITH_PERSON_ID = "Person not found with personId=";
    public static final String DELETING_PERSON_WITH_PERSON_ID= "Deleting person with personId={}";
    public static final String UPDATING_PERSON_WITH_PERSON_ID = "Updating person with personId={}, version={}";
    public static final String  GETTING_PERSON_WITH_PERSON_ID= "Getting person with personId={}";
    public static final String TOTAL_NUMBER_OF_PERSON_FOUND = "Total number of person found={}";
    public static final String PERSON_DELETE_IS_SUCCESSFUL =  "Person delete is successful, personId={}";
    public static final String PERSON_UPDATE_IS_SUCCESSFUL =  "Person update is successful, personId={}";
    public static final String PERSON_GET_IS_SUCCESSFUL = "Person get is successful, personId={}";
    public static final String PERSON_CREATED_SUCCESSFULLY="Person created successfully, personId={}";
    public static final String NO_QUERY_PARAMETER_FOUND="No query parameter found,returning empty result for person search";
    public static final String EMAIL_CREATED_SUCCESSFULLY="Email created successfully, emailId={}";
    // Request Header related Constants
    public static final class RequestHeader {
        private RequestHeader() {
        }

        public static final String X_TENANT_ID = "X-Tenant-Id";

    }
    // Hystrix related Constants
    public static final class Hystrix {
        private Hystrix() {
        }

        public static final String X_TENANT_ID = "X-Tenant-Id";

    }

    // Collection related Constants
    public static final class Collections {
        private Collections() {
        }

        public static final String PERSON_COLLECTION = "persons";

    }
}
