package br.com.siberius.jfilter.core;

import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.siberius.jfilter.jpa.AttributePath;

public class EmptyFilterable extends Filterable {

	@Override
	public <T> Predicate toPredicate(Class<T> clazz, Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb, Map<String, AttributePath> paths) {
		return null;
	}

}
