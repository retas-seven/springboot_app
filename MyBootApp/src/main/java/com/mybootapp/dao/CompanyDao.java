package com.mybootapp.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.mybootapp.entity.Company;

/**
 */
@Dao
@ConfigAutowireable
public interface CompanyDao {

    /**
     * @param companyId
     * @return the Company entity
     */
    @Select
    Company selectById(Integer companyId);

    /**
     * @param companyId
     * @param version
     * @return the Company entity
     */
    @Select(ensureResult = true)
    Company selectByIdAndVersion(Integer companyId, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Company entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Company entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Company entity);
}