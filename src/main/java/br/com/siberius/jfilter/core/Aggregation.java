package br.com.siberius.jfilter.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Aggregation {

	private String dataField;

	private Object result;

	private Aggregable.Operation operation;

	public Aggregation(String dataField, Object result, Aggregable.Operation operation) {
		super();
		this.dataField = dataField;
		this.result = result;
		this.operation = operation;
	}

}
