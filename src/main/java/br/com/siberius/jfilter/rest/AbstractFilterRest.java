package br.com.siberius.jfilter.rest;

import javax.annotation.PostConstruct;

import br.com.siberius.jfilter.core.Page;
import br.com.siberius.jfilter.core.Payload;
import br.com.siberius.jfilter.core.Projectable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.siberius.jfilter.jpa.AbstractSpecification;
import br.com.siberius.jfilter.jpa.JFilterRepository;
import lombok.Getter;

/**
 * Classe abstrata com método padrão para filtragem de dados.
 *
 *
 * @param <T> Entidade JPA.
 * @param <ID> Tipo do atributo identificador.
 * @param <S> Classe de specification.
 * @param <R> Classe de repository.
 */
public abstract class AbstractFilterRest<T, ID, S extends AbstractSpecification<T>, R extends JpaRepository<T, ID> & JFilterRepository<T>> {

	private Class<T> entityClass;

	private Class<S> specificationClass;

	@Getter
	private R repository;

	@Autowired
	private ApplicationContext appContext;

	@SuppressWarnings("unchecked")
	public AbstractFilterRest() {
		super();
		this.entityClass = (Class<T>) ResolvableType.forClass(this.getClass()).getSuperType().getGeneric(0).getRawClass();
		this.specificationClass = (Class<S>) ResolvableType.forClass(this.getClass()).getSuperType().getGeneric(2).getRawClass();
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	private void init() {
		this.repository = (R) appContext.getBean(ResolvableType.forClass(this.getClass()).getSuperType().getGeneric(3).getRawClass());
	}

	/**
	 * Endpoint padrão para filtragem de dados.
	 * 
	 * @param payload
	 * @param pageable
	 * @param projectable
	 * @return
	 */
	@PostMapping("/filter")
	public final ResponseEntity<Page<T>> filter(@RequestBody(required = false) Payload payload, Pageable pageable, Projectable projectable) {
		return ResponseEntity.ok(repository.findAll(entityClass, pageable, projectable, specificationClass, payload));
	}
}
