package dao;

import model.Role;
import java.sql.Connection;

public class RoleDao extends BasicDao<Role>{
    public RoleDao(Connection conn) {
        super(conn);
    }
}
