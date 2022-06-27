package com.mybootapp.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * RoleのEnumクラス
 */
public enum Role {

    /** 管理者 */
    ADMIN("1"),

    /** ユーザ */
    USER("2");

	/**
	 * コード値を保持するMap
	 */
	private static final Map<String, Role> CODE_MAP = initMap(ADMIN, USER);

	/**
	 * コード値
	 */
	private final String code;

    /**
     * コンストラクタ
     * @param code コード値
     */
	private Role(String code) {
		this.code = code;
	}

    /**
     * コード値を保持するMapを初期化する
     * @param elements RoleのEnum
     * @return コード値を保持するMap
     */
	private static Map<String, Role> initMap(Role... elements) {
		Map<String, Role> map = new HashMap<>();
		for (Role element : elements) {
			map.put(element.toString(), element);
		}
		return map;
	}

    /**
     * コード値を取得する
     * @return コード値
     */
    public String toString() {
        return code;
    }

    /**
     * コード値に該当するEnumを取得する
     * @param code コード値
     * @return 果物のEnum
     */
	public static Role toElement(String code) {
		return CODE_MAP.get(code);
	}

    /**
     * 管理者であるか判別する
     * @return 管理者の場合は{@code true}、それ以外は{@code false}
     */
    public boolean isAdmin() {
        return this == ADMIN;
    }

    /**
     * ユーザであるか判別する
     * @return ユーザの場合は{@code true}、それ以外は{@code false}
     */
    public boolean isUser() {
        return this == USER;
    }
    
    /**
     * 管理者であるか判別する
     * @return 管理者の場合は{@code true}、それ以外は{@code false}
     */
    public static boolean isAdmin(String code) {
        return toElement(code).isAdmin();
    }

    /**
     * ユーザであるか判別する
     * @return ユーザの場合は{@code true}、それ以外は{@code false}
     */
    public static boolean isUser(String code) {
        return toElement(code).isUser();
    }
}
