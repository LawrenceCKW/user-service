package com.yuexin.user_service.constants;

public class SqlQuery {
    private SqlQuery() {}

    public final static String FIND_USERS_QUERY =
            "SELECT new com.yuexin.user_service.dto.UserDTO(" +
                    "u.userId, u.userName, u.email, u.accountNonLocked, " +
                    "u.accountNonExpired, u.credentialsNonExpired, u.enabled," +
                    "u.credentialsExpiryDate, u.accountExpiryDate, u.twoFactorSecret," +
                    "u.isTwoFactorAuthEnabled, u.signUpMethod, u.role, u.createdDate, u.updatedDate) " +
                    "FROM User u";

    public final static String FIND_USER_QUERY =
            "SELECT new com.yuexin.user_service.dto.UserDTO(" +
                    "u.userId, u.userName, u.email, u.accountNonLocked, " +
                    "u.accountNonExpired, u.credentialsNonExpired, u.enabled," +
                    "u.credentialsExpiryDate, u.accountExpiryDate, u.twoFactorSecret," +
                    "u.isTwoFactorAuthEnabled, u.signUpMethod, u.role, u.createdDate, u.updatedDate) " +
                    "FROM User u WHERE u.userId = :userId";

}
