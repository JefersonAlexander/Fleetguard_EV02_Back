package com.microservice.fleetLocation.listener;

import com.microservice.fleetLocation.entity.UserAuditEntity;
import org.hibernate.envers.RevisionListener;


public class UserRevisionListener implements RevisionListener{
     @Override
    public void newRevision(Object revisionEntity) {
        UserAuditEntity userAuditEntity = (UserAuditEntity) revisionEntity;
        String username = getCurrentUsername();
        userAuditEntity.setUsername(username);
    }

    private String getCurrentUsername() {
        
        return "system";
        
    }
}
