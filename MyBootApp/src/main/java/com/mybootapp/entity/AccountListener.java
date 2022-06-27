package com.mybootapp.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class AccountListener implements EntityListener<Account> {

    @Override
    public void preInsert(Account entity, PreInsertContext<Account> context) {
    }

    @Override
    public void preUpdate(Account entity, PreUpdateContext<Account> context) {
    }

    @Override
    public void preDelete(Account entity, PreDeleteContext<Account> context) {
    }

    @Override
    public void postInsert(Account entity, PostInsertContext<Account> context) {
    }

    @Override
    public void postUpdate(Account entity, PostUpdateContext<Account> context) {
    }

    @Override
    public void postDelete(Account entity, PostDeleteContext<Account> context) {
    }
}