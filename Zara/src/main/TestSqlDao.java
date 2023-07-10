package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Mejorar cada uno de los métodos a nivel SQL y código cuando sea necesario
 * Razonar cada una de las mejoras que se han implementado
 * No es necesario que el código implementado funcione 
 */
public class TestSqlDao {
	
	private TestSqlDao() {
	}

	/**
	 * Obtiene el ID del último pedido para cada usuario
	 */
	public HashMap<Long, Long> getMaxUserOrderId(long idTienda) throws Exception {
	    String query = "SELECT ID_PEDIDO, ID_USUARIO FROM PEDIDOS WHERE ID_TIENDA = ?";
	    Connection connection = getConnection();
	    PreparedStatement stmt = connection.prepareStatement(query);
	    stmt.setLong(1, idTienda);
	    ResultSet rs = stmt.executeQuery();
	    HashMap<Long, Long> maxOrderUser = new HashMap<Long, Long>(100);

	    while (rs.next()) {
	        long idPedido = rs.getLong("ID_PEDIDO");
	        long idUsuario = rs.getLong("ID_USUARIO");
	        maxOrderUser.compute(idUsuario, (key, value) -> value == null || value < idPedido ? idPedido : value);
	    }

	    return maxOrderUser;
	}


	/**
	 * Copia todos los pedidos de un usuario a otro
	 */
	public void copyUserOrders(long idUserOri, long idUserDes) throws Exception {
	    String query = "SELECT FECHA, TOTAL, SUBTOTAL, DIRECCION FROM PEDIDOS WHERE ID_USUARIO = ?";
	    Connection connection = getConnection();
	    PreparedStatement stmt = connection.prepareStatement(query);
	    stmt.setLong(1, idUserOri);
	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
	        String insert = "INSERT INTO PEDIDOS (FECHA, TOTAL, SUBTOTAL, DIRECCION) VALUES (?, ?, ?, ?)";
	        Connection connection2 = getConnection();
	        connection2.setAutoCommit(false);
	        PreparedStatement stmt2 = connection2.prepareStatement(insert);
	        stmt2.setTimestamp(1, rs.getTimestamp("FECHA"));
	        stmt2.setDouble(2, rs.getDouble("TOTAL"));
	        stmt2.setDouble(3, rs.getDouble("SUBTOTAL"));
	        stmt2.setString(4, rs.getString("DIRECCION"));
	        stmt2.executeUpdate();
	        connection2.commit();
	    }
	}

	/**
	 * Obtiene los datos del usuario y pedido con el pedido de mayor importe para la tienda dada
	 */
	public UserMaxOrderData getUserMaxOrder(long idTienda) throws Exception {
	    String query = "SELECT U.ID_USUARIO, P.ID_PEDIDO, P.TOTAL, U.NOMBRE, U.DIRECCION FROM PEDIDOS AS P "
	                        + "INNER JOIN USUARIOS AS U ON P.ID_USUARIO = U.ID_USUARIO WHERE P.ID_TIENDA = ? "
	                        + "ORDER BY P.TOTAL DESC LIMIT 1";
	    Connection connection = getConnection();
	    PreparedStatement stmt = connection.prepareStatement(query);
	    stmt.setLong(1, idTienda);
	    ResultSet rs = stmt.executeQuery();

	    if (rs.next()) {
	        long userId = rs.getLong("ID_USUARIO");
	        long orderId = rs.getLong("ID_PEDIDO");
	        String name = rs.getString("NOMBRE");
	        String address = rs.getString("DIRECCION");
	        double total = rs.getDouble("TOTAL");
	        return new UserMaxOrderData(userId, orderId, name, address, total);
	    }

	    // Si no se encontró ningún resultado, puedes lanzar una excepción o devolver un valor predeterminado
	    throw new Exception("No se encontró ningún pedido para la tienda especificada");
	}

	
	private Connection getConnection() throws SQLException {
	    String url = "jdbc:mysql://localhost:3306/nombre_basedatos";
	    String username = "usuario";
	    String password = "contraseña";
	    
	    Connection connection = DriverManager.getConnection(url, username, password);
	    return connection;
	}

}

