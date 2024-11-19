package com.lutero.dscommecer.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String fone;
	private LocalDate bithDate;
	private String password;
	
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	
	public User() {
		
	}


	public User(Long id, String name, String email, String fone, LocalDate bithDate, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.fone = fone;
		this.bithDate = bithDate;
		this.password = password;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFone() {
		return fone;
	}


	public void setFone(String fone) {
		this.fone = fone;
	}


	public LocalDate getBithDate() {
		return bithDate;
	}


	public void setBithDate(LocalDate bithDate) {
		this.bithDate = bithDate;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
}
