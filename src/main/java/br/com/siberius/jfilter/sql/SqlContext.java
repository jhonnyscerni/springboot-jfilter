package br.com.siberius.jfilter.sql;

import java.util.List;

import br.com.siberius.jfilter.core.Aggregation;
import br.com.siberius.jfilter.core.Payload;

public interface SqlContext {
	SqlWhereStep selectFrom(String sql);

	List<Aggregation> aggregation(String sql, Payload payload);

	void clear();
}
