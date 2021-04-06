package com.mayank.cruduser.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.redis.core.RedisHash;

@Entity
//@Table(name= "users")
@RedisHash("User")
@Document(indexName="crud_user",type="Users",shards=2)
public class User implements Serializable {
	
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		private String  id;
		
		@Column(name="firstName")
		private String firstName;
		
		@Column(name="lastName")
		private String lastName;
		

		@Column(name="email")
		private String email;
		
		@Column(name="occupation")
		private String occupation;
		
		@Column(name="state")
		private String state;
		public User()
		{}
		
		public User(String firstName, String lastName, String email, String occupation, String state) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.occupation = occupation;
			this.state = state;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		
}
