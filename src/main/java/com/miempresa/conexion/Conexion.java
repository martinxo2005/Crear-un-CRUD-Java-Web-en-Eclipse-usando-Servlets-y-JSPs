package com.miempresa.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static BasicDataSource dataSource = null;

    private static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            // Driver de MySQL que soporta MariaDB
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("root"); // Ajusta si tu usuario en MariaDB es distinto
            dataSource.setPassword("root"); // Pon la contraseña que usas al entrar por consola en MariaDB
            
            // URL configurada para evitar fallos de plugins de autenticación
            dataSource.setUrl("jdbc:mysql://localhost:3306/crud?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
            
            dataSource.setInitialSize(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxTotal(20);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}