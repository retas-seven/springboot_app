package com.mybootapp.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.mybootapp.entity.Account;

/**
 */
@Dao
@ConfigAutowireable
public interface AccountDao {

    /**
     * @param userId
     * @return the Account entity
     */
    @Select
    Account selectById(String userId);

    /**
     * @param userId
     * @param version
     * @return the Account entity
     */
    @Select(ensureResult = true)
    Account selectByIdAndVersion(String userId, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Account entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Account entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Account entity);
    
    @Select
    Account selectByEmail(String email);
}