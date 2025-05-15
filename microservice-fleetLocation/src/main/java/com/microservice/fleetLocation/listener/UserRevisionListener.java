package com.microservice.fleetLocation.listener;

import com.microservice.fleetLocation.entity.UserRevisionEntity;
import org.hibernate.envers.RevisionListener;


public class UserRevisionListener implements RevisionListener{
     @Override
    public void newRevision(Object revisionEntity) {
        UserRevisionEntity customRev = (UserRevisionEntity) revisionEntity;
        String username = getCurrentUsername();
        customRev.setUsername(username);
    }

    private String getCurrentUsername() {
        
        return "system";
        
    }
}
