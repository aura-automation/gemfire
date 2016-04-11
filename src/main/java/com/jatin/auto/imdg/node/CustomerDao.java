
package com.jatin.auto.imdg.node;

import com.jatin.auto.imdg.domain.Customer;

public interface CustomerDao {

	/**
	 * Get a Customer by ID
	 * @param id
	 * @return
	 */
	 public abstract Customer get(long id);

}