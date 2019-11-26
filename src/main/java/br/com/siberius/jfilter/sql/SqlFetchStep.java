package br.com.siberius.jfilter.sql;

import java.util.List;
import java.util.Map;

public interface SqlFetchStep {
	List<Map<String, Object>> fetchMaps();
}
