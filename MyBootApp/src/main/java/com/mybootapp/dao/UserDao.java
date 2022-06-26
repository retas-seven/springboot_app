package com.mybootapp.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.mybootapp.entity.User;

/**
 */
@Dao
@ConfigAutowireable
public interface UserDao {

    /**
     * @param userId
     * @return the User entity
     */
    @Select
    User selectById(String userId);

    /**
     * @param userId
     * @param version
     * @return the User entity
     */
    @Select(ensureResult = true)
    User selectByIdAndVersion(String userId, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(User entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(User entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(User entity);
}