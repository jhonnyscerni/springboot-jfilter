package br.com.siberius.jfilter.sql;

import br.com.siberius.jfilter.core.Filterable;

public interface SqlWhereStep extends SqlFetchStep, SqlOrderByStep {
	SqlOrderByStep where(Filterable filter);
}
