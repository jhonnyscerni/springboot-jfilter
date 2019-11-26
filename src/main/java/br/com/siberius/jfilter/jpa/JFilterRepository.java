package br.com.siberius.jfilter.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.siberius.jfilter.core.Aggregable;
import br.com.siberius.jfilter.core.Aggregation;
import br.com.siberius.jfilter.core.Page;
import br.com.siberius.jfilter.core.Payload;
import br.com.siberius.jfilter.core.Projectable;

/**
 * Interface de Repository com as funcionalidades de projeção, filtragem e agregação.
 *
 *
 * @param <T>
 */
public interface JFilterRepository<T> {

	Page<T> findAll(Class<T> entityClass, Pageable pageable, Projectable projectable, Class<? extends AbstractSpecification<T>> specificationClass, Payload payload);

	List<Aggregation> aggregation(Class<T> entityClass, Specification<T> specification, Aggregable... aggregables);
}
