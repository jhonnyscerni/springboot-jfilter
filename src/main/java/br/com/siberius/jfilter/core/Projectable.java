package br.com.siberius.jfilter.core;

import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe com os dados da projeção.
 *
 *
 */
@Getter
@Setter
public class Projectable {
	/**
	 * Lista de atributos da projeção.
	 */
	List<String> fields;

	public static boolean hasProjection(Projectable projectable) {
		return Objects.nonNull(projectable) && Objects.nonNull(projectable.getFields());
	}
}
