package conversor;

import javax.persistence.AttributeConverter;

import modelo.Genero;

public class ConversorGenero implements AttributeConverter<Genero, String>{

	@Override
	public String convertToDatabaseColumn(Genero genero) {
		return genero.getCodigo();
	}

	@Override
	public Genero convertToEntityAttribute(String genero) {
		return Genero.getEnumerado(genero);
	}
	
	

}
