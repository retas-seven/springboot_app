package com.mybootapp.dao;

import java.sql.Timestamp;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 */
@Dao
@ConfigAutowireable
public interface CommonDao {

	/**
	 * 現在のトランザクションの開始日時を取得する。<br>
	 * 同じトランザクションでこれらの関数を複数回実行しても、日時が変化しない。<br>
	 * この動作はPostgresqlの仕様で、トランザクション全体で一貫した日時を取得できる。
	 * @return 現在のトランザクションの開始日時（システム日付として使用する）
	 */
    @Select
    Timestamp selectCurrentTimestamp();
}