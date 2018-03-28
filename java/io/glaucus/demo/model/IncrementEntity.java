package io.glaucus.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Data entity class modeled according to table.
 * Contains an ID and the counter value.
 * 
 * @author Arjun M.C.
 * @version 1.0
 * @since 2018-03-25
 */
@Entity
@Table(name = "Number")
public class IncrementEntity {

	/**
     * Unique ID used as key
     */
	@Id
	@Column(name = "id")
	private Integer id;
	
	/**
     * Value of the counter that will be incremented
     */
	@Column(name = "value")
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public IncrementEntity() {}
	
	public IncrementEntity(Integer value) {
		super();
		this.value = value;
	}

}
