package com.mybootapp.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 */
@Dao
@ConfigAutowireable
public interface SequenceDao {

    @Select
    String selectNextUserId();
    
    @Select
    String selectNextCompanyId();
}