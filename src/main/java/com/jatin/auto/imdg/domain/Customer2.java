/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jatin.auto.imdg.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.util.Assert;


/**
 * A customer.
 * 
 * @author Oliver Gierke
 * @author David Turanski
 */
 
@Region
public class Customer2 extends AbstractPersistentEntity {
	
 
	private static final long serialVersionUID = -3860687524824507134L;
	
	private EmailAddress emailAddress;
	private String firstname, lastname;
	private Set<Address> addresses = new HashSet<Address>();

	/**
	 * Creates a new {@link Customer2} from the given parameters.
	 * @param id the unique id;
	 * @param emailAddress must not be {@literal null} or empty.
	 * @param firstname must not be {@literal null} or empty.
	 * @param lastname must not be {@literal null} or empty.
	 */
	public Customer2(Long id, EmailAddress emailAddress, String firstname, String lastname) {
		super(id);
		Assert.hasText(firstname);
		Assert.hasText(lastname);
		Assert.notNull(emailAddress);

		this.firstname = firstname;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
	}

	protected Customer2() {	
	}

	/**
	 * Adds the given {@link Address} to the {@link Customer2}.
	 * 
	 * @param address must not be {@literal null}.
	 */
	public void add(Address address) {

		Assert.notNull(address);
		this.addresses.add(address);
	}

	/**
	 * Returns the firstname of the {@link Customer2}.
	 * 
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Sets the firstname of the {@link Customer2}.
	 * 
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Returns the lastname of the {@link Customer2}.
	 * 
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname of the {@link Customer2}.
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Returns the {@link EmailAddress} of the {@link Customer2}.
	 * 
	 * @return
	 */
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}
	
	/**
	 * Sets the emailAddress of the {@link Customer2}.
	 * 
	 * @param emailAddress
	 */
	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Return the {@link Customer2}'s addresses.
	 * 
	 * @return
	 */
	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(addresses);
	}
}
