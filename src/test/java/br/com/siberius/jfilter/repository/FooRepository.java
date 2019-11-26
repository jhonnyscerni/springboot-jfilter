package br.com.siberius.jfilter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.siberius.jfilter.jpa.JFilterRepository;
import br.com.siberius.jfilter.repository.domain.Foo;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long>, JFilterRepository<Foo> {

}
