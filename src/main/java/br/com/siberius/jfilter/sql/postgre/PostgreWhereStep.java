package br.com.siberius.jfilter.sql.postgre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.siberius.jfilter.sql.SqlPaginationStep;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.siberius.jfilter.core.EmptyFilterable;
import br.com.siberius.jfilter.core.Filterable;
import br.com.siberius.jfilter.sql.SqlOrderByStep;
import br.com.siberius.jfilter.sql.SqlWhereStep;

public class PostgreWhereStep implements SqlWhereStep {

	private JdbcTemplate jdbcTemplate;

	private Map<String, String> sqlFragments = new HashMap<>();

	public PostgreWhereStep(JdbcTemplate jdbcTemplate, Map<String, String> sqlFragments) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.sqlFragments = sqlFragments;
	}

	@Override
	public List<Map<String, Object>> fetchMaps() {
		return jdbcTemplate.queryForList(sqlFragments.get("sql"));
	}

	@Override
	public SqlPaginationStep orderBy(String sortSql) {
		if (StringUtils.isNotBlank(sortSql)) {
			sqlFragments.put("sql", String.format("%s order by %s ", sqlFragments.get("sql"), sortSql));
		}
		return new PostgrePaginationStep(jdbcTemplate, sqlFragments);
	}

	@Override
	public SqlPaginationStep orderBy(Sort sort) {
		if (Objects.nonNull(sort)) {
			// @formatter:off
			String orders = sort
					.stream()
					.map(it -> String.format("%s %s ", it.getProperty(), it.getDirection()))
					.collect(Collectors.joining(","));
			// @formatter:on
			return orderBy(orders);
		}
		return orderBy("");
	}

	@Override
	public SqlOrderByStep where(Filterable filter) {
		if ((filter instanceof EmptyFilterable) == false) {
			sqlFragments.put("whereSql", String.format("%s where %s ", sqlFragments.get("sql"), filter.toSql()));
			sqlFragments.put("sql", String.format("%s where %s ", sqlFragments.get("sql"), filter.toSql()));
		}
		return new PostgreOrderByStep(jdbcTemplate, sqlFragments);
	}

}
