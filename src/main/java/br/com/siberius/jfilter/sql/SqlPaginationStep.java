package br.com.siberius.jfilter.sql;

import org.springframework.data.domain.Pageable;

public interface SqlPaginationStep extends SqlFetchStep {
	SqlPageableSelectStep limit(Pageable pageable);
}
