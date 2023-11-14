package com.example.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Cliente;

@Repository
public class ClienteRepositoryDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	String findAll = "SELECT * FROM CLIENTE";
	String findById = "SELECT * FROM CLIENTE WHERE ID = ?";
	String insertCliente = "INSERT INTO CLIENTE (USERNAME, EMAIL, PASSWORD) VALUES(:user, :email, :password)";
			 
	
	public class ClienteRowMapper implements RowMapper<Cliente>{
		@Override
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cliente cliente = new Cliente();
			cliente.setId(rs.getInt("ID"));
			cliente.setUsername(rs.getString("USERNAME"));
			cliente.setEmail(rs.getString("EMAIL"));
			cliente.setPassword(rs.getString("PASSWORD"));
			return cliente;
		}
		
	}
	
	public List<Cliente> findAll() {
		return jdbcTemplate.query(findAll, new ClienteRowMapper());
	}
	
	public Cliente findbById(Integer id) {
		return jdbcTemplate.queryForObject(findById, new ClienteRowMapper(), new Object[]{id});
	}
	
	public int insert(Cliente cliente) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", cliente.getUsername());
		params.put("email", cliente.getEmail());
		params.put("password", cliente.getPassword());
		
		/*return jdbcTemplate.update(insertCliente, cliente.getUsername(), cliente.getEmail(), cliente.getPassword()); */
		
		return namedParameterJdbcTemplate.update(insertCliente, params);
	}

}
